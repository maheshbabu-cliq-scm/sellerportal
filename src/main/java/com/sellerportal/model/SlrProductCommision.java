package com.sellerportal.model;

import java.io.Serializable;
import java.util.Date;

import org.apache.commons.lang.builder.ToStringBuilder;
import javax.persistence.*;

@Entity
@Table(name = "oct_slr_product_commision")
public class SlrProductCommision implements Serializable {

	@Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "spcrfnum_generator")
    @SequenceGenerator(name="spcrfnum_generator", sequenceName = "SLR_PROD_CMSN_SPCRFNUM_SEQ", allocationSize = 1)
    @Column(name = "SPCRFNUM")
    private Long spcrfnum;

    @Column(name = "COMMISION_TYPE", length = 1)
    private String commisionType;

    @Column(name = "COMMISION_VALUE", length = 11)
    private Float commisionValue;

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

    @Column(name = "COMMISION_STARTDATE")
    private Date commisionStartDate;

    @Column(name = "COMMISION_ENDDATE")
    private Date commisionEndDate;

    @Column(name = "COMMISION_ISACTIVE", length = 1)
    private String commisionIsActive;

    @Column(name = "DELIVERYMODE", length = 50)
    private String deliverymode;

    @Column(name = "FULFILMENTTYPE", length = 50)
    private String fulfilmenttype;

    @Column(name = "STORETYPE", length = 50)
    private String storetype;

    @Column(name = "CHANNELTYPE", length = 50)
    private String channeltype;

    @Column(name = "UPLOAD_ID", length = 1)
    private String uploadId;

    @Column(name = "APPROVAL_ID", length = 1)
    private String approvalId;

    @Column(name = "APPROVAL_DATE")
    private Date approvalDate;

    @Column(name = "DATA_COUNT", length = 25)
    private String datacount;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "COMMISSION_STATUS", nullable = false)
    private OctParam commissionStatus;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "SPCSPRFNUM", nullable = false)
    private SlrProduct slrProduct;

    /** full constructor */
    public SlrProductCommision(String commisionType, Float commisionValue, Date createdate, Long createdby, String deleted, Date modidate, Long modifiedby, com.sellerportal.model.SlrProduct slrProduct,String commisionIsActive,Date commisionEndDate,Date commisionStartDate) {
        this.commisionType = commisionType;
        this.commisionValue = commisionValue;
        this.createdate = createdate;
        this.createdby = createdby;
        this.deleted = deleted;
        this.modidate = modidate;
        this.modifiedby = modifiedby;
        this.slrProduct = slrProduct;
        this.commisionStartDate = commisionStartDate;
        this.commisionEndDate = commisionEndDate;
        this.commisionIsActive = commisionIsActive;
    }

    /** default constructor */
    public SlrProductCommision() {
    }

    /** minimal constructor */
    public SlrProductCommision(Date createdate, Long createdby, String deleted, Date modidate, Long modifiedby, com.sellerportal.model.SlrProduct slrProduct,String commisionIsActive,Date commisionEndDate,Date commisionStartDate) {
        this.createdate = createdate;
        this.createdby = createdby;
        this.deleted = deleted;
        this.modidate = modidate;
        this.modifiedby = modifiedby;
        this.slrProduct = slrProduct;
        this.commisionStartDate = commisionStartDate;
        this.commisionEndDate = commisionEndDate;
        this.commisionIsActive = commisionIsActive;
    }

    /** 
     * 		       auto_increment
     * 		    
     */
    public Long getSpcrfnum() {
        return this.spcrfnum;
    }

    public void setSpcrfnum(Long spcrfnum) {
        this.spcrfnum = spcrfnum;
    }

    public String getCommisionType() {
        return this.commisionType;
    }

    public void setCommisionType(String commisionType) {
        this.commisionType = commisionType;
    }

    public Float getCommisionValue() {
        return this.commisionValue;
    }

    public void setCommisionValue(Float commisionValue) {
        this.commisionValue = commisionValue;
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

    public com.sellerportal.model.SlrProduct getSlrProduct() {
        return this.slrProduct;
    }

    public void setSlrProduct(com.sellerportal.model.SlrProduct slrProduct) {
        this.slrProduct = slrProduct;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("spcrfnum", getSpcrfnum())
            .toString();
    }

	public Date getCommisionStartDate() {
		return commisionStartDate;
	}

	public void setCommisionStartDate(Date commisionStartDate) {
		this.commisionStartDate = commisionStartDate;
	}

	public Date getCommisionEndDate() {
		return commisionEndDate;
	}

	public void setCommisionEndDate(Date commisionEndDate) {
		this.commisionEndDate = commisionEndDate;
	}

	public String getCommisionIsActive() {
		return commisionIsActive;
	}

	public void setCommisionIsActive(String commisionIsActive) {
		this.commisionIsActive = commisionIsActive;
	}

	public String getFulfilmenttype() {
		return fulfilmenttype;
	}

	public void setFulfilmenttype(String fulfilmenttype) {
		this.fulfilmenttype = fulfilmenttype;
	}

	public String getStoretype() {
		return storetype;
	}

	public void setStoretype(String storetype) {
		this.storetype = storetype;
	}

	public String getChanneltype() {
		return channeltype;
	}

	public void setChanneltype(String channeltype) {
		this.channeltype = channeltype;
	}

	public String getDeliverymode() {
		return deliverymode;
	}

	public void setDeliverymode(String deliverymode) {
		this.deliverymode = deliverymode;
	}

	public String getUploadId() {
		return uploadId;
	}

	public void setUploadId(String uploadId) {
		this.uploadId = uploadId;
	}

	public String getApprovalId() {
		return approvalId;
	}

	public void setApprovalId(String approvalId) {
		this.approvalId = approvalId;
	}

	public Date getApprovalDate() {
		return approvalDate;
	}

	public void setApprovalDate(Date approvalDate) {
		this.approvalDate = approvalDate;
	}

	public com.sellerportal.model.OctParam getCommissionStatus() {
		return commissionStatus;
	}

	public void setCommissionStatus(com.sellerportal.model.OctParam commissionStatus) {
		this.commissionStatus = commissionStatus;
	}

	public String getDatacount() {
		return datacount;
	}

	public void setDatacount(String datacount) {
		this.datacount = datacount;
	}

}
