package com.sellerportal.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "oct_zone_master")
public class ZoneMaster implements Serializable {
	
	 /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ZONE_ZONERFNUM_SEQ")
    @SequenceGenerator(name = "ZONE_ZONERFNUM_SEQ", sequenceName = "ZONE_ZONERFNUM_SEQ", allocationSize = 1)
    @Column(name = "ZONERFNUM")
    private Long zonerfnum;

    @Column(name = "ZONECODE", length = 4)
    private String zoneCode;

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

	public Long getZonerfnum() {
		return zonerfnum;
	}

	public void setZonerfnum(Long zonerfnum) {
		this.zonerfnum = zonerfnum;
	}

	public String getZoneCode() {
		return zoneCode;
	}

	public void setZoneCode(String zoneCode) {
		this.zoneCode = zoneCode;
	}

	public Date getCreatedate() {
		return createdate;
	}

	public void setCreatedate(Date createdate) {
		this.createdate = createdate;
	}

	public Long getCreatedby() {
		return createdby;
	}

	public void setCreatedby(Long createdby) {
		this.createdby = createdby;
	}

	public String getDeleted() {
		return deleted;
	}

	public void setDeleted(String deleted) {
		this.deleted = deleted;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getModidate() {
		return modidate;
	}

	public void setModidate(Date modidate) {
		this.modidate = modidate;
	}

	public String getIsactive() {
		return isactive;
	}

	public void setIsactive(String isactive) {
		this.isactive = isactive;
	}
    
    


}
