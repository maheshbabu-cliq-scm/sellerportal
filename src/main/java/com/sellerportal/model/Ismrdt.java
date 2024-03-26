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
@Table(name = "ISMRDT")
public class Ismrdt implements Serializable {

	 /** identifier field */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long RDTRFNUM;

    /** persistent field */
    @Column(name = "CREATEDATE")
    private Date CREATEDATE;

    /** persistent field */
    @Column(name = "CREATEDBY")
    private Long CREATEDBY;

    /** persistent field */
    @Column(name = "DELETED")
    private String DELETED;

    /** persistent field */
    @Column(name = "MODIDATE")
    private Date MODIDATE;

    /** persistent field */
    @Column(name = "RDTISORDER")
    private String RDTISORDER;

    /** nullable persistent field */
    @Column(name = "RDTREPDESC")
    private String RDTREPDESC;

    /** persistent field */
    @Column(name = "RDTREPNAME")
    private String RDTREPNAME;

    /** persistent field */
    @ManyToOne
    @JoinColumn(name = "RDTCNDREPGRP")
    private Ismcnd ISMCND;

    /** persistent field */
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER,mappedBy = "ismrft")
    @Transient
    private Set<Ismrfa> ISMRFAS;

    /** full constructor */
    public Ismrdt(Date createdate, Long createdby, String deleted, Date modidate, String rdtisorder, String rdtrepdesc, String rdtrepname,  Ismcnd ismcnd, Set<Ismrfa> ismrfas) {
        this.CREATEDATE = createdate;
        this.CREATEDBY = createdby;
        this.DELETED = deleted;
        this.MODIDATE = modidate;
        this.RDTISORDER = rdtisorder;
        this.RDTREPDESC = rdtrepdesc;
        this.RDTREPNAME = rdtrepname;
        this.ISMCND = ismcnd;
        this.ISMRFAS = ismrfas;
    }

    /** default constructor */
    public Ismrdt() {
    }

    /** minimal constructor */
    public Ismrdt(Date createdate, Long createdby, String deleted, Date modidate, String rdtisorder, String rdtrepname,  Ismcnd ismcnd, Set<Ismrfa> ismrfas) {
        this.CREATEDATE = createdate;
        this.CREATEDBY = createdby;
        this.DELETED = deleted;
        this.MODIDATE = modidate;
        this.RDTISORDER = rdtisorder;
        this.RDTREPNAME = rdtrepname;
        this.ISMCND = ismcnd;
        this.ISMRFAS = ismrfas;
    }

    /** 
     * 		       auto_increment
     * 		    
     */
    public Long getRdtrfnum() {
        return this.RDTRFNUM;
    }

    public void setRdtrfnum(Long rdtrfnum) {
        this.RDTRFNUM = rdtrfnum;
    }

    public Date getCreatedate() {
        return this.CREATEDATE;
    }

    public void setCreatedate(Date createdate) {
        this.CREATEDATE = createdate;
    }

    public Long getCreatedby() {
        return this.CREATEDBY;
    }

    public void setCreatedby(Long createdby) {
        this.CREATEDBY = createdby;
    }

    public String getDeleted() {
        return this.DELETED;
    }

    public void setDeleted(String deleted) {
        this.DELETED = deleted;
    }

    public Date getModidate() {
        return this.MODIDATE;
    }

    public void setModidate(Date modidate) {
        this.MODIDATE = modidate;
    }

    public String getRdtisorder() {
        return this.RDTISORDER;
    }

    public void setRdtisorder(String rdtisorder) {
        this.RDTISORDER = rdtisorder;
    }

    public String getRdtrepdesc() {
        return this.RDTREPDESC;
    }

    public void setRdtrepdesc(String rdtrepdesc) {
        this.RDTREPDESC = rdtrepdesc;
    }

    public String getRdtrepname() {
        return this.RDTREPNAME;
    }

    public void setRdtrepname(String rdtrepname) {
        this.RDTREPNAME = rdtrepname;
    }

    public  com.sellerportal.model.Ismcnd getIsmcnd() {
        return this.ISMCND;
    }

    public void setIsmcnd( com.sellerportal.model.Ismcnd ismcnd) {
        this.ISMCND = ismcnd;
    }

    public Set<Ismrfa> getIsmrfas() {
        return this.ISMRFAS;
    }

    public void setIsmrfas(Set<Ismrfa> ismrfas) {
        this.ISMRFAS = ismrfas;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("rdtrfnum", getRdtrfnum())
            .toString();
    }

}
