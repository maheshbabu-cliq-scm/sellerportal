package com.sellerportal.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import org.apache.commons.lang.builder.ToStringBuilder;
import javax.persistence.*;

@Entity
@Table(name = "oct_fee_type_master")
public class FeeTypeMaster implements Serializable {

	@Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "fee_type_master_seq")
    @SequenceGenerator(name = "fee_type_master_seq", sequenceName = "FEETP_FTMRFNUM_SEQ", allocationSize = 1)
    @Column(name = "FTMRFNUM")
    private Long ftmrfnum;

    @Column(name = "CREATEDATE", nullable = false)
    private Date createdate;

    @Column(name = "CREATEDBY", nullable = false, length = 20)
    private Long createdby;

    @Column(name = "DELETED", nullable = false, length = 1)
    private String deleted;

    @Column(name = "FTMCODE", length = 128)
    private String ftmcode;

    @Column(name = "FTMNAME", length = 128)
    private String ftmname;

    @Column(name = "FTMTYPE", length = 1)
    private String ftmtype;

    @Column(name = "MODIDATE", nullable = false)
    private Date modidate;

    @Column(name = "MODIFIEDBY", nullable = false, length = 20)
    private Long modifiedby;

    @Column(name = "FTMVALUETYPE", nullable = false, length = 1)
    private String ftmvaluetype;

    @Column(name = "FTMPARENTCODE", length = 128)
    private String ftmparentcode;

    @Column(name = "FEEVALUE", length = 20)
    private Long feeValue;

    @OneToMany(mappedBy = "feeTypeMaster", fetch = FetchType.LAZY)
    @Transient
    private Set<SlrProductFee> slrProductFees;

    @OneToMany(mappedBy = "feeTypeMaster", fetch = FetchType.LAZY)
    @Transient
    private Set<SlrCategoryFee> slrCategoryFees;
    

    /** full constructor */
    public FeeTypeMaster(Date createdate, Long createdby, String deleted, String ftmcode, String ftmname, String ftmtype, Date modidate, Long modifiedby, Set<SlrProductFee> slrProductFees, Set<SlrCategoryFee> slrCategoryFees,Long feeValue) {
        this.createdate = createdate;
        this.createdby = createdby;
        this.deleted = deleted;
        this.ftmcode = ftmcode;
        this.ftmname = ftmname;
        this.ftmtype = ftmtype;
        this.modidate = modidate;
        this.modifiedby = modifiedby;
        this.slrProductFees = slrProductFees;
        this.slrCategoryFees = slrCategoryFees;
        this.feeValue = feeValue;
    }

    /** default constructor */
    public FeeTypeMaster() {
    }

    /** minimal constructor */
    public FeeTypeMaster(Date createdate, Long createdby, String deleted, Date modidate, Long modifiedby, Set<SlrProductFee> slrProductFees, Set<SlrCategoryFee> slrCategoryFees) {
        this.createdate = createdate;
        this.createdby = createdby;
        this.deleted = deleted;
        this.modidate = modidate;
        this.modifiedby = modifiedby;
        this.slrProductFees = slrProductFees;
        this.slrCategoryFees = slrCategoryFees;
    }

    /** 
     * 		       auto_increment
     * 		    
     */
    public Long getFtmrfnum() {
        return this.ftmrfnum;
    }

    public void setFtmrfnum(Long ftmrfnum) {
        this.ftmrfnum = ftmrfnum;
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

    public String getFtmcode() {
        return this.ftmcode;
    }

    public void setFtmcode(String ftmcode) {
        this.ftmcode = ftmcode;
    }

    public String getFtmname() {
        return this.ftmname;
    }

    public void setFtmname(String ftmname) {
        this.ftmname = ftmname;
    }

    public String getFtmtype() {
        return this.ftmtype;
    }

    public void setFtmtype(String ftmtype) {
        this.ftmtype = ftmtype;
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

    public Set<SlrProductFee> getSlrProductFees() {
        return this.slrProductFees;
    }

    public void setSlrProductFees(Set<SlrProductFee> slrProductFees) {
        this.slrProductFees = slrProductFees;
    }

    public Set<SlrCategoryFee> getSlrCategoryFees() {
        return this.slrCategoryFees;
    }

    public void setSlrCategoryFees(Set<SlrCategoryFee> slrCategoryFees) {
        this.slrCategoryFees = slrCategoryFees;
    }

    public String getFtmvaluetype() {
		return ftmvaluetype;
	}

	public void setFtmvaluetype(String ftmvaluetype) {
		this.ftmvaluetype = ftmvaluetype;
	}

	public String getFtmparentcode() {
		return ftmparentcode;
	}

	public void setFtmparentcode(String ftmparentcode) {
		this.ftmparentcode = ftmparentcode;
	}

    public String toString() {
        return new ToStringBuilder(this)
            .append("ftmrfnum", getFtmrfnum())
            .toString();
    }

	public Long getFeeValue() {
		return feeValue;
	}

	public void setFeeValue(Long feeValue) {
		this.feeValue = feeValue;
	}

}
