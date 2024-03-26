package com.sellerportal.model;

import java.io.Serializable;
import java.util.Date;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import javax.persistence.*;

@Entity
@Table(name = "ISMSVU")
public class Ismsvu implements Serializable {

	@EmbeddedId
    private IsmsvuPK comp_id;

    @Column(name = "CREATEDATE", nullable = false)
    private Date createdate;

    @Column(name = "CREATEDBY", length = 20)
    private Long createdby;

    @Column(name = "DELETED", length = 1)
    private String deleted;

    @Column(name = "MODIDATE", nullable = false)
    private Date modidate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "SVUPVMRFNUM",  insertable = false, updatable = false)
    private Ismpvm ismpvm;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "SVUSMTRFNUM",  insertable = false, updatable = false)
    private Ismsmt ismsmt;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "SVUSMDRFNUM",  insertable = false, updatable = false)
    private Ismsmd ismsmd;

    /** full constructor */
    public Ismsvu(com.sellerportal.model.IsmsvuPK comp_id, Date createdate, Long createdby, String deleted, Date modidate, com.sellerportal.model.Ismpvm ismpvm, com.sellerportal.model.Ismsmt ismsmt, com.sellerportal.model.Ismsmd ismsmd) {
        this.comp_id = comp_id;
        this.createdate = createdate;
        this.createdby = createdby;
        this.deleted = deleted;
        this.modidate = modidate;
        this.ismpvm = ismpvm;
        this.ismsmt = ismsmt;
        this.ismsmd = ismsmd;
    }

    /** default constructor */
    public Ismsvu() {
    }

    /** minimal constructor */
    public Ismsvu(com.sellerportal.model.IsmsvuPK comp_id, Date createdate, Date modidate) {
        this.comp_id = comp_id;
        this.createdate = createdate;
        this.modidate = modidate;
    }

    public com.sellerportal.model.IsmsvuPK getComp_id() {
        return this.comp_id;
    }

    public void setComp_id(com.sellerportal.model.IsmsvuPK comp_id) {
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

    public com.sellerportal.model.Ismpvm getIsmpvm() {
        return this.ismpvm;
    }

    public void setIsmpvm(com.sellerportal.model.Ismpvm ismpvm) {
        this.ismpvm = ismpvm;
    }

    public com.sellerportal.model.Ismsmt getIsmsmt() {
        return this.ismsmt;
    }

    public void setIsmsmt(com.sellerportal.model.Ismsmt ismsmt) {
        this.ismsmt = ismsmt;
    }

    public com.sellerportal.model.Ismsmd getIsmsmd() {
        return this.ismsmd;
    }

    public void setIsmsmd(com.sellerportal.model.Ismsmd ismsmd) {
        this.ismsmd = ismsmd;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("comp_id", getComp_id())
            .toString();
    }

    public boolean equals(Object other) {
        if ( (this == other ) ) return true;
        if ( !(other instanceof Ismsvu) ) return false;
        Ismsvu castOther = (Ismsvu) other;
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
