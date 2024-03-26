package com.sellerportal.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import org.apache.commons.lang.builder.ToStringBuilder;

import javax.persistence.*;

/** @author Hibernate CodeGenerator */
@Entity
@Table(name = "ISMAPM")
public class Ismapm implements Serializable {

	@Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence")
    @SequenceGenerator(name = "sequence", sequenceName = "ISMAPM_APMRFNUM_SEQ", allocationSize = 1)
    @Column(name = "APMRFNUM")
    private Long apmrfnum;

    @Column(name = "ACTIVE", length = 1)
    private String active;

    @Column(name = "APMPAGENAME", length = 254)
    private String apmpagename;

    @Column(name = "APMPAGETITLE", length = 254)
    private String apmpagetitle;

    @Column(name = "CREATEDATE", nullable = false)
    private Date createdate;

    @Column(name = "CREATEDBY", nullable = false)
    private Long createdby;

    @Column(name = "DELETED", nullable = false, length = 1)
    private String deleted;

    @Column(name = "MODIDATE", nullable = false)
    private Date modidate;

    @ManyToOne
    @JoinColumn(name = "APMCNDMODULE", nullable = false)
    private Ismcnd ismcnd;

    @OneToMany(mappedBy = "ismapm")
    private Set<Ismacm> ismacms;

    /** full constructor 
     * @param modifiedby */
    public Ismapm(String active, String apmpagename, String apmpagetitle, Date createdate, Long createdby, String deleted, Date modidate, com.sellerportal.model.Ismcnd ismcnd, Set<Ismacm> ismacms) {
        this.active = active;
        this.apmpagename = apmpagename;
        this.apmpagetitle = apmpagetitle;
        this.createdate = createdate;
        this.createdby = createdby;
        this.deleted = deleted;
        this.modidate = modidate;
        this.ismcnd = ismcnd;
        this.ismacms = ismacms;
//        this.modifiedby=modifiedby;
    }

    /** default constructor */
    public Ismapm() {
    }

    /** minimal constructor 
     * @param modifiedby */
    public Ismapm(Date createdate, Long createdby, String deleted, Date modidate, com.sellerportal.model.Ismcnd ismcnd, Set<Ismacm> ismacms) {
        this.createdate = createdate;
        this.createdby = createdby;
        this.deleted = deleted;
        this.modidate = modidate;
//        this.modifiedby=modifiedby;
        this.ismcnd = ismcnd;
        this.ismacms = ismacms;
    }

    /** 
     * 		       auto_increment
     * 		    
     */
    public Long getApmrfnum() {
        return this.apmrfnum;
    }

    public void setApmrfnum(Long apmrfnum) {
        this.apmrfnum = apmrfnum;
    }

    public String getActive() {
        return this.active;
    }

    public void setActive(String active) {
        this.active = active;
    }

    public String getApmpagename() {
        return this.apmpagename;
    }

    public void setApmpagename(String apmpagename) {
        this.apmpagename = apmpagename;
    }

    public String getApmpagetitle() {
        return this.apmpagetitle;
    }

    public void setApmpagetitle(String apmpagetitle) {
        this.apmpagetitle = apmpagetitle;
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

    public com.sellerportal.model.Ismcnd getIsmcnd() {
        return this.ismcnd;
    }

    public void setIsmcnd(com.sellerportal.model.Ismcnd ismcnd) {
        this.ismcnd = ismcnd;
    }

    public Set<Ismacm> getIsmacms() {
        return this.ismacms;
    }

    public void setIsmacms(Set<Ismacm> ismacms) {
        this.ismacms = ismacms;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("apmrfnum", getApmrfnum())
            .toString();
    }

//	public Long getModifiedby() {
//		return modifiedby;
//	}
//
//	public void setModifiedby(Long modifiedby) {
//		this.modifiedby = modifiedby;
//	}

}
