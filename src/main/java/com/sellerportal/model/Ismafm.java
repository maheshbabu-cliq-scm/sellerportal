package com.sellerportal.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import org.apache.commons.lang3.builder.ToStringBuilder;
import javax.persistence.*;

@Entity
@Table(name = "ISMAFM")
public class Ismafm implements Serializable {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "AFMRFNUM")
    private Long afmrfnum;

    @Column(name = "AFMALLPRODUCT", length = 1)
    private String afmallproduct;

    @Column(name = "AFMBANNER", length = 1024)
    private String afmbanner;

    @Column(name = "AFMCREATEDATE", nullable = false)
    private Date afmcreatedate;

    @Column(name = "AFMCREATEDBY", nullable = false)
    private Long afmcreatedby;

    @Column(name = "AFMDATRFNUM")
    private Long afmdatrfnum;

    @Column(name = "AFMDELETED", length = 1, nullable = false)
    private String afmdeleted;

    @Column(name = "AFMDESC", length = 256)
    private String afmdesc;

    @Column(name = "AFMFOOTERTEMPLATE", length = 256)
    private String afmfootertemplate;

    @Column(name = "AFMISPRICE", length = 1, nullable = false)
    private String afmisprice;

    @Column(name = "AFMLOGINTEMPLATE", length = 128)
    private String afmlogintemplate;

    @Column(name = "AFMLOGO", length = 256)
    private String afmlogo;

    @Column(name = "AFMMODIFYDATE", nullable = false)
    private Date afmmodifydate;

    @Column(name = "AFMMYACCTEMPLATE", length = 128)
    private String afmmyacctemplate;

    @Column(name = "AFMNAME", length = 128)
    private String afmname;

    @Column(name = "AFMPROFILEREGTEMPLATE", length = 128)
    private String afmprofileregtemplate;

    @Column(name = "AFMREGTEMPLATE", length = 128)
    private String afmregtemplate;

    @Column(name = "AFMROOTSITE", length = 64)
    private String afmrootsite;

    @Column(name = "AFMURL", length = 128)
    private String afmurl;
    
    private String afmothercatl;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "AFMCNDBUSINESSID", nullable = false)
    private Ismcnd ismcndByAfmcndbusinessid;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "AFMCNDCHANNELID", nullable = false)
    private Ismcnd ismcndByAfmcndchannelid;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "AFMPETRFNUM", nullable = false)
    private Ismpet ismpet;
    /** persistent field */
   /* private com.sellerportal.model.Ismact ismact;*/

    /** persistent field */
    

//    /** persistent field */
//    private Set ismapts;

//    @OneToMany(mappedBy = "ismafm", fetch = FetchType.LAZY)
//    private Set<Ismpot> ismpots;
//    /** persistent field */
//    private Set ismkgts;

//    /** persistent field */
//    private Set ismdpts;
//
//    /** persistent field */
//    private Set ismsoms;

    @OneToMany(mappedBy = "ismafm", fetch = FetchType.LAZY)
    private Set<Ismvsm> ismvsms;

//    @OneToMany(mappedBy = "ismafm", fetch = FetchType.LAZY)
//    private Set<Ismcmt> ismcmts;

//    /** persistent field */
//    private Set ismscls;

//    @OneToMany(mappedBy = "ismafm", fetch = FetchType.LAZY)
//    private Set<Ismubi> ismubis;

    @OneToMany(mappedBy = "ismafm", fetch = FetchType.LAZY)
    private Set<Ismacc> ismaccs;

    @OneToMany(mappedBy = "ismafm", fetch = FetchType.LAZY)
    private Set<Octapp> octapps;

    @OneToMany(mappedBy = "ismafm", fetch = FetchType.LAZY)
    private Set<Ismout> ismouts;

