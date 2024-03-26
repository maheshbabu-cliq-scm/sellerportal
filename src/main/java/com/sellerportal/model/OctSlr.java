package com.sellerportal.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Set;

import org.apache.commons.lang3.builder.ToStringBuilder;
import javax.persistence.*;

@Entity
@Table(name = "OCT_SLR")
public class OctSlr implements Serializable {

	@Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "octSlrSeq")
    @SequenceGenerator(name = "octSlrSeq", sequenceName = "OCT_SLR_OCTSLRRFNUM_SEQ", allocationSize = 1)
    @Column(name = "OCTSLRRFNUM")
    private Long octslrrfnum;

    @Column(name = "CREATEDATE", nullable = false)
    private Date createdate;

    @Column(name = "CREATEDBY", nullable = false)
    private Long createdby;

    @Column(name = "DELETED", nullable = false, length = 1)
    private String deleted;

    @Column(name = "ALLOWFLUSH", length = 1)
    private String allowflush;

    @Column(name = "ALLOWSINGLECLICKFLUSH", length = 1)
    private String allowsingleclickflush;

    @Column(name = "MODIDATE", nullable = false)
    private Date modidate;

    @Column(name = "MODIFIEDBY", nullable = false)
    private Long modifiedby;

    @Column(name = "OCTSLRISACTIVE", length = 1)
    private String octslrisactive;

    @Column(name = "OCTSLRISAPPROVE", length = 1)
    private String octslrisapprove;

    @Column(name = "OCTSLRLCODE", nullable = false, length = 128)
    private String octslrlcode;

    @Column(name = "OCTSLRLNAME", nullable = false, length = 128)
    private String octslrlname;

    @Column(name = "OCTSLRLOGO", length = 256)
    private String octslrlogo;

    @Column(name = "OCTSLRNAME", length = 128)
    private String octslrname;

    @Column(name = "OCTSLRPAN", length = 256)
    private String octslrpan;

    @Column(name = "OCTSLRNAME1", length = 256)
    private String octslrname1;

    @Column(name = "OCTSLRNAME2", length = 256)
    private String octslrname2;

    @Column(name = "OCTSLRTAN", length = 256)
    private String octslrtan;

    @Column(name = "OCTSLRTAX", length = 256)
    private String octslrtax;

 

    @Column(name = "OCTSLRLST", length = 256)
    private String octslrlst;

    @Column(name = "OCTSLRCST", length = 256)
    private String octslrcst;

    @Column(name = "OCTSLRURL", length = 256)
    private String octslrurl;

    @Column(name = "ORGID", nullable = false)
    private Long orgid;

    @Column(name = "SLRINCOMPLETE", length = 1)
    private String slrincomplete;

    @Column(name = "OCTSLRNAME3", length = 256)
    private String octslrname3;

    @Column(name = "OCTSLRISPROCESSED", length = 1)
    private String octslrisprocessed;

    @Column(name = "OCTSLRISACCEPTED", length = 1)
    private String octslrisaccepted;

    @Column(name = "OCTSLRTITLE", length = 20)
    private String octslrtitle;

    @Column(name = "OCTSLRPANVALIDDATE")
    private Date octslrPanValidDate;

    @Column(name = "OCTSLRPANEXPIRYDATE")
    private Date octslrPanExpiryDate;

    @Column(name = "OCTSLRONBOARDINGDATE")
    private Date octslronboardingdate;

    @Column(name = "OCTSLRCOLLECTENABLE", length = 1)
    private String octslrCollectEnable;

    @Column(name = "OCTSLRCOLLDAYS")
    private Long octSlrCollDays;

    @Column(name = "OCTSLRCOLLEXTDAYS")
    private Long octSlrExtDays;

    @Column(name = "OCTSLRISITRFILED", length = 1)
    private String octSlrIsITRFiled;

    @Column(name = "OCTSLRNOOFEXT")
    private Long octSlrNoofext;

    @Column(name = "OCTSLRISINVOICE", length = 20)
    private String octslrisinvoice;

    @Column(name = "OCTSLRLOGO2", length = 256)
    private String octslrlogo2;

    @Column(name = "OCTSLRLOGO3", length = 256)
    private String octslrlogo3;
    //@Avinash R2 Merged end
    
    @Column(name = "OCTSLRCHANGEOFDELIVERYADD", length = 1)
    private String octslrchangeofdeliveryadd;

    @Column(name = "OCTSLRSSHIPSCHEDULING", length = 1)
    private String octslrsshipscheduling;

    @Column(name = "OCTSLRLPAWBEDIT", length = 1)
    private String octslrlpawbedit;

    @Column(name = "OCTSLRISRETURNTOSTORE", length = 1)
    private String octslrisreturntostore;

    @Column(name = "OCTSLRISQCONHOLD", length = 1)
    private String octslrisqconhold;

    @Column(name = "OCTSLRQCONHOLDDAYS")
    private Long octslrqconholddays;

    @Column(name = "OCTREGEMAILSENT", length = 1)
    private String isRegEmailSent;

    @Column(name = "OCTCORPEMAILSENT", length = 1)
    private String isCorpEmailSent;

    @Column(name = "ISSEALVISIBLE", length = 1)
    private String isSealVisible;

    @Column(name = "UniComLiveDate")
    private Date uniComLiveDate;

    @Column(name = "OCTSLRPRICEBIFNREQ", length = 1)
    private String octslrPriceBifrReq;

    @Column(name = "INVOICEFORMAT", length = 1)
    private String invoiceformat;

    @Column(name = "SMSNOTIFICATION", length = 1)
    private String smsNotification;

    @Column(name = "MAILNOTIFICATION", length = 1)
    private String mailNotification;

    @Column(name = "CURRENTPENALTY", length = 10)
    private BigDecimal currentPenalty;

    @Column(name = "SELLERREFNUM", length = 4)
    private String sellerRefNum;

    @Column(name = "INVOICENUMBER")
    private Long invoiceNumber;

    @Column(name = "SMSNOTIFICATIONFORSELLER", length = 1)
    private String smsNotificationForSeller;

    @Column(name = "MAILNOTIFICATIONFORSELLER", length = 1)
    private String mailNotificationForSeller;

    @Column(name = "ISERPANELELIGIBLE", length = 1)
    private String isERPanelEligible;

    @Column(name = "LP_MAHINDRA_SLR_ID", length = 50)
    private String lpMahindraSlrId;
    
    @Column(name = "ISREVELIGIBLE", length = 1)
    private String isRevEligible;

    @Column(name = "SLRPAYOUTCYCLE", length = 50)
    private String slrPayoutCycle;

    @Column(name = "ISPRIORITYSLR", length = 1)
    private String isPrioritySlr;

    @Column(name = "APPLESTOREID", length = 1)
    private String appleStoreId;

    @ManyToOne
    @JoinColumn(name = "OCTSLRISLISTING")
    private OctParam octslrislisting;

    @ManyToOne
    @JoinColumn(name = "OCTSLRTYPE")
    private OctParam octslrtype;

    @ManyToOne
    @JoinColumn(name = "OCTSLRSETTLEMENT")
    private OctParam octslrsettlement;

    @ManyToOne
    @JoinColumn(name = "OCTSLRPAYOUTPERIOD")
    private OctParam octslrpayoutperiod;

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

    @OneToMany(mappedBy = "octSlr")
    @Transient
    private Set<OctSlrInfo> octSlrInfos;

    @OneToMany(mappedBy = "octSlr")
    @Transient
    private Set<OctSlrUsr> octSlrUsrs;

    @OneToMany(mappedBy = "octSlr")
    @Transient
    private Set<OctSlrBnk> octSlrBnks;

    @OneToMany(mappedBy = "octSlr")
    @Transient
    private Set<SlrCategoryAssociation> slrCategoryAssociations;

    @OneToMany(mappedBy = "octSlr")
    @Transient
    private Set<SlrProductCommision> slrProductCommisions;

    @OneToMany(mappedBy = "octSlr")
    @Transient
    private Set<OctSlv> octSlvs;

    @OneToMany(mappedBy = "octSlr")
    @Transient
    private Set<OctSlrDoc> octSlrDocs;

    @OneToMany(mappedBy = "slrlogslrrfnum")
    @Transient
    private Set<OctSlrLog> octSlrLogs;

    @OneToMany(mappedBy = "octSlr")
    @Transient
    private Set<ProductSearchLog> ProductSearchLogs;

    @OneToMany(mappedBy = "octSlr")
    @Transient
    private Set<OctSlrTtc> octSlrTtcs;
    
	public String getOctslrisinvoice() {
		return octslrisinvoice;
	}

	public String getIsRegEmailSent() {
		return isRegEmailSent;
	}

	public void setIsRegEmailSent(String isRegEmailSent) {
		this.isRegEmailSent = isRegEmailSent;
	}

	public String getIsCorpEmailSent() {
		return isCorpEmailSent;
	}

	public void setIsCorpEmailSent(String isCorpEmailSent) {
		this.isCorpEmailSent = isCorpEmailSent;
	}

	public void setOctslrisinvoice(String octslrisinvoice) {
		this.octslrisinvoice = octslrisinvoice;
	}

	/** full constructor */
    public OctSlr(Date createdate, Long createdby, String deleted, Date modidate, Long modifiedby, String octslrisactive, com.sellerportal.model.OctParam octslrislisting, String octslrlcode, String octslrlname, String octslrlogo, String octslrname, String octslrpan, String slrlogname1, String slrlogname2, String octslrtan, String octslrtax, String octslrurl, Long orgid, Set<OctSlrInfo> octSlrInfos, Set<OctSlrUsr> octSlrUsrs, Set<OctSlrBnk> octSlrBnks, Set<SlrCategoryAssociation> slrCategoryAssociations, Set<SlrProductCommision> slrProductCommisions, Set<OctSlv> octSlvs,Set<ProductSearchLog> ProductSearchLogs, Set<OctSlrDoc> octSlrDocs, String slrlogname3, com.sellerportal.model.OctParam octslrtype,String octslrisapprove, OctParam octslrsettlement,Set<OctSlrLog> octSlrLogs,String octslrisprocessed, OctParam octslrpayoutperiod,String octslrisaccepted,String octslrtitle,String octslrname1,String octslrname2,String octslrname3,String octslrlst,String octslrcst,Date octslrPanExpiryDate,Date octslrPanValidDate, Date octslronboardingdate,Set<OctSlrTtc> octSlrTtcs) {
        this.createdate = createdate;
        this.createdby = createdby;
        this.deleted = deleted;
        this.modidate = modidate;
        this.modifiedby = modifiedby;
        this.octslrisactive = octslrisactive;
        this.octslrislisting = octslrislisting;
        this.octslrlcode = octslrlcode;
        this.octslrlname = octslrlname;
        this.octslrlogo = octslrlogo;
        this.octslrname = octslrname;
        this.octslrpan = octslrpan;
        this.octslrname1 = octslrname1;
        this.octslrname2 = octslrname2;
        this.octslrtan = octslrtan;
        this.octslrtax = octslrtax;
        this.octslrurl = octslrurl;
        this.orgid = orgid;
        this.octSlrInfos = octSlrInfos;
        this.octSlrUsrs = octSlrUsrs;
        this.octSlrBnks = octSlrBnks;
        this.slrCategoryAssociations = slrCategoryAssociations;
        this.slrProductCommisions = slrProductCommisions;
        this.octSlvs = octSlvs;
        this.ProductSearchLogs = ProductSearchLogs;
        this.octSlrDocs = octSlrDocs;
        this.octslrname3 = octslrname3;
        this.octslrtype = octslrtype;
        this.octslrisapprove = octslrisapprove;
        this.octslrsettlement = octslrsettlement;
        this.octSlrLogs = octSlrLogs;
        this.octslrisprocessed = octslrisprocessed;
        this.octslrpayoutperiod = octslrpayoutperiod;
        this.octslrisaccepted = octslrisaccepted;
        this.octslrtitle = octslrtitle;
        this.octslrlst = octslrlst;
        this.octslrcst = octslrcst;
        this.octslrPanValidDate = octslrPanValidDate;
        this.octslrPanExpiryDate = octslrPanExpiryDate;
        this.octslronboardingdate = octslronboardingdate;
        this.octSlrTtcs = octSlrTtcs; 
        this.allowflush=allowflush;
        this.allowsingleclickflush=allowsingleclickflush;
        
    }

    public String getAllowflush() {
		return allowflush;
	}

	public void setAllowflush(String allowflush) {
		this.allowflush = allowflush;
	}

	public String getAllowsingleclickflush() {
		return allowsingleclickflush;
	}

	public void setAllowsingleclickflush(String allowsingleclickflush) {
		this.allowsingleclickflush = allowsingleclickflush;
	}

	/** default constructor */
    public OctSlr() {
    }

    /** minimal constructor */
    public OctSlr(Date createdate, Long createdby, String deleted, Date modidate, Long modifiedby, String octslrlcode, String octslrlname, String octslrname, Long orgid, Set<OctSlrInfo> octSlrInfos, Set<OctSlrUsr> octSlrUsrs, Set<OctSlrBnk> octSlrBnks, Set<SlrCategoryAssociation> slrCategoryAssociations, Set<SlrProductCommision> slrProductCommisions, Set<OctSlv> octSlvs,Set<ProductSearchLog> ProductSearchLogs, Set<OctSlrDoc> octSlrDocs,String slrincomplete,Set<OctSlrLog> octSlrLogs,String octslrisprocessed) {
        this.createdate = createdate;
        this.createdby = createdby;
        this.deleted = deleted;
        this.modidate = modidate;
        this.modifiedby = modifiedby;
        this.octslrlcode = octslrlcode;
        this.octslrlname = octslrlname;
        this.octslrname = octslrname;
        this.orgid = orgid;
        this.octSlrInfos = octSlrInfos;
        this.octSlrUsrs = octSlrUsrs;
        this.octSlrBnks = octSlrBnks;
        this.slrCategoryAssociations = slrCategoryAssociations;
        this.slrProductCommisions = slrProductCommisions;
        this.octSlvs = octSlvs;
        this.ProductSearchLogs = ProductSearchLogs;
        this.octSlrDocs = octSlrDocs;
        this.slrincomplete = slrincomplete;
        this.octSlrLogs = octSlrLogs;
        this.octslrisprocessed = octslrisprocessed;
    }

    /** 
     * 		       auto_increment
     * 		    
     */
    public Long getOctslrrfnum() {
        return this.octslrrfnum;
    }

    public void setOctslrrfnum(Long octslrrfnum) {
        this.octslrrfnum = octslrrfnum;
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

    public String getOctslrisactive() {
        return this.octslrisactive;
    }

    public void setOctslrisactive(String octslrisactive) {
        this.octslrisactive = octslrisactive;
    }

    public com.sellerportal.model.OctParam getOctslrislisting() {
        return this.octslrislisting;
    }

    public void setOctslrislisting(com.sellerportal.model.OctParam octslrislisting) {
        this.octslrislisting = octslrislisting;
    }

    public String getOctslrlcode() {
        return this.octslrlcode;
    }

    public void setOctslrlcode(String octslrlcode) {
        this.octslrlcode = octslrlcode;
    }

    public String getOctslrlname() {
        return this.octslrlname;
    }

    public void setOctslrlname(String octslrlname) {
        this.octslrlname = octslrlname;
    }

    public String getOctslrlogo() {
        return this.octslrlogo;
    }

    public void setOctslrlogo(String octslrlogo) {
        this.octslrlogo = octslrlogo;
    }

    public String getOctslrname() {
        return this.octslrname;
    }

    public void setOctslrname(String octslrname) {
        this.octslrname = octslrname;
    }

    public String getOctslrpan() {
        return this.octslrpan;
    }

    public void setOctslrpan(String octslrpan) {
        this.octslrpan = octslrpan;
    }


    public String getOctslrtan() {
        return this.octslrtan;
    }

    public void setOctslrtan(String octslrtan) {
        this.octslrtan = octslrtan;
    }

    public String getOctslrtax() {
        return this.octslrtax;
    }

    public void setOctslrtax(String octslrtax) {
        this.octslrtax = octslrtax;
    }

    public String getOctslrurl() {
        return this.octslrurl;
    }

    public void setOctslrurl(String octslrurl) {
        this.octslrurl = octslrurl;
    }

    public Long getOrgid() {
        return this.orgid;
    }

    public void setOrgid(Long orgid) {
        this.orgid = orgid;
    }

    public Set<OctSlrInfo> getOctSlrInfos() {
        return this.octSlrInfos;
    }

    public void setOctSlrInfos(Set<OctSlrInfo> octSlrInfos) {
        this.octSlrInfos = octSlrInfos;
    }

    public Set<OctSlrUsr> getOctSlrUsrs() {
        return this.octSlrUsrs;
    }

    public void setOctSlrUsrs(Set<OctSlrUsr> octSlrUsrs) {
        this.octSlrUsrs = octSlrUsrs;
    }

    public Set<OctSlrBnk> getOctSlrBnks() {
        return this.octSlrBnks;
    }

    public void setOctSlrBnks(Set<OctSlrBnk> octSlrBnks) {
        this.octSlrBnks = octSlrBnks;
    }

    public Set<SlrCategoryAssociation> getSlrCategoryAssociations() {
        return this.slrCategoryAssociations;
    }

    public void setSlrCategoryAssociations(Set<SlrCategoryAssociation> slrCategoryAssociations) {
        this.slrCategoryAssociations = slrCategoryAssociations;
    }

    public Set<SlrProductCommision> getSlrProductCommisions() {
        return this.slrProductCommisions;
    }

    public void setSlrProductCommisions(Set<SlrProductCommision> slrProductCommisions) {
        this.slrProductCommisions = slrProductCommisions;
    }

    public Set<OctSlv> getOctSlvs() {
        return this.octSlvs;
    }

    public void setOctSlvs(Set<OctSlv> octSlvs) {
        this.octSlvs = octSlvs;
    }
    
    public Set<ProductSearchLog> getProductSearchLogs() {
		return ProductSearchLogs;
	}

	public void setProductSearchLogs(Set<ProductSearchLog> productSearchLogs) {
		ProductSearchLogs = productSearchLogs;
	}

	public Set<OctSlrDoc> getOctSlrDocs() {
        return this.octSlrDocs;
    }

    public void setOctSlrDocs(Set<OctSlrDoc> octSlrDocs) {
        this.octSlrDocs = octSlrDocs;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("octslrrfnum", getOctslrrfnum())
            .toString();
    }

	public String getSlrincomplete() {
		return slrincomplete;
	}

	public void setSlrincomplete(String slrincomplete) {
		this.slrincomplete = slrincomplete;
	}

	public com.sellerportal.model.OctParam getOctslrtype() {
		return octslrtype;
	}

	public void setOctslrtype(com.sellerportal.model.OctParam octslrtype) {
		this.octslrtype = octslrtype;
	}
	
	public OctParam getOctslrsettlement() {
		return octslrsettlement;
	}

	public void setOctslrsettlement(OctParam octslrsettlement) {
		this.octslrsettlement = octslrsettlement;
	}

	public String getOctslrisapprove() {
		return octslrisapprove;
	}

	public void setOctslrisapprove(String octslrisapprove) {
		this.octslrisapprove = octslrisapprove;
	}

	public Set<OctSlrLog> getOctSlrLogs() {
		return octSlrLogs;
	}

	public void setOctSlrLogs(Set<OctSlrLog> octSlrLogs) {
		this.octSlrLogs = octSlrLogs;
	}

	public String getOctslrisprocessed() {
		return octslrisprocessed;
	}

	public void setOctslrisprocessed(String octslrisprocessed) {
		this.octslrisprocessed = octslrisprocessed;
	}

	/**
	 * @return the octslrpayoutperiod
	 */
	public OctParam getOctslrpayoutperiod() {
		return octslrpayoutperiod;
	}

	/**
	 * @param octslrpayoutperiod the octslrpayoutperiod to set
	 */
	public void setOctslrpayoutperiod(OctParam octslrpayoutperiod) {
		this.octslrpayoutperiod = octslrpayoutperiod;
	}

	public String getOctslrisaccepted() {
		return octslrisaccepted;
	}

	public void setOctslrisaccepted(String octslrisaccepted) {
		this.octslrisaccepted = octslrisaccepted;
	}

	/**
	 * @return the octslrname1
	 */
	public String getOctslrname1() {
		return octslrname1;
	}

	/**
	 * @param octslrname1 the octslrname1 to set
	 */
	public void setOctslrname1(String octslrname1) {
		this.octslrname1 = octslrname1;
	}

	/**
	 * @return the octslrname2
	 */
	public String getOctslrname2() {
		return octslrname2;
	}

	/**
	 * @param octslrname2 the octslrname2 to set
	 */
	public void setOctslrname2(String octslrname2) {
		this.octslrname2 = octslrname2;
	}

	/**
	 * @return the octslrname3
	 */
	public String getOctslrname3() {
		return octslrname3;
	}

	/**
	 * @param octslrname3 the octslrname3 to set
	 */
	public void setOctslrname3(String octslrname3) {
		this.octslrname3 = octslrname3;
	}

	public String getOctslrtitle() {
		return octslrtitle;
	}

	public void setOctslrtitle(String octslrtitle) {
		this.octslrtitle = octslrtitle;
	}

	public String getOctslrlst() {
		return octslrlst;
	}

	public void setOctslrlst(String octslrlst) {
		this.octslrlst = octslrlst;
	}

	public String getOctslrcst() {
		return octslrcst;
	}

	public void setOctslrcst(String octslrcst) {
		this.octslrcst = octslrcst;
	}

	public Date getOctslrPanValidDate() {
		return octslrPanValidDate;
	}

	public void setOctslrPanValidDate(Date octslrPanValidDate) {
		this.octslrPanValidDate = octslrPanValidDate;
	}

	public Date getOctslrPanExpiryDate() {
		return octslrPanExpiryDate;
	}

	public void setOctslrPanExpiryDate(Date octslrPanExpiryDate) {
		this.octslrPanExpiryDate = octslrPanExpiryDate;
	}

	/**
	 * @return the octslronboardingdate
	 */
	public Date getOctslronboardingdate() {
		return octslronboardingdate;
	}

	/**
	 * @param octslronboardingdate the octslronboardingdate to set
	 */
	public void setOctslronboardingdate(Date octslronboardingdate) {
		this.octslronboardingdate = octslronboardingdate;
	}

	public Set<OctSlrTtc> getOctSlrTtcs() {
		return octSlrTtcs;
	}

	public void setOctSlrTtcs(Set<OctSlrTtc> octSlrTtcs) {
		this.octSlrTtcs = octSlrTtcs;
	}

	public String getOctslrCollectEnable() {
		return octslrCollectEnable;
	}

	public void setOctslrCollectEnable(String octslrCollectEnable) {
		this.octslrCollectEnable = octslrCollectEnable;
	}

	public Long getOctSlrCollDays() {
		return octSlrCollDays;
	}

	public void setOctSlrCollDays(Long octSlrCollDays) {
		this.octSlrCollDays = octSlrCollDays;
	}

	public Long getOctSlrExtDays() {
		return octSlrExtDays;
	}

	public void setOctSlrExtDays(Long octSlrExtDays) {
		this.octSlrExtDays = octSlrExtDays;
	}

	public Long getOctSlrNoofext() {
		return octSlrNoofext;
	}

	public void setOctSlrNoofext(Long octSlrNoofext) {
		this.octSlrNoofext = octSlrNoofext;
	}

	public String getOctslrlogo2() {
		return octslrlogo2;
	}

	public void setOctslrlogo2(String octslrlogo2) {
		this.octslrlogo2 = octslrlogo2;
	}

	public String getOctslrlogo3() {
		return octslrlogo3;
	}

	public void setOctslrlogo3(String octslrlogo3) {
		this.octslrlogo3 = octslrlogo3;
	}

	public String getOctslrchangeofdeliveryadd() {
		return octslrchangeofdeliveryadd;
	}

	public void setOctslrchangeofdeliveryadd(String octslrchangeofdeliveryadd) {
		this.octslrchangeofdeliveryadd = octslrchangeofdeliveryadd;
	}

	public String getOctslrsshipscheduling() {
		return octslrsshipscheduling;
	}

	public void setOctslrsshipscheduling(String octslrsshipscheduling) {
		this.octslrsshipscheduling = octslrsshipscheduling;
	}

	public String getOctslrlpawbedit() {
		return octslrlpawbedit;
	}

	public void setOctslrlpawbedit(String octslrlpawbedit) {
		this.octslrlpawbedit = octslrlpawbedit;
	}

	public String getOctslrisreturntostore() {
		return octslrisreturntostore;
	}

	public void setOctslrisreturntostore(String octslrisreturntostore) {
		this.octslrisreturntostore = octslrisreturntostore;
	}

	public String getOctslrisqconhold() {
		return octslrisqconhold;
	}

	public void setOctslrisqconhold(String octslrisqconhold) {
		this.octslrisqconhold = octslrisqconhold;
	}

	public Long getOctslrqconholddays() {
		return octslrqconholddays;
	}

	public void setOctslrqconholddays(Long octslrqconholddays) {
		this.octslrqconholddays = octslrqconholddays;
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
	    public String getIsSealVisible() {
		return isSealVisible;
	}

	public void setIsSealVisible(String isSealVisible) {
		this.isSealVisible = isSealVisible;
	}
	
	public String getOctslrPriceBifrReq() {
		return octslrPriceBifrReq;
	}

	public void setOctslrPriceBifrReq(String octslrPriceBifrReq) {
		this.octslrPriceBifrReq = octslrPriceBifrReq;
	}

    public String getInvoiceformat() {
        return invoiceformat;
    }

    public void setInvoiceformat(String invoiceformat) {
        this.invoiceformat = invoiceformat;
    }

	public String getSmsNotification() {
		return smsNotification;
	}

	public void setSmsNotification(String smsNotification) {
		this.smsNotification = smsNotification;
	}

	public String getMailNotification() {
		return mailNotification;
	}

	public void setMailNotification(String mailNotification) {
		this.mailNotification = mailNotification;
	}
	
    public Long getInvoiceNumber() {
		return invoiceNumber;
	}

	public void setInvoiceNumber(Long invoiceNumber) {
		this.invoiceNumber = invoiceNumber;
	}

	public String getSellerRefNum() {
		return sellerRefNum;
	}

	public void setSellerRefNum(String sellerRefNum) {
		this.sellerRefNum = sellerRefNum;
	}

	public String getSmsNotificationForSeller() {
		return smsNotificationForSeller;
	}

	public void setSmsNotificationForSeller(String smsNotificationForSeller) {
		this.smsNotificationForSeller = smsNotificationForSeller;
	}

	public String getMailNotificationForSeller() {
		return mailNotificationForSeller;
	}

	public void setMailNotificationForSeller(String mailNotificationForSeller) {
		this.mailNotificationForSeller = mailNotificationForSeller;
	}

	public String getIsERPanelEligible() {
		return isERPanelEligible;
	}

	public void setIsERPanelEligible(String isERPanelEligible) {
		this.isERPanelEligible = isERPanelEligible;
	}
	public String getLpMahindraSlrId() {
		return lpMahindraSlrId;
	}

	public void setLpMahindraSlrId(String lpMahindraSlrId) {
		this.lpMahindraSlrId = lpMahindraSlrId;
	}

	public String getIsRevEligible() {
		return isRevEligible;
	}

	public void setIsRevEligible(String isRevEligible) {
		this.isRevEligible = isRevEligible;
	}
	
	public BigDecimal getCurrentPenalty() {
		return currentPenalty;
	}

	public void setCurrentPenalty(BigDecimal currentPenalty) {
		this.currentPenalty = currentPenalty;
	}
	
	public String getSlrPayoutCycle() {
		return slrPayoutCycle;
	}

	public void setSlrPayoutCycle(String slrPayoutCycle) {
		this.slrPayoutCycle = slrPayoutCycle;
	}

	public String getIsPrioritySlr() {
		return isPrioritySlr;
	}

	public void setIsPrioritySlr(String isPrioritySlr) {
		this.isPrioritySlr = isPrioritySlr;
	}

	public String getOctSlrIsITRFiled() {
		return octSlrIsITRFiled;
	}

	public void setOctSlrIsITRFiled(String octSlrIsITRFiled) {
		this.octSlrIsITRFiled = octSlrIsITRFiled;
	}

	public String getAppleStoreId() {
		return appleStoreId;
	}

	public void setAppleStoreId(String appleStoreId) {
		this.appleStoreId = appleStoreId;
	}
}
