package com.sellerportal.model;

import java.io.Serializable;
import java.util.Date;

import org.apache.commons.lang.builder.ToStringBuilder;
import javax.persistence.*;

@Entity
@Table(name = "OCT_SLR_PROD_ATTR_DATA")
public class SlrProdAttrData implements Serializable {

	@Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "spadrfnum_generator")
    @SequenceGenerator(name = "spadrfnum_generator", sequenceName = "SPAD_SPADRFNUM_SEQ", allocationSize = 1)
    @Column(name = "SPADRFNUM")
    private Long spadrfnum;

    @Column(name = "CREATEDATE", nullable = false)
    private Date createdate;

    @Column(name = "DELETED", nullable = false, length = 1)
    private String deleted;

    @Column(name = "MODIDATE", nullable = false)
    private Date modidate;

    @Column(name = "MODIFIEDBY", nullable = false, length = 19)
    private Long modifiedby;

    @Column(name = "CREATEDBY", nullable = false, length = 24)
    private Long createdby;

    @Column(name = "SCADISACTIVE", nullable = false, length = 1)
    private String spadisactive;

    @Column(name = "SPADVALUE", length = 256)
    private String spadvalue;

    @Column(name = "UOM", length = 256)
    private String uom;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "SPADAMRFNUM", nullable = false)
    private AttrMstr attrMstr;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "SPADSPRFNUM", nullable = false)
    private SlrProduct spadsprfnum;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "SPADPBIRFNUM")
    private Ismpbi ismpbi;

    
    /** full constructor */
    public SlrProdAttrData(Date createdate,Long createdby, Long modifiedby,  String deleted, Date modidate, String spadisactive, com.sellerportal.model.SlrProduct spadsprfnum, String spadvalue,String uom, com.sellerportal.model.AttrMstr attrMstr,com.sellerportal.model.Ismpbi ismpbi) {
        this.createdate = createdate;
        this.deleted = deleted;
        this.modidate = modidate;
        this.createdby = createdby;
        this.modifiedby = modifiedby;
        this.spadisactive = spadisactive;
        this.spadsprfnum = spadsprfnum;
        this.spadvalue = spadvalue;
        this.uom = uom;
        this.attrMstr = attrMstr;
        this.ismpbi = ismpbi;
    }

    /** default constructor */
    public SlrProdAttrData() {
    }

    /** minimal constructor */
    public SlrProdAttrData(Date createdate,Long createdby, Long modifiedby, String deleted, Date modidate, String spadisactive, com.sellerportal.model.SlrProduct spadsprfnum, com.sellerportal.model.AttrMstr attrMstr,com.sellerportal.model.Ismpbi ismpbi) {
        this.createdate = createdate;
        this.deleted = deleted;
        this.modidate = modidate;
        this.createdby = createdby;
        this.modifiedby = modifiedby;
        this.spadisactive = spadisactive;
        this.spadsprfnum = spadsprfnum;
        this.attrMstr = attrMstr;
        this.ismpbi = ismpbi;
    }

    public Long getSpadrfnum() {
        return this.spadrfnum;
    }

    public void setSpadrfnum(Long spadrfnum) {
        this.spadrfnum = spadrfnum;
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

	public String getSpadisactive() {
        return this.spadisactive;
    }

    public void setSpadisactive(String spadisactive) {
        this.spadisactive = spadisactive;
    }
    
    public com.sellerportal.model.SlrProduct getSpadsprfnum() {
		return spadsprfnum;
	}

	public void setSpadsprfnum(com.sellerportal.model.SlrProduct spadsprfnum) {
		this.spadsprfnum = spadsprfnum;
	}

	public String getSpadvalue() {
        return this.spadvalue;
    }

    public void setSpadvalue(String spadvalue) {
        this.spadvalue = spadvalue;
    }

    public String getUom() {
		return uom;
	}

	public void setUom(String uom) {
		this.uom = uom;
	}

	public com.sellerportal.model.AttrMstr getAttrMstr() {
        return this.attrMstr;
    }

    public void setAttrMstr(com.sellerportal.model.AttrMstr attrMstr) {
        this.attrMstr = attrMstr;
    }
    
    public com.sellerportal.model.Ismpbi getIsmpbi() {
		return ismpbi;
	}

	public void setIsmpbi(com.sellerportal.model.Ismpbi ismpbi) {
		this.ismpbi = ismpbi;
	}
	
	public String toString() {
        return new ToStringBuilder(this)
            .append("spadrfnum", getSpadrfnum())
            .toString();
    }

}
