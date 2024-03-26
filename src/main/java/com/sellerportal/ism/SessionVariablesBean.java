/*
 *
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package com.sellerportal.ism;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

@Component
public class SessionVariablesBean implements Serializable {

	/**
	 * 
	 */
	private int isLogin = 1;
	
	public int getIsLogin() {
		return isLogin;
	}

	public void setIsLogin(int isLogin) {
		this.isLogin = isLogin;
	}
	private String dayforExpiry;
	public String getDayforExpiry() {
		return dayforExpiry;
	}

	public void setDayforExpiry(String dayforExpiry) {
		this.dayforExpiry = dayforExpiry;
	}
	private static final long serialVersionUID = 1L;
	private String loginId;
	private String categoryRefNo;
	private String tabId;
	private String userRefNo;
	private String userType;
	private String userFName;
	private String sellerRefNo;
	private String sellerCode;
	private String slaveCode;
	/*private String productRefNo;*/
	//private String catelogueRefNo;
	private String stateMachine;
	private String omsUserRefNo;
	/*private String ccrRefNo;
	private boolean sellerLogin;
	private String availableNC;
	public String omsQueueUrl;*/
	private String userCode;
	private String userTypeCode;
	
	// FOR OMS PURPOSE
	private String omsUserRole;
	/*private boolean courierheader;
	private boolean normalheader;
	private boolean buttonFlag = false;
	private String openCount = null;
	private String closeCount = null;
	private String escCount = null;
	private String suppCount = null;
	private String caseType;*/
	private boolean iscourier;
	private boolean issalesreturn;
	private String userName;
	/*private String cssName = "default";
	private String potssishopno;
	private String pollQuestionRfNum;
	private String shippingOptionRfNum;*/
	private String profilePercentage;
	

	/**
	 * Dont Use Below 3 (userLoginId,userLoginPassword,moduleHomeLink) Variables
	 * Anywhere Now Onwords
	 **/
	private String userLoginId = null;
	private String userLoginPassword = null;
	private String moduleHomeLink = null;
	/*private String brandRefNo = null;
	private String bdcRefNo = null;
	private String entityRefNo = null;
	private String productReviewId = null;
	private String selectedOrder = null;
	private String msq;*/
	/*private String compaignId;
	private String loyaltyPoints = "0.00";*/
	
	private String corporateEmailAddrs;
	private String octSlvRfNum;
	private long loggedInTime=0l;
	private String inComplete;
	private String isSellerAccepted;
	private String isSellerApproved;
	private String isSellerProcessed;
	private String userLogoUrl;
	
	private String shipPartner;
	private String shipType;
	
	// Global Search @ Amit Mulay(17-02-16)
	private String globalSellerId;
	private String globalSlaveId;
	private String globalSeller;
	private String globalSlave;
	private String globalSelectionValue;
	private String globalOptionTextValue;
	
	//@Raju R2 Merged start
	private String slvType;
	private String isCNC;
	private String slaveType;
	private String isEnablement;
	//@Raju R2 Merged end
	
	//Gulab  R2  Start
	private List multiplesellerlist=new ArrayList();
	private List multipleslavelist=new ArrayList();
	//Gulab  R2  End
	
	private String totalSalesPrice;
	private String totaltaxAmt;
	private String grossTotal;
	private String isDisplayReports;
	private String isDisplayReportsForLink;
	private String isDisplayReportsR2;//For Display R2 Reports
	private String isDisplayReportsR2ForLink;//For Display R2 Reports
	private String totalDiscount;
	private String totalNetAmt;
	private String totalActualNetAmt;
	private String totalTaxableAmt;
	private String isSuperoms = "N";//superoms
	
	private String isAllowErPanel; //@Nishant TPR-6575
	private String isERPanelEligible; //Shankar
	private String maskCustData; //@Nishant
	private boolean isKercess=false; //@Nikhil.S TPR-12256
	private String keralaTaxableAmt;//@Nikhil.S TPR-12256
	private String keralaCessVal;//@Nikhil.S TPR-12256
	private String keralatotalcess;
	private String slrTypeLogoUrl;
	private String slrRatingType;
	private String slrRatingPdf;
	
	private String csrfToken;
	private String isContactInfoUpdateRequired;
	private String slaveFirstName;
	private String slavePhoneNumber;
	
	private String rtoTicketId;
	
	public String getTotalTaxableAmt() {
		return totalTaxableAmt;
	}

	public void setTotalTaxableAmt(String totalTaxableAmt) {
		this.totalTaxableAmt = totalTaxableAmt;
	}

	public String getTotalActualNetAmt() {
		return totalActualNetAmt;
	}

	public void setTotalActualNetAmt(String totalActualNetAmt) {
		this.totalActualNetAmt = totalActualNetAmt;
	}
	//R2.3 start
	private String isReturnToStore;
	//R2.3 end
	
	//R3.1 start
	private String isFineJewelleryEnable;
	//R3.1 end
	
	private String digitalslrType;//@Nikhil Need to change
	private String isDigitalSlr="N";//@Nikhil Need to change
	private Map<String,String> pageAuth;

	private String ipAddress;
	
	public String getGrossTotal() {
		return grossTotal;
	}

	public String getIsFineJewelleryEnable() {
		return isFineJewelleryEnable;
	}

	public void setIsFineJewelleryEnable(String isFineJewelleryEnable) {
		this.isFineJewelleryEnable = isFineJewelleryEnable;
	}

	public void setGrossTotal(String grossTotal) {
		this.grossTotal = grossTotal;
	}

	public String getTotaltaxAmt() {
		return totaltaxAmt;
	}

	public void setTotaltaxAmt(String totaltaxAmt) {
		this.totaltaxAmt = totaltaxAmt;
	}

	public String getTotalSalesPrice() {
		return totalSalesPrice;
	}

	public void setTotalSalesPrice(String totalSalesPrice) {
		this.totalSalesPrice = totalSalesPrice;
	}

	public String getTotalDiscount() {
		return totalDiscount;
	}

	public void setTotalDiscount(String totalDiscount) {
		this.totalDiscount = totalDiscount;
	}

	public String getTotalNetAmt() {
		return totalNetAmt;
	}

	public void setTotalNetAmt(String totalNetAmt) {
		this.totalNetAmt = totalNetAmt;
	}
	private String addlDiscount;
	public String getAddlDiscount() {
		return addlDiscount;
	}

	public void setAddlDiscount(String addlDiscount) {
		this.addlDiscount = addlDiscount;
	}

	
	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getModuleHomeLink() {
		return moduleHomeLink;
	}

	public void setModuleHomeLink(String moduleHomeLink) {
		this.moduleHomeLink = moduleHomeLink;
	}

	/*public String getPotssishopno() {
		return potssishopno;
	}

	public void setPotssishopno(String potssishopno) {
		this.potssishopno = potssishopno;
	}

	*//**
	 * @return Returns the cssName.
	 *//*
	public String getCssName() {
		return cssName;
	}

	*//**
	 * @param cssName
	 *            The cssName to set.
	 *//*
	public void setCssName(String cssName) {
		this.cssName = cssName;
	}*/

	/**
	 * @return Returns the userName.
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * @param userName
	 *            The userName to set.
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}

	/**
	 * @return Returns the buttonFlag.
	 */
	/*public boolean isButtonFlag() {
		return buttonFlag;
	}

	*//**
	 * @param buttonFlag
	 *            The buttonFlag to set.
	 *//*
	public void setButtonFlag(boolean buttonFlag) {
		this.buttonFlag = buttonFlag;
	}

	*//**
	 * @return Returns the caseType.
	 *//*
	public String getCaseType() {
		return caseType;
	}

	*//**
	 * @param caseType
	 *            The caseType to set.
	 *//*
	public void setCaseType(String caseType) {
		this.caseType = caseType;
	}

	*//**
	 * @return Returns the closeCount.
	 *//*
	public String getCloseCount() {
		return closeCount;
	}

	*//**
	 * @param closeCount
	 *            The closeCount to set.
	 *//*
	public void setCloseCount(String closeCount) {
		this.closeCount = closeCount;
	}

	*//**
	 * @return Returns the courierheader.
	 *//*
	public boolean isCourierheader() {
		return courierheader;
	}

	*//**
	 * @param courierheader
	 *            The courierheader to set.
	 *//*
	public void setCourierheader(boolean courierheader) {
		this.courierheader = courierheader;
	}

	*//**
	 * @return Returns the escCount.
	 *//*
	public String getEscCount() {
		return escCount;
	}

	*//**
	 * @param escCount
	 *            The escCount to set.
	 *//*
	public void setEscCount(String escCount) {
		this.escCount = escCount;
	}*/

	/**
	 * @return Returns the iscourier.
	 */
	public boolean isIscourier() {
		return iscourier;
	}

	/**
	 * @param iscourier
	 *            The iscourier to set.
	 */
	public void setIscourier(boolean iscourier) {
		this.iscourier = iscourier;
	}

	/**
	 * @return Returns the issalesreturn.
	 */
	public boolean isIssalesreturn() {
		return issalesreturn;
	}

	/**
	 * @param issalesreturn
	 *            The issalesreturn to set.
	 */
	public void setIssalesreturn(boolean issalesreturn) {
		this.issalesreturn = issalesreturn;
	}

	/**
	 * @return Returns the normalheader.
	 */
	/*public boolean isNormalheader() {
		return normalheader;
	}

	*//**
	 * @param normalheader
	 *            The normalheader to set.
	 *//*
	public void setNormalheader(boolean normalheader) {
		this.normalheader = normalheader;
	}

	*//**
	 * @return Returns the openCount.
	 *//*
	public String getOpenCount() {
		return openCount;
	}

	*//**
	 * @param openCount
	 *            The openCount to set.
	 *//*
	public void setOpenCount(String openCount) {
		this.openCount = openCount;
	}

	*//**
	 * @return Returns the suppCount.
	 *//*
	public String getSuppCount() {
		return suppCount;
	}

	*//**
	 * @param suppCount
	 *            The suppCount to set.
	 *//*
	public void setSuppCount(String suppCount) {
		this.suppCount = suppCount;
	}*/

	/**
	 * @return Returns the omsUserRole.
	 */
	public String getOmsUserRole() {
		return omsUserRole;
	}

	/**
	 * @param omsUserRole
	 *            The omsUserRole to set.
	 */
	public void setOmsUserRole(String omsUserRole) {
		this.omsUserRole = omsUserRole;
	}

	/*public String getOmsQueueUrl() {
		return omsQueueUrl;
	}

	public void setOmsQueueUrl(String omsQueueUrl) {
		this.omsQueueUrl = omsQueueUrl;
	}

	*//**
	 * @return Returns the availableNC.
	 *//*
	public String getAvailableNC() {
		return availableNC;
	}

	*//**
	 * @param availableNC
	 *            The availableNC to set.
	 *//*
	public void setAvailableNC(String availableNC) {
		this.availableNC = availableNC;
	}*/

	/**
	 * @return Returns the categoryRefNo.
	 */
	public String getCategoryRefNo() {
		return categoryRefNo;
	}

	/**
	 * @param categoryRefNo
	 *            The categoryRefNo to set.
	 */
	public void setCategoryRefNo(String categoryRefNo) {
		this.categoryRefNo = categoryRefNo;
	}

	/**
	 * @return Returns the catelogueRefNo.
	 */
	/*public String getCatelogueRefNo() {
		return catelogueRefNo;
	}

	*//**
	 * @param catelogueRefNo
	 *            The catelogueRefNo to set.
	 *//*
	public void setCatelogueRefNo(String catelogueRefNo) {
		this.catelogueRefNo = catelogueRefNo;
	}

	*//**
	 * @return Returns the productRefNo.
	 *//*
	public String getProductRefNo() {
		return productRefNo;
	}

	*//**
	 * @param productRefNo
	 *            The productRefNo to set.
	 *//*
	public void setProductRefNo(String productRefNo) {
		this.productRefNo = productRefNo;
	}*/

	/**
	 * @return Returns the sellerRefNo.
	 */
	public String getSellerRefNo() {
		return sellerRefNo;
	}

	/**
	 * @param sellerRefNo
	 *            The sellerRefNo to set.
	 */
	public void setSellerRefNo(String sellerRefNo) {
		this.sellerRefNo = sellerRefNo;
	}

	/**
	 * @return Returns the stateMachine.
	 */
	public String getStateMachine() {
		return stateMachine;
	}

	/**
	 * @param stateMachine
	 *            The stateMachine to set.
	 */
	public void setStateMachine(String stateMachine) {
		this.stateMachine = stateMachine;
	}

	/**
	 * @return Returns the userRefNo.
	 */
	public String getUserRefNo() {
		return userRefNo;
	}

	/**
	 * @return Returns the userType.
	 */
	public String getUserType() {
		return userType;
	}

	/**
	 * @param userType
	 *            The userType to set.
	 */
	public void setUserType(String userType) {
		this.userType = userType;
	}

	/**
	 * @param userRefNo
	 *            The userRefNo to set.
	 */
	public void setUserRefNo(String userRefNo) {
		this.userRefNo = userRefNo;
	}

	/**
	 * @return Returns the omsUserRefNo.
	 */
	public String getOmsUserRefNo() {
		return omsUserRefNo;
	}

	/**
	 * @param omsUserRefNo
	 *            The omsUserRefNo to set.
	 */
	public void setOmsUserRefNo(String omsUserRefNo) {
		this.omsUserRefNo = omsUserRefNo;
	}

	/**
	 * @return Returns the ccrRefNo.
	 *//*
	public String getCcrRefNo() {
		return ccrRefNo;
	}

	*//**
	 * @param ccrRefNo
	 *            The ccrRefNo to set.
	 *//*
	public void setCcrRefNo(String ccrRefNo) {
		this.ccrRefNo = ccrRefNo;
	}

	*//**
	 * @return Returns the sellerLogin.
	 *//*
	public boolean isSellerLogin() {
		return sellerLogin;
	}

	*//**
	 * @param sellerLogin
	 *            The sellerLogin to set.
	 *//*
	public void setSellerLogin(boolean sellerLogin) {
		this.sellerLogin = sellerLogin;
	}*/

	public String getLoginId() {
		return loginId;
	}

	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}

	public String getUserFName() {
		return userFName;
	}

	public void setUserFName(String userFName) {
		this.userFName = userFName;
	}

	/*public String getPollQuestionRfNum() {
		return pollQuestionRfNum;
	}

	public void setPollQuestionRfNum(String pollQuestionRfNum) {
		this.pollQuestionRfNum = pollQuestionRfNum;
	}*/

	public String getTabId() {
		return tabId;
	}

	public void setTabId(String tabId) {
		this.tabId = tabId;
	}

	public String getUserLoginId() {
		return userLoginId;
	}

	public void setUserLoginId(String userLoginId) {
		this.userLoginId = userLoginId;
	}

	public String getUserLoginPassword() {
		return userLoginPassword;
	}

	public void setUserLoginPassword(String userLoginPassword) {
		this.userLoginPassword = userLoginPassword;
	}

	/*public String getBrandRefNo() {
		return brandRefNo;
	}

	public void setBrandRefNo(String brandRefNo) {
		this.brandRefNo = brandRefNo;
	}

	public String getBdcRefNo() {
		return bdcRefNo;
	}

	public void setBdcRefNo(String bdcRefNo) {
		this.bdcRefNo = bdcRefNo;
	}

	public String getEntityRefNo() {
		return entityRefNo;
	}

	public void setEntityRefNo(String entityRefNo) {
		this.entityRefNo = entityRefNo;
	}

	*//**
	 * @return the shippingOptionRfNum
	 *//*
	public String getShippingOptionRfNum() {
		return shippingOptionRfNum;
	}

	*//**
	 * @param shippingOptionRfNum
	 *            the shippingOptionRfNum to set
	 *//*
	public void setShippingOptionRfNum(String shippingOptionRfNum) {
		this.shippingOptionRfNum = shippingOptionRfNum;
	}

	*//**
	 * @return the isMultipleCartItem
	 *//*
	public String getProductReviewId() {
		return productReviewId;
	}

	public void setProductReviewId(String productReviewId) {
		this.productReviewId = productReviewId;
	}

	public String getMsq() {
		return msq;
	}

	public void setMsq(String msq) {
		this.msq = msq;
	}


	*//**
	 * @return the selectedOrder
	 *//*
	public String getSelectedOrder() {
		return selectedOrder;
	}

	*//**
	 * @param selectedOrder
	 *            the selectedOrder to set
	 *//*
	public void setSelectedOrder(String selectedOrder) {
		this.selectedOrder = selectedOrder;
	}*/

	public String getCorporateEmailAddrs() {
		return corporateEmailAddrs;
	}

	public void setCorporateEmailAddrs(String corporateEmailAddrs) {
		this.corporateEmailAddrs = corporateEmailAddrs;
	}

	public String getOctSlvRfNum() {
		return octSlvRfNum;
	}

	public void setOctSlvRfNum(String octSlvRfNum) {
		this.octSlvRfNum = octSlvRfNum;
	}

	public String getProfilePercentage() {
		return profilePercentage;
	}

	public void setProfilePercentage(String profilePercentage) {
		this.profilePercentage = profilePercentage;
	}

	public String getUserCode() {
		return userCode;
	}

	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}

	public long getLoggedInTime() {
		return loggedInTime;
	}

	public void setLoggedInTime(long loggedInTime) {
		this.loggedInTime = loggedInTime;
	}

	public String getInComplete() {
		return inComplete;
	}

	public void setInComplete(String inComplete) {
		this.inComplete = inComplete;
	}

	/**
	 * @return the isSellerAccepted
	 */
	public String getIsSellerAccepted() {
		return isSellerAccepted;
	}

	/**
	 * @param isSellerAccepted the isSellerAccepted to set
	 */
	public void setIsSellerAccepted(String isSellerAccepted) {
		this.isSellerAccepted = isSellerAccepted;
	}

	public String getIsSellerApproved() {
		return isSellerApproved;
	}

	public void setIsSellerApproved(String isSellerApproved) {
		this.isSellerApproved = isSellerApproved;
	}

	public String getIsSellerProcessed() {
		return isSellerProcessed;
	}

	public void setIsSellerProcessed(String isSellerProcessed) {
		this.isSellerProcessed = isSellerProcessed;
	}

	public String getUserLogoUrl() {
		return userLogoUrl;
	}

	public void setUserLogoUrl(String userLogoUrl) {
		this.userLogoUrl = userLogoUrl;
	}

	public String getUserTypeCode() {
		return userTypeCode;
	}

	public void setUserTypeCode(String userTypeCode) {
		this.userTypeCode = userTypeCode;
	}

	public String getShipPartner() {
		return shipPartner;
	}

	public void setShipPartner(String shipPartner) {
		this.shipPartner = shipPartner;
	}

	public String getShipType() {
		return shipType;
	}

	public void setShipType(String shipType) {
		this.shipType = shipType;
	}

	public String getSellerCode() {
		return sellerCode;
	}

	public void setSellerCode(String sellerCode) {
		this.sellerCode = sellerCode;
	}

	public String getSlaveCode() {
		return slaveCode;
	}

	public void setSlaveCode(String slaveCode) {
		this.slaveCode = slaveCode;
	}

	public String getGlobalSellerId() {
		return globalSellerId;
	}

	public void setGlobalSellerId(String globalSellerId) {
		this.globalSellerId = globalSellerId;
	}

	public String getGlobalSlaveId() {
		return globalSlaveId;
	}

	public void setGlobalSlaveId(String globalSlaveId) {
		this.globalSlaveId = globalSlaveId;
	}

	public String getGlobalSeller() {
		return globalSeller;
	}

	public void setGlobalSeller(String globalSeller) {
		this.globalSeller = globalSeller;
	}

	public String getGlobalSlave() {
		return globalSlave;
	}

	public void setGlobalSlave(String globalSlave) {
		this.globalSlave = globalSlave;
	}

	public String getGlobalSelectionValue() {
		return globalSelectionValue;
	}

	public void setGlobalSelectionValue(String globalSelectionValue) {
		this.globalSelectionValue = globalSelectionValue;
	}

	public String getGlobalOptionTextValue() {
		return globalOptionTextValue;
	}

	public void setGlobalOptionTextValue(String globalOptionTextValue) {
		this.globalOptionTextValue = globalOptionTextValue;
	}

	public String getSlvType() {
		return slvType;
	}

	public void setSlvType(String slvType) {
		this.slvType = slvType;
	}

	public String getIsCNC() {
		return isCNC;
	}

	public void setIsCNC(String isCNC) {
		this.isCNC = isCNC;
	}

	public String getSlaveType() {
		return slaveType;
	}

	public void setSlaveType(String slaveType) {
		this.slaveType = slaveType;
	}

	public String getIsEnablement() {
		return isEnablement;
	}

	public void setIsEnablement(String isEnablement) {
		this.isEnablement = isEnablement;
	}

	public List getMultiplesellerlist() {
		return multiplesellerlist;
	}

	public void setMultiplesellerlist(List multiplesellerlist) {
		this.multiplesellerlist = multiplesellerlist;
	}

	public List getMultipleslavelist() {
		return multipleslavelist;
	}

	public void setMultipleslavelist(List multipleslavelist) {
		this.multipleslavelist = multipleslavelist;
	}

	public String getIsDisplayReports() {
		return isDisplayReports;
	}

	public void setIsDisplayReports(String isDisplayReports) {
		this.isDisplayReports = isDisplayReports;
	}

	public String getIsDisplayReportsForLink() {
		return isDisplayReportsForLink;
	}

	public void setIsDisplayReportsForLink(String isDisplayReportsForLink) {
		this.isDisplayReportsForLink = isDisplayReportsForLink;
	}

	public String getIsDisplayReportsR2() {
		return isDisplayReportsR2;
	}

	public void setIsDisplayReportsR2(String isDisplayReportsR2) {
		this.isDisplayReportsR2 = isDisplayReportsR2;
	}

	public String getIsDisplayReportsR2ForLink() {
		return isDisplayReportsR2ForLink;
	}

	public void setIsDisplayReportsR2ForLink(String isDisplayReportsR2ForLink) {
		this.isDisplayReportsR2ForLink = isDisplayReportsR2ForLink;
	}

	public String getIsReturnToStore() {
		return isReturnToStore;
	}

	public void setIsReturnToStore(String isReturnToStore) {
		this.isReturnToStore = isReturnToStore;
	}

	public String getIsSuperoms() {
		return isSuperoms;
	}

	public void setIsSuperoms(String isSuperoms) {
		this.isSuperoms = isSuperoms;
	}

	public String getIsAllowErPanel() {
		return isAllowErPanel;
	}

	public void setIsAllowErPanel(String isAllowErPanel) {
		this.isAllowErPanel = isAllowErPanel;
	}

	public String getIsERPanelEligible() {
		return isERPanelEligible;
	}

	public void setIsERPanelEligible(String isERPanelEligible) {
		this.isERPanelEligible = isERPanelEligible;
	}
	
		public String getDigitalslrType() {
		return digitalslrType;
	}

	public void setDigitalslrType(String digitalslrType) {
		this.digitalslrType = digitalslrType;
	}

	public String getIsDigitalSlr() {
		return isDigitalSlr;
	}

	public void setIsDigitalSlr(String isDigitalSlr) {
		this.isDigitalSlr = isDigitalSlr;
	}

	public String getMaskCustData() {
		return maskCustData;
	}

	public void setMaskCustData(String maskCustData) {
		this.maskCustData = maskCustData;
	}

	public boolean isKercess() {
		return isKercess;
	}

	public void setKercess(boolean isKercess) {
		this.isKercess = isKercess;
	}

	public String getKeralaTaxableAmt() {
		return keralaTaxableAmt;
	}

	public void setKeralaTaxableAmt(String keralaTaxableAmt) {
		this.keralaTaxableAmt = keralaTaxableAmt;
	}

	public String getKeralaCessVal() {
		return keralaCessVal;
	}

	public void setKeralaCessVal(String keralaCessVal) {
		this.keralaCessVal = keralaCessVal;
	}

	public String getKeralatotalcess() {
		return keralatotalcess;
	}

	public void setKeralatotalcess(String keralatotalcess) {
		this.keralatotalcess = keralatotalcess;
	}

	public Map<String, String> getPageAuth() {
		return pageAuth;
	}

	public void setPageAuth(Map<String, String> pageAuth) {
		this.pageAuth = pageAuth;
	}

	public String getSlrTypeLogoUrl() {
		return slrTypeLogoUrl;
	}
	
	public void setSlrTypeLogoUrl(String slrTypeLogoUrl) {
		this.slrTypeLogoUrl = slrTypeLogoUrl;
	}
	
	public String getSlrRatingType() {
		return slrRatingType;
	}
	
	public void setSlrRatingType(String slrRatingType) {
		this.slrRatingType = slrRatingType;
	}

	public String getSlrRatingPdf() {
		return slrRatingPdf;
	}

	public void setSlrRatingPdf(String slrRatingPdf) {
		this.slrRatingPdf = slrRatingPdf;
	}

	public String getCsrfToken() {
		return csrfToken;
	}

	public void setCsrfToken(String csrfToken) {
		this.csrfToken = csrfToken;
	}
	
	public String getIpAddress() {
		return ipAddress;
	}

	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}

	public String getIsContactInfoUpdateRequired() {
		return isContactInfoUpdateRequired;
	}

	public void setIsContactInfoUpdateRequired(String isContactInfoUpdateRequired) {
		this.isContactInfoUpdateRequired = isContactInfoUpdateRequired;
	}

	public String getSlaveFirstName() {
		return slaveFirstName;
	}

	public void setSlaveFirstName(String slaveFirstName) {
		this.slaveFirstName = slaveFirstName;
	}

	public String getSlavePhoneNumber() {
		return slavePhoneNumber;
	}

	public void setSlavePhoneNumber(String slavePhoneNumber) {
		this.slavePhoneNumber = slavePhoneNumber;
	}

	public String getRtoTicketId() {
		return rtoTicketId;
	}

	public void setRtoTicketId(String rtoTicketId) {
		this.rtoTicketId = rtoTicketId;
	}

}