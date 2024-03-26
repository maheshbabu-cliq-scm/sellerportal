/**
 * 
 */
package com.sellerportal.tisl.seller.listproduct.utils;

/**
 * @author pramod
 *
 */
public interface ProductAttributeConst {
	public final String PRODUCTATTRIBUTEVALUESSPLITTER = ",";
	public final String PRODUCTATTRIBUTEVALUESJOINER = ",";
	public final String SELLERATTRIBUTE_TYPE_CODE = "SELLERATTRIBUTE";
	public final String PRODUCT_ATTRIBUTE_TYPE_GROUP_CODE = "PRODUCT_ATTRIBUTE_TYPE";
	public final String ATTRIBUTEHEAD_INFO_SPLIT = "_";
	public final String ATTRIBUTEHEAD_INFO_PREFIX = "#ATTR";
	public final String ATTRIBUTE_PARAM_VALUE = "VALUE";
	public final String RICH_ATTRIBUTE_TYPE_CODE = "RICHATTRIBUTE";
	public final String ATTRIBUTE_HEAD_DATAMAP_COLUMN_NAME = "ATTRIBUTEDATAMAP";
	public final String SELLER_ID_BEAN_PROPERTY_NAME = "sellerId";
	public final String CATEGORY_ID_BEAN_PROPERTY_NAME = "leafCategoryId";
	public final String REUIRED_FIELD_PREFIX = "*";
	public final String ATTR_UOM_PROPERTY_PREFIX = "uom_";
	public final String ATTR_UOM_PROPERTY_LABEL_PREFIX = "Unit of ";
	
	public final String PRODUCT_ATTR_DATA_TYPE_GROUP = "ATTRIBUTE_DATA_TYPE";
	public final String PRODUCT_ATTR_DATA_TYPE_DATE = "DATE";
	public final String PRODUCT_ATTR_DATA_TYPE_ENUM = "ENUM";
	public final String PRODUCT_ATTR_DATA_TYPE_INTEGER = "INTEGER";
	public final String PRODUCT_ATTR_DATA_TYPE_RELATIONSHIP = "RELATIONSHIP";
	public final String PRODUCT_ATTR_DATA_TYPE_STRING = "STRING";
	public final String PRODUCT_ATTR_DATA_TYPE_TEXT = "TEXT";
	public final String PRODUCT_ATTR_DATA_TYPE_URL = "URL";
	
	public final String PRODUCT_ATTR_CODE_PACKQUANTITY = "packquantity";
	public final String PRODUCT_ATTR_CODE_PACKCOLOR = "packcolor";
	public final String PRODUCT_ATTR_CODE_MULTIPACK = "multipack";
	public final String PRODUCT_ATTR_CODE_COLORAPPAREL = "colorapparel";
	public final String PRODUCT_ATTR_CODE_DISPLAYPRODUCT = "displayproduct";
	public final String PRODUCT_ATTR_HEELTYPE = "heeltype";//@ritesh
	public final String PRODUCT_ATTR_HEELHEIGHT = "heelheight";//@ritesh
	//@ritesh R 2.2 Start
	public final String PRODUCT_ATTR_MULTIPACK = "multipackfashiona";
	public final String PRODUCT_ATTR_MULTIPACK_QTY = "multipackquantityfashiona";
	public final String PRODUCT_ATTR_MULTIPACK_CONTENT = "multipackcontentsfashiona";
	public final String PRODUCT_ATTR_BELT_SIZE = "beltsizefashiona";
	public final String PRODUCT_ATTR_SIZE_GUIDE = "sizeguidefashiona";
	public final String PRODUCT_ATTR_OCCASSION_WATCH = "occasionwatches";
	public final String PRODUCT_ATTR_SPORT_TYPE = "sporttypewatches";
	public final String PRODUCT_ATTR_LEADVARIANTID_CODE = "leadvariantid";
	public final String L3_MEN_BELT_CAT_CODE = "MPH1600002";
	public final String L3_WOMEN_BELT_CAT_CODE = "MPH1601002";
	public final String L3_KIDS_BELT_CAT = "MPH1602002";
	public final String SIZE_CHART_VALUE_MEN  = "MenBelt";
	public final String SIZE_CHART_VALUE_WOMEN  = "WomenBelt";
	public final String SIZE_CHART_VALUE_KIDS = "KidsBelt";
	public final String DANGEROUS_GOODS_AMCODE = "dangerousGoods";
	public final String GENDER_AMCODE = "gender";
	public final String TAGS_AMCODE = "tags";
	public final String PLATFORM = "platform";
	public final String NET_QUANTITY_AMCODE = "netQuantity";
	public final String FREEBIE_AMCODE = "freebie";
	//@ritesh R 2.2 end
	
