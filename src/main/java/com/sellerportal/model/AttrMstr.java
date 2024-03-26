package com.sellerportal.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import org.apache.commons.lang.builder.ToStringBuilder;
import javax.persistence.*;

@Entity
@Table(name = "OCT_ATTR_MSTR")
public class AttrMstr implements Serializable {

	@Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "amrfnum_generator")
    @SequenceGenerator(name = "amrfnum_generator", sequenceName = "ATTR_AMRFNUM_SEQ", allocationSize = 1)
    @Column(name = "AMRFNUM")
    private Long amrfnum;

    @Column(name = "AMCODE", nullable = false, length = 64)
    private String amcode;

    @Column(name = "AMCOMPONENTLOVGROUP", length = 256)
    private String amcomponentlovgroup;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "AMCOMPONENTTYPE")
    private OctParam amcomponenttype;

    @Column(name = "AMDIFFERENTSELLEREDIT", length = 1)
    private String amdifferentselleredit;

    @Column(name = "AMISACTIVE", nullable = false, length = 1)
    private String amisactive;

    @Column(name = "AMISMULTIFIELD", length = 1)
    private String amismultifield;

    @Column(name = "AMISMULTIVALUEFIELD", length = 1)
    private String amismultivaluefield;

    @Column(name = "AMNAME", nullable = false, length = 120)
    private String amname;

    @Column(name = "AMSAMESELLEREDIT", length = 1)
    private String amsameselleredit;

    @Column(name = "AMSEQUENCE", nullable = false)
    private Long amsequence;

    @Column(name = "AMVALUE", length = 64)
    private String amvalue;

    @Column(name = "UOM", length = 64)
    private String uom;

    @Column(name = "CREATEDATE", nullable = false)
    private Date createdate;

    @Column(name = "DELETED", nullable = false, length = 1)
    private String deleted;

    @Column(name = "EMAILVALIDATION", length = 1)
    private String emailvalidation;

    @Column(name = "LETTERSONLY", length = 1)
    private String lettersonly;

    @Column(name = "MANDATORYVALIDATION", length = 1)
    private String mandatoryvalidation;

    @Column(name = "MAXLENGTHVALIDATION", length = 3)
    private String maxlengthvalidation;

    @Column(name = "MINLENGTHVALIDATION", length = 3)
    private String minlengthvalidation;

    @Column(name = "MOBNUMVALIDATION", length = 1)
    private String mobnumvalidation;

    @Column(name = "MODIDATE", nullable = false)
    private Date modidate;

    @Column(name = "MODIFIEDBY", nullable = false)
    private Long modifiedby;

    @Column(name = "CREATEDBY", nullable = false)
    private Long createdby;

    @Column(name = "NUMVALIDATION", length = 1)
    private String numvalidation;

    @Column(name = "REGEXPRESSIONVALIDATION", length = 100)
    private String regexpressionvalidation;

    @Column(name = "REGEXPRESSIONVALIDATIONMSG", length = 300)
    private String regexpressionvalidationmsg;

    @Column(name = "URLVALIDATION", length = 1)
    private String urlvalidation;

    @Column(name = "WSBEANPROPERTY", length = 256)
    private String wsbeanproperty;

    @Column(name = "AMUOMGROUP", length = 256)
    private String amuomgroup;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "AMSECMSTR", nullable = false)
    private AttrSecMstr amsecmstr;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "AMPARAMATTRIBUTETYPE", nullable = false)
    private OctParam amparamattributetype;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "AMATTRDATATYPE")
    private OctParam amattrdatatype;

    @OneToMany(mappedBy = "attrMstr")
    @Transient
    private Set<SlrProdAttrData> slrProdAttrDatas;

    @OneToMany(mappedBy = "attrMstr")
    @Transient
    private Set<SlrProdListAttrData> slrProdListAttrDatas;

    @OneToMany(mappedBy = "attrMstr")
    @Transient
    private Set<SlrCatAttrData> slrCatAttrDatas;

    @OneToMany(mappedBy = "attrMstr")
    @Transient
    private Set<AttrCategoryAssoc> attrCategoryAssocs;

    /** full constructor */
    public AttrMstr(Long amrfnum ,Date createdate, String deleted, String emailvalidation, String lettersonly, String mandatoryvalidation, String maxlengthvalidation, String minlengthvalidation, String mobnumvalidation, Date modidate,Long createdby,Long modifiedby,  String numvalidation,String isvarient, com.sellerportal.model.OctParam amattrdatatype,com.sellerportal.model.OctParam amparamattributetype,String amsameselleredit,String amdifferentselleredit,String wsbeanproperty, String amcode, String amcomponentlovgroup,String amuomgroup,String amisactive, String amismultifield, String amismultivaluefield, String amname, Long amsequence, String amvalue,String uom, String regexpressionvalidation, String regexpressionvalidationmsg, String urlvalidation, com.sellerportal.model.AttrSecMstr amsecmstr, Set<SlrProdAttrData> slrProdAttrDatas,Set<SlrProdListAttrData> slrProdListAttrDatas, Set<AttrCategoryAssoc> attrCategoryAssocs,Set<SlrCatAttrData> slrCatAttrDatas) {
        this.amrfnum = amrfnum;
    	this.createdate = createdate;
        this.deleted = deleted;
        this.emailvalidation = emailvalidation;
        this.lettersonly = lettersonly;
        this.mandatoryvalidation = mandatoryvalidation;
        this.maxlengthvalidation = maxlengthvalidation;
        this.minlengthvalidation = minlengthvalidation;
        this.mobnumvalidation = mobnumvalidation;
        this.modidate = modidate;
        this.createdby = createdby;
        this.modifiedby = modifiedby;
        this.numvalidation = numvalidation;
        this.amattrdatatype = amattrdatatype;
        this.amparamattributetype = amparamattributetype;
        this.amsameselleredit = amsameselleredit;
        this.amdifferentselleredit = amdifferentselleredit;
        this.amcode = amcode;
        this.uom = uom;
        this.amcomponentlovgroup = amcomponentlovgroup;
        this.amuomgroup=amuomgroup;
       
        this.amisactive = amisactive;
        this.amismultifield = amismultifield;
        this.amismultivaluefield = amismultivaluefield;
        this.amname = amname;
        this.amsequence = amsequence;
        this.amvalue = amvalue;
        this.regexpressionvalidation = regexpressionvalidation;
        this.regexpressionvalidationmsg = regexpressionvalidationmsg;
        this.urlvalidation = urlvalidation;
        this.amsecmstr = amsecmstr;
        this.slrProdAttrDatas = slrProdAttrDatas;
        this.attrCategoryAssocs = attrCategoryAssocs;
        this.slrCatAttrDatas = slrCatAttrDatas;
        this.slrProdListAttrDatas = slrProdListAttrDatas;
//        this.isvarient = isvarient;
        this.wsbeanproperty = wsbeanproperty;
    }

    /** default constructor */
    public AttrMstr() {
    }

    /** minimal constructor */
    public AttrMstr(Date createdate, String deleted, Date modidate,Long createdby,Long modifiedby, com.sellerportal.model.OctParam amattrdatatype,com.sellerportal.model.OctParam amparamattributetype, String amcode, String amisactive, String amname, Long amsequence, String amvalue, com.sellerportal.model.AttrSecMstr amsecmstr, Set<SlrProdAttrData> slrProdAttrDatas, Set<AttrCategoryAssoc> attrCategoryAssocs,Set<SlrCatAttrData> slrCatAttrDatas,Set<SlrProdListAttrData> slrProdListAttrDatas) {
        this.createdate = createdate;
        this.deleted = deleted;
        this.modidate = modidate;
        this.createdby = createdby;
        this.modifiedby = modifiedby;
        this.amattrdatatype = amattrdatatype;
        this.amparamattributetype = amparamattributetype;
        this.amcode = amcode;
        this.amisactive = amisactive;
        this.amname = amname;
        this.amsequence = amsequence;
        this.amvalue = amvalue;
        this.amsecmstr = amsecmstr;
        this.slrProdAttrDatas = slrProdAttrDatas;
        this.attrCategoryAssocs = attrCategoryAssocs;
        this.slrCatAttrDatas = slrCatAttrDatas;
        this.slrProdListAttrDatas = slrProdListAttrDatas;
    }

    public Long getAmrfnum() {
        return this.amrfnum;
    }

    public void setAmrfnum(Long amrfnum) {
        this.amrfnum = amrfnum;
    }

    public Date getCreatedate() {
        return this.createdate;
    }

    public void setCreatedate(Date createdate) {
        this.createdate = createdate;
    }

    public String getDeleted() {
        return this.deleted;
    }

    public void setDeleted(String deleted) {
        this.deleted = deleted;
    }

    public String getEmailvalidation() {
        return this.emailvalidation;
    }

    public void setEmailvalidation(String emailvalidation) {
        this.emailvalidation = emailvalidation;
    }

    public String getLettersonly() {
        return this.lettersonly;
    }

    public void setLettersonly(String lettersonly) {
        this.lettersonly = lettersonly;
    }

    public String getMandatoryvalidation() {
        return this.mandatoryvalidation;
    }

    public void setMandatoryvalidation(String mandatoryvalidation) {
        this.mandatoryvalidation = mandatoryvalidation;
    }

    public String getMaxlengthvalidation() {
        return this.maxlengthvalidation;
    }

    public void setMaxlengthvalidation(String maxlengthvalidation) {
        this.maxlengthvalidation = maxlengthvalidation;
    }

    public String getMinlengthvalidation() {
        return this.minlengthvalidation;
    }

    public void setMinlengthvalidation(String minlengthvalidation) {
        this.minlengthvalidation = minlengthvalidation;
    }

    public String getMobnumvalidation() {
        return this.mobnumvalidation;
    }

    public void setMobnumvalidation(String mobnumvalidation) {
        this.mobnumvalidation = mobnumvalidation;
    }

    public Date getModidate() {
        return this.modidate;
    }

    public void setModidate(Date modidate) {
        this.modidate = modidate;
    }
    
    public Long getCreatedby() {
		return createdby;
	}

	public void setCreatedby(Long createdby) {
		this.createdby = createdby;
	}

	public Long getModifiedby() {
		return modifiedby;
	}

	public void setModifiedby(Long modifiedby) {
		this.modifiedby = modifiedby;
	}

	public String getNumvalidation() {
        return this.numvalidation;
    }

    public void setNumvalidation(String numvalidation) {
        this.numvalidation = numvalidation;
    }

    public com.sellerportal.model.OctParam getAmattrdatatype() {
		return amattrdatatype;
	}

	public void setAmattrdatatype(com.sellerportal.model.OctParam amattrdatatype) {
		this.amattrdatatype = amattrdatatype;
	}
	
	public com.sellerportal.model.OctParam getAmparamattributetype() {
		return amparamattributetype;
	}

	public void setAmparamattributetype(
			com.sellerportal.model.OctParam amparamattributetype) {
		this.amparamattributetype = amparamattributetype;
	}
	
	public String getAmsameselleredit() {
		return amsameselleredit;
	}

	public void setAmsameselleredit(String amsameselleredit) {
		this.amsameselleredit = amsameselleredit;
	}

	public String getAmdifferentselleredit() {
		return amdifferentselleredit;
	}

	public void setAmdifferentselleredit(String amdifferentselleredit) {
		this.amdifferentselleredit = amdifferentselleredit;
	}

	public String getAmcode() {
        return this.amcode;
    }

    public void setAmcode(String amcode) {
        this.amcode = amcode;
    }

    public String getAmcomponentlovgroup() {
        return this.amcomponentlovgroup;
    }

    public void setAmcomponentlovgroup(String amcomponentlovgroup) {
        this.amcomponentlovgroup = amcomponentlovgroup;
    }

   

    public com.sellerportal.model.OctParam getAmcomponenttype() {
		return amcomponenttype;
	}

	public void setAmcomponenttype(com.sellerportal.model.OctParam amcomponenttype) {
		this.amcomponenttype = amcomponenttype;
	}

	public String getAmisactive() {
        return this.amisactive;
    }

    public void setAmisactive(String amisactive) {
        this.amisactive = amisactive;
    }

    public String getAmismultifield() {
        return this.amismultifield;
    }

    public void setAmismultifield(String amismultifield) {
        this.amismultifield = amismultifield;
    }

    public String getAmismultivaluefield() {
        return this.amismultivaluefield;
    }

    public void setAmismultivaluefield(String amismultivaluefield) {
        this.amismultivaluefield = amismultivaluefield;
    }

    public String getAmname() {
        return this.amname;
    }

    public void setAmname(String amname) {
        this.amname = amname;
    }

    public Long getAmsequence() {
        return this.amsequence;
    }

    public void setAmsequence(Long amsequence) {
        this.amsequence = amsequence;
    }

    public String getAmvalue() {
        return this.amvalue;
    }

    public void setAmvalue(String amvalue) {
        this.amvalue = amvalue;
    }

    public String getRegexpressionvalidation() {
        return this.regexpressionvalidation;
    }

    public void setRegexpressionvalidation(String regexpressionvalidation) {
        this.regexpressionvalidation = regexpressionvalidation;
    }

    public String getRegexpressionvalidationmsg() {
        return this.regexpressionvalidationmsg;
    }

    public void setRegexpressionvalidationmsg(String regexpressionvalidationmsg) {
        this.regexpressionvalidationmsg = regexpressionvalidationmsg;
    }

    public String getUrlvalidation() {
        return this.urlvalidation;
    }

    public void setUrlvalidation(String urlvalidation) {
        this.urlvalidation = urlvalidation;
    }

    public com.sellerportal.model.AttrSecMstr getAmsecmstr() {
		return amsecmstr;
	}

	public void setAmsecmstr(com.sellerportal.model.AttrSecMstr amsecmstr) {
		this.amsecmstr = amsecmstr;
	}

	public Set<AttrCategoryAssoc> getAttrCategoryAssocs() {
        return this.attrCategoryAssocs;
    }

    public void setAttrCategoryAssocs(Set<AttrCategoryAssoc> attrCategoryAssocs) {
        this.attrCategoryAssocs = attrCategoryAssocs;
    }
    
    public Set<SlrProdAttrData> getSlrProdAttrDatas() {
		return slrProdAttrDatas;
	}

	public void setSlrProdAttrDatas(Set<SlrProdAttrData> slrProdAttrDatas) {
		this.slrProdAttrDatas = slrProdAttrDatas;
	}
	
	public Set<SlrCatAttrData> getSlrCatAttrDatas() {
		return slrCatAttrDatas;
	}

	public void setSlrCatAttrDatas(Set<SlrCatAttrData> slrCatAttrDatas) {
		this.slrCatAttrDatas = slrCatAttrDatas;
	}
	
	public Set<SlrProdListAttrData> getSlrProdListAttrDatas() {
		return slrProdListAttrDatas;
	}

	public void setSlrProdListAttrDatas(Set<SlrProdListAttrData> slrProdListAttrDatas) {
		this.slrProdListAttrDatas = slrProdListAttrDatas;
	}

//	public String getIsvarient() {
//		return isvarient;
//	}
//
//	public void setIsvarient(String isvarient) {
//		this.isvarient = isvarient;
//	}
	
	public String getWsbeanproperty() {
		return wsbeanproperty;
	}

	public void setWsbeanproperty(String wsbeanproperty) {
		this.wsbeanproperty = wsbeanproperty;
	}
	
	public String getAmuomgroup() {
		return amuomgroup;
	}

	public void setAmuomgroup(String amuomgroup) {
		this.amuomgroup = amuomgroup;
	}
	
	public String getUom() {
		return uom;
	}

	public void setUom(String uom) {
		this.uom = uom;
	}

	public String toString() {
        return new ToStringBuilder(this)
            .append("pamrfnum", getAmrfnum())
            .toString();
    }

}
