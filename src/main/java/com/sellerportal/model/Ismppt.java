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
@Table(name = "Ismppt")
public class Ismppt implements Serializable {

	/** identifier field */
    @EmbeddedId
    private IsmpptPK comp_id;

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

    /** persistent field */
    @Column(name = "PPTISPRIMARY")
    private String pptisprimary;

    /** nullable persistent field */
    @ManyToOne
    @JoinColumn(name = "PPTPBIRFNUM",insertable = false, updatable = false)
    private Ismpbi ismpbi;

    /** nullable persistent field */
    @ManyToOne
    @JoinColumn(name = "PPTCMTRFNUM", insertable = false, updatable = false)
    private Ismcmt ismcmt;

    /** persistent field */
    @Column(name = "MODIFIEDBY")
    private Long modifiedby;


    /** full constructor */
    public Ismppt(IsmpptPK comp_id, Date createdate, Long createdby, String deleted, Date modidate, String pptisprimary, Ismpbi ismpbi, Ismcmt ismcmt,Long modifiedby) {
        this.comp_id = comp_id;
        this.createdate = createdate;
        this.createdby = createdby;
        this.deleted = deleted;
        this.modidate = modidate;
        this.pptisprimary = pptisprimary;
        this.ismpbi = ismpbi;
        this.ismcmt = ismcmt;
        this.modifiedby = modifiedby;
    }

    /** default constructor */
    public Ismppt() {
    }

    /** minimal constructor */
    public Ismppt(IsmpptPK comp_id, Date createdate, Long createdby, String deleted, Date modidate, String pptisprimary) {
        this.comp_id = comp_id;
        this.createdate = createdate;
        this.createdby = createdby;
        this.deleted = deleted;
        this.modidate = modidate;
        this.pptisprimary = pptisprimary;
    }

    public IsmpptPK getComp_id() {
        return this.comp_id;
    }

    public void setComp_id(IsmpptPK comp_id) {
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

    public String getPptisprimary() {
        return this.pptisprimary;
    }

    public void setPptisprimary(String pptisprimary) {
        this.pptisprimary = pptisprimary;
    }

    public Ismpbi getIsmpbi() {
        return this.ismpbi;
    }

    public void setIsmpbi(Ismpbi ismpbi) {
        this.ismpbi = ismpbi;
    }

    public Ismcmt getIsmcmt() {
        return this.ismcmt;
    }

    public void setIsmcmt(Ismcmt ismcmt) {
        this.ismcmt = ismcmt;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("comp_id", getComp_id())
            .toString();
    }

    public boolean equals(Object other) {
        if ( (this == other ) ) return true;
        if ( !(other instanceof Ismppt) ) return false;
        Ismppt castOther = (Ismppt) other;
        return new EqualsBuilder()
            .append(this.getComp_id(), castOther.getComp_id())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getComp_id())
            .toHashCode();
    }

	public Long getModifiedby() {
		return modifiedby;
	}

	public void setModifiedby(Long modifiedby) {
		this.modifiedby = modifiedby;
	}

}
