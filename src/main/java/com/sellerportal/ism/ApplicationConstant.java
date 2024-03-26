package com.sellerportal.ism;
/**
 * @author manojv
 *
 */
public interface ApplicationConstant {
	
	 public static final String SLAVE_USER_TYPE_CODE = "SLV";
	 public static final String SELLER_USER_TYPE_CODE = "SLR";
	 public static final String MP_USER_TYPE_CODE = "MP";
	 public static final String SLAVE_USER_TYPE = "slave";
	 public static final String SELLER_USER_TYPE = "seller";
	 public static final String MP_USER_TYPE = "admin";
	 public static final String FINE_L1_CATCODE="MPH19"; //@Deepak Deshekar
	 public static final String FASHION_L1_CATCODE="MPH20"; //@Deepak Deshekar
	 public static final String TSHIP="TSHIP";
	 public static final String SSHIP="SSHIP";
	 public static final String USER_TYPE_SELLER="Seller"; //@Shankar
	 public static final String custReturnReasongroup="CUST_CAT_RETURN_REASON";
	 public static final String custSubReturnReasongroup="CUST_CAT_SUB_RETURN_REASON";
	 //@Parag Start custom Manifest constants
	 public static final String  SHIPMENT_SUCCESSED="Shipment has been created successfully";
	 public static final String  SUCCESS="SUCCESS";
	 public static final String  FAIL="FAIL";
	 public static final String FAILED_TO_GENERATE_MANIFEST_PDF="Failed to Generate Manifest PDF";
	 public static final String  AWB_DOES_NOT_EXISTS_AGAINST_SHIPMENT="AWB Does Not Exists against Shipment";
	 public static final String SHIPMENT_ALREADY_IN_HOTC="Shipment Already in HOTC";
	 public static final String SHIPMENT_ALREADY_IN_HOTC_WO_PDF="Shipment Already in HOTC without PDF";
	 public static final String P1LOGISTIC_OF_SHIPMENT_IS_INVALID="p1logistic of Shipment is Invalid";
	 public static final String  SELLERCODE_OF_SHIPMENT_IS_INVALID="Sellercode of Shipment is Invalid";
	 public static final String DELIVERY_OF_SHIPMENT_IS_INVALID="Wrong Delivery Mode for Shipment";
	 public static final String TRANSPORT_OF_SHIPMENT_IS_INVALID="Wrong transport Mode for Shipment";
	 
	 //@Parag end custom Manifest constants
	 public static final String er_refund_Amt_limit="EARLY_REFUND_AMT_LIMIT"; //@Deepak Deshekar ::TPR -6575
	 public static final String ER_QCFAIL_APPROVAL_SEQ= "ER_QCFAIL_APPROVAL_SEQ";
	 public static final String ER_QCFAIL_REFUND_SEQ= "ER_QCFAIL_REFUND_SEQ";
	 public static final String REJECTION_REASON="REJECTION_REASON";
	 
	 //public static final String  Success="Success";
	 public static final String  success="success";
	 public static final String  failed="failed";
	 public static final String  CIR="CIR";
	 public static final String  RTO="RTO";
	 //Shankar Start : Inventory dashboard constants
	 public static final String  DUPSTOCKGT75="DUPSTOCKGT75";
	 public static final String  TOTAL="TOTAL";
	 public static final String  TOTALGT0="TOTALGT0";
	 public static final String  SUMGT0="SUMGT0";
	 public static final String  TOTALUPDATED="TOTALUPDATED";
	 public static final String  TOTALUPDATEDGT0="TOTALUPDATEDGT0";
	 public static final String  SUMUPDATEDGT0="SUMUPDATEDGT0";
	 public static final String  TOTALSTORES="TOTALSTORES";
	 public static final String  TOTALNEWSTORES="TOTALNEWSTORES";
	 public static final String  TOTALMISSINGSTORES="TOTALMISSINGSTORES";
	 public static final String  TOTALSKU="TOTALSKU";
	 public static final String  TOTALNEWSKU="TOTALNEWSKU";
	 public static final String  TOTALMISSINGSKU="TOTALMISSINGSKU";
	 public static final String  SLVTYPESKUUPDATED_STORE="SLVTYPESKUUPDATED_STORE";
	 public static final String  SLVTYPESKUUPDATED_WH="SLVTYPESKUUPDATED_WH";
	 public static final String  NZSKUGT30IN="NZSKUGT30IN";
	 public static final String  SLVTYPESKUIN_STORE="SLVTYPESKUIN_STORE";
	 public static final String  SLVTYPESKUIN_WH="SLVTYPESKUIN_WH";
	 public static final String  NZSKUGT30UPDATED="NZSKUGT30UPDATED";
	 public static final String  TOTALSTALESKU="TOTALSTALESKU";
	 public static final String  TOTALDELISTEDSKU="TOTALDELISTEDSKU";
	//Shankar End : Inventory dashboard constants
	 
