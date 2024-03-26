package com.sellerportal.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import org.apache.commons.lang3.builder.ToStringBuilder;

import javax.persistence.*;

@Entity
@Table(name = "ISMDEM")
public class Ismdem implements Serializable {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "DEMRFNUM")
    private Long demrfnum;

    @Column(name = "CREATEDATE", nullable = false)
    private Date createdate;

    @Column(name = "CREATEDBY", nullable = false, length = 20)
    private Long createdby;

    @Column(name = "DELETED", nullable = false, length = 1)
    private String deleted;

    @Column(name = "DEMCNDDSPENTITY", nullable = false, length = 20)
    private Long demcnddspentity;

    @Column(name = "DEMCNDTYPE", nullable = false, length = 20)
    private Long demcndtype;

    @Column(name = "DEMDESC", length = 2048)
    private String demdesc;

    @Column(name = "DEMFILENAME", nullable = false, length = 254)
    private String demfilename;

    @Column(name = "DEMNAME", nullable = false, length = 128)
    private String demname;

    @Column(name = "DEMPDTCSV", length = 1024)
    private String dempdtcsv;

    @Column(name = "DEMTHUMBNAIL", length = 254)
    private String demthumbnail;

    @Column(name = "MODIDATE", nullable = false)
    private Date modidate;

    @OneToMany(mappedBy = "ismdemByPetdemreviewbody", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Ismpet> ismpetsByPetdemreviewbody;

    @OneToMany(mappedBy = "ismdemByPetdemmgiftbody", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Ismpet> ismpetsByPetdemmgiftbody;

    @OneToMany(mappedBy = "ismdemByPetdemmaddbody", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Ismpet> ismpetsByPetdemmaddbody;

    @OneToMany(mappedBy = "ismdemByPetdemsaddbody", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Ismpet> ismpetsByPetdemsaddbody;

    @OneToMany(mappedBy = "ismdemByPetdempayoptbody", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Ismpet> ismpetsByPetdempayoptbody;
    
    @OneToMany(mappedBy = "ismdemByPetdemcartbody", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Ismpet> ismpetsByPetdemcartbody;

    @OneToMany(mappedBy = "ismdemByPetdemsuccessbody", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Ismpet> ismpetsByPetdemsuccessbody;

    @OneToMany(mappedBy = "ismdemByCcrprodfooter", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Ismccr> ismccrsByCcrprodfooter;

    @OneToMany(mappedBy = "ismdemByCcrcatebody", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Ismccr> ismccrsByCcrcatebody;

    @OneToMany(mappedBy = "ismdemByCcrprodheader", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Ismccr> ismccrsByCcrprodheader;

    @OneToMany(mappedBy = "ismdemByCcrprodbody", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Ismccr> ismccrsByCcrprodbody;

    @OneToMany(mappedBy = "ismdemByCcrcatefooter", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Ismccr> ismccrsByCcrcatefooter;

    @OneToMany(mappedBy = "ismdemByCcrcateheader", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Ismccr> ismccrsByCcrcateheader;

    @OneToMany(mappedBy = "ismdemByPccbody", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Ismpcc> ismpccsByPccbody;

    @OneToMany(mappedBy = "ismdemByPccheader", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Ismpcc> ismpccsByPccheader;

    @OneToMany(mappedBy = "ismdemByPccfooter", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Ismpcc> ismpccsByPccfooter;

    @OneToMany(mappedBy = "ismdemByMctcathead", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Ismmct> ismmctsByMctcathead;

    @OneToMany(mappedBy = "ismdemByMctsearchhead", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Ismmct> ismmctsByMctsearchhead;

    @OneToMany(mappedBy = "ismdemByMctindexbody", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Ismmct> ismmctsByMctindexbody;

    @OneToMany(mappedBy = "ismdemByMctcatbody", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Ismmct> ismmctsByMctcatbody;

    @OneToMany(mappedBy = "ismdemByMctprodhead", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Ismmct> ismmctsByMctprodhead;

    @OneToMany(mappedBy = "ismdemByMctsearchfoot", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Ismmct> ismmctsByMctsearchfoot;

    @OneToMany(mappedBy = "ismdemByMctindexhead", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Ismmct> ismmctsByMctindexhead;

    @OneToMany(mappedBy = "ismdemByMctindexfoot", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Ismmct> ismmctsByMctindexfoot;

    @OneToMany(mappedBy = "ismdemByMctcatfoot", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Ismmct> ismmctsByMctcatfoot;

    @OneToMany(mappedBy = "ismdemByMctsearcgbody", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Ismmct> ismmctsByMctsearcgbody;

    @OneToMany(mappedBy = "ismdemByMctprodbody", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Ismmct> ismmctsByMctprodbody;

    @OneToMany(mappedBy = "ismdemByMctprodfoot", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Ismmct> ismmctsByMctprodfoot;

    /** full constructor */
    public Ismdem(Date createdate, Long createdby, String deleted, Long demcnddspentity, Long demcndtype, String demdesc, String demfilename, String demname, String dempdtcsv, String demthumbnail, Date modidate, Set ismpetsByPetdemreviewbody, Set ismpetsByPetdemmgiftbody, Set ismpetsByPetdemmaddbody, Set ismpetsByPetdemsaddbody, Set ismpetsByPetdempayoptbody, Set ismpetsByPetdemcartbody, Set ismpetsByPetdemsuccessbody, Set ismccrsByCcrprodfooter, Set ismccrsByCcrcatebody, Set ismccrsByCcrprodheader, Set ismccrsByCcrprodbody, Set ismccrsByCcrcatefooter, Set ismccrsByCcrcateheader, Set ismpccsByPccbody, Set ismpccsByPccheader, Set ismpccsByPccfooter, Set ismmctsByMctcathead, Set ismmctsByMctsearchhead, Set ismmctsByMctindexbody, Set ismmctsByMctcatbody, Set ismmctsByMctprodhead, Set ismmctsByMctsearchfoot, Set ismmctsByMctindexhead, Set ismmctsByMctindexfoot, Set ismmctsByMctcatfoot, Set ismmctsByMctsearcgbody, Set ismmctsByMctprodbody, Set ismmctsByMctprodfoot) {
        this.createdate = createdate;
        this.createdby = createdby;
        this.deleted = deleted;
        this.demcnddspentity = demcnddspentity;
        this.demcndtype = demcndtype;
        this.demdesc = demdesc;
        this.demfilename = demfilename;
        this.demname = demname;
        this.dempdtcsv = dempdtcsv;
        this.demthumbnail = demthumbnail;
        this.modidate = modidate;
        this.ismpetsByPetdemreviewbody = ismpetsByPetdemreviewbody;
        this.ismpetsByPetdemmgiftbody = ismpetsByPetdemmgiftbody;
        this.ismpetsByPetdemmaddbody = ismpetsByPetdemmaddbody;
        this.ismpetsByPetdemsaddbody = ismpetsByPetdemsaddbody;
        this.ismpetsByPetdempayoptbody = ismpetsByPetdempayoptbody;
        this.ismpetsByPetdemcartbody = ismpetsByPetdemcartbody;
        this.ismpetsByPetdemsuccessbody = ismpetsByPetdemsuccessbody;
        this.ismccrsByCcrprodfooter = ismccrsByCcrprodfooter;
        this.ismccrsByCcrcatebody = ismccrsByCcrcatebody;
        this.ismccrsByCcrprodheader = ismccrsByCcrprodheader;
        this.ismccrsByCcrprodbody = ismccrsByCcrprodbody;
        this.ismccrsByCcrcatefooter = ismccrsByCcrcatefooter;
        this.ismccrsByCcrcateheader = ismccrsByCcrcateheader;
        this.ismpccsByPccbody = ismpccsByPccbody;
        this.ismpccsByPccheader = ismpccsByPccheader;
        this.ismpccsByPccfooter = ismpccsByPccfooter;
        this.ismmctsByMctcathead = ismmctsByMctcathead;
        this.ismmctsByMctsearchhead = ismmctsByMctsearchhead;
        this.ismmctsByMctindexbody = ismmctsByMctindexbody;
        this.ismmctsByMctcatbody = ismmctsByMctcatbody;
        this.ismmctsByMctprodhead = ismmctsByMctprodhead;
        this.ismmctsByMctsearchfoot = ismmctsByMctsearchfoot;
        this.ismmctsByMctindexhead = ismmctsByMctindexhead;
        this.ismmctsByMctindexfoot = ismmctsByMctindexfoot;
        this.ismmctsByMctcatfoot = ismmctsByMctcatfoot;
        this.ismmctsByMctsearcgbody = ismmctsByMctsearcgbody;
        this.ismmctsByMctprodbody = ismmctsByMctprodbody;
        this.ismmctsByMctprodfoot = ismmctsByMctprodfoot;
    }

    /** default constructor */
    public Ismdem() {
    }

    /** minimal constructor */
    public Ismdem(Date createdate, Long createdby, String deleted, Long demcnddspentity, Long demcndtype, String demfilename, String demname, Date modidate, Set ismpetsByPetdemreviewbody, Set ismpetsByPetdemmgiftbody, Set ismpetsByPetdemmaddbody, Set ismpetsByPetdemsaddbody, Set ismpetsByPetdempayoptbody, Set ismpetsByPetdemcartbody, Set ismpetsByPetdemsuccessbody, Set ismccrsByCcrprodfooter, Set ismccrsByCcrcatebody, Set ismccrsByCcrprodheader, Set ismccrsByCcrprodbody, Set ismccrsByCcrcatefooter, Set ismccrsByCcrcateheader, Set ismpccsByPccbody, Set ismpccsByPccheader, Set ismpccsByPccfooter, Set ismmctsByMctcathead, Set ismmctsByMctsearchhead, Set ismmctsByMctindexbody, Set ismmctsByMctcatbody, Set ismmctsByMctprodhead, Set ismmctsByMctsearchfoot, Set ismmctsByMctindexhead, Set ismmctsByMctindexfoot, Set ismmctsByMctcatfoot, Set ismmctsByMctsearcgbody, Set ismmctsByMctprodbody, Set ismmctsByMctprodfoot) {
        this.createdate = createdate;
        this.createdby = createdby;
        this.deleted = deleted;
        this.demcnddspentity = demcnddspentity;
        this.demcndtype = demcndtype;
        this.demfilename = demfilename;
        this.demname = demname;
        this.modidate = modidate;
        this.ismpetsByPetdemreviewbody = ismpetsByPetdemreviewbody;
        this.ismpetsByPetdemmgiftbody = ismpetsByPetdemmgiftbody;
        this.ismpetsByPetdemmaddbody = ismpetsByPetdemmaddbody;
        this.ismpetsByPetdemsaddbody = ismpetsByPetdemsaddbody;
        this.ismpetsByPetdempayoptbody = ismpetsByPetdempayoptbody;
        this.ismpetsByPetdemcartbody = ismpetsByPetdemcartbody;
        this.ismpetsByPetdemsuccessbody = ismpetsByPetdemsuccessbody;
        this.ismccrsByCcrprodfooter = ismccrsByCcrprodfooter;
        this.ismccrsByCcrcatebody = ismccrsByCcrcatebody;
        this.ismccrsByCcrprodheader = ismccrsByCcrprodheader;
        this.ismccrsByCcrprodbody = ismccrsByCcrprodbody;
        this.ismccrsByCcrcatefooter = ismccrsByCcrcatefooter;
        this.ismccrsByCcrcateheader = ismccrsByCcrcateheader;
        this.ismpccsByPccbody = ismpccsByPccbody;
        this.ismpccsByPccheader = ismpccsByPccheader;
        this.ismpccsByPccfooter = ismpccsByPccfooter;
        this.ismmctsByMctcathead = ismmctsByMctcathead;
        this.ismmctsByMctsearchhead = ismmctsByMctsearchhead;
        this.ismmctsByMctindexbody = ismmctsByMctindexbody;
        this.ismmctsByMctcatbody = ismmctsByMctcatbody;
        this.ismmctsByMctprodhead = ismmctsByMctprodhead;
        this.ismmctsByMctsearchfoot = ismmctsByMctsearchfoot;
        this.ismmctsByMctindexhead = ismmctsByMctindexhead;
        this.ismmctsByMctindexfoot = ismmctsByMctindexfoot;
        this.ismmctsByMctcatfoot = ismmctsByMctcatfoot;
        this.ismmctsByMctsearcgbody = ismmctsByMctsearcgbody;
        this.ismmctsByMctprodbody = ismmctsByMctprodbody;
        this.ismmctsByMctprodfoot = ismmctsByMctprodfoot;
    }

    /** 
     * 		       auto_increment
     * 		    
     */
    public Long getDemrfnum() {
        return this.demrfnum;
    }

    public void setDemrfnum(Long demrfnum) {
        this.demrfnum = demrfnum;
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

    public Long getDemcnddspentity() {
        return this.demcnddspentity;
    }

    public void setDemcnddspentity(Long demcnddspentity) {
        this.demcnddspentity = demcnddspentity;
    }

    public Long getDemcndtype() {
        return this.demcndtype;
    }

    public void setDemcndtype(Long demcndtype) {
        this.demcndtype = demcndtype;
    }

    public String getDemdesc() {
        return this.demdesc;
    }

    public void setDemdesc(String demdesc) {
        this.demdesc = demdesc;
    }

    public String getDemfilename() {
        return this.demfilename;
    }

    public void setDemfilename(String demfilename) {
        this.demfilename = demfilename;
    }

    public String getDemname() {
        return this.demname;
    }

    public void setDemname(String demname) {
        this.demname = demname;
    }

    public String getDempdtcsv() {
        return this.dempdtcsv;
    }

    public void setDempdtcsv(String dempdtcsv) {
        this.dempdtcsv = dempdtcsv;
    }

    public String getDemthumbnail() {
        return this.demthumbnail;
    }

    public void setDemthumbnail(String demthumbnail) {
        this.demthumbnail = demthumbnail;
    }

    public Date getModidate() {
        return this.modidate;
    }

    public void setModidate(Date modidate) {
        this.modidate = modidate;
    }

    public Set getIsmpetsByPetdemreviewbody() {
        return this.ismpetsByPetdemreviewbody;
    }

    public void setIsmpetsByPetdemreviewbody(Set ismpetsByPetdemreviewbody) {
        this.ismpetsByPetdemreviewbody = ismpetsByPetdemreviewbody;
    }

    public Set getIsmpetsByPetdemmgiftbody() {
        return this.ismpetsByPetdemmgiftbody;
    }

    public void setIsmpetsByPetdemmgiftbody(Set ismpetsByPetdemmgiftbody) {
        this.ismpetsByPetdemmgiftbody = ismpetsByPetdemmgiftbody;
    }

    public Set getIsmpetsByPetdemmaddbody() {
        return this.ismpetsByPetdemmaddbody;
    }

    public void setIsmpetsByPetdemmaddbody(Set ismpetsByPetdemmaddbody) {
        this.ismpetsByPetdemmaddbody = ismpetsByPetdemmaddbody;
    }

    public Set getIsmpetsByPetdemsaddbody() {
        return this.ismpetsByPetdemsaddbody;
    }

    public void setIsmpetsByPetdemsaddbody(Set ismpetsByPetdemsaddbody) {
        this.ismpetsByPetdemsaddbody = ismpetsByPetdemsaddbody;
    }

    public Set getIsmpetsByPetdempayoptbody() {
        return this.ismpetsByPetdempayoptbody;
    }

    public void setIsmpetsByPetdempayoptbody(Set ismpetsByPetdempayoptbody) {
        this.ismpetsByPetdempayoptbody = ismpetsByPetdempayoptbody;
    }

    public Set getIsmpetsByPetdemcartbody() {
        return this.ismpetsByPetdemcartbody;
    }

    public void setIsmpetsByPetdemcartbody(Set ismpetsByPetdemcartbody) {
        this.ismpetsByPetdemcartbody = ismpetsByPetdemcartbody;
    }

    public Set getIsmpetsByPetdemsuccessbody() {
        return this.ismpetsByPetdemsuccessbody;
    }

    public void setIsmpetsByPetdemsuccessbody(Set ismpetsByPetdemsuccessbody) {
        this.ismpetsByPetdemsuccessbody = ismpetsByPetdemsuccessbody;
    }

    public Set getIsmccrsByCcrprodfooter() {
        return this.ismccrsByCcrprodfooter;
    }

    public void setIsmccrsByCcrprodfooter(Set ismccrsByCcrprodfooter) {
        this.ismccrsByCcrprodfooter = ismccrsByCcrprodfooter;
    }

    public Set getIsmccrsByCcrcatebody() {
        return this.ismccrsByCcrcatebody;
    }

    public void setIsmccrsByCcrcatebody(Set ismccrsByCcrcatebody) {
        this.ismccrsByCcrcatebody = ismccrsByCcrcatebody;
    }

    public Set getIsmccrsByCcrprodheader() {
        return this.ismccrsByCcrprodheader;
    }

    public void setIsmccrsByCcrprodheader(Set ismccrsByCcrprodheader) {
        this.ismccrsByCcrprodheader = ismccrsByCcrprodheader;
    }

    public Set getIsmccrsByCcrprodbody() {
        return this.ismccrsByCcrprodbody;
    }

    public void setIsmccrsByCcrprodbody(Set ismccrsByCcrprodbody) {
        this.ismccrsByCcrprodbody = ismccrsByCcrprodbody;
    }

    public Set getIsmccrsByCcrcatefooter() {
        return this.ismccrsByCcrcatefooter;
    }

    public void setIsmccrsByCcrcatefooter(Set ismccrsByCcrcatefooter) {
        this.ismccrsByCcrcatefooter = ismccrsByCcrcatefooter;
    }

    public Set getIsmccrsByCcrcateheader() {
        return this.ismccrsByCcrcateheader;
    }

    public void setIsmccrsByCcrcateheader(Set ismccrsByCcrcateheader) {
        this.ismccrsByCcrcateheader = ismccrsByCcrcateheader;
    }

    public Set getIsmpccsByPccbody() {
        return this.ismpccsByPccbody;
    }

    public void setIsmpccsByPccbody(Set ismpccsByPccbody) {
        this.ismpccsByPccbody = ismpccsByPccbody;
    }

    public Set getIsmpccsByPccheader() {
        return this.ismpccsByPccheader;
    }

    public void setIsmpccsByPccheader(Set ismpccsByPccheader) {
        this.ismpccsByPccheader = ismpccsByPccheader;
    }

    public Set getIsmpccsByPccfooter() {
        return this.ismpccsByPccfooter;
    }

    public void setIsmpccsByPccfooter(Set ismpccsByPccfooter) {
        this.ismpccsByPccfooter = ismpccsByPccfooter;
    }

    public Set getIsmmctsByMctcathead() {
        return this.ismmctsByMctcathead;
    }

    public void setIsmmctsByMctcathead(Set ismmctsByMctcathead) {
        this.ismmctsByMctcathead = ismmctsByMctcathead;
    }

    public Set getIsmmctsByMctsearchhead() {
        return this.ismmctsByMctsearchhead;
    }

    public void setIsmmctsByMctsearchhead(Set ismmctsByMctsearchhead) {
        this.ismmctsByMctsearchhead = ismmctsByMctsearchhead;
    }

    public Set getIsmmctsByMctindexbody() {
        return this.ismmctsByMctindexbody;
    }

    public void setIsmmctsByMctindexbody(Set ismmctsByMctindexbody) {
        this.ismmctsByMctindexbody = ismmctsByMctindexbody;
    }

    public Set getIsmmctsByMctcatbody() {
        return this.ismmctsByMctcatbody;
    }

    public void setIsmmctsByMctcatbody(Set ismmctsByMctcatbody) {
        this.ismmctsByMctcatbody = ismmctsByMctcatbody;
    }

    public Set getIsmmctsByMctprodhead() {
        return this.ismmctsByMctprodhead;
    }

    public void setIsmmctsByMctprodhead(Set ismmctsByMctprodhead) {
        this.ismmctsByMctprodhead = ismmctsByMctprodhead;
    }

    public Set getIsmmctsByMctsearchfoot() {
        return this.ismmctsByMctsearchfoot;
    }

    public void setIsmmctsByMctsearchfoot(Set ismmctsByMctsearchfoot) {
        this.ismmctsByMctsearchfoot = ismmctsByMctsearchfoot;
    }

    public Set getIsmmctsByMctindexhead() {
        return this.ismmctsByMctindexhead;
    }

    public void setIsmmctsByMctindexhead(Set ismmctsByMctindexhead) {
        this.ismmctsByMctindexhead = ismmctsByMctindexhead;
    }

    public Set getIsmmctsByMctindexfoot() {
        return this.ismmctsByMctindexfoot;
    }

    public void setIsmmctsByMctindexfoot(Set ismmctsByMctindexfoot) {
        this.ismmctsByMctindexfoot = ismmctsByMctindexfoot;
    }

    public Set getIsmmctsByMctcatfoot() {
        return this.ismmctsByMctcatfoot;
    }

    public void setIsmmctsByMctcatfoot(Set ismmctsByMctcatfoot) {
        this.ismmctsByMctcatfoot = ismmctsByMctcatfoot;
    }

    public Set getIsmmctsByMctsearcgbody() {
        return this.ismmctsByMctsearcgbody;
    }

    public void setIsmmctsByMctsearcgbody(Set ismmctsByMctsearcgbody) {
        this.ismmctsByMctsearcgbody = ismmctsByMctsearcgbody;
    }

    public Set getIsmmctsByMctprodbody() {
        return this.ismmctsByMctprodbody;
    }

    public void setIsmmctsByMctprodbody(Set ismmctsByMctprodbody) {
        this.ismmctsByMctprodbody = ismmctsByMctprodbody;
    }

    public Set getIsmmctsByMctprodfoot() {
        return this.ismmctsByMctprodfoot;
    }

    public void setIsmmctsByMctprodfoot(Set ismmctsByMctprodfoot) {
        this.ismmctsByMctprodfoot = ismmctsByMctprodfoot;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("demrfnum", getDemrfnum())
            .toString();
    }

}
