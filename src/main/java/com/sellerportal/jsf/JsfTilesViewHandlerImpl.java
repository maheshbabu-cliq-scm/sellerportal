package com.sellerportal.jsf;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.faces.FacesException;
import javax.faces.application.ViewHandler;
import javax.faces.component.UIViewRoot;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.myfaces.shared_tomahawk.webapp.webxml.WebXml;
import org.apache.myfaces.shared_tomahawk.webapp.webxml.ServletMapping;

import com.sellerportal.integra.impl.octashop.utils.OctashopUtils;
import com.anm.jsf.utils.FacesUtils;
import com.anm.utils.CommonUtils;

public class JsfTilesViewHandlerImpl extends ViewHandler {
    private ViewHandler _viewHandler;

    private static final Log log = LogFactory
            .getLog(JsfTilesViewHandlerImpl.class);
    private static final String TILES_EXTENSION = ".tiles";
    //private static final String TILES_DEF_ATTR = "tiles-definitions";

    //private DefinitionsFactory definitionsFactory;

    public JsfTilesViewHandlerImpl(ViewHandler viewHandler) {
        _viewHandler = viewHandler;
    }

    /*public DefinitionsFactory getDefinitionsFactory() {
        if (definitionsFactory == null || isTileDefinitionModified()) {
            if (log.isDebugEnabled())
                log.debug("JsfTilesViewHandlerImpl init");
            ExternalContext context = FacesContext.getCurrentInstance()
                    .getExternalContext();
            String tilesDefinitions = context.getInitParameter(TILES_DEF_ATTR);
            if (tilesDefinitions == null) {
                log.fatal("No Tiles definition found. Specify Definition files by adding "
                                + TILES_DEF_ATTR + " param in your web.xml");
                return null;
            }

            DefinitionsFactoryConfig factoryConfig = new DefinitionsFactoryConfig();
            factoryConfig.setDefinitionConfigFiles(tilesDefinitions);
            try {
                if (log.isDebugEnabled())
                    log.debug("Reading tiles definitions");
                definitionsFactory = TilesUtil.createDefinitionsFactory(
                        (ServletContext) context.getContext(), factoryConfig);
            } catch (DefinitionsFactoryException e) {
                log.fatal(
                        "Error reading tiles definitions", e);
                return null;
            }
        }
        return definitionsFactory;
    }*/
    
    private static long lastModifiedTime = 0;
    /**
     * Check if the tiles-defs.xml is modified.
     * @param tilesDefFile
     */
    @SuppressWarnings("squid:S2583")
    public boolean isTileDefinitionModified() {
        String applicationPath = new CommonUtils().getApplicationBasePath((ServletContext) FacesContext.getCurrentInstance().getExternalContext().getContext());
        File file = new File(applicationPath,"WEB-INF/tiles-defs.xml");
        if (file == null) {
            log.fatal(" !Error: Could not load the ["+applicationPath+"WEB-INF/tiles-defs.xml"+"]");
            return true;
        }
        long modifiedTime = file.lastModified();
       
        if (modifiedTime > lastModifiedTime) {
            log.info("++++++ Reloading modified tiles-defs.xml ["+applicationPath+"WEB-INF/tiles-defs.xml]");
            lastModifiedTime = modifiedTime;
            return true;
        }
        return false;
        
    }
    
