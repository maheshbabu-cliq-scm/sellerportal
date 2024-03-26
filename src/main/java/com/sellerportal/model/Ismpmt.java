package com.sellerportal.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import org.apache.commons.lang.builder.ToStringBuilder;
import javax.persistence.*;

@Entity
@Table(name = "ISMPMT")
public class Ismpmt implements Serializable {

	 @Id
	    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ismpmt_sequence")
	    @SequenceGenerator(name = "ismpmt_sequence", sequenceName = "ISMPMT_PMTRFNUM_SEQ", allocationSize = 1)
	    @Column(name = "PMTRFNUM")
	    private Long pmtrfnum;

	    @Column(name = "CREATEDATE", nullable = false)
	    private Date createdate;

	    @Column(name = "CREATEDBY", nullable = false)
	    private Long createdby;

	    @Column(name = "DELETED", nullable = false, length = 1)
	    private String deleted;

	    @Column(name = "MODIDATE", nullable = false)
	    private Date modidate;

	    @Column(name = "PMTCARDTYPE", length = 254)
	    private String pmtcardtype;

	    @Column(name = "PMTCHANNELID", length = 254)
	    private String pmtchannelid;

	    @Column(name = "PMTCODE", nullable = false, length = 32)
	    private String pmtcode;

	    @Column(name = "PMTDESC", length = 2028)
	    private String pmtdesc;

	    @Column(name = "PMTIMAGEFILE", length = 254)
	    private String pmtimagefile;

	    @Column(name = "PMTISACTIVE", nullable = false, length = 1)
	    private String pmtisactive;

	    @Column(name = "PMTISADMIN", nullable = false, length = 1)
	    private String pmtisadmin;

	    @Column(name = "PMTISONLINE", nullable = false, length = 1)
	    private String pmtisonline;

	    @Column(name = "PMTNAME", nullable = false, length = 254)
	    private String pmtname;

	    @Column(name = "PMTSEQUINCENO", length = 11)
	    private Integer pmtsequinceno;

	    @Column(name = "PMTSMTRFNUMFAIL")
	    private Long pmtsmtrfnumfail;

	    @Column(name = "PMTSMTRFNUMSUCCESS")
	    private Long pmtsmtrfnumsuccess;

	    @Column(name = "PMTSUCCESSDETAILS", length = 2048)
	    private String pmtsuccessdetails;

	    @ManyToOne(fetch = FetchType.LAZY)
	    @JoinColumn(name = "PMTCNDCATEGORY", nullable = false)
	    private Ismcnd ismcnd;

	    @ManyToOne(fetch = FetchType.LAZY)
	    @JoinColumn(name = "PMTIDMRFNUM", nullable = false)
	    private Ismidm ismidm;

	    @ManyToOne(fetch = FetchType.LAZY)
	    @JoinColumn(name = "PMTSMSMDMRFNUM", nullable = false)
	    private Ismmdm ismmdmByPmtsmsmdmrfnum;

	    @ManyToOne(fetch = FetchType.LAZY)
	    @JoinColumn(name = "PMTMDMRFNUM", nullable = false)
	    private Ismmdm ismmdmByPmtmdmrfnum;

	    @ManyToOne(fetch = FetchType.LAZY)
	    @JoinColumn(name = "PMTAFMRFNUM", nullable = false)
	    private Ismafm ismafm;

	    @ManyToOne(fetch = FetchType.LAZY)
	    @JoinColumn(name = "PMTSMTRFNUM", nullable = false)
	    private Ismsmt ismsmtByPmtsmtrfnum;

	    @ManyToOne(fetch = FetchType.LAZY)
	    @JoinColumn(name = "PMTSMTPARTSUCC", nullable = false)
	    private Ismsmt ismsmtByPmtsmtpartsucc;

	    @ManyToOne(fetch = FetchType.LAZY)
	    @JoinColumn(name = "PMTMTMRFNUM", nullable = false)
	    private Ismmtm ismmtmByPmtmtmrfnum;

	    @ManyToOne(fetch = FetchType.LAZY)
	    @JoinColumn(name = "PMTCCMTMRFNUM", nullable = false)
	    private Ismmtm ismmtmByPmtccmtmrfnum;

	    @ManyToOne(fetch = FetchType.LAZY)
	    @JoinColumn(name = "PMTSMDRFNUM", nullable = false)
	    private Ismsmd ismsmd;

    @OneToMany(mappedBy = "ismpmt", fetch = FetchType.LAZY)
    private Set<Ismppm> ismppms;

//    /** persistent field */
//    private Set ismapts;

//    @OneToMany(mappedBy = "ismpmt", fetch = FetchType.LAZY)
//    private Set<Ismpot> ismpots;

    @OneToMany(mappedBy = "ismpmt", fetch = FetchType.LAZY)
    private Set<Ismbpm> ismbpms;

