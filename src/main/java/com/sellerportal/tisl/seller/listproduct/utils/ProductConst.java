/**
 * 
 */
package com.sellerportal.tisl.seller.listproduct.utils;

/**
 * @author pramod
 *
 */
public interface ProductConst {
	public final String CATEGORYATTRPREFIX = "attr_cat_";
	public final String PRODUCTATTRPREFIX = "attr_prod_";
	public final String PRODUCT_IMG_PREFIX = "imgFile";
	public final String PRODUCT_VIDEO_ATTR_PREFIX = "video";
	public final String FILE_ITEMS_REQ_ATTR_NAME = "parseUpload";
	public final String CATEGORY_LEVEL_REQ_4_ATTR_NAME = "categoryLevel4";
	public final String CATEGORY_LEVEL_REQ_1_ATTR_NAME = "categoryLevel1";
	public final String CATEGORY_LEVEL_REQ_2_ATTR_NAME = "categoryLevel2";
	public final String CATEGORY_LEVEL_REQ_3_ATTR_NAME = "categoryLevel3";
	public final String EDITED_CONTENT_REQ_ATTR_NAME = "editedContent";

	public final String PRODUCT_APPROVAL_GROUPCODE = "PROD_APPROVAL_STATUS";

	public final String SAVEASDRAFT_APPROVAL_CODE = "SAVEASDRAFT";
	public final String SAVE_N_SUBMIT_APPROVAL_CODE = "SENDFORAPPROVAL";
	public final String PENDING_SEND_FOR_APPROVAL_CODE = "PENDINGSENDFORAPPROVAL";
	public final String PENDING_FOR_COMMISSION = "PENDINGFORCOMMISSION";
	public final String SEND_FOR_APPROVAL_CODE = "SENDFORAPPROVAL";
	public final String PENDING_USSID_APPROVAL_CODE = "PENDINGTAXSTATUS";

	public final String REJECTED_APPROVAL_CODE = "REJECTED";
	public final String LISTED_APPROVAL_CODE = "LISTED";
	public final String LISTED_MODIFICATION_APPROVAL_CODE = "LISTED_MODIFICATION";

	public final String PRODUCT_VIDEO_URL = "Url_";
	public final String PRODUCT_VIDEO_FILE = "File_";
	public final String PRODUCT_VIDEO_TITLE = "title_";
	public final String PRODUCT_VIDEO_COMMENT = "comment_";
	public final String PRODUCT_VIDEO_TYPE = "Type_";
	public final String PROD_CREATION_WIZARD = "PROD_CREATION_WIZARD";
	public final String BASIC_INFO = "BASIC_INFO";
	public final String PROD_ATTRIBUTES = "PROD_ATTRIBUTES";
	public final String PROD_IMG_UPLOAD = "PROD_IMG_UPLOAD";
	public final String PROD_VIDEO_UPLOAD = "PROD_VIDEO_UPLOAD";
	public final String PROD_APPROVAL_STATUS_ALREADY_SENT = "ALREADY_SENT_PENDING";
	public final String PROD_APPROVAL_STATUS_SENT = "SENT_FOR_APPROVAL";
	public final String PROD_APPROVAL_STATUS_NOT_SENT = "NOT_SENT";
	public final String PRODUCT_REQUESTED_FOR = "PRODUCT_REQUESTED_FOR";
	public final String SELLNOW = "SELLNOW";
	public final String LISTED_MODIFICATION = "LISTEDMODIFICATION";
	public final String LISTED_MODIFICATION_UPDATE_END_DATE = "LISTEDMODIFICATIONUPDATEENDDT";
	public final String LISTED_MODIFICATION_UPDATE_ATTR_VAL = "LISTEDMODIFICATIONUPDATEATTR";
	public final String NEW_PRODUCT_CREATION =  "NEWPRODUCTCREATION";
	public final String NON_LISTED_MODIFICATION = "NONLISTEDMODI";
	public final String PRODUCT_LIST_DELIST_GROUPCODE = "PROD_LISTING_STATUS";
	public final String PRODUCT_LISTING_CODE = "LISTED";
	public final String PRODUCT_DELIST_CODE = "DELISTED";

