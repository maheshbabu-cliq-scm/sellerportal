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
@Table(name = "ISMRFA")
public class Ismrfa implements Serializable {

    /** identifier field */
    @EmbeddedId
    private IsmrfaPK comp_id;

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
    @Column(name = "RFAISINPUT")
    private String rfaisinput;

    /** nullable persistent field */
    @ManyToOne
    @JoinColumn(name = "RFARFTRFNUM",insertable = false, updatable = false)
    private Ismrft ismrft;

    /** nullable persistent field */
    @ManyToOne
    @JoinColumn(name = "RFARDTRFNUM",insertable = false, updatable = false)
    private Ismrdt ismrdt;

    /** full constructor */
    public Ismrfa(IsmrfaPK comp_id, Date createdate, Long createdby, String deleted, Date modidate, String rfaisinput, Ismrft ismrft, Ismrdt ismrdt) {
        this.comp_id = comp_id;
        this.createdate = createdate;
        this.createdby = createdby;
        this.deleted = deleted;
        this.modidate = modidate;
        this.rfaisinput = rfaisinput;
        this.ismrft = ismrft;
        this.ismrdt = ismrdt;
    }

    /** default constructor */
    public Ismrfa() {
    }

    /** minimal constructor */
    public Ismrfa(IsmrfaPK comp_id, Date createdate, Long createdby, String deleted, Date modidate, String rfaisinput) {
        this.comp_id = comp_id;
        this.createdate = createdate;
        this.createdby = createdby;
        this.deleted = deleted;
        this.modidate = modidate;
        this.rfaisinput = rfaisinput;
    }

    public IsmrfaPK getComp_id() {
        return this.comp_id;
    }

    public void setComp_id(IsmrfaPK comp_id) {
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

    public String getRfaisinput() {
        return this.rfaisinput;
    }

    public void setRfaisinput(String rfaisinput) {
        this.rfaisinput = rfaisinput;
    }

    public Ismrft getIsmrft() {
        return this.ismrft;
    }

    public void setIsmrft(Ismrft ismrft) {
        this.ismrft = ismrft;
    }

    public Ismrdt getIsmrdt() {
        return this.ismrdt;
    }

    public void setIsmrdt(Ismrdt ismrdt) {
        this.ismrdt = ismrdt;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("comp_id", getComp_id())
            .toString();
    }

    public boolean equals(Object other) {
        if ( (this == other ) ) return true;
        if ( !(other instanceof Ismrfa) ) return false;
        Ismrfa castOther = (Ismrfa) other;
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
