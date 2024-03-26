package com.sellerportal.model;

import java.io.Serializable;
import java.util.Date;

import org.apache.commons.lang.builder.ToStringBuilder;

import javax.persistence.*;

@Entity
@Table(name = "ISMMSC")
public class Ismmsc implements Serializable {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MSCRFNUM")
    private Long mscrfnum;

    @Column(name = "ACTIVE", nullable = false, length = 1)
    private String active;

    @Column(name = "CREATEDATE", nullable = false)
    private Date createdate;

    @Column(name = "CREATEDBY", nullable = false)
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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "MDMRFNUM", nullable = false)
    private Ismmdm ismmdm;

    /** full constructor */
    public Ismmsc(String active, Date createdate, Long createdby, String deleted, String fldstr1, String fldstr2, String fldstr3, Date fldtstamp1, Date modidate, String name, com.sellerportal.model.Ismmdm ismmdm) {
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
        this.ismmdm = ismmdm;
    }

    /** default constructor */
    public Ismmsc() {
    }

    /** minimal constructor */
    public Ismmsc(String active, Date createdate, Long createdby, String deleted, Date fldtstamp1, Date modidate, String name, com.sellerportal.model.Ismmdm ismmdm) {
        this.active = active;
        this.createdate = createdate;
        this.createdby = createdby;
        this.deleted = deleted;
        this.fldtstamp1 = fldtstamp1;
        this.modidate = modidate;
        this.name = name;
        this.ismmdm = ismmdm;
    }

    /** 
     * 		       auto_increment
     * 		    
     */
    public Long getMscrfnum() {
        return this.mscrfnum;
    }

    public void setMscrfnum(Long mscrfnum) {
        this.mscrfnum = mscrfnum;
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

    public com.sellerportal.model.Ismmdm getIsmmdm() {
        return this.ismmdm;
    }

    public void setIsmmdm(com.sellerportal.model.Ismmdm ismmdm) {
        this.ismmdm = ismmdm;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("mscrfnum", getMscrfnum())
            .toString();
    }

}
