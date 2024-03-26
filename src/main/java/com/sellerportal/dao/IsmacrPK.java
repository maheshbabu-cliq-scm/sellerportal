package com.sellerportal.dao;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;


/** @author Hibernate CodeGenerator */
@Embeddable
public class IsmacrPK implements Serializable {

    /** identifier field */
	@Column(name = "ACRACMRFNUM")
    private Long acracmrfnum;

    /** identifier field */
	@Column(name = "ACRARMRFNUM")
    private Long acrarmrfnum;

    /** full constructor */
    public IsmacrPK(Long acracmrfnum, Long acrarmrfnum) {
        this.acracmrfnum = acracmrfnum;
        this.acrarmrfnum = acrarmrfnum;
    }

    /** default constructor */
    public IsmacrPK() {
    }

    public Long getAcracmrfnum() {
        return this.acracmrfnum;
    }

    public void setAcracmrfnum(Long acracmrfnum) {
        this.acracmrfnum = acracmrfnum;
    }

    public Long getAcrarmrfnum() {
        return this.acrarmrfnum;
    }

    public void setAcrarmrfnum(Long acrarmrfnum) {
        this.acrarmrfnum = acrarmrfnum;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("acracmrfnum", getAcracmrfnum())
            .append("acrarmrfnum", getAcrarmrfnum())
            .toString();
    }

    public boolean equals(Object other) {
        if ( (this == other ) ) return true;
        if ( !(other instanceof IsmacrPK) ) return false;
        IsmacrPK castOther = (IsmacrPK) other;
        return new EqualsBuilder()
            .append(this.getAcracmrfnum(), castOther.getAcracmrfnum())
            .append(this.getAcrarmrfnum(), castOther.getAcrarmrfnum())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getAcracmrfnum())
            .append(getAcrarmrfnum())
            .toHashCode();
    }

}
