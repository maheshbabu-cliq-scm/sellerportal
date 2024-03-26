/*
 *
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package com.sellerportal.ism.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.faces.application.FacesMessage;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import jakarta.mail.Address;
import jakarta.mail.BodyPart;
import jakarta.mail.Message;
import jakarta.mail.Multipart;
import jakarta.mail.Transport;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeBodyPart;
import jakarta.mail.internet.MimeMessage;
import jakarta.mail.internet.MimeMultipart;
import javax.servlet.ServletContext;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.BooleanUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.jdbc.Work;

import com.anm.hibernate.DAOException;
import com.anm.hibernate.HibernateConnection;
import com.sellerportal.integra.impl.octashop.utils.OctashopUtils;
import com.sellerportal.ism.ApplicationConstant;
import com.sellerportal.ism.Configuration;
import com.sellerportal.ism.SessionVariablesBean;
import com.sellerportal.model.Ismcmt;
import com.sellerportal.dao.IsmcmtDAO;
import com.sellerportal.model.Ismubi;
import com.sellerportal.dao.IsmubiDAO;
import com.sellerportal.dao.OrgiptDAO;
import com.sellerportal.ism.i18n.I18nHelper;
import com.sellerportal.mail.AbstractMailApi;
import com.sellerportal.webservice.CourierServiceConstants;
import com.sellerportal.webservice.WebserviceConstants;

/**
 * @author Vinit
 * 
 * TODO To change the template for this generated type comment go to Window -
 * Preferences - Java - Code Style - Code Templates
 */
@SuppressWarnings("squid:S2885")
public class CommonUtils extends com.anm.utils.CommonUtils {
	private static final Log LOGGER = LogFactory.getLog(CommonUtils.class);

	/**
	 * This method is used for Checking ISM Login Id. Here it checks on ISM
	 * only.this method is called with in login_submitAction().
	 * 
	 * @param loginId
	 * @return result
	 * @throws DAOException
	 */
	public String ismLogin(String loginId, HttpServletRequest request) {
		String navigation = "";

		SessionVariablesBean sessionBean = (SessionVariablesBean) request
				.getSession().getAttribute("SessionVariablesBean");
		if (sessionBean == null)
			return navigation;

		// Fix - Problem reported for non-availability of login on registration
		// page.
		sessionBean.setLoginId(loginId);
		Ismubi ismubi = new IsmubiDAO().findByUserId(loginId);
		if (ismubi != null) {
			Long ubirfnum = new Long(ismubi.getUbirfnum().toString());
			long ubinum = ubirfnum.longValue();
			sessionBean.setUserRefNo("" + ubinum);
			navigation = "success";
		} else {
			LOGGER.info("User not registered on Website. Go to Website registeration page.");
			navigation = "login";
		}
		return navigation;
	}

	public String login() throws Exception {
		ExternalContext externalContext = FacesContext.getCurrentInstance()
				.getExternalContext();
		HttpServletRequest request = (HttpServletRequest) externalContext
				.getRequest();
		HttpServletResponse response = (HttpServletResponse) externalContext
				.getResponse();
		return login(request, response);
	}

	/**
	 * Fetch User ID from Cookies set by integra
	 * 
	 * @return String LoginId Octashop ID
	 * @throws Exception
	 */
	public String login(HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		Cookie[] cookies = request.getCookies();
		Map requestCookieMap = new HashMap();
		for (int i = 0; i < cookies.length; i++) {
			requestCookieMap.put(cookies[i].getName(), cookies[i].getValue());
		}

		String mscsCookie = (String) requestCookieMap.get("MSCSAuth");
		if (mscsCookie == null)
			return null;

		String mscsAuthDetailsCookie = (String) requestCookieMap
				.get("MSCSAuthDetails");
		if (mscsAuthDetailsCookie == null
				|| mscsAuthDetailsCookie.trim().length() == 0)
			return null;

		String loginId = mscsAuthDetailsCookie.substring(mscsAuthDetailsCookie
				.indexOf("=") + 1);
		LOGGER.info(" Login  id from cookie [" + loginId + "]");
		loginId = loginId.trim();
		return loginId;
	}

	
	/**
	 * @param affiliateID
	 * @return
	 */
	public Long getMailDefinitionByAffiliate(String affiliateID,
			String paymentMode) {
				return null;/*
		Long mdmrfnum = null;
		List aptlist = new IsmaptDAO().findIsmmdm(affiliateID, paymentMode);
		if (aptlist != null && aptlist.size()>0) {
			Ismapt ismapt = (Ismapt) aptlist.get(0);
			Ismmdm mdm = ismapt.getIsmmdm();
			if (mdm != null) {
				return mdm.getMdmrfnum();
			}
		}
		return mdmrfnum;
	*/}
	
