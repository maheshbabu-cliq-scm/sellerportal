package com.sellerportal.model;

import java.io.Serializable;
import java.util.Date;

import org.apache.commons.lang.builder.ToStringBuilder;
import javax.persistence.*;

@Entity
@Table(name = "OCT_SLR_PROD_LIST_ATTR_DATA")
public class SlrProdListAttrData implements Serializable {

	 @Id
	    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "splad_spladrfnum_seq")
	    @SequenceGenerator(name = "splad_spladrfnum_seq", sequenceName = "SPLAD_SPLADRFNUM_SEQ", allocationSize = 1)
	    @Column(name = "SPLADRFNUM")
	    private Long spladrfnum;

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

	    @Column(name = "SPLADISACTIVE", nullable = false, length = 1)
	    private String spladisactive;

	    @Column(name = "SPLADVALUE", length = 256)
	    private String spladvalue;

	    @Column(name = "UOM", length = 256)
	    private String uom;

	    @ManyToOne(fetch = FetchType.LAZY)
	    @JoinColumn(name = "SPLADAMRFNUM", nullable = false)
	    private AttrMstr attrMstr;

	    @ManyToOne(fetch = FetchType.LAZY)
	    @JoinColumn(name = "SPLADSPLRFNUM", nullable = false)
	    private SlrProductList spladsplrfnum;
	    
    /** full constructor */
    public SlrProdListAttrData(Date createdate,Long createdby, Long modifiedby,  String deleted, Date modidate, String spladisactive, com.sellerportal.model.SlrProductList spladsplrfnum, String spladvalue, String uom, com.sellerportal.model.AttrMstr attrMstr) {
        this.createdate = createdate;
        this.deleted = deleted;
        this.modidate = modidate;
        this.createdby = createdby;
        this.modifiedby = modifiedby;
        this.spladisactive = spladisactive;
        this.spladsplrfnum = spladsplrfnum;
        this.spladvalue = spladvalue;
        this.uom = uom;
        this.attrMstr = attrMstr;
    }

    /** default constructor */
    public SlrProdListAttrData() {
    }

    /** minimal constructor */
    public SlrProdListAttrData(Date createdate,Long createdby, Long modifiedby, String deleted, Date modidate, String spladisactive, com.sellerportal.model.SlrProductList spladsplrfnum, com.sellerportal.model.AttrMstr attrMstr) {
        this.createdate = createdate;
        this.deleted = deleted;
        this.modidate = modidate;
        this.createdby = createdby;
        this.modifiedby = modifiedby;
        this.spladisactive = spladisactive;
        this.spladsplrfnum = spladsplrfnum;
        this.attrMstr = attrMstr;
    }

    
    public Long getSpladrfnum() {
		return spladrfnum;
	}

	public void setSpladrfnum(Long spladrfnum) {
		this.spladrfnum = spladrfnum;
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

	public String getSpladisactive() {
		return spladisactive;
	}

	public void setSpladisactive(String spladisactive) {
		this.spladisactive = spladisactive;
	}

	public com.sellerportal.model.SlrProductList getSpladsplrfnum() {
		return spladsplrfnum;
	}

	public void setSpladsplrfnum(com.sellerportal.model.SlrProductList spladsplrfnum) {
		this.spladsplrfnum = spladsplrfnum;
	}

	public String getSpladvalue() {
		return spladvalue;
	}

	public void setSpladvalue(String spladvalue) {
		this.spladvalue = spladvalue;
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

    public String toString() {
        return new ToStringBuilder(this)
            .append("spladrfnum", getSpladrfnum())
            .toString();
    }

}
