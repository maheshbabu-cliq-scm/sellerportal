/**
 * 
 */
package com.sellerportal.tisl.oms.utils;


/**
 * @author pramod
 *
 */
public interface OmsStatusMasterInterface {
	//Order Receiving 
	public final String ORDER_ALLOCATE = "ORDALLOC"; 
	public final String ORDER_ACCEPTED = "ORDACCEP";
	public final String ORDER_REJECTED = "ORDREJEC";
	public final String ORDER_REALLOCATED = "ODREALOC";
	public final String LP_PENDING_ASSIGNED = "LPPNASIGN";
	//Pack Process
	public final String PACK_LIST_GENERATED = "PILIGENE";
	public final String PACKED = "SCANNED";//no
	//Pick Process
	public final String PICK_IN_PROCESS = "PICKINPR";
	public final String PICK_CONFIRMED = "PICKCONF";
	public final String PICK_HOLD = "PICKHOLD";
	//Order Cancellation
	public final String ORDER_CANCELLATION = "ORDCANCL";
	public final String CLOSE_ON_CANCELLATION = "CLONCANC";
	public final String CNC_INITIATED="CNCINTED";
	//Re-Dispatch Management	
	public final String RE_DISPATCH_LINITIATED = "REDIINIT";


	//Shipment & Invoice Process	
	public final String AWD_ASSIGNED = "AWBASSIG";
	public final String PRINT_SHIPING_LABLE = "PRISHLAB";
	public final String INVOICE_GENERATED = "INVOGENE";
	public final String PRINT_INVOICE = "PRIINVOI";
	public final String MANIFESTRO_PENDING = "MANIPEND";
	public final String READY_TO_SHIP = "RETOSHIP";
	public final String LOGISTIC_PARTNER_SWITCH = "LPSWITCH";
	public final String HANDED_OVER_TO_COURIER = "HOTCOURI";
	public final String REACHED_NEAREST_HUB = "RENEARHB";
	public final String DELIVERED = "DELIVERD";
	public final String SHIPMENT_RECIVE_AT_ORIGIN = "SRECTORI";
	//Refund Management
	public final String REFUND_INITIATED = "REFUINIT";
	public final String REFUND_IN_PROCESS = "REFINPRO";
	public final String REFUND_IN_CLOSE = "REFCLOSE";
	public final String COD_CLOSED_WITHOUT_REFUND = "CODCWRND";
    //Return Management	
	public final String RETURN_TO_ORIGIN = "RETTOORG";
	public final String RETURN_INITIATED ="RETUINIT";
	public final String RETURN_INITIATED_BY_CUSTOMER ="RETUINIT_CUSTOMER";
	public final String RETURN_INITIATED_BY_RTO ="RETUINIT_RTO";
	public final String RETURN_TO_CLOSE = "RETUCLOS";
	public final String RETURN_TO_CANCELLED  = "RETUCANC";
	public final String CLOSED_ON_RETURN_TO_ORIGIN = "CLRETORI";
	public final String REVERSE_AWB_ASSIGNED="REVRSAWB"; //no
	public final String SHIPMENT_RECEIVED_AT_ORIGIN ="SRECTORI";
	public final String QC_FAILED="QCFAILED";//no
	public final String LOST_IN_TRANSIT = "LOSTINTT"; //no
	public final String TRANSACTION_HOLD = "TXCTNHLD";
	public final String RETURN_REJECTED = "RETREJEC";
	
	
	//CS: SPD OMS-20
	public final String PICK_UP_REQUEST_CONFIRMED = "PKUPRQCF";
	public final String PICK_UP_SCHEDULED = "PKUPSCLD";
	public final String OUT_FOR_RETURN_PICKUP = "OTFRRTPK";
	public final String PICK_UP_ATTEMPT_UNSUCCESSFUL = "PKUPATUS";
	public final String DOORSTEP_QC_FAIL = "DRSPQCFL";
	public final String DOORSTEP_QC_PASS = "DRSPQCPS";
	public final String RETURN_PICKED_UP = "RTRNPKUP";
	public final String RETURN_IN_TRANSIT = "RTNINTST";
	public final String OUT_FOR_RETURN_DELIVERY = "OTFRRTDL";
	public final String RETURN_LOST_IN_TRANSIT = "RTNLSINT";
	public final String RETURN_DELIVERED_TO_SELLER = "RTNDELSL";
	public final String RETURN_CANCELLED_BY_LP = "RETCNCLP";
	
