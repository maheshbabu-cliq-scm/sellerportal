package com.sellerportal.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import org.apache.commons.lang.builder.ToStringBuilder;

import javax.persistence.*;

/** @author Hibernate CodeGenerator */
@Entity
@Table(name = "ISMAPP")
public class Ismapp implements Serializable {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "APPRFNUM")
    private Long apprfnum;

    @Column(name = "APPADMINOWN", length = 1)
    private String appadminown;

    @Column(name = "APPDESC", length = 2048)
    private String appdesc;

    @Column(name = "APPNAME", nullable = true, length = 128)
    private String appname;

    @Column(name = "APPTITLE", length = 254)
    private String apptitle;

    @Column(name = "CREATEDATE", nullable = true)
    private Date createdate;

    @Column(name = "CREATEDBY", nullable = true, length = 20)
    private Long createdby;

    @Column(name = "DELETED", nullable = true, length = 1)
    private String deleted;

    @Column(name = "MODIDATE", nullable = true)
    private Date modidate;

    @OneToMany(mappedBy = "ismapp", fetch = FetchType.LAZY)
    @Transient
    private Set<Ismapr> ismaprs;

    @OneToMany(mappedBy = "ismapp", fetch = FetchType.LAZY)
    @Transient
    private Set<Ismpbi> ismpbis;

    /** full constructor */
    public Ismapp(String appadminown, String appdesc, String appname, String apptitle, Date createdate, Long createdby, String deleted, Date modidate, Set<Ismapr> ismaprs, Set<Ismpbi> ismpbis) {
        this.appadminown = appadminown;
        this.appdesc = appdesc;
        this.appname = appname;
        this.apptitle = apptitle;
        this.createdate = createdate;
        this.createdby = createdby;
        this.deleted = deleted;
        this.modidate = modidate;
        this.ismaprs = ismaprs;
        this.ismpbis = ismpbis;
    }

    /** default constructor */
    public Ismapp() {
    }

    /** minimal constructor */
    public Ismapp(String appname, Date createdate, Long createdby, String deleted, Date modidate,Set<Ismapr> ismaprs, Set<Ismpbi> ismpbis) {
        this.appname = appname;
        this.createdate = createdate;
        this.createdby = createdby;
        this.deleted = deleted;
        this.modidate = modidate;
        this.ismaprs = ismaprs;
        this.ismpbis = ismpbis;
    }

    /** 
     * 		       auto_increment
     * 		    
     */
    public Long getApprfnum() {
        return this.apprfnum;
    }

    public void setApprfnum(Long apprfnum) {
        this.apprfnum = apprfnum;
    }

    public String getAppadminown() {
        return this.appadminown;
    }

    public void setAppadminown(String appadminown) {
        this.appadminown = appadminown;
    }

    public String getAppdesc() {
        return this.appdesc;
    }

    public void setAppdesc(String appdesc) {
        this.appdesc = appdesc;
    }

    public String getAppname() {
        return this.appname;
    }

    public void setAppname(String appname) {
        this.appname = appname;
    }

    public String getApptitle() {
        return this.apptitle;
    }

    public void setApptitle(String apptitle) {
        this.apptitle = apptitle;
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

    
    public Set<Ismapr> getIsmaprs() {
        return this.ismaprs;
    }

    public void setIsmaprs(Set<Ismapr> ismaprs) {
        this.ismaprs = ismaprs;
    }

    public Set<Ismpbi> getIsmpbis() {
        return this.ismpbis;
    }

    public void setIsmpbis(Set<Ismpbi> ismpbis) {
        this.ismpbis = ismpbis;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("apprfnum", getApprfnum())
            .toString();
    }

}
