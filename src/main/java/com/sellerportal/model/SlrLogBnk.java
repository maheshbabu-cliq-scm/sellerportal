package com.sellerportal.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Entity
@Table(name = "OCT_SLR_LOG_BNK")
public class SlrLogBnk implements Serializable{
	
	@Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "slbrfnum_generator")
    @SequenceGenerator(name="slbrfnum_generator", sequenceName = "SLB_SLBRFNUM_SEQ", allocationSize = 1)
    @Column(name = "SLBRFNUM")
    private Long slbrfnum;

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
    @JoinColumn(name = "SLRLOGBNKRFNUM", nullable = false)
    private OctSlrBnk slrLogBnkRfnum;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "SLRLOGOLDBNKRFNUM")
    private OctSlrBnk slrLogOldBnkRfnum;
    
    /** full constructor */
    public SlrLogBnk(Date createdate, Long createdby, String deleted, Long orgid, com.sellerportal.model.OctSlrBnk slrLogBnkRfnum,com.sellerportal.model.OctSlrLog slrLogRfnum,String editedBy,String isApproved,String isProcessed,com.sellerportal.model.OctSlrBnk slrLogOldBnkRfnum) {
        this.createdate = createdate;
        this.createdby = createdby;
        this.deleted = deleted;
        this.orgid = orgid;
        this.slrLogBnkRfnum = slrLogBnkRfnum;
        this.slrLogRfnum = slrLogRfnum;
        this.editedBy = editedBy;
        this.isApproved = isApproved;
        this.isProcessed = isProcessed;
        this.slrLogOldBnkRfnum = slrLogOldBnkRfnum;
    }

    /** default constructor */
    public SlrLogBnk() {
    }

    /** minimal constructor */
    public SlrLogBnk(Date createdate, Long createdby, String deleted, Long orgid) {
        this.createdate = createdate;
        this.createdby = createdby;
        this.deleted = deleted;
        this.orgid = orgid;
    }
    
    
    
	public Long getSlbrfnum() {
		return slbrfnum;
	}

	public void setSlbrfnum(Long slbrfnum) {
		this.slbrfnum = slbrfnum;
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

	public com.sellerportal.model.OctSlrBnk getSlrLogBnkRfnum() {
		return slrLogBnkRfnum;
	}

	public void setSlrLogBnkRfnum(com.sellerportal.model.OctSlrBnk slrLogBnkRfnum) {
		this.slrLogBnkRfnum = slrLogBnkRfnum;
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

	public com.sellerportal.model.OctSlrBnk getSlrLogOldBnkRfnum() {
		return slrLogOldBnkRfnum;
	}

	public void setSlrLogOldBnkRfnum(com.sellerportal.model.OctSlrBnk slrLogOldBnkRfnum) {
		this.slrLogOldBnkRfnum = slrLogOldBnkRfnum;
	}
    
}
