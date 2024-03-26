package com.sellerportal.webservice;


/**
 * @author Pramod
 *This class is implemented for Web service Constant
 */

public interface CourierServiceConstants {

	public final String VENDOR_CUSTOMER_DETAIL_BEAN = "VENDOR_CUSTOMER_DETAIL";
	public final String VENDOR_CODE = "VENDOR_CODE";

	public final String PARAM_SERVICE_COURIER_AWBNUM = "AWBNUM";
	public final String PARAM_SERVICE_COURIER_PICKUP_ID = "PICKUP_ID";
	public final String COURIER_SERVICE_SHIPMENT_IDS = "SHIPMENT_IDS";
	public final String REPLACEMENT_COURIER_SERVICE_SHIPMENT_IDS = "REPLACEMENT_SHIPMENT_IDS";
	
	public final String PARAM_SERVICE_COURIER_ORDER_ID = "ORDER_ID";
	public final String COURIER_SERVICE_SERVICE_SUCCESS_SHIPMENT_IDS = "SUCCESS_SHIPMENT_IDS";
	public final String COURIER_SERVICE_TYPE_PICK = "pick";
	public final String COURIER_SERVICE_TYPE_SHIP = "ship";
	public final String COURIER_SERVICE_OPERATION = "courier.service.operation";

	public final String FEDEX_ACCOUNT_NUM = "FEDEX.account.num";
	public final String FEDEX_ACCOUNT_NUM_RESPONSIBLE = "FEDEX.account.num.responsible";
	public final String FEDEX_METER_NUM = "FEDEX.meter.num";
	public final String FEDEX_KEY = "Fedex-Key";
	public final String FEDEX_PASSWORD = "Fedex-Password";
	public final String FEDEX_PROCESS_SHIPMENT_URL_PARAM = "FEDEX.courier.service.url.processshipment";
	public final String FEDEX_PROCESS_SHIPMENT_SOAP_ACTION = "FEDEX.courier.service.action.processshipment";
	public final String FEDEX_PROCESS_CREATE_PICKUP_URL_PARAM = "FEDEX.courier.service.url.createpickup";
	public final String FEDEX_PROCESS_CREATE_PICKUP_SOAP_ACTION = "FEDEX.courier.service.action.createpickup";
	public final String FEDEX_FORM_ID = "FORM_ID";
	public final String FEDEX_ROUTING_CODE = "ROUTING_CODE";
	public final String FEDEX_SERVICE_TYPE = "SERVICE_TYPE";
	public final String FEDEX_DESTINATION_CITY_CODE = "DESTINATION_CITY_CODE";
	public final String FEDEX_ESTIMATED_TIME_OF_DELIVERY = "ESTIMATED_TIME_OF_DELIVERY";
	public final String FEDEX_DESTINATION_POSTAL_CODE="DESTINATION_POSTAL_CODE";
	public final String FEDEX_DESTINATION_COUNTRY_CODE="DESTINATION_COUNTRY_CODE";
	public final String FEDEX_FEDEX_1D_BARCODE="FEDEX_1D_BARCODE";
	public final String FEDEX_COD_RETURN_TYPE ="COD_RETURN";
	public final String FEDEX_COD_RETURN_SERVICE_TYPE="COD_RETURN_SERVICE_TYPE";
	public final String FEDEX_COD_RETURN_TRACKING_ID="COD_RETURN_TRACKING_ID";
	public final String FEDEX_COD_RETURN_FORM_TYPE="COD_RETURN_FORM_TYPE";
	public final String FEDEX_COD_RETURN_1D_BARCODE="COD_RETURN_1D_BARCODE";

	public final String FEDEX_PROCESS_AVAILABILITY_PICKUP_URL_PARAM = "FEDEX.courier.service.url.pickupAvailability";
	public final String FEDEX_PROCESS_AVAILABILITY_PICKUP_SOAP_ACTION = "FEDEX.courier.service.action.pickupAvailability";

