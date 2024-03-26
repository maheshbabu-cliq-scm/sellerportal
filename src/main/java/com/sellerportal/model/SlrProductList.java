package com.sellerportal.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import org.apache.commons.lang.builder.ToStringBuilder;
import javax.persistence.*;

@Entity
@Table(name = "OCT_SLR_PRODUCT_LIST")
public class SlrProductList implements Serializable {

	 @Id
	    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "spl_splrfnum_seq")
	    @SequenceGenerator(name = "spl_splrfnum_seq", sequenceName = "SPL_SPLRFNUM_SEQ", allocationSize = 1)
	    @Column(name = "SPLRFNUM")
	    private Long splrfnum;

	    @Column(name = "APPROVALREMARK", length = 256)
	    private String approvalremark;

	    @Column(name = "CREATEDATE", nullable = false)
	    private Date createdate;

	    @Column(name = "CREATEDBY", nullable = false)
	    private Long createdby;

	    @Column(name = "DELETED", nullable = false, length = 1)
	    private String deleted;

	    @Column(name = "ENDDATE")
	    private Date enddate;

	    @Column(name = "MODIDATE", nullable = false)
	    private Date modidate;

	    @Column(name = "MODIFIEDBY", nullable = false)
	    private Long modifiedby;

	    @Column(name = "SPLISACTIVE", length = 1)
	    private String splisactive;

	    @Column(name = "SPLUSSID", length = 40)
	    private String splussid;

	    @Column(name = "STARTDATE")
	    private Date startdate;

	    @Column(name = "INWARDDATE")
	    private Date inwarddate;

	    @Column(name = "SPLWIZARDSTATUS", length = 30)
	    private String splwizardstatus;

	    @Column(name = "SPLLISTINGID", length = 30)
	    private String spllistingid;

	    @Column(name = "ISPROCESSED", length = 1)
	    private String isprocessed;

	    @Column(name = "CREATEDVIA", length = 2)
	    private String createdvia;

	    @Column(name = "SLRHSNCODE", length = 50)
	    private String slrHSNCode;

	    @Column(name = "ISJWLPCMSEND", length = 10)
	    private String isJwlPcmSend;

	    @Column(name = "FIFOPRIORITY")
	    private Integer fifoPriority;

	    @Column(name = "SPLLENGTH", length = 10)
	    private String splLength;

	    @Column(name = "SPLWIDTH", length = 10)
	    private String splWidth;

	    @Column(name = "SPLHEIGHT", length = 10)
	    private String splHeight;

	    @Column(name = "SPLWEIGHT", length = 10)
	    private String splWeight;

	    @Column(name = "SELLNOWSKUEDIT", length = 1)
	    private String sellNowSkuedit;

	    @Column(name = "CMTRFNUM1")
	    private Long cmtrfnum1;

	    @Column(name = "CMTRFNUM2")
	    private Long cmtrfnum2;

	    @Column(name = "CMTRFNUM3")
	    private Long cmtrfnum3;

	    @Column(name = "CMTRFNUM4")
	    private Long cmtrfnum4;

	    @Column(name = "SPBRANDCODE", length = 50)
	    private String spbrandcode;

	    @Column(name = "SPBRANDNAME", length = 1024)
	    private String spbrandname;

	    @Column(name = "ISSKUEDIT", length = 1)
	    private String isSkuedit;

	    @ManyToOne
	    @JoinColumn(name = "SPLCMTRFNUM", nullable = false)
	    private Ismcmt ismcmt;

	    @ManyToOne
	    @JoinColumn(name = "SPLPARAMSTATUS", nullable = false)
	    private OctParam octParam;

	    @ManyToOne
	    @JoinColumn(name = "SPLSLRRFNUM", nullable = false)
	    private OctSlr octSlr;

	    @ManyToOne
	    @JoinColumn(name = "REQUESTEDFOR")
	    private OctParam requestedfor;

	    @OneToMany(mappedBy = "slrProductList")
	    private Set<SlrPbi> slrPbis;

	    @OneToMany(mappedBy = "slrProductList")
	    @Transient
	    private Set<SlrProductListVideo> slrProductListVideos;

	    @OneToMany(mappedBy = "slrProductList")
	    @Transient
	    private Set<SlrProductListImg> slrProductListImgs;

	    @OneToMany(mappedBy = "spladsplrfnum")
	    @Transient
	    private Set<SlrProdListAttrData> slrProdListAttrDatas;

	 
	    @OneToMany(mappedBy = "slrProductList")
	    @Transient
	    private Set<ProductSuggestion> productSuggestions;

	    @Column(name = "BATCHID", length = 1024)
	    private String batchId;
    
	/** full constructor */
    public SlrProductList(String approvalremark, Date createdate, Long createdby, String deleted, Date enddate, Date inwarddate, Date modidate, Long modifiedby, String splisactive, String splussid,String splwizardstatus,String spllistingid, Date startdate,String isprocessed,String createdvia, com.sellerportal.model.Ismcmt ismcmt, com.sellerportal.model.OctParam octParam,com.sellerportal.model.OctParam requestedfor, com.sellerportal.model.OctSlr octSlr, Set<SlrProductListVideo> slrProductListVideos,Set<ProductSuggestion> productSuggestions, Set<SlrProductListImg> slrProductListImgs, Set<SlrPbi> slrPbis, Set<SlrProdListAttrData> slrProdListAttrDatas) {
        this.approvalremark = approvalremark;
        this.createdate = createdate;
        this.createdby = createdby;
        this.deleted = deleted;
        this.enddate = enddate;
        this.modidate = modidate;
        this.modifiedby = modifiedby;
        this.splisactive = splisactive;
        this.splussid = splussid;
        this.startdate = startdate;
        this.inwarddate = inwarddate;
        this.createdvia = createdvia;
        this.ismcmt = ismcmt;
        this.octParam = octParam;
        this.octSlr = octSlr;
        this.slrProductListVideos = slrProductListVideos;
        this.slrProductListImgs = slrProductListImgs;
        this.splwizardstatus = splwizardstatus;
        this.spllistingid = spllistingid;
        this.requestedfor = requestedfor;
        this.isprocessed = isprocessed;
        this.slrPbis = slrPbis;
        this.productSuggestions = productSuggestions;
        this.slrProdListAttrDatas = slrProdListAttrDatas;
    }

    /** default constructor */
    public SlrProductList() {
    }

    /** minimal constructor */
    public SlrProductList(Date createdate, Long createdby, String deleted, Date modidate, Long modifiedby, com.sellerportal.model.Ismcmt ismcmt, com.sellerportal.model.OctParam octParam, com.sellerportal.model.OctSlr octSlr, Set<SlrProductListVideo> slrProductListVideos,Set<ProductSuggestion> productSuggestions, Set<SlrProductListImg> slrProductListImgs, Set<SlrPbi> slrPbis, Set<SlrProdListAttrData> slrProdListAttrDatas) {
        this.createdate = createdate;
        this.createdby = createdby;
        this.deleted = deleted;
        this.modidate = modidate;
        this.modifiedby = modifiedby;
        this.ismcmt = ismcmt;
        this.octParam = octParam;
        this.octSlr = octSlr;
        this.slrProductListVideos = slrProductListVideos;
        this.slrProductListImgs = slrProductListImgs;
        this.slrPbis = slrPbis;
        this.productSuggestions = productSuggestions;
        this.slrProdListAttrDatas = slrProdListAttrDatas;
    }

    public Long getSplrfnum() {
        return this.splrfnum;
    }

    public void setSplrfnum(Long splrfnum) {
        this.splrfnum = splrfnum;
    }

    public String getApprovalremark() {
        return this.approvalremark;
    }

    public void setApprovalremark(String approvalremark) {
        this.approvalremark = approvalremark;
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

    public Date getEnddate() {
        return this.enddate;
    }

    public void setEnddate(Date enddate) {
        this.enddate = enddate;
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

    public String getSplisactive() {
        return this.splisactive;
    }

    public void setSplisactive(String splisactive) {
        this.splisactive = splisactive;
    }

    public String getSplussid() {
        return this.splussid;
    }

    public void setSplussid(String splussid) {
        this.splussid = splussid;
    }

    public Date getStartdate() {
        return this.startdate;
    }

    public void setStartdate(Date startdate) {
        this.startdate = startdate;
    }
    
    public Date getInwarddate() {
		return inwarddate;
	}

	public void setInwarddate(Date inwarddate) {
		this.inwarddate = inwarddate;
	}
	
	public com.sellerportal.model.Ismcmt getIsmcmt() {
        return this.ismcmt;
    }

    public void setIsmcmt(com.sellerportal.model.Ismcmt ismcmt) {
        this.ismcmt = ismcmt;
    }

    public com.sellerportal.model.OctParam getOctParam() {
        return this.octParam;
    }

    public void setOctParam(com.sellerportal.model.OctParam octParam) {
        this.octParam = octParam;
    }

    public com.sellerportal.model.OctSlr getOctSlr() {
        return this.octSlr;
    }

    public void setOctSlr(com.sellerportal.model.OctSlr octSlr) {
        this.octSlr = octSlr;
    }

    public Set<SlrProductListVideo> getSlrProductListVideos() {
        return this.slrProductListVideos;
    }

    public void setSlrProductListVideos(Set<SlrProductListVideo> slrProductListVideos) {
        this.slrProductListVideos = slrProductListVideos;
    }
    
    public Set<ProductSuggestion> getProductSuggestions() {
		return productSuggestions;
	}

	public void setProductSuggestions(Set<ProductSuggestion> productSuggestions) {
		this.productSuggestions = productSuggestions;
	}

	public Set<SlrProductListImg> getSlrProductListImgs() {
        return this.slrProductListImgs;
    }
    
    public Set<SlrPbi> getSlrPbis() {
		return slrPbis;
	}

	public void setSlrPbis(Set<SlrPbi> slrPbis) {
		this.slrPbis = slrPbis;
	}
	
	public Set<SlrProdListAttrData> getSlrProdListAttrDatas() {
		return slrProdListAttrDatas;
	}

	public void setSlrProdListAttrDatas(Set<SlrProdListAttrData> slrProdListAttrDatas) {
		this.slrProdListAttrDatas = slrProdListAttrDatas;
	}

	public void setSlrProductListImgs(Set<SlrProductListImg> slrProductListImgs) {
        this.slrProductListImgs = slrProductListImgs;
    }
    
    public String getSplwizardstatus() {
		return splwizardstatus;
	}

	public void setSplwizardstatus(String splwizardstatus) {
		this.splwizardstatus = splwizardstatus;
	}
	
	public String getSpllistingid() {
		return spllistingid;
	}

	public void setSpllistingid(String spllistingid) {
		this.spllistingid = spllistingid;
	}

	public com.sellerportal.model.OctParam getRequestedfor() {
		return requestedfor;
	}

	public void setRequestedfor(com.sellerportal.model.OctParam requestedfor) {
		this.requestedfor = requestedfor;
	}
	
	public String getIsprocessed() {
		return isprocessed;
	}

	public void setIsprocessed(String isprocessed) {
		this.isprocessed = isprocessed;
	}

	public String getCreatedvia() {
		return createdvia;
	}

	public void setCreatedvia(String createdvia) {
		this.createdvia = createdvia;
	}

	public String toString() {
        return new ToStringBuilder(this)
            .append("splrfnum", getSplrfnum())
            .toString();
    }

	public String getSlrHSNCode() {
		return slrHSNCode;
	}

	public void setSlrHSNCode(String slrHSNCode) {
		this.slrHSNCode = slrHSNCode;
	}

	public String getIsJwlPcmSend() {
		return isJwlPcmSend;
	}

	public void setIsJwlPcmSend(String isJwlPcmSend) {
		this.isJwlPcmSend = isJwlPcmSend;
	}
	
	public Integer getFifoPriority() {
		return fifoPriority;
	}

	public void setFifoPriority(Integer fifoPriority) {
		this.fifoPriority = fifoPriority;
	}

	public String getSplLength() {
		return splLength;
	}

	public void setSplLength(String splLength) {
		this.splLength = splLength;
	}

	public String getSplWidth() {
		return splWidth;
	}

	public void setSplWidth(String splWidth) {
		this.splWidth = splWidth;
	}

	public String getSplHeight() {
		return splHeight;
	}

	public void setSplHeight(String splHeight) {
		this.splHeight = splHeight;
	}

	public String getSplWeight() {
		return splWeight;
	}

	public void setSplWeight(String splWeight) {
		this.splWeight = splWeight;
	}

	public String getSellNowSkuedit() {
		return sellNowSkuedit;
	}

	public void setSellNowSkuedit(String sellNowSkuedit) {
		this.sellNowSkuedit = sellNowSkuedit;
	}
	
	public String getIsSkuedit() {
		return isSkuedit;
	}

	public void setIsSkuedit(String isSkuedit) {
		this.isSkuedit = isSkuedit;
	}

	public Long getCmtrfnum1() {
		return cmtrfnum1;
	}

	public void setCmtrfnum1(Long cmtrfnum1) {
		this.cmtrfnum1 = cmtrfnum1;
	}

	public Long getCmtrfnum2() {
		return cmtrfnum2;
	}

	public void setCmtrfnum2(Long cmtrfnum2) {
		this.cmtrfnum2 = cmtrfnum2;
	}

	public Long getCmtrfnum3() {
		return cmtrfnum3;
	}

	public void setCmtrfnum3(Long cmtrfnum3) {
		this.cmtrfnum3 = cmtrfnum3;
	}

	public Long getCmtrfnum4() {
		return cmtrfnum4;
	}

	public void setCmtrfnum4(Long cmtrfnum4) {
		this.cmtrfnum4 = cmtrfnum4;
	}

	public String getSpbrandcode() {
		return spbrandcode;
	}

	public void setSpbrandcode(String spbrandcode) {
		this.spbrandcode = spbrandcode;
	}

	public String getSpbrandname() {
		return spbrandname;
	}

	public void setSpbrandname(String spbrandname) {
		this.spbrandname = spbrandname;
	}

	public String getBatchId() {
		return batchId;
	}

	public void setBatchId(String batchId) {
		this.batchId = batchId;
	}
	
}
