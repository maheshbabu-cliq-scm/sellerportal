package com.sellerportal.ism.i18n;

import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Criteria;
import org.hibernate.EntityMode;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.hibernate.persister.entity.SingleTableEntityPersister;
import org.hibernate.type.EntityType;
import org.hibernate.type.LiteralType;
import org.hibernate.type.Type;

import com.anm.hibernate.HibernateConnection;
import com.sellerportal.model.Ismglt;
import com.sellerportal.model.Ismgot;
import com.sellerportal.ism.i18n.core.hibernate.EntityDataHolder;
import com.sellerportal.ism.i18n.core.sqlparser.MultilanguageHelper;
import com.sellerportal.ism.i18n.core.sqlparser.TableMetaDataDTO;

/**
 * All the hibernate related queries for all organization. Our hibernate interceptor to translate the SQL should
 * have a configuration to exclude some tables based on name or wildcard to avoid appending the orgID
 * @author anmol.pakhare
 *
 */
public class I18nHibernateHelper {
	
	private static final Log LOGGER = LogFactory.getLog(I18nHibernateHelper.class);
	
	
	
	
	/**
	 * TODO We need to the queries to avoid orgId appending in this table as this is a global system table
	 * @param langId
	 * @return
	 */
	public static Ismglt findLanguageById(String langId)
	{
		if(langId != null)
		{
			Criteria criteria = HibernateConnection.getSession().createCriteria(Ismglt.class);
			criteria.add(Restrictions.eq("gltrfnum",langId));
			List list = criteria.list();
			if(list != null && list.size() > 0)
			{
				return (Ismglt) list.get(0);
			}
		}
		
		return null;
	}

	/**
	 * Get the language object given a language code
	 * @param langCode
	 * @return
	 */
	public static Ismglt findLanguageByCode(String langCode)
	{
		if(langCode != null)
		{
			Criteria criteria = HibernateConnection.getSession().createCriteria(Ismglt.class);
			criteria.add(Restrictions.eq("gltcode",langCode));
			List list = criteria.list();
			if(list != null && list.size() > 0)
			{
				return (Ismglt) list.get(0);
			}
		}
		
		return null;
	}
	
	public static Ismgot findOrganizationByDomainName(String domainName)
	{
		if(domainName != null)
		{
			String hql = "from Ismgot got left join fetch got.ismglt where got.gotdomain=:domainName";
			Query query = HibernateConnection.getSession().createQuery(hql);
			query.setString("domainName",domainName);
			
			List list = query.list();
			if(list != null && list.size() > 0)
			{
				return (Ismgot) list.get(0);
			}
		}
		return null;
	}
	
	public static Ismgot findOrganizationByOrgId(String orgId)
	{
		if(orgId != null)
		{
			Session session = null;
			try {
				String hql = "from Ismgot got left join fetch got.ismglt where got.gotrfnum=:orgId";
				 session = MultilanguageHelper.openPlainSession();
				Query query = session.createQuery(hql);
				query.setLong("orgId",new Long(orgId));
				
				List list = query.list();
				if(list != null && list.size() > 0)
				{
					return (Ismgot) list.get(0);
				}
			}catch(Exception e) {
				LOGGER.error("findOrganizationByOrgId("+orgId+") :: EXCEPTION ::"+e.getMessage());
			}finally {
				if(session != null) {
					try {
						session.close();
					}catch(Exception e) {}
					
				}
			}
			
		}
		return null;
	}

