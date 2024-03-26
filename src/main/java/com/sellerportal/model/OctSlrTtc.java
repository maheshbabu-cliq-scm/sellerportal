package com.sellerportal.model;

import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name = "OCT_SLR_TAX_TYPE_CODE")
public class OctSlrTtc {

	@Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "OCT_SLR_TTC_SLRTTCRFNUM_SEQ")
    @SequenceGenerator(name = "OCT_SLR_TTC_SLRTTCRFNUM_SEQ", sequenceName = "OCT_SLR_TTC_SLRTTCRFNUM_SEQ", allocationSize = 1)
    @Column(name = "SLRTTCRFNUM")
    private Long slrttcrfnum;

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
    @JoinColumn(name = "OCTSLRRFNUM", nullable = false)
    private OctSlr octSlr;

    @ManyToOne
    @JoinColumn(name = "SLRTTCRECEIPT", nullable = false)
    private OctParam slrttcreceipt;

    @ManyToOne
    @JoinColumn(name = "SLRTTCTYPE", nullable = false)
    private OctParam slrttctype;

    @ManyToOne
    @JoinColumn(name = "SLRTTCCODE", nullable = false)
    private OctParam slrttccode;

    
    
    /** full constructor */
    public OctSlrTtc(Date createdate, Long createdby, String deleted, Date modidate, Long modifiedby, Long orgid, com.sellerportal.model.OctSlr octSlr, com.sellerportal.model.OctParam slrttctype, com.sellerportal.model.OctParam slrttccode, com.sellerportal.model.OctParam slrttcreceipt) {
        this.createdate = createdate;
        this.createdby = createdby;
        this.deleted = deleted;
        this.modidate = modidate;
        this.modifiedby = modifiedby;
        this.orgid = orgid;
        this.octSlr = octSlr;
        this.slrttctype = slrttctype;
        this.slrttccode = slrttccode;
        this.slrttcreceipt = slrttcreceipt;
    }
    
    
    /** default constructor */
    public OctSlrTtc() {
    }
    
    
    /** minimal constructor */
    public OctSlrTtc(Date createdate, Long createdby, String deleted, Date modidate, Long modifiedby, Long orgid, com.sellerportal.model.OctSlr octSlr) {
        this.createdate = createdate;
        this.createdby = createdby;
        this.deleted = deleted;
        this.modidate = modidate;
        this.modifiedby = modifiedby;
        this.orgid = orgid;
        this.octSlr = octSlr;
    }


	public Long getSlrttcrfnum() {
		return slrttcrfnum;
	}


	public void setSlrttcrfnum(Long slrttcrfnum) {
		this.slrttcrfnum = slrttcrfnum;
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


	public OctParam getSlrttctype() {
		return slrttctype;
	}


	public void setSlrttctype(OctParam slrttctype) {
		this.slrttctype = slrttctype;
	}


	public OctParam getSlrttccode() {
		return slrttccode;
	}


	public void setSlrttccode(OctParam slrttccode) {
		this.slrttccode = slrttccode;
	}


	public OctParam getSlrttcreceipt() {
		return slrttcreceipt;
	}


	public void setSlrttcreceipt(OctParam slrttcreceipt) {
		this.slrttcreceipt = slrttcreceipt;
	}


	public com.sellerportal.model.OctSlr getOctSlr() {
		return octSlr;
	}


	public void setOctSlr(com.sellerportal.model.OctSlr octSlr) {
		this.octSlr = octSlr;
	}
    
    
    
}
