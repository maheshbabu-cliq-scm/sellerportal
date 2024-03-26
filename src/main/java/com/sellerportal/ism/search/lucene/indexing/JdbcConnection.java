/**
 * 
 */
package com.sellerportal.ism.search.lucene.indexing;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.concurrent.atomic.AtomicInteger;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sellerportal.ism.search.lucene.indexing.IndexConfiguration.ConfigParam;

/**
 * @author Binod Kumar
 *
 */
@SuppressWarnings("squid:S2095")
public class JdbcConnection {
	//Declare LOGGER
	private static final Log LOGGER = LogFactory.getLog(JdbcConnection.class);
	
	private static final AtomicInteger connectionCount =  new AtomicInteger(0);
	private static final AtomicInteger connectionCountSb=  new AtomicInteger(0);
	private static final ThreadLocal<Connection> localConnection = new ThreadLocal<Connection>();
	private static final ThreadLocal<Connection> localConnectionSb = new ThreadLocal<Connection>();
	private static String PARAM_CONFIG_DATABASE_URL = "database.jdbc.url";
	private static final String PARAM_CONFIG_JNDI_NAME = "jdbc/tcsdb";
	/**
	 * Create a one jdbc connection per thread. If already created and open/active, then return otherwise create new and set in threadlocal.
	 * @return
	 * @throws Exception 
	 * @throws SQLException 
	 */
	public static Connection getConnection() throws  Exception
	{
		Connection conn = JdbcConnection.localConnection.get();
		if(conn == null)
		{
			conn = JdbcConnection.newConnection();
			JdbcConnection.localConnection.set(conn);
			
			int totalCount = JdbcConnection.connectionCount.incrementAndGet();
			if(isDebugEnabled())
			{
				LOGGER.info("[DATABASE.DEBUG] connection created. total "+totalCount);
			}
		}else {
			//Check if conn is in good state
			if(conn.isClosed())
			{
				LOGGER.warn("! connection is closed directly. cleaning up and creating new connection");
				JdbcConnection.closeConnection();
				conn = JdbcConnection.newConnection();
				JdbcConnection.localConnection.set(conn);
				int totalCount = JdbcConnection.connectionCount.incrementAndGet();
				if(isDebugEnabled())
				{
					LOGGER.info("[DATABASE.DEBUG] connection created. total "+totalCount);
				}
			}
		}
		
		return conn;
	}

	/**
	 * Close the thread specific jdbc connection.
	 *
	 */
	public static void closeConnection() {
		try{
	        Connection conn = JdbcConnection.localConnection.get();
	        if(conn == null)
	        	return;
	        if(conn.isClosed()){
	            LOGGER.warn("! connection is closed directly. cleaning up and creating new connection");
	        }else{
	            conn.close();
	            int totalCount = JdbcConnection.connectionCount.decrementAndGet();
	            JdbcConnection.localConnection.set(null);
	            JdbcConnection.localConnection.remove();
	            if(isDebugEnabled()){
	                LOGGER.info("[DATABASE.DEBUG] connection closed. total "+totalCount);
	            }
	        }
		}catch(Exception e){
			LOGGER.warn("! closeConnection: "+e.getMessage());
		} 
	}

