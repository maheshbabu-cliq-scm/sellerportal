package com.sellerportal.model;

import java.io.Serializable;
import java.util.Date;

import org.apache.commons.lang3.builder.ToStringBuilder;

import javax.persistence.*;

@Entity
@Table(name = "oct_city_master")
public class CityMaster implements Serializable {

	@Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "city_seq_generator")
    @SequenceGenerator(name = "city_seq_generator", sequenceName = "CITY_CITYRFNUM_SEQ", allocationSize = 1)
    @Column(name = "CITYRFNUM")
    private Long cityrfnum;

    @Column(name = "CITYCODE", length = 4)
    private String citycode;

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

    @Column(name = "ZONEGROUP", length = 4)
    private String zone;

    @ManyToOne
    @JoinColumn(name = "STATERFNUM", nullable = false)
    private StateMaster stateMaster;

    /** full constructor */
    public CityMaster(String citycode, Date createdate, Long createdby, String deleted, String description, Date modidate,String isactive, com.sellerportal.model.StateMaster stateMaster) {
        this.citycode = citycode;
        this.createdate = createdate;
        this.createdby = createdby;
        this.deleted = deleted;
        this.description = description;
        this.modidate = modidate;
        this.isactive = isactive;
        this.stateMaster = stateMaster;
    }

    /** default constructor */
    public CityMaster() {
    }

    /** minimal constructor */
    public CityMaster(Date createdate, Long createdby, String deleted, String description, Date modidate, com.sellerportal.model.StateMaster stateMaster) {
        this.createdate = createdate;
        this.createdby = createdby;
        this.deleted = deleted;
        this.description = description;
        this.modidate = modidate;
        this.stateMaster = stateMaster;
    }

    /** 
     * 		       auto_increment
     * 		    
     */
    public Long getCityrfnum() {
        return this.cityrfnum;
    }

    public void setCityrfnum(Long cityrfnum) {
        this.cityrfnum = cityrfnum;
    }


    public String getCitycode() {
        return this.citycode;
    }

    public void setCitycode(String citycode) {
        this.citycode = citycode;
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

    public com.sellerportal.model.StateMaster getStateMaster() {
        return this.stateMaster;
    }

    public void setStateMaster(com.sellerportal.model.StateMaster stateMaster) {
        this.stateMaster = stateMaster;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("cityrfnum", getCityrfnum())
            .toString();
    }


	public void setIsactive(String isactive) {
		this.isactive = isactive;
	}

	public String getIsactive() {
		return isactive;
	}

	public String getZone() {
		return zone;
	}

	public void setZone(String zone) {
		this.zone = zone;
	}

}
