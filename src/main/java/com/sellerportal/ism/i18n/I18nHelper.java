package com.sellerportal.ism.i18n;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Locale;
import java.util.MissingResourceException;
import java.util.Properties;
import java.util.ResourceBundle;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sellerportal.model.Ismart;
import com.sellerportal.dao.IsmartDAO;
import com.sellerportal.model.Ismgat;
import com.sellerportal.dao.IsmgatDAO;
import com.anm.jsf.utils.MessageFactory;
import com.anm.utils.CommonUtils;

@Component
public class I18nHelper {
	private static final Log LOGGER = LogFactory.getLog("I18nHelper");

	public static String DEFAULT_LOCALE = "en_US";

	public static String PARAM_LANG_CODE = "lang"; // Value should be language
	// code eg en/fr

	public static String PARAM_ORG_ID = "orgId"; // PK of ISMGOT

	public static String SCOPE_PREFIX = "com.anm.octashop.";
	
	@Autowired
	HttpServletRequest request;

	/**
	 * Utility method to load the resource bundle from
	 * <code>resource/<lang>/pageName.properties relative to 
	 * @param request
	 * @param pageName
	 * @return
	 */
	public static Properties loadBundle(HttpServletRequest request,
			String pageName) {
		String []arr = getOrganizationAndLanguageId(request, null);
		return loadBundle(request,arr[1]+"_"+arr[0], pageName);
	}

	/**
	 * 
	 * @param request
	 * @return
	 */
	public static String getLanguageCode(HttpServletRequest request) {

		String languageCode = null;

		String[] organizationAndLanguageId = getOrganizationAndLanguageId(
				request, null);
		if(organizationAndLanguageId != null && organizationAndLanguageId.length > 1)
			languageCode = organizationAndLanguageId[1];
		
		return languageCode;
	}

	/**
	 * 
	 * @param request
	 * @return
	 */
	public static String getOrganizationId(HttpServletRequest request) {

		String orgId = null;

		String[] organizationAndLanguageId = getOrganizationAndLanguageId(
				request, null);
		if(organizationAndLanguageId != null && organizationAndLanguageId.length > 0)
			orgId = organizationAndLanguageId[0];
		return orgId;
	}

