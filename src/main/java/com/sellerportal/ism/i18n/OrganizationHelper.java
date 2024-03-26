package com.sellerportal.ism.i18n;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Query;
import org.hibernate.Session;

import com.sellerportal.model.Ismgot;
import com.sellerportal.ism.i18n.core.sqlparser.MultilanguageHelper;

/**
 * Helper class which encapsulate Organization Related Functionality
 * @author octashop
 *
 */
public class OrganizationHelper implements OrganizationConstants {
	private static final Log LOGGER = LogFactory.getLog(OrganizationHelper.class);
	
	//Constant
	public static final String PARAM_ORG_INFO_MAP = "com.anm.organization.map";
	
	//Map containing the cached information for organizations key=orgId value=Map
	private static Map<String,Map<String,String>> orgCache =  new HashMap<String,Map<String,String>>();
	
	/*static {
		initOrganizations();
	}*/
	
	private static HashMap<String, String> prepareOrganizationInformationMap(Ismgot ismgot)
	{
		HashMap<String, String> m = new HashMap<String, String>();
		if(ismgot != null) {
			m.put(ORG_ID, ismgot.getGotrfnum()+"");
			m.put(DOMAIN_NAME, ismgot.getGotdomain());
			m.put(CITY, ismgot.getCityname());
			m.put(COUNTRY, ismgot.getCountrycode());
			m.put(ORGANIZATION_CODE, ismgot.getGotorgcode());
			m.put(CURRENCY, ismgot.getGotcurrency());
			m.put(ORGANIZATION_NAME, ismgot.getGotorgname());
			m.put(LANG_CODE, ismgot.getIsmglt().getGltcode());
			m.put(LANG_DESC, ismgot.getIsmglt().getGltdesc());
			m.put(ADDRESS, ismgot.getGotheadofficeaddress());
		}
		return m;
	}
	
	//Should be callled from the cache manager page which should have links to reload organization cache, reload appConfig cache etc
	public static void reloadOrganizations()
	{
		synchronized(OrganizationHelper.class)
		{
			orgCache.clear();
			initOrganizations();
		}
	}
	
	public static void initOrganizations()
	{
		LOGGER.info("+ initOrganizations :: START");
		Session session = null;
		try {
			String hql = "from Ismgot got left join fetch got.ismglt ";
			session = MultilanguageHelper.openPlainSession();
			Query query = session.createQuery(hql);
			List list = query.list();
			if(list != null && list.size() > 0)
			{
				LOGGER.info("+ Total organizations ::"+list.size());
				for (Iterator iter = list.iterator(); iter.hasNext();) {
					Ismgot got = (Ismgot) iter.next();
					HashMap<String, String> orgInfoMap = prepareOrganizationInformationMap(got);
					orgCache.put(got.getGotrfnum()+"",orgInfoMap);
				}
			}
			
		}catch(Exception e) {
			LOGGER.error("findAllOrganizations() :: EXCEPTION ::"+e.getMessage());
			orgCache = null; //clear the the map so that it can be rebuilt if needed
		}finally {
			if(session != null) {
				try {
					session.close();
				}catch(Exception e) {}
				
			}
		}
		LOGGER.info("initOrganizations :: DONE");
	}
	
	@SuppressWarnings("squid:S2201")
	//graceful reloading of organization map in case of emergency scenarios
	public static  Map<String, String> getOrganizationInformationMap(String orgId)
	{
		if(orgCache != null && orgId != null)
		{
			return orgCache.get(orgId);
		}else {
			//Don't expect, but in case of some exceptional cases like database get restarted
			synchronized(OrganizationHelper.class)
			{
				if(orgCache == null)
					initOrganizations();
				
				if(orgCache != null)
					orgCache.get(orgId);
			}
			
		}
		return null;
	}
	
	public static Map<String, String> getOrganizationByDomain(String domainName) {
		if(orgCache !=null)
		{
		Collection<Map<String, String>> orgInfos = orgCache.values();
		for (Iterator iter = orgInfos.iterator(); iter.hasNext();) {
			Map element = (Map) iter.next();
			String orgDomain = (String) element.get(DOMAIN_NAME);
			if(orgDomain != null && orgDomain.length()>0)
			{
				if(orgDomain.trim().equalsIgnoreCase(domainName.trim()))
					return element;
			}
		}
		}else
		{
			synchronized(OrganizationHelper.class)
			{
				if(orgCache == null)
					initOrganizations();
			}	
		}
		return null;
	}

	/*public static Map<String, String> findOrganizationByOrgId(String orgId) {
		Collection<Map<String, String>> orgInfos = orgCache.values();
		for (Iterator iter = orgInfos.iterator(); iter.hasNext();) {
			Map element = (Map) iter.next();
			String oid = (String) element.get(ORG_ID);
			if(oid != null && oid.length()>0)
			{
				if(oid.trim().equalsIgnoreCase(orgId.trim()))
					return element;
			}
		}
		return null;
		
	}*/
	
	
	public static Map<String, String> findOrganizationByOrgId(String orgId) {
		
		if(orgCache!=null)
		{
		Collection<Map<String, String>> orgInfos = orgCache.values();
		for (Iterator iter = orgInfos.iterator(); iter.hasNext();) {
			Map element = (Map) iter.next();
			String oid = (String) element.get(ORG_ID);
			if(oid != null && oid.length()>0)
			{
				if(oid.trim().equalsIgnoreCase(orgId.trim()))
					return element;
			}
		}
		}else{
			synchronized(OrganizationHelper.class)
			{
				if(orgCache == null)
					initOrganizations();
			}
			
		}
		return null;
		
	}
	
	public static String[]  getOrgIdByDomainName(String domainName)
	{
		String[] orgLangArray = new String[2];
		Session session = null;
		try {
			String hql = "from Ismgot got left join fetch got.ismglt where got.gotdomain='"+domainName.trim()+"'" ;
			session = MultilanguageHelper.openPlainSession();
			Query query = session.createQuery(hql);
			List list = query.list();
			if(list != null && list.size() > 0)
			{
				LOGGER.info("+ Total organizations ::"+list.size());
				for (Iterator iter = list.iterator(); iter.hasNext();) {
					Ismgot got = (Ismgot) iter.next();
					orgLangArray[0]=got.getGotrfnum()+"";
					orgLangArray[1]=got.getIsmglt().getGltcode();
			
				}
			}
			
		}catch(Exception e) {
			LOGGER.info("Message :: "+e.toString() +" Cause :: "+e.getCause());
		}finally {
			if(session != null) {
				try {
					session.close();
				}catch(Exception e) {}
				
			}
		}
		LOGGER.info("initOrganizations :: DONE");
		return orgLangArray;
	}
	
	
	public static  Map<String,Map<String,String>> getOrganizationMap()
	{
		if(orgCache != null)
		{
			//return orgCache;
			;
		}else {
			synchronized(OrganizationHelper.class)
			{
				if(orgCache == null)
					initOrganizations();
			}
		}
		return orgCache;
	}

	
	public static void clear()
	{
		orgCache.clear();	
	}

}
