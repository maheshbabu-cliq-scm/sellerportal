/*
 *
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package com.sellerportal.ism;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;
import java.net.URL;
import java.util.Collection;
import java.util.Collections;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Properties;
import java.util.Set;
import java.util.zip.ZipEntry;
import java.util.zip.ZipException;
import java.util.zip.ZipFile;

import javax.faces.context.FacesContext;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;

import com.sellerportal.integra.impl.octashop.utils.OctashopUtils;
import com.sellerportal.ism.AppConfigHelper;
import com.sellerportal.model.Appconfig;
import com.sellerportal.dao.AppconfigDAO;
import com.sellerportal.model.OctSlr;
import com.sellerportal.model.OctSlv;
import com.sellerportal.dao.OrgiptDAO;
import com.sellerportal.ism.i18n.I18nHelper;
import com.sellerportal.ism.i18n.OrganizationHelper;
import com.sellerportal.ism.utils.CommonUtils;
import com.anm.jsf.utils.FacesUtils;

/**
 * @author Chandra Singh Meena
 * 
 *         This class provides the methods to fetch application configurations.
 *         Modified to support the path based on the multiple organizations
 *         (partitions)
 * 
 */
public class Configuration {

	private static final Log LOGGER = LogFactory.getLog(Configuration.class);

	// This would be loaded once from appConfig.properties and reloaded if
	// modified
	private static Properties applicationConfiguration = null;
	private static Properties searchConfiguration=null;
	private static Properties schedulerConfiguration=null;
	// This would contains the key=value from appConfig.properties replaced with
	// organizational data plus ismipt based organization replacement values
	private static Map<String, String> orgAppConfigMap = Collections
			.synchronizedMap(new HashMap<String, String>());

	public static Map<String, VelocityContext> contextMap = new HashMap<String, VelocityContext>();

	private static String[] filter = new String[] { "${cms.octashop.com}", /* internal */
			"${mail.octashop.com}", /* internal */
			"${static.octashop.com}", /* public */
			"${solr.octashop.com}", /* internal */
			"${db.octashop.com}", /* internal */
			"${images.octashop.com}", /* public */
			"${css.octashop.com}", /* public */
			"${js.octashop.com}", /* public */
			"${document.root}",
			"${document.topCategory}"
	};

	private static VelocityEngine _engine = null;
	private static boolean shutdown=false;

	public static void shutdown(){
		shutdown=true;

		orgAppConfigMap.clear();
		contextMap.clear();
		applicationConfiguration = null;
		searchConfiguration=null;
		schedulerConfiguration=null;
	}

	public static void initializeAppConfiguration() {
		shutdown=false;
		try {
			_engine = createVelocityEngine();
		} catch (Exception e) {
			LOGGER.info("Message :: "+e.toString() +" Cause :: "+e.getCause());
		}

		// loadAppConfiguration();
		applicationConfiguration = I18nHelper.loadResource("appConfig.properties");
		searchConfiguration = I18nHelper.loadResource("search.properties");
		schedulerConfiguration = I18nHelper.loadResource("scheduler-config.properties");

		final long reloadInterval = 1 * 60 * 1000; // Reload every 5 minute

		Thread reloaderTask = new Thread() {

			private long lastModifiedTime = -1L;

			public void run() {
				LOGGER.info(" ReloadAppConfig.properties -  appConfig.properties reload thread started ");

				while (!shutdown) {
					try {

						// File file = new File(new
						// CommonUtils().getApplicationBasePath()+"/WEB-INF/classes/appConfig.properties");
						URL appConfig = Thread.currentThread().getContextClassLoader().getResource("appConfig.properties");

						URL search=Thread.currentThread().getContextClassLoader().getResource("search.properties");
						URL schedulerConfig=Thread.currentThread().getContextClassLoader().getResource("scheduler-config.properties");

						File file = new File(appConfig.getFile());

						File searchFile=new File(search.getFile());
						File schedulerConfFile=new File(schedulerConfig.getFile());

						long lastModified = file.lastModified();
						if (this.lastModifiedTime < 0
								|| lastModified > this.lastModifiedTime + 1000) {
							this.lastModifiedTime = lastModified;
							loadAppConfiguration();
						}

						long searchLastModifiedTime=searchFile.lastModified();

						if (this.lastModifiedTime < 0
								|| searchLastModifiedTime > this.lastModifiedTime + 1000) {
							this.lastModifiedTime = searchLastModifiedTime;
							loadAppConfiguration();
						}


						long schedulerConfigLastModifiedTime=schedulerConfFile.lastModified();

						if (this.lastModifiedTime < 0
								|| schedulerConfigLastModifiedTime > this.lastModifiedTime + 1000) {
							this.lastModifiedTime = schedulerConfigLastModifiedTime;
							loadAppConfiguration();
						}


						Thread.sleep(reloadInterval);
					} catch (InterruptedException e) {
						// LOGGER.info("Message :: "+e.toString() +" Cause :: "+e.getCause());
					}
				}

			}
		};

		reloaderTask.start();
	}

