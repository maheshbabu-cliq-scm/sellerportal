package com.sellerportal.model;

import java.io.Serializable;
import java.util.Date;

import org.apache.commons.lang.builder.ToStringBuilder;
import javax.persistence.*;

@Entity
@Table(name = "OCT_COURIER_AWB_BULK_DATA")
public class OctCourierAwbBulkData implements Serializable {

	 @Id
	    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "oct_courier_awb_bulk_sequence")
	    @SequenceGenerator(name = "oct_courier_awb_bulk_sequence", sequenceName = "OCT_COURIER_AWB_BULK_SEQ", allocationSize = 1)
	    @Column(name = "OCABDRFNUM")
	    private Long ocabdrfnum;

	    @Column(name = "AWBNUM", length = 30)
	    private String awbnum;

	    @Column(name = "CREATEDATE", nullable = false)
	    private Date createdate;

	    @Column(name = "CREATEDBY", nullable = false, length = 19)
	    private Long createdby;

	    @Column(name = "DELETED", nullable = false, length = 1)
	    private String deleted;

	    @Column(name = "ISUSED", length = 1)
	    private String isused;

	    @Column(name = "MODIDATE", nullable = false)
	    private Date modidate;

	    @Column(name = "MODIFIEDBY", nullable = false, length = 19)
	    private Long modifiedby;

	    @Column(name = "AWBTYPE", length = 1)
	    private String awbtype;

	    @Column(name = "TRANSPORTMODE", length = 45)
	    private String trasportmode;

	    @Column(name = "PAYMENTMODE", length = 45)
	    private String paymentmode;

	    @Column(name = "AWBDELIVERYTYPE", length = 20)
	    private String awbdeliverytype;

	    @Column(name = "SERVICEMODE", length = 45)
	    private String servicemode;

	    @Column(name = "ISACTIVE", nullable = false, length = 1)
	    private String isactive;

	    @Column(name = "ISREVERSEAWBNUM", length = 20)
	    private String isreverseawbnum;

	    @Column(name = "AWBMBKPTYPE", length = 64)
	    private String awbmbkptype;

	    // Many-to-one association to OctCourierMaster
	    @ManyToOne(fetch = FetchType.LAZY)
	    @JoinColumn(name = "OCABDOCMRFNUM", nullable = false)
	    private OctCourierMaster octCourierMaster;

	    // Many-to-one association to OctAwbSery
	    @ManyToOne(fetch = FetchType.LAZY)
	    @JoinColumn(name = "AWBMRFNUM", nullable = false)
	    private OctAwbSery awbmrfnum;


	/** full constructor */
    public OctCourierAwbBulkData(String awbnum, Date createdate, Long createdby, String deleted, String isused, Date modidate, Long modifiedby,String awbtype, com.sellerportal.model.OctCourierMaster octCourierMaster,String awbdeliverytype,String isreverseawbnum,String isactive) {
        this.awbnum = awbnum;
        this.createdate = createdate;
        this.createdby = createdby;
        this.deleted = deleted;
        this.isused = isused;
        this.modidate = modidate;
        this.modifiedby = modifiedby;
        this.octCourierMaster = octCourierMaster;
        this.awbtype = awbtype;
        this.awbdeliverytype = awbdeliverytype;
        this.isreverseawbnum = isreverseawbnum;
        this.isactive=isactive;
    }

    /** default constructor */
    public OctCourierAwbBulkData() {
    }

    /** minimal constructor */
    public OctCourierAwbBulkData(Date createdate, Long createdby, String deleted, Date modidate, Long modifiedby, com.sellerportal.model.OctCourierMaster octCourierMaster) {
        this.createdate = createdate;
        this.createdby = createdby;
        this.deleted = deleted;
        this.modidate = modidate;
        this.modifiedby = modifiedby;
        this.octCourierMaster = octCourierMaster;
    }

    public Long getOcabdrfnum() {
        return this.ocabdrfnum;
    }

    public void setOcabdrfnum(Long ocabdrfnum) {
        this.ocabdrfnum = ocabdrfnum;
    }

    public String getAwbnum() {
        return this.awbnum;
    }

    public void setAwbnum(String awbnum) {
        this.awbnum = awbnum;
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

    public String getIsused() {
        return this.isused;
    }

    public void setIsused(String isused) {
        this.isused = isused;
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

    public com.sellerportal.model.OctCourierMaster getOctCourierMaster() {
        return this.octCourierMaster;
    }

    public void setOctCourierMaster(com.sellerportal.model.OctCourierMaster octCourierMaster) {
        this.octCourierMaster = octCourierMaster;
    }
    
    public String getAwbtype() {
		return awbtype;
	}

	public void setAwbtype(String awbtype) {
		this.awbtype = awbtype;
	}
	//added Avinash R2
	public com.sellerportal.model.OctAwbSery getAwbmrfnum() {
		return awbmrfnum;
	}
     
	//added Avinash R2
	public void setAwbmrfnum(com.sellerportal.model.OctAwbSery awbmrfnum) {
		this.awbmrfnum = awbmrfnum;
	}

	public String toString() {
        return new ToStringBuilder(this)
            .append("ocabdrfnum", getOcabdrfnum())
            .toString();
    }

	public String getAwbdeliverytype() {
		return awbdeliverytype;
	}

	public void setAwbdeliverytype(String awbdeliverytype) {
		this.awbdeliverytype = awbdeliverytype;
	}
	//added by Suyog R2.3
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
	
		public String getIsreverseawbnum() {
		return isreverseawbnum;
	}

	public void setIsreverseawbnum(String isreverseawbnum) {
		this.isreverseawbnum = isreverseawbnum;
	}
	public String getIsactive() {
		return isactive;
	}

	public void setIsactive(String isactive) {
		this.isactive = isactive;
	}
	
	public String getAwbmbkptype() {
		return awbmbkptype;
	}

	public void setAwbmbkptype(String awbmbkptype) {
		this.awbmbkptype = awbmbkptype;
	}
}
