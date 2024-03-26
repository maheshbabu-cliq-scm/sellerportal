package com.sellerportal.model;

import java.io.Serializable;
import java.util.Date;

import org.apache.commons.lang.builder.ToStringBuilder;
import javax.persistence.*;

@Entity
@Table(name = "oct_slr_bnk")

/** @author Hibernate CodeGenerator */
public class OctSlrBnk implements Serializable {

	@Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "slrbnkrfnum_generator")
    @SequenceGenerator(name = "slrbnkrfnum_generator", sequenceName = "OCT_SLR_BNK_SLRBNKRFNUM_SEQ", allocationSize = 1)
    @Column(name = "SLRBNKRFNUM")
    private Long slrbnkrfnum;

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

    @Column(name = "SLRBNKACCNAME", length = 128)
    private String slrbnkaccname;

    @Column(name = "SLRBNKACCNUMBER", length = 128)
    private String slrbnkaccnumber;

    @Column(name = "SLRBNKBRANCH", length = 128)
    private String slrbnkbranch;

    @Column(name = "SLRBNKIFSCCODE", length = 128)
    private String slrbnkifsccode;

    @Column(name = "SLRBNKNAME", length = 128)
    private String slrbnkname;

    @Column(name = "ISPROCESSED", length = 1)
    private String isProcessed;

    @Column(name = "ISAPPROVED", length = 1)
    private String isApproved;

    @Column(name = "SLRBNKADDRESS", length = 128)
    private String slrbnkaddress;

    @Column(name = "SLRBNKRECONACC", length = 128)
    private String slrbnkReconAcc;

    @Column(name = "SLRBNKHOUSEBNK", length = 128)
    private String slrbnkHouseBnk;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "OCTSLRRFNUM", nullable = false)
    private OctSlr octSlr;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "SLRBNKPAYMENT", nullable = false)
    private OctParam slrbnkpayment;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "SLRBNKMINORITYINDICATOR", nullable = false)
    private OctParam slrbnkMinorityIndicator;
    
    /** full constructor */
    public OctSlrBnk(Date createdate, Long createdby, String deleted, Date modidate, Long modifiedby, Long orgid, String slrbnkaccname, String slrbnkaccnumber, String slrbnkbranch, String slrbnkifsccode, String slrbnkname, OctParam slrbnkpayment, com.sellerportal.model.OctSlr octSlr, String isApproved, String isProcessed,String slrbnkaddress,OctParam slrbnkMinorityIndicator,String slrbnkReconAcc,String slrbnkHouseBnk) {
        this.createdate = createdate;
        this.createdby = createdby;
        this.deleted = deleted;
        this.modidate = modidate;
        this.modifiedby = modifiedby;
        this.orgid = orgid;
        this.slrbnkaccname = slrbnkaccname;
        this.slrbnkaccnumber = slrbnkaccnumber;
        this.slrbnkbranch = slrbnkbranch;
        this.slrbnkifsccode = slrbnkifsccode;
        this.slrbnkname = slrbnkname;
        this.slrbnkpayment = slrbnkpayment;
        this.octSlr = octSlr;
        this.isApproved = isApproved;
        this.isProcessed = isProcessed;
        this.slrbnkaddress = slrbnkaddress;
        this.slrbnkMinorityIndicator = slrbnkMinorityIndicator;
        this.slrbnkHouseBnk = slrbnkHouseBnk; 
        this.slrbnkReconAcc = slrbnkReconAcc;
    }

    /** default constructor */
    public OctSlrBnk() {
    }

    /** minimal constructor */
    public OctSlrBnk(Date createdate, Long createdby, String deleted, Date modidate, Long modifiedby, Long orgid, com.sellerportal.model.OctSlr octSlr) {
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
    public Long getSlrbnkrfnum() {
        return this.slrbnkrfnum;
    }

    public void setSlrbnkrfnum(Long slrbnkrfnum) {
        this.slrbnkrfnum = slrbnkrfnum;
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

    public String getSlrbnkaccname() {
        return this.slrbnkaccname;
    }

    public void setSlrbnkaccname(String slrbnkaccname) {
        this.slrbnkaccname = slrbnkaccname;
    }

    public String getSlrbnkaccnumber() {
        return this.slrbnkaccnumber;
    }

    public void setSlrbnkaccnumber(String slrbnkaccnumber) {
        this.slrbnkaccnumber = slrbnkaccnumber;
    }

    public String getSlrbnkbranch() {
        return this.slrbnkbranch;
    }

    public void setSlrbnkbranch(String slrbnkbranch) {
        this.slrbnkbranch = slrbnkbranch;
    }

    public String getSlrbnkifsccode() {
        return this.slrbnkifsccode;
    }

    public void setSlrbnkifsccode(String slrbnkifsccode) {
        this.slrbnkifsccode = slrbnkifsccode;
    }

    public String getSlrbnkname() {
        return this.slrbnkname;
    }

    public void setSlrbnkname(String slrbnkname) {
        this.slrbnkname = slrbnkname;
    }

    public OctParam getSlrbnkpayment() {
        return this.slrbnkpayment;
    }

    public void setSlrbnkpayment(OctParam slrbnkpayment) {
        this.slrbnkpayment = slrbnkpayment;
    }

    public com.sellerportal.model.OctSlr getOctSlr() {
        return this.octSlr;
    }

    public void setOctSlr(com.sellerportal.model.OctSlr octSlr) {
        this.octSlr = octSlr;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("slrbnkrfnum", getSlrbnkrfnum())
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

	public String getSlrbnkaddress() {
		return slrbnkaddress;
	}

	public void setSlrbnkaddress(String slrbnkaddress) {
		this.slrbnkaddress = slrbnkaddress;
	}

	public OctParam getSlrbnkMinorityIndicator() {
		return slrbnkMinorityIndicator;
	}

	public void setSlrbnkMinorityIndicator(OctParam slrbnkMinorityIndicator) {
		this.slrbnkMinorityIndicator = slrbnkMinorityIndicator;
	}

	public String getSlrbnkHouseBnk() {
		return slrbnkHouseBnk;
	}

	public void setSlrbnkHouseBnk(String slrbnkHouseBnk) {
		this.slrbnkHouseBnk = slrbnkHouseBnk;
	}

	public String getSlrbnkReconAcc() {
		return slrbnkReconAcc;
	}

	public void setSlrbnkReconAcc(String slrbnkReconAcc) {
		this.slrbnkReconAcc = slrbnkReconAcc;
	}
	
	
}
