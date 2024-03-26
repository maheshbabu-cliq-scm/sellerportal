package com.sellerportal.ism.search.lucene.indexing;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

import org.apache.commons.io.FileUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.lucene.index.IndexWriter;
import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.response.UpdateResponse;
import org.apache.solr.common.SolrException;
import org.apache.solr.common.SolrInputDocument;

import com.anm.hibernate.DAOException;
import com.sellerportal.ism.search.lucene.indexing.IndexCommonUtils.CategoryRecord;
import com.sellerportal.ism.search.lucene.indexing.IndexConfiguration.ConfigParam;


@SuppressWarnings({"squid:S2885","squid:S2583"})
public class IndexHelper {
	//LOGGER declaration
	protected static final Log LOGGER = LogFactory.getLog("Indexer");

	
	public static String DELIMITER = "%%";
	//DEBUG flag to print the trace
	public static boolean DEBUG = false;
	//debug level : 0 dont print any debug, 3 highest
	public static int DEBUG_LEVEL = 0;
	//Show the discarded products
	public static boolean SHOW_DISCARDED = true;
	//Show the indexed products
	public static boolean SHOW_INDEXED = false;
	//Make entry of indexed PRN
	public static boolean ENTER_INDEXED = false;
	//Show the time taken per worker for input work
	public static boolean SHOW_WORKER_PERFORMANCE = false;
	//Print the Wait time by the Main thread before delegating to the worker threads
	public static  boolean SHOW_WORKER_WAIT_TIME = false;
	protected static volatile AtomicBoolean abort = new AtomicBoolean(false);
	public static volatile AtomicInteger indexed = new AtomicInteger(0); // total products indexed
	public static volatile AtomicInteger discarded = new AtomicInteger(0);; // total products discarded
	protected static Exception abortReason = null;
	
	public static Properties configuration = null;
	public static boolean cache = true; // Cache the parent categories
	protected static Map<Long,Set<IndexCommonUtils.CategoryRecord>> parentCategoryMap = new HashMap<Long,Set<IndexCommonUtils.CategoryRecord>>();
	protected static Map<String,Set<String>> slrNtopCatMap = new HashMap<String,Set<String>>();
	protected static Map<String,String> topCatNCatMap = new HashMap<String,String>();
	
	protected static Map<Long, Set<Long>> categoryCatalogueMap = new HashMap<Long,Set<Long>>();
	protected static Map<Long,Set<String>> ccgCczCityMap = new HashMap<Long,Set<String>>();
	protected static Map<Long, String> catalogueNameMap = new HashMap<Long,String>();

	protected static SimpleDateFormat DATE_FORMATTER = new SimpleDateFormat("yyyy-MM-dd");
	// Runtime variables
	static long longestIndexTime = 0;
	protected static volatile int from = 0;
	protected static volatile int total = 0;
	
	public static Date start = new Date();

	
	protected static IndexCommonUtils.ProgressThread progress = null;
	public static IndexWriter writer = null;
	public static String indexDirectory = null;
	public static File IndexedPIDFile = null;
	public static DataOutputStream DOS = null;
	public static FileOutputStream FOS = null;
	public static void cleanupDirectory(String dirName) {
		try {
			File tlog= new File (dirName); 
	        if (tlog.exists()) {
	            FileUtils.cleanDirectory(tlog); 
	        }	
		} catch (Exception e) {
			
		}
	}
	
	/**
	 * Entry method to start the indexing
	 * Create all the index using multiple runs to avoid leaks
	 * 
	 * @param directory
	 *            index directory
	 * @return
	 * @throws IOException
	 * @throws IOException
	 */
	
	public static Map productSizeListMap = new HashMap();
	
	
	public static boolean isInfo()
	{
		return DEBUG && DEBUG_LEVEL > 0;
	}
	
	public static boolean isDebug()
	{
		return DEBUG && DEBUG_LEVEL > 1;
	}
	
	public static boolean isTrace()
	{
		return DEBUG && DEBUG_LEVEL > 2;
	}
	
