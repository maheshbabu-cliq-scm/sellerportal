package com.sellerportal.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import org.apache.commons.lang.builder.ToStringBuilder;

import javax.persistence.*;

/** @author Hibernate CodeGenerator */
@Entity
@Table(name = "ISMAPR")
public class Ismapr implements Serializable {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "APRRFNUM")
    private Long aprrfnum;

    @Column(name = "APRAMOUNT", length = 10)
    private BigDecimal apramount;

    @Column(name = "APRPERC", length = 5)
    private BigDecimal aprperc;

    @Column(name = "CREATEDATE", nullable = true)
    private Date createdate;

    @Column(name = "CREATEDBY", nullable = true, length = 20)
    private Long createdby;

    @Column(name = "DELETED", nullable = true, length = 1)
    private String deleted;

    @Column(name = "MODIDATE", nullable = true)
    private Date modidate;

    @ManyToOne
    @JoinColumn(name = "APRCNDTYPE", nullable = true)
    private Ismcnd ismcndByAprcndtype;

    @ManyToOne
    @JoinColumn(name = "APRCNDELEMENT", nullable = true)
    private Ismcnd ismcndByAprcndelement;

    @ManyToOne
    @JoinColumn(name = "APRAPPRFNUM", nullable = true)
    private Ismapp ismapp;

    @ManyToOne
    @JoinColumn(name = "APRRTDRFNUM", nullable = true)
    private Ismrtd ismrtd;

    /** full constructor */
    public Ismapr(BigDecimal apramount, BigDecimal aprperc, Date createdate, Long createdby, String deleted, Date modidate,  com.sellerportal.model.Ismcnd ismcndByAprcndtype,  com.sellerportal.model.Ismcnd ismcndByAprcndelement,  com.sellerportal.model.Ismapp ismapp,  com.sellerportal.model.Ismrtd ismrtd) {
        this.apramount = apramount;
        this.aprperc = aprperc;
        this.createdate = createdate;
        this.createdby = createdby;
        this.deleted = deleted;
        this.modidate = modidate;
        this.ismcndByAprcndtype = ismcndByAprcndtype;
        this.ismcndByAprcndelement = ismcndByAprcndelement;
        this.ismapp = ismapp;
        this.ismrtd = ismrtd;
    }

    /** default constructor */
    public Ismapr() {
    }

    /** minimal constructor */
    public Ismapr(Date createdate, Long createdby, String deleted, Date modidate,  com.sellerportal.model.Ismcnd ismcndByAprcndtype,  com.sellerportal.model.Ismcnd ismcndByAprcndelement,  com.sellerportal.model.Ismapp ismapp,  com.sellerportal.model.Ismrtd ismrtd) {
        this.createdate = createdate;
        this.createdby = createdby;
        this.deleted = deleted;
        this.modidate = modidate;
        this.ismcndByAprcndtype = ismcndByAprcndtype;
        this.ismcndByAprcndelement = ismcndByAprcndelement;
        this.ismapp = ismapp;
        this.ismrtd = ismrtd;
    }

    /** 
     * 		       auto_increment
     * 		    
     */
    public Long getAprrfnum() {
        return this.aprrfnum;
    }

    public void setAprrfnum(Long aprrfnum) {
        this.aprrfnum = aprrfnum;
    }

    public BigDecimal getApramount() {
        return this.apramount;
    }

    public void setApramount(BigDecimal apramount) {
        this.apramount = apramount;
    }

    public BigDecimal getAprperc() {
        return this.aprperc;
    }

    public void setAprperc(BigDecimal aprperc) {
        this.aprperc = aprperc;
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

    public  com.sellerportal.model.Ismcnd getIsmcndByAprcndtype() {
        return this.ismcndByAprcndtype;
    }

    public void setIsmcndByAprcndtype( com.sellerportal.model.Ismcnd ismcndByAprcndtype) {
        this.ismcndByAprcndtype = ismcndByAprcndtype;
    }

    public  com.sellerportal.model.Ismcnd getIsmcndByAprcndelement() {
        return this.ismcndByAprcndelement;
    }

    public void setIsmcndByAprcndelement( com.sellerportal.model.Ismcnd ismcndByAprcndelement) {
        this.ismcndByAprcndelement = ismcndByAprcndelement;
    }

    public  com.sellerportal.model.Ismapp getIsmapp() {
        return this.ismapp;
    }

    public void setIsmapp( com.sellerportal.model.Ismapp ismapp) {
        this.ismapp = ismapp;
    }

    public  com.sellerportal.model.Ismrtd getIsmrtd() {
        return this.ismrtd;
    }

    public void setIsmrtd( com.sellerportal.model.Ismrtd ismrtd) {
        this.ismrtd = ismrtd;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("aprrfnum", getAprrfnum())
            .toString();
    }

}
