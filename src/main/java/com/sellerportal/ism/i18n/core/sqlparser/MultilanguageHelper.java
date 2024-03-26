package com.sellerportal.ism.i18n.core.sqlparser;

import java.io.StringReader;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.atomic.AtomicLong;

import javax.servlet.http.HttpServletRequest;

import net.sf.jsqlparser.expression.Expression;
import net.sf.jsqlparser.expression.ExpressionVisitor;
import net.sf.jsqlparser.expression.JdbcParameter;
import net.sf.jsqlparser.expression.LongValue;
import net.sf.jsqlparser.expression.operators.conditional.AndExpression;
import net.sf.jsqlparser.expression.operators.relational.EqualsTo;
import net.sf.jsqlparser.expression.operators.relational.ExpressionList;
import net.sf.jsqlparser.parser.CCJSqlParserManager;
import net.sf.jsqlparser.schema.Column;
import net.sf.jsqlparser.schema.Table;
import net.sf.jsqlparser.statement.Statement;
import net.sf.jsqlparser.statement.insert.Insert;
import net.sf.jsqlparser.statement.select.Select;
import net.sf.jsqlparser.statement.update.Update;
import net.sf.jsqlparser.util.deparser.ExpressionDeParser;
import net.sf.jsqlparser.util.deparser.SelectDeParser;

import org.apache.commons.collections.bidimap.TreeBidiMap;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.EmptyInterceptor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.jdbc.Work;

import com.anm.hibernate.HibernateConnection;
import com.sellerportal.ism.i18n.I18nHelper;
import com.sellerportal.ism.i18n.I18nHibernateHelper;
import com.sellerportal.ism.i18n.OrganizationConstants;
import com.sellerportal.ism.i18n.core.hibernate.EntityDataHolder;

/**
 * Helper contains the helper method to simplimy the SQL manipulation to enable
 * the multilanguage support
 * 
 * Given a SQL and definition of TableMeta - We need to transform the SQL so
 * that all the multilanguage fields (defined in TableMetaData.properties) get
 * replaced with corresponding table
 * 
 * For example table T1 we have defined the col1,col2 as a multilingual
 * TableMetaData.properties T1.pk=tkid T1.lang=col1,col2 End user API would not
 * be affected and should not continue to work without any code modification and
 * without any performance issues
 * 
 * <1> For Each table T which would support multiple language - Create table
 * T_child Primary Key : pk of T, lang (int), orgId (int) - Intercept SQLs fired
 * on database and do a left outer join for each T such that left outer join
 * T_child c1 on c1.pk1 = p.pk1 AND c1.pk2=p.pk2 ...AND c1.lang=1 AND c2.orgId=1
 * Replace all the select columns with corresponding values from the child
 * language table
 * 
 * 
 * @author Chandra Singh Meena
 * 
 */
public class MultilanguageHelper implements OrganizationConstants {

	public static final Log LOGGER = LogFactory.getLog(MultilanguageHelper.class);

	public static final String LANG_TABLE_SUFFIX = "CHILD";

	public static final String LANG_TABLE_ALIAS_SUFFIX = "l";

	public static final String COLUMN_ORG_ID = "orgId";

	public static final String COLUMN_LANG_ID = "lang";
	
	private static ThreadLocal requestThreadLocal = new ThreadLocal();

	  @SuppressWarnings("unchecked")
	public static void setServletRequest(HttpServletRequest request) {
		  requestThreadLocal.set(request);
	  }

	  public static HttpServletRequest getServletRequest() {
	    return (HttpServletRequest) requestThreadLocal.get();
	  }

	/**
	 * Initialized all table configuration using the
	 * <code>CONFIG_FILE_NAME</code>
	 */
	protected static List<TableMetaDataDTO> configuration = null;

	/**
	 * Table containing the configuration
	 */
	protected static String CONFIG_FILE_NAME = "table_metadata.properties";

	private static int MAX_SIZE = 5000;

	private static Map<String, String> sqlCacheMap = Collections.synchronizedMap(new HashMap<String, String>());

	private static AtomicLong hitCount = new AtomicLong(0);

	private static AtomicLong putCount = new AtomicLong(0);

	private static AtomicLong missCount = new AtomicLong(0);

	private static AtomicLong purgeCount = new AtomicLong(0);

