package com.sellerportal.ism.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.TimeZone;

import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.hibernate.Query;

import com.sellerportal.hibernate.HibernateConnection;
import com.sellerportal.integra.impl.octashop.utils.OctashopUtils;
import com.sellerportal.ism.ApplicationConstant;
import com.sellerportal.ism.BulkUploadProcessStatusBean;
import com.sellerportal.ism.Configuration;
import com.sellerportal.ism.SessionVariablesBean;

import com.sellerportal.ism.i18n.I18nFilter;
import com.sellerportal.ism.i18n.I18nHelper;
import com.sellerportal.model.Ismcnd;
import com.anm.jsf.utils.FacesUtils;
import com.sellerportal.tisl.seller.listproduct.utils.ProductConst;
import com.google.gson.Gson;

public class Utility implements ApplicationConstant {

	private static final Log LOGGER = LogFactory.getLog(Utility.class);

	public static void goToPage() {
		try {
			FacesContext ctx = FacesContext.getCurrentInstance();
			HttpServletRequest request = (HttpServletRequest) ctx
					.getExternalContext().getRequest();
			SessionVariablesBean svb = (SessionVariablesBean) FacesUtils
					.getManagedBean("SessionVariablesBean");
			String tabid = request.getParameter("tabid");
			String url = request.getParameter("url");
			url = url.replaceAll("&amp;", "&");

			FacesContext context = FacesContext.getCurrentInstance();
			HttpSession httpSession = request.getSession(false);
			httpSession.setAttribute("url", url);

			if (!OctashopUtils.isEmpty(tabid)) {
				svb.setTabId(tabid);
			} else {
				svb.setTabId("");
			}
			if (!OctashopUtils.isEmpty(url)) {
				ctx.getExternalContext().redirect(url);
			}
		} catch (Exception e) {
			LOGGER.info("Message :: "+e.toString() +" Cause :: "+e.getCause());
		}
	}

	
	public static HttpServletRequest getRequestObject() {
		return (HttpServletRequest) FacesContext.getCurrentInstance()
				.getExternalContext().getRequest();
	}

	public static SessionVariablesBean getSessionBeanObject() {
		return (SessionVariablesBean) FacesUtils
				.getManagedBean("SessionVariablesBean");
	}
	
	
	
	
	
	public static String replaceChar(String chr) {
		if (!OctashopUtils.isEmpty(chr)) {
			if (chr.contains("'")) {
				chr = chr.replace("'", "&#39;");
			}
			if (chr.contains("\"")) {
				chr = chr.replace("\"", "&#34;");
			}
			return chr;
		}
		return "";
	}

	public static String replaceCharMetatag(String chr) {
		if (!OctashopUtils.isEmpty(chr)) {
			String noHTMLString = chr.replaceAll("\\<.*?>", "");
			noHTMLString = noHTMLString.replaceAll("\r", "");
			noHTMLString = noHTMLString.replaceAll("\n", " ");
			noHTMLString = noHTMLString.replaceAll("\'", "'");
			noHTMLString = noHTMLString.replaceAll("&nbsp", " ");
			noHTMLString = noHTMLString.replaceAll("�", "");
			noHTMLString = noHTMLString.replaceAll("<(.|\n)*?>", "");
			noHTMLString = noHTMLString.replace("; ; ; ; ; ; ; ;", "");
			noHTMLString = noHTMLString.replaceAll("\\s+", " ");
			noHTMLString = noHTMLString.replaceAll(": ;", ":");
			noHTMLString = noHTMLString.replaceAll(". ; ", " ");
			noHTMLString = noHTMLString.replaceAll("â€", "");
			noHTMLString = noHTMLString.trim();
			return noHTMLString;
		}
		return "";
	}

	
	
	public static void copyFile(File srcPath, File dstPath) throws IOException {
		
		InputStream in = null;
		OutputStream out = null;
		try {
		in = new FileInputStream(srcPath);
		out = new FileOutputStream(dstPath);

		byte[] buf = new byte[1024];
		int len;
		while ((len = in.read(buf)) > 0) {
			out.write(buf, 0, len);
		}
		} finally {
			if(in!=null) {
				try {
					in.close();
				} catch(Exception e) {
					LOGGER.info("Message :: "+e.toString() +" Cause :: "+e.getCause());
				}
			}
			if(out!=null) {
				try {
					out.close();
				} catch(Exception e) {
					LOGGER.info("Message :: "+e.toString() +" Cause :: "+e.getCause());
				}
			}
		}
		
	}

