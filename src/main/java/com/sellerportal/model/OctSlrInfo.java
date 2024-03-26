package com.sellerportal.model;

import java.io.Serializable;
import java.util.Date;

import org.apache.commons.lang.builder.ToStringBuilder;
import javax.persistence.*;

@Entity
@Table(name = "oct_slr_info")
public class OctSlrInfo implements Serializable {

	@Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "slrinforfnum_generator")
    @SequenceGenerator(name = "slrinforfnum_generator", sequenceName = "OCT_SLR_INFO_SLRINFORFNUM_SEQ", allocationSize = 1)
    @Column(name = "SLRINFORFNUM")
    private Long slrinforfnum;

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

    @Column(name = "SLRINFOADDRESS", length = 128)
    private String slrinfoaddress;

    @Column(name = "SLRINFODESGNTN", length = 128)
    private String slrinfodesgntn;

    @Column(name = "SLRINFOEMAIL", length = 128)
    private String slrinfoemail;

    @Column(name = "SLRINFOFNAME", length = 128)
    private String slrinfofname;

    @Column(name = "SLRINFOPHONEO", length = 128)
    private String slrinfophoneo;

    @Column(name = "SLRINFOPHONEP", length = 128)
    private String slrinfophonep;

    @Column(name = "ISPROCESSED", length = 1)
    private String isProcessed;

    @Column(name = "ISAPPROVED", length = 1)
    private String isApproved;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "OCTSLRRFNUM", nullable = false)
    private OctSlr octSlr;
    
    /** full constructor */
    public OctSlrInfo(Date createdate, Long createdby, String deleted, Date modidate, Long modifiedby, Long orgid, String slrinfoaddress, String slrinfodesgntn, String slrinfoemail, String slrinfofname, String slrinfophoneo, String slrinfophonep, com.sellerportal.model.OctSlr octSlr,String isApproved,String isProcessed) {
        this.createdate = createdate;
        this.createdby = createdby;
        this.deleted = deleted;
        this.modidate = modidate;
        this.modifiedby = modifiedby;
        this.orgid = orgid;
        this.slrinfoaddress = slrinfoaddress;
        this.slrinfodesgntn = slrinfodesgntn;
        this.slrinfoemail = slrinfoemail;
        this.slrinfofname = slrinfofname;
        this.slrinfophoneo = slrinfophoneo;
        this.slrinfophonep = slrinfophonep;
        this.octSlr = octSlr;
        this.isProcessed = isProcessed;
        this.isApproved =  isApproved;
    }

    /** default constructor */
    public OctSlrInfo() {
    }

    /** minimal constructor */
    public OctSlrInfo(Date createdate, Long createdby, String deleted, Date modidate, Long modifiedby, Long orgid, com.sellerportal.model.OctSlr octSlr) {
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
    public Long getSlrinforfnum() {
        return this.slrinforfnum;
    }

    public void setSlrinforfnum(Long slrinforfnum) {
        this.slrinforfnum = slrinforfnum;
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

    public String getSlrinfoaddress() {
        return this.slrinfoaddress;
    }

    public void setSlrinfoaddress(String slrinfoaddress) {
        this.slrinfoaddress = slrinfoaddress;
    }

    public String getSlrinfodesgntn() {
        return this.slrinfodesgntn;
    }

    public void setSlrinfodesgntn(String slrinfodesgntn) {
        this.slrinfodesgntn = slrinfodesgntn;
    }

    public String getSlrinfoemail() {
        return this.slrinfoemail;
    }

    public void setSlrinfoemail(String slrinfoemail) {
        this.slrinfoemail = slrinfoemail;
    }

    public String getSlrinfofname() {
        return this.slrinfofname;
    }

    public void setSlrinfofname(String slrinfofname) {
        this.slrinfofname = slrinfofname;
    }

    public String getSlrinfophoneo() {
        return this.slrinfophoneo;
    }

    public void setSlrinfophoneo(String slrinfophoneo) {
        this.slrinfophoneo = slrinfophoneo;
    }

    public String getSlrinfophonep() {
        return this.slrinfophonep;
    }

    public void setSlrinfophonep(String slrinfophonep) {
        this.slrinfophonep = slrinfophonep;
    }

    public com.sellerportal.model.OctSlr getOctSlr() {
        return this.octSlr;
    }

    public void setOctSlr(com.sellerportal.model.OctSlr octSlr) {
        this.octSlr = octSlr;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("slrinforfnum", getSlrinforfnum())
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
