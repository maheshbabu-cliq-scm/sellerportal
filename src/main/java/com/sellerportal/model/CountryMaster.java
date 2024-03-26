package com.sellerportal.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import org.apache.commons.lang3.builder.ToStringBuilder;

import javax.persistence.*;

@Entity
@Table(name = "oct_country_master")
public class CountryMaster implements Serializable {

	@Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "country_seq_generator")
    @SequenceGenerator(name = "country_seq_generator", sequenceName = "COUNTRY_COUNTRYRFNUM_SEQ", allocationSize = 1)
    @Column(name = "COUNTRYRFNUM")
    private Long countryrfnum;

    @Column(name = "COUNTRYCODE", length = 4)
    private String countrycode;

    @Column(name = "CREATEDATE", nullable = false)
    private Date createdate;

    @Column(name = "CREATEDBY", nullable = false, length = 20)
    private Long createdby;

    @Column(name = "DELETED", nullable = false, length = 1)
    private String deleted;

    @Column(name = "DESCRIPTION", nullable = false, length = 254)
    private String description;

    @Column(name = "MODIDATE", nullable = false)
    private Date modidate;

    @Column(name = "ISACTIVE", length = 1)
    private String isactive;

    @OneToMany(mappedBy = "countryMaster", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<StateMaster> stateMasters;

    /** full constructor */
    public CountryMaster(String countrycode, Date createdate, Long createdby, String deleted, String description, Date modidate, String isactive, Set stateMasters) {
        this.countrycode = countrycode;
        this.createdate = createdate;
        this.createdby = createdby;
        this.deleted = deleted;
        this.description = description;
        this.modidate = modidate;
        this.isactive = isactive;
        this.stateMasters = stateMasters;
    }

    /** default constructor */
    public CountryMaster() {
    }

    /** minimal constructor */
    public CountryMaster(Date createdate, Long createdby, String deleted, String description, Date modidate, Set stateMasters) {
        this.createdate = createdate;
        this.createdby = createdby;
        this.deleted = deleted;
        this.description = description;
        this.modidate = modidate;
        this.stateMasters = stateMasters;
    }

    /** 
     * 		       auto_increment
     * 		    
     */
    public Long getCountryrfnum() {
        return this.countryrfnum;
    }

    public void setCountryrfnum(Long countryrfnum) {
        this.countryrfnum = countryrfnum;
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

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getModidate() {
        return this.modidate;
    }

    public void setModidate(Date modidate) {
        this.modidate = modidate;
    }

    public Set getStateMasters() {
        return this.stateMasters;
    }

    public void setStateMasters(Set stateMasters) {
        this.stateMasters = stateMasters;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("countryrfnum", getCountryrfnum())
            .toString();
    }

	public void setIsactive(String isactive) {
		this.isactive = isactive;
	}

	public String getIsactive() {
		return isactive;
	}

}
