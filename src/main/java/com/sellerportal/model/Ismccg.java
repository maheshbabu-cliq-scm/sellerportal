package com.sellerportal.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import org.apache.commons.lang.builder.ToStringBuilder;
import javax.persistence.*;

@Entity
@Table(name = "ISMCCG")
public class Ismccg implements Serializable {

	@Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ccgrfnum_sequence")
    @SequenceGenerator(name = "ccgrfnum_sequence", sequenceName = "IMSCCG_CCGRFNUM_SEQ", allocationSize = 1)
    @Column(name = "CCGRFNUM")
    private Long ccgrfnum;

    @Column(name = "CCGDESCRIPTION", length = 2048)
    private String ccgdescription;

    @Column(name = "CCGFLAGEVERYWHERE", length = 1)
    private String ccgflageverywhere;

    @Column(name = "CCGISADMIN", nullable = false, length = 1)
    private String ccgisadmin;

    @Column(name = "CCGNAME", nullable = false, length = 128)
    private String ccgname;

    @Column(name = "CREATEDATE", nullable = false)
    private Date createdate;

    @Column(name = "CREATEDBY", length = 20)
    private Long createdby;

    @Column(name = "DELETED", nullable = false, length = 1)
    private String deleted;

    @Column(name = "MODIDATE", nullable = false)
    private Date modidate;

    @Column(name = "CCGCODE", length = 32)
    private String ccgcode;

    @OneToMany(mappedBy = "ismccg", fetch = FetchType.LAZY)
    private Set<Ismppm> ismppms;

    @OneToMany(mappedBy = "ismccg", fetch = FetchType.LAZY)
    private Set<Ismccz> ismcczs;

    @OneToMany(mappedBy = "ismccg", fetch = FetchType.LAZY)
    private Set<Ismidc> ismidcs;

//    @OneToMany(mappedBy = "ismccg", fetch = FetchType.LAZY)
//    private Set<Ismpbi> ismpbis;

    /** full constructor */
    public Ismccg(String ccgdescription, String ccgflageverywhere, String ccgisadmin, String ccgname, Date createdate, Long createdby, String deleted, Date modidate,String ccgcode, Set<Ismppm> ismppms, Set<Ismccz> ismcczs, Set<Ismidc> ismidcs, Set<Ismpbi> ismpbis) {
        this.ccgdescription = ccgdescription;
        this.ccgflageverywhere = ccgflageverywhere;
        this.ccgisadmin = ccgisadmin;
        this.ccgname = ccgname;
        this.createdate = createdate;
        this.createdby = createdby;
        this.deleted = deleted;
        this.modidate = modidate;
        this.ccgcode = ccgcode;
        this.ismppms = ismppms;
        this.ismcczs = ismcczs;
//        this.ismsoms = ismsoms;
        this.ismidcs = ismidcs;
//        this.ismpbis = ismpbis;
//        this.ismlwts = ismlwts;
//        this.crmplcs = crmplcs;
    }

    /** default constructor */
    public Ismccg() {
    }

    /** minimal constructor */
    public Ismccg(String ccgisadmin, String ccgname, Date createdate, String deleted, Date modidate,Set<Ismppm> ismppms, Set<Ismccz> ismcczs, Set<Ismidc> ismidcs, Set<Ismpbi> ismpbis) {
        this.ccgisadmin = ccgisadmin;
        this.ccgname = ccgname;
        this.createdate = createdate;
        this.deleted = deleted;
        this.modidate = modidate;
        this.ismppms = ismppms;
        this.ismcczs = ismcczs;
//        this.ismsoms = ismsoms;
        this.ismidcs = ismidcs;
//        this.ismpbis = ismpbis;
//        this.ismlwts = ismlwts;
//        this.crmplcs = crmplcs;
    }

    /** 
     * 		       auto_increment
     * 		    
     */
    public Long getCcgrfnum() {
        return this.ccgrfnum;
    }

    public void setCcgrfnum(Long ccgrfnum) {
        this.ccgrfnum = ccgrfnum;
    }

    public String getCcgdescription() {
        return this.ccgdescription;
    }

    public void setCcgdescription(String ccgdescription) {
        this.ccgdescription = ccgdescription;
    }

    public String getCcgflageverywhere() {
        return this.ccgflageverywhere;
    }

    public void setCcgflageverywhere(String ccgflageverywhere) {
        this.ccgflageverywhere = ccgflageverywhere;
    }

    public String getCcgisadmin() {
        return this.ccgisadmin;
    }

    public void setCcgisadmin(String ccgisadmin) {
        this.ccgisadmin = ccgisadmin;
    }

    public String getCcgname() {
        return this.ccgname;
    }

    public void setCcgname(String ccgname) {
        this.ccgname = ccgname;
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
    public Set<Ismppm> getIsmppms() {
        return this.ismppms;
    }

    public void setIsmppms(Set<Ismppm> ismppms) {
        this.ismppms = ismppms;
    }

    public Set<Ismccz> getIsmcczs() {
        return this.ismcczs;
    }

    public void setIsmcczs(Set<Ismccz> ismcczs) {
        this.ismcczs = ismcczs;
    }

//    public Set getIsmsoms() {
//        return this.ismsoms;
//    }
//
//    public void setIsmsoms(Set ismsoms) {
//        this.ismsoms = ismsoms;
//    }

    public Set<Ismidc> getIsmidcs() {
        return this.ismidcs;
    }

    public void setIsmidcs(Set<Ismidc> ismidcs) {
        this.ismidcs = ismidcs;
    }

//    public Set<Ismpbi> getIsmpbis() {
//        return this.ismpbis;
//    }
//
//    public void setIsmpbis(Set<Ismpbi> ismpbis) {
//        this.ismpbis = ismpbis;
//    }

//    public Set getIsmlwts() {
//        return this.ismlwts;
//    }
//
//    public void setIsmlwts(Set ismlwts) {
//        this.ismlwts = ismlwts;
//    }
//
//    public Set getCrmplcs() {
//        return this.crmplcs;
//    }

//    public void setCrmplcs(Set crmplcs) {
//        this.crmplcs = crmplcs;
//    }
//    
    public String getCcgcode() {
		return ccgcode;
	}

	public void setCcgcode(String ccgcode) {
		this.ccgcode = ccgcode;
	}

	public String toString() {
        return new ToStringBuilder(this)
            .append("ccgrfnum", getCcgrfnum())
            .toString();
    }

}
