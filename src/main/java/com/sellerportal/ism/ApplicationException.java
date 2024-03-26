/*
 *
 */
package com.sellerportal.ism;

/**
 * @author pranavs 
 * 		   This is the applicaton level Exception. 
 * 		   Purpose:- All the action methods should throw this exception for 
 *         rollback of database insert or update.
 */
public class ApplicationException extends RuntimeException {
    private String errorCode = "";

    /**
     *  
     */
    public ApplicationException() {
        super();
        
    }

    /**
     * @param message
     */
    public ApplicationException(String message) {
        super(message);
        
    }

    /**
     * @param cause
     */
    public ApplicationException(Throwable cause) {
        super(cause);
        
    }

    /**
     * @param cause
     */
    public ApplicationException(Throwable cause, String errorCode) {
        super(cause);
        
    }

    /**
     * @param message
     * @param cause
     */
    public ApplicationException(String message, Throwable cause) {
        super(message, cause);
        
    }

    /**
     * @return Returns the errorCode.
     */
    public String getErrorCode() {
        return errorCode;
    }

    /**
     * @param errorCode
     *            The errorCode to set.
     */
    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }
}