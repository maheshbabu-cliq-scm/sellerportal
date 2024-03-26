package com.sellerportal.model;

import java.io.Serializable;
import java.util.Date;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import javax.persistence.*;

@Entity
@Table(name = "ISMOUR")
public class Ismour implements Serializable {

	@EmbeddedId
    private IsmourPK comp_id;

    @ManyToOne
    @JoinColumn(name = "OURORMRFNUM", insertable = false, updatable = false)
    private Ismorm ismorm;

    @ManyToOne
    @JoinColumn(name = "OUROUTRFNUM", insertable = false, updatable = false)
    private Ismout ismout;

    @Column(name = "CREATEDATE", nullable = false)
    private Date createdate;

    @Column(name = "CREATEDBY", length = 20)
    private Long createdby;

    @Column(name = "DELETED", length = 1)
    private String deleted;

    @Column(name = "MODIDATE", nullable = false)
    private Date modidate;

    @Column(name = "OURISACTIVE", length = 1)
    private String ourisactive;

    /** full constructor */
    public Ismour(com.sellerportal.model.IsmourPK comp_id, Date createdate, Long createdby, String deleted, Date modidate, String ourisactive, com.sellerportal.model.Ismorm ismorm, com.sellerportal.model.Ismout ismout) {
        this.comp_id = comp_id;
        this.createdate = createdate;
        this.createdby = createdby;
        this.deleted = deleted;
        this.modidate = modidate;
        this.ourisactive = ourisactive;
        this.ismorm = ismorm;
        this.ismout = ismout;
    }

    /** default constructor */
    public Ismour() {
    }

    /** minimal constructor */
    public Ismour(com.sellerportal.model.IsmourPK comp_id, Date createdate, Date modidate) {
        this.comp_id = comp_id;
        this.createdate = createdate;
        this.modidate = modidate;
    }

    public com.sellerportal.model.IsmourPK getComp_id() {
        return this.comp_id;
    }

    public void setComp_id(com.sellerportal.model.IsmourPK comp_id) {
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

    public String getOurisactive() {
        return this.ourisactive;
    }

    public void setOurisactive(String ourisactive) {
        this.ourisactive = ourisactive;
    }

    public com.sellerportal.model.Ismorm getIsmorm() {
        return this.ismorm;
    }

    public void setIsmorm(com.sellerportal.model.Ismorm ismorm) {
        this.ismorm = ismorm;
    }

    public com.sellerportal.model.Ismout getIsmout() {
        return this.ismout;
    }

    public void setIsmout(com.sellerportal.model.Ismout ismout) {
        this.ismout = ismout;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("comp_id", getComp_id())
            .toString();
    }

    public boolean equals(Object other) {
        if ( (this == other ) ) return true;
        if ( !(other instanceof Ismour) ) return false;
        Ismour castOther = (Ismour) other;
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
