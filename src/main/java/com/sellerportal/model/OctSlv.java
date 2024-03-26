package com.sellerportal.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import org.apache.commons.lang3.builder.ToStringBuilder;
import javax.persistence.*;



@Entity
@Table(name = "OCT_SLV")
public class OctSlv implements Serializable {

	@Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "oct_slv_octslvrfnum_seq_generator")
    @SequenceGenerator(name = "oct_slv_octslvrfnum_seq_generator", sequenceName = "OCT_SLV_OCTSLVRFNUM_SEQ", allocationSize = 1)
    @Column(name = "OCTSLVRFNUM")
    private Long octslvrfnum;

    @Column(name = "CREATEDATE", nullable = false)
    private Date createdate;

    @Column(name = "CREATEDBY", nullable = false, length = 20)
    private Long createdby;

    @Column(name = "DELETED", nullable = false, length = 1)
    private String deleted;

    @Column(name = "MODIDATE", nullable = false)
    private Date modidate;

    @Column(name = "MODIFIEDBY", nullable = false, length = 20)
    private Long modifiedby;

    @Column(name = "OCTSLVOPENTIME", length = 19)
    private String octslvopentime;

    @Column(name = "OCTSLVCLOSETIME", length = 19)
    private String octslvclosetime;

    @Column(name = "OCTSLVCODE", nullable = false, length = 128)
    private String octslvcode;

    @Column(name = "OCTSLVLATITUDE", length = 100)
    private String octslvlatitude;

    @Column(name = "OCTSLVLONGITUDE", length = 100)
    private String octslvlongitude;

    @Column(name = "OCTSLVISACTIVE", length = 1)
    private String octslvisactive;

    @Column(name = "OCTSLVLNAME", nullable = false, length = 128)
    private String octslvlname;

    @Column(name = "OCTSLVLOGO", length = 256)
    private String octslvlogo;

    @Column(name = "OCTSLVNAME", nullable = false, length = 128)
    private String octslvname;

    @Column(name = "OCTSLVPAN", length = 256)
    private String octslvpan;

    @Column(name = "ORGID", nullable = false, length = 20)
    private Long orgid;

    @Column(name = "ISMAILSENT", length = 1)
    private String ismailsent;

    @Column(name = "OCTSLVCOLLECTENABLE", length = 1)
    private String octslvCollectEnable;

    @Column(name = "OCTSLVISLISTING", length = 1)
    private String octSlvIsListing;

    @Column(name = "OCTSLVCST", length = 20)
    private String octslvcst;

    @Column(name = "OCTSLVSERVICE", length = 20)
    private String octslvservice;

    @Column(name = "OCTSLVVAT", length = 20)
    private String octslvvat;

    @Column(name = "OCTSLVPARKING", length = 1)
    private String octslvparking;
    
    @Column(name = "OCTSLVLOC", length = 20)
    private String octslvloc;

    @Column(name = "OCTSLVSTORESIZE", length = 20)
    private String octslvstoresize;

    @Column(name = "OCTSLVFOOTFALL", length = 20)
    private Long octslvfootfall;

    @Column(name = "OCTSLVOWNERSHIP", length = 20)
    private String octslvownership;

    @Column(name = "OCTSLVRETSALSTATE", length = 20)
    private String octslvretsalstate;

    @Column(name = "OCTSLVREMARK", length = 64)
    private String octSlvRemark;

    @Column(name = "INVOICENUMBER", length = 20)
    private Long invoiceNumber;

    @Column(name = "OCTSLVLOGO2", length = 256)
    private String octslvlogo2;

    @Column(name = "OCTSLVLOGO3", length = 256)
    private String octslvlogo3;

    @Column(name = "OCTSLVFINANCEYEAR", length = 64)
    private String octSlvFinanceYear;

    @Column(name = "OCTSLVISRETURNTOSTORE", length = 1)
    private String octSlvIsReturnToStore;
   
    @Column(name = "OCTSLVCUTOFFTIMETATHDSURFACE", length = 20)
    private String octSlvCutoffTimeTatHdSurface;

    @Column(name = "OCTSLVCUTOFFTIMETATHDAIR", length = 20)
    private String octSlvCutoffTimeTatHdAir;

    @Column(name = "ISTHERMALPRINT", length = 1)
    private String isThermalprint="N";

    @Column(name = "ISALLOWERPANEL", length = 1)
    private String isAllowErPanel;

    @Column(name = "OCTSLVCUTOFFTIMETATEDAIR", length = 20)
    private String octSlvCutoffTimeTatEdAir;

    @Column(name = "OCTSLVCUTOFFTIMETATEDSURFACE", length = 20)
    private String octSlvCutoffTimeTatEdSurface;

    @Column(name = "ISLPSTOREACTIVE", length = 1)
    private String isLpStoreActive;

    @Column(name = "OCTSLVORDERACCEPTANCETAT", length = 20)
    private String octslvorderacceptancetat;

    @Column(name = "OCTSLVORDERPROCESSINGTAT", length = 20)
    private String octslvorderprocessingtat;

    @Column(name = "OCTSLVORDERACCEPTANCETATEDAIR", length = 20)
    private String octslvorderacceptancetatedair;

    @Column(name = "OCTSLVORDERACCEPTANCETATHDSURF", length = 20)
    private String octslvorderacceptancetathdsurf;

    @Column(name = "OCTSLVORDERACCEPTANCETATEDSURF", length = 20)
    private String octslvorderacceptancetatedsurf;

    @Column(name = "OCTSLVORDERPROCESSINGTATEDAIR", length = 20)
    private String octslvorderprocessingtatedair;

    @Column(name = "OCTSLVORDERPROCESSINGTATHDSURF", length = 20)
    private String octslvorderprocessingtathdsurf;

    @Column(name = "OCTSLVORDERPROCESSINGTATEDSURF", length = 20)
    private String octslvorderprocessingtatedsurf;
    
    @Column(name = "OCTSLVLPHANDOVERTIME", length = 20)
    private String octslvlphandovertime;

    @Column(name = "OCTSLVPHANDOVERTIMEEDAIR", length = 20)
    private String octslvlphandovertimeedair;

    @Column(name = "OCTSLVLPHANDOVERTIMEHDSURF", length = 20)
    private String octslvlphandovertimehdsurf;

    @Column(name = "OCTSLVLPHANDOVERTIMEEDSURF", length = 20)
    private String octslvlphandovertimeedsurf;
    
    @Column(name = "GSTREGISTRATIONNO", length = 20)
    private String gstregistrationNo;

    @Column(name = "GSTREGISTRATIONDATE", length = 20)
    private Date gstregistrationdate;

    @Column(name = "LP_MAHINDRA_SLV_ID", length = 50)
    private String lpMahindraSlvId;

    @Column(name = "ALLOWREJECTREASON", length = 1)
    private String allowRejectReason;

    @Column(name = "ISGEOFENCING", length = 1)
    private String isGeoFencing="N";

    @Column(name = "OCTSLVLISTINGDATE", length = 19)
    private Date octSlvListingDate;

    @Column(name = "ISAPOB", length = 1)
    private String isAPOB;

    @Column(name = "ISREVELIGIBLE", length = 1)
    private String isRevEligible="Y";

    @Column(name = "PENALTYDAYS", length = 10)
    private Integer penaltyDays;

    @Column(name = "OCTSLVORDERACCEPTANCETATSDDAIR", length = 20)
    private String octslvorderacceptancetatsddair;

    @Column(name = "OCTSLVORDERACCEPTSDDSURF", length = 20)
    private String octslvorderacceptancetatsddsurf;

    @Column(name = "OCTSLVORDERPROCESSINGTATSDDAIR", length = 20)
    private String octslvorderprocessingtatsddair;

    @Column(name = "OCTSLVORDERPROCESSTATSDDSURF", length = 20)
    private String octslvorderprocessingtatsddsurf;

    @Column(name = "OCTSLVLPHANDOVERTIMESDDAIR", length = 20)
    private String octslvlphandovertimesddair;

    @Column(name = "OCTSLVLPHANDOVERTIMESDDSURF", length = 20)
    private String octslvlphandovertimesddsurf;

    @Column(name = "SAMEDAYDEL", length = 256)
    private String sameDayDel;

    @Column(name = "OCTSLVCUTOFFTIMETATSDDAIR", length = 20)
    private String octSlvCutoffTimeTatSddAir;

    @Column(name = "OCTSLVCUTOFFTIMETATSDDSURFACE", length = 20)
    private String octSlvCutoffTimeTatSddSurface;

    @Column(name = "OCTSLVCUTOFFTIMETATNDDAIR", length = 20)
    private String octSlvCutoffTimeTatNddAir;

    @Column(name = "OCTSLVCUTOFFTIMETATNDDSURFACE", length = 20)
    private String octSlvCutoffTimeTatNddSurface;

    @Column(name = "OCTSLVORDERACCEPTANCETATNDDAIR", length = 20)
    private String octslvorderacceptancetatnddair;

    @Column(name = "OCTSLVORDERACCEPTNDDSURF", length = 20)
    private String octslvorderacceptancetatnddsurf;

    @Column(name = "OCTSLVORDERPROCESSINGTATNDDAIR", length = 20)
    private String octslvorderprocessingtatnddair;

    @Column(name = "OCTSLVORDERPROCESSTATNDDSURF", length = 20)
    private String octslvorderprocessingtatnddsurf;

    @Column(name = "OCTSLVLPHANDOVERTIMENDDAIR", length = 20)
    private String octslvlphandovertimenddair;

    @Column(name = "OCTSLVLPHANDOVERTIMENDDSURF", length = 20)
    private String octslvlphandovertimenddsurf;

    @Column(name = "OCTSLVCUTOFFTIMETATSLDAIR", length = 20)
    private String octSlvCutoffTimeTatSldAir;

    @Column(name = "OCTSLVCUTOFFTIMETATSLDSURFACE", length = 20)
    private String octSlvCutoffTimeTatSldSurface;

    @Column(name = "OCTSLVORDERACCEPTANCETATSLDAIR", length = 20)
    private String octslvorderacceptancetatsldair;

    @Column(name = "OCTSLVORDERACCEPTSLDSURF", length = 20)
    private String octslvorderacceptancetatsldsurf;

    @Column(name = "OCTSLVORDERPROCESSINGTATSLDAIR", length = 20)
    private String octslvorderprocessingtatsldair;

    @Column(name = "OCTSLVORDERPROCESSTATSLDSURF", length = 20)
    private String octslvorderprocessingtatsldsurf;

    @Column(name = "OCTSLVLPHANDOVERTIMESLDAIR", length = 20)
    private String octslvlphandovertimesldair;

    @Column(name = "OCTSLVLPHANDOVERTIMESLDSURF", length = 20)
    private String octslvlphandovertimesldsurf;

    // Other properties...

    @Column(name = "ISAUTODISPUTE", nullable = false, length = 1)
    private String isAutoDispute="N";

    @Column(name = "ISSTOCKBLOCK", nullable = false, length = 1)
    private String isStockBlock="N";

    @Column(name = "ISTULSTORE", length = 1)
    private String isTULStore="N";

    @Column(name = "ISGATIACTIVE", length = 1)
    private String isGatiActive;

    @Column(name = "ORDERCAPACITY", length = 10)
    private Integer orderCapacity;

    @Column(name = "TRANSMODETYPE", length = 10)
    private String transmodeType;

    @Column(name = "L4CATEGORYLIST", length = 255)
    private String L4CategoryList;

    @Column(name = "ISPRECIOUS", length = 1)
    private String isPrecious;

    @Column(name = "LPACTIVATIONSTATUS", length = 50)
    private String lpActivationStatus;

    @Column(name = "REJECTREASON", length = 255)
    private String rejectReason;

    @Column(name = "FSSAI", length = 255)
    private String fssai;

    @Column(name = "OCCUPIEDDAYSLIMIT", length = 10)
    private String occupiedDaysLimit;

    @Column(name = "ISPRIORITYMATRIXUPDATE")
    private Boolean isPriorityMatrixUpdate;

    @Column(name = "ISSENTTOOMS")
    private Character isSentToOms;

    @Column(name = "REGWITHSR", length = 1)
    private String regWithSR;

    @Column(name = "CONTACTINFOMODIDATE")
    private Date contactInfoModiDate;

    @Column(name = "DETAILUPDATEDFORREAPPROVAL", length = 50)
    private String detailUpdatedForReapproval;

    @Column(name = "SLVAPPROVALTYPE", length = 10)
    private String slvApprovalType;

    @ManyToOne
    @JoinColumn(name = "OCTSLVSLR", nullable = false)
    private OctSlr octSlr;

    @ManyToOne
    @JoinColumn(name = "OCTSLVTYPE", nullable = false)
    private OctParam octslvtype;

    @ManyToOne
    @JoinColumn(name = "OCTSLVRETADDRESS")
    private Ismuat octslvRetAddress;

    @ManyToOne
    @JoinColumn(name = "UATREGISTEREDADDRESS")
    private Ismuat uatRegisteredAddress;

    @ManyToOne
    @JoinColumn(name = "OCTSLVRETURNSLAVE")
    private OctSlv octSlvReturnSlave;

    @OneToMany(mappedBy = "octSlv")
    @Transient
    private Set<OctSlvDoc> octSlvDocs;
    
    @OneToMany(mappedBy = "octSlv")
    @Transient
    private Set<OctSlvUsr> octSlvUsrs;

    @OneToMany(mappedBy = "octSlv")
    @Transient
    private Set<OctSlvInfo> octSlvInfos;

    @ManyToOne
    @JoinColumn(name = "GSTREGISTRATIONSTATUS")
    private OctParam gstRegStatusParam;

    @ManyToOne
    @JoinColumn(name = "OCTSLVRTOADDRESS")
    private Ismuat octSlvRtoAddress;

    @ManyToOne
    @JoinColumn(name = "OCTSLVRTOSLAVE")
    private OctSlv octSlvRtoSlave;

    @ManyToOne
    @JoinColumn(name = "OCTSLVCITYRFNUM", nullable = false)
    private CityMaster octSlvCityrfnum;
	
	
	public String getIsPrecious() {
		return isPrecious;
	}

	public void setIsPrecious(String isPrecious) {
		this.isPrecious = isPrecious;
	}

	public String getL4CategoryList() {
		return L4CategoryList;
	}

	public void setL4CategoryList(String l4CategoryList) {
		L4CategoryList = l4CategoryList;
	}

	public String getTransmodeType() {
		return transmodeType;
	}

	public void setTransmodeType(String transmodeType) {
		this.transmodeType = transmodeType;
	}

	

	
	public String getLpActivationStatus() {
		return lpActivationStatus;
	}

	public void setLpActivationStatus(String lpActivationStatus) {
		this.lpActivationStatus = lpActivationStatus;
	}


	//@Raju added for CIR Return Address start
	

	//@Deepak Deshekar::Thermalprint cr
