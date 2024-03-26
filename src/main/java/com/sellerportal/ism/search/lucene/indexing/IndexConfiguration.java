package com.sellerportal.ism.search.lucene.indexing;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * @author Binod Kumar
 *
 */
public class IndexConfiguration {
	private static final Log LOGGER = LogFactory
			.getLog(IndexConfiguration.class);

	
	static boolean configured = false;

	public enum ConfigParam  {
		KEY_INDEX_DIRECTORY("index.dir"),
		KEY_INDEX_SPELLCHECK_DIRECTORY("sindex.dir"),
		KEY_INDEX_START("index.from"),
		KEY_INDEX_TOTAL("index.total"),
		KEY_INDEX_CREATE("index.create"),
		KEY_INDEX_PID_FILE("indexpid.dir"),
		
		//Index Writer configuration paramerers
		KEY_WRITER_MAX_BUFFEREDDOCS("writer.max.buffereddocs"),
		KEY_WRITER_RAM_BUFFERSIZE_MB("writer.ram.buffersizeMB"),
		KEY_WRITER_USE_COMPOUND_FILE("writer.useCompoundFile"),
		KEY_WRITER_MERGE_SCHEDULER_CLASS("writer.mergeSchedulerClass"),
		KEY_WRITER_MERGE_POLICY_CLASS("writer.mergePolicyClass"),
		KEY_WRITER_MERGE_FACTOR("writer.merge.factor"),
		
		//Thread Configuration
		KEY_WORKER_SIZE("worker.size"),
		KEY_WORKER_THREADS("worker.threads"),
		
		//Progress Thread Configuration
		KEY_PROGRESS_INTERVAL("progress.interval"),
		
		//ResultSet Parameters
		KEY_RESULTSET_TYPE("resultset.type"),
		
		//Debug Parameters
		KEY_DEBUG_ENABLE("debug"),
		KEY_DEBUG_PRINT_DISCARDED("debug.printDiscarded"),
		KEY_DEBUG_PRINT_INDEXED("debug.printIndexed"),
		KEY_DEBUG_PRINT_WORKER_PERFORMANCE("debug.printWorkerCompleteInfo"),
		KEY_DEBUG_PRINT_WORKER_ALLOCATION_WAIT_TIME("debug.printWorkerAllocationWaitTime"),
		KEY_DEBUG_SHOW_SQL("database.show.sql"),
		
		
		//JDBC Related parameters
		KEY_JDBC_URL("database.jdbc.url"),
		KEY_JDBC_USER("database.jdbc.user"),
		KEY_JDBC_PASSWORD("database.jdbc.password"),
		KEY_JDBC_DRIVER("database.jdbc.driver"),
		KEY_JDBC_PROPERTIES("database.jdbc.properties"),
		
		//JDBC Related parameters Rating
		KEY_JDBC_URL_SB("database.jdbc.url.sb"),
		KEY_JDBC_USER_SB("database.jdbc.user.sb"),
		KEY_JDBC_PASSWORD_SB("database.jdbc.password.sb"),
		KEY_JDBC_DRIVER_SB("database.jdbc.driver.sb"),
		KEY_JDBC_PROPERTIES_SB("database.jdbc.properties.sb");
		
		private ConfigParam(String paramName){
		      configKey = paramName;
		}

		public String key()
		{
			return configKey;
		}
		private String configKey = null;
		
	}
	
		
	public static String CONFIG_FILE = "lucene.properties";
	//Default Configuration if the CONFIG_FILE is missing
	public static String DEFAULT_CONFIG_FILE = "com/anm/ism/search/lucene/indexing/lucene.properties";
	
	
	
