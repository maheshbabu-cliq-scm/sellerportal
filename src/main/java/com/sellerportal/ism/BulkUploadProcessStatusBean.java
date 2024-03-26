/*
 *
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package com.sellerportal.ism;

import java.util.Date;


/**
 * @author pramod
 * 
 * @see To maintain the Bulk Upload process status 
 */
public class BulkUploadProcessStatusBean {
	
	private String  ref; 
	private String  message;
	private String  total;
	private String  successCnt;
	private String  failedCnt;
	private Date starttime;
	private Date endtime;
	
	public String getRef() {
		return ref;
	}
	public void setRef(String ref) {
		this.ref = ref;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getTotal() {
		return total;
	}
	public void setTotal(String total) {
		this.total = total;
	}
	public String getSuccessCnt() {
		return successCnt;
	}
	public void setSuccessCnt(String successCnt) {
		this.successCnt = successCnt;
	}
	public String getFailedCnt() {
		return failedCnt;
	}
	public void setFailedCnt(String failedCnt) {
		this.failedCnt = failedCnt;
	}
	public Date getStarttime() {
		return starttime;
	}
	public void setStarttime(Date starttime) {
		this.starttime = starttime;
	}
	public Date getEndtime() {
		return endtime;
	}
	public void setEndtime(Date endtime) {
		this.endtime = endtime;
	}
	
}