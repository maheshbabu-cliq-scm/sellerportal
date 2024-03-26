package com.sellerportal.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import org.apache.commons.lang3.builder.ToStringBuilder;
import javax.persistence.*;

@Entity
@Table(name = "ISMPET")
public class Ismpet implements Serializable {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PETRFNUM")
    private Long petrfnum;

    @Column(name = "PETBANNER", length = 254)
    private String petbanner;

    @Column(name = "PETCHECKOUTFOOTER", length = 254)
    private String petcheckoutfooter;

    @Column(name = "PETCHECKOUTHEADER", length = 254)
    private String petcheckoutheader;

    @Column(name = "PETCNDPARTTYPE", length = 20)
    private Long petcndparttype;

    @Column(name = "PETCREATEDATE", nullable = false)
    private Date petcreatedate;

    @Column(name = "PETCREATEDBY", nullable = false, length = 20)
    private Long petcreatedby;

    @Column(name = "PETDELETED", nullable = false, length = 1)
    private String petdeleted;

    @Column(name = "PETFOOTER", length = 254)
    private String petfooter;

    @Column(name = "PETHEADER", length = 254)
    private String petheader;

    @Column(name = "PETMODIFYDATE", nullable = false)
    private Date petmodifydate;

    @ManyToOne
    @JoinColumn(name = "PETDEMREVIEWBODY", nullable = false)
    private Ismdem ismdemByPetdemreviewbody;

    @ManyToOne
    @JoinColumn(name = "PETDEMMGIFTBODY", nullable = false)
    private Ismdem ismdemByPetdemmgiftbody;

    @ManyToOne
    @JoinColumn(name = "PETDEMMADDBODY", nullable = false)
    private Ismdem ismdemByPetdemmaddbody;

    @ManyToOne
    @JoinColumn(name = "PETDEMSADDBODY", nullable = false)
    private Ismdem ismdemByPetdemsaddbody;

    @ManyToOne
    @JoinColumn(name = "PETDEMPAYOPTBODY", nullable = false)
    private Ismdem ismdemByPetdempayoptbody;

    @ManyToOne
    @JoinColumn(name = "PETDEMCARTBODY", nullable = false)
    private Ismdem ismdemByPetdemcartbody;

    @ManyToOne
    @JoinColumn(name = "PETDEMSUCCESSBODY", nullable = false)
    private Ismdem ismdemByPetdemsuccessbody;

    @ManyToOne
    @JoinColumn(name = "PETIDMGETUSERPROFILE", nullable = false)
    private Ismidm ismidmByPetidmgetuserprofile;

    @ManyToOne
    @JoinColumn(name = "PETIDMAUTHENTICATE", nullable = false)
    private Ismidm ismidmByPetidmauthenticate;

    @ManyToOne
    @JoinColumn(name = "PETIDMCREDITPOINT", nullable = false)
    private Ismidm ismidmByPetidmcreditpoint;

    @ManyToOne
    @JoinColumn(name = "PETIDMPOINTREDEM", nullable = false)
    private Ismidm ismidmByPetidmpointredem;

    @ManyToOne
    @JoinColumn(name = "PETIDMREGISTER", nullable = false)
    private Ismidm ismidmByPetidmregister;

    @ManyToOne
    @JoinColumn(name = "PETIDMCHANGEPASSWORD", nullable = false)
    private Ismidm ismidmByPetidmchangepassword;

    @ManyToOne
    @JoinColumn(name = "PETIDMUSRLYLTPTS", nullable = false)
    private Ismidm ismidmByPetidmusrlyltpts;

    @ManyToOne
    @JoinColumn(name = "PETIDMGETPASSWORD", nullable = false)
    private Ismidm ismidmByPetidmgetpassword;

    @ManyToOne
    @JoinColumn(name = "PETIDMCHECKUSEREXIST", nullable = false)
    private Ismidm ismidmByPetidmcheckuserexist;

