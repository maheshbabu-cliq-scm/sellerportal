package com.sellerportal.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import org.apache.commons.lang.builder.ToStringBuilder;


@Entity
@Table(name = "OCT_SLR_PRODUCT_PRICE")
public class SlrProductPrice implements Serializable {

	@Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "spprfnum_generator")
    @SequenceGenerator(name = "spprfnum_generator", sequenceName = "SLR_PROD_PRICE_SPPRFNUM_SEQ", allocationSize = 1)
    @Column(name = "SPPRFNUM")
    private Long spprfnum;

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

    @Column(name = "SPPPRICE", length = 20)
    private Double sppprice;

    @Column(name = "SPOFFERPRICE", length = 20)
    private Double spofferprice;

    @Column(name = "SPPHDPRICE", length = 20)
    private Double spphdprice;

    @Column(name = "SPPEDPRICE", length = 20)
    private Double sppedprice;

    @Column(name = "SPPCNCPRICE", length = 20)
    private Double sppcncprice;

    @Column(name = "ISSENT", length = 1)
    private String issent;

    @Column(name = "ASSOCIATIONCODE", length = 55)
    private String associationcode;

    @Column(name = "MAKINGCHARGES", length = 19)
    private Double makingcharges;

    @Column(name = "WASTAGECHARGES", length = 19)
    private Double wastagecharges;

    @Column(name = "GOLDRATE", length = 19)
    private Double goldrate;

    @Column(name = "GOLDVALUE", length = 19)
    private Double goldvalue;

    @Column(name = "SILVERRATE", length = 19)
    private Double silverrate;

    @Column(name = "SILVERVALUE", length = 19)
    private Double silvervalue;

    @Column(name = "PLATINUMRATE", length = 19)
    private Double platinumrate;

    @Column(name = "PLATINUMVALUE", length = 19)
    private Double platinumvalue;

    @Column(name = "SOLITAIRERATE", length = 19)
    private Double solitairerate;

    @Column(name = "SOLITAIREVALUE", length = 19)
    private Double solitairevalue;

    @Column(name = "TOTALDIAMONDVALUE", length = 19)
    private Double totaldiamondvalue;

    @Column(name = "diamondratetype1")
    private Double diamondratetype1;

    @Column(name = "diamondvaluetype1")
    private Double diamondvaluetype1;

    @Column(name = "diamondratetype2")
    private Double diamondratetype2;

    @Column(name = "diamondvaluetype2")
    private Double diamondvaluetype2;

    @Column(name = "diamondratetype3")
    private Double diamondratetype3;

    @Column(name = "diamondvaluetype3")
    private Double diamondvaluetype3;

    @Column(name = "diamondratetype4")
    private Double diamondratetype4;

    @Column(name = "diamondvaluetype4")
    private Double diamondvaluetype4;

    @Column(name = "diamondratetype5")
    private Double diamondratetype5;

    @Column(name = "diamondvaluetype5")
    private Double diamondvaluetype5;

    @Column(name = "diamondratetype6")
    private Double diamondratetype6;

    @Column(name = "diamondvaluetype6")
    private Double diamondvaluetype6;

    @Column(name = "diamondratetype7")
    private Double diamondratetype7;

    @Column(name = "diamondvaluetype7")
    private Double diamondvaluetype7;

    @Column(name = "TOTALSTONEVALUE", length = 19)
    private Double totalstonevalue;
    
    @Column(name = "stoneratetype1")
    private Double stoneratetype1;

    @Column(name = "stonevaluetype1")
    private Double stonevaluetype1;

    @Column(name = "stoneratetype2")
    private Double stoneratetype2;

    @Column(name = "stonevaluetype2")
    private Double stonevaluetype2;

    @Column(name = "stoneratetype3")
    private Double stoneratetype3;

    @Column(name = "stonevaluetype3")
    private Double stonevaluetype3;

    @Column(name = "stoneratetype4")
    private Double stoneratetype4;

    @Column(name = "stonevaluetype4")
    private Double stonevaluetype4;

    @Column(name = "stoneratetype5")
    private Double stoneratetype5;

    @Column(name = "stonevaluetype5")
    private Double stonevaluetype5;

    @Column(name = "stoneratetype6")
    private Double stoneratetype6;

    @Column(name = "stonevaluetype6")
    private Double stonevaluetype6;

    @Column(name = "stoneratetype7")
    private Double stoneratetype7;

    @Column(name = "stonevaluetype7")
    private Double stonevaluetype7;

    @Column(name = "stoneratetype8")
    private Double stoneratetype8;

    @Column(name = "stonevaluetype8")
    private Double stonevaluetype8;

    @Column(name = "stoneratetype9")
    private Double stoneratetype9;

    @Column(name = "stonevaluetype9")
    private Double stonevaluetype9;

    @Column(name = "stoneratetype10")
    private Double stoneratetype10;

    @Column(name = "stonevaluetype10")
    private Double stonevaluetype10;

    // SPPSDDPRICE property
    @Column(name = "SPPSDDPRICE")
    private Double sppsddprice;
    
  

    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "SPPSPRFNUM", nullable = false)
    private SlrProduct slrProduct;
    
    
	 public String getAssociationcode() {
		return associationcode;
	}

	public void setAssociationcode(String associationcode) {
		this.associationcode = associationcode;
	}

	public Double getMakingcharges() {
		return makingcharges;
	}

	public void setMakingcharges(Double makingcharges) {
		this.makingcharges = makingcharges;
	}

	public Double getWastagecharges() {
		return wastagecharges;
	}

	public void setWastagecharges(Double wastagecharges) {
		this.wastagecharges = wastagecharges;
	}

	public Double getGoldrate() {
		return goldrate;
	}

	public void setGoldrate(Double goldrate) {
		this.goldrate = goldrate;
	}

	public Double getGoldvalue() {
		return goldvalue;
	}

	public void setGoldvalue(Double goldvalue) {
		this.goldvalue = goldvalue;
	}

	public Double getSilverrate() {
		return silverrate;
	}

	public void setSilverrate(Double silverrate) {
		this.silverrate = silverrate;
	}

	public Double getSilvervalue() {
		return silvervalue;
	}

	public void setSilvervalue(Double silvervalue) {
		this.silvervalue = silvervalue;
	}

	public Double getPlatinumrate() {
		return platinumrate;
	}

	public void setPlatinumrate(Double platinumrate) {
		this.platinumrate = platinumrate;
	}

	public Double getPlatinumvalue() {
		return platinumvalue;
	}

	public void setPlatinumvalue(Double platinumvalue) {
		this.platinumvalue = platinumvalue;
	}

	public Double getSolitairerate() {
		return solitairerate;
	}

	public void setSolitairerate(Double solitairerate) {
		this.solitairerate = solitairerate;
	}

	public Double getSolitairevalue() {
		return solitairevalue;
	}

	public void setSolitairevalue(Double solitairevalue) {
		this.solitairevalue = solitairevalue;
	}

	public Double getTotaldiamondvalue() {
		return totaldiamondvalue;
	}

	public void setTotaldiamondvalue(Double totaldiamondvalue) {
		this.totaldiamondvalue = totaldiamondvalue;
	}

	public Double getdiamondratetype1() {
		return diamondratetype1;
	}

	public void setdiamondratetype1(Double diamondratetype1) {
		this.diamondratetype1 = diamondratetype1;
	}

	public Double getdiamondvaluetype1() {
		return diamondvaluetype1;
	}

	public void setdiamondvaluetype1(Double diamondvaluetype1) {
		this.diamondvaluetype1 = diamondvaluetype1;
	}

	public Double getdiamondratetype2() {
		return diamondratetype2;
	}

	public void setdiamondratetype2(Double diamondratetype2) {
		this.diamondratetype2 = diamondratetype2;
	}

	public Double getdiamondvaluetype2() {
		return diamondvaluetype2;
	}

	public void setdiamondvaluetype2(Double diamondvaluetype2) {
		this.diamondvaluetype2 = diamondvaluetype2;
	}

	public Double getdiamondratetype3() {
		return diamondratetype3;
	}

	public void setdiamondratetype3(Double diamondratetype3) {
		this.diamondratetype3 = diamondratetype3;
	}

	public Double getdiamondvaluetype3() {
		return diamondvaluetype3;
	}

	public void setdiamondvaluetype3(Double diamondvaluetype3) {
		this.diamondvaluetype3 = diamondvaluetype3;
	}

	public Double getdiamondratetype4() {
		return diamondratetype4;
	}

	public void setdiamondratetype4(Double diamondratetype4) {
		this.diamondratetype4 = diamondratetype4;
	}

	public Double getdiamondvaluetype4() {
		return diamondvaluetype4;
	}

	public void setdiamondvaluetype4(Double diamondvaluetype4) {
		this.diamondvaluetype4 = diamondvaluetype4;
	}

	public Double getdiamondratetype5() {
		return diamondratetype5;
	}

	public void setdiamondratetype5(Double diamondratetype5) {
		this.diamondratetype5 = diamondratetype5;
	}

	public Double getdiamondvaluetype5() {
		return diamondvaluetype5;
	}

	public void setdiamondvaluetype5(Double diamondvaluetype5) {
		this.diamondvaluetype5 = diamondvaluetype5;
	}

	public Double getdiamondratetype6() {
		return diamondratetype6;
	}

	public void setdiamondratetype6(Double diamondratetype6) {
		this.diamondratetype6 = diamondratetype6;
	}

	public Double getdiamondvaluetype6() {
		return diamondvaluetype6;
	}

	public void setdiamondvaluetype6(Double diamondvaluetype6) {
		this.diamondvaluetype6 = diamondvaluetype6;
	}

	public Double getdiamondratetype7() {
		return diamondratetype7;
	}

	public void setdiamondratetype7(Double diamondratetype7) {
		this.diamondratetype7 = diamondratetype7;
	}

	public Double getdiamondvaluetype7() {
		return diamondvaluetype7;
	}

	public void setdiamondvaluetype7(Double diamondvaluetype7) {
		this.diamondvaluetype7 = diamondvaluetype7;
	}

	public Double getTotalstonevalue() {
		return totalstonevalue;
	}

	public void setTotalstonevalue(Double totalstonevalue) {
		this.totalstonevalue = totalstonevalue;
	}

	public Double getstoneratetype1() {
		return stoneratetype1;
	}

	public void setstoneratetype1(Double stoneratetype1) {
		this.stoneratetype1 = stoneratetype1;
	}

	public Double getstonevaluetype1() {
		return stonevaluetype1;
	}

	public void setstonevaluetype1(Double stonevaluetype1) {
		this.stonevaluetype1 = stonevaluetype1;
	}

	public Double getstoneratetype2() {
		return stoneratetype2;
	}

	public void setstoneratetype2(Double stoneratetype2) {
		this.stoneratetype2 = stoneratetype2;
	}

	public Double getstonevaluetype2() {
		return stonevaluetype2;
	}

	public void setstonevaluetype2(Double stonevaluetype2) {
		this.stonevaluetype2 = stonevaluetype2;
	}

	public Double getstoneratetype3() {
		return stoneratetype3;
	}

	public void setstoneratetype3(Double stoneratetype3) {
		this.stoneratetype3 = stoneratetype3;
	}

	public Double getstonevaluetype3() {
		return stonevaluetype3;
	}

	public void setstonevaluetype3(Double stonevaluetype3) {
		this.stonevaluetype3 = stonevaluetype3;
	}

	public Double getstoneratetype4() {
		return stoneratetype4;
	}

	public void setstoneratetype4(Double stoneratetype4) {
		this.stoneratetype4 = stoneratetype4;
	}

	public Double getstonevaluetype4() {
		return stonevaluetype4;
	}

	public void setstonevaluetype4(Double stonevaluetype4) {
		this.stonevaluetype4 = stonevaluetype4;
	}

	public Double getstoneratetype5() {
		return stoneratetype5;
	}

	public void setstoneratetype5(Double stoneratetype5) {
		this.stoneratetype5 = stoneratetype5;
	}

	public Double getstonevaluetype5() {
		return stonevaluetype5;
	}

	public void setstonevaluetype5(Double stonevaluetype5) {
		this.stonevaluetype5 = stonevaluetype5;
	}

	public Double getstoneratetype6() {
		return stoneratetype6;
	}

	public void setstoneratetype6(Double stoneratetype6) {
		this.stoneratetype6 = stoneratetype6;
	}

	public Double getstonevaluetype6() {
		return stonevaluetype6;
	}

	public void setstonevaluetype6(Double stonevaluetype6) {
		this.stonevaluetype6 = stonevaluetype6;
	}

	public Double getstoneratetype7() {
		return stoneratetype7;
	}

	public void setstoneratetype7(Double stoneratetype7) {
		this.stoneratetype7 = stoneratetype7;
	}

	public Double getstonevaluetype7() {
		return stonevaluetype7;
	}

	public void setstonevaluetype7(Double stonevaluetype7) {
		this.stonevaluetype7 = stonevaluetype7;
	}

	public Double getstoneratetype8() {
		return stoneratetype8;
	}

	public void setstoneratetype8(Double stoneratetype8) {
		this.stoneratetype8 = stoneratetype8;
	}

	public Double getstonevaluetype8() {
		return stonevaluetype8;
	}

	public void setstonevaluetype8(Double stonevaluetype8) {
		this.stonevaluetype8 = stonevaluetype8;
	}

	public Double getstoneratetype9() {
		return stoneratetype9;
	}

	public void setstoneratetype9(Double stoneratetype9) {
		this.stoneratetype9 = stoneratetype9;
	}

	public Double getstonevaluetype9() {
		return stonevaluetype9;
	}

	public void setstonevaluetype9(Double stonevaluetype9) {
		this.stonevaluetype9 = stonevaluetype9;
	}

	public Double getstoneratetype10() {
		return stoneratetype10;
	}

	public void setstoneratetype10(Double stoneratetype10) {
		this.stoneratetype10 = stoneratetype10;
	}

	public Double getstonevaluetype10() {
		return stonevaluetype10;
	}

	public void setstonevaluetype10(Double stonevaluetype10) {
		this.stonevaluetype10 = stonevaluetype10;
	}

	
	   
	

	/** full constructor */
    public SlrProductPrice(Date createdate, Long createdby, String deleted, Date modidate, Long modifiedby, Double sppprice, com.sellerportal.model.SlrProduct slrProduct, Double spofferprice, Double spphdprice, Double sppedprice) {
        this.createdate = createdate;
        this.createdby = createdby;
        this.deleted = deleted;
        this.modidate = modidate;
        this.modifiedby = modifiedby;
        this.sppprice = sppprice;
        this.slrProduct = slrProduct;
        this.spofferprice=spofferprice;
        this.spphdprice = spphdprice;
        this.sppedprice = sppedprice;
        this.sppcncprice=sppcncprice;
    }

    /** default constructor */
    public SlrProductPrice() {
    }

    /** minimal constructor */
    public SlrProductPrice(Date createdate, Long createdby, String deleted, Date modidate, Long modifiedby, com.sellerportal.model.SlrProduct slrProduct, Double spofferprice, Double spphdprice, Double sppedprice) {
        this.createdate = createdate;
        this.createdby = createdby;
        this.deleted = deleted;
        this.modidate = modidate;
        this.modifiedby = modifiedby;
        this.slrProduct = slrProduct;
        this.spofferprice=spofferprice;
        this.spphdprice = spphdprice;
        this.sppedprice = sppedprice;
        this.sppcncprice=sppcncprice;
    }

    /** 
     * 		       auto_increment
     * 		    
     */
    public Long getSpprfnum() {
        return this.spprfnum;
    }

    public void setSpprfnum(Long spprfnum) {
        this.spprfnum = spprfnum;
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

    public Double getSppprice() {
        return this.sppprice;
    }

    public void setSppprice(Double sppprice) {
        this.sppprice = sppprice;
    }

    public com.sellerportal.model.SlrProduct getSlrProduct() {
        return this.slrProduct;
    }

    public void setSlrProduct(com.sellerportal.model.SlrProduct slrProduct) {
        this.slrProduct = slrProduct;
    }
    
    public Double getSpofferprice() {
		return spofferprice;
	}

	public void setSpofferprice(Double spofferprice) {
		this.spofferprice = spofferprice;
	}

    public Double getSpphdprice() {
		return spphdprice;
	}

	public void setSpphdprice(Double spphdprice) {
		this.spphdprice = spphdprice;
	}

	public Double getSppedprice() {
		return sppedprice;
	}

	public void setSppedprice(Double sppedprice) {
		this.sppedprice = sppedprice;
	}

	public Double getSppcncprice() {
		return sppcncprice;
	}

	public void setSppcncprice(Double sppcncprice) {
		this.sppcncprice = sppcncprice;
	}
	
	public String getIssent() {
		return issent;
	}

	public void setIssent(String issent) {
		this.issent = issent;
	}

	public Double getSppsddprice() {
		return sppsddprice;
	}

	public void setSppsddprice(Double sppsddprice) {
		this.sppsddprice = sppsddprice;
	}

	public String toString() {
        return new ToStringBuilder(this)
            .append("spprfnum", getSpprfnum())
            .toString();
    }

}
