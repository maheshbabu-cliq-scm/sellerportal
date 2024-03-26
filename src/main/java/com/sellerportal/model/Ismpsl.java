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
@Table(name = "ISMPSL")
public class Ismpsl implements Serializable {

    /** identifier field */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long PSLRFNUM;

    /** persistent field */
    @Column(name = "CREATEDATE")
    private Date CREATEDATE;

    /** persistent field */
    @Column(name = "CREATEDBY")
    private Integer CREATEDBY;

    /** persistent field */
    @Column(name = "DELETED")
    private String DELETED;

    /** persistent field */
    @Column(name = "MODIDATE")
    private Date MODIDATE;

    /** persistent field */
    @Column(name = "PSLISLIMITED")
    private String PSLISLIMITED;

    /** nullable persistent field */
    @Column(name = "PSLUNITS")
    private Integer PSLUNITS;

    /** persistent field */
    @ManyToOne
    @JoinColumn(name = "PSLSMLRFNUM")
    private Ismsml ISMSML;

    /** persistent field */
    @ManyToOne
    @JoinColumn(name = "PSLPMLRFNUM")
    private Ismpml ISMPML;

    /** full constructor */
    public Ismpsl(Date createdate, Integer createdby, String deleted, Date modidate, String pslislimited, Integer pslunits, Ismsml ismsml, Ismpml ismpml) {
        this.CREATEDATE = createdate;
        this.CREATEDBY = createdby;
        this.DELETED = deleted;
        this.MODIDATE = modidate;
        this.PSLISLIMITED = pslislimited;
        this.PSLUNITS = pslunits;
        this.ISMSML = ismsml;
        this.ISMPML = ismpml;
    }

    /** default constructor */
    public Ismpsl() {
    }

    /** minimal constructor */
    public Ismpsl(Date createdate, Integer createdby, String deleted, Date modidate, String pslislimited, Ismsml ismsml, Ismpml ismpml) {
        this.CREATEDATE = createdate;
        this.CREATEDBY = createdby;
        this.DELETED = deleted;
        this.MODIDATE = modidate;
        this.PSLISLIMITED = pslislimited;
        this.ISMSML = ismsml;
        this.ISMPML = ismpml;
    }

    /** 
     * 		       auto_increment
     * 		    
     */
    public Long getPslrfnum() {
        return this.PSLRFNUM;
    }

    public void setPslrfnum(Long pslrfnum) {
        this.PSLRFNUM = pslrfnum;
    }

    public Date getCreatedate() {
        return this.CREATEDATE;
    }

    public void setCreatedate(Date createdate) {
        this.CREATEDATE = createdate;
    }

    public Integer getCreatedby() {
        return this.CREATEDBY;
    }

    public void setCreatedby(Integer createdby) {
        this.CREATEDBY = createdby;
    }

    public String getDeleted() {
        return this.DELETED;
    }

    public void setDeleted(String deleted) {
        this.DELETED = deleted;
    }

    public Date getModidate() {
        return this.MODIDATE;
    }

    public void setModidate(Date modidate) {
        this.MODIDATE = modidate;
    }

    public String getPslislimited() {
        return this.PSLISLIMITED;
    }

    public void setPslislimited(String pslislimited) {
        this.PSLISLIMITED = pslislimited;
    }

    public Integer getPslunits() {
        return this.PSLUNITS;
    }

    public void setPslunits(Integer pslunits) {
        this.PSLUNITS = pslunits;
    }

    public Ismsml getIsmsml() {
        return this.ISMSML;
    }

    public void setIsmsml(Ismsml ismsml) {
        this.ISMSML = ismsml;
    }

    public Ismpml getIsmpml() {
        return this.ISMPML;
    }

    public void setIsmpml(Ismpml ismpml) {
        this.ISMPML = ismpml;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("pslrfnum", getPslrfnum())
            .toString();
    }

}
