package com.sellerportal.integra.impl.octashop.utils;

import it.sauronsoftware.ftp4j.FTPClient;

import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Vector;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.faces.context.FacesContext;
import javax.imageio.ImageIO;
import javax.imageio.ImageReader;
import javax.imageio.stream.ImageInputStream;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import javax.servlet.http.HttpServletResponse;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.myfaces.custom.fileupload.UploadedFile;

import com.anm.hibernate.HibernateConnection;
import com.sellerportal.ism.ApplicationConstant;
import com.sellerportal.ism.Configuration;
import com.sellerportal.dao.OctParamDAO;
import com.sellerportal.ism.integration.tasks.utils.FTPUtils;
import com.sellerportal.ism.integration.tasks.utils.FileUtility;
import com.sellerportal.ism.utils.ANMTimeZone;
import com.sellerportal.ism.utils.CommonUtils;
import com.sellerportal.ism.utils.EncryptDecrypt;
import com.sellerportal.ism.utils.Utility;
import com.anm.jsf.utils.FacesUtils;
import com.sellerportal.mail.AbstractMailApi;
import com.sellerportal.tisl.oms.forward.bean.O2SAndO2DDisplayBean;
import com.sellerportal.tisl.oms.utils.OmsStatusMasterInterface;
import com.anm.utils.IsmSerializer;
import com.google.gson.Gson;
import com.itextpdf.text.Document;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.RectangleReadOnly;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfImportedPage;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfWriter;

@SuppressWarnings("squid:S2885")
public class OctashopUtils implements ApplicationConstant{
	private static final Log LOGGER = LogFactory.getLog(OctashopUtils.class);
	public static final String PARAM_USER_TYPE = "ut"; 
	public static final String PARAM_FILE_DOWNLOAD = "/faces/filedownload/?pr=";
	public static final String PARAM_SEPERATOR = "&";
	public static final String ASSIGN_OPERATOR = "=";
	public static final Rectangle ThermalSize = new RectangleReadOnly(220.0F, 1400.0F);//Shankar : TQTM-1281
	public static final Rectangle DiscreetlSize = new RectangleReadOnly(842.0F,595.0F);
	public static final Rectangle A4 = new RectangleReadOnly(595.0F, 842.0F);
	public static final Rectangle A6 = new RectangleReadOnly(297.0F, 420.0F);
	//public static final Rectangle ThermalSize = new RectangleReadOnly(595.0F, 856.0F);
	public static final String OLD_INPUT_FILE_EXPRESSION = "\\$\\{oldfile\\}";
	public static final String OUTPUT_FILE_EXPRESSION = "\\$\\{output\\}";
	public static final String INPUT_FILE_EXPRESSION = "\\$\\{input\\}";
	public static final String DOT = ".";
	public static final String CSV = "csv";
	//public static final String NO_OF_HEADER_IN_INPUT_FILE = "4";
	public static final String NO_OF_HEADER_EXPRESSION = "\\$\\{no_of_header\\}";
	public static final String ESCAPE_HEADER_EXPRESSION = "\\$\\{escape_header\\}";

	//static final SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd-hh:mm:ss");
	public static final SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy-HH:mm:ss");
	public static final SimpleDateFormat dateformat = new SimpleDateFormat("dd-MM-yyyy");
	public static final SimpleDateFormat sdfFileName = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	public static final SimpleDateFormat sdfFile = new SimpleDateFormat("yyyy-MM-dd HH:mm:SS");
	public static final SimpleDateFormat counterFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
//	public static final String essentialCatCode = new Configuration().getEssentialCatCode();
	public static List<String> essentialList = null; 
	public static final SimpleDateFormat sdfFileddMMYYYY = new SimpleDateFormat("dd/MM/yyyy");
	private OctashopUtils(){

	}

	/**
	 * @author pramod
	 * @param jsCode
	 */
	public static void javascriptEngine(String jsCode){
		ScriptEngineManager scriptEngineManager = new ScriptEngineManager(); 
		ScriptEngine nashorn = scriptEngineManager.getEngineByName("nashorn"); 
		String name = "Mahesh";
		try {
			nashorn.eval("print('" + name + "')");
			nashorn.eval("10 + 2");   
		}catch(ScriptException e){
			LOGGER.error("Error executing script: "+ e.getMessage());
		}

	} 