	/**
	 * Create new jdbc connection based on the configuration
	 * @return
	 * @throws Exception 
	 */
	public static Connection newConnection() throws Exception
	{
		Connection connection = null;
		try {
			Context ctx = new InitialContext();
			LOGGER.info("CTX "+ctx);
			DataSource ds = (DataSource) ctx.lookup(PARAM_CONFIG_JNDI_NAME);
			connection = ds.getConnection();
		} catch (Exception e) {
			LOGGER.info("No JNDI Specify. Now Going to create Connection with JDBC");
		}
		if(connection == null){
			String url = IndexConfiguration.getConfiguration(ConfigParam.KEY_JDBC_URL);
			String userId = IndexConfiguration.getConfiguration(ConfigParam.KEY_JDBC_USER);
			String password = IndexConfiguration.getConfiguration(ConfigParam.KEY_JDBC_PASSWORD);
			String driverClass = IndexConfiguration.getConfiguration(ConfigParam.KEY_JDBC_DRIVER);
			String jdbcExtraProperties = IndexConfiguration.getConfiguration(ConfigParam.KEY_JDBC_PROPERTIES);
			
			if(isDebugEnabled()){
				LOGGER.info("[DATABASE.DEBUG] newConnection (url:"+url+", userId:"+userId+", password:"+password+", driver:"+driverClass+")");
			}
			try {
				Class.forName(driverClass);
				connection = DriverManager.getConnection(url, userId, password);
			} catch (ClassNotFoundException e) {
				throw new Exception("ClassNotFoundException:"+e.getMessage());
			}
		}
		
		try {
			connection.setReadOnly(true); //to avoid any implicit locks etc while row reads
			//connection.setTransactionIsolation(Connection.TRANSACTION_READ_UNCOMMITTED);//Oracle v11g doesn't support Read-Uncommited
			connection.setTransactionIsolation(Connection.TRANSACTION_READ_COMMITTED); //
			return connection;
		} catch (SQLException e) {
			throw new Exception("DriverManager.getConnection() : SQLException:"+e.getMessage());
		}
	}
	
	public static boolean isDebugEnabled()
	{
		if(IndexConfiguration.getConfiguration(ConfigParam.KEY_DEBUG_ENABLE, "false").equalsIgnoreCase("true"))
			return true;
		else
			return false;
	}
	
	public static void main(String [] args)
	{
		IndexConfiguration.configure();
		try {
			Connection connection = JdbcConnection.newConnection();
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery("select pbi.pbirfnum as pbirfnum," +
					"group_concat(pil.pilrfnum order by pilrfnum desc SEPARATOR ':') as pilrfnum" +
					" from ISMPBI pbi left outer join ISMPIL pil on pil.pilpbirfnum=pbi.pbirfnum AND pil.pilactive='Y'  group by pbi.pbirfnum limit 10");
			while(rs!=null && rs.next())
			{
				System.out.println(rs.getString("pbirfnum")+" ==> pilrfnums = "+rs.getString("pilrfnum"));
			}
			
		}catch(Exception e) {
			LOGGER.info("Message :: "+e.toString() +" Cause :: "+e.getCause());
		}
		
	}
	
	public static Connection getModificableConnection() throws  Exception
	{
		Connection conn = JdbcConnection.localConnection.get();
		if(conn == null)
		{
			conn = JdbcConnection.newConnectionForInsert();
			JdbcConnection.localConnection.set(conn);
			
			int totalCount = JdbcConnection.connectionCount.incrementAndGet();
			if(isDebugEnabled())
			{
				LOGGER.info("[DATABASE.DEBUG] connection created. total "+totalCount);
			}
		}else {
			//Check if conn is in good state
			if(conn.isClosed())
			{
				LOGGER.warn("! connection is closed directly. cleaning up and creating new connection");
				JdbcConnection.closeConnection();
				conn = JdbcConnection.newConnectionForInsert();
				JdbcConnection.localConnection.set(conn);
				int totalCount = JdbcConnection.connectionCount.incrementAndGet();
				if(isDebugEnabled())
				{
					LOGGER.info("[DATABASE.DEBUG] connection created. total "+totalCount);
				}
			}
		}
		
		return conn;
	}
	public static Connection newConnectionForInsert() throws Exception
	{
		String url = IndexConfiguration.getConfiguration(ConfigParam.KEY_JDBC_URL);
		String userId = IndexConfiguration.getConfiguration(ConfigParam.KEY_JDBC_USER);
		String password = IndexConfiguration.getConfiguration(ConfigParam.KEY_JDBC_PASSWORD);
		String driverClass = IndexConfiguration.getConfiguration(ConfigParam.KEY_JDBC_DRIVER);
		String jdbcExtraProperties = IndexConfiguration.getConfiguration(ConfigParam.KEY_JDBC_PROPERTIES);
		
		if(isDebugEnabled())
		{
			LOGGER.info("[DATABASE.DEBUG] newConnection (url:"+url+", userId:"+userId+", password:"+password+", driver:"+driverClass+")");
		}
		try {
			Class.forName(driverClass);
		} catch (ClassNotFoundException e) {
			throw new Exception("ClassNotFoundException:"+e.getMessage());
		}
		try {
			Connection connection = DriverManager.getConnection(url, userId, password);
			//connection.setReadOnly(true); //to avoid any implicit locks etc while row reads
			//connection.setTransactionIsolation(Connection.TRANSACTION_READ_UNCOMMITTED);//Oracle v11g doesn't support Read-Uncommited
			connection.setTransactionIsolation(Connection.TRANSACTION_READ_COMMITTED); //
			return connection;
		} catch (SQLException e) {
			throw new Exception("DriverManager.getConnection() : SQLException:"+e.getMessage());
		}
	}

	
	public static Connection getSbConnection() throws  Exception
	{
		Connection conn = JdbcConnection.localConnectionSb.get();
		if(conn == null)
		{
			conn = JdbcConnection.SbConnection();
			JdbcConnection.localConnectionSb.set(conn);
			
			int totalCount = JdbcConnection.connectionCountSb.incrementAndGet();
			if(isDebugEnabled())
			{
				LOGGER.info("[DATABASE.DEBUG] connection created for rating. total "+totalCount);
			}
		}else {
			//Check if conn is in good state
			if(conn.isClosed())
			{
				LOGGER.warn("! getNewDBConnection connection is closed directly. cleaning up and creating new connection");
				JdbcConnection.closeSbConnection();
				conn = JdbcConnection.SbConnection();
				JdbcConnection.localConnectionSb.set(conn);
				int totalCount = JdbcConnection.connectionCountSb.incrementAndGet();
				if(isDebugEnabled())
				{
					LOGGER.info("[DATABASE.DEBUG] connection created for rating. total "+totalCount);
				}
			}
		}
		
		return conn;
	}
	