	public final String PRODUCT_COPY_COMMAND = "CP";
	public final String LISTED_PRODUCT_COPY_COMMAND = "LCP";
	public final String PRODUCT_EDIT_COMMAND = "ED";
	public final String PRODUCT_NEW_CREATE_COMMAND = "NC";

	public final String PRODUCT_STATUS_LISTED = "LI";
	public final String PRODUCT_STATUS_NON_LISTED = "NL";
	public final String PRODUCTCREATIONBEAN = "ProductCreationBean";

	public final String PARAM_PRODUCT_ID = "id";
	public final String PARAM_USSID = "ussid";
	public final String PARAM_PRODUCT_STATUS = "ps";
	public final String PARAM_PRODUCT_COMMAND = "command";
	public final String PARAM_SEPERATOR = "&";
	public final String ASSIGN_OPERATOR = "=";

	public final String GETPR_FUNCTION_NAME = "getPr";

	public final String PARAM_KEYWORD_TEXT = "keywordText";
	public final String PARAM_PROD_STATUS = "prodStatus";
	public final String PARAM_CMTRFNUM = "cmtrfnum";
	public final String PARAM_CMTCODE = "CMTCODE";
	public final String PARAM_PRODUCT_FROM_LIST_PAGE = "flp";

	public final String IMG_ATTRIBUTE_GROUP = "IMG_ATTRIBUTE";
	public final String VIDEO_ATTRIBUTE_GROUP = "VIDEO_ATTRIBUTE";

	public final String PRODUCT_IDENTITY_CODE = "PRODUCTIDENTCODE";
	public final String PRODUCT_IDENT_CODE = "productIdentCode";
	public final String PRODUCT_IDENT_VALUE = "productIdentValue";

	public final String INVENTORY_SAFTY_STOCK = "INVENTORY_SAFTY_STOCK";
	public final String SAFTYSTOCK = "SAFTYSTOCK";
	public final String VIDEO_FILE_CONSTANT = "http://";
	public final String VIDEO_FILE_SECURE_CONSTANT = "https://";
	public final String VIDEO_FILE_TYPE = "F";
	public final String VIDEO_FILE_LINK = "L";
	public final String DEDUPLICATION_VALUE_GROUP= "DEDUPLICATION_VALUE_GROUP";
	public final String APPARELCATEGORY = "APPAREL";
	public final String L1_APPAREL_CAT = "MPH11";
	public final String ELECRONICCATEGORY = "ELECRONICS";
	public final String L1_ELECTRONIC_CAT = "MPH12";
	public final String SPECIAL_ATTRIBUTE_SUBGROUP = "SPECIAL_ATTRIBUTE_SUBGROUP";
	public final String SIZECODE = "Size";
	public final String SIZECODEVAL = "SIZECODEVAL";
	public final String DESCR_CAT_CODE = "DESCR_CAT_CODE";
	public final String COLORCODE = "Color";
	public final String VARIENT_COLOR = "VARIENT_Color";
	public final String VARIENT_SIZE = "VARIENT_Size";
	public final String VARIENT_BASEPRODID = "VARIENT_Baseproductid"; 
	public final String VARIENT_SKUEDITATTR = "VARIENT_Skueditattr"; //skuedit retrigger : Skueditattr
	public final String VARIENT_COLOR_BEAN_PROPERTY = "color";
	public final String VARIENT_SIZE_BEAN_PROPERTY = "size";

	public final String COLORCODEVALUE = "COLORCODEVALUE";
	public final String CATEGORY_IMG_GROUP = "CATEGORY_IMG_TYPE";
	public final String CATEGORYMINREQUIREIMGGROUP = "CAT_MINIMUMREQIMG";