    @OneToMany(mappedBy = "ismpet",  fetch = FetchType.LAZY)
    private Set<Ismafm> ismafms;

    @OneToMany(mappedBy = "ismpet",fetch = FetchType.LAZY)
    private Set<Octiat> octiats;


//    /** persistent field */
//    private Set ismscls;

    @OneToMany(mappedBy = "ismpet",  fetch = FetchType.LAZY)
    private Set<Ismmct> ismmcts;

    /** full constructor */
    public Ismpet(String petbanner, String petcheckoutfooter, String petcheckoutheader, Long petcndparttype, Date petcreatedate, Long petcreatedby, String petdeleted, String petfooter, String petheader, Date petmodifydate, com.sellerportal.model.Ismdem ismdemByPetdemreviewbody, com.sellerportal.model.Ismdem ismdemByPetdemmgiftbody, com.sellerportal.model.Ismdem ismdemByPetdemmaddbody, com.sellerportal.model.Ismdem ismdemByPetdemsaddbody, com.sellerportal.model.Ismdem ismdemByPetdempayoptbody, com.sellerportal.model.Ismdem ismdemByPetdemcartbody, com.sellerportal.model.Ismdem ismdemByPetdemsuccessbody, com.sellerportal.model.Ismidm ismidmByPetidmgetuserprofile, com.sellerportal.model.Ismidm ismidmByPetidmauthenticate, com.sellerportal.model.Ismidm ismidmByPetidmcreditpoint, com.sellerportal.model.Ismidm ismidmByPetidmpointredem, com.sellerportal.model.Ismidm ismidmByPetidmregister, com.sellerportal.model.Ismidm ismidmByPetidmchangepassword, com.sellerportal.model.Ismidm ismidmByPetidmusrlyltpts, com.sellerportal.model.Ismidm ismidmByPetidmgetpassword, com.sellerportal.model.Ismidm ismidmByPetidmcheckuserexist, Set ismafms, Set octiats, Set ismscls, Set ismmcts) {
        this.petbanner = petbanner;
        this.petcheckoutfooter = petcheckoutfooter;
        this.petcheckoutheader = petcheckoutheader;
        this.petcndparttype = petcndparttype;
        this.petcreatedate = petcreatedate;
        this.petcreatedby = petcreatedby;
        this.petdeleted = petdeleted;
        this.petfooter = petfooter;
        this.petheader = petheader;
        this.petmodifydate = petmodifydate;
        this.ismdemByPetdemreviewbody = ismdemByPetdemreviewbody;
        this.ismdemByPetdemmgiftbody = ismdemByPetdemmgiftbody;
        this.ismdemByPetdemmaddbody = ismdemByPetdemmaddbody;
        this.ismdemByPetdemsaddbody = ismdemByPetdemsaddbody;
        this.ismdemByPetdempayoptbody = ismdemByPetdempayoptbody;
        this.ismdemByPetdemcartbody = ismdemByPetdemcartbody;
        this.ismdemByPetdemsuccessbody = ismdemByPetdemsuccessbody;
        this.ismidmByPetidmgetuserprofile = ismidmByPetidmgetuserprofile;
        this.ismidmByPetidmauthenticate = ismidmByPetidmauthenticate;
        this.ismidmByPetidmcreditpoint = ismidmByPetidmcreditpoint;
        this.ismidmByPetidmpointredem = ismidmByPetidmpointredem;
        this.ismidmByPetidmregister = ismidmByPetidmregister;
        this.ismidmByPetidmchangepassword = ismidmByPetidmchangepassword;
        this.ismidmByPetidmusrlyltpts = ismidmByPetidmusrlyltpts;
        this.ismidmByPetidmgetpassword = ismidmByPetidmgetpassword;
        this.ismidmByPetidmcheckuserexist = ismidmByPetidmcheckuserexist;
        this.ismafms = ismafms;
        this.octiats = octiats;
//        this.ismscls = ismscls;
        this.ismmcts = ismmcts;
    }

    /** default constructor */
    public Ismpet() {
    }

