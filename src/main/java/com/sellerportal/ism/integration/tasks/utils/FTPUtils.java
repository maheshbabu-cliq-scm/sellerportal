package com.sellerportal.ism.integration.tasks.utils;

import it.sauronsoftware.ftp4j.FTPAbortedException;
import it.sauronsoftware.ftp4j.FTPClient;
import it.sauronsoftware.ftp4j.FTPDataTransferException;
import it.sauronsoftware.ftp4j.FTPDataTransferListener;
import it.sauronsoftware.ftp4j.FTPException;
import it.sauronsoftware.ftp4j.FTPFile;
import it.sauronsoftware.ftp4j.FTPIllegalReplyException;
import it.sauronsoftware.ftp4j.FTPListParseException;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Vector;
import java.util.zip.GZIPInputStream;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sellerportal.integra.impl.octashop.utils.OctashopUtils;
import com.sellerportal.ism.utils.ANMTimeZone;
import com.jcraft.jsch.Channel;
import com.jcraft.jsch.ChannelSftp;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.ProxyHTTP;
import com.jcraft.jsch.Session;
import com.jcraft.jsch.SftpATTRS;
import com.jcraft.jsch.SftpException;

/**
 * FTP Utility methods [1] FTPClient client =
 * connectToFTP(ip,port,userId,password) [2]
 * client.downloadFile(remoteFilePath,localFileObj,....) [3]
 * client.uploadFile(...TODO)
 * 
 * @author Chandra Singh Meena
 * 
 */
@SuppressWarnings("squid:S2885")
public class FTPUtils {
	
	private static final Log LOGGER  = LogFactory.getLog("FTP");
	
	private static String ftpIp = null;
	private static int ftpPort = 21;
	private static String userId = null;
	private static String password = null;
	private static boolean verbose = true;
	private static boolean showProgressBar = true;
	private static Properties configuration = null;
	private static boolean isFTPEnable = false; 
	public static String TMPLOCATION = "/tmp";
	private static ChannelSftp channelSftp = null;
	static{
		Properties configuration = null;
		try {
			//configuration = CommonUtils.loadFTPConfig();	
		} catch (Exception e) {
			
		}
		/*if(configuration != null){
			ftpIp = configuration.getProperty("static.ftp.ip");
			ftpPort = Integer.parseInt(configuration.getProperty("static.ftp.port"));
			userId = configuration.getProperty("static.ftp.user");
			password = configuration.getProperty("static.ftp.password"); 
			verbose = Boolean.parseBoolean(configuration.getProperty("static.ftp.verbose"));
			showProgressBar = Boolean.parseBoolean(configuration.getProperty("static.ftp.showProgressBar"));
			isFTPEnable = Boolean.parseBoolean(configuration.getProperty("enable.ftp"));
		}*/
	}
	
	
	public static Properties getConfiguration() {
		return configuration;
	}

	public static boolean isShowProgressBar() {
		return showProgressBar;
	}
	

	public static boolean isFTPEnable() {
		return isFTPEnable;
	}

	public static void setFTPEnable(boolean isFTPEnable) {
		FTPUtils.isFTPEnable = isFTPEnable;
	}

	public static FTPClient getFTPClient() throws Exception {
		FTPClient client = new FTPClient();
		try {
			client = connectToFTP(ftpIp, ftpPort, userId, password, verbose);
		} catch (Exception e) {
			LOGGER.info("Failed to connect");
			throw e;
		}
		return client;

	}
	
	
	/**
	 * 
	 * @param ip
	 *            String ip address of the FTP Server
	 * @param port
	 *            int FTP Port of the FTP
	 * @param userId
	 *            String userID ftp user
	 * @param password
	 *            String FTP user password
	 * @param verbose
	 *            boolean true to print the detail verbose output
	 * @return
	 * @throws Exception
	 */
	public static FTPClient connectToFTP(String ip, int port, String userId,
			String password, boolean verbose) throws Exception {
		FTPClient client = new FTPClient();
		try {
			LOGGER.info(" connecting to " + ip + " at port " + port
					+ " ...");
			String[] info = client.connect(ip, port);
			if (verbose) {
				LOGGER.info(" connect response ::");
				for (int i = 0; i < info.length; i++)
					System.out.print(info[i] + " ");
				LOGGER.info("/n");
			}
			LOGGER.info(" + connected to " + ip + " at port " + port
					+ ". ");
			client.login(userId, password);
			LOGGER.info(" + logged in to FTP <" + userId + "/xxxx>");

		} catch (IllegalStateException e) {
			LOGGER.info("Message :: "+e.toString() +" Cause :: "+e.getCause());
			throw e;
		} catch (IOException e) {
			LOGGER.info("Message :: "+e.toString() +" Cause :: "+e.getCause());
			throw e;
		} catch (FTPIllegalReplyException e) {
			LOGGER.info("Message :: "+e.toString() +" Cause :: "+e.getCause());
			throw e;
		}
		return client;

	}

	