	private static void loadAppConfiguration() {
		LOGGER.info("+ loadAppConfiguration() :  Reloading  appConfig.properties ");

		try {

			applicationConfiguration = I18nHelper
					.loadResource("appConfig.properties");

			// Total organization map, cache would be rebuilt if required
			// gracefully
			Map<String, Map<String, String>> organizationsMap = OrganizationHelper
					.getOrganizationMap();

			Set<Entry<Object, Object>> entrySet = applicationConfiguration
					.entrySet();
			Iterator<Entry<Object, Object>> properties = entrySet.iterator();
			while (properties.hasNext()) {
				Entry<Object, Object> pEntry = properties.next();
				String orgId = null;
				Iterator<Entry<String, Map<String, String>>> it = organizationsMap
						.entrySet().iterator();
				while (it.hasNext()) {
					Entry<String, Map<String, String>> oEntry = it.next();
					orgId = oEntry.getKey();
					VelocityContext velocityContext = getVelocityContext(orgId);
					String k = orgId + "/" + pEntry.getKey();

					String replacedValue = getReplacedValue(pEntry.getValue()
							+ "", velocityContext, orgId);
					if (LOGGER.isDebugEnabled())
						LOGGER.debug(k + " = " + pEntry.getValue()
						+ " Replaced value = " + replacedValue);
					orgAppConfigMap.put(k, replacedValue);
				}
			}

			// Search.proertiess section start

			searchConfiguration = I18nHelper.loadResource("search.properties");

			LOGGER.info("search.properties loading start....");
			Set<Entry<Object, Object>> sEntrySet = searchConfiguration.entrySet();
			Iterator<Entry<Object, Object>> sProperties = sEntrySet.iterator();
			while (sProperties.hasNext()) {
				Entry<Object, Object> sEntry = sProperties.next();
				String orgId = null;
				Iterator<Entry<String, Map<String, String>>> it = organizationsMap.entrySet().iterator();
				while (it.hasNext()) {
					Entry<String, Map<String, String>> oEntry = it.next();
					orgId = oEntry.getKey();
					VelocityContext velocityContext = getVelocityContext(orgId);
					String k = orgId + "/" + sEntry.getKey();

					String replacedValue = getReplacedValue(sEntry.getValue()+ "", velocityContext, orgId);

					if (LOGGER.isDebugEnabled())
						LOGGER.debug(k + " = " + sEntry.getValue()
						+ " Replaced value = " + replacedValue);
					orgAppConfigMap.put(k, replacedValue);
				}
			}

			// scheduler-config.properties section start

			schedulerConfiguration = I18nHelper.loadResource("scheduler-config.properties");

			LOGGER.info("scheduler-config.properties loading start....");

			Set<Entry<Object, Object>> schedulerEntrySet = schedulerConfiguration.entrySet();
			Iterator<Entry<Object, Object>> schedulerProperties = schedulerEntrySet.iterator();
			while (schedulerProperties.hasNext()) {
				Entry<Object, Object> schedulerEntry = schedulerProperties.next();
				String orgId = null;
				Iterator<Entry<String, Map<String, String>>> it = organizationsMap.entrySet().iterator();
				while (it.hasNext()) {
					Entry<String, Map<String, String>> oEntry = it.next();
					orgId = oEntry.getKey();
					VelocityContext velocityContext = getVelocityContext(orgId);
					String k = orgId + "/" + schedulerEntry.getKey();

					String replacedValue = getReplacedValue(schedulerEntry.getValue()+ "", velocityContext, orgId);
					if (LOGGER.isDebugEnabled())
						LOGGER.debug(k + " = " + schedulerEntry.getValue()+ " Replaced value = " + replacedValue);
					orgAppConfigMap.put(k, replacedValue);
				}
			}

			// TODO Repeat the above for each managed configurations like
			// scheduer-config.properties, search.properties and future
			// TODO jsp to flush the needed cache
			// Auto reloading in safe way to avoid deadlocks if any of the
			// backed properties files are modified
		} catch (Exception e) {
			LOGGER.error("Error in loadConfiguration() ", e);
			orgAppConfigMap = null;
		}

		//LOGGER.info(orgAppConfigMap);

	}

	private static VelocityEngine createVelocityEngine() throws Exception {
		Properties props = new Properties();
		props.load(Thread.currentThread().getContextClassLoader()
				.getResourceAsStream("velocity.properties"));
		VelocityEngine vengine = new VelocityEngine();
		vengine.init(props);
		return vengine;
	}

	/**
	 * Gets the Velocity Engine. Does it need to by synchronized?
	 * 
	 * @return The Engine value
	 * @throws Exception
	 */
	private static VelocityEngine getEngine() throws Exception {
		if (_engine == null)
			throw new Exception("Velocity Engine not initialized");
		return _engine;
	}

	/**
	 * Constructor for Configuration
	 * 
	 */
	public Configuration() {
	}

	private static ApplicationBean getAppicationBean() {
		System.out.println("inside getappbean");
		if (FacesContext.getCurrentInstance() != null)
		{
			System.out.println("not inside getappbean");
			return (ApplicationBean) FacesUtils
					.getManagedBean("ApplicationBean");
		}
			
		return null;
	}

	/* This method should be called as an API method by the request threads */
	public String getProperty(String key) {
		String value = null;
		ApplicationBean appBean = getAppicationBean();
		System.out.println(appBean);
		if (appBean != null) {
			try {
				value = BeanUtils.getMappedProperty(appBean, key);
				System.out.println("Hi");
				if (value != null) {
					if (LOGGER.isWarnEnabled())
						LOGGER.warn("! Dont want any property in ApplicationBean so that application can work in standalone mode too!");
					value = getReplacedValue(value);
				}
			} catch (Exception e) {
				// LOGGER.info("Message :: "+e.toString() +" Cause :: "+e.getCause());
			}
		}

		if (value == null) {
			// value = applicationConfiguration.getProperty(key);
			String[] ol = I18nHelper.getOrganizationAndLanguageId(null, null);
			if (ol != null && ol.length > 0 && StringUtils.isNotBlank(ol[0])) {
				key = ol[0] + "/" + key;
				if (orgAppConfigMap == null || orgAppConfigMap.isEmpty()) {
					synchronized (Configuration.class) {
						LOGGER.warn(" Dont expect this message. Some thing wierd if it prints frequently");
						if (orgAppConfigMap == null)
							loadAppConfiguration();
					}
				}

				if (orgAppConfigMap != null)
					value = orgAppConfigMap.get(key); // baseImageLocation ->//
				// 0/baseImageLocation

				if (LOGGER.isDebugEnabled())
					LOGGER.debug(key + "=" + value);
			} else {
				LOGGER.warn(" ! Unexpected. organization id is not set. Return the raw value without any dynamic replacement based on the organization");
				value = applicationConfiguration.getProperty(key);
			}

		}

		return value;
	}

