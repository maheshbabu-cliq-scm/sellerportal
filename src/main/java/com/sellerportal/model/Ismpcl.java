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
@Table(name = "Ismpcl")
public class Ismpcl implements Serializable {

	/** identifier field */
    @EmbeddedId
    private IsmpclPK comp_id;

    /** persistent field */
    @Column(name = "createdate")
    private Date createdate;

    /** persistent field */
    @Column(name = "createdby")
    private Long createdby;

    /** persistent field */
    @Column(name = "deleted")
    private String deleted;

    /** persistent field */
    @Column(name = "modidate")
    private Date modidate;

    /** nullable persistent field */
    @Column(name = "pclseqnum")
    private String pclseqnum;

    /** nullable persistent field */
    @ManyToOne
    @JoinColumn(name = "PCLMCTRFNUM",insertable = false, updatable = false)
    private Ismmct ismmct;

    /** full constructor */
    public Ismpcl(IsmpclPK comp_id, Date createdate, Long createdby, String deleted, Date modidate, String pclseqnum, Ismmct ismmct) {
        this.comp_id = comp_id;
        this.createdate = createdate;
        this.createdby = createdby;
        this.deleted = deleted;
        this.modidate = modidate;
        this.pclseqnum = pclseqnum;
        this.ismmct = ismmct;
    }

    /** default constructor */
    public Ismpcl() {
    }

    /** minimal constructor */
    public Ismpcl(IsmpclPK comp_id, Date createdate, Long createdby, String deleted, Date modidate) {
        this.comp_id = comp_id;
        this.createdate = createdate;
        this.createdby = createdby;
        this.deleted = deleted;
        this.modidate = modidate;
    }

    public IsmpclPK getComp_id() {
        return this.comp_id;
    }

    public void setComp_id(IsmpclPK comp_id) {
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

    public String getPclseqnum() {
        return this.pclseqnum;
    }

    public void setPclseqnum(String pclseqnum) {
        this.pclseqnum = pclseqnum;
    }

    public Ismmct getIsmmct() {
        return this.ismmct;
    }

    public void setIsmmct(Ismmct ismmct) {
        this.ismmct = ismmct;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("comp_id", getComp_id())
            .toString();
    }

    public boolean equals(Object other) {
        if ( (this == other ) ) return true;
        if ( !(other instanceof Ismpcl) ) return false;
        Ismpcl castOther = (Ismpcl) other;
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
