package com.sellerportal.ism;

import java.util.ArrayList;
import java.util.List;

public class ErrorMessagesBean {
	
	String errorMessage = null;
	List messageList = new ArrayList();
	String errorMessageGuestChkOut = null;
	String activeTab = null;
	/**
	 * @return Returns the errorMessage.
	 */
	public String getErrorMessage() {
		return errorMessage;
	}
	/**
	 * @param errorMessage The errorMessage to set.
	 */
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	/**
	 * @return Returns the messageList.
	 */
	public List getMessageList() {
		return messageList;
	}
	/**
	 * @param messageList The messageList to set.
	 */
	public void setMessageList(List messageList) {
		this.messageList = messageList;
	}
	/**
	 * @return the errorMessageGuestChkOut
	 */
	public String getErrorMessageGuestChkOut() {
		return errorMessageGuestChkOut;
	}
	/**
	 * @param errorMessageGuestChkOut the errorMessageGuestChkOut to set
	 */
	public void setErrorMessageGuestChkOut(String errorMessageGuestChkOut) {
		this.errorMessageGuestChkOut = errorMessageGuestChkOut;
	}
	/**
	 * @return the activeTab
	 */
	public String getActiveTab() {
		return activeTab;
	}
	/**
	 * @param activeTab the activeTab to set
	 */
	public void setActiveTab(String activeTab) {
		this.activeTab = activeTab;
	}

}