	public final String GOJAVAS_USERID = "gojavas.username";
	public final String GOJAVAS_PASSWORD = "gojavas.password";
	public final String GOJAVAS_CUST_CODE = "gojavas.cust.code";
	public final String GOJAVAS_XMLBATCH = "XMLBatch";
	public final String GOJAVAS_CNOR_NAME = "GOJAVAS.Cnor_Name";

	public final String BLUEDART_SERVICE_WAYBILL_URL = "BLUEDART.service.Waybill.url";
	public final String BLUEDART_SERVICE_PICKUP_URL = "BLUEDART.service.Pickup.url";
	public final String BLUEDART_SERVICE_SERVICEFINDER_URL = "BLUEDART.service.ServiceFinder.url";
	public final String BLUEDART_SERVICE_API_TYPE = "BLUEDART.service.api.type";
	public final String BLUEDART_SERVICE_AREA = "BLUEDART.service.area";
	public final String BLUEDART_SERVICE_CUSTOMER_CODE = "BLUEDART.service.customer.code";
	public final String BLUEDART_SERVICE_CUSTOMER_CODE_A50KFRWRD = "BLUEDART.service.customer.code.a50kfrwrd";
	public final String BLUEDART_SERVICE_CUSTOMER_CODE_REVERSE = "BLUEDART.service.customer.code.reverse";
	public final String BLUEDART_SERVICE_CUSTOMER_CODE_ED_AIR = "BLUEDART.service.customer.code.ed.AIR";
	public final String BLUEDART_SERVICE_CUSTOMER_CODE_ED_SUR = "BLUEDART.service.customer.code.ed.SUR";


	public final String BLUEDART_SERVICE_LICENCEKEY = "BLUEDART.service.licenceKey";
	public final String BLUEDART_SERVICE_LOGINID = "BLUEDART.service.loginID";
	public final String BLUEDART_SERVICE_PASSWORD = "BLUEDART.service.password";
	public final String BLUEDART_SERVICE_VERSION = "BLUEDART.service.version";
	public final String BLUEDART_PICKUP_SOAP_ACTION = "BLUEDART.courier.service.action.pickup";
	public final String BLUEDART_SHIP_SOAP_ACTION = "BLUEDART.courier.service.action.ship";
	public final String BLUEDART_SERVICE_LICENCEKEY_REV = "BLUEDART.service.licenceKey.reverse";

	public final String GATI_DOCKET_NUM = "GATI.docket.num";
	public final String GATI_PINSTATIONCODE = "PINSTATIONCODE";
	public final String GATI_CUSTVENDCODE = "GATI.Custvendcode";
	public final String GATI_GOODSCODE = "GATI.Goodscode";
	public final String GATI_CUSTCODE = "GATI.custcode";
	public final String GATI_SHIPPERCODE = "GATI.shippercode";

	public final String AWB_GENERATION_ERROR_MSG = "AWB_GEN_ERROR_MSG";

	public final String USERTYPE_SENDER = "SENDER";
	public final String USERTYPE_RECEIVER = "RECEIVER";

	public final String ORIGIN_CAREA = "ORIGIN_CAREA";
	public final String ORIGIN_CSCRCD = "ORIGIN_CSCRCD";

	public final String DEST_CAREA = "DEST_CAREA";
	public final String DEST_CSCRCD = "DEST_CSCRCD";

	public final String DELHIVERY_PROXY_ENABLE = "DELHIVERY.service.proxy.enablement";
	public final String DELHIVERY_PROXY_IP = "DELHIVERY.service.proxy.url";
	public final String DELHIVERY_PROXY_PORT = "DELHIVERY.service.proxy.port";
	public final String DELHIVERY_PICK_TIME = "DELHIVERY.service.pickuptime";
	public final String COURIER_SERVICE_LICENCEKEY = "service.licenceKey";

