package com.sellerportal.model;

import java.io.Serializable;
import java.util.Date;

import org.apache.commons.lang.builder.ToStringBuilder;
import javax.persistence.*;

@Entity
@Table(name = "oct_slr_product_fee")
public class SlrProductFee implements Serializable {

	@Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "spfrfnum_seq")
    @SequenceGenerator(name = "spfrfnum_seq", sequenceName = "SPFRFNUM_AUTOINC_SEQ", allocationSize = 1)
    @Column(name = "SPFRFNUM")
    private Long spfrfnum;

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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "SPFFTMRFNUM", nullable = false)
    private FeeTypeMaster feeTypeMaster;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "SPFSPRFNUM", nullable = false)
    private SlrProduct slrProduct;
    

    /** full constructor */
    public SlrProductFee(Date createdate, Long createdby, String deleted, String feeType, Float feeValue, Date modidate, Long modifiedby, com.sellerportal.model.FeeTypeMaster feeTypeMaster, com.sellerportal.model.SlrProduct slrProduct,String feeActive,Date feeStartDate,Date feeEndDate) {
        this.createdate = createdate;
        this.createdby = createdby;
        this.deleted = deleted;
        this.feeType = feeType;
        this.feeValue = feeValue;
        this.modidate = modidate;
        this.modifiedby = modifiedby;
        this.feeTypeMaster = feeTypeMaster;
        this.slrProduct = slrProduct;
        this.feeActive = feeActive;
        this.feeStartDate = feeStartDate;
        this.feeEndDate = feeEndDate;
    }

    /** default constructor */
    public SlrProductFee() {
    }

    /** minimal constructor */
    public SlrProductFee(Date createdate, Long createdby, String deleted, Date modidate, Long modifiedby, com.sellerportal.model.FeeTypeMaster feeTypeMaster, com.sellerportal.model.SlrProduct slrProduct,String feeActive,Date feeStartDate,Date feeEndDate) {
        this.createdate = createdate;
        this.createdby = createdby;
        this.deleted = deleted;
        this.modidate = modidate;
        this.modifiedby = modifiedby;
        this.feeTypeMaster = feeTypeMaster;
        this.slrProduct = slrProduct;
        this.feeActive = feeActive;
        this.feeStartDate = feeStartDate;
        this.feeEndDate = feeEndDate;
    }

    /** 
     * 		       auto_increment
     * 		    
     */
    public Long getSpfrfnum() {
        return this.spfrfnum;
    }

    public void setSpfrfnum(Long spfrfnum) {
        this.spfrfnum = spfrfnum;
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

    public com.sellerportal.model.SlrProduct getSlrProduct() {
        return this.slrProduct;
    }

    public void setSlrProduct(com.sellerportal.model.SlrProduct slrProduct) {
        this.slrProduct = slrProduct;
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

	public String toString() {
        return new ToStringBuilder(this)
            .append("spfrfnum", getSpfrfnum())
            .toString();
    }

}