	public static String replace(String value, String orgId) {

		// boolean isReplaced = false;
		for (int i = 0; i < filter.length; i++) {

			if (StringUtils.contains(value, filter[i])) {
				String key = StringUtils.substringBetween(filter[i], "${", "}");

				if (LOGGER.isDebugEnabled())
					LOGGER.debug("key to fetch record from orgipt map >> "
							+ key);

				String dbValue = AppConfigHelper.getValueFromDB(orgId, key);// "192.168.57.192";

				if (LOGGER.isDebugEnabled())
					LOGGER.debug("returned value from orgipt map >> " + dbValue);

				if (StringUtils.isNotBlank(dbValue)) {
					value = value.replace(filter[i], dbValue);
					// value=dbValue;
					if (LOGGER.isDebugEnabled())
						LOGGER.debug("returned value from orgipt map after replacement >> "
								+ value);
					// isReplaced = true;
					// break;
				} else {
					value = value.replace(filter[i], key);
				}
			}else{
				//TODO: Replace value from dev-ant.properties if available else return as it is.

			}

		}
		return value;
	}

	public static VelocityContext getVelocityContext() {

		String[] orgLang = I18nHelper.getOrganizationAndLanguageId(null, null);
		if (orgLang == null) {
			orgLang = new String[] { "", "" };
		}
		return getVelocityContext(orgLang[0]);

	}

	public static VelocityContext getVelocityContext(String orgId) {

		VelocityContext velocityContext = contextMap.get(orgId);
//		if (velocityContext == null) {
//			Map<String, String> m = OrganizationHelper
//					.getOrganizationInformationMap(orgId);
//			velocityContext = new VelocityContext(m);
//			contextMap.put(orgId, velocityContext);
//		}
		return velocityContext;

	}

	/**
	 * TODO - ${} - Is it for all or only selected filtered properties
	 * 
	 * @param value
	 * @return
	 */
	public static String getReplacedValue(String value,
			VelocityContext context, String orgId) {
		try {
			String returnValue = null;
			// VelocityContext context = getVelocityContext();
			if (context != null) {
				VelocityEngine engine = getEngine();
				StringReader reader = new StringReader(value);
				StringWriter writer = new StringWriter();
				engine.evaluate(context, writer, "none", reader);
				returnValue = writer.getBuffer().toString();
			}

			if (LOGGER.isDebugEnabled())
				LOGGER.debug(" >> getReplacedValue(" + value + ") =  >> "
						+ returnValue);
			returnValue = replace(returnValue, orgId);
			if (LOGGER.isDebugEnabled())
				LOGGER.debug(" >> (after orgip replace) getReplacedValue("
						+ value + ") =  >> " + returnValue);
			value = returnValue;
		} catch (Exception e) {
			LOGGER.info("Message :: "+e.toString() +" Cause :: "+e.getCause());
		}
		return value;
	}


	/**
	 * TODO - ${} - Is it for all or only selected filtered properties
	 * 
	 * @param value
	 * @return
	 */
	public static String getReplacedValue(String value) {
		try {
			VelocityContext context = getVelocityContext();
			if (context != null) {
				VelocityEngine engine = getEngine();
				StringReader reader = new StringReader(value);
				StringWriter writer = new StringWriter();
				engine.evaluate(context, writer, "none", reader);
				value = writer.getBuffer().toString();
			}

		} catch (Exception e) {
			LOGGER.info("Message :: "+e.toString() +" Cause :: "+e.getCause());
		}
		return value;
	}

	public void showConfiguration() {
		// TODO implement this method
	}

	public String getUserProfileLogo(String userCode,String userRfNum) {
		String path ="";

		path = getProperty("document.root") +getProperty("profilelogo") + "/" + userCode + "/" + userRfNum;
		return path;
	}
	public String getUserProfileLogoLocation(String userCode,String userRfNum) {
		String path ="";
		path = getProperty("profilelogo") + "/" + userCode + "/" + userRfNum;
		return path;
	}
	public String uploadedProductVideoImage() {
		String path ="";
		path = getProperty("uploadedProductVideoImage");
		return path;
	}

	public String getServiceOutBoundDir() {
		return getProperty("serviceOutBoundDir");
	}

	public String getServiceInBoundDir() {
		return getProperty("serviceInBoundDir");
	}

	public String getDocumentRootDir() {
		return getProperty("document.root");
	}

	public String getprodOutBoundDir() {
		return getProperty("prodOutBoundDir");
	}

	/**
	 * Get the absolute path of mail template
	 * 
	 * @param templateFileName
	 * @return
	 */
	public String getMailTemplateLocation(String templateFileName) {
		String path = getProperty("mail.template.upload.location") + "/"
				+ templateFileName;
		if (new File(path).exists())
			return path;
		else {
			path = new Configuration()
					.getProperty("mail.template.upload.location")
					+ "/"
					+ templateFileName;
			// path = path.replaceAll("\\$orgId", "");
			return new CommonUtils().getApplicationBasePath() + "/" + path;
		}
	}