//    @OneToMany(mappedBy = "ismafm", fetch = FetchType.LAZY)
//    private Set<Ismpst> ismpsts;

    @OneToMany(mappedBy = "ismafm", fetch = FetchType.LAZY)
    private Set<Ismpmt> ismpmts;

    @OneToMany(mappedBy = "ismafm", fetch = FetchType.LAZY)
    private Set<Ismmct> ismmcts;
    /** full constructor */
    public Ismafm(String afmallproduct, String afmothercatl,String afmbanner, Date afmcreatedate, Long afmcreatedby, Long afmdatrfnum, String afmdeleted, String afmdesc, String afmfootertemplate, String afmisprice, String afmlogintemplate, String afmlogo, Date afmmodifydate, String afmmyacctemplate, String afmname, String afmprofileregtemplate, String afmregtemplate, String afmrootsite, String afmurl, com.sellerportal.model.Ismcnd ismcndByAfmcndbusinessid, com.sellerportal.model.Ismcnd ismcndByAfmcndchannelid, com.sellerportal.model.Ismpet ismpet, /*com.sellerportal.model.Ismact ismact*/ Set ismapts, Set ismpots, Set ismkgts, Set ismdpts, Set ismsoms, Set ismvsms, Set ismcmts, Set ismscls, Set ismubis, Set ismaccs, Set octapps, Set ismacts, Set ismouts, Set ismpsts, Set ismpmts, Set ismmcts) {
        this.afmallproduct = afmallproduct;
        this.afmbanner = afmbanner;
        this.afmcreatedate = afmcreatedate;
        this.afmcreatedby = afmcreatedby;
        this.afmdatrfnum = afmdatrfnum;
        this.afmdeleted = afmdeleted;
        this.afmdesc = afmdesc;
        this.afmfootertemplate = afmfootertemplate;
        this.afmisprice = afmisprice;
        this.afmlogintemplate = afmlogintemplate;
        this.afmlogo = afmlogo;
        this.afmmodifydate = afmmodifydate;
        this.afmmyacctemplate = afmmyacctemplate;
        this.afmname = afmname;
        this.afmprofileregtemplate = afmprofileregtemplate;
        this.afmregtemplate = afmregtemplate;
        this.afmrootsite = afmrootsite;
        this.afmurl = afmurl;
        this.ismcndByAfmcndbusinessid = ismcndByAfmcndbusinessid;
        this.ismcndByAfmcndchannelid = ismcndByAfmcndchannelid;
        this.ismpet = ismpet;
       /* this.ismact = ismact;*/
//        this.ismapts = ismapts;
//        this.ismpots = ismpots;
//        this.ismkgts = ismkgts;
//        this.ismdpts = ismdpts;
//        this.ismsoms = ismsoms;
        this.ismvsms = ismvsms;
//        this.ismcmts = ismcmts;
//        this.ismscls = ismscls;
//        this.ismubis = ismubis;
        this.ismaccs = ismaccs;
        this.octapps = octapps;
//        this.ismacts = ismacts;
        this.ismouts = ismouts;
//        this.ismpsts = ismpsts;
        this.ismpmts = ismpmts;
        this.ismmcts = ismmcts;
        this.afmothercatl=afmothercatl;
    }

    /** default constructor */
    public Ismafm() {
    }

    /** minimal constructor */
    public Ismafm(Date afmcreatedate, Long afmcreatedby, String afmdeleted, String afmisprice, Date afmmodifydate, com.sellerportal.model.Ismcnd ismcndByAfmcndbusinessid, com.sellerportal.model.Ismcnd ismcndByAfmcndchannelid, com.sellerportal.model.Ismpet ismpet,/* com.sellerportal.model.Ismact ismact,*/ Set ismapts, Set ismpots, Set ismkgts, Set ismdpts, Set ismsoms, Set ismvsms, Set ismcmts, Set ismscls, Set ismubis, Set ismaccs, Set octapps, Set ismacts, Set ismouts, Set ismpsts, Set ismpmts, Set ismmcts) {
        this.afmcreatedate = afmcreatedate;
        this.afmcreatedby = afmcreatedby;
        this.afmdeleted = afmdeleted;
        this.afmisprice = afmisprice;
        this.afmmodifydate = afmmodifydate;
        this.ismcndByAfmcndbusinessid = ismcndByAfmcndbusinessid;
        this.ismcndByAfmcndchannelid = ismcndByAfmcndchannelid;
        this.ismpet = ismpet;
        /*this.ismact = ismact;*/
//        this.ismapts = ismapts;
//        this.ismpots = ismpots;
//        this.ismkgts = ismkgts;
//        this.ismdpts = ismdpts;
//        this.ismsoms = ismsoms;
        this.ismvsms = ismvsms;
//        this.ismcmts = ismcmts;
//        this.ismscls = ismscls;
//        this.ismubis = ismubis;
        this.ismaccs = ismaccs;
        this.octapps = octapps;
//        this.ismacts = ismacts;
        this.ismouts = ismouts;
//        this.ismpsts = ismpsts;
        this.ismpmts = ismpmts;
        this.ismmcts = ismmcts;
    }

    /** 
     * 		       auto_increment
     * 		    
     */
    public Long getAfmrfnum() {
        return this.afmrfnum;
    }

    public void setAfmrfnum(Long afmrfnum) {
        this.afmrfnum = afmrfnum;
    }

    public String getAfmallproduct() {
        return this.afmallproduct;
    }

    public void setAfmallproduct(String afmallproduct) {
        this.afmallproduct = afmallproduct;
    }

    public String getAfmbanner() {
        return this.afmbanner;
    }

    public void setAfmbanner(String afmbanner) {
        this.afmbanner = afmbanner;
    }

    public Date getAfmcreatedate() {
        return this.afmcreatedate;
    }

    public void setAfmcreatedate(Date afmcreatedate) {
        this.afmcreatedate = afmcreatedate;
    }

    public Long getAfmcreatedby() {
        return this.afmcreatedby;
    }

    public void setAfmcreatedby(Long afmcreatedby) {
        this.afmcreatedby = afmcreatedby;
    }

    public Long getAfmdatrfnum() {
        return this.afmdatrfnum;
    }

    public void setAfmdatrfnum(Long afmdatrfnum) {
        this.afmdatrfnum = afmdatrfnum;
    }

    public String getAfmdeleted() {
        return this.afmdeleted;
    }

    public void setAfmdeleted(String afmdeleted) {
        this.afmdeleted = afmdeleted;
    }

    public String getAfmdesc() {
        return this.afmdesc;
    }

    public void setAfmdesc(String afmdesc) {
        this.afmdesc = afmdesc;
    }

    public String getAfmfootertemplate() {
        return this.afmfootertemplate;
    }

    public void setAfmfootertemplate(String afmfootertemplate) {
        this.afmfootertemplate = afmfootertemplate;
    }

    public String getAfmisprice() {
        return this.afmisprice;
    }

    public void setAfmisprice(String afmisprice) {
        this.afmisprice = afmisprice;
    }

    public String getAfmlogintemplate() {
        return this.afmlogintemplate;
    }

    public void setAfmlogintemplate(String afmlogintemplate) {
        this.afmlogintemplate = afmlogintemplate;
    }

    public String getAfmlogo() {
        return this.afmlogo;
    }

    public void setAfmlogo(String afmlogo) {
        this.afmlogo = afmlogo;
    }

    public Date getAfmmodifydate() {
        return this.afmmodifydate;
    }

    public void setAfmmodifydate(Date afmmodifydate) {
        this.afmmodifydate = afmmodifydate;
    }

    public String getAfmmyacctemplate() {
        return this.afmmyacctemplate;
    }

    public void setAfmmyacctemplate(String afmmyacctemplate) {
        this.afmmyacctemplate = afmmyacctemplate;
    }

    public String getAfmname() {
        return this.afmname;
    }

    public void setAfmname(String afmname) {
        this.afmname = afmname;
    }

    public String getAfmprofileregtemplate() {
        return this.afmprofileregtemplate;
    }

    public void setAfmprofileregtemplate(String afmprofileregtemplate) {
        this.afmprofileregtemplate = afmprofileregtemplate;
    }

    public String getAfmregtemplate() {
        return this.afmregtemplate;
    }

    public void setAfmregtemplate(String afmregtemplate) {
        this.afmregtemplate = afmregtemplate;
    }

    public String getAfmrootsite() {
        return this.afmrootsite;
    }

    public void setAfmrootsite(String afmrootsite) {
        this.afmrootsite = afmrootsite;
    }

    public String getAfmurl() {
        return this.afmurl;
    }

    public void setAfmurl(String afmurl) {
        this.afmurl = afmurl;
    }

    public com.sellerportal.model.Ismcnd getIsmcndByAfmcndbusinessid() {
        return this.ismcndByAfmcndbusinessid;
    }

    public void setIsmcndByAfmcndbusinessid(com.sellerportal.model.Ismcnd ismcndByAfmcndbusinessid) {
        this.ismcndByAfmcndbusinessid = ismcndByAfmcndbusinessid;
    }

    public com.sellerportal.model.Ismcnd getIsmcndByAfmcndchannelid() {
        return this.ismcndByAfmcndchannelid;
    }

    public void setIsmcndByAfmcndchannelid(com.sellerportal.model.Ismcnd ismcndByAfmcndchannelid) {
        this.ismcndByAfmcndchannelid = ismcndByAfmcndchannelid;
    }

    public com.sellerportal.model.Ismpet getIsmpet() {
        return this.ismpet;
    }

    public void setIsmpet(com.sellerportal.model.Ismpet ismpet) {
        this.ismpet = ismpet;
    }

