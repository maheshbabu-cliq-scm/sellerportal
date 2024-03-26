package com.sellerportal.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.apache.commons.lang.builder.ToStringBuilder;


/** @author Hibernate CodeGenerator */
@Entity
@Table(name = "Ismpt")
public class Ismpt implements Serializable {

	 /** identifier field */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ptsrfnum;

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
    @Column(name = "PTSITEMSKU")
    private String ptsitemsku;

    /** persistent field */
    @Column(name = "PTSQTY")
    private Long ptsqty;

    /** persistent field */
    @ManyToOne
    @JoinColumn(name = "PTSPBIRFNUM")
    private Ismpbi ismpbi;

    /** persistent field */
    @ManyToOne
    @JoinColumn(name = "PTSMCTRFNUM")
    private Ismmct ismmct;

    

    /** full constructor */
    public Ismpt(Date createdate, Long createdby, String deleted, Date modidate, String ptsitemsku, Long ptsqty, Ismpbi ismpbi, Ismmct ismmct) {
        this.createdate = createdate;
        this.createdby = createdby;
        this.deleted = deleted;
        this.modidate = modidate;
        this.ptsitemsku = ptsitemsku;
        this.ptsqty = ptsqty;
        this.ismpbi = ismpbi;
        this.ismmct = ismmct;
      
    }

    /** default constructor */
    public Ismpt() {
    }

    /** minimal constructor */
    public Ismpt(Date createdate, Long createdby, String deleted, Date modidate, Long ptsqty, Ismpbi ismpbi, Ismmct ismmct) {
        this.createdate = createdate;
        this.createdby = createdby;
        this.deleted = deleted;
        this.modidate = modidate;
        this.ptsqty = ptsqty;
        this.ismpbi = ismpbi;
        this.ismmct = ismmct;
       
    }

    /** 
     * 		       auto_increment
     * 		    
     */
    public Long getPtsrfnum() {
        return this.ptsrfnum;
    }

    public void setPtsrfnum(Long ptsrfnum) {
        this.ptsrfnum = ptsrfnum;
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

    public String getPtsitemsku() {
        return this.ptsitemsku;
    }

    public void setPtsitemsku(String ptsitemsku) {
        this.ptsitemsku = ptsitemsku;
    }

    public Long getPtsqty() {
        return this.ptsqty;
    }

    public void setPtsqty(Long ptsqty) {
        this.ptsqty = ptsqty;
    }

    public Ismpbi getIsmpbi() {
        return this.ismpbi;
    }

    public void setIsmpbi(Ismpbi ismpbi) {
        this.ismpbi = ismpbi;
    }

    public Ismmct getIsmmct() {
        return this.ismmct;
    }

    public void setIsmmct(Ismmct ismmct) {
        this.ismmct = ismmct;
    }

  

    public String toString() {
        return new ToStringBuilder(this)
            .append("ptsrfnum", getPtsrfnum())
            .toString();
    }

}
