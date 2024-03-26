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
@Table(name = "Ismppm")
public class Ismppm implements Serializable {

    /** identifier field */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ppmrfnum;

    /** persistent field */
    @Column(name = "CREATEDATE")
    private Date createdate;

    /** persistent field */
    @Column(name = "CREATEDBY")
    private Long createdby;

    /** persistent field */
    @Column(name = "DELETED")
    private String deleted;

    /** persistent field */
    @Column(name = "MODIDATE")
    private Date modidate;

    /** nullable persistent field */
    @Column(name = "PPMAPPRFNUM")
    private Long ppmapprfnum;

    /** nullable persistent field */
    @Column(name = "PPMISALLCITY")
    private String ppmisallcity;

    /** persistent field */
    @ManyToOne
    @JoinColumn(name = "PPMCNDMODETYPE")
    private Ismcnd ismcnd;

    /** persistent field */
    @ManyToOne
    @JoinColumn(name = "PPMPMTRFNUM")
    private Ismpmt ismpmt;

    /** persistent field */
    @ManyToOne
    @JoinColumn(name = "PPMPBIRFNUM")
    private Ismpbi ismpbi;

    /** persistent field */
    @ManyToOne
    @JoinColumn(name = "PPMCCGRFNUM")
    private Ismccg ismccg;

    /** persistent field */
    @Column(name = "MODIFIEDBY")
    private Long modifiedby;

    /** full constructor */
    public Ismppm(Date createdate, Long createdby, String deleted, Date modidate, Long ppmapprfnum, String ppmisallcity, Ismcnd ismcnd, Ismpmt ismpmt, Ismpbi ismpbi, /*com.sellerportal.model.Ismact ismact,*/Ismccg ismccg,Long modifiedby) {
        this.createdate = createdate;
        this.createdby = createdby;
        this.deleted = deleted;
        this.modidate = modidate;
        this.ppmapprfnum = ppmapprfnum;
        this.ppmisallcity = ppmisallcity;
        this.ismcnd = ismcnd;
        this.ismpmt = ismpmt;
        this.ismpbi = ismpbi;
        /*this.ismact = ismact;*/
        this.ismccg = ismccg;
        this.modifiedby= modifiedby;
    }

    /** default constructor */
    public Ismppm() {
    }

    /** minimal constructor */
    public Ismppm(Date createdate, Long createdby, String deleted, Date modidate, Ismcnd ismcnd, Ismpmt ismpmt, Ismpbi ismpbi,/* com.sellerportal.model.Ismact ismact,*/ Ismccg ismccg) {
        this.createdate = createdate;
        this.createdby = createdby;
        this.deleted = deleted;
        this.modidate = modidate;
        this.ismcnd = ismcnd;
        this.ismpmt = ismpmt;
        this.ismpbi = ismpbi;
        /*this.ismact = ismact;*/
        this.ismccg = ismccg;
    }

    /** 
     * 		       auto_increment
     * 		    
     */
    public Long getPpmrfnum() {
        return this.ppmrfnum;
    }

    public void setPpmrfnum(Long ppmrfnum) {
        this.ppmrfnum = ppmrfnum;
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

    public Long getPpmapprfnum() {
        return this.ppmapprfnum;
    }

    public void setPpmapprfnum(Long ppmapprfnum) {
        this.ppmapprfnum = ppmapprfnum;
    }

    public String getPpmisallcity() {
        return this.ppmisallcity;
    }

    public void setPpmisallcity(String ppmisallcity) {
        this.ppmisallcity = ppmisallcity;
    }

    public Ismcnd getIsmcnd() {
        return this.ismcnd;
    }

    public void setIsmcnd(Ismcnd ismcnd) {
        this.ismcnd = ismcnd;
    }

    public Ismpmt getIsmpmt() {
        return this.ismpmt;
    }

    public void setIsmpmt(Ismpmt ismpmt) {
        this.ismpmt = ismpmt;
    }

    public Ismpbi getIsmpbi() {
        return this.ismpbi;
    }

    public void setIsmpbi(Ismpbi ismpbi) {
        this.ismpbi = ismpbi;
    }

    /*public com.sellerportal.model.Ismact getIsmact() {
        return this.ismact;
    }

    public void setIsmact(com.sellerportal.model.Ismact ismact) {
        this.ismact = ismact;
    }*/

    public Ismccg getIsmccg() {
        return this.ismccg;
    }

    public void setIsmccg(Ismccg ismccg) {
        this.ismccg = ismccg;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("ppmrfnum", getPpmrfnum())
            .toString();
    }

	public Long getModifiedby() {
		return modifiedby;
	}

	public void setModifiedby(Long modifiedby) {
		this.modifiedby = modifiedby;
	}

}