//    public com.sellerportal.model.Ismact getIsmact() {
//        return this.ismact;
//    }
//
//    public void setIsmact(com.sellerportal.model.Ismact ismact) {
//        this.ismact = ismact;
//    }

   

//    public Set getIsmapts() {
//        return this.ismapts;
//    }
//
//    public void setIsmapts(Set ismapts) {
//        this.ismapts = ismapts;
//    }

//    public Set getIsmpots() {
//        return this.ismpots;
//    }
//
//    public void setIsmpots(Set ismpots) {
//        this.ismpots = ismpots;
//    }

//    public Set getIsmkgts() {
//        return this.ismkgts;
//    }
//
//    public void setIsmkgts(Set ismkgts) {
//        this.ismkgts = ismkgts;
//    }
//
//    public Set getIsmdpts() {
//        return this.ismdpts;
//    }
//
//    public void setIsmdpts(Set ismdpts) {
//        this.ismdpts = ismdpts;
//    }
//
//    public Set getIsmsoms() {
//        return this.ismsoms;
//    }
//
//    public void setIsmsoms(Set ismsoms) {
//        this.ismsoms = ismsoms;
//    }

    public Set getIsmvsms() {
        return this.ismvsms;
    }

    public void setIsmvsms(Set ismvsms) {
        this.ismvsms = ismvsms;
    }

