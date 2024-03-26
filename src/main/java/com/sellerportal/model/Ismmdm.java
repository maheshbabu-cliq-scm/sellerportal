package com.sellerportal.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import org.apache.commons.lang3.builder.ToStringBuilder;


import javax.persistence.*;

@Entity
@Table(name = "ISMMDM")
public class Ismmdm implements Serializable {

	 @Id
	    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ISMMDM_MDMRFNUM_SEQ")
	    @SequenceGenerator(name = "ISMMDM_MDMRFNUM_SEQ", sequenceName = "ISMMDM_MDMRFNUM_SEQ", allocationSize = 1)
	    @Column(name = "MDMRFNUM")
	    private Long mdmrfnum;

	    @Column(name = "BCC", length = 512)
	    private String bcc;

	    @Column(name = "CC", length = 512)
	    private String cc;

	    @Column(name = "CONTENT", length = 10000)
	    private String content;

	    @Column(name = "CREATEDATE", nullable = false)
	    private Date createdate;

	    @Column(name = "CREATEDBY", nullable = false, length = 20)
	    private Long createdby;

	    @Column(name = "DELETED", nullable = false, length = 1)
	    private String deleted;

	    @Column(name = "EMAILFROM", length = 128)
	    private String emailfrom;

	    @Column(name = "EMAILTO", length = 512)
	    private String emailto;

	    @Column(name = "FLDSTR1", length = 512)
	    private String fldstr1;

	    @Column(name = "FLDSTR2", length = 512)
	    private String fldstr2;

	    @Column(name = "FLDSTR3", length = 512)
	    private String fldstr3;

	    @Column(name = "FLDTSTAMP1", nullable = false)
	    private Date fldtstamp1;

	    @Column(name = "LOG", nullable = false, length = 1)
	    private String log;

	    @Column(name = "MODIDATE", nullable = false)
	    private Date modidate;

	    @Column(name = "NAME", nullable = false, length = 128)
	    private String name;

	    @Column(name = "SUBJECT", length = 512)
	    private String subject;

	    @Column(name = "ACTIVE", length = 1)
	    private String active;

	    @ManyToOne(fetch = FetchType.LAZY)
	    @JoinColumn(name = "TOQDMRFNUM", nullable = false)
	    private Ismqdm ismqdmByToqdmrfnum;

	    @ManyToOne(fetch = FetchType.LAZY)
	    @JoinColumn(name = "CCQDMRFNUM", nullable = false)
	    private Ismqdm ismqdmByCcqdmrfnum;

	    @ManyToOne(fetch = FetchType.LAZY)
	    @JoinColumn(name = "BCCQDMRFNUM", nullable = false)
	    private Ismqdm ismqdmByBccqdmrfnum;

	    @ManyToOne(fetch = FetchType.LAZY)
	    @JoinColumn(name = "TDMRFNUM", nullable = false)
	    private Ismtdm ismtdm;

