package com.sellerportal.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import org.apache.commons.lang.builder.ToStringBuilder;
import javax.persistence.*;

@Entity
@Table(name = "ISMQDM")
public class Ismqdm implements Serializable {

	@Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ISMQDM_QDMRFNUM_SEQ")
    @SequenceGenerator(name = "ISMQDM_QDMRFNUM_SEQ", sequenceName = "ISMQDM_QDMRFNUM_SEQ", allocationSize = 1)
    @Column(name = "QDMRFNUM")
    private Long qdmrfnum;

    @Column(name = "ACTIVE", nullable = false, length = 1)
    private String active;

    @Column(name = "CREATEDATE", nullable = false)
    private Date createdate;

    @Column(name = "CREATEDBY", nullable = false, length = 20)
    private Long createdby;

    @Column(name = "DELETED", nullable = false, length = 1)
    private String deleted;

    @Column(name = "FLDSTR2", length = 1024)
    private String fldstr2;

    @Column(name = "FLDSTR3", length = 1024)
    private String fldstr3;

    @Column(name = "FLDTSTAMP1", nullable = false)
    private Date fldtstamp1;

    @Column(name = "MODIDATE", nullable = false)
    private Date modidate;

    @Column(name = "QDESC", length = 1024)
    private String qdesc;

    @Column(name = "QRYEXECUTOR", length = 1024)
    private String qryexecutor;

    @Column(name = "QUERY", nullable = false, length = 4096)
    private String query;

    @OneToMany(mappedBy = "ismqdm")
    @Transient
    private Set<Ismtql> ismtqls;

    @OneToMany(mappedBy = "ismqdmByToqdmrfnum", fetch = FetchType.LAZY)
    private Set<Ismmdm> ismmdmsByToqdmrfnum;

    @OneToMany(mappedBy = "ismqdmByCcqdmrfnum", fetch = FetchType.LAZY)
    private Set<Ismmdm> ismmdmsByCcqdmrfnum;

    @OneToMany(mappedBy = "ismqdmByBccqdmrfnum", fetch = FetchType.LAZY)
    private Set<Ismmdm> ismmdmsByBccqdmrfnum;

    @OneToMany(mappedBy = "ismqdm", fetch = FetchType.LAZY)
    private Set<Ismqpm> ismqpms;

    /** full constructor */
    public Ismqdm(String active, Date createdate, Long createdby, String deleted, String fldstr2, String fldstr3, Date fldtstamp1, Date modidate, String qdesc, String qryexecutor, String query, Set ismtqls, Set ismmdmsByToqdmrfnum, Set ismmdmsByCcqdmrfnum, Set ismmdmsByBccqdmrfnum, Set ismqpms) {
        this.active = active;
        this.createdate = createdate;
        this.createdby = createdby;
        this.deleted = deleted;
        this.fldstr2 = fldstr2;
        this.fldstr3 = fldstr3;
        this.fldtstamp1 = fldtstamp1;
        this.modidate = modidate;
        this.qdesc = qdesc;
        this.qryexecutor = qryexecutor;
        this.query = query;
        this.ismtqls = ismtqls;
        this.ismmdmsByToqdmrfnum = ismmdmsByToqdmrfnum;
        this.ismmdmsByCcqdmrfnum = ismmdmsByCcqdmrfnum;
        this.ismmdmsByBccqdmrfnum = ismmdmsByBccqdmrfnum;
        this.ismqpms = ismqpms;
    }

    /** default constructor */
    public Ismqdm() {
    }

    /** minimal constructor */
    public Ismqdm(String active, Date createdate, Long createdby, String deleted, Date fldtstamp1, Date modidate, String query, Set ismtqls, Set ismmdmsByToqdmrfnum, Set ismmdmsByCcqdmrfnum, Set ismmdmsByBccqdmrfnum, Set ismqpms) {
        this.active = active;
        this.createdate = createdate;
        this.createdby = createdby;
        this.deleted = deleted;
        this.fldtstamp1 = fldtstamp1;
        this.modidate = modidate;
        this.query = query;
        this.ismtqls = ismtqls;
        this.ismmdmsByToqdmrfnum = ismmdmsByToqdmrfnum;
        this.ismmdmsByCcqdmrfnum = ismmdmsByCcqdmrfnum;
        this.ismmdmsByBccqdmrfnum = ismmdmsByBccqdmrfnum;
        this.ismqpms = ismqpms;
    }

    /** 
     * 		       auto_increment
     * 		    
     */
    public Long getQdmrfnum() {
        return this.qdmrfnum;
    }

    public void setQdmrfnum(Long qdmrfnum) {
        this.qdmrfnum = qdmrfnum;
    }

    public String getActive() {
        return this.active;
    }

    public void setActive(String active) {
        this.active = active;
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

    public String getFldstr2() {
        return this.fldstr2;
    }

    public void setFldstr2(String fldstr2) {
        this.fldstr2 = fldstr2;
    }

    public String getFldstr3() {
        return this.fldstr3;
    }

    public void setFldstr3(String fldstr3) {
        this.fldstr3 = fldstr3;
    }

    public Date getFldtstamp1() {
        return this.fldtstamp1;
    }

    public void setFldtstamp1(Date fldtstamp1) {
        this.fldtstamp1 = fldtstamp1;
    }

    public Date getModidate() {
        return this.modidate;
    }

    public void setModidate(Date modidate) {
        this.modidate = modidate;
    }

    public String getQdesc() {
        return this.qdesc;
    }

    public void setQdesc(String qdesc) {
        this.qdesc = qdesc;
    }

    public String getQryexecutor() {
        return this.qryexecutor;
    }

    public void setQryexecutor(String qryexecutor) {
        this.qryexecutor = qryexecutor;
    }

    public String getQuery() {
        return this.query;
    }

    public void setQuery(String query) {
        this.query = query;
    }

    public Set<Ismtql> getIsmtqls() {
        return this.ismtqls;
    }

    public void setIsmtqls(Set<Ismtql> ismtqls) {
        this.ismtqls = ismtqls;
    }

    public Set<Ismmdm> getIsmmdmsByToqdmrfnum() {
        return this.ismmdmsByToqdmrfnum;
    }

    public void setIsmmdmsByToqdmrfnum(Set<Ismmdm> ismmdmsByToqdmrfnum) {
        this.ismmdmsByToqdmrfnum = ismmdmsByToqdmrfnum;
    }

    public Set getIsmmdmsByCcqdmrfnum() {
        return this.ismmdmsByCcqdmrfnum;
    }

    public void setIsmmdmsByCcqdmrfnum(Set ismmdmsByCcqdmrfnum) {
        this.ismmdmsByCcqdmrfnum = ismmdmsByCcqdmrfnum;
    }

    public Set getIsmmdmsByBccqdmrfnum() {
        return this.ismmdmsByBccqdmrfnum;
    }

    public void setIsmmdmsByBccqdmrfnum(Set ismmdmsByBccqdmrfnum) {
        this.ismmdmsByBccqdmrfnum = ismmdmsByBccqdmrfnum;
    }

    public Set getIsmqpms() {
        return this.ismqpms;
    }

    public void setIsmqpms(Set ismqpms) {
        this.ismqpms = ismqpms;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("qdmrfnum", getQdmrfnum())
            .toString();
    }

}