	public final String COURIER_SERVICE_SLAVE_IDS = "SLAVE_IDS";
	public final String COURIER_SERVICE_SLAVE_REGISTER_REQUEST = "SLAVE_REGISTER_REQUEST";
	public final String COURIER_SERVICE_MENIFEST_REQUEST = "MENIFEST_REQUEST";
	public final String COURIER_SERVICE_BANK_REQUEST = "BANK_REQUEST";

	public final String ECOM_USERID = "ECOM.service.username";
	public final String ECOM_PASSWORD = "ECOM.service.password";
	public final String ECOM_CUST_CODE = "ECOM.cust.code";
	public final String ECOM_PICK_TIME = "ECOM.courier.service.pickuptime";
	public final String ECOM_BANK_COUNT = "ECOM.courier.service.bank.batch.size";
	public final String LP_BANK_AWB_TYPE = "LP_BANK_AWB_TYPE";


	public final String TRY_AGAIN_MSG = "Try Again";
	public final String LP_USERID = "lp.username";
	public final String LP_PASSWORD = "lp.password";
	public final String LP_USERID_SURFACE = "lp.username.surface";
	public final String LP_PASSWORD_SURFACE = "lp.password.surface";
	public final String COD = "COD";
	public final String PREPAID = "PPD";
	public final String REVERSE = "REV";
	public final String EKART_AWB_TYPE = "AWB_TYPE";
	public final String EKART_IS_REV_AWB = "REV_AWB";
	public final String EKART_REQ_ID = "1234";
	public final String EKART_CLIENT_NAME = "CLQ";
	public final String EKART_ISDANGEROUS_L4CATCODE="EKART.isDangerous.l4catCode";
	public final String COURIER_TRANSPORTMODE_SURFACE = "SUR";
	//@Rohit Part of Delhivery multipart awb Start
	public final String TATABULK_SURFACE = "TATABULK SURFACE";
	public final String TATABULK_SURF_MPS_CLIENT = "DELHIVERY.service.mps.client";
	public final String MPS = "MPS";
	//@Rohit Part of Delhivery multipart awb End

	//@nikhil changes for mahindra LP
	public final String MAHINDRALP_CODE = "ML";
	public final String CREATED = "created";
	public final String MESSAGE = "message";
	public final String ERRORCODE = "errorcode";
	public final String AUTHENTICATIONFAILED = "Authentication failed";
	public final String ML_AUTH_ERRORID = "API00002";
	public final String PRODUCTNAME = "FMCG";
	public final String UNITS = "Units";
	public final String KGS = "Kgs";
	public final String ARRAY = "array";
	public final String BOOLEAN = "boolean";
	public final String FALSE = "False";
	public final String TRUE = "True";

	public final String COURIER_SERVICE_VENDOR_CREATE = "VENDOR_CREATE";	//@siddhesh create vendor for GATI UF-493

	//Shankar Start : TPR-10681
	public final String KEY = "service.url.licenceKey";
	public final String VERSION_NUMBER = "service.version";
	public final String CUSTOMER_TYPE_PRIMARY = "customerType.Primary";
	public final String CUSTOMER_TYPE_SECONDARY = "customerType.Secondary";
	public final String PICKUP_TYPE = "pickup.type";
	//Shankar End : TPR-10681



	//Suraj T :: TPR:11800
	public final String COURIER_TRANSPORTMODE_AIR = "AIR";
	public final String EKART_SERVICE_CODE_HD_ECONOMY = "ECONOMY";
	//Suraj T :: TPR:11800

	// Suraj T: TPR-11583 
	public final String EKART_SERVICE_CODE_HD = "REGULAR";
	public final String EKART_SERVICE_CODE_ED = "NDD";
	public final String EKART_SERVICE_VENDOR_NAME = "Ekart";
	//TPR-11583

	// Suraj T: TPR-11704
	public final String EKART_SERVICE_CODE_REVERSE = "RETURNS_SMART_CHECK";