	/**
	 * Download remote file <tt>remoteFilePath</tt> eg out/Stock.csv and save
	 * the downloaded file to <code>localFile</code>. If
	 * <code>progressBar</code> true then it will print the progress bar of
	 * downloaded bytes eg 1024 of 20000 per line if deleteAfterDownload true
	 * then remote file will be deleted from the FTP after successfull download
	 * 
	 * @param client
	 *            FTPClient FTP client connection object
	 * @param remoteFilePath
	 *            String path of the remote file relative to the user home eg
	 *            out/Stock.csv
	 * @param localFile
	 *            java.io.File File to save the downloaded file
	 * @param progressBar
	 *            boolean true show download progress bar
	 * @param renameAfterDownload
	 *            boolean if true delete the remote file
	 * @return
	 * @throws Exception
	 */
	public static File download(final FTPClient client,
			final String remoteFilePath,final String remoteFileName, final File localFile,
			final boolean progressBar, boolean renameAfterDownload,String remoteArchivePath,String isFileToBeDeleted)
			throws Exception {
		
		try {

			FTPFile[] files = client.list(remoteFilePath);
			if (files == null || files.length == 0) {
				LOGGER.warn(" Remote File does not exist :: " + remoteFilePath);
				return null;
			}
			
			
			FTPFile downloadFile =  null;
			if (files != null && files.length > 0) {
				for (int i = 0; i < files.length; i++) {
					int t = files[i].getType();
					String fileType = (t == FTPFile.TYPE_DIRECTORY) ? "Directory":"File"; 
					LOGGER.info(" REMOTE ::CWD = "+client.currentDirectory()+" "+files[i].getName() + " "+ files[i].getSize() + " "+ files[i].getModifiedDate()+" TYPE = "+fileType );
					if(files[i].getType() == FTPFile.TYPE_DIRECTORY)
						continue;
					if(remoteFileName != null && remoteFileName.trim().length() > 0 && files[i].getName().equalsIgnoreCase(remoteFileName)) {
						downloadFile = files[i];
						break;
					}else if(remoteFileName == null || remoteFileName.trim().length() == 0){
						downloadFile = files[i];
						break;
					}
					
				}
			}
			
			
			if(downloadFile == null)
			{
				LOGGER.warn(" Remote File does not exist :: " + remoteFilePath);
				return null;
			}
			
			final long fileSize = downloadFile.getSize();
			
			final long startTime = System.currentTimeMillis();

			FTPDataTransferListener listener = new FTPDataTransferListener() {
				private long totalTransferred = 0;

				private double lastPercentDone = 0f;

				private long lastPrintTime = System.currentTimeMillis();

				public void transferred(int paramInt) {
					totalTransferred += paramInt;
					double percentageDone = (totalTransferred * 100.00 / fileSize);
					if (System.currentTimeMillis() - lastPrintTime > 5000
							|| percentageDone - lastPercentDone > 1f) {
						long timeElapsed = (System.currentTimeMillis() - startTime);
						long speed = (totalTransferred * 1000 / (timeElapsed));
						LOGGER.info(" DOWNLOADING [" + remoteFilePath + "]  "
								+ String.format("%5.2f", percentageDone)+ " %,  " + timeElapsed / 1000 + " SECS, "
								+ speed + " BPS  :: " + totalTransferred+ " / " + fileSize);
						lastPrintTime = System.currentTimeMillis();
						lastPercentDone = percentageDone;
					}

					
				}

				public void started() {
					LOGGER.info("DOWNLOAD STARTED : " + ANMTimeZone.getDateInTimeZone());

				}

				public void failed() {
					LOGGER.info("DOWNLOAD FAILED : " + ANMTimeZone.getDateInTimeZone());

				}

				public void completed() {
					LOGGER.info("DOWNLOAD COMPLETED : " + ANMTimeZone.getDateInTimeZone());

				}

				public void aborted() {
					LOGGER.info("DOWNLOAD CANCELLED : " + ANMTimeZone.getDateInTimeZone());
				}
			};
			
			
			String remotePath = remoteFilePath+"/"+downloadFile.getName();
			LOGGER.info("+ Downloading "+remotePath);
			
			client.download(remotePath, localFile, listener);
			
			//@Rohit To Remove File After Download Start
			if(!OctashopUtils.isEmpty(isFileToBeDeleted) && "Y".equalsIgnoreCase(isFileToBeDeleted)){
				client.deleteFile(remoteFileName);
			}
			//End
			
			
			LOGGER.info("+ Remote File " + remotePath+ " Downloaded At " + localFile.getAbsolutePath()+ " Successfully SIZE ["+localFile.length()+"]");

			if (renameAfterDownload) {
				int j = remotePath.lastIndexOf('/');
				String fileName = remotePath.substring(j + 1) + "_"+ getCurrentTimestamp();
				if(remoteArchivePath == null)
					remoteArchivePath = "archived/";
				client.rename(remotePath, remoteArchivePath+"/"+fileName);
			}

			LOGGER.info("+ File Downloaded At "+ localFile.getAbsolutePath());
			

		} catch (IllegalStateException e) {

			LOGGER.info("Message :: "+e.toString() +" Cause :: "+e.getCause());
			throw e;
		} catch (IOException e) {

			LOGGER.info("Message :: "+e.toString() +" Cause :: "+e.getCause());
			throw e;
		} catch (FTPIllegalReplyException e) {

			LOGGER.info("Message :: "+e.toString() +" Cause :: "+e.getCause());
			throw e;
		} catch (FTPException e) {
			LOGGER.info("Message :: "+e.toString() +" Cause :: "+e.getCause());
			throw e;
		} catch (FTPDataTransferException e) {

			LOGGER.info("Message :: "+e.toString() +" Cause :: "+e.getCause());
			throw e;
		} catch (FTPAbortedException e) {

			LOGGER.info("Message :: "+e.toString() +" Cause :: "+e.getCause());
			throw e;
		} catch (FTPListParseException e) {

			throw e;
		}
		return localFile;
	}
	
	
	/**
	 * 
	 * @Ranjit seth
	 * 
	 * If file is not present in local then 
	 * first create file into local then copy 
	 * remote file to local file
	 * 
	 * Download remote file <tt>remoteFilePath</tt> eg out/Stock.csv and save
	 * the downloaded file to <code>localFile</code>. If
	 * <code>progressBar</code> true then it will print the progress bar of
	 * downloaded bytes eg 1024 of 20000 per line if deleteAfterDownload true
	 * then remote file will be deleted from the FTP after successfull download
	 * 
	 * @param client
	 *            FTPClient FTP client connection object
	 * @param remoteFilePath
	 *            String path of the remote file relative to the user home eg
	 *            out/Stock.csv
	 * @param localFile
	 *            java.io.File File to save the downloaded file
	 * @param progressBar
	 *            boolean true show download progress bar
	 * @param renameAfterDownload
	 *            boolean if true delete the remote file
	 * @return
	 * @throws Exception
	 */
	public static File downloadDirectory(final FTPClient client,
			final String remoteFilePath,final String remoteFileName, final File localFile,
			final boolean progressBar, boolean renameAfterDownload,String remoteArchivePath)
			throws Exception {
		
		try {

			FTPFile[] files = client.list(remoteFilePath);
			if (files == null || files.length == 0) {
				LOGGER.warn(" Remote File does not exist :: " + remoteFilePath);
				return null;
			}
			
			
			FTPFile downloadFile =  null;
			if (files != null && files.length > 0) {
				
				/*for (int i = 0; i < files.length; i++) {
									
					File currentFile = new File(localFile.getAbsolutePath()+"/"+files[i].getName());
					if(!currentFile.exists()) {
						currentFile.createNewFile();
					}
				}*/
				
				for (int i = 0; i < files.length; i++) {
					
					/*File currentFile = new File(localFile.getAbsolutePath()+"/"+files[i].getName());
					if(!currentFile.exists()) {
						currentFile.createNewFile();
					}*/
					int t = files[i].getType();
					String fileType = (t == FTPFile.TYPE_DIRECTORY) ? "Directory":"File"; 
					LOGGER.info(" REMOTE ::CWD = "+client.currentDirectory()+" "+files[i].getName() + " "+ files[i].getSize() + " "+ files[i].getModifiedDate()+" TYPE = "+fileType );
					if(files[i].getType() == FTPFile.TYPE_DIRECTORY)
						continue;
					if(remoteFileName != null && remoteFileName.trim().length() > 0 && files[i].getName().equalsIgnoreCase(remoteFileName)) {
						downloadFile = files[i];
						break;
					}else if(remoteFileName == null || remoteFileName.trim().length() == 0){
						downloadFile = files[i];
						break;
					}
					
				}
			}
			
			
			if(downloadFile == null)
			{
				LOGGER.warn(" Remote File does not exist :: " + remoteFilePath);
				return null;
			}
			
			final long fileSize = downloadFile.getSize();
			
			final long startTime = System.currentTimeMillis();

			FTPDataTransferListener listener = new FTPDataTransferListener() {
				private long totalTransferred = 0;

				private double lastPercentDone = 0f;

				private long lastPrintTime = System.currentTimeMillis();

				public void transferred(int paramInt) {
					totalTransferred += paramInt;
					double percentageDone = (totalTransferred * 100.00 / fileSize);
					if (System.currentTimeMillis() - lastPrintTime > 5000
							|| percentageDone - lastPercentDone > 1f) {
						long timeElapsed = (System.currentTimeMillis() - startTime);
						long speed = (totalTransferred * 1000 / (timeElapsed));
						LOGGER.info(" DOWNLOADING [" + remoteFilePath + "]  "
								+ String.format("%5.2f", percentageDone)+ " %,  " + timeElapsed / 1000 + " SECS, "
								+ speed + " BPS  :: " + totalTransferred+ " / " + fileSize);
						lastPrintTime = System.currentTimeMillis();
						lastPercentDone = percentageDone;
					}

					
				}

				public void started() {
					LOGGER.info("DOWNLOAD STARTED : " + ANMTimeZone.getDateInTimeZone());

				}

				public void failed() {
					LOGGER.info("DOWNLOAD FAILED : " + ANMTimeZone.getDateInTimeZone());

				}

				public void completed() {
					LOGGER.info("DOWNLOAD COMPLETED : " + ANMTimeZone.getDateInTimeZone());

				}

				public void aborted() {
					LOGGER.info("DOWNLOAD CANCELLED : " + ANMTimeZone.getDateInTimeZone());
				}
			};
			
			for (int i = 0; i < files.length; i++) {
				
				File currentFile = new File(localFile.getAbsolutePath()+"/"+files[i].getName());
				if(!currentFile.exists()) {
					currentFile.createNewFile();
				}
				String remotePath = remoteFilePath+"/"+files[i].getName();
				LOGGER.info("+ Downloading "+remotePath);
				
				client.download(remotePath, currentFile, listener);
			}
			
			
			//LOGGER.info("+ Remote File " + remotePath+ " Downloaded At " + localFile.getAbsolutePath()+ " Successfully SIZE ["+localFile.length()+"]");

			/*if (renameAfterDownload) {
				int j = remotePath.lastIndexOf('/');
				String fileName = remotePath.substring(j + 1) + "_"+ getCurrentTimestamp();
				if(remoteArchivePath == null)
					remoteArchivePath = "archived/";
				client.rename(remotePath, remoteArchivePath+"/"+fileName);
			}*/

			LOGGER.info("+ File Downloaded At "+ localFile.getAbsolutePath());
			

		} catch (IllegalStateException e) {

			LOGGER.info("Message :: "+e.toString() +" Cause :: "+e.getCause());
			throw e;
		} catch (IOException e) {

			LOGGER.info("Message :: "+e.toString() +" Cause :: "+e.getCause());
			throw e;
		} catch (FTPIllegalReplyException e) {

			LOGGER.info("Message :: "+e.toString() +" Cause :: "+e.getCause());
			throw e;
		} catch (FTPException e) {
			LOGGER.info("Message :: "+e.toString() +" Cause :: "+e.getCause());
			throw e;
		} catch (FTPDataTransferException e) {

			LOGGER.info("Message :: "+e.toString() +" Cause :: "+e.getCause());
			throw e;
		} catch (FTPAbortedException e) {

			LOGGER.info("Message :: "+e.toString() +" Cause :: "+e.getCause());
			throw e;
		} catch (FTPListParseException e) {

			throw e;
		}
		return localFile;
	}
	
	
	
	
	/**
	 * Download remote file <tt>remoteFilePath</tt> eg out/Stock.csv and save
	 * the downloaded file to <code>localFile</code>. If
	 * <code>progressBar</code> true then it will print the progress bar of
	 * downloaded bytes eg 1024 of 20000 per line if deleteAfterDownload true
	 * then remote file will be deleted from the FTP after successfull download
	 * 
	 * @param client
	 *            FTPClient FTP client connection object
	 * @param remoteFilePath
	 *            String path of the remote file relative to the user home eg
	 *            out/Stock.csv
	 * @param localFile
	 *            java.io.File File to save the downloaded file
	 * @param progressBar
	 *            boolean true show download progress bar
	 * @param renameAfterDownload
	 *            boolean if true delete the remote file
	 * @return
	 * @throws Exception
	 */
	public static long downloadWithCompression(final FTPClient client,
			final String remoteFilePath, final File localFile,
			final boolean progressBar, boolean renameAfterDownload)
			throws Exception {
		long size = 0;
		try {

			FTPFile[] files = client.list(remoteFilePath + ".gz");
			final boolean gz;
			if (files == null || files.length == 0) {
				gz = false;
				files = client.list(remoteFilePath);
				if (files == null || files.length == 0)
					throw new FTPException(404,
							" Remote File does not exist REMOTE PATH = " + remoteFilePath);
			} else {
				gz = true;
			}

			size = files[0].getSize();
			final long fileSize = size;
			if (files != null && files.length > 0) {
				for (int i = 0; i < files.length; i++) {
					LOGGER.info(files[i].getName() + " "+ files[i].getSize() + " "+ files[i].getModifiedDate());
				}
			}

			final long startTime = System.currentTimeMillis();

			FTPDataTransferListener listener = new FTPDataTransferListener() {
				private long totalTransferred = 0;

				private double lastPercentDone = 0f;

				private long lastPrintTime = System.currentTimeMillis();

				public void transferred(int paramInt) {
					totalTransferred += paramInt;
					double percentageDone = (totalTransferred * 100.00 / fileSize);
					if (System.currentTimeMillis() - lastPrintTime > 5000
							|| percentageDone - lastPercentDone > 1f) {
						long timeElapsed = (System.currentTimeMillis() - startTime);
						long speed = (totalTransferred * 1000 / (timeElapsed));
						LOGGER.info(" DOWNLOADING [" + remoteFilePath
								+ (gz ? ".gz" : "") + "]  "
								+ String.format("%5.2f", percentageDone)
								+ " %,  " + timeElapsed / 1000 + " SECS, "
								+ speed + " BPS  :: " + totalTransferred
								+ " / " + fileSize);
						lastPrintTime = System.currentTimeMillis();
						lastPercentDone = percentageDone;
					}

					
				}

				public void started() {
					LOGGER.info("DOWNLOAD STARTED : " + ANMTimeZone.getDateInTimeZone());

				}

				public void failed() {
					LOGGER.info("DOWNLOAD FAILED : " + ANMTimeZone.getDateInTimeZone());

				}

				public void completed() {
					LOGGER.info("DOWNLOAD COMPLETED : " + ANMTimeZone.getDateInTimeZone());

				}

				public void aborted() {
					LOGGER.info("DOWNLOAD CANCELLED : " + ANMTimeZone.getDateInTimeZone());

				}

			};

			String downloadFile = remoteFilePath;
			if (gz)
				downloadFile = remoteFilePath + ".gz";

			if (gz == true) {
				File savedGzipFile = new File(localFile.getParent(), localFile
						.getName()
						+ ".gz");
				client.download(downloadFile, savedGzipFile, listener);
				GZIPInputStream zipin = new GZIPInputStream(
						new FileInputStream(savedGzipFile));
				byte[] buffer = new byte[8192];
				// decompress the file
				FileOutputStream out = null;
				try {
					out = new FileOutputStream(localFile);
					int length;
					while ((length = zipin.read(buffer, 0, 8192)) != -1)
						out.write(buffer, 0, length);
					out.close();
					LOGGER.info(" Decompressed file ::"
							+ localFile.getAbsolutePath());
				} catch (IOException e) {
					LOGGER.info("Couldn't decompress "
							+ savedGzipFile.getAbsolutePath() + ".");
				}finally{
					try {
						if(out!=null){
							out.close();
						}
					} catch (IOException e) {
					}
					
					try {
						if(zipin!=null){
							zipin.close();
						}
					} catch (IOException e) {
					}
				}

				savedGzipFile.delete();
			} else {
				client.download(downloadFile, localFile, listener);
			}

			if (renameAfterDownload) {
				int j = downloadFile.indexOf('/');
				String fileName = downloadFile.substring(j + 1) + "_"
						+ getCurrentTimestamp();
				client.rename(downloadFile, fileName);
			}

			LOGGER.info("+ File Downloaded At "
					+ localFile.getAbsolutePath());
			

		} catch (IllegalStateException e) {

			LOGGER.info("Message :: "+e.toString() +" Cause :: "+e.getCause());
			throw e;
		} catch (IOException e) {

			LOGGER.info("Message :: "+e.toString() +" Cause :: "+e.getCause());
			throw e;
		} catch (FTPIllegalReplyException e) {

			LOGGER.info("Message :: "+e.toString() +" Cause :: "+e.getCause());
			throw e;
		} catch (FTPException e) {
			LOGGER.info("Message :: "+e.toString() +" Cause :: "+e.getCause());
			throw e;
		} catch (FTPDataTransferException e) {

			LOGGER.info("Message :: "+e.toString() +" Cause :: "+e.getCause());
			throw e;
		} catch (FTPAbortedException e) {

			LOGGER.info("Message :: "+e.toString() +" Cause :: "+e.getCause());
			throw e;
		} catch (FTPListParseException e) {

			throw e;
		}
		return size;
	}


