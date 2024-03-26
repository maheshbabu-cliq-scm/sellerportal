package com.sellerportal.model;

import java.util.Date;
import java.util.Set;
import javax.persistence.*;

@Entity
@Table(name = "OCT_INVOICE")
public class OctInvoice {

	@Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "invoice_sequence")
    @SequenceGenerator(name = "invoice_sequence", sequenceName = "INVOICE_INVOICERFNUM_SEQ", allocationSize = 1)
    @Column(name = "INVOICERFNUM")
    private Long invoicerfnum;

    @Column(name = "CREATEDATE")
    private Date createdate;

    @Column(name = "CREATEDBY")
    private Long createdby;

    @Column(name = "DELETED", length = 1)
    private String deleted;

    @Column(name = "ISACTIVE", length = 1)
    private String isactive;

    @Column(name = "INVOICEPATH", length = 256)
    private String invoicepath;

    @Column(name = "MODIDATE")
    private Date modidate;

    @Column(name = "MODIFIEDBY")
    private Long modifiedby;

    @Column(name = "SELLERPACKID", length = 20)
    private String sellerpackid;

    @Column(name = "INVOICEID", length = 50)
    private String invoiceNo;

    @Column(name = "AUTOGENINVOICENO", length = 50)
    private String autoGenInvoice;

    @Column(name = "ISINVOICEREGENERATED", length = 1)
    private String isregeneratedinvoice;

    @Column(name = "ISINVOICEPRINTED", length = 1)
    private String isInvoicePrinted;

    @Column(name = "ACTIVATIONCODE", length = 50)
    private String activationCode;

    @Column(name = "INVOICEDATE")
    private Date invoiceDate;

    @Column(name = "ACTIVATIONDATE")
    private Date activationDate;

    @Column(name = "ACTIVATIONTIME", length = 50)
    private String activationTime;

    @Column(name = "EXPIREDATE")
    private Date expireDate;

    @Column(name = "INVOICEIRN", length = 50)
    private String invoiceIrn;

    @Column(name = "INVOICEREVIRN", length = 50)
    private String invoiceRevIrn;

    @Column(name = "REVAUTOGENINVOICE", length = 50)
    private String revAutoGenInvoice;

    @Column(name = "INVOICEURL", length = 256)
    private String invoiceUrl;

    @Column(name = "SELLER_AGG_CODE", length = 100)
    private String sellerAggregatorCode;

    @ManyToOne
    @JoinColumn(name = "INVOICESTATUS")
    private OctParam invoicestatus;

    @ManyToOne
    @JoinColumn(name = "REASONCODE")
    private OctParam reasonCode;
	
	public String getInvoiceUrl() {
		return invoiceUrl;
	}

	public void setInvoiceUrl(String invoiceUrl) {
		this.invoiceUrl = invoiceUrl;
	}

	/** full constructor 
	 * @param invoicepath 
	 * @param ismpsts */
	public OctInvoice(Date createdate, Long createdby, String deleted, String isactive, Date modidate, Long modifiedby, com.sellerportal.model.OctParam invoicestatus, String invoicepath,String sellerpackid,String isregeneratedinvoice) {
		this.createdate = createdate;
		this.createdby = createdby;
		this.deleted = deleted;
		this.isactive = isactive;
		this.modidate = modidate;
		this.modifiedby = modifiedby;
		this.invoicestatus = invoicestatus;
//		this.shipments = shipments;
		this.invoicepath=invoicepath;
		this.sellerpackid=sellerpackid;
		this.isregeneratedinvoice = isregeneratedinvoice;
	}

	/** default constructor */
	public OctInvoice() {
	}

	public Long getInvoicerfnum() {
		return invoicerfnum;
	}

	public void setInvoicerfnum(Long invoicerfnum) {
		this.invoicerfnum = invoicerfnum;
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

	public String getIsactive() {
		return isactive;
	}

	public void setIsactive(String isactive) {
		this.isactive = isactive;
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

	public com.sellerportal.model.OctParam getInvoicestatus() {
		return invoicestatus;
	}

	public void setInvoicestatus(com.sellerportal.model.OctParam invoicestatus) {
		this.invoicestatus = invoicestatus;
	}

//	public Set getShipments() {
//		return shipments;
//	}
//
//	public void setShipments(Set shipments) {
//		this.shipments = shipments;
//	}

	public String getInvoicepath() {
		return invoicepath;
	}

	public void setInvoicepath(String invoicepath) {
		this.invoicepath = invoicepath;
	}

	public String getSellerpackid() {
		return sellerpackid;
	}

	public void setSellerpackid(String sellerpackid) {
		this.sellerpackid = sellerpackid;
	}

	public String getAutoGenInvoice() {
		return autoGenInvoice;
	}

	public void setAutoGenInvoice(String autoGenInvoice) {
		this.autoGenInvoice = autoGenInvoice;
	}

	public String getInvoiceNo() {
		return invoiceNo;
	}

	public void setInvoiceNo(String invoiceNo) {
		this.invoiceNo = invoiceNo;
	}

	public String getIsregeneratedinvoice() {
		return isregeneratedinvoice;
	}

	public void setIsregeneratedinvoice(String isregeneratedinvoice) {
		this.isregeneratedinvoice = isregeneratedinvoice;
	}

	public String getIsInvoicePrinted() {
		return isInvoicePrinted;
	}

	public void setIsInvoicePrinted(String isInvoicePrinted) {
		this.isInvoicePrinted = isInvoicePrinted;
	}
	public String getActivationCode() {
		return activationCode;
	}

	public void setActivationCode(String activationCode) {
		this.activationCode = activationCode;
	}

	public Date getInvoiceDate() {
		return invoiceDate;
	}

	public void setInvoiceDate(Date invoiceDate) {
		this.invoiceDate = invoiceDate;
	}

	public Date getActivationDate() {
		return activationDate;
	}

	public void setActivationDate(Date activationDate) {
		this.activationDate = activationDate;
	}

	public String getActivationTime() {
		return activationTime;
	}

	public void setActivationTime(String activationTime) {
		this.activationTime = activationTime;
	}

	public Date getExpireDate() {
		return expireDate;
	}

	public void setExpireDate(Date expireDate) {
		this.expireDate = expireDate;
	}

	public com.sellerportal.model.OctParam getReasonCode() {
		return reasonCode;
	}

	public void setReasonCode(com.sellerportal.model.OctParam reasonCode) {
		this.reasonCode = reasonCode;
	}

	public String getInvoiceIrn() {
		return invoiceIrn;
	}

	public void setInvoiceIrn(String invoiceIrn) {
		this.invoiceIrn = invoiceIrn;
	}

	public String getInvoiceRevIrn() {
		return invoiceRevIrn;
	}

	public void setInvoiceRevIrn(String invoiceRevIrn) {
		this.invoiceRevIrn = invoiceRevIrn;
	}

	public String getRevAutoGenInvoice() {
		return revAutoGenInvoice;
	}

	public void setRevAutoGenInvoice(String revAutoGenInvoice) {
		this.revAutoGenInvoice = revAutoGenInvoice;
	}

	public String getSellerAggregatorCode() {
		return sellerAggregatorCode;
	}

	public void setSellerAggregatorCode(String sellerAggregatorCode) {
		this.sellerAggregatorCode = sellerAggregatorCode;
	}

}
