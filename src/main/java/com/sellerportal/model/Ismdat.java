package com.sellerportal.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import org.apache.commons.lang.builder.ToStringBuilder;
import javax.persistence.*;

/** @author Hibernate CodeGenerator */
@Entity
@Table(name = "ISMDAT")
public class Ismdat implements Serializable {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "DATRFNUM")
    private Long datrfnum;

    @Column(name = "CREATEDATE", nullable = false)
    private Date createdate;

    @Column(name = "CREATEDBY", length = 20, nullable = false)
    private Long createdby;

    @Column(name = "DATADCODE", length = 254, nullable = false)
    private String datadcode;

    @Column(name = "DATADDATE", nullable = false)
    private Date dataddate;

    @Column(name = "DATDESC", length = 1024)
    private String datdesc;

    @Column(name = "DATNAME", length = 254, nullable = false)
    private String datname;

    @Column(name = "DELETED", length = 1, nullable = false)
    private String deleted;

    @Column(name = "MODIDATE", nullable = false)
    private Date modidate;

    @OneToMany(mappedBy = "ismdat", fetch = FetchType.LAZY)
    private Set<Ismdap> ismdaps;

    @ManyToOne
    @JoinColumn(name = "DATCNDADGRP", nullable = false)
    private Ismcnd ismcnd;

    /** full constructor */
    public Ismdat(Date createdate, Long createdby, String datadcode, Date dataddate, String datdesc, String datname, String deleted, Date modidate,  com.sellerportal.model.Ismcnd ismcnd, Set<Ismdap> ismdaps) {
        this.createdate = createdate;
        this.createdby = createdby;
        this.datadcode = datadcode;
        this.dataddate = dataddate;
        this.datdesc = datdesc;
        this.datname = datname;
        this.deleted = deleted;
        this.modidate = modidate;
        this.ismcnd = ismcnd;
        this.ismdaps = ismdaps;
    }

    /** default constructor */
    public Ismdat() {
    }

    /** minimal constructor */
    public Ismdat(Date createdate, Long createdby, String datadcode, Date dataddate, String datname, String deleted, Date modidate,  com.sellerportal.model.Ismcnd ismcnd, Set<Ismdap> ismdaps) {
        this.createdate = createdate;
        this.createdby = createdby;
        this.datadcode = datadcode;
        this.dataddate = dataddate;
        this.datname = datname;
        this.deleted = deleted;
        this.modidate = modidate;
        this.ismcnd = ismcnd;
        this.ismdaps = ismdaps;
    }

    /** 
     * 		       auto_increment
     * 		    
     */
    public Long getDatrfnum() {
        return this.datrfnum;
    }

    public void setDatrfnum(Long datrfnum) {
        this.datrfnum = datrfnum;
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

    public String getDatadcode() {
        return this.datadcode;
    }

    public void setDatadcode(String datadcode) {
        this.datadcode = datadcode;
    }

    public Date getDataddate() {
        return this.dataddate;
    }

    public void setDataddate(Date dataddate) {
        this.dataddate = dataddate;
    }

    public String getDatdesc() {
        return this.datdesc;
    }

    public void setDatdesc(String datdesc) {
        this.datdesc = datdesc;
    }

    public String getDatname() {
        return this.datname;
    }

    public void setDatname(String datname) {
        this.datname = datname;
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

    public  com.sellerportal.model.Ismcnd getIsmcnd() {
        return this.ismcnd;
    }

    public void setIsmcnd( com.sellerportal.model.Ismcnd ismcnd) {
        this.ismcnd = ismcnd;
    }

    public Set<Ismdap> getIsmdaps() {
        return this.ismdaps;
    }

    public void setIsmdaps(Set<Ismdap> ismdaps) {
        this.ismdaps = ismdaps;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("datrfnum", getDatrfnum())
            .toString();
    }

}
