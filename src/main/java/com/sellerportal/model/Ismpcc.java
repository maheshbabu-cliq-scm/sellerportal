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
@Table(name = "Ismpcc")
public class Ismpcc implements Serializable {

	/** identifier field */
    @EmbeddedId
    private IsmpccPK comp_id;

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
    @Column(name = "pccpriority")
    private Integer pccpriority;

    /** nullable persistent field */
    @ManyToOne
    @JoinColumn(name = "PBIRFNUM",insertable = false, updatable = false)
    private Ismpbi ismpbi;

    /** nullable persistent field */
    @ManyToOne
    @JoinColumn(name = "PCCCCRRFNUM",insertable = false, updatable = false)
    private Ismccr ismccr;

    /** persistent field */
    @ManyToOne
    @JoinColumn(name = "PCCBODY",insertable = false, updatable = false)
    private Ismdem ismdemByPccbody;

    /** persistent field */
    @ManyToOne
    @JoinColumn(name = "PCCHEADER",insertable = false, updatable = false)
    private Ismdem ismdemByPccheader;

    /** persistent field */
    @ManyToOne
    @JoinColumn(name = "PCCFOOTER",insertable = false, updatable = false)
    private Ismdem ismdemByPccfooter;

    /** full constructor */
    public Ismpcc(IsmpccPK comp_id, Date createdate, Long createdby, String deleted, Date modidate, Integer pccpriority, Ismpbi ismpbi, Ismccr ismccr, Ismdem ismdemByPccbody, Ismdem ismdemByPccheader, Ismdem ismdemByPccfooter) {
        this.comp_id = comp_id;
        this.createdate = createdate;
        this.createdby = createdby;
        this.deleted = deleted;
        this.modidate = modidate;
        this.pccpriority = pccpriority;
        this.ismpbi = ismpbi;
        this.ismccr = ismccr;
        this.ismdemByPccbody = ismdemByPccbody;
        this.ismdemByPccheader = ismdemByPccheader;
        this.ismdemByPccfooter = ismdemByPccfooter;
    }

    /** default constructor */
    public Ismpcc() {
    }

    /** minimal constructor */
    public Ismpcc(IsmpccPK comp_id, Date createdate, Long createdby, String deleted, Date modidate, Ismdem ismdemByPccbody, Ismdem ismdemByPccheader, Ismdem ismdemByPccfooter) {
        this.comp_id = comp_id;
        this.createdate = createdate;
        this.createdby = createdby;
        this.deleted = deleted;
        this.modidate = modidate;
        this.ismdemByPccbody = ismdemByPccbody;
        this.ismdemByPccheader = ismdemByPccheader;
        this.ismdemByPccfooter = ismdemByPccfooter;
    }

    public IsmpccPK getComp_id() {
        return this.comp_id;
    }

    public void setComp_id(IsmpccPK comp_id) {
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

    public Integer getPccpriority() {
        return this.pccpriority;
    }

    public void setPccpriority(Integer pccpriority) {
        this.pccpriority = pccpriority;
    }

    public Ismpbi getIsmpbi() {
        return this.ismpbi;
    }

    public void setIsmpbi(Ismpbi ismpbi) {
        this.ismpbi = ismpbi;
    }

    public Ismccr getIsmccr() {
        return this.ismccr;
    }

    public void setIsmccr(Ismccr ismccr) {
        this.ismccr = ismccr;
    }

    public Ismdem getIsmdemByPccbody() {
        return this.ismdemByPccbody;
    }

    public void setIsmdemByPccbody(Ismdem ismdemByPccbody) {
        this.ismdemByPccbody = ismdemByPccbody;
    }

    public Ismdem getIsmdemByPccheader() {
        return this.ismdemByPccheader;
    }

    public void setIsmdemByPccheader(Ismdem ismdemByPccheader) {
        this.ismdemByPccheader = ismdemByPccheader;
    }

    public Ismdem getIsmdemByPccfooter() {
        return this.ismdemByPccfooter;
    }

    public void setIsmdemByPccfooter(Ismdem ismdemByPccfooter) {
        this.ismdemByPccfooter = ismdemByPccfooter;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("comp_id", getComp_id())
            .toString();
    }

    public boolean equals(Object other) {
        if ( (this == other ) ) return true;
        if ( !(other instanceof Ismpcc) ) return false;
        Ismpcc castOther = (Ismpcc) other;
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
