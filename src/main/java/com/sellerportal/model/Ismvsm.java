package com.sellerportal.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Set;

import org.apache.commons.lang.builder.ToStringBuilder;
import javax.persistence.*;

@Entity
@Table(name = "ISMVSM")
public class Ismvsm implements Serializable {

	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    @Column(name = "VSMRFNUM")
	    private Long vsmrfnum;

	    @Column(name = "CREATEDATE", nullable = false)
	    private Date createdate;

	    @Column(name = "CREATEDBY", nullable = false)
	    private Long createdby;

	    @Column(name = "DELETED", nullable = false, length = 1)
	    private String deleted;

	    @Column(name = "MODIDATE", nullable = false)
	    private Date modidate;

	    @Column(name = "VSMALLDAY", length = 1)
	    private String vsmallday;

	    @Column(name = "VSMALLTIME", length = 1)
	    private String vsmalltime;

	    @Column(name = "VSMCARTDISCOUNT", length = 8)
	    private BigDecimal vsmcartdiscount;

	    @Column(name = "VSMENDDATE", length = 10)
	    private Date vsmenddate;

	    @Column(name = "VSMENDTIME", length = 8)
	    private Date vsmendtime;

	    @Column(name = "VSMISACTIVE", nullable = false, length = 1)
	    private String vsmisactive;

	    @Column(name = "VSMISADMIN", nullable = false, length = 1)
	    private String vsmisadmin;

	    @Column(name = "VSMISSHIPPFREE", nullable = false, length = 1)
	    private String vsmisshippfree;

	    @Column(name = "VSMMAXVALUE", length = 8)
	    private BigDecimal vsmmaxvalue;

	    @Column(name = "VSMMINVALUE", nullable = false, length = 8)
	    private BigDecimal vsmminvalue;

	    @Column(name = "VSMQTYFREE", length = 11)
	    private Integer vsmqtyfree;

	    @Column(name = "VSMSCHEMEDESC", nullable = false, length = 1024)
	    private String vsmschemedesc;

	    @Column(name = "VSMSCHEMENAME", nullable = false, length = 128)
	    private String vsmschemename;

	    @Column(name = "VSMSTARTDATE", length = 10)
	    private Date vsmstartdate;

	    @Column(name = "VSMSTARTTIME", length = 8)
	    private Date vsmstarttime;

	    @OneToMany(mappedBy = "ismvsm", fetch = FetchType.LAZY)
	    @Transient
	    private Set<Ismsgt> ismsgts;

	    @ManyToOne(fetch = FetchType.LAZY)
	    @JoinColumn(name = "VSMAFMRFNUM", nullable = false)
	    private Ismafm ismafm;


    /** full constructor */
    public Ismvsm(Date createdate, Long createdby, String deleted, Date modidate, String vsmallday, String vsmalltime, BigDecimal vsmcartdiscount, Date vsmenddate, Date vsmendtime, String vsmisactive, String vsmisadmin, String vsmisshippfree, BigDecimal vsmmaxvalue, BigDecimal vsmminvalue, Integer vsmqtyfree, String vsmschemedesc, String vsmschemename, Date vsmstartdate, Date vsmstarttime,com.sellerportal.model.Ismafm ismafm, Set<Ismsgt> ismsgts) {
        this.createdate = createdate;
        this.createdby = createdby;
        this.deleted = deleted;
        this.modidate = modidate;
        this.vsmallday = vsmallday;
        this.vsmalltime = vsmalltime;
        this.vsmcartdiscount = vsmcartdiscount;
        this.vsmenddate = vsmenddate;
        this.vsmendtime = vsmendtime;
        this.vsmisactive = vsmisactive;
        this.vsmisadmin = vsmisadmin;
        this.vsmisshippfree = vsmisshippfree;
        this.vsmmaxvalue = vsmmaxvalue;
        this.vsmminvalue = vsmminvalue;
        this.vsmqtyfree = vsmqtyfree;
        this.vsmschemedesc = vsmschemedesc;
        this.vsmschemename = vsmschemename;
        this.vsmstartdate = vsmstartdate;
        this.vsmstarttime = vsmstarttime;
        this.ismafm = ismafm;
        this.ismsgts = ismsgts;
    }

    /** default constructor */
    public Ismvsm() {
    }

