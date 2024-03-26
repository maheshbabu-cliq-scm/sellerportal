package com.sellerportal.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.Set;

import org.apache.commons.lang.builder.ToStringBuilder;


@Entity
@Table(name = "oct_slr_log")
public class OctSlrLog implements Serializable{
	


	@Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SLRLOGRFNUM_SLRLOG_SEQ")
    @SequenceGenerator(name = "SLRLOGRFNUM_SLRLOG_SEQ", sequenceName = "SLRLOGRFNUM_SLRLOG_SEQ", allocationSize = 1)
    @Column(name = "SLRLOGRFNUM")
    private Long slrlogrfnum;

    @Column(name = "CREATEDATE", nullable = false)
    private Date createdate;

    @Column(name = "CREATEDBY", nullable = false)
    private Long createdby;

    @Column(name = "DELETED", nullable = false, length = 1)
    private String deleted;

    @Column(name = "SLRLOGISACTIVE", length = 1)
    private String slrlogisactive;

    @Column(name = "SLRLOGLCODE", length = 128)
    private String slrloglcode;

    @Column(name = "SLRLOGLNAME", length = 128)
    private String slrloglname;

    @Column(name = "SLRLOGLOGO", length = 256)
    private String slrloglogo;

    @Column(name = "SLRLOGNAME", length = 128)
    private String slrlogname;

    @Column(name = "SLRLOGPAN", length = 256)
    private String slrlogpan;

    @Column(name = "SLRLOGNAME1", length = 256)
    private String slrlogname1;

    @Column(name = "SLRLOGNAME2", length = 256)
    private String slrlogname2;

    @Column(name = "SLRLOGTAN", length = 256)
    private String slrlogtan;

    @Column(name = "SLRLOGTAX", length = 256)
    private String slrlogtax;

    @Column(name = "SLRLOGURL", length = 256)
    private String slrlogurl;

    @Column(name = "ORGID", nullable = false)
    private Long orgid;

    @Column(name = "SLRINCOMPLETE", length = 1)
    private String slrincomplete;

    @Column(name = "SLRLOGNAME3", length = 256)
    private String slrlogname3;

    @Column(name = "EDITEDBY", length = 20)
    private String editedBy;

    @Column(name = "ISAPPROVED", length = 1)
    private String isApproved;

    @Column(name = "ISPROCESSED", length = 1)
    private String isProcessed;

    @Column(name = "SLRLOGTITLE", length = 10)
    private String slrlogtitle;

    @Column(name = "SLRLOGLST", length = 256)
    private String slrloglst;

    @Column(name = "SLRLOGCST", length = 256)
    private String slrlogcst;

    @Column(name = "SLRLOGPANVALIDDATE")
    private Date slrLogPanValidDate;

    @Column(name = "SLRLOGPANEXPIRYDATE")
    private Date slrLogPanExpiryDate;

    @Column(name = "SLRLOGLOGO2", length = 256)
    private String slrloglogo2;

    @Column(name = "SLRLOGLOGO3", length = 256)
    private String slrloglogo3;

    @ManyToOne
    @JoinColumn(name = "SLRLOGISLISTING")
    private OctParam slrlogislisting;

    @ManyToOne
    @JoinColumn(name = "SLRLOGTYPE")
    private OctParam slrlogtype;

    @ManyToOne
    @JoinColumn(name = "SLRLOGSETTLEMENT")
    private OctParam slrlogsettlement;

    @ManyToOne
    @JoinColumn(name = "SLRLOGSLRRFNUM")
    private OctSlr slrlogslrrfnum;

    @ManyToOne
    @JoinColumn(name = "OCTSLRLOGPAYOUTPERIOD")
    private OctParam octslrlogpayoutperiod;

    @ManyToOne
    @JoinColumn(name = "SLRLOG")
    private OctSlrLog slrlogRef;

    @ManyToOne
    @JoinColumn(name = "sellerConstitution")
    private OctParam sellerConstitution;

    @ManyToOne
    @JoinColumn(name = "sellertype")
    private OctParam sellertype;

    @ManyToOne
    @JoinColumn(name = "sellerclassification")
    private OctParam sellerclassification;

    @ManyToOne
    @JoinColumn(name = "gSTRegistrationStatus")
    private OctParam gSTRegistrationStatus;

