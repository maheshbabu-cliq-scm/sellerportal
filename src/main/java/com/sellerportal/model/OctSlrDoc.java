package com.sellerportal.model;

import java.io.Serializable;
import java.util.Date;

import org.apache.commons.lang.builder.ToStringBuilder;
import javax.persistence.*;

@Entity
@Table(name = "oct_slr_doc")
public class OctSlrDoc implements Serializable {

	@Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "slrdocrfnum_generator")
    @SequenceGenerator(name="slrdocrfnum_generator", sequenceName = "OCT_SLR_DOC_SLRDOCRFNUM_SEQ", allocationSize = 1)
    @Column(name = "SLRDOCRFNUM")
    private Long slrdocrfnum;

    @Column(name = "CREATEDATE", nullable = false)
    private Date createdate;

    @Column(name = "CREATEDBY", nullable = false, length = 20)
    private Long createdby;

    @Column(name = "DELETED", nullable = false, length = 1)
    private String deleted;

    @Column(name = "MODIDATE", nullable = false)
    private Date modidate;

    @Column(name = "MODIFIEDBY", nullable = false, length = 20)
    private Long modifiedby;

    @Column(name = "ORGID", nullable = false, length = 20)
    private Long orgid;

    @Column(name = "SLRDOCFILENAME", length = 128)
    private String slrdocfilename;

    @Column(name = "SLRDOCTEMPLATE", length = 128)
    private String slrdoctemplate;

    @Column(name = "ISPROCESSED", length = 1)
    private String isProcessed;

    @Column(name = "ISAPPROVED", length = 1)
    private String isApproved;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "OCTSLRRFNUM", nullable = false)
    private OctSlr octSlr;
    

    /** full constructor */
    public OctSlrDoc(Date createdate, Long createdby, String deleted, Date modidate, Long modifiedby, Long orgid, String slrdocfilename, String slrdoctemplate, com.sellerportal.model.OctSlr octSlr,String isApproved, String isProcessed) {
        this.createdate = createdate;
        this.createdby = createdby;
        this.deleted = deleted;
        this.modidate = modidate;
        this.modifiedby = modifiedby;
        this.orgid = orgid;
        this.slrdocfilename = slrdocfilename;
        this.slrdoctemplate = slrdoctemplate;
        this.octSlr = octSlr;
        this.isProcessed = isProcessed;
        this.isApproved = isApproved;
    }

    /** default constructor */
    public OctSlrDoc() {
    }

    /** minimal constructor */
    public OctSlrDoc(Date createdate, Long createdby, String deleted, Date modidate, Long modifiedby, Long orgid, com.sellerportal.model.OctSlr octSlr) {
        this.createdate = createdate;
        this.createdby = createdby;
        this.deleted = deleted;
        this.modidate = modidate;
        this.modifiedby = modifiedby;
        this.orgid = orgid;
        this.octSlr = octSlr;
    }

    /** 
     * 		       auto_increment
     * 		    
     */
    public Long getSlrdocrfnum() {
        return this.slrdocrfnum;
    }

    public void setSlrdocrfnum(Long slrdocrfnum) {
        this.slrdocrfnum = slrdocrfnum;
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

    public Long getOrgid() {
        return this.orgid;
    }

    public void setOrgid(Long orgid) {
        this.orgid = orgid;
    }

    public String getSlrdocfilename() {
        return this.slrdocfilename;
    }

    public void setSlrdocfilename(String slrdocfilename) {
        this.slrdocfilename = slrdocfilename;
    }

    public String getSlrdoctemplate() {
        return this.slrdoctemplate;
    }

    public void setSlrdoctemplate(String slrdoctemplate) {
        this.slrdoctemplate = slrdoctemplate;
    }

    public com.sellerportal.model.OctSlr getOctSlr() {
        return this.octSlr;
    }

    public void setOctSlr(com.sellerportal.model.OctSlr octSlr) {
        this.octSlr = octSlr;
    }
    
	public String toString() {
        return new ToStringBuilder(this)
            .append("slrdocrfnum", getSlrdocrfnum())
            .toString();
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
	
	

}
