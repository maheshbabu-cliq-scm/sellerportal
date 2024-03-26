package com.sellerportal.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Set;

import org.apache.commons.lang3.builder.ToStringBuilder;

import javax.persistence.*;

/** @author Hibernate CodeGenerator */
@Entity
@Table(name = "ISMGOT")
public class Ismgot implements Serializable {

	@Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "got_sequence")
    @SequenceGenerator(name = "got_sequence", sequenceName = "ISMGOT_GOTRFNUM_SEQ", allocationSize = 1)
    @Column(name = "GOTRFNUM")
    private Long gotrfnum;

    @Column(name = "CITYNAME", length = 40)
    private String cityname;

    @Column(name = "COUNTRYCODE", length = 40)
    private String countrycode;

    @Column(name = "CREATEDATE", nullable = true)
    private Date createdate;

    @Column(name = "CREATEDBY", length = 20)
    private Long createdby;

    @Column(name = "DELETED", length = 1)
    private String deleted;

    @Column(name = "GOTCOUNTRYHEAD", length = 254)
    private String gotcountryhead;

    @Column(name = "GOTCURRENCY", length = 254)
    private String gotcurrency;

    @Column(name = "GOTCURRENCYTYPE", length = 254)
    private String gotcurrencytype;

    @Column(name = "GOTDATEOFFORMATION", length = 254)
    private String gotdateofformation;

    @Column(name = "GOTDOMAIN", length = 20)
    private String gotdomain;

    @Column(name = "GOTFLAG", length = 254)
    private String gotflag;

    @Column(name = "GOTHEADOFFICEADDRESS", length = 254)
    private String gotheadofficeaddress;

    @Column(name = "GOTORGCODE", length = 254)
    private String gotorgcode;

    @Column(name = "GOTORGNAME", length = 254, nullable = false, unique = true)
    private String gotorgname;

    @Column(name = "GOTREGION", length = 254)
    private String gotregion;

    @Column(name = "GOTREMARK", length = 254)
    private String gotremark;

    @Column(name = "GOTVERSION", length = 1)
    private String gotversion;

    @Column(name = "ISACTIVE", length = 1, nullable = false)
    private String isactive;

    @Column(name = "MODIDATE", nullable = false)
    private Date modidate;

    @Column(name = "STATENAME", length = 40)
    private String statename;

    @Column(name = "GOTLATTICORD", length = 15)
    private BigDecimal gotlatticord;

    @Column(name = "GOTLONGICORD", length = 15)
    private BigDecimal gotlongicord;

    @Column(name = "GOTCENTERSIZE")
    private Long gotcentersize;

    @Column(name = "GOTGMAPKEY", length = 2147483647)
    private String gotgmapkey;

    @ManyToOne
    @JoinColumn(name = "GOTGLTPREFLANG", nullable = false)
    private Ismglt ismglt;

    @OneToMany(mappedBy = "ismgot")
    private Set<Ismglm> ismglms;

    @OneToMany(mappedBy = "ismgot")
    private Set<Ismomt> ismomts;

    @OneToMany(mappedBy = "ismgot")
    private Set<Ismart> ismarts;

    @OneToMany(mappedBy = "ismgot")
    private Set<Orgcfg> orgcfgs;
    
    /** full constructor */
    public Ismgot(String cityname, String countrycode, Date createdate, Long createdby, String deleted, String gotcountryhead, String gotcurrency, String gotcurrencytype, String gotdateofformation, String gotdomain, String gotflag, String gotheadofficeaddress, String gotorgcode, String gotorgname, String gotregion, String gotremark, String gotversion, String isactive, Date modidate, String statename, String gotgmapkey, Ismglt ismglt, Set<Ismglm> ismglms, Set<Ismomt> ismomts, Set<Ismart> ismarts, Set<Orgcfg> orgcfgs, BigDecimal gotlatticord, BigDecimal gotlongicord, Long gotcentersize) {
        this.cityname = cityname;
        this.countrycode = countrycode;
        this.createdate = createdate;
        this.createdby = createdby;
        this.deleted = deleted;
        this.gotcountryhead = gotcountryhead;
        this.gotcurrency = gotcurrency;
        this.gotcurrencytype = gotcurrencytype;
        this.gotdateofformation = gotdateofformation;
        this.gotdomain = gotdomain;
        this.gotflag = gotflag;
        this.gotheadofficeaddress = gotheadofficeaddress;
        this.gotorgcode = gotorgcode;
        this.gotorgname = gotorgname;
        this.gotregion = gotregion;
        this.gotremark = gotremark;
        this.gotversion = gotversion;
        this.isactive = isactive;
        this.modidate = modidate;
        this.statename = statename;
        this.gotgmapkey = gotgmapkey;
        this.ismglt = ismglt;
        this.ismglms = ismglms;
        this.ismomts = ismomts;
        this.ismarts = ismarts;
        this.orgcfgs = orgcfgs;
        this.gotlatticord = gotlatticord;
        this.gotlongicord = gotlongicord;
        this.gotcentersize = gotcentersize;
    }

    /** default constructor */
    public Ismgot() {
    }

    /** minimal constructor */
    public Ismgot(Date createdate, Long createdby, String deleted, String gotorgname, String isactive, Date modidate, Ismglt ismglt, Set<Ismglm> ismglms, Set<Ismomt> ismomts, Set<Ismart> ismarts, Set<Orgcfg> orgcfgs) {
        this.createdate = createdate;
        this.createdby = createdby;
        this.deleted = deleted;
        this.gotorgname = gotorgname;
        this.isactive = isactive;
        this.modidate = modidate;
        this.ismglt = ismglt;
        this.ismglms = ismglms;
        this.ismomts = ismomts;
        this.ismarts = ismarts;
        this.orgcfgs = orgcfgs;
    }

    /** 
     * 		       auto_increment
     * 		    
     */
    public Long getGotrfnum() {
        return this.gotrfnum;
    }

    public void setGotrfnum(Long gotrfnum) {
        this.gotrfnum = gotrfnum;
    }

    public String getCityname() {
        return this.cityname;
    }

    public void setCityname(String cityname) {
        this.cityname = cityname;
    }

    public String getCountrycode() {
        return this.countrycode;
    }

    public void setCountrycode(String countrycode) {
        this.countrycode = countrycode;
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

    public String getGotcountryhead() {
        return this.gotcountryhead;
    }

    public void setGotcountryhead(String gotcountryhead) {
        this.gotcountryhead = gotcountryhead;
    }

    public String getGotcurrency() {
        return this.gotcurrency;
    }

    public void setGotcurrency(String gotcurrency) {
        this.gotcurrency = gotcurrency;
    }

    public String getGotcurrencytype() {
        return this.gotcurrencytype;
    }

    public void setGotcurrencytype(String gotcurrencytype) {
        this.gotcurrencytype = gotcurrencytype;
    }

    public String getGotdateofformation() {
        return this.gotdateofformation;
    }

    public void setGotdateofformation(String gotdateofformation) {
        this.gotdateofformation = gotdateofformation;
    }

    public String getGotdomain() {
        return this.gotdomain;
    }

    public void setGotdomain(String gotdomain) {
        this.gotdomain = gotdomain;
    }

    public String getGotflag() {
        return this.gotflag;
    }

    public void setGotflag(String gotflag) {
        this.gotflag = gotflag;
    }

    public String getGotheadofficeaddress() {
        return this.gotheadofficeaddress;
    }

    public void setGotheadofficeaddress(String gotheadofficeaddress) {
        this.gotheadofficeaddress = gotheadofficeaddress;
    }

    public String getGotorgcode() {
        return this.gotorgcode;
    }

    public void setGotorgcode(String gotorgcode) {
        this.gotorgcode = gotorgcode;
    }

    public String getGotorgname() {
        return this.gotorgname;
    }

    public void setGotorgname(String gotorgname) {
        this.gotorgname = gotorgname;
    }

    public String getGotregion() {
        return this.gotregion;
    }

    public void setGotregion(String gotregion) {
        this.gotregion = gotregion;
    }

    public String getGotremark() {
        return this.gotremark;
    }

    public void setGotremark(String gotremark) {
        this.gotremark = gotremark;
    }

    public String getGotversion() {
        return this.gotversion;
    }

    public void setGotversion(String gotversion) {
        this.gotversion = gotversion;
    }

    public String getIsactive() {
        return this.isactive;
    }

    public void setIsactive(String isactive) {
        this.isactive = isactive;
    }

    public Date getModidate() {
        return this.modidate;
    }

    public void setModidate(Date modidate) {
        this.modidate = modidate;
    }

    public String getStatename() {
        return this.statename;
    }

    public void setStatename(String statename) {
        this.statename = statename;
    }

    public com.sellerportal.model.Ismglt getIsmglt() {
        return this.ismglt;
    }

    public void setIsmglt(com.sellerportal.model.Ismglt ismglt) {
        this.ismglt = ismglt;
    }

    public Set<Ismglm> getIsmglms() {
        return this.ismglms;
    }

    public void setIsmglms(Set<Ismglm> ismglms) {
        this.ismglms = ismglms;
    }

    public Set<Ismomt> getIsmomts() {
        return this.ismomts;
    }

    public void setIsmomts(Set<Ismomt> ismomts) {
        this.ismomts = ismomts;
    }

    public Set<Ismart> getIsmarts() {
        return this.ismarts;
    }

    public void setIsmarts(Set<Ismart> ismarts) {
        this.ismarts = ismarts;
    }

    public Set<Orgcfg> getOrgcfgs() {
        return this.orgcfgs;
    }

    public void setOrgcfgs(Set<Orgcfg> orgcfgs) {
        this.orgcfgs = orgcfgs;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("gotrfnum", getGotrfnum())
            .toString();
    }

	public BigDecimal getGotlatticord() {
		return gotlatticord;
	}

	public void setGotlatticord(BigDecimal gotlatticord) {
		this.gotlatticord = gotlatticord;
	}

	public BigDecimal getGotlongicord() {
		return gotlongicord;
	}

	public void setGotlongicord(BigDecimal gotlongicord) {
		this.gotlongicord = gotlongicord;
	}

	public Long getGotcentersize() {
		return gotcentersize;
	}

	public void setGotcentersize(Long gotcentersize) {
		this.gotcentersize = gotcentersize;
	}

	public String getGotgmapkey() {
		return gotgmapkey;
	}

	public void setGotgmapkey(String gotgmapkey) {
		this.gotgmapkey = gotgmapkey;
	}
}
