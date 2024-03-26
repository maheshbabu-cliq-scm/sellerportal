package com.sellerportal.ism.bam.beans;

import javax.faces.bean.ManagedBean;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

/**
 * @author:Binod Kumar
 * This is the backing bean for login.jsp
 */
@Component
public class UserLoginBean {
	
	private String loginId;
	private String password;
    private String message;
    private String captchaG;
    private String captchaR;
    private Long attemptCount;
    
		public String getMessage() {
			return message;
		}
		public void setMessage(String message) {
			this.message = message;
		}
		 public String getLoginId() {
				return loginId;
		}
		public void setLoginId(String loginId) {
			this.loginId = loginId;
		}
		public String getPassword() {
			return password;
		}
		public void setPassword(String password) {
			this.password = password;
		}
		
		public String getActionBean(){
			return "UserLoginActionBean";
		}
		public String getCaptchaG() {
			return captchaG;
		}
		public void setCaptchaG(String captchaG) {
			this.captchaG = captchaG;
		}
		public String getCaptchaR() {
			return captchaR;
		}
		public void setCaptchaR(String captchaR) {
			this.captchaR = captchaR;
		}
		public void setAttemptCount(Long attemptCount) {
			this.attemptCount = attemptCount;
		}
		
		public Long getAttemptCount() {
			return attemptCount;
		}
		
		
}