	//Shankar Start : TPR-10660 Fedex
	public final String FEDEX_INSTRUCTION7 = "FEDEX_INSTRUCTION7"; 
	public final String FEDEX_COD_FORWARD_ADDRESS_STATE="FEDEX_COD_FORWARD_ADDRESS_STATE";
	public final String FEDEX_COD_FORWARD_ADDRESS_POSTALCODE="FEDEX_COD_FORWARD_ADDRESS_POSTALCODE";
	public final String FEDEX_COD_FORWARD_ADDRESS_COUNTRYCODE="FEDEX_COD_FORWARD_ADDRESS_COUNTRYCODE";
	public final String FEDEX_COD_RETURN_AIRPORTID="FEDEX_COD_RETURN_AIRPORTID";
	public final String FEDEX_COD_RETURN_ADDRESS_STATE="FEDEX_COD_RETURN_ADDRESS_STATE";
	public final String FEDEX_COD_RETURN_ADDRESS_POSTALCODE="FEDEX_COD_RETURN_ADDRESS_POSTALCODE";
	public final String FEDEX_COD_RETURN_ADDRESS_COUNTRYCODE="FEDEX_COD_RETURN_ADDRESS_COUNTRYCODE";
	public final String FEDEX_COD_FORWARD_AIRPORTID="FEDEX_COD_FORWARD_AIRPORTID";
	public final String FEDEX_UVSDK_VERSION="FEDEX_UVSDK_VERSION";
	public final String FEDEX_COD_FORWARD_SERVICE_TYPE="FEDEX_COD_FORWARD_SERVICE_TYPE";
	public final String FEDEX_ROUTING_INFO="FEDEX_ROUTING_INFO";

	public final String FEDEX_PREPAID_FORWARD_POSTALCODE="FEDEX_PREPAID_FORWARD_POSTALCODE";
	public final String FEDEX_PREPAID_FORWARD_AIRPORTID="FEDEX_PREPAID_FORWARD_AIRPORTID";
	public final String FEDEX_PREPAID_FORWARD_STATE="FEDEX_PREPAID_FORWARD_STATE";
	public final String FEDEX_PREPAID_FORWARD_COUNTRYCODE="FEDEX_PREPAID_FORWARD_COUNTRYCODE";

	public final String FEDEX_COD_FORWARD_DEST_SERVICE_AREA="FEDEX_COD_FORWARD_DEST_SERVICE_AREA";
	public final String FEDEX_COD_RETURN_DEST_SERVICE_AREA="FEDEX_COD_RETURN_DEST_SERVICE_AREA";
	public final String REMIT_TO_NAME="COLLECT CASH INR....";
	//Shankar End : TPR-10660 Fedex

	//Suraj Smart Check Questions XC and SF
	public final String SIZE_QUES = "Size";
	public final String COLOR_QUES = "Color";
	public final String BRAND_QUES = "Brand";
	public final String SKU_QUES = "SkuCode";
	public final String SERIAL_NO_QUES = "Serial Number";
	public final String REVERSE_SEAL_QUES = "Reverse Seal Code";
	public final String IMEI_QUES = "Imei Number";
	public final String PACKAGING_MANDATORY_QUES = "Is Brand Packaging available?"; //Jyoti Label change for XC and SF
	public final String CHECK_DAMAGE_QUES = "Is Product Damaged?";
	public final String CHECK_USAGE = "Is Product Used?";
	
	public final String SIZE_QUES_BD = "Does the size of product match?";
	public final String COLOR_QUES_BD = "Does the color of product match?";
	public final String IMAGE_QUES_BD = "Does the image match with the product?";
	public final String BRAND_QUES_BD = "Does the brand of product match?";
	public final String SKU_QUES_BD = "Does the sku of product match?";
	public final String SERIAL_NO_QUES_BD = "Does the Serial Number match?";
	public final String REVERSE_SEAL_QUES_BD = "Does the Reverse Seal Code match?";
	public final String CHECK_DAMAGE_QUES_BD = "Is Product in good condition(Not Damaged)?";
	public final String CHECK_USAGE_BD = "Is Product Unused?";
	
