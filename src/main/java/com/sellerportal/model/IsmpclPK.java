package com.sellerportal.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;


@Embeddable
public class IsmpclPK implements Serializable {

	 @Column(name = "PCLMCTRFNUM")
	    private Long pclmctrfnum;

	    @Column(name = "PCLPDTRFNUM")
	    private Long pclpdtrfnum;

    /** full constructor */
    public IsmpclPK(Long pclmctrfnum, Long pclpdtrfnum) {
        this.pclmctrfnum = pclmctrfnum;
        this.pclpdtrfnum = pclpdtrfnum;
    }

    /** default constructor */
    public IsmpclPK() {
    }

    public Long getPclmctrfnum() {
        return this.pclmctrfnum;
    }

    public void setPclmctrfnum(Long pclmctrfnum) {
        this.pclmctrfnum = pclmctrfnum;
    }

    public Long getPclpdtrfnum() {
        return this.pclpdtrfnum;
    }

    public void setPclpdtrfnum(Long pclpdtrfnum) {
        this.pclpdtrfnum = pclpdtrfnum;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("pclmctrfnum", getPclmctrfnum())
            .append("pclpdtrfnum", getPclpdtrfnum())
            .toString();
    }

    public boolean equals(Object other) {
        if ( (this == other ) ) return true;
        if ( !(other instanceof IsmpclPK) ) return false;
        IsmpclPK castOther = (IsmpclPK) other;
        return new EqualsBuilder()
            .append(this.getPclmctrfnum(), castOther.getPclmctrfnum())
            .append(this.getPclpdtrfnum(), castOther.getPclpdtrfnum())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getPclmctrfnum())
            .append(getPclpdtrfnum())
            .toHashCode();
    }

}
