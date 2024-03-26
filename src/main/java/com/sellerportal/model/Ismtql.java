package com.sellerportal.model;

import java.io.Serializable;
import java.util.Date;

import org.apache.commons.lang.builder.ToStringBuilder;
import javax.persistence.*;

/** @author Hibernate CodeGenerator */
public class Ismtql implements Serializable {

	@Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ISMTQL_TQLRFNUM_SEQ")
    @SequenceGenerator(name = "ISMTQL_TQLRFNUM_SEQ", sequenceName = "ISMTQL_TQLRFNUM_SEQ", allocationSize = 1)
    @Column(name = "TQLRFNUM")
    private Long tqlrfnum;

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

    @Column(name = "FLDTSTAMP1")
    private Date fldtstamp1;

    @Column(name = "MODIDATE", nullable = false)
    private Date modidate;

    @Column(name = "TAGCLASS", length = 512)
    private String tagclass;

    @Column(name = "TAGNAME", nullable = false, length = 512)
    private String tagname;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "QDMRFNUM", nullable = false)
    private Ismqdm ismqdm;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "TDMRFNUM", nullable = false)
    private Ismtdm ismtdm;

    /** full constructor */
    public Ismtql(String active, Date createdate, Long createdby, String deleted, String fldstr1, String fldstr2, String fldstr3, Date fldtstamp1, Date modidate, String tagclass, String tagname, com.sellerportal.model.Ismqdm ismqdm, com.sellerportal.model.Ismtdm ismtdm) {
        this.active = active;
        this.createdate = createdate;
        this.createdby = createdby;
        this.deleted = deleted;
        this.fldstr1 = fldstr1;
        this.fldstr2 = fldstr2;
        this.fldstr3 = fldstr3;
        this.fldtstamp1 = fldtstamp1;
        this.modidate = modidate;
        this.tagclass = tagclass;
        this.tagname = tagname;
        this.ismqdm = ismqdm;
        this.ismtdm = ismtdm;
    }

    /** default constructor */
    public Ismtql() {
    }

    /** minimal constructor */
    public Ismtql(String active, Date createdate, Long createdby, String deleted, Date fldtstamp1, Date modidate, String tagname, com.sellerportal.model.Ismqdm ismqdm, com.sellerportal.model.Ismtdm ismtdm) {
        this.active = active;
        this.createdate = createdate;
        this.createdby = createdby;
        this.deleted = deleted;
        this.fldtstamp1 = fldtstamp1;
        this.modidate = modidate;
        this.tagname = tagname;
        this.ismqdm = ismqdm;
        this.ismtdm = ismtdm;
    }

    /** 
     * 		       auto_increment
     * 		    
     */
    public Long getTqlrfnum() {
        return this.tqlrfnum;
    }

    public void setTqlrfnum(Long tqlrfnum) {
        this.tqlrfnum = tqlrfnum;
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

    public String getTagclass() {
        return this.tagclass;
    }

    public void setTagclass(String tagclass) {
        this.tagclass = tagclass;
    }

    public String getTagname() {
        return this.tagname;
    }

    public void setTagname(String tagname) {
        this.tagname = tagname;
    }

    public com.sellerportal.model.Ismqdm getIsmqdm() {
        return this.ismqdm;
    }

    public void setIsmqdm(com.sellerportal.model.Ismqdm ismqdm) {
        this.ismqdm = ismqdm;
    }

    public com.sellerportal.model.Ismtdm getIsmtdm() {
        return this.ismtdm;
    }

    public void setIsmtdm(com.sellerportal.model.Ismtdm ismtdm) {
        this.ismtdm = ismtdm;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("tqlrfnum", getTqlrfnum())
            .toString();
    }

}
