package com.sellerportal.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import org.apache.commons.lang3.builder.ToStringBuilder;
import javax.persistence.*;

@Entity
@Table(name = "ISMPTM")
public class Ismptm implements Serializable {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PTMRFNUM")
    private Long ptmrfnum;

    @Column(name = "CREATEDATE", nullable = false)
    private Date createdate;

    @Column(name = "CREATEDBY", nullable = false, length = 20)
    private Long createdby;

    @Column(name = "DELETED", nullable = false, length = 1)
    private String deleted;

    @Column(name = "MODIDATE", nullable = false)
    private Date modidate;

    @Column(name = "PTMCNDQUERYTYP", nullable = false, length = 20)
    private Long ptmcndquerytyp;

    @Column(name = "PTMDESC", length = 2048)
    private String ptmdesc;

    @Column(name = "PTMISADMIN", length = 1)
    private String ptmisadmin;

    @Column(name = "PTMNAME", nullable = false, length = 128)
    private String ptmname;

    @Column(name = "PTMQUERY", nullable = false, length = 2048)
    private String ptmquery;

    @OneToMany(mappedBy = "ismptm", fetch = FetchType.LAZY)
    @Transient
    private Set<Ismsct> ismscts;

    @OneToMany(mappedBy = "ismptm", fetch = FetchType.LAZY)
    @Transient
    private Set<Ismcmt> ismcmts;

    @OneToMany(mappedBy = "ismptm", fetch = FetchType.LAZY)
    @Transient
    private Set<Ismmct> ismmcts;

    /** full constructor */
    public Ismptm(Date createdate, Long createdby, String deleted, Date modidate, Long ptmcndquerytyp, String ptmdesc, String ptmisadmin, String ptmname, String ptmquery, Set<Ismsct> ismscts, Set<Ismcmt> ismcmts, Set<Ismmct> ismmcts) {
        this.createdate = createdate;
        this.createdby = createdby;
        this.deleted = deleted;
        this.modidate = modidate;
        this.ptmcndquerytyp = ptmcndquerytyp;
        this.ptmdesc = ptmdesc;
        this.ptmisadmin = ptmisadmin;
        this.ptmname = ptmname;
        this.ptmquery = ptmquery;
//        this.ismsdas = ismsdas;
//        this.ismidas = ismidas;
//        this.ismcdas = ismcdas;
//        this.ismpdts = ismpdts;
        this.ismscts = ismscts;
        this.ismcmts = ismcmts;
        this.ismmcts = ismmcts;
    }

    /** default constructor */
    public Ismptm() {
    }

    /** minimal constructor */
    public Ismptm(Date createdate, Long createdby, String deleted, Date modidate, Long ptmcndquerytyp, String ptmname, String ptmquery, Set<Ismsct> ismscts, Set<Ismcmt> ismcmts, Set<Ismmct> ismmcts) {
        this.createdate = createdate;
        this.createdby = createdby;
        this.deleted = deleted;
        this.modidate = modidate;
        this.ptmcndquerytyp = ptmcndquerytyp;
        this.ptmname = ptmname;
        this.ptmquery = ptmquery;
//        this.ismsdas = ismsdas;
//        this.ismidas = ismidas;
//        this.ismcdas = ismcdas;
//        this.ismpdts = ismpdts;
        this.ismscts = ismscts;
        this.ismcmts = ismcmts;
        this.ismmcts = ismmcts;
    }

    /** 
     * 		       auto_increment
     * 		    
     */
    public Long getPtmrfnum() {
        return this.ptmrfnum;
    }

    public void setPtmrfnum(Long ptmrfnum) {
        this.ptmrfnum = ptmrfnum;
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

    public Long getPtmcndquerytyp() {
        return this.ptmcndquerytyp;
    }

    public void setPtmcndquerytyp(Long ptmcndquerytyp) {
        this.ptmcndquerytyp = ptmcndquerytyp;
    }

    public String getPtmdesc() {
        return this.ptmdesc;
    }

    public void setPtmdesc(String ptmdesc) {
        this.ptmdesc = ptmdesc;
    }

    public String getPtmisadmin() {
        return this.ptmisadmin;
    }

    public void setPtmisadmin(String ptmisadmin) {
        this.ptmisadmin = ptmisadmin;
    }

    public String getPtmname() {
        return this.ptmname;
    }

    public void setPtmname(String ptmname) {
        this.ptmname = ptmname;
    }

    public String getPtmquery() {
        return this.ptmquery;
    }

    public void setPtmquery(String ptmquery) {
        this.ptmquery = ptmquery;
    }

    

//    public Set getIsmsdas() {
//        return this.ismsdas;
//    }
//
//    public void setIsmsdas(Set ismsdas) {
//        this.ismsdas = ismsdas;
//    }
//
//    public Set getIsmidas() {
//        return this.ismidas;
//    }
//
//    public void setIsmidas(Set ismidas) {
//        this.ismidas = ismidas;
//    }
//
//    public Set getIsmcdas() {
//        return this.ismcdas;
//    }
//
//    public void setIsmcdas(Set ismcdas) {
//        this.ismcdas = ismcdas;
//    }
//
//    public Set getIsmpdts() {
//        return this.ismpdts;
//    }
//
//    public void setIsmpdts(Set ismpdts) {
//        this.ismpdts = ismpdts;
//    }

    public Set<Ismsct> getIsmscts() {
        return this.ismscts;
    }

    public void setIsmscts(Set<Ismsct> ismscts) {
        this.ismscts = ismscts;
    }

    public Set<Ismcmt> getIsmcmts() {
        return this.ismcmts;
    }

    public void setIsmcmts(Set<Ismcmt> ismcmts) {
        this.ismcmts = ismcmts;
    }

    public Set<Ismmct> getIsmmcts() {
        return this.ismmcts;
    }

    public void setIsmmcts(Set<Ismmct> ismmcts) {
        this.ismmcts = ismmcts;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("ptmrfnum", getPtmrfnum())
            .toString();
    }

}
