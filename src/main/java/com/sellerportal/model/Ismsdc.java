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
@Table(name = "ISMSDC")
public class Ismsdc implements Serializable {

    /** identifier field */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "SDCRFNUM")
    private Long sdcrfnum;

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

    /** persistent field */
    @ManyToOne
    @JoinColumn(name = "SDCCNDDISTRCITY")
    private Ismcnd ismcnd;


    /** full constructor */
    public Ismsdc(Date createdate, Long createdby, String deleted, Date modidate,  Ismcnd ismcnd) {
        this.createdate = createdate;
        this.createdby = createdby;
        this.deleted = deleted;
        this.modidate = modidate;
        this.ismcnd = ismcnd;
    }

    /** default constructor */
    public Ismsdc() {
    }

    /** 
     * 		       auto_increment
     * 		    
     */
    public Long getSdcrfnum() {
        return this.sdcrfnum;
    }

    public void setSdcrfnum(Long sdcrfnum) {
        this.sdcrfnum = sdcrfnum;
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

    public  Ismcnd getIsmcnd() {
        return this.ismcnd;
    }

    public void setIsmcnd(Ismcnd ismcnd) {
        this.ismcnd = ismcnd;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("sdcrfnum", getSdcrfnum())
            .toString();
    }

}
