package com.sellerportal.ism;

import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Query;
import org.hibernate.Session;

import com.sellerportal.model.Orgipt;
import com.sellerportal.ism.i18n.OrganizationHelper;
import com.sellerportal.ism.i18n.core.sqlparser.MultilanguageHelper;

public class AppConfigHelper {

	private static final Log LOGGER = LogFactory.getLog(AppConfigHelper.class);
	private static final String prefix = "runtime";

	// Map containing the cached information for appconfig key=appName value=Map
	private static Map<String, String> appConfigCache = Collections.synchronizedMap(new HashMap<String, String>());
	
	/*static {
		AppConfigHelper.initAppConfig();
	}*/

	public static void reloadAppConfig() {
		synchronized (appConfigCache) {
			appConfigCache.clear();
			initAppConfig();
		}
	}

	public static void initAppConfig() {
		LOGGER.info("+ initAppConfig :: START");
		Session session = null;
		try {
			String hql = "from Orgipt ipt ";
			Map<String, Map<String, String>> organizationMap = OrganizationHelper.getOrganizationMap();
			session = MultilanguageHelper.openPlainSession();
			Query query = session.createQuery(hql);
			List list = query.list();
			
			Iterator<Entry<String, Map<String, String>>> iterator = organizationMap.entrySet().iterator();
			while(iterator.hasNext())
			{
				Entry<String, Map<String, String>> oEntry = iterator.next();
				String orgId = oEntry.getKey();
				
				if (list != null && list.size() > 0) {					
					LOGGER.info("<"+orgId+"> Total appConfiguration ::" + list.size() );
					for (Iterator iter = list.iterator(); iter.hasNext();) {
						Orgipt ipt = (Orgipt) iter.next();
						String iptname = ipt.getIptname();
						iptname = iptname.toLowerCase().trim();
						if(iptname.startsWith("runtime_"))
						{
							String key = orgId +"/"+ ipt.getIptname().trim();
							appConfigCache.put(key, ipt.getIptvalue().trim());
						}
					}
				}

			}
			
			LOGGER.info(appConfigCache);
			
			
		} catch (Exception e) {
			LOGGER.error("initAppConfig from Appconfig) :: EXCEPTION ::"
					+ e.getMessage());
			appConfigCache = null;
		} finally {
			if (session != null) {
				try {
					session.close();
				} catch (Exception e) {
				}

			}
		}
		LOGGER.info("initOrganizations :: DONE");
	}

	public static String getValueFromDB(String orgId,String appkey) {
		String value = null;
		
		String key = orgId+"/"+"runtime_"+appkey;
		key = key.trim();
		if (appConfigCache != null && StringUtils.isNotBlank(appkey)) {
			value = appConfigCache.get(key);
		}else {
			LOGGER.warn("! (unexpected) getValueFromDB("+orgId+","+appkey+") - ");
			
			synchronized(AppConfigHelper.class)
			{
				if(appConfigCache == null)
					initAppConfig();
				if(appConfigCache != null)
					value = appConfigCache.get(key);					
			}
		}
		
		if(LOGGER.isDebugEnabled())
			LOGGER.debug("getValueFromDB(["+orgId+"],["+appkey+"]) - "+value);
		return value;
	}
	
	public static void clear()
	{
		appConfigCache.clear();
		
	}

	

}
