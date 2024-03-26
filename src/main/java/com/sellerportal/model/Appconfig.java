package com.sellerportal.model;

import java.io.Serializable;
import java.util.Date;

import org.apache.commons.lang3.builder.ToStringBuilder;


import javax.persistence.*;

/** @author Hibernate CodeGenerator */
@Entity
@Table(name = "appconfig")
public class Appconfig implements Serializable {

	@Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence")
    @SequenceGenerator(name = "sequence", sequenceName = "AAPCONFIG_APPRFNUM_SEQ", allocationSize = 1)
    @Column(name = "APPRFNUM")
    private Long apprfnum;

    @Column(name = "APPIP", nullable = false, length = 254)
    private String appip;

    @Column(name = "APPNAME", nullable = false, length = 254)
    private String appname;

    @Column(name = "CREATEDATE", nullable = false)
    private Date createdate;

    @Column(name = "CREATEDBY")
    private Long createdby;

    @Column(name = "DELETED", length = 1)
    private String deleted;

    @Column(name = "MODIDATE", nullable = false)
    private Date modidate;

    @Column(name = "ORGID", nullable = false)
    private Long orgid;

    /** full constructor */
    public Appconfig(String appip, String appname, Date createdate, Long createdby, String deleted, Date modidate, Long orgid) {
        this.appip = appip;
        this.appname = appname;
        this.createdate = createdate;
        this.createdby = createdby;
        this.deleted = deleted;
        this.modidate = modidate;
        this.orgid = orgid;
    }

    /** default constructor */
    public Appconfig() {
    }

    /** minimal constructor */
    public Appconfig(String appip, String appname, Date createdate, Date modidate, Long orgid) {
        this.appip = appip;
        this.appname = appname;
        this.createdate = createdate;
        this.modidate = modidate;
        this.orgid = orgid;
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

    public String getAppip() {
        return this.appip;
    }

    public void setAppip(String appip) {
        this.appip = appip;
    }

    public String getAppname() {
        return this.appname;
    }

    public void setAppname(String appname) {
        this.appname = appname;
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

    public Long getOrgid() {
        return this.orgid;
    }

    public void setOrgid(Long orgid) {
        this.orgid = orgid;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("apprfnum", getApprfnum())
            .toString();
    }

}
