package com.sellerportal.dao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class Utils {

	public static boolean isEmpty(String param) {
		if (param == null || param.trim().equals("")){
			return true;
		}
		else{
			return false;	
		}
	}
	public static boolean isListEmpty(List list) {
		if (list == null || list.isEmpty() || list.size() == 0 ){
			return true;
		}
		else{
			return false;	
		}
	}
	
	public static boolean isMapEmpty(Map<String,String> map) {
		if (map == null || map.isEmpty() || map.size() == 0 ){
			return true;
		}else{
			return false;
		}
	}
	public static boolean isKeyEmpty(Map<String,String> map,String key) {
		if (isMapEmpty(map) || isEmpty(key)){
			return true;
		}else if(!Utils.isEmpty(key) && !isMapEmpty(map) && isEmpty((String)map.get(key))){
			return true;
		}
		else{
 			return false;	
		}
	}
	
	 public static boolean isObjectEmpty(Object param) {
			if (param == null){
				return true;
			}else{
				return false;	
			}
	 }
	
	public static boolean isNumeric(String str)	{
	  return str.matches("-?\\d+(\\.\\d+)?");  //match a number with optional '-' and decimal.
	}
	
	public static boolean isDigitOnly(String str)	{
		  return str.matches("\\d+");  //match a number with only Digits.
	}

	 public static boolean isStrEqual(String first, String second){
		 
		 first = first!=null ? first : "";
		 second = second!=null ? second : "";
		 

		if(first.equals(second)){
			return true;
		}else{
			return false;
		}
 
	 }
	 
	 public static boolean isStrEqualS(String first, String second){
		 
		 first = first!=null ? first : "";
		 second = second!=null ? second : "";
		 

		if(first.equalsIgnoreCase(second)){
			return true;
		}else{
			return false;
		}
 
	 }
	 
	 public static Date getDateAddedDays(Date date, int days){
		 Calendar calendar = Calendar.getInstance();
		 calendar.setTime(date);
		 calendar.add(Calendar.DATE, days);
		 return calendar.getTime();
	 }
	 public static Date  getDateSubstractDays(Date date, int days){
		 Calendar calendar = Calendar.getInstance();
		 calendar.setTime(date);
		 calendar.add(Calendar.DATE, -days);
		 return calendar.getTime();
	 }
	 public static Date getDateAddedMonth(Date date, int months){
		 Calendar calendar = Calendar.getInstance();
		 calendar.setTime(date);
		 calendar.add(Calendar.MONTH, months);
		 return calendar.getTime();
	 }
	 public static Date getDateSubstractMonth(Date date, int months){
		 Calendar calendar = Calendar.getInstance();
		 calendar.setTime(date);
		 calendar.add(Calendar.MONTH, -months);
		 return calendar.getTime();
	 }
	 
	 public static String formatDate (String date, String initDateFormat, String endDateFormat) throws ParseException {
	    Date initDate = new SimpleDateFormat(initDateFormat).parse(date);
	    SimpleDateFormat formatter = new SimpleDateFormat(endDateFormat);
	    String parsedDate = formatter.format(initDate);

	    return parsedDate;
	}
}
