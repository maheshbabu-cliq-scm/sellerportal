package com.sellerportal.model;

import java.io.Serializable;
import java.util.Date;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import javax.persistence.*;

@Entity
@Table(name = "ISMRSA")
public class Ismrsa implements Serializable {

	 @EmbeddedId
	    private IsmrsaPK comp_id;

	    @ManyToOne(fetch = FetchType.LAZY)
	    @JoinColumn(name = "RSAORMRFNUM", insertable = false, updatable = false)
	    private Ismorm ismorm;

	    @ManyToOne(fetch = FetchType.LAZY)
	    @JoinColumn(name = "RSASMTRFNUM", insertable = false, updatable = false)
	    private Ismsmt ismsmt;

	    @Column(name = "CREATEDATE", nullable = false)
	    private Date createdate;

	    @Column(name = "CREATEDBY", nullable = false)
	    private Long createdby;

	    @Column(name = "DELETED", nullable = false, length = 1)
	    private String deleted;

	    @Column(name = "MODIDATE", nullable = false)
	    private Date modidate;

    /** full constructor */
    public Ismrsa(com.sellerportal.model.IsmrsaPK comp_id, Date createdate, Long createdby, String deleted, Date modidate, com.sellerportal.model.Ismorm ismorm, com.sellerportal.model.Ismsmt ismsmt) {
        this.comp_id = comp_id;
        this.createdate = createdate;
        this.createdby = createdby;
        this.deleted = deleted;
        this.modidate = modidate;
        this.ismorm = ismorm;
        this.ismsmt = ismsmt;
    }

    /** default constructor */
    public Ismrsa() {
    }

    /** minimal constructor */
    public Ismrsa(com.sellerportal.model.IsmrsaPK comp_id, Date createdate, Long createdby, String deleted, Date modidate) {
        this.comp_id = comp_id;
        this.createdate = createdate;
        this.createdby = createdby;
        this.deleted = deleted;
        this.modidate = modidate;
    }

    public com.sellerportal.model.IsmrsaPK getComp_id() {
        return this.comp_id;
    }

    public void setComp_id(com.sellerportal.model.IsmrsaPK comp_id) {
        this.comp_id = comp_id;
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

    public com.sellerportal.model.Ismorm getIsmorm() {
        return this.ismorm;
    }

    public void setIsmorm(com.sellerportal.model.Ismorm ismorm) {
        this.ismorm = ismorm;
    }

    public com.sellerportal.model.Ismsmt getIsmsmt() {
        return this.ismsmt;
    }

    public void setIsmsmt(com.sellerportal.model.Ismsmt ismsmt) {
        this.ismsmt = ismsmt;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("comp_id", getComp_id())
            .toString();
    }

    public boolean equals(Object other) {
        if ( (this == other ) ) return true;
        if ( !(other instanceof Ismrsa) ) return false;
        Ismrsa castOther = (Ismrsa) other;
        return new EqualsBuilder()
            .append(this.getComp_id(), castOther.getComp_id())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getComp_id())
            .toHashCode();
    }

}
