package com.sellerportal.model;

import java.io.Serializable;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;


import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class IsmsvuPK implements Serializable {

	@Column(name = "SVUISORDER", length = 1)
    private String svuisorder;

    @Column(name = "SVUPVMRFNUM", length = 20)
    private Long svupvmrfnum;

    @Column(name = "SVUSMDRFNUM", length = 20)
    private Long svusmdrfnum;

    @Column(name = "SVUSMTRFNUM", length = 20)
    private Long svusmtrfnum;

    /** full constructor */
    public IsmsvuPK(String svuisorder, Long svupvmrfnum, Long svusmdrfnum, Long svusmtrfnum) {
        this.svuisorder = svuisorder;
        this.svupvmrfnum = svupvmrfnum;
        this.svusmdrfnum = svusmdrfnum;
        this.svusmtrfnum = svusmtrfnum;
    }

    /** default constructor */
    public IsmsvuPK() {
    }

    public String getSvuisorder() {
        return this.svuisorder;
    }

    public void setSvuisorder(String svuisorder) {
        this.svuisorder = svuisorder;
    }

    public Long getSvupvmrfnum() {
        return this.svupvmrfnum;
    }

    public void setSvupvmrfnum(Long svupvmrfnum) {
        this.svupvmrfnum = svupvmrfnum;
    }

    public Long getSvusmdrfnum() {
        return this.svusmdrfnum;
    }

    public void setSvusmdrfnum(Long svusmdrfnum) {
        this.svusmdrfnum = svusmdrfnum;
    }

    public Long getSvusmtrfnum() {
        return this.svusmtrfnum;
    }

    public void setSvusmtrfnum(Long svusmtrfnum) {
        this.svusmtrfnum = svusmtrfnum;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("svuisorder", getSvuisorder())
            .append("svupvmrfnum", getSvupvmrfnum())
            .append("svusmdrfnum", getSvusmdrfnum())
            .append("svusmtrfnum", getSvusmtrfnum())
            .toString();
    }

    public boolean equals(Object other) {
        if ( (this == other ) ) return true;
        if ( !(other instanceof IsmsvuPK) ) return false;
        IsmsvuPK castOther = (IsmsvuPK) other;
        return new EqualsBuilder()
            .append(this.getSvuisorder(), castOther.getSvuisorder())
            .append(this.getSvupvmrfnum(), castOther.getSvupvmrfnum())
            .append(this.getSvusmdrfnum(), castOther.getSvusmdrfnum())
            .append(this.getSvusmtrfnum(), castOther.getSvusmtrfnum())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getSvuisorder())
            .append(getSvupvmrfnum())
            .append(getSvusmdrfnum())
            .append(getSvusmtrfnum())
            .toHashCode();
    }

}