//	private String isThermalprint="N";

	
//	private String  isGeoFencing="N";

	
	//@Nishant Start
//	private String isRevEligible="Y";
	
	 //@Nishant Start TPR-10459
    
   //@Nishant End TPR-10459
   
	
//	private String isAutoDispute="N"; //Nishant added for TPR-13442
//	private String isStockBlock="N"; //Nishant added for WMS-12
	
//	//Manoj commission revamp
//	private String isTULStore="N";
	
	public Character getIsSentToOms() {
		return isSentToOms;
	}

	public void setIsSentToOms(Character isSentToOms) {
		this.isSentToOms = isSentToOms;
	}

	public Boolean getIsPriorityMatrixUpdate() {
	    return isPriorityMatrixUpdate;
	}

	public void setIsPriorityMatrixUpdate(Boolean isPriorityMatrixUpdate) {
	    this.isPriorityMatrixUpdate = isPriorityMatrixUpdate;
	}

	public String getRejectReason() {
		return rejectReason;
	}

	public void setRejectReason(String rejectReason) {
		this.rejectReason = rejectReason;
	}
	public String getOccupiedDaysLimit() {
		return occupiedDaysLimit;
	}

	public void setOccupiedDaysLimit(String occupiedDaysLimit) {
		this.occupiedDaysLimit = occupiedDaysLimit;
	}

	/** full constructor */
	public OctSlv(Date createdate, Long createdby, String deleted, Date modidate, Long modifiedby, String octslvcode, String octslvisactive, String octslvlname, String octslvlogo, String octslvname, String octslvpan, Long orgid,String octslvlatitude,String octslvlongitude,String octslvopentime,String octslvclosetime, com.sellerportal.model.OctSlr octSlr, Set<OctSlvDoc> octSlvDocs, Set<OctSlvUsr> octSlvUsrs, Set<OctSlvInfo> octSlvInfos,String ismailsent, com.sellerportal.model.OctParam octslvtype, String octslvislisting,String octslvCollectEnable,com.sellerportal.model.Ismuat octslvRetAddress,String octslvvat,String octslvservice,String octslvcst ,String octSlvRemark,String octSlvFinanceYear, String regWithSR) {
		this.createdate = createdate;
		this.createdby = createdby;
		this.deleted = deleted;
		this.modidate = modidate;
		this.modifiedby = modifiedby;
		this.octslvcode = octslvcode;
		this.octslvisactive = octslvisactive;
		this.octslvlname = octslvlname;
		this.octslvlogo = octslvlogo;
		this.octslvname = octslvname;
		this.octslvpan = octslvpan;
		this.octslvtype = octslvtype;
		this.octSlvFinanceYear=octSlvFinanceYear;
		this.orgid = orgid;  
		this.octslvlatitude = octslvlatitude;
		this.octslvlongitude = octslvlongitude;
		this.octslvopentime = octslvopentime;
		this.octslvclosetime = octslvclosetime; 
		this.octSlr = octSlr;
		this.octSlvDocs = octSlvDocs;
		this.octSlvUsrs = octSlvUsrs;
		this.octSlvInfos = octSlvInfos;
		this.ismailsent = ismailsent;
		this.octSlvIsListing = octslvislisting;
		this.octslvCollectEnable = octslvCollectEnable;
		this.octslvRetAddress = octslvRetAddress;
		this.octslvvat = octslvvat;
		this.octslvcst = octslvcst;
		this.octslvservice = octslvservice;
		this.octSlvRemark = octSlvRemark;
		this.regWithSR = regWithSR;
	}

	/** default constructor */
	public OctSlv() {
	}

	/** minimal constructor */
	public OctSlv(Date createdate, Long createdby, String deleted, Date modidate, Long modifiedby, String octslvcode, String octslvlname, String octslvname, Long orgid, com.sellerportal.model.OctSlr octSlr, Set<OctSlvDoc> octSlvDocs, Set<OctSlvUsr> octSlvUsrs, Set<OctSlvInfo> octSlvInfos,String ismailsent ,String octSlvRemark, String regWithSR) {
		this.createdate = createdate;
		this.createdby = createdby;
		this.deleted = deleted;
		this.modidate = modidate;
		this.modifiedby = modifiedby;
		this.octslvcode = octslvcode;
		this.octslvlname = octslvlname;
		this.octslvname = octslvname;
		this.orgid = orgid;
		this.octSlr = octSlr;
		this.octSlvDocs = octSlvDocs;
		this.octSlvUsrs = octSlvUsrs;
		this.octSlvInfos = octSlvInfos;
		this.ismailsent = ismailsent;
		this.octSlvRemark = octSlvRemark;
		this.regWithSR = regWithSR;

	}



	public String getIsGeoFencing() {
		return isGeoFencing;
	}

	public void setIsGeoFencing(String isGeoFencing) {
		this.isGeoFencing = isGeoFencing;
	}

	public com.sellerportal.model.OctParam getOctslvtype() {
		return octslvtype;
	}

	public void setOctslvtype(com.sellerportal.model.OctParam octslvtype) {
		this.octslvtype = octslvtype;
	}

	/** 
	 * 		       auto_increment
	 * 		    
	 */
	public Long getOctslvrfnum() {
		return this.octslvrfnum;
	}

	public void setOctslvrfnum(Long octslvrfnum) {
		this.octslvrfnum = octslvrfnum;
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

	public String getOctslvcode() {
		return this.octslvcode;
	}

	public void setOctslvcode(String octslvcode) {
		this.octslvcode = octslvcode;
	}

	public String getOctslvisactive() {
		return this.octslvisactive;
	}

	public void setOctslvisactive(String octslvisactive) {
		this.octslvisactive = octslvisactive;
	}

	public String getOctslvlname() {
		return this.octslvlname;
	}

	public void setOctslvlname(String octslvlname) {
		this.octslvlname = octslvlname;
	}

	public String getOctslvlogo() {
		return this.octslvlogo;
	}

	public void setOctslvlogo(String octslvlogo) {
		this.octslvlogo = octslvlogo;
	}

	public String getOctslvname() {
		return this.octslvname;
	}

	public void setOctslvname(String octslvname) {
		this.octslvname = octslvname;
	}

	public String getOctslvpan() {
		return this.octslvpan;
	}

	public void setOctslvpan(String octslvpan) {
		this.octslvpan = octslvpan;
	}


	public Long getOrgid() {
		return this.orgid;
	}

	public void setOrgid(Long orgid) {
		this.orgid = orgid;
	}

	public com.sellerportal.model.OctSlr getOctSlr() {
		return this.octSlr;
	}

	public void setOctSlr(com.sellerportal.model.OctSlr octSlr) {
		this.octSlr = octSlr;
	}

	public Set<OctSlvDoc> getOctSlvDocs() {
		return this.octSlvDocs;
	}

	public void setOctSlvDocs(Set<OctSlvDoc> octSlvDocs) {
		this.octSlvDocs = octSlvDocs;
	}

	public Set<OctSlvUsr> getOctSlvUsrs() {
		return this.octSlvUsrs;
	}

	public void setOctSlvUsrs(Set<OctSlvUsr> octSlvUsrs) {
		this.octSlvUsrs = octSlvUsrs;
	}

	public Set<OctSlvInfo> getOctSlvInfos() {
		return this.octSlvInfos;
	}

	public void setOctSlvInfos(Set<OctSlvInfo> octSlvInfos) {
		this.octSlvInfos = octSlvInfos;
	}

	public String toString() {
		return new ToStringBuilder(this)
		.append("octslvrfnum", getOctslvrfnum())
		.toString();
	}

	public String getIsmailsent() {
		return ismailsent;
	}

	public void setIsmailsent(String ismailsent) {
		this.ismailsent = ismailsent;
	}


	public String getOctSlvIsListing() {
		return octSlvIsListing;
	}

	public void setOctSlvIsListing(String octSlvIsListing) {
		this.octSlvIsListing = octSlvIsListing;
	}

	public String getOctslvlatitude() {
		return octslvlatitude;
	}

	public void setOctslvlatitude(String octslvlatitude) {
		this.octslvlatitude = octslvlatitude;
	}

	public String getOctslvlongitude() {
		return octslvlongitude;
	}

	public void setOctslvlongitude(String octslvlongitude) {
		this.octslvlongitude = octslvlongitude;
	}

	public String getOctslvopentime() {
		return octslvopentime;
	}

	public void setOctslvopentime(String octslvopentime) {
		this.octslvopentime = octslvopentime;
	}

	public String getOctslvclosetime() {
		return octslvclosetime;
	}

	public void setOctslvclosetime(String octslvclosetime) {
		this.octslvclosetime = octslvclosetime;
	}

	public String getOctslvCollectEnable() {
		return octslvCollectEnable;
	}

	public void setOctslvCollectEnable(String octslvCollectEnable) {
		this.octslvCollectEnable = octslvCollectEnable;
	}

	public com.sellerportal.model.Ismuat getOctslvRetAddress() {
		return octslvRetAddress;
	}

	public void setOctslvRetAddress(com.sellerportal.model.Ismuat octslvRetAddress) {
		this.octslvRetAddress = octslvRetAddress;
	}

	public String getOctslvvat() {
		return octslvvat;
	}

	public void setOctslvvat(String octslvvat) {
		this.octslvvat = octslvvat;
	}

	public String getOctslvservice() {
		return octslvservice;
	}

	public void setOctslvservice(String octslvservice) {
		this.octslvservice = octslvservice;
	}

	public String getOctslvcst() {
		return octslvcst;
	}

	public void setOctslvcst(String octslvcst) {
		this.octslvcst = octslvcst;
	}

	public String getOctslvparking() {
		return octslvparking;
	}

	public void setOctslvparking(String octslvparking) {
		this.octslvparking = octslvparking;
	}

	public String getOctslvloc() {
		return octslvloc;
	}

	public void setOctslvloc(String octslvloc) {
		this.octslvloc = octslvloc;
	}

	public String getOctslvstoresize() {
		return octslvstoresize;
	}

	public void setOctslvstoresize(String octslvstoresize) {
		this.octslvstoresize = octslvstoresize;
	}

	public Long getOctslvfootfall() {
		return octslvfootfall;
	}

	public void setOctslvfootfall(Long octslvfootfall) {
		this.octslvfootfall = octslvfootfall;
	}

	public String getOctslvownership() {
		return octslvownership;
	}

	public void setOctslvownership(String octslvownership) {
		this.octslvownership = octslvownership;
	}

	public String getOctslvretsalstate() {
		return octslvretsalstate;
	}

	public void setOctslvretsalstate(String octslvretsalstate) {
		this.octslvretsalstate = octslvretsalstate;
	}

	public Long getInvoiceNumber() {
		return invoiceNumber;
	}

	public void setInvoiceNumber(Long invoiceNumber) {
		this.invoiceNumber = invoiceNumber;
	}

	public String getOctSlvRemark() {
		return octSlvRemark;
	}

	public void setOctSlvRemark(String octSlvRemark) {
		this.octSlvRemark = octSlvRemark;
	}

	public com.sellerportal.model.Ismuat getUatRegisteredAddress() {
		return uatRegisteredAddress;
	}

	public void setUatRegisteredAddress(com.sellerportal.model.Ismuat uatRegisteredAddress) {
		this.uatRegisteredAddress = uatRegisteredAddress;
	}

	public com.sellerportal.model.OctSlv getOctSlvReturnSlave() {
		return octSlvReturnSlave;
	}

	public void setOctSlvReturnSlave(com.sellerportal.model.OctSlv octSlvReturnSlave) {
		this.octSlvReturnSlave = octSlvReturnSlave;
	}

	//@Avinash added for 2 more logo images start
	public String getOctslvlogo2() {
		return octslvlogo2;
	}

	public void setOctslvlogo2(String octslvlogo2) {
		this.octslvlogo2 = octslvlogo2;
	}

	public String getOctslvlogo3() {
		return octslvlogo3;
	}

	public void setOctslvlogo3(String octslvlogo3) {
		this.octslvlogo3 = octslvlogo3;
	}
	//@Avinash added for 2 more logo images end

	public String getOctSlvFinanceYear() {
		return octSlvFinanceYear;
	}

	public void setOctSlvFinanceYear(String octSlvFinanceYear) {
		this.octSlvFinanceYear = octSlvFinanceYear;
	}

	public String getOctSlvIsReturnToStore() {
		return octSlvIsReturnToStore;
	}

	public void setOctSlvIsReturnToStore(String octSlvIsReturnToStore) {
		this.octSlvIsReturnToStore = octSlvIsReturnToStore;
	}

	
	public String getIsLpStoreActive() {
		return isLpStoreActive;
	}

	public void setIsLpStoreActive(String isLpStoreActive) {
		this.isLpStoreActive = isLpStoreActive;
	}

	public String getOctslvorderacceptancetat() {
		return octslvorderacceptancetat;
	}

	public void setOctslvorderacceptancetat(String octslvorderacceptancetat) {
		this.octslvorderacceptancetat = octslvorderacceptancetat;
	}

	public String getOctslvorderprocessingtat() {
		return octslvorderprocessingtat;
	}

	public void setOctslvorderprocessingtat(String octslvorderprocessingtat) {
		this.octslvorderprocessingtat = octslvorderprocessingtat;
	}

	public String getOctslvlphandovertime() {
		return octslvlphandovertime;
	}

	public void setOctslvlphandovertime(String octslvlphandovertime) {
		this.octslvlphandovertime = octslvlphandovertime;
	}

	public String getOctslvorderacceptancetatedair() {
		return octslvorderacceptancetatedair;
	}

	public void setOctslvorderacceptancetatedair(
			String octslvorderacceptancetatedair) {
		this.octslvorderacceptancetatedair = octslvorderacceptancetatedair;
	}

	public String getOctslvorderacceptancetathdsurf() {
		return octslvorderacceptancetathdsurf;
	}

	public void setOctslvorderacceptancetathdsurf(
			String octslvorderacceptancetathdsurf) {
		this.octslvorderacceptancetathdsurf = octslvorderacceptancetathdsurf;
	}

	public String getOctslvorderacceptancetatedsurf() {
		return octslvorderacceptancetatedsurf;
	}

	public void setOctslvorderacceptancetatedsurf(
			String octslvorderacceptancetatedsurf) {
		this.octslvorderacceptancetatedsurf = octslvorderacceptancetatedsurf;
	}

	public String getOctslvorderprocessingtatedair() {
		return octslvorderprocessingtatedair;
	}

	public void setOctslvorderprocessingtatedair(
			String octslvorderprocessingtatedair) {
		this.octslvorderprocessingtatedair = octslvorderprocessingtatedair;
	}

	public String getOctslvorderprocessingtathdsurf() {
		return octslvorderprocessingtathdsurf;
	}

	public void setOctslvorderprocessingtathdsurf(
			String octslvorderprocessingtathdsurf) {
		this.octslvorderprocessingtathdsurf = octslvorderprocessingtathdsurf;
	}

	public String getOctslvorderprocessingtatedsurf() {
		return octslvorderprocessingtatedsurf;
	}

	public void setOctslvorderprocessingtatedsurf(
			String octslvorderprocessingtatedsurf) {
		this.octslvorderprocessingtatedsurf = octslvorderprocessingtatedsurf;
	}

	public String getOctslvlphandovertimeedair() {
		return octslvlphandovertimeedair;
	}

	public void setOctslvlphandovertimeedair(String octslvlphandovertimeedair) {
		this.octslvlphandovertimeedair = octslvlphandovertimeedair;
	}

	public String getOctslvlphandovertimehdsurf() {
		return octslvlphandovertimehdsurf;
	}

	public void setOctslvlphandovertimehdsurf(String octslvlphandovertimehdsurf) {
		this.octslvlphandovertimehdsurf = octslvlphandovertimehdsurf;
	}

	public String getOctslvlphandovertimeedsurf() {
		return octslvlphandovertimeedsurf;
	}

	public void setOctslvlphandovertimeedsurf(String octslvlphandovertimeedsurf) {
		this.octslvlphandovertimeedsurf = octslvlphandovertimeedsurf;
	}

	public String getGstregistrationNo() {
		return gstregistrationNo;
	}

	public void setGstregistrationNo(String gstregistrationNo) {
		this.gstregistrationNo = gstregistrationNo;
	}

	public Date getGstregistrationdate() {
		return gstregistrationdate;
	}

	public void setGstregistrationdate(Date gstregistrationdate) {
		this.gstregistrationdate = gstregistrationdate;
	}

	public OctParam getGstRegStatusParam() {
		return gstRegStatusParam;
	}

	public void setGstRegStatusParam(OctParam gstRegStatusParam) {
		this.gstRegStatusParam = gstRegStatusParam;
	}

	public String getIsThermalprint() {
		return isThermalprint;
	}

	public void setIsThermalprint(String isThermalprint) {
		this.isThermalprint = isThermalprint;
	}

	public String getIsAllowErPanel() {
		return isAllowErPanel;
	}

	public void setIsAllowErPanel(String isAllowErPanel) {
		this.isAllowErPanel = isAllowErPanel;
	}

	public String getLpMahindraSlvId() {
		return lpMahindraSlvId;
	}

	public void setLpMahindraSlvId(String lpMahindraSlvId) {
		this.lpMahindraSlvId = lpMahindraSlvId;
	}

	public String getAllowRejectReason() {
		return allowRejectReason;
	}

	public void setAllowRejectReason(String allowRejectReason) {
		this.allowRejectReason = allowRejectReason;
	}

	public Date getOctSlvListingDate() {
		return octSlvListingDate;
	}

	public void setOctSlvListingDate(Date octSlvListingDate) {
		this.octSlvListingDate = octSlvListingDate;
	}

	public com.sellerportal.model.Ismuat getOctSlvRtoAddress() {
		return octSlvRtoAddress;
	}

	public void setOctSlvRtoAddress(com.sellerportal.model.Ismuat octSlvRtoAddress) {
		this.octSlvRtoAddress = octSlvRtoAddress;
	}

	public com.sellerportal.model.OctSlv getOctSlvRtoSlave() {
		return octSlvRtoSlave;
	}

	public void setOctSlvRtoSlave(com.sellerportal.model.OctSlv octSlvRtoSlave) {
		this.octSlvRtoSlave = octSlvRtoSlave;
	}

	public String getIsAPOB() {
		return isAPOB;
	}

	public void setIsAPOB(String isAPOB) {
		this.isAPOB = isAPOB;
	}
	public String getIsRevEligible() {
		return isRevEligible;
	}

	public void setIsRevEligible(String isRevEligible) {
		this.isRevEligible = isRevEligible;
	}
	
	public com.sellerportal.model.CityMaster getOctSlvCityrfnum() {
		return octSlvCityrfnum;
	}

	public void setOctSlvCityrfnum(com.sellerportal.model.CityMaster octSlvCityrfnum) {
		this.octSlvCityrfnum = octSlvCityrfnum;
	}

	public int getPenaltyDays() {
		return penaltyDays;
	}

	public void setPenaltyDays(int penaltyDays) {
		this.penaltyDays = penaltyDays;
	}

	public String getOctslvorderacceptancetatsddair() {
		return octslvorderacceptancetatsddair;
	}

	public void setOctslvorderacceptancetatsddair(
			String octslvorderacceptancetatsddair) {
		this.octslvorderacceptancetatsddair = octslvorderacceptancetatsddair;
	}

	public String getOctslvorderacceptancetatsddsurf() {
		return octslvorderacceptancetatsddsurf;
	}

	public void setOctslvorderacceptancetatsddsurf(
			String octslvorderacceptancetatsddsurf) {
		this.octslvorderacceptancetatsddsurf = octslvorderacceptancetatsddsurf;
	}

	public String getOctslvorderprocessingtatsddair() {
		return octslvorderprocessingtatsddair;
	}

	public void setOctslvorderprocessingtatsddair(
			String octslvorderprocessingtatsddair) {
		this.octslvorderprocessingtatsddair = octslvorderprocessingtatsddair;
	}

	public String getOctslvorderprocessingtatsddsurf() {
		return octslvorderprocessingtatsddsurf;
	}

	public void setOctslvorderprocessingtatsddsurf(
			String octslvorderprocessingtatsddsurf) {
		this.octslvorderprocessingtatsddsurf = octslvorderprocessingtatsddsurf;
	}

	public String getOctslvlphandovertimesddair() {
		return octslvlphandovertimesddair;
	}

	public void setOctslvlphandovertimesddair(String octslvlphandovertimesddair) {
		this.octslvlphandovertimesddair = octslvlphandovertimesddair;
	}

	public String getOctslvlphandovertimesddsurf() {
		return octslvlphandovertimesddsurf;
	}

	public void setOctslvlphandovertimesddsurf(String octslvlphandovertimesddsurf) {
		this.octslvlphandovertimesddsurf = octslvlphandovertimesddsurf;
	}

	public String getSameDayDel() {
		return sameDayDel;
	}

	public void setSameDayDel(String sameDayDel) {
		this.sameDayDel = sameDayDel;
	}

	

	public String getIsAutoDispute() {
		return isAutoDispute;
	}

	public void setIsAutoDispute(String isAutoDispute) {
		this.isAutoDispute = isAutoDispute;
	}

	public String getIsStockBlock() {
		return isStockBlock;
	}

	public void setIsStockBlock(String isStockBlock) {
		this.isStockBlock = isStockBlock;
	}
	
	public String getIsTULStore() {
		return isTULStore;
	}

	public void setIsTULStore(String isTULStore) {
		this.isTULStore = isTULStore;
	}

	public String getIsGatiActive() {
		return isGatiActive;
	}

	public void setIsGatiActive(String isGatiActive) {
		this.isGatiActive = isGatiActive;
	}

	public Integer getOrderCapacity() {
		return orderCapacity;
	}

	public void setOrderCapacity(Integer orderCapacity) {
		this.orderCapacity = orderCapacity;
	}

	public String getOctSlvCutoffTimeTatHdAir() {
		return octSlvCutoffTimeTatHdAir;
	}

	public void setOctSlvCutoffTimeTatHdAir(String octSlvCutoffTimeTatHdAir) {
		this.octSlvCutoffTimeTatHdAir = octSlvCutoffTimeTatHdAir;
	}

	public String getOctSlvCutoffTimeTatHdSurface() {
		return octSlvCutoffTimeTatHdSurface;
	}

	public void setOctSlvCutoffTimeTatHdSurface(String octSlvCutoffTimeTatHdSurface) {
		this.octSlvCutoffTimeTatHdSurface = octSlvCutoffTimeTatHdSurface;
	}

	public String getOctSlvCutoffTimeTatEdAir() {
		return octSlvCutoffTimeTatEdAir;
	}

	public void setOctSlvCutoffTimeTatEdAir(String octSlvCutoffTimeTatEdAir) {
		this.octSlvCutoffTimeTatEdAir = octSlvCutoffTimeTatEdAir;
	}

	public String getOctSlvCutoffTimeTatEdSurface() {
		return octSlvCutoffTimeTatEdSurface;
	}

	public void setOctSlvCutoffTimeTatEdSurface(String octSlvCutoffTimeTatEdSurface) {
		this.octSlvCutoffTimeTatEdSurface = octSlvCutoffTimeTatEdSurface;
	}

	public String getOctSlvCutoffTimeTatSddAir() {
		return octSlvCutoffTimeTatSddAir;
	}

	public void setOctSlvCutoffTimeTatSddAir(String octSlvCutoffTimeTatSddAir) {
		this.octSlvCutoffTimeTatSddAir = octSlvCutoffTimeTatSddAir;
	}

	public String getOctSlvCutoffTimeTatSddSurface() {
		return octSlvCutoffTimeTatSddSurface;
	}

	public void setOctSlvCutoffTimeTatSddSurface(String octSlvCutoffTimeTatSddSurface) {
		this.octSlvCutoffTimeTatSddSurface = octSlvCutoffTimeTatSddSurface;
	}
	
	
	public String getFssai() {
		return fssai;
	}

	public void setFssai(String fssai) {
		this.fssai = fssai;
	}

	public String getOctslvorderacceptancetatnddair() {
		return octslvorderacceptancetatnddair;
	}

	public void setOctslvorderacceptancetatnddair(String octslvorderacceptancetatnddair) {
		this.octslvorderacceptancetatnddair = octslvorderacceptancetatnddair;
	}

	public String getOctslvorderacceptancetatnddsurf() {
		return octslvorderacceptancetatnddsurf;
	}

	public void setOctslvorderacceptancetatnddsurf(String octslvorderacceptancetatnddsurf) {
		this.octslvorderacceptancetatnddsurf = octslvorderacceptancetatnddsurf;
	}

	public String getOctslvorderprocessingtatnddair() {
		return octslvorderprocessingtatnddair;
	}

	public void setOctslvorderprocessingtatnddair(String octslvorderprocessingtatnddair) {
		this.octslvorderprocessingtatnddair = octslvorderprocessingtatnddair;
	}

	public String getOctslvorderprocessingtatnddsurf() {
		return octslvorderprocessingtatnddsurf;
	}

	public void setOctslvorderprocessingtatnddsurf(String octslvorderprocessingtatnddsurf) {
		this.octslvorderprocessingtatnddsurf = octslvorderprocessingtatnddsurf;
	}

	public String getOctslvlphandovertimenddair() {
		return octslvlphandovertimenddair;
	}

	public void setOctslvlphandovertimenddair(String octslvlphandovertimenddair) {
		this.octslvlphandovertimenddair = octslvlphandovertimenddair;
	}

	public String getOctslvlphandovertimenddsurf() {
		return octslvlphandovertimenddsurf;
	}

	public void setOctslvlphandovertimenddsurf(String octslvlphandovertimenddsurf) {
		this.octslvlphandovertimenddsurf = octslvlphandovertimenddsurf;
	}

	public String getOctslvorderacceptancetatsldair() {
		return octslvorderacceptancetatsldair;
	}

	public void setOctslvorderacceptancetatsldair(String octslvorderacceptancetatsldair) {
		this.octslvorderacceptancetatsldair = octslvorderacceptancetatsldair;
	}

	public String getOctslvorderacceptancetatsldsurf() {
		return octslvorderacceptancetatsldsurf;
	}

	public void setOctslvorderacceptancetatsldsurf(String octslvorderacceptancetatsldsurf) {
		this.octslvorderacceptancetatsldsurf = octslvorderacceptancetatsldsurf;
	}

	public String getOctslvorderprocessingtatsldair() {
		return octslvorderprocessingtatsldair;
	}

	public void setOctslvorderprocessingtatsldair(String octslvorderprocessingtatsldair) {
		this.octslvorderprocessingtatsldair = octslvorderprocessingtatsldair;
	}

	public String getOctslvorderprocessingtatsldsurf() {
		return octslvorderprocessingtatsldsurf;
	}

	public void setOctslvorderprocessingtatsldsurf(String octslvorderprocessingtatsldsurf) {
		this.octslvorderprocessingtatsldsurf = octslvorderprocessingtatsldsurf;
	}

	public String getOctslvlphandovertimesldair() {
		return octslvlphandovertimesldair;
	}

	public void setOctslvlphandovertimesldair(String octslvlphandovertimesldair) {
		this.octslvlphandovertimesldair = octslvlphandovertimesldair;
	}

	public String getOctslvlphandovertimesldsurf() {
		return octslvlphandovertimesldsurf;
	}

	public void setOctslvlphandovertimesldsurf(String octslvlphandovertimesldsurf) {
		this.octslvlphandovertimesldsurf = octslvlphandovertimesldsurf;
	}

	public String getOctSlvCutoffTimeTatNddAir() {
		return octSlvCutoffTimeTatNddAir;
	}

	public void setOctSlvCutoffTimeTatNddAir(String octSlvCutoffTimeTatNddAir) {
		this.octSlvCutoffTimeTatNddAir = octSlvCutoffTimeTatNddAir;
	}

	public String getOctSlvCutoffTimeTatNddSurface() {
		return octSlvCutoffTimeTatNddSurface;
	}

	public void setOctSlvCutoffTimeTatNddSurface(String octSlvCutoffTimeTatNddSurface) {
		this.octSlvCutoffTimeTatNddSurface = octSlvCutoffTimeTatNddSurface;
	}

	public String getOctSlvCutoffTimeTatSldAir() {
		return octSlvCutoffTimeTatSldAir;
	}

	public void setOctSlvCutoffTimeTatSldAir(String octSlvCutoffTimeTatSldAir) {
		this.octSlvCutoffTimeTatSldAir = octSlvCutoffTimeTatSldAir;
	}

	public String getOctSlvCutoffTimeTatSldSurface() {
		return octSlvCutoffTimeTatSldSurface;
	}

	public void setOctSlvCutoffTimeTatSldSurface(String octSlvCutoffTimeTatSldSurface) {
		this.octSlvCutoffTimeTatSldSurface = octSlvCutoffTimeTatSldSurface;
	}

	public String getRegWithSR() {
		return regWithSR;
	}

	public void setRegWithSR(String regWithSR) {
		this.regWithSR = regWithSR;
	}

	public Date getContactInfoModiDate() {
		return contactInfoModiDate;
	}

	public void setContactInfoModiDate(Date contactInfoModiDate) {
		this.contactInfoModiDate = contactInfoModiDate;
	}

	public String getDetailUpdatedForReapproval() {
		return detailUpdatedForReapproval;
	}

	public void setDetailUpdatedForReapproval(String detailUpdatedForReapproval) {
		this.detailUpdatedForReapproval = detailUpdatedForReapproval;
	}

	public String getSlvApprovalType() {
		return slvApprovalType;
	}

	public void setSlvApprovalType(String slvApprovalType) {
		this.slvApprovalType = slvApprovalType;
	}
	
}