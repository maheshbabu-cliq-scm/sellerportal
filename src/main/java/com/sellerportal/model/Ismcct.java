package com.sellerportal.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.*;

import org.apache.commons.lang3.builder.ToStringBuilder;


@Entity
@Table(name = "ISMCCT")
public class Ismcct implements Serializable {

	@Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ismcct_seq_generator")
    @SequenceGenerator(name = "ismcct_seq_generator", sequenceName = "ISMCCT_CCTNCODE_SEQ", allocationSize = 1)
    @Column(name = "CCTNCODE")
    private Long cctncode;

	@Column(name = "CCTACODE", nullable = false, length = 3)
    private String cctacode;

    @Column(name = "CCTEXPONENT", nullable = false)
    private Integer cctexponent;

    @Column(name = "CCTNOTE", length = 50)
    private String cctnote;

    @Column(name = "CCTSYMBOL", length = 10)
    private String cctsymbol;

    @Column(name = "CREATEDATE", nullable = false)
    private Date createdate;

    @Column(name = "CREATEDBY", nullable = false)
    private Long createdby;

    @Column(name = "DELETED", nullable = false, length = 1)
    private String deleted;

    @Column(name = "MODIDATE", nullable = false)
    private Date modidate;

//    @OneToMany(mappedBy = "ismcct", fetch = FetchType.LAZY)
//    private Set<Ismpot> ismpots;

    @OneToMany(mappedBy = "ismcctByCcmfromcurr", fetch = FetchType.LAZY)
    private Set<Ismccm> ismccmsByCcmfromcurr;

    @OneToMany(mappedBy = "ismcctByCcmtocurr", fetch = FetchType.LAZY)
    private Set<Ismccm> ismccmsByCcmtocurr;

//    /** persistent field */
//    private Set ismsoms;
//
//    /** persistent field */
//    private Set ismscls;

//    @OneToMany(mappedBy = "pbicctrfnum", fetch = FetchType.LAZY)
//    private Set<Ismpbi> ismpbis;
//
//    @OneToMany(mappedBy = "ubicctrfnum", fetch = FetchType.LAZY)
//    private Set<Ismubi> ismubis;

//    /** persistent field */
//    private Set ismgcms;

    

    /** full constructor */
    public Ismcct(String cctacode, Integer cctexponent, String cctnote, String cctsymbol, Date createdate, Long createdby, String deleted, Date modidate, Set ismpots, Set ismccmsByCcmfromcurr, Set ismccmsByCcmtocurr, Set ismsoms, Set ismscls, Set ismpbis, Set ismgcms, Set ismubis) {
        this.cctacode = cctacode;
        this.cctexponent = cctexponent;
        this.cctnote = cctnote;
        this.cctsymbol = cctsymbol;
        this.createdate = createdate;
        this.createdby = createdby;
        this.deleted = deleted;
        this.modidate = modidate;
//        this.ismpots = ismpots;
        this.ismccmsByCcmfromcurr = ismccmsByCcmfromcurr;
        this.ismccmsByCcmtocurr = ismccmsByCcmtocurr;
//        this.ismsoms = ismsoms;
//        this.ismscls = ismscls;
//        this.ismpbis = ismpbis;
//        this.ismgcms = ismgcms;
//        this.ismubis = ismubis;
    }

    /** default constructor */
    public Ismcct() {
    }

    /** minimal constructor */
    public Ismcct(String cctacode, Integer cctexponent, Date createdate, Long createdby, String deleted, Date modidate, Set ismpots, Set ismccmsByCcmfromcurr, Set ismccmsByCcmtocurr, Set ismsoms, Set ismscls, Set ismpbis, Set ismgcms, Set ismubis) {
        this.cctacode = cctacode;
        this.cctexponent = cctexponent;
        this.createdate = createdate;
        this.createdby = createdby;
        this.deleted = deleted;
        this.modidate = modidate;
//        this.ismpots = ismpots;
        this.ismccmsByCcmfromcurr = ismccmsByCcmfromcurr;
        this.ismccmsByCcmtocurr = ismccmsByCcmtocurr;
//        this.ismsoms = ismsoms;
//        this.ismscls = ismscls;
//        this.ismpbis = ismpbis;
//        this.ismgcms = ismgcms;
//        this.ismubis = ismubis;
    }

    public Long getCctncode() {
        return this.cctncode;
    }

    public void setCctncode(Long cctncode) {
        this.cctncode = cctncode;
    }

    public String getCctacode() {
        return this.cctacode;
    }

    public void setCctacode(String cctacode) {
        this.cctacode = cctacode;
    }

    public Integer getCctexponent() {
        return this.cctexponent;
    }

    public void setCctexponent(Integer cctexponent) {
        this.cctexponent = cctexponent;
    }

    public String getCctnote() {
        return this.cctnote;
    }

    public void setCctnote(String cctnote) {
        this.cctnote = cctnote;
    }

    public String getCctsymbol() {
        return this.cctsymbol;
    }

    public void setCctsymbol(String cctsymbol) {
        this.cctsymbol = cctsymbol;
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

//    public Set getIsmpots() {
//        return this.ismpots;
//    }
//
//    public void setIsmpots(Set ismpots) {
//        this.ismpots = ismpots;
//    }

    public Set<Ismccm> getIsmccmsByCcmfromcurr() {
        return this.ismccmsByCcmfromcurr;
    }

    public void setIsmccmsByCcmfromcurr(Set<Ismccm> ismccmsByCcmfromcurr) {
        this.ismccmsByCcmfromcurr = ismccmsByCcmfromcurr;
    }

    public Set<Ismccm> getIsmccmsByCcmtocurr() {
        return this.ismccmsByCcmtocurr;
    }

    public void setIsmccmsByCcmtocurr(Set<Ismccm> ismccmsByCcmtocurr) {
        this.ismccmsByCcmtocurr = ismccmsByCcmtocurr;
    }

//    public Set getIsmsoms() {
//        return this.ismsoms;
//    }
//
//    public void setIsmsoms(Set ismsoms) {
//        this.ismsoms = ismsoms;
//    }
//
//    public Set getIsmscls() {
//        return this.ismscls;
//    }
//
//    public void setIsmscls(Set ismscls) {
//        this.ismscls = ismscls;
//    }

//    public Set getIsmpbis() {
//        return this.ismpbis;
//    }
//
//    public void setIsmpbis(Set ismpbis) {
//        this.ismpbis = ismpbis;
//    }

//    public Set getIsmgcms() {
//        return this.ismgcms;
//    }
//
//    public void setIsmgcms(Set ismgcms) {
//        this.ismgcms = ismgcms;
//    }

//    public Set getIsmubis() {
//        return this.ismubis;
//    }
//
//    public void setIsmubis(Set ismubis) {
//        this.ismubis = ismubis;
//    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("cctncode", getCctncode())
            .toString();
    }

}
