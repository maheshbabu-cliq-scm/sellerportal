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
@Table(name = "Ismpit")
public class Ismpit implements Serializable {

    /** identifier field */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long pitrfnum;

    /** persistent field */
    @Column(name = "createdate")
    private Date createdate;

    /** persistent field */
    @Column(name = "createdby")
    private Long createdby;

    /** persistent field */
    @Column(name = "deleted")
    private String deleted;

    /** persistent field */
    @Column(name = "modidate")
    private Date modidate;

    /** persistent field */
    @Column(name = "pitimage")
    private String pitimage;

    /** persistent field */
    @Column(name = "pitimgtitle")
    private String pitimgtitle;

    /** nullable persistent field */
    @Column(name = "pitzoomimage")
    private String pitzoomimage;

    /** persistent field */
    @Column(name = "pitviewseq")
    private String pitviewseq;

    /** persistent field */
    @ManyToOne
    @JoinColumn(name = "PITPBIRFNUM")
    private Ismpbi ismpbi;

    /** persistent field */
    @ManyToOne
    @JoinColumn(name = "PITIMGATTRIBUTE")
    private OctParam octParamAttr;

    /** persistent field */
    @Column(name = "modifiedby")
    private Long modifiedby;

    /** persistent field */
    @Column(name = "pitpriority")
    private Long pitpriority;

    

    /** full constructor */
    public Ismpit(Date createdate, Long createdby, String deleted, Date modidate, String pitimage, String pitimgtitle, String pitzoomimage,Long pitpriority, Ismpbi ismpbi,OctParam octParamAttr,String pitviewseq,Long modifiedby) {
        this.createdate = createdate;
        this.createdby = createdby;
        this.deleted = deleted;
        this.modidate = modidate;
        this.pitimage = pitimage;
        this.pitimgtitle = pitimgtitle;
        this.pitzoomimage = pitzoomimage;
        this.ismpbi = ismpbi;
        this.pitviewseq = pitviewseq;
        this.modifiedby= modifiedby;
        this.octParamAttr = octParamAttr;
        this.pitpriority = pitpriority;
    }

    /** default constructor */
    public Ismpit() {
    }

    /** minimal constructor */
    public Ismpit(Date createdate, Long createdby, String deleted, Date modidate, String pitimage, String pitimgtitle, Ismpbi ismpbi,OctParam octParamAttr) {
        this.createdate = createdate;
        this.createdby = createdby;
        this.deleted = deleted;
        this.modidate = modidate;
        this.pitimage = pitimage;
        this.pitimgtitle = pitimgtitle;
        this.ismpbi = ismpbi;
     
        this.octParamAttr = octParamAttr;
    }

    /** 
     * 		       auto_increment
     * 		    
     */
    public Long getPitrfnum() {
        return this.pitrfnum;
    }

    public void setPitrfnum(Long pitrfnum) {
        this.pitrfnum = pitrfnum;
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
  

    public String getPitimage() {
        return this.pitimage;
    }

    public void setPitimage(String pitimage) {
        this.pitimage = pitimage;
    }
    
    public Long getPitpriority() {
		return pitpriority;
	}

	public void setPitpriority(Long pitpriority) {
		this.pitpriority = pitpriority;
	}

	public String getPitimgtitle() {
        return this.pitimgtitle;
    }

    public void setPitimgtitle(String pitimgtitle) {
        this.pitimgtitle = pitimgtitle;
    }

    public String getPitzoomimage() {
        return this.pitzoomimage;
    }

    public void setPitzoomimage(String pitzoomimage) {
        this.pitzoomimage = pitzoomimage;
    }

    public Ismpbi getIsmpbi() {
        return this.ismpbi;
    }

    public void setIsmpbi(Ismpbi ismpbi) {
        this.ismpbi = ismpbi;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("pitrfnum", getPitrfnum())
            .toString();
    }

	public String getPitviewseq() {
		return pitviewseq;
	}

	public void setPitviewseq(String pitviewseq) {
		this.pitviewseq = pitviewseq;
	}

	public OctParam getOctParamAttr() {
		return octParamAttr;
	}

	public void setOctParamAttr(OctParam octParamAttr) {
		this.octParamAttr = octParamAttr;
	}

	public Long getModifiedby() {
		return modifiedby;
	}

	public void setModifiedby(Long modifiedby) {
		this.modifiedby = modifiedby;
	}
	
}
