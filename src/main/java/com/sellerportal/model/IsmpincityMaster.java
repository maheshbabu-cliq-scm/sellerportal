package com.sellerportal.model;

import java.io.Serializable;
import java.util.Date;

import org.apache.commons.lang.builder.ToStringBuilder;
import javax.persistence.*;

@Entity
@Table(name = "ismpincity_master")
public class IsmpincityMaster implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pcrfnum_sequence")
    @SequenceGenerator(name = "pcrfnum_sequence", sequenceName = "PCRFNUM_AUTOINC_SEQ", allocationSize = 1)
    @Column(name = "pcrfnum")
    private Long pcrfnum;

    @Column(name = "city", length = 255)
    private String city;

    @Column(name = "country", length = 255)
    private String country;

    @Column(name = "createdate", nullable = false)
    private Date createdate;

    @Column(name = "createdby", length = 20)
    private Long createdby;

    @Column(name = "deleted", nullable = false, length = 1)
    private String deleted;

    @Column(name = "district", length = 255)
    private String district;

    @Column(name = "isactive", nullable = false, length = 1)
    private String isactive;

    @Column(name = "modidate")
    private Date modidate;

    @Column(name = "modifiedby", length = 20)
    private Long modifiedby;

    @Column(name = "pincode", nullable = false, length = 20)
    private Long pincode;

    @Column(name = "state", length = 255)
    private String state;

    @Column(name = "ishd", length = 1)
    private String ishd;

    @Column(name = "ised", length = 1)
    private String ised;

    @Column(name = "ISSDD", length = 1)
    private String issdd;

    // Many-to-one association to StateMaster
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fkstateid", nullable = false)
    private StateMaster stateMaster;

    // Many-to-one association to CountryMaster
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fkcountryid", nullable = false)
    private CountryMaster countryMaster;

    // Many-to-one association to CityMaster
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fkcityid", nullable = false)
    private CityMaster cityMaster;


    /** full constructor */
    public IsmpincityMaster(String city, String country, Date createdate, Long createdby, String deleted, String district, String isactive, Date modidate, Long modifiedby, Long pincode, String state,String ishd,String ised, com.sellerportal.model.StateMaster stateMaster, com.sellerportal.model.CountryMaster countryMaster, com.sellerportal.model.CityMaster cityMaster) {
        this.city = city;
        this.country = country;
        this.createdate = createdate;
        this.createdby = createdby;
        this.deleted = deleted;
        this.district = district;
        this.isactive = isactive;
        this.modidate = modidate;
        this.modifiedby = modifiedby;
        this.pincode = pincode;
        this.state = state;
        this.ised = ised;
        this.ishd = ishd;
       /* this.ismcnd = ismcnd;*/
        this.stateMaster = stateMaster;
        this.countryMaster = countryMaster;
        this.cityMaster = cityMaster;
       /* this.ismcou=ismcou;*/
    }

    /** default constructor */
    public IsmpincityMaster() {
    }

    /** minimal constructor */
    public IsmpincityMaster(Date createdate, String deleted, String isactive, Long pincode, com.sellerportal.model.Ismcnd ismcnd, com.sellerportal.model.StateMaster stateMaster, com.sellerportal.model.CountryMaster countryMaster, com.sellerportal.model.CityMaster cityMaster) {
        this.createdate = createdate;
        this.deleted = deleted;
        this.isactive = isactive;
        this.pincode = pincode;
     /*   this.ismcnd = ismcnd;*/
        this.stateMaster = stateMaster;
        this.countryMaster = countryMaster;
        this.cityMaster = cityMaster;
    }

    /** 
     * 		       auto_increment
     * 		    
     */
    public Long getPcrfnum() {
        return this.pcrfnum;
    }

    public void setPcrfnum(Long pcrfnum) {
        this.pcrfnum = pcrfnum;
    }

    public String getCity() {
        return this.city;
    }

    public void setCity(String city) {
        this.city = city;
    }

  
    public String getCountry() {
        return this.country;
    }

    public void setCountry(String country) {
        this.country = country;
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

    public String getDistrict() {
        return this.district;
    }

    public void setDistrict(String district) {
        this.district = district;
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

    public Long getModifiedby() {
        return this.modifiedby;
    }

    public void setModifiedby(Long modifiedby) {
        this.modifiedby = modifiedby;
    }

    public Long getPincode() {
        return this.pincode;
    }

    public void setPincode(Long pincode) {
        this.pincode = pincode;
    }

   
    public String getState() {
        return this.state;
    }

    public void setState(String state) {
        this.state = state;
    }

    
  /*  public com.sellerportal.model.Ismcnd getIsmcnd() {
        return this.ismcnd;
    }

    public void setIsmcnd(com.sellerportal.model.Ismcnd ismcnd) {
        this.ismcnd = ismcnd;
    }*/

    public String getIshd() {
		return ishd;
	}

	public void setIshd(String ishd) {
		this.ishd = ishd;
	}

	public String getIsed() {
		return ised;
	}

	public void setIsed(String ised) {
		this.ised = ised;
	}

	public com.sellerportal.model.StateMaster getStateMaster() {
        return this.stateMaster;
    }

    public void setStateMaster(com.sellerportal.model.StateMaster stateMaster) {
        this.stateMaster = stateMaster;
    }

    public com.sellerportal.model.CountryMaster getCountryMaster() {
        return this.countryMaster;
    }

    public void setCountryMaster(com.sellerportal.model.CountryMaster countryMaster) {
        this.countryMaster = countryMaster;
    }

    public com.sellerportal.model.CityMaster getCityMaster() {
        return this.cityMaster;
    }

    public void setCityMaster(com.sellerportal.model.CityMaster cityMaster) {
        this.cityMaster = cityMaster;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("pcrfnum", getPcrfnum())
            .toString();
    }

	public String getIssdd() {
		return issdd;
	}

	public void setIssdd(String issdd) {
		this.issdd = issdd;
	}

	/*public com.sellerportal.model.Ismcou getIsmcou() {
		return ismcou;
	}

	public void setIsmcou(
			com.sellerportal.model.Ismcou ismcou) {
		this.ismcou = ismcou;
	}*/
    
}
