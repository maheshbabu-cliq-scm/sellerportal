package com.sellerportal.model;

import java.io.Serializable;

import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name = "OCT_SLR_LOG_INFO")
public class SlrLogInfo implements Serializable{
	
	@Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "slirfnum_generator")
    @SequenceGenerator(name="slirfnum_generator", sequenceName = "SLI_SLIRFNUM_SEQ", allocationSize = 1)
    @Column(name = "SLIRFNUM")
    private Long slirfnum;

    @Column(name = "CREATEDATE", nullable = false)
    private Date createdate;

    @Column(name = "CREATEDBY", nullable = false, length = 20)
    private Long createdby;

    @Column(name = "DELETED", nullable = false, length = 1)
    private String deleted;

    @Column(name = "ORGID", nullable = false, length = 20)
    private Long orgid;

    @Column(name = "EDITEDBY", length = 20)
    private String editedBy;

    @Column(name = "ISAPPROVED", length = 1)
    private String isApproved;

    @Column(name = "ISPROCESSED", length = 1)
    private String isProcessed;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "SLRLOGRFNUM", nullable = false)
    private OctSlrLog slrLogRfnum;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "SLRLOGINFORFNUM", nullable = false)
    private OctSlrInfo slrLogInfoRfnum;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "SLRLOGOLDINFORFNUM")
    private OctSlrInfo slrLogOldInfoRfnum;

    
    
    /** full constructor */
    public SlrLogInfo(Date createdate, Long createdby, String deleted, Long orgid, com.sellerportal.model.OctSlrInfo slrLogInfoRfnum,com.sellerportal.model.OctSlrLog slrLogRfnum,com.sellerportal.model.OctSlrInfo slrLogOldInfoRfnum) {
        this.createdate = createdate;
        this.createdby = createdby;
        this.deleted = deleted;
        this.orgid = orgid;
        this.slrLogInfoRfnum = slrLogInfoRfnum;
        this.slrLogRfnum = slrLogRfnum;
        this.slrLogOldInfoRfnum = slrLogOldInfoRfnum;
    }

    /** default constructor */
    public SlrLogInfo() {
    }

    /** minimal constructor */
    public SlrLogInfo(Date createdate, Long createdby, String deleted, Long orgid) {
        this.createdate = createdate;
        this.createdby = createdby;
        this.deleted = deleted;
        this.orgid = orgid;
    }
    
    
	public Long getSlirfnum() {
		return slirfnum;
	}

	public void setSlirfnum(Long slirfnum) {
		this.slirfnum = slirfnum;
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

	public Long getOrgid() {
		return orgid;
	}

	public void setOrgid(Long orgid) {
		this.orgid = orgid;
	}

	public com.sellerportal.model.OctSlrInfo getSlrLogInfoRfnum() {
		return slrLogInfoRfnum;
	}

	public void setSlrLogInfoRfnum(com.sellerportal.model.OctSlrInfo slrLogInfoRfnum) {
		this.slrLogInfoRfnum = slrLogInfoRfnum;
	}

	public com.sellerportal.model.OctSlrLog getSlrLogRfnum() {
		return slrLogRfnum;
	}

	public void setSlrLogRfnum(com.sellerportal.model.OctSlrLog slrLogRfnum) {
		this.slrLogRfnum = slrLogRfnum;
	}

	public String getEditedBy() {
		return editedBy;
	}

	public void setEditedBy(String editedBy) {
		this.editedBy = editedBy;
	}

	public String getIsApproved() {
		return isApproved;
	}

	public void setIsApproved(String isApproved) {
		this.isApproved = isApproved;
	}

	public String getIsProcessed() {
		return isProcessed;
	}

	public void setIsProcessed(String isProcessed) {
		this.isProcessed = isProcessed;
	}

	public com.sellerportal.model.OctSlrInfo getSlrLogOldInfoRfnum() {
		return slrLogOldInfoRfnum;
	}

	public void setSlrLogOldInfoRfnum(com.sellerportal.model.OctSlrInfo slrLogOldInfoRfnum) {
		this.slrLogOldInfoRfnum = slrLogOldInfoRfnum;
	}
	
	
}
