package com.sellerportal.model;

import java.io.Serializable;
//import java.math.Long;
import java.util.Date;
import java.util.Set;

import org.apache.commons.lang.builder.ToStringBuilder;
import javax.persistence.*;


@Entity
@Table(name = "OCT_AWB_MASTER")
public class OctAwbSery implements Serializable {

	@Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "awbmrfnum_sequence")
    @SequenceGenerator(name = "awbmrfnum_sequence", sequenceName = "AWBMRFNUM_AUTOINC_SEQ", allocationSize = 1)
    @Column(name = "AWBMRFNUM")
    private Long awbmrfnum;

    @Column(name = "AWBMBKPTYPE", nullable = false, length = 64)
    private String awbmbkptype;

    @Column(name = "CREATEDATE", nullable = false)
    private Date createdate;

    @Column(name = "CREATEDBY", nullable = false)
    private Long createdby;

    @Column(name = "DELETED", nullable = false, length = 1)
    private String deleted;

    @Column(name = "ISACTIVE", nullable = false, length = 1)
    private String isactive;

    @Column(name = "MODIDATE", nullable = false)
    private Date modidate;

    @Column(name = "MODIFIEDBY", nullable = false)
    private Long modifiedby;

    @Column(name = "AWBMBATCHNUM", nullable = false)
    private Long awbsbatchnum;

    @Column(name = "AWBMUSEDDATE", nullable = false)
    private Date awbsuseddate;

    @Column(name = "AWBMALLOCATEDATE", nullable = false)
    private Date awbsallocatedate;

    @Column(name = "AWBMUSEDBY", nullable = false)
    private Long awbusedby;

    @Column(name = "TRANSPORTMODE", length = 45)
    private String trasportmode;

    @Column(name = "PAYMENTMODE", length = 45)
    private String paymentmode;

    @Column(name = "SERVICEMODE", length = 45)
    private String servicemode;

    @Column(name = "AWBMSTARTNO", length = 45)
    private String awbmstartno;

    @Column(name = "AWBMENDNO", length = 45)
    private String awbmendno;

    // Many-to-one association to OctCourierMaster
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "AWBOCRRFNUM", nullable = false)
    private OctCourierMaster octCourierMaster;

    // Many-to-one association to OctSlr
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "AWBMSLRRFNUM")
    private OctSlr octSlr;

    // One-to-many association to OctCourierAwbBulkData
    @OneToMany(mappedBy = "awbmrfnum")
    @Transient
    private Set<OctCourierAwbBulkData> octawb;
    
    

    /** full constructor */
    
    public OctAwbSery(Long awbmrfnum, String awbmbkptype, Date createdate,
			Long createdby, String deleted, String isactive, Date modidate,
			Long modifiedby, Long awbsbatchnum, Date awbsuseddate,
			Date awbsallocatedate, Long awbusedby, String trasportmode,
			String paymentmode, String servicemode, String awbmstartno,
			String awbmendno, Set<OctCourierAwbBulkData> octawb, OctCourierMaster octCourierMaster,
			OctSlr octSlr, OctAwbSery awbSery) {
		super();
		this.awbmrfnum = awbmrfnum;
		this.awbmbkptype = awbmbkptype;
		this.createdate = createdate;
		this.createdby = createdby;
		this.deleted = deleted;
		this.isactive = isactive;
		this.modidate = modidate;
		this.modifiedby = modifiedby;
		this.awbsbatchnum = awbsbatchnum;
		this.awbsuseddate = awbsuseddate;
		this.awbsallocatedate = awbsallocatedate;
		this.awbusedby = awbusedby;
		this.trasportmode = trasportmode;
		this.paymentmode = paymentmode;
		this.servicemode = servicemode;
		this.awbmstartno = awbmstartno;
		this.awbmendno = awbmendno;
		this.octawb = octawb;
		this.octCourierMaster = octCourierMaster;
		this.octSlr = octSlr;
//		this.awbSery = awbSery;
	}
    
    
  /*  public OctAwbSery(String awbmbkptype, String awbmend, String awbmstart,Date createdate, Long createdby, String deleted, String isactive, Date modidate, Long modifiedby, com.sellerportal.model.OctCourierMaster octCourierMaster,com.sellerportal.model.OctSlr  octSlr, com.sellerportal.model.OctAwbSery awbSery) {
        this.awbmbkptype = awbmbkptype;
        this.awbnum = awbnum;
        this.createdate = createdate;
        this.createdby = createdby;
        this.deleted = deleted;
        this.isactive = isactive;
        this.modidate = modidate;
        this.modifiedby = modifiedby;
        this.octCourierMaster = octCourierMaster;
        this.octSlr=octSlr;
        this.awbSery=awbSery;
    }*/

    /** default constructor */
    public OctAwbSery() {
    }

	/** minimal constructor */
    public OctAwbSery(String awbmbkptype, String awbmend, String awbmstart, Date createdate, Long createdby, String deleted, String isactive, Date modidate, Long modifiedby) {
        this.awbmbkptype = awbmbkptype;
        this.createdate = createdate;
        this.createdby = createdby;
        this.deleted = deleted;
        this.isactive = isactive;
        this.modidate = modidate;
        this.modifiedby = modifiedby;
    }
    
    public String getAwbmstartno() {
		return awbmstartno;
	}

	public void setAwbmstartno(String awbmstartno) {
		this.awbmstartno = awbmstartno;
	}

	public String getAwbmendno() {
		return awbmendno;
	}

	public void setAwbmendno(String awbmendno) {
		this.awbmendno = awbmendno;
	}

	public Set<OctCourierAwbBulkData> getOctawb() {
		return this.octawb;
	}

	public void setOctawb(Set<OctCourierAwbBulkData> octawb) {
		this.octawb = octawb;
	}

	public Long getAwbmrfnum() {
        return this.awbmrfnum;
    }

    public void setAwbmrfnum(Long awbmrfnum) {
        this.awbmrfnum = awbmrfnum;
    }

    public String getAwbmbkptype() {
        return this.awbmbkptype;
    }

    public void setAwbmbkptype(String awbmbkptype) {
        this.awbmbkptype = awbmbkptype;
    }

   

    public com.sellerportal.model.OctSlr getOctSlr() {
		return octSlr;
	}

	public void setOctSlr(com.sellerportal.model.OctSlr octSlr) {
		this.octSlr = octSlr;
	}