    /** minimal constructor */
    public Ismvsm(Date createdate, Long createdby, String deleted, Date modidate, String vsmisactive, String vsmisadmin, String vsmisshippfree, BigDecimal vsmminvalue, String vsmschemedesc, String vsmschemename,com.sellerportal.model.Ismafm ismafm, Set<Ismsgt> ismsgts) {
        this.createdate = createdate;
        this.createdby = createdby;
        this.deleted = deleted;
        this.modidate = modidate;
        this.vsmisactive = vsmisactive;
        this.vsmisadmin = vsmisadmin;
        this.vsmisshippfree = vsmisshippfree;
        this.vsmminvalue = vsmminvalue;
        this.vsmschemedesc = vsmschemedesc;
        this.vsmschemename = vsmschemename;
        this.ismafm = ismafm;
        this.ismsgts = ismsgts;
    }

    /** 
     * 		       auto_increment
     * 		    
     */
    public Long getVsmrfnum() {
        return this.vsmrfnum;
    }

    public void setVsmrfnum(Long vsmrfnum) {
        this.vsmrfnum = vsmrfnum;
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

    public String getVsmallday() {
        return this.vsmallday;
    }

    public void setVsmallday(String vsmallday) {
        this.vsmallday = vsmallday;
    }

    public String getVsmalltime() {
        return this.vsmalltime;
    }

    public void setVsmalltime(String vsmalltime) {
        this.vsmalltime = vsmalltime;
    }

    public BigDecimal getVsmcartdiscount() {
        return this.vsmcartdiscount;
    }

    public void setVsmcartdiscount(BigDecimal vsmcartdiscount) {
        this.vsmcartdiscount = vsmcartdiscount;
    }

    public Date getVsmenddate() {
        return this.vsmenddate;
    }

    public void setVsmenddate(Date vsmenddate) {
        this.vsmenddate = vsmenddate;
    }

    public Date getVsmendtime() {
        return this.vsmendtime;
    }

    public void setVsmendtime(Date vsmendtime) {
        this.vsmendtime = vsmendtime;
    }

    public String getVsmisactive() {
        return this.vsmisactive;
    }

    public void setVsmisactive(String vsmisactive) {
        this.vsmisactive = vsmisactive;
    }

    public String getVsmisadmin() {
        return this.vsmisadmin;
    }

    public void setVsmisadmin(String vsmisadmin) {
        this.vsmisadmin = vsmisadmin;
    }

    public String getVsmisshippfree() {
        return this.vsmisshippfree;
    }

    public void setVsmisshippfree(String vsmisshippfree) {
        this.vsmisshippfree = vsmisshippfree;
    }

    public BigDecimal getVsmmaxvalue() {
        return this.vsmmaxvalue;
    }

    public void setVsmmaxvalue(BigDecimal vsmmaxvalue) {
        this.vsmmaxvalue = vsmmaxvalue;
    }

    public BigDecimal getVsmminvalue() {
        return this.vsmminvalue;
    }

    public void setVsmminvalue(BigDecimal vsmminvalue) {
        this.vsmminvalue = vsmminvalue;
    }

    public Integer getVsmqtyfree() {
        return this.vsmqtyfree;
    }

    public void setVsmqtyfree(Integer vsmqtyfree) {
        this.vsmqtyfree = vsmqtyfree;
    }

    public String getVsmschemedesc() {
        return this.vsmschemedesc;
    }

    public void setVsmschemedesc(String vsmschemedesc) {
        this.vsmschemedesc = vsmschemedesc;
    }

    public String getVsmschemename() {
        return this.vsmschemename;
    }

    public void setVsmschemename(String vsmschemename) {
        this.vsmschemename = vsmschemename;
    }

    public Date getVsmstartdate() {
        return this.vsmstartdate;
    }

    public void setVsmstartdate(Date vsmstartdate) {
        this.vsmstartdate = vsmstartdate;
    }

    public Date getVsmstarttime() {
        return this.vsmstarttime;
    }

    public void setVsmstarttime(Date vsmstarttime) {
        this.vsmstarttime = vsmstarttime;
    }

    public com.sellerportal.model.Ismafm getIsmafm() {
        return this.ismafm;
    }

    public void setIsmafm(com.sellerportal.model.Ismafm ismafm) {
        this.ismafm = ismafm;
    }

    public Set<Ismsgt> getIsmsgts() {
        return this.ismsgts;
    }

    public void setIsmsgts(Set<Ismsgt> ismsgts) {
        this.ismsgts = ismsgts;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("vsmrfnum", getVsmrfnum())
            .toString();
    }

}