	public void setMaxSQLCacheSize(int size) {
		MAX_SIZE = size;
	}

	/**
	 * NOTE: Databse Specific : ifnull is picked up from MySQL, We need to port
	 * it to different database
	 * 
	 * Translate the input SQL so transformed SQL can directly give the results
	 * in given language <code>langId</code>  
	 <pre>
	 * 	 Concept: For a given table &lt;i&gt;T&lt;/i&gt; if the column(s) &lt;i&gt;C1, C2&lt;/i&gt; are multilingual then a hidden table &lt;b&gt;T1_lang&lt;/b&gt; with fields &lt;i&gt;C1,C2&lt;/i&gt; and PK(T1pk1,T1pk2,..,TkPkn,langId,orgId)
	 * 	 should  be created at the System installation time. &lt;b&gt;NOTE: An API would be provided to generate a DDL for all tables with assumption is that only String type files are multilingual &lt;/b&gt;
	 * 	 
	 * 	 At runtime every query will be intercepted and translated such that an outerjoin will be performed with the language table and corresponding
	 * 	 select columns would be replaced with language table. Care will be taken that if language row does not exist then parent column will be used.
	 * 	 
	 * 	 For Example,
	 * 	 == Input ===
	 * 
	 * 	 SELECT 
	 * 	 t2.description as t2desc,t1.description as t1desc 
	 * 	 FROM 
	 * 	 T1 t1 
	 * 	 left outer join T2 t2 on t2.id=t1.id
	 * 	 WHERE 
	 * 	 t1.id=1;
	 * 
	 * 	 == Configuration ===
	 * 	 table_configuration.properties
	 * 	 T1=id:description
	 * 	 T2=id:description
	 * 	 == Left Outer Join For T1
	 * 	 left outer join T1_child t1_child on t1.id=t1_child.id and t1_child.lang=1  
	 * 	 == Left Outer Join for T2
	 * 	 left outer join T2_child t2_child on t2.id=t2_child.id and t2_child.lang=1  
	 * 
	 * 	 ==== Output  ===
	 * 	 SELECT 
	 * 	 ifnull(t2_child.description,t2.description) as t2desc,ifnull(t1_child.description,t1.description) as t1desc
	 * 	 FROM 
	 * 	 T1 t1
	 * 	 left outer join T2 t2 on t2.id=t1.id
	 * 	 left outer join T1_child t1_child on t1.id=t1_child.id and t1_child.lang=1 
	 * 	 left outer join T2_child t2_child on t2.id=t2_child.id and t2_child.lang=1 
	 * 	 WHERE 
	 * 	 t1.id=1 
	 * 	 and t1.orgId=1
	 * 	 and t2.orgId=1;
	 * 	 and t1_child.orgId=1
	 * 	 and t2_child.orgId=1
	 * 	 
	 * 	
	 * </pre>
	 * 
	 * @param sql
	 *            String inputSQL
	 * @param orgId
	 *            int Organization id
	 * @param langCode
	 *            int Language ID
	 * @return
	 * @throws Throwable
	 */
	
	
	public static String prepareSQL(String[] sqls){
		for(int i=1;i<sqls.length;i++){
			String tmpStr = sqls[i].substring(0, sqls[i].indexOf("WHERE"));
			String tstr = sqls[i].substring(sqls[i].indexOf("WHERE"));
			tmpStr = tmpStr.replaceAll("AS", "");
			sqls[i] = tmpStr+" "+tstr;
		}
		
		String sql = "";
		for(int i=0;i<sqls.length;i++){
			if(i==0)
				sql = sqls[i];
			else{
				sql += " FROM " + sqls[i];
			}
		}
		
		return sql;
	}

	

	public static List<TableMetaDataDTO> getMetaDataConfigurationList(
			boolean force) {
		synchronized (MultilanguageHelper.class) {
			if (configuration != null)
				return configuration;
			else {
				configuration = initialize();
				return configuration;
			}
		}
	}

