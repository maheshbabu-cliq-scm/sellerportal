/*
 *
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package com.sellerportal.mail;

import java.io.File;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.ResourceBundle;

import jakarta.mail.Message;
import jakarta.mail.Session;
import jakarta.mail.Transport;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;
import javax.naming.InitialContext;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.anm.hibernate.DAOException;
import com.sellerportal.integra.impl.octashop.utils.OctashopUtils;
import com.sellerportal.ism.Configuration;
import com.sellerportal.ism.SessionVariablesBean;
import com.sellerportal.model.Ismmdm;
import com.sellerportal.dao.IsmmdmDAO;
import com.anm.jsf.utils.FacesUtils;

/**
 * @author Prasanna
 */
public abstract class AbstractMailApi {

    private static final Log LOGGER = LogFactory.getLog(AbstractMailApi.class);

    public abstract String getSmtpServer();

    public abstract String getJndiName();

    public abstract File getTemplateLocation();

    private static final ResourceBundle RESOURCE_BUNDLE = ResourceBundle
	.getBundle("appConfig");
    
    final Configuration conf = new Configuration();

    private static final String STATUS_CODE = "200";  //added by Parag TPR-6127
    
    //TODO Should it be synchronized for some reason
    private static Session session = null;

    /*
     * Send generic mail method.
     * 
     * @param params @param mail @throws Exception
     */
    
    /**
     * @param to
     * @param cc
     * @param bcc
     * @param msg
     * @throws MailException
     */
    private void setMessageRecepients(String to, String cc, String bcc,
            Message msg) throws MailException {
        try {
            InternetAddress[] toAddrs = null, ccAddrs = null, bccAddrs = null;
            toAddrs = InternetAddress.parse(to, false);

            if (cc != null) {
                ccAddrs = InternetAddress.parse(cc, false);
            }
            if (bcc != null) {
                bccAddrs = InternetAddress.parse(bcc, false);
            }
            msg.setRecipients(Message.RecipientType.TO, toAddrs);
            msg.setRecipients(Message.RecipientType.CC, ccAddrs);
            msg.setRecipients(Message.RecipientType.BCC, bccAddrs);
        } catch (Exception e) {
            throw new MailException(
                    "Error in setting recepients : Address parsing");
        }
    }

    /**
     * Get mail session
     * 
     * @return
     */
    public Session getSession() {
        if (session != null)
            return session;
        
        try {
            InitialContext ctx = new InitialContext();
            session = (Session) ctx.lookup(getJndiName());
            return session;
        } catch (Exception e) {
            LOGGER.error("Unable to lookup mail session from JNDI lookup["
                    + e.getMessage() + "]");
        }

        if (session == null) {
            Properties props = new Properties();
            LOGGER.warn("SMTP Server: "+getSmtpServer());
            props.put("mail.smtp.host", getSmtpServer());
            props.put("mail.smtp.port", RESOURCE_BUNDLE.getString("mailServerPort"));
            props.put("mail.smtp.timeout", 60000); //Max gap in socket read/write 60 seconds
            
            
            //props.put("mail.debug", "true");
            session = Session.getInstance(props, null);
            LOGGER.error("Obatained Session from local configuration.");
        }

        return session;
    }

