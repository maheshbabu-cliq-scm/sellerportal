package com.sellerportal.dao;

import java.io.Serializable;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;


/** @author Hibernate CodeGenerator */
public class IsmsuaPK implements Serializable {

    /** identifier field */
    private Long suassirfnum;

    /** identifier field */
    private Long suaubirfnum;

    /** full constructor */
    public IsmsuaPK(Long suassirfnum, Long suaubirfnum) {
        this.suassirfnum = suassirfnum;
        this.suaubirfnum = suaubirfnum;
    }

    /** default constructor */
    public IsmsuaPK() {
    }

    public Long getSuassirfnum() {
        return this.suassirfnum;
    }

    public void setSuassirfnum(Long suassirfnum) {
        this.suassirfnum = suassirfnum;
    }

    public Long getSuaubirfnum() {
        return this.suaubirfnum;
    }

    public void setSuaubirfnum(Long suaubirfnum) {
        this.suaubirfnum = suaubirfnum;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("suassirfnum", getSuassirfnum())
            .append("suaubirfnum", getSuaubirfnum())
            .toString();
    }

    public boolean equals(Object other) {
        if ( (this == other ) ) return true;
        if ( !(other instanceof IsmsuaPK) ) return false;
        IsmsuaPK castOther = (IsmsuaPK) other;
        return new EqualsBuilder()
            .append(this.getSuassirfnum(), castOther.getSuassirfnum())
            .append(this.getSuaubirfnum(), castOther.getSuaubirfnum())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getSuassirfnum())
            .append(getSuaubirfnum())
            .toHashCode();
    }

}
