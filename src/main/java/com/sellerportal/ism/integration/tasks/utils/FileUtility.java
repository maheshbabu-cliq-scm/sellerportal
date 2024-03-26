package com.sellerportal.ism.integration.tasks.utils;

import java.io.File;





public class FileUtility {

	
	/*
	 * renameFile(source,destination)
	 * Method Renames the existing file to the provided detination file.
	 * Returns false for failure and true for success.
	 * @param String sourceFile
	 * @param String destinationFile
	 * @return boolean
	 */
	public static String renameFile(String sourceFile,String destinationFile) {
        String message = "";
        
        if( sourceFile == null || destinationFile == null ) {
			if( sourceFile      == null ) message =  "Source File is null. "     ;
			if( destinationFile == null ) message += "Destination File is null. ";
			
			// TODO: Add log for file delete
			return message; 
		}

		File sFile = new File(sourceFile);
		File dFile = new File(destinationFile);

		
		if( !sFile.exists() && !sFile.canRead() && dFile.exists() ) {
			if ( !sFile.exists()                     )  message  = "Source File does not exist. "  ;
			if ( sFile.exists() && !sFile.canRead()  )  message += "Cannot Read Source File. "     ;
			if ( dFile.exists()                      )  message += "Desination File Does Exits. "  ;
			if ( dFile.exists() && !dFile.canWrite() )  message += "Destiation File not writable. ";
			
			// TODO: Add log for file operation with message
			return message;
		}
		try {
			if ( sFile.renameTo(dFile) ) {
				 // TODO: Add log for file rename operation with message
			     return "OK";
			} else {
				 // TODO: Add log for file rename failure
            	 return "failure";
			}
		} catch (Exception e) {
			// TODO: Add log for file rename failure
			return "Error Renaming File";
		}
	}
	
	/*
	 * deleteFile(source)
	 * Method deletes the file name passed .
	 * Checks if the passed file exists.
	 * Returns false for failure and true for success.
	 * @param String file
	 * @return boolean
	 */
	public static String deleteFile(String file) {
		
		if( file == null  ) {
			// TODO: Add log for file delete message: File is Null
			return "File is Null"; 
		}
		
		File sFile = new File(file);
		
		if( !sFile.exists() ) {
			// TODO: Add log for file delete message: File Does Not Exits
			return "File Does Not Exits";
		}

		try {
			if ( sFile.delete() ) {
				/// TODO: Add log for file delete message: File deleted
				return "OK";
			} else {
				/// TODO: Add log for file delete failure message
				return "FAILURE";
			}
				
		} catch (Exception e) {
			//LOGGER.info("Message :: "+e.toString() +" Cause :: "+e.getCause());
			/// TODO: Add log for file delete failure message
			return "File Deletion Error";
		}
	}
	
	
	public static File[] getFiles(String path) {
		
		if( path == null)
			return null;

		File mFile      = new File(path);
	    File[] allFiles = mFile.listFiles();
	    
	    return allFiles;

	}
}
