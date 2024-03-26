package com.sellerportal.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Entity
@Table(name = "SLAVE_STATE_MAPPING")
public class SlaveStateMapping  implements Serializable{

	/**
	 * 
	 */
	@Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "slavestatemapping_seq")
    @SequenceGenerator(name = "slavestatemapping_seq", sequenceName = "SLAVESTATEMAPPING_SEQ", allocationSize = 1)
    @Column(name = "SSMRFNUM")
    private Long ssmrfnum;

    @Column(name = "SERVICEABILITY", length = 1)
    private String serviceability;

    @Column(name = "OCTSTATERFNUM", length = 10)
    private Long octstaterfnum;

    @Column(name = "ZONERFNUM", length = 10)
    private Long zonerfnum;

    @Column(name = "OCTSLAVERFNUM", length = 10)
    private Long octslaverfnum;

    @Column(name = "CREATEDATE", nullable = false)
    private Date createdate;

    @Column(name = "CREATEDBY", nullable = false, length = 20)
    private Long createdby;

    @Column(name = "DELETED", nullable = false, length = 1)
    private String deleted;

    @Column(name = "MODIDATE", nullable = false)
    private Date modidate;


    public Long getZonerfnum() {
		return zonerfnum;
	}

	public void setZonerfnum(Long zonerfnum) {
		this.zonerfnum = zonerfnum;
	}

	public String getServiceability() {
		return serviceability;
	}

	public void setServiceability(String serviceability) {
		this.serviceability = serviceability;
	}


    

	public Long getSsmrfnum() {
		return ssmrfnum;
	}

	public void setSsmrfnum(Long ssmrfnum) {
		this.ssmrfnum = ssmrfnum;
	}

	public Long getOctstaterfnum() {
		return octstaterfnum;
	}

	public void setOctstaterfnum(Long octstaterfnum) {
		this.octstaterfnum = octstaterfnum;
	}

	public Long getOctslaverfnum() {
		return octslaverfnum;
	}

	public void setOctslaverfnum(Long octslaverfnum) {
		this.octslaverfnum = octslaverfnum;
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

	public Date getModidate() {
		return modidate;
	}

	public void setModidate(Date modidate) {
		this.modidate = modidate;
	}


}
