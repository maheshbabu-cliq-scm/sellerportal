package com.sellerportal.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;


/** @author Hibernate CodeGenerator */
@Embeddable
public class IsmrstPK implements Serializable {

    /** identifier field */
    @Column(name = "RSTORMRFNUM")
    private Long rstormrfnum;

    /** identifier field */
    @Column(name = "RSTSSTRFNUM")
    private Long rstsstrfnum;

    /** full constructor */
    public IsmrstPK(Long rstormrfnum, Long rstsstrfnum) {
        this.rstormrfnum = rstormrfnum;
        this.rstsstrfnum = rstsstrfnum;
    }

    /** default constructor */
    public IsmrstPK() {
    }

    public Long getRstormrfnum() {
        return this.rstormrfnum;
    }

    public void setRstormrfnum(Long rstormrfnum) {
        this.rstormrfnum = rstormrfnum;
    }

    public Long getRstsstrfnum() {
        return this.rstsstrfnum;
    }

    public void setRstsstrfnum(Long rstsstrfnum) {
        this.rstsstrfnum = rstsstrfnum;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("rstormrfnum", getRstormrfnum())
            .append("rstsstrfnum", getRstsstrfnum())
            .toString();
    }

    public boolean equals(Object other) {
        if ( (this == other ) ) return true;
        if ( !(other instanceof IsmrstPK) ) return false;
        IsmrstPK castOther = (IsmrstPK) other;
        return new EqualsBuilder()
            .append(this.getRstormrfnum(), castOther.getRstormrfnum())
            .append(this.getRstsstrfnum(), castOther.getRstsstrfnum())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getRstormrfnum())
            .append(getRstsstrfnum())
            .toHashCode();
    }

}
