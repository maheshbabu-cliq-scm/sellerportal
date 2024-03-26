package com.sellerportal.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import org.apache.commons.lang.builder.ToStringBuilder;
import javax.persistence.*;

@Entity
@Table(name = "ISMMCT")
public class Ismmct implements Serializable {

	@Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ISMMCT_MCTRFNUM_SEQ")
    @SequenceGenerator(name = "ISMMCT_MCTRFNUM_SEQ", sequenceName = "ISMMCT_MCTRFNUM_SEQ", allocationSize = 1)
    @Column(name = "MCTRFNUM")
    private Long mctrfnum;

    @Column(name = "CREATEDATE")
    private Date createdate;

    @Column(name = "CREATEDBY", nullable = false)
    private Long createdby;

    @Column(name = "DELETED", nullable = false, length = 1)
    private String deleted;

    @Column(name = "MCTADMINEMAIL", length = 64)
    private String mctadminemail;

    @Column(name = "MCTCCPBIRFNUM", length = 256)
    private String mctccpbirfnum;

    @Column(name = "MCTCHANNELID", length = 64)
    private String mctchannelid;

    @Column(name = "MCTCNDLEADSOURCERFNUM", length = 256)
    private String mctcndleadsourcerfnum;

    @Column(name = "MCTCODE", length = 64)
    private String mctcode;

    @Column(name = "MCTDESC", length = 2048)
    private String mctdesc;

    @Column(name = "MCTENDTDATE")
    private Date mctendtdate;

    @Column(name = "MCTGROUPID", length = 64)
    private String mctgroupid;

    @Column(name = "MCTISACTIVE", length = 1)
    private String mctisactive;

    @Column(name = "MCTISADMIN", length = 1)
    private String mctisadmin;

    @Column(name = "MCTISCCUSE", length = 1)
    private String mctisccuse;

    @Column(name = "MCTISORDERMAIL", length = 1)
    private String mctisordermail;

    @Column(name = "MCTISPUBLISH", length = 1)
    private String mctispublish;

    @Column(name = "MCTISRESTRIC", length = 1)
    private String mctisrestric;

    @Column(name = "MCTISROOT", length = 1)
    private String mctisroot;

    @Column(name = "MCTISSPECIALIZED", length = 1)
    private String mctisspecialized;

    @Column(name = "MCTKEYDESC", length = 2048)
    private String mctkeydesc;

    @Column(name = "MCTNAME", nullable = false, length = 128)
    private String mctname;

    @Column(name = "MCTPAYMODES", length = 256)
    private String mctpaymodes;

    @Column(name = "MCTSHIPPINGFREE", length = 1)
    private String mctshippingfree;

    @Column(name = "MCTSMSDESC", length = 2048)
    private String mctsmsdesc;

    @Column(name = "MCTSOMS", length = 256)
    private String mctsoms;

    @Column(name = "MCTSTARTDATE")
    private Date mctstartdate;

    @Column(name = "MCTTITLE", nullable = false, length = 254)
    private String mcttitle;

    @Column(name = "MODIDATE")
    private Date modidate;

    @ManyToOne(optional = false)
    @JoinColumn(name = "MCTPTMRFNUM")
    private Ismptm ismptm;

    @ManyToOne(optional = false)
    @JoinColumn(name = "MCTCATHEAD")
    private Ismdem ismdemByMctcathead;

    @ManyToOne(optional = false)
    @JoinColumn(name = "MCTSEARCHHEAD")
    private Ismdem ismdemByMctsearchhead;

    @ManyToOne(optional = false)
    @JoinColumn(name = "MCTINDEXBODY")
    private Ismdem ismdemByMctindexbody;

    @ManyToOne(optional = false)
    @JoinColumn(name = "MCTCATBODY")
    private Ismdem ismdemByMctcatbody;

    @ManyToOne(optional = false)
    @JoinColumn(name = "MCTPRODHEAD")
    private Ismdem ismdemByMctprodhead;

    @ManyToOne(optional = false)
    @JoinColumn(name = "MCTSEARCHFOOT")
    private Ismdem ismdemByMctsearchfoot;

    @ManyToOne(optional = false)
    @JoinColumn(name = "MCTINDEXHEAD")
    private Ismdem ismdemByMctindexhead;