	 //Shankar Start : Fee Commission
	 public static final String  P="P";
	 public static final String  F="F";
	 public static final String  LF="LF";
	 public static final String  SF="SF";
	 public static final String  PF="PF";
	 public static final String  OF="OF";
	 public static final String  CF="CF";
	//Shankar End : Fee Commission
	 //Parag start IN-103
	 
	 public static final String  PICKCONF = "PILIGENE,PICKCONF,ORDALLOC";
	 
	 public static final String SCANNED = "PICKCONF";
	 
	 public static final String HOTCOURI = "SCANNED,CNCINTED";
	 
	 public static final String QCFAILED = "RETUINIT,REVRSAWB,LOSTINIT,RETUIRTO";
	 
	 public static final String RETUCLOS = "RETUINIT,REVRSAWB,RETUIRTO";
	 
	 public static final String ORDREJEC = "ORDACCEP,PICKINPR,PILIGENE,PICKCONF";
	 
	 public static final String DELIVERD = "ORDCANCL,CLONCANC,RETUINIT,DELIVERD,LOSTINTT,RETTOORG,RETUCANC,SCANNED,CNCINTED,HOTCOURI";
	 
	 public static final String ORDUNCTD = "RDYCOLTN";
	 public static final String ORDCOLTD = "RDYCOLTN";
	//Parag start IN-103
	 public static final String SELLER_PATH="/seller_";
	 //Shankar Start : TPR-9732 
	 public static final String FILENAME_PRINTPICK = "Pick-List_";
	 public static final String FILENAME_PICKCONF = "PickConfirm_";
	 public static final String FILENAME_INITPACK = "TshipPackOrderStatusBulkDownload_";
	 //Shankar End : TPR-9732 
	 public static final String REJECT_REASON_PARAM_GROUP = "REJECTREASON"; //Shankar : Issue :Rejected Reason Activate
	 
	 //Shankar Start : TPR-11602
	 public static final String NOTIFY_TYPE_BK = "BK";
	 public static final String NOTIFY_TYPE_MG = "MG";
	 public static final String NOTIFICATION_URL_DISPUTE_RAISED = "/faces/oms/EarlyRefundQC.jsp";
	 public static final String NOTIFICATION_URL_DISPUTE_CLOSED = "/faces/oms/sellerDispute.jsp?submodel=CIR";
	 public static final String Resolved = "Resolved";
	 public static final String SLA_BREACHED = "Auto closure due to SLA breached";
	 //Shankar End : TPR-11602
	 //Shankar Start : TPR-10660 Fedex
	 public static final String LP_FEDEX = "FD";
	 public static final String TRANSPORT_MODE_AIR = "AIR";
	 public static final String TRANSPORT_MODE_SUR = "SUR";
	 public static final String PAYMENT_MODE_COD = "COD";
	 public static final String PAYMENT_MODE_PREPAID = "PREPAID";
	 //Shankar End : TPR-10660 Fedex
	 
