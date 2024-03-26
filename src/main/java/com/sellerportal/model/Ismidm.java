package com.sellerportal.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;
import javax.persistence.*;
import org.apache.commons.lang3.builder.ToStringBuilder;


@Entity
@Table(name = "ISMIDM")
public class Ismidm implements Serializable {

	@Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "IDMRFNUM_SEQ")
    @SequenceGenerator(name = "IDMRFNUM_SEQ", sequenceName = "ISMIDM_IDMRFNUM_SEQ", allocationSize = 1)
    @Column(name = "IDMRFNUM")
    private Long idmrfnum;

    @Column(name = "IDMCREATEDATE", nullable = false)
    private Date idmcreatedate;

    @Column(name = "IDMCREATEDBY", nullable = false)
    private Long idmcreatedby;

    @Column(name = "IDMDELETED", nullable = false, length = 1)
    private String idmdeleted;

    @Column(name = "IDMDESC", length = 2048)
    private String idmdesc;

    @Column(name = "IDMFIELD1", length = 128)
    private String idmfield1;

    @Column(name = "IDMFIELD2", length = 64)
    private String idmfield2;

    @Column(name = "IDMFIELD3", length = 32)
    private String idmfield3;

    @Column(name = "IDMINVOKER", length = 256)
    private String idminvoker;

    @Column(name = "IDMISSYNC", nullable = false, length = 1)
    private String idmissync;

    @Column(name = "IDMMETHOD", length = 128)
    private String idmmethod;

    @Column(name = "IDMMODIFIEDDATE", nullable = false)
    private Date idmmodifieddate;

    @Column(name = "IDMRELOG", length = 1)
    private String idmrelog;

    @Column(name = "IDMRESPOPARSER", length = 128)
    private String idmrespoparser;

    @Column(name = "IDMRQLOGON", length = 1)
    private String idmrqlogon;

    @Column(name = "IDMURL", nullable = false, length = 256)
    private String idmurl;

    @ManyToOne
    @JoinColumn(name = "IDMCNDNAME", nullable = false)
    private Ismcnd ismcndByIdmcndname;

    @ManyToOne
    @JoinColumn(name = "IDMCNDPROTOCOL", nullable = false)
    private Ismcnd ismcndByIdmcndprotocol;

