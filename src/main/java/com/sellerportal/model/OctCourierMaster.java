package com.sellerportal.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Set;

import org.apache.commons.lang.builder.ToStringBuilder;
import javax.persistence.*;

@Entity
@Table(name = "OCT_COURIER_MASTER")
public class OctCourierMaster implements Serializable {

	@Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "oct_courier_master_sequence")
    @SequenceGenerator(name = "oct_courier_master_sequence", sequenceName = "OCT_COURIER_MASTER_SEQ", allocationSize = 1)
    @Column(name = "OCRRFNUM")
    private Long ocrrfnum;

    @Column(name = "CREATEDATE", nullable = false)
    private Date createdate;

    @Column(name = "CREATEDBY", nullable = false, length = 19)
    private Long createdby;

    @Column(name = "DELETED", nullable = false, length = 1)
    private String deleted;

    @Column(name = "MODIDATE", nullable = false)
    private Date modidate;

    @Column(name = "MODIFIEDBY", nullable = false, length = 19)
    private Long modifiedby;

    @Column(name = "OCTCOURIERCODE", length = 256)
    private String octcouriercode;

    @Column(name = "OCTCOURIERNAME", length = 256)
    private String octcouriername;

    @Column(name = "OCTISACTIVE", nullable = false, length = 1)
    private String octisactive;

    @Column(name = "ISONLINEAWBAVAILABLE", length = 1)
    private String isOnlineAWBAvailable;

    @Column(name = "GLOBALCOURIERCODE", length = 30)
    private String globalcouriercode;

    @Column(name = "OCTFULLFILMENTTYPE", length = 1)
    private String octFullFilmentType;

    @Column(name = "ENABLEMODES", length = 50)
    private String enableModes;

    @Column(name = "ISREVSERVICEABLE", length = 1)
    private String isRevServiceable;

    @OneToMany(mappedBy = "octCourierMaster", fetch = FetchType.LAZY)
    @Transient
    private Set<OctCourierServiceMaster> octCourierServiceMasters ;

    @OneToMany(mappedBy = "octCourierMaster", fetch = FetchType.LAZY)
    @Transient
    private Set<OctCourierAwbBulkData> octCourierAwbBulkDatas ;
    


    /** full constructor */
    public OctCourierMaster(Date createdate, Long createdby, String deleted, Date modidate, Long modifiedby, String octcouriercode, String octcouriername, String octisactive, String isOnlineAWBAvailable,String globalcouriercode, Set<OctCourierServiceMaster> octCourierServiceMasters,Set<OctCourierAwbBulkData> octCourierAwbBulkDatas,String isRevServiceable) {
        this.createdate = createdate;
        this.createdby = createdby;
        this.deleted = deleted;
        this.modidate = modidate;
        this.modifiedby = modifiedby;
        this.octcouriercode = octcouriercode;
        this.octcouriername = octcouriername;
        this.octisactive = octisactive;
        this.isOnlineAWBAvailable = isOnlineAWBAvailable;
        this.octCourierServiceMasters = octCourierServiceMasters;
        this.octCourierAwbBulkDatas = octCourierAwbBulkDatas;
        this.globalcouriercode = globalcouriercode;
        this.isRevServiceable = isRevServiceable;
    }

    /** default constructor */
    public OctCourierMaster() {
    }

    /** minimal constructor */
    public OctCourierMaster(Date createdate, Long createdby, String deleted, Date modidate, Long modifiedby, String octisactive, Set<OctCourierServiceMaster> octCourierServiceMasters,Set<OctCourierAwbBulkData> octCourierAwbBulkDatas) {
        this.createdate = createdate;
        this.createdby = createdby;
        this.deleted = deleted;
        this.modidate = modidate;
        this.modifiedby = modifiedby;
        this.octisactive = octisactive;
        this.octCourierServiceMasters = octCourierServiceMasters;
        this.octCourierAwbBulkDatas = octCourierAwbBulkDatas;
    }

    public Long getOcrrfnum() {
        return this.ocrrfnum;
    }

    public void setOcrrfnum(Long ocrrfnum) {
        this.ocrrfnum = ocrrfnum;
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

    public Long getModifiedby() {
        return this.modifiedby;
    }

    public void setModifiedby(Long modifiedby) {
        this.modifiedby = modifiedby;
    }

    public String getOctcouriercode() {
        return this.octcouriercode;
    }

    public void setOctcouriercode(String octcouriercode) {
        this.octcouriercode = octcouriercode;
    }

    public String getOctcouriername() {
        return this.octcouriername;
    }

    public void setOctcouriername(String octcouriername) {
        this.octcouriername = octcouriername;
    }

    public String getOctisactive() {
        return this.octisactive;
    }

    public void setOctisactive(String octisactive) {
        this.octisactive = octisactive;
    }

    public String getIsOnlineAWBAvailable() {
		return isOnlineAWBAvailable;
	}

	public void setIsOnlineAWBAvailable(String isOnlineAWBAvailable) {
		this.isOnlineAWBAvailable = isOnlineAWBAvailable;
	}

	public String getGlobalcouriercode() {
		return globalcouriercode;
	}

	public void setGlobalcouriercode(String globalcouriercode) {
		this.globalcouriercode = globalcouriercode;
	}

	public Set<OctCourierServiceMaster> getOctCourierServiceMasters() {
        return this.octCourierServiceMasters;
    }

    public void setOctCourierServiceMasters(Set<OctCourierServiceMaster> octCourierServiceMasters) {
        this.octCourierServiceMasters = octCourierServiceMasters;
    }

    public Set<OctCourierAwbBulkData> getOctCourierAwbBulkDatas() {
        return this.octCourierAwbBulkDatas;
    }

    public void setOctCourierAwbBulkDatas(Set<OctCourierAwbBulkData> octCourierAwbBulkDatas) {
        this.octCourierAwbBulkDatas = octCourierAwbBulkDatas;
    }
    
    public String toString() {
        return new ToStringBuilder(this)
            .append("ocrrfnum", getOcrrfnum())
            .toString();
    }

	public String getOctFullFilmentType() {
		return octFullFilmentType;
	}

	public void setOctFullFilmentType(String octFullFilmentType) {
		this.octFullFilmentType = octFullFilmentType;
	}

	public String getEnableModes() {
		return enableModes;
	}

	public void setEnableModes(String enableModes) {
		this.enableModes = enableModes;
	}

	public String getIsRevServiceable() {
		return isRevServiceable;
	}

	public void setIsRevServiceable(String isRevServiceable) {
		this.isRevServiceable = isRevServiceable;
	}
	
	
	
}