	public final String CREATED_VIA_SCREEN = "SR";
	public final String CREATED_VIA_BULk_UPLOAD = "BU";
	public final String CREATED_VIA_CMS = "CS";
	public final String CREATED_VIA_SELLER_INTEGRATION = "SI";
	public final String CREATED_VIA_SELL_NOW = "SL";
	public final String CREATED_VIA_SELL_NOW_BULK = "SLB";
	//@ritesh R 2.2 Start
	public final String ACCESSORIES = "ACCESSORIES";
	public final String PRODUCT_BRAND_CODE = "PRODUCTBRANDCODE";
	public final String PRODUCT_BRAND_VALUE = "PRODUCTBRANDVALUE";	
	public final String PARAM_CMTLEAF = "CMTLEAFCAT";
	public final String WATCHESCATEGORY = "WATCHES";
	public final String L1_WATCH_CAT ="MPH15";
	public final String BRAND = "brand";
	public final String beltCatCode = "Belts";
	//@ritesh R 2.2 END
	public final String FOOTWEARCATEGORY = "FOOTWEAR";
	public final String L1_FOOTWEAR_CAT = "MPH13";
	//TPR-581::  product sell now
	public final String LISTINGID = "LISTINGID";
	//Travel & Luggage : start
	public final String TRAVELANDLUGGAGE = "TRAVELANDLUGGAGE";
	public final String L1_TRAVELANDLUGGAGE_CAT = "MPH18";
	//Travel & Luggage : end
	//@Nikhil Fashion Jewellery: START
	public final String FASHIONJEWELLERY = "FASHIONJEWELLERY";
	public final String FASHIONSTYLECODE = "stylecodefshnjwlry";
	public final String STYLECODE = "Style";
	public final String STYLECODEVALUE = "STYLECODEVAL";
	public final String L1_FASHION_CAT="MPH20";
	public final String GOURMET = "GOURMET";
	public final String L1_GOURMET_CAT = "MPH23";
	//@Nikhil Fashion Jewellery: END

	//@Nikhil Fine Jewellery: START
	public final String FINEJEWELLERY = "FINEJEWELLERY";
	public final String FINEASSOCIATIONCODE = "associationcodefinejwlry";
	public final String FINESTYLECODE = "stylecodefinejwlry";
	public final String ASSOCIATIONCODE = "association";
	public final String ASSOCIATIONCODEVALUE = "ASSOCIATIONCODEVALUE";
	public final String L1_FINE_CAT="MPH19";
	public final String FINESIZECODE = "FINESIZECODE";
	public final String FINESIZEVALUE = "FINESIZEVALUE";
	public final String DELETE = "DEL";


	//@Nikhil Fine Jewellery: END

	//@Gulab
	public final String ATTR_ASSOCIATION_CODE="associationcodefinejwlry";

	public final String ATTR_COIN_WEIGHT_JW="coinbarweightfinejwlry";

	public final String JW_WT_COMP = "FINE_JWLRY_WT";
	public final String ATTR_GROSS_WEIGHT_JW = "grossweightfinejwlry";

	//@siddesh: BC1 Added for Apparel & footwear stylecode
	public final String ApparelStylecode = "stylecode";
	public final String STYLECODEBC = "stylecode";
	public final String STYLECODEVAL = "stylecodevalue";

	public final String COLORAPPAREL = "colorapparel";
	public final String BRANDCOLORFOOTWEAR = "brandcolorfootwear";

	public final String PRODUCT_COLORAPPAREL = "PRODUCTBRANDCODE";
	public final String PRODUCT_BRANDCOLORFOOTWEAR = "PRODUCTBRANDCODE";
	public final String PRODUCT_SKUCODE = "SKUCODE";

	//@siddesh: BC1 Added for Apparel & footwear stylecode	
	//nikhil:product priority start
	public final String PRIORITYURL = "PriorityProductFeed";
	//nikhil:product priority end

	//@nikhil added for HOME
	public final String HOMECATEGORY = "HOME";
	public final String L1_HOME_CAT = "MPH21";
	//@Sumesh added for Beauty, Watches and Accessories
	public final String BEAUTYCATEGORY = "Beauty & Grooming";
	public final String L1_BEAUTY_CAT = "MPH22";
	public final String ACCESSORIESCATEGORY = "Accessories";
	public final String L1_ACCESSORIES_CAT = "MPH16";
	
	
	//@siddesh: TPR - 6745 :start
	public final String gifCardName = "Gift Cards";
	public final String othergifCardName = "Others Gift Cards";
	//@siddesh: TPR - 6745 :end	
	//@nikhil added for Services
	public final String SERVICESCATEGORY = "SERVICES";
	public final String L1_SERVICES_CAT = "MPH22";
	//@nikhil
	public final String EAN_IDENT_VALUE = "EANValue";
	//public final String EAN_IDENT_VALUE = "eanValue";
	public final String UPC_IDENT_VALUE = "UPCValue";
	//public final String UPC_IDENT_VALUE = "upcValue";
	public final String MPN_IDENT_VALUE = "MPNValue";
	//public final String MPN_IDENT_VALUE = "mpnValue";
	public final String GSTIN_GROUP = "PRODUCTIDENTCODE";
	public final String EAN_CODE = "EAN";
	public final String UPC_CODE = "UPC";
	public final String MPN_CODE = "MPN";