    @OneToMany(mappedBy = "ismpmt", fetch = FetchType.LAZY)
    private Set<Ismbco> ismbcos;
    @Column(name = "MODIFIEDBY", nullable = false)
    private Long modifiedby;

    @Column(name = "PMTADDONCHARGE")
    private Long pmtaddoncharge;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PMTCNDDEFAULTGROUP", nullable = false)
    private Ismcnd pmtcnddefaultgroup;

	public com.sellerportal.model.Ismcnd getPmtcnddefaultgroup() {
		return pmtcnddefaultgroup;
	}

	public void setPmtcnddefaultgroup(com.sellerportal.model.Ismcnd pmtcnddefaultgroup) {
		this.pmtcnddefaultgroup = pmtcnddefaultgroup;
	}
	//Bug 35555 End
	
    /** full constructor */
    public Ismpmt(Date createdate, Long createdby, String deleted, Date modidate, String pmtcardtype, String pmtchannelid, String pmtcode, String pmtdesc, String pmtimagefile, String pmtisactive, String pmtisadmin, String pmtisonline, String pmtname, Integer pmtsequinceno, Long pmtsmtrfnumfail, Long pmtsmtrfnumsuccess, String pmtsuccessdetails, com.sellerportal.model.Ismcnd ismcnd,com.sellerportal.model.Ismidm ismidm, com.sellerportal.model.Ismmdm ismmdmByPmtsmsmdmrfnum, com.sellerportal.model.Ismmdm ismmdmByPmtmdmrfnum, com.sellerportal.model.Ismafm ismafm, com.sellerportal.model.Ismsmt ismsmtByPmtsmtrfnum, com.sellerportal.model.Ismsmt ismsmtByPmtsmtpartsucc, com.sellerportal.model.Ismmtm ismmtmByPmtmtmrfnum, com.sellerportal.model.Ismmtm ismmtmByPmtccmtmrfnum, com.sellerportal.model.Ismsmd ismsmd, Set ismppms, Set ismapts, Set ismpots, Set ismbpms, Set ismbcos,Long modifiedby, com.sellerportal.model.Ismcnd pmtcnddefaultgroup,long pmtaddoncharge) {//Bug 35555
        this.createdate = createdate;
        this.createdby = createdby;
        this.deleted = deleted;
        this.modidate = modidate;
        this.pmtcardtype = pmtcardtype;
        this.pmtchannelid = pmtchannelid;
        this.pmtcode = pmtcode;
        this.pmtdesc = pmtdesc;
        this.pmtimagefile = pmtimagefile;
        this.pmtisactive = pmtisactive;
        this.pmtisadmin = pmtisadmin;
        this.pmtisonline = pmtisonline;
        this.pmtname = pmtname;
        this.pmtsequinceno = pmtsequinceno;
        this.pmtsmtrfnumfail = pmtsmtrfnumfail;
        this.pmtsmtrfnumsuccess = pmtsmtrfnumsuccess;
        this.pmtsuccessdetails = pmtsuccessdetails;
        this.ismcnd = ismcnd;
        this.ismidm = ismidm;
        this.ismmdmByPmtsmsmdmrfnum = ismmdmByPmtsmsmdmrfnum;
        this.ismmdmByPmtmdmrfnum = ismmdmByPmtmdmrfnum;
        this.ismafm = ismafm;
        this.ismsmtByPmtsmtrfnum = ismsmtByPmtsmtrfnum;
        this.ismsmtByPmtsmtpartsucc = ismsmtByPmtsmtpartsucc;
        this.ismmtmByPmtmtmrfnum = ismmtmByPmtmtmrfnum;
        this.ismmtmByPmtccmtmrfnum = ismmtmByPmtccmtmrfnum;
        this.ismsmd = ismsmd;
        this.ismppms = ismppms;
//        this.ismapts = ismapts;
//        this.ismpots = ismpots;
        this.ismbpms = ismbpms;
        this.ismbcos = ismbcos;
        this.modifiedby = modifiedby; 
        this.pmtcnddefaultgroup = pmtcnddefaultgroup;//35555
        this.pmtaddoncharge=pmtaddoncharge;
    }

    /** default constructor */
    public Ismpmt() {
    }

