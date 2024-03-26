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
@Table(name = "Ismpml")
public class Ismpml implements Serializable {

	/** identifier field */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long pmlrfnum;

    /** persistent field */
    @Column(name = "createdate")
    private Date createdate;

    /** persistent field */
    @Column(name = "createdby")
    private Integer createdby;

    /** persistent field */
    @Column(name = "deleted")
    private String deleted;

    /** persistent field */
    @Column(name = "modidate")
    private Date modidate;

    /** nullable persistent field */
    @Column(name = "pmlcndtype")
    private Long pmlcndtype;

    /** nullable persistent field */
    @Column(name = "pmldemcsv")
    private Long pmldemcsv;

    /** nullable persistent field */
    @Column(name = "pmldesc")
    private String pmldesc;

    /** nullable persistent field */
    @Column(name = "pmlimg")
    private String pmlimg;

    /** persistent field */
    @Column(name = "pmlisactive")
    private String pmlisactive;

    /** persistent field */
    @Column(name = "pmlisvisible")
    private String pmlisvisible;

    /** persistent field */
    @Column(name = "pmlname")
    private String pmlname;

    /** persistent field */
    @Column(name = "pmlpackdur")
    private Integer pmlpackdur;

    /** persistent field */
    @Column(name = "pmlprice")
    private Double pmlprice;

    /** persistent field */
    @ManyToOne
    @JoinColumn(name = "PMLCNDPDURUNIT")
    private Ismcnd ismcndByPmlcndpdurunit;

    /** persistent field */
    @ManyToOne
    @JoinColumn(name = "PMLCNDPRICETY")
    private Ismcnd ismcndByPmlcndpricety;

    /** persistent field */
    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY, mappedBy = "ismpml")
    @Transient
    private Set<Ismpsl> ismpsls;

    /** full constructor */
    public Ismpml(Date createdate, Integer createdby, String deleted, Date modidate, Long pmlcndtype, Long pmldemcsv, String pmldesc, String pmlimg, String pmlisactive, String pmlisvisible, String pmlname, Integer pmlpackdur, Double pmlprice,  Ismcnd ismcndByPmlcndpdurunit,  Ismcnd ismcndByPmlcndpricety, Set<Ismpsl> ismpsls) {
        this.createdate = createdate;
        this.createdby = createdby;
        this.deleted = deleted;
        this.modidate = modidate;
        this.pmlcndtype = pmlcndtype;
        this.pmldemcsv = pmldemcsv;
        this.pmldesc = pmldesc;
        this.pmlimg = pmlimg;
        this.pmlisactive = pmlisactive;
        this.pmlisvisible = pmlisvisible;
        this.pmlname = pmlname;
        this.pmlpackdur = pmlpackdur;
        this.pmlprice = pmlprice;
        this.ismcndByPmlcndpdurunit = ismcndByPmlcndpdurunit;
        this.ismcndByPmlcndpricety = ismcndByPmlcndpricety;
        this.ismpsls = ismpsls;
    }

    /** default constructor */
    public Ismpml() {
    }

    /** minimal constructor */
    public Ismpml(Date createdate, Integer createdby, String deleted, Date modidate, String pmlisactive, String pmlisvisible, String pmlname, Integer pmlpackdur, Double pmlprice,  Ismcnd ismcndByPmlcndpdurunit,  Ismcnd ismcndByPmlcndpricety, Set<Ismpsl> ismpsls) {
        this.createdate = createdate;
        this.createdby = createdby;
        this.deleted = deleted;
        this.modidate = modidate;
        this.pmlisactive = pmlisactive;
        this.pmlisvisible = pmlisvisible;
        this.pmlname = pmlname;
        this.pmlpackdur = pmlpackdur;
        this.pmlprice = pmlprice;
        this.ismcndByPmlcndpdurunit = ismcndByPmlcndpdurunit;
        this.ismcndByPmlcndpricety = ismcndByPmlcndpricety;
        this.ismpsls = ismpsls;
    }

    /** 
     * 		       auto_increment
     * 		    
     */
    public Long getPmlrfnum() {
        return this.pmlrfnum;
    }

    public void setPmlrfnum(Long pmlrfnum) {
        this.pmlrfnum = pmlrfnum;
    }

    public Date getCreatedate() {
        return this.createdate;
    }

    public void setCreatedate(Date createdate) {
        this.createdate = createdate;
    }

    public Integer getCreatedby() {
        return this.createdby;
    }

    public void setCreatedby(Integer createdby) {
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

    public Long getPmlcndtype() {
        return this.pmlcndtype;
    }

    public void setPmlcndtype(Long pmlcndtype) {
        this.pmlcndtype = pmlcndtype;
    }

    public Long getPmldemcsv() {
        return this.pmldemcsv;
    }

    public void setPmldemcsv(Long pmldemcsv) {
        this.pmldemcsv = pmldemcsv;
    }

    public String getPmldesc() {
        return this.pmldesc;
    }

    public void setPmldesc(String pmldesc) {
        this.pmldesc = pmldesc;
    }

    public String getPmlimg() {
        return this.pmlimg;
    }

    public void setPmlimg(String pmlimg) {
        this.pmlimg = pmlimg;
    }

    public String getPmlisactive() {
        return this.pmlisactive;
    }

    public void setPmlisactive(String pmlisactive) {
        this.pmlisactive = pmlisactive;
    }

    public String getPmlisvisible() {
        return this.pmlisvisible;
    }

    public void setPmlisvisible(String pmlisvisible) {
        this.pmlisvisible = pmlisvisible;
    }

    public String getPmlname() {
        return this.pmlname;
    }

    public void setPmlname(String pmlname) {
        this.pmlname = pmlname;
    }

    public Integer getPmlpackdur() {
        return this.pmlpackdur;
    }

    public void setPmlpackdur(Integer pmlpackdur) {
        this.pmlpackdur = pmlpackdur;
    }

    public Double getPmlprice() {
        return this.pmlprice;
    }

    public void setPmlprice(Double pmlprice) {
        this.pmlprice = pmlprice;
    }

    public  Ismcnd getIsmcndByPmlcndpdurunit() {
        return this.ismcndByPmlcndpdurunit;
    }

    public void setIsmcndByPmlcndpdurunit(Ismcnd ismcndByPmlcndpdurunit) {
        this.ismcndByPmlcndpdurunit = ismcndByPmlcndpdurunit;
    }

    public  Ismcnd getIsmcndByPmlcndpricety() {
        return this.ismcndByPmlcndpricety;
    }

    public void setIsmcndByPmlcndpricety(Ismcnd ismcndByPmlcndpricety) {
        this.ismcndByPmlcndpricety = ismcndByPmlcndpricety;
    }

    public Set<Ismpsl> getIsmpsls() {
        return this.ismpsls;
    }

    public void setIsmpsls(Set<Ismpsl> ismpsls) {
        this.ismpsls = ismpsls;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("pmlrfnum", getPmlrfnum())
            .toString();
    }

}