	    @OneToMany(mappedBy = "ismmdm", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	    private Set<Ismbpm> ismbpms;

	    @OneToMany(mappedBy = "ismmdmBySemccmdmrfnum", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	    private Set<Ismsem> ismsemsBySemccmdmrfnum;

	    @OneToMany(mappedBy = "ismmdmBySemmdmrfnum", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	    private Set<Ismsem> ismsemsBySemmdmrfnum;

	    @OneToMany(mappedBy = "ismmdm", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	    private Set<Ismose> ismoses;

	    @OneToMany(mappedBy = "ismmdmBySsemdmrfnum", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	    private Set<Ismsse> ismssesBySsemdmrfnum;

	    @OneToMany(mappedBy = "ismmdmBySsemdmrfnumafm", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	    private Set<Ismsse> ismssesBySsemdmrfnumafm;

	    @OneToMany(mappedBy = "ismmdm", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	    private Set<Ismmsc> ismmscs;

	    @OneToMany(mappedBy = "ismmdmByOemmdmrfnum", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	    private Set<Ismoem> ismoemsByOemmdmrfnum;

	    @OneToMany(mappedBy = "ismmdmByOemccmdmrfnum", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	    private Set<Ismoem> ismoemsByOemccmdmrfnum;

	    @OneToMany(mappedBy = "ismmdmByPmtsmsmdmrfnum", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	    private Set<Ismpmt> ismpmtsByPmtsmsmdmrfnum;

	    @OneToMany(mappedBy = "ismmdmByPmtmdmrfnum", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	    private Set<Ismpmt> ismpmtsByPmtmdmrfnum;

    /** full constructor */
    public Ismmdm(String bcc, String cc, String content, Date createdate, Long createdby, String deleted, String emailfrom, String emailto, String fldstr1, String fldstr2, String fldstr3, Date fldtstamp1, String log, Date modidate, String name, String subject,String active, com.sellerportal.model.Ismqdm ismqdmByToqdmrfnum, com.sellerportal.model.Ismqdm ismqdmByCcqdmrfnum, com.sellerportal.model.Ismqdm ismqdmByBccqdmrfnum, com.sellerportal.model.Ismtdm ismtdm, Set ismapts, Set ismbpms, Set ismsemsBySemccmdmrfnum, Set ismsemsBySemmdmrfnum, Set ismfbts, Set ismoses, Set ismssesBySsemdmrfnum, Set ismssesBySsemdmrfnumafm, Set ismmscs, Set ismoemsByOemmdmrfnum, Set ismoemsByOemccmdmrfnum, Set ismpmtsByPmtsmsmdmrfnum, Set ismpmtsByPmtmdmrfnum) {
        this.bcc = bcc;
        this.cc = cc;
        this.content = content;
        this.createdate = createdate;
        this.createdby = createdby;
        this.deleted = deleted;
        this.emailfrom = emailfrom;
        this.emailto = emailto;
        this.fldstr1 = fldstr1;
        this.fldstr2 = fldstr2;
        this.fldstr3 = fldstr3;
        this.fldtstamp1 = fldtstamp1;
        this.log = log;
        this.modidate = modidate;
        this.name = name;
        this.subject = subject;
        this.active = active;
        this.ismqdmByToqdmrfnum = ismqdmByToqdmrfnum;
        this.ismqdmByCcqdmrfnum = ismqdmByCcqdmrfnum;
        this.ismqdmByBccqdmrfnum = ismqdmByBccqdmrfnum;
        this.ismtdm = ismtdm;
//        this.ismapts = ismapts;
        this.ismbpms = ismbpms;
        this.ismsemsBySemccmdmrfnum = ismsemsBySemccmdmrfnum;
        this.ismsemsBySemmdmrfnum = ismsemsBySemmdmrfnum;
//        this.ismfbts = ismfbts;
        this.ismoses = ismoses;
        this.ismssesBySsemdmrfnum = ismssesBySsemdmrfnum;
        this.ismssesBySsemdmrfnumafm = ismssesBySsemdmrfnumafm;
        this.ismmscs = ismmscs;
        this.ismoemsByOemmdmrfnum = ismoemsByOemmdmrfnum;
        this.ismoemsByOemccmdmrfnum = ismoemsByOemccmdmrfnum;
        this.ismpmtsByPmtsmsmdmrfnum = ismpmtsByPmtsmsmdmrfnum;
        this.ismpmtsByPmtmdmrfnum = ismpmtsByPmtmdmrfnum;
    }

    /** default constructor */
    public Ismmdm() {
    }

    /** minimal constructor */
    public Ismmdm(Date createdate, Long createdby, String deleted, Date fldtstamp1, String log, Date modidate, String name,String active, com.sellerportal.model.Ismqdm ismqdmByToqdmrfnum, com.sellerportal.model.Ismqdm ismqdmByCcqdmrfnum, com.sellerportal.model.Ismqdm ismqdmByBccqdmrfnum, com.sellerportal.model.Ismtdm ismtdm, Set ismapts, Set ismbpms, Set ismsemsBySemccmdmrfnum, Set ismsemsBySemmdmrfnum, Set ismfbts, Set ismoses, Set ismssesBySsemdmrfnum, Set ismssesBySsemdmrfnumafm, Set ismmscs, Set ismoemsByOemmdmrfnum, Set ismoemsByOemccmdmrfnum, Set ismpmtsByPmtsmsmdmrfnum, Set ismpmtsByPmtmdmrfnum) {
        this.createdate = createdate;
        this.createdby = createdby;
        this.deleted = deleted;
        this.fldtstamp1 = fldtstamp1;
        this.log = log;
        this.modidate = modidate;
        this.name = name;
        this.active = active;
        this.ismqdmByToqdmrfnum = ismqdmByToqdmrfnum;
        this.ismqdmByCcqdmrfnum = ismqdmByCcqdmrfnum;
        this.ismqdmByBccqdmrfnum = ismqdmByBccqdmrfnum;
        this.ismtdm = ismtdm;
//        this.ismapts = ismapts;
        this.ismbpms = ismbpms;
        this.ismsemsBySemccmdmrfnum = ismsemsBySemccmdmrfnum;
        this.ismsemsBySemmdmrfnum = ismsemsBySemmdmrfnum;
//        this.ismfbts = ismfbts;
        this.ismoses = ismoses;
        this.ismssesBySsemdmrfnum = ismssesBySsemdmrfnum;
        this.ismssesBySsemdmrfnumafm = ismssesBySsemdmrfnumafm;
        this.ismmscs = ismmscs;
        this.ismoemsByOemmdmrfnum = ismoemsByOemmdmrfnum;
        this.ismoemsByOemccmdmrfnum = ismoemsByOemccmdmrfnum;
        this.ismpmtsByPmtsmsmdmrfnum = ismpmtsByPmtsmsmdmrfnum;
        this.ismpmtsByPmtmdmrfnum = ismpmtsByPmtmdmrfnum;
    }

    /**
     *                auto_increment
     *            
     */
    public Long getMdmrfnum() {
        return this.mdmrfnum;
    }

    public void setMdmrfnum(Long mdmrfnum) {
        this.mdmrfnum = mdmrfnum;
    }

    public String getBcc() {
        return this.bcc;
    }

    public void setBcc(String bcc) {
        this.bcc = bcc;
    }

    public String getCc() {
        return this.cc;
    }

    public void setCc(String cc) {
        this.cc = cc;
    }

    public String getContent() {
        return this.content;
    }

    public void setContent(String content) {
        this.content = content;
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

    public String getEmailfrom() {
        return this.emailfrom;
    }

    public void setEmailfrom(String emailfrom) {
        this.emailfrom = emailfrom;
    }

    public String getEmailto() {
        return this.emailto;
    }

    public void setEmailto(String emailto) {
        this.emailto = emailto;
    }

    public String getFldstr1() {
        return this.fldstr1;
    }

    public void setFldstr1(String fldstr1) {
        this.fldstr1 = fldstr1;
    }

    public String getFldstr2() {
        return this.fldstr2;
    }

    public void setFldstr2(String fldstr2) {
        this.fldstr2 = fldstr2;
    }

    public String getFldstr3() {
        return this.fldstr3;
    }

    public void setFldstr3(String fldstr3) {
        this.fldstr3 = fldstr3;
    }

    public Date getFldtstamp1() {
        return this.fldtstamp1;
    }

    public void setFldtstamp1(Date fldtstamp1) {
        this.fldtstamp1 = fldtstamp1;
    }

    public String getLog() {
        return this.log;
    }

    public void setLog(String log) {
        this.log = log;
    }

    public Date getModidate() {
        return this.modidate;
    }

    public void setModidate(Date modidate) {
        this.modidate = modidate;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSubject() {
        return this.subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }
    public String getActive() {
        return this.active;
    }

    public void setActive(String active) {
        this.active = active;
    }

   

    public com.sellerportal.model.Ismqdm getIsmqdmByToqdmrfnum() {
        return this.ismqdmByToqdmrfnum;
    }

    public void setIsmqdmByToqdmrfnum(com.sellerportal.model.Ismqdm ismqdmByToqdmrfnum) {
        this.ismqdmByToqdmrfnum = ismqdmByToqdmrfnum;
    }

    public com.sellerportal.model.Ismqdm getIsmqdmByCcqdmrfnum() {
        return this.ismqdmByCcqdmrfnum;
    }

    public void setIsmqdmByCcqdmrfnum(com.sellerportal.model.Ismqdm ismqdmByCcqdmrfnum) {
        this.ismqdmByCcqdmrfnum = ismqdmByCcqdmrfnum;
    }

    public com.sellerportal.model.Ismqdm getIsmqdmByBccqdmrfnum() {
        return this.ismqdmByBccqdmrfnum;
    }

    public void setIsmqdmByBccqdmrfnum(com.sellerportal.model.Ismqdm ismqdmByBccqdmrfnum) {
        this.ismqdmByBccqdmrfnum = ismqdmByBccqdmrfnum;
    }

    public com.sellerportal.model.Ismtdm getIsmtdm() {
        return this.ismtdm;
    }

    public void setIsmtdm(com.sellerportal.model.Ismtdm ismtdm) {
        this.ismtdm = ismtdm;
    }

//    public Set getIsmapts() {
//        return this.ismapts;
//    }
//
//    public void setIsmapts(Set ismapts) {
//        this.ismapts = ismapts;
//    }

    public Set getIsmbpms() {
        return this.ismbpms;
    }

    public void setIsmbpms(Set ismbpms) {
        this.ismbpms = ismbpms;
    }

    public Set getIsmsemsBySemccmdmrfnum() {
        return this.ismsemsBySemccmdmrfnum;
    }

    public void setIsmsemsBySemccmdmrfnum(Set ismsemsBySemccmdmrfnum) {
        this.ismsemsBySemccmdmrfnum = ismsemsBySemccmdmrfnum;
    }

    public Set getIsmsemsBySemmdmrfnum() {
        return this.ismsemsBySemmdmrfnum;
    }

    public void setIsmsemsBySemmdmrfnum(Set ismsemsBySemmdmrfnum) {
        this.ismsemsBySemmdmrfnum = ismsemsBySemmdmrfnum;
    }

//    public Set getIsmfbts() {
//        return this.ismfbts;
//    }
//
//    public void setIsmfbts(Set ismfbts) {
//        this.ismfbts = ismfbts;
//    }

    public Set getIsmoses() {
        return this.ismoses;
    }

    public void setIsmoses(Set ismoses) {
        this.ismoses = ismoses;
    }

    public Set getIsmssesBySsemdmrfnum() {
        return this.ismssesBySsemdmrfnum;
    }

    public void setIsmssesBySsemdmrfnum(Set ismssesBySsemdmrfnum) {
        this.ismssesBySsemdmrfnum = ismssesBySsemdmrfnum;
    }

    public Set getIsmssesBySsemdmrfnumafm() {
        return this.ismssesBySsemdmrfnumafm;
    }

    public void setIsmssesBySsemdmrfnumafm(Set ismssesBySsemdmrfnumafm) {
        this.ismssesBySsemdmrfnumafm = ismssesBySsemdmrfnumafm;
    }

    public Set getIsmmscs() {
        return this.ismmscs;
    }

    public void setIsmmscs(Set ismmscs) {
        this.ismmscs = ismmscs;
    }

    public Set getIsmoemsByOemmdmrfnum() {
        return this.ismoemsByOemmdmrfnum;
    }

    public void setIsmoemsByOemmdmrfnum(Set ismoemsByOemmdmrfnum) {
        this.ismoemsByOemmdmrfnum = ismoemsByOemmdmrfnum;
    }

    public Set getIsmoemsByOemccmdmrfnum() {
        return this.ismoemsByOemccmdmrfnum;
    }

    public void setIsmoemsByOemccmdmrfnum(Set ismoemsByOemccmdmrfnum) {
        this.ismoemsByOemccmdmrfnum = ismoemsByOemccmdmrfnum;
    }

    public Set getIsmpmtsByPmtsmsmdmrfnum() {
        return this.ismpmtsByPmtsmsmdmrfnum;
    }

    public void setIsmpmtsByPmtsmsmdmrfnum(Set ismpmtsByPmtsmsmdmrfnum) {
        this.ismpmtsByPmtsmsmdmrfnum = ismpmtsByPmtsmsmdmrfnum;
    }

    public Set getIsmpmtsByPmtmdmrfnum() {
        return this.ismpmtsByPmtmdmrfnum;
    }

    public void setIsmpmtsByPmtmdmrfnum(Set ismpmtsByPmtmdmrfnum) {
        this.ismpmtsByPmtmdmrfnum = ismpmtsByPmtmdmrfnum;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("mdmrfnum", getMdmrfnum())
            .toString();
    }

}

