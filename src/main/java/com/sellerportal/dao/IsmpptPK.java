package com.sellerportal.dao;

import java.io.Serializable;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;


/** @author Hibernate CodeGenerator */
public class IsmpptPK implements Serializable {

    /** identifier field */
    private Long pptcmtrfnum;

    /** identifier field */
    private Long pptpbirfnum;

    /** full constructor */
    public IsmpptPK(Long pptcmtrfnum, Long pptpbirfnum) {
        this.pptcmtrfnum = pptcmtrfnum;
        this.pptpbirfnum = pptpbirfnum;
    }

    /** default constructor */
    public IsmpptPK() {
    }

    public Long getPptcmtrfnum() {
        return this.pptcmtrfnum;
    }

    public void setPptcmtrfnum(Long pptcmtrfnum) {
        this.pptcmtrfnum = pptcmtrfnum;
    }

    public Long getPptpbirfnum() {
        return this.pptpbirfnum;
    }

    public void setPptpbirfnum(Long pptpbirfnum) {
        this.pptpbirfnum = pptpbirfnum;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("pptcmtrfnum", getPptcmtrfnum())
            .append("pptpbirfnum", getPptpbirfnum())
            .toString();
    }

    public boolean equals(Object other) {
        if ( (this == other ) ) return true;
        if ( !(other instanceof IsmpptPK) ) return false;
        IsmpptPK castOther = (IsmpptPK) other;
        return new EqualsBuilder()
            .append(this.getPptcmtrfnum(), castOther.getPptcmtrfnum())
            .append(this.getPptpbirfnum(), castOther.getPptpbirfnum())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getPptcmtrfnum())
            .append(getPptpbirfnum())
            .toHashCode();
    }

}