//	public com.sellerportal.model.OctAwbSery getAwbSery() {
//		return awbSery;
//	}
//
//	public void setAwbSery(com.sellerportal.model.OctAwbSery awbSery) {
//		this.awbSery = awbSery;
//	}

	/*public String getAwbnum() {
        return this.awbnum;
    }

    public void setAwbnum(String awbnum) {
        this.awbnum = awbnum;
    }*/


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
    
    public Long getAwbsbatchnum() {
		return awbsbatchnum;
	}

	public void setAwbsbatchnum(Long awbsbatchnum) {
		this.awbsbatchnum = awbsbatchnum;
	}

/*	public String getAwbsisused() {
		return awbsisused;
	}

	public void setAwbsisused(String awbsisused) {
		this.awbsisused = awbsisused;
	}*/

	public Date getAwbsuseddate() {
		return awbsuseddate;
	}

	public void setAwbsuseddate(Date awbsuseddate) {
		this.awbsuseddate = awbsuseddate;
	}

	public Date getAwbsallocatedate() {
		return awbsallocatedate;
	}

	public void setAwbsallocatedate(Date awbsallocatedate) {
		this.awbsallocatedate = awbsallocatedate;
	}

	public Long getAwbusedby() {
		return awbusedby;
	}

	public void setAwbusedby(Long awbusedby) {
		this.awbusedby = awbusedby;
	}

	public com.sellerportal.model.OctCourierMaster getOctCourierMaster() {
		return octCourierMaster;
	}

	public void setOctCourierMaster(
			com.sellerportal.model.OctCourierMaster octCourierMaster) {
		this.octCourierMaster = octCourierMaster;
	}
	
	 public String getTrasportmode() {
			return trasportmode;
		}

		public void setTrasportmode(String trasportmode) {
			this.trasportmode = trasportmode;
		}

		public String getPaymentmode() {
			return paymentmode;
		}

		public void setPaymentmode(String paymentmode) {
			this.paymentmode = paymentmode;
		}

		public String getServicemode() {
			return servicemode;
		}

		public void setServicemode(String servicemode) {
			this.servicemode = servicemode;
		}


	public String toString() {
        return new ToStringBuilder(this)
            .append("awbmrfnum", getAwbmrfnum())
            .toString();
    }

}