package com.sellerportal.model;

import java.io.Serializable;
import java.util.Date;

import org.apache.commons.lang.builder.ToStringBuilder;
import javax.persistence.*;

@Entity
@Table(name = "ISMIRF")
public class Ismirf implements Serializable {

	@Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "IRFRFNUM_SEQ")
    @SequenceGenerator(name = "IRFRFNUM_SEQ", sequenceName = "ISMIRF_IRFRFNUM_SEQ", allocationSize = 1)
    @Column(name = "IRFRFNUM")
    private Long irfrfnum;

    @Column(name = "IRFCREATEDATE", nullable = false)
    private Date irfcreatedate;

    @Column(name = "IRFCREATEDBY", nullable = false, length = 20)
    private Long irfcreatedby;

    @Column(name = "IRFDELETED", nullable = false, length = 1)
    private String irfdeleted;

    @Column(name = "IRFDESC", length = 2048)
    private String irfdesc;

    @Column(name = "IRFISMNAME", length = 128)
    private String irfismname;

    @Column(name = "IRFMODIDATE", nullable = false)
    private Date irfmodidate;

    @Column(name = "IRFNAME", length = 128)
    private String irfname;

    @Column(name = "IRFTESTDATA", length = 1024)
    private String irftestdata;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "IRFIDMRFNUM", nullable = false)
    private Ismidm ismidm;

    /** full constructor */
    public Ismirf(Date irfcreatedate, Long irfcreatedby, String irfdeleted, String irfdesc, String irfismname, Date irfmodidate, String irfname, String irftestdata, com.sellerportal.model.Ismidm ismidm) {
        this.irfcreatedate = irfcreatedate;
        this.irfcreatedby = irfcreatedby;
        this.irfdeleted = irfdeleted;
        this.irfdesc = irfdesc;
        this.irfismname = irfismname;
        this.irfmodidate = irfmodidate;
        this.irfname = irfname;
        this.irftestdata = irftestdata;
        this.ismidm = ismidm;
    }

    /** default constructor */
    public Ismirf() {
    }

    /** minimal constructor */
    public Ismirf(Date irfcreatedate, Long irfcreatedby, String irfdeleted, Date irfmodidate, com.sellerportal.model.Ismidm ismidm) {
        this.irfcreatedate = irfcreatedate;
        this.irfcreatedby = irfcreatedby;
        this.irfdeleted = irfdeleted;
        this.irfmodidate = irfmodidate;
        this.ismidm = ismidm;
    }

    /** 
     * 		       auto_increment
     * 		    
     */
    public Long getIrfrfnum() {
        return this.irfrfnum;
    }

    public void setIrfrfnum(Long irfrfnum) {
        this.irfrfnum = irfrfnum;
    }

    public Date getIrfcreatedate() {
        return this.irfcreatedate;
    }

    public void setIrfcreatedate(Date irfcreatedate) {
        this.irfcreatedate = irfcreatedate;
    }

    public Long getIrfcreatedby() {
        return this.irfcreatedby;
    }

    public void setIrfcreatedby(Long irfcreatedby) {
        this.irfcreatedby = irfcreatedby;
    }

    public String getIrfdeleted() {
        return this.irfdeleted;
    }

    public void setIrfdeleted(String irfdeleted) {
        this.irfdeleted = irfdeleted;
    }

    public String getIrfdesc() {
        return this.irfdesc;
    }

    public void setIrfdesc(String irfdesc) {
        this.irfdesc = irfdesc;
    }

    public String getIrfismname() {
        return this.irfismname;
    }

    public void setIrfismname(String irfismname) {
        this.irfismname = irfismname;
    }

    public Date getIrfmodidate() {
        return this.irfmodidate;
    }

    public void setIrfmodidate(Date irfmodidate) {
        this.irfmodidate = irfmodidate;
    }

    public String getIrfname() {
        return this.irfname;
    }

    public void setIrfname(String irfname) {
        this.irfname = irfname;
    }

    public String getIrftestdata() {
        return this.irftestdata;
    }

    public void setIrftestdata(String irftestdata) {
        this.irftestdata = irftestdata;
    }

    public com.sellerportal.model.Ismidm getIsmidm() {
        return this.ismidm;
    }

    public void setIsmidm(com.sellerportal.model.Ismidm ismidm) {
        this.ismidm = ismidm;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("irfrfnum", getIrfrfnum())
            .toString();
    }

}
