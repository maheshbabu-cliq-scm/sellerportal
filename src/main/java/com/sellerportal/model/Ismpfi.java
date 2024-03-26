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
@Table(name = "Ismpfi")
public class Ismpfi implements Serializable {

    /** identifier field */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long pfirfnum;

    /** persistent field */
    @Column(name = "createdate")
    private Date createdate;

    /** persistent field */
    @Column(name = "createdby")
    private Long createdby;

    /** persistent field */
    @Column(name = "deleted")
    private String deleted;

    /** persistent field */
    @Column(name = "modidate")
    private Date modidate;

    /** persistent field */
    @Column(name = "pfiname")
    private String pfiname;

    /** nullable persistent field */
    @Column(name = "pfiseq")
    private Integer pfiseq;

    /** persistent field */
    @Column(name = "pfivalue")
    private String pfivalue;

    /** persistent field */
    @ManyToOne
    @JoinColumn(name = "PFICNDFEATURETYPE")
    private Ismcnd ismcnd;

    /** persistent field */
    @ManyToOne
    @JoinColumn(name = "PFIPBIRFNUM")
    private Ismpbi ismpbi;

    /** full constructor */
    public Ismpfi(Date createdate, Long createdby, String deleted, Date modidate, String pfiname, Integer pfiseq, String pfivalue,  Ismcnd ismcnd,  Ismpbi ismpbi) {
        this.createdate = createdate;
        this.createdby = createdby;
        this.deleted = deleted;
        this.modidate = modidate;
        this.pfiname = pfiname;
        this.pfiseq = pfiseq;
        this.pfivalue = pfivalue;
        this.ismcnd = ismcnd;
        this.ismpbi = ismpbi;
    }

    /** default constructor */
    public Ismpfi() {
    }

    /** minimal constructor */
    public Ismpfi(Date createdate, Long createdby, String deleted, Date modidate, String pfiname, String pfivalue,  Ismcnd ismcnd,  Ismpbi ismpbi) {
        this.createdate = createdate;
        this.createdby = createdby;
        this.deleted = deleted;
        this.modidate = modidate;
        this.pfiname = pfiname;
        this.pfivalue = pfivalue;
        this.ismcnd = ismcnd;
        this.ismpbi = ismpbi;
    }

    /** 
     * 		       auto_increment
     * 		    
     */
    public Long getPfirfnum() {
        return this.pfirfnum;
    }

    public void setPfirfnum(Long pfirfnum) {
        this.pfirfnum = pfirfnum;
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

    public String getPfiname() {
        return this.pfiname;
    }

    public void setPfiname(String pfiname) {
        this.pfiname = pfiname;
    }

    public Integer getPfiseq() {
        return this.pfiseq;
    }

    public void setPfiseq(Integer pfiseq) {
        this.pfiseq = pfiseq;
    }

    public String getPfivalue() {
        return this.pfivalue;
    }

    public void setPfivalue(String pfivalue) {
        this.pfivalue = pfivalue;
    }

    public  Ismcnd getIsmcnd() {
        return this.ismcnd;
    }

    public void setIsmcnd(Ismcnd ismcnd) {
        this.ismcnd = ismcnd;
    }

    public  Ismpbi getIsmpbi() {
        return this.ismpbi;
    }

    public void setIsmpbi(Ismpbi ismpbi) {
        this.ismpbi = ismpbi;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("pfirfnum", getPfirfnum())
            .toString();
    }

}
