/*
 *
 */
package com.sellerportal.service;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.anm.hibernate.DAOException;
import com.sellerportal.integra.impl.octashop.utils.OctashopUtils;
import com.sellerportal.ism.SessionVariablesBean;
import com.sellerportal.ism.bam.beans.StagingLoginBean;
import com.sellerportal.dao.IsmaurDAO;
import com.sellerportal.model.Ismsua;
import com.sellerportal.dao.IsmsuaDAO;
import com.sellerportal.dao.IsmsuaPK;
import com.sellerportal.model.Ismubi;
import com.sellerportal.dao.IsmubiDAO;
import com.sellerportal.ism.i18n.I18nHelper;
import com.sellerportal.ism.utils.EncryptDecrypt;
import com.anm.jsf.utils.FacesUtils;

/**
 * @author:Binod Kumar
 * this class is used for Checking Login ID
 */
public class StagingLoginActionBean {
    private static final Log LOGGER = LogFactory
            .getLog(StagingLoginActionBean.class);
    
    @Autowired
	private UserValidationActionBean uvab;

   

    /**
     * This method is used for Checking shopping Login ID, and it also checks Ocatshop Login ID by
     * calling ismLogin(String Id) method
     * 
     * @return navigation
     */
    public String stagingLogin_loginAction(String ipAddress) {

        boolean result = false;
        String navigation = "failure";
        FacesContext ctx = FacesContext.getCurrentInstance();
        HttpSession session = (HttpSession)ctx.getExternalContext().getSession(true);
        StagingLoginBean staging = (StagingLoginBean) FacesUtils
                .getManagedBean("StagingLoginBean");
        SessionVariablesBean sessionBean = (SessionVariablesBean) FacesUtils.getManagedBean("SessionVariablesBean");
        String loginId = (String) staging.getLoginId().getValue();
        String password = (String) staging.getPassword().getValue();
        String passwordtemp = password;

        try {
        	EncryptDecrypt encDec = new EncryptDecrypt();
			password = encDec.encrypt(password);			
            result = uvab.loginAction(loginId, password);
        } catch (Exception e1) {
        	LOGGER.error(e1.getStackTrace());
            FacesMessage msg =I18nHelper.getMessage("Authentication_failure",null);
            String errorMsg="Authentication failure:[" + e1.getMessage() + "]";            
            ctx.addMessage(
                    null, msg);
            LOGGER.info(errorMsg);
            return navigation;
        }

        try {
            if (result == true) {
                LOGGER.info("valid  loginId for Octashop...");
               
                Ismubi ismubi = ismLogin(loginId);
                if (ismubi != null) {
                	List roleList = new IsmaurDAO().findAurByUbi(ismubi.getUbirfnum());
                	if(!OctashopUtils.isListEmpty(roleList)){
                		Long ubirfnum = ismubi.getUbirfnum();
                		long ubinum = ubirfnum.longValue();
                		sessionBean.setUserRefNo("" + ubinum);
                		sessionBean.setUserType("b");
                		sessionBean.setUserFName(null);
                		sessionBean.setUserLoginId(loginId);
                		sessionBean.setIpAddress(ipAddress);
                		sessionBean.setUserLoginPassword(passwordtemp);
                		session.setAttribute("SessionVariablesBean",sessionBean);
                		navigation = "success";
                		
                		// Added for embed the seller should come from session
                		
                		Ismsua ismsua = new Ismsua();
                		IsmsuaPK ismsuaPK = new IsmsuaPK();
                		ismsuaPK.setSuaubirfnum(ubirfnum);
                		ismsua.setComp_id(ismsuaPK);
                		List list2 = new IsmsuaDAO().findByExample(ismsua);
                		
                		if (list2.size() > 0) {
                			
                			Ismsua suaPojo = (Ismsua) list2.get(0);
                			Long ssirfnum = suaPojo.getComp_id().getSuassirfnum();
                			//if (ssirfnum != null && !ssirfnum.equals("")) {
                			if(!OctashopUtils.isObjectEmpty(ssirfnum)){	
                				sessionBean.setSellerRefNo(ssirfnum.toString());
                				//sessionBean.setSellerLogin(true);
                				return "gotoProductBasicInfo";
                			}
                		}
                	}
                	else {
                   	 	FacesMessage msg =I18nHelper.getMessage("invalid",null);                
                        ctx.addMessage(null, msg);
                	}
                } else {
                	 FacesMessage msg =I18nHelper.getMessage("invalidforism",null);                    
                     ctx.addMessage(
                            null, msg);
                }
            } else {
            	 FacesMessage msg =I18nHelper.getMessage("invalid",null);                
                 ctx.addMessage(
                        null, msg);
            }
        } catch (Exception e) {
            LOGGER.info("Message :: "+e.toString() +" Cause :: "+e.getCause());
        }
        return navigation;
    }

    /**
     * This method is used for Checking Octashop Login Id. Here it checks on Octashop only.this method is
     * called with in login_submitAction().
     * 
     * @param login
     * @return result
     * @throws DAOException
     */
    public Ismubi ismLogin(String login) {
        Ismubi ubi = null;
        try {
            ubi = new IsmubiDAO().findByUserId(login);
        } catch (DAOException e) {

            LOGGER.info("Message :: "+e.toString() +" Cause :: "+e.getCause());
        }
        return ubi;
    }
}