	/**
	 * This method would be called for tables which requires multilanguage
	 * support conditionally
	 * 
	 * @param session
	 * @param pojo
	 * @param langColumn
	 * @param langId
	 * @throws IllegalAccessException
	 * @throws InvocationTargetException
	 * @throws NoSuchMethodException
	 */
	public static String insertUpdateLanguageRecord(
			SessionFactory sessionFactory, Object pojo, String langColumn,
			String langId, String orgId) {
		String rawSQl = null;
		try {
			String tableName = pojo.getClass().getSimpleName().toUpperCase();
			TableMetaDataDTO tableConfig = MultilanguageHelper
					.getTableMetaData(tableName);
			SingleTableEntityPersister entity = (SingleTableEntityPersister) sessionFactory
					.getClassMetadata(pojo.getClass());
			if (tableConfig != null && tableConfig.getColumns() != null
					&& tableConfig.getColumns().length > 0) {
	
				String[] pkColumns = I18nHibernateHelper.getPrimaryKeyColumns(entity);
				String[] pkValues = I18nHibernateHelper.getPrimaryKeyValues(entity, pojo);
	
				String[] columnNames = tableConfig.getColumns();
				String[] columnValues = new String[columnNames.length];
				String[] propertyNames = entity.getPropertyNames();
				for (String propertyName : propertyNames) {
					int index = entity.getPropertyIndex(propertyName);
					String[] propertyColumnNames = entity
							.getPropertyColumnNames(index);
					Type type = entity.getPropertyType(propertyName);
					if (!type.isEntityType() && !type.isAssociationType()
							&& !type.isCollectionType()
							&& !type.isComponentType()) {
						int ui = MultilanguageHelper.indexOf(tableConfig.getColumns(),
								propertyColumnNames[0]);
						if (ui >= 0) {
							Object v = entity.getPropertyValue(pojo,index);
							columnValues[ui] =  (v== null ? null:v+"") ;
						} 
					}
				}
				
				if(columnValues == null || columnValues.length == 0)
					return null;
	
				String[] allColumnNames = new String[columnNames.length + 1];
				String[] allColumnValues = new String[columnNames.length + 1];
				System.arraycopy(columnNames, 0, allColumnNames, 0,
						columnNames.length);
				System.arraycopy(columnValues, 0, allColumnValues, 0,
						columnNames.length);
				allColumnNames[columnNames.length] = "lang";
				allColumnValues[columnNames.length] = langId;
				rawSQl = MultilanguageHelper.generateInsertSQL(tableName + "_" + MultilanguageHelper.LANG_TABLE_SUFFIX,
						pkColumns, pkValues, allColumnNames, allColumnValues,
						orgId);
	
			} else {
				LOGGER.warn(" WARNING :: " + tableName+ " not configured for multilingual content");
	
			}
		} catch (Exception e) {
			LOGGER.error("insertUpdateLanguageRecord :: EXCEPTION <<"+e.getMessage()+">> ");
			//LOGGER.info("Message :: "+e.toString() +" Cause :: "+e.getCause());
			// Ignore. This is not really that important if called by mistake
		}
	
		if(LOGGER.isInfoEnabled())
			LOGGER.info("insertUpdateLanguageRecord\n"+rawSQl+"\n");
		return rawSQl;
	}

	/**
	 * Generate INSERT DDL for a given tableName with the definition
	 * 
	 * @param tableName
	 * @param pkColumnNames
	 * @param pkValues
	 * @param columnNames
	 * @param columnValues
	 * @param langColumnName
	 * @param langId
	 * @param orgColumnName
	 * @param orgId
	 * @return
	 */
	public static String generateInsertSQL(String tableName,
			String[] pkColumnNames, String[] pkValues, String[] columnNames,
			String[] columnValues, String orgColumnName, String orgId) {
		boolean havePKColumn = false;
		StringBuffer sqlBuffer = new StringBuffer();
		sqlBuffer.append(" insert into " + tableName.toUpperCase().trim());
		sqlBuffer.append("	(");
		if (pkColumnNames.length > 0) {
			havePKColumn = true;
			for (int i = 0; i < pkColumnNames.length; i++) {
				if (i != 0)
					sqlBuffer.append(", ");
				sqlBuffer.append(pkColumnNames[i]);
			}
		}
		if (columnNames.length > 0) {
			if (havePKColumn) {
				sqlBuffer.append(", ");
			}
			int k = 0;
			for (int i = 0; i < columnNames.length; i++) {
				if (columnValues[i] != null
						&& !columnValues[i].trim().equals("null")) {
					if (k != 0)
						sqlBuffer.append(", ");
					sqlBuffer.append(columnNames[i]);
					k++;
				}
			}
		}
	
		sqlBuffer.append(") VALUES (");
	
		if (pkValues.length > 0) {
			sqlBuffer.append(" ");
			for (int i = 0; i < pkValues.length; i++) {
				if (i != 0)
					sqlBuffer.append(", ");
				sqlBuffer.append("'"+pkValues[i]+"'");
			}
		}
		if (columnValues.length > 0) {
			if (havePKColumn) {
				sqlBuffer.append(", ");
			}
	
			int j = 0;
			for (int i = 0; i < columnValues.length; i++) {
				if (columnValues[i] != null
						&& !columnValues[i].trim().equals("null")) {
					if (j != 0)
						sqlBuffer.append(", ");
					sqlBuffer.append(" '" + columnValues[i] + "'");
					j++;
				}
			}
		}
	
		sqlBuffer.append(") ");
	
		// TODO This is mysql specific and can create problem with other
		// databases. PORTING
		if (columnValues.length > 0) {
			sqlBuffer.append(" ON DUPLICATE KEY UPDATE ");
			int j = 0;
			for (int i = 0; i < columnValues.length; i++) {
				if (columnValues[i] != null
						&& !columnValues[i].trim().equals("null")) {
					if (j != 0)
						sqlBuffer.append(", ");
					sqlBuffer.append(columnNames[i] + " = '" + columnValues[i]
							+ "'");
					j++;
				}
			}
		}
	
		if (LOGGER.isDebugEnabled())
			LOGGER.debug(sqlBuffer.toString());
		return sqlBuffer.toString();
	
	}

