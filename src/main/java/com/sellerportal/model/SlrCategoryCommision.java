package com.sellerportal.model;

import java.io.Serializable;
import java.util.Date;

import org.apache.commons.lang.builder.ToStringBuilder;
import javax.persistence.*;

@Entity
@Table(name = "oct_slr_category_commision")
public class SlrCategoryCommision implements Serializable {

	@Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "slr_category_commision_seq")
    @SequenceGenerator(name = "slr_category_commision_seq", sequenceName = "SCC_SCCRFNUM_SEQ", allocationSize = 1)
    @Column(name = "SCCRFNUM")
    private Long sccrfnum;

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

    @Column(name = "COMMISSION_ACTIVE", length = 1)
    private String active;

    @Column(name = "ISACCEPTED", length = 1)
    private String isaccepted;

    @Column(name = "COMMISSION_STARTDATE")
    private Date startDate;

    @Column(name = "COMMISSION_ENDDATE")
    private Date endDate;

    @Column(name = "DELIVERYMODE", length = 50)
    private String deliverymode;

    @Column(name = "FULFILMENTTYPE", length = 50)
    private String fulfilmenttype;

    @Column(name = "STORETYPE", length = 50)
    private String storetype;

    @Column(name = "CHANNELTYPE", length = 50)
    private String channeltype;

    @Column(name = "UPLOAD_ID", length = 30)
    private String uploadId;

    @Column(name = "APPROVAL_ID", length = 30)
    private String approvalId;

    @Column(name = "APPROVAL_DATE")
    private Date approvalDate;

    @Column(name = "DATA_COUNT", length = 25)
    private String datacount;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "SCCSCARFNUM", nullable = false)
    private SlrCategoryAssociation slrCategoryAssociation;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "COMMISSION_STATUS", nullable = false)
    private OctParam commissionStatus;
    

    /** full constructor */
    public SlrCategoryCommision(String commisionType,Float commisionValue, Date createdate, Long createdby, String deleted, Date modidate, Long modifiedby, com.sellerportal.model.SlrCategoryAssociation slrCategoryAssociation,String active,Date startDate,Date endDate,String isaccepted) {
        this.commisionType = commisionType;
        this.commisionValue = commisionValue;
        this.createdate = createdate;
        this.createdby = createdby;
        this.deleted = deleted;
        this.modidate = modidate;
        this.modifiedby = modifiedby;
        this.slrCategoryAssociation = slrCategoryAssociation;
        this.active = active;
        this.startDate = startDate;
        this.endDate = endDate;
        this.isaccepted = isaccepted;
    }

    /** default constructor */
    public SlrCategoryCommision() {
    }

    /** minimal constructor */
    public SlrCategoryCommision(Date createdate, Long createdby, String deleted, Date modidate, Long modifiedby, com.sellerportal.model.SlrCategoryAssociation slrCategoryAssociation,String isaccepted) {
        this.createdate = createdate;
        this.createdby = createdby;
        this.deleted = deleted;
        this.modidate = modidate;
        this.modifiedby = modifiedby;
        this.slrCategoryAssociation = slrCategoryAssociation;
    }

    /** 
     * 		       auto_increment
     * 		    
     */
    public Long getSccrfnum() {
        return this.sccrfnum;
    }

    public void setSccrfnum(Long sccrfnum) {
        this.sccrfnum = sccrfnum;
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

    public com.sellerportal.model.SlrCategoryAssociation getSlrCategoryAssociation() {
        return this.slrCategoryAssociation;
    }

    public void setSlrCategoryAssociation(com.sellerportal.model.SlrCategoryAssociation slrCategoryAssociation) {
        this.slrCategoryAssociation = slrCategoryAssociation;
    }
    
    public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public String getActive() {
		return active;
	}

	public void setActive(String active) {
		this.active = active;
	}

	public String toString() {
        return new ToStringBuilder(this)
            .append("sccrfnum", getSccrfnum())
            .toString();
    }

	public String getIsaccepted() {
		return isaccepted;
	}

	public void setIsaccepted(String isaccepted) {
		this.isaccepted = isaccepted;
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