	//Travel & Luggage : START
	public final String PRODUCT_ATTR_LUGGAGESET = "luggagesettrlg";
	public final String PRODUCT_ATTR_LUGGAGESET_CONTENT = "luggagesetcontentstrlg";
	//Travel & Luggage : END
	
	//@nikhil Fashion Jewellery :START
	public final String PRODUCT_ATTR_METAL = "metalfshnjwlry";
	public final String PRODUCT_ATTR_CERTIFICATION = "certificationfshnjwlry";
	public final String L1_FASHION_CAT="MPH20"; 
	//@nikhil Fashion Jewellery :END
	
	//@suraj Fine Jewellery :START
	public final String PRODUCT_ATTR_FINEMETAL = "metalfinejwlry";
	public final String PRODUCT_ATTR_FINECERTIFICATION = "certificationfinejwlry";
	public final String PRODUCT_ATTR_GOLDPURITY = "goldpurityfinejwlry";
	public final String PRODUCT_ATTR_SILVERPURITY = "silverpurityfinejwlry";
	public final String PRODUCT_ATTR_PLATINUMPURITY = "platinumpurityfinejwlry";
	public final String PRODUCT_ATTR_GEMSTONE = "stonegemstonepresentfinejwlry";
	public final String PRODUCT_ATTR_STONE = "stonefinejwlry1";
	public final String PRODUCT_ATTR_NUMOF_STONETYP = "noofstonetypesfinejwlry";
	public final String PRODUCT_ATTR_TOTALSTONE_COUNT = "stonetotalcountfinejwlry";
	public final String PRODUCT_ATTR_STONE_COUNT = "stonecountfinejwlry1";
	public final String L1_FINE_CAT="MPH19";
	//@suraj Fine Jewellery  :END
	
	//@siddesh: TPR - 6745 :start
	public final String PRODUCT_ATTR_COLOR_GUIDE_FSHN = "colorfamilyfashiona";
	public final String L3_GIFT_CARDS_CAT_CODE = "MPH1603002";
	public final String L3_OTHER_GIFT_CARDS_CAT_CODE = "MPH1603003";
	public final String BASE_PROD_ID_MPH16_L3 = "zyxzyx";
	//@siddesh: TPR - 6745 :end
	
	public final String ATTR_STYLECODE = "stylecode"; //exponential check
	
	public final String STYLE_CODE="Style Code";
	
	//EYE-15 / 24
	public final String L4_CONTACT_LENSES = "MPH1604101100";
	public final String L4_READING_GLASSES = "MPH1604104100";
	public final String SP_POWER_ATTR = "sphericalpowerdioptreseyewear";
	
	//EYE-15 / 24
	
	
	public final String Water_Content = "watercontenteyewear";
	public final String PRODUCT_ATTR_L4_Inclusion = "categoryinclusionelectronics";//@mahesh
	public final String PRODUCT_ATTR_USSID_Exclusion = "ussidexclusionelectronics";//@mahesh
	public final String PRODUCT_ATTR_Digital_Prod_Type ="digitalproducttypeelectronics";//@mahesh
	public final String PRODUCT_ATTR_Digital_Prod_Sub_Type ="digitalproductsubtypeelectronics";//@mahesh
	public final String PRODUCT_ATTR_GroupingID ="groupingidelectronics";//@mahesh
	public final String PRODUCT_ATTR_USSID_Inclusion = "ussidinclusionelectronics";//@Sumesh
	public final String PRODUCT_ATTR_DIGITAL_PRODUCT_ELECTRONICS = "digitalproductelectronics";//@Sumesh
	public final String PRODUCT_PLATFORM_LUXURY = "Luxury";
	public final String PRODUCT_PLATFORM_INDILUXE = "Indiluxe";
	public final String PRODUCT_PLATFORM_BEAUTY = "Beauty";
	public final String PRODUCT_PLATFORM_MARKETPLACE = "Marketplace";
	
}