	/**
	 * 
	 * @param srcPath
	 * @param dstPath
	 * @throws IOException
	 */
	public static void copyDirectory(File srcPath, File dstPath)
			throws IOException {
		if (srcPath.isDirectory()) {
			if (!dstPath.exists()) {
				dstPath.mkdir();
			}

			String files[] = srcPath.list();
			for (int i = 0; i < files.length; i++) {
				copyDirectory(new File(srcPath, files[i]), new File(dstPath,
						files[i]));
			}
		} else {
			if (!srcPath.exists()) {
				return;
			} else {
				InputStream in = null;
				OutputStream out = null;
				try {
				in = new FileInputStream(srcPath);
				out = new FileOutputStream(dstPath);

				byte[] buf = new byte[1024];
				int len;
				while ((len = in.read(buf)) > 0) {
					out.write(buf, 0, len);
				}
				} finally {
					if(in!=null) {
						try {
							in.close();
						} catch(Exception e) {
							LOGGER.info("Message :: "+e.toString() +" Cause :: "+e.getCause());
						}
					}
					if(out!=null) {
						try {
							out.close();
						} catch(Exception e) {
							LOGGER.info("Message :: "+e.toString() +" Cause :: "+e.getCause());
						}
					}
				}
				
			}
		}
	}
	
	
	public static List getEmptySelectList() {
		List list = new ArrayList();
		SelectItem item = new SelectItem("", "Please Select");
		list.add(item);
		return list;
	}

	public static HttpSession getSessionObject() {
		return (HttpSession) FacesContext.getCurrentInstance()
				.getExternalContext().getSession(false);
	}

	public static int dateValidator(Date beforeDate) {
		int status = 0;
		try {
			Date date = new Date();
			status = beforeDate.compareTo(date);
		} catch (Exception e) {
			LOGGER.info("Message :: "+e.toString() +" Cause :: "+e.getCause());
		}
		return status;
	}

	public static int dateValidatorWithoutTime(Date beforeDate) {
		int status = 0;
		try {
			Date date = new Date();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			String date2 = sdf.format(date);
			Date startingDate = sdf.parse(date2);
			LOGGER.info("currentDate is>>>>" + startingDate);
			status = beforeDate.compareTo(startingDate);
		} catch (Exception e) {
			LOGGER.info("Message :: "+e.toString() +" Cause :: "+e.getCause());
		}
		return status;
	}
	public static boolean isImageExist(File file) {
		if (file.exists()) {
			return true;
		} else {
			return false;
		}
	}
	
	
		
		
		private static int MAX_PIN_PER_CALL=1000;
		
		
		
	
		
		//Control flags to avoid commit time mistakes
		private static boolean IS_UPLOAD_IN_BATCH = false; //Meena: Later change it true when Partha Confirms
		private static boolean IS_REAL_SEND = true; //change it to true when commit - Meena
		
		
		
	public static void sendGet(String slave,String pstSmt,String stlSmt) throws Exception {
			
			String isEnable = new Configuration().getIsStlPstMismatchEnable();
			
			if("Y".equalsIgnoreCase(isEnable)){
				
				String serverPath = new Configuration().getStlpstMismatchUrl();
				final String USER_AGENT = "Mozilla/5.0";
				//String serverpath =req.getRequestURL().toString().replaceAll(req.getRequestURI().toString(), "")+"/";
				//String url = serverpath+"/flatfileupload/?action=CorrectStlPstMismatch&slave='"+slave+"'&pstSmt='"+pstSmt+"'&stlSmt='"+stlSmt+"'";
				String url = serverPath+"&slave='"+slave+"'&pstSmt='"+pstSmt+"'&stlSmt='"+stlSmt+"'";
				HttpClient client = new DefaultHttpClient();
				HttpGet request = new HttpGet(url);
				request.addHeader("User-Agent", USER_AGENT);
				client.execute(request);
				
			}
		}
	
			
			 public static Date  getDateSubstractDays(Date date, int days){
		         Calendar calendar = Calendar.getInstance();
		         calendar.setTime(date);
		         calendar.add(Calendar.DATE, -days);
		         return calendar.getTime();
		     }
			 
			 //Rohit Method Added to Subtract No Of days from Date
			 public static Date  getDateAddDays(Date date, int days){
		         Calendar calendar = Calendar.getInstance();
		         calendar.setTime(date);
		         calendar.add(Calendar.DATE, +days);
		         return calendar.getTime();
		     }
			 
			 
}