    /** minimal constructor */
    public Ismpet(Date petcreatedate, Long petcreatedby, String petdeleted, Date petmodifydate, com.sellerportal.model.Ismdem ismdemByPetdemreviewbody, com.sellerportal.model.Ismdem ismdemByPetdemmgiftbody, com.sellerportal.model.Ismdem ismdemByPetdemmaddbody, com.sellerportal.model.Ismdem ismdemByPetdemsaddbody, com.sellerportal.model.Ismdem ismdemByPetdempayoptbody, com.sellerportal.model.Ismdem ismdemByPetdemcartbody, com.sellerportal.model.Ismdem ismdemByPetdemsuccessbody, com.sellerportal.model.Ismidm ismidmByPetidmgetuserprofile, com.sellerportal.model.Ismidm ismidmByPetidmauthenticate, com.sellerportal.model.Ismidm ismidmByPetidmcreditpoint, com.sellerportal.model.Ismidm ismidmByPetidmpointredem, com.sellerportal.model.Ismidm ismidmByPetidmregister, com.sellerportal.model.Ismidm ismidmByPetidmchangepassword, com.sellerportal.model.Ismidm ismidmByPetidmusrlyltpts, com.sellerportal.model.Ismidm ismidmByPetidmgetpassword, com.sellerportal.model.Ismidm ismidmByPetidmcheckuserexist, Set ismafms, Set octiats, Set ismscls, Set ismmcts) {
        this.petcreatedate = petcreatedate;
        this.petcreatedby = petcreatedby;
        this.petdeleted = petdeleted;
        this.petmodifydate = petmodifydate;
        this.ismdemByPetdemreviewbody = ismdemByPetdemreviewbody;
        this.ismdemByPetdemmgiftbody = ismdemByPetdemmgiftbody;
        this.ismdemByPetdemmaddbody = ismdemByPetdemmaddbody;
        this.ismdemByPetdemsaddbody = ismdemByPetdemsaddbody;
        this.ismdemByPetdempayoptbody = ismdemByPetdempayoptbody;
        this.ismdemByPetdemcartbody = ismdemByPetdemcartbody;
        this.ismdemByPetdemsuccessbody = ismdemByPetdemsuccessbody;
        this.ismidmByPetidmgetuserprofile = ismidmByPetidmgetuserprofile;
        this.ismidmByPetidmauthenticate = ismidmByPetidmauthenticate;
        this.ismidmByPetidmcreditpoint = ismidmByPetidmcreditpoint;
        this.ismidmByPetidmpointredem = ismidmByPetidmpointredem;
        this.ismidmByPetidmregister = ismidmByPetidmregister;
        this.ismidmByPetidmchangepassword = ismidmByPetidmchangepassword;
        this.ismidmByPetidmusrlyltpts = ismidmByPetidmusrlyltpts;
        this.ismidmByPetidmgetpassword = ismidmByPetidmgetpassword;
        this.ismidmByPetidmcheckuserexist = ismidmByPetidmcheckuserexist;
        this.ismafms = ismafms;
        this.octiats = octiats;
//        this.ismscls = ismscls;
        this.ismmcts = ismmcts;
    }

    /** 
     * 		       auto_increment
     * 		    
     */
    public Long getPetrfnum() {
        return this.petrfnum;
    }

    public void setPetrfnum(Long petrfnum) {
        this.petrfnum = petrfnum;
    }

    public String getPetbanner() {
        return this.petbanner;
    }

    public void setPetbanner(String petbanner) {
        this.petbanner = petbanner;
    }

    public String getPetcheckoutfooter() {
        return this.petcheckoutfooter;
    }

    public void setPetcheckoutfooter(String petcheckoutfooter) {
        this.petcheckoutfooter = petcheckoutfooter;
    }

    public String getPetcheckoutheader() {
        return this.petcheckoutheader;
    }

    public void setPetcheckoutheader(String petcheckoutheader) {
        this.petcheckoutheader = petcheckoutheader;
    }

