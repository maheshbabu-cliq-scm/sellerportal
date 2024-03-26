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
@Table(name = "ISMROT")
public class Ismrot implements Serializable {

	 /** identifier field */
    @EmbeddedId
    private IsmrotPK comp_id;

    /** persistent field */
    @Column(name = "CREATEDATE")
    private Date createdate;

    /** nullable persistent field */
    @Column(name = "CREATEDBY")
    private Long createdby;

    /** nullable persistent field */
    @Column(name = "DELETED")
    private String deleted;

    /** persistent field */
    @Column(name = "MODIDATE")
    private Date modidate;

    /** nullable persistent field */
    @ManyToOne
    @JoinColumn(name = "ROTORMRFNUM",insertable = false, updatable = false)
    private Ismorm ismorm;

    /** nullable persistent field */
    @ManyToOne
    @JoinColumn(name = "ROTOSTRFNUM",insertable = false, updatable = false)
    private Ismosu ismosu;

    /** full constructor */
    public Ismrot(IsmrotPK comp_id, Date createdate, Long createdby, String deleted, Date modidate, Ismorm ismorm, Ismosu ismosu) {
        this.comp_id = comp_id;
        this.createdate = createdate;
        this.createdby = createdby;
        this.deleted = deleted;
        this.modidate = modidate;
        this.ismorm = ismorm;
        this.ismosu = ismosu;
    }

    /** default constructor */
    public Ismrot() {
    }

    /** minimal constructor */
    public Ismrot(IsmrotPK comp_id, Date createdate, Date modidate) {
        this.comp_id = comp_id;
        this.createdate = createdate;
        this.modidate = modidate;
    }

    public IsmrotPK getComp_id() {
        return this.comp_id;
    }

    public void setComp_id(IsmrotPK comp_id) {
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

    public Ismosu getIsmosu() {
        return this.ismosu;
    }

    public void setIsmosu(Ismosu ismosu) {
        this.ismosu = ismosu;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("comp_id", getComp_id())
            .toString();
    }

    public boolean equals(Object other) {
        if ( (this == other ) ) return true;
        if ( !(other instanceof Ismrot) ) return false;
        Ismrot castOther = (Ismrot) other;
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
