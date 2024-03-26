package com.sellerportal.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import org.apache.commons.lang.builder.ToStringBuilder;

import javax.persistence.*;

/** @author Hibernate CodeGenerator */
@Entity
@Table(name = "ISMACM")
public class Ismacm implements Serializable {

	@Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence")
    @SequenceGenerator(name = "sequence", sequenceName = "ISMACM_ACMRFNUM_SEQ", allocationSize = 1)
    @Column(name = "ACMRFNUM")
    private Long acmrfnum;

    @Column(name = "ACTIVE", length = 1)
    private String active;

    @Column(name = "COMMAND", length = 1024)
    private String command;

    @Column(name = "CREATEDATE", nullable = false)
    private Date createdate;

    @Column(name = "CREATEDBY", nullable = false)
    private Long createdby;

    @Column(name = "DELETED", nullable = false, length = 1)
    private String deleted;

    @Column(name = "MODIDATE", nullable = false)
    private Date modidate;

    @OneToMany(mappedBy = "ismacm")
    @Transient
    private Set<Ismacr> ismacrs;

    @ManyToOne
    @JoinColumn(name = "APMRFNUM", nullable = false)
    private Ismapm ismapm;

    /** full constructor */
    public Ismacm(String active, String command, Date createdate, Long createdby, String deleted, Date modidate, com.sellerportal.model.Ismapm ismapm, Set<Ismacr> ismacrs) {
        this.active = active;
        this.command = command;
        this.createdate = createdate;
        this.createdby = createdby;
        this.deleted = deleted;
        this.modidate = modidate;
        this.ismapm = ismapm;
        this.ismacrs = ismacrs;
    }

    /** default constructor */
    public Ismacm() {
    }

    /** minimal constructor */
    public Ismacm(Date createdate, Long createdby, String deleted, Date modidate, com.sellerportal.model.Ismapm ismapm, Set<Ismacr> ismacrs) {
        this.createdate = createdate;
        this.createdby = createdby;
        this.deleted = deleted;
        this.modidate = modidate;
        this.ismapm = ismapm;
        this.ismacrs = ismacrs;
    }

    /** 
     * 		       auto_increment
     * 		    
     */
    public Long getAcmrfnum() {
        return this.acmrfnum;
    }

    public void setAcmrfnum(Long acmrfnum) {
        this.acmrfnum = acmrfnum;
    }

    public String getActive() {
        return this.active;
    }

    public void setActive(String active) {
        this.active = active;
    }

    public String getCommand() {
        return this.command;
    }

    public void setCommand(String command) {
        this.command = command;
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

    public com.sellerportal.model.Ismapm getIsmapm() {
        return this.ismapm;
    }

    public void setIsmapm(com.sellerportal.model.Ismapm ismapm) {
        this.ismapm = ismapm;
    }

    public Set<Ismacr> getIsmacrs() {
        return this.ismacrs;
    }
 
 
    public void setIsmacrs(Set<Ismacr> ismacrs) {
        this.ismacrs = ismacrs;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("acmrfnum", getAcmrfnum())
            .toString();
    }

}
