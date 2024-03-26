package com.sellerportal.ism;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sellerportal.ism.utils.FileChangeListener;
import com.sellerportal.ism.utils.FileMonitor;

@SuppressWarnings("squid:S2886")
public class Application implements FileChangeListener{
	private static final Log LOGGER = LogFactory.getLog(Application.class);
	private static final String PROPERTIES_FILE = "application.properties";
    private boolean useClasspath;
    private long checkPeriod;
    static private Application instance_;

    private boolean appCurrency ;
    private String appCurrencyCode ;
    private String appCurrencySymbol ;
    private boolean cartCommonUserBase;
    private boolean sendGcOnRegistration;
    private boolean sendGcOnRegistrationToRegisteredFriend;
    private boolean sendGcOnRegistrationToReferrer;
    
    
    
    public boolean isSendGcOnRegistrationToRegisteredFriend() {
		return sendGcOnRegistrationToRegisteredFriend;
	}
	public void setSendGcOnRegistrationToRegisteredFriend(
			boolean sendGcOnRegistrationToRegisteredFriend) {
		this.sendGcOnRegistrationToRegisteredFriend = sendGcOnRegistrationToRegisteredFriend;
	}
	public boolean isSendGcOnRegistrationToReferrer() {
		return sendGcOnRegistrationToReferrer;
	}
	public void setSendGcOnRegistrationToReferrer(
			boolean sendGcOnRegistrationToReferrer) {
		this.sendGcOnRegistrationToReferrer = sendGcOnRegistrationToReferrer;
	}
	/**
	 * @return Returns the sendGcOnRegistration.
	 */
	public boolean isSendGcOnRegistration() {
		return sendGcOnRegistration;
	}
	/**
	 * @param sendGcOnRegistration The sendGcOnRegistration to set.
	 */
	public void setSendGcOnRegistration(boolean sendGcOnRegistration) {
		this.sendGcOnRegistration = sendGcOnRegistration;
	}
	/* Default Constructor */
    private Application() {
    }
    private Application(boolean b) {
        this.useClasspath = b;
        reloadProperties();
    }
    
    @SuppressWarnings("squid:S2168")
    static public Application instance()
    {
    	if(instance_== null) //don't want to block here
        {
          //two or more threads might be here!!!
          synchronized(Application.class)
          {
            //must check again as one of the
            //blocked threads can still enter
            if(instance_==null)
              instance_= new Application(true);//safe
          }
        }
        return instance_;
    }

	public long getCheckPeriod() {
        return checkPeriod;
    }

    public synchronized void setCheckPeriod(long period) {
    	LOGGER.info("Setting checkPeriod: " + period);
        checkPeriod = period;
		try {
		    FileMonitor.getInstance().addFileChangeListener(this, 
								PROPERTIES_FILE, 
								checkPeriod);
		}
		catch (FileNotFoundException e) {
			if(LOGGER.isErrorEnabled())
				LOGGER.error("Please check the WEB-INF/classes for property file.",e);
		}
    }
    private void reloadProperties() {
    	Properties props = new Properties();
        InputStream in = null;
    	
        try {
			if (useClasspath) {
			in = getClass().getClassLoader().getResourceAsStream(PROPERTIES_FILE);
 	    }
 	    else {
			in = new FileInputStream(PROPERTIES_FILE);
 	    }
			props.load(in);
		} catch (FileNotFoundException e) {
			if(LOGGER.isErrorEnabled())
			LOGGER.error("Please check the WEB-INF/classes for property file.",e);
		} catch (IOException e) {
			if(LOGGER.isErrorEnabled())
			LOGGER.error("Please check the WEB-INF/classes for property file.",e);
		} finally {
			if (in != null) {
				try {
					in.close();
				} catch (Exception e) {
					LOGGER.error("Message :: "+e.toString() +" Cause :: "+e.getCause());
				}
			}
		}
    	

    	setCheckPeriod(Long.parseLong(props.getProperty("checkPeriod")));
    	setAppCurrency(new Boolean(props.getProperty("appCurrency")).booleanValue());
    	setSendGcOnRegistration(new Boolean(props.getProperty("sendGcOnRegistration")).booleanValue());
    	setSendGcOnRegistrationToReferrer(new Boolean(props.getProperty("sendGcOnRegistrationToReferrer")).booleanValue());
    	setSendGcOnRegistrationToRegisteredFriend(new Boolean(props.getProperty("sendGcOnRegistrationToRegisteredFriend")).booleanValue());
    	setAppCurrencyCode(props.getProperty("appCurrencyCode"));
    	setAppCurrencySymbol(props.getProperty("appCurrencySymbol"));
    	setCartCommonUserBase(Boolean.getBoolean(props.getProperty("cartCommonUserBase")));
        }
    
    public void fileChanged(String fileName) {
        reloadProperties();
    }
    
    public void destroy(){
    	FileMonitor.getInstance().removeFileChangeListener(this,PROPERTIES_FILE);
    }

	
    
	public boolean isAppCurrency() {
		return appCurrency;
	}

	public String getAppCurrencyCode() {
		return appCurrencyCode;
	}

	public String getAppCurrencySymbol() {
		return appCurrencySymbol;
	}

	private synchronized void setAppCurrency(boolean appCurrency) {
		this.appCurrency = appCurrency;
	}

	private synchronized void setAppCurrencyCode(String appCurrencyCode) {
		this.appCurrencyCode = appCurrencyCode;
	}

	private synchronized void setAppCurrencySymbol(String appCurrencySymbol) {
		this.appCurrencySymbol = appCurrencySymbol;
	}
	public static void main(String[] args) {
		
	}
	/**
	 * @return Returns the cartCommonUserBase.
	 */
	public boolean isCartCommonUserBase() {
		return cartCommonUserBase;
	}
	/**
	 * @param cartCommonUserBase The cartCommonUserBase to set.
	 */
	public synchronized void setCartCommonUserBase(boolean cartCommonUserBase) {
		this.cartCommonUserBase = cartCommonUserBase;
	}
}