//    public Set getIsmcmts() {
//        return this.ismcmts;
//    }
//
//    public void setIsmcmts(Set ismcmts) {
//        this.ismcmts = ismcmts;
//    }

//    public Set getIsmscls() {
//        return this.ismscls;
//    }
//
//    public void setIsmscls(Set ismscls) {
//        this.ismscls = ismscls;
//    }

//    public Set getIsmubis() {
//        return this.ismubis;
//    }
//
//    public void setIsmubis(Set ismubis) {
//        this.ismubis = ismubis;
//    }

    public Set getIsmaccs() {
        return this.ismaccs;
    }

    public void setIsmaccs(Set ismaccs) {
        this.ismaccs = ismaccs;
    }

    public Set getOctapps() {
        return this.octapps;
    }

    public void setOctapps(Set octapps) {
        this.octapps = octapps;
    }

//    public Set getIsmacts() {
//        return this.ismacts;
//    }
//
//    public void setIsmacts(Set ismacts) {
//        this.ismacts = ismacts;
//    }

    public Set getIsmouts() {
        return this.ismouts;
    }

    public void setIsmouts(Set ismouts) {
        this.ismouts = ismouts;
    }

//    public Set getIsmpsts() {
//        return this.ismpsts;
//    }
//
//    public void setIsmpsts(Set ismpsts) {
//        this.ismpsts = ismpsts;
//    }

    public Set getIsmpmts() {
        return this.ismpmts;
    }

    public void setIsmpmts(Set ismpmts) {
        this.ismpmts = ismpmts;
    }

    public Set getIsmmcts() {
        return this.ismmcts;
    }

    public void setIsmmcts(Set ismmcts) {
        this.ismmcts = ismmcts;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("afmrfnum", getAfmrfnum())
            .toString();
    }

    public String getAfmothercatl() {
  		return afmothercatl;
  	}

  	public void setAfmothercatl(String afmothercatl) {
  		this.afmothercatl = afmothercatl;
  	}


}