    @OneToMany(mappedBy = "slrLogRfnum")
    @Transient
    private Set<SlrLogUat> uatSlrLogs;

    @OneToMany(mappedBy = "slrLogRfnum")
    @Transient
    private Set<SlrLogBnk> bnkSlrLogs;
    
    @OneToMany(mappedBy = "slrLogRfnum")
    @Transient
    private Set<SlrLogInfo> infoSlrLogs;

    @OneToMany(mappedBy = "slrLogRfnum")
    @Transient
    private Set<SlrLogDoc> docSlrLogs;
    
    /** full constructor */
    public OctSlrLog(Date createdate, Long createdby, String deleted, String slrlogisactive, com.sellerportal.model.OctParam slrlogislisting, String slrloglcode, String slrloglname, String slrloglogo, String slrlogname, String slrlogpan, String slrlogname1, String slrlogname2, String slrlogtan, String slrlogtax, String slrlogurl, Long orgid, String slrlogname3, com.sellerportal.model.OctParam slrlogtype, OctParam slrlogsettlement,com.sellerportal.model.OctSlr slrlogslrrfnum,com.sellerportal.model.OctSlrLog slrlogRef,Set<SlrLogInfo> infoSlrLogs,Set<SlrLogBnk> bnkSlrLogs,Set<SlrLogUat> uatSlrLogs,Set<SlrLogDoc> docSlrLogs,String editedBy,String isApproved,String isProcessed, OctParam octslrlogpayoutperiod,String slrlogtitle,String slrloglst,String slrlogcst,Date slrLogPanExpiryDate,Date slrLogPanValidDate) {
        this.createdate = createdate;
        this.createdby = createdby;
        this.deleted = deleted;
        this.slrlogisactive = slrlogisactive;
        this.slrlogislisting = slrlogislisting;
        this.slrloglcode = slrloglcode;
        this.slrloglname = slrloglname;
        this.slrloglogo = slrloglogo;
        this.slrlogname = slrlogname;
        this.slrlogpan = slrlogpan;
        this.slrlogname1 = slrlogname1;
        this.slrlogname2 = slrlogname2;
        this.slrlogtan = slrlogtan;
        this.slrlogtax = slrlogtax;
        this.slrlogurl = slrlogurl;
        this.orgid = orgid;
        this.slrlogname3 = slrlogname3;
        this.slrlogtype = slrlogtype;
        this.slrlogsettlement = slrlogsettlement;
        this.slrlogslrrfnum = slrlogslrrfnum;
        this.slrlogRef = slrlogRef;
        this.infoSlrLogs = infoSlrLogs;
        this.bnkSlrLogs = bnkSlrLogs;
        this.uatSlrLogs = uatSlrLogs;
        this.docSlrLogs = docSlrLogs;
        this.editedBy = editedBy;
        this.isApproved = isApproved;
        this.isProcessed = isProcessed;
        this.octslrlogpayoutperiod = octslrlogpayoutperiod;
        this.slrlogtitle = slrlogtitle;
        this.slrloglst = slrloglst;
        this.slrlogcst = slrlogcst;
        this.slrLogPanValidDate = slrLogPanValidDate;
        this.slrLogPanExpiryDate = slrLogPanExpiryDate;
    }

    /** default constructor */
    public OctSlrLog() {
    	
    }


	/** minimal constructor */
    public OctSlrLog(Date createdate, Long createdby, String deleted, String slrloglcode, String slrloglname, String slrlogname, Long orgid, String slrincomplete,com.sellerportal.model.OctSlr slrlogslrrfnum,com.sellerportal.model.OctSlrLog slrlogRef,String modifiedByUser) {
        this.createdate = createdate;
        this.createdby = createdby;
        this.deleted = deleted;
        this.slrloglcode = slrloglcode;
        this.slrloglname = slrloglname;
        this.slrlogname = slrlogname;
        this.orgid = orgid;
        this.slrincomplete = slrincomplete;
        this.slrlogslrrfnum  = slrlogslrrfnum;
        this.slrlogRef = slrlogRef;
    }

    

    /** 
     * 		       auto_increment
     * 		    
     */
   
    
	public Long getSlrlogrfnum() {
		return slrlogrfnum;
	}

