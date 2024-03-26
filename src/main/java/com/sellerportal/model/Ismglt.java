package com.sellerportal.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import org.apache.commons.lang3.builder.ToStringBuilder;

import javax.persistence.*;

/** @author Hibernate CodeGenerator */
@Entity
@Table(name = "ISMGLT")
public class Ismglt implements Serializable {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "GLTRFNUM")
    private Long gltrfnum;

    @Column(name = "CREATEDATE", nullable = true)
    private Date createdate;

    @Column(name = "CREATEDBY", length = 20)
    private Long createdby;

    @Column(name = "DELETED", length = 1)
    private String deleted;

    @Column(name = "GLTCODE", nullable = true, length = 4)
    private String gltcode;

    @Column(name = "GLTDESC", length = 2048)
    private String gltdesc;

    @Column(name = "MODIDATE", nullable = true)
    private Date modidate;

    @OneToMany(mappedBy = "ismglt", fetch = FetchType.LAZY)
    @Transient
    private Set<Ismglm> ismglms;

    /** full constructor */
    public Ismglt(Date createdate, Long createdby, String deleted, String gltcode, String gltdesc, Date modidate, Set<Ismglm> ismglms) {
        this.createdate = createdate;
        this.createdby = createdby;
        this.deleted = deleted;
        this.gltcode = gltcode;
        this.gltdesc = gltdesc;
        this.modidate = modidate;
        this.ismglms = ismglms;
    }

    /** default constructor */
    public Ismglt() {
    }

    /** minimal constructor */
    public Ismglt(Date createdate, String gltcode, Date modidate, Set<Ismglm> ismglms) {
        this.createdate = createdate;
        this.gltcode = gltcode;
        this.modidate = modidate;
        this.ismglms = ismglms;
    }

    /** 
     * 		       auto_increment
     * 		    
     */
    public Long getGltrfnum() {
        return this.gltrfnum;
    }

    public void setGltrfnum(Long gltrfnum) {
        this.gltrfnum = gltrfnum;
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

    public String getGltcode() {
        return this.gltcode;
    }

    public void setGltcode(String gltcode) {
        this.gltcode = gltcode;
    }

    public String getGltdesc() {
        return this.gltdesc;
    }

    public void setGltdesc(String gltdesc) {
        this.gltdesc = gltdesc;
    }

    public Date getModidate() {
        return this.modidate;
    }

    public void setModidate(Date modidate) {
        this.modidate = modidate;
    }

    public Set<Ismglm> getIsmglms() {
        return this.ismglms;
    }

    public void setIsmglms(Set<Ismglm> ismglms) {
        this.ismglms = ismglms;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("gltrfnum", getGltrfnum())
            .toString();
    }

}
