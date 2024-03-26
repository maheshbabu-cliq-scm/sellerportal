package com.sellerportal.model;

import java.io.Serializable;


import java.util.Date;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;


import javax.persistence.*;

@Entity
@Table(name = "ISMOCR")
public class Ismocr implements Serializable {

	@EmbeddedId
    private IsmocrPK comp_id;

    @ManyToOne
    @JoinColumn(name = "OCROCMRFNUM", insertable = false, updatable = false)
    private Ismocm ismocm;

    @ManyToOne
    @JoinColumn(name = "OCRORMRFNUM", insertable = false, updatable = false)
    private Ismorm ismorm;

    @Column(name = "ACTIVE", length = 1)
    private String active;

    @Column(name = "CREATEDATE", nullable = false)
    private Date createdate;

    @Column(name = "CREATEDBY", nullable = false)
    private Long createdby;

    @Column(name = "DELETED", nullable = false, length = 1)
    private String deleted;

    @Column(name = "MODIDATE", nullable = false)
    private Date modidate;


    /** full constructor */
    public Ismocr(com.sellerportal.model.IsmocrPK comp_id, String active, Date createdate, Long createdby, String deleted, Date modidate, com.sellerportal.model.Ismorm ismorm, com.sellerportal.model.Ismocm ismocm) {
        this.comp_id = comp_id;
        this.active = active;
        this.createdate = createdate;
        this.createdby = createdby;
        this.deleted = deleted;
        this.modidate = modidate;
        this.ismorm = ismorm;
        this.ismocm = ismocm;
    }

    /** default constructor */
    public Ismocr() {
    }

    /** minimal constructor */
    public Ismocr(com.sellerportal.model.IsmocrPK comp_id, Date createdate, Long createdby, String deleted, Date modidate) {
        this.comp_id = comp_id;
        this.createdate = createdate;
        this.createdby = createdby;
        this.deleted = deleted;
        this.modidate = modidate;
    }

    public com.sellerportal.model.IsmocrPK getComp_id() {
        return this.comp_id;
    }

    public void setComp_id(com.sellerportal.model.IsmocrPK comp_id) {
        this.comp_id = comp_id;
    }

    public String getActive() {
        return this.active;
    }

    public void setActive(String active) {
        this.active = active;
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

    public com.sellerportal.model.Ismocm getIsmocm() {
        return this.ismocm;
    }

    public void setIsmocm(com.sellerportal.model.Ismocm ismocm) {
        this.ismocm = ismocm;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("comp_id", getComp_id())
            .toString();
    }

    public boolean equals(Object other) {
        if ( (this == other ) ) return true;
        if ( !(other instanceof Ismocr) ) return false;
        Ismocr castOther = (Ismocr) other;
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