	/**
	 * Organization ID strategy [1] get from the request parameter - web [2] get
	 * from session - web [3] get from the cookies - web [3] get from System
	 * properties - for standalone programs
	 * 
	 * @param request
	 *            String[] 0=orgId 1=langCode
	 */
	public static String[] getOrganizationAndLanguageId(
			HttpServletRequest request, HttpServletResponse response) {
		
		String[] retValue = new String[2];
		String langCode = null;
		String orgId = null;
		if(FacesContext.getCurrentInstance() != null && request == null)
		{
			request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
			//response = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
		}
		if (request != null) {
			// 1 try from request parameters
			if (LOGGER.isDebugEnabled())
				LOGGER
						.debug(" <<WEB>> Finding orgId/langCode in request parameters :: ");
			if(StringUtils.isBlank(langCode))
			langCode = request.getParameter(PARAM_LANG_CODE);
			
			if(StringUtils.isBlank(orgId))
			orgId = request.getParameter(PARAM_ORG_ID);
			
			if (langCode == null || orgId == null
					|| langCode.trim().length() == 0
					|| orgId.trim().length() == 0
					|| langCode.equalsIgnoreCase("null")
					|| orgId.equalsIgnoreCase("null")) {
				// 2 try from the session
				if (LOGGER.isDebugEnabled())
					LOGGER
							.debug(" <<WEB>> Finding orgId/langCode in session :: ");
				if(request.getSession() != null) {
					
					if(StringUtils.isBlank(langCode))
				    langCode = (String) request.getSession().getAttribute(
						SCOPE_PREFIX + PARAM_LANG_CODE);
					
					if(StringUtils.isBlank(orgId))
				    orgId = (String) request.getSession().getAttribute(
						SCOPE_PREFIX + PARAM_ORG_ID);
				}
				if (langCode == null || orgId == null
						|| langCode.trim().length() == 0
						|| orgId.trim().length() == 0
						|| langCode.equalsIgnoreCase("null")
						|| orgId.equalsIgnoreCase("null")) {
					if (LOGGER.isDebugEnabled())
						LOGGER
								.debug(" <<WEB>> Finding orgId/langCode in Cookies :: ");
					// 3 try from the cookies
					Cookie[] cookies = request.getCookies();
					if (cookies != null) {
						for (int i = 0; i < cookies.length; i++) {
							if (cookies[i].getName().equals(
									SCOPE_PREFIX + PARAM_LANG_CODE)) {
								if(StringUtils.isBlank(langCode))	
								langCode = cookies[i].getValue();
							}

							if (cookies[i].getName().equals(
									SCOPE_PREFIX + PARAM_ORG_ID)) {
								if(StringUtils.isBlank(orgId))
								orgId = cookies[i].getValue();
							}
						}
					}
				}
			}else {
				//orgId and langCode found in request - Great
			}

			// Web case
		} else {
			// if(LOGGER.isInfoEnabled())
			// LOGGER.info("getOrganizationAndLanguageId:: STANDALONE : Retrieve
			// from System properties");
			langCode = System.getProperty(PARAM_LANG_CODE);
			orgId = System.getProperty(PARAM_ORG_ID);

		}
		
		
		if (langCode == null ||  langCode.trim().length() == 0 || langCode.trim().equalsIgnoreCase("null")  )
			langCode = "en";

		if (orgId != null && orgId.trim().length() > 0 && !orgId.trim().equalsIgnoreCase("null")) {
			retValue[0] = orgId.trim();
			retValue[1] = langCode.trim();
			
			System.setProperty(PARAM_LANG_CODE,langCode.trim());
			System.setProperty(PARAM_ORG_ID,orgId.trim());
					
		} else {
			//LOGGER.warn("org and language not SET. Now going to retrieve on the basis of domain name");
			/*
			 * LOGGER .warn(" ! Using system default values for langId = 0,
			 * orgId = 0"); retValue[0] = "0"; retValue[1] = "en";
			 */
		}

		return retValue;

	}

	/**
	 * This method should be used to populate the orgId/langCode into the
	 * appropriate place
	 * 
	 * @param orgId
	 * @param langCode
	 * @param request
	 * @param response
	 */
	public static void setOrganizationAndLanguage(String orgId,
			String langCode, HttpServletRequest request,
			HttpServletResponse response) {
		if (request != null && response != null) {
			if (orgId != null && langCode != null
					&& langCode.trim().length() > 0
					&& orgId.trim().length() > 0
					&& !orgId.equalsIgnoreCase("null")
					&& !langCode.equalsIgnoreCase("null")) {
				request.getSession().setAttribute(
						SCOPE_PREFIX + PARAM_LANG_CODE, langCode);
				request.getSession().setAttribute(SCOPE_PREFIX + PARAM_ORG_ID,
						orgId);
				response.addCookie(new Cookie(SCOPE_PREFIX + PARAM_LANG_CODE,
						langCode));
				response.addCookie(new Cookie(SCOPE_PREFIX + PARAM_ORG_ID,
						orgId));

				System.setProperty(PARAM_LANG_CODE, langCode);
				System.setProperty(PARAM_ORG_ID, orgId);

			}
		}
	}

	/**
	 * Utility method to load the resource bundle from
	 * <code>resource/<lang>/pageName.properties relative to 
	 * @param request
	 * @param pageName
	 * @return
	 */
	public static Properties loadBundle(HttpServletRequest request,
			String locale, String pageName) {
		Properties bundle = loadBundleInternal(request, locale, pageName);
		if (bundle == null) {
			// LOGGER.warn(pageName + " does not support " + locale+ ". Trying
			// the default locale " + DEFAULT_LOCALE);
			bundle = loadBundleInternal(request, null, pageName);

		}

		int k = pageName.lastIndexOf('.');
		if (k > 0)
			pageName = pageName.substring(0, k);

		request.setAttribute(pageName, bundle);

		return bundle;
	}

