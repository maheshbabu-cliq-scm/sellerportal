package com.sellerportal.dao;

import java.io.Serializable;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;


/** @author Hibernate CodeGenerator */
public class IsmaurPK implements Serializable {

    /** identifier field */
    private Long aurarmrfnum;

    /** identifier field */
    private Long aurubirfnum;

    /** full constructor */
    public IsmaurPK(Long aurarmrfnum, Long aurubirfnum) {
        this.aurarmrfnum = aurarmrfnum;
        this.aurubirfnum = aurubirfnum;
    }

    /** default constructor */
    public IsmaurPK() {
    }

    public Long getAurarmrfnum() {
        return this.aurarmrfnum;
    }

    public void setAurarmrfnum(Long aurarmrfnum) {
        this.aurarmrfnum = aurarmrfnum;
    }

    public Long getAurubirfnum() {
        return this.aurubirfnum;
    }

    public void setAurubirfnum(Long aurubirfnum) {
        this.aurubirfnum = aurubirfnum;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("aurarmrfnum", getAurarmrfnum())
            .append("aurubirfnum", getAurubirfnum())
            .toString();
    }

    public boolean equals(Object other) {
        if ( (this == other ) ) return true;
        if ( !(other instanceof IsmaurPK) ) return false;
        IsmaurPK castOther = (IsmaurPK) other;
        return new EqualsBuilder()
            .append(this.getAurarmrfnum(), castOther.getAurarmrfnum())
            .append(this.getAurubirfnum(), castOther.getAurubirfnum())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getAurarmrfnum())
            .append(getAurubirfnum())
            .toHashCode();
    }

}
