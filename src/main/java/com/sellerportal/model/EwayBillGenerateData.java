package  com.sellerportal.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name = "EWAY_BILL_GENERATE_DATA")
public class EwayBillGenerateData implements Serializable {

		/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence")
    @SequenceGenerator(name = "sequence", sequenceName = "EWAYBILLGENERATEDATA_SEQ", allocationSize = 1)
    @Column(name = "id")
    private Long id;

    @Column(name = "REQUESTPAYLOAD", length = 4000)
    private String requestPayload;

    @Column(name = "RESPONSEPAYLOAD", length = 4000)
    private String responsePayload;

    @Column(name = "INVOICENUMBER", length = 255)
    private String invoiceNumber;

    @Column(name = "EWAYBILLNUMBER", length = 255)
    private String ewayBillNumber;

    @Column(name = "GSTIN", length = 255)
    private String gstin;

    @Column(name = "STATUS", length = 20)
    private String status;

    @Column(name = "REMARKS", length = 20)
    private String remarks;

    @Column(name = "CANCELREASONCODE", length = 255)
    private String cancelReasonCode;

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
	    
	    
	    
	    public String getCancelReasonCode() {
			return cancelReasonCode;
		}

		public void setCancelReasonCode(String cancelReasonCode) {
			this.cancelReasonCode = cancelReasonCode;
		}

		public String getRemarks() {
			return remarks;
		}

		public void setRemarks(String remarks) {
			this.remarks = remarks;
		}

		public String getStatus() {
			return status;
		}

		public void setStatus(String status) {
			this.status = status;
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

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public String getRequestPayLoad() {
			return requestPayload;
		}

		public void setRequestPayLoad(String requestPayLoad) {
			this.requestPayload = requestPayLoad;
		}

		public String getResponsePayLoad() {
			return responsePayload;
		}

		public void setResponsePayLoad(String responsePayLoad) {
			this.responsePayload = responsePayLoad;
		}

		public String getInvoiceNumber() {
			return invoiceNumber;
		}

		public void setInvoiceNumber(String invoiceNumber) {
			this.invoiceNumber = invoiceNumber;
		}

		public String getEwayBillNumber() {
			return ewayBillNumber;
		}

		public void setEwayBillNumber(String ewayBillNumber) {
			this.ewayBillNumber = ewayBillNumber;
		}

		public String getGstin() {
			return gstin;
		}

		public void setGstin(String gstin) {
			this.gstin = gstin;
		}

		public static long getSerialversionuid() {
			return serialVersionUID;
		}
	    
	    
	    
	
	}