	/**
	 * DEBUG = true and DEBUG_LEVEL > 0
	 * @param msg
	 */
	public static void info(String msg)
	{
		if(DEBUG && DEBUG_LEVEL > 0)
			LOGGER.info("INFO "+msg);
	}
	
	/**
	 * DEBUG = true and DEBUG_LEVEL > 1
	 * @param msg
	 */
	public static void debug(String msg)
	{
		if(DEBUG && DEBUG_LEVEL > 1)
			LOGGER.info("DEBUG "+msg);
	}
	
	/**
	 * DEBUG = true and DEBUG_LEVEL > 2
	 * @param msg
	 */
	public static void trace(String msg)
	{
		if(DEBUG && DEBUG_LEVEL > 2)
			LOGGER.info("TRACE "+msg);
	}

	
	protected static Set<Long> getCataloguesIds(List<Object []> pccList ) throws Exception {
		Set<Long> catalogues = new HashSet<Long>();
		
		if(pccList == null || pccList.size() == 0)
			return catalogues;
		
		Iterator iterator = pccList.iterator();
		while (iterator.hasNext()) {
			boolean add = true;
			Object[] o = (Object[]) iterator.next();
			Long catalogId = (Long) o[0];
			String rtcd = (String) o[1];
			// String restrictQuery = (String) o[2];
			String restrictQuery = "";
			if (rtcd != null && rtcd.equals("Y")) {
				boolean restricted = false;
				restricted = isProductRestricted((Long) o[2], restrictQuery);
				if (restricted)
					add = false;
			}

			if (add) {
				catalogues.add(catalogId);
			}
		}
		return catalogues;
	}

	/**
	 * @param prn
	 * @param restrictQuery
	 * @return
	 */
	protected static boolean isProductRestricted(Long prn, String restrictQuery) {
		LOGGER.warn("isProductRestricted - Not implemented yet");
		return false;
	}

/*	*//**
	 * Fetch all the categories product belongs
	 * 
	 * @param dcatSet
	 *            Long Product Reference Number
	 * @return Set RRN of categories
	 * @throws DAOException
	 */
	protected static Set<IndexCommonUtils.CategoryRecord> findAllCategories(Set<Object[]> dcatSet, Long prn)
			throws Exception {
		Set<IndexCommonUtils.CategoryRecord> categories = new HashSet<IndexCommonUtils.CategoryRecord>();
		if (isTrace())
			debug("Product [" + prn + "] -> Total direct Categories ["
					+ dcatSet.size() + "]");

		// Add all the parent categories for direct product categories
		Iterator it = dcatSet.iterator();
		while (it.hasNext()) {
			Object [] obj = (Object []) it.next();
			Long categoryId = (Long) obj[0];
			String categoryName = (String) obj[1];
			CategoryRecord rec = new IndexCommonUtils.CategoryRecord(categoryId,categoryName);
			categories.add(rec);
			Set<IndexCommonUtils.CategoryRecord> parentCategories = getParentCategories(rec.getId());
			if (parentCategories != null) {
				if (isTrace())
					trace("Product [" + prn + "] : Direct category :"+ rec.getId() + " has total parents ["+ parentCategories.size() + "]");
				categories.addAll(parentCategories);
			} else {
				if (isTrace())
					trace("Product ["
									+ prn
									+ "] : Direct category :"
									+ rec.getId()
									+ " is top level category without a (null)parent definition in ISMCPT");

			}

		}
		return categories;
	}

	public static Set<IndexCommonUtils.CategoryRecord> getFromCache(Long categoryId) {
		return (Set<IndexCommonUtils.CategoryRecord>) parentCategoryMap.get(categoryId);
	}
	
	/**
	 * This function will recursively get all the parent category tree for the
	 * <code>categoryId</code>
	 * 
	 * @param categoryId
	 * @return
	 */

