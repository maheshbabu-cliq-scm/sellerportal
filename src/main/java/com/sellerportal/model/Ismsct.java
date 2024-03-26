package com.sellerportal.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.apache.commons.lang.builder.ToStringBuilder;


/** @author Hibernate CodeGenerator */
@Entity
@Table(name = "ISMSCT")
public class Ismsct implements Serializable {

	/** identifier field */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "SCTRFNUM")
    private Long sctrfnum;

    /** persistent field */
    @Column(name = "CREATEDATE")
    private Date createdate;

    /** persistent field */
    @Column(name = "CREATEDBY")
    private Long createdby;

    /** persistent field */
    @Column(name = "DELETED")
    private String deleted;

    /** persistent field */
    @Column(name = "MODIDATE")
    private Date modidate;

    /** nullable persistent field */
    @Column(name = "SCTISQUERY")
    private String sctisquery;

    /** nullable persistent field */
    @Column(name = "SCTISVALUE")
    private String sctisvalue;

    /** persistent field */
    @Column(name = "SCTTITLE")
    private String scttitle;

    /** nullable persistent field */
    @Column(name = "SCTVALUE")
    private Integer sctvalue;

    /** persistent field */
    @ManyToOne
    @JoinColumn(name = "SCTPTMRFNUM")
    private Ismptm ismptm;

    /** persistent field */
    @ManyToOne
    @JoinColumn(name = "SCTCNDDEFFIELD")
    private Ismcnd ismcnd;

    /** persistent field */
    @OneToMany(mappedBy = "ismsct", fetch = FetchType.EAGER)
    @Transient
    private Set<Ismmct> ismmcts;

    /** full constructor */
    public Ismsct(Date createdate, Long createdby, String deleted, Date modidate, String sctisquery, String sctisvalue, String scttitle, Integer sctvalue,  Ismptm ismptm,  Ismcnd ismcnd, Set<Ismmct> ismmcts) {
        this.createdate = createdate;
        this.createdby = createdby;
        this.deleted = deleted;
        this.modidate = modidate;
        this.sctisquery = sctisquery;
        this.sctisvalue = sctisvalue;
        this.scttitle = scttitle;
        this.sctvalue = sctvalue;
        this.ismptm = ismptm;
        this.ismcnd = ismcnd;
        this.ismmcts = ismmcts;
    }

    /** default constructor */
    public Ismsct() {
    }

    /** minimal constructor */
    public Ismsct(Date createdate, Long createdby, String deleted, Date modidate, String scttitle,  Ismptm ismptm,  Ismcnd ismcnd, Set<Ismmct> ismmcts) {
        this.createdate = createdate;
        this.createdby = createdby;
        this.deleted = deleted;
        this.modidate = modidate;
        this.scttitle = scttitle;
        this.ismptm = ismptm;
        this.ismcnd = ismcnd;
        this.ismmcts = ismmcts;
    }

    /** 
     * 		       auto_increment
     * 		    
     */
    public Long getSctrfnum() {
        return this.sctrfnum;
    }

    public void setSctrfnum(Long sctrfnum) {
        this.sctrfnum = sctrfnum;
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

    public String getSctisquery() {
        return this.sctisquery;
    }

    public void setSctisquery(String sctisquery) {
        this.sctisquery = sctisquery;
    }

    public String getSctisvalue() {
        return this.sctisvalue;
    }

    public void setSctisvalue(String sctisvalue) {
        this.sctisvalue = sctisvalue;
    }

    public String getScttitle() {
        return this.scttitle;
    }

    public void setScttitle(String scttitle) {
        this.scttitle = scttitle;
    }

    public Integer getSctvalue() {
        return this.sctvalue;
    }

    public void setSctvalue(Integer sctvalue) {
        this.sctvalue = sctvalue;
    }

    public  Ismptm getIsmptm() {
        return this.ismptm;
    }

    public void setIsmptm(Ismptm ismptm) {
        this.ismptm = ismptm;
    }

    public  Ismcnd getIsmcnd() {
        return this.ismcnd;
    }

    public void setIsmcnd(Ismcnd ismcnd) {
        this.ismcnd = ismcnd;
    }

    public Set<Ismmct> getIsmmcts() {
        return this.ismmcts;
    }

    public void setIsmmcts(Set<Ismmct> ismmcts) {
        this.ismmcts = ismmcts;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("sctrfnum", getSctrfnum())
            .toString();
    }

}