    public void sendEmail(String to, String from, String subj, String text,
            String cc, String bcc) throws MailException {
        try {
            
        	
            if (LOGGER.isDebugEnabled()) {
                LOGGER.debug(" \n");
                LOGGER.debug(text);
                LOGGER.debug(" \n");
            }
            
            String host = conf.getMailServerIP();
            int port=0;
            String userName="";
            String password = "";
            
            Properties props = new Properties();
            
            if(OctashopUtils.isEmpty(from)) {
            	if(RESOURCE_BUNDLE.getString("fromAddress")!=null && !"".equalsIgnoreCase(RESOURCE_BUNDLE.getString("fromAddress"))){
                	from = RESOURCE_BUNDLE.getString("fromAddress");
                }
            }
            
            if(RESOURCE_BUNDLE.getString("mailServerPort")!=null && !"".equalsIgnoreCase(RESOURCE_BUNDLE.getString("mailServerPort"))){
            	port = Integer.parseInt(RESOURCE_BUNDLE.getString("mailServerPort"));	
            }
        	
            if(RESOURCE_BUNDLE.getString("mailServerUserName")!=null && !"".equalsIgnoreCase(RESOURCE_BUNDLE.getString("mailServerUserName"))
            		&& RESOURCE_BUNDLE.getString("mailServerPassword")!=null && !"".equalsIgnoreCase(RESOURCE_BUNDLE.getString("mailServerPassword"))){
            	userName = RESOURCE_BUNDLE.getString("mailServerUserName");
            	password = RESOURCE_BUNDLE.getString("mailServerPassword");

            	props.put("mail.smtp.auth", "true");
            }

            props.put("mail.transport.protocol", "smtp");
            props.put("mail.smtp.host", host);
            
            
            props.put("mail.smtp.timeout", 60000); //Max gap in socket read/write 60 seconds
            
            //props.put("mail.smtp.starttls.enable", "true"); //Commented for tsl certificate issue

            Session  session = Session.getDefaultInstance(props);
            
            //Manojv 
            if(RESOURCE_BUNDLE.getString("mailDebugEnable")!=null && !"".equalsIgnoreCase(RESOURCE_BUNDLE.getString("mailDebugEnable"))){
                if("Y".equalsIgnoreCase(RESOURCE_BUNDLE.getString("mailDebugEnable"))){
                session.setDebug(true);
                }
            }
            
            Message msg = new MimeMessage(session);
            if (to != null) {
                setMessageRecepients(to, cc, bcc, msg);
            } else {
                throw new MailException("No \"To\" address specified");
            }
            if (subj != null) {
                msg.setSubject(subj);
            } else {
                subj = "Subject not specified";
            }

            msg.setFrom(new InternetAddress(from));
            if (text != null) {
                msg.setContent(text, "text/html");
            }

            msg.saveChanges();
            
            Transport transport = session.getTransport();
            
            LOGGER.info(" modified : get the transport to send the mail");
            
            transport.connect(host,port,userName,password);
            transport.sendMessage(msg,msg.getAllRecipients());
            transport.close();

        } catch (Exception mex) {
            LOGGER.error(mex.getStackTrace());
            LOGGER.error("sendEmail:EXCEPTION [" + mex.getMessage() + "]");
            throw new MailException(mex.getMessage());
        }
    }
    
    
    
    public void sendEmail(String to, String from, String subj, String text,
            String cc, String bcc,Transport transport) throws MailException {
        try {
            
            if (LOGGER.isDebugEnabled()) {
                LOGGER.debug(" \n");
                LOGGER.debug(text);
                LOGGER.debug(" \n");
            }
                     
            Session session = getSession();
            Message msg = new MimeMessage(session);
            if (to != null) {
                setMessageRecepients(to, cc, bcc, msg);
            } else {
                throw new MailException("No \"To\" address specified");
            }
            if (subj != null) {
                msg.setSubject(subj);
            } else {
                subj = "Subject not specified";
            }

            msg.setFrom(new InternetAddress(from));
            if (text != null) {
                msg.setContent(text, "text/html");
            }
            
            transport.sendMessage(msg,msg.getAllRecipients());
            
        } catch (Exception mex) {
            LOGGER.error(mex.getStackTrace());
            LOGGER.error("sendEmail:EXCEPTION [" + mex.getMessage() + "]");
            throw new MailException(mex.getMessage());
        }
    }
    
