package com.sellerportal.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import org.apache.commons.lang.builder.ToStringBuilder;
import javax.persistence.*;


@Entity
@Table(name = "ISMCCD")
public class Ismccd implements Serializable {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CCDRFNUM")
    private Long ccdrfnum;

    @Column(name = "CCDADDR1", nullable = false, length = 254)
    private String ccdaddr1;

    @Column(name = "CCDADDR2", length = 254)
    private String ccdaddr2;

    @Column(name = "CCDCCNUM", nullable = false, length = 16)
    private String ccdccnum;

    @Column(name = "CCDCONTEMAIL", nullable = false, length = 128)
    private String ccdcontemail;

    @Column(name = "CCDCONTFAX", length = 16)
    private String ccdcontfax;

    @Column(name = "CCDCONTMOBILE", nullable = false, length = 16)
    private String ccdcontmobile;

    @Column(name = "CCDCONTNAME", nullable = false, length = 128)
    private String ccdcontname;

    @Column(name = "CCDCONTPHONE", nullable = false, length = 16)
    private String ccdcontphone;

    @Column(name = "CCDEMAIL", length = 128)
    private String ccdemail;

    @Column(name = "CCDISACTIVE", nullable = false, length = 1)
    private String ccdisactive;

    @Column(name = "CCDNAME", nullable = false, length = 128)
    private String ccdname;

    @Column(name = "CCDPHONE1", nullable = false, length = 16)
    private String ccdphone1;

    @Column(name = "CCDPHONE2", length = 16)
    private String ccdphone2;

    @Column(name = "CCDZIP", nullable = false, length = 10)
    private String ccdzip;

    @Column(name = "CREATEDATE", nullable = false)
    private Date createdate;

    @Column(name = "CREATEDBY", nullable = false, length = 20)
    private Long createdby;

    @Column(name = "DELETED", nullable = false, length = 1)
    private String deleted;

    @Column(name = "MODIDATE", nullable = false)
    private Date modidate;
    /** persistent field */
    @ManyToOne
    @JoinColumn(name = "CCDCNDLOCIDCITY", nullable = false)
    private CityMaster locidCity;

    @ManyToOne
    @JoinColumn(name = "CCDCNDSTATE", nullable = false)
    private StateMaster state;

    @ManyToOne
    @JoinColumn(name = "CCDCNDCITY", nullable = false)
    private CityMaster city;

    @ManyToOne
    @JoinColumn(name = "CCDCNDCOUNTRY", nullable = false)
    private CountryMaster country;