	/**
	 * Configure the lucene indexer based on lucene.properties
	 * Configuration file will be picked up from the root of the CLASSPATH with name lucene.properties.
	 * 
	 * System property -Dlucene.config.file can be used to override the default configuration loading. Relative path will be resolved
	 * as CLASSPATH relative rather the run location
	 *
	 */
	public static void configure()
	{
		if(configured)
			return;
		InputStream ins = null;
		try {
			
			//Check system property first -Dlucene.config.file=/some-path/lucene-config.properties
			//System.err.println(getInstance("KEY_JDBC_URL").key());
			
			String configFilePath = System.getProperty("lucene.config.file");
			if(configFilePath != null && configFilePath.trim().length() > 0)
			{
				File config = new File(configFilePath);
				if(config.exists())
				{
					if(config.isAbsolute()) {
						IndexHelper.LOGGER.info("[Configuration] <System.Property absolute path> lucene configuration LOADED from the "+configFilePath+" from the base of CLASSPATH.");
						ins = new FileInputStream(config);
					}else {
						//Load as a configuration relative to the CLASSPATH
						
						ins = Thread.currentThread().getContextClassLoader().getResourceAsStream(configFilePath);
						IndexHelper.LOGGER.info("[Configuration] <System.Property relative path> lucene configuration LOADED from the "+configFilePath+" from the base of CLASSPATH.");
					}
				}else {
					throw new Exception("[Configuration] -Dlucene.config.file="+configFilePath+" does not exist. Please check the path or use the default configuration");
				}
			}else {
				IndexHelper.LOGGER.info("! [Configuration] System.Property -Dlucene.config.file=path-to-lucene-configuration is not SET."); 
			}
			
			if(ins == null)
			{
				ins = Thread.currentThread().getContextClassLoader().getResourceAsStream(CONFIG_FILE);
				if(ins == null)
				{
					//load the default lucene.properties
					IndexHelper.LOGGER.info("! [Configuration] DOES NOT EXIST "+CONFIG_FILE+".");
					ins = Thread.currentThread().getContextClassLoader().getResourceAsStream(DEFAULT_CONFIG_FILE);
					IndexHelper.LOGGER.info("[Configuration] Using default configuration from "+DEFAULT_CONFIG_FILE+"");
				}else {
					IndexHelper.LOGGER.info("+  Configuration loaded from the "+CONFIG_FILE+". ");
				}
			}
			
			
			IndexHelper.configuration = new Properties();
			
			IndexHelper.configuration.load(ins);
			System.out.println(IndexHelper.configuration);
			
			IndexHelper.DEBUG = false;
			int debugLevel = Integer.parseInt(IndexConfiguration.getConfiguration(ConfigParam.KEY_DEBUG_ENABLE,"0"));
			if(debugLevel > 0)
			{
				System.out.println(" >>>>>>>>>>>>> DEBUG  IS ON "+debugLevel+">>>>>>>>>>>>>>>>>>");
				IndexHelper.DEBUG = true;
				IndexHelper.DEBUG_LEVEL = debugLevel;
			}
			
			String showDiscarded = IndexConfiguration.getConfiguration(ConfigParam.KEY_DEBUG_PRINT_DISCARDED,"false");
			if(showDiscarded.equalsIgnoreCase("true"))
				IndexHelper.SHOW_DISCARDED = true;
			
			String showIndexed = IndexConfiguration.getConfiguration(ConfigParam.KEY_DEBUG_PRINT_INDEXED,"false");
			if(showIndexed.equalsIgnoreCase("true"))
				IndexHelper.SHOW_INDEXED = true;
			
			String showWorkerPerformance = IndexConfiguration.getConfiguration(ConfigParam.KEY_DEBUG_PRINT_WORKER_PERFORMANCE,"false");
			if(showWorkerPerformance.equalsIgnoreCase("true"))
				IndexHelper.SHOW_WORKER_PERFORMANCE = true;
			
			String waitTimeForWorker = IndexConfiguration.getConfiguration(ConfigParam.KEY_DEBUG_PRINT_WORKER_ALLOCATION_WAIT_TIME,"false");
			if(waitTimeForWorker.equalsIgnoreCase("true"))
				IndexHelper.SHOW_WORKER_WAIT_TIME = true;
			
			configured = true;
		} catch (Exception e) {
			LOGGER.error(e.getStackTrace());
		} finally {
			if (ins != null)
				try {
					ins.close();
				} catch (IOException e) {
					LOGGER.error(e.getStackTrace());
				}
		}
	}
	
	
	public static String getConfiguration(ConfigParam param) {
		return getConfiguration(param.key());
	}
	
	public static String getConfiguration(ConfigParam param, String defaultValue) {
		return getConfiguration(param.key(), defaultValue);
	}

	private static String getConfiguration(String param, String defaultValue) {
		String value = System.getProperty(param);
		if (value != null) {
			return value;
		} else {
			if(IndexHelper.configuration == null){
				IndexConfiguration.configure();
			}
			if (defaultValue != null)
				return IndexHelper.configuration.getProperty(param, defaultValue);
			else
				return IndexHelper.configuration.getProperty(param);
		}
	}

	
	
	private static String getConfiguration(String param) {
		String value = System.getProperty(param);
		if (value != null) {
			return value;
		} else {
			if(IndexHelper.configuration == null){
				IndexConfiguration.configure();
			}
			return IndexHelper.configuration != null ?IndexHelper.configuration.getProperty(param):null;
		}
	}
	
	/**
	 * Get the Enumneration constant instance given the name of ConstantName and Class
	 * @param constantName
	 */
	public static ConfigParam getInstance(String whichParam)
	{
//		Parse the text to Enum constant. Given a string value of Constant Name, get an instance
		ConfigParam param = Enum.valueOf(ConfigParam.class, whichParam);
		return param;
	}

}
