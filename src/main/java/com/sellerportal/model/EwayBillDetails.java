package com.sellerportal.model;

import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name = "EWAY_BILL_DETAILS")
public class EwayBillDetails {
	
	private static final long serialVersionUID = 1L;
	
	 	@Id
	    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence")
	    @SequenceGenerator(name = "sequence", sequenceName = "EWAYBILLDETAILS_SEQ", allocationSize = 1)
	    @Column(name = "EWAYBILLID")
	    private Long ewayBillId;

	    @Column(name = "USERNAME", length = 255)
	    private String userName;

	    @Column(name = "PASSWORD", length = 255)
	    private String password;

	    @Column(name = "OWNERID", length = 255)
	    private String ownerId;

	    @Column(name = "GSTIN", length = 255)
	    private String gstin;

	    @Column(name = "ISOPTINEWAYBILL", length = 20)
	    private String isOptInEwayBill;

	    @Column(name = "ISCLAYFIN", length = 20)
	    private String isClayFin;

	    @Column(name = "CREATEDATE", nullable = false)
	    private Date createdate;

	    @Column(name = "CREATEDBY", nullable = false)
	    private Long createdby;

	    @Column(name = "DELETED", nullable = false, length = 1)
	    private String deleted;

	    @Column(name = "MODIDATE", nullable = false)
	    private Date modidate;

	    @Column(name = "MODIFIEDBY", nullable = false)
	    private Long modifiedby;

	    @Column(name = "ORGID", nullable = false)
	    private Long orgid;

	    @ManyToOne
	    private OctSlv octslv;
	


	public Long getEwayBillId() {
		return ewayBillId;
	}


	public void setEwayBillId(Long ewayBillId) {
		this.ewayBillId = ewayBillId;
	}


	public String getUserName() {
		return userName;
	}


	public void setUserName(String userName) {
		this.userName = userName;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getOwnerId() {
		return ownerId;
	}


	public void setOwnerId(String ownerId) {
		this.ownerId = ownerId;
	}


	public String getGstin() {
		return gstin;
	}


	public void setGstin(String gstin) {
		this.gstin = gstin;
	}


	public OctSlv getOctslv() {
		return octslv;
	}


	public void setOctslv(OctSlv octslv) {
		this.octslv = octslv;
	}


	public String getIsOptInEwayBill() {
		return isOptInEwayBill;
	}


	public void setIsOptInEwayBill(String isOptInEwayBill) {
		this.isOptInEwayBill = isOptInEwayBill;
	}

	public String getIsClayFin() {
		return isClayFin;
	}


	public void setIsClayFin(String isClayFin) {
		this.isClayFin = isClayFin;
	}


	public Date getCreatedate() {
		return createdate;
	}


	public void setCreatedate(Date createdate) {
		this.createdate = createdate;
	}


	public Long getCreatedby() {
		return createdby;
	}


	public void setCreatedby(Long createdby) {
		this.createdby = createdby;
	}


	public String getDeleted() {
		return deleted;
	}


	public void setDeleted(String deleted) {
		this.deleted = deleted;
	}


	public Date getModidate() {
		return modidate;
	}


	public void setModidate(Date modidate) {
		this.modidate = modidate;
	}


	public Long getModifiedby() {
		return modifiedby;
	}


	public void setModifiedby(Long modifiedby) {
		this.modifiedby = modifiedby;
	}


	public Long getOrgid() {
		return orgid;
	}


	public void setOrgid(Long orgid) {
		this.orgid = orgid;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}