	private static final SimpleDateFormat FORMATTER = new SimpleDateFormat(
			"yyyyMMdd_hhmmss_SSS");

	public static String getCurrentTimestamp() {
		return FORMATTER.format(ANMTimeZone.getDateInTimeZone());
	}

	/**
	 * 
	 * @param localFile
	 * @param remoteFile
	 * @param remotePath
	 * @param archivePath
	 * @param shortFileName
	 * @param sourcePath
	 * @return
	 */
	/*
	 * public static boolean downloadFile(String localFile,String
	 * remoteFile,String remotePath,String archivePath,String
	 * shortFileName,String localPath) { //remotePath+"/"+remoteFile ->
	 * localPath+"/"+localFile // remotePath+"/"+remoteFile ->
	 * archivePath+"/"+remoteFile_Timestamp.suffix
	 *  }
	 */
	
	/**
	 * Uplaod local file <tt>localFilePath/localFileName</tt> eg out/Stock.csv to remote server at location <code>remoteDirName</code>. If <code>progressBar</code>
	 *  true then it will print the progress bar of downloaded bytes eg 1024 of 20000 per line
	 * 
	 * @param client FTPClient FTP client connection object
	 * @param remoteFilePath String path of the remote file relative to the user home eg out/Stock.csv
	 * @param localFilePath String path of local file
	 * @param localFileName String name of local file
	 * @param progressBar boolean true show download progress bar
	 * @return
	 * @throws Exception 
	 */
	public static long upload(FTPClient client, String localFilePath, String localFileName, String remoteDirName, final boolean progressBar) throws Exception{
		long size = 0;
		final long fileSize = size;	// TODO: get the size of file to be downloaded
		
		try {
			final long startTime = System.currentTimeMillis();
			
			client.changeDirectory(remoteDirName);
			File fileToUpload = new File(localFileName);
			if(!fileToUpload.exists())
				fileToUpload = new java.io.File(localFilePath,localFileName);
			new java.io.File(localFilePath,localFileName);
			client.upload(fileToUpload,new FTPDataTransferListener() {
				private long totalTransferred = 0;
				public void transferred(int paramInt) {
					totalTransferred += paramInt;
					if(progressBar)
					  LOGGER.info(" "+totalTransferred+" of "+fileSize+ " "+(totalTransferred*1000/(System.currentTimeMillis()-startTime)+" BPS"));
			
				}
			
				public void started() {
					LOGGER.info("UPLOAD STARTED : "+ANMTimeZone.getDateInTimeZone());
			
				}
			
				public void failed() {
					LOGGER.info("UPLOAD FAILED : "+ANMTimeZone.getDateInTimeZone());
			
				}
			
				public void completed() {
					LOGGER.info("UPLOAD COMPLETED : "+ANMTimeZone.getDateInTimeZone());
			
				}
			
				public void aborted() {
					LOGGER.info("UPLOAD CANCELLED : "+ANMTimeZone.getDateInTimeZone());
			
				}
			
			});
			LOGGER.info(localFileName+" File Uploaded Successfully.");
			//client.upload(new java.io.File("localFile.ext"), new MyTransferListener());
			//client.download("Stock.csv", os, paramLong, paramFTPDataTransferListener)
			
		} catch (IllegalStateException e) {
			
			LOGGER.info("Message :: "+e.toString() +" Cause :: "+e.getCause());
			LOGGER.info("Message :: "+e.toString() +" Cause :: "+e.getCause());
		} catch (IOException e) {
		
			LOGGER.info("Message :: "+e.toString() +" Cause :: "+e.getCause());
			LOGGER.info("Message :: "+e.toString() +" Cause :: "+e.getCause());
		} catch (FTPIllegalReplyException e) {
			
			LOGGER.info("Message :: "+e.toString() +" Cause :: "+e.getCause());
			LOGGER.info("Message :: "+e.toString() +" Cause :: "+e.getCause());
		} catch (FTPException e) {
			LOGGER.info("Message :: "+e.toString() +" Cause :: "+e.getCause());
			throw e;
		} catch (FTPDataTransferException e) {
			
			LOGGER.info("Message :: "+e.toString() +" Cause :: "+e.getCause());
			throw e;
		} catch (FTPAbortedException e) {
			
			LOGGER.info("Message :: "+e.toString() +" Cause :: "+e.getCause());
			throw e;
		}
		return size;
	}
	
	
	public static void main(String[] args) {
		// Configuration parameters which need to go in configuration file
		String ftpIp = "192.168.57.50";
		int ftpPort = 22;
		String userId = "pramod";
		String password = "pramod@007";
		String localFilePath = "/data/dev/WildFly/standalone/deployments/index.html";
		// String remoteFilePath = "out"+"/"+"Stock.csv";
		String remoteFilePath = "/home/pramod" + "/" + "index.html";
		boolean renameDownloadedFile = true;
		boolean verbose = true;
		boolean progressBar = true;

		FTPClient client;
		try {
			client = connectToFTP(ftpIp, ftpPort, userId, password, verbose);
		} catch (Exception e) {
			LOGGER.info("Message :: "+e.toString() +" Cause :: "+e.getCause());
			LOGGER.info("Exit : Error in FTP Connection <"
					+ e.getMessage() + ">");
			return;
		}

		try {
			File downloadedFile = new File(localFilePath);
			downloadedFile = download(client, "out/cashreciept1",null, downloadedFile, progressBar, renameDownloadedFile,null,"N");
			LOGGER.info("+ Remote File " + remoteFilePath+ " Downloaded At " + localFilePath + " Successfully ");
		} catch (Exception e1) {
			LOGGER.error(e1.getStackTrace());
		}

		try {
			client.disconnect(true);
		} catch (Exception e) {
			LOGGER.info("Message :: "+e.toString() +" Cause :: "+e.getCause());
		}
	}
	