    /**
     * To make a one connection for transport for bulk mail sending
     * @return
     * @throws MailException
     */
    public Transport openMailTransport() throws MailException {
        Session session = getSession();
        try {
        	long l = System.currentTimeMillis();        	
        	LOGGER.info("MAIL SERVER CONNECTING TIME:::"+l+"MS");
        	String host = conf.getMailServerIP();
        	String connectionTimeout = conf.getMailConnectionTimeOut();
            int port=0;
            String userName="";
            String password = "";
            
            Properties props = new Properties();
            
            if(RESOURCE_BUNDLE.getString("mailServerPort")!=null && !"".equalsIgnoreCase(RESOURCE_BUNDLE.getString("mailServerPort"))){
            	port = Integer.parseInt(RESOURCE_BUNDLE.getString("mailServerPort"));	
            }
        	
            if(RESOURCE_BUNDLE.getString("mailServerUserName")!=null && !"".equalsIgnoreCase(RESOURCE_BUNDLE.getString("mailServerUserName"))
            		&& RESOURCE_BUNDLE.getString("mailServerPassword")!=null && !"".equalsIgnoreCase(RESOURCE_BUNDLE.getString("mailServerPassword"))){
            	userName = RESOURCE_BUNDLE.getString("mailServerUserName");
            	password = RESOURCE_BUNDLE.getString("mailServerPassword");

            	props.put("mail.smtp.auth", "true");
            }
            
            props.put("mail.transport.protocol", "smtp");
            props.put("mail.smtp.host", host);
            props.put("mail.smtp.ssl.enable", "false");
            props.put("mail.smtp.starttls.enable", "false");
            props.put("mail.smtp.connectiontimeout",connectionTimeout);
            props.put("mail.smtp.timeout", 60000); //Max gap in socket read/write 60 seconds
            
            session = Session.getDefaultInstance(props);
            session.setDebug(true);
        	
            Transport transport = session.getTransport("smtp");
            
            transport.connect(host,port,userName,password);
            LOGGER.info("MAIL SERVER CONNECTING END-TIME:::"+System.currentTimeMillis()+"MS");
            return transport;
        } catch (Exception e) {
            LOGGER.info("Message :: "+e.toString() +" Cause :: "+e.getCause());
            throw new MailException("No such provider smtp");
        }
    }

    public void sendEmail(String to, String from, String subj, String text)
            throws MailException {
    	if(to != null){
    		sendEmail(to, from, subj, text, null, null);
    	}else{
    		LOGGER.error("To Address not define.");
    	}
    }
    
    /**
     * Create instance of abstract mail api.
     * @param smtpServer
     * @param templateLocation
     * @return
     */
    public static AbstractMailApi getInstance(final String smtpServer, final String templateLocation) {
    	session = null;
    	AbstractMailApi api = new AbstractMailApi() {
            public String getJndiName() {
                return null;
            }

            public String getSmtpServer() {
                return smtpServer;
            }

            public File getTemplateLocation() {
                return new File(templateLocation);
            }
        };
        return api;
    }

    
    /*********************************************************added by punit for sending mail to new register cutomer***********************************************************************************/   
   	public void sendMailForNewRegisterCustomer(String from_email, String to, String[] cc, String subject, String text) 
   		throws MailException {
   		    
   		       
  
   	        try
   	        {
   	        	 if (LOGGER.isDebugEnabled()) {
   	                 LOGGER.debug(" \n");
   	                 LOGGER.debug(text);
   	                 LOGGER.debug(" \n");
   	             }
   	             
   	             String host = conf.getMailServerIP();
   	             int port=0;
   	             String userName="";
   	             String password = "";
   	             
   	             Properties props = new Properties();
   	             
   	             if(RESOURCE_BUNDLE.getString("fromAddress")!=null && !"".equalsIgnoreCase(RESOURCE_BUNDLE.getString("fromAddress"))){
   	            	 from_email = "(tisl)salesupdate@tisl.com";
   	             }
   	             
   	             if(RESOURCE_BUNDLE.getString("mailServerPort")!=null && !"".equalsIgnoreCase(RESOURCE_BUNDLE.getString("mailServerPort"))){
   	             	port = Integer.parseInt(RESOURCE_BUNDLE.getString("mailServerPort"));	
   	             }
   	         	
   	             if(RESOURCE_BUNDLE.getString("mailServerUserName")!=null && !"".equalsIgnoreCase(RESOURCE_BUNDLE.getString("mailServerUserName"))
   	             		&& RESOURCE_BUNDLE.getString("mailServerPassword")!=null && !"".equalsIgnoreCase(RESOURCE_BUNDLE.getString("mailServerPassword"))){
   	             	userName = RESOURCE_BUNDLE.getString("mailServerUserName");
   	             	password = RESOURCE_BUNDLE.getString("mailServerPassword");

   	             	props.put("mail.smtp.auth", "true");
   	             }

   	             props.put("mail.transport.protocol", "smtp");
   	             props.put("mail.smtp.host", host);
   	             props.put("mail.smtp.starttls.enable", "true");
   	          props.put("mail.smtp.timeout", 60000); //Max gap in socket read/write 60 seconds

   	             Session  session = Session.getDefaultInstance(props);
   	             session.setDebug(true);
   	            MimeMessage msg = new MimeMessage(session);
   	            msg.setFrom(new InternetAddress(from_email));
   	            InternetAddress[] address = {new InternetAddress(to)};
   	            msg.setRecipients(Message.RecipientType.TO, address);

   	            address = new InternetAddress[cc.length];
   	            for (int i = 0; i < cc.length; i++)
   	            {
   	                String ccEmail = cc[i];
   	                address[i] = new InternetAddress(ccEmail);
   	            }

   	            msg.setRecipients(Message.RecipientType.CC, address);
   	            msg.setContent(text, "text/html");
   	            msg.setSubject(subject);
   	            msg.setSentDate(new Date());

   	            msg.saveChanges();
   	            LOGGER.info(" modified : get the transport to send the mail");
   	            Transport transport = session.getTransport();
   	            transport.connect(host,port,userName,password);
   	            transport.sendMessage(msg,msg.getAllRecipients());
   	        }
   	        catch (Exception mex) {
   	            LOGGER.error(mex.getStackTrace());
   	            LOGGER.error("sendEmail:EXCEPTION [" + mex.getMessage() + "]");
   	            throw new MailException(mex.getMessage());
   	        }

   	}
   	/*********************************************************end for sending mail to new register cutomer***********************************************************************************/
    