//    @OneToMany(mappedBy = "ismidmByAptidmrfnum")
//    private Set<Ismapt> ismapts;

    @OneToMany(mappedBy = "ismidm", cascade = CascadeType.ALL)
    private Set<Ismirp> ismirps;

    // An example of bi-directional one-to-many associations
    @OneToMany(mappedBy = "ismidmByPetidmgetuserprofile",  fetch = FetchType.LAZY)
    private Set<Ismpet> ismpetsByPetidmgetuserprofile;

    @OneToMany(mappedBy = "ismidmByPetidmauthenticate",  fetch = FetchType.LAZY)
    private Set<Ismpet> ismpetsByPetidmauthenticate;

    @OneToMany(mappedBy = "ismidmByPetidmcreditpoint",  fetch = FetchType.LAZY)
    private Set<Ismpet> ismpetsByPetidmcreditpoint;

    @OneToMany(mappedBy = "ismidmByPetidmpointredem",  fetch = FetchType.LAZY)
    private Set<Ismpet> ismpetsByPetidmpointredem;

    @OneToMany(mappedBy = "ismidmByPetidmregister",  fetch = FetchType.LAZY)
    private Set<Ismpet> ismpetsByPetidmregister;

    @OneToMany(mappedBy = "ismidmByPetidmchangepassword",  fetch = FetchType.LAZY)
    private Set<Ismpet> ismpetsByPetidmchangepassword;

    @OneToMany(mappedBy = "ismidmByPetidmusrlyltpts",  fetch = FetchType.LAZY)
    private Set<Ismpet> ismpetsByPetidmusrlyltpts;

    @OneToMany(mappedBy = "ismidmByPetidmgetpassword",  fetch = FetchType.LAZY)
    private Set<Ismpet> ismpetsByPetidmgetpassword;

    @OneToMany(mappedBy = "ismidmByPetidmcheckuserexist",  fetch = FetchType.LAZY)
    private Set<Ismpet> ismpetsByPetidmcheckuserexist;

    @OneToMany(mappedBy = "ismidm",  fetch = FetchType.LAZY)
    private Set<Ismirf> ismirfs;

    @OneToMany(mappedBy = "ismidm",  fetch = FetchType.LAZY)
    private Set<Ismpmt> ismpmts;

    /** full constructor */
    public Ismidm(Date idmcreatedate, Long idmcreatedby, String idmdeleted, String idmdesc, String idmfield1, String idmfield2, String idmfield3, String idminvoker, String idmissync, String idmmethod, Date idmmodifieddate, String idmrelog, String idmrespoparser, String idmrqlogon, String idmurl, com.sellerportal.model.Ismcnd ismcndByIdmcndname, com.sellerportal.model.Ismcnd ismcndByIdmcndprotocol, Set ismapts, Set ismirps, Set ismpetsByPetidmgetuserprofile, Set ismpetsByPetidmauthenticate, Set ismpetsByPetidmcreditpoint, Set ismpetsByPetidmpointredem, Set ismpetsByPetidmregister, Set ismpetsByPetidmchangepassword, Set ismpetsByPetidmusrlyltpts, Set ismpetsByPetidmgetpassword, Set ismpetsByPetidmcheckuserexist, Set ismirfs, Set ismpmts) {
        this.idmcreatedate = idmcreatedate;
        this.idmcreatedby = idmcreatedby;
        this.idmdeleted = idmdeleted;
        this.idmdesc = idmdesc;
        this.idmfield1 = idmfield1;
        this.idmfield2 = idmfield2;
        this.idmfield3 = idmfield3;
        this.idminvoker = idminvoker;
        this.idmissync = idmissync;
        this.idmmethod = idmmethod;
        this.idmmodifieddate = idmmodifieddate;
        this.idmrelog = idmrelog;
        this.idmrespoparser = idmrespoparser;
        this.idmrqlogon = idmrqlogon;
        this.idmurl = idmurl;
        this.ismcndByIdmcndname = ismcndByIdmcndname;
        this.ismcndByIdmcndprotocol = ismcndByIdmcndprotocol;
//        this.ismapts = ismapts;
        this.ismirps = ismirps;
        this.ismpetsByPetidmgetuserprofile = ismpetsByPetidmgetuserprofile;
        this.ismpetsByPetidmauthenticate = ismpetsByPetidmauthenticate;
        this.ismpetsByPetidmcreditpoint = ismpetsByPetidmcreditpoint;
        this.ismpetsByPetidmpointredem = ismpetsByPetidmpointredem;
        this.ismpetsByPetidmregister = ismpetsByPetidmregister;
        this.ismpetsByPetidmchangepassword = ismpetsByPetidmchangepassword;
        this.ismpetsByPetidmusrlyltpts = ismpetsByPetidmusrlyltpts;
        this.ismpetsByPetidmgetpassword = ismpetsByPetidmgetpassword;
        this.ismpetsByPetidmcheckuserexist = ismpetsByPetidmcheckuserexist;
        this.ismirfs = ismirfs;
        this.ismpmts = ismpmts;
    }

    /** default constructor */
    public Ismidm() {
    }

    /** minimal constructor */
    public Ismidm(Date idmcreatedate, Long idmcreatedby, String idmdeleted, String idmissync, Date idmmodifieddate, String idmurl, com.sellerportal.model.Ismcnd ismcndByIdmcndname, com.sellerportal.model.Ismcnd ismcndByIdmcndprotocol, Set ismapts, Set ismirps, Set ismpetsByPetidmgetuserprofile, Set ismpetsByPetidmauthenticate, Set ismpetsByPetidmcreditpoint, Set ismpetsByPetidmpointredem, Set ismpetsByPetidmregister, Set ismpetsByPetidmchangepassword, Set ismpetsByPetidmusrlyltpts, Set ismpetsByPetidmgetpassword, Set ismpetsByPetidmcheckuserexist, Set ismirfs, Set ismpmts) {
        this.idmcreatedate = idmcreatedate;
        this.idmcreatedby = idmcreatedby;
        this.idmdeleted = idmdeleted;
        this.idmissync = idmissync;
        this.idmmodifieddate = idmmodifieddate;
        this.idmurl = idmurl;
        this.ismcndByIdmcndname = ismcndByIdmcndname;
        this.ismcndByIdmcndprotocol = ismcndByIdmcndprotocol;
//        this.ismapts = ismapts;
        this.ismirps = ismirps;
        this.ismpetsByPetidmgetuserprofile = ismpetsByPetidmgetuserprofile;
        this.ismpetsByPetidmauthenticate = ismpetsByPetidmauthenticate;
        this.ismpetsByPetidmcreditpoint = ismpetsByPetidmcreditpoint;
        this.ismpetsByPetidmpointredem = ismpetsByPetidmpointredem;
        this.ismpetsByPetidmregister = ismpetsByPetidmregister;
        this.ismpetsByPetidmchangepassword = ismpetsByPetidmchangepassword;
        this.ismpetsByPetidmusrlyltpts = ismpetsByPetidmusrlyltpts;
        this.ismpetsByPetidmgetpassword = ismpetsByPetidmgetpassword;
        this.ismpetsByPetidmcheckuserexist = ismpetsByPetidmcheckuserexist;
        this.ismirfs = ismirfs;
        this.ismpmts = ismpmts;
    }

    /** 
     * 		       auto_increment
     * 		    
     */
    public Long getIdmrfnum() {
        return this.idmrfnum;
    }

    public void setIdmrfnum(Long idmrfnum) {
        this.idmrfnum = idmrfnum;
    }

    public Date getIdmcreatedate() {
        return this.idmcreatedate;
    }

    public void setIdmcreatedate(Date idmcreatedate) {
        this.idmcreatedate = idmcreatedate;
    }

    public Long getIdmcreatedby() {
        return this.idmcreatedby;
    }

    public void setIdmcreatedby(Long idmcreatedby) {
        this.idmcreatedby = idmcreatedby;
    }

    public String getIdmdeleted() {
        return this.idmdeleted;
    }

    public void setIdmdeleted(String idmdeleted) {
        this.idmdeleted = idmdeleted;
    }

    public String getIdmdesc() {
        return this.idmdesc;
    }

    public void setIdmdesc(String idmdesc) {
        this.idmdesc = idmdesc;
    }

    public String getIdmfield1() {
        return this.idmfield1;
    }

    public void setIdmfield1(String idmfield1) {
        this.idmfield1 = idmfield1;
    }

    public String getIdmfield2() {
        return this.idmfield2;
    }

    public void setIdmfield2(String idmfield2) {
        this.idmfield2 = idmfield2;
    }

    public String getIdmfield3() {
        return this.idmfield3;
    }

    public void setIdmfield3(String idmfield3) {
        this.idmfield3 = idmfield3;
    }

    public String getIdminvoker() {
        return this.idminvoker;
    }

    public void setIdminvoker(String idminvoker) {
        this.idminvoker = idminvoker;
    }

    public String getIdmissync() {
        return this.idmissync;
    }

    public void setIdmissync(String idmissync) {
        this.idmissync = idmissync;
    }

    public String getIdmmethod() {
        return this.idmmethod;
    }

    public void setIdmmethod(String idmmethod) {
        this.idmmethod = idmmethod;
    }

    public Date getIdmmodifieddate() {
        return this.idmmodifieddate;
    }

    public void setIdmmodifieddate(Date idmmodifieddate) {
        this.idmmodifieddate = idmmodifieddate;
    }

    public String getIdmrelog() {
        return this.idmrelog;
    }

    public void setIdmrelog(String idmrelog) {
        this.idmrelog = idmrelog;
    }

    public String getIdmrespoparser() {
        return this.idmrespoparser;
    }

    public void setIdmrespoparser(String idmrespoparser) {
        this.idmrespoparser = idmrespoparser;
    }

    public String getIdmrqlogon() {
        return this.idmrqlogon;
    }

    public void setIdmrqlogon(String idmrqlogon) {
        this.idmrqlogon = idmrqlogon;
    }

    public String getIdmurl() {
        return this.idmurl;
    }

    public void setIdmurl(String idmurl) {
        this.idmurl = idmurl;
    }

    public com.sellerportal.model.Ismcnd getIsmcndByIdmcndname() {
        return this.ismcndByIdmcndname;
    }

    public void setIsmcndByIdmcndname(com.sellerportal.model.Ismcnd ismcndByIdmcndname) {
        this.ismcndByIdmcndname = ismcndByIdmcndname;
    }

    public com.sellerportal.model.Ismcnd getIsmcndByIdmcndprotocol() {
        return this.ismcndByIdmcndprotocol;
    }

    public void setIsmcndByIdmcndprotocol(com.sellerportal.model.Ismcnd ismcndByIdmcndprotocol) {
        this.ismcndByIdmcndprotocol = ismcndByIdmcndprotocol;
    }

