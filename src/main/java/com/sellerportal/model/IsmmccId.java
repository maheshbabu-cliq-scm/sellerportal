package com.sellerportal.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

@Embeddable
public class IsmmccId implements Serializable {

    @Column(name = "MCCCARDPINNO")
    private String mcccardpinno;

    @Column(name = "MCCCARDTYPE")
    private String mcccardtype;

    @Column(name = "MCCDENOMINATION")
    private BigDecimal mccdenomination;

    @Column(name = "MCCEXPDATE")
    private Date mccexpdate;

    @Column(name = "MCCRFNUM")
    private Integer mccrfnum;

    @Column(name = "MCCSTATUS")
    private Integer mccstatus;

	/**
	 * @param mcccardpinno
	 * @param mcccardtype
	 * @param mccdenomination
	 * @param mccexpdate
	 * @param mccrfnum
	 * @param mccstatus
	 */
	public IsmmccId(String mcccardpinno, String mcccardtype, BigDecimal mccdenomination, Date mccexpdate,
			Integer mccrfnum, Integer mccstatus) {
	
		this.mcccardpinno = mcccardpinno;
		this.mcccardtype = mcccardtype;
		this.mccdenomination = mccdenomination;
		this.mccexpdate = mccexpdate;
		this.mccrfnum = mccrfnum;
		this.mccstatus = mccstatus;
	}
	
	public IsmmccId() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @return the mcccardpinno
	 */
	public String getMcccardpinno() {
		return mcccardpinno;
	}

	/**
	 * @param mcccardpinno the mcccardpinno to set
	 */
	public void setMcccardpinno(String mcccardpinno) {
		this.mcccardpinno = mcccardpinno;
	}

	/**
	 * @return the mcccardtype
	 */
	public String getMcccardtype() {
		return mcccardtype;
	}

	/**
	 * @param mcccardtype the mcccardtype to set
	 */
	public void setMcccardtype(String mcccardtype) {
		this.mcccardtype = mcccardtype;
	}

	/**
	 * @return the mccdenomination
	 */
	public BigDecimal getMccdenomination() {
		return mccdenomination;
	}

	/**
	 * @param mccdenomination the mccdenomination to set
	 */
	public void setMccdenomination(BigDecimal mccdenomination) {
		this.mccdenomination = mccdenomination;
	}

	/**
	 * @return the mccexpdate
	 */
	public Date getMccexpdate() {
		return mccexpdate;
	}

	/**
	 * @param mccexpdate the mccexpdate to set
	 */
	public void setMccexpdate(Date mccexpdate) {
		this.mccexpdate = mccexpdate;
	}

	/**
	 * @return the mccrfnum
	 */
	public Integer getMccrfnum() {
		return mccrfnum;
	}

	/**
	 * @param mccrfnum the mccrfnum to set
	 */
	public void setMccrfnum(Integer mccrfnum) {
		this.mccrfnum = mccrfnum;
	}

	/**
	 * @return the mccstatus
	 */
	public Integer getMccstatus() {
		return mccstatus;
	}

	/**
	 * @param mccstatus the mccstatus to set
	 */
	public void setMccstatus(Integer mccstatus) {
		this.mccstatus = mccstatus;
	}
	
	public boolean equals(Object obj) {
        if (obj == this) return true;
        if (!(obj instanceof IsmmccId)) return false;
        IsmmccId other = (IsmmccId) obj;
        return new EqualsBuilder()
                .append(this.getMcccardpinno(), other.getMcccardpinno())
                .append(this.getMcccardtype(), other.getMcccardtype())
                .append(this.getMccdenomination(), other.getMccdenomination())
                .append(this.getMccexpdate(), other.getMccexpdate())
                .append(this.getMccrfnum(), other.getMccrfnum())
                .append(this.getMccstatus(), other.getMccstatus())
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder()
                .append(getMcccardpinno())
                .append(getMcccardtype())
                .append(getMccdenomination())
                .append(getMccexpdate())
                .append(getMccrfnum())
                .append(getMccstatus())
                .toHashCode();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("mcccardpinno", getMcccardpinno())
                .append("mcccardtype", getMcccardtype())
                .append("mccdenomination", getMccdenomination())
                .append("mccexpdate", getMccexpdate())
                .append("mccrfnum", getMccrfnum())
                .append("mccstatus", getMccstatus())
                .toString();
    }
}