	protected static Set<IndexCommonUtils.CategoryRecord> getParentICategories(Long categoryId) {
		Set<IndexCommonUtils.CategoryRecord> parentCategories = getFromCache(categoryId);
		if (parentCategories != null) {
			return parentCategories;
		}else {
			
		}
		if (isDebug())
			debug("Can't find parent categories  for " + categoryId);
		return null;
	}

	/**
	 * Cache. This will cache the already retrieved category tree for given
	 * category id
	 */

	protected static Set<IndexCommonUtils.CategoryRecord> getParentCategories(Long categoryId) {

		return getParentICategories(categoryId);
	}

	public static void abort(Exception e)
	{
		LOGGER.info("Message :: "+e.toString() +" Cause :: "+e.getCause(),e);
		LOGGER.fatal("!! EXCEPTION:"+e.getMessage()+" ABORTING INDEXING ");
		abort.set(true);
		abortReason = e;
		System.exit(1);
	}
	
	
	
	
	/*public static  void addDocuments1(List<SolrInputDocument> docList)
	{
		try {
			Iterator it = docList.iterator();
			int k = 0;
			for (k = 0; it.hasNext(); k++) {
				SolrInputDocument doc = (SolrInputDocument) it.next();
				Document document = SolrIndexHelper.toLuceneDocument(doc);
				//SolrIndexConfig solrIndexConfig = new SolrIndexConfig()
				//new SolrIndexWriter("MeenaIndexer","C://SolrIndex",true,schema,solrIndexConfig);
				writer.addDocument(document);
				if (isDebug())
					debug("added product " + doc.getField("id")+ " to index");
				indexed.incrementAndGet();
			}

		} catch (Exception e) {
			LOGGER.info("Message :: "+e.toString() +" Cause :: "+e.getCause());
			LOGGER.warn("index: EXCEPTION [" + e.getMessage() + "]");
			System.exit(1);
		}
	}*/
	
	
	protected static boolean isValidProduct(Long pid) {
		return true;
	}
	
	public static boolean showDiscarded()
	{
		return SHOW_DISCARDED;
	}


	/**
	 //TODO We need to identify the Root Categories and keep in seperate lucene field
		//TODO Direct categories: Categories where product is actually linked to a category. Eg Bra product is attached to Sexy Bikini, Flower Bikini Categories.
		// In facet counts it should be only direct categories should be used to avoid the confusion but some time direct categories names are short name in
		// the context of category tree eg, Greeting Cards>Occasion>Fathers Day -> Greeting Cards(1) Occassions(1) Fathers Day(1)
		// Now in this case either we should display the root or leaf category (direct category) i.e Either Greeting Cards (1) OR Fathers Day(1)
		// So if there were two products under Greeting Cards in 2 categories Fathers Day/Mothers Day then Greeting Cards(2)/OR Fathers Day(1)/Mothers Day
		// Its good Idea to use the name of the catalogue of direct category in facet browsing i.e Greeting Cards - Fathers Day (1) Greeting Cards - Mothers Day
		// Gift Store - Delhi (32) Gifts Store - Mumbai (25)
		// How do we do that? 
		//   -> During search, dct should be used in search without category/catalogue
		//   -> For each direct category get name i.e getTopParent(FathersDAy) - Fathers Day
		// Or For each direct category on mouseover display the navigation path i.e Greeting Cards/Occassions/Fathers Day - Count
		// So categories with duplicate names will also be resolved
		// During indexing we can store the path of each direct category too
		// dct_* : dct_123456: (dynamic lucene field) : Greeting Cards/Occasion/Fathers Day
		//during display 
	 * @param sourceCampaignMap 
	 * @param productCampaignMap 
	 * @param boutiqueCampaignMap 
	 * @param categoryCampaignMap 
	 * @param campaignMap 
	 
	 * @param pbi
	 */
	
	
	
	
	
