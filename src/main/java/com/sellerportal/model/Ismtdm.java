package com.sellerportal.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;
import javax.persistence.*;

import org.apache.commons.lang.builder.ToStringBuilder;


@Entity
@Table(name = "ISMTDM")
public class Ismtdm implements Serializable {

	@Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ISMTDM_TDMRFNUM_SEQ")
    @SequenceGenerator(name = "ISMTDM_TDMRFNUM_SEQ", sequenceName = "ISMTDM_TDMRFNUM_SEQ", allocationSize = 1)
    @Column(name = "TDMRFNUM")
    private Long tdmrfnum;

    @Column(name = "ACTIVE", nullable = false, length = 1)
    private String active;

    @Column(name = "CREATEDATE", nullable = false)
    private Date createdate;

    @Column(name = "CREATEDBY", nullable = false, length = 20)
    private Long createdby;

    @Column(name = "DELETED", nullable = false, length = 1)
    private String deleted;

    @Column(name = "FLDSTR1", length = 1024)
    private String fldstr1;

    @Column(name = "FLDSTR2", length = 1024)
    private String fldstr2;

    @Column(name = "FLDSTR3", length = 1024)
    private String fldstr3;

    @Column(name = "FLDTSTAMP1", nullable = false)
    private Date fldtstamp1;

    @Column(name = "MODIDATE", nullable = false)
    private Date modidate;

    @Column(name = "NAME", nullable = false, length = 128)
    private String name;

    @Column(name = "TEMPLATEFILE", nullable = false, length = 512)
    private String templatefile;

    @Column(name = "TEMPLATETYPE", length = 1)
    private String templatetype;

    @OneToMany(mappedBy = "ismtdm",fetch = FetchType.LAZY)
    @Transient
    private Set<Ismtql> ismtqls;

    @OneToMany(mappedBy = "ismtdm",fetch = FetchType.LAZY)
    private Set<Ismmdm> ismmdms;


    /** full constructor */
    public Ismtdm(String active, Date createdate, Long createdby, String deleted, String fldstr1, String fldstr2, String fldstr3, Date fldtstamp1, Date modidate, String name, String templatefile, Set ismtqls, Set ismmdms,String templatetype) {
        this.active = active;
        this.createdate = createdate;
        this.createdby = createdby;
        this.deleted = deleted;
        this.fldstr1 = fldstr1;
        this.fldstr2 = fldstr2;
        this.fldstr3 = fldstr3;
        this.fldtstamp1 = fldtstamp1;
        this.modidate = modidate;
        this.name = name;
        this.templatefile = templatefile;
        this.ismtqls = ismtqls;
        this.ismmdms = ismmdms;
        this.templatetype=templatetype;
    }

    /** default constructor */
    public Ismtdm() {
    }

    /** minimal constructor */
    public Ismtdm(String active, Date createdate, Long createdby, String deleted, Date fldtstamp1, Date modidate, String name, String templatefile, Set ismtqls, Set ismmdms, String templatetype) {
        this.active = active;
        this.createdate = createdate;
        this.createdby = createdby;
        this.deleted = deleted;
        this.fldtstamp1 = fldtstamp1;
        this.modidate = modidate;
        this.name = name;
        this.templatefile = templatefile;
        this.ismtqls = ismtqls;
        this.ismmdms = ismmdms;
       this.templatetype=templatetype;
    }

    /**
     *                auto_increment
     *            
     */
    public Long getTdmrfnum() {
        return this.tdmrfnum;
    }

    public void setTdmrfnum(Long tdmrfnum) {
        this.tdmrfnum = tdmrfnum;
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

    public String getFldstr1() {
        return this.fldstr1;
    }

    public void setFldstr1(String fldstr1) {
        this.fldstr1 = fldstr1;
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

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTemplatefile() {
        return this.templatefile;
    }

    public void setTemplatefile(String templatefile) {
        this.templatefile = templatefile;
    }

    public Set getIsmtqls() {
        return this.ismtqls;
    }

    public void setIsmtqls(Set ismtqls) {
        this.ismtqls = ismtqls;
    }

    public Set getIsmmdms() {
        return this.ismmdms;
    }

    public void setIsmmdms(Set ismmdms) {
        this.ismmdms = ismmdms;
    }
    public String getTemplatetype() {
        return this.templatetype;
    }

    public void setTemplatetype(String templatetype) {
        this.templatetype = templatetype;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("tdmrfnum", getTdmrfnum())
            .toString();
    }

}
