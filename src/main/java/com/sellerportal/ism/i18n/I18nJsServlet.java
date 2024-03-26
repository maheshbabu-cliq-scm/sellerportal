package com.sellerportal.ism.i18n;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.zip.GZIPOutputStream;

import javax.servlet.ServletOutputStream;
import javax.servlet.WriteListener;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.tools.ant.filters.StringInputStream;
import org.springframework.util.StringUtils;

public class I18nJsServlet extends HttpServlet {
	private final Log LOGGER = LogFactory.getLog(I18nJsServlet.class);

	private static final long serialVersionUID = 1L;

	private boolean gzipEnabled = true;
	private int defaultCacheTimeout = 60*60; 
	private boolean cachingEnabled = true;
	
	private Map<String, String> defaultMimeTypes = new HashMap<String, String>();
	{
		defaultMimeTypes.put(".css", "text/css");
		defaultMimeTypes.put(".gif", "image/gif");
		defaultMimeTypes.put(".ico", "image/vnd.microsoft.icon");
		defaultMimeTypes.put(".jpeg", "image/jpeg");
		defaultMimeTypes.put(".jpg", "image/jpeg");
		defaultMimeTypes.put(".js", "text/javascript");
		defaultMimeTypes.put(".png", "image/png");
	}

	

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws IOException {
		try {

			if (LOGGER.isDebugEnabled()) {
				LOGGER
						.debug("********************************************************************");
				LOGGER
						.debug("****************		I18nJsServlet Called		****************");
				LOGGER
						.debug("********************************************************************");
			}

			request.setCharacterEncoding("UTF-8");
			
			URL resource = getResourceByName(request, "resources/Messages");
			if(resource == null)
				return;
			
			
			long lastModified = getLastModified(resource);
			String currentMimeType = getServletContext().getMimeType(resource.getPath());
			if (currentMimeType == null) {
				String extension = resource.getPath().substring(resource.getPath().lastIndexOf('.'));
				currentMimeType = (String) defaultMimeTypes.get(extension);
			}
			response.setContentType("text/javascript;charset=UTF-8");
			response.setDateHeader("Last-Modified", lastModified);
			if(cachingEnabled)
			{
				int cacheTimeout = defaultCacheTimeout;
				try {
					cacheTimeout = Integer.parseInt(getServletConfig().getInitParameter("cacheTimeout").trim());
				}catch(Exception e) {}
				
				if (cacheTimeout > 0) {
					response.setDateHeader("Expires", System.currentTimeMillis() + cacheTimeout * 1000L); //Http 1.0
					response.setHeader("Cache-Control", "max-age=" + cacheTimeout); //Http 1.1
				}
			}
			
			
			
			StringBuffer content = getContent(request,response,resource);
			if(content == null)
				content = new StringBuffer("");
			response.setHeader("Content-Length", Long.toString(content.length()));
			
			OutputStream out = selectOutputStream(request, response);
			try {
				InputStream in = new StringInputStream(content.toString());
				try {
					byte[] buffer = new byte[1024];
					int bytesRead = -1;
					while ((bytesRead = in.read(buffer)) != -1) {
						out.write(buffer, 0, bytesRead);
					}
				} finally {
					in.close();
				}
			} finally {
				out.close();
			}
			
		} catch (Exception e) {
			LOGGER.info("Message :: "+e.toString() +" Cause :: "+e.getCause());
		}
	}

	private OutputStream selectOutputStream(HttpServletRequest request,HttpServletResponse response) throws IOException {

		String acceptEncoding = request.getHeader("Accept-Encoding");

		if (gzipEnabled && StringUtils.hasText(acceptEncoding) && acceptEncoding.indexOf("gzip") > -1) {
			LOGGER.debug("Enabling GZIP compression for the current response.");
			return new GZIPResponseStream(response);
		} else {
			return response.getOutputStream();
		}
	}
	
	

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws IOException {
		doGet(request, response);
	}

	private URL getResourceByName(HttpServletRequest request, String resourceBundleName) {
		URL resource = null;
		String langCode = I18nHelper.getLanguageCode(request);
		if (langCode != null) {
			try {
				resource = Thread.currentThread().getContextClassLoader().getResource(
						resourceBundleName + "_" + langCode + ".properties");
			} catch (Exception e) {
			}
		}
		if (resource == null) {
			try {
				resource = Thread.currentThread().getContextClassLoader().getResource(
						resourceBundleName + "_" + "en" + ".properties");
			} catch (Exception e) {
			}
		}
		if (resource == null) {
			try {
				resource = Thread.currentThread().getContextClassLoader().getResource(
						resourceBundleName + ".properties");
			} catch (Exception e) {
			}
		}
		return resource;
	}