	//Added by .
	public Long getMailDefinition(String paymentMode) {
		return null;/*
		Long mdmrfnum = null;
		List mdmrfList = new IsmaptDAO().findIsmmdm1(paymentMode);
		if (mdmrfList != null && mdmrfList.size()>0) 
			mdmrfnum = (Long) mdmrfList.get(0);
		
		return mdmrfnum;
	*/}
	
	/**
	 * Method parse the 
	 * 
	 * @author chandrasingh.meena@anmsoft.com
	 */
	public static Map parseRewrittenURL(HttpServletRequest request, HttpServletResponse response)
	{
		/*UrlRewriter urlRewriter = UrlRewriteFilter.getUrlRewriter();
		if(urlRewriter != null)
		{
			try {
				RewrittenUrl rewrittenURL = urlRewriter.processRequest(request,response);
				if(rewrittenURL != null)
				{
					String[] uriQueryString = RewrittenUrl.parseTarget(rewrittenURL.getTarget());
					Map params = new FacesUtils().decodeQuery(uriQueryString[1],"&");;
					return params;
				}
				
			} catch (IOException e) {
				LOGGER.info("Message :: "+e.toString() +" Cause :: "+e.getCause());
			} catch (ServletException e) {
				LOGGER.info("Message :: "+e.toString() +" Cause :: "+e.getCause());
			}catch(Exception e)
			{
				LOGGER.info("Message :: "+e.toString() +" Cause :: "+e.getCause());
			}
		}*/
		return null;
	}
	
	@SuppressWarnings("squid:S2583")
	public static String getCatalogueId(HttpServletRequest request, HttpServletResponse response)
	{
		Map parameters = parseRewrittenURL(request, response);
		if(parameters != null)
			return (String) parameters.get("catalogueID");
		return null;
	}
	
	public static Properties loadSchedulerConfiguration() throws Exception
	{
		Properties configuration = null;
		InputStream ins = null;
		try {
			if(FacesContext.getCurrentInstance() != null)
			{
				ServletContext servletContext = (ServletContext) FacesContext.getCurrentInstance().getExternalContext().getContext();
				//We are running inside WAR
				 ins = new FileInputStream(servletContext.getRealPath("WEB-INF/classes/scheduler-config.properties"));
				
			}else {
				ins = Thread.currentThread().getContextClassLoader().getResourceAsStream("scheduler-config.properties");
			}
			if(ins != null)
			{
				configuration = new Properties();
				configuration.load(ins);
			}else {
				throw new Exception("scheduler-config.properties should be in the root of classpath");
			}
			
		} catch (FileNotFoundException e) {
			throw e;
		} catch (IOException e) {
			throw e;
		} finally {
			try {
				if(ins!=null)
					ins.close();
			} catch(Exception e) {
				LOGGER.info("Error Message :: "+e.toString() +" Error Cause :: "+e.getCause());
			}
		}
		return configuration;
	}
	
	public static Properties loadFTPConfig() throws Exception {
		Properties configuration = null;
		InputStream ins = null;
		try {
			if(FacesContext.getCurrentInstance() != null) {
				ServletContext servletContext = (ServletContext) FacesContext.getCurrentInstance().getExternalContext().getContext();
				 ins = new FileInputStream(servletContext.getRealPath("WEB-INF/classes/ftp-config.properties"));
			}else {
				ins = Thread.currentThread().getContextClassLoader().getResourceAsStream("ftp-config.properties");
			}
			if(ins != null) {
				configuration = new Properties();
				configuration.load(ins);
			}else {
				throw new Exception("ftp-config.properties should be in the root of classpath");
			}
			
		} catch (FileNotFoundException e) {
			throw e;
		} catch (IOException e) {
			throw e;
		} finally {
			try {
				if(ins!=null)
					ins.close();
			} catch(Exception e) {
				LOGGER.info("Error Message :: "+e.toString() +" Error Cause :: "+e.getCause());
			}
		}
		return configuration;
	}
	
	public static Properties loadWebServiceConfig() throws Exception {
		Properties configuration = null;
		InputStream ins = null;
		try {
			if(FacesContext.getCurrentInstance() != null) {
				ServletContext servletContext = (ServletContext) FacesContext.getCurrentInstance().getExternalContext().getContext();
				 ins = new FileInputStream(servletContext.getRealPath("WEB-INF/classes/webservice-config.properties"));
			}else {
				ins = Thread.currentThread().getContextClassLoader().getResourceAsStream("webservice-config.properties");
			}
			if(ins != null) {
				configuration = new Properties();
				configuration.load(ins);
			}else {
				throw new Exception("webservice-config.properties should be in the root of classpath");
			}
		} catch (FileNotFoundException e) {
			throw e;
		} catch (IOException e) {
			throw e;
		} finally {
			try {
				if(ins!=null)
					ins.close();
			} catch(Exception e) {
				LOGGER.info("Error Message :: "+e.toString() +" Error Cause :: "+e.getCause());
			}
		}
		return configuration;
	}
	
