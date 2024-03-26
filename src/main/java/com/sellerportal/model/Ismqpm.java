package com.sellerportal.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.apache.commons.lang.builder.ToStringBuilder;


/** @author Hibernate CodeGenerator */
@Entity
@Table(name = "Ismqpm")
public class Ismqpm implements Serializable {

	/** identifier field */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long qpmrfnum;

    /** persistent field */
    @Column(name = "active")
    private String active;

    /** persistent field */
    @Column(name = "createdate")
    private Date createdate;

    /** persistent field */
    @Column(name = "createdby")
    private Long createdby;

    /** persistent field */
    @Column(name = "deleted")
    private String deleted;

    /** nullable persistent field */
    @Column(name = "fldstr1")
    private String fldstr1;

    /** nullable persistent field */
    @Column(name = "fldstr2")
    private String fldstr2;

    /** nullable persistent field */
    @Column(name = "fldstr3")
    private String fldstr3;

    /** persistent field */
    @Column(name = "fldtstamp1")
    private Date fldtstamp1;

    /** persistent field */
    @Column(name = "modidate")
    private Date modidate;

    /** persistent field */
    @Column(name = "name")
    private String name;

    /** persistent field */
    @Column(name = "type")
    private String type;

    /** nullable persistent field */
    @Column(name = "value")
    private String value;

    /** persistent field */
    @ManyToOne
    @JoinColumn(name = "QDMRFNUM")
    private Ismqdm ismqdm;

    /** full constructor */
    public Ismqpm(String active, Date createdate, Long createdby, String deleted, String fldstr1, String fldstr2, String fldstr3, Date fldtstamp1, Date modidate, String name, String type, String value, Ismqdm ismqdm) {
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
        this.type = type;
        this.value = value;
        this.ismqdm = ismqdm;
    }

    /** default constructor */
    public Ismqpm() {
    }

    /** minimal constructor */
    public Ismqpm(String active, Date createdate, Long createdby, String deleted, Date fldtstamp1, Date modidate, String name, String type, Ismqdm ismqdm) {
        this.active = active;
        this.createdate = createdate;
        this.createdby = createdby;
        this.deleted = deleted;
        this.fldtstamp1 = fldtstamp1;
        this.modidate = modidate;
        this.name = name;
        this.type = type;
        this.ismqdm = ismqdm;
    }

    /** 
     * 		       auto_increment
     * 		    
     */
    public Long getQpmrfnum() {
        return this.qpmrfnum;
    }

    public void setQpmrfnum(Long qpmrfnum) {
        this.qpmrfnum = qpmrfnum;
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

    public String getType() {
        return this.type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getValue() {
        return this.value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Ismqdm getIsmqdm() {
        return this.ismqdm;
    }

    public void setIsmqdm(Ismqdm ismqdm) {
        this.ismqdm = ismqdm;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("qpmrfnum", getQpmrfnum())
            .toString();
    }

}
