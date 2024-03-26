package com.sellerportal.model;

import java.util.HashMap;
import java.util.Map;

public class LPUtils {
	public static final Map<String, String> returnLogisticsIds = new HashMap<>();

	static {
		returnLogisticsIds.put("Ecom", "EE");
		returnLogisticsIds.put("ECOM", "EE");
		returnLogisticsIds.put("EE", "EE");
		
		
		returnLogisticsIds.put("EK", "EK");
		returnLogisticsIds.put("EKART", "EK");
		returnLogisticsIds.put("Ekart", "EK");
		
		returnLogisticsIds.put("XC", "XC");
		returnLogisticsIds.put("XPRESSBEES", "XC");
		returnLogisticsIds.put("XpressBees", "XC");
		returnLogisticsIds.put("XB", "XC");
		returnLogisticsIds.put("XpressC", "XC");
		
		
		returnLogisticsIds.put("DL", "DL");
		returnLogisticsIds.put("Delhivery_sur", "DL");
		returnLogisticsIds.put("Delhivery", "DL");
		returnLogisticsIds.put("Delhivery_SUR", "DL");
		
		
		returnLogisticsIds.put("BD", "BD");
		returnLogisticsIds.put("Blue Dart", "BD");
		returnLogisticsIds.put("Bluedart", "BD");
		returnLogisticsIds.put("BlueDart", "BD");
		
		returnLogisticsIds.put("SF", "SF");
		returnLogisticsIds.put("ShadowFax", "SF");
		returnLogisticsIds.put("SHDOWFAX", "SF");
		returnLogisticsIds.put("Shadowfax","SF");
		returnLogisticsIds.put("SDFX", "SF");
		returnLogisticsIds.put("SHADOWFAX", "SF");
	}
	
}