	//Jyoti TPR 14040
	public final String PICKUP_CANCELLED_BY_LP = "PKUPCNLP";

	
	//Ticket Management
	public final String ORDER_CANCEL="ORDCANCL";
	public final String ORDER_RETURN="REFUINIT";
	public final String UNDELIVERED_ORDERS="RETTOORG";
	public final String REPLACEMENT_ORDERS="ReplacementInitiated";
	public final String SHIPTYPE_GROUP="SHIPTYPE";
	public final String SHIPPARTNER_GROUP="SHIPPARTNER";
	
	public final String SHIPPING_FEE="SF";
	public final String GATEWAY_FEE="PF";
	public final String COD_FEE="OF";
	public final String LISTING_FEE="LF";
	public final String Other_Fee="OF";
	
	public final String FULFILLMENT_TYPE_TSHIP="TSHIP";
	public final String FULFILLMENT_TYPE_SSHIP="SSHIP";
	
	public final String DELIVERY_MODE_HD="HD";
	public final String DELIVERY_MODE_ED="ED";
	
	public final String CANCEL_TICKET_FLAG="C";
	public final String RETURN_TICKET_FLAG="R";
	public final String YES ="Y";
	public final String NO ="N";
	public final String GATI ="GT";
	public final String GOJAVA ="GJ";
	public final String BLUE_DART ="BD";
	public final String FEDEX ="FD";
	
	public final String TRANSPORT_MODE_AIR="AIR";
	public final String TRANSPORT_MODE_SURFACE="SUR";
	
	public final String Delivery_TYPE_CNC="CNC";
	public final String SUBORDER_TYPE_CNC="CNC";
	public final String ORDER_UNCOLLECTED="ORDUNCTD";
	
	//For Images
	public final String GETCOUR_FUNCTION_NAME = "getCour";
	public final String FILE_ITEMS_REQ_ATTR_NAME = "parseUpload";
	public final String COURIER_IMG_PREFIX = "imgFile";
	
	public final String CODE_ORDALLOC = "001";
	
	public final String CODE_ORDACCEP = "002";
	
	public final String CODE_ORDREJEC = "003";

	public final String CODE_PICKINPR = "004";

	public final String CODE_PICKHOLD = "005";

	public final String CODE_PICKCONF = "006";

	public final String CODE_PILIGENE = "007";

	public final String CODE_SCANNED = "008";

	public final String CODE_AWBASSIG = "009";

	public final String CODE_PRISHLAB = "010";

	public final String CODE_INVOGENE = "011";

	public final String CODE_PRIINVOI = "012";

	public final String CODE_MANIPEND = "013";

	public final String CODE_RETOSHIP = "014";

	public final String CODE_LPSWITCH = "015";

	public final String CODE_HOTCOURI = "016";

	public final String CODE_RENEARHB = "017";

	public final String CODE_DELIVERD = "018";

	public final String CODE_ORDCANCL = "019";

	public final String CODE_CLONCANC = "020";

	public final String CODE_REFUINIT = "021";

	public final String CODE_REFINPRO = "022";

	public final String CODE_REFCLOSE = "023";

	public final String CODE_RETTOORG = "024";

	public final String CODE_RETUINIT = "025";

	public final String CODE_SRECTORI = "026";

	public final String CODE_RETUCANC = "027";

	public final String CODE_RETUCLOS = "028";

	public final String CODE_REDIINIT = "029";

	public final String CODE_CLRETORI = "030";

	public final String CODE_QCFAILED = "031";

	public final String CODE_REVRSAWB = "032";

	public final String CODE_LOSTINTT = "033";

	public final String CODE_PKUPCNLP = "046";
	
    public final String ORDALLOC = "ORDALLOC";
	
	public final String ORDACCEP = "ORDACCEP";
	
	public final String ORDREJEC = "ORDREJEC";

	public final String PICKINPR = "PICKINPR";

	public final String PICKHOLD = "PICKHOLD";

	public final String PICKCONF = "PICKCONF";

