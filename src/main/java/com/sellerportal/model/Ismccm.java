package com.sellerportal.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.*;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;


@Entity
@Table(name = "ISMCCM")
public class Ismccm implements Serializable {

	@EmbeddedId
    private IsmccmPK comp_id;

    @Column(name = "CCMFACTOR", nullable = false, length = 10)
    private BigDecimal ccmfactor;

    @Column(name = "CREATEDATE", nullable = false, length = 19)
    private Date createdate;

    @Column(name = "CREATEDBY", nullable = false, length = 20)
    private Long createdby;

    @Column(name = "DELETED", nullable = false, length = 1)
    private String deleted;

    @Column(name = "MODIDATE", nullable = false, length = 19)
    private Date modidate;

    @ManyToOne
    @JoinColumn(name = "CCMFROMCURR",insertable = false, updatable = false)
    private Ismcct ismcctByCcmfromcurr;

    @ManyToOne
    @JoinColumn(name = "CCMTOCURR",insertable = false, updatable = false)
    private Ismcct ismcctByCcmtocurr;

    /** full constructor */
    public Ismccm(com.sellerportal.model.IsmccmPK comp_id, BigDecimal ccmfactor, Date createdate, Long createdby, String deleted, Date modidate, com.sellerportal.model.Ismcct ismcctByCcmfromcurr, com.sellerportal.model.Ismcct ismcctByCcmtocurr) {
        this.comp_id = comp_id;
        this.ccmfactor = ccmfactor;
        this.createdate = createdate;
        this.createdby = createdby;
        this.deleted = deleted;
        this.modidate = modidate;
        this.ismcctByCcmfromcurr = ismcctByCcmfromcurr;
        this.ismcctByCcmtocurr = ismcctByCcmtocurr;
    }

    /** default constructor */
    public Ismccm() {
    }

    /** minimal constructor */
    public Ismccm(com.sellerportal.model.IsmccmPK comp_id, BigDecimal ccmfactor, Date createdate, Long createdby, String deleted, Date modidate) {
        this.comp_id = comp_id;
        this.ccmfactor = ccmfactor;
        this.createdate = createdate;
        this.createdby = createdby;
        this.deleted = deleted;
        this.modidate = modidate;
    }

    public com.sellerportal.model.IsmccmPK getComp_id() {
        return this.comp_id;
    }

    public void setComp_id(com.sellerportal.model.IsmccmPK comp_id) {
        this.comp_id = comp_id;
    }

    public BigDecimal getCcmfactor() {
        return this.ccmfactor;
    }

    public void setCcmfactor(BigDecimal ccmfactor) {
        this.ccmfactor = ccmfactor;
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

    public com.sellerportal.model.Ismcct getIsmcctByCcmfromcurr() {
        return this.ismcctByCcmfromcurr;
    }

    public void setIsmcctByCcmfromcurr(com.sellerportal.model.Ismcct ismcctByCcmfromcurr) {
        this.ismcctByCcmfromcurr = ismcctByCcmfromcurr;
    }

    public com.sellerportal.model.Ismcct getIsmcctByCcmtocurr() {
        return this.ismcctByCcmtocurr;
    }

    public void setIsmcctByCcmtocurr(com.sellerportal.model.Ismcct ismcctByCcmtocurr) {
        this.ismcctByCcmtocurr = ismcctByCcmtocurr;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("comp_id", getComp_id())
            .toString();
    }

    public boolean equals(Object other) {
        if ( (this == other ) ) return true;
        if ( !(other instanceof Ismccm) ) return false;
        Ismccm castOther = (Ismccm) other;
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
