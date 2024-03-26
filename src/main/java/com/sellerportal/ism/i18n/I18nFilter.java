package com.sellerportal.ism.i18n;

import java.io.File;
import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.faces.FacesException;
import javax.faces.FactoryFinder;
import javax.faces.context.FacesContext;
import javax.faces.context.FacesContextFactory;
import javax.faces.lifecycle.Lifecycle;
import javax.faces.lifecycle.LifecycleFactory;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.jdbc.Work;
import org.hibernate.stat.Statistics;

import com.sellerportal.custom.logging.CustomLogger;
import com.anm.hibernate.HibernateConnection;
import com.sellerportal.integra.impl.octashop.utils.OctashopUtils;
import com.sellerportal.ism.SessionVariablesBean;
import com.sellerportal.dao.StatelessSessionDAO;
import com.sellerportal.ism.i18n.core.sqlparser.MultilanguageHelper;
import com.sellerportal.ism.search.lucene.indexing.JdbcConnection;
import com.anm.security.DefaultAuthorizer;
/**
 * Localaziation Filter : Handle the initialization of the organization and
 * language for all requests (dynamic)
 * 
 * This filter should be after the SecurityFilter/UrlRewriteFilter in the chain
 * otherwise might fail
 * 
 * 
 * 
 * @author ritesh.singh@anmsoft.com
 **/
public class I18nFilter implements Filter {
	public static final String LIFECYCLE_ID_ATTR = "javax.faces.LIFECYCLE_ID";
	public static final String LANG_CODE = "lang";
	public static final String ORG_ID = "orgId";
	public static final String DEFAULT_ORGID="0";
	public static final String DEFAULT_LANGCODE="en";
	public static final String DEFAULT_ORG_NAME="India";
	private static final Log LOGGER = LogFactory.getLog(I18nFilter.class);

	private static String PARAM_DO_REDIRECT = "qwaszx";
	private static String PARAM_INIT_TARGET_MAPPINGS = "targetMappings";
	public static String REQUEST_PARAM_DATAMAP = "REQUEST_PARAM_DATAMAP";
	private static Map<String, String> redirectTargetMap = new HashMap<String, String>();

	public static Map<String, String> userSessionMap = new HashMap<String, String>();
	
	private ServletContext servletConfig = null;

	private boolean isEnabled = true;

	private FacesContextFactory facesContextFactory = null;
	private Lifecycle lifecycle = null;
	public static final ThreadLocal userThreadLocal = new ThreadLocal();

	private int uploadMaxFileSize = 1 * 1024 * 1024; //1MB
	private int uploadThresholdSize = 1 * 512 * 1024; //512 KB
	private String uploadRepositoryPath = "/tmp";
		   
	public void init(FilterConfig filterConfig) throws ServletException {
		if (LOGGER.isInfoEnabled())
			LOGGER.info("init () test");
		
		 HibernateConnection.getSessionFactory().getStatistics().setStatisticsEnabled(true);
		
		 this.uploadMaxFileSize = resolveSize(filterConfig.getInitParameter("uploadMaxFileSize"), this.uploadMaxFileSize);
	     this.uploadThresholdSize = resolveSize(filterConfig.getInitParameter("uploadThresholdSize"), this.uploadThresholdSize);
	     this.uploadRepositoryPath = filterConfig.getInitParameter("uploadRepositoryPath");
		
		servletConfig = filterConfig.getServletContext();
		
		String en = filterConfig.getInitParameter("enabled");
		if (en != null) {
			isEnabled = new Boolean(en.trim()).booleanValue();
		}
		String initParameter = filterConfig
				.getInitParameter(PARAM_INIT_TARGET_MAPPINGS);
		StringTokenizer tkz = new StringTokenizer(initParameter, ",\t\n ");
		while (tkz.hasMoreTokens()) {
			String entry = tkz.nextToken();
			entry = entry.trim();
			String[] keyValue = entry.split("=");
			redirectTargetMap.put(keyValue[0].trim(), keyValue[1].trim());
		}

		// Acquire our FacesContextFactory instance
		try {
			facesContextFactory = (FacesContextFactory) FactoryFinder
					.getFactory(FactoryFinder.FACES_CONTEXT_FACTORY);
		} catch (FacesException e) {
			LOGGER.error("Unable to load facesContextFactory");
		}

		// Acquire our Lifecycle instance
		try {
			LifecycleFactory lifecycleFactory = (LifecycleFactory) FactoryFinder
					.getFactory(FactoryFinder.LIFECYCLE_FACTORY);
			String lifecycleId;

			// First look in the servlet init-param set
			if (null == (lifecycleId = servletConfig
					.getInitParameter(LIFECYCLE_ID_ATTR))) {
				// If not found, look in the context-param set
				lifecycleId = servletConfig.getInitParameter(LIFECYCLE_ID_ATTR);
			}

			if (lifecycleId == null) {
				lifecycleId = LifecycleFactory.DEFAULT_LIFECYCLE;
			}
			lifecycle = lifecycleFactory.getLifecycle(lifecycleId);
		} catch (FacesException e) {
			Throwable rootCause = e.getCause();
			if (rootCause == null) {
				throw e;
			} else {
				throw new ServletException(e.getMessage(), rootCause);
			}
		}
	}

