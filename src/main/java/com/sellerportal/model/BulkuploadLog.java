package com.sellerportal.model;

import java.io.Serializable;
import java.util.Date;

import org.apache.commons.lang.builder.ToStringBuilder;

import javax.persistence.*;

/** @author Hibernate CodeGenerator */
@Entity
@Table(name = "OCT_BULKUPLOAD_LOG")
public class BulkuploadLog implements Serializable {

	@Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence")
    @SequenceGenerator(name = "sequence", sequenceName = "BULKUPLOADLOG_BULRFNUM_SEQ", allocationSize = 1)
    @Column(name = "BULRFNUM")
    private Long bulrfnum;

    @Column(name = "BULENDTIME")
    private Date bulendtime;

    @Column(name = "BULFILENAME", length = 256)
    private String bulfilename;

    @Column(name = "BULREMARK", length = 500)
    private String bulremark;

    @Column(name = "BULSTARTTIME")
    private Date bulstarttime;

    @Column(name = "BULSUMMARYFILENAME", length = 256)
    private String bulsummaryfilename;

    @Column(name = "CREATEDATE", nullable = false)
    private Date createdate;

    @Column(name = "CREATEDBY", nullable = false)
    private Long createdby;

    @Column(name = "DELETED", nullable = false, length = 1)
    private String deleted;

    @Column(name = "ISACTIVE", nullable = false, length = 1)
    private String isactive;

    @Column(name = "BULSTATUS", length = 1)
    private String status;

    @Column(name = "MODIDATE", nullable = false)
    private Date modidate;

    @Column(name = "MODIFIEDBY", nullable = false)
    private Long modifiedby;

    @Column(name = "BULUBIRFNUM")
    private Long ismubi;

    @Column(name = "TOTALCOUNT", length = 5)
    private String totalcount;

    @Column(name = "COUNTSUCCESS", length = 5)
    private String countsuccess;

    @Column(name = "COUNTFAILED", length = 5)
    private String countfailed;

    @Column(name = "UPLOADPERCENTAGE", length = 20)
    private String uploadPercentage;

    @Column(name = "TOTALFILERECORD", length = 20)
    private String totalFileRecord;

    @Column(name = "CURRENTFILERECORD", length = 20)
    private String currentFileRecord;

    @Column(name = "BULKUNIQUEID", length = 256)
    private String bulkUniqueId;

    @ManyToOne
    private OctSlr octslr;

    @ManyToOne
    private OctParam bultype;
    
    /** full constructor 
     * @param octslr */
    public BulkuploadLog(Date bulendtime, String bulfilename, String bulremark, Date bulstarttime, String status, String bulsummaryfilename, Long ismubi, Date createdate, Long createdby, String deleted, String isactive, Date modidate, Long modifiedby, OctSlr octslr, OctParam bultype,String totalcount,String countsuccess,String countfailed) {
        this.bulendtime = bulendtime;
        this.bulfilename = bulfilename;
        this.bulremark = bulremark;
        this.bulstarttime = bulstarttime;
        this.status = status;
        this.bulsummaryfilename = bulsummaryfilename;
        this.ismubi = ismubi;
        this.createdate = createdate;
        this.createdby = createdby;
        this.deleted = deleted;
        this.isactive = isactive;
        this.modidate = modidate;
        this.modifiedby = modifiedby;
        //this.orgid = orgid;
        this.octslr=octslr;
        this.bultype = bultype;
        this.totalcount = totalcount;
        this.countsuccess = countsuccess;
        this.countfailed = countfailed;
    }

    public String getUploadPercentage() {
		return uploadPercentage;
	}

	public void setUploadPercentage(String uploadPercentage) {
		this.uploadPercentage = uploadPercentage;
	}

	public String getTotalFileRecord() {
		return totalFileRecord;
	}

	public void setTotalFileRecord(String totalFileRecord) {
		this.totalFileRecord = totalFileRecord;
	}

	public String getCurrentFileRecord() {
		return currentFileRecord;
	}

	public void setCurrentFileRecord(String CurrentFileRecord) {
		currentFileRecord = CurrentFileRecord;
	}

	public String getBulkUniqueId() {
		return bulkUniqueId;
	}

	public void setBulkUniqueId(String bulkUniqueId) {
		this.bulkUniqueId = bulkUniqueId;
	}

	/** default constructor */
    public BulkuploadLog() {
    }

    /** minimal constructor 
     * @param octslr */
    public BulkuploadLog(Date bulendtime, String bulfilename, String bulremark, Date bulstarttime, String bulsummaryfilename, Long ismubi, Date createdate, Long createdby, String deleted, String isactive, Date modidate, Long modifiedby, OctSlr octslr, String totalcount, String countsuccess, String countfailed) {
        this.bulendtime = bulendtime;
        this.bulfilename = bulfilename;
        this.bulremark = bulremark;
        this.bulstarttime = bulstarttime;
        this.bulsummaryfilename = bulsummaryfilename;
        this.ismubi = ismubi;
        this.octslr=octslr;
        this.createdate = createdate;
        this.createdby = createdby;
        this.deleted = deleted;
        this.isactive = isactive;
        this.modidate = modidate;
        this.modifiedby = modifiedby;
        this.totalcount = totalcount;
        this.countsuccess = countsuccess;
        this.countfailed = countfailed;
    }

    public Long getBulrfnum() {
        return this.bulrfnum;
    }

    public void setBulrfnum(Long bulrfnum) {
        this.bulrfnum = bulrfnum;
    }

    public Date getBulendtime() {
        return this.bulendtime;
    }

    public void setBulendtime(Date bulendtime) {
        this.bulendtime = bulendtime;
    }

    public String getBulfilename() {
        return this.bulfilename;
    }

    public void setBulfilename(String bulfilename) {
        this.bulfilename = bulfilename;
    }

    public String getBulremark() {
		return bulremark;
	}

	public void setBulremark(String bulremark) {
		this.bulremark = bulremark;
	}

	public Date getBulstarttime() {
        return this.bulstarttime;
    }

    public void setBulstarttime(Date bulstarttime) {
        this.bulstarttime = bulstarttime;
    }

    public String getBulsummaryfilename() {
        return this.bulsummaryfilename;
    }

    public void setBulsummaryfilename(String bulsummaryfilename) {
        this.bulsummaryfilename = bulsummaryfilename;
    }

   	public Long getIsmubi() {
		return ismubi;
	}

	public void setIsmubi(Long ismubi) {
		this.ismubi = ismubi;
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

    /*public Long getOrgid() {
        return this.orgid;
    }

    public void setOrgid(Long orgid) {
        this.orgid = orgid;
    }*/

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String toString() {
        return new ToStringBuilder(this)
            .append("bulrfnum", getBulrfnum())
            .toString();
    }

	public com.sellerportal.model.OctSlr getOctslr() {
		return octslr;
	}

	public void setOctslr(com.sellerportal.model.OctSlr octslr) {
		this.octslr = octslr;
	}

	/**
	 * @return the bultype
	 */
	public OctParam getBultype() {
		return bultype;
	}

	/**
	 * @param bultype the bultype to set
	 */
	public void setBultype(OctParam bultype) {
		this.bultype = bultype;
	}

	public String getTotalcount() {
		return totalcount;
	}

	public void setTotalcount(String totalcount) {
		this.totalcount = totalcount;
	}

	public String getCountsuccess() {
		return countsuccess;
	}

	public void setCountsuccess(String countsuccess) {
		this.countsuccess = countsuccess;
	}

	public String getCountfailed() {
		return countfailed;
	}

	public void setCountfailed(String countfailed) {
		this.countfailed = countfailed;
	}
	
}