    public void handleError(Throwable e)
    {
    	HttpServletRequest request=null;
		HttpServletResponse response=null;
		String contextPath="";
    	try {
    	
    		
    		FacesContext facesContext = FacesContext.getCurrentInstance();
    		if(facesContext != null)
    		{
    			request = (HttpServletRequest) facesContext.getExternalContext().getRequest();
    			response = (HttpServletResponse) facesContext.getExternalContext().getResponse();
    			contextPath=request.getContextPath();
    			
    			//Lets dont cache if some error while rendering any tile 
    			request.setAttribute("com.anm.dontcache","true");
    			
    			String requestURL = request.getRequestURI();
    			String method = request.getMethod();
    			String error = "";
    			//Let print the root cause only and not all the stack trace
    			String message = e.getMessage();
    			StackTraceElement[] stackTrace = e.getStackTrace();
    			StackTraceElement end = stackTrace[0];
    			StackTraceElement start = stackTrace[stackTrace.length-1];
    			Map params = new HashMap();
    			params.putAll(facesContext.getExternalContext().getRequestParameterMap());
    			params.remove("jsf_state_64");
    			params.remove("jsf_tree_64");
    			String queryString = new FacesUtils().encodeQuery(params);
    			if (queryString == null)
    				queryString = "";
    			
    			error = "Reason <"+message+"> line: "+start.getLineNumber()+" method <"+start.getMethodName()+"> class <"+start.getClassName()+">";
    			
    			//if the same error already logged how then we should not log otherwise we need to print trace
    			
    			log.error("<Processing Error> : URL ["+method+"] <"+requestURL+"> Parameters <"+queryString+"> : <"+error+">. Please Report the Details to Tech support team ");
    			//show we display the error trace.
    			if(log.isDebugEnabled())
    			{
    				StringWriter writer = new StringWriter();
    				PrintWriter writer2 = new PrintWriter(writer);
    				//e.printStackTrace(writer2);
    				log.debug(writer.getBuffer().toString());
    				writer2.close();
    			}
    			ExternalContext externalContext = facesContext.getExternalContext();
    			Map initParameterMap = externalContext.getInitParameterMap();
    			String jspErrorHandler = (String) initParameterMap.get("jsp-error-handling");
    			if (jspErrorHandler != null && jspErrorHandler.equals("true"))
    			{
    				String statusCode = (String) initParameterMap.get("jsp-error-status-code");
    				if (statusCode != null && statusCode.trim().length() > 0)
    				{
    					response.setStatus(Integer.parseInt(statusCode.trim()));
            			response.flushBuffer();
    				}
    				else {
    					response.setStatus(500);
            			response.flushBuffer();
    				}
    			}
    		}
    	}catch(Exception e1) {
    		e1.printStackTrace();
    		log.info("JsfTilesViewHandlerImpl: Oops something went wrong. The detailed logs are available in below stack trace.");
    		//LOGGER.error(e1.getStackTrace());
    	}
    	
    	finally
    	{
    		try {
    			if(response!=null && !response.isCommitted()){
    				response.sendRedirect(contextPath + "/faces/commons/notAuthorized.jsp");    				
    			}
			} catch (IOException e1) {
				
				//LOGGER.error(e1.getStackTrace());
			}	
    	}
    	
    }


    private void dispatch(ExternalContext externalContext,
            UIViewRoot viewToRender, String viewId) throws IOException {
        if (log.isDebugEnabled())
            log.debug("Dispatching to " + viewId);
        
        // handle character encoding as of section 2.5.2.2 of JSF 1.1
        if (externalContext.getResponse() instanceof ServletResponse) {
            ServletResponse response = (ServletResponse) externalContext
                    .getResponse();
            response.setLocale(viewToRender.getLocale());
        }
        if(!OctashopUtils.isEmpty(viewId)){
        	externalContext.dispatch(viewId);
        }
        
        
        // handle character encoding as of section 2.5.2.2 of JSF 1.1
        if (externalContext.getRequest() instanceof HttpServletRequest) {
            HttpServletResponse response = (HttpServletResponse) externalContext
                    .getResponse();
            HttpServletRequest request = (HttpServletRequest) externalContext
                    .getRequest();
            HttpSession session = request.getSession(false);

            if (session != null) {
                session.setAttribute(
                        ViewHandler.CHARACTER_ENCODING_KEY, response
                                .getCharacterEncoding());
            }
        }
    }
    
    private static boolean logMappings = true;
    private static List mappings = new ArrayList();
    
    private synchronized static List getMappingsObject() {
		if(mappings == null || mappings.size() == 0 ) {
    		ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
    		WebXml.init(externalContext);
            WebXml webxml = WebXml.getWebXml(externalContext);
            mappings = webxml.getFacesServletMappings();
		}
		return mappings;
    }