    /** minimal constructor */
    public Ismpmt(Date createdate, Long createdby, String deleted, Date modidate, String pmtcode, String pmtisactive, String pmtisadmin, String pmtisonline, String pmtname, com.sellerportal.model.Ismcnd ismcnd,com.sellerportal.model.Ismidm ismidm, com.sellerportal.model.Ismmdm ismmdmByPmtsmsmdmrfnum, com.sellerportal.model.Ismmdm ismmdmByPmtmdmrfnum, com.sellerportal.model.Ismafm ismafm, com.sellerportal.model.Ismsmt ismsmtByPmtsmtrfnum, com.sellerportal.model.Ismsmt ismsmtByPmtsmtpartsucc, com.sellerportal.model.Ismmtm ismmtmByPmtmtmrfnum, com.sellerportal.model.Ismmtm ismmtmByPmtccmtmrfnum, com.sellerportal.model.Ismsmd ismsmd, Set ismppms, Set ismapts, Set ismpots, Set ismbpms, Set ismbcos, com.sellerportal.model.Ismcnd pmtcnddefaultgroup) {//35555
        this.createdate = createdate;
        this.createdby = createdby;
        this.deleted = deleted;
        this.modidate = modidate;
        this.pmtcode = pmtcode;
        this.pmtisactive = pmtisactive;
        this.pmtisadmin = pmtisadmin;
        this.pmtisonline = pmtisonline;
        this.pmtname = pmtname;
        this.ismcnd = ismcnd;
        this.ismidm = ismidm;
        this.ismmdmByPmtsmsmdmrfnum = ismmdmByPmtsmsmdmrfnum;
        this.ismmdmByPmtmdmrfnum = ismmdmByPmtmdmrfnum;
        this.ismafm = ismafm;
        this.ismsmtByPmtsmtrfnum = ismsmtByPmtsmtrfnum;
        this.ismsmtByPmtsmtpartsucc = ismsmtByPmtsmtpartsucc;
        this.ismmtmByPmtmtmrfnum = ismmtmByPmtmtmrfnum;
        this.ismmtmByPmtccmtmrfnum = ismmtmByPmtccmtmrfnum;
        this.ismsmd = ismsmd;
        this.ismppms = ismppms;
//        this.ismapts = ismapts;
//        this.ismpots = ismpots;
        this.ismbpms = ismbpms;
        this.ismbcos = ismbcos;
        this.pmtcnddefaultgroup = pmtcnddefaultgroup;//35555
    }

    /** 
     * 		       auto_increment
     * 		    
     */
    public Long getPmtrfnum() {
        return this.pmtrfnum;
    }

