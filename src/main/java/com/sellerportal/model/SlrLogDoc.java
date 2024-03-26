package com.sellerportal.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Entity
@Table(name = "OCT_SLR_LOG_DOC")
public class SlrLogDoc implements Serializable{
	
	@Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sldrfnum_generator")
    @SequenceGenerator(name="sldrfnum_generator", sequenceName = "SLD_SLDRFNUM_SEQ", allocationSize = 1)
    @Column(name = "SLDRFNUM")
    private Long sldrfnum;

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
    @JoinColumn(name = "SLRLOGDOCRFNUM", nullable = false)
    private OctSlrDoc slrLogDocRfnum;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "SLRLOGOLDDOCRFNUM")
    private OctSlrDoc slrLogOldDocRfnum;
    
    /** full constructor */
    public SlrLogDoc(Date createdate, Long createdby, String deleted, Long orgid, com.sellerportal.model.OctSlrDoc slrLogDocRfnum,com.sellerportal.model.OctSlrLog slrLogRfnum,String editedBy,String isApproved,String isProcessed,com.sellerportal.model.OctSlrDoc slrLogOldDocRfnum) {
        this.createdate = createdate;
        this.createdby = createdby;
        this.deleted = deleted;
        this.orgid = orgid;
        this.slrLogDocRfnum = slrLogDocRfnum;
        this.slrLogRfnum = slrLogRfnum;
        this.editedBy = editedBy;
        this.isApproved = isApproved;
        this.isProcessed = isProcessed;
        this.slrLogOldDocRfnum = slrLogOldDocRfnum;
    }

    /** default constructor */
    public SlrLogDoc() {
    }

    /** minimal constructor */
    public SlrLogDoc(Date createdate, Long createdby, String deleted, Long orgid) {
        this.createdate = createdate;
        this.createdby = createdby;
        this.deleted = deleted;
        this.orgid = orgid;
    }
    
    
    
	public Long getSldrfnum() {
		return sldrfnum;
	}

	public void setSldrfnum(Long sldrfnum) {
		this.sldrfnum = sldrfnum;
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

	public com.sellerportal.model.OctSlrDoc getSlrLogDocRfnum() {
		return slrLogDocRfnum;
	}

	public void setSlrLogDocRfnum(com.sellerportal.model.OctSlrDoc slrLogDocRfnum) {
		this.slrLogDocRfnum = slrLogDocRfnum;
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

	public com.sellerportal.model.OctSlrDoc getSlrLogOldDocRfnum() {
		return slrLogOldDocRfnum;
	}

	public void setSlrLogOldDocRfnum(com.sellerportal.model.OctSlrDoc slrLogOldDocRfnum) {
		this.slrLogOldDocRfnum = slrLogOldDocRfnum;
	}
	
	
    
}
