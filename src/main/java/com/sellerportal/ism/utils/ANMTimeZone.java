/**
 * 
 */
package com.sellerportal.ism.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sellerportal.integra.impl.octashop.utils.OctashopUtils;
import com.sellerportal.dao.OrgiptDAO;

/**
 * @author Binod Kumar
 *
 */
public class ANMTimeZone {

	private static final Log LOGGER = LogFactory.getLog(ANMTimeZone.class);
	
	public static Date getDateInTimeZone()
	{
		//Meena: Skip timezone feature
		if(true)
			return new Date();
		
		String timeZoneId = new OrgiptDAO().getOrgIptValueByName("TimeZoneId");
		
		if(OctashopUtils.isEmpty(timeZoneId)){
			timeZoneId = "GMT+05:30";
			//LOGGER.info("FAILED TO RETRIVE ORGANIZATION DATE :::: timeZoneId NOT FOUND IN ORGIPT ::::: DEFAULT [IND]");
		}
		
		TimeZone tz = TimeZone.getTimeZone(timeZoneId);
		Calendar mbCal = new GregorianCalendar(TimeZone.getTimeZone(timeZoneId));
		mbCal.setTimeInMillis(new Date().getTime());
	
			Calendar cal = Calendar.getInstance();
			cal.set(Calendar.YEAR, mbCal.get(Calendar.YEAR));
			cal.set(Calendar.MONTH, mbCal.get(Calendar.MONTH));
			cal.set(Calendar.DAY_OF_MONTH, mbCal.get(Calendar.DAY_OF_MONTH));
			cal.set(Calendar.HOUR_OF_DAY, mbCal.get(Calendar.HOUR_OF_DAY));
			cal.set(Calendar.MINUTE, mbCal.get(Calendar.MINUTE));
			cal.set(Calendar.SECOND, mbCal.get(Calendar.SECOND));
			cal.set(Calendar.MILLISECOND, mbCal.get(Calendar.MILLISECOND));
	
		return cal.getTime();
	}
	
	public static long getTimeInTimeZone(long currentTime, String timeZoneId)
	{
		TimeZone tz = TimeZone.getTimeZone(timeZoneId);
		Calendar mbCal = new GregorianCalendar(TimeZone.getTimeZone(timeZoneId));
		mbCal.setTimeInMillis(currentTime);
		
			Calendar cal = Calendar.getInstance();
			cal.set(Calendar.YEAR, mbCal.get(Calendar.YEAR));
			cal.set(Calendar.MONTH, mbCal.get(Calendar.MONTH));
			cal.set(Calendar.DAY_OF_MONTH, mbCal.get(Calendar.DAY_OF_MONTH));
			cal.set(Calendar.HOUR_OF_DAY, mbCal.get(Calendar.HOUR_OF_DAY));
			cal.set(Calendar.MINUTE, mbCal.get(Calendar.MINUTE));
			cal.set(Calendar.SECOND, mbCal.get(Calendar.SECOND));
			cal.set(Calendar.MILLISECOND, mbCal.get(Calendar.MILLISECOND));
		
		return cal.getTimeInMillis();
	}
	@SuppressWarnings("squid:S2583")
	public static String getDateInTimeZoneForSql()
	{
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String getDateTimeinSql=null;
		Date getTodayDate=new Date();
		if(ANMTimeZone.getDateInTimeZone() !=null){
		getDateTimeinSql=getDateTimeinSql=format.format(ANMTimeZone.getDateInTimeZone());
		}else{
		getDateTimeinSql=getDateTimeinSql=format.format(getTodayDate);	
		}
		return getDateTimeinSql;
	}
	
	public static void main(String[] args)
	{
		Date now = new Date();
		
		System.out.println("Current Time="+now);
		Calendar cal = Calendar.getInstance();
		System.out.println("Current Timezone="+cal.getTimeZone().getDisplayName());
		
		//Canada/Central
		String timeZoneId = "Canada/Central";
		System.out.println("Getting Time in the timezone="+timeZoneId);
		//System.out.println("Current Time there="+getDateInTimeZone(now,timeZoneId));
	
	}

}

	