    public void setPmtrfnum(Long pmtrfnum) {
        this.pmtrfnum = pmtrfnum;
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

    public String getPmtcardtype() {
        return this.pmtcardtype;
    }

    public void setPmtcardtype(String pmtcardtype) {
        this.pmtcardtype = pmtcardtype;
    }

    public String getPmtchannelid() {
        return this.pmtchannelid;
    }

    public void setPmtchannelid(String pmtchannelid) {
        this.pmtchannelid = pmtchannelid;
    }

    public String getPmtcode() {
        return this.pmtcode;
    }

    public void setPmtcode(String pmtcode) {
        this.pmtcode = pmtcode;
    }

    public String getPmtdesc() {
        return this.pmtdesc;
    }

    public void setPmtdesc(String pmtdesc) {
        this.pmtdesc = pmtdesc;
    }

    public String getPmtimagefile() {
        return this.pmtimagefile;
    }

    public void setPmtimagefile(String pmtimagefile) {
        this.pmtimagefile = pmtimagefile;
    }

    public String getPmtisactive() {
        return this.pmtisactive;
    }

    public void setPmtisactive(String pmtisactive) {
        this.pmtisactive = pmtisactive;
    }

    public String getPmtisadmin() {
        return this.pmtisadmin;
    }

    public void setPmtisadmin(String pmtisadmin) {
        this.pmtisadmin = pmtisadmin;
    }

    public String getPmtisonline() {
        return this.pmtisonline;
    }

    public void setPmtisonline(String pmtisonline) {
        this.pmtisonline = pmtisonline;
    }

    public String getPmtname() {
        return this.pmtname;
    }

    public void setPmtname(String pmtname) {
        this.pmtname = pmtname;
    }

    public Integer getPmtsequinceno() {
        return this.pmtsequinceno;
    }

    public void setPmtsequinceno(Integer pmtsequinceno) {
        this.pmtsequinceno = pmtsequinceno;
    }

    public Long getPmtsmtrfnumfail() {
        return this.pmtsmtrfnumfail;
    }

    public void setPmtsmtrfnumfail(Long pmtsmtrfnumfail) {
        this.pmtsmtrfnumfail = pmtsmtrfnumfail;
    }

    public Long getPmtsmtrfnumsuccess() {
        return this.pmtsmtrfnumsuccess;
    }

    public void setPmtsmtrfnumsuccess(Long pmtsmtrfnumsuccess) {
        this.pmtsmtrfnumsuccess = pmtsmtrfnumsuccess;
    }

    public String getPmtsuccessdetails() {
        return this.pmtsuccessdetails;
    }

    public void setPmtsuccessdetails(String pmtsuccessdetails) {
        this.pmtsuccessdetails = pmtsuccessdetails;
    }

    public com.sellerportal.model.Ismcnd getIsmcnd() {
        return this.ismcnd;
    }

    public void setIsmcnd(com.sellerportal.model.Ismcnd ismcnd) {
        this.ismcnd = ismcnd;
    }

    public com.sellerportal.model.Ismidm getIsmidm() {
        return this.ismidm;
    }

    public void setIsmidm(com.sellerportal.model.Ismidm ismidm) {
        this.ismidm = ismidm;
    }

    public com.sellerportal.model.Ismmdm getIsmmdmByPmtsmsmdmrfnum() {
        return this.ismmdmByPmtsmsmdmrfnum;
    }

    public void setIsmmdmByPmtsmsmdmrfnum(com.sellerportal.model.Ismmdm ismmdmByPmtsmsmdmrfnum) {
        this.ismmdmByPmtsmsmdmrfnum = ismmdmByPmtsmsmdmrfnum;
    }

    public com.sellerportal.model.Ismmdm getIsmmdmByPmtmdmrfnum() {
        return this.ismmdmByPmtmdmrfnum;
    }

    public void setIsmmdmByPmtmdmrfnum(com.sellerportal.model.Ismmdm ismmdmByPmtmdmrfnum) {
        this.ismmdmByPmtmdmrfnum = ismmdmByPmtmdmrfnum;
    }

    public com.sellerportal.model.Ismafm getIsmafm() {
        return this.ismafm;
    }

    public void setIsmafm(com.sellerportal.model.Ismafm ismafm) {
        this.ismafm = ismafm;
    }

    public com.sellerportal.model.Ismsmt getIsmsmtByPmtsmtrfnum() {
        return this.ismsmtByPmtsmtrfnum;
    }

    public void setIsmsmtByPmtsmtrfnum(com.sellerportal.model.Ismsmt ismsmtByPmtsmtrfnum) {
        this.ismsmtByPmtsmtrfnum = ismsmtByPmtsmtrfnum;
    }

    public com.sellerportal.model.Ismsmt getIsmsmtByPmtsmtpartsucc() {
        return this.ismsmtByPmtsmtpartsucc;
    }

    public void setIsmsmtByPmtsmtpartsucc(com.sellerportal.model.Ismsmt ismsmtByPmtsmtpartsucc) {
        this.ismsmtByPmtsmtpartsucc = ismsmtByPmtsmtpartsucc;
    }

    public com.sellerportal.model.Ismmtm getIsmmtmByPmtmtmrfnum() {
        return this.ismmtmByPmtmtmrfnum;
    }

    public void setIsmmtmByPmtmtmrfnum(com.sellerportal.model.Ismmtm ismmtmByPmtmtmrfnum) {
        this.ismmtmByPmtmtmrfnum = ismmtmByPmtmtmrfnum;
    }

    public com.sellerportal.model.Ismmtm getIsmmtmByPmtccmtmrfnum() {
        return this.ismmtmByPmtccmtmrfnum;
    }

    public void setIsmmtmByPmtccmtmrfnum(com.sellerportal.model.Ismmtm ismmtmByPmtccmtmrfnum) {
        this.ismmtmByPmtccmtmrfnum = ismmtmByPmtccmtmrfnum;
    }

    public com.sellerportal.model.Ismsmd getIsmsmd() {
        return this.ismsmd;
    }

    public void setIsmsmd(com.sellerportal.model.Ismsmd ismsmd) {
        this.ismsmd = ismsmd;
    }

    public Set getIsmppms() {
        return this.ismppms;
    }

    public void setIsmppms(Set ismppms) {
        this.ismppms = ismppms;
    }

//    public Set getIsmapts() {
//        return this.ismapts;
//    }

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

    public Set getIsmbpms() {
        return this.ismbpms;
    }

    public void setIsmbpms(Set ismbpms) {
        this.ismbpms = ismbpms;
    }

    public Set getIsmbcos() {
        return this.ismbcos;
    }

    public void setIsmbcos(Set ismbcos) {
        this.ismbcos = ismbcos;
    }
    public Long getModifiedby() {
		return modifiedby;
	}

	public void setModifiedby(Long modifiedby) {
		this.modifiedby = modifiedby;
	}
	
	

	/**
	 * @return the pmtaddoncharge
	 */
	public Long getPmtaddoncharge() {
		return pmtaddoncharge;
	}

	/**
	 * @param pmtaddoncharge the pmtaddoncharge to set
	 */
	public void setPmtaddoncharge(Long pmtaddoncharge) {
		this.pmtaddoncharge = pmtaddoncharge;
	}

	public String toString() {
        return new ToStringBuilder(this)
            .append("pmtrfnum", getPmtrfnum())
            .toString();
    }

}