	public final String PILIGENE = "PILIGENE";

	public final String SCANNED = "SCANNED";

	public final String AWBASSIG = "AWBASSIG";

	public final String PRISHLAB = "PRISHLAB";

	public final String INVOGENE = "INVOGENE";

	public final String PRIINVOI = "PRIINVOI";

	public final String MANIPEND = "MANIPEND";

	public final String RETOSHIP = "RETOSHIP";

	public final String LPSWITCH = "LPSWITCH";

	public final String HOTCOURI = "HOTCOURI";

	public final String RENEARHB = "RENEARHB";

	public final String DELIVERD = "DELIVERD";

	public final String ORDCANCL = "ORDCANCL";

	public final String CLONCANC = "CLONCANC";

	public final String REFUINIT = "REFUINIT";

	public final String REFINPRO = "REFINPRO";

	public final String REFCLOSE = "REFCLOSE";

	public final String RETTOORG = "RETTOORG";

	public final String RETUINIT = "RETUINIT";

	public final String SRECTORI = "SRECTORI";

	public final String RETUCANC = "RETUCANC";

	public final String RETUCLOS = "RETUCLOS";

	public final String REDIINIT = "REDIINIT";

	public final String CLRETORI = "CLRETORI";

	public final String QCFAILED = "QCFAILED";

	public final String REVRSAWB = "REVRSAWB";
	
	public final String LOSTINTT = "LOSTINTT";
	
	//Courier Inbound	
	public final String RETURN_INITIATED_INBOUND= "RETUINIT";
	public final String RETURN_INITIATED_BY_RTO_INBOUND="RETUIRTO";
	public final String REVERSE_AWB_ASSIGNED_INBOUND="REVRSAWB";
	public final String RETURN_TO_ORIGIN_INBOUND="RETTOORG";
	public final String HANDED_OVER_TO_COURIER_INBOUND="HOTCOURI";
	public final String SUBORDER_CNC="CNC";
	public final String SUBORDER_NDR="NDR";
	public final String SUBORDER_RTO="RTO";
	public final String SUBORDER_CIR="CIR";
	public final String RETUCLOS_INBOUND = "RETUCLOS";
	public final String RETUCANC_INBOUND = "RETUCANC";
	public final String RDYCOLTN_INBOUND="RDYCOLTN";
	public final String ORDER_COLLECTED="ORDCOLTD";

	public final String ORDER_NOT_ASSIGNED="ORDPNASG";
	public final String Status_Updated_For_CNC ="Status Updated For CNC.";
	
	public final String READY_FOR_INWARD = "Ready For Inward";
	public final String AWAITING_FOR_TICKET_RTO = "Awaiting For Ticket";
	public final String AWAITING_FOR_TICKET_CIR = "Awaiting For Ticket Not Assigned";
	public final String AWAITING_FOR_REVAWB_CIR = "Awaiting For REVRSAWB Not Assigned";
	
	//@Rohit TPR-6074 CNC API Start
	public final String CODE_ORDCOLTD = "020";
	public final String CODE_ORDUNCTD = "021";
	public final String CNC = "CNC";
	
	public final String QCPASS = "QCPASS";
	public final String LIT = "LIT";
	
	//@Deepak Deshekar :: TPR -6575 or 7488 Start
	public final String ERRETUPICK= "ERRETUPICK";
	public final String ERRETUDEL= "ERRETUDEL";
	public final String ERRETULIT = "ERRETULIT";
	public final String ERAPPROVALPEND = "ERAPPROVALPEND";
	public final String ERQCPASS = "ERQCPASS";
	public final String ERQCFAILED = "ERQCFAILED";
	public final String ERQCFAPPROVED = "ERQCFAPPROVED";
	public final String ERQCFREJECT = "ERQCFREJECT";
	public final String ERLITAPPROVED = "ERLITAPPROVED";
	public final String ERLITREJECT =  "ERLITREJECT";
	/*public final String ERRETUPICK_RFNUM= "2421";
	public final String ERRETUDEL_RFNUM= "2422";
	public final String ERRETULIT_RFNUM= "2423";
	public final String ERQCFAIL_RFNUM= "2426";*/
	
