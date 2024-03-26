package com.sellerportal.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import org.apache.commons.lang.builder.ToStringBuilder;
import javax.persistence.*;

@Entity
@Table(name = "ISMOUT")
public class Ismout implements Serializable {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "OUTRFNUM")
    private Long outrfnum;

    @Column(name = "CREATEDATE", nullable = false)
    private Date createdate;

    @Column(name = "CREATEDBY", length = 20)
    private Long createdby;

    @Column(name = "DELETED", length = 1)
    private String deleted;

    @Column(name = "MODIDATE", nullable = false)
    private Date modidate;

    @Column(name = "OUTEMAIL", length = 64)
    private String outemail;

    @Column(name = "OUTFNAME", nullable = false, length = 128)
    private String outfname;

    @Column(name = "OUTISACTIVE", nullable = false, length = 1)
    private String outisactive;

    @Column(name = "OUTISSELLER", length = 1)
    private String outisseller;

    @Column(name = "OUTLNAME", nullable = false, length = 128)
    private String outlname;

    @Column(name = "OUTLOGIN", nullable = false, length = 128)
    private String outlogin;

    @Column(name = "OUTMCTRFNUM", length = 128)
    private String outmctrfnum;

    @Column(name = "OUTMNAME", length = 128)
    private String outmname;

    @Column(name = "OUTMOBILE", length = 16)
    private String outmobile;

    @Column(name = "OUTPASS", nullable = false, length = 128)
    private String outpass;

    @Column(name = "OUTPHEADNAME", length = 128)
    private String outpheadname;

    @ManyToOne
    @JoinColumn(name = "OUTCOURFNUM", nullable = false)
    private Ismcou ismcou;

    @OneToMany(mappedBy = "ismout")
    @Transient
    private Set<Ismour> ismours;

    @ManyToOne
    @JoinColumn(name = "OUTAFMRFNUM", nullable = false)
    private Ismafm ismafm;

    /** full constructor */
    public Ismout(Date createdate, Long createdby, String deleted, Date modidate, String outemail, String outfname, String outisactive, String outisseller, String outlname, String outlogin, String outmctrfnum, String outmname, String outmobile, String outpass, String outpheadname,com.sellerportal.model.Ismcou ismcou, com.sellerportal.model.Ismafm ismafm, Set<Ismour> ismours) {
        this.createdate = createdate;
        this.createdby = createdby;
        this.deleted = deleted;
        this.modidate = modidate;
        this.outemail = outemail;
        this.outfname = outfname;
        this.outisactive = outisactive;
        this.outisseller = outisseller;
        this.outlname = outlname;
        this.outlogin = outlogin;
        this.outmctrfnum = outmctrfnum;
        this.outmname = outmname;
        this.outmobile = outmobile;
        this.outpass = outpass;
        this.outpheadname = outpheadname;
        this.ismcou = ismcou;
        this.ismafm = ismafm;
        this.ismours = ismours;
    }

    /** default constructor */
    public Ismout() {
    }

    /** minimal constructor */
    public Ismout(Date createdate, Date modidate, String outfname, String outisactive, String outlname, String outlogin, String outpass,com.sellerportal.model.Ismcou ismcou, com.sellerportal.model.Ismafm ismafm, Set<Ismour> ismours) {
        this.createdate = createdate;
        this.modidate = modidate;
        this.outfname = outfname;
        this.outisactive = outisactive;
        this.outlname = outlname;
        this.outlogin = outlogin;
        this.outpass = outpass;
        this.ismcou = ismcou;
        this.ismafm = ismafm;
        this.ismours = ismours;
    }

    /** 
     * 		       auto_increment
     * 		    
     */
    public Long getOutrfnum() {
        return this.outrfnum;
    }

    public void setOutrfnum(Long outrfnum) {
        this.outrfnum = outrfnum;
    }

    public Date getCreatedate() {
        return this.createdate;
    }

    public void setCreatedate(Date createdate) {
        this.createdate = createdate;
    }

    public Long getCreatedby() {
        return this.createdby;
    }

    public void setCreatedby(Long createdby) {
        this.createdby = createdby;
    }

    public String getDeleted() {
        return this.deleted;
    }

    public void setDeleted(String deleted) {
        this.deleted = deleted;
    }

    public Date getModidate() {
        return this.modidate;
    }

    public void setModidate(Date modidate) {
        this.modidate = modidate;
    }

    public String getOutemail() {
        return this.outemail;
    }

    public void setOutemail(String outemail) {
        this.outemail = outemail;
    }

    public String getOutfname() {
        return this.outfname;
    }

    public void setOutfname(String outfname) {
        this.outfname = outfname;
    }

    public String getOutisactive() {
        return this.outisactive;
    }

    public void setOutisactive(String outisactive) {
        this.outisactive = outisactive;
    }

    public String getOutisseller() {
        return this.outisseller;
    }

    public void setOutisseller(String outisseller) {
        this.outisseller = outisseller;
    }

    public String getOutlname() {
        return this.outlname;
    }

    public void setOutlname(String outlname) {
        this.outlname = outlname;
    }

    public String getOutlogin() {
        return this.outlogin;
    }

    public void setOutlogin(String outlogin) {
        this.outlogin = outlogin;
    }

    public String getOutmctrfnum() {
        return this.outmctrfnum;
    }

    public void setOutmctrfnum(String outmctrfnum) {
        this.outmctrfnum = outmctrfnum;
    }

    public String getOutmname() {
        return this.outmname;
    }

    public void setOutmname(String outmname) {
        this.outmname = outmname;
    }

    public String getOutmobile() {
        return this.outmobile;
    }

    public void setOutmobile(String outmobile) {
        this.outmobile = outmobile;
    }

    public String getOutpass() {
        return this.outpass;
    }

    public void setOutpass(String outpass) {
        this.outpass = outpass;
    }

    public String getOutpheadname() {
        return this.outpheadname;
    }

    public void setOutpheadname(String outpheadname) {
        this.outpheadname = outpheadname;
    }

    public com.sellerportal.model.Ismcou getIsmcou() {
        return this.ismcou;
    }

    public void setIsmcou(com.sellerportal.model.Ismcou ismcou) {
        this.ismcou = ismcou;
    }

    public com.sellerportal.model.Ismafm getIsmafm() {
        return this.ismafm;
    }

    public void setIsmafm(com.sellerportal.model.Ismafm ismafm) {
        this.ismafm = ismafm;
    }

    public Set<Ismour> getIsmours() {
        return this.ismours;
    }

    public void setIsmours(Set<Ismour> ismours) {
        this.ismours = ismours;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("outrfnum", getOutrfnum())
            .toString();
    }

}