    @ManyToOne(optional = false)
    @JoinColumn(name = "MCTINDEXFOOT")
    private Ismdem ismdemByMctindexfoot;

    @ManyToOne(optional = false)
    @JoinColumn(name = "MCTCATFOOT")
    private Ismdem ismdemByMctcatfoot;

    @ManyToOne(optional = false)
    @JoinColumn(name = "MCTSEARCGBODY")
    private Ismdem ismdemByMctsearcgbody;

    @ManyToOne(optional = false)
    @JoinColumn(name = "MCTPRODBODY")
    private Ismdem ismdemByMctprodbody;

    @ManyToOne
    @JoinColumn(name = "MCTPRODFOOT")
    private Ismdem ismdemByMctprodfoot;

    @ManyToOne
    @JoinColumn(name = "MCTPETRFNUM")
    private Ismpet ismpet;

    @ManyToOne
    @JoinColumn(name = "MCTCMTRFNUM")
    private Ismcmt ismcmt;

    @ManyToOne
    @JoinColumn(name = "MCTAFMRFNUM")
    private Ismafm ismafm;

    @OneToMany(mappedBy = "ismmct", fetch = FetchType.LAZY)
    private Set<Ismacc> ismaccs;

    @OneToMany(mappedBy = "ismmct", fetch = FetchType.LAZY)
    private Set<Ismpt> ismpts;

    @OneToMany(mappedBy = "ismmct", fetch = FetchType.LAZY)
    private Set<Ismpcl> ismpcls;

    @OneToMany(mappedBy = "ismmct", fetch = FetchType.LAZY)
    private Set<Ismccr> ismccrs;

    @OneToMany(mappedBy = "ismmct", fetch = FetchType.LAZY)
    private Set<Ismdap> ismdaps;

    @ManyToOne
    @JoinColumn(name = "MCTSCTRFNUM")
    private Ismsct ismsct;

    @Column(name = "MCTOCTAMT", nullable = false, length = 20)
    private String mctoctamt;
    
    @Column(name = "MODIFIEDBY", nullable = false, length = 20)
    private Long modifiedby;

