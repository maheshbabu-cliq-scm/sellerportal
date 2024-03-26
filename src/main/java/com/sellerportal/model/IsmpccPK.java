package com.sellerportal.model;

import java.io.Serializable;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import javax.persistence.Column;
import javax.persistence.Embeddable;


@Embeddable
public class IsmpccPK implements Serializable {

	 @Column(name = "PCCCCRRFNUM")
	    private Long pccccrrfnum;

	    @Column(name = "PCCPBIRFNUM")
	    private Long pccpbirfnum;
    /** full constructor */
    public IsmpccPK(Long pccccrrfnum, Long pccpbirfnum) {
        this.pccccrrfnum = pccccrrfnum;
        this.pccpbirfnum = pccpbirfnum;
    }

    /** default constructor */
    public IsmpccPK() {
    }

    public Long getPccccrrfnum() {
        return this.pccccrrfnum;
    }

    public void setPccccrrfnum(Long pccccrrfnum) {
        this.pccccrrfnum = pccccrrfnum;
    }

    public Long getPccpbirfnum() {
        return this.pccpbirfnum;
    }

    public void setPccpbirfnum(Long pccpbirfnum) {
        this.pccpbirfnum = pccpbirfnum;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("pccccrrfnum", getPccccrrfnum())
            .append("pccpbirfnum", getPccpbirfnum())
            .toString();
    }

    public boolean equals(Object other) {
        if ( (this == other ) ) return true;
        if ( !(other instanceof IsmpccPK) ) return false;
        IsmpccPK castOther = (IsmpccPK) other;
        return new EqualsBuilder()
            .append(this.getPccccrrfnum(), castOther.getPccccrrfnum())
            .append(this.getPccpbirfnum(), castOther.getPccpbirfnum())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getPccccrrfnum())
            .append(getPccpbirfnum())
            .toHashCode();
    }

}