	public static Properties loadBundleInternal(HttpServletRequest request,
			String locale, String pageName) {

		String country = "US";
		String lang = "en";
		Properties bundle = null;
		Locale localeObj = Locale.getDefault();
		if(locale == null || locale.trim().length() == 0)
			locale = "en_US";
		
		if (locale.indexOf("_") > 0) {
			lang = locale.substring(0, locale.indexOf("_"));
			country = locale.substring(locale.indexOf("_") + 1).trim();
			localeObj = new Locale(lang,country);
		} else {
			lang = locale.trim();
			localeObj = new Locale(lang);
		}

		int k = pageName.lastIndexOf('.');
		if (k > 0)
			pageName = pageName.substring(0, k);
		
		
		ResourceBundle b = null;
		try {
			b = ResourceBundle.getBundle("resources."+pageName,localeObj,ResourceBundle.Control.getControl(ResourceBundle.Control.FORMAT_DEFAULT));
		}catch(MissingResourceException e) {
			
		}
			
		if(b != null)
		{		
			//if(LOGGER.isInfoEnabled())
				//LOGGER.info(" Resource Bundle Loaded : "+b.toString());
			return new PropertiesResourceBundle(b);
		}else {
			

			String resourcePath = "resources/" + pageName + "_" + lang + "_"
					+ country + ".properties";

			bundle = loadResource(request, resourcePath);

			if (bundle == null) {
				resourcePath = "resources/" + pageName + "_" + lang + ".properties";
				bundle = loadResource(request, resourcePath);
				if(LOGGER.isInfoEnabled())
					LOGGER.info(pageName + " resource bundle does not exist");
			}

			if (bundle == null) {
				resourcePath = "resources/" + pageName + ".properties";
				bundle = loadResource(request, resourcePath);
			}

			if (bundle == null) {
				// LOGGER.warn(pageName + " resource bundle does not exist");
			}

			return bundle;
		}

	}

	/**
	 * Method to load any property file in application server independent way
	 * 
	 * @param request
	 * @param resoucePath
	 * @return
	 */
	public static Properties loadResource(String resoucePath) {
		if (FacesContext.getCurrentInstance() != null) {
			HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
			return loadResource(request, resoucePath);
		} else {
			return loadResource(null, resoucePath);
		}
	}

	/**
	 * Method to load any property file in application server independent way
	 * 
	 * @param request
	 * @param resoucePath
	 * @return
	 */
	public static Properties loadResource(HttpServletRequest request,
			String resoucePath) {
		Properties configuration = null;
		InputStream ins = null;

		try {
			// We are running inside WAR
			File file = new File(resoucePath);
			if (request != null && !file.isAbsolute())
				file = new File(new CommonUtils().getApplicationBasePath()+"/WEB-INF/classes/"+ resoucePath);

			/*if (file != null && file.exists())
				ins = new FileInputStream(file);
			else {
				ins = Thread.currentThread().getContextClassLoader().getResourceAsStream(resoucePath);
			}*/
			ins = Thread.currentThread().getContextClassLoader().getResourceAsStream(resoucePath);
			if (ins != null) 
			{
				ins = new BufferedInputStream(ins);
				configuration = new Properties();
				configuration.load(ins);
				ins.close();
				LOGGER.info(resoucePath);
			} else {
				// LOGGER.warn(resoucePath + " not loaded");
			}

		} catch (FileNotFoundException e) {
			LOGGER.error("FileNotFoundException" + resoucePath + " ["
					+ e.getMessage() + "]");
		} catch (IOException e) {
			LOGGER.error("IOException" + resoucePath + " [" + e.getMessage()
					+ "]");
		}
		return configuration;
	}