	//@siddhesh :: TPR-6688
	public final String PRODUCT_IDENTITY_CODE_2 = "PRODUCTIDENTCODE_2";
	public final String PRODUCT_IDENT_VALUE_2 = "productIdentValue_2";
	public final String PRODUCT_IDENTITY_CODE_3 = "PRODUCTIDENTCODE_3";
	public final String PRODUCT_IDENT_VALUE_3 = "productIdentValue_3";

	//@nikhil.s TPR-6670 : Differential Commission Model
	public final String COMMISSIONAPPROVALSTATUS = "COMM_APPROVAL_STATUS";
	public final String COMMPENDINGSENDFORAPPROVALCODE = "COMMPENDINGSENDFORAPPROVAL";
	public final String COMMSENDFORAPPROVALCODE = "COMMSENDFORAPPROVAL";
	public final String COMMSENDFORAPPROVALDESC = "SENDFORAPPROVAL";
	public final String COMMOVERRIDDENAPPROVE = "COMOVERRIDEAPP";	
	public final String COMMOVERRIDDENREJECT = "COMOVERRIDEREJ";	
	public final String COMMPENDINGSENDFORAPPROVALDESC = "PENDING SEND FOR APPROVAL";
	public final String APPROVED = "APPROVED";
	public final String REJECTED = "REJECTED";
	public final String APPROVE = "APPROVE";
	public final String REJECT = "REJECT";
	public final String COMMAPPROVED = "COMMAPPROVED";
	public final String PRODUCT = "PRODUCT";
	public final String COMMREJECTED = "COMMREJECTED";
	public final String SUCCESS = "SUCCESS";
	public final String INPROGRESS = "INPROGRESS";
	public final String FAIL = "FAIL";
	public final String CNCCODE = "CNC";
	public final String CNCValue = "Click & Collect";

	//@nikhil.s Digital Seller
	public final String CMSENDAPPROVAL= "CMSENDAPPROVAL";
	public final String FINANCESENDFORAPPROVAL = "FINANCESENDFORAPPROVAL";
	public final String LEGALSENDFORAPPROVAL = "LEGALSENDFORAPPROVAL";
	public final String SELLERSENDFORAPPROVAL = "SELLERSENDFORAPPROVAL";
	public final String www = "www";
	public final String defaultAgreepdf = "DigiAgreement.pdf";
	//public final String REPLACE_CHARS = "\\/;";
	public final String REPLACE_CHARS = ";\\";		//SDI-27228

	public final String LEADTIMEATTRCODE_ATTR_CODE = "leadTimeForTheSKUHomeDelivery";
	public final String WARRANTYTYPE_ATTR_CODE = "warrantyType";
	public final String WARRANTYTIME_ATTR_CODE = "warrantyTimePeriod";
	public final String GSTELIGIBLE_ATTR_CODE = "gstEligible";
	public final String PRODUCT_ATTR_L4_Inclusion = "categoryinclusionelectronics";//@mahesh
	public final String PRODUCT_ATTR_USSID_Exclusion = "ussidexclusionelectronics";//@mahesh
	public final String PRODUCT_ATTR_Digital_Prod_Type ="digitalproducttypeelectronics";//@mahesh
	public final String PRODUCT_ATTR_Digital_Prod_Sub_Type ="digitalproductsubtypeelectronics";//@mahesh
	public final String PRODUCT_ATTR_GroupingID ="groupingidelectronics";//@mahesh
	public final String BEAUTYGROOMING = "BEAUTYGROOMING";
    public final String L1_BEAUTYGROOMING_CAT = "MPH22"; 
    public final String KIDS = "KIDS"; 
    public final String L1_KIDS_CAT = "MPH24";
	}

