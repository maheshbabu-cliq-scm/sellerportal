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
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.apache.commons.lang.builder.ToStringBuilder;


import javax.persistence.*;


@Entity
@Table(name = "ISMRTD")
public class Ismrtd implements Serializable {

	/** identifier field */
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "RTDRFNUM")
    private Long rtdrfnum;

    @Column(name = "CREATEDATE", nullable = false)
    private Date createdate;

    @Column(name = "CREATEDBY", nullable = false, length = 20)
    private Long createdby;

    @Column(name = "DELETED", nullable = false, length = 1)
    private String deleted;

    @Column(name = "MODIDATE", nullable = false)
    private Date modidate;

    @Column(name = "RTDDESC", length = 2048)
    private String rtddesc;

    @Column(name = "RTDNAME", nullable = false, length = 128)
    private String rtdname;

    @Column(name = "RTDRULENAME", nullable = false, length = 128)
    private String rtdrulename;

    @OneToMany(mappedBy = "ismrtd", fetch = FetchType.LAZY)
    @Transient
    private Set<Ismapr> ismaprs;
    
    
    /** full constructor */
    public Ismrtd(Date createdate, Long createdby, String deleted, Date modidate, String rtddesc, String rtdname, String rtdrulename, Set<Ismapr> ismaprs) {
        this.createdate = createdate;
        this.createdby = createdby;
        this.deleted = deleted;
        this.modidate = modidate;
        this.rtddesc = rtddesc;
        this.rtdname = rtdname;
        this.rtdrulename = rtdrulename;
//        this.ismacts = ismacts;
//        this.ismdpts = ismdpts;
        this.ismaprs = ismaprs;
    }

    /** default constructor */
    public Ismrtd() {
    }

    /** minimal constructor */
    public Ismrtd(Date createdate, Long createdby, String deleted, Date modidate, String rtdname, String rtdrulename,  Set<Ismapr> ismaprs) {
        this.createdate = createdate;
        this.createdby = createdby;
        this.deleted = deleted;
        this.modidate = modidate;
        this.rtdname = rtdname;
        this.rtdrulename = rtdrulename;
//        this.ismacts = ismacts;
//        this.ismdpts = ismdpts;
        this.ismaprs = ismaprs;
    }

    /** 
     * 		       auto_increment
     * 		    
     */
    public Long getRtdrfnum() {
        return this.rtdrfnum;
    }

    public void setRtdrfnum(Long rtdrfnum) {
        this.rtdrfnum = rtdrfnum;
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

    public String getRtddesc() {
        return this.rtddesc;
    }

    public void setRtddesc(String rtddesc) {
        this.rtddesc = rtddesc;
    }

    public String getRtdname() {
        return this.rtdname;
    }

    public void setRtdname(String rtdname) {
        this.rtdname = rtdname;
    }

    public String getRtdrulename() {
        return this.rtdrulename;
    }

    public void setRtdrulename(String rtdrulename) {
        this.rtdrulename = rtdrulename;
    }

//    public Set getIsmacts() {
//        return this.ismacts;
//    }
//
//    public void setIsmacts(Set ismacts) {
//        this.ismacts = ismacts;
//    }
//
//    public Set getIsmdpts() {
//        return this.ismdpts;
//    }
//
//    public void setIsmdpts(Set ismdpts) {
//        this.ismdpts = ismdpts;
//    }

    public Set<Ismapr> getIsmaprs() {
        return this.ismaprs;
    }

    public void setIsmaprs(Set<Ismapr> ismaprs) {
        this.ismaprs = ismaprs;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("rtdrfnum", getRtdrfnum())
            .toString();
    }

}