	public void doFilter(ServletRequest req, ServletResponse resp,
			FilterChain chain) throws IOException, ServletException {

		long st = System.currentTimeMillis();
		Map securityParams = new HashMap();
		DefaultAuthorizer authorizer = new DefaultAuthorizer();
	      securityParams.put("login-page", "/faces/commons/userLogin.jsp");
          securityParams.put("authorization-page","/faces/notAuthorized.jsp");
          securityParams.put("security-enabled", true);
          securityParams.put("redirected", new Boolean(false));                    
          req.setAttribute("security-params", securityParams);
          securityParams.put("authorizer", authorizer);
        
          
        
          if (!isEnabled) {
			chain.doFilter(req, resp);
			return;
          }
          
           
          
		boolean redirected = false;
		String langCode = "en";
		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) resp;
		MultilanguageHelper.setServletRequest(request);
		HttpSession session = request.getSession(false);
		
		Exception error = null;
		
		try {
			if(session != null) {
				String threadName = getThreadName(session);
				//As discussed with Meena sir    Manojv
				//threadName += "-"+getOracleSessionIdPortInfo();
				threadName = Thread.currentThread().getId()+"_"+threadName;
				Thread.currentThread().setName(threadName); //To identify the number of threads per user
				//Set the threadName in the oracle session to analysis and correlation
				//setOracleClientInfo(threadName);
			}
			
			LOGGER.info("[PERF START]  "+((HttpServletRequest)req).getRequestURI()+"  Free  "+Runtime.getRuntime().freeMemory()/(1024*1024)+" MB ");
			session = request.getSession(false);
			//inValidatePreviousSession(session); //Commented As per QA Suggestion
			performFileUpload(request);
			session = request.getSession(false);
			request.setCharacterEncoding("UTF-8");
			session = request.getSession(false);
			redirected = prepareRequest(request, response);
			session = request.getSession(false);
			langCode = (String) request.getAttribute(LANG_CODE);
			Locale locale = new Locale(langCode);
			((HttpServletResponse) resp).setContentType("text/html;charset=UTF-8");
			((HttpServletResponse) resp).setLocale(new Locale(langCode));
			session = request.getSession(false);
			
			
			
			//Set the JSF Locale
			FacesContext fc = FacesContext.getCurrentInstance();
			if (FacesContext.getCurrentInstance() == null) 
				fc = facesContextFactory.getFacesContext(servletConfig,request, response, lifecycle);
				
			if(fc!=null && fc.getViewRoot() != null)
				fc.getViewRoot().setLocale(locale);
			
			request.setAttribute("locale", locale);
			request.setAttribute("staticPath", com.sellerportal.ism.Configuration.getStaticPath());
			session = request.getSession(false);
			long currTime = System.currentTimeMillis();
			long expiryTime = currTime ;
			if(session != null) {
				expiryTime +=  session.getMaxInactiveInterval() * 1000;
			}
			
	       
	        request.setAttribute("currentTime", currTime);
	        request.setAttribute("expiryTime", expiryTime);
	        set(request);	        
	      

		} catch (Exception e) {
			LOGGER.error("EXCEPTION :: ", e);
			error = e;

		} finally {
			
			
			if (!redirected) {
				try {
					chain.doFilter(req, resp);
					//Do it again as jsps/faces might set some thing different
					response.setContentType("text/html; charset=UTF-8");        
			        request.setCharacterEncoding("UTF8"); 
			        unset();
				}catch(Exception e) {
					LOGGER.info("Message :: "+e.toString() +" Cause :: "+e.getCause());
				}
			}
			
			
			
			
		   // LOGGER.info("PERF DONE :: "+((HttpServletRequest)req).getRequestURI()+"?"+((HttpServletRequest)req).getQueryString()+" "+(System.currentTimeMillis()-st)+" ms   Free  "+Runtime.getRuntime().freeMemory()/(1024*1024)+" MB ");
			
			
			boolean statisticsEnabled = HibernateConnection.getSessionFactory().getStatistics().isStatisticsEnabled();
			String extraInfo =  " Free "+Runtime.getRuntime().freeMemory()/(1024*1024)+" MB ";//+ getHibernateStatics();
		    String accessLogString = getAccessLogString(request, error, st,extraInfo);
		    LOGGER.info("[PERF DONE] "+accessLogString);
		    
		    HibernateConnection.getSession().clear();
			HibernateConnection.closeSession();
			JdbcConnection.closeConnection();
			
			try {
				StatelessSessionDAO.closeStatelessSession();
			}catch(Exception e) {
				
			}
			
			//Meena: 14June2016 - Leak of FacesContext and wierd behaviour
			try {
				FacesContext.getCurrentInstance().release();
			}catch(Exception e) {
				
			}
		}
	}
	
	private static String getHibernateStatics() {
		StringBuffer ret = new StringBuffer();
//		SessionStatistics sessionStats = HibernateConnection.getSession().getStatistics();
//		
//		if(sessionStats != null) {
//			ret.append(" Session [ entities "+sessionStats.getEntityCount());
//			ret.append(" collections "+sessionStats.getCollectionCount()+" ] ");
//		}
		
		Statistics stats = HibernateConnection.getSessionFactory().getStatistics();
		if(stats != null) {
			//ret.append(" Global Counts [ "+stats.toString() +"] \n");
			ret.append(" Hibernate  [ connections "+stats.getConnectCount());
			ret.append(" entityFetched  "+stats.getEntityFetchCount());
			ret.append(" entityInserted  "+stats.getEntityInsertCount());
			ret.append(" entityUpdated  "+stats.getEntityUpdateCount());
			ret.append(" entityDeleted  "+stats.getEntityDeleteCount());
			ret.append(" sessionOpend  "+stats.getSessionOpenCount());
			ret.append(" sessionClosed  "+stats.getSessionCloseCount());
			ret.append(" queriesExecuted  "+stats.getQueryExecutionCount());
			ret.append(" queriesMaxTime  "+stats.getQueryExecutionMaxTime());
			ret.append(" queriesMaxTimeQuery  "+stats.getQueryExecutionMaxTimeQueryString());
			ret.append(" ] ");
		}
		
		return ret.toString();
	}
	/**
	@author pramod
	@see Method to inValidate PreviousSession if any user already logged in with same User Id
	**/
	private static void inValidatePreviousSession(HttpSession session) {
		String sessionUserID = (String) session.getAttribute("sessionUserID");
		if(!OctashopUtils.isEmpty(sessionUserID)){
			String previousSessionID = userSessionMap.get(sessionUserID);
			if(previousSessionID == null){
				userSessionMap.put(sessionUserID, session.getId());
			}else{
				if(!previousSessionID.equals(session.getId())){
					session.invalidate();
				}
			}
		}
	}
	
	private  ServletFileUpload getServletFileUpload(HttpServletRequest req) {
		DiskFileItemFactory factory = new DiskFileItemFactory();
		ServletFileUpload upload = null;
		try {
			factory.setSizeThreshold(uploadThresholdSize);
			if ((uploadRepositoryPath != null) && (uploadRepositoryPath.trim().length() > 0)) {
				factory.setRepository(new File(uploadRepositoryPath));
			}
			
			upload = new ServletFileUpload(factory);
			upload.setFileSizeMax(uploadMaxFileSize);
			upload.setHeaderEncoding(req.getCharacterEncoding());
			//upload.setProgressListener(pListener);
		} catch (Exception e) {
			LOGGER.error("Method Line Number"+e.getStackTrace()[0].getLineNumber() +" Problem with file upload",e);
		}
		return upload;
	}
	
	private void performFileUpload(HttpServletRequest req){
		boolean isMultipart = ServletFileUpload.isMultipartContent(req);
		if(isMultipart){
			try{
				ServletFileUpload upload = getServletFileUpload(req);
				List fileList = (upload != null) ? upload.parseRequest(req) : null; //get uploaded file
				List<FileItem> uploadedItem=new ArrayList<FileItem>();//create a tempary list
				Map<String, FileItem> uploadedMap = new HashMap<String, FileItem>();
				Map<String, String> reqParamDataMap = new HashMap<String, String>();
				if(fileList!=null){
					for(int i=0;i<fileList.size();i++){ //iterate the list
						FileItem item=(FileItem)fileList.get(i);
						if(item!=null && !item.isFormField()){
							uploadedItem.add(item);
							uploadedMap.put(item.getName(), item);
						}else if(item != null && item.isFormField()){
						     if(item.getFieldName() != null && !"".equals(item.getFieldName().trim())){
						    	 reqParamDataMap.put(item.getFieldName(), item.getString());
						     }
						}
					}
				}
				//save uploaded file detail into request
				//req.setAttribute("parseUpload",uploadedItem);
				req.setAttribute("parseUpload",uploadedMap);
				if(reqParamDataMap != null && reqParamDataMap.size() > 0){
					req.setAttribute(REQUEST_PARAM_DATAMAP, reqParamDataMap);	
				}
			}catch(Exception e){
				e.printStackTrace();
				LOGGER.error("Method Line Number 1"+e.getStackTrace()[0].getLineNumber() +" Problem with file upload 1",e);
			}
		}
	}	

	public static boolean prepareRequest(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		String[] orgLangId = I18nHelper.getOrganizationAndLanguageId(request,response);

		String orgId = orgLangId[0];
		String langCode = orgLangId[1];

		String domainName = I18nHelper.getDomainName(request);
		domainName = escapeDomainName(domainName);
		Map<String,String>  org = null;
		if (orgId == null) {
			org = OrganizationHelper.getOrganizationByDomain(domainName);
			if (org == null) {
				//LOGGER.error("ERROR [find org by domain - "+domainName+"]:: organization id not defined. Not in request/session/cookie and there is not organization" +" configured for domain "+ domainName);
			} else {
				orgId = org.get(OrganizationConstants.ORG_ID);
				langCode = org.get(OrganizationConstants.LANG_CODE);
			}
		} else {
			org = OrganizationHelper.findOrganizationByOrgId(orgId);
		}

		if(StringUtils.isBlank(orgId))
			orgId=DEFAULT_ORGID;
		
		if(StringUtils.isBlank(langCode) )
			langCode=DEFAULT_LANGCODE;

		
		
		// Set the orgId and language
		I18nHelper.setOrganizationAndLanguage(orgId, langCode, request,response);
		
		
		
		request.setAttribute(LANG_CODE, langCode);
		request.setAttribute(ORG_ID, orgId);
		
		if(org ==null && !StringUtils.isEmpty(orgId)){
			org = OrganizationHelper.findOrganizationByOrgId(orgId);
		}
		
		if(org !=null){
			request.setAttribute("ORGNAME", org.get(OrganizationConstants.ORGANIZATION_NAME));
		}else{
			request.setAttribute("ORGNAME", DEFAULT_ORG_NAME);	
		}
		
		if(langCode!=null){
			langCode = langCode.trim();
		}
		
		if(orgId!=null){
			orgId = orgId.trim();
		}
		
		System.setProperty(LANG_CODE,langCode);
		System.setProperty(ORG_ID,orgId);

		boolean toRedirect = false;
		String url = I18nHelper.getRequestURL(request).toString();
		if (request.getParameter(PARAM_DO_REDIRECT) != null) {
			String targetUrl = getTargetUrl(request, (String) request
					.getAttribute(ORG_ID), langCode);
			if (targetUrl != null) {
				toRedirect = true;
				url = targetUrl;
			}
		}
		/*if (org != null) {
			String orgDomainName = org.get(OrganizationConstants.DOMAIN_NAME);
			orgDomainName = escapeDomainName(orgDomainName);

			url = replaceUrl(url, domainName, orgDomainName);
			if (orgDomainName != null && !domainName.equals(orgDomainName))
				toRedirect = true;

			if (toRedirect) {
				response.sendRedirect(url);
				return true;
			}
		}*/

		return false;
	}
	
	

	public static String getTargetUrl(HttpServletRequest request, String orgId,
			String langCode) {
		String uri = findTargetMapping(redirectTargetMap, request);
		if (uri != null) {
			StringBuffer urlBuffer = new StringBuffer();
			String scheme = request.getScheme();
			int port = request.getServerPort();

			urlBuffer.append(scheme);
			urlBuffer.append("://");
			urlBuffer.append(request.getServerName());
			if ((scheme.equals("http") && port != 80)
					|| (scheme.equals("https") && port != 443)) {
				urlBuffer.append(':');
				urlBuffer.append(request.getServerPort());
			}
			urlBuffer.append(request.getContextPath());
			if (!uri.startsWith("/"))
				urlBuffer.append("/");
			urlBuffer.append(uri);
			urlBuffer.append("?1=1");

			if (request.getQueryString() != null) {
				urlBuffer.append("&");
				String queryString = request.getQueryString().replace(
						PARAM_DO_REDIRECT, "k");
				urlBuffer = I18nHelper.removeOrganizationAndLanguage(urlBuffer
						.toString());
				urlBuffer.append(queryString);
			}
			return urlBuffer.toString();
		} else {
			return null;
		}
	}

	public static String replaceUrl(String url, String domainName,
			String orgDomainName) {

		String replaceUrl = url;
		if (orgDomainName != null)
			replaceUrl = replaceUrl.replace(domainName, orgDomainName);
		return replaceUrl;

	}

	public static String escapeDomainName(String domainName) {

		if (domainName != null) {
			StringTokenizer tkz = new StringTokenizer(domainName, ".");
			int c = tkz.countTokens();
			if (c == 3) 
				tkz.nextToken();
			if (c >= 2) {
				String s1 = tkz.nextToken();
				String s2 = tkz.nextToken();
				try {
					Integer.parseInt(s1);
				}catch(Exception e) {
					domainName = s1 + "." + s2;
				}				
			}
		}
		return domainName;
	}

	public static String findTargetMapping(Map mappings,
			HttpServletRequest request) {
		if (mappings.size() > 0) {
			String uri = request.getRequestURI();
			uri = uri.toLowerCase();

			Map<String, String> matchingMap = new HashMap<String, String>();
			Set entrySet = mappings.entrySet();
			Iterator iterator = entrySet.iterator();
			while (iterator.hasNext()) {
				Entry entry = (Entry) iterator.next();
				String key = (String) entry.getKey();
				key = key.toLowerCase();
				if (uri.contains(key)) {
					matchingMap.put(key, (String) entry.getValue());
				}
			}

			if (matchingMap.size() > 0) {
				entrySet = matchingMap.entrySet();
				iterator = entrySet.iterator();
				int length = 0;
				String maxKey = null;
				while (iterator.hasNext()) {
					Entry entry = (Entry) iterator.next();
					String key = (String) entry.getKey();
					if (key.length() > length) {
						length = key.length();
						maxKey = key;
					}
				}

				return (String) matchingMap.get(maxKey);
			}

		}
		return null;
	}

	public void destroy() {
		if (LOGGER.isInfoEnabled())
			LOGGER.info("destroy()");
		facesContextFactory = null;
		lifecycle = null;
		servletConfig = null;

	}
	
	public static void set(HttpServletRequest req) {
		userThreadLocal.set(req);
	}
	
	public static void unset() {
		userThreadLocal.remove();
	}
		 
	public static HttpServletRequest get() {
		return (HttpServletRequest) userThreadLocal.get();
	}
	
	private int resolveSize(String param, int defaultValue){
	      int numberParam = defaultValue;
	      if (param != null){
	         param = param.toLowerCase();
	        int factor = 1;
	        String number = param;
	         if (param.endsWith("g")){
	            factor = 1073741824;
	            number = param.substring(0, param.length() - 1);
	         }else if (param.endsWith("m")){
	            factor = 1048576;
	            number = param.substring(0, param.length() - 1);
	          } else if (param.endsWith("k")){
	            factor = 1024;
	            number = param.substring(0, param.length() - 1);
	          }
	          numberParam = Integer.parseInt(number) * factor;
           }
	        return numberParam;
	 }
	
	//Access log related settings
	  /**
	   * 
	   * @param session <code>HttpSession</code>
	   * @return <code>String</code> Returns following format response.<pre>44328_11977_206122295_</pre>
	   */
	  
	  public String getThreadName(HttpSession session){
		  if(session == null)
			  return null;

		  //sessionId_sellerCode_slaveCode_loginId
	      StringBuffer threadName = new StringBuffer();
	      try{
	          SessionVariablesBean svb = (SessionVariablesBean)session.getAttribute ("SessionVariablesBean");
	          String sessionId = session.getId();
	          
	          try {
		          if(sessionId !=null && sessionId.length()>10){
		             // String last6 = sessionId.substring(sessionId.length() - 6); 
		              String first5 = sessionId.substring(0,10);
		              sessionId = first5;//+""+last6;
		          }
	          }catch(Exception e) { }
	          threadName.append (sessionId);
	          String sellerCode = "";
	          if(svb !=null){
	        	  String userTypeCode = svb.getUserTypeCode() != null ? svb.getUserTypeCode():"-";
	        	  threadName.append("_"+userTypeCode);
	        		  
	        	  if(svb.getSlaveCode() == null && svb.getGlobalSlaveId() == null ) {
	        		  sellerCode =  svb.getSellerCode() != null ? svb.getSellerCode():"-";
	        		  if(sellerCode.equals("-") && svb.getGlobalSellerId() != null ) {
	        			  sellerCode = getSellerSlave(svb.getGlobalSellerId());
		              }
	        		  threadName.append ("_"+sellerCode);
	        	  }
	             
	        	  
	              String slaveCode = svb.getSlaveCode() !=null?svb.getSlaveCode():"-";
	              if(slaveCode.equals("-") && svb.getGlobalSlaveId() != null ) {
	            	  
	            	  slaveCode = getSellerSlave(svb.getGlobalSlaveId());
	              }
	              threadName.append ("_"+slaveCode);
	              
	              String loginId = "-";
	              if(svb.getUserLoginId() !=null ){
	                  loginId = svb.getUserLoginId();
	              }
	              threadName.append ("_"+loginId);
	              
	          }
	      }
	      catch(Exception e){
	          
	      }
	     
	      return threadName.toString ();
	  }
	  
	  static String patternString = "^[a-zA-Z ]+"+Pattern.quote("(")+"(.*)"+Pattern.quote(")");
		
		static Pattern p = Pattern.compile(patternString);
		private static String getSellerSlave(String text) {
			String r = text;
			if(text.indexOf("(") > 0) {
				Matcher m = p.matcher(text);

				if (m.find()) {
				    r = m.group(1);
				}
			}
			
			if(r != null) {
				r = r.replaceAll(" ", "");
				r = r.trim();
			}
			return r;
			
		}
	  
	  /**
	   * Method returns the access log format for given http request. In case of any runtime error method would return empty string.
	   * [Future] method can be enhanced to support the template based log format.
	   * 
	   * @param request <code>ServletRequest</code>
	   * @param error <code>Exception </code> Any runtime error raised during request processing by application. It can be null which means no error.
	   * @param st <code>long</code> System timestamp at the request start   
	   * @param additionalInfo <code>String</code> Application related information
	   * @return <code>String</code> Returns following format response.<pre>[ACCESSLOG] 127.0.0.1 GET quickBook.html flightSearch.jsp 200 250 ms sessionId additioninfo ourney_type=O&travel_class=E&departure_date=05/12/2009&return_date=&departure_time=00:00:00,23:59:00&return_time=&adult_count=1&child_count=0 Mozilla/5.0  </pre>
	   */
	  public String getAccessLogString(ServletRequest request,Exception error,long st,String additionalInfo){
	      StringBuffer strAccessLog = new StringBuffer();

	      String delimiter = " ";
	      String errorStausCode = "200";
	      try{
	          HttpServletRequest httpRequest = (HttpServletRequest) request;
	          if(httpRequest!=null){
	              String strReferrer  = "-";
	              String strQueryString ="";
	              String strPage ="-";
	              httpRequest.getHeaderNames ();
	              String strMethod = httpRequest.getMethod ();
	              if(httpRequest.getHeader ("referer")!=null){
	                  String[] refArr = httpRequest.getHeader ("referer").split("\\?")[0].split ("/");
	                  strReferrer  = (refArr.length>0) ?refArr[refArr.length-1] :"";
	                  strQueryString = (refArr.length>1) ?refArr[1] :"";
	              }
	              if(httpRequest.getRequestURI ()!=null){
	                  String[] reqUriArr = httpRequest.getRequestURI ().split("\\?")[0].split ("/");
	                  strPage =reqUriArr[reqUriArr.length-1];
	              }
	              
	              strQueryString = strQueryString + getRequestParameter (httpRequest);//httpRequest.getQueryString ()!=null ? httpRequest.getQueryString () :"-";
	              String strBrowser = httpRequest.getHeader ("user-agent")!=null?httpRequest.getHeader ("user-agent").split (" ")[0]:"-";
	              String strIpAdd = httpRequest.getRemoteAddr ()!=null?httpRequest.getRemoteAddr ():"-";
	              if(error != null){
	                  errorStausCode = "500";
	              }
	               String id=httpRequest.getSession().getId();
	               HttpSession session = httpRequest.getSession(false);
	               if(session!=null){
	            	   //session.invalidate();
	            	   //session.setMaxInactiveInterval(1);
	               }
	              if(httpRequest.isRequestedSessionIdFromCookie()){
	            	 // httpRequest.getSession().invalidate();
	              }
	         
	              
	              long responseTime = (System.currentTimeMillis ()-st);
	              strAccessLog.append (strIpAdd+delimiter+strMethod+delimiter+responseTime+delimiter+"ms"+delimiter+strPage+"?"+strQueryString+delimiter);
	              strAccessLog.append (errorStausCode+delimiter+strReferrer+delimiter+((HttpServletRequest) request).getSession ().getId () +delimiter + additionalInfo);
	              strAccessLog.append (strQueryString+delimiter+strBrowser);
	              //strAccessLog = strIpAdd +delimiter+strMethod+delimiter+strReferrer+delimiter+strPage+delimiter+errorStausCode+delimiter+strQueryString+delimiter+ strBrowser;
	          }
	      }catch(Exception e){
	          
	      }
	    

	      return strAccessLog.toString ();
	  }
	  
	  public String getRequestParameter(HttpServletRequest request){
	      StringBuffer paramString = new StringBuffer();
	      try{
	          Map reqMap = request.getParameterMap ();
	          if(reqMap!=null){
	              Set keyMap = reqMap.keySet ();
	              Iterator iter = keyMap.iterator ();
	              while (iter.hasNext ())
	              {
	                  String key = (String) iter.next ();
	                  if (key != null && !(key.startsWith ("jsf_"))) {
	                	  if(key.equals("password")) {
		                	  paramString.append("" + key + "=" + "*******"+"&");
		                	  continue;
		                  }
	                	  String value = request.getParameter(key);
	                	  if(value.length() > 64)
	                		  value = value.substring(0, 64) +"...";
	                      paramString.append("" + key + "=" + value+"&");
	                  }
	              }
	          }
	      }
	      catch (Exception e) {
	         
	      } 
	      
	      return paramString.toString();
	  }

}