    /** full constructor */
    public Ismmct(Date createdate, Long createdby, String deleted, String mctadminemail, String mctccpbirfnum, String mctchannelid, String mctcndleadsourcerfnum, String mctcode, String mctdesc, Date mctendtdate, String mctgroupid, String mctisactive, String mctisadmin, String mctisccuse, String mctisordermail, String mctispublish, String mctisrestric, String mctisroot, String mctisspecialized, String mctkeydesc, String mctname, String mctpaymodes, String mctshippingfree, String mctsmsdesc, String mctsoms, Date mctstartdate, String mcttitle, Date modidate, com.sellerportal.model.Ismptm ismptm, com.sellerportal.model.Ismdem ismdemByMctcathead, com.sellerportal.model.Ismdem ismdemByMctsearchhead, com.sellerportal.model.Ismdem ismdemByMctindexbody, com.sellerportal.model.Ismdem ismdemByMctcatbody, com.sellerportal.model.Ismdem ismdemByMctprodhead, com.sellerportal.model.Ismdem ismdemByMctsearchfoot, com.sellerportal.model.Ismdem ismdemByMctindexhead, com.sellerportal.model.Ismdem ismdemByMctindexfoot, com.sellerportal.model.Ismdem ismdemByMctcatfoot, com.sellerportal.model.Ismdem ismdemByMctsearcgbody, com.sellerportal.model.Ismdem ismdemByMctprodbody, com.sellerportal.model.Ismdem ismdemByMctprodfoot, com.sellerportal.model.Ismpet ismpet,com.sellerportal.model.Ismcmt ismcmt, com.sellerportal.model.Ismafm ismafm, com.sellerportal.model.Ismsct ismsct, Set ismaccs, Set ismcdas, Set ismpts, Set ismppls, Set octctms, Set ismpcls, Set ismccrs, Set ismdaps, Set ismscls, Set ismmsts, String mctoctamt, Long modifiedby) {
        this.createdate = createdate;
        this.createdby = createdby;
        this.deleted = deleted;
        this.mctadminemail = mctadminemail;
        this.mctccpbirfnum = mctccpbirfnum;
        this.mctchannelid = mctchannelid;
        this.mctcndleadsourcerfnum = mctcndleadsourcerfnum;
        this.mctcode = mctcode;
        this.mctdesc = mctdesc;
        this.mctendtdate = mctendtdate;
        this.mctgroupid = mctgroupid;
        this.mctisactive = mctisactive;
        this.mctisadmin = mctisadmin;
        this.mctisccuse = mctisccuse;
        this.mctisordermail = mctisordermail;
        this.mctispublish = mctispublish;
        this.mctisrestric = mctisrestric;
        this.mctisroot = mctisroot;
        this.mctisspecialized = mctisspecialized;
        this.mctkeydesc = mctkeydesc;
        this.mctname = mctname;
        this.mctpaymodes = mctpaymodes;
        this.mctshippingfree = mctshippingfree;
        this.mctsmsdesc = mctsmsdesc;
        this.mctsoms = mctsoms;
        this.mctstartdate = mctstartdate;
        this.mcttitle = mcttitle;
        this.modidate = modidate;
        this.ismptm = ismptm;
        this.ismdemByMctcathead = ismdemByMctcathead;
        this.ismdemByMctsearchhead = ismdemByMctsearchhead;
        this.ismdemByMctindexbody = ismdemByMctindexbody;
        this.ismdemByMctcatbody = ismdemByMctcatbody;
        this.ismdemByMctprodhead = ismdemByMctprodhead;
        this.ismdemByMctsearchfoot = ismdemByMctsearchfoot;
        this.ismdemByMctindexhead = ismdemByMctindexhead;
        this.ismdemByMctindexfoot = ismdemByMctindexfoot;
        this.ismdemByMctcatfoot = ismdemByMctcatfoot;
        this.ismdemByMctsearcgbody = ismdemByMctsearcgbody;
        this.ismdemByMctprodbody = ismdemByMctprodbody;
        this.ismdemByMctprodfoot = ismdemByMctprodfoot;
        this.ismpet = ismpet;
        this.ismcmt = ismcmt;
        this.ismafm = ismafm;
        this.ismsct = ismsct;
        this.ismaccs = ismaccs;
//        this.ismcdas = ismcdas;
        this.ismpts = ismpts;
//        this.ismppls = ismppls;
//        this.octctms = octctms;
        this.ismpcls = ismpcls;
        this.ismccrs = ismccrs;
        this.ismdaps = ismdaps;
//        this.ismscls = ismscls;
//        this.ismmsts = ismmsts;
        this.mctoctamt=mctoctamt;
        this.modifiedby=modifiedby;
    }

    /** default constructor */
    public Ismmct() {
    }

    /** minimal constructor */
    public Ismmct(Long createdby, String deleted, String mctname, String mcttitle, com.sellerportal.model.Ismptm ismptm, com.sellerportal.model.Ismdem ismdemByMctcathead, com.sellerportal.model.Ismdem ismdemByMctsearchhead, com.sellerportal.model.Ismdem ismdemByMctindexbody, com.sellerportal.model.Ismdem ismdemByMctcatbody, com.sellerportal.model.Ismdem ismdemByMctprodhead, com.sellerportal.model.Ismdem ismdemByMctsearchfoot, com.sellerportal.model.Ismdem ismdemByMctindexhead, com.sellerportal.model.Ismdem ismdemByMctindexfoot, com.sellerportal.model.Ismdem ismdemByMctcatfoot, com.sellerportal.model.Ismdem ismdemByMctsearcgbody, com.sellerportal.model.Ismdem ismdemByMctprodbody, com.sellerportal.model.Ismdem ismdemByMctprodfoot, com.sellerportal.model.Ismpet ismpet,com.sellerportal.model.Ismcmt ismcmt, com.sellerportal.model.Ismafm ismafm, com.sellerportal.model.Ismsct ismsct, Set ismaccs, Set ismcdas, Set ismpts, Set ismppls, Set octctms, Set ismpcls, Set ismccrs, Set ismdaps, Set ismscls, Set ismmsts, String mctoctamt) {
        this.createdby = createdby;
        this.deleted = deleted;
        this.mctname = mctname;
        this.mcttitle = mcttitle;
        this.ismptm = ismptm;
        this.ismdemByMctcathead = ismdemByMctcathead;
        this.ismdemByMctsearchhead = ismdemByMctsearchhead;
        this.ismdemByMctindexbody = ismdemByMctindexbody;
        this.ismdemByMctcatbody = ismdemByMctcatbody;
        this.ismdemByMctprodhead = ismdemByMctprodhead;
        this.ismdemByMctsearchfoot = ismdemByMctsearchfoot;
        this.ismdemByMctindexhead = ismdemByMctindexhead;
        this.ismdemByMctindexfoot = ismdemByMctindexfoot;
        this.ismdemByMctcatfoot = ismdemByMctcatfoot;
        this.ismdemByMctsearcgbody = ismdemByMctsearcgbody;
        this.ismdemByMctprodbody = ismdemByMctprodbody;
        this.ismdemByMctprodfoot = ismdemByMctprodfoot;
        this.ismpet = ismpet;
        this.ismcmt = ismcmt;
        this.ismafm = ismafm;
        this.ismsct = ismsct;
        this.ismaccs = ismaccs;
//        this.ismcdas = ismcdas;
        this.ismpts = ismpts;
//        this.ismppls = ismppls;
//        this.octctms = octctms;
        this.ismpcls = ismpcls;
        this.ismccrs = ismccrs;
        this.ismdaps = ismdaps;
//        this.ismscls = ismscls;
//        this.ismmsts = ismmsts;
        this.mctoctamt=mctoctamt;
    }

