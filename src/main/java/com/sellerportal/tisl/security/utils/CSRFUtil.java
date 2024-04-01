package com.sellerportal.tisl.security.utils;

import java.util.UUID;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sellerportal.integra.impl.octashop.utils.OctashopUtils;
import com.sellerportal.ism.SessionVariablesBean;
import com.anm.jsf.utils.FacesUtils;

@Component
public final class CSRFUtil {
	private static final Log LOGGER = LogFactory.getLog(CSRFUtil.class);
	
	@Autowired
	SessionVariablesBean sessionBean;
	/**
	 * Private constructor to restrict instantiation
	 */
	private CSRFUtil () {}
	
	public static String generateCSRFToken() {
	    return UUID.randomUUID().toString();
	}
	
	public void attachCSRFToken() {
		sessionBean.setCsrfToken(CSRFUtil.generateCSRFToken());
	}
	
	public static void checkTokenValidity(String providedToken) throws Exception {
		SessionVariablesBean sessionBean = (SessionVariablesBean) FacesUtils.getManagedBean("SessionVariablesBean");
		
		if (!OctashopUtils.isObjectEmpty(sessionBean.getCsrfToken())
				&& !sessionBean.getCsrfToken().equals(providedToken)) {
			LOGGER.error("Intrusion attempt was caught!!!");
			throw new Exception("Intrusion attempt was caught!!!");
		}
	}

}
