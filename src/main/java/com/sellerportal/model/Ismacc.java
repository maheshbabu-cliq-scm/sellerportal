package com.sellerportal.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import org.apache.commons.lang.builder.ToStringBuilder;
import javax.persistence.*;

@Entity
@Table(name = "ISMACC")
public class Ismacc implements Serializable {

	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    @Column(name = "ACCRFNUM")
	    private Long accrfnum;

	    @Column(name = "ACCCOMM", nullable = false, length = 12)
	    private BigDecimal acccomm;

	    @Column(name = "ACCCREATEDATE", nullable = false)
	    private Date acccreatedate;

	    @Column(name = "ACCCREATEDBY", nullable = false, length = 20)
	    private Long acccreatedby;

	    @Column(name = "ACCDELETED", nullable = false, length = 1)
	    private String accdeleted;

	    @Column(name = "ACCMODIDATE", nullable = false)
	    private Date accmodidate;

	    @ManyToOne(fetch = FetchType.LAZY)
	    @JoinColumn(name = "ACCMCTRFNUM", nullable = false)
	    private Ismcmt ismcmt;

	    @ManyToOne(fetch = FetchType.LAZY)
	    @JoinColumn(name = "ACCAFMRFNUM", nullable = false)
	    private Ismafm ismafm;

	    @ManyToOne(fetch = FetchType.LAZY)
	    @JoinColumn(name = "ACCCMTRFNUM", nullable = false)
	    private Ismmct ismmct;

    /** full constructor */
    public Ismacc(BigDecimal acccomm, Date acccreatedate, Long acccreatedby, String accdeleted, Date accmodidate, com.sellerportal.model.Ismcmt ismcmt, com.sellerportal.model.Ismafm ismafm, com.sellerportal.model.Ismmct ismmct) {
        this.acccomm = acccomm;
        this.acccreatedate = acccreatedate;
        this.acccreatedby = acccreatedby;
        this.accdeleted = accdeleted;
        this.accmodidate = accmodidate;
        this.ismcmt = ismcmt;
        this.ismafm = ismafm;
        this.ismmct = ismmct;
    }

    /** default constructor */
    public Ismacc() {
    }

    /** 
     * 		       auto_increment
     * 		    
     */
    public Long getAccrfnum() {
        return this.accrfnum;
    }

    public void setAccrfnum(Long accrfnum) {
        this.accrfnum = accrfnum;
    }

    public BigDecimal getAcccomm() {
        return this.acccomm;
    }

    public void setAcccomm(BigDecimal acccomm) {
        this.acccomm = acccomm;
    }

    public Date getAcccreatedate() {
        return this.acccreatedate;
    }

    public void setAcccreatedate(Date acccreatedate) {
        this.acccreatedate = acccreatedate;
    }

    public Long getAcccreatedby() {
        return this.acccreatedby;
    }

    public void setAcccreatedby(Long acccreatedby) {
        this.acccreatedby = acccreatedby;
    }

    public String getAccdeleted() {
        return this.accdeleted;
    }

    public void setAccdeleted(String accdeleted) {
        this.accdeleted = accdeleted;
    }

    public Date getAccmodidate() {
        return this.accmodidate;
    }

    public void setAccmodidate(Date accmodidate) {
        this.accmodidate = accmodidate;
    }

    public com.sellerportal.model.Ismcmt getIsmcmt() {
        return this.ismcmt;
    }

    public void setIsmcmt(com.sellerportal.model.Ismcmt ismcmt) {
        this.ismcmt = ismcmt;
    }

    public com.sellerportal.model.Ismafm getIsmafm() {
        return this.ismafm;
    }

    public void setIsmafm(com.sellerportal.model.Ismafm ismafm) {
        this.ismafm = ismafm;
    }

    public com.sellerportal.model.Ismmct getIsmmct() {
        return this.ismmct;
    }

    public void setIsmmct(com.sellerportal.model.Ismmct ismmct) {
        this.ismmct = ismmct;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("accrfnum", getAccrfnum())
            .toString();
    }

}
