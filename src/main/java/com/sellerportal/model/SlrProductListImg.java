package com.sellerportal.model;

import java.io.Serializable;
import java.util.Date;

import org.apache.commons.lang.builder.ToStringBuilder;
import javax.persistence.*;

@Entity
@Table(name = "OCT_SLR_PRODUCT_LIST_IMG")
public class SlrProductListImg implements Serializable {

	@Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "spli_splirfnum_seq")
    @SequenceGenerator(name = "spli_splirfnum_seq", sequenceName = "SPLI_SPLIRFNUM_SEQ", allocationSize = 1)
    @Column(name = "SPLIRFNUM")
    private Long splirfnum;

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

    @Column(name = "SPLIIMGFILE", length = 256)
    private String spliimgfile;

    @Column(name = "SPLISEQUENCE", length = 5)
    private String splisequence;

    @Column(name = "SPLIPRIORITY", length = 2)
    private Long splipriority;

    @ManyToOne
    @JoinColumn(name = "SPLISPLRFNUM", nullable = false)
    private SlrProductList slrProductList;

    /** full constructor */
    public SlrProductListImg(Date createdate, Long createdby, String deleted, Date modidate, Long modifiedby, String spliimgfile, String splisequence,Long splipriority, com.sellerportal.model.SlrProductList slrProductList) {
        this.createdate = createdate;
        this.createdby = createdby;
        this.deleted = deleted;
        this.modidate = modidate;
        this.modifiedby = modifiedby;
        this.spliimgfile = spliimgfile;
        this.splisequence = splisequence;
        this.splipriority = splipriority;
        this.slrProductList = slrProductList;
    }

    /** default constructor */
    public SlrProductListImg() {
    }

    /** minimal constructor */
    public SlrProductListImg(Date createdate, Long createdby, String deleted, Date modidate, Long modifiedby, com.sellerportal.model.SlrProductList slrProductList) {
        this.createdate = createdate;
        this.createdby = createdby;
        this.deleted = deleted;
        this.modidate = modidate;
        this.modifiedby = modifiedby;
        this.slrProductList = slrProductList;
    }

    public Long getSplirfnum() {
        return this.splirfnum;
    }

    public void setSplirfnum(Long splirfnum) {
        this.splirfnum = splirfnum;
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

    public String getSpliimgfile() {
        return this.spliimgfile;
    }

    public void setSpliimgfile(String spliimgfile) {
        this.spliimgfile = spliimgfile;
    }

    public String getSplisequence() {
        return this.splisequence;
    }

    public void setSplisequence(String splisequence) {
        this.splisequence = splisequence;
    }
    
    public Long getSplipriority() {
		return splipriority;
	}

	public void setSplipriority(Long splipriority) {
		this.splipriority = splipriority;
	}

	public com.sellerportal.model.SlrProductList getSlrProductList() {
        return this.slrProductList;
    }

    public void setSlrProductList(com.sellerportal.model.SlrProductList slrProductList) {
        this.slrProductList = slrProductList;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("splirfnum", getSplirfnum())
            .toString();
    }

}
