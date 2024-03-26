/*
 *
 */
package com.sellerportal.ism.bam.beans;

/**
 * @author:Kunal
 * 
 * This is the backing bean for reset Password
 */
public class StagingResetPasswordBean {
	
	private String loginId;	
	private String emailauthcode;
	private String ubiRfNum;
	private String password1;
	private String password2;
	
	
	public String getUbiRfNum() {
		return ubiRfNum;
	}

	public void setUbiRfNum(String ubiRfNum) {
		this.ubiRfNum = ubiRfNum;
	}

	public String getLoginId() {
		return loginId;
	}

	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}

	public String getEmailauthcode() {
		return emailauthcode;
	}


	public void setEmailauthcode(String emailauthcode) {
		this.emailauthcode = emailauthcode;
	}


	public String getPassword1() {
		return password1;
	}

	public void setPassword1(String password1) {
		this.password1 = password1;
	}

	public String getPassword2() {
		return password2;
	}

	public void setPassword2(String password2) {
		this.password2 = password2;
	}

	public String getActionBean() {
		return "UserLoginActionBean";
	}
	
	
    }