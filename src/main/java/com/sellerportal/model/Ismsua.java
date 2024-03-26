package com.sellerportal.model;

import java.io.Serializable;
import java.util.Date;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import javax.persistence.*;

@Entity
@Table(name = "ISMSUA")
public class Ismsua implements Serializable {

	@EmbeddedId
    private com.sellerportal.dao.IsmsuaPK comp_id;

	@Column(name = "CREATEDATE", nullable = false)
    private Date createdate;

    @Column(name = "CREATEDBY", nullable = false)
    private Long createdby;

    @Column(name = "DELETED", nullable = false, length = 1)
    private String deleted;

    @Column(name = "MODIDATE", nullable = false)
    private Date modidate;

    @ManyToOne
    @JoinColumn(name = "SUAUBIRFNUM", insertable = false, updatable = false)
    private com.sellerportal.model.Ismubi ismubi;

    /** full constructor */
    public Ismsua(com.sellerportal.dao.IsmsuaPK comp_id, Date createdate, Long createdby, String deleted, Date modidate,com.sellerportal.model.Ismubi ismubi) {
        this.comp_id = comp_id;
        this.createdate = createdate;
        this.createdby = createdby;
        this.deleted = deleted;
        this.modidate = modidate;
        this.ismubi = ismubi;
    }

    /** default constructor */
    public Ismsua() {
    }

    /** minimal constructor */
    public Ismsua(com.sellerportal.dao.IsmsuaPK comp_id, Date createdate, Long createdby, String deleted, Date modidate) {
        this.comp_id = comp_id;
        this.createdate = createdate;
        this.createdby = createdby;
        this.deleted = deleted;
        this.modidate = modidate;
    }

    public com.sellerportal.dao.IsmsuaPK getComp_id() {
        return this.comp_id;
    }

    public void setComp_id(com.sellerportal.dao.IsmsuaPK comp_id) {
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

    public com.sellerportal.model.Ismubi getIsmubi() {
        return this.ismubi;
    }

    public void setIsmubi(com.sellerportal.model.Ismubi ismubi) {
        this.ismubi = ismubi;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("comp_id", getComp_id())
            .toString();
    }

    public boolean equals(Object other) {
        if ( (this == other ) ) return true;
        if ( !(other instanceof Ismsua) ) return false;
        Ismsua castOther = (Ismsua) other;
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