	public final String ERRETUPICK_RFNUM= "2606"; //Jyoti Reverse status tracking
	public final String ERRETUDEL_RFNUM= "2610";
	public final String ERRETULIT_RFNUM= "2609";
	public final String ERQCFAIL_RFNUM= "2426";
	public final String RTODELVRD_RFNUM= "2437";
	public final String ONHOLDREPL_RFNUM= "2616";
	public final String REPLINIT_RFNUM= "2614";
	public final String CNCLBYTUL_RFNUM= "2619";
	public final String LOSTINTT_RFNUM= "2230";
	public final String QCFAILED_RFNUM= "2238";
	
	//@Deepak Deshekar :: TPR -6575 or 7488 Start
	//@Parag :: IN-91 start
	public final String RET_TO_ORG =  "2242";
	public final String RETU_INIT   ="2241";
	//@Parag :: IN-91 end
	
	//@Rohit RDYCOLTN 
	public final String READY_FOR_COLLECTION =  "RDYCOLTN";
	//@Nishant
	public final String RETUIRTO =  "2403";
	public final String REVRSAWBRFNUM="2240";
	public final String RETUCLOSRFNUM="2236";
	
		
	//@nikhil.Shinge TPR-9732_Reject reason start
	public final String REJECTREASON = "REJECTREASON"; 
	public final String COURIEROUTBOUND_REJECTREASON = "Rejected by system"; 
	//@nikhil.Shinge TPR-9732_Reject reason end
	
	//@Nikhil.S TPR-6670 
	public final String CHANNEL= "ORDER_PLACED_CHANNEL";
	public final String ALL_LIST= "ALL_LIST";
	public final String FULLFILLSLAVE= "SLV_TYPE";
	public final String DELIVERYTYPE= "SHIPTYPE";
	
	//@Rohit New Rejection Reason Code Start
	public final String DEFAULT_REJECT_REASON= "06";
	//@Rohit New Rejection Reason Code End
	
		//@Deepak Deshekar :: DIGI Agreement Start
	public final String DIGIDOCSTATUS = "DIGIDOCSTATUS";
	public final String PENCMSENDAPPROVAL = "PENCMSENDAPPROVAL";
	
	public final String CMDRAFT = "CMDRAFT";
	public final String DRAFT = "DRAFT";
	public final String CMSENDAPPROVAL = "CMSENDAPPROVAL";
	public final String FINAPPROVE = "FINANCEAPPROVE";
	public final String FINREJECT = "FINREJECT";
	public final String LEGAPPROVE = "LEGAPPROVE";
	public final String LEGREJECT = "LEGREJECT";
	public final String SLRACCEPT = "SLRACCEPT";
	public final String SLRREJECT = "SLRREJECT";
	public final String FINANCESENDFORAPPROVAL = "FINANCESENDFORAPPROVAL";	
	public final String AGREAPPROVED = "AGREAPPROVED";
	public final String CHODSENDFORAPPROVAL = "CHODSENDFORAPPROVAL";
	public final String CHODREJECT = "CHODREJECT";
	public final String CHODAPPROVE = "CHODAPPROVE";
	public final String CMREJECT = "CMREJECT";
	public final String LEGALSENDFORAPPROVAL = "LEGALSENDFORAPPROVAL";
	public final String SELLERSENDFORAPPROVAL = "SELLERSENDFORAPPROVAL";
	public final String SELLERDISPUTERAISE = "SELLERDISPUTERAISE";
	public final String FEESAPPROVED = "FEESAPPROVED";
	public final String PENALTYSUBMITTED = "PENALTYSUBMITTED";
	//@Deepak Deshekar :: DIGI Agreement Start

	//@Rohit Start ::: TPR-8560 Digitizing Seller Agreement 
	public final String DIGI_COMM_TYPE = "DA_COMM_TYPE";
	public final String LIST_COMM_RANGE = "DA_COMM_TYPE_LIST";
	public final String DA_BULK_UPLOAD_STATE = "BULKUPLOAD";
	//@Rohit End ::: TPR-8560 Digitizing Seller Agreement
	