	/**
	 * Get the absolute path of folder to upload to mail templates.
	 * 
	 * @return
	 */
	public String getMailTemplateUploadLocation() {
		String path = getProperty("mail.template.upload.location");
		if (new File(path).exists())
			return path;
		else {
			path = new Configuration()
					.getProperty("mail.template.upload.location") + "/";
			// path = path.replaceAll("\\$orgId", "");
			return new CommonUtils().getApplicationBasePath() + "/" + path;
		}
	}

	public String getMailServerIP() {
		// TODO Organization
		return getProperty("mailServerIP");
	}

	public String getFromAddress() {
		// TODO Organization
		return getProperty("fromAddress");
	}

	/**
	 * Get the URI for template passed based on the configured template paths
	 * 
	 * @param templateFile
	 * @return
	 */
	public String getTemplateUri(String templateFile) {
		if (templateFile == null)
			return null;
		String baseName = templateFile;
		String path = getProperty("template.target.location") + "/" + baseName;
		if (!isTemplateExist(path)) {
			path = applicationConfiguration
					.getProperty("template.target.location") + "/" + baseName;
			path = path.replaceAll("\\$orgId", "");
		}

		if (!isTemplateExist(path))
			return null;
		return "/" + path;
	}

	/**
	 * Check if the template exist physically in the WEB Application
	 * 
	 * @param templatePath
	 * @return
	 */
	public static boolean isTemplateExist(String templatePath) {
		return new File(new CommonUtils().getApplicationBasePath(),
				templatePath).exists();
	}

	/**
	 * Get the Absoulute path of the folder where template will be uploaded.
	 * 
	 * @param templateFile
	 * @return
	 */
	public String getTemplateUploadPath() {
		return getProperty("template.target.location");
	}

	/**
	 * URL to the DEM Thumbnail the image name
	 * 
	 * @param imageName
	 * @return
	 */
	public String getMediaFile(String mediaFile) {
		if ((mediaFile != null) && ((mediaFile.indexOf("http") != -1))) {
			return mediaFile;
		}
		if (mediaFile!=null && mediaFile.indexOf("/") > 0) {
			return getProperty("baseImagesLocation") + "/" + mediaFile;
		} else {
			return getProperty("baseImagesLocation") + "/"
					+ getProperty("mediaLocation") + "/" + mediaFile;
		}
	}

	public String getRestrictedCataloge() {
		String catalogues = getProperty("restrictedCatalogue");
		return catalogues;
	}

	public String getDefaultCatalogue() {
		String defaultCatalogue = getProperty("defaultCatalogue");
		return defaultCatalogue;
	}

	public String getNoImagePath() {
		return getProperty("baseImagesLocation") + "/"
				+ getProperty("noImageLocation");
	}

	public Object getPageTitle() {
		return getProperty("pageTitle");
	}

	public static String getStaticPath() {
		return new Configuration().getProperty("static.content");
	}
	
	public static String getPsfaCounter() {
		return new Configuration().getProperty("psfsCounter");
	}

	public String resolveImagePath(String imageNamePath) {
		try {
			String resolveImagePathFlag = getProperty("resolveImagePathFlag");
			if ("true".equalsIgnoreCase(resolveImagePathFlag)) {
				String imageServerBasePath = getProperty("imageServerBasePath");
				imageNamePath = imageServerBasePath + "/" + imageNamePath;
				if (!new File(imageNamePath).exists()) {
					imageNamePath = null;
				}
			}
		} catch (Exception e) {
			e.getMessage();
		}
		return imageNamePath;
	}

	/*******
	 * This method is used to return a valid String as per conditions... This
	 * method takes 2 parameters... parameter 1 : referenceNumber need to check
	 * whether valid reference number or not... parameter 2 : this is a boolean
	 * parameter which decide where to append the / before the refence number or
	 * after the refencenumber Basically in case of imageUploadLocation we need
	 * the / before the referenceNumber & in case of imageLocation we need the /
	 * after the referenceNumber
	 ***********************/
	/*****
	 * location : true means method called from getImage(*)Location method...
	 * location : false means method called from image(*)UploadLocation
	 * method...
	 */
	public String getReferenceNumberLocationPath(String referenceNumber,
			boolean location) {
		if (referenceNumber != null && !"".equalsIgnoreCase(referenceNumber)) {
			if (location) {
				return (referenceNumber + "/");// return ("/" +referenceNumber);
			} else {
				return ("/" + referenceNumber);
			}

		} else {
			return "";
		}
		/* return ""; */
	}

	public String getMailConnectionTimeOut() {
		// TODO Organization
		return getProperty("mailConnectionTimeOut");
	}

	public String getTopCategoryRfNum() {
		//String topCategoryRfnum = getProperty("topCategoryRfNum");
		String topCategoryRfnum  = new OrgiptDAO().getOrgIptValueByName("runtime_document.topCategory");

		return topCategoryRfnum;
	}

	/**
	 * This method will return defined path from appconfig table based on
	 * keyparam and orgid
	 * 
	 * @param keyParam
	 * @param OrgId
	 * @return
	 */
	public String getConfiguration(String keyParam, String OrgId) {
		String staticPath = null;
		Appconfig appConfig = null;
		AppconfigDAO configDao = new AppconfigDAO();
		try {
			appConfig = configDao.findAppConfig(keyParam.trim(), OrgId.trim());

			if (appConfig != null && appConfig.getAppip() != null)
				staticPath = "http://" + appConfig.getAppip() + "/"
						+ appConfig.getOrgid();

		} catch (Exception e) {
			LOGGER.info("Message :: "+e.toString() +" Cause :: "+e.getCause());
		}
		return staticPath;
	}