	private static boolean isDocumentMatch(SolrInputDocument document,
			BoostConfig cfg) {
		boolean isMatch = true;

		if (cfg.getConditions() != null && cfg.getConditions().length > 0) {

			for (int i = 0; i < cfg.getConditions().length; i++) {
				String condition = cfg.getConditions()[i];
				if (condition != null && condition.length() > 0) {
					String[] nvpair = condition.split("=");
					if (nvpair.length == 2) {
						if (!document.getFieldValue(nvpair[0])
								.equals(nvpair[1])) {
							isMatch = false;
							break;
						}
					}
				}
			}
		}
		return isMatch;
	}

	
	public static class BoostConfig {
		private String fieldName;

		private String[] conditions;

		private String excludeValue; //boost of 1

		private float excludeBoost; //default 1

		/**
		 * @return Returns the conditions.
		 */
		public String[] getConditions() {
			return conditions;
		}

		/**
		 * @param conditions The conditions to set.
		 */
		public void setConditions(String[] conditions) {
			this.conditions = conditions;
		}

		/**
		 * @return Returns the excludeBoost.
		 */
		public float getExcludeBoost() {
			return excludeBoost;
		}

		/**
		 * @param excludeBoost The excludeBoost to set.
		 */
		public void setExcludeBoost(float excludeBoost) {
			this.excludeBoost = excludeBoost;
		}

		/**
		 * @return Returns the excludeValue.
		 */
		public String getExcludeValue() {
			return excludeValue;
		}

		/**
		 * @param excludeValue The excludeValue to set.
		 */
		public void setExcludeValue(String excludeValue) {
			this.excludeValue = excludeValue;
		}

		/**
		 * @return Returns the fieldName.
		 */
		public String getFieldName() {
			return fieldName;
		}

		/**
		 * @param fieldName The fieldName to set.
		 */
		public void setFieldName(String fieldName) {
			this.fieldName = fieldName;
		}

		/* (non-Javadoc)
		 * @see java.lang.Object#equals(java.lang.Object)
		 */
		@Override
		public boolean equals(Object obj) {
			if (obj == null)
			    return false;

			  if (this.getClass() != obj.getClass())
			    return false;
			  
				BoostConfig other = (BoostConfig) obj;
				if (other.getFieldName().equalsIgnoreCase(this.getFieldName()))
					return true;
				else
					return false;
			}

		
		
		/*public boolean equals(Object obj) {
			if (obj != null) {
				BoostConfig other = (BoostConfig) obj;
				if (other.getFieldName().equalsIgnoreCase(this.getFieldName()))
					return true;
				else
					return false;
			} else {
				return false;
			}

		}*/
		

		@Override
		public int hashCode() {			
			return super.hashCode();
		}
		

	}

	
	public static Map getSizesForAtmGroup(String orgId)
	{
		Map atmSizes = null;
		List sizesList = null;
		String strSizes = null;
		String size = null;
		Statement stmt2 = null;
		ResultSet rs2 =null;
		try {
			Connection conn = JdbcConnection.getConnection();
			stmt2 = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
			rs2= stmt2.executeQuery("select atmastgrp,group_concat(distinct atmvpmsize separator ',vpmstk') as sizes from ismatm where orgid = "+ orgId +" group by atmastgrp");
			atmSizes = new HashMap();
			while(rs2.next())
			{
				sizesList = new ArrayList();
				strSizes = "vpmstk"+rs2.getString("sizes");
				int startIndex = 0;
				int endIndex = 0;
				
				while (strSizes.indexOf(",",startIndex) != -1)
				{
					endIndex = strSizes.indexOf(",",startIndex);
					size = strSizes.substring(startIndex,endIndex);
					startIndex = endIndex + 1;
					sizesList.add(size);
				}
				
				size = strSizes.substring(startIndex);
				sizesList.add(size);
				
				atmSizes.put(rs2.getString("atmastgrp"),sizesList);
			}
			//conn.close();
			
		} catch (Exception e) {
			LOGGER.info("SOMETHING GOES WRONG IN IndexHelper.getSizesForAtmGroup "+e.getMessage());
		} finally {
			try {
				if(stmt2 != null)   stmt2.close();
				if(rs2 != null)  rs2.close();
			}catch(NullPointerException | SQLException e) {
				LOGGER.info("Message :: "+e.toString() +" Cause :: "+e.getCause());
			}
		}
		return atmSizes;
	}
	
