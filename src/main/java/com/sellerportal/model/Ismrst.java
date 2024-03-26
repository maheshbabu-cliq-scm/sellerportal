package com.sellerportal.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;


/** @author Hibernate CodeGenerator */
@Entity
@Table(name = "ISMRST")
public class Ismrst implements Serializable {

	/** identifier field */
    @EmbeddedId
    private IsmrstPK comp_id;

    /** persistent field */
    @Column(name = "CREATEDATE")
    private Date createdate;

    /** persistent field */
    @Column(name = "CREATEDBY")
    private Long createdby;

    /** persistent field */
    @Column(name = "DELETED")
    private String deleted;

    /** persistent field */
    @Column(name = "MODIDATE")
    private Date modidate;

    /** nullable persistent field */
    @ManyToOne
    @JoinColumn(name = "RSTORMRFNUM",insertable = false, updatable = false)
    private Ismorm ismorm;

    /** nullable persistent field */
    @ManyToOne
    @JoinColumn(name = "RSTSSTRFNUM",insertable = false, updatable = false)
    private Ismssu ismssu;

    /** full constructor */
    public Ismrst(IsmrstPK comp_id, Date createdate, Long createdby, String deleted, Date modidate, Ismorm ismorm, Ismssu ismssu) {
        this.comp_id = comp_id;
        this.createdate = createdate;
        this.createdby = createdby;
        this.deleted = deleted;
        this.modidate = modidate;
        this.ismorm = ismorm;
        this.ismssu = ismssu;
    }

    /** default constructor */
    public Ismrst() {
    }

    /** minimal constructor */
    public Ismrst(IsmrstPK comp_id, Date createdate, Long createdby, String deleted, Date modidate) {
        this.comp_id = comp_id;
        this.createdate = createdate;
        this.createdby = createdby;
        this.deleted = deleted;
        this.modidate = modidate;
    }

    public IsmrstPK getComp_id() {
        return this.comp_id;
    }

    public void setComp_id(IsmrstPK comp_id) {
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

    public Ismorm getIsmorm() {
        return this.ismorm;
    }

    public void setIsmorm(Ismorm ismorm) {
        this.ismorm = ismorm;
    }

    public Ismssu getIsmssu() {
        return this.ismssu;
    }

    public void setIsmssu(Ismssu ismssu) {
        this.ismssu = ismssu;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("comp_id", getComp_id())
            .toString();
    }

    public boolean equals(Object other) {
        if ( (this == other ) ) return true;
        if ( !(other instanceof Ismrst) ) return false;
        Ismrst castOther = (Ismrst) other;
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
