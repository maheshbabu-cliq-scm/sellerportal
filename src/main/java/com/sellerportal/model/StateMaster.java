package com.sellerportal.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import org.apache.commons.lang3.builder.ToStringBuilder;
import javax.persistence.*;

@Entity
@Table(name = "oct_state_master")
public class StateMaster implements Serializable {

	@Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "state_seq_generator")
    @SequenceGenerator(name = "state_seq_generator", sequenceName = "STATE_STATERFNUM_SEQ", allocationSize = 1)
    @Column(name = "STATERFNUM")
    private Long staterfnum;

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

    @Column(name = "STATECODE", length = 4)
    private String statecode;

    @Column(name = "GLOBALSTATECODE", length = 4)
    private String globalstatecode;

    @Column(name = "ISACTIVE", length = 1)
    private String isactive;
    
    @ManyToOne
    @JoinColumn(name = "COUNTRYRFNUM", nullable = false)
    private CountryMaster countryMaster;

    @OneToMany(mappedBy = "stateMaster", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<CityMaster> cityMasters;

    @OneToMany(mappedBy = "stateMaster", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<OctTaxMstr> taxMasters;
    
    @Column(name = "zonerfnum", length = 4)
    private Long zonerfnum;
    
    
    public Long getZonerfnum() {
		return zonerfnum;
	}

	public void setZonerfnum(Long zonerfnum) {
		this.zonerfnum = zonerfnum;
	}

	@Column(name = "GSTSTATECODE", length = 4)
    private String gstStateCode;

    @Column(name = "ISTAXEXEMPTED", length = 1)
    private String isTaxExempted;

    @Column(name = "ISUNIONTERRITORY", length = 1)
    private String isUnionTerritory;

    @Column(name = "ISPLASTICBANNED", length = 1)
    private String isPlasticBanned;

    @Column(name = "JIOPOSSTATERG", length = 10)
    private String jioPosStateRg;
    
	/** full constructor */
    public StateMaster(Date createdate, Long createdby, String deleted, String description, Date modidate, String statecode,String isactive ,com.sellerportal.model.CountryMaster countryMaster, Set cityMasters, Set taxMasters,String gstStateCode,String isTaxExempted, String isUnionTerritory) {
        this.createdate = createdate;
        this.createdby = createdby;
        this.deleted = deleted;
        this.description = description;
        this.modidate = modidate;
        this.statecode = statecode;
        this.isactive = isactive;
        this.countryMaster = countryMaster;
        this.cityMasters = cityMasters;
        this.taxMasters = taxMasters;
        this.gstStateCode = gstStateCode;
        this.isTaxExempted = isTaxExempted;
        this.isUnionTerritory = isUnionTerritory;
    }

    public Set getTaxMasters() {
		return taxMasters;
	}

	public void setTaxMasters(Set taxMasters) {
		this.taxMasters = taxMasters;
	}

	/** default constructor */
    public StateMaster() {
    }

    /** minimal constructor */
    public StateMaster(Date createdate, Long createdby, String deleted, String description, Date modidate, com.sellerportal.model.CountryMaster countryMaster, Set cityMasters) {
        this.createdate = createdate;
        this.createdby = createdby;
        this.deleted = deleted;
        this.description = description;
        this.modidate = modidate;
        this.countryMaster = countryMaster;
        this.cityMasters = cityMasters;
    }

    /** 
     * 		       auto_increment
     * 		    
     */
  
    public Long getStaterfnum() {
        return this.staterfnum;
    }

   

	public void setStaterfnum(Long staterfnum) {
        this.staterfnum = staterfnum;
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
    
    public String getStatecode() {
        return this.statecode;
    }

    public void setStatecode(String statecode) {
        this.statecode = statecode;
    }

    public com.sellerportal.model.CountryMaster getCountryMaster() {
        return this.countryMaster;
    }

    public void setCountryMaster(com.sellerportal.model.CountryMaster countryMaster) {
        this.countryMaster = countryMaster;
    }

    public Set getCityMasters() {
        return this.cityMasters;
    }

    public void setCityMasters(Set cityMasters) {
        this.cityMasters = cityMasters;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("staterfnum", getStaterfnum())
            .toString();
    }

	public String getGlobalstatecode() {
		return globalstatecode;
	}

	public void setGlobalstatecode(String globalstatecode) {
		this.globalstatecode = globalstatecode;
	}

	public void setIsactive(String isactive) {
		this.isactive = isactive;
	}

	public String getIsactive() {
		return isactive;
	}

	public String getGstStateCode() {
		return gstStateCode;
	}

	public void setGstStateCode(String gstStateCode) {
		this.gstStateCode = gstStateCode;
	}

	public String getIsTaxExempted() {
		return isTaxExempted;
	}

	public void setIsTaxExempted(String isTaxExempted) {
		this.isTaxExempted = isTaxExempted;
	}

	public String getIsUnionTerritory() {
		return isUnionTerritory;
	}

	public void setIsUnionTerritory(String isUnionTerritory) {
		this.isUnionTerritory = isUnionTerritory;
	}

	public String getIsPlasticBanned() {
		return isPlasticBanned;
	}

	public void setIsPlasticBanned(String isPlasticBanned) {
		this.isPlasticBanned = isPlasticBanned;
	}	
	//@Parag JIOPOS Sales order change start
	public String getJioPosStateRg() {
		return jioPosStateRg;
	}

	public void setJioPosStateRg(String jioPosStateRg) {
		this.jioPosStateRg = jioPosStateRg;
	}
	//@Parag JIOPOS Sales order change end

}