	public static Properties loadSellerWebServiceConfig() throws Exception {
		Properties configuration = null;
		InputStream ins = null;
		try {
			if(FacesContext.getCurrentInstance() != null) {
				ServletContext servletContext = (ServletContext) FacesContext.getCurrentInstance().getExternalContext().getContext();
				 ins = new FileInputStream(servletContext.getRealPath("WEB-INF/classes/sellerIntegrationService.properties"));
			}else {
				ins = Thread.currentThread().getContextClassLoader().getResourceAsStream("sellerIntegrationService.properties");
			}
			if(ins != null) {
				configuration = new Properties();
				configuration.load(ins);
				
			}else {
				throw new Exception("webservice-config.properties should be in the root of classpath");
			}
		} catch (FileNotFoundException e) {
			throw e;
		} catch (IOException e) {
			throw e;
		} finally {
			try {
				if(ins!=null)
					ins.close();
			} catch(Exception e) {
				LOGGER.info("Error Message :: "+e.toString() +" Error Cause :: "+e.getCause());
			}
		}
		return configuration;
	}
	/**
	 <pre> Example usage
	 
		String [] attachments = new String [] {"C:/VAIO Entertainment/Thumbnail/01-We Are One_mp3.jpg","C:/VAIO Entertainment/Thumbnail/01-Kyrie - Kyrie Eleison (Chorus)_mp3.jpg"};
		try {
			CommonUtils.sendEmailWithAttachment("192.168.57.1","chandrasingh.meena@anmsoft.com", "sujan.singh@anmsoft.com,chndu6ue@gmail.com", "Lets Test Attachment in Java Email", "Dear All\n I Am attaching some pics\nPlease Have a Look", attachments, null);
		} catch (Exception e) {
			
			LOGGER.info("Message :: "+e.toString() +" Cause :: "+e.getCause());
		}
	 </pre>
	 * @param smtpServerIp
	 * @param fromAddress
	 * @param toAddress
	 * @param subject
	 * @param content
	 * @param attachmentFilePath
	 * @param attachmentDesc
	 * @throws Exception
	 */
	public static void sendEmailWithAttachment(String smtpServerIp,String fromAddress, String toAddress, String subject, String content,String [] attachmentFilePath,String [] attachmentDesc) throws Exception
	{
		
		try {
			AbstractMailApi api = AbstractMailApi.getInstance(smtpServerIp, null);
			
			
			Message message = new MimeMessage(api.getSession());
			Address[] toAddrs = null, ccAddrs = null, bccAddrs = null;
	        toAddrs = InternetAddress.parse(toAddress, false);
			
	        message.addRecipients(Message.RecipientType.TO, toAddrs);
	        message.setFrom(new InternetAddress(fromAddress));
	        message.setSubject(subject);
//			 Create the message part 
			BodyPart messageBodyPart = new MimeBodyPart();

//			 Fill the message
			StringBuilder msgText = new StringBuilder();
			msgText.append(content);
			messageBodyPart.setText(msgText.toString());
			

			Multipart multipart = new MimeMultipart();
			multipart.addBodyPart(messageBodyPart);

//			
//			 Put parts in message
			message.setContent(multipart);

//			 Send the message
			Transport transport = api.getSession().getTransport("smtp");
			transport.send(message);
			transport.close();
		}catch(Exception e) {
			LOGGER.info("Message :: "+e.toString() +" Cause :: "+e.getCause());
			throw e;
		}
		
	}
	
	
	