//    public Set getIsmapts() {
//        return this.ismapts;
//    }
//
//    public void setIsmapts(Set ismapts) {
//        this.ismapts = ismapts;
//    }

    public Set getIsmirps() {
        return this.ismirps;
    }

    public void setIsmirps(Set ismirps) {
        this.ismirps = ismirps;
    }

    public Set getIsmpetsByPetidmgetuserprofile() {
        return this.ismpetsByPetidmgetuserprofile;
    }

    public void setIsmpetsByPetidmgetuserprofile(Set ismpetsByPetidmgetuserprofile) {
        this.ismpetsByPetidmgetuserprofile = ismpetsByPetidmgetuserprofile;
    }

    public Set getIsmpetsByPetidmauthenticate() {
        return this.ismpetsByPetidmauthenticate;
    }

    public void setIsmpetsByPetidmauthenticate(Set ismpetsByPetidmauthenticate) {
        this.ismpetsByPetidmauthenticate = ismpetsByPetidmauthenticate;
    }

    public Set getIsmpetsByPetidmcreditpoint() {
        return this.ismpetsByPetidmcreditpoint;
    }

    public void setIsmpetsByPetidmcreditpoint(Set ismpetsByPetidmcreditpoint) {
        this.ismpetsByPetidmcreditpoint = ismpetsByPetidmcreditpoint;
    }

    public Set getIsmpetsByPetidmpointredem() {
        return this.ismpetsByPetidmpointredem;
    }

    public void setIsmpetsByPetidmpointredem(Set ismpetsByPetidmpointredem) {
        this.ismpetsByPetidmpointredem = ismpetsByPetidmpointredem;
    }

    public Set getIsmpetsByPetidmregister() {
        return this.ismpetsByPetidmregister;
    }

    public void setIsmpetsByPetidmregister(Set ismpetsByPetidmregister) {
        this.ismpetsByPetidmregister = ismpetsByPetidmregister;
    }

    public Set getIsmpetsByPetidmchangepassword() {
        return this.ismpetsByPetidmchangepassword;
    }

    public void setIsmpetsByPetidmchangepassword(Set ismpetsByPetidmchangepassword) {
        this.ismpetsByPetidmchangepassword = ismpetsByPetidmchangepassword;
    }

    public Set getIsmpetsByPetidmusrlyltpts() {
        return this.ismpetsByPetidmusrlyltpts;
    }

    public void setIsmpetsByPetidmusrlyltpts(Set ismpetsByPetidmusrlyltpts) {
        this.ismpetsByPetidmusrlyltpts = ismpetsByPetidmusrlyltpts;
    }

    public Set getIsmpetsByPetidmgetpassword() {
        return this.ismpetsByPetidmgetpassword;
    }

    public void setIsmpetsByPetidmgetpassword(Set ismpetsByPetidmgetpassword) {
        this.ismpetsByPetidmgetpassword = ismpetsByPetidmgetpassword;
    }

    public Set getIsmpetsByPetidmcheckuserexist() {
        return this.ismpetsByPetidmcheckuserexist;
    }

    public void setIsmpetsByPetidmcheckuserexist(Set ismpetsByPetidmcheckuserexist) {
        this.ismpetsByPetidmcheckuserexist = ismpetsByPetidmcheckuserexist;
    }

    public Set getIsmirfs() {
        return this.ismirfs;
    }

    public void setIsmirfs(Set ismirfs) {
        this.ismirfs = ismirfs;
    }

    public Set getIsmpmts() {
        return this.ismpmts;
    }

    public void setIsmpmts(Set ismpmts) {
        this.ismpmts = ismpmts;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("idmrfnum", getIdmrfnum())
            .toString();
    }

}
