package com.sellerportal.ism;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sellerportal.ism.i18n.I18nFilter;

/**
 * @author binod.kumar
 * This can be used to populate the parameters from the request to bean.  
 */
public class AutoPopulateBeanHelper {
	private static final Log LOGGER = LogFactory.getLog(AutoPopulateBeanHelper.class);
	
	
	public static Object populate(HttpServletRequest req ,Object bean){
		if(bean == null)
			throw new NullPointerException();
		HashMap map = new HashMap();
	    Enumeration names = req.getParameterNames();
	    while (names.hasMoreElements()) {
	      String name = (String) names.nextElement();
	      map.put(name, req.getParameterValues(name));
	    }
	    try{
	    	BeanUtils.populate(bean, map);
	    	Object obj = req.getAttribute(I18nFilter.REQUEST_PARAM_DATAMAP);
	    	if(obj != null && obj instanceof HashMap){
	    		map = (HashMap)obj;
	    		BeanUtils.populate(bean, map);
	    	}
	    }catch (InvocationTargetException e) {
		}catch (IllegalAccessException e) {
		}
	    
	    //Binod:: fill bean with uploaded file
	    try{
	    	@SuppressWarnings("unchecked")
			//List<FileItem> parseUpload = (List<FileItem>)req.getAttribute("parseUpload");
	    	Map<String,FileItem> parseUpload = (HashMap<String,FileItem>)req.getAttribute("parseUpload");
	    	if(parseUpload !=null && parseUpload.size() > 0){
	    		Set<String> keySet = parseUpload.keySet();
	    		if(keySet!=null){
	    			Iterator<String> itemSet=keySet.iterator();	    		
		    		while(itemSet.hasNext()){		    			
		    			String key = itemSet.next();
		    			if(key!=null && !key.trim().isEmpty()){
			    			FileItem item=parseUpload.get(key);
			    			if(item !=null){
			    				String fieldName=item.getFieldName();	    				
			    				HashMap<String,FileItem> uploadMap = new HashMap<String,FileItem>();
			    				uploadMap.put(fieldName, item);
			    				BeanUtils.populate(bean, uploadMap);
			    			}
		    			}
		    		}
	    		}
	    	}
	    }catch(Exception e){
	    	LOGGER.error("Error occured while setting upload property "+e.getMessage()+" Caused By "+e.getCause());
	    }
		return bean;
	}
	
	public static Object populateCat(HttpServletRequest req ,Object bean){
		if(bean == null)
			throw new NullPointerException();
		HashMap map = new HashMap();
	    Enumeration names = req.getParameterNames();
	   while (names.hasMoreElements()) {
	      String name = (String) names.nextElement();
	      if (!"uploadFile".equals(name))
	      {
	      map.put(name, req.getParameterValues(name));
	      }
	    }
	    
	    try{
	    	BeanUtils.populate(bean, map);
	    	Object obj = req.getAttribute(I18nFilter.REQUEST_PARAM_DATAMAP);
	    	if(obj != null && obj instanceof HashMap){
	    		map = (HashMap)obj;
	    		BeanUtils.populate(bean, map);
	    	}
	    }catch (InvocationTargetException e) {
		}catch (IllegalAccessException e) {
		}
	    
	    try{
	    	@SuppressWarnings("unchecked")
	    	Map<String,FileItem> parseUpload = (HashMap<String,FileItem>)req.getAttribute("parseUpload");
	    	if(parseUpload !=null && parseUpload.size() > 0){
	    		Set<String> keySet = parseUpload.keySet();
	    		if(keySet!=null){
	    			Iterator<String> itemSet=keySet.iterator();	    		
		    		while(itemSet.hasNext()){		    			
		    			String key = itemSet.next();
		    			if(key!=null && !key.trim().isEmpty()){
			    			FileItem item=parseUpload.get(key);
			    			if(item !=null){
			    				String fieldName=item.getFieldName();	    				
			    				HashMap<String,FileItem> uploadMap = new HashMap<String,FileItem>();
			    				uploadMap.put(fieldName, item);
			    				BeanUtils.populate(bean, uploadMap);
			    			}
		    			}
		    		}
	    		}
	    	}
	    }catch(Exception e){
	    	LOGGER.error("Error occured while setting upload property "+e.getMessage()+" Caused By "+e.getCause());
	    }
		return bean;
	}
	
	/**
	 * 
	 * @param req
	 * 			- ServletRequest 
	 * @param bean
	 * 			- This is the bean passed by the user to populate parameters to beans property
	 */
	static public void populateBean(ServletRequest req, Object bean){
		if(bean == null)
			throw new NullPointerException();
		Map parameterMap = req.getParameterMap();
		Iterator it = parameterMap.keySet().iterator();
		while (it.hasNext()) {
				String key = (String) it.next();
				if(key.indexOf(":")==-1){
					String paramValue = req.getParameter(key);
					if(LOGGER.isDebugEnabled())
						LOGGER.debug(key + ":"+ paramValue);
					invokeSetProperty(bean, key, paramValue);
				}
		}
		
	}
	/**
	   * Set the values of the "set" methods of Bean.
	   * 
	   * @param obj
	   *          The object to set method called.
	   * @param
	   * 		- name of the property whose setter method will be called
	   * 
	   * @throws InvocationTargetException
	   *           If an error occurs in calling the get methods.
	   * @throws IllegalAccessException
	   *           If the security manager rejects access.
	   */
	private static void invokeSetProperty(Object obj, String prop, String paramValue) {
		prop = Character.toUpperCase(prop.charAt(0)) + prop.substring(1);
		String mname = "set" + prop;
		Class[] types = new Class[] { String.class };
		try {
			Method method = obj.getClass().getMethod(mname, types);
			if(method.isAccessible())
				method.invoke(obj, new Object[] { paramValue });
		} catch (SecurityException e) {
			LOGGER.info("Message :: "+e.toString() +" Cause :: "+e.getCause());
		} catch (IllegalArgumentException e) {
			LOGGER.info("Message :: "+e.toString() +" Cause :: "+e.getCause());
		} catch (NoSuchMethodException e) {
			LOGGER.error("Property["+mname+"] Not Found",e);
		} catch (IllegalAccessException e) {
			LOGGER.info("Message :: "+e.toString() +" Cause :: "+e.getCause());
		} catch (InvocationTargetException e) {
			LOGGER.info("Message :: "+e.toString() +" Cause :: "+e.getCause());
		}
	}
	public static String invokeGetProperty(Object obj, String prop) throws Exception {
		String mname = "get" + prop;
		Class[] types = new Class[] {};
		Method method = obj.getClass().getMethod(mname, types);
		Object result = method.invoke(obj, new Object[0]);
		String value = (String) result;
		return value;
	}

}