    public Long getPetcndparttype() {
        return this.petcndparttype;
    }

    public void setPetcndparttype(Long petcndparttype) {
        this.petcndparttype = petcndparttype;
    }

    public Date getPetcreatedate() {
        return this.petcreatedate;
    }

    public void setPetcreatedate(Date petcreatedate) {
        this.petcreatedate = petcreatedate;
    }

    public Long getPetcreatedby() {
        return this.petcreatedby;
    }

    public void setPetcreatedby(Long petcreatedby) {
        this.petcreatedby = petcreatedby;
    }

    public String getPetdeleted() {
        return this.petdeleted;
    }

    public void setPetdeleted(String petdeleted) {
        this.petdeleted = petdeleted;
    }

    public String getPetfooter() {
        return this.petfooter;
    }

    public void setPetfooter(String petfooter) {
        this.petfooter = petfooter;
    }

    public String getPetheader() {
        return this.petheader;
    }

    public void setPetheader(String petheader) {
        this.petheader = petheader;
    }

    public Date getPetmodifydate() {
        return this.petmodifydate;
    }

    public void setPetmodifydate(Date petmodifydate) {
        this.petmodifydate = petmodifydate;
    }

    public com.sellerportal.model.Ismdem getIsmdemByPetdemreviewbody() {
        return this.ismdemByPetdemreviewbody;
    }

    public void setIsmdemByPetdemreviewbody(com.sellerportal.model.Ismdem ismdemByPetdemreviewbody) {
        this.ismdemByPetdemreviewbody = ismdemByPetdemreviewbody;
    }

    public com.sellerportal.model.Ismdem getIsmdemByPetdemmgiftbody() {
        return this.ismdemByPetdemmgiftbody;
    }

    public void setIsmdemByPetdemmgiftbody(com.sellerportal.model.Ismdem ismdemByPetdemmgiftbody) {
        this.ismdemByPetdemmgiftbody = ismdemByPetdemmgiftbody;
    }

    public com.sellerportal.model.Ismdem getIsmdemByPetdemmaddbody() {
        return this.ismdemByPetdemmaddbody;
    }

    public void setIsmdemByPetdemmaddbody(com.sellerportal.model.Ismdem ismdemByPetdemmaddbody) {
        this.ismdemByPetdemmaddbody = ismdemByPetdemmaddbody;
    }

    public com.sellerportal.model.Ismdem getIsmdemByPetdemsaddbody() {
        return this.ismdemByPetdemsaddbody;
    }

    public void setIsmdemByPetdemsaddbody(com.sellerportal.model.Ismdem ismdemByPetdemsaddbody) {
        this.ismdemByPetdemsaddbody = ismdemByPetdemsaddbody;
    }

    public com.sellerportal.model.Ismdem getIsmdemByPetdempayoptbody() {
        return this.ismdemByPetdempayoptbody;
    }

    public void setIsmdemByPetdempayoptbody(com.sellerportal.model.Ismdem ismdemByPetdempayoptbody) {
        this.ismdemByPetdempayoptbody = ismdemByPetdempayoptbody;
    }

    public com.sellerportal.model.Ismdem getIsmdemByPetdemcartbody() {
        return this.ismdemByPetdemcartbody;
    }

    public void setIsmdemByPetdemcartbody(com.sellerportal.model.Ismdem ismdemByPetdemcartbody) {
        this.ismdemByPetdemcartbody = ismdemByPetdemcartbody;
    }

    public com.sellerportal.model.Ismdem getIsmdemByPetdemsuccessbody() {
        return this.ismdemByPetdemsuccessbody;
    }

    public void setIsmdemByPetdemsuccessbody(com.sellerportal.model.Ismdem ismdemByPetdemsuccessbody) {
        this.ismdemByPetdemsuccessbody = ismdemByPetdemsuccessbody;
    }

    public com.sellerportal.model.Ismidm getIsmidmByPetidmgetuserprofile() {
        return this.ismidmByPetidmgetuserprofile;
    }

