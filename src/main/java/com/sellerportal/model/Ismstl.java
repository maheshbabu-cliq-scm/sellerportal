package com.sellerportal.model;

import java.io.Serializable;
import java.util.Date;

import org.apache.commons.lang.builder.ToStringBuilder;
import javax.persistence.*;

@Entity
@Table(name = "ISMSTL")
public class Ismstl implements Serializable {

	@Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "stlrfnum_sequence")
    @SequenceGenerator(name = "stlrfnum_sequence", sequenceName = "ISMSTL_STLRFNUM_SEQ", allocationSize = 1)
    @Column(name = "STLRFNUM")
    private Long stlrfnum;

    @Column(name = "CREATEDATE", nullable = false)
    private Date createdate;

    @Column(name = "CREATEDBY", nullable = false, length = 10)
    private Long createdby;

    @Column(name = "DELETED", length = 1)
    private String deleted;

    @Column(name = "MODIDATE")
    private Date modidate;

    @Column(name = "MODIFIEDBY", nullable = false, length = 10)
    private Long modifiedby;

    @Column(name = "STLAWBNUM", length = 30)
    private String stlawbnum;

    @Column(name = "STLPICKQTY", length = 10)
    private Long stlpickqty;

    @Column(name = "STLPACKID", length = 25)
    private String stlpackid;

    @Column(name = "STLPICKID", length = 25)
    private String stlpickid;

    @Column(name = "STLREMARK", length = 500)
    private String stlremark;

    @Column(name = "STLSHIPMENTID", length = 25)
    private String stlshipmentid;

    @Column(name = "SENDSTATUS", length = 1)
    private String sendstatus;

    @Column(name = "SELLERSENDSTATUS", length = 1)
    private String sellersendstatus;

    @Column(name = "STLSLRCODE", length = 25)
    private String stlslrcode;

    @Column(name = "STLSLVRFNUM", length = 25)
    private Long stlslvrfnum;

    @Column(name = "STLSMDRFNUM", length = 25)
    private Long stlsmdrfnum;

    @Column(name = "STLSMTFSTATE", length = 25)
    private Long stlsmtfstate;

    @Column(name = "STLSMTTSTATE", length = 25)
    private Long stlsmttstate;

    @Column(name = "ORDERSTATUSDATE", length = 30)
    private String orderstatusdate;

    @Column(name = "STATUSUPDATETOKEN", length = 20)
    private String statusupdatetoken;

    @Column(name = "STL_MOBILE_SRC", length = 100)
    private String stlMobileSrc;

    @Column(name = "ISRETURNCONFIRM", length = 1)
    private String isReturnConfirm;

    @Column(name = "RETCONFIRMDATE")
    private Date retConfirmDate;

    @Column(name = "STLRETURNREASON", length = 500)
    private String stlReturnReason;

    @Column(name = "STLLPFAILREASON", length = 500)
    private String stlLpFailReason;

    @Column(name = "PICKUPATTEMPTCOUNT", length = 10)
    private Integer PickupAttemptCount;

    @Column(name = "PICKUPATTEMPTCOUNTDATE")
    private Date PickupAttemptCountDate;

    @Column(name = "SLAVEID", length = 28)
    private String slaveId;

    @Column(name = "CANCELLATIONSENDSTATUS", length = 1)
    private String cancellationsendstatus;

    @Column(name = "RETRYCOUNT", length = 2)
    private Integer retryCount;

    @Column(name = "ISDOORSTEPQCREQUIRED", length = 1)
    private String isDoorStepQCRequired;

    @Column(name = "LPACCOUNTCODE", length = 255)
    private String lpAccountCode;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "STLUBIRFNUM")
    private Ismubi ismubi;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "STLPSTRFNUM", nullable = false)
    private Ismpst ismpst;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "STLREJECTIONREASON")
    private OctParam stlRejectionReason;
	
	public Integer getPickupAttemptCount() {
		return PickupAttemptCount;
	}

	public void setPickupAttemptCount(Integer pickupAttemptCount) {
		PickupAttemptCount = pickupAttemptCount;
	}


	
	public Date getPickupAttemptCountDate() {
		return PickupAttemptCountDate;
	}

	public void setPickupAttemptCountDate(Date pickupAttemptCountDate) {
		PickupAttemptCountDate = pickupAttemptCountDate;
	}

	/** full constructor */
	public Ismstl(Date createdate, Long createdby, String deleted, Date modidate, Long modifiedby, String stlawbnum, String stlpackid, String stlpickid, String stlremark, String stlshipmentid, String stlslrcode, Long stlslvrfnum, Long stlsmdrfnum, Long stlsmtfstate, Long stlsmttstate,Long stlpickqty,String orderstatusdate,  com.sellerportal.model.Ismubi ismubi,  com.sellerportal.model.Ismpst ismpst,  com.sellerportal.model.OctParam stlRejectionReason,String statusupdatetoken, Integer PickupAttemptCount
			, String slaveId,Integer retryCount) {
		this.createdate = createdate;
		this.createdby = createdby;
		this.deleted = deleted;
		this.modidate = modidate;
		this.modifiedby = modifiedby;
		this.stlawbnum = stlawbnum;
		this.stlpackid = stlpackid;
		this.stlpickid = stlpickid;
		this.stlremark = stlremark;
		this.stlshipmentid = stlshipmentid;
		this.stlslrcode = stlslrcode;
		this.stlslvrfnum = stlslvrfnum;
		this.stlsmdrfnum = stlsmdrfnum;
		this.stlsmtfstate = stlsmtfstate;
		this.stlsmttstate = stlsmttstate;
		this.ismubi = ismubi;
		this.ismpst = ismpst;
		this.stlpickqty=stlpickqty;
		this.stlRejectionReason = stlRejectionReason;
		this.orderstatusdate = orderstatusdate;
		this.statusupdatetoken = statusupdatetoken;
		this.PickupAttemptCount = PickupAttemptCount;
		this.slaveId = slaveId;
		this.retryCount=retryCount;
	}

	/** default constructor */
	public Ismstl() {
	}

	/** minimal constructor */
	public Ismstl(Date createdate, Long createdby, Long modifiedby, String stlawbnum, String stlpackid, String stlpickid, String stlremark, String stlshipmentid, String stlslrcode, Long stlslvrfnum, Long stlsmdrfnum, Long stlsmtfstate, Long stlsmttstate,  com.sellerportal.model.Ismubi ismubi,  com.sellerportal.model.Ismpst ismpst) {
		this.createdate = createdate;
		this.createdby = createdby;
		this.modifiedby = modifiedby;
		this.stlawbnum = stlawbnum;
		this.stlpackid = stlpackid;
		this.stlpickid = stlpickid;
		this.stlremark = stlremark;
		this.stlshipmentid = stlshipmentid;
		this.stlslrcode = stlslrcode;
		this.stlslvrfnum = stlslvrfnum;
		this.stlsmdrfnum = stlsmdrfnum;
		this.stlsmtfstate = stlsmtfstate;
		this.stlsmttstate = stlsmttstate;
		this.ismubi = ismubi;
		this.ismpst = ismpst;

	}

	public Long getStlrfnum() {
		return this.stlrfnum;
	}

	public void setStlrfnum(Long stlrfnum) {
		this.stlrfnum = stlrfnum;
	}

	public Date getCreatedate() {
		return this.createdate;
	}

	public void setCreatedate(Date createdate) {
		this.createdate = createdate;
	}

	public Long getCreatedby() {
		return this.createdby;
	}

	public void setCreatedby(Long createdby) {
		this.createdby = createdby;
	}

	public String getDeleted() {
		return this.deleted;
	}

	public void setDeleted(String deleted) {
		this.deleted = deleted;
	}

	public Date getModidate() {
		return this.modidate;
	}

	public void setModidate(Date modidate) {
		this.modidate = modidate;
	}

	public Long getModifiedby() {
		return this.modifiedby;
	}

	public void setModifiedby(Long modifiedby) {
		this.modifiedby = modifiedby;
	}

	public String getStlawbnum() {
		return this.stlawbnum;
	}

	public void setStlawbnum(String stlawbnum) {
		this.stlawbnum = stlawbnum;
	}

	public String getStlpackid() {
		return this.stlpackid;
	}

	public void setStlpackid(String stlpackid) {
		this.stlpackid = stlpackid;
	}

	public String getStlpickid() {
		return this.stlpickid;
	}

	public void setStlpickid(String stlpickid) {
		this.stlpickid = stlpickid;
	}

	public String getStlremark() {
		return this.stlremark;
	}

	public void setStlremark(String stlremark) {
		this.stlremark = stlremark;
	}

	public String getStlshipmentid() {
		return this.stlshipmentid;
	}

	public void setStlshipmentid(String stlshipmentid) {
		this.stlshipmentid = stlshipmentid;
	}

	public String getStlslrcode() {
		return this.stlslrcode;
	}

	public void setStlslrcode(String stlslrcode) {
		this.stlslrcode = stlslrcode;
	}

	public Long getStlslvrfnum() {
		return this.stlslvrfnum;
	}

	public void setStlslvrfnum(Long stlslvrfnum) {
		this.stlslvrfnum = stlslvrfnum;
	}

	public Long getStlsmdrfnum() {
		return this.stlsmdrfnum;
	}

	public String getOrderstatusdate() {
		return orderstatusdate;
	}

	public void setOrderstatusdate(String orderstatusdate) {
		this.orderstatusdate = orderstatusdate;
	}

	public void setStlsmdrfnum(Long stlsmdrfnum) {
		this.stlsmdrfnum = stlsmdrfnum;
	}

	public Long getStlsmtfstate() {
		return this.stlsmtfstate;
	}

	public void setStlsmtfstate(Long stlsmtfstate) {
		this.stlsmtfstate = stlsmtfstate;
	}

	public Long getStlsmttstate() {
		return this.stlsmttstate;
	}

	public void setStlsmttstate(Long stlsmttstate) {
		this.stlsmttstate = stlsmttstate;
	}

	public  com.sellerportal.model.Ismubi getIsmubi() {
		return this.ismubi;
	}

	public void setIsmubi( com.sellerportal.model.Ismubi ismubi) {
		this.ismubi = ismubi;
	}

	public  com.sellerportal.model.Ismpst getIsmpst() {
		return this.ismpst;
	}

	public void setIsmpst( com.sellerportal.model.Ismpst ismpst) {
		this.ismpst = ismpst;
	}


	public Long getStlpickqty() {
		return stlpickqty;
	}

	public void setStlpickqty(Long stlpickqty) {
		this.stlpickqty = stlpickqty;
	}

	public String toString() {
		return new ToStringBuilder(this)
				.append("stlrfnum", getStlrfnum())
				.toString();
	}

	public  com.sellerportal.model.OctParam getStlRejectionReason() {
		return stlRejectionReason;
	}

	public void setStlRejectionReason( com.sellerportal.model.OctParam stlRejectionReason) {
		this.stlRejectionReason = stlRejectionReason;
	}

	public String getSendstatus() {
		return sendstatus;
	}

	public void setSendstatus(String sendstatus) {
		this.sendstatus = sendstatus;
	}

	public String getSellersendstatus() {
		return sellersendstatus;
	}

	public void setSellersendstatus(String sellersendstatus) {
		this.sellersendstatus = sellersendstatus;
	}

	public String getStatusupdatetoken() {
		return statusupdatetoken;
	}

	public void setStatusupdatetoken(String statusupdatetoken) {
		this.statusupdatetoken = statusupdatetoken;
	}

	public String getStlMobileSrc() {
		return stlMobileSrc;
	}

	public void setStlMobileSrc(String stlMobileSrc) {
		this.stlMobileSrc = stlMobileSrc;
	}

	public String getIsReturnConfirm() {
		return isReturnConfirm;
	}

	public void setIsReturnConfirm(String isReturnConfirm) {
		this.isReturnConfirm = isReturnConfirm;
	}

	public Date getRetConfirmDate() {
		return retConfirmDate;
	}

	public void setRetConfirmDate(Date retConfirmDate) {
		this.retConfirmDate = retConfirmDate;
	}

	public String getStlReturnReason() {
		return stlReturnReason;
	}

	public void setStlReturnReason(String stlReturnReason) {
		this.stlReturnReason = stlReturnReason;
	}

	public String getStlLpFailReason() {
		return stlLpFailReason;
	}

	public void setStlLpFailReason(String stlLpFailReason) {
		this.stlLpFailReason = stlLpFailReason;
	}

	public String getSlaveId() {
		return slaveId;
	}

	public void setSlaveId(String slaveId) {
		this.slaveId = slaveId;
	}

	public String getCancellationsendstatus() {
		return cancellationsendstatus;
	}

	public void setCancellationsendstatus(String cancellationsendstatus) {
		this.cancellationsendstatus = cancellationsendstatus;
	}

	public Integer getRetryCount() {
		return retryCount;
	}

	public void setRetryCount(Integer retryCount) {
		this.retryCount = retryCount;
	}
	
	public String getIsDoorStepQCRequired() {
		return isDoorStepQCRequired;
	}

	public void setIsDoorStepQCRequired(String isDoorStepQCRequired) {
		this.isDoorStepQCRequired = isDoorStepQCRequired;
	}

	public String getLpAccountCode() {
		return lpAccountCode;
	}

	public void setLpAccountCode(String lpAccountCode) {
		this.lpAccountCode = lpAccountCode;
	}
	
	
}