package com.sellerportal.model;

import java.io.Serializable;
import java.util.Date;

import org.apache.commons.lang.builder.ToStringBuilder;
import javax.persistence.*;

@Entity
@Table(name = "OCT_ATTR_CATEGORY_ASSOC")
public class AttrCategoryAssoc implements Serializable {

	@Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "aca_acarfnum_seq")
    @SequenceGenerator(name = "aca_acarfnum_seq", sequenceName = "ACA_ACARFNUM_SEQ", allocationSize = 1)
    @Column(name = "ACARFNUM")
    private Long acarfnum;

    @Column(name = "ACAISACTIVE", nullable = false, length = 1)
    private String acaisactive;

    @Column(name = "ACAVALUE", length = 256)
    private String acavalue;

    @Column(name = "UOM", length = 256)
    private String uom;

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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ACACMTRFNUM", nullable = false)
    private Ismcmt acacmtrfnum;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ACAAMRFNUM", nullable = false)
    private AttrMstr attrMstr;

    /** full constructor */
    public AttrCategoryAssoc(Long createdby, Long modifiedby, com.sellerportal.model.Ismcmt acacmtrfnum, String acaisactive, String acavalue, String uom, Date createdate, String deleted, Date modidate, com.sellerportal.model.AttrMstr attrMstr) {
        this.acacmtrfnum = acacmtrfnum;
        this.acaisactive = acaisactive;
        this.acavalue = acavalue;
        this.createdate = createdate;
        this.deleted = deleted;
        this.modidate = modidate;
        this.createdby = createdby;
        this.modifiedby = modifiedby;
        this.attrMstr = attrMstr;
        this.uom = uom;
    }

    /** default constructor */
    public AttrCategoryAssoc() {
    }

    /** minimal constructor */
    public AttrCategoryAssoc(Long createdby, Long modifiedby, com.sellerportal.model.Ismcmt acacmtrfnum, String acaisactive, Date createdate, String deleted, Date modidate, com.sellerportal.model.AttrMstr attrMstr) {
        this.acacmtrfnum = acacmtrfnum;
        this.acaisactive = acaisactive;
        this.createdate = createdate;
        this.deleted = deleted;
        this.modidate = modidate;
        this.createdby = createdby;
        this.modifiedby = modifiedby;
        this.attrMstr = attrMstr;
    }

    public Long getAcarfnum() {
        return this.acarfnum;
    }

    public void setAcarfnum(Long acarfnum) {
        this.acarfnum = acarfnum;
    }
    
    public com.sellerportal.model.Ismcmt getAcacmtrfnum() {
		return acacmtrfnum;
	}

	public void setAcacmtrfnum(com.sellerportal.model.Ismcmt acacmtrfnum) {
		this.acacmtrfnum = acacmtrfnum;
	}

	public String getAcaisactive() {
        return this.acaisactive;
    }

    public void setAcaisactive(String acaisactive) {
        this.acaisactive = acaisactive;
    }

    public String getAcavalue() {
        return this.acavalue;
    }

    public void setAcavalue(String acavalue) {
        this.acavalue = acavalue;
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

	public com.sellerportal.model.AttrMstr getAttrMstr() {
        return this.attrMstr;
    }

    public void setAttrMstr(com.sellerportal.model.AttrMstr attrMstr) {
        this.attrMstr = attrMstr;
    }

    public String getUom() {
		return uom;
	}

	public void setUom(String uom) {
		this.uom = uom;
	}

	public String toString() {
        return new ToStringBuilder(this)
            .append("acarfnum", getAcarfnum())
            .toString();
    }

}