	/**
	 * This method is called by the generic servlet
	 */
	protected long getLastModified(HttpServletRequest request) {
		long lastModified = -1;
		URL resource = getResourceByName(request, "resources/Messages");
		if(resource != null)
			lastModified =  getLastModified(resource);	
		//log.info("getLastModified :TODO<<Remove this>>: "+lastModified);
		return lastModified;
		
	}
	
	protected long getLastModified(URL resources) {
		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("Checking last modified of resource: "
					+ resources.getPath());
		}

		if (resources == null) {
			return -1;
		}

		long lastModified = -1;
		URLConnection resourceConn;
		try {
			resourceConn = resources.openConnection();
		} catch (IOException e) {
			return -1;
		}
		if (resourceConn.getLastModified() > lastModified) {
			lastModified = resourceConn.getLastModified();
		}

		return lastModified;
	}

	private Properties load(URL resource) {
		InputStream ins = null;
		try {
			ins = resource.openStream();
			Properties properties = new Properties();
			properties.load(ins);
			ins.close();
			return properties;
		} catch (Exception e) {
		} finally {
			if (ins != null)
				try {
					ins.close();
				} catch (IOException e) {

				}
		}
		return null;

	}

	private StringBuffer getContent(HttpServletRequest request,
			HttpServletResponse response, URL resource) {
		
		if (resource != null) {

			Properties properties = load(resource);

			StringBuffer buffer = new StringBuffer();
			String bufferString = "";

			buffer.append("var i18nAlertArr = new Array(");

			if (properties != null) {
				Enumeration em = properties.keys();
				while (em.hasMoreElements()) {
					String key = (String) em.nextElement();
					String value = (String) properties.get(key);
					//
					buffer.append("['" + key + "','" + value + "'],");
				}
				bufferString = buffer.toString();
				// Remove Last "," added in above line
				bufferString = bufferString.substring(0, bufferString
						.lastIndexOf(","));
				buffer = new StringBuffer();
				buffer.append(bufferString);
			}

			buffer.append(");");

			buffer.append("\nfunction i18n(alertkey){");
			buffer.append("\n	var multiArray = new Array();");
			buffer.append("\n	var alertValue = '';");
			buffer.append("\n	for(var k=0;k<i18nAlertArr.length;k++){");
			buffer.append("\n		multiArray = i18nAlertArr[k];");
			buffer.append("\n		if(multiArray[0]==alertkey){");
			buffer.append("\n			alertValue = multiArray[1];");
			buffer.append("\n			break;");
			buffer.append("\n		}");
			buffer.append("\n	} ");
			buffer.append("\n	if(alertValue == ''){");
			buffer.append("\n		alertkey = alertkey.replace(/_/g,' ');");
			buffer.append("\n		alertValue = alertkey;");
			buffer.append("\n	}");
			buffer.append("\n	return alertValue;");
			buffer.append("\n}");

			
			return buffer;
		} else {
			return null;
		}

	}

	private class GZIPResponseStream extends ServletOutputStream {

		private ByteArrayOutputStream byteStream = null;

		private GZIPOutputStream gzipStream = null;

		private boolean closed = false;

		private HttpServletResponse response = null;

		private ServletOutputStream servletStream = null;

		public GZIPResponseStream(HttpServletResponse response) throws IOException {
			super();
			closed = false;
			this.response = response;
			this.servletStream = response.getOutputStream();
			byteStream = new ByteArrayOutputStream();
			gzipStream = new GZIPOutputStream(byteStream);
		}

		public void close() throws IOException {
			if (closed) {
				throw new IOException("This output stream has already been closed");
			}
			gzipStream.finish();

			byte[] bytes = byteStream.toByteArray();

			response.setContentLength(bytes.length);
			response.addHeader("Content-Encoding", "gzip");
			servletStream.write(bytes);
			servletStream.flush();
			servletStream.close();
			closed = true;
		}

		public void flush() throws IOException {
			if (closed) {
				throw new IOException("Cannot flush a closed output stream");
			}
			gzipStream.flush();
		}

		public void write(int b) throws IOException {
			if (closed) {
				throw new IOException("Cannot write to a closed output stream");
			}
			gzipStream.write((byte) b);
		}

		public void write(byte b[]) throws IOException {
			write(b, 0, b.length);
		}

		public void write(byte b[], int off, int len) throws IOException {
			if (closed) {
				throw new IOException("Cannot write to a closed output stream");
			}
			gzipStream.write(b, off, len);
		}

		public boolean closed() {
			return (this.closed);
		}

		public void reset() {
			// noop
		}

		@Override
		public boolean isReady() {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public void setWriteListener(WriteListener listener) {
			// TODO Auto-generated method stub
			
		}
	}

	
}