	public static boolean isEmpty(String param) {
		if (param == null || param.trim().isEmpty() || "null".equals(param.trim()) || param.trim().equals("") ){
			return true;
		}else{
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

	/**
	 * Function to validate date
	 * @param sDate
	 * @param eDate
	 * @return
	 * @throws PricerException
	 */
	public static boolean isValidDate(Date sDate, Date eDate) {
		boolean ret = false;
		try {
			Date cDate = ANMTimeZone.getDateInTimeZone();
			if ((sDate.getTime() <= cDate.getTime())
					&& (cDate.getTime() <= eDate.getTime()))
				ret = true;
		} catch (Exception e) {
			LOGGER.error("Invalid Date",e);
		}
		return ret;
	}
	/**
	 * Function to validate time
	 * @param timeToValidate
	 * @param startTime
	 * @param endTime
	 * @return
	 * @throws ParseException
	 */
	public static boolean isValidTime(Date startTime, Date endTime) {
		boolean isValid = false;
		Date currentDate = ANMTimeZone.getDateInTimeZone();
		try {
			Long secondsCurr = getSecondsInGivenTime(currentDate);
			Long secondsStr = getSecondsInGivenTime(startTime);
			Long secondsEnd = getSecondsInGivenTime(endTime);
			if (secondsCurr.longValue() >= secondsStr.longValue()
					&& secondsCurr.longValue() <= secondsEnd.longValue()) {
				isValid = true;
			}
		} catch (ParseException e) {
			LOGGER.info("Some error in parsing" + e.getMessage());
			LOGGER.info(e);
		}
		return isValid;
	}
	/**
	 * Function to get seconds in give time
	 * @param time
	 * @return
	 * @throws ParseException
	 */
	public static Long getSecondsInGivenTime(Date time) throws ParseException {
		Long ret = null;
		FacesUtils facesUtils = new FacesUtils();
		String hours = facesUtils.formateDate(time, "HH");
		String minuts = facesUtils.formateDate(time, "mm");
		String seconds = facesUtils.formateDate(time, "ss");
		Long hh = new Long(hours);
		Long mm = new Long(minuts);
		Long ss = new Long(seconds);
		ret = new Long((hh.longValue() * 60 * 60) + (mm.longValue() * 60)
				+ ss.longValue());
		return ret;
	}

	public static boolean isListEmpty(List<?> list) {
		if (list == null || list.isEmpty() || list.size() == 0 ){
			return true;
		}
		else{
			return false;	
		}
	}

	public static String toCsv(Object [] ar,String sep)
	{
		if(sep == null)
			sep = ",";
		StringBuffer buffer = new StringBuffer();
		if(ar != null && ar.length > 0)
		{
			int k=0;
			for (int i = 0; i < ar.length; i++) {
				if(ar[i] != null)
				{
					if(k!=0)
						buffer.append(sep);
					buffer.append(ar[i]+"");
					k++;
				}
			}
		}
		return buffer.toString();

	}

	public static String toCsv(Collection<String> csvList,String sep)
	{
		if(csvList != null && csvList.size() > 0)
		{
			String [] v = new String[csvList.size()];
			v = csvList.toArray(v);
			return toCsv(v,",");
		}
		return "";
	}

	public static String [] csvToArray(String csvString,String delim)
	{
		return csvString.split("\\"+delim);
	}

	public static String formatName(String name, int limit){
		if(!OctashopUtils.isEmpty(name) && limit > 0){
			name = name.trim();
			if(name.length() > limit){
				name = name.substring(0,limit);
				if(name.indexOf(" ") != -1){
					name = name.substring(0,name.indexOf(" "));
				}
				else{
					name = name + "..";
				}
			}
		}
		return name;
	}

	/**
	 * 
	 * @param inDate input date which we want to validate
	 * @param inDateFormat If it is null or blank then it will take default format dd/MM/yyyy
	 * @return true if inDate follows date format specified, else false
	 */
	public static boolean isValidDateFormat(String inDate, String inDateFormat) {
		if (inDate == null)
			return false;

		if(inDateFormat == null || inDateFormat.equals(""))
			inDateFormat = "dd/MM/yyyy";

		SimpleDateFormat dateFormat = new SimpleDateFormat(inDateFormat);
		if (inDate.trim().length() != dateFormat.toPattern().length())
			return false;

		dateFormat.setLenient(false);
		try {
			dateFormat.parse(inDate.trim());
		}
		catch (ParseException pe) {
			return false;
		}
		return true;
	}

	/**
	 * Created int nthOccurrence to find nth index of String
	 * @param str
	 * @param c
	 * @param n
	 * @return
	 */
	public static int nthOccurrence(String str, char c, int n) {
		int pos = str.indexOf(c, 0);
		while (n-- > 0 && pos != -1)
			pos = str.indexOf(c, pos + 1);
		return pos;
	}


	/**
	 * Compute the hash value to check for "real person" submission.
	 * 
	 * @param  value  the entered value
	 * @return  its hash value
	 */

	/**
	 * Created String rpHash
	 * @param value
	 * @return
	 */
	public static String rpHash(String value) {
		int hash = 5381; 
		value = value.toUpperCase();
		for(int i = 0; i < value.length(); i++) {
			hash = ((hash << 5) + hash) + value.charAt(i);
		}
		return String.valueOf(hash);
	}

	public static long getTwoDateDifferences(Date firstDate, Date secondDate){
		long mills1=firstDate.getTime();
		long mills2=secondDate.getTime();
		long difference=mills2-mills1;
		long days = difference/ (24 * 60 * 60 * 1000);

		return days;
	}

	public static boolean dateComparsion(Date firstDate, Date secondDate){

		return firstDate.equals(secondDate);
	}

	/**********
	 * 	HibernateConnection.getSession().clear(); 		:		Commented this statement it was giving problem while adding,editing any data...
	 * **********************/
	public static String getFormattedNameForImage(String imageName,String referenceNumber,String imageType,String imageDimension,String viewSequence){
		return null;
	}

	/*public static Map sortByValue(Map map,String order) {
	     List list = new LinkedList(map.entrySet());
	     Collections.sort(list, new Comparator() {
	          public int compare(Object o1, Object o2) {
	               return ((Comparable) ((Map.Entry) (o1)).getValue())
	              .compareTo(((Map.Entry) (o2)).getValue());
	          }
	     });

	     if("desc".equalsIgnoreCase(order))
	     {
	     Collections.reverse(list);
	     }

	    Map result = new LinkedHashMap();
	    for (Iterator it = list.iterator(); it.hasNext();) {
	        Map.Entry entry = (Map.Entry)it.next();
	        result.put(entry.getKey(), entry.getValue());
	    }
	    return result;
	}*/ 

	public static boolean ValidationEmail(String email){

		Pattern p=Pattern.compile("[a-zA-Z]+[0-9]*[\\.a-zA-Z]+[0-9]*@[a-zA-Z]*\\.[a-zA-Z]*"); 
		Matcher m=p.matcher(email);
		boolean b=m.matches();
		if(b==true){
			return true;
		}else{
			return false;
		}
	}

	public static boolean isNumeric(String str){
		try{
			Double.parseDouble(str);  
		}catch(NumberFormatException nfe){  
			return false;  
		}
		return true;  
	}


	public static String convertIntoInitCap(String text){
		try{
			if(!isEmpty(text)){
				StringBuilder stringBuilder = new StringBuilder();			
				for(String f: text.split(" ")){
					f = f.trim();
					if (f.length() > 0) {
					if(stringBuilder.length()>0){
						stringBuilder.append(" ");
					}
					stringBuilder.append(f.substring(0,1).toUpperCase()).append(f.substring(1,f.length()).toLowerCase());
					}
				}
				if(stringBuilder.length()>0){
					text=stringBuilder.toString();
					LOGGER.info(text);

				}
			}
		}catch(Exception e){
			LOGGER.info(e);
		}
		return text;
	}

	public static String getUploadedImageDimension(UploadedFile uploadedImage){
		ImageInputStream in=null;
		String imgDimension="";
		try {
			in = ImageIO.createImageInputStream(uploadedImage.getInputStream());
			final Iterator<?> readers = ImageIO.getImageReaders(in);
			if (readers.hasNext()) {
				ImageReader reader = (ImageReader) readers.next();
				try {
					reader.setInput(in);
					imgDimension=reader.getWidth(0)+"X"+reader.getHeight(0);

				} catch(Exception e){}
			}
		}catch(Exception e){
			OctashopUtils.printExceptionMsgNCause(LOGGER, e);
		} 
		finally {
			try{
				if (in != null) in.close();
			}catch(Exception e){
				OctashopUtils.printExceptionMsgNCause(LOGGER, e);
			}
		}
		return imgDimension;
	}

	public static String charsToRemove(String str){
		try{
			String charsToRemove = "[%^#!'$:@*`~&?;]";
			str = str.replaceAll(charsToRemove, "");
		}catch(Exception e){LOGGER.info("Errror in removing not required cahrs"+e.getMessage());}
		return str;
	}

	public static boolean isSetEmpty(Set<?> set) {
		if (set == null || set.isEmpty() || set.size() == 0 ){
			return true;
		}
		else{
			return false;	
		}
	}

	/**
	 * For validation of emailId with special scenerio 
	 * Like emailId which start with hr,admin,info,support,sales,sale and asd111 is not allowed
	 * @param emilId	 
	 */
	public static boolean isValidEmailId(String emilId){
		boolean status=false;				
		Pattern emailPattern=Pattern.compile("^[a-zA-Z0-9._%-+]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,4}$");
		try{
			if(isEmpty(emilId)){
				status=true;
			}else{
				Matcher emilMatcher=emailPattern.matcher(emilId);
				if(!emilMatcher.matches()){
					status=true;
				}

				int charInEmaiString=(int)emilId.charAt(0);
				if(!((charInEmaiString>=48 && charInEmaiString<=57) || 
						(charInEmaiString>=65 && charInEmaiString<=90) || 
						(charInEmaiString>=97 && charInEmaiString<=122))){
					status=true;          
				}

				if(emilId.indexOf('@')>0){/*
					String tempEmail=emilId.substring(0, emilId.indexOf('@'));
					Map hashMap=new HashMap();
					hashMap=new IsmmftDAO().getAllRecord();
					boolean  matchTodefine=hashMap.containsKey(tempEmail.toLowerCase());
					if(matchTodefine){								
						status=true;
					}
				 */}
			}
		}catch(Exception e){
			LOGGER.info(e);
		}
		return status;
	}

	public static final BigDecimal ONEHUNDERT = new BigDecimal(100);
	public static BigDecimal percentage(BigDecimal base, BigDecimal pct){
		return base.multiply(pct).divide(ONEHUNDERT);
	}

	public static String formatInString(BigDecimal bigDecimal) {
		return bigDecimal.round(new MathContext(bigDecimal.toBigInteger().toString().length(),RoundingMode.HALF_UP))+"";
	}

	public static boolean renameFile(String filePath,String suffix){
		boolean isRenamed = false;
		String newFilePath = "";
		try { 
			if(isFileExist(filePath)){
				if(isEmpty(suffix)){
					String currentTimeStamp = FTPUtils.getCurrentTimestamp();
					newFilePath = filePath+"_"+currentTimeStamp;
				}else{
					newFilePath = filePath+"_"+suffix;
				}
				File oldFile = new File(filePath);
				File newFile = new File(newFilePath);
				if(oldFile.renameTo(newFile)){
					isRenamed = true;
				}
			}
		} catch (Exception e) {

			LOGGER.info(e);
		}
		return isRenamed;
	}

	public static String getEncryptedData(String plainText) {
		String encData = null;
		EncryptDecrypt encDec = new EncryptDecrypt();
		try {
			encData = encDec.encrypt(plainText);
		} catch (Exception e) {

			LOGGER.info(e);
		}
		return encData;
	}

	public static String getEncryptedEncodedURLParam(String plainText) {
		String encData = null;
		EncryptDecrypt encDec = new EncryptDecrypt();
		try {
			encData = encDec.encrypt(plainText);
			encData = URLEncoder.encode(encData, "UTF-8");  //commented to resolve multiples of 8 decrypt issue
		} catch (Exception e) {

			LOGGER.info(e);
		}
		return encData;
	}

	public static String getDecodedDecreptedURLParam(String encriptedData) {
		String decryptData = null;
		EncryptDecrypt decrypt = new EncryptDecrypt();
		try {
			//encriptedData = URLDecoder.decode(encriptedData, "UTF-8");
			decryptData = decrypt.decrypt(encriptedData);
		} catch (Exception e) {

			LOGGER.info(e);
		}
		return decryptData;
	}
	/**
	 * @author pramod
	 * @param encriptedData
	 * @return
	 */
	public static String getDecreptedData(String encriptedData) {
		String decryptData = null;
		EncryptDecrypt decrypt = new EncryptDecrypt();
		try {
			if(!OctashopUtils.isEmpty(encriptedData)){
				decryptData = decrypt.decrypt(encriptedData);
			}
		} catch (Exception e) {

			LOGGER.info(e);
		}
		return decryptData;
	}

	public static String serializeObject(Object obj) {
		String serializeStr = null;
		IsmSerializer serializer = new IsmSerializer();
		try {
			Gson gson = new Gson();
			String json = gson.toJson(obj);

			serializeStr = serializer.encode64(json);
		} catch (Exception e) {

		}
		return serializeStr;
	}

	
	/**
	 * @author pramod
	 * @param urlParam
	 * @return
	 * @throws UnsupportedEncodingException
	 */
	public static Map<String, String> splitQueryParam(String urlParam) throws UnsupportedEncodingException {
		Map<String, String> query_pairs = new LinkedHashMap<String, String>();
		String[] pairs = urlParam.split(PARAM_SEPERATOR);
		for (String pair : pairs) {
			int idx = pair.indexOf(ASSIGN_OPERATOR);
			query_pairs.put(URLDecoder.decode(pair.substring(0, idx), "UTF-8"), URLDecoder.decode(pair.substring(idx + 1), "UTF-8"));
		}
		return query_pairs;
	}
	/**
	 * @author pramod
	 * @param map
	 * @return
	 */
	public static String urlEncodeUTF8(Map<String,String> map) {
		StringBuilder sb = new StringBuilder();
		try {
			for(Map.Entry<String, String> e : map.entrySet()){
				if(sb.length() > 0){
					sb.append(PARAM_SEPERATOR);
				}
				if(e.getValue() != null){
					sb.append(URLEncoder.encode(e.getKey(), "UTF-8")).append('=').append(URLEncoder.encode(e.getValue(), "UTF-8"));
					//sb.append(e.getKey()).append('=').append(e.getValue());
				}
			}
		} catch (Exception e) {

			LOGGER.info(e);
		}
		return sb.toString();       
	}

	/**
	 * @author pramod
	 * @param filePath
	 * @param suffix
	 * @return
	 */
	public static String renameFileTo(String filePath,String suffix){
		String newFilePath = "";
		try { 
			if(isEmpty(suffix)){
				Date currentDate = ANMTimeZone.getDateInTimeZone();
				newFilePath = filePath+"_"+currentDate;
			}else{
				newFilePath = filePath+"_"+suffix;
			}
			File oldFile = new File(filePath);
			File newFile = new File(newFilePath);
			if(oldFile.renameTo(newFile)){
				newFilePath = newFile.getName();
			}
		} catch (Exception e) {
			LOGGER.info(e);
		}
		return newFilePath;
	}

	public static void printExceptionMsgNCause(Log LOGGER, Exception e) {
		try {
			StackTraceElement trace = e.getStackTrace()[0];
			LOGGER.info("ClassName : "+trace.getClassName()+" MethodName : "+trace.getMethodName()+" LineNumber : " +trace.getLineNumber()+" "+trace.getFileName()+" Message :: "+e.toString() +" Cause :: "+e.getCause());	
		} catch (Exception e2) {
			LOGGER.error(e.getStackTrace());
		}
	}


	public static String getDecodedDecreptedURLParamData(String encriptedData) {
		String decryptData = null;
		String encriptedDataOld=new String(encriptedData);
		EncryptDecrypt decrypt = new EncryptDecrypt();
		try {
			encriptedData = URLDecoder.decode(encriptedData, "UTF-8");
			decryptData = decrypt.decrypt(encriptedData);
		} catch (Exception e) {

			EncryptDecrypt decrypt2 = new EncryptDecrypt();
			decryptData = decrypt2.decrypt(encriptedDataOld);
			LOGGER.info("Message :: "+e.toString() +" Cause :: "+e.getCause());
		}
		return decryptData;
	}

	/**
	 * @author pramod
	 * @param throwable
	 * @return
	 */
	public static List<String> getExceptionMessageChain(Throwable throwable) {
		List<String> result = new ArrayList<String>();
		while (throwable != null) {
			result.add(throwable.getMessage());
			throwable = throwable.getCause();
		}
		return result; //["THIRD EXCEPTION", "SECOND EXCEPTION", "FIRST EXCEPTION"]
	}

	/**
	 * @author pramod
	 * @param localFilePath
	 * @param remoteFilePath
	 */
	public static void uploadFileToFtp(String localFilePath,String remoteFilePath) {
		FTPClient client;
		try {
			client = FTPUtils.getFTPClient();
			LOGGER.info("FTP is connected now");
		} catch (Exception e) {
			LOGGER.info("Exit : Error in FTP Connection <"+ e.getMessage() + ">");
			return;
		}
		try {
			if(!OctashopUtils.isEmpty(localFilePath) && !OctashopUtils.isEmpty(remoteFilePath)){
				String localFileName = localFilePath.substring(localFilePath.lastIndexOf('/') + 1);
				String remoteFileName = remoteFilePath.substring(remoteFilePath.lastIndexOf('/') + 1); 
				if(FTPUtils.isFileExist(client, remoteFilePath)){
					int j = remoteFilePath.lastIndexOf('/');
					String renamedRemoteFileName = remoteFilePath.substring(j + 1) + "_"+ FTPUtils.getCurrentTimestamp();
					String newRemoteFilePath = remoteFilePath.substring(0, j+1) + renamedRemoteFileName;
					client.rename(remoteFilePath, newRemoteFilePath);
				}
				String remoteFileDir = remoteFilePath.substring(0,remoteFilePath.lastIndexOf('/'));
				if(!FTPUtils.isFileExist(client, remoteFileDir)){
					FTPUtils.makeDirectories(client, remoteFileDir);	
				}
				FTPUtils.upload(client, localFilePath, localFilePath, remoteFileDir, FTPUtils.isShowProgressBar());
				if(!localFileName.equals(remoteFileName)){
					client.rename(remoteFileDir+"/"+localFileName, remoteFilePath);
				}
				LOGGER.info("Saving File to " + remoteFilePath);
			}
		} catch (Exception e1) {
			LOGGER.error(e1.getStackTrace());
			LOGGER.info("Failed to connect Ftp");
		}
		try {
			client.disconnect(true);
		} catch (Exception e) {
			LOGGER.info("Message :: "+e.toString() +" Cause :: "+e.getCause());
		}
	}

	/**
	 * @author pramod
	 * @param fileItem
	 * @param uploadPath
	 */
	public static void makeDirectories(String dir) {
		try {
			if(!FTPUtils.isFTPEnable()){
				File file = new File(dir);
				if(!file.exists()) {
					file.mkdirs();
				}
			}else{
				FTPUtils.makeDirectories(FTPUtils.getFTPClient(), dir);
			}
		} catch (Exception e) {

			LOGGER.info(e.toString());
		}
	}
	/**
	 * @author pramod
	 * @param fileItem
	 * @param uploadPath
	 */
	public static void writeFile(FileItem fileItem, String uploadPath) {
		try {
			if(!FTPUtils.isFTPEnable()){
				File file = new File(uploadPath.substring(0,uploadPath.lastIndexOf('/')));
				if(!file.exists()) {
					file.mkdirs();
				}
				OctashopUtils.renameFile(uploadPath, null);
				fileItem.write(new File(uploadPath));

			}else{
				String uploadFileName = uploadPath.substring(uploadPath.lastIndexOf('/') + 1);
				String localFilePath = FileUtils.getTempDirectoryPath()+"/"+uploadFileName;
				File currentFile = new File(localFilePath);
				if(currentFile.exists()) {
					String currentTimeStamp = FTPUtils.getCurrentTimestamp();
					localFilePath = localFilePath+"_"+currentTimeStamp;
				}
				fileItem.write(new File(localFilePath));
				uploadFileToFtp(localFilePath, uploadPath);
				FileUtility.deleteFile(localFilePath);
			}
		} catch (Exception e) {

		}
	}

	/**
	 * @author pramod
	 * @param filePath
	 * @return
	 */
	/*public static boolean isFileExist(String filePath){
		boolean isExist = false;
		try {
			if(!FTPUtils.isFTPEnable()){
				File file = new File(filePath);
				if(file.exists() && !file.isDirectory()) { 
					isExist = true;
				}
			}else{
				return FTPUtils.isFileExist(FTPUtils.getFTPClient(), filePath);
			}
		} catch (Exception e) {

			LOGGER.info(e);
		}
		return isExist;
	}*/

	public static boolean isFileExist(String filePath){
		boolean isExist = false;
		try {
			File file = new File(filePath);
			if(file.exists() && !file.isDirectory()) { 
				isExist = true;
			}
		} catch (Exception e) {

			LOGGER.error("EXCEPTION IN IS_FILE_EXIST_CHECK :: "+e.toString());
		}
		return isExist;
	}

	/**
	 * @author pramod
	 * @param fileItem
	 * @param uploadPath
	 */
	public static void copyFile(String srcPath, String destPath) throws Exception{
		try {
			if(!FTPUtils.isFTPEnable()){
				File destinationFile = new File(destPath);
				File sourceFile = new File(srcPath);
				if(!OctashopUtils.isFileExist(destPath)){
					OctashopUtils.makeDirectories(destPath);	
				}
				org.apache.commons.io.FileUtils.copyFile(sourceFile, destinationFile);
			}else{
				//Copy File on static server from one location to another via FTP
				FTPClient ftpClient = FTPUtils.getFTPClient();
				String localFilePath = FileUtils.getTempDirectoryPath()+"/"+ srcPath.substring(srcPath.lastIndexOf('/') + 1);
				File currentFile = new File(localFilePath);
				if(currentFile.exists()) {
					String currentTimeStamp = FTPUtils.getCurrentTimestamp();
					localFilePath = localFilePath+"_"+currentTimeStamp;
				}
				File localFile = new File(localFilePath);
				ftpClient.download(srcPath, localFile);
				uploadFileToFtp(localFilePath, destPath);
				FileUtility.deleteFile(localFilePath);
			}
		} catch (Exception e) {

			throw e;
		}
	}

	public static boolean isValidStartEndDates(Date sDate, Date eDate) {
		boolean ret = false;
		try {
			Date cDate = ANMTimeZone.getDateInTimeZone();
			if ((sDate.getTime() <= cDate.getTime())
					&& (sDate.getTime() <= eDate.getTime()))
				ret = true;
		} catch (Exception e) {
			LOGGER.error("Invalid Date",e);
		}
		return ret;
	}

	private static final SimpleDateFormat FORMATTER = new SimpleDateFormat(
			"yyyyMMddHHmmss");

	public static String getCurrentTimestamp() {
		return FORMATTER.format(ANMTimeZone.getDateInTimeZone());
	}

	public static void sendMailWithAttachment(String to,String requestFilePath,String responseFilePath,String content,String subject) throws Exception{	

		final Configuration conf = new Configuration();
		String[] summaryDesc=new String[2];      
		String[] summaryArray = new String[2];	              

		String smtpIP = conf.getMailServerIP();
		String emailFrom = conf.getFromAddress();

		File requestFile = new File(requestFilePath);
		File responseFile = new File(responseFilePath);

		if(requestFile!=null && requestFile.exists()){
			summaryArray[0]=requestFile.getAbsolutePath();
			summaryDesc[0]=requestFile.getName();
		}
		if(responseFile!=null && responseFile.exists()){
			summaryArray[1]=responseFile.getAbsolutePath();
			summaryDesc[1]=responseFile.getName();
		}

		try {
			CommonUtils.sendEmailWithAttachment(smtpIP, emailFrom, to, subject, content, summaryArray, summaryDesc);
		}catch (Exception e) {
			LOGGER.error(e.getStackTrace());
		}    
	}

	public static Double roundUp(Double num) {
		Double roundUpnum = new Double("0.0");
		try {
			if(num != null){
				roundUpnum = Math.round(num*100)/100.0;	
			}
		} catch (Exception e) {

		}
		return roundUpnum;
	}

	public static String printBulkUploadTimeEstimation(long startTIme,long endTime,int countDone,int totalCount){
		String estMsg = "";
		try {
			long processingtime = endTime - startTIme;
			long singleProcessTime = processingtime/countDone;
			long totalEstimatedSec = (singleProcessTime/1000)*(long)(totalCount-countDone);
			long totalEstimatedMin = 0L,totalEstimatedHr = 0L;

			if(totalEstimatedSec > 60){
				totalEstimatedMin = totalEstimatedSec/60;
				totalEstimatedSec = totalEstimatedSec%60;
			}
			if(totalEstimatedMin > 60){
				totalEstimatedHr = totalEstimatedMin/60;
				totalEstimatedMin = totalEstimatedMin%60; 
			}
			estMsg = " Batch Job Estimated Completion time : HH:MM:SS -> "+(totalEstimatedHr < 10?"0"+totalEstimatedHr:totalEstimatedHr)+":"+(totalEstimatedMin<10?"0"+totalEstimatedMin:totalEstimatedMin)+":"+totalEstimatedSec;
		} catch (Exception e) {

		}
		return estMsg;
	}

	public static List<String> wordWrap(String sentence, int maxLengthInSingleLine){
		List<String> matchList = new ArrayList<String>();
		try {
			Pattern regex = Pattern.compile("(.{1,"+maxLengthInSingleLine+"}(?:\\s|$))|(.{0,"+maxLengthInSingleLine+"})", Pattern.DOTALL);
			Matcher regexMatcher = regex.matcher(sentence);
			while (regexMatcher.find()) {
				matchList.add(regexMatcher.group());
			}
		} catch (Exception e) {
			LOGGER.error(e.getStackTrace());
		}
		return matchList;
	}

	public static String mailTextForConfigModificationAlert(String configName,String modifiedConfigInfo,String modifedBy,String other_Details){
		StringBuffer buffer = new StringBuffer();
		try {
			buffer.append("<div style='border:0px solid #000;border-collapse:collapse;font-family:Tahoma, Geneva, sans-serif;font-size: 13px;color:#3d3d3d;'>");
			buffer.append("<p>Dear <b>Dear MarketPlace Admin,</b></p>");
			buffer.append("<p>Modified Configuration Name :"+configName+"</p>");
			buffer.append("<b>Config Modified Desc : "+modifiedConfigInfo+"</b>");
			buffer.append("<p>Modified By : "+modifedBy+" </p>");
			buffer.append("<p>More Info : "+other_Details+" </p>");
			buffer.append("<br/><br/>");
			buffer.append("</div> ");	
		} catch (Exception e) {

		}
		return buffer.toString();
	}
	//@Avinash R2 Merged for date formate
	public static String convertDate(String strDate,String fromFmt,String toFmt){
		String formattedDate="";
		try{
			SimpleDateFormat dateFormat = new SimpleDateFormat(fromFmt);
			Date date=dateFormat.parse(strDate);

			SimpleDateFormat formatter = new SimpleDateFormat(toFmt);
			formattedDate = formatter.format(date);
		}catch(Exception e){
			StackTraceElement ste = e.getStackTrace()[0];
			LOGGER.error("Message :: "+e.toString() +" Cause :: "+e.getCause()+" Detail ::"+ste.getClassName()+">"+ste.getMethodName()+">"+ste.getLineNumber());
		}

		return formattedDate;

	}

	public static boolean isNumber(String str){
		if (str == null) {
			return false;
		}
		int sz = str.length();
		for (int i = 0; i < sz; i++) {
			if ((Character.isDigit(str.charAt(i)) == false) && (str.charAt(i) != '.')) {
				return false;
			}
		}
		return true;
	}

	public static void keepBusy(String str) {
		try {
			FacesContext facesContext = FacesContext.getCurrentInstance();
			if(facesContext !=  null){
				HttpServletResponse response = (HttpServletResponse) facesContext.getExternalContext().getResponse();
				response.getOutputStream().print(str);
				response.getOutputStream().flush();	
			}else{
				LOGGER.info(" keepBusy : Failed as FacesContext NULL");
			}
		}catch(Exception e) {
			LOGGER.error(" ! keepBusy : Failed "+e.getMessage(),e);
		}

	}

	public static List<String> wordWrapFixedLength(String userType, String sentence, String userCode){
		int maxLengthInSingleLine = 0;
		if(!isEmpty(userType)) {
			if("SLR".equals(userType)) {
				maxLengthInSingleLine = 23;
			} else if("SLV".equals(userType) && !isEmpty(userCode)) {
				int totalLength = userCode.length() + 6;
				maxLengthInSingleLine = 40 - totalLength;
			}
		} else {
			maxLengthInSingleLine = 23;
		}
		List<String> matchList = new ArrayList<String>();
		try {
			Pattern regex = Pattern.compile("(.{1,"+maxLengthInSingleLine+"}(?:\\s|$))|(.{0,"+maxLengthInSingleLine+"})", Pattern.DOTALL);
			Matcher regexMatcher = regex.matcher(sentence);
			while (regexMatcher.find()) {
				matchList.add(regexMatcher.group()+"...");
			}
		} catch (Exception e) {
			LOGGER.error(e.getStackTrace());
		}
		return matchList;
	}
	public static String ExponToNumber(float shipmentWght){
		DecimalFormat formatter = new DecimalFormat("#.#######");
		return formatter .format(shipmentWght);	
	}

	public static String getModifiedEndDay(String endDate) {
		String modifiedDate = endDate.concat(" "+ "23:59:59").toString();
		return modifiedDate;
	}
	public static String isValidGSTRegistrationNumber(String GSTRegno,String statcode,String slrpan){
		String response = "";
		try{
			String gststatecode = GSTRegno.substring(0, 2);
			String gstslrpan = GSTRegno.substring(2, 12);
			String gstother = GSTRegno.substring(12,GSTRegno.length());

			LOGGER.info("gststatecode: " + gststatecode + ",gstslrpan: " + gstslrpan + ",gstother: " + gstother);
			
			List<String> gstStateLst = new ArrayList<>();

			if("28".equals(statcode) || "37".equals(statcode)){
				gstStateLst.add("28");
				gstStateLst.add("37");
			}else{
				gstStateLst.add(statcode);
			}

			if(!gstStateLst.contains(gststatecode)){
				response =  "Not valid GST Registration Number state code Invalid.";
				return response;
			}
			if(!slrpan.equals(gstslrpan)){
				response =  "Not valid GST Registration Number Pan No Invalid.";
				return response;
			}
			if(!gstother.matches("^[a-zA-Z0-9]*$")){
				response =  "Not valid GST Registration Number Special Characters not allowed";
				return response;
			}
		}catch(Exception e){
			OctashopUtils.printExceptionMsgNCause(LOGGER, e);
		}
		return response;
	}

	public static final SimpleDateFormat folderDateFORMATTER = new SimpleDateFormat("yyyy/MM/dd");

	public static double roundOfTwoDecimal(double d , int places) {
		if(places < 0) throw new IllegalArgumentException();

		BigDecimal bd = BigDecimal.valueOf(d);
		bd = bd.setScale(places, BigDecimal.ROUND_HALF_UP);
		return bd.doubleValue();
	}
	public static String roundOfTwoDecimal(String d , int places) {
		if(places < 0) throw new IllegalArgumentException();

		BigDecimal bd = new BigDecimal(d);
		bd = bd.setScale(places, BigDecimal.ROUND_HALF_UP);
		return bd.toString();
	}
	public static float roundOfTwoDecimal(float d , int places) {
		if(places < 0) throw new IllegalArgumentException();

		BigDecimal bd = BigDecimal.valueOf(d);
		bd = bd.setScale(places, BigDecimal.ROUND_HALF_UP);
		return bd.floatValue();
	}

	public static void concatPDFs(List<String> streamOfPDFFiles,OutputStream outputStream, boolean paginate,String mergefilename) {
		Document document =null;

		try {
			List<String> pdfs = streamOfPDFFiles;
			List<PdfReader> readers = new ArrayList<PdfReader>();
			Iterator<String> iteratorPDFs = pdfs.iterator();
			File file = null;
			InputStream pdf =null;
			while (iteratorPDFs.hasNext()) {
				try{
					file = new File(iteratorPDFs.next());

					if(file!=null && file.isFile()){
						pdf = new FileInputStream(file);
						PdfReader pdfReader = new PdfReader(pdf);				
						readers.add(pdfReader);
					}
				}catch(FileNotFoundException fe){
					LOGGER.error(fe.getStackTrace());
				}
				catch(IOException ie){
					LOGGER.error(ie.getStackTrace());
				}
				finally{
					if(pdf!=null){
						pdf.close();
					}
				}
			}

			document = new Document(); 

			// Create a writer for the outputstream
			PdfWriter writer = PdfWriter.getInstance(document, outputStream);
			document.open();

			// Holds the PDF data
			PdfContentByte cb = writer.getDirectContent();

			PdfImportedPage page;
			int pageOfCurrentReaderPDF = 0;
			Iterator<PdfReader> iteratorPDFReader = readers.iterator();

			// Loop through the PDF files and add to the output.
			while (iteratorPDFReader.hasNext()) {
				PdfReader pdfReader = iteratorPDFReader.next();

				//@Deepak Deshekar ::Set Page Size Dynamically  Start
				com.itextpdf.text.Rectangle mediabox = pdfReader.getPageSize(1);
				if(mediabox.getRight() > 220 && mediabox.getRight()<=297) {
					document.setPageSize(A6);
				}else if(mediabox.getRight()<595){
					document.setPageSize(ThermalSize);
				}else if(mediabox.getRight()>600){
					document.setPageSize(DiscreetlSize);
				}else{
					document.setPageSize(A4);
				}
				//@Deepak Deshekar ::Set Page Size Dynamically  Start
				// Create a new page in the target for each source page.
				while (pageOfCurrentReaderPDF < pdfReader.getNumberOfPages()) {
					document.newPage();
					pageOfCurrentReaderPDF++;
					page = writer.getImportedPage(pdfReader,pageOfCurrentReaderPDF);
					cb.addTemplate(page, 0,0); 
				}
				pageOfCurrentReaderPDF = 0;
			}

			outputStream.flush();
			document.close();
			outputStream.close();
		}

		catch (Exception e) {
			LOGGER.error("Exception : " + e.getMessage());
		}

		finally {

			if (document!=null && document.isOpen())
				document.close();

			try {
				if (outputStream != null)
					outputStream.close();

			} catch (IOException ioe) {
				LOGGER.error("Exception : " + ioe.getMessage());
			}
		}
	}


	public static String getFilename(int size) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:SS");
		Date currDate = new Date();
		String date[] = sdf.format(currDate).toString().split(":");
		String date1[] = date[0].split(" ");
		String filename = "O2S-O2D-Report-" + size + "-" + date1[0] + "-" + date1[1] + "-" + date[1] + "-" + date[2] + ".xlsx";
		return filename;
	}

	public static Map<String,List<O2SAndO2DDisplayBean>> getO2SAndO2DReportMap(List<Object[]> list, Map<String,List<O2SAndO2DDisplayBean>> map, String reportType) {
		try {
			for(int i=0; i<list.size(); i++) {
				Object[] obj = (Object[])list.get(i);
				String sellerName,slaveName,deliveryMode,totalTx,typeTotalTx,type0Day,type1Days,type2Days,type3Days,typeG3Days;
				sellerName=slaveName=deliveryMode=totalTx=typeTotalTx=null;
				type0Day=type1Days=type2Days=type3Days=typeG3Days="0%";

				if(!OctashopUtils.isEmpty(obj[0]+"") && !OctashopUtils.isEmpty(obj[1]+"")) {
					sellerName = obj[0]+"("+obj[1]+")";
				}

				if(!OctashopUtils.isEmpty(obj[2]+"") && !OctashopUtils.isEmpty(obj[3]+"")) {
					slaveName = obj[2]+"("+obj[3]+")";
				}

				if(!OctashopUtils.isEmpty(obj[4]+"")) {
					deliveryMode = obj[4]+"";
				}

				if(!OctashopUtils.isEmpty(obj[5]+"")) {
					typeTotalTx = obj[5]+"";
				}

				if(!OctashopUtils.isEmpty(typeTotalTx)) {
					if(!OctashopUtils.isEmpty(obj[6]+"")) {						
						type0Day = getPercentageO2SAndO2DReport(Double.parseDouble(typeTotalTx), Double.parseDouble(obj[6]+""));
					}

					if(!OctashopUtils.isEmpty(obj[7]+"")) {
						type1Days = getPercentageO2SAndO2DReport(Double.parseDouble(typeTotalTx), Double.parseDouble(obj[7]+""));
					}

					if(!OctashopUtils.isEmpty(obj[8]+"")) {
						type2Days = getPercentageO2SAndO2DReport(Double.parseDouble(typeTotalTx), Double.parseDouble(obj[8]+""));
					}

					if(!OctashopUtils.isEmpty(obj[9]+"")) {
						type3Days = getPercentageO2SAndO2DReport(Double.parseDouble(typeTotalTx), Double.parseDouble(obj[9]+""));
					}

					if(!OctashopUtils.isEmpty(obj[10]+"")) {
						typeG3Days = getPercentageO2SAndO2DReport(Double.parseDouble(typeTotalTx), Double.parseDouble(obj[10]+""));
					}
				}

				O2SAndO2DDisplayBean displayBean = null;

				List<O2SAndO2DDisplayBean> displayList = new ArrayList<O2SAndO2DDisplayBean>();
				String key = obj[3]+"_"+obj[4]+"";
				if(map.get(key) == null) {
					map.put(key, new ArrayList<O2SAndO2DDisplayBean>());
					displayBean = new O2SAndO2DDisplayBean();

					displayBean.setSellerName(sellerName);
					displayBean.setSlaveName(slaveName);
					displayBean.setDeliveryMode(deliveryMode);
					displayBean.setTotalTx(totalTx);

					if("O2S".equals(reportType)) {
						displayBean.setO2sTx(typeTotalTx);
						displayBean.setO2s0Day(type0Day);
						displayBean.setO2s1Days(type1Days);
						displayBean.setO2s2Days(type2Days);
						displayBean.setO2s3Days(type3Days);
						displayBean.setO2sG3Days(typeG3Days);
					} else if("O2D".equals(reportType)) {
						displayBean.setO2oOrders(typeTotalTx);
						displayBean.setO2d0Day(type0Day);
						displayBean.setO2d1Days(type1Days);
						displayBean.setO2d2Days(type2Days);
						displayBean.setO2d3Days(type3Days);
						displayBean.setO2dG3Days(typeG3Days);
					}
					displayList.add(displayBean);
				} else {
					displayBean = (O2SAndO2DDisplayBean)map.get(key).get(0);
					if("O2S".equals(reportType)) {
						displayBean.setO2oOrders(typeTotalTx);
						displayBean.setO2s0Day(type0Day);
						displayBean.setO2s1Days(type1Days);
						displayBean.setO2s2Days(type2Days);
						displayBean.setO2s3Days(type3Days);
						displayBean.setO2sG3Days(typeG3Days);
					} else if("O2D".equals(reportType)) {
						displayBean.setO2oOrders(typeTotalTx);
						displayBean.setO2d0Day(type0Day);
						displayBean.setO2d1Days(type1Days);
						displayBean.setO2d2Days(type2Days);
						displayBean.setO2d3Days(type3Days);
						displayBean.setO2dG3Days(typeG3Days);
					}
					displayList.add(displayBean);
				}
				map.put(key, displayList);
			}
		} catch(Exception e) {
			StackTraceElement ste = e.getStackTrace()[0];
			LOGGER.error("Message :: " + e.toString() + " Cause :: "+ e.getCause() + " Detail ::" + ste.getClassName() + ">"
					+ ste.getMethodName() + ">" + ste.getLineNumber());
		}
		return map;
	}

	public static String getPercentageO2SAndO2DReport(double totalTx, double typeDate) {
		String percentage = "0%";
		try {
			if(typeDate != 0) {
				double perc = typeDate*100/totalTx;
				DecimalFormat twoDForm = new DecimalFormat();
				twoDForm.setMaximumFractionDigits(2);
				percentage = twoDForm.format(perc)+"%";
			}
		} catch(Exception e) {
			StackTraceElement ste = e.getStackTrace()[0];
			LOGGER.error("Message :: " + e.toString() + " Cause :: "+ e.getCause() + " Detail ::" + ste.getClassName() + ">"
					+ ste.getMethodName() + ">" + ste.getLineNumber());
		}
		return percentage;
	}

	//@shreyas start :: [JIRA] SI-17+SI-18 >>Updated validation on Tax fields_REST Invoice API
	public static boolean isDecimalNumeric(String str){
		try{
			if(str.matches("^[-+]?\\d+(\\.\\d+)?$")){
				return true;
			}
		}
		catch(Exception e){

		}
		return false;
	}
	//@shreyas end :: [JIRA] SI-17+SI-18 >>Updated validation on Tax fields_REST Invoice API

	//@Manojv
	public static List<List> getListinChunk(List orgniallist,int chunkSize){
		List<List> lists = new ArrayList<>();
		for (int i=0; i<orgniallist.size(); i+= chunkSize) {
			int end = Math.min(orgniallist.size(), i + chunkSize);
			lists.add(orgniallist.subList(i, end));
		}
		return lists;
	}

	//@Rohit File Difference Checker Method Start
	public static boolean isFileSimilar(File oldFile,String newFile,int header){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd_HH-mm-sss");
		boolean isSimilar = false;
		String outpayload = ""; //add new file location and file name
		String command = "(head -n +"+header+" ${input} && diff ${oldfile} ${input} | grep '>' | sed -e 's/> //'; ) > ${output}";
		try{
			//int totalCount = new com.anm.ism.utils.FileUtils().countRows(oldFile.getAbsolutePath()); //Count Includes Header Count
			command = command.replaceAll(OLD_INPUT_FILE_EXPRESSION, oldFile.getAbsolutePath());
			command = command.replaceAll(INPUT_FILE_EXPRESSION, newFile);
			/*int lastIndxDot = newFile.lastIndexOf('.');
			if (lastIndxDot != -1) {
		        String beforeDot = newFile.substring(0, lastIndxDot);
		        System.out.println(beforeDot);
		        int lastIndxSlash = beforeDot.lastIndexOf('/');
		        if(lastIndxSlash != -1){
		        	String afterSlash = beforeDot.substring(lastIndxSlash+1, beforeDot.length());
		        	System.out.println(afterSlash);
		        }
		    }*/
			String [] arrOfStr = newFile.split("\\.");
			if(!OctashopUtils.isEmpty(arrOfStr[0]+"")){
				outpayload = arrOfStr[0].toString()+sdf.format(new Date())+DOT+CSV;
				outpayload = outpayload.replaceAll("sort_", "diff_");
			}
			command = command.replaceAll(OUTPUT_FILE_EXPRESSION, outpayload);
			LOGGER.info(command);
			execute(command);
			//int discardCount = totalCount -  (new com.anm.ism.utils.FileUtils().countRows(outpayload)-1);//Count Includes Header Count
			if((new com.sellerportal.ism.utils.FileUtils().countRows(outpayload)-header)==0){
				isSimilar = true ;
			}
			File file = new File(outpayload);
			file.delete();
		}
		catch(Exception e){
			LOGGER.error(e.getStackTrace());
		}
		return isSimilar;
	}

	public static void execute(String unixShellCommand) {
		long t = System.currentTimeMillis(), m = Runtime.getRuntime().freeMemory();
		String tmp = null;
		execute(unixShellCommand, tmp);
		LOGGER.info("#Unix Command: "+unixShellCommand+" #Execution Time "+(System.currentTimeMillis() - t) +" #Memory Consumed :"+(Runtime.getRuntime().freeMemory() - m));
	}

	public static void execute(String unixShellCommand, String outfilePath) {
		InputStream is = null;
		FileOutputStream fos = null;
		try {
			String[] cmd = { "/bin/sh", "-c", unixShellCommand };
			Process process = Runtime.getRuntime().exec(cmd);
			if(!OctashopUtils.isEmpty(outfilePath)){
				is = process.getInputStream();
				fos = new FileOutputStream(new File(outfilePath));
				IOUtils.copyLarge(is, fos);
				IOUtils.closeQuietly(is);
				IOUtils.closeQuietly(fos);
			}
			int exitVal = process.waitFor();
			LOGGER.info("Process exitValue: " + exitVal);
		} catch (Exception e) {
			LOGGER.error(e.getStackTrace());
		}
	}

	public static File lastFileModified(String dir) {
		File fl = new File(dir);
		File[] files = fl.listFiles(new FileFilter() {          
			public boolean accept(File file) {
				return file.isFile();
			}
		});
		long lastMod = Long.MIN_VALUE;
		File choice = null;
		for (File file : files) {
			if (file.lastModified() > lastMod) {
				choice = file;
				lastMod = file.lastModified();
			}
		}
		return choice;
	}

	public static String sortFile(File inputFile,String sellerid,String headCnt){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd_HH-mm-sss");
		String outpayload = null;
		String nfilePath = null;
		String SELLER_ID = "\\$\\{sellerid\\}";
		int no_of_Header = Integer.parseInt(headCnt);
		String command = "(head -n +${no_of_header} ${input} && tail -n +${escape_header} ${input} | sort -t ',' -k1,2 ) > ${output}";
		//String outpayload = "/tulincu/inbound/seller/${sellerid}/inventory/sorted/";
		//String outpayload = "/tulincu/outbound/upload/inventory/seller_${sellerid}/sorted/";
		//
		String inFilepath = inputFile.getAbsolutePath();
		int lastIndxSlash = inFilepath.lastIndexOf('/');
		if(lastIndxSlash != -1){
			nfilePath = inFilepath.substring(0, lastIndxSlash+1);
			System.out.println(nfilePath);
		}

		outpayload = nfilePath +"sorted/sort_"+sdf.format(new Date())+"_"+inputFile.getName().toString();
		//
		//outpayload = outpayload +"sort_"+inputFile.getName().toString();
		try {
			outpayload = outpayload.replaceAll(SELLER_ID, sellerid);
			command = command.replaceAll(INPUT_FILE_EXPRESSION, inputFile.getAbsolutePath());
			command = command.replaceAll(OUTPUT_FILE_EXPRESSION, outpayload);
			command = command.replaceAll(NO_OF_HEADER_EXPRESSION, no_of_Header+"");
			command = command.replaceAll(ESCAPE_HEADER_EXPRESSION, (no_of_Header+1)+"");
			LOGGER.info(command);
			execute(command);
		} catch (Exception e) {
			LOGGER.error(e.getStackTrace());
		}
		return outpayload;
	}
	//@Rohit File Difference Checker Method End

	//@Rohit Start of Analytics date and time
	public static Date[] getSdateEdate(String stime,String etime,int threshold){
		Date sDateEDate[] = new Date[2];
		try {
			String cDate = dateformat.format(new Date());
			if(!OctashopUtils.isEmpty(stime)){
				sDateEDate[0] = getDate(cDate,stime);
				LOGGER.info("Start Date And Time ::::: "+sDateEDate[0]);
				if(!OctashopUtils.isEmpty(etime)){
					sDateEDate[1] = getDate(cDate,etime);
					LOGGER.info("End Date And Time ::::: "+sDateEDate[1]);
				}else{
					sDateEDate[1] = getDatewithThre(sDateEDate[0],threshold);
					LOGGER.info("End Date And Time ::::: "+sDateEDate[1]);
				}
			}

		} catch (Exception e) {
			LOGGER.error(e.getStackTrace());
		}
		return sDateEDate;
	}

	public static Date getDate(String cDate,String time){
		Date d = null;
		String dt = cDate+"-"+time+":00";
		try {
			d = formatter.parse(dt);
			LOGGER.info("Date And Time ::::: "+d);
		} catch (Exception e) {
			LOGGER.error(e.getStackTrace());
		}
		return d;
	}

	public static Date getDatewithThre(Date sDate,int threshold){
		Date d = null;
		d = new Date(sDate.getTime() + threshold * 3600*1000);
		LOGGER.info("Date and Time After Adding Threshold::::: "+d);
		return d;
	}

	public static boolean colorDecider(Date lastUpdateDt,Date stime){
		boolean isValidDate = false;
		//String startDate =  dateformat.format(new Date())+"-"+stime+":00";
		//Date startDate = stime;
		try {
			String rangeDate = isSameDate(formatter.parse(formatter.format(new Date())),stime);
			if("Before".equals(rangeDate)){
				Date edate = Utility.getDateSubstractDays(stime,1);
				if(lastUpdateDt.after(edate) && lastUpdateDt.before(stime)){
					return true;
				}
			}else if("After".equals(rangeDate)){
				Date edate = Utility.getDateAddDays(stime,1);
				if(lastUpdateDt.after(stime) && lastUpdateDt.before(edate)){
					return true;
				}
			}
		} catch (Exception e) {
			LOGGER.error(e.getStackTrace());
		}
		return isValidDate;
	}

	public static String isSameDate(Date cDate,Date sDate){
		String day = "";
		if (cDate.after(sDate)) {
			day = "After";
			LOGGER.info("cDate is after sDate");
		}
		if (cDate.before(sDate)) {
			day = "Before";
			LOGGER.info("cDate is Before sDate");
		}
		if (cDate.equals(sDate)) {
			day = "Equal";
			LOGGER.info("cDate is equal sDate");
		}
		return day;
	}

	@SuppressWarnings("deprecation")
	public static Date[] getSDateEDateRangeByCtime(String stime,String etime,int threshold){
		Date sDateEDate[] = new Date[2];
		try {
			String cDate = dateformat.format(new Date());
			Date cDateTime = new Date();
			if(!OctashopUtils.isEmpty(stime)){
				sDateEDate[0] = getDate(cDate,stime);
				LOGGER.info("Start Date And Time ::::: "+sDateEDate[0]);
				if(!OctashopUtils.isEmpty(etime)){
					sDateEDate[1] = getDate(cDate,etime);
					LOGGER.info("End Date And Time ::::: "+sDateEDate[1]);
				}else{
					sDateEDate[1] = getDatewithThre(sDateEDate[0],threshold);
					LOGGER.info("End Date And Time ::::: "+sDateEDate[1]);
				}
			}
			while(!(cDateTime.after(sDateEDate[0]) && cDateTime.before(sDateEDate[1]))){
				sDateEDate = getSdateEdate(sDateEDate[1].getHours()+":00",etime,threshold);
			}
		} catch (Exception e) {
			LOGGER.error(e.getStackTrace());
		}
		return sDateEDate;
	}
	//@Rohit End of Analytics date and time

	//siddhesh
	public static boolean isMapEmpty(Map<?,?> map) {
		if (map == null || map.isEmpty() || map.size() == 0 ){
			return true;
		}else{
			return false;
		}
	}
	//Siddhesh

	//@siddhesh
	public static boolean isKeyEmpty(Map<String,String> map,String key) {
		if (isMapEmpty(map) || isEmpty(key)){
			return true;
		}else if(!OctashopUtils.isEmpty(key) && !isMapEmpty(map) && isEmpty((String)map.get(key))){
			return true;
		}
		else{
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

	public static boolean isNotEmpty(Object value) {
		if (value == null) {
			return false;
		} else if (value instanceof String) {
			String text = (String) value;
			return text.trim().length() > 0 && !"null".trim().equals(text);
		} else if (value instanceof Collection) {
			return ((Collection<?>) value).size() > 0;
		} else if (value instanceof List) {
			return ((List<?>) value).size() > 0;
		} else if (value instanceof Map) {
			return ((Map<?,?>) value).size() > 0;
		} else if (value instanceof Set) {
			return ((Set<?>) value).size() > 0;
		} else if (value instanceof Vector) {
			return ((Vector<?>) value).size() > 0;
		} else {
			return true;
		}
	}

	//@Nikhil.S
	public static String generateCommissionId(String type, String sellercode, Date currentdate) {
		String generateId = null;
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
			String todaydate =  sdf.format(currentdate);
			if(OctashopUtils.isEmpty(sellercode)) {
				sellercode = "";
			}
			generateId = type + sellercode + todaydate;
		} catch(Exception e) {
			StackTraceElement ste = e.getStackTrace()[0];
			LOGGER.error("Message :: "+e.toString() +" Cause :: "+e.getCause()+" Detail ::"+ste.getClassName()+">"+ste.getMethodName()+">"+ste.getLineNumber());
		}
		return  generateId;
	}

	public static boolean sendEmailForUploadApprovalId(String subject, String content) {
		boolean flag = false;
		try {
			final Configuration conf = new Configuration();
			AbstractMailApi absMail = AbstractMailApi.getInstance(conf.getMailServerIP(),conf.getMailTemplateUploadLocation());
			String toEmailIds = conf.getProperty("sendEmailForApprovalIdToMakerChecker");
			absMail.sendEmail(toEmailIds, conf.getFromAddress(), subject, content);
		} catch(Exception e) {
			StackTraceElement ste = e.getStackTrace()[0];
			LOGGER.error("Message :: "+e.toString() +" Cause :: "+e.getCause()+" Detail ::"+ste.getClassName()+">"+ste.getMethodName()+">"+ste.getLineNumber());
		}
		return flag;
	}


	public static String dateForCommissionSavingPath(){
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
		return dateFormat.format(new Date());
	}

	//@siddhesh sellNow TPR-7759 
	public static XMLGregorianCalendar stringToXMLGregorianCalendar(String s) throws ParseException,DatatypeConfigurationException
	{
		XMLGregorianCalendar result = null;
		Date date;
		SimpleDateFormat simpleDateFormat;
		GregorianCalendar gregorianCalendar;

		simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		date = simpleDateFormat.parse(s);
		gregorianCalendar = (GregorianCalendar)GregorianCalendar.getInstance();
		gregorianCalendar.setTime(date);
		result = DatatypeFactory.newInstance().newXMLGregorianCalendar(gregorianCalendar);
		return result;
	}

	//Shankar Start : TPR-9982
	public static boolean isValidBoxTypeForMH(String boxType){
		boolean validBoxType = true;
		String charAfterBox = "";
		boolean boxTypeFlag = true;
		try{
			boxTypeFlag = boxType.startsWith("PB");
			if(boxTypeFlag){
				charAfterBox = boxType.substring(2);
				if(isNumber(charAfterBox)){
					validBoxType = false;
				}
			}
		}catch(Exception e){
			StackTraceElement ste = e.getStackTrace()[0];
			LOGGER.error("Message :: "+e.toString() +" Cause :: "+e.getCause()+" Detail ::"+ste.getClassName()+">"+ste.getMethodName()+">"+ste.getLineNumber());
		}
		return validBoxType;
	}
	//Shankar End : TPR-9982
	public static int dayofweek(int d, int m, int y) 
	{ 
		int t[] = { 0, 3, 2, 5, 0, 3, 5, 1, 4, 6, 2, 4 }; 
		y -= (m < 3) ? 1 : 0; 
		return ( y + y/4 - y/100 + y/400 + t[m-1] + d) % 7; 
	}

	//@nikhil.S Digital Seller Common Email
	public static void sendCommonEmail(String logFileName,String sub,String sendTo,String Msg){
		try{
			Configuration conf=new Configuration();
			if(!OctashopUtils.isEmpty(sendTo)){
				StringBuffer buff = new StringBuffer();
				buff.append(Msg);
				AbstractMailApi absMail=AbstractMailApi.getInstance(conf.getMailServerIP(),conf.getMailTemplateUploadLocation());
				try{
					absMail.sendEmail(sendTo, conf.getFromAddress(),sub, buff.toString());
				}catch(Exception e){
				}
			}
		}catch(Exception e){
			LOGGER.error("Exception while sending summary file"+e.getMessage());
		}

	}

	//@Suraj.T java8 Date Difference
	public static long dateDifference(Date date1){
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		LocalDate dateBefore = LocalDate.parse(dateFormat.format(date1));
		LocalDate dateAfter = LocalDate.parse(dateFormat.format(new Date()));
		return(ChronoUnit.DAYS.between(dateBefore, dateAfter));

	}

	//@Rohit Start ::: Below Utility Method is to Verify Valid Date Format
	public static boolean isValidFormat(String format, String value) {
		Date date = null;
		try {
			SimpleDateFormat sdf = new SimpleDateFormat(format);
			date = sdf.parse(value);
			if (!value.equals(sdf.format(date))) {
				date = null;
			}
		} catch (ParseException e) {
			LOGGER.error("Exception While Parsing date "+e.getMessage());
		}
		return date != null;
	}

	public static boolean isPositiveNum(String num) {
		try {
			double value = Double.parseDouble(num);
			if(value<0)
				return false;
			else
				return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}

	public static boolean isPositiveNum(double num) {
		try {
			if(num<0)
				return false;
			else
				return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}
	//@Rohit End ::: Below Utility Method is to Verify Valid Date Format

	public static String replaceAllManyChars(String dataStr,String searchChars,String replaceChars) {
		return StringUtils.replaceChars(dataStr,searchChars,replaceChars);
	}

	public static String getCSVFilename(String fileName){
		Date currDate = new Date();
		String[] date = sdfFile.format(currDate).split(":");
		String[] date1 = date[0].split(" ");
		return fileName+"-"+date1[0]+"-"+date1[1]+"-"+date[1]+"-"+date[2]+".csv";        
	}

	//@siddhesh : kafka
	public static String getPCMKafkaFlag(){
		String flag = "0";
		flag = new OctParamDAO().findParamValueByCode("PCMKAFKA");
		return flag;        
	}
	//@siddhesh : kafka

	//Shankar Start : TPR-11937
	public static String getWordsByDigits(double digits){
		String dig = String.valueOf(digits).replace(".", "#");
		String[] value= dig.split("#");
		StringBuilder words = new StringBuilder();
		
		int digit = Integer.parseInt(value[0]);
		int precision = Integer.parseInt(value[1]);
		
		words.append(convert((digit/1000000000)," Hundred"));
		words.append(convert((digit/10000000)%100," Crore"));
		words.append(convert(((digit/100000)%100)," Lakh"));
		words.append(convert(((digit/1000)%100)," Thousand"));
		words.append(convert(((digit/100)%10)," Hundred"));
		words.append(convert((digit%100)," Rupees"));
		
		words.append(convert(((precision)%100)," Paise"));
		
		return words.toString().trim();
	}

	public static String convert(double n,String ch){
		StringBuilder word = new StringBuilder();
		String  one[]={" "," One"," Two"," Three"," Four"," Five"," Six"," Seven"," Eight"," Nine"," Ten"," Eleven"," Twelve"," Thirteen"," Fourteen","Fifteen"," Sixteen"," Seventeen"," Eighteen"," Nineteen"};
		String ten[]={" "," "," Twenty"," Thirty"," Forty"," Fifty"," Sixty","Seventy"," Eighty"," Ninety"};

		if(n > 19) { 
			word.append(ten[(int) (n/10)]+" "+one[(int) (n%10)]);
		} else { 
			word.append(one[(int) n]);
		}
		if(n > 0)
			word.append(ch);

		return word.toString();
	}
	//Shankar End : TPR-11937

	/**
	 * <p>Checks whether the String a valid Java number.</p>
	 *
	 * <p>Valid numbers include hexadecimal marked with the <code>0x</code> or
	 * <code>0X</code> qualifier, octal numbers, scientific notation and
	 * numbers marked with a type qualifier (e.g. 123L).</p>
	 *
	 * <p>Non-hexadecimal strings beginning with a leading zero are
	 * treated as octal values. Thus the string <code>09</code> will return
	 * <code>false</code>, since <code>9</code> is not a valid octal value.
	 * However, numbers beginning with {@code 0.} are treated as decimal.</p>
	 *
	 * <p><code>null</code> and empty/blank {@code String} will return
	 * <code>false</code>.</p>
	 *
	 * <p>Note, {@link #createNumber(String)} should return a number for every
	 * input resulting in <code>true</code>.</p>
	 *
	 * @param str  the <code>String</code> to check
	 * @return <code>true</code> if the string is a correctly formatted number
	 * @since 3.5
	 */
	public static boolean isCreatable(final String str) {
		if (StringUtils.isEmpty(str)) {
			return false;
		}
		final char[] chars = str.toCharArray();
		int sz = chars.length;
		boolean hasExp = false;
		boolean hasDecPoint = false;
		boolean allowSigns = false;
		boolean foundDigit = false;
		// deal with any possible sign up front
		final int start = chars[0] == '-' || chars[0] == '+' ? 1 : 0;
		if (sz > start + 1 && chars[start] == '0' && !StringUtils.contains(str, '.')) { // leading 0, skip if is a decimal number
			if (chars[start + 1] == 'x' || chars[start + 1] == 'X') { // leading 0x/0X
				int i = start + 2;
				if (i == sz) {
					return false; // str == "0x"
				}
				// checking hex (it can't be anything else)
				for (; i < chars.length; i++) {
					if ((chars[i] < '0' || chars[i] > '9')
							&& (chars[i] < 'a' || chars[i] > 'f')
							&& (chars[i] < 'A' || chars[i] > 'F')) {
						return false;
					}
				}
				return true;
			} else if (Character.isDigit(chars[start + 1])) {
				// leading 0, but not hex, must be octal
				int i = start + 1;
				for (; i < chars.length; i++) {
					if (chars[i] < '0' || chars[i] > '7') {
						return false;
					}
				}
				return true;
			}
		}
		sz--; // don't want to loop to the last char, check it afterwords
		// for type qualifiers
		int i = start;
		// loop to the next to last char or to the last char if we need another digit to
		// make a valid number (e.g. chars[0..5] = "1234E")
		while (i < sz || i < sz + 1 && allowSigns && !foundDigit) {
			if (chars[i] >= '0' && chars[i] <= '9') {
				foundDigit = true;
				allowSigns = false;

			} else if (chars[i] == '.') {
				if (hasDecPoint || hasExp) {
					// two decimal points or dec in exponent
					return false;
				}
				hasDecPoint = true;
			} else if (chars[i] == 'e' || chars[i] == 'E') {
				// we've already taken care of hex.
				if (hasExp) {
					// two E's
					return false;
				}
				if (!foundDigit) {
					return false;
				}
				hasExp = true;
				allowSigns = true;
			} else if (chars[i] == '+' || chars[i] == '-') {
				if (!allowSigns) {
					return false;
				}
				allowSigns = false;
				foundDigit = false; // we need a digit after the E
			} else {
				return false;
			}
			i++;
		}
		if (i < chars.length) {
			if (chars[i] >= '0' && chars[i] <= '9') {
				// no type qualifier, OK
				return true;
			}
			if (chars[i] == 'e' || chars[i] == 'E') {
				// can't have an E at the last byte
				return false;
			}
			if (chars[i] == '.') {
				if (hasDecPoint || hasExp) {
					// two decimal points or dec in exponent
					return false;
				}
				// single trailing decimal point after non-exponent is ok
				return foundDigit;
			}
			if (!allowSigns
					&& (chars[i] == 'd'
					|| chars[i] == 'D'
					|| chars[i] == 'f'
					|| chars[i] == 'F')) {
				return foundDigit;
			}
			if (chars[i] == 'l'
					|| chars[i] == 'L') {
				// not allowing L with an exponent or decimal point
				return foundDigit && !hasExp && !hasDecPoint;
			}
			// last character is illegal
			return false;
		}
		// allowSigns is true iff the val ends in 'E'
		// found digit it to make sure weird stuff like '.' and '1E-' doesn't pass
		return !allowSigns && foundDigit;
	}

	/**
	 * <p>Checks whether the given String is a parsable number.</p>
	 *
	 * <p>Parsable numbers include those Strings understood by {@link Integer#parseInt(String)},
	 * {@link Long#parseLong(String)}, {@link Float#parseFloat(String)} or
	 * {@link Double#parseDouble(String)}. This method can be used instead of catching {@link java.text.ParseException}
	 * when calling one of those methods.</p>
	 *
	 * <p>Hexadecimal and scientific notations are <strong>not</strong> considered parsable.
	 * See {@link #isCreatable(String)} on those cases.</p>
	 *
	 * <p>{@code Null} and empty String will return <code>false</code>.</p>
	 *
	 * @param str the String to check.
	 * @return {@code true} if the string is a parsable number.
	 * @since 3.4
	 */
	public static boolean isParsable(final String str) {
		if (StringUtils.isEmpty(str)) {
			return false;
		}
		if (str.charAt(str.length() - 1) == '.') {
			return false;
		}
		if (str.charAt(0) == '-') {
			if (str.length() == 1) {
				return false;
			}
			return withDecimalsParsing(str, 1);
		}
		return withDecimalsParsing(str, 0);
	}

	private static boolean withDecimalsParsing(final String str, final int beginIdx) {
		int decimalPoints = 0;
		for (int i = beginIdx; i < str.length(); i++) {
			final boolean isDecimalPoint = str.charAt(i) == '.';
			if (isDecimalPoint) {
				decimalPoints++;
			}
			if (decimalPoints > 1) {
				return false;
			}
			if (!isDecimalPoint && !Character.isDigit(str.charAt(i))) {
				return false;
			}
		}
		return true;
	}

	public static List<String> getAllCancelStatus(){
		List<String> smtCodeList = new ArrayList<String>();
		smtCodeList.add(OmsStatusMasterInterface.ORDER_CANCELLATION);
		smtCodeList.add(OmsStatusMasterInterface.CLOSE_ON_CANCELLATION);
		smtCodeList.add(OmsStatusMasterInterface.REFUND_INITIATED);
		return smtCodeList;
	}

	
	
	//@siddhesh : slr payout
	public static Date getSQLDate(Date date){
		java.sql.Date sqlDate = new java.sql.Date( date.getTime() );
		return sqlDate;
	}
	//@siddhesh : slr payout
	
	//@Nikhil.S Payout utility
	public static List getPayoutDates(String str,String dateStr,String isPrioritySlr) throws Exception{ //pass dateStr as yyyy-MM-dd
			//Sun is 1
			List list = new ArrayList();
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
			Calendar calendar = Calendar.getInstance();
			if(OctashopUtils.isNotEmpty(dateStr)){
				Date pastDate = formatter.parse(dateStr);
				calendar.setTime(pastDate);
			}else{
				calendar.setTime(new Date());
			}
	        
	        String[] strArr = str.split("#");
	        int weekOfYr=0;
	        int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
	        if(OctashopUtils.isNotEmpty(dateStr)){
	        	weekOfYr = calendar.get(Calendar.WEEK_OF_YEAR)+1;
	        }else{
	        	weekOfYr = calendar.get(Calendar.WEEK_OF_YEAR);
	        }
	        int i=0;
	        while(i<strArr.length){
	            int day = Integer.parseInt((strArr[i].split("-")[0]));
	            LOGGER.info("dayOfWeek-> "+dayOfWeek +"<="+day);
	            if(dayOfWeek<=day){
	                break;
	            }

	                i++;
	        }
	        String strDays[] = null;
	        if(!(i<strArr.length)){
	        	//strDays = new Configuration().getDefaltPayoutCycle().split("-");
	        	strDays = strArr[0].split("-");
	        }
	        else{
	        	strDays = strArr[i].split("-");
	        }

	        int cycleDay= Integer.parseInt(strDays[0]);
	        int fromDay= Integer.parseInt(strDays[1]);
	        int toDay= Integer.parseInt(strDays[2]);
	        calendar.set(Calendar.WEEK_OF_YEAR,weekOfYr);
	        calendar.set(Calendar.DAY_OF_WEEK,cycleDay);
	        Date cycleDate = calendar.getTime();
	        list.add(cycleDate); //cycle date
	        
	        calendar.set(Calendar.DAY_OF_WEEK,fromDay);
	        
	        if(calendar.getTime().after(cycleDate) || isPrioritySlr.equals("N")){
	        	  calendar.set(Calendar.WEEK_OF_YEAR,weekOfYr-1);
	        }
	        
	        list.add(formatter.format(calendar.getTime())); //From date
	        calendar.set(Calendar.WEEK_OF_YEAR,weekOfYr);
	        calendar.set(Calendar.DAY_OF_WEEK,toDay);
	        
	        if(calendar.getTime().after(cycleDate)){
	        	calendar.set(Calendar.WEEK_OF_YEAR,weekOfYr-1);
	        }
	        
	        list.add(formatter.format(calendar.getTime())); //To date
		
		return list;
	}
	
	public static boolean isNumber1(String str){
		String pattern="[0-9]+";
		if(str.matches(pattern)){
			return true;
		}else{
			return false;
		}
	}

	
	public static double getDateDiffInHrMin(Date start,Date end){
		long diffInMillies = (end.getTime() - start.getTime())/ 1000;
		if(diffInMillies>0){
	    long hr = (diffInMillies / 3600);
        long min = ((diffInMillies % 3600))/60;
        
        String result = String.format("%d.%02d", hr, min);
        
        return Double.parseDouble(result);
		}else{
			return -1;
		}
	}
	public static String specialCharToRemove(String str){
		try{
			String charsToRemove = "¿";
			str = str.replaceAll(charsToRemove, "");
		}catch(Exception e){LOGGER.info("Errror in removing not required cahrs"+e.getMessage());}
		return str;
	}

	/**
	 * Function to check for whether the given number is of specified length
	 * @param number
	 * @param length
	 * @return boolean - if the number matches the specified length or not
	 */
	public static boolean isNumberWithValidLength(String number, String length) {
		String pattern = "^\\d{"+length+"}$";
		if (number.matches(pattern)) {
			return true;
		}
		return false;
	}
}