	/**
	 * This method will return orgId if found from request,session,cookies or
	 * system property else return default orgid ie.0
	 * 
	 * @return
	 */
	public String getOrgId() {
		String orgId = "0";
		try {
			String[] orgLang = I18nHelper.getOrganizationAndLanguageId(null,
					null);
			if (orgLang != null && orgLang.length > 0) {
				orgId = orgLang[0];
			}

		} catch (Exception e) {
			LOGGER.info("Message :: "+e.toString() +" Cause :: "+e.getCause());
		}
		return orgId;

	}

	public String getErrorFileSaveLocation(String dynamicpath) {
		String path = getProperty("baseUploadImagesLocation")+"/bulkcsv/"+dynamicpath+"/";
		File file = new File(path);
		if (!file.exists())
			file.mkdirs();
		return path;
	}
	public String getErrorFileDownloadLocation(String dynamicpath) {
		String path = getProperty("baseImagesLocation")+"/bulkcsv/"+dynamicpath+"/";
		return path;
	}
	public String getTempFileUploadLocation(String dynamicpath) {
		Configuration configuration=new Configuration();
		String path = configuration.getProperty("baseUploadImagesLocation")+"/images/TempBulkImageLocation/"+dynamicpath;
		File file = new File(path);
		if (!file.exists())
			file.mkdirs();
		return path;
	}
	public boolean extractFolder(String zipFile,String savingLocation) 
	{
		boolean status=false;
		ZipFile zip = null;
		BufferedOutputStream dest = null;
		try {
			LOGGER.info("Zip file " + zipFile);
			int BUFFER = 2048;
			File file = new File(zipFile);
			zip = new ZipFile(file);
			new File(savingLocation).mkdir();
			Enumeration<? extends ZipEntry> zipFileEntries = zip.entries();

			while (zipFileEntries.hasMoreElements()) {
				ZipEntry entry = (ZipEntry) zipFileEntries.nextElement();
				String currentEntry = entry.getName();
				File destFile = new File(savingLocation, currentEntry);
				File destinationParent = destFile.getParentFile();
				destinationParent.mkdirs();

				if (!entry.isDirectory()) {
					BufferedInputStream is = new BufferedInputStream(zip.getInputStream(entry));
					int currentByte;
					byte data[] = new byte[BUFFER];
					FileOutputStream fos = new FileOutputStream(destFile);
					dest = new BufferedOutputStream(fos,BUFFER);
					while ((currentByte = is.read(data, 0, BUFFER)) != -1) {
						dest.write(data, 0, currentByte);
					}
					dest.flush();
					is.close();
				}
				if (currentEntry.endsWith(".zip")) {
					extractFolder(destFile.getAbsolutePath(),savingLocation);
					System.out.println("File Extraction......");
				}				
			}
			System.out.println("File Extraction......Completed......");
			status=true;			
		} catch (ZipException e) {
			LOGGER.info("Zip Exception");
			LOGGER.info("Message :: "+e.toString() +" Cause :: "+e.getCause());
		} catch (FileNotFoundException e) {
			LOGGER.info("FileNotFoundException");
			LOGGER.info("Message :: "+e.toString() +" Cause :: "+e.getCause());
		} catch (IOException e) {
			LOGGER.info("IOException");
			LOGGER.info("Message :: "+e.toString() +" Cause :: "+e.getCause());
		}finally {
			if(zip != null)
				try {
					zip.close();
				} catch (IOException e) {

				}
			
			if (dest != null) {
				try {
					dest.close();
				} catch (Exception e) {
					LOGGER.error("Message :: "+e.toString() +" Cause :: "+e.getCause());
				}
			}
		}
		return status;
	}
	public boolean deleteZipFolder(String zipfolder)
	{
		boolean status=false;
		System.out.println("deleteZipFolder....................................................."+zipfolder);
		try {	
			File folder = new File(zipfolder);
			if (folder.exists()) {
				folder.delete();
				System.out.println("Finally Deleted .....................................................deleteZipFolder = "+zipfolder);
			}			
			status=true;
		} catch (Exception e) {
			LOGGER.info("Message :: "+e.toString() +" Cause :: "+e.getCause());
		}
		return status;
	}
	public boolean isFileExist(File file){
		if (file.exists()){
			System.out.println("============="+file);
			return true;
		}else{
			return false;
		}
	}