	/**
	 * 
	 * @param ftpClient
	 * @author pramod
	 * @return
	 */
	public static boolean isFileExist(final FTPClient client,
			final String remoteFilePath)
			throws Exception {
		try {
			FTPFile[] files = client.list(remoteFilePath);
			if (files == null || files.length == 0) {
				LOGGER.warn(" Remote File does not exist :: " + remoteFilePath);
				return false;
			}else{
				return true;
			}
		} catch (IllegalStateException e) {
			LOGGER.info("Message :: "+e.toString() +" Cause :: "+e.getCause());
			throw e;
		} catch (IOException e) {
			LOGGER.info("Message :: "+e.toString() +" Cause :: "+e.getCause());
			throw e;
		} catch (FTPIllegalReplyException e) {
			LOGGER.info("Message :: "+e.toString() +" Cause :: "+e.getCause());
			throw e;
		} catch (FTPException e) {
			LOGGER.info("Message :: "+e.toString() +" Cause :: "+e.getCause());
			throw e;
		} catch (FTPDataTransferException e) {
			LOGGER.info("Message :: "+e.toString() +" Cause :: "+e.getCause());
			throw e;
		} catch (FTPAbortedException e) {
			LOGGER.info("Message :: "+e.toString() +" Cause :: "+e.getCause());
			throw e;
		} catch (FTPListParseException e) {
			throw e;
		}
	}
	
	/**
	 * 
	 * @param ftpClient
	 * @author pramod
	 * @return
	 */
	public static boolean makeDirectories(FTPClient ftpClient, String dirPath)
            throws IOException {
		String[] pathElements = dirPath.split("/");
        if (changeToRootDirectory(ftpClient) && pathElements != null && pathElements.length > 0) {
            for (String singleDir : pathElements) {
            	if(OctashopUtils.isEmpty(singleDir)){
            		continue;
            	}
                boolean existed = changeDirectory(ftpClient,singleDir);
                if (!existed) {
                    boolean created = false; 
                    try {
						ftpClient.createDirectory(singleDir);
						created = true;
					} catch (IllegalStateException | FTPIllegalReplyException
							| FTPException e) {
						
						//LOGGER.error(e.getStackTrace());
						LOGGER.info("Failed to create directory: " + singleDir + e.toString());
					}
                    if(created) {
                    	LOGGER.info("CREATED directory: " + singleDir);
                        changeDirectory(ftpClient,singleDir);
                    } else {
                    	LOGGER.info("COULD NOT create directory: " + singleDir);
                        return false;
                    }
                }
            }
        }
        return true;
    }
	
	/**
	 * 
	 * @param ftpClient
	 * @author pramod
	 * @return
	 */
	public static boolean changeDirectory(FTPClient ftpClient, String singleDir){
		boolean isChanged = false;
		try {
			ftpClient.changeDirectory(singleDir);
			isChanged = true;
		} catch (IllegalStateException e) {
			
			
		} catch (IOException e) {
			
			
		} catch (FTPIllegalReplyException e) {
			
			
		} catch (FTPException e) {
			
			
		}
        return isChanged;
    }
	/**
	 * 
	 * @param ftpClient
	 * @author pramod
	 * @return
	 */
	public static boolean changeToRootDirectory(FTPClient ftpClient){
		boolean isChanged = false;
		try {
			String dir = ftpClient.currentDirectory(); 
			while (!"/".equals(dir)) {
			 ftpClient.changeDirectoryUp();
			 dir = ftpClient.currentDirectory();
			}
			isChanged = true;
		} catch (IllegalStateException e) {
			
			
		} catch (IOException e) {
			
			
		} catch (FTPIllegalReplyException e) {
			
			
		} catch (FTPException e) {
			
			
		}
        return isChanged;
    }
	
	/*public static FTPClient getDAMFtpClient(){
		FTPClient ftpClient =  null;
		try {
			boolean isFTPEnable = Boolean.parseBoolean(configuration.getProperty("dam.ftp.enable"));
			String ip = configuration.getProperty("dam.ftp.ip");
			int port= Integer.valueOf(configuration.getProperty("dam.ftp.port"));
			boolean verbose=Boolean.valueOf(configuration.getProperty("dam.ftp.verbose"));
			String user = configuration.getProperty("dam.ftp.user");
			String password= configuration.getProperty("dam.ftp.password");
			LOGGER.info("ip :: "+ip+" port :: "+port+" user ::"+user+" isFTPEnable :: "+isFTPEnable);
			if(isFTPEnable){
				ftpClient=connectToFTP(ip, port, user, password, verbose);
			}
			LOGGER.info("ftpClient "+ftpClient.getPort() );
		}catch (Exception e) {
			// TODO: handle exceptionftpClient
			ftpClient = null;
		}
		return ftpClient;
	}*/
	
	/*public static void copyFileToFtpServer(FTPClient client, String srcPath, String destPath) throws Exception{
		try {
				//Copy File on static server from one location to another via FTP
				String localFilePath = FileUtils.getTempDirectoryPath()+"/"+ srcPath.substring(srcPath.lastIndexOf('/') + 1);
				File currentFile = new File(localFilePath);
				if(currentFile.exists()) {
					String currentTimeStamp = FTPUtils.getCurrentTimestamp();
					localFilePath = localFilePath+"_"+currentTimeStamp;
				}
				File localFile = new File(localFilePath);
				client.download(srcPath, localFile);
				uploadFileToFtp(client, localFilePath, destPath);
		} catch (Exception e) {
			
			throw e;
		}
	}*/
	
