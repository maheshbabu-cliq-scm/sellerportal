package com.sellerportal.model;

import java.io.Serializable;
import java.util.Date;

import org.apache.commons.lang.builder.ToStringBuilder;
import javax.persistence.*;

@Entity
@Table(name = "OCT_SLR_CAT_ATTR_DATA")
public class SlrCatAttrData implements Serializable {

	 @Id
	    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "scad_scadrfnum_seq")
	    @SequenceGenerator(name = "scad_scadrfnum_seq", sequenceName = "SCAD_SCADRFNUM_SEQ", allocationSize = 1)
	    @Column(name = "SCADRFNUM")
	    private Long scadrfnum;

	    @Column(name = "CREATEDATE", nullable = false)
	    private Date createdate;

	    @Column(name = "DELETED", nullable = false, length = 1)
	    private String deleted;

	    @Column(name = "MODIDATE", nullable = false)
	    private Date modidate;

	    @Column(name = "MODIFIEDBY", nullable = false)
	    private Long modifiedby;

	    @Column(name = "CREATEDBY", nullable = false)
	    private Long createdby;

	    @Column(name = "SCADISACTIVE", nullable = false, length = 1)
	    private String scadisactive;

	    @Column(name = "SCADVALUE", length = 256)
	    private String scadvalue;

	    @Column(name = "UOM", length = 256)
	    private String uom;

	    @ManyToOne(fetch = FetchType.LAZY)
	    @JoinColumn(name = "SCADSCARFNUM", nullable = false)
	    private SlrCategoryAssociation slrCategoryAssoc;

	    @ManyToOne(fetch = FetchType.LAZY)
	    @JoinColumn(name = "SCADAMRFNUM", nullable = false)
	    private AttrMstr attrMstr;
	    
    /** full constructor */
    public SlrCatAttrData(Date createdate,Long createdby ,Long modifiedby, String deleted, Date modidate, String scadisactive, String scadvalue,String uom, com.sellerportal.model.AttrMstr attrMstr, com.sellerportal.model.SlrCategoryAssociation slrCategoryAssoc) {
        this.createdate = createdate;
        this.deleted = deleted;
        this.modidate = modidate;
        this.createdby = createdby;
        this.modifiedby = modifiedby;
        this.scadisactive = scadisactive;
//        this.scadslrrfnum = scadslrrfnum;
        this.scadvalue = scadvalue;
        this.uom = uom;
        this.attrMstr = attrMstr;
        this.slrCategoryAssoc = slrCategoryAssoc;
    }

    /** default constructor */
    public SlrCatAttrData() {
    }

    /** minimal constructor */
    public SlrCatAttrData(Date createdate,Long createdby ,Long modifiedby, String deleted, Date modidate, String scadisactive, com.sellerportal.model.AttrMstr attrMstr,com.sellerportal.model.SlrCategoryAssociation slrCategoryAssoc) {
        this.createdate = createdate;
        this.deleted = deleted;
        this.modidate = modidate;
        this.createdby = createdby;
        this.modifiedby = modifiedby;
        this.scadisactive = scadisactive;
//        this.scadslrrfnum = scadslrrfnum;
        this.attrMstr = attrMstr;
        this.slrCategoryAssoc = slrCategoryAssoc;
    }

    public Long getScadrfnum() {
        return this.scadrfnum;
    }

    public void setScadrfnum(Long scadrfnum) {
        this.scadrfnum = scadrfnum;
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

	public String getScadisactive() {
        return this.scadisactive;
    }

    public void setScadisactive(String scadisactive) {
        this.scadisactive = scadisactive;
    }

//    public OctSlr getScadslrrfnum() {
//        return this.scadslrrfnum;
//    }
//
//    public void setScadslrrfnum(OctSlr scadslrrfnum) {
//        this.scadslrrfnum = scadslrrfnum;
//    }

    public String getScadvalue() {
        return this.scadvalue;
    }

    public void setScadvalue(String scadvalue) {
        this.scadvalue = scadvalue;
    }

    public String getUom() {
		return uom;
	}

	public void setUom(String uom) {
		this.uom = uom;
	}

	public com.sellerportal.model.AttrMstr getAttrMstr() {
		return attrMstr;
	}

	public void setAttrMstr(com.sellerportal.model.AttrMstr attrMstr) {
		this.attrMstr = attrMstr;
	}

	public com.sellerportal.model.SlrCategoryAssociation getSlrCategoryAssoc() {
        return this.slrCategoryAssoc;
    }

    public void setSlrCategoryAssoc(com.sellerportal.model.SlrCategoryAssociation slrCategoryAssoc) {
        this.slrCategoryAssoc = slrCategoryAssoc;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("scadrfnum", getScadrfnum())
            .toString();
    }

}