	public static String getAtmGroup(String productId,String orgId)
	{
		String atmGroup = null;
		Statement stmt2 = null;
		ResultSet rs2 =null;
		try {
			Connection conn = JdbcConnection.getConnection();
			stmt2 = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
			rs2= stmt2.executeQuery("select PILASRTGRP from ismpil where PILPBIRFNUM="+productId + " and orgid = " + orgId);
			
			while(rs2.next())
			{
				atmGroup = rs2.getString("PILASRTGRP");
				break;
			}
			rs2.close();
			stmt2.close();
			//conn.close();
			
		} catch (Exception e) {
			LOGGER.info("SOMETHING GOES WRONG IN IndexHelper.getAtmGroup "+e.getMessage());
		} finally {
			try {
				if(stmt2 != null)   stmt2.close();
				if(rs2 != null)  rs2.close();
			}catch(NullPointerException | SQLException e) {
				LOGGER.info("Message :: "+e.toString() +" Cause :: "+e.getCause());
			}
		}
		return atmGroup;
		
	}
	
	
	public static Map getAtmGroupSizeCodeMap(String orgId)
	{
		Map atmGroupSizeCodeMap = new HashMap();
		Statement stmt2 = null;
		ResultSet rs2 =null;
		try 
		{
			
			Connection conn = JdbcConnection.getConnection();
			stmt2 = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
			String query  = "select concat(ATMASTGRP,ATMVPMSIZE) as GRP,ATMCODE  from  ismatm where orgid = "+ orgId;
			rs2= stmt2.executeQuery(query);
			
			while(rs2.next())
			{
				String key = rs2.getString("GRP")+"";
				String atmCode = rs2.getString("ATMCODE")+"";
				atmGroupSizeCodeMap.put(key, atmCode);
			}
			
			rs2.close();
			stmt2.close();
		} catch (Exception e) {
			LOGGER.info("SOMETHING GOES WRONG IN IndexHelper.getAtmGroupSizeCodeMap "+e.getMessage());
		} finally {
			try {
				if(stmt2 != null)   stmt2.close();
				if(rs2 != null)  rs2.close();
			}catch(NullPointerException | SQLException e) {
				LOGGER.info("Message :: "+e.toString() +" Cause :: "+e.getCause());
			}
		}
		
		return atmGroupSizeCodeMap;
		
	}
	
	
	public static Map getProductAtmMap(List activeProductsList)
	{
		Map productAtmMap = new HashMap();
		Statement stmt2 = null;
		ResultSet rs2 =null;
		try 
		{
			String strProductList = activeProductsList.toString();
			strProductList = strProductList.replace(" ", "");
			strProductList = strProductList.replace("[", "");
			strProductList = strProductList.replace("]", "");	
			
			
		Connection conn = JdbcConnection.getConnection();
		stmt2 = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
		String query  = "select pilpbirfnum,PILASRTGRP from ismpil where pilpbirfnum in ("+strProductList+");" ;
		rs2= stmt2.executeQuery(query);
		
		while(rs2.next())
		{
			String key = rs2.getString("pilpbirfnum")+"";
			String atmCode = rs2.getString("PILASRTGRP")+"";
			productAtmMap.put(key, atmCode);
		}
		
		rs2.close();
		stmt2.close();
		} catch (Exception e) {
			LOGGER.info("SOMETHING GOES WRONG IN IndexHelper.getProductAtmMap "+e.getMessage());
		} finally {
			try {
				if(stmt2 != null)   stmt2.close();
				if(rs2 != null)  rs2.close();
			}catch(NullPointerException | SQLException e) {
				LOGGER.info("Message :: "+e.toString() +" Cause :: "+e.getCause());
			}
		}
		return productAtmMap;
	}
	
	public static Map getProductSizeListMap()
	{
		return productSizeListMap;
	}
}