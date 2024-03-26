/*
 *
 */
package com.sellerportal.ism.bam.beans;


/**
 * @author:Binod Kumar
 * 
 * This is the backing bean for forgotPasswordStep1.jsp
 */
public class ForgotPasswordStep1Bean {
    private String forgotloginID;
    private String recovery;
    private String mobilenum;
    private String loginIdval;
    private String smscode;
    
   /* private HtmlCommandButton next = new HtmlCommandButton();*/

	/**
	 * @return the forgotloginID
	 */
	public String getForgotloginID() {
		return forgotloginID;
	}

	/**
	 * @param forgotloginID the forgotloginID to set
	 */
	public void setForgotloginID(String forgotloginID) {
		this.forgotloginID = forgotloginID;
	}

	public String getRecovery() {
		return recovery;
	}

	public void setRecovery(String recovery) {
		this.recovery = recovery;
	}

	

	public String getMobilenum() {
		return mobilenum;
	}

	public void setMobilenum(String mobilenum) {
		this.mobilenum = mobilenum;
	}

	public String getLoginIdval() {
		return loginIdval;
	}

	public void setLoginIdval(String loginIdval) {
		this.loginIdval = loginIdval;
	}

	public String getSmscode() {
		return smscode;
	}

	public void setSmscode(String smscode) {
		this.smscode = smscode;
	}

	

    /**
     * @return Returns the next.
     */
   /* public HtmlCommandButton getNext() {
        return next;
    }*/
    /**
     * @param next
     *            The next to set.
     */
   /* public void setNext(HtmlCommandButton next) {
        this.next = next;
    }*/
	
	
}