    public void setIsmidmByPetidmgetuserprofile(com.sellerportal.model.Ismidm ismidmByPetidmgetuserprofile) {
        this.ismidmByPetidmgetuserprofile = ismidmByPetidmgetuserprofile;
    }

    public com.sellerportal.model.Ismidm getIsmidmByPetidmauthenticate() {
        return this.ismidmByPetidmauthenticate;
    }

    public void setIsmidmByPetidmauthenticate(com.sellerportal.model.Ismidm ismidmByPetidmauthenticate) {
        this.ismidmByPetidmauthenticate = ismidmByPetidmauthenticate;
    }

    public com.sellerportal.model.Ismidm getIsmidmByPetidmcreditpoint() {
        return this.ismidmByPetidmcreditpoint;
    }

    public void setIsmidmByPetidmcreditpoint(com.sellerportal.model.Ismidm ismidmByPetidmcreditpoint) {
        this.ismidmByPetidmcreditpoint = ismidmByPetidmcreditpoint;
    }

    public com.sellerportal.model.Ismidm getIsmidmByPetidmpointredem() {
        return this.ismidmByPetidmpointredem;
    }

    public void setIsmidmByPetidmpointredem(com.sellerportal.model.Ismidm ismidmByPetidmpointredem) {
        this.ismidmByPetidmpointredem = ismidmByPetidmpointredem;
    }

    public com.sellerportal.model.Ismidm getIsmidmByPetidmregister() {
        return this.ismidmByPetidmregister;
    }

    public void setIsmidmByPetidmregister(com.sellerportal.model.Ismidm ismidmByPetidmregister) {
        this.ismidmByPetidmregister = ismidmByPetidmregister;
    }

    public com.sellerportal.model.Ismidm getIsmidmByPetidmchangepassword() {
        return this.ismidmByPetidmchangepassword;
    }

    public void setIsmidmByPetidmchangepassword(com.sellerportal.model.Ismidm ismidmByPetidmchangepassword) {
        this.ismidmByPetidmchangepassword = ismidmByPetidmchangepassword;
    }

    public com.sellerportal.model.Ismidm getIsmidmByPetidmusrlyltpts() {
        return this.ismidmByPetidmusrlyltpts;
    }

    public void setIsmidmByPetidmusrlyltpts(com.sellerportal.model.Ismidm ismidmByPetidmusrlyltpts) {
        this.ismidmByPetidmusrlyltpts = ismidmByPetidmusrlyltpts;
    }

    public com.sellerportal.model.Ismidm getIsmidmByPetidmgetpassword() {
        return this.ismidmByPetidmgetpassword;
    }

    public void setIsmidmByPetidmgetpassword(com.sellerportal.model.Ismidm ismidmByPetidmgetpassword) {
        this.ismidmByPetidmgetpassword = ismidmByPetidmgetpassword;
    }

    public com.sellerportal.model.Ismidm getIsmidmByPetidmcheckuserexist() {
        return this.ismidmByPetidmcheckuserexist;
    }

    public void setIsmidmByPetidmcheckuserexist(com.sellerportal.model.Ismidm ismidmByPetidmcheckuserexist) {
        this.ismidmByPetidmcheckuserexist = ismidmByPetidmcheckuserexist;
    }

    public Set getIsmafms() {
        return this.ismafms;
    }

    public void setIsmafms(Set ismafms) {
        this.ismafms = ismafms;
    }

    public Set getOctiats() {
        return this.octiats;
    }

    public void setOctiats(Set octiats) {
        this.octiats = octiats;
    }

//    public Set getIsmscls() {
//        return this.ismscls;
//    }
//
//    public void setIsmscls(Set ismscls) {
//        this.ismscls = ismscls;
//    }

    public Set getIsmmcts() {
        return this.ismmcts;
    }

    public void setIsmmcts(Set ismmcts) {
        this.ismmcts = ismmcts;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("petrfnum", getPetrfnum())
            .toString();
    }

}