	public static Connection SbConnection() throws Exception
	{
		Connection connection = null;
		if(connection == null){
			String url = IndexConfiguration.getConfiguration(ConfigParam.KEY_JDBC_URL_SB);
			String userId = IndexConfiguration.getConfiguration(ConfigParam.KEY_JDBC_USER_SB);
			String password = IndexConfiguration.getConfiguration(ConfigParam.KEY_JDBC_PASSWORD_SB);
			String driverClass = IndexConfiguration.getConfiguration(ConfigParam.KEY_JDBC_DRIVER_SB);
			
			if(isDebugEnabled()){
				LOGGER.info("[DATABASE.DEBUG] newConnection for rating (url:"+url+", userId:"+userId+", password:"+password+", driver:"+driverClass+")");
			}
			try {
				Class.forName(driverClass);
				connection = DriverManager.getConnection(url, userId, password);
			} catch (ClassNotFoundException e) {
				throw new Exception("ClassNotFoundException:"+e.getMessage());
			}
		}
		
		try {
			connection.setReadOnly(true); //to avoid any implicit locks etc while row reads
			//connection.setTransactionIsolation(Connection.TRANSACTION_READ_UNCOMMITTED);//Oracle v11g doesn't support Read-Uncommited
			connection.setTransactionIsolation(Connection.TRANSACTION_READ_COMMITTED); //
			return connection;
		} catch (SQLException e) {
			throw new Exception("DriverManager.getConnection() : SQLException:"+e.getMessage());
		}
	}
	
	public static void closeSbConnection() {
		try{
	        Connection conn = JdbcConnection.localConnectionSb.get();
	        if(conn == null)
	        	return;
	        if(conn.isClosed()){
	            LOGGER.warn("! connection is closed directly. cleaning up and creating new connection for rating");
	        }else{
	            conn.close();
	            int totalCount = JdbcConnection.connectionCountSb.decrementAndGet();
	            JdbcConnection.localConnectionSb.set(null);
	            JdbcConnection.localConnectionSb.remove();
	            if(isDebugEnabled()){
	                LOGGER.info("[DATABASE.DEBUG] connection closed. total "+totalCount);
	            }
	        }
		}catch(Exception e){
			LOGGER.warn("! closeConnection: "+e.getMessage());
		} 
	}

	
}
