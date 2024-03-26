package com.sellerportal.tisl.commons.listener;
import java.util.concurrent.atomic.LongAdder;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sellerportal.integra.impl.octashop.utils.OctashopUtils;
import com.sellerportal.ism.i18n.I18nFilter;
public class SessionListener implements HttpSessionListener{
	
	private static LongAdder created = new LongAdder();
	private static LongAdder destroyed = new LongAdder();
	public static int activeSessions = 0;
	 
	 private static Log LOGGER = LogFactory.getLog(SessionListener.class);
	  public void sessionCreated(HttpSessionEvent event) {
		  
		  try {
			  created.increment();
			  HttpSession session =  event.getSession();
			  LOGGER.info(" sessionCreated : created  = "+created.longValue()+" destroyed = "+destroyed.longValue()+" SessionID = "+event.getSession().getId()+" ActiveUsersCount = "+activeSessions);
		  }catch(Exception e) {
			  
		  }finally {
			  
		  }
		  
	  }
	 
	  public void sessionDestroyed(HttpSessionEvent event) {
		  destroyed.increment();
		 LOGGER.info(" sessionDestroyed : created  = "+created.longValue()+" destroyed = "+destroyed.longValue()+" SessionID = "+event.getSession().getId()+" ActiveUsersCount = "+activeSessions);
		 HttpSession session =  event.getSession();
		 String userID = (String) session.getAttribute("sessionUserID");
		 if(!OctashopUtils.isEmpty(userID)){
			 activeSessions--;
			 I18nFilter.userSessionMap.remove(userID);
		 }
	  }	
	  
	  public static int getActiveUsers(){
		  return activeSessions;
	  }
}

