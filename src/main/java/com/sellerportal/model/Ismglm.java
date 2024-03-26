package com.sellerportal.model;

import java.io.Serializable;
import java.util.Date;

import org.apache.commons.lang.builder.ToStringBuilder;
import javax.persistence.*;


@Entity
@Table(name = "ISMGLM")
public class Ismglm implements Serializable {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "GLMRFNUM")
    private Long glmrfnum;

    @Column(name = "CREATEDATE", nullable = false)
    private Date createdate;

    @Column(name = "CREATEDBY", nullable = false)
    private Long createdby;

    @Column(name = "DELETED", nullable = false, length = 1)
    private String deleted;

    @Column(name = "ISACTIVE", nullable = false, length = 1)
    private String isactive;

    @Column(name = "ISDEFAULT", nullable = false, length = 1)
    private String isdefault;

    @Column(name = "MODIDATE", nullable = false)
    private Date modidate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "GLMGLTRFNUM", nullable = false)
    private Ismglt ismglt;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "GLMGOTRFNUM", nullable = false)
    private Ismgot ismgot;

    /** full constructor */
    public Ismglm(Date createdate, Long createdby, String deleted, String isactive, String isdefault, Date modidate, com.sellerportal.model.Ismglt ismglt, com.sellerportal.model.Ismgot ismgot) {
        this.createdate = createdate;
        this.createdby = createdby;
        this.deleted = deleted;
        this.isactive = isactive;
        this.isdefault = isdefault;
        this.modidate = modidate;
        this.ismglt = ismglt;
        this.ismgot = ismgot;
    }

    /** default constructor */
    public Ismglm() {
    }

    /** 
     * 		       auto_increment
     * 		    
     */
    public Long getGlmrfnum() {
        return this.glmrfnum;
    }

    public void setGlmrfnum(Long glmrfnum) {
        this.glmrfnum = glmrfnum;
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

    public String getIsactive() {
        return this.isactive;
    }

    public void setIsactive(String isactive) {
        this.isactive = isactive;
    }

    public String getIsdefault() {
        return this.isdefault;
    }

    public void setIsdefault(String isdefault) {
        this.isdefault = isdefault;
    }

    public Date getModidate() {
        return this.modidate;
    }

    public void setModidate(Date modidate) {
        this.modidate = modidate;
    }

    public com.sellerportal.model.Ismglt getIsmglt() {
        return this.ismglt;
    }

    public void setIsmglt(com.sellerportal.model.Ismglt ismglt) {
        this.ismglt = ismglt;
    }

    public com.sellerportal.model.Ismgot getIsmgot() {
        return this.ismgot;
    }

    public void setIsmgot(com.sellerportal.model.Ismgot ismgot) {
        this.ismgot = ismgot;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("glmrfnum", getGlmrfnum())
            .toString();
    }

}