    private static ServletMapping getServletMapping(
            ExternalContext externalContext) {
        String servletPath = externalContext.getRequestServletPath();
        String requestPathInfo = externalContext.getRequestPathInfo();
        
        mappings = getMappingsObject();
        if(mappings !=null)
        	log.info("logMappingData:: Standard Mapping Size::" +mappings.size());
        
        if(logMappings) {
        	logMappings = false;
        }

        boolean isExtensionMapping = requestPathInfo == null;

        try {
			for (int i = 0, size = mappings.size(); i < size; i++) {
			    ServletMapping servletMapping = (ServletMapping) mappings.get(i);
			    if (servletMapping.isExtensionMapping() == isExtensionMapping) {
			        String urlpattern = servletMapping.getUrlPattern();
			        if (isExtensionMapping) {
			            String extension = urlpattern.substring(
			                    1, urlpattern.length());
			            if (servletPath.endsWith(extension)) {
			                return servletMapping;
			            }
			        } else {
			            urlpattern = urlpattern.substring(
			                    0, urlpattern.length() - 2);
			            // servletPath starts with "/" except in the case where the
			            // request is matched with the "/*" pattern, in which case
			            // it is the empty string (see Servlet Sepc 2.3 SRV4.4)
			            if (servletPath.equals(urlpattern)) {
			                return servletMapping;
			            }
			        }
			    }
			}
		} catch (Exception e) {
		}
        
        log.error("could not find pathMapping for servletPath = " + servletPath
                + " requestPathInfo = " + requestPathInfo);
        throw new IllegalArgumentException(
                "could not find pathMapping for servletPath = " + servletPath
                        + " requestPathInfo = " + requestPathInfo);
    }
    
    

    public Locale calculateLocale(FacesContext context) {
        return _viewHandler.calculateLocale(context);
    }

    public String calculateRenderKitId(FacesContext context) {
        return _viewHandler.calculateRenderKitId(context);
    }

    public UIViewRoot createView(FacesContext context, String viewId) {
        return _viewHandler.createView(
                context, viewId);
    }

    public String getActionURL(FacesContext context, String viewId) {
    	String actionUrl = _viewHandler.getActionURL(context, viewId);
    	
    	/*
    	 * TODO Customization for the post back actions which does not contain the original Query Parameter after postback
    	if(viewId != null)
    	{
    		HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
    		boolean isNavigation = new CommonUtils().isPageTransition(request);
    		//if postback and viewID is search.jsp, category.jsp, or product.jsp or catalogue.jsp and ParameterBean is not null
    		boolean isPostBack = new CommonUtils().isPostBackRequest();
    		
    		boolean isValidViewId = (viewId.endsWith("search.jsp") || viewId.endsWith("category.jsp") || viewId.endsWith("product.jsp") || viewId.endsWith("catalogue.jsp"));
    		boolean isParameterBean = (FacesUtils.getManagedBean("ParameterBean") != null);
    		boolean isValid = ( (isPostBack &&  isValidViewId &&  isParameterBean);
    		//TODO Future To Avoid Hardcoding of pages :
    		 //boolean isValid = ( isPostBack && !isNavigation && isParameterBean);
    		if(isValid)
    		{
    		  //ParameterBean paramBean = (FacesUtils.getManagedBean("ParameterBean") != null);	
    		 //TODO Make the queryString from the parameterBean
    		  StringBuffer queryString = new StringBuffer();
    		  
    		  if(queryString.length() > 0)
    		  {
    			actionUrl = actionUrl+"?"+  actionUrl;
    		  }
    		}
    		
    	}
    	*/
    	return actionUrl;
        
    }

    public String getResourceURL(FacesContext context, String path) {
        return _viewHandler.getResourceURL(
                context, path);
    }

    public UIViewRoot restoreView(FacesContext context, String viewId) {
        return _viewHandler.restoreView(
                context, viewId);
    }

    public void writeState(FacesContext context) throws IOException {
        _viewHandler.writeState(context);
    }

	@Override
	public void renderView(FacesContext context, UIViewRoot viewToRender) throws IOException, FacesException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getWebsocketURL(FacesContext context, String channelAndToken) {
		// TODO Auto-generated method stub
		return null;
	}

}