	//@Maggi Start 
	public final String FINANCE_REJ = "DIGI_REJECTED_BY_FINANCE_EMAIL";
	public final String LEGAL_REJ = "DIGI_REJ_BY_LEGAL_EMAIL";
	public final String SELLER_REJ = "DIGI_REJ_BY_SELLER_EMAIL";
	public final String LEG_PEND = "DIGITAL_LEG_PEND_FOR_APP_EMAIL";
	public final String FIN_PEND = "DIGITAL_FIN_PEND_FOR_APP_EMAIL";
	public final String CATEGORY_MANAGER_REJ = "DIGI_REJ_BY_CATMANAG_EMAIL";
	public final String CATEGORY_HOD_REJ = "DIGI_REJ_BY_CATHOD_EMAIL";
	public final String CATEGORY_HOD_PEND = "DIGITAL_HOD_PEND_FOR_APP_EMAIL";	 
	public final String CATMANAG_APP = "DIGI_APPR_BY_CATMANAG_EMAIL";
	public final String CATHOD_APP = "DIGI_APPR_BY_CATHOD_EMAIL";
	public final String SELLER_PEND="DIGITAL_SELLER_PENDING_EMAIL"; 
	public final String CATMANAG_PEND = "DIGITAL_CM_PEND_FOR_APP_EMAIL";
	public final String SLR_DISPUTE_RAISED = "DIGITAL_SLR_DISPUTE_EMAIL";
	public final String ALL_COMMISSION_MAIL = "DIGITAL_APPROVE_EMAIL";
	//Maggi End
	
	//@hEMANT sTART
	public final String FINANCE_APP = "DIGI_APPR_BY_FINANCE_EMAIL";
	public final String LEGAL_APP = "DIGI_APPR_BY_LEGAL_EMAIL";
    public final String SELLER_APP = "DIGI_APPR_BY_SELLER_EMAIL";
    public final String SLR_APP = "DIGITAL_SELLER_APPROVED_EMAIL";
    public final String OTHERFEE = "Other Fee";
		//@HEMANT eND
    
    //@siddhesh TPR-10495 SDD
    public final String DELIVERY_MODE_SDD="SDD";
    //@siddhesh TPR-10495 SDD
    //@Parag IN-177 
    public final String RETURN_CLOSE = "RETUCLOS";
    //@Parag IN-177 
    
    public final String RBC = "RBC";
    public final String VBC = "VBC";
    public final String FMC = "FMC";
    public final String CBC = "CBC";
    public final String draft = "draft";
    
    //@Nishant TPR-10991
    public final String Return_Cancelled_By_Customer="RETCNCUS";
	public static final String ORD_ON_HOLD = "ORDONHLD";
	
	public final String CIR_RATING = "CIR";
    public final String HOTC_RATING = "HOTC";
    public final String O2D_RATING = "O2D";
    public final String REJECT_CANCEL_RATING = "REJECTCANCEL";
    public final String CUSTOMER_RATING = "CUSTRATE";
    public final String NPS_RATING = "NPSRATE";
    public final String BRAND_RATING = "BRANDRATE";
    public final String PREV = "PREV";
    public final String ALL = "ALL";
    public final String ULTIMATE = "ULTIMATE";
    public final String UNDERSCORE = "_";
    public final String PRICE = "PRICE";
    public final String ThirtyDays = "30";
    public final String Gold_Plus_Thresold = "Gold+ Thresold";
    public final String RatingEnable = "ratingEnable";
    public final String SellerRating = "SellerRating";
    public final String SellerRatingCat = "sellerCatRating";
    public final String Image_Ext = ".jpg";
    public final String CWT = "CriteriaWeight";
    public final String TSV = "ThresholdSaleValue";
    public final String TSC = "ThresholdSaleCount";
    public final String SELLER_RATING = "SELLER_RATING";
    
    public final String SILVER = "Silver Thresold:";
    public final String GOLD = "Gold Thresold:";
    public final String GOLDPLUS = "Silver Thresold:";
    
    
	//@Nishant added for Auto Reject
	public final String ORDER_AUTO_REJECTED = "ORDAUTOREJEC";
	//@SanketP New Status TPR-12680/TPR-12883 : RTO revamp
    public final String RTO_IN_PROGRESS="RTOINPRS";
    public final String RTO_COMPLETE="RTOCOMP";
    public final String RTO_DELIVERED="RTODELVRD";
    public final String COD_ORDER_NO_REFUND="CODNOREF";
    public final String RTO_CLOSED="RTOCLOS";
    public final String RTO_QC_FAILED="RTOQCFAILED";
    public final String RTO_QC_PASS="RTOQCPASS";
    public final String RTO_INIT="RTOINITD";
    
