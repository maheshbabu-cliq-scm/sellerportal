package com.sellerportal.service;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sellerportal.model.Ismcnd;
import com.sellerportal.model.Ismubi;
import com.sellerportal.repository.LoginRepository;
import com.sellerportal.dao.IsmubiDAO;
import com.sellerportal.integra.impl.octashop.utils.OctashopUtils;
/**********************************************************************************
  		
  		@author Binod Kumar
  		
  		UserValidationActionBean class is the replacement to the SSO in Octashop.
  		It means when SSO is off then will use this class for bellow operations.
  
  		1.	To login Octashop User
 		2.	To authenticate Octashop User
 		3.	To save details of Octashop User
 		4.	To Change password of Octashop User
 		5.	To get Password of Octashop User
 		
 **********************************************************************************/

@Service
public class UserValidationActionBean {
	
	@Autowired
	private LoginRepository loginDao;
	
	public static boolean isUserExist(String loginId) {
		boolean isUserInDb = true;
		isUserInDb = new IsmubiDAO().isUserExists(loginId);
		return isUserInDb;
	}

	public static boolean login(String loginId, String endPass) {
		boolean isValidUser = true;
		isValidUser = new IsmubiDAO().checkValidLogin(loginId,endPass);
		return isValidUser;
	}

	public static boolean saveUser(String shoppingId, String shoppingPwd, String firstName, String lastName, Byte orgid) {
		IsmubiDAO ismubiDAO = new IsmubiDAO();
		Ismubi ismubi = new Ismubi();
		ismubi.setUbilogin(shoppingId);
		ismubi.setCommunicationEmail(shoppingId);
		ismubi.setUbipass(shoppingPwd);
		ismubi.setUbifname(firstName);
		ismubi.setUbilname(lastName);
		
		Ismcnd ismcndByUatcndTitle = new Ismcnd();
		ismcndByUatcndTitle.setCndrfnum(new Long("5"));
		ismubi.setIsmcnd(ismcndByUatcndTitle);
		
		ismubi.setUbiactive("Y");
		ismubi.setDeleted("N");
		ismubi.setCreatedate(new Date(System.currentTimeMillis()));
		ismubi.setModidate(new Date(System.currentTimeMillis()));
		ismubi.setCreatedby(new Long(0));
		//ismubi.setUbiusertype("W");
		
		Serializable serializable = ismubiDAO.save(ismubi);
		if(serializable != null){
			return true;	
		}
		else{
			return false;
		}
	}

	public static boolean changePassword(String shoppingId, String newPassword) {
		boolean pwdChangedSuccessfully = false;
		try {
			Ismubi ubi = (Ismubi) new IsmubiDAO().findByUserId(shoppingId);
			ubi.setUbipass(newPassword);
			String sDate1="01/01/2001";  
			    Date date1=new SimpleDateFormat("dd/MM/yyyy").parse(sDate1);  
			    ubi.setLoginBlockTime(date1);
			new IsmubiDAO().update(ubi);
			pwdChangedSuccessfully = true;
		} catch (Exception e) {
			pwdChangedSuccessfully = false;
		}
		return pwdChangedSuccessfully;
	}

	public static String getPassword(String shoppingId) {
		Ismubi ubi = new IsmubiDAO().findByUserId(shoppingId);
		return ubi.getUbipass();
	}

	public static boolean isSecondEmail(String loginId) {
		boolean isSecondEmail = true;
		isSecondEmail = new IsmubiDAO().isUserSecondEmail(loginId);
		return isSecondEmail;
	}

	public static boolean loginforBackend(String loginId, String endPass) {
		boolean isValidUser = true;
		isValidUser = new IsmubiDAO().checkValidLoginForBackend(loginId,endPass);
		return isValidUser;
	}
	public  boolean loginAction(String ubilogin, String ubipass) {
		
		boolean isValidUser = true;
		String loginid="";
		try {
			loginid = loginDao.findByUbiloginAndUbipass(ubilogin,ubipass);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(OctashopUtils.isNotEmpty(loginid))
		{
			isValidUser=true;
		}
		else
		{
			isValidUser=false;
		}
		return isValidUser;
	}
	
	public boolean loginUserAction(String loginId) {
		
		boolean isValidUser = true;
		String loginid = loginDao.checkValidLoginUser(loginId);
		if(OctashopUtils.isNotEmpty(loginid))
		{
			isValidUser=true;
		}
		else
		{
			isValidUser=false;
		}
		return isValidUser;
	}
	
}