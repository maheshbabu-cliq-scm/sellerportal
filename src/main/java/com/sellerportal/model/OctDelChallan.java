package com.sellerportal.model;

import java.util.Date;
import javax.persistence.*;


@Entity
@Table(name = "OCT_DEL_CHALLAN")
public class OctDelChallan {

	@Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "OCT_DCSEQRFNUM_SEQ")
    @SequenceGenerator(name = "OCT_DCSEQRFNUM_SEQ", sequenceName = "OCT_DCSEQRFNUM_SEQ", allocationSize = 1)
    @Column(name = "DCRFNUM")
    private Long dcrfnum;

    @Column(name = "DCSTATUS")
    private String dcStatus;

    @Column(name = "CREATEDATE")
    private Date createdate;

    @Column(name = "CREATEDBY")
    private Long createdby;

    @Column(name = "DELETED")
    private String deleted;

    @Column(name = "MODIDATE")
    private Date modidate;

    @Column(name = "MODIFIEDBY")
    private Long modifiedby;

    @Column(name = "ISACTIVE")
    private String isActive;

    @Column(name = "DCPATH")
    private String dcPath;

    @Column(name = "SELLERPACKID")
    private String sellerPackId;

    @Column(name = "AUTOGENDCNO")
    private String autoGenDcNo;

    @Column(name = "ISDCREGENERATED")
    private String isDcRegenerated;

    @Column(name = "ISDCPRINTED")
    private String isDcPrinted;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "OCTINVOICE", nullable = false)
    private OctInvoice octinvoice;

	public Long getDcrfnum() {
		return dcrfnum;
	}

	public void setDcrfnum(Long dcrfnum) {
		this.dcrfnum = dcrfnum;
	}

	public String getDcStatus() {
		return dcStatus;
	}

	public void setDcStatus(String dcStatus) {
		this.dcStatus = dcStatus;
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

	public String getIsActive() {
		return isActive;
	}

	public void setIsActive(String isActive) {
		this.isActive = isActive;
	}

	public String getDcPath() {
		return dcPath;
	}

	public void setDcPath(String dcPath) {
		this.dcPath = dcPath;
	}

	public String getSellerPackId() {
		return sellerPackId;
	}

	public void setSellerPackId(String sellerPackId) {
		this.sellerPackId = sellerPackId;
	}

	public String getAutoGenDcNo() {
		return autoGenDcNo;
	}

	public void setAutoGenDcNo(String autoGenDcNo) {
		this.autoGenDcNo = autoGenDcNo;
	}

	public String getIsDcRegenerated() {
		return isDcRegenerated;
	}

	public void setIsDcRegenerated(String isDcRegenerated) {
		this.isDcRegenerated = isDcRegenerated;
	}

	public String getIsDcPrinted() {
		return isDcPrinted;
	}

	public void setIsDcPrinted(String isDcPrinted) {
		this.isDcPrinted = isDcPrinted;
	}

	public OctInvoice getOctinvoice() {
		return octinvoice;
	}

	public void setOctinvoice(OctInvoice octinvoice) {
		this.octinvoice = octinvoice;
	}

}