	/**
	 * 
	 * Initialize the configuration based on the table_configuration.properties
	 * 
	 */
	private static List<TableMetaDataDTO> initialize() {
		List<TableMetaDataDTO> retValue = new ArrayList<TableMetaDataDTO>();
		try {

			Properties properties = I18nHelper.loadResource(CONFIG_FILE_NAME);

			// parse the configuration file
			Set<Entry<Object, Object>> keyValueSet = properties.entrySet();
			for (Iterator iter = keyValueSet.iterator(); iter.hasNext();) {
				Entry<String, String> aKeyValue = (Entry<String, String>) iter
						.next();
				String key = aKeyValue.getKey();
				String value = aKeyValue.getValue();
				if (key == null || value == null)
					continue;
				key = key.trim();
				value = value.trim();

				if (key.startsWith("#"))
					continue;

				try {
					TableMetaDataDTO configDTO = parseTableConfig(key, value);
					if (configDTO != null && configDTO.getTableName() != null
							&& configDTO.getTableName().trim().length() > 0)
						retValue.add(configDTO);
				} catch (Exception e) {
					if (LOGGER.isDebugEnabled()) {
						LOGGER.debug("INVALID ENTRY ::" + key + "=" + value);
					}
				}

			}

		} catch (Exception e) {
			if (LOGGER.isDebugEnabled()) {
				LOGGER.debug("EXCEPTION ::::\n" + e + "\n");
			}
		}

		return retValue;
	}

	/**
	 * Parse the table configuration file with format
	 * 
	 * <pre>
	 * 	 TableName=PK1,PK2,...,PKN:COL1,COL2,....,COLN
	 * 	 IF PK is not defined then file will not be processed
	 * 	
	 * </pre>
	 * 
	 * @param key
	 * @param value
	 * @return
	 * @throws Exception
	 */
	static TableMetaDataDTO parseTableConfig(String key, String value)
			throws Exception {
		TableMetaDataDTO configDTO = new TableMetaDataDTO();
		configDTO.setPk(new String[0]);
		configDTO.setColumns(new String[0]);
		configDTO.setMultipleLanguage(false);
		int _i = value.indexOf(":");
		String pkString = value;
		if (_i >= 0)
			pkString = value.substring(0, _i);

		if (pkString != null && pkString.trim().length() > 0) {

			String[] pks = new String[0];
			pks = pkString.split(",");
			configDTO.setPk(pks);

			if (value.length() >= (_i + 1)) {
				String langColumns = value.substring(_i + 1);
				String[] cols = langColumns.split(",");
				boolean f = (cols != null && cols.length > 0 && cols[0].trim()
						.length() > 0);
				configDTO.setTableName(key.toLowerCase());
				if (f) {
					configDTO.setColumns(cols);
					configDTO.setMultipleLanguage(f);
				}
			}
		} else {
			if (pkString == null || pkString.trim().length() == 0) {
				System.err.println("! PK NOT DEFINED TABLE = [" + key + "] "
						+ value + "]");
			}
		}

		return configDTO;
	}

	public static TableMetaDataDTO getTableMetaData(String tableName) {
		return getTableMetaData(getMetaDataConfigurationList(true), tableName);
	}

	public static TableMetaDataDTO getTableMetaData(
			List<TableMetaDataDTO> list, String tableName) {
		for (int i = 0; i < list.size(); i++)
			if (list.get(i).getTableName().equalsIgnoreCase(tableName))
				return list.get(i);
		return null;
	}

	/**
	 * Execute a SQL in the new connection. Possible problems
	 * 
	 * 
	 * @param sql
	 * @throws SQLException
	 */
	public static void executeSQL(String sql) throws SQLException {
		Session session = null;
		Connection connection = null;
		java.sql.Statement statement = null;
		try {
			session = HibernateConnection.getSessionFactory().openSession();
			session.doWork(new Work() {
				@Override
				public void execute(Connection connection) throws SQLException {
					java.sql.Statement	statement = connection.createStatement();
					
				}
			});
			statement.execute(sql);
			if(LOGGER.isDebugEnabled())
				LOGGER.debug(sql);
			
			//session.close();

		} catch (SQLException e) {
			
		} finally {
			if (statement != null) {
				try {
					statement.close();
				} catch (Exception e) {
					LOGGER.error("Message :: "+e.toString() +" Cause :: "+e.getCause());
				}
			}
			if(session != null)
				try {session.close();}catch(Exception e) {}
		}
	}

	/** Set of String 2-digit codes that indicate bad SQL */
	private static final Set BAD_SQL_CODES = new HashSet(4);

	/** Set of String 2-digit codes that indicate RDBMS integrity violation */
	private static final Set INTEGRITY_VIOLATION_CODES = new HashSet(4);

