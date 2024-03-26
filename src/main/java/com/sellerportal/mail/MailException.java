/*
 *
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package com.sellerportal.mail;

/**
 * @author Administrator
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class MailException extends Exception {

	/**
	 * 
	 */
	public MailException() {
		super();
	}
	/**
	 * @param message
	 */
	public MailException(String message) {
		super(message);
		
	}
	/**
	 * @param message
	 * @param cause
	 */
	public MailException(String message, Throwable cause) {
		super(message, cause);
	}
	/**
	 * @param cause
	 */
	public MailException(Throwable cause) {
		super(cause);
		
	}
}