    /** 
     * 		       auto_increment
     * 		    
     */
    public Long getMctrfnum() {
        return this.mctrfnum;
    }

    public void setMctrfnum(Long mctrfnum) {
        this.mctrfnum = mctrfnum;
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

    public String getMctadminemail() {
        return this.mctadminemail;
    }

    public void setMctadminemail(String mctadminemail) {
        this.mctadminemail = mctadminemail;
    }

    public String getMctccpbirfnum() {
        return this.mctccpbirfnum;
    }

    public void setMctccpbirfnum(String mctccpbirfnum) {
        this.mctccpbirfnum = mctccpbirfnum;
    }

    public String getMctchannelid() {
        return this.mctchannelid;
    }

    public void setMctchannelid(String mctchannelid) {
        this.mctchannelid = mctchannelid;
    }

    public String getMctcndleadsourcerfnum() {
        return this.mctcndleadsourcerfnum;
    }

    public void setMctcndleadsourcerfnum(String mctcndleadsourcerfnum) {
        this.mctcndleadsourcerfnum = mctcndleadsourcerfnum;
    }

    public String getMctcode() {
        return this.mctcode;
    }

    public void setMctcode(String mctcode) {
        this.mctcode = mctcode;
    }

    public String getMctdesc() {
        return this.mctdesc;
    }

    public void setMctdesc(String mctdesc) {
        this.mctdesc = mctdesc;
    }

    public Date getMctendtdate() {
        return this.mctendtdate;
    }

    public void setMctendtdate(Date mctendtdate) {
        this.mctendtdate = mctendtdate;
    }

    public String getMctgroupid() {
        return this.mctgroupid;
    }

    public void setMctgroupid(String mctgroupid) {
        this.mctgroupid = mctgroupid;
    }

    public String getMctisactive() {
        return this.mctisactive;
    }

    public void setMctisactive(String mctisactive) {
        this.mctisactive = mctisactive;
    }

    public String getMctisadmin() {
        return this.mctisadmin;
    }

    public void setMctisadmin(String mctisadmin) {
        this.mctisadmin = mctisadmin;
    }

    public String getMctisccuse() {
        return this.mctisccuse;
    }

    public void setMctisccuse(String mctisccuse) {
        this.mctisccuse = mctisccuse;
    }

    public String getMctisordermail() {
        return this.mctisordermail;
    }

    public void setMctisordermail(String mctisordermail) {
        this.mctisordermail = mctisordermail;
    }

    public String getMctispublish() {
        return this.mctispublish;
    }

    public void setMctispublish(String mctispublish) {
        this.mctispublish = mctispublish;
    }

    public String getMctisrestric() {
        return this.mctisrestric;
    }

    public void setMctisrestric(String mctisrestric) {
        this.mctisrestric = mctisrestric;
    }

    public String getMctisroot() {
        return this.mctisroot;
    }

    public void setMctisroot(String mctisroot) {
        this.mctisroot = mctisroot;
    }

    public String getMctisspecialized() {
        return this.mctisspecialized;
    }

    public void setMctisspecialized(String mctisspecialized) {
        this.mctisspecialized = mctisspecialized;
    }

    public String getMctkeydesc() {
        return this.mctkeydesc;
    }

    public void setMctkeydesc(String mctkeydesc) {
        this.mctkeydesc = mctkeydesc;
    }

    public String getMctname() {
        return this.mctname;
    }

    public void setMctname(String mctname) {
        this.mctname = mctname;
    }

    public String getMctpaymodes() {
        return this.mctpaymodes;
    }

    public void setMctpaymodes(String mctpaymodes) {
        this.mctpaymodes = mctpaymodes;
    }

    public String getMctshippingfree() {
        return this.mctshippingfree;
    }

    public void setMctshippingfree(String mctshippingfree) {
        this.mctshippingfree = mctshippingfree;
    }

    public String getMctsmsdesc() {
        return this.mctsmsdesc;
    }

    public void setMctsmsdesc(String mctsmsdesc) {
        this.mctsmsdesc = mctsmsdesc;
    }

    public String getMctsoms() {
        return this.mctsoms;
    }

    public void setMctsoms(String mctsoms) {
        this.mctsoms = mctsoms;
    }

    public Date getMctstartdate() {
        return this.mctstartdate;
    }

    public void setMctstartdate(Date mctstartdate) {
        this.mctstartdate = mctstartdate;
    }

    public String getMcttitle() {
        return this.mcttitle;
    }

    public void setMcttitle(String mcttitle) {
        this.mcttitle = mcttitle;
    }

    public Date getModidate() {
        return this.modidate;
    }

    public void setModidate(Date modidate) {
        this.modidate = modidate;
    }

    public com.sellerportal.model.Ismptm getIsmptm() {
        return this.ismptm;
    }

    public void setIsmptm(com.sellerportal.model.Ismptm ismptm) {
        this.ismptm = ismptm;
    }

    public com.sellerportal.model.Ismdem getIsmdemByMctcathead() {
        return this.ismdemByMctcathead;
    }

    public void setIsmdemByMctcathead(com.sellerportal.model.Ismdem ismdemByMctcathead) {
        this.ismdemByMctcathead = ismdemByMctcathead;
    }

    public com.sellerportal.model.Ismdem getIsmdemByMctsearchhead() {
        return this.ismdemByMctsearchhead;
    }

    public void setIsmdemByMctsearchhead(com.sellerportal.model.Ismdem ismdemByMctsearchhead) {
        this.ismdemByMctsearchhead = ismdemByMctsearchhead;
    }

    public com.sellerportal.model.Ismdem getIsmdemByMctindexbody() {
        return this.ismdemByMctindexbody;
    }

    public void setIsmdemByMctindexbody(com.sellerportal.model.Ismdem ismdemByMctindexbody) {
        this.ismdemByMctindexbody = ismdemByMctindexbody;
    }

    public com.sellerportal.model.Ismdem getIsmdemByMctcatbody() {
        return this.ismdemByMctcatbody;
    }

    public void setIsmdemByMctcatbody(com.sellerportal.model.Ismdem ismdemByMctcatbody) {
        this.ismdemByMctcatbody = ismdemByMctcatbody;
    }

    public com.sellerportal.model.Ismdem getIsmdemByMctprodhead() {
        return this.ismdemByMctprodhead;
    }

    public void setIsmdemByMctprodhead(com.sellerportal.model.Ismdem ismdemByMctprodhead) {
        this.ismdemByMctprodhead = ismdemByMctprodhead;
    }

    public com.sellerportal.model.Ismdem getIsmdemByMctsearchfoot() {
        return this.ismdemByMctsearchfoot;
    }

    public void setIsmdemByMctsearchfoot(com.sellerportal.model.Ismdem ismdemByMctsearchfoot) {
        this.ismdemByMctsearchfoot = ismdemByMctsearchfoot;
    }

    public com.sellerportal.model.Ismdem getIsmdemByMctindexhead() {
        return this.ismdemByMctindexhead;
    }

    public void setIsmdemByMctindexhead(com.sellerportal.model.Ismdem ismdemByMctindexhead) {
        this.ismdemByMctindexhead = ismdemByMctindexhead;
    }

    public com.sellerportal.model.Ismdem getIsmdemByMctindexfoot() {
        return this.ismdemByMctindexfoot;
    }

    public void setIsmdemByMctindexfoot(com.sellerportal.model.Ismdem ismdemByMctindexfoot) {
        this.ismdemByMctindexfoot = ismdemByMctindexfoot;
    }

    public com.sellerportal.model.Ismdem getIsmdemByMctcatfoot() {
        return this.ismdemByMctcatfoot;
    }

    public void setIsmdemByMctcatfoot(com.sellerportal.model.Ismdem ismdemByMctcatfoot) {
        this.ismdemByMctcatfoot = ismdemByMctcatfoot;
    }

    public com.sellerportal.model.Ismdem getIsmdemByMctsearcgbody() {
        return this.ismdemByMctsearcgbody;
    }

    public void setIsmdemByMctsearcgbody(com.sellerportal.model.Ismdem ismdemByMctsearcgbody) {
        this.ismdemByMctsearcgbody = ismdemByMctsearcgbody;
    }

    public com.sellerportal.model.Ismdem getIsmdemByMctprodbody() {
        return this.ismdemByMctprodbody;
    }

    public void setIsmdemByMctprodbody(com.sellerportal.model.Ismdem ismdemByMctprodbody) {
        this.ismdemByMctprodbody = ismdemByMctprodbody;
    }

    public com.sellerportal.model.Ismdem getIsmdemByMctprodfoot() {
        return this.ismdemByMctprodfoot;
    }

    public void setIsmdemByMctprodfoot(com.sellerportal.model.Ismdem ismdemByMctprodfoot) {
        this.ismdemByMctprodfoot = ismdemByMctprodfoot;
    }

    public com.sellerportal.model.Ismpet getIsmpet() {
        return this.ismpet;
    }

    public void setIsmpet(com.sellerportal.model.Ismpet ismpet) {
        this.ismpet = ismpet;
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

   

    public com.sellerportal.model.Ismsct getIsmsct() {
        return this.ismsct;
    }

    public void setIsmsct(com.sellerportal.model.Ismsct ismsct) {
        this.ismsct = ismsct;
    }

    public Set getIsmaccs() {
        return this.ismaccs;
    }

    public void setIsmaccs(Set ismaccs) {
        this.ismaccs = ismaccs;
    }

//    public Set getIsmcdas() {
//        return this.ismcdas;
//    }
//
//    public void setIsmcdas(Set ismcdas) {
//        this.ismcdas = ismcdas;
//    }

    public Set getIsmpts() {
        return this.ismpts;
    }

    public void setIsmpts(Set ismpts) {
        this.ismpts = ismpts;
    }

//    public Set getIsmppls() {
//        return this.ismppls;
//    }

//    public void setIsmppls(Set ismppls) {
//        this.ismppls = ismppls;
//    }
//
//    public Set getOctctms() {
//        return this.octctms;
//    }
//
//    public void setOctctms(Set octctms) {
//        this.octctms = octctms;
//    }

    public Set getIsmpcls() {
        return this.ismpcls;
    }

    public void setIsmpcls(Set ismpcls) {
        this.ismpcls = ismpcls;
    }

    public Set getIsmccrs() {
        return this.ismccrs;
    }

    public void setIsmccrs(Set ismccrs) {
        this.ismccrs = ismccrs;
    }

    public Set getIsmdaps() {
        return this.ismdaps;
    }

    public void setIsmdaps(Set ismdaps) {
        this.ismdaps = ismdaps;
    }

//    public Set getIsmscls() {
//        return this.ismscls;
//    }

//    public void setIsmscls(Set ismscls) {
//        this.ismscls = ismscls;
//    }
//
//    public Set getIsmmsts() {
//        return this.ismmsts;
//    }
//
//    public void setIsmmsts(Set ismmsts) {
//        this.ismmsts = ismmsts;
//    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("mctrfnum", getMctrfnum())
            .toString();
    }

	public String getMctoctamt() {
		return mctoctamt;
	}

	public void setMctoctamt(String mctoctamt) {
		this.mctoctamt = mctoctamt;
	}

	public Long getModifiedby() {
		return modifiedby;
	}

	public void setModifiedby(Long modifiedby) {
		this.modifiedby = modifiedby;
	}
	
}
