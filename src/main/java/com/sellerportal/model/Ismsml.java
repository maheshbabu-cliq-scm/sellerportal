package com.sellerportal.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.apache.commons.lang.builder.ToStringBuilder;


/** @author Hibernate CodeGenerator */
@Entity
@Table(name = "ISMSML")
public class Ismsml implements Serializable {

	/** identifier field */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long SMLRFNUM;

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
    @Column(name = "SMLISACTIVE")
    private String SMLISACTIVE;

    /** persistent field */
    @Column(name = "SMLISFREE")
    private String SMLISFREE;

    /** persistent field */
    @Column(name = "SMLSEQNUM")
    private Double SMLSEQNUM;

    /** persistent field */
    @Column(name = "SMLSERVISIBLE")
    private String SMLSERVISIBLE;

    /** persistent field */
    @ManyToOne
    @JoinColumn(name = "SMLCNDSER")
    private Ismcnd ISMCND;

    /** persistent field */
    @OneToMany(fetch = FetchType.EAGER,mappedBy = "ISMSML")
    @Transient
    private Set<Ismpsl> Ismpsls;


    /** full constructor */
    public Ismsml(Date createdate, Integer createdby, String deleted, Date modidate, String smlisactive, String smlisfree, Double smlseqnum, String smlservisible,  Ismcnd ismcnd, Set<Ismpsl> ismpsls) {
        this.CREATEDATE = createdate;
        this.CREATEDBY = createdby;
        this.DELETED = deleted;
        this.MODIDATE = modidate;
        this.SMLISACTIVE = smlisactive;
        this.SMLISFREE = smlisfree;
        this.SMLSEQNUM = smlseqnum;
        this.SMLSERVISIBLE = smlservisible;
        this.ISMCND = ismcnd;
        this.Ismpsls = ismpsls;
    }

    /** default constructor */
    public Ismsml() {
    }

    /** 
     * 		       auto_increment
     * 		    
     */
    public Long getSmlrfnum() {
        return this.SMLRFNUM;
    }

    public void setSmlrfnum(Long smlrfnum) {
        this.SMLRFNUM = smlrfnum;
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

    public String getSmlisactive() {
        return this.SMLISACTIVE;
    }

    public void setSmlisactive(String smlisactive) {
        this.SMLISACTIVE = smlisactive;
    }

    public String getSmlisfree() {
        return this.SMLISFREE;
    }

    public void setSmlisfree(String smlisfree) {
        this.SMLISFREE = smlisfree;
    }

    public Double getSmlseqnum() {
        return this.SMLSEQNUM;
    }

    public void setSmlseqnum(Double smlseqnum) {
        this.SMLSEQNUM = smlseqnum;
    }

    public String getSmlservisible() {
        return this.SMLSERVISIBLE;
    }

    public void setSmlservisible(String smlservisible) {
        this.SMLSERVISIBLE = smlservisible;
    }

    public  Ismcnd getIsmcnd() {
        return this.ISMCND;
    }

    public void setIsmcnd(Ismcnd ismcnd) {
        this.ISMCND = ismcnd;
    }

    public Set<Ismpsl> getIsmpsls() {
        return this.Ismpsls;
    }

    public void setIsmpsls(Set<Ismpsl> ismpsls) {
        this.Ismpsls = ismpsls;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("smlrfnum", getSmlrfnum())
            .toString();
    }

}