	// Populate reference data.
	static {
		BAD_SQL_CODES.add("07");
		BAD_SQL_CODES.add("42");
		BAD_SQL_CODES.add("65"); // Oracle throws on unknown identifier
		BAD_SQL_CODES.add("S0"); // MySQL uses this - from ODBC error codes?

		INTEGRITY_VIOLATION_CODES.add("22"); // Integrity constraint
		// violation
		INTEGRITY_VIOLATION_CODES.add("23"); // Integrity constraint
		// violation
		INTEGRITY_VIOLATION_CODES.add("27"); // Triggered data change
		// violation
		INTEGRITY_VIOLATION_CODES.add("44"); // With check violation
	}

	/**
	 * Generate insert into for a given language table
	 * 
	 * @param tableName
	 * @param pkColumnNames
	 * @param pkValues
	 * @param columnNames
	 * @param columnValues
	 * @param langColumnName
	 * @param langId
	 * @param orgId
	 * @return
	 */
	public static String generateInsertSQL(String tableName,
			String[] pkColumnNames, String[] pkValues, String[] columnNames,
			String[] columnValues, String orgId) {
		return I18nHibernateHelper.generateInsertSQL(tableName, pkColumnNames, pkValues,
				columnNames, columnValues, "orgId", orgId);
	}

	public static void processParentChildUpdate(SessionFactory sf,
			EntityDataHolder updateData, String langColumnName,
			String langCode, String orgId) {

		String childInsertUpdateSQL = I18nHibernateHelper.insertUpdateLanguageRecord(sf, updateData
				.getEntity(), langColumnName, langCode, orgId);
		if (childInsertUpdateSQL != null && childInsertUpdateSQL.length() > 0) {
			try {
				executeSQL(childInsertUpdateSQL);
			} catch (Exception e) {
				LOGGER.error("processParentChildUpdate::: EXCEPTION <<"+e.getMessage()+">> Ignored <<"+childInsertUpdateSQL+">>");
				// LOGGER.info("Message :: "+e.toString() +" Cause :: "+e.getCause());
			}
			
			String sql = null;
			try {
				sql = I18nHibernateHelper.createUpdateSQLForMaster(sf, updateData,langColumnName, langCode, orgId);
				
				if (sql != null && sql.length() > 0) 
				{
					if(LOGGER.isDebugEnabled())
						LOGGER.debug(sql);
					executeSQL(sql);	
				}
			} catch (Exception e) {
				LOGGER.error("processParentChildUpdate::update to rollback in Master:: EXCEPTION <<"+e.getMessage()+">> Ignored <<"+sql+">>");
				//LOGGER.info("Message :: "+e.toString() +" Cause :: "+e.getCause());
			}
		}

		

	}

	public static int indexOf(String[] ar, String key) {
		if (ar != null && key != null) {
			for (int i = 0; i < ar.length; i++) {
				if (ar[i] != null && ar[i].equalsIgnoreCase(key))
					return i;
			}
		}
		return -1;
	}

	/**
	 * - Might be a system property - Might be a session - web - Might be a
	 * current request - web - Might be a coookie - web - Might be a database
	 * table
	 * 
	 * @return
	 */
	public static String getOrganizationId() {
		HttpServletRequest request = MultilanguageHelper.getServletRequest();
		String orgId = I18nHelper.getOrganizationId(request);
		return orgId;
	}
	
	
	/**
	 * 
	 */
	public static String getLanguage() {
		HttpServletRequest request = MultilanguageHelper.getServletRequest();
		return I18nHelper.getLanguageCode(request);
	}
	
	/**
	 * This method is only for framework use only. If opened session this way, called should close it in finally otherwise
	 * there could be a connection leak problem
	 * @return
	 */
	public static Session openPlainSession()
	{
		Session session = HibernateConnection.getSessionFactory().openSession();
		if(LOGGER.isDebugEnabled())
			LOGGER.debug("openPlainSession ::"+session);
		return session;
	}

	public static String getCacheMapSize()
	{
		String mapSize = "notFound";
		try {
			mapSize = sqlCacheMap.size() + "";
		} catch (Exception e) {
			
		}
		return mapSize;
		
	}
	
	public static void clearCache()
	{
		sqlCacheMap = new TreeBidiMap();
		LOGGER.info("Cache Successfully cleared .........");
	}

}