    @OneToMany(mappedBy = "ismccd", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Ismcca> ismccas;

    /** full constructor */
    public Ismccd(String ccdaddr1, String ccdaddr2, String ccdccnum, String ccdcontemail, String ccdcontfax, String ccdcontmobile, String ccdcontname, String ccdcontphone, String ccdemail, String ccdisactive, String ccdname, String ccdphone1, String ccdphone2, String ccdzip, Date createdate, Long createdby, String deleted, Date modidate,  com.sellerportal.model.CityMaster locidCity,  com.sellerportal.model.StateMaster state,  com.sellerportal.model.CityMaster city,  com.sellerportal.model.CountryMaster country, Set ismccas) {
        this.ccdaddr1 = ccdaddr1;
        this.ccdaddr2 = ccdaddr2;
        this.ccdccnum = ccdccnum;
        this.ccdcontemail = ccdcontemail;
        this.ccdcontfax = ccdcontfax;
        this.ccdcontmobile = ccdcontmobile;
        this.ccdcontname = ccdcontname;
        this.ccdcontphone = ccdcontphone;
        this.ccdemail = ccdemail;
        this.ccdisactive = ccdisactive;
        this.ccdname = ccdname;
        this.ccdphone1 = ccdphone1;
        this.ccdphone2 = ccdphone2;
        this.ccdzip = ccdzip;
        this.createdate = createdate;
        this.createdby = createdby;
        this.deleted = deleted;
        this.modidate = modidate;
        this.locidCity = locidCity;
        this.state = state;
        this.city = city;
        this.country = country;
        this.ismccas = ismccas;
    }

    /** default constructor */
    public Ismccd() {
    }

    /** minimal constructor */
    public Ismccd(String ccdaddr1, String ccdccnum, String ccdcontemail, String ccdcontmobile, String ccdcontname, String ccdcontphone, String ccdisactive, String ccdname, String ccdphone1, String ccdzip, Date createdate, Long createdby, String deleted, Date modidate,  com.sellerportal.model.CityMaster locidCity,  com.sellerportal.model.StateMaster state,  com.sellerportal.model.CityMaster city,  com.sellerportal.model.CountryMaster country, Set ismccas) {
        this.ccdaddr1 = ccdaddr1;
        this.ccdccnum = ccdccnum;
        this.ccdcontemail = ccdcontemail;
        this.ccdcontmobile = ccdcontmobile;
        this.ccdcontname = ccdcontname;
        this.ccdcontphone = ccdcontphone;
        this.ccdisactive = ccdisactive;
        this.ccdname = ccdname;
        this.ccdphone1 = ccdphone1;
        this.ccdzip = ccdzip;
        this.createdate = createdate;
        this.createdby = createdby;
        this.deleted = deleted;
        this.modidate = modidate;
        this.locidCity = locidCity;
        this.state = state;
        this.city = city;
        this.country = country;
        this.ismccas = ismccas;
    }

    /** 
     * 		       auto_increment
     * 		    
     */
    public Long getCcdrfnum() {
        return this.ccdrfnum;
    }

    public void setCcdrfnum(Long ccdrfnum) {
        this.ccdrfnum = ccdrfnum;
    }

    public String getCcdaddr1() {
        return this.ccdaddr1;
    }

    public void setCcdaddr1(String ccdaddr1) {
        this.ccdaddr1 = ccdaddr1;
    }

    public String getCcdaddr2() {
        return this.ccdaddr2;
    }

    public void setCcdaddr2(String ccdaddr2) {
        this.ccdaddr2 = ccdaddr2;
    }

    public String getCcdccnum() {
        return this.ccdccnum;
    }

    public void setCcdccnum(String ccdccnum) {
        this.ccdccnum = ccdccnum;
    }

    public String getCcdcontemail() {
        return this.ccdcontemail;
    }

    public void setCcdcontemail(String ccdcontemail) {
        this.ccdcontemail = ccdcontemail;
    }

    public String getCcdcontfax() {
        return this.ccdcontfax;
    }

    public void setCcdcontfax(String ccdcontfax) {
        this.ccdcontfax = ccdcontfax;
    }

    public String getCcdcontmobile() {
        return this.ccdcontmobile;
    }

    public void setCcdcontmobile(String ccdcontmobile) {
        this.ccdcontmobile = ccdcontmobile;
    }

    public String getCcdcontname() {
        return this.ccdcontname;
    }

    public void setCcdcontname(String ccdcontname) {
        this.ccdcontname = ccdcontname;
    }

    public String getCcdcontphone() {
        return this.ccdcontphone;
    }

    public void setCcdcontphone(String ccdcontphone) {
        this.ccdcontphone = ccdcontphone;
    }

    public String getCcdemail() {
        return this.ccdemail;
    }

    public void setCcdemail(String ccdemail) {
        this.ccdemail = ccdemail;
    }

    public String getCcdisactive() {
        return this.ccdisactive;
    }

    public void setCcdisactive(String ccdisactive) {
        this.ccdisactive = ccdisactive;
    }

    public String getCcdname() {
        return this.ccdname;
    }

    public void setCcdname(String ccdname) {
        this.ccdname = ccdname;
    }

    public String getCcdphone1() {
        return this.ccdphone1;
    }

    public void setCcdphone1(String ccdphone1) {
        this.ccdphone1 = ccdphone1;
    }

    public String getCcdphone2() {
        return this.ccdphone2;
    }

    public void setCcdphone2(String ccdphone2) {
        this.ccdphone2 = ccdphone2;
    }

    public String getCcdzip() {
        return this.ccdzip;
    }

    public void setCcdzip(String ccdzip) {
        this.ccdzip = ccdzip;
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

    public  com.sellerportal.model.CityMaster getLocidCity() {
        return this.locidCity;
    }

    public void setLocidCity( com.sellerportal.model.CityMaster locidCity) {
        this.locidCity = locidCity;
    }

    public  com.sellerportal.model.StateMaster getState() {
        return this.state;
    }

    public void setState( com.sellerportal.model.StateMaster state) {
        this.state = state;
    }

    public  com.sellerportal.model.CityMaster getCity() {
        return this.city;
    }

    public void setCity( com.sellerportal.model.CityMaster city) {
        this.city = city;
    }

    public  com.sellerportal.model.CountryMaster getCountry() {
        return this.country;
    }

    public void setCountry( com.sellerportal.model.CountryMaster country) {
        this.country = country;
    }

    public Set getIsmccas() {
        return this.ismccas;
    }

    public void setIsmccas(Set ismccas) {
        this.ismccas = ismccas;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("ccdrfnum", getCcdrfnum())
            .toString();
    }
    
    public boolean equals(Object o){
    
    	if(o instanceof Ismccd){    		
    		return ((Ismccd)o).getCcdrfnum() == ccdrfnum;
    	}
    	return false;
    }

    public Ismccd(Long ccdrfnum){
    	this.ccdrfnum = ccdrfnum;
    }

	@Override
	public int hashCode() {
		return super.hashCode();
	}
    
    
}
