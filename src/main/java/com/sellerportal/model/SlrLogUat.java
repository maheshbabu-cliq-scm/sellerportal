package com.sellerportal.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Entity
@Table(name = "OCT_SLR_LOG_UAT")
public class SlrLogUat implements Serializable{
	
	@Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "slurfnum_generator")
    @SequenceGenerator(name="slurfnum_generator", sequenceName = "SLU_SLURFNUM_SEQ", allocationSize = 1)
    @Column(name = "SLURFNUM")
    private Long slurfnum;

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
    @JoinColumn(name = "SLRLOGUATRFNUM", nullable = false)
    private Ismuat slrLogUatRfnum;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "SLRLOGOLDUATRFNUM")
    private Ismuat slrLogOldUatRfnum;
    
    
    /** full constructor */
    public SlrLogUat(Date createdate, Long createdby, String deleted, Long orgid, com.sellerportal.model.Ismuat slrLogUatRfnum,com.sellerportal.model.OctSlrLog slrLogRfnum,String editedBy,String isApproved,String isProcessed,com.sellerportal.model.Ismuat slrLogOldUatRfnum) {
        this.createdate = createdate;
        this.createdby = createdby;
        this.deleted = deleted;
        this.orgid = orgid;
        this.slrLogUatRfnum = slrLogUatRfnum;
        this.slrLogRfnum = slrLogRfnum;
        this.editedBy = editedBy;
        this.isApproved = isApproved;
        this.isProcessed = isProcessed;
        this.slrLogOldUatRfnum = slrLogOldUatRfnum;
    }

    /** default constructor */
    public SlrLogUat() {
    }

    /** minimal constructor */
    public SlrLogUat(Date createdate, Long createdby, String deleted, Long orgid) {
        this.createdate = createdate;
        this.createdby = createdby;
        this.deleted = deleted;
        this.orgid = orgid;
    }
    
    

	public Long getSlurfnum() {
		return slurfnum;
	}

	public void setSlurfnum(Long slurfnum) {
		this.slurfnum = slurfnum;
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

	public com.sellerportal.model.Ismuat getSlrLogUatRfnum() {
		return slrLogUatRfnum;
	}

	public void setSlrLogUatRfnum(com.sellerportal.model.Ismuat slrLogUatRfnum) {
		this.slrLogUatRfnum = slrLogUatRfnum;
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

	public com.sellerportal.model.Ismuat getSlrLogOldUatRfnum() {
		return slrLogOldUatRfnum;
	}

	public void setSlrLogOldUatRfnum(com.sellerportal.model.Ismuat slrLogOldUatRfnum) {
		this.slrLogOldUatRfnum = slrLogOldUatRfnum;
	}
    
	

}
