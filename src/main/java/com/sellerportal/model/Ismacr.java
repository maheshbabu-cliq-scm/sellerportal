package com.sellerportal.model;

import java.io.Serializable;
import java.util.Date;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

import javax.persistence.*;

/** @author Hibernate CodeGenerator */
@Entity
@Table(name = "ISMACR")
public class Ismacr implements Serializable {
    
	@EmbeddedId
    private com.sellerportal.dao.IsmacrPK comp_id;

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

    @ManyToOne
    @JoinColumn(name = "ACRARMRFNUM", insertable = false, updatable = false)
    private Ismarm ismarm;

    @ManyToOne
    @JoinColumn(name = "ACRACMRFNUM", insertable = false, updatable = false)
    private Ismacm ismacm;

    /** full constructor */
    public Ismacr(com.sellerportal.dao.IsmacrPK comp_id, String active, Date createdate, Long createdby, String deleted, Date modidate, com.sellerportal.model.Ismarm ismarm, com.sellerportal.model.Ismacm ismacm) {
        this.comp_id = comp_id;
        this.active = active;
        this.createdate = createdate;
        this.createdby = createdby;
        this.deleted = deleted;
        this.modidate = modidate;
        this.ismarm = ismarm;
        this.ismacm = ismacm;
    }

    /** default constructor */
    public Ismacr() {
    }

    /** minimal constructor */
    public Ismacr(com.sellerportal.dao.IsmacrPK comp_id, Date createdate, Long createdby, String deleted, Date modidate) {
        this.comp_id = comp_id;
        this.createdate = createdate;
        this.createdby = createdby;
        this.deleted = deleted;
        this.modidate = modidate;
    }

    public com.sellerportal.dao.IsmacrPK getComp_id() {
        return this.comp_id;
    }

    public void setComp_id(com.sellerportal.dao.IsmacrPK comp_id) {
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

    public com.sellerportal.model.Ismarm getIsmarm() {
        return this.ismarm;
    }

    public void setIsmarm(com.sellerportal.model.Ismarm ismarm) {
        this.ismarm = ismarm;
    }

    public com.sellerportal.model.Ismacm getIsmacm() {
        return this.ismacm;
    }

    public void setIsmacm(com.sellerportal.model.Ismacm ismacm) {
        this.ismacm = ismacm;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("comp_id", getComp_id())
            .toString();
    }

    public boolean equals(Object other) {
        if ( (this == other ) ) return true;
        if ( !(other instanceof Ismacr) ) return false;
        Ismacr castOther = (Ismacr) other;
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
