/*
 *
 *
 */
package com.sellerportal.ism.bam.beans;

import javax.faces.component.html.HtmlCommandButton;
import javax.faces.component.html.HtmlInputSecret;
import javax.faces.component.html.HtmlInputText;

/**
 * @author:Binod Kumar
 * 
 * this is the backing bean for stagingLogin.jsp
 */
public class StagingLoginBean {
    private HtmlInputText loginId = new HtmlInputText();
    private HtmlInputSecret password = new HtmlInputSecret();
    private HtmlCommandButton login = new HtmlCommandButton();

    /**
     * @return Returns the login.
     */
    public HtmlCommandButton getLogin() {
        return login;
    }
    /**
     * @param login
     *            The login to set.
     */
    public void setLogin(HtmlCommandButton login) {
        this.login = login;
    }
    /**
     * @return Returns the loginId.
     */
    public HtmlInputText getLoginId() {
        return loginId;
    }
    /**
     * @param loginId
     *            The loginId to set.
     */
    public void setLoginId(HtmlInputText loginId) {
        this.loginId = loginId;
    }
    /**
     * @return Returns the password.
     */
    public HtmlInputSecret getPassword() {
        return password;
    }
    /**
     * @param password
     *            The password to set.
     */
    public void setPassword(HtmlInputSecret password) {
        this.password = password;
    }
    
    public String getActionBean() {
		return "StagingLoginActionBean";
	}
}