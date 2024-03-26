package com.sellerportal.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import javax.persistence.*;

@Entity
@Table(name = "ISMMCC")
public class Ismmcc implements Serializable {

	@EmbeddedId
    private IsmmccId id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "MCCPOTRFNUM", insertable = false, updatable = false)
    private Ismpot ismpot;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "MCCCNDCITY",  insertable = false, updatable = false)
    private Ismcnd ismcnd;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "MCCPSTRFNUM",  insertable = false, updatable = false)
    private Ismpst ismpst;

    /**
	 * @param id
	 * @param ismpot
	 * @param ismcnd
	 * @param ismpst
	 */
	public Ismmcc(IsmmccId id, Ismpot ismpot, Ismcnd ismcnd, Ismpst ismpst) {
		this.id = id;
		this.ismpot = ismpot;
		this.ismcnd = ismcnd;
		this.ismpst = ismpst;
	}

	

    /** default constructor */
    public Ismmcc() {
    }

    

    /**
	 * @return the id
	 */
	public IsmmccId getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(IsmmccId id) {
		this.id = id;
	}

	public  com.sellerportal.model.Ismpot getIsmpot() {
        return this.ismpot;
    }

    public void setIsmpot( com.sellerportal.model.Ismpot ismpot) {
        this.ismpot = ismpot;
    }

    public  com.sellerportal.model.Ismcnd getIsmcnd() {
        return this.ismcnd;
    }

    public void setIsmcnd( com.sellerportal.model.Ismcnd ismcnd) {
        this.ismcnd = ismcnd;
    }

    public  com.sellerportal.model.Ismpst getIsmpst() {
        return this.ismpst;
    }

    public void setIsmpst( com.sellerportal.model.Ismpst ismpst) {
        this.ismpst = ismpst;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("id", getId())
            .toString();
    }

    public boolean equals(Object other) {
        if ( (this == other ) ) return true;
        if ( !(other instanceof Ismmcc) ) return false;
        Ismmcc castOther = (Ismmcc) other;
        return new EqualsBuilder()
            .append(this.getId(), castOther.getId())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getId())
            .toHashCode();
    }

}