    public void sendEmailComplainDetails(String to, String from, String subj, String text,
            String cc, String bcc) throws MailException {
        try {
            
        	
            if (LOGGER.isDebugEnabled()) {
                LOGGER.debug(" \n");
                LOGGER.debug(text);
                LOGGER.debug(" \n");
            }
            
            String host = conf.getMailServerIP();
            int port=0;
            String userName="";
            String password = "";
            
            Properties props = new Properties();
            
            if(RESOURCE_BUNDLE.getString("fromAddress")!=null && !"".equalsIgnoreCase(RESOURCE_BUNDLE.getString("fromAddress"))){
            	from = RESOURCE_BUNDLE.getString("fromAddress");
            }
            
            if(RESOURCE_BUNDLE.getString("mailServerPort")!=null && !"".equalsIgnoreCase(RESOURCE_BUNDLE.getString("mailServerPort"))){
            	port = Integer.parseInt(RESOURCE_BUNDLE.getString("mailServerPort"));	
            }
        	
            if(RESOURCE_BUNDLE.getString("mailServerUserName")!=null && !"".equalsIgnoreCase(RESOURCE_BUNDLE.getString("mailServerUserName"))
            		&& RESOURCE_BUNDLE.getString("mailServerPassword")!=null && !"".equalsIgnoreCase(RESOURCE_BUNDLE.getString("mailServerPassword"))){
            	userName = RESOURCE_BUNDLE.getString("mailServerUserName");
            	password = RESOURCE_BUNDLE.getString("mailServerPassword");

            	props.put("mail.smtp.auth", "true");
            }

            props.put("mail.transport.protocol", "smtp");
            props.put("mail.smtp.host", host);
            props.put("mail.smtp.starttls.enable", "true");
            props.put("mail.smtp.timeout", 60000); //Max gap in socket read/write 60 seconds

            Session  session = Session.getInstance(props);
            session.setDebug(true);
            
            Message msg = new MimeMessage(session);
            if (to != null) {
                setMessageRecepients(to, cc, bcc, msg);
            } else {
                throw new MailException("No \"To\" address specified");
            }
            if (subj != null) {
                msg.setSubject(subj);
            } else {
                subj = "Subject not specified";
            }

            msg.setFrom(new InternetAddress(from));
            if (text != null) {
                msg.setContent(text, "text/html");
            }

            msg.saveChanges();
            
            Transport transport = session.getTransport();
            
            LOGGER.info(" modified : get the transport to send the mail");
            
            transport.connect(host,port,userName,password);
            transport.sendMessage(msg,msg.getAllRecipients());
            transport.close();
            session=null;

        } catch (Exception mex) {
            LOGGER.error(mex.getStackTrace());
            LOGGER.error("sendEmail:EXCEPTION [" + mex.getMessage() + "]");
            session=null;
            throw new MailException(mex.getMessage());
            
        }
    }
    
/*Parag Start TPR-6127*/
    public String sendEmailWithStatus(String to, String from, String subj, String text,
            String cc, String bcc) throws MailException {
    	String status = "";
        try {
            
        	
            if (LOGGER.isDebugEnabled()) {
                LOGGER.debug(" \n");
                LOGGER.debug(text);
                LOGGER.debug(" \n");
            }
            
            String host = conf.getMailServerIP();
            int port=0;
            String userName="";
            String password = "";
            
            Properties props = new Properties();
            
            if(OctashopUtils.isEmpty(from)) {
            	if(RESOURCE_BUNDLE.getString("fromAddress")!=null && !"".equalsIgnoreCase(RESOURCE_BUNDLE.getString("fromAddress"))){
                	from = RESOURCE_BUNDLE.getString("fromAddress");
                }
            }
            
            if(RESOURCE_BUNDLE.getString("mailServerPort")!=null && !"".equalsIgnoreCase(RESOURCE_BUNDLE.getString("mailServerPort"))){
            	port = Integer.parseInt(RESOURCE_BUNDLE.getString("mailServerPort"));	
            }
        	
            if(RESOURCE_BUNDLE.getString("mailServerUserName")!=null && !"".equalsIgnoreCase(RESOURCE_BUNDLE.getString("mailServerUserName"))
            		&& RESOURCE_BUNDLE.getString("mailServerPassword")!=null && !"".equalsIgnoreCase(RESOURCE_BUNDLE.getString("mailServerPassword"))){
            	userName = RESOURCE_BUNDLE.getString("mailServerUserName");
            	password = RESOURCE_BUNDLE.getString("mailServerPassword");

            	props.put("mail.smtp.auth", "true");
            }

            props.put("mail.transport.protocol", "smtp");
            props.put("mail.smtp.host", host);
            
            
            props.put("mail.smtp.timeout", 60000); //Max gap in socket read/write 60 seconds
            
            //props.put("mail.smtp.starttls.enable", "true"); //Commented for tsl certificate issue

            Session  session = Session.getDefaultInstance(props);
            
            //Manojv 
            if(RESOURCE_BUNDLE.getString("mailDebugEnable")!=null && !"".equalsIgnoreCase(RESOURCE_BUNDLE.getString("mailDebugEnable"))){
                if("Y".equalsIgnoreCase(RESOURCE_BUNDLE.getString("mailDebugEnable"))){
                session.setDebug(true);
                }
            }
            
            Message msg = new MimeMessage(session);
            if (to != null) {
                setMessageRecepients(to, cc, bcc, msg);
            } else {
                throw new MailException("No \"To\" address specified");
            }
            if (subj != null) {
                msg.setSubject(subj);
            } else {
                subj = "Subject not specified";
            }

            msg.setFrom(new InternetAddress(from));
            if (text != null) {
                msg.setContent(text, "text/html");
            }

            msg.saveChanges();
            
            Transport transport = session.getTransport();
            
            LOGGER.info(" modified : get the transport to send the mail");
            
            transport.connect(host,port,userName,password);
            transport.sendMessage(msg,msg.getAllRecipients());
            transport.close();
            status = STATUS_CODE;

        } catch (Exception mex) {
            LOGGER.error(mex.getStackTrace());
            LOGGER.error("sendEmail:EXCEPTION [" + mex.getMessage() + "]");
            throw new MailException(mex.getMessage());
        }
        return status;
    }
    
    public String sendEmailWithStatus(String to, String from, String subj, String text)
            throws MailException {
    	String status = "";
    	if(to != null){
    		status = sendEmailWithStatus(to, from, subj, text, null, null);
    	}else{
    		LOGGER.error("To Address not define.");
    	}
    	return status;
    }
  /*Parag end TPR-6127*/
}