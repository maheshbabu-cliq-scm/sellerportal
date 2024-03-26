/**
 * 
 */
package com.sellerportal.tisl.commons;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.Set;
import java.util.TreeSet;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.commons.net.util.Base64;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;

import com.sellerportal.integra.impl.octashop.utils.OctashopUtils;
import com.sellerportal.ism.SessionVariablesBean;
import com.sellerportal.model.Ismipt;
import com.sellerportal.dao.IsmiptDAO;
import com.sellerportal.model.Ismmdm;
import com.sellerportal.dao.IsmmdmDAO;
import com.sellerportal.model.Ismubi;
import com.sellerportal.dao.IsmubiDAO;
import com.sellerportal.model.OctParam;
import com.sellerportal.dao.OctParamDAO;
import com.sellerportal.ism.i18n.I18nHelper;
import com.anm.jsf.utils.FacesUtils;
import com.sellerportal.mail.AbstractMailApi;
import com.sellerportal.tisl.seller.listproduct.utils.ProductAttributeConst;
import com.sellerportal.webservice.CourierServiceConstants;
import com.sellerportal.webservice.WebserviceConstants;

/**
 * @author kunal
 *
 */
public class CommonsUtils {
	private final static Log LOGGER = LogFactory.getLog(CommonsUtils.class);
	
	
	
	public static List<OptionComponentDisplayBean> getOptionComponentListByOctparam(String groupName, String selectedValue, String splitter) {
		List<OptionComponentDisplayBean> optionList = new ArrayList<OptionComponentDisplayBean>();
		
		if(!OctashopUtils.isEmpty(groupName)){
			List<OctParam> componentGroupList = new OctParamDAO().findByGroup(groupName);	
			if(!OctashopUtils.isListEmpty(componentGroupList)){
				Set<String> selectedValSet = new TreeSet<String>();
				if(!OctashopUtils.isEmpty(splitter) && !OctashopUtils.isEmpty(selectedValue)){
					String[] selectVals = selectedValue.split(ProductAttributeConst.PRODUCTATTRIBUTEVALUESSPLITTER);
					for (int i = 0; i < selectVals.length; i++) {
						selectedValSet.add(selectVals[i]);
					}
				}else{
					selectedValSet.add(selectedValue);
				}
				
				for (int i = 0; i < componentGroupList.size(); i++) {
					OctParam octparam = (OctParam) componentGroupList.get(i);
					String label = octparam.getParamdesc();
					String value = octparam.getParamrfnum().toString();
					String id = "";
					if(octparam.getParamrfnum() != null){
						id = octparam.getParamrfnum().toString();	
					}
					
					if(!OctashopUtils.isEmpty(value) && selectedValSet.contains(value)){
						optionList.add(new OptionComponentDisplayBean(id,label, value, true));	
					}else{
						optionList.add(new OptionComponentDisplayBean(id,label, value, false));
					}
				}
			}
		}
		return optionList;
	}
	
	private static VelocityEngine engine;
	private static VelocityEngine initVelocityEngine() {
		if (engine == null) {
			synchronized (CommonsUtils.class) {
				try {	
						engine = new VelocityEngine();
						engine.init();
					} catch (Exception e) {
						LOGGER.info("Message :: " + e.toString() + " Cause :: " + e.getCause(), e);
					}
				}
		}
		return engine;
	}
	
   public static String invokeVelocityEngine(final Map params, final File templateFile) {
		
    	StringWriter writer = null;
		BufferedReader reader = null;
		String result = null;
		try {
			initVelocityEngine();
			VelocityContext context=new VelocityContext(params);
			writer=new StringWriter();
			reader = new BufferedReader(new InputStreamReader(new FileInputStream(templateFile)));
			engine.evaluate(context, writer, "velocity template", reader);
			StringBuffer buffer = writer.getBuffer();
			result = buffer.toString();			
		} catch (Exception e) {
			
			LOGGER.info("Message :: "+e.toString() +" Cause :: "+e.getCause());
		}
		return result;
    }
   
   public String generateCode() {
		long nextId;
		nextId = System.currentTimeMillis() % 1000000;
		return String.valueOf(nextId);
	}
   
   public static boolean isLoggedIn() {
	   boolean isLoggedIn = false;
	   try {
		   SessionVariablesBean sessionbean = (SessionVariablesBean) FacesUtils.getManagedBean("SessionVariablesBean");
		   if(sessionbean.getUserRefNo() != null && !"".equals(sessionbean.getUserRefNo().trim())){
			   isLoggedIn = true; 
		   }
	   } catch (Exception e) {
			
		}
	   return isLoggedIn;
   }
   
   /**
	 * Checks valid Pincode no(6) digits.
	 * @author Amol Jadhav
	 * @param mobileNo
	 * @return
	 */ 
	public boolean isValidPincode(String pincode) {
		if (pincode.length() == 0)
			return false;
		if (pincode.length() < 6 || pincode.length()>6 )
			return false;
		try {
			Long.parseLong(pincode);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}		
	
	public boolean isValidAmount(String pincode) {
		try {
			if(Double.parseDouble(pincode)>0){
				return true;	
			}else{
				return false;
			}
		} catch (Exception e) {
			return false;
		}
	}
	
	public boolean isValidFlag(String flag) {
		try {
			if (flag.equalsIgnoreCase("Y") || flag.equalsIgnoreCase("N"))
				return true;
			else 
				return false;
		} catch (Exception e) {
			return true;
		}
	}
	
	
	public static boolean isIntegratedWithClickPost(String logisticId) {
		boolean isIntegrated=false;
		if(OctashopUtils.isNotEmpty(logisticId))
		{
			isIntegrated=logisticId.endsWith("CP") ? true: false; 
		}
		return isIntegrated;
	}
	
	public static boolean containsClickPost(String courierCode) {
		boolean isIntegrated=false;
		if(OctashopUtils.isNotEmpty(courierCode))
		{
			courierCode = courierCode.toLowerCase();
			isIntegrated = courierCode.contains("clickpost") ? true: false; 
		}
		return isIntegrated;
	}
  
}