	/**
	 * SingleTableEntityPersister entity = (SingleTableEntityPersister) sessionFactory.getClassMetaData(pojo.getClass().getSimpleName());
	 * 
	 * Retrives the Primary key values usable in the insert/update kind of DDL statements
	 * 
	 * @param entity
	 * @param pojo
	 * @return
	 * @throws Exception
	 */
	public static String[] getPrimaryKeyValues(
			SingleTableEntityPersister entity, Object pojo) throws Exception {
		if(LOGGER.isDebugEnabled())
			LOGGER.debug("getPrimaryKey ::"+entity.getEntityName() + "."
				+ entity.getIdentifierPropertyName() + " => "
				+ Arrays.toString(entity.getIdentifierColumnNames())
				+ " TYPE [" + entity.getIdentifierType() + "]");
		Type identifierType = entity.getIdentifierType();
		Serializable identifier = entity.getIdentifier(pojo);
		if (identifierType instanceof EntityType) {
			// Composite Primary Key
			if (entity.getIdentifierPropertyName().equals("comp_id")) {
				String[] pkColumns = entity.getIdentifierColumnNames();
				String[] pkValues = new String[pkColumns.length];
				for (int i = 0; i < pkColumns.length; i++) {
					String pkValue = BeanUtils.getSimpleProperty(identifier,
							pkColumns[i].toLowerCase());
					pkValues[i] = pkValue;
				}
				return pkValues;
			} else {
				throw new RuntimeException(
						" Composite Primary key mapping using component not handled "
								+ entity.getName());
			}
		} else {
			return new String[] { identifier + "" };
		}
	}

	/**
	 * Givena pojo for given property (could be a complex property too) it returns the array of values.
	 * In normal case, it returns one values for normal columns but if there is a composite fk then it would return 2 value for a given field
	 * @param entity
	 * @param propertyName
	 * @param pojo
	 * @param sf
	 * @param propertyValue
	 * @return
	 * @throws Exception
	 */
	public static String[] getPropertyValues(
			SingleTableEntityPersister entity, String propertyName,
			Object pojo, SessionFactory sf, Object propertyValue) throws Exception {
		
	
		if (propertyValue != null) {
			Type type = entity.getPropertyType(propertyName);
			String[] values = new String[entity
					.getPropertyColumnNames(propertyName).length];
			if (type instanceof LiteralType) {
				values[0] = propertyValue + "";
			} else if (type instanceof EntityType) {
				// This is the case of ManyToOne/OneToOne/ComponentType
				SingleTableEntityPersister parentEntity = (SingleTableEntityPersister) sf
						.getClassMetadata(((EntityType) type)
								.getAssociatedEntityName());
				String[] pkValues = getPrimaryKeyValues(parentEntity,
						propertyValue);
				values = pkValues;
			} else {
				values[0] = propertyValue + "";
	
			}
			return values;
		} else {
			return new String[] { null };
		}
	
	}