	public static void uploadFileToFtp(FTPClient client, String localFilePath,String remoteFilePath) {
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
	
	public static boolean uploadTOSFtp(String SFTPUSER,String SFTPPASS,String SFTPHOST,int SFTPPORT,String SFTPWORKINGDIR, String FILETOTRANSFER ) {
        Session     session     = null;
        Channel     channel     = null;
        ChannelSftp channelSftp = null;
        LOGGER.info("SFTP Connection starting");
        boolean isUploaded = false;
        FileInputStream fileInputStream = null;
        try{
                    JSch jsch = new JSch();
                    session = jsch.getSession(SFTPUSER,SFTPHOST,SFTPPORT);
                    session.setPassword(SFTPPASS);
                   // session.setTimeout(60*1000); //60 seconds timeout
                    java.util.Properties config = new java.util.Properties();
                    config.put("StrictHostKeyChecking", "no");
                    session.setConfig(config);
                    session.setDaemonThread(true);
                    session.connect();
                    channel = session.openChannel("sftp");
                    channel.connect();
                    LOGGER.info("Connected...");
                    channelSftp = (ChannelSftp)channel;
                    channelSftp.cd(SFTPWORKINGDIR);
                    File f = new File(FILETOTRANSFER);
                    fileInputStream = new FileInputStream(f);
                    channelSftp.put(fileInputStream, f.getName());
                    isUploaded = true;
        }catch(JSchException jschX){
            LOGGER.error(jschX.getMessage());
         }catch(Exception ex){
        	 LOGGER.error(ex.getStackTrace());
        }finally{
        	try{
        		FTPUtils.closeSFTPConnection(channelSftp);
        	}catch(Exception e){
        		LOGGER.info("FTPUtils.closeSFTPConnection(channelSftp) calling but not closed on productactionbean class.",e);
        	}
        	if(channelSftp != null && channelSftp.isConnected()){
        		channelSftp.disconnect();
        		session.disconnect();
        	}
        	if (fileInputStream != null) {
        		try {
        			fileInputStream.close();
        		} catch (Exception e) {
        			LOGGER.error("Message :: "+e.toString() +" Cause :: "+e.getCause());
        		}
        	}
        }
        return isUploaded;
	}
	
	public static void closeSFTPConnection(ChannelSftp channelSftp ){
		try {
			if(channelSftp != null && channelSftp.isConnected()){
	    		channelSftp.exit();
	    		channelSftp.getSession().disconnect();
	    	}
		} catch (Exception e) {
			LOGGER.error("Failed in closing SFTP Connection ", e);
		}
		
	}
	
	public static ChannelSftp getSFTPChannel(final String SFTPUSER,final String SFTPHOST,final int SFTPPORT,final String SFTPPASS) throws Exception {
        Session     session     = null;
        Channel     channel     = null;
        ChannelSftp channelSftp = null;
        LOGGER.info("SFTP Connection starting");
        try{
                    JSch jsch = new JSch();
                    session = jsch.getSession(SFTPUSER,SFTPHOST,SFTPPORT);
                    session.setPassword(SFTPPASS);
                    //session.setTimeout(60*1000); //60 seconds idle will generate timeout exception
                    java.util.Properties config = new java.util.Properties();
                    config.put("StrictHostKeyChecking", "no");
                    session.setConfig(config);
                    session.setDaemonThread(true);
                    session.connect();
                    channel = session.openChannel("sftp");
                    
                    channel.connect();
                    LOGGER.info("Connected... daemon=true");
                    channelSftp = (ChannelSftp)channel;
                    
        }catch(JSchException jschX){
            LOGGER.error(jschX.getMessage());
         }catch(Exception ex){
        	 LOGGER.error(ex.getStackTrace());
        }
        return channelSftp;
	}
	
	public static ChannelSftp getProxySFTPChannel(final String SFTPUSER,final String SFTPHOST,final int SFTPPORT,final String SFTPPASS,final String ProxyHOST,final int ProxyPORT) throws Exception {
        Session     session     = null;
        Channel     channel     = null;
        ChannelSftp channelSftp = null;
        LOGGER.info("SFTP Connection starting");
        try{
                    JSch jsch = new JSch();
                    session = jsch.getSession(SFTPUSER,SFTPHOST,SFTPPORT);
                    session.setPassword(SFTPPASS);
                    session.setProxy(new ProxyHTTP(ProxyHOST, ProxyPORT));
                    java.util.Properties config = new java.util.Properties();
                    config.put("StrictHostKeyChecking", "no");
                    session.setConfig(config);
                    session.setDaemonThread(true);
                    session.connect();
                    
                    channel = session.openChannel("sftp");
                    channel.connect();
                    
                    channel.getSession();
                    LOGGER.info("Connected...");
                    channelSftp = (ChannelSftp)channel;
                    
        }catch(JSchException jschX){
            LOGGER.error(jschX.getMessage());
         }catch(Exception ex){
        	 LOGGER.error(ex.getStackTrace());
        }
        return channelSftp;
	}
	
	public static boolean isFileExistOnSFTP(final ChannelSftp channelSftp,final String remoteFilePath) throws Exception {
		boolean isExist = false;
		SftpATTRS attrs = null;
		try {
			attrs = channelSftp.stat(remoteFilePath);
			isExist = true;
		} catch (Exception e) {
			LOGGER.info("Message :: "+e.toString() +" Cause :: "+e.getCause());
			throw e;
		}
		return isExist;
	}
	
	/**
	 * 
	 * @param ftpClient
	 * @author pramod
	 * @return
	 */
	public static boolean makeDirectories(ChannelSftp channelSftp, String dirPath) {
		boolean isCreated = false;
		try {
			//String currentDirectory = channelSftp.pwd();
			SftpATTRS attrs=null;
			try {
			    attrs = channelSftp.stat(dirPath);
			} catch (Exception e) {
			    System.out.println(dirPath+" not found");
			}

			if (attrs != null) {
			    System.out.println("Directory exists IsDir="+attrs.isDir());
			} else {
			    System.out.println("Creating dir "+dirPath);
			    channelSftp.mkdir(dirPath);
			}
		} catch (SftpException e) {
			LOGGER.info("Message :: "+e.toString() +" Cause :: "+e.getCause());
		}finally{
			if(channelSftp != null){
				channelSftp.disconnect();
				try {
					channelSftp.getSession().disconnect();
				} catch (JSchException e) {
					
					LOGGER.error(e.getStackTrace());
				}
			}
		}
		return isCreated;
	}
	
	 public static void downloadFileFromFtp(ChannelSftp channelSftp,String SFTPWORKINGDIR,String localPath) throws SftpException {

            try {
	            Vector<?> filelist = channelSftp.ls(SFTPWORKINGDIR);
	            for(int i=0; i<filelist.size();i++){
	            	LOGGER.info(filelist.get(i).toString());
	                ChannelSftp.LsEntry ls = (ChannelSftp.LsEntry) filelist.get(i);
	                LOGGER.info("File Name: " + ls.getFilename());
	                String filename = ls.getFilename();
	                if(filename.endsWith(".xml")||filename.endsWith(".XML")){
		                File file = new File(FTPUtils.normalizeLocation(localPath) + filename);
		                if(!file.exists()){
		                	file.createNewFile();
		                }
		                /*
		                 * file downloaded from sftp 
		                 */
		                download(SFTPWORKINGDIR,filename,localPath+filename,channelSftp);
		                
		                if(file.length() == 0){
		                	/*
			                 * file moved to rejected folder on sftp for file size 0 byte 
			                 */
		                	uploadFile(channelSftp,localPath+filename,SFTPWORKINGDIR+"/rejected");
		                	/*
		                	 * Delete file from local folder for file size 0 byte 
		                	 */
		                	file.renameTo(new File(localPath+"/rejected/"+filename+".xml"));
		                	
		                }
		                /*
		                 * remove file after downloaded from sftp 
		                 */
		                channelSftp.rm(SFTPWORKINGDIR+"/"+filename);
		            }
	            }
	            LOGGER.info("File Successfully Downloaded");
	            channelSftp.exit();
	            //sftpChannel.exit();
	            //session.disconnect();
	            LOGGER.info("All connections successfully closed");
	        }
	        catch (SftpException e) {
	        	 LOGGER.error(e.getStackTrace());
	        }
	        catch (Exception e) {
	        	 LOGGER.error(e.getStackTrace());
	        }
	    }
	 	/**
		 * 
		 * @param ftpClient
		 * @author ranjit
		 * @return
	     * Download the file * @param directory * @param downloadFile download directory file download * @param saveFile local path * @param sftp 
	     */  
	    public static void download(String directory, String downloadFile, String saveFile, ChannelSftp sftp) {  
	        try {  
	        	sftp.cd("/");
	            sftp.cd(directory);  
	            File file = new File(saveFile);  
	            FileOutputStream fileOutputStream =new FileOutputStream(file);  
	            sftp.get(downloadFile, fileOutputStream );  
	            fileOutputStream.close();  
	            fileOutputStream=null;  
	            file =null;  
	        } catch (Exception e) {  
	        	 LOGGER.error(e.getStackTrace());
	        }
	    }
	    public static boolean uploadFile(ChannelSftp channelSftp,String uploadFileOrFolder,String changeDirectory) throws SftpException {
	    	boolean fileUploadedFlag = false;
	            try {
		            channelSftp.cd("/");
		            channelSftp.cd(changeDirectory);
		            fileUploadedFlag = uploadSingleFileToSftp(uploadFileOrFolder,channelSftp);
		            LOGGER.info("File Successfully Uploaded uploadFileOrFolder : "+uploadFileOrFolder+" SFTP Directory: "+changeDirectory);
		            return fileUploadedFlag;
	        }
	        catch (SftpException e) {
	        	 LOGGER.error(e.getStackTrace());
	            return false;
	        }
	        catch (Exception e) {
	        	 LOGGER.error(e.getStackTrace());
	            return false;
	        }
	    }
	    /** 
		 * @param ftpClient
		 * @author ranjit
		 * @return
	     */  
	    public static boolean uploadSingleFileToSftp(String FILETOTRANSFER,ChannelSftp sftp) {  
	        boolean fileUploadedFlag = false;
	        FileInputStream fileInputStream = null;
	    	try {  
	            File f = new File(FILETOTRANSFER);
	           // sftp.lcd(FILETOTRANSFER);
	            fileInputStream = new FileInputStream(f);
				sftp.put(fileInputStream, f.getName()); 
	            return true;
	        } catch (Exception e) {  
	        	 LOGGER.error(e.getStackTrace());
	            return fileUploadedFlag;
	        } finally {
	        	if (fileInputStream != null) {
	        		try {
	        			fileInputStream.close();
	        		} catch (Exception e) {
	        			LOGGER.error("Message :: "+e.toString() +" Cause :: "+e.getCause());
	        		}
	        	}
	        }
	    }
	    
	    /** 
		 * @param ftpClient
		 * @author ranjit
		 * @return
	     */  
	    public static void uploadFolderToSftp(String FILETOTRANSFER,ChannelSftp sftp) {  
	        try {  
	            File f = new File(FILETOTRANSFER);
	            sftp.lcd(FILETOTRANSFER);
	        } catch (Exception e) {  
	        	 LOGGER.error(e.getStackTrace());
	        }  
	    }
	    
	    public static String normalizeLocation(String location) {  
	        try {  
	            if(!OctashopUtils.isEmpty(location)){
	            	if(!location.trim().endsWith("/")){
	            		location = location.trim() + "/";
	            	}
	            }
	        } catch (Exception e) {  
	        	 LOGGER.error(e.getStackTrace());  
	        }
	        return location;
	    }

		public static void closeChannel(ChannelSftp channel) {
			if(channel != null) {
				try {
					LOGGER.info("[MEENA] closeChannel : FTP Leak Fix : closing channel ...");
					Session session = channel.getSession();
					channel.exit();
					session.disconnect();
					LOGGER.info("[MEENA] closeChannel: FTP Leak Fix : successfully closed");
				}catch(Exception e) {
					LOGGER.warn("[MEENA] closeChannel: Exception [Ignore] "+e.getMessage());
				}
			}
			
			
		}
		 /**
		 * 
		 * @param ftpClient
		 * @author ranjit
		 * @return
		 */
		 public static ArrayList<File> downloadCsvFile(ChannelSftp channelSftp,String SFTPWORKINGDIR,String localPath) throws SftpException {

	            try {
	            	ArrayList<File> files = new ArrayList<File>();
	            	channelSftp.cd("/");
	            	channelSftp.cd(SFTPWORKINGDIR);
	            	//Vector<ChannelSftp.LsEntry> list = channelSftp.ls("*.csv");
	            	Vector<ChannelSftp.LsEntry> list = channelSftp.ls(SFTPWORKINGDIR);
	            	if(list != null && !list.isEmpty()){
	            	for(ChannelSftp.LsEntry entry : list) {
	            		String filename = entry.getFilename();
	            		if(filename.endsWith(".csv")||filename.endsWith(".CSV")){
		            		LOGGER.info(localPath + "/" + entry.getFilename());
		            	    File file = new File(localPath + "/" + entry.getFilename());
		            	    if(!new File(localPath).isDirectory()){
		            	    	FileUtils.forceMkdir(new File(localPath));
		            	    	//OctashopUtils.makeDirectories(localPath);
							}
	
		            	    if(!file.exists()){
			                	file.createNewFile();
			                }
			                channelSftp.get(entry.getFilename(), localPath + entry.getFilename());
			                files.add(file);
			                try{
			                	FTPUtils.download(SFTPWORKINGDIR,entry.getFilename(),localPath +"/"+ entry.getFilename(),channelSftp);
			                	if(file.length() == 0){
			                		/*
					                 * file moved to rejected folder on sftp for file size 0 byte 
					                 */
			                		FTPUtils.uploadFile(channelSftp,localPath+entry.getFilename(),SFTPWORKINGDIR+"/rejected");
				                	/*
				                	 * Delete file from local folder for file size 0 byte 
				                	 */
				                	file.renameTo(new File(localPath+"/rejected/"+entry.getFilename()));
			                	}
			                }catch(Exception e){
			                	LOGGER.info("File doesn't Downloaded ::: "+ localPath +"/"+ entry.getFilename() + ":::::::   ",e);
			                }
			                channelSftp.rm(SFTPWORKINGDIR+"/"+entry.getFilename());
		            	}
	            	}
		            LOGGER.info("File Successfully Downloaded");
		          
		            	return files;
	            	}else{
	            		LOGGER.info("No Any Files are there");
	            		return null;
	            	}
		        }
		        catch (SftpException e) {
		        	 LOGGER.error(e.getStackTrace());
		            return null;
		        }
		        catch (Exception e) {
		        	 LOGGER.error(e.getStackTrace());
		            return null;
		        }finally {
		        	FTPUtils.closeChannel(channelSftp);
		        }
		    }
		 
		 /**
			 * 
			 * @param ftpClient
			 * @author ranjit
			 * @return
			 */
			 public static ArrayList<File> downloadFile(ChannelSftp channelSftp,String SFTPWORKINGDIR,String localPath) throws SftpException {

		            try {
			           /* String SFTPWORKINGDIR = "100001/inward/invoice/";
			            * localPath = "/data/xmlfile/"
			            * */
		            	ArrayList<File> files = new ArrayList<File>();
			            Vector filelist = channelSftp.ls(SFTPWORKINGDIR);
			            for(int i=0; i<filelist.size();i++){
			                System.out.println(filelist.get(i).toString());
			                String filename = filelist.get(i).toString().trim();
			                
			                if(filename.endsWith(".xml")||filename.endsWith(".XML")){
				                File file = new File(localPath + filelist.get(i).toString());
				               
				                if(!file.exists()){
				                	file.createNewFile();
				                	files.add(file);
				                }
				                FTPUtils.download(SFTPWORKINGDIR,filelist.get(i).toString(),localPath + filelist.get(i).toString(),channelSftp);
				            }
			            }
			            LOGGER.info("+ File Successfully Downloaded");
			            return files;
			        }
			        catch (SftpException e) {
			        	 LOGGER.error(e.getStackTrace());
			            return null;
			        }
			        catch (Exception e) {
			        	 LOGGER.error(e.getStackTrace());
			            return null;
			        }finally {
			        	FTPUtils.closeSFTPConnection(channelSftp);
			        }
			    }
			 
			 /*
			  * @local system
			  * Delete file from local folder or all file delete from folder
			  */
			 public void deleteFileFromLocal(String localPath){
					try{
						File folder = new File(localPath);
						if(folder.isDirectory()){
							File[] listOfFiles = folder.listFiles();
							
							for(int i = 0; i < listOfFiles.length; i++){
								String filename = listOfFiles[i].getName();
								 if(filename.endsWith(".xml")||filename.endsWith(".XML") || filename.endsWith(".csv")||filename.endsWith(".CSV") || filename.endsWith(".pdf")||filename.endsWith(".PDF")){
									 File fileDelete = new File(localPath+"/"+filename);
									 fileDelete.delete();
								 }
							}
						}else if(folder.isFile()){
							 File fileDelete = new File(localPath);
							 fileDelete.delete();
						}
					}catch(Exception e){
						 LOGGER.error(e.getStackTrace());
					}
					
					
				}
			 
			 /*
			  * @sftp system
			  * Delete file from SFTP remote folder or all file delete from folder
			  */
			 public static void deleteFileFromSftp(ChannelSftp channelSftp,String remoteFilePath,String serverFilePathTemp){
					try{
						channelSftp.cd("/");
						channelSftp.cd(serverFilePathTemp);
			        	Vector<ChannelSftp.LsEntry> list = channelSftp.ls("*.*");
			        	for(ChannelSftp.LsEntry entry : list) {
			        		 String filename = entry.getFilename();
			        		 if(filename.endsWith(".xml")||filename.endsWith(".XML") || filename.endsWith(".csv")||filename.endsWith(".CSV"))
								 channelSftp.rm(filename);
			        	}
					}catch(SftpException e){
						LOGGER.error("Deleteing falid "+e);
					}
				}
			 
			 public static void deleteFolder(File source){
					if (source.isDirectory()){
						String files[] = source.list();
				        for (String file : files){
				        	 if(file.toLowerCase().endsWith(".xml") || file.toLowerCase().endsWith(".csv")){
					            File srcFile = new File(source, file);
					            srcFile.deleteOnExit();
				        	 }
				        }
				    }else{
				    	source.deleteOnExit();
				    }
				}
			 
			 public static void copyFolder(File source, File destination){
				    try {
				    	if (source.isDirectory()){
					        FileUtils.forceMkdir(destination);
					        String files[] = source.list();
					        for (String file : files){
					        	 if(file.toLowerCase().endsWith(".xml") || file.toLowerCase().endsWith(".csv")){
						            File srcFile = new File(source, file);
						            File destFile = new File(destination, file);
						            copyFolder(srcFile, destFile);
					        	 }
					        }
					    }
					} catch (Exception e) {
						 LOGGER.error(e.getStackTrace());
					}
				}
			 
			 public static File createFile(String localpath,String strContent){
		    	 BufferedWriter bufferedWriter = null;
		    	 File myFile = new File(localpath);
		         try {
		             // check if file exist, otherwise create the file before writing
		             if (!myFile.exists()) {
		                 myFile.createNewFile();
		             }
		             Writer writer = new FileWriter(myFile);
		             bufferedWriter = new BufferedWriter(writer);
		             bufferedWriter.write(strContent);
		         } catch (IOException e) {
		        	 LOGGER.error(e.getStackTrace());
		         } finally{
		             try{
		                 if(bufferedWriter != null) bufferedWriter.close();
		             } catch(Exception ex){
		                  
		             }
		         }
		    	return myFile;
		    }
			 
			 public static String jaxbObjectToXML(JAXBContext jaxbContext,Object object) {
			        String xmlString = "";
			        try {
			            Marshaller m = jaxbContext.createMarshaller();

	m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE); // To format XML

			            StringWriter sw = new StringWriter();	         
			            m.marshal(object, sw);
			            xmlString = sw.toString();

			        } catch (JAXBException e) {
			             LOGGER.error(e.getStackTrace());
			        }

			        return xmlString;
			    }
			 
