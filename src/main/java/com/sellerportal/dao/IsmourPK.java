package com.sellerportal.dao;

import java.io.Serializable;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;


/** @author Hibernate CodeGenerator */
public class IsmourPK implements Serializable {

    /** identifier field */
    private Long ourormrfnum;

    /** identifier field */
    private Long ouroutrfnum;

    /** full constructor */
    public IsmourPK(Long ourormrfnum, Long ouroutrfnum) {
        this.ourormrfnum = ourormrfnum;
        this.ouroutrfnum = ouroutrfnum;
    }

    /** default constructor */
    public IsmourPK() {
    }

    public Long getOurormrfnum() {
        return this.ourormrfnum;
    }

    public void setOurormrfnum(Long ourormrfnum) {
        this.ourormrfnum = ourormrfnum;
    }

    public Long getOuroutrfnum() {
        return this.ouroutrfnum;
    }

    public void setOuroutrfnum(Long ouroutrfnum) {
        this.ouroutrfnum = ouroutrfnum;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("ourormrfnum", getOurormrfnum())
            .append("ouroutrfnum", getOuroutrfnum())
            .toString();
    }

    public boolean equals(Object other) {
        if ( (this == other ) ) return true;
        if ( !(other instanceof IsmourPK) ) return false;
        IsmourPK castOther = (IsmourPK) other;
        return new EqualsBuilder()
            .append(this.getOurormrfnum(), castOther.getOurormrfnum())
            .append(this.getOuroutrfnum(), castOther.getOuroutrfnum())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getOurormrfnum())
            .append(getOuroutrfnum())
            .toHashCode();
    }

}