	/**
	 * Return the dbname of primary key columns
	 * @param entity
	 * @return
	 */
	public static String[] getPrimaryKeyColumns(
			SingleTableEntityPersister entity) {
		return entity.getIdentifierColumnNames();
	}
	
	/**
	 * Return the dbname of primary key columns
	 * @param entity
	 * @return
	 */
	public static String[] getPrimaryKeyColumns(Class entityClass) {
		
		return getPrimaryKeyColumns((SingleTableEntityPersister) HibernateConnection.getSessionFactory().getClassMetadata(entityClass));
	}

	/**
	 * This method create a update SQL given the PreviousStates and include only the language columns
	 * 
	 * @param sf
	 * @param updateData
	 * @param langColumnName
	 * @param langCode
	 * @param orgId
	 * @return
	 * @throws Exception
	 */
	public static String createUpdateSQLForMaster(SessionFactory sf,
			EntityDataHolder updateData, String langColumnName,
			String langCode, String orgId) throws Exception {
		
		if(updateData.getPreviousState() == null)
			return null;
		
		Object pojo = updateData.getEntity();
		String tableName = pojo.getClass().getSimpleName().toUpperCase();
		SingleTableEntityPersister entity = (SingleTableEntityPersister) sf
				.getClassMetadata(pojo.getClass());
		
		
		
		TableMetaDataDTO tableConfig = MultilanguageHelper
				.getTableMetaData(tableName);
	
		if (tableConfig == null || tableConfig.getColumns() == null
				|| tableConfig.getColumns().length == 0)
			return null;
	
		String[] langColumnNames = tableConfig.getColumns();
	
		StringBuffer updateSQL = new StringBuffer("UPDATE  "
				+ entity.getTableName() + " SET ");
		StringBuffer updateCondition = new StringBuffer();
	
		for (String propertyName : entity.getPropertyNames()) {
			Type type = entity.getPropertyType(propertyName);
			if (type.isCollectionType())
				continue;
	
			Object[] previousValue = updateData.getPreviousState();
			int pi = entity.getPropertyIndex(propertyName);
			
			String[] values = getPropertyValues(entity, propertyName, pojo, sf,previousValue[pi]);
			if(LOGGER.isDebugEnabled())
				LOGGER.debug(entity.getEntityName()
					+ "."
					+ propertyName
					+ " ["
					+ pi
					+ "] ==> "
					+ Arrays.toString(entity
							.getPropertyColumnNames(propertyName)) + " = "
					+ Arrays.toString(values));
	
			String[] propertyColumnNames = entity
					.getPropertyColumnNames(propertyName);
			for (int i = 0; i < propertyColumnNames.length; i++) {
				int li = MultilanguageHelper.indexOf(langColumnNames, propertyColumnNames[i]);
				if (li >= 0) {
					if(values[i] != null) {
						if (updateCondition.length() > 0)
							updateCondition.append(",");
						updateCondition.append(" " + propertyColumnNames[i] + "="+ (values[i] == null ? "NULL" : "'"+values[i]+"'"));
					}
				}
			}
	
		}
	
		if (updateCondition.length() > 0) {
			updateSQL.append("  " + updateCondition);
	
			StringBuffer where = new StringBuffer();
			String[] primaryKeyColumns = getPrimaryKeyColumns(entity);
			if (primaryKeyColumns != null && primaryKeyColumns.length > 0) {
				String[] primaryKeyValues = getPrimaryKeyValues(entity, pojo);
				where.append(" orgId=" + orgId + " ");
				for (int i = 0; i < primaryKeyColumns.length; i++) {
					where.append(" AND " + primaryKeyColumns[i] + " = '"+ primaryKeyValues[i]+"'");
				}
			}
			if (where.length() > 0)
				updateSQL.append(" WHERE " + where);
		}
	
		String sql = updateSQL.toString();
		if(LOGGER.isInfoEnabled())
			LOGGER.info("[SQL Master Update SQL]======================== \n" + sql);
		return sql;
	}


	

}