	public static String getSiteName() {
		String orgSiteName = null;
		Map<String,Map<String,String>> orgMap = OrganizationHelper.getOrganizationMap();
		if(orgMap!=null)
		{
			Collection<Map<String, String>> orgInfos = orgMap.values();
			if(orgInfos!=null)
			{
				Iterator<Map<String, String>> iter = orgInfos.iterator();
				while(iter.hasNext()) 
				{
					Map<String, String> element = iter.next();
					//Map element = (Map) iter.next();
					if((""+element.get("orgId")).equalsIgnoreCase("0"))
					{
						orgSiteName = (String) element.get("orgName");
					}
				}
				if(orgSiteName==null)
				{
					orgSiteName = "tisl";
				}
			}
			else
			{
				orgSiteName = "tisl";
			}
		}
		else
		{
			orgSiteName = "tisl";
		}

		return orgSiteName;
	}
	public static String getCopyRightText() {
		// &copy; 2011 Today Merchandise Private Limited. All rights reserved.
		return "&copy;&nbsp;" + java.util.Calendar.getInstance().get(java.util.Calendar.YEAR) + "&nbsp;"+ getCompanyLegalName()+ ".";
	}
	public static String getCompanyLegalName() {
		String orgCompanyLegalName = null;
		Map<String,Map<String,String>> orgMap = OrganizationHelper.getOrganizationMap();
		if(orgMap!=null)
		{
			Collection<Map<String, String>> orgInfos = orgMap.values();
			if(orgInfos!=null)
			{
				Iterator<Map<String, String>> iterator = orgInfos.iterator();
				while(iterator.hasNext()) 
				{
					Map<String, String> element = iterator.next();
					//Map element = (Map) iter.next();
					if((""+element.get("orgId")).equalsIgnoreCase("0"))
					{
						orgCompanyLegalName = (String) element.get("OrgCountryHead");
					}
				}
				if(orgCompanyLegalName==null)
				{
					orgCompanyLegalName = "TODAY MERCHANDISE PRIVATE LIMITED";
				}
			}
			else
			{
				orgCompanyLegalName = "TODAY MERCHANDISE PRIVATE LIMITED";
			}
		}
		else
		{
			orgCompanyLegalName = "TODAY MERCHANDISE PRIVATE LIMITED";
		}

		return orgCompanyLegalName;
	}



	public static String getDomainName() 
	{
		String orgDomain = null;
		Map<String,Map<String,String>> orgMap = OrganizationHelper.getOrganizationMap();
		if(orgMap!=null)
		{
			Collection<Map<String, String>> orgInfos = orgMap.values();
			if(orgInfos!=null)
			{
				Iterator<Map<String, String>> iterator = orgInfos.iterator();
				while(iterator.hasNext()) 
				{
					Map<String, String> element = iterator.next();
					//Map element = (Map) iter.next();
					if((""+element.get("orgId")).equalsIgnoreCase("0"))
					{
						orgDomain = (String) element.get("orgDomainName");
					}
				}
				if(orgDomain==null)
				{
					orgDomain = "tisl.com";
				}
			}
			else
			{
				orgDomain = "tisl.com";
			}
		}
		else
		{
			orgDomain = "tisl.com";
		}

		return orgDomain;
	}

	public String getFileUploadLocation() {
		String path = getProperty("fileUploadLocation");
		return path;
	} 

	public String getfileUploadLocationSlave() {
		String path = getProperty("fileUploadLocationSlave");
		return path;
	} 

	public String getFileCsvLocationSlave() {
		String path = getProperty("fileCsvLocationSlave");
		return path;
	} 
	public String getFileCsvLocationBulkPrice() {
		String path = getProperty("fileUploadLocationPrice");
		return path;
	}
	public String getFileCsvLocationBulkInventory() {
		String path = getProperty("fileUploadLocationInventory");
		return path;
	}

	public String getFileCsvLocationBulkServiceablility() {
		String path = getProperty("fileUploadLocationServiceability");
		return path;
	}

	public String getfileUploadInventoryFlush() {
		String path = getProperty("fileUploadInventoryFlush");
		return path;
	}

	public String getfileUploadLPCatConfig() {
		String path = getProperty("fileUploadLPCatConfig");
		return path;
	}

	public String getFTPLocation() {
		String path = getProperty("ftpFileLocation");
		return path;
	}

	public String getFileUploadLocationSeller() {
		String path = getProperty("fileUploadLocationSeller");
		return path;
	}

	public String getSellerUploadLogoLocation(){
		String path = getProperty("sellerUploadLogo");
		return path;
	}

	public String getSlaveUploadLogoLocation(){
		String path = getProperty("slaveUploadLogo");
		return path;
	}

	public String getProductBulkUploadBaseFileLocation(){
		String path = getProperty("productBulkUploadBaseFileLocation");
		return path;
	}

	public String getShipmentLabelLocation() {
		String path = getProperty("shipmentLabelLocation");
		return path;
	}

	public String getInvoicelLocation() {
		String path = getProperty("invoiceLocation");
		return path;
	}
	
	public String getdelvChallanlLocation() {
		String path = getProperty("delvChallanLocation");
		return path;
	}

	public String getMicrositeBulkUploadLocation() {
		String path = getProperty("micrositeBulkUploadLocation");
		return path;
	}

	public String getMicrositeBulkUploadLocationPcm() {
		String path = getProperty("micrositeBulkUploadLocationpcm");
		return path;
	}

	public String getAWBassignBulkUploadLocation() {
		String path = getProperty("awbAssignBulkUploadLocation");
		return path;
	}

	public String getSchedularEmail() {
		String schedulerEmail = getProperty("schedulerEmail");
		return schedulerEmail;
	}


	public String getfileprintPickList() {
		String path = getProperty("fileprintPickList");
		return path;
	}

	public String getfiledownloadxlsreport() {
		String path = getProperty("filedownloadxlsreport");
		return path;
	}

	public String getDefaltPayoutCycle() {
		String path = getProperty("defaultpayoutcycle");
		return path;
	}

	public String getCourierInboundLocation() {
		String path ="";
		path = getProperty("document.root") + getProperty("courierInboundLocation");
		return path;
	}
	public String getCourierInboundLocation(String userCode,String transactionId) {
		String path ="";
		path = getProperty("courierInboundLocation") + "/" + userCode + "/" + transactionId;
		return path;
	}
	
	public String getFilePrintAckList() {
		String path = getProperty("filePrintAckList");
		return path;
	}

	public String getMarkerImageUrlLocation(){
		String path = getProperty("markerImageURL");
		return path;
	}

