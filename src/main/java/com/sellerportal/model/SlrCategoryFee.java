package com.sellerportal.model;

import java.io.Serializable;
import java.util.Date;

import org.apache.commons.lang.builder.ToStringBuilder;
import javax.persistence.*;

@Entity
@Table(name = "oct_slr_category_fee")
public class SlrCategoryFee implements Serializable {

	 @Id
	    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "slr_category_fee_seq")
	    @SequenceGenerator(name = "slr_category_fee_seq", sequenceName = "SCF_SCFRFNUM_SEQ", allocationSize = 1)
	    @Column(name = "SCFRFNUM")
	    private Long scfrfnum;

	    @Column(name = "CREATEDATE", nullable = false)
	    private Date createdate;

	    @Column(name = "CREATEDBY", nullable = false, length = 20)
	    private Long createdby;

	    @Column(name = "DELETED", nullable = false, length = 1)
	    private String deleted;

	    @Column(name = "FEE_TYPE", length = 1)
	    private String feeType;

	    @Column(name = "FEE_VALUE", length = 38)
	    private Float feeValue;

	    @Column(name = "MODIDATE", nullable = false)
	    private Date modidate;

	    @Column(name = "MODIFIEDBY", nullable = false, length = 20)
	    private Long modifiedby;

	    @Column(name = "FEE_ACTIVE", length = 1)
	    private String feeActive;

	    @Column(name = "FEE_STARTDATE")
	    private Date feeStartDate;

	    @Column(name = "FEE_ENDDATE")
	    private Date feeEndDate;

	    @Column(name = "ISACCEPTED", length = 1)
	    private String isaccepted;

	    @ManyToOne(fetch = FetchType.LAZY)
	    @JoinColumn(name = "SCFFTMRFNUM", nullable = false)
	    private FeeTypeMaster feeTypeMaster;

	    @ManyToOne(fetch = FetchType.LAZY)
	    @JoinColumn(name = "SCFSCARFNUM", nullable = false)
	    private SlrCategoryAssociation slrCategoryAssociation;

    /** full constructor */
    public SlrCategoryFee(Date createdate, Long createdby, String deleted, String feeType, Float feeValue, Date modidate, Long modifiedby, com.sellerportal.model.FeeTypeMaster feeTypeMaster, com.sellerportal.model.SlrCategoryAssociation slrCategoryAssociation,String feeActive,Date feeStartDate,Date feeEndDate,String isaccepted) {
        this.createdate = createdate;
        this.createdby = createdby;
        this.deleted = deleted;
        this.feeType = feeType;
        this.feeValue = feeValue;
        this.modidate = modidate;
        this.modifiedby = modifiedby;
        this.feeTypeMaster = feeTypeMaster;
        this.slrCategoryAssociation = slrCategoryAssociation;
        this.feeActive = feeActive;
        this.feeStartDate = feeStartDate;
        this.feeEndDate = feeEndDate;
        this.isaccepted = isaccepted;
    }

    /** default constructor */
    public SlrCategoryFee() {
    }

    /** minimal constructor */
    public SlrCategoryFee(Date createdate, Long createdby, String deleted, Date modidate, Long modifiedby, com.sellerportal.model.FeeTypeMaster feeTypeMaster, com.sellerportal.model.SlrCategoryAssociation slrCategoryAssociation,String feeActive,Date feeStartDate,Date feeEndDate,String isaccepted) {
        this.createdate = createdate;
        this.createdby = createdby;
        this.deleted = deleted;
        this.modidate = modidate;
        this.modifiedby = modifiedby;
        this.feeTypeMaster = feeTypeMaster;
        this.slrCategoryAssociation = slrCategoryAssociation;
        this.feeActive = feeActive;
        this.feeStartDate = feeStartDate;
        this.feeEndDate = feeEndDate;
        this.isaccepted = isaccepted;
    }

    /** 
     * 		       auto_increment
     * 		    
     */
    public Long getScfrfnum() {
        return this.scfrfnum;
    }

    public void setScfrfnum(Long scfrfnum) {
        this.scfrfnum = scfrfnum;
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

    public String getFeeType() {
        return this.feeType;
    }

    public void setFeeType(String feeType) {
        this.feeType = feeType;
    }

    public Float getFeeValue() {
        return this.feeValue;
    }

    public void setFeeValue(Float feeValue) {
        this.feeValue = feeValue;
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

    public com.sellerportal.model.FeeTypeMaster getFeeTypeMaster() {
        return this.feeTypeMaster;
    }

    public void setFeeTypeMaster(com.sellerportal.model.FeeTypeMaster feeTypeMaster) {
        this.feeTypeMaster = feeTypeMaster;
    }

    public com.sellerportal.model.SlrCategoryAssociation getSlrCategoryAssociation() {
        return this.slrCategoryAssociation;
    }

    public void setSlrCategoryAssociation(com.sellerportal.model.SlrCategoryAssociation slrCategoryAssociation) {
        this.slrCategoryAssociation = slrCategoryAssociation;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("scfrfnum", getScfrfnum())
            .toString();
    }

	public String getFeeActive() {
		return feeActive;
	}

	public void setFeeActive(String feeActive) {
		this.feeActive = feeActive;
	}

	public Date getFeeStartDate() {
		return feeStartDate;
	}

	public void setFeeStartDate(Date feeStartDate) {
		this.feeStartDate = feeStartDate;
	}

	public Date getFeeEndDate() {
		return feeEndDate;
	}

	public void setFeeEndDate(Date feeEndDate) {
		this.feeEndDate = feeEndDate;
	}

	public String getIsaccepted() {
		return isaccepted;
	}

	public void setIsaccepted(String isaccepted) {
		this.isaccepted = isaccepted;
	}
    
    
	
}
