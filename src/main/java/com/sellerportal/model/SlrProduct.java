package com.sellerportal.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import org.apache.commons.lang.builder.ToStringBuilder;
import javax.persistence.*;

/** @author Hibernate CodeGenerator */
/**
 * @author pramod
 *
 */
@Entity
@Table(name = "OCT_SLR_PRODUCT")
public class SlrProduct implements Serializable {

	public String getLeadussid() {
		return leadussid;
	}

	public void setLeadussid(String leadussid) {
		this.leadussid = leadussid;
	}

	public String getProdcattype() {
		return prodcattype;
	}

	public void setProdcattype(String prodcattype) {
		this.prodcattype = prodcattype;
	}

	@Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sprfnum_seq")
    @SequenceGenerator(name = "sprfnum_seq", sequenceName = "SLR_PROD_SPRFNUM_SEQ", allocationSize = 1)
    @Column(name = "SPRFNUM")
    private Long sprfnum;

    @Column(name = "CREATEDATE", nullable = false)
    private Date createdate;

    @Column(name = "CREATEDBY", nullable = false, length = 20)
    private Long createdby;

    @Column(name = "DELETED", nullable = false, length = 1)
    private String deleted;

    @Column(name = "MODIDATE", nullable = false)
    private Date modidate;

    @Column(name = "DELISTDATE")
    private Date delistdate;

    @Column(name = "MODIFIEDBY", nullable = false, length = 20)
    private Long modifiedby;

    @Column(name = "SLRPRODUCTSKU", length = 60)
    private String slrproductsku;

    @Column(name = "SLRUSSID", length = 120)
    private String slrussid;

    @Column(name = "LEADUSSID", length = 120)
    private String leadussid;

    @Column(name = "STARTDATE")
    private Date startdate;

    @Column(name = "ENDDATE")
    private Date enddate;

    @Column(name = "INWARDDATE")
    private Date inwarddate;

    @Column(name = "ISSEND", length = 1)
    private String isSend;

    @Column(name = "SLRHSNCODE", length = 50)
    private String slrHSNCode;

    @Column(name = "PROD_CAT_TYPE", length = 56)
    private String prodcattype;

    @Column(name = "SLRLENGTH", length = 10)
    private String slrLength;

    @Column(name = "SLRWIDTH", length = 10)
    private String slrWidth;

    @Column(name = "SLRHEIGHT", length = 10)
    private String slrHeight;

    @Column(name = "SLRWEIGHT", length = 10)
    private String slrWeight;

    @Column(name = "ISLUXURY", length = 1)
    private String isLuxury;

    @Column(name = "SPALU", length = 64)
    private String spAlu;

    @Column(name = "CMTRFNUM1", length = 24)
    private Long cmtrfnum1;

    @Column(name = "CMTRFNUM2", length = 24)
    private Long cmtrfnum2;

    @Column(name = "CMTRFNUM3", length = 24)
    private Long cmtrfnum3;

    @Column(name = "CMTRFNUM4", length = 24)
    private Long cmtrfnum4;

    @Column(name = "SPBRANDCODE", length = 50)
    private String spbrandcode;

    @Column(name = "SPBRANDNAME", length = 1024)
    private String spbrandname;

    @Column(name = "EXPIRYDATE")
    private Date expiryDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "SPPBIRFNUM", nullable = false)
    private Ismpbi ismpbi;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "SPSLRRFNUM", nullable = false)
    private OctSlr octSlr;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PRODLISTINGSTATUS", nullable = false)
    private OctParam prodListingStatus;
    
    @OneToMany(mappedBy = "slrProduct", fetch = FetchType.LAZY)
    @Transient
    private Set<SlrProductFee> slrProductFees;

    @OneToMany(mappedBy = "spadsprfnum", fetch = FetchType.LAZY)
    @Transient
    private Set<SlrProdAttrData> slrProdAttrDatas;

    @OneToMany(mappedBy = "slrProduct", fetch = FetchType.LAZY)
    @Transient
    private Set<SlrProductCommision> slrProductCommisions;

    @OneToMany(mappedBy = "slrProduct", fetch = FetchType.LAZY)
    @Transient
    private Set<SlrProductPrice> slrProductPrices;

	/** full constructor */
    public SlrProduct(Date createdate, Long createdby, String deleted, Date modidate,Date startdate,Date enddate,Date inwarddate, Long modifiedby,String slrproductsku,String slrussid,com.sellerportal.model.OctParam prodListingStatus, com.sellerportal.model.Ismpbi ismpbi, com.sellerportal.model.OctSlr octSlr, Set<SlrProductFee> slrProductFees, Set<SlrProductCommision> slrProductCommisions, Set<SlrProductPrice> slrProductPrices, Set<SlrProdAttrData> slrProdAttrDatas) {
        this.createdate = createdate;
        this.createdby = createdby;
        this.deleted = deleted;
        this.modidate = modidate;
        this.modifiedby = modifiedby;
        this.ismpbi = ismpbi;
        this.octSlr = octSlr;
        this.slrProductFees = slrProductFees;
        this.slrProductCommisions = slrProductCommisions;
        this.slrProductPrices = slrProductPrices;
        this.slrproductsku = slrproductsku;
        this.prodListingStatus = prodListingStatus;
        this.slrussid = slrussid;
        this.startdate = startdate;
        this.enddate = enddate;
        this.inwarddate = inwarddate;
        this.slrProdAttrDatas = slrProdAttrDatas;
//        this.slrProdPlatformInfo = slrProdPlatformInfo;
    }

    /** default constructor */
    public SlrProduct() {
    }

    /** 
     * 		       auto_increment
     * 		    
     */
    public Long getSprfnum() {
        return this.sprfnum;
    }

    public void setSprfnum(Long sprfnum) {
        this.sprfnum = sprfnum;
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

    public com.sellerportal.model.Ismpbi getIsmpbi() {
        return this.ismpbi;
    }

    public void setIsmpbi(com.sellerportal.model.Ismpbi ismpbi) {
        this.ismpbi = ismpbi;
    }

    public com.sellerportal.model.OctSlr getOctSlr() {
        return this.octSlr;
    }

    public void setOctSlr(com.sellerportal.model.OctSlr octSlr) {
        this.octSlr = octSlr;
    }

	public Set<SlrProductFee> getSlrProductFees() {
        return this.slrProductFees;
    }

    public void setSlrProductFees(Set<SlrProductFee> slrProductFees) {
        this.slrProductFees = slrProductFees;
    }

    public Set<SlrProductCommision> getSlrProductCommisions() {
        return this.slrProductCommisions;
    }

    public void setSlrProductCommisions(Set<SlrProductCommision> slrProductCommisions) {
        this.slrProductCommisions = slrProductCommisions;
    }

    public Set<SlrProductPrice> getSlrProductPrices() {
        return this.slrProductPrices;
    }

    public void setSlrProductPrices(Set<SlrProductPrice> slrProductPrices) {
        this.slrProductPrices = slrProductPrices;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("sprfnum", getSprfnum())
            .toString();
    }

	public String getSlrproductsku() {
		return slrproductsku;
	}

	public void setSlrproductsku(String slrproductsku) {
		this.slrproductsku = slrproductsku;
	}

	public com.sellerportal.model.OctParam getProdListingStatus() {
		return prodListingStatus;
	}

	public void setProdListingStatus(com.sellerportal.model.OctParam prodListingStatus) {
		this.prodListingStatus = prodListingStatus;
	}

	public String getSlrussid() {
		return slrussid;
	}

	public void setSlrussid(String slrussid) {
		this.slrussid = slrussid;
	}

	public Date getStartdate() {
		return startdate;
	}

	public void setStartdate(Date startdate) {
		this.startdate = startdate;
	}

	public Date getEnddate() {
		return enddate;
	}

	public void setEnddate(Date enddate) {
		this.enddate = enddate;
	}

	public Date getInwarddate() {
		return inwarddate;
	}

	public void setInwarddate(Date inwarddate) {
		this.inwarddate = inwarddate;
	}

	public Set<SlrProdAttrData> getSlrProdAttrDatas() {
		return slrProdAttrDatas;
	}

	public void setSlrProdAttrDatas(Set<SlrProdAttrData> slrProdAttrDatas) {
		this.slrProdAttrDatas = slrProdAttrDatas;
	}
    public String getIsSend() {
		return isSend;
	}

	public void setIsSend(String isSend) {
		this.isSend = isSend;
	}

	public String getSlrHSNCode() {
		return slrHSNCode;
	}

	public void setSlrHSNCode(String slrHSNCode) {
		this.slrHSNCode = slrHSNCode;
	}

	public Date getDelistdate() {
		return delistdate;
	}

	public void setDelistdate(Date delistdate) {
		this.delistdate = delistdate;
	}

	public String getSlrLength() {
		return slrLength;
	}

	public void setSlrLength(String slrLength) {
		this.slrLength = slrLength;
	}

	public String getSlrWidth() {
		return slrWidth;
	}

	public void setSlrWidth(String slrWidth) {
		this.slrWidth = slrWidth;
	}

	public String getSlrHeight() {
		return slrHeight;
	}

	public void setSlrHeight(String slrHeight) {
		this.slrHeight = slrHeight;
	}

	public String getSlrWeight() {
		return slrWeight;
	}

	public void setSlrWeight(String slrWeight) {
		this.slrWeight = slrWeight;
	}

	public String getIsLuxury() {
		return isLuxury;
	}

	public void setIsLuxury(String isLuxury) {
		this.isLuxury = isLuxury;
	}
	
	public String getSpAlu() {
		return spAlu;
	}
	
	public void setSpAlu(String spAlu) {
		this.spAlu = spAlu;
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

//	public Set getSlrProdPlatformInfo() {
//		return slrProdPlatformInfo;
//	}
//
//	public void setSlrProdPlatformInfo(Set slrProdPlatformInfo) {
//		this.slrProdPlatformInfo = slrProdPlatformInfo;
//	}
	
	public Date getExpiryDate() {
		return expiryDate;
	}

	public void setExpiryDate(Date expiryDate) {
		this.expiryDate = expiryDate;
	}

}