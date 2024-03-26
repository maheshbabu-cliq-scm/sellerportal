package com.sellerportal.model;

import java.io.Serializable;
import java.util.Date;

import org.apache.commons.lang.builder.ToStringBuilder;
import javax.persistence.*;

/** @author Hibernate CodeGenerator */
@Entity
@Table(name = "ISMDAP")
public class Ismdap implements Serializable {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "DAPRFNUM")
    private Long daprfnum;

    @Column(name = "CREATEDATE", nullable = false)
    private Date createdate;

    @Column(name = "CREATEDBY", length = 20, nullable = false)
    private Long createdby;

    @Column(name = "DAPADPRODID", length = 10, nullable = false)
    private String dapadprodid;

    @Column(name = "DELETED", length = 1, nullable = false)
    private String deleted;

    @Column(name = "MODIDATE", nullable = false)
    private Date modidate;

    @ManyToOne
    @JoinColumn(name = "DAPDATRFNUM", nullable = false)
    private Ismdat ismdat;

    @ManyToOne
    @JoinColumn(name = "DAPPBIRFNUM", nullable = false)
    private Ismpbi ismpbi;

    @ManyToOne
    @JoinColumn(name = "DAPMCTRFNUM", nullable = false)
    private Ismmct ismmct;

    /** full constructor */
    public Ismdap(Date createdate, Long createdby, String dapadprodid, String deleted, Date modidate, Ismdat ismdat, Ismpbi ismpbi, Ismmct ismmct) {
        this.createdate = createdate;
        this.createdby = createdby;
        this.dapadprodid = dapadprodid;
        this.deleted = deleted;
        this.modidate = modidate;
        this.ismdat = ismdat;
        this.ismpbi = ismpbi;
        this.ismmct = ismmct;
    }

    /** default constructor */
    public Ismdap() {
    }

    /** 
     * 		       auto_increment
     * 		    
     */
    public Long getDaprfnum() {
        return this.daprfnum;
    }

    public void setDaprfnum(Long daprfnum) {
        this.daprfnum = daprfnum;
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

    public String getDapadprodid() {
        return this.dapadprodid;
    }

    public void setDapadprodid(String dapadprodid) {
        this.dapadprodid = dapadprodid;
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

    public Ismdat getIsmdat() {
        return this.ismdat;
    }

    public void setIsmdat(Ismdat ismdat) {
        this.ismdat = ismdat;
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
            .append("daprfnum", getDaprfnum())
            .toString();
    }

}
