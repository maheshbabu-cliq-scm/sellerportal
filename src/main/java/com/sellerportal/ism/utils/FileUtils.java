/*
 *
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package com.sellerportal.ism.utils;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sellerportal.integra.impl.octashop.utils.OctashopUtils;
import com.sellerportal.ism.integration.tasks.utils.FTPUtils;
import com.sellerportal.ism.integration.tasks.utils.FileUtility;

/**
 * @author Prasanna
 * 
 * TODO To change the template for this generated type comment go to Window -
 * Preferences - Java - Code Style - Code Templates
 */
public class FileUtils {

    private final static Log LOGGER = LogFactory.getLog(FileUtils.class);

    private final String FILE_SEP = System.getProperty("file.separator");

    public boolean copyFile(String sourceFileName, String destinationFileName) {
        boolean copyStatus = true;
        FileInputStream fInputStream = null;
        FileOutputStream fOutputStream = null;
        try {
            fInputStream = new FileInputStream(sourceFileName);
            fOutputStream = new FileOutputStream(
                    destinationFileName);
            
                byte buff[] = new byte[1024];
                while (true) {
                    int read = fInputStream.read(buff);
                    if (read == -1)
                        break;
                    fOutputStream.write(buff, 0, read);
                }
        } catch (FileNotFoundException fnfe) {
            LOGGER.warn("The source file [ " + sourceFileName
                    + "] was unavailable for copying");
            copyStatus = false;
        } catch (IOException ioe) {
            LOGGER
                    .warn("An input output Exception occured for the source file ["
                            + sourceFileName
                            + "]"
                            + "or"
                            + "for destination file ["
                            + destinationFileName
                            + "]");
            copyStatus = false;
        } finally {
        	if (fInputStream != null) {
        	try {
	            fInputStream.close();
        	} catch (Exception e) {
                LOGGER.info("Message :: "+e.toString() +" Cause :: "+e.getCause());
            }
        	}
        	if (fOutputStream != null) {
        	try {
        		fOutputStream.close();
        	} catch (Exception e) {
                LOGGER.info("Message :: "+e.toString() +" Cause :: "+e.getCause());
            }
        	}
        }
        return copyStatus;
    }
    
    public static boolean writeStringToStaticLocation(StringBuffer sourceString, String toWriteFileLocation) {
        boolean writeStatus = true;
        try {
			if(!FTPUtils.isFTPEnable()){
				File file = new File(toWriteFileLocation.substring(0,toWriteFileLocation.lastIndexOf('/')));
				if(!file.exists()) {
					file.mkdirs();
				}
				
				OctashopUtils.renameFile(toWriteFileLocation, null);
				writeToLocation(sourceString,toWriteFileLocation);
				
			}else{
				String uploadFileName = toWriteFileLocation.substring(toWriteFileLocation.lastIndexOf('/') + 1);
				String localFilePath = FTPUtils.TMPLOCATION+"/"+uploadFileName;
				File currentFile = new File(localFilePath);
				if(currentFile.exists()) {
					String currentTimeStamp = FTPUtils.getCurrentTimestamp();
					localFilePath = localFilePath+"_"+currentTimeStamp;
				}
				writeToLocation(sourceString,toWriteFileLocation);
				OctashopUtils.uploadFileToFtp(localFilePath, toWriteFileLocation);
				FileUtility.deleteFile(localFilePath);
			}
		} catch (FileNotFoundException fnfe) {
            LOGGER.warn("The source file [ " +toWriteFileLocation
                    + "] was unavailable for copying");
            writeStatus = false;
        } catch (IOException ioe) {
            LOGGER.warn("An input output Exception occured for the source file ["+toWriteFileLocation
                            + "]"
                            + "or"
                            + "for destination file ["
                            + "]");
            writeStatus = false;
        }
        return writeStatus;
    }
    
    public static boolean writeToLocation(StringBuffer sourceString, String toWriteFileLocation) throws IOException{
    	boolean writeStatus = true;
    	java.io.FileWriter fw = null;
    	try {
    		fw = new java.io.FileWriter(toWriteFileLocation);
            fw.write(sourceString.toString());
		} catch (Exception e) {
			writeStatus = false;
			throw e;
		} finally {
			try {
				if(fw!=null)
					fw.close();
			} catch (Exception e) {
                LOGGER.info("Message :: "+e.toString() +" Cause :: "+e.getCause());
            }
		}
    	return writeStatus;
    }
    
    //@Rohit countRow Method
    public int countRows(String filename) {
	    int rowsCount = 0;
	    try {
	        rowsCount = countLines(filename);
        } catch (Exception e) {
            LOGGER.error(e.getStackTrace());
        }
	    return rowsCount;
	}
    
    public static int countLines(String filename) throws IOException {
		int count = 0;
		boolean empty = true;
		FileInputStream fis = null;
		InputStream is = null;
		try {
		    fis = new FileInputStream(filename);
	        is = new BufferedInputStream(fis);
			byte[] c = new byte[1024];
			int readChars = 0;
			//int lineCharCount = 0;
			boolean isLine = false;
			while ((readChars = is.read(c)) != -1) {
				empty = false;
				for (int i = 0; i < readChars; ++i) {
					if ( c[i] == '\n' ) {
					    //lineCharCount = 0;
					    isLine = false;
					    ++count;
					}else if(!isLine && c[i] != '\n' && c[i] != '\r'){   //Case to handle line count where no New Line character present at EOF
					    isLine = true;
					    //lineCharCount++;
					}
				}
			}
			if(isLine){
			    ++count;
			}
		}catch(IOException e){
		    LOGGER.error(e.getStackTrace());
		}finally {
			if(is != null){
			    is.close();    
			}
			if(fis != null){
                fis.close();    
            }
		}
		LOGGER.info("count: "+count);
		return (count == 0 && !empty) ? 1 : count;
	}
    //@Rohit CountRow Method End
}