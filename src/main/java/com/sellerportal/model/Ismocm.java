package com.sellerportal.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;
import javax.persistence.*;

import org.apache.commons.lang.builder.ToStringBuilder;


@Entity
@Table(name = "ISMOCM")
public class Ismocm implements Serializable {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "OCMRFNUM")
    private Long ocmrfnum;

    @Column(name = "CREATEDATE", nullable = false)
    private Date createdate;

    @Column(name = "CREATEDBY", nullable = false)
    private Long createdby;

    @Column(name = "DELETED", nullable = false, length = 1)
    private String deleted;

    @Column(name = "MODIDATE", nullable = false)
    private Date modidate;

    @Column(name = "OCMACTIVE", nullable = false, length = 1)
    private String ocmactive;

    @Column(name = "OCMCOMMAND", nullable = false, length = 1024)
    private String ocmcommand;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "OCMOPMRFNUM", nullable = false)
    private Ismopm ismopm;

    @OneToMany(mappedBy = "ismocm", fetch = FetchType.LAZY)
    @Transient
    private Set<Ismocr> ismocrs;

    /** full constructor */
    public Ismocm(Date createdate, Long createdby, String deleted, Date modidate, String ocmactive, String ocmcommand, com.sellerportal.model.Ismopm ismopm, Set<Ismocr> ismocrs) {
        this.createdate = createdate;
        this.createdby = createdby;
        this.deleted = deleted;
        this.modidate = modidate;
        this.ocmactive = ocmactive;
        this.ocmcommand = ocmcommand;
        this.ismopm = ismopm;
        this.ismocrs = ismocrs;
    }

    /** default constructor */
    public Ismocm() {
    }

    /** 
     * 		       auto_increment
     * 		    
     */
    public Long getOcmrfnum() {
        return this.ocmrfnum;
    }

    public void setOcmrfnum(Long ocmrfnum) {
        this.ocmrfnum = ocmrfnum;
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

    public String getOcmactive() {
        return this.ocmactive;
    }

    public void setOcmactive(String ocmactive) {
        this.ocmactive = ocmactive;
    }

    public String getOcmcommand() {
        return this.ocmcommand;
    }

    public void setOcmcommand(String ocmcommand) {
        this.ocmcommand = ocmcommand;
    }

    public com.sellerportal.model.Ismopm getIsmopm() {
        return this.ismopm;
    }

    public void setIsmopm(com.sellerportal.model.Ismopm ismopm) {
        this.ismopm = ismopm;
    }

    public Set<Ismocr> getIsmocrs() {
        return this.ismocrs;
    }

    public void setIsmocrs(Set<Ismocr> ismocrs) {
        this.ismocrs = ismocrs;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("ocmrfnum", getOcmrfnum())
            .toString();
    }

}
