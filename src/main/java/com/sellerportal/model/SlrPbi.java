package com.sellerportal.model;

import java.io.Serializable;
import java.util.Date;

import org.apache.commons.lang.builder.ToStringBuilder;
import javax.persistence.*;

@Entity
@Table(name = "OCT_SLRPBI")
public class SlrPbi implements Serializable {

	@Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "slr_slrpbirfnum_seq")
    @SequenceGenerator(name = "slr_slrpbirfnum_seq", sequenceName = "SLR_SLRPBIRFNUM_SEQ", allocationSize = 1)
    @Column(name = "SLRPBIRFNUM")
    private Long slrpbirfnum;

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

    @Column(name = "SLRPBIDESC", length = 600)
    private String slrpbidesc;

    @Column(name = "SLRPBISKUCODE", length = 60)
    private String slrpbiskucode;

    @Column(name = "ISACTIVE", length = 1)
    private String isactive;

    @Column(name = "SLRPBINAME", length = 200)
    private String slrpbiname;

    @Column(name = "SLRPBIMINIDESCRIPTION", length = 500)
    private String slrpbiminidescription;

    @Column(name = "PRODUCTIDENTVALUE", length = 60)
    private String productidentvalue;

    @Column(name = "SLRPBIMETADESC", length = 256)
    private String slrpbimetadesc;

    @Column(name = "SLRPBIMETATITLE", length = 256)
    private String slrpbimetatitle;

    @Column(name = "SLRPBIMETAKEYWORD", length = 256)
    private String slrpbimetakeyword;

    @Column(name = "SLRPBITAGS", length = 256)
    private String slrpbitags;

    @Column(name = "STARTDATE")
    private Date startdate;

    @Column(name = "ENDDATE")
    private Date enddate;

    @Column(name = "EDCHARGE", length = 20)
    private String edcharge;

    @Column(name = "HDCHARGE", length = 20)
    private String hdcharge;

    @Column(name = "SLRPBITITLE", length = 200)
    private String slrpbititle;

    @Column(name = "SLRPBIREVIEW", length = 500)
    private String slrpbireview;

    @Column(name = "COUNTRYOFMANUFACTURE", length = 60)
    private String countryofmanufacture;

    @Column(name = "PRODUCT_PRIORITY", length = 60)
    private String productpriority;

    @Column(name = "LEADSELLER", length = 50)
    private String leadseller;

    @Column(name = "LEADUSSID", length = 56)
    private String leadussid;

    @Column(name = "PROD_CAT_TYPE", length = 56)
    private String prodcattype;

    @Column(name = "PRODUCTIDENTVALUE2", length = 60)
    private String productidentvalue2;

    @Column(name = "PRODUCTIDENTVALUE3", length = 60)
    private String productidentvalue3;

    @ManyToOne
    @JoinColumn(name = "SLRPBISPLRFNUM")
    private SlrProductList slrProductList;

    @ManyToOne
    @JoinColumn(name = "SLRPBICMTRFNUM")
    private Ismcmt ismcmt;

    @ManyToOne
    @JoinColumn(name = "PRODUCTIDENTCODE")
    private OctParam octParam;

    @ManyToOne
    @JoinColumn(name = "PRODUCTIDENTCODE2")
    private OctParam octParam2;

    @ManyToOne
    @JoinColumn(name = "PRODUCTIDENTCODE3")
    private OctParam octParam3;
    
    /** full constructor */
    public SlrPbi(Date createdate, Long createdby, String deleted,Date modidate, Long modifiedby,Date startdate,Date enddate, String slrpbidesc, String slrpbiskucode, String isactive, String slrpbiname, String slrpbiminidescription, String productidentvalue,String slrpbimetakeyword,String slrpbimetadesc,String slrpbimetatitle,String slrpbitags,String edcharge,String hdcharge,String slrpbititle,String slrpbireview,String finejewlcat,String leadussid,String countryofmanufacture,com.sellerportal.model.Ismcmt ismcmt, com.sellerportal.model.OctParam octParam,com.sellerportal.model.SlrProductList slrProductList) {
        this.createdate = createdate;
        this.createdby = createdby;
        this.deleted = deleted;
        this.modidate = modidate;
        this.modifiedby = modifiedby;
        this.slrpbidesc = slrpbidesc;
        this.slrpbiskucode = slrpbiskucode;
        this.isactive = isactive;
        this.slrpbiname = slrpbiname;
        this.slrpbiminidescription = slrpbiminidescription;
        this.productidentvalue = productidentvalue;
        this.slrpbimetakeyword = slrpbimetakeyword;
        this.slrpbimetadesc = slrpbimetadesc;
        this.slrpbimetatitle = slrpbimetatitle;
        this.slrpbitags = slrpbitags;
        this.ismcmt = ismcmt;
        this.octParam = octParam;
        this.slrProductList = slrProductList;
        this.startdate = startdate;
        this.enddate = enddate;
        this.slrpbititle = slrpbititle;
        this.slrpbireview = slrpbireview;
        this.countryofmanufacture = countryofmanufacture;
        this.leadussid = leadussid;
  
    }

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

	/** default constructor */
    public SlrPbi() {
    }

    /** minimal constructor */
    public SlrPbi(Date createdate, Long createdby, String deleted, Date modidate, Long modifiedby, com.sellerportal.model.Ismcmt ismcmt, com.sellerportal.model.OctParam octParam, com.sellerportal.model.SlrProductList slrProductList) {
        this.createdate = createdate;
        this.createdby = createdby;
        this.deleted = deleted;
        this.modidate = modidate;
        this.modifiedby = modifiedby;
        this.ismcmt = ismcmt;
        this.octParam = octParam;
        this.slrProductList = slrProductList;
    }
    
    

	public Long getSlrpbirfnum() {
		return slrpbirfnum;
	}

	public void setSlrpbirfnum(Long slrpbirfnum) {
		this.slrpbirfnum = slrpbirfnum;
	}

	public Date getCreatedate() {
		return createdate;
	}

	public void setCreatedate(Date createdate) {
		this.createdate = createdate;
	}

	public Long getCreatedby() {
		return createdby;
	}

	public void setCreatedby(Long createdby) {
		this.createdby = createdby;
	}

	public String getDeleted() {
		return deleted;
	}

	public void setDeleted(String deleted) {
		this.deleted = deleted;
	}

	public Date getModidate() {
		return modidate;
	}

	public void setModidate(Date modidate) {
		this.modidate = modidate;
	}

	public Long getModifiedby() {
		return modifiedby;
	}

	public void setModifiedby(Long modifiedby) {
		this.modifiedby = modifiedby;
	}

	public String getSlrpbidesc() {
		return slrpbidesc;
	}

	public void setSlrpbidesc(String slrpbidesc) {
		this.slrpbidesc = slrpbidesc;
	}

	public String getSlrpbiskucode() {
		return slrpbiskucode;
	}

	public void setSlrpbiskucode(String slrpbiskucode) {
		this.slrpbiskucode = slrpbiskucode;
	}

	public String getIsactive() {
		return isactive;
	}

	public void setIsactive(String isactive) {
		this.isactive = isactive;
	}

	public String getSlrpbiname() {
		return slrpbiname;
	}

	public void setSlrpbiname(String slrpbiname) {
		this.slrpbiname = slrpbiname;
	}
	
	public String getSlrpbiminidescription() {
		return slrpbiminidescription;
	}

	public void setSlrpbiminidescription(String slrpbiminidescription) {
		this.slrpbiminidescription = slrpbiminidescription;
	}

	public String getProductidentvalue() {
		return productidentvalue;
	}

	public void setProductidentvalue(String productidentvalue) {
		this.productidentvalue = productidentvalue;
	}

	public com.sellerportal.model.Ismcmt getIsmcmt() {
		return ismcmt;
	}

	public void setIsmcmt(com.sellerportal.model.Ismcmt ismcmt) {
		this.ismcmt = ismcmt;
	}

	public com.sellerportal.model.OctParam getOctParam() {
		return octParam;
	}

	public void setOctParam(com.sellerportal.model.OctParam octParam) {
		this.octParam = octParam;
	}

	public com.sellerportal.model.SlrProductList getSlrProductList() {
		return slrProductList;
	}

	public void setSlrProductList(com.sellerportal.model.SlrProductList slrProductList) {
		this.slrProductList = slrProductList;
	}
	
	public String getSlrpbimetakeyword() {
		return slrpbimetakeyword;
	}

	public void setSlrpbimetakeyword(String slrpbimetakeyword) {
		this.slrpbimetakeyword = slrpbimetakeyword;
	}

	public String getSlrpbimetadesc() {
		return slrpbimetadesc;
	}

	public void setSlrpbimetadesc(String slrpbimetadesc) {
		this.slrpbimetadesc = slrpbimetadesc;
	}

	public String getSlrpbimetatitle() {
		return slrpbimetatitle;
	}

	public void setSlrpbimetatitle(String slrpbimetatitle) {
		this.slrpbimetatitle = slrpbimetatitle;
	}

	public String getSlrpbitags() {
		return slrpbitags;
	}

	public void setSlrpbitags(String slrpbitags) {
		this.slrpbitags = slrpbitags;
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
	
	public String getEdcharge() {
		return edcharge;
	}

	public void setEdcharge(String edcharge) {
		this.edcharge = edcharge;
	}

	public String getHdcharge() {
		return hdcharge;
	}

	public void setHdcharge(String hdcharge) {
		this.hdcharge = hdcharge;
	}
	
	public String getSlrpbititle() {
		return slrpbititle;
	}

	public void setSlrpbititle(String slrpbititle) {
		this.slrpbititle = slrpbititle;
	}

	public String getSlrpbireview() {
		return slrpbireview;
	}

	public void setSlrpbireview(String slrpbireview) {
		this.slrpbireview = slrpbireview;
	}
	
	public String getCountryofmanufacture() {
		return countryofmanufacture;
	}

	public void setCountryofmanufacture(String countryofmanufacture) {
		this.countryofmanufacture = countryofmanufacture;
	}

	public String toString() {
        return new ToStringBuilder(this)
            .append("slrpbirfnum", getSlrpbirfnum())
            .toString();
    }

	public String getLeadseller() {
		return leadseller;
	}

	public void setLeadseller(String leadseller) {
		this.leadseller = leadseller;
	}

	public String getProductpriority() {
		return productpriority;
	}

	public void setProductpriority(String productpriority) {
		this.productpriority = productpriority;
	}

	public String getProductidentvalue2() {
		return productidentvalue2;
	}

	public void setProductidentvalue2(String productidentvalue2) {
		this.productidentvalue2 = productidentvalue2;
	}

	public String getProductidentvalue3() {
		return productidentvalue3;
	}

	public void setProductidentvalue3(String productidentvalue3) {
		this.productidentvalue3 = productidentvalue3;
	}

	public com.sellerportal.model.OctParam getOctParam2() {
		return octParam2;
	}

	public void setOctParam2(com.sellerportal.model.OctParam octParam2) {
		this.octParam2 = octParam2;
	}

	public com.sellerportal.model.OctParam getOctParam3() {
		return octParam3;
	}

	public void setOctParam3(com.sellerportal.model.OctParam octParam3) {
		this.octParam3 = octParam3;
	}
	
}
