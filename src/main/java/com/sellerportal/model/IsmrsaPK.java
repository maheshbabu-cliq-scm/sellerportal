package com.sellerportal.model;

import java.io.Serializable;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import javax.persistence.*;

@Embeddable
public class IsmrsaPK implements Serializable {

	@Column(name = "RSAORMRFNUM")
    private Long rsaormrfnum;

    @Column(name = "RSASMTRFNUM")
    private Long rsasmtrfnum;

    /** full constructor */
    public IsmrsaPK(Long rsaormrfnum, Long rsasmtrfnum) {
        this.rsaormrfnum = rsaormrfnum;
        this.rsasmtrfnum = rsasmtrfnum;
    }

    /** default constructor */
    public IsmrsaPK() {
    }

    public Long getRsaormrfnum() {
        return this.rsaormrfnum;
    }

    public void setRsaormrfnum(Long rsaormrfnum) {
        this.rsaormrfnum = rsaormrfnum;
    }

    public Long getRsasmtrfnum() {
        return this.rsasmtrfnum;
    }

    public void setRsasmtrfnum(Long rsasmtrfnum) {
        this.rsasmtrfnum = rsasmtrfnum;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("rsaormrfnum", getRsaormrfnum())
            .append("rsasmtrfnum", getRsasmtrfnum())
            .toString();
    }

    public boolean equals(Object other) {
        if ( (this == other ) ) return true;
        if ( !(other instanceof IsmrsaPK) ) return false;
        IsmrsaPK castOther = (IsmrsaPK) other;
        return new EqualsBuilder()
            .append(this.getRsaormrfnum(), castOther.getRsaormrfnum())
            .append(this.getRsasmtrfnum(), castOther.getRsasmtrfnum())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getRsaormrfnum())
            .append(getRsasmtrfnum())
            .toHashCode();
    }

}