	public final String CHECK_DAMAGE_QUES_XC = "Is product damaged?";//Kanav, new label for XC as per Dhananjay
	public final String CHECK_USAGE_XC = "Is product used?";//Kanav, new label for XC as per Dhananjay
	public final String COLOR_QUES_XC = "Is COLOR of product ";
	public final String SIZE_QUES_XC = "Is SIZE of product ";
	public final String BRAND_QUES_XC = "Is BRAND of product ";
	public final String IMAGE_QUES_XC = "Is Product matching with the image?";
	public final String SKU_QUES_XC = "Is SKU Code of product is " ;
	public final String SERIAL_NO_QUES_XC = "Is Serial Number of product is ";
	public final String REVERSE_SEAL_QUES_XC = "Is Reverse Seal Code of product is ";
	public final String IMEI_QUES_XC = "Is IMEI of product is ";
	public final String CHECK_ACCESSORIES_XC = "Is any accessory available with product?";
	public final String PRODUCTDESC_QUES_XC = "Is Description of product is ";
	public final String QUESTION_MARK = "?";
	public final String QUOTE = "\'";
	
	
	public final String CHECK_ACCESSORIES = "Is Accessories available?";

	public final String EKART_LARGE = "LARGE";
	public final String EKART_CLIENT_NAME_TUL = "TUL";

	public final String RTO_CIR_ENABLED ="rto.cir.enabled";
	public static final String BLUEDART_SERVICE_CUSTOMER_CODE_REVERSE_SUR = "BLUEDART.service.customer.code.reverse.surface";
	
	public final String RETURN_CANCEL_REASON_FOR_MANUAL_LP ="Delivery issue";
	
	public final String IS_MULTIPART_SHIPMENT = "isMultipartShipment";
	
	public static final String SECURITY_TOKEN = "AUTH_TOKEN";
	public static final String SHIPROCKET_SECURITY_TOKEN = "SHIPROCKET_AUTH_TOKEN";
	public static final String SHIPROCKET = "Shiprocket";
	public static final String SHIPROCKET_CODE = "SR";

	public final String DANGEROUS_GOODS = "Dangerous Goods";
	public final String YES = "Yes";
	
	//CriticaLog Constants
	public final String CRITICALOG_DEFAULT_PAYMENT_TYPE = "Credit";
	public final String CRITICALOG_DEFAULT_TRANSIT_MODE = "Air";
	public final String CRITICALOG_DEFAULT_PRODUCT_MODE = "Normal";

	public final String CRITICALOG_CLIENT_CODE_VARIABLE_NAME = "CRITICALOG_CLIENT_CODE";
	public final String CRITICALOG_AUTHORIZATION_CODE_VARIABLE_NAME = "CRITICALOG_AUTHORIZATION_CODE";
	public final String CRITICALOG_DEFAULT_DATE_FORMAT = "yyyy-MM-dd";

	public final String CRITICALOG_QC_RULE_TYPE_BOOLEAN = "Boolean";
	public final String CRITICALOG_QC_RULE_TYPE_INPUT = "Input";
	public final String CRITICALOG_QC_RULE_TYPE_IMAGE = "Image";
	
	public final String BLUEDART_SERVICE_CUSTOMER_CODE_REVERSE_QC = "BLUEDART.service.customer.code.reverse.QC";
	
	public final String BLUEDART_SERVICE_SHIPPER_ORIGIN_CODE_REVERSE_QC = "BLUEDART.service.shipper.origin_area.reverse.QC";
	
	public final String CLICKPOST_ID = "CLICKPOST_ID";

	public static final String FORWARD = "FORWARD";
	public static final String RVP = "RVP";
	public static final String CLICKPOST_DOORSTEPQC = "doorstep";

}