			 public static ChannelSftp channelSftpCon(ChannelSftp channelSftp){
					try{
					if(!channelSftp.isConnected())
						channelSftp.connect();
					}catch(Exception e){
						OctashopUtils.printExceptionMsgNCause(LOGGER, e);
					}
					return channelSftp;
				}
			 
			 public static ArrayList<File> downloadCsvFile(FTPClient client,String SFTPWORKINGDIR,String localPath,String isFileToBeDeleted) throws SftpException {
				 	
				 	ArrayList<File> files = new ArrayList<File>();
				 	boolean progressBar = true;
				 	boolean renameDownloadedFile = false;
				 	String remoteFilePath = "";
				 	File downloadedFile = new File(localPath);
				 	
				 	try {
						FTPFile[] file = client.list(SFTPWORKINGDIR);
						if (file == null || file.length == 0) {
							LOGGER.warn(" Remote File does not exist :: " + remoteFilePath);
							return null;
						}
						
						if (file != null && file.length > 0) {
							for (int i = 0; i < file.length; i++) {
								String filename=file[i].getName();
								if("csv".equalsIgnoreCase(FilenameUtils.getExtension(filename))){
									File f = new File(localPath + "/" + filename);
				            	    if(!new File(localPath).isDirectory()){
				            	    	FileUtils.forceMkdir(new File(localPath));
									}

				            	    if(!f.exists()){
					                	f.createNewFile();
					                }
				            	    files.add(f);
				            	    
				            	    try {
										downloadedFile = FTPUtils.download(client,SFTPWORKINGDIR,filename, f, progressBar, renameDownloadedFile,null,isFileToBeDeleted);
										LOGGER.info("+ Remote File " + remoteFilePath+ " Downloaded At " + localPath + " Successfully file name:: "+filename);
									} catch (Exception e) {
										 LOGGER.error(e.getStackTrace());
									}
								}
							}
						}
						
					} catch (IllegalStateException e1) {
						LOGGER.info("Message :: "+e1.toString() +" Cause :: "+e1.getCause());
						throw e1;
					} catch (IOException e1) {
						LOGGER.error(e1.getStackTrace());
					} catch (FTPIllegalReplyException e1) {
						LOGGER.error(e1.getStackTrace());
					} catch (FTPException e1) {
						LOGGER.error(e1.getStackTrace());
					} catch (FTPDataTransferException e1) {
						LOGGER.error(e1.getStackTrace());
					} catch (FTPAbortedException e1) {
						LOGGER.error(e1.getStackTrace());
					} catch (FTPListParseException e1) {
						LOGGER.error(e1.getStackTrace());
					}
				 	return files;
			   }
			 