	public String getMarkerImageLocation(){
		String path = getProperty("markerImage");
		return path;
	}

	public String getIsReportDisable(){
		String path = getProperty("reportdisable");
		return path;
	}
	public String getIsReportDisableR2(){
		String path = getProperty("reportdisableR2");
		return path;
	}  
	//mahesh LOV crone
	public String getfileProcessLocationLov() {
		String path = getProperty("fileProcessLocationLov");
		return path;
	}

	public String getStateFormLocation() {
		String path = getProperty("stateFormLocation");
		return path;
	}

	public String getReturnToStoreLocation() {
		String path ="";
		path = getProperty("document.root") + getProperty("returnToStoreLocation");
		return path;
	}
	public String getReturnToStoreLocation(String userCode,String transactionId) {
		String path ="";
		path = getProperty("returnToStoreLocation") + "/" + userCode + "/" + transactionId;
		return path;
	}
	public String getPackOrderStatusBulkUploadBaseFileLocation(){
		String path = getProperty("packOrderStatusBulkUploadBaseFileLocation");
		return path;
	}

	public String getCromaBulkUploadBaseFileLocation(){
		String path = getProperty("cromaBulkUploadBaseFileLocation");
		return path;
	}

	public String getQcFailImageFileLocation(){
		String path = getProperty("qcfailImageURL");
		return path;
	} 

	public String getRTSLimit(){
		String path = getProperty("RTSLimit");
		return path;
	}

	public String getRTSEnableSlrCode(){
		String path = getProperty("RTSEnableSlrCode");
		return path;
	}
	//@Suyog,TPR-5454 Start ----------->
	public String getErrorMailID() {
		return getProperty("cromaFailedCancelEmails");
	}
	//@Suyog,TPR-5454 End <-----------

	/*pack load more start*/
	public String getPackMaxRang() {
		String path = getProperty("packmaxrang");
		return path;
	}
	/*pack load more end*/

	public String getManageDeliveryRange() {
		String path = getProperty("manageDeliveryRange");
		return path;
	}

	public String getcourierInboundRange() {
		String path = getProperty("courierInboundRange");
		return path;
	}

	public String getIsGFXAllowed() {
		String path = getProperty("isGFXEnable");
		return path;
	}

	public String getReturnToStoreRange() {
		String path = getProperty("returnToStoreRange");
		return path;
	}

	public String getMobileApiProcessingTimeInMin() {
		String path = getProperty("mobileApiProcessingTimeInMin");
		return path;
	}
	public String getStlpstMismatchUrl() {
		String path = getProperty("stlpstMismatchUrl");
		return path;
	}

	public String getIsStlPstMismatchEnable() {
		String path = getProperty("isStlPstMismatchEnable");
		return path;
	}
	public String getMaxCourierInboundDetails() {
		String path = getProperty("maxCourierInboundDetails");
		return path;
	}

	public String getOpenAgingReportLocation(){
		String path = getProperty("openAgingReportLocation");
		return path;
	}

	public String getOpenAgingReportDaysLimit(){
		String path = getProperty("openAgingReportDaysLimit");
		return path;
	}

	public String getIsTaskSchedulerEnable(){
		String path = getProperty("isTaskSchedulerEnable");
		return path;
	}

	public String getIsHiberInterSqlAnalysisEnable(){
		String path = getProperty("isHiberInterSqlAnalysisEnable");
		return path;
	}

	public String getFileCsvLocationErQcPending() {
		String path = getProperty("fileUploadLocationErQcPeinding");
		return path;
	}
	public String getFileLocationForReturnPickUpDelivered() {
		String path = getProperty("fileLocationForReturnPickUpDelivered");
		return path;
	}
	public String getDLShipmentSellerName() {
		String path = getProperty("DLShipmentSellerName");
		return path;
	}
	//@Rohit Start::: (TPR-8895) Delhivery SUR logic for split AC
	public String getMultiAwbCatCode() {
		String path = getProperty("multiAwbCatCode");
		return path;
	}
	
	public String getMultiAwbCatCode(String lpCode) {
		String path = getProperty(lpCode+".multiAwbCatCode");
		return path;
	}
	
	//@Rohit End::: (TPR-8895) Delhivery SUR logic for split AC
	//@Nishant for return journey
	public String getFileLocationForReturnPickUpDownloadDelivered() {
		String path = getProperty("fileLocationForReturnPickUpDownloadDelivered");
		return path;
	}

	public String getPathForXLSPriceInv() {
		String path = getProperty("priceInvXSLPath");
		return path;
	}
	//TPR-8570 Price and Inventory Module Start
	public String getatsSolrEnable() {
		String isEnabled = getProperty("atsSolrEnable");
		return isEnabled;
	}
	//TPR-8570 Price and Inventory Module End

	//@Rohit Start ::: TPR-8560 :: Digitizing Seller Agreement
	public String getDigitalAgreementPath() {
		String path = getProperty("digitalAgreementPath");
		return path;
	}
	//@Rohit End ::: TPR-8560 :: Digitizing Seller Agreement
	//@Nikhil.S
	public String getAdharMobileNo() {
		String path = getProperty("adharMobileno");
		return path;
	}

	public String getDigitalFeePath() {
		return(getProperty("digitalFeePath"));

	}

	public String getDigitalFileUploadLocation() {
		return(getProperty("digitalHTMLLocation"));

	}
	public String getMaskSalesReport() {
		return(getProperty("maskSalesReport"));

	}
	public String getMaskOrderStatusReport() {
		return(getProperty("maskOrderStatusReport"));

	}
	public String getMaskCustomerDataReport (){
		return(getProperty("maskCustomerDataReport"));

	}