	public void setSlrlogrfnum(Long slrlogrfnum) {
		this.slrlogrfnum = slrlogrfnum;
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

	public String getSlrlogisactive() {
		return slrlogisactive;
	}

	public void setSlrlogisactive(String slrlogisactive) {
		this.slrlogisactive = slrlogisactive;
	}

	public com.sellerportal.model.OctParam getSlrlogislisting() {
		return slrlogislisting;
	}

	public void setSlrlogislisting(com.sellerportal.model.OctParam slrlogislisting) {
		this.slrlogislisting = slrlogislisting;
	}

	public String getSlrloglcode() {
		return slrloglcode;
	}

	public void setSlrloglcode(String slrloglcode) {
		this.slrloglcode = slrloglcode;
	}

	public String getSlrloglname() {
		return slrloglname;
	}

	public void setSlrloglname(String slrloglname) {
		this.slrloglname = slrloglname;
	}

	public String getSlrloglogo() {
		return slrloglogo;
	}

	public void setSlrloglogo(String slrloglogo) {
		this.slrloglogo = slrloglogo;
	}

	public String getSlrlogname() {
		return slrlogname;
	}

	public void setSlrlogname(String slrlogname) {
		this.slrlogname = slrlogname;
	}

	public String getSlrlogpan() {
		return slrlogpan;
	}

	public void setSlrlogpan(String slrlogpan) {
		this.slrlogpan = slrlogpan;
	}

	public String getSlrlogtan() {
		return slrlogtan;
	}

	public void setSlrlogtan(String slrlogtan) {
		this.slrlogtan = slrlogtan;
	}

	public String getSlrlogtax() {
		return slrlogtax;
	}

	public void setSlrlogtax(String slrlogtax) {
		this.slrlogtax = slrlogtax;
	}

	public String getSlrlogurl() {
		return slrlogurl;
	}

	public void setSlrlogurl(String slrlogurl) {
		this.slrlogurl = slrlogurl;
	}

	public Long getOrgid() {
		return orgid;
	}

	public void setOrgid(Long orgid) {
		this.orgid = orgid;
	}

	public com.sellerportal.model.OctParam getSlrlogtype() {
		return slrlogtype;
	}

	public void setSlrlogtype(com.sellerportal.model.OctParam slrlogtype) {
		this.slrlogtype = slrlogtype;
	}

	public OctParam getSlrlogsettlement() {
		return slrlogsettlement;
	}

	public void setSlrlogsettlement(OctParam slrlogsettlement) {
		this.slrlogsettlement = slrlogsettlement;
	}

	public String getSlrincomplete() {
		return slrincomplete;
	}

	public void setSlrincomplete(String slrincomplete) {
		this.slrincomplete = slrincomplete;
	}

	public com.sellerportal.model.OctSlr getSlrlogslrrfnum() {
		return slrlogslrrfnum;
	}

	public void setSlrlogslrrfnum(com.sellerportal.model.OctSlr slrlogslrrfnum) {
		this.slrlogslrrfnum = slrlogslrrfnum;
	}

	public com.sellerportal.model.OctSlrLog getSlrlogRef() {
		return slrlogRef;
	}

	public void setSlrlogRef(com.sellerportal.model.OctSlrLog slrlogRef) {
		this.slrlogRef = slrlogRef;
	}

	public Set<SlrLogUat> getUatSlrLogs() {
		return uatSlrLogs;
	}

	public void setUatSlrLogs(Set<SlrLogUat> uatSlrLogs) {
		this.uatSlrLogs = uatSlrLogs;
	}

	public Set<SlrLogBnk> getBnkSlrLogs() {
		return bnkSlrLogs;
	}

	public void setBnkSlrLogs(Set<SlrLogBnk> bnkSlrLogs) {
		this.bnkSlrLogs = bnkSlrLogs;
	}

	public Set<SlrLogInfo> getInfoSlrLogs() {
		return infoSlrLogs;
	}

	public void setInfoSlrLogs(Set<SlrLogInfo> infoSlrLogs) {
		this.infoSlrLogs = infoSlrLogs;
	}
	
	public String getEditedBy() {
		return editedBy;
	}

	public void setEditedBy(String editedBy) {
		this.editedBy = editedBy;
	}

	public String getIsApproved() {
		return isApproved;
	}

	public void setIsApproved(String isApproved) {
		this.isApproved = isApproved;
	}

	public String getIsProcessed() {
		return isProcessed;
	}

	public void setIsProcessed(String isProcessed) {
		this.isProcessed = isProcessed;
	}
	
	public Set<SlrLogDoc> getDocSlrLogs() {
		return docSlrLogs;
	}

	public void setDocSlrLogs(Set<SlrLogDoc> docSlrLogs) {
		this.docSlrLogs = docSlrLogs;
	}

	public String toString() {
	        return new ToStringBuilder(this)
	            .append("slrlogrfnum", getSlrlogrfnum())
	            .toString();
	 }

	/**
	 * @return the octslrlogpayoutperiod
	 */
	public OctParam getOctslrlogpayoutperiod() {
		return octslrlogpayoutperiod;
	}

	/**
	 * @param octslrlogpayoutperiod the octslrlogpayoutperiod to set
	 */
	public void setOctslrlogpayoutperiod(OctParam octslrlogpayoutperiod) {
		this.octslrlogpayoutperiod = octslrlogpayoutperiod;
	}

	/**
	 * @return the slrlogname1
	 */
	public String getSlrlogname1() {
		return slrlogname1;
	}

	/**
	 * @param slrlogname1 the slrlogname1 to set
	 */
	public void setSlrlogname1(String slrlogname1) {
		this.slrlogname1 = slrlogname1;
	}

	/**
	 * @return the slrlogname2
	 */
	public String getSlrlogname2() {
		return slrlogname2;
	}

	/**
	 * @param slrlogname2 the slrlogname2 to set
	 */
	public void setSlrlogname2(String slrlogname2) {
		this.slrlogname2 = slrlogname2;
	}

	/**
	 * @return the slrlogname3
	 */
	public String getSlrlogname3() {
		return slrlogname3;
	}

	/**
	 * @param slrlogname3 the slrlogname3 to set
	 */
	public void setSlrlogname3(String slrlogname3) {
		this.slrlogname3 = slrlogname3;
	}

	public String getSlrlogtitle() {
		return slrlogtitle;
	}

	public void setSlrlogtitle(String slrlogtitle) {
		this.slrlogtitle = slrlogtitle;
	}

	public String getSlrloglst() {
		return slrloglst;
	}

	public void setSlrloglst(String slrloglst) {
		this.slrloglst = slrloglst;
	}

	public String getSlrlogcst() {
		return slrlogcst;
	}

	public void setSlrlogcst(String slrlogcst) {
		this.slrlogcst = slrlogcst;
	}

	public Date getSlrLogPanValidDate() {
		return slrLogPanValidDate;
	}

	public void setSlrLogPanValidDate(Date slrLogPanValidDate) {
		this.slrLogPanValidDate = slrLogPanValidDate;
	}

	public Date getSlrLogPanExpiryDate() {
		return slrLogPanExpiryDate;
	}

	public void setSlrLogPanExpiryDate(Date slrLogPanExpiryDate) {
		this.slrLogPanExpiryDate = slrLogPanExpiryDate;
	}

	public String getSlrloglogo2() {
		return slrloglogo2;
	}

	public void setSlrloglogo2(String slrloglogo2) {
		this.slrloglogo2 = slrloglogo2;
	}

	public String getSlrloglogo3() {
		return slrloglogo3;
	}

	public void setSlrloglogo3(String slrloglogo3) {
		this.slrloglogo3 = slrloglogo3;
	}

	public OctParam getSellerConstitution() {
		return sellerConstitution;
	}

	public void setSellerConstitution(OctParam sellerConstitution) {
		this.sellerConstitution = sellerConstitution;
	}

	public OctParam getSellertype() {
		return sellertype;
	}

	public void setSellertype(OctParam sellertype) {
		this.sellertype = sellertype;
	}

	public OctParam getSellerclassification() {
		return sellerclassification;
	}

	public void setSellerclassification(OctParam sellerclassification) {
		this.sellerclassification = sellerclassification;
	}

	public OctParam getgSTRegistrationStatus() {
		return gSTRegistrationStatus;
	}

	public void setgSTRegistrationStatus(OctParam gSTRegistrationStatus) {
		this.gSTRegistrationStatus = gSTRegistrationStatus;
	}
	
	
}
