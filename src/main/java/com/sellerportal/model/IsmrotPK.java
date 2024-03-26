package com.sellerportal.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;


/** @author Hibernate CodeGenerator */
@Embeddable
public class IsmrotPK implements Serializable {

    /** identifier field */
    @Column(name = "ROTORMRFNUM")
    private Long rotormrfnum;

    /** identifier field */
    @Column(name = "ROTOSTRFNUM")
    private Long rotostrfnum;

    /** full constructor */
    public IsmrotPK(Long rotormrfnum, Long rotostrfnum) {
        this.rotormrfnum = rotormrfnum;
        this.rotostrfnum = rotostrfnum;
    }

    /** default constructor */
    public IsmrotPK() {
    }

    public Long getRotormrfnum() {
        return this.rotormrfnum;
    }

    public void setRotormrfnum(Long rotormrfnum) {
        this.rotormrfnum = rotormrfnum;
    }

    public Long getRotostrfnum() {
        return this.rotostrfnum;
    }

    public void setRotostrfnum(Long rotostrfnum) {
        this.rotostrfnum = rotostrfnum;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("rotormrfnum", getRotormrfnum())
            .append("rotostrfnum", getRotostrfnum())
            .toString();
    }

    public boolean equals(Object other) {
        if ( (this == other ) ) return true;
        if ( !(other instanceof IsmrotPK) ) return false;
        IsmrotPK castOther = (IsmrotPK) other;
        return new EqualsBuilder()
            .append(this.getRotormrfnum(), castOther.getRotormrfnum())
            .append(this.getRotostrfnum(), castOther.getRotostrfnum())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getRotormrfnum())
            .append(getRotostrfnum())
            .toHashCode();
    }

}
