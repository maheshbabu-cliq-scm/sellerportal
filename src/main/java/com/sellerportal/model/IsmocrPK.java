package com.sellerportal.model;

import java.io.Serializable;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;


import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class IsmocrPK implements Serializable {

	 @Column(name = "OCROCMRFNUM")
	    private Long ocrocmrfnum;

	    @Column(name = "OCRORMRFNUM")
	    private Long ocrormrfnum;;

    /** full constructor */
    public IsmocrPK(Long ocrocmrfnum, Long ocrormrfnum) {
        this.ocrocmrfnum = ocrocmrfnum;
        this.ocrormrfnum = ocrormrfnum;
    }

    /** default constructor */
    public IsmocrPK() {
    }

    public Long getOcrocmrfnum() {
        return this.ocrocmrfnum;
    }

    public void setOcrocmrfnum(Long ocrocmrfnum) {
        this.ocrocmrfnum = ocrocmrfnum;
    }

    public Long getOcrormrfnum() {
        return this.ocrormrfnum;
    }

    public void setOcrormrfnum(Long ocrormrfnum) {
        this.ocrormrfnum = ocrormrfnum;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("ocrocmrfnum", getOcrocmrfnum())
            .append("ocrormrfnum", getOcrormrfnum())
            .toString();
    }

    public boolean equals(Object other) {
        if ( (this == other ) ) return true;
        if ( !(other instanceof IsmocrPK) ) return false;
        IsmocrPK castOther = (IsmocrPK) other;
        return new EqualsBuilder()
            .append(this.getOcrocmrfnum(), castOther.getOcrocmrfnum())
            .append(this.getOcrormrfnum(), castOther.getOcrormrfnum())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getOcrocmrfnum())
            .append(getOcrormrfnum())
            .toHashCode();
    }

}
