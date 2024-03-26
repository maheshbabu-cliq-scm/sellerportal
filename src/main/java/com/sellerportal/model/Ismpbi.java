package com.sellerportal.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Set;
import javax.persistence.*;

import org.apache.commons.lang.builder.ToStringBuilder;


@Entity
@Table(name = "ISMPBI")
public class Ismpbi implements Serializable {

	@Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ISMPBI_PBIRFNUM_SEQ")
    @SequenceGenerator(name = "ISMPBI_PBIRFNUM_SEQ", sequenceName = "ISMPBI_PBIRFNUM_SEQ", allocationSize = 1)
    @Column(name = "PBIRFNUM")
    private Long pbirfnum;

    @Column(name = "CREATEDATE", nullable = false)
    private Date createdate;

    @Column(name = "CREATEDBY", nullable = false)
    private Long createdby;

    @Column(name = "DELETED", nullable = false, length = 1)
    private String deleted;
    
    @Column(name = "ISACTIVE", length = 1)
    private String isactive;

    @Column(name = "PBICODE", length = 64)
    private String pbicode;

    @Column(name = "MODIDATE", nullable = false)
    private Date modidate;

    @Column(name = "PBIDESC")
    private String pbidesc;

    @Column(name = "PBISEARCHKEYWORD", length = 256)
    private String pbisearchkeyword;

    @Column(name = "PBINAME", length = 128)
    private String pbiname;

    @Column(name = "PBISEQNUM", length = 16)
    private String pbiseqnum;

    @Column(name = "PBIISAPPROVE", length = 1)
    private String pbiisapprove;

    @Column(name = "MODIFIEDBY", nullable = false)
    private Long modifiedby;

    @Column(name = "PBIPRODTYPE", length = 125)
    private String pbiprodtype;

    @Column(name = "STARTDATE")
    private Date startdate;

    @Column(name = "ENDDATE")
    private Date enddate;

    @Column(name = "PBILISTINGID", length = 120)
    private String pbilistingid;

    @Column(name = "PBIMETADESC", length = 120)
    private String pbimetadesc;

    @Column(name = "PBIIDENTITYVALUE", length = 120)
    private String pbiidentityvalue;

    @Column(name = "PBIMETATITLE", length = 256)
    private String pbimetatitle;

    @Column(name = "PBIMETAKEYWORD", length = 256)
    private String pbimetakeyword;

    @Column(name = "PBITAGS", length = 256)
    private String pbitags;

    @Column(name = "BASEPRODUCTID", length = 256)
    private String baseproductid;

    @Column(name = "EDCHARGE")
    private Double edcharge;

    @Column(name = "HDCHARGE")
    private Double hdcharge;

    @Column(name = "PBITITLE", length = 200)
    private String pbititle;
    
    @ManyToOne
    @JoinColumn(name = "PBIIDENTITYCODE", nullable = false)
    private OctParam pbiidentitycode;
    /** persistent field */
    @ManyToOne
    @JoinColumn(name = "PBIPARAMSTATUS", nullable = false)
    private OctParam octParam;
    
    @Column(name = "PBIMINIDESCRIPTION", length = 500)
    private String pbiminidescription;
    
    /** persistent field */
    @OneToMany(mappedBy = "ismpbi", fetch = FetchType.LAZY)
    private Set<Ismppt> ismppts;

    @OneToMany(mappedBy = "ismpbi", fetch = FetchType.LAZY)
    private Set<Ismppm> ismppms;

    @OneToMany(mappedBy = "ismpbi", fetch = FetchType.LAZY)
    private Set<Ismpit> ismpits;

//    @OneToMany(mappedBy = "ismpbi", fetch = FetchType.LAZY)
//    private Set<Ismvpm> ismvpms;
//    
    @OneToMany(mappedBy = "ismpbi", fetch = FetchType.LAZY)
    private Set<ProductSearchLog> ProductSearchLogs;

    @OneToMany(mappedBy = "ismpbi", fetch = FetchType.LAZY)
    private Set<ProductVideo> productVideos;
    
    @Column(name = "PBIREVIEW", length = 500)
    private String pbireview;
    
    @Column(name = "COUNTRYOFMANUFACTURE", length = 60)
    private String countryofmanufacture;

    @Column(name = "LEADSELLER", length = 50)
    private String leadseller;
    
    @ManyToOne
    @JoinColumn(name = "PBIIDENTITYCODE2", nullable = false)
    private OctParam pbiidentitycode2;

    @ManyToOne
    @JoinColumn(name = "PBIIDENTITYCODE3", nullable = false)
    private OctParam pbiidentitycode3;
    
    @Column(name = "PBIIDENTITYVALUE2", length = 120)
    private String pbiidentityvalue2;

    @Column(name = "PBIIDENTITYVALUE3", length = 120)
    private String pbiidentityvalue3;
    