	//@Rohit Start TPR-1083 Trent EOSS | Bulk Sales order posting
	public String getFileLocationForTrentUpload() {
		return(getProperty("fileLocationForTrentUpload"));

	}
	//@Rohit End TPR-1083 Trent EOSS | Bulk Sales order posting

	//@Rohit Start TPR-11567 ::: Change in RETURN FLOW - CROMA
	public String getLocalInboundLoc() {
		return(getProperty("localInbound"));
	}
	//@Rohit End TPR-11567 ::: Change in RETURN FLOW - CROMA
	//@Nishant start for Narvar
	public String getMyOrder (){
		String path = getProperty("myOrder");
		return path;
	}
	public String getTatacliqURL (){
		String path = getProperty("myOrder");
		return path;
	}
	public String getIsNarvar (){
		String path = getProperty("isNarvar");
		return path;
	}
	public String getMyOrderLux (){
		String path = getProperty("myOrderLux");
		return path;
	}
	public String getTatacliqURLLux (){
		String path = getProperty("myOrderLux");
		return path;
	}
	public String getSellerRatingLoc() {
		String path = getProperty("sellerRatingPdf");
		return path;
	}
	//@Nishant End for Narvar

	//hemant Start
	public String getFileLocationForSarwoskiReport() {
		return(getProperty("fileLocationForSarwoskiReport"));
	}
	//Hemant End
	//Nishant start
	public String getRowCount() {
		String path = getProperty("rowCount");
		return path;
	}

	public String getFileUploadLocationPenalties() {
		String path = getProperty("fileUploadLocationPenalties");
		return path;
	}

	//Nishant end
	public String getCessMasterSetup() {
		String path = getProperty("CessMasterSetup");
		return path;
	}
	//hemant :Start
	public String getfileProcessLocationRichAttr() {
		String path = getProperty("fileProcessLocationPCMAttr");
		return path;
	}
	//hemant

	//Nishant start
	public String getZeroCommMail() {
		String path = getProperty("zeroCommMail");
		return path;
	}
	//Nishant end 
	public String getOrderRejectPenaltyFlag() { //Nishant added for zero inentory
		String path = getProperty("orderRejectPenaltyFlag");
		return path;
	}
	public String getZeroInventoryFlag() { //Nishant added for zero inentory
		String path = getProperty("zeroInventoryFlag");
		return path;
	}
	public String getESignServerUrl() { //Nishant added for pdf sign
		String path = getProperty("eSignServerUrl");
		return path;
	}
	public String getDownloadESignPdfFlag() { //Nishant added for pdf sign
		String path = getProperty("downloadESignPdfFlag");
		return path;
	}
	public String getESignSerialNo() { //Nishant added for pdf sign
		String path = getProperty("eSignSerialNo");
		return path;
	}
	public String getAddressForRetunShip() { //Amar added 
		String path = getProperty("addressForRetunShip");
		return path;
	}
	public String getAddressForQCpendingReminder() { //Amar added 
		String path = getProperty("addressForQCpendingReminder");
		return path;
	}
	public String getAddressForAutoQCclosed() { //Amar added 
		String path = getProperty("addressForAutoQCclosed");
		return path;
	}
	public String getAddressForDisputestatus() { //Amar added 
		String path = getProperty("addressForDisputestatus");
		return path;
	}
	public String getAddressForDisputeReason() { //Amar added 
		String path = getProperty("addressForDisputeReason");
		return path;
	}
	
	public String getEssentialCatCode() {//essential
		String path ="";
		try{
			path = getProperty("essentialcatcode");
		}catch(Exception e){
			e.printStackTrace();
		}
		return path;
	}	
	
	public String getEssentialShipmentSellerName() {
		String path = getProperty("EssentialShipmentSellerName");
		return path;
	}
	
	public String getQcstatuspath() {
		String path = getProperty("Qcstatuspath");
		return path;
	}
	
	public String getPathForXLSCommissionRev() {
		String path = getProperty("commissionRevXSLPath");
		return path;
	}
	public String getPathForApproval() {
		String path = getProperty("commissionApproval");
		return path;
	}
	
	public String getPathForXLSCommissionRevFees() {
		String path = getProperty("commissionRevXSLPathFees");
		return path;
	}
	
	public String getPathForXLSCommissionRevPenalty() {
		String path = getProperty("commissionRevXSLPathPenalty");
		return path;
	}
	
	public String getPenaltyOrderdelayedCutoff1() {
		String path = getProperty("Penalty.Order.delayed.Cutoff.1");
		return path;
	}
	
	public String getPenaltyOrderdelayedCutoff2() {
		String path = getProperty("Penalty.Order.delayed.Cutoff.2");
		return path;
	}
	
	public String getPenaltyOrderdelayedCutoff3() {
		String path = getProperty("Penalty.Order.delayed.Cutoff.3");
		return path;
	}
	
	public String getPenaltyOrderdelayedCutoff4() {
		String path = getProperty("Penalty.Order.delayed.Cutoff.4");
		return path;
	}
	
	public String getPenatlyExceptionalPath() {
		String path = getProperty("penaltyExceptionPath");
		return path;
	}
	
	public String getFileUploadLocationAutoQCPass() {
		String path = getProperty("fileUploadLocationAutoQCPass");
		return path;
	}

	public int getAutoQCPassClosureDays() {
		int autoQCPassClosureDays = Integer.parseInt(getProperty("autoQCPassClosureDays"));
		return autoQCPassClosureDays;
	}
	
}