    //Aniket.s
    public final String SLR_RATING_CRITERIA = "SLR_RATING_CRITERIA";
    public final String SELLER_RATING_TIER = "SELLER_RATING_TIER";
	//Aniket.e
    public final String EarlyRefundQC = "EarlyRefundQC";
	public final String RTS1 = "RTS1";
	public final String RTS2 = "RTS2";
	public final String adminDispute = "adminDispute";
	public final String slrDispute = "slrDispute";
	
	public final String CODE_RETTOORG_INIT = "041";

	//COMMISSION REVAMP MANOJ
	public final String LOG_FEE_FWD_LOCAL_AIR="LFLA";
	public final String LOG_FEE_FWD_LOCAL_SUR="LFLS";
	public final String LOG_FEE_FWD_ZONAL_AIR="LFZA";
	public final String LOG_FEE_FWD_ZONAL_SUR="LFZS";
	public final String LOG_FEE_FWD_NATIONAL_AIR="LFNA";
	public final String LOG_FEE_FWD_NATIONAL_SUR="LFNS";
	public final String LOG_FEE_REV_LOCAL_AIR="LRLA";
	public final String LOG_FEE_REV_LOCAL_SUR="LRLS";
	public final String LOG_FEE_REV_ZONAL_AIR="LRZA";
	public final String LOG_FEE_REV_ZONAL_SUR="LRZS";
	public final String LOG_FEE_REV_NATIONAL_AIR="LRNA";
	public final String LOG_FEE_REV_NATIONAL_SUR="LRNS";
	public final String COD_FEES="CF";
	public final String NO_COST_EMI_FEE="EMI";
	public final String REPLACEMENT_FEE="RF";
	public final String WAREHOUSE_FEE="WF";
	public final String PRODUCT_CONTENT_FEE="PC";
	public final String PKG_FEE="PKGF";
	public final String MKT_FEE="MKTF";
	public final String RTO_FEE="RTOF";
	public final String PRODUCT_LISTINGORCATALOGUING="LF";
	public final String PAYMENT_GATEWAY_CHARGES="PF";

	//Penalty
	public final String ORDER_PROCESS_DELAY_PENALTY="OPDF";
	public final String ORDER_REJECTION_PENALTY="ORJF";
	public final String USED_PRODUCT_PENALTY="UFPP";
	public final String HOTC_INSCAN_GAP_PENALTY="HOTCP";
	public final String HOTC_ID = "2247";
	public final String ALLOCATE_ID = "2262";
	public final String REJECT_ID = "2260";
	public final String QC_FAIL_ID = "2238";
	//MANOJ

	//Replacement 
	public final String REPLACEMENT_INITIATED = "REPLINIT";
	public final String REPLACEMENT_CLOSED = "REPLCLOS";
	public final String ONHOLD_FOR_REPLACEMENT = "ONHOLDREPL";		
	public final String RELEASE_FOR_PROCESSING = "RELFORPROC";
	public final String REPLACEMENT_CANCELLED_BY_TUL = "UNBLTOREPL";
	public final String CANCELLED_BY_TUL = "CNCLBYTUL";
	public final String REPLACEMENT_RTO_REFUND_PENDING = "REPLRTORFNDPNDG";
	public final String REPLACEMENT_RTO_NOREFUND = "REPLRTONORFND";
	public final String REPLACEMENT_CANCELLATION_REQUESTED = "REPLCNCLREQ";
	public final String REPLACEMENT_CANCELLED_BY_CUSTOMER = "REPLCNCLCUST";
	public final String REPLACEMENT_CANCELLATION_REFUND_PENDING = "REPLCNCLRFNDPNDG";
	public final String UNABLE_TO_CANCEL_REPLACEMENT = "UNBLCNCLREPL";
	public final String REPLACEMENT_CANCELLATION_NOREFUND = "REPLCNCLNORFND";
	public final String REJECT_CANCEL = "REJCANC";

	public final String YES_VALUE ="Yes";
	public final String NO_VALUE="No";
}
	