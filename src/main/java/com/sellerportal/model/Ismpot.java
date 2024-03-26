package com.sellerportal.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigDecimal;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.apache.commons.lang.builder.ToStringBuilder;


/** @author Hibernate CodeGenerator */
@Entity
@Table(name = "ismpot")
public class Ismpot implements Serializable {

	/** identifier field */
	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long potrfnum;

   /** persistent field */
	@Column(name = "BILLADDRESS1")
   private String billaddress1;

   /** persistent field */
	@Column(name = "BILLADDRESS2")
   private String billaddress2;

   /** persistent field */
	@Column(name = "BILLADDRESS3")
   private String billaddress3;

   /** persistent field */
	@Column(name = "BILLCITYORDISTRICT")
   private String billcityordistrict;

   /** persistent field */
	@Column(name = "BILLCOUNTRY")
   private String billcountry;

   /** persistent field */
	@Column(name = "BILLEMAILID")
   private String billemailid;

   /** persistent field */
	@Column(name = "BILLFIRSTNAME")
   private String billfirstname;

   /** persistent field */
	@Column(name = "BILLLASTNAME")
   private String billlastname;

   /** persistent field */
	@Column(name = "BILLMIDDLENAME")
   private String billmiddlename;

   /** persistent field */
	@Column(name = "BILLPHONENO")
   private String billphoneno;

   /** persistent field */
	@Column(name = "BILLPINCODE")
   private String billpincode;

   /** persistent field */
	@Column(name = "BILLSTATE")
   private String billstate;

   /** persistent field */
	@Column(name = "CREATEDATE")
   private Date createdate;

   /** persistent field */
	@Column(name = "CREATEDBY")
   private Long createdby;

   /** persistent field */
	@Column(name = "CUSTOMERID")
   private String customerid;

   /** nullable persistent field */
	@Column(name = "DELETED")
   private String deleted;

   /** nullable persistent field */
	@Column(name = "MODIDATE")
   private Date modidate;

   /** persistent field */
	@Column(name = "MODIFIEDBY")
   private Long modifiedby;

   /** persistent field */
	@Column(name = "ORDERREFNO")
   private String orderrefno;

   /** persistent field */
	@Column(name = "SELLERCODE")
   private String sellercode;
   
	@Column(name = "ORDERID")
   private String orderid;

   /** persistent field */
	@Column(name = "SUBMISSIONDATETIME")
   private Date submissiondatetime;
   
	@Column(name = "ORIGINALORDERREFNO")
   private String originalorderrefno;
   
	@Column(name = "SHIPPINGLAT")
   private BigDecimal shippingLat;
	
	@Column(name = "SHIPPINGLON")
   private BigDecimal shippingLon;

	/** persistent field */
	@ManyToOne
	@JoinColumn(name = "POTSMTSTATUS")
   private Ismsmt ismsmt;

   /** persistent field */
	@ManyToOne
	@JoinColumn(name = "POTSMDRFNUM")
   private Ismsmd ismsmd;

   /** persistent field */
	@ManyToOne
	@JoinColumn(name = "SELLERREF")
   private OctSlr octSlr;
   
   /** persistent field */
	@ManyToOne
	@JoinColumn(name = "ORDERTYPE")
   private OctParam ordertype;