	public static String getDomainName(HttpServletRequest request) {
		
		String domainName=request.getServerName();
		
		if(domainName !=null && domainName.contains("www")) {
			int index=domainName.indexOf(".");
		if(index > 0){
			domainName=domainName.substring(index+1);
		}
		
		}
		
		return domainName;
	}

	public static StringBuffer getRequestURL(HttpServletRequest req) {
		StringBuffer url = new StringBuffer();
		String scheme = req.getScheme();
		int port = req.getServerPort();
		String urlPath = req.getRequestURI();

		// String servletPath = req.getServletPath ();
		// String pathInfo = req.getPathInfo ();

		url.append(scheme); // http, https
		url.append("://");
		url.append(req.getServerName());
		if ((scheme.equals("http") && port != 80)
				|| (scheme.equals("https") && port != 443)) {
			url.append(':');
			url.append(req.getServerPort());
		}

		url.append(urlPath);
		if (req.getQueryString() != null) {
			url.append("?");
			// remove orgId and lang if present in url
			url = removeOrganizationAndLanguage(url.toString());
			url.append(req.getQueryString());
		}

		return url;
	}

	public static StringBuffer removeOrganizationAndLanguage(String url) {

		String queryString[] = url.split("[{?}]");
		if (queryString.length > 1) {
			String queryParameters[] = queryString[1].split("[{&}]");

			for (int i = 0; i < queryParameters.length; i++) {

				if (queryParameters[i].contains("orgId")
						|| queryParameters[i].contains("lang")) {

					queryString[1] = queryString[1].replaceAll("&"
							+ queryParameters[i], "");
					queryString[1] = queryString[1].replaceAll(
							queryParameters[i], "");
				}
			}

			if (queryString[1].equals("")) {
				url = queryString[0];

			}
			if (!queryString[1].equals("")) {

				if (queryString[1].charAt(0) == '&') {
					queryString[1] = queryString[1].substring(1, queryString[1]
							.length());
				}
				url = queryString[0] + "?" + queryString[1];
			}
		}

		return new StringBuffer(url);
	}
	/***************************************************************************
	 * Below method is written to check the logged user is global admin or not.
	 * If he is global admin then dont do Authentication and Authorization in
	 * security filter. Else continue as usual.
	 **************************************************************************/
	public static boolean isRootAdmin(HttpServletRequest request, HashMap param) {

		boolean isRootAdmin = false;
		String orgid = "1";
		String loginid = "superadmin";
		String password = "superadmin";

		if (loginid != null && !"".equalsIgnoreCase(loginid)
				&& password != null && !"".equalsIgnoreCase(password)) {
			Ismgat ismgat = new IsmgatDAO().checkAdminValidLogin(loginid,
					password);
			if (ismgat != null) {

				String isRoot = ismgat.getRoot();
				String isAdmin = ismgat.getIsadmin();

				if ("Y".equalsIgnoreCase(isRoot)) {
					request.setAttribute("rootadmin", "true");
					isRootAdmin = true;
				}

				if ("Y".equalsIgnoreCase(isAdmin)) {
					Ismart ismart = new IsmartDAO().findByOrgIdAndGatrfnum(
							new Long(orgid), ismgat.getGatrfnum());
					if (ismart != null) {
						request.setAttribute("rootadmin", "true");
						isRootAdmin = true;
					}
				}
			}
		}

		return isRootAdmin;
	}
	
	/**
	 * Below method retuns the value for key passed from
	 * property file
	 * 
	 */
	public FacesMessage getMessage(String key,Object params[]){
		
		FacesMessage msg = null;
		
			Locale locale = (Locale)request.getAttribute("locale");
			if(params != null){
				msg = MessageFactory.getMessage(locale,key,params);
			}else{
				msg = MessageFactory.getMessage(locale,key,null);
			}
		
		return msg;
	}
	
	 

}
