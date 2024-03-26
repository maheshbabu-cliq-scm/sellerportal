package com.sellerportal.model;

import java.io.Serializable;
import java.util.Date;

import org.apache.commons.lang.builder.ToStringBuilder;
import javax.persistence.*;

/** @author Hibernate CodeGenerator */
@Entity
@Table(name = "ISMCCZ")
public class Ismccz implements Serializable {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CCZRFNUM")
    private Long cczrfnum;

    @Column(name = "CCZALLSTATE", length = 1)
    private String cczallstate;

    @Column(name = "CCZALLCITY", length = 1)
    private String cczallcity;

    @Column(name = "CCZALLZIP", length = 1)
    private String cczallzip;

    @Column(name = "CREATEDATE", nullable = false)
    private Date createdate;

    @Column(name = "CREATEDBY", length = 20)
    private Long createdby;

    @Column(name = "DELETED", nullable = false, length = 1)
    private String deleted;

    @Column(name = "MODIDATE", nullable = false)
    private Date modidate;

    @Column(name = "CCZZIP", length = 10)
    private String cczPin;

    @ManyToOne
    @JoinColumn(name = "CCZCNDZIP", nullable = false)
    private Ismcnd ismcndByCczcndzip;

    @ManyToOne
    @JoinColumn(name = "CCZCNDCNTRY", nullable = false)
    private Ismcnd ismcndByCczcndcntry;

    @ManyToOne
    @JoinColumn(name = "CCZCNDCITY", nullable = false)
    private Ismcnd ismcndByCczcndcity;

    @ManyToOne
    @JoinColumn(name = "CCZCCGRFNUM", nullable = false)
    private Ismccg ismccg;

    @ManyToOne
    @JoinColumn(name = "CCZCITY", nullable = false)
    private CityMaster cityMaster;

    @ManyToOne
    @JoinColumn(name = "CCZSTATE", nullable = false)
    private StateMaster stateMaster;

    @ManyToOne
    @JoinColumn(name = "CCZCOUNTRY", nullable = false)
    private CountryMaster countryMaster;

    /** full constructor */
    public Ismccz(String cczallcity, String cczallzip, Date createdate, Long createdby, String deleted, Date modidate,  com.sellerportal.model.Ismcnd ismcndByCczcndzip,  com.sellerportal.model.Ismcnd ismcndByCczcndcntry,  com.sellerportal.model.Ismcnd ismcndByCczcndcity,  com.sellerportal.model.Ismccg ismccg, CountryMaster countryMaster, StateMaster stateMaster,CityMaster cityMaster, String cczPin, String cczallstate) {
        this.cczallcity = cczallcity;
        this.cczallzip = cczallzip;
        this.createdate = createdate;
        this.createdby = createdby;
        this.deleted = deleted;
        this.modidate = modidate;
        this.ismcndByCczcndzip = ismcndByCczcndzip;
        this.ismcndByCczcndcntry = ismcndByCczcndcntry;
        this.ismcndByCczcndcity = ismcndByCczcndcity;
        this.ismccg = ismccg;
        this.countryMaster = countryMaster;
        this.stateMaster = stateMaster;
        this.cityMaster = cityMaster;
        this.cczPin = cczPin;  
        this.cczallstate = cczallstate;
    }

    /** default constructor */
    public Ismccz() {
    }

    /** minimal constructor */
    public Ismccz(Date createdate, String deleted, Date modidate,  com.sellerportal.model.Ismcnd ismcndByCczcndzip,  com.sellerportal.model.Ismcnd ismcndByCczcndcntry,  com.sellerportal.model.Ismcnd ismcndByCczcndcity,  com.sellerportal.model.Ismccg ismccg, CountryMaster countryMaster, StateMaster stateMaster, CityMaster cityMaster, String cczPin, String cczallstate) {
        this.createdate = createdate;
        this.deleted = deleted;
        this.modidate = modidate;
        this.ismcndByCczcndzip = ismcndByCczcndzip;
        this.ismcndByCczcndcntry = ismcndByCczcndcntry;
        this.ismcndByCczcndcity = ismcndByCczcndcity;
        this.ismccg = ismccg;
        this.countryMaster = countryMaster;
        this.stateMaster = stateMaster;
        this.cityMaster = cityMaster;
        this.cczPin = cczPin;
        this.cczallstate = cczallstate;
    }

    /** 
     * 		       auto_increment
     * 		    
     */
    public Long getCczrfnum() {
        return this.cczrfnum;
    }

    public void setCczrfnum(Long cczrfnum) {
        this.cczrfnum = cczrfnum;
    }

    public String getCczallcity() {
        return this.cczallcity;
    }

    public void setCczallcity(String cczallcity) {
        this.cczallcity = cczallcity;
    }

    public String getCczallzip() {
        return this.cczallzip;
    }

    public void setCczallzip(String cczallzip) {
        this.cczallzip = cczallzip;
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

    public  com.sellerportal.model.Ismcnd getIsmcndByCczcndzip() {
        return this.ismcndByCczcndzip;
    }

    public void setIsmcndByCczcndzip( com.sellerportal.model.Ismcnd ismcndByCczcndzip) {
        this.ismcndByCczcndzip = ismcndByCczcndzip;
    }

    public  com.sellerportal.model.Ismcnd getIsmcndByCczcndcntry() {
        return this.ismcndByCczcndcntry;
    }

    public void setIsmcndByCczcndcntry( com.sellerportal.model.Ismcnd ismcndByCczcndcntry) {
        this.ismcndByCczcndcntry = ismcndByCczcndcntry;
    }

    public  com.sellerportal.model.Ismcnd getIsmcndByCczcndcity() {
        return this.ismcndByCczcndcity;
    }

    public void setIsmcndByCczcndcity( com.sellerportal.model.Ismcnd ismcndByCczcndcity) {
        this.ismcndByCczcndcity = ismcndByCczcndcity;
    }

    public  com.sellerportal.model.Ismccg getIsmccg() {
        return this.ismccg;
    }

    public void setIsmccg( com.sellerportal.model.Ismccg ismccg) {
        this.ismccg = ismccg;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("cczrfnum", getCczrfnum())
            .toString();
    }

	public  com.sellerportal.model.CountryMaster getCountryMaster() {
		return countryMaster;
	}

	public void setCountryMaster( com.sellerportal.model.CountryMaster countryMaster) {
		this.countryMaster = countryMaster;
	}

	public  com.sellerportal.model.StateMaster getStateMaster() {
		return stateMaster;
	}

	public void setStateMaster( com.sellerportal.model.StateMaster stateMaster) {
		this.stateMaster = stateMaster;
	}

	public  com.sellerportal.model.CityMaster getCityMaster() {
		return cityMaster;
	}

	public void setCityMaster( com.sellerportal.model.CityMaster cityMaster) {
		this.cityMaster = cityMaster;
	}

	public String getCczPin() {
		return cczPin;
	}

	public void setCczPin(String cczPin) {
		this.cczPin = cczPin;
	}

	public String getCczallstate() {
		return cczallstate;
	}

	public void setCczallstate(String cczallstate) {
		this.cczallstate = cczallstate;
	}	
	
}