   /** persistent field */
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "ismpot")
	@Transient
   private Set<Ismotl> ismotls;

   /** persistent field */
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "ismpot")
	@Transient
   private Set<Ismpst> ismpsts;
	
	@Column(name = "statecode")
   private String statecode;
   
	@Column(name = "countrycode")
   private String countrycode;   

   
 //@Raju R2 Merged start
	@Column(name = "SECURITYCODE1")
   private String securityCode1;
	
	@Column(name = "SECURITYCODE2")
   private String securityCode2;
	
	@Column(name = "COLLECTIONEXPIRYDATE")
   private String collectionExpiryDate;
	
	@Column(name = "COLLECTIONEXPIRYCOUNTER")
   private Long collectionExpiryCounter;
	
	@Column(name = "CHECKBOGOORDER")
   private String checkBogoOrder;
	
	@Column(name = "ISSEND")
   private String isSend; 
	
	@Column(name = "ISCOMPLETED")
   private String isCompleted;
	
	@Column(name = "ISDONE")
   private String isDone; 
   
	@Column(name = "SPCREATEDATE")
   private Date spCreateDate;
   
	@Column(name = "ISBUNDLINGAVAILABLE")
   private String isBundlingAvailable;
   
	@Column(name = "ORIGINALORDERID")
   private String originalOrderId;
   
   public String getIsCompleted() {
		return isCompleted;
	}

	public void setIsCompleted(String isCompleted) {
		this.isCompleted = isCompleted;
	}

	 
   
   //@Raju R2 Merged end
   
	/** full constructor */
   public Ismpot(Long potrfnum, String billaddress1, String billaddress2, String billaddress3, String billcityordistrict, String billcountry, String billemailid, String billfirstname, String billlastname, String billmiddlename, String billphoneno, String billpincode, String billstate, Date createdate, Long createdby, String customerid, String deleted, Date modidate, Long modifiedby, String orderrefno, OctParam ordertype, String sellercode,String orderid, Date submissiondatetime, Ismsmt ismsmt, Ismsmd ismsmd, OctSlr octSlr, Set<Ismotl> ismotls, Set<Ismpst> ismpsts,String isSend,BigDecimal shippingLat ,BigDecimal shippingLon) {
       this.potrfnum = potrfnum;
       this.billaddress1 = billaddress1;
       this.billaddress2 = billaddress2;
       this.billaddress3 = billaddress3;
       this.billcityordistrict = billcityordistrict;
       this.billcountry = billcountry;
       this.billemailid = billemailid;
       this.billfirstname = billfirstname;
       this.billlastname = billlastname;
       this.billmiddlename = billmiddlename;
       this.billphoneno = billphoneno;
       this.billpincode = billpincode;
       this.billstate = billstate;
       this.createdate = createdate;
       this.createdby = createdby;
       this.customerid = customerid;
       this.deleted = deleted;
       this.modidate = modidate;
       this.modifiedby = modifiedby;
       this.orderrefno = orderrefno;
       this.setOrdertype(ordertype);
       this.sellercode = sellercode;
       this.orderid=orderid;
       this.submissiondatetime = submissiondatetime;
       this.ismsmt = ismsmt;
       this.ismsmd = ismsmd;
       this.octSlr = octSlr;
       this.ismotls = ismotls;
       this.ismpsts = ismpsts;
       this.isSend=isSend;
       this.shippingLat=shippingLat;
       this.shippingLon=shippingLon;
   }

   /** default constructor */
   public Ismpot() {
   }

   /** minimal constructor */
   public Ismpot(Long potrfnum, String billaddress1, String billaddress2, String billaddress3, String billcityordistrict, String billcountry, String billemailid, String billfirstname, String billlastname, String billmiddlename, String billphoneno, String billpincode, String billstate, Date createdate, Long createdby, String customerid, Long modifiedby, String orderrefno, OctParam ordertype, String sellercode, Date submissiondatetime, Ismsmt ismsmt, Ismsmd ismsmd, OctSlr octSlr, Set<Ismotl> ismotls, Set<Ismpst> ismpsts) {
       this.potrfnum = potrfnum;
       this.billaddress1 = billaddress1;
       this.billaddress2 = billaddress2;
       this.billaddress3 = billaddress3;
       this.billcityordistrict = billcityordistrict;
       this.billcountry = billcountry;
       this.billemailid = billemailid;
       this.billfirstname = billfirstname;
       this.billlastname = billlastname;
       this.billmiddlename = billmiddlename;
       this.billphoneno = billphoneno;
       this.billpincode = billpincode;
       this.billstate = billstate;
       this.createdate = createdate;
       this.createdby = createdby;
       this.customerid = customerid;
       this.modifiedby = modifiedby;
       this.orderrefno = orderrefno;
       this.setOrdertype(ordertype);
       this.sellercode = sellercode;
       this.submissiondatetime = submissiondatetime;
       this.ismsmt = ismsmt;
       this.ismsmd = ismsmd;
       this.octSlr = octSlr;
       this.ismotls = ismotls;
       this.ismpsts = ismpsts;
   }

   public Long getPotrfnum() {
       return this.potrfnum;
   }

   public void setPotrfnum(Long potrfnum) {
       this.potrfnum = potrfnum;
   }

   public String getBilladdress1() {
       return this.billaddress1;
   }

   public void setBilladdress1(String billaddress1) {
       this.billaddress1 = billaddress1;
   }

   public String getBilladdress2() {
       return this.billaddress2;
   }

   public void setBilladdress2(String billaddress2) {
       this.billaddress2 = billaddress2;
   }

   public String getBilladdress3() {
       return this.billaddress3;
   }

   public void setBilladdress3(String billaddress3) {
       this.billaddress3 = billaddress3;
   }

   public String getBillcityordistrict() {
       return this.billcityordistrict;
   }

   public void setBillcityordistrict(String billcityordistrict) {
       this.billcityordistrict = billcityordistrict;
   }

   public String getBillcountry() {
       return this.billcountry;
   }

   public void setBillcountry(String billcountry) {
       this.billcountry = billcountry;
   }

   public String getBillemailid() {
       return this.billemailid;
   }

   public void setBillemailid(String billemailid) {
       this.billemailid = billemailid;
   }

   public String getBillfirstname() {
       return this.billfirstname;
   }

   public void setBillfirstname(String billfirstname) {
       this.billfirstname = billfirstname;
   }

   public String getBilllastname() {
       return this.billlastname;
   }

   public void setBilllastname(String billlastname) {
       this.billlastname = billlastname;
   }

   public String getBillmiddlename() {
       return this.billmiddlename;
   }

   public void setBillmiddlename(String billmiddlename) {
       this.billmiddlename = billmiddlename;
   }

   public String getBillphoneno() {
       return this.billphoneno;
   }

   public void setBillphoneno(String billphoneno) {
       this.billphoneno = billphoneno;
   }

   public String getBillpincode() {
       return this.billpincode;
   }

   public void setBillpincode(String billpincode) {
       this.billpincode = billpincode;
   }

   public String getBillstate() {
       return this.billstate;
   }

   public void setBillstate(String billstate) {
       this.billstate = billstate;
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

   public String getCustomerid() {
       return this.customerid;
   }

   public void setCustomerid(String customerid) {
       this.customerid = customerid;
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

   public String getOrderrefno() {
       return this.orderrefno;
   }

   public void setOrderrefno(String orderrefno) {
       this.orderrefno = orderrefno;
   }

   public String getSellercode() {
       return this.sellercode;
   }

   public void setSellercode(String sellercode) {
       this.sellercode = sellercode;
   }
   
   public String getOrderid() {
		return orderid;
	}

	public void setOrderid(String orderid) {
		this.orderid = orderid;
	}

	public Date getSubmissiondatetime() {
       return this.submissiondatetime;
   }

   public void setSubmissiondatetime(Date submissiondatetime) {
       this.submissiondatetime = submissiondatetime;
   }
   
   public BigDecimal getShippingLon() {
		return shippingLon;
	}

	public void setShippingLon(BigDecimal shippingLon) {
		this.shippingLon = shippingLon;
	}

   public Ismsmt getIsmsmt() {
       return this.ismsmt;
   }

   public void setIsmsmt(Ismsmt ismsmt) {
       this.ismsmt = ismsmt;
   }

   public Ismsmd getIsmsmd() {
       return this.ismsmd;
   }

   public void setIsmsmd(Ismsmd ismsmd) {
       this.ismsmd = ismsmd;
   }

   public OctSlr getOctSlr() {
       return this.octSlr;
   }

   public void setOctSlr(OctSlr octSlr) {
       this.octSlr = octSlr;
   }

   public Set<Ismotl> getIsmotls() {
       return this.ismotls;
   }

   public void setIsmotls(Set<Ismotl> ismotls) {
       this.ismotls = ismotls;
   }

   public Set<Ismpst> getIsmpsts() {
       return this.ismpsts;
   }

   public void setIsmpsts(Set<Ismpst> ismpsts) {
       this.ismpsts = ismpsts;
   }

   public String toString() {
       return new ToStringBuilder(this)
           .append("potrfnum", getPotrfnum())
           .toString();
   }

	public OctParam getOrdertype() {
		return ordertype;
	}

	public void setOrdertype(OctParam ordertype) {
		this.ordertype = ordertype;
	}

	public String getOriginalorderrefno() {
		return originalorderrefno;
	}

	public void setOriginalorderrefno(String originalorderrefno) {
		this.originalorderrefno = originalorderrefno;
	}

	public String getStatecode() {
		return statecode;
	}

	public void setStatecode(String statecode) {
		this.statecode = statecode;
	}

	public String getCountrycode() {
		return countrycode;
	}

	public void setCountrycode(String countrycode) {
		this.countrycode = countrycode;
	}

	public String getSecurityCode1() {
		return securityCode1;
	}

	public void setSecurityCode1(String securityCode1) {
		this.securityCode1 = securityCode1;
	}

	public String getSecurityCode2() {
		return securityCode2;
	}

	public void setSecurityCode2(String securityCode2) {
		this.securityCode2 = securityCode2;
	}

	public String getCollectionExpiryDate() {
		return collectionExpiryDate;
	}

	public void setCollectionExpiryDate(String collectionExpiryDate) {
		this.collectionExpiryDate = collectionExpiryDate;
	}

	public Long getCollectionExpiryCounter() {
		return collectionExpiryCounter;
	}

	public void setCollectionExpiryCounter(Long collectionExpiryCounter) {
		this.collectionExpiryCounter = collectionExpiryCounter;
	}

	public String getCheckBogoOrder() {
		return checkBogoOrder;
	}

	public void setCheckBogoOrder(String checkBogoOrder) {
		this.checkBogoOrder = checkBogoOrder;
	}
	public String getIsSend() {
		return isSend;
	}

	public void setIsSend(String isSend) {
		this.isSend = isSend;
	}

	/**
	 * @return the isDone
	 */
	public String getIsDone() {
		return isDone;
	}

	/**
	 * @param isDone the isDone to set
	 */
	public void setIsDone(String isDone) {
		this.isDone = isDone;
	}

	public Date getSpCreateDate() {
		return spCreateDate;
	}

	public void setSpCreateDate(Date spCreateDate) {
		this.spCreateDate = spCreateDate;
	}
	public String getIsBundlingAvailable() {
		return isBundlingAvailable;
	}

	public void setIsBundlingAvailable(String isBundlingAvailable) {
		this.isBundlingAvailable = isBundlingAvailable;
	}

	public String getOriginalOrderId() {
		return originalOrderId;
	}

	public void setOriginalOrderId(String originalOrderId) {
		this.originalOrderId = originalOrderId;
	}
	public BigDecimal getShippingLat() {
		return shippingLat;
	}

	public void setShippingLat(BigDecimal shippingLat) {
		this.shippingLat = shippingLat;
	}
	
	
}