	 //Aniket
	 public static final String REJECTION_REASON_SHD ="REJECTION_REASON_SHD";
 //Shankar Start : TPR-Return Automation
	 public static final String RNP = "REFNOPCK";
	 public static final String RTP = "REFTHPCK";
	 public static final String RVP = "REFONRVP";
	 public static final String RQC = "REFDONQC";
	 public static final String REFUNDTYPE = "REFUNDTYPE";
	 public static final String EARLYTYPE = "EARLYTYPE";
	 public static final String LITRTO = "LITRTO";
	 public static final String REFONRVP = "REFONRVP";
	 public static final String REFANDTHENPICKUP="REFANDTHENPICKUP";
	 public static final String EARLYRTO = "EARLYRTO";
	 public static final String EARLYLIT="EARLYLIT";
	 public static final String TICKET_SUBTYPE_RSP="RSP";
	 public static final String TICKET_SUBTYPE_RSS="RSS";
	 public static final String TICKET_SUBTYPE_RTS="RTS";
	 public static final String TICKET_SUBTYPE_RNP="RNP";
	 public static final String RNP_DESC = "Refund and no pick up";
	 public static final String RTP_DESC = "Refund then pick up";
	 public static final String RVP_DESC = "Refund on Reverse pick up";
	 public static final String RQC_DESC = "Refund on QC";
	 
	 public static final String REPL_RVP = "REPONRVP";
	 public static final String REPL_QC = "REPONQC";
	 public static final String REPL_RVP_DESC = "Replacement on RVP";
	 public static final String REPL_QC_DESC = "Replacement on QC";
	 //Shankar Start : TPR-Return Automation
	 
	 	 //Shankar Start : TPR-11937
	 public static final String SETTLEMENT_DATE = "Settlement Date";
	 public static final String SETTLEMENT_DUE_DATE = "Settlement Due Date";
	//Shankar End : TPR-11937
	 
	 public static final String PAYOUT_ISSUE_TYPE = "PAYOUT_ISSUE_TYPE";
	 public static final String TRANSACTIONID = "Transaction ID";
	 public static final String SELLERCODE = "Seller Code";
	 public static final String PAYMENTDATE = "Payment date";
	 public static final String AMOUNTRECEIVED = "Amount received";
	 public static final String ACTUALCOMMISSIONPERCHARGED = "Actual commission % charged";
	 public static final String ACTUALDISCREPANCYREASON = "Actual discrepancy reason";
	 public static final String ORDERSTATUS = "Order Status";
	 public static final String EXACTQUERYONPAYMENTCYCLE = "exact query on payment cycle";
	 public static final String TDSCERTIFICATE = "TDS related queries";
	 public static final String MONTHFORWHICHREPORTISREQUIRED = "Month for which report is required";
	 
	 public static final String TULPAN = "AACCT7290E";
	 public static final String TULCIN = "U74999MH2007PLC173035";
	 public static final String TULGSTIN = "27AACCT7290E1Z7";
	 public static final String TULBANKNAME = "Deutsche Bank";
	 public static final String TULBANKACCOUNTNO = "0679761000";
	 public static final String TULBANKADDRESS = "DB House Hazarimal Somani Marg Fort Mumbai 400001 (Branch -FORT)";
	 public static final String TULBANKIFSCCODE = "DEUT0784BBY";
	 public static final String PAYOUT_GSTIN_STATECODE_GROUP = "PAYOUT_GSTIN_STATECODE";
	 
	 public static final String REPLACEMENT_TYPE_HAND_ON_HAND = "Hand-On-Hand";
	 public static final String REPLACEMENT_TYPE_DEFERRED = "Deferred";
	 public static final String REPLACEMENT_VALUE_Y = "Y";
	 public static final String REPLACEMENT_VALUE_N = "N";
	 public static final String REPLACEMENT_RVP = "REPONRVP";
	 
	 //Reverse EwayBill Constants
	 public static final String DELIVERY_CHALLAN = "CHL";
	 public static final String SUPPLY_TYPE_INWARD = "INWARD";
	 public static final String SALES_RETURN = "SALES_RETURN";
	 public static final int SALES_RETURN_NUMERIC = 7;
	 public static final String CANCEL_REASON_CODE = "3";
	 public static final String CANCEL_REMARKS = "DATA_ENTRY_MISTAKE";
	 public static final String EWAY_BILL_CANCEL_FAILED = "Eway Bill Cancellation Failed";
	 public static final String REV_EWAY_BILL_ACTION_BEAN = "ReverseEwayBillActionBean";

	 public static final String LAST_MILE_DYNAMIC_OTP = "LastMileDynamicOTP";
	 public static final String YES = "Yes";
	 
	 public static final String LAT="lat";
	 public static final String LON="lon";
	 
	 public static final String TEMPORARY_FOLDER_DOWNLOAD_UPLOAD="tempFilePathForDownloadAndUpload";
}