			 public static FTPClient channelFtpCon(FTPClient clientFtp,String ip,int port){
					try{
					if(!clientFtp.isConnected())
						clientFtp.connect(ip,port);
					}catch(Exception e){
						OctashopUtils.printExceptionMsgNCause(LOGGER, e);
					}
					return clientFtp;
				}
			 //@parag Start
			 public static List<String> getAllFileNamesFromLocal(String localPath,String patternName){
				 List<String> filesName = new ArrayList<>();
				 try{
						File folder = new File(localPath);
						if(folder.isDirectory()){
							File[] listOfFiles = folder.listFiles();
							
							for(int i = 0; i < listOfFiles.length; i++){
								String filename = listOfFiles[i].getName();
								if(!OctashopUtils.isEmpty(patternName) && filename.contains(patternName)/*(patternName, 0)*/){
									filesName.add(filename);
								}
							}
						}
					}catch(Exception e){
						 LOGGER.error(e.getStackTrace());
					}
					
					return filesName;
				}	
			 public static ArrayList<File> downloadTextFile(ChannelSftp channelSftp,String SFTPWORKINGDIR,String localPath) throws SftpException {

		            try {
		            	ArrayList<File> files = new ArrayList<File>();
		            	channelSftp.cd("/");
		            	channelSftp.cd(SFTPWORKINGDIR);
		            	//Vector<ChannelSftp.LsEntry> list = channelSftp.ls("*.csv");
		            	Vector<ChannelSftp.LsEntry> list = channelSftp.ls(SFTPWORKINGDIR);
		            	if(list != null && !list.isEmpty()){
		            	for(ChannelSftp.LsEntry entry : list) {
		            		String filename = entry.getFilename();
		            		if(filename.endsWith(".txt")||filename.endsWith(".TXT")){
			            		LOGGER.info(localPath + "/" + entry.getFilename());
			            	    File file = new File(localPath + "/" + entry.getFilename());
			            	    if(!new File(localPath).isDirectory()){
			            	    	FileUtils.forceMkdir(new File(localPath));
			            	    	//OctashopUtils.makeDirectories(localPath);
								}
		
			            	    if(!file.exists()){
				                	file.createNewFile();
				                }
				                channelSftp.get(entry.getFilename(), localPath + entry.getFilename());
				                files.add(file);
				                try{
				                	FTPUtils.download(SFTPWORKINGDIR,entry.getFilename(),localPath +"/"+ entry.getFilename(),channelSftp);
				                	if(file.length() == 0){
				                		/*
						                 * file moved to rejected folder on sftp for file size 0 byte 
						                 */
				                		FTPUtils.uploadFile(channelSftp,localPath+entry.getFilename(),SFTPWORKINGDIR+"/rejected");
					                	/*
					                	 * Delete file from local folder for file size 0 byte 
					                	 */
					                	file.renameTo(new File(localPath+"/rejected/"+entry.getFilename()));
				                	}
				                }catch(Exception e){
				                	LOGGER.info("File doesn't Downloaded ::: "+ localPath +"/"+ entry.getFilename() + ":::::::   ",e);
				                }
				                channelSftp.rm(SFTPWORKINGDIR+"/"+entry.getFilename());
			            	}
		            	}
			            LOGGER.info("File Successfully Downloaded");
			          
			            	return files;
		            	}else{
		            		LOGGER.info("No Any Files are there");
		            		return null;
		            	}
			        }
			        catch (SftpException e) {
			             LOGGER.error(e.getStackTrace());
			            return null;
			        }
			        catch (Exception e) {
			             LOGGER.error(e.getStackTrace());
			            return null;
			        }finally {
			        	FTPUtils.closeChannel(channelSftp);
			        }
			    }
			 /*
			  * @Ranjit
			  * Automation Sftp downloader with extension wise
			  */
			 public static ArrayList<File> downloadFileExtensinWiseFromSftp(ChannelSftp channelSftp,String SFTPWORKINGDIR,String localPath,String extension) throws SftpException {

		            try {
		            	ArrayList<File> files = new ArrayList<File>();
		            	channelSftp.cd("/");
		            	channelSftp.cd(SFTPWORKINGDIR);
		            	//Vector<ChannelSftp.LsEntry> list = channelSftp.ls("*.csv");
		            	Vector<ChannelSftp.LsEntry> list = channelSftp.ls(SFTPWORKINGDIR);
		            	if(list != null && !list.isEmpty()){
		            	for(ChannelSftp.LsEntry entry : list) {
		            		String filename = entry.getFilename();
		            		if(filename.endsWith("."+extension.toLowerCase())||filename.endsWith("."+extension.toUpperCase())){
			            		LOGGER.info(localPath + "/" + entry.getFilename());
			            	    File file = new File(localPath + "/" + entry.getFilename());
			            	    if(!new File(localPath).isDirectory()){
			            	    	FileUtils.forceMkdir(new File(localPath));
			            	    	//OctashopUtils.makeDirectories(localPath);
								}
		
			            	    if(!file.exists()){
				                	file.createNewFile();
				                }
				                channelSftp.get(entry.getFilename(), localPath + entry.getFilename());
				                files.add(file);
				                try{
				                	FTPUtils.download(SFTPWORKINGDIR,entry.getFilename(),localPath +"/"+ entry.getFilename(),channelSftp);
				                	if(file.length() == 0){
				                		/*
						                 * file moved to rejected folder on sftp for file size 0 byte 
						                 */
				                		FTPUtils.uploadFile(channelSftp,localPath+entry.getFilename(),SFTPWORKINGDIR+"/rejected");
					                	/*
					                	 * Delete file from local folder for file size 0 byte 
					                	 */
					                	file.renameTo(new File(localPath+"/rejected/"+entry.getFilename()));
				                	}
				                }catch(Exception e){
				                	LOGGER.info("File doesn't Downloaded ::: "+ localPath +"/"+ entry.getFilename() + ":::::::   ",e);
				                }
				                channelSftp.rm(SFTPWORKINGDIR+"/"+entry.getFilename());
			            	}
		            	}
			            LOGGER.info("File Successfully Downloaded");
			          
			            	return files;
		            	}else{
		            		LOGGER.info("No Any Files are there");
		            		return null;
		            	}
			        }
			        catch (SftpException e) {
			             LOGGER.error(e.getStackTrace());
			            return null;
			        }
			        catch (Exception e) {
			             LOGGER.error(e.getStackTrace());
			            return null;
			        }finally {
			        	FTPUtils.closeChannel(channelSftp);
			        }
			    }

			 /*
			  * @Ranjit
			  * Automation Ftp downloader with extension wise
			  */
			 public static ArrayList<File> downloadFileExtensinWiseFromFtp(FTPClient client,String SFTPWORKINGDIR,String localPath,String isFileToBeDeleted,String extension) throws SftpException {
				 	
				 	ArrayList<File> files = new ArrayList<File>();
				 	boolean progressBar = true;
				 	boolean renameDownloadedFile = false;
				 	String remoteFilePath = "";
				 	File downloadedFile = new File(localPath);
				 	
				 	try {
						FTPFile[] file = client.list(SFTPWORKINGDIR);
						if (file == null || file.length == 0) {
							LOGGER.warn(" Remote File does not exist :: " + remoteFilePath);
							return null;
						}
						
						if (file != null && file.length > 0) {
							for (int i = 0; i < file.length; i++) {
								String filename=file[i].getName();
								if(extension.toLowerCase().equalsIgnoreCase(FilenameUtils.getExtension(filename).toLowerCase())){
									File f = new File(localPath + "/" + filename);
				            	    if(!new File(localPath).isDirectory()){
				            	    	FileUtils.forceMkdir(new File(localPath));
									}

				            	    if(!f.exists()){
					                	f.createNewFile();
					                }
				            	    files.add(f);
				            	    
				            	    try {
										downloadedFile = FTPUtils.download(client,SFTPWORKINGDIR,filename, f, progressBar, renameDownloadedFile,null,isFileToBeDeleted);
										LOGGER.info("+ Remote File " + remoteFilePath+ " Downloaded At " + localPath + " Successfully file name:: "+filename);
									} catch (Exception e) {
										 LOGGER.error(e.getStackTrace());
									}
								}
							}
						}
						
					} catch (IllegalStateException e1) {
						LOGGER.info("Message :: "+e1.toString() +" Cause :: "+e1.getCause());
						throw e1;
					} catch (IOException e1) {
						LOGGER.error(e1.getStackTrace());
					} catch (FTPIllegalReplyException e1) {
						LOGGER.error(e1.getStackTrace());
					} catch (FTPException e1) {
						LOGGER.error(e1.getStackTrace());
					} catch (FTPDataTransferException e1) {
						LOGGER.error(e1.getStackTrace());
					} catch (FTPAbortedException e1) {
						LOGGER.error(e1.getStackTrace());
					} catch (FTPListParseException e1) {
						LOGGER.error(e1.getStackTrace());
					}
				 	return files;
			   }
			 
			 public static ArrayList<File> downloadXmlFile(ChannelSftp channelSftp,String SFTPWORKINGDIR,String localPath) throws SftpException {
		            try {
		            	ArrayList<File> files = new ArrayList<File>();
		            	channelSftp.cd("/");
		            	channelSftp.cd(SFTPWORKINGDIR);
		            	//Vector<ChannelSftp.LsEntry> list = channelSftp.ls("*.csv");
		            	Vector<ChannelSftp.LsEntry> list = channelSftp.ls(SFTPWORKINGDIR);
		            	if(list != null && !list.isEmpty()){
		            	for(ChannelSftp.LsEntry entry : list) {
		            		String filename = entry.getFilename();
		            		if(filename.endsWith(".XML") || filename.endsWith(".xml")){
			            		LOGGER.info(localPath + "/" + entry.getFilename());
			            	    File file = new File(localPath + "/" + entry.getFilename());
			            	    if(!new File(localPath).isDirectory()){
			            	    	FileUtils.forceMkdir(new File(localPath));
			            	    	//OctashopUtils.makeDirectories(localPath);
								}
		
			            	    if(!file.exists()){
				                	file.createNewFile();
				                }
				                channelSftp.get(entry.getFilename(), localPath + entry.getFilename());
				                files.add(file);
				                try{
				                	FTPUtils.download(SFTPWORKINGDIR,entry.getFilename(),localPath +"/"+ entry.getFilename(),channelSftp);
				                	if(file.length() == 0){
				                		/*
						                 * file moved to rejected folder on sftp for file size 0 byte 
						                 */
				                		FTPUtils.uploadFile(channelSftp,localPath+entry.getFilename(),SFTPWORKINGDIR+"/rejected");
					                	/*
					                	 * Delete file from local folder for file size 0 byte 
					                	 */
					                	file.renameTo(new File(localPath+"/rejected/"+entry.getFilename()));
				                	}
				                }catch(Exception e){
				                	LOGGER.info("File doesn't Downloaded ::: "+ localPath +"/"+ entry.getFilename() + ":::::::   ",e);
				                }
				                channelSftp.rm(SFTPWORKINGDIR+"/"+entry.getFilename());
			            	}
		            	}
			            LOGGER.info("File Successfully Downloaded");
			          
			            	return files;
		            	}else{
		            		LOGGER.info("No Any Files are there");
		            		return null;
		            	}
			        }
			        catch (SftpException e) {
			        	LOGGER.error(e.getStackTrace());
			            return null;
			        }
			        catch (Exception e) {
			        	LOGGER.error(e.getStackTrace());
			            return null;
			        }finally {
			        	FTPUtils.closeChannel(channelSftp);
			        }
			    }
}