package com.sellerportal.model;

import java.io.Serializable;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;


/** @author Hibernate CodeGenerator */
public class IsmccmPK implements Serializable {

    /** identifier field */
    private Long ccmfromcurr;

    /** identifier field */
    private Long ccmtocurr;

    /** full constructor */
    public IsmccmPK(Long ccmfromcurr, Long ccmtocurr) {
        this.ccmfromcurr = ccmfromcurr;
        this.ccmtocurr = ccmtocurr;
    }

    /** default constructor */
    public IsmccmPK() {
    }

    public Long getCcmfromcurr() {
        return this.ccmfromcurr;
    }

    public void setCcmfromcurr(Long ccmfromcurr) {
        this.ccmfromcurr = ccmfromcurr;
    }

    public Long getCcmtocurr() {
        return this.ccmtocurr;
    }

    public void setCcmtocurr(Long ccmtocurr) {
        this.ccmtocurr = ccmtocurr;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("ccmfromcurr", getCcmfromcurr())
            .append("ccmtocurr", getCcmtocurr())
            .toString();
    }

    public boolean equals(Object other) {
        if ( (this == other ) ) return true;
        if ( !(other instanceof IsmccmPK) ) return false;
        IsmccmPK castOther = (IsmccmPK) other;
        return new EqualsBuilder()
            .append(this.getCcmfromcurr(), castOther.getCcmfromcurr())
            .append(this.getCcmtocurr(), castOther.getCcmtocurr())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getCcmfromcurr())
            .append(getCcmtocurr())
            .toHashCode();
    }

}
