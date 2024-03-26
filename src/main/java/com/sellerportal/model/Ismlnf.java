package com.sellerportal.model;

import java.io.Serializable;
import java.util.Date;

import org.apache.commons.lang.builder.ToStringBuilder;
import javax.persistence.*;

@Entity
@Table(name = "ISMLNF")
public class Ismlnf implements Serializable {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "LNFRFNUM")
    private Long lnfrfnum;

    @Column(name = "LNFCREATEDATE", nullable = false)
    private Date lnfcreatedate;

    @Column(name = "LNFCREATEDBY", nullable = false, length = 20)
    private Long lnfcreatedby;

    @Column(name = "LNFDELETED", nullable = false, length = 1)
    private String lnfdeleted;

    @Column(name = "LNFMODIDATE", nullable = false)
    private Date lnfmodidate;

    @Column(name = "LNFSTYLEFILE", nullable = false, length = 256)
    private String lnfstylefile;

    @Column(name = "LNFSTYLENAME", nullable = false, length = 128)
    private String lnfstylename;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "LNFCNDOPT", nullable = false)
    private Ismcnd ismcndByLnfcndopt;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "LNFCNDENT", nullable = false)
    private Ismcnd ismcndByLnfcndent;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "LNFCNDDEL", nullable = false)
    private Ismcnd ismcndByLnfcnddel;

    /** full constructor */
    public Ismlnf(Date lnfcreatedate, Long lnfcreatedby, String lnfdeleted, Date lnfmodidate, String lnfstylefile, String lnfstylename, com.sellerportal.model.Ismcnd ismcndByLnfcndopt, com.sellerportal.model.Ismcnd ismcndByLnfcndent, com.sellerportal.model.Ismcnd ismcndByLnfcnddel) {
        this.lnfcreatedate = lnfcreatedate;
        this.lnfcreatedby = lnfcreatedby;
        this.lnfdeleted = lnfdeleted;
        this.lnfmodidate = lnfmodidate;
        this.lnfstylefile = lnfstylefile;
        this.lnfstylename = lnfstylename;
        this.ismcndByLnfcndopt = ismcndByLnfcndopt;
        this.ismcndByLnfcndent = ismcndByLnfcndent;
        this.ismcndByLnfcnddel = ismcndByLnfcnddel;
    }

    /** default constructor */
    public Ismlnf() {
    }

    /** 
     * 		       auto_increment
     * 		    
     */
    public Long getLnfrfnum() {
        return this.lnfrfnum;
    }

    public void setLnfrfnum(Long lnfrfnum) {
        this.lnfrfnum = lnfrfnum;
    }

    public Date getLnfcreatedate() {
        return this.lnfcreatedate;
    }

    public void setLnfcreatedate(Date lnfcreatedate) {
        this.lnfcreatedate = lnfcreatedate;
    }

    public Long getLnfcreatedby() {
        return this.lnfcreatedby;
    }

    public void setLnfcreatedby(Long lnfcreatedby) {
        this.lnfcreatedby = lnfcreatedby;
    }

    public String getLnfdeleted() {
        return this.lnfdeleted;
    }

    public void setLnfdeleted(String lnfdeleted) {
        this.lnfdeleted = lnfdeleted;
    }

    public Date getLnfmodidate() {
        return this.lnfmodidate;
    }

    public void setLnfmodidate(Date lnfmodidate) {
        this.lnfmodidate = lnfmodidate;
    }

    public String getLnfstylefile() {
        return this.lnfstylefile;
    }

    public void setLnfstylefile(String lnfstylefile) {
        this.lnfstylefile = lnfstylefile;
    }

    public String getLnfstylename() {
        return this.lnfstylename;
    }

    public void setLnfstylename(String lnfstylename) {
        this.lnfstylename = lnfstylename;
    }

    public com.sellerportal.model.Ismcnd getIsmcndByLnfcndopt() {
        return this.ismcndByLnfcndopt;
    }

    public void setIsmcndByLnfcndopt(com.sellerportal.model.Ismcnd ismcndByLnfcndopt) {
        this.ismcndByLnfcndopt = ismcndByLnfcndopt;
    }

    public com.sellerportal.model.Ismcnd getIsmcndByLnfcndent() {
        return this.ismcndByLnfcndent;
    }

    public void setIsmcndByLnfcndent(com.sellerportal.model.Ismcnd ismcndByLnfcndent) {
        this.ismcndByLnfcndent = ismcndByLnfcndent;
    }

    public com.sellerportal.model.Ismcnd getIsmcndByLnfcnddel() {
        return this.ismcndByLnfcnddel;
    }

    public void setIsmcndByLnfcnddel(com.sellerportal.model.Ismcnd ismcndByLnfcnddel) {
        this.ismcndByLnfcnddel = ismcndByLnfcnddel;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("lnfrfnum", getLnfrfnum())
            .toString();
    }

}
