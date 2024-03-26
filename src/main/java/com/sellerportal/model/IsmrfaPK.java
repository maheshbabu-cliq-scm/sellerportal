package com.sellerportal.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;


/** @author Hibernate CodeGenerator */
@Embeddable
public class IsmrfaPK implements Serializable {

    /** identifier field */
    @Column(name = "RFARDTRFNUM")
    private Long rfardtrfnum;

    /** identifier field */
    @Column(name = "RFARFTRFNUM")
    private Long rfarftrfnum;

    /** full constructor */
    public IsmrfaPK(Long rfardtrfnum, Long rfarftrfnum) {
        this.rfardtrfnum = rfardtrfnum;
        this.rfarftrfnum = rfarftrfnum;
    }

    /** default constructor */
    public IsmrfaPK() {
    }

    public Long getRfardtrfnum() {
        return this.rfardtrfnum;
    }

    public void setRfardtrfnum(Long rfardtrfnum) {
        this.rfardtrfnum = rfardtrfnum;
    }

    public Long getRfarftrfnum() {
        return this.rfarftrfnum;
    }

    public void setRfarftrfnum(Long rfarftrfnum) {
        this.rfarftrfnum = rfarftrfnum;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("rfardtrfnum", getRfardtrfnum())
            .append("rfarftrfnum", getRfarftrfnum())
            .toString();
    }

    public boolean equals(Object other) {
        if ( (this == other ) ) return true;
        if ( !(other instanceof IsmrfaPK) ) return false;
        IsmrfaPK castOther = (IsmrfaPK) other;
        return new EqualsBuilder()
            .append(this.getRfardtrfnum(), castOther.getRfardtrfnum())
            .append(this.getRfarftrfnum(), castOther.getRfarftrfnum())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getRfardtrfnum())
            .append(getRfarftrfnum())
            .toHashCode();
    }

}