	public static void zipTheFile(File sourceFile,String targetFile)
	{
		byte[] buffer = new byte[1024]; 
		FileInputStream in = null;
		ZipOutputStream zos = null;
		try
    	{ 
    		in = new FileInputStream(sourceFile);
    		FileOutputStream fos = new FileOutputStream(targetFile);
    		zos = new ZipOutputStream(fos);    		
    		//Initialize the ZipEntry with the included file name, you can give any name in the parameter
    		ZipEntry ze= new ZipEntry(sourceFile.getName());
    		zos.putNextEntry(ze);
    		System.out.println("Compression started...");
    		int len;
    		while ((len = in.read(buffer)) > 0) 
    		{
    			zos.write(buffer, 0, len);
    		}
    		zos.closeEntry();
    		 
    		System.out.println("Done!!!!!!");
    		System.out.println(sourceFile.getCanonicalPath()+" is zipped to "+targetFile);
    	}
    	catch(IOException ex)
    	{
    	   LOGGER.error(ex.getStackTrace());
    	} finally {
    		//Remember to close all opened resources. 
    		if(in!=null) {
	    		try {
	    			in.close();
				} catch(Exception e) {
					LOGGER.info("Error Message :: "+e.toString() +" Error Cause :: "+e.getCause());
				}
	    		}
    		if(zos!=null) {
				try {
						zos.close();
				} catch(Exception e) {
					LOGGER.info("Error Message :: "+e.toString() +" Error Cause :: "+e.getCause());
				}
    		}
		}
	}
	
	public static void zipTheFiles(List<File> sourceFiles,File targetFile)
	{
		byte[] buffer = new byte[1024]; 
    	try(FileOutputStream fos = new FileOutputStream(targetFile);ZipOutputStream zos = new ZipOutputStream(fos);)
    	{   
    		//Initialize the ZipEntry with the included file name, you can give any name in the parameter
    		for(File sourceFile : sourceFiles) {
    			try(FileInputStream in = new FileInputStream(sourceFile);){
    				ZipEntry ze= new ZipEntry(sourceFile.getName());
    				zos.putNextEntry(ze);
    				System.out.println("Compression started...");
    				int len;
    				while ((len = in.read(buffer)) > 0) 
    				{
    					zos.write(buffer, 0, len);
    				}
    				System.out.println("Done!!!!!!");
    				System.out.println(sourceFile.getCanonicalPath()+" is zipped to "+targetFile);
    				//Remember to close all opened resources. 
    			}
    		}
    	}
    	catch(IOException ex)
    	{
    	   LOGGER.info(ex.getStackTrace());
    	}
	}
	
//	yyyy-MM-dd HHmmss
	private static final SimpleDateFormat DB_TIMESTAMP_FORMATTER = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	
	public static String getCurrentTimestamp(){
		return DB_TIMESTAMP_FORMATTER.format(ANMTimeZone.getDateInTimeZone());	
	}
	
	
    public boolean isValidEmail(String email){
        //Set the email pattern string
        Pattern p = Pattern.compile(".+@.+\\.[a-z]+");
        //Match the given string with the pattern
        Matcher m = p.matcher(email);
        //check whether match is found 
        boolean matchFound = m.matches();
        if (matchFound)
          return true;
        else
          return false;
    }
    /**
	 * Checks valid mobile no(10) digits.
	 * @author Girjesh vyas
	 * @param mobileNo
	 * @return
	 */ 
	public boolean isValidMobile(String mobileNo) {
		if (mobileNo.length() == 0)
			return false;
		if (mobileNo.length() < 10)
			return false;
		try {
			Long.parseLong(mobileNo);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}
	@SuppressWarnings("squid:S2095")
	public Connection createConnection() throws Exception
	{	
		Properties configuration = CommonUtils.loadSchedulerConfiguration();
		String url =  configuration.getProperty(WebserviceConstants.PARAM_CONFIG_DATABASE_URL);
		String userId = configuration.getProperty(WebserviceConstants.PARAM_CONFIG_DATABASE_USERNAME);
		String password = configuration.getProperty(WebserviceConstants.PARAM_CONFIG_DATABASE_PASSWORD);
		String driverClass = configuration.getProperty(WebserviceConstants.PARAM_CONFIG_DATABASE_DRIVER);
		//LOGGER.info("\n DB URL : "+url+" USERID : "+userId+" PASSWORD : "+password+" DRIVER_CLASS : "+driverClass);
		try {
			Class.forName(driverClass);
		} catch (ClassNotFoundException e) {
			throw new Exception("ClassNotFoundException:"+e.getMessage());
		}
		try {
			Connection connection = DriverManager.getConnection(url, userId, password);
			//connection.setReadOnly(true); //to avoid any implicit locks etc while row reads
			connection.setTransactionIsolation(Connection.TRANSACTION_READ_COMMITTED); //
			return connection;
		} catch (SQLException e) {
			throw new Exception("DriverManager.getConnection() : SQLException:"+e.getMessage());
		}
	}
	
	
	
	public static String getStackTraceAsString(Throwable e) {

		StringWriter sw = new StringWriter();
		PrintWriter pw = new PrintWriter(sw);
		e.printStackTrace(pw);
		return sw.toString().replace("\n", " ** ");
	}
	
	
}