	public Ismpbi(Date createdate, Long createdby, String deleted,Date startdate,Date enddate,Double edcharge,Double hdcharge,String pbireview, String isactive,String pbilistingid,String pbimetakeyword,String pbimetadesc,String pbimetatitle,String pbitags,String baseproductid, String pbicode, Date modidate, String pbidesc,String pbisearchkeyword, String pbiname, String pbiseqnum,String pbiminidescription, String pbititle, com.sellerportal.model.OctParam octParam, Set ismppts, Set ismppms, Set ismpits, Set ismvpms,Set ProductSearchLogs, BigDecimal pbidiscpers,String pbiisdiscallow,String pbidispatchbyair,String pbidispatchbysurface,String pbivideo,Long modifiedby,String countryofmanufacture, com.sellerportal.model.OctParam pbiidentitycode,String pbiidentityvalue, Set productVideos) {
        this.createdate = createdate;
        this.createdby = createdby;
        this.deleted = deleted;
        this.isactive = isactive;
        this.pbicode = pbicode;
        this.modidate = modidate;
        this.pbidesc = pbidesc;
        this.pbiname = pbiname;
        this.pbiseqnum = pbiseqnum;
        this.pbititle = pbititle;
        this.ismppts = ismppts;
        this.ismppms = ismppms;
        this.ismpits = ismpits;
//        this.ismvpms = ismvpms;
        this.ProductSearchLogs = ProductSearchLogs;
        this.pbisearchkeyword = pbisearchkeyword;
        this.modifiedby=modifiedby;
        this.octParam = octParam;
        this.startdate = startdate;
        this.enddate = enddate;
        this.hdcharge = hdcharge;
        this.edcharge = edcharge;
        this.pbireview = pbireview;
        this.pbilistingid = pbilistingid;
        this.pbimetakeyword = pbimetakeyword;
        this.pbimetadesc = pbimetadesc;
        this.pbiidentitycode = pbiidentitycode;
        this.pbiidentityvalue = pbiidentityvalue;
        this.pbimetatitle = pbimetatitle;
        this.pbitags = pbitags;
        this.productVideos = productVideos;
        this.baseproductid = baseproductid;
        this.pbiminidescription = pbiminidescription;
        this.countryofmanufacture = countryofmanufacture;
    }

    /** default constructor */
    public Ismpbi() {
    }

    /** minimal constructor */
    public Ismpbi(Date createdate, Long createdby, String deleted, Date modidate, com.sellerportal.model.OctParam octParam, Set ismppts, Set ismppms, Set ismpits, Set ismvpms,Set ProductSearchLogs) {
        this.createdate = createdate;
        this.createdby = createdby;
        this.deleted = deleted;
        this.modidate = modidate;
        this.ismppts = ismppts;
        this.ismppms = ismppms;
        this.ismpits = ismpits;
//        this.ismvpms = ismvpms;
        this.ProductSearchLogs = ProductSearchLogs;
        this.octParam=octParam;
    }

	/** 
     * 		       auto_increment
     * 		    
     */
    public Long getPbirfnum() {
        return this.pbirfnum;
    }

    public void setPbirfnum(Long pbirfnum) {
        this.pbirfnum = pbirfnum;
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

    public String getIsactive() {
        return this.isactive;
    }

    public void setIsactive(String isactive) {
        this.isactive = isactive;
    }

    public Date getModidate() {
        return this.modidate;
    }

    public void setModidate(Date modidate) {
        this.modidate = modidate;
    }

    public String getPbidesc() {
        return this.pbidesc;
    }

    public void setPbidesc(String pbidesc) {
        this.pbidesc = pbidesc;
    }

	public String getPbiname() {
        return this.pbiname;
    }

    public void setPbiname(String pbiname) {
        this.pbiname = pbiname;
    }

    public String getPbiseqnum() {
        return this.pbiseqnum;
    }

    public void setPbiseqnum(String pbiseqnum) {
        this.pbiseqnum = pbiseqnum;
    }
    public String getPbititle() {
        return this.pbititle;
    }

    public void setPbititle(String pbititle) {
        this.pbititle = pbititle;
    }

    public Set getIsmppts() {
        return this.ismppts;
    }

    public void setIsmppts(Set ismppts) {
        this.ismppts = ismppts;
    }

    public Set getIsmppms() {
        return this.ismppms;
    }

    public void setIsmppms(Set ismppms) {
        this.ismppms = ismppms;
    }

    public Set getIsmpits() {
        return this.ismpits;
    }

    public void setIsmpits(Set ismpits) {
        this.ismpits = ismpits;
    }

//    public Set getIsmvpms() {
//        return this.ismvpms;
//    }
//
//    public void setIsmvpms(Set ismvpms) {
//        this.ismvpms = ismvpms;
//    }
    
    public Set getProductSearchLogs() {
		return ProductSearchLogs;
	}

	public void setProductSearchLogs(Set productSearchLogs) {
		ProductSearchLogs = productSearchLogs;
	}

	public String toString() {
        return new ToStringBuilder(this)
            .append("pbirfnum", getPbirfnum())
            .toString();
    }

	public String getPbicode() {
		return pbicode;
	}

	public void setPbicode(String pbicode) {
		this.pbicode = pbicode;
	}

	public String getPbiisapprove() {
		return pbiisapprove;
	}

	public void setPbiisapprove(String pbiisapprove) {
		this.pbiisapprove = pbiisapprove;
	}

	public Long getModifiedby() {
		return modifiedby;
	}

	public void setModifiedby(Long modifiedby) {
		this.modifiedby = modifiedby;
	}

	public String getPbiprodtype() {
		return pbiprodtype;
	}

	public void setPbiprodtype(String pbiprodtype) {
		this.pbiprodtype = pbiprodtype;
	}

	public  com.sellerportal.model.OctParam getOctParam() {
		return octParam;
	}

	public void setOctParam( com.sellerportal.model.OctParam octParam) {
		this.octParam = octParam;
	}

	public String getPbisearchkeyword() {
		return pbisearchkeyword;
	}

	public void setPbisearchkeyword(String pbisearchkeyword) {
		this.pbisearchkeyword = pbisearchkeyword;
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

	public String getPbilistingid() {
		return pbilistingid;
	}

	public void setPbilistingid(String pbilistingid) {
		this.pbilistingid = pbilistingid;
	}

	public String getPbimetakeyword() {
		return pbimetakeyword;
	}

	public void setPbimetakeyword(String pbimetakeyword) {
		this.pbimetakeyword = pbimetakeyword;
	}

	public String getPbimetadesc() {
		return pbimetadesc;
	}

	public void setPbimetadesc(String pbimetadesc) {
		this.pbimetadesc = pbimetadesc;
	}

	public  com.sellerportal.model.OctParam getPbiidentitycode() {
		return pbiidentitycode;
	}

	public void setPbiidentitycode( com.sellerportal.model.OctParam pbiidentitycode) {
		this.pbiidentitycode = pbiidentitycode;
	}

	public String getPbiidentityvalue() {
		return pbiidentityvalue;
	}

	public void setPbiidentityvalue(String pbiidentityvalue) {
		this.pbiidentityvalue = pbiidentityvalue;
	}

	public String getPbimetatitle() {
		return pbimetatitle;
	}

	public void setPbimetatitle(String pbimetatitle) {
		this.pbimetatitle = pbimetatitle;
	}

	public String getPbitags() {
		return pbitags;
	}

	public void setPbitags(String pbitags) {
		this.pbitags = pbitags;
	}
	
	public String getBaseproductid() {
		return baseproductid;
	}

	public void setBaseproductid(String baseproductid) {
		this.baseproductid = baseproductid;
	}

	public Set getProductVideos() {
		return productVideos;
	}
	
	public void setProductVideos(Set productVideos) {
		this.productVideos = productVideos;
	}

	public Double getEdcharge() {
		return edcharge;
	}

	public void setEdcharge(Double edcharge) {
		this.edcharge = edcharge;
	}

	public Double getHdcharge() {
		return hdcharge;
	}

	public void setHdcharge(Double hdcharge) {
		this.hdcharge = hdcharge;
	}

	public String getPbireview() {
		return pbireview;
	}

	public void setPbireview(String pbireview) {
		this.pbireview = pbireview;
	}

	public String getPbiminidescription() {
		return pbiminidescription;
	}

	public void setPbiminidescription(String pbiminidescription) {
		this.pbiminidescription = pbiminidescription;
	}

	public String getCountryofmanufacture() {
		return countryofmanufacture;
	}

	public void setCountryofmanufacture(String countryofmanufacture) {
		this.countryofmanufacture = countryofmanufacture;
	}
	 
    public String getLeadseller() {
		return leadseller;
	}

	public void setLeadseller(String leadseller) {
		this.leadseller = leadseller;
	}

	public  com.sellerportal.model.OctParam getPbiidentitycode2() {
		return pbiidentitycode2;
	}

	public void setPbiidentitycode2( com.sellerportal.model.OctParam pbiidentitycode2) {
		this.pbiidentitycode2 = pbiidentitycode2;
	}

	public  com.sellerportal.model.OctParam getPbiidentitycode3() {
		return pbiidentitycode3;
	}

	public void setPbiidentitycode3( com.sellerportal.model.OctParam pbiidentitycode3) {
		this.pbiidentitycode3 = pbiidentitycode3;
	}

	public String getPbiidentityvalue2() {
		return pbiidentityvalue2;
	}

	public void setPbiidentityvalue2(String pbiidentityvalue2) {
		this.pbiidentityvalue2 = pbiidentityvalue2;
	}

	public String getPbiidentityvalue3() {
		return pbiidentityvalue3;
	}

	public void setPbiidentityvalue3(String pbiidentityvalue3) {
		this.pbiidentityvalue3 = pbiidentityvalue3;
	}
	
}
