package com.sellerportal.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.lang.builder.ToStringBuilder;
import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "ISMPST")
public class Ismpst implements Serializable {
	
	
	 @Id
	    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ISMPST_PSTRFNUM_SEQ")
	    @SequenceGenerator(name = "ISMPST_PSTRFNUM_SEQ", sequenceName = "ISMPST_PSTRFNUM_SEQ", allocationSize = 1)
	    @Column(name = "PSTRFNUM")
	    private Long pstrfnum;

	    @Column(name = "APPORTIONEDCODPRICE", length = 10)
	    private BigDecimal apportionedcodprice;

	    @Column(name = "APPORTIONEDPRICE", length = 10)
	    private BigDecimal apportionedprice;

	    @Column(name = "CREATEDATE")
	    private Date createdate;

	    @Column(name = "CREATEDBY", length = 10)
	    private Long createdby;

	    @Column(name = "DELETED", length = 1)
	    private String deleted;

	    @Column(name = "RETURNLOGISTICPROVIDERNAME", length = 100)
	    private String returnlogisticprovidername;

	    @Column(name = "P1LOGISTICNAME", length = 100)
	    private String p1logisticname;

	    @Column(name = "P2LOGISTICNAME", length = 100)
	    private String p2logisticname;

	    @Column(name = "ISAGIFT", length = 1)
	    private String isagift;

	    @Column(name = "ISFRAGILE", length = 1)
	    private String isFragile;

	    @Column(name = "ISAFREEBIE", length = 1)
	    private String isafreebie;

	    @Column(name = "ISPRECIOUS", length = 1)
	    private String isPrecious;

	    @Column(name = "ISCOD", length = 1)
	    private String iscod;

	    @Column(name = "MODIDATE")
	    private Date modidate;

	    @Column(name = "MODIFIEDBY", length = 10)
	    private Long modifiedby;

	    @Column(name = "P1LOGISTICSID", length = 40)
	    private String p1logisticsid;

	    @Column(name = "QCREASONCODE", length = 10)
	    private String qcreasoncode;

	    @Column(name = "RETURNLOGISTICID", length = 20)
	    private String returnlogisticid;

	    @Column(name = "statecode", length = 5)
	    private String statecode;

	    @Column(name = "countrycode", length = 5)
	    private String countrycode;

	    @Column(name = "P1SLAVEID", length = 28)
	    private String p1slaveid;

	    @Column(name = "P2LOGISTICSID", length = 20)
	    private String p2logisticsid;

	    @Column(name = "P2SLAVEID", length = 28)
	    private String p2slaveid;

	    @Column(name = "PARENTTRANSACTIONID", length = 30)
	    private String parenttransactionid;

	    @Column(name = "MRP", length = 10)
	    private BigDecimal mrp;

	    @Column(name = "TOTALAMMOUNT", length = 10)
	    private BigDecimal totalammount;
	    
	    @ManyToOne
	    @JoinColumn(name = "PICKID")
	    private OctPick octpick;

	    @Column(name = "PRICE", length = 10)
	    private BigDecimal price;

	    @Column(name = "PSTQTY", length = 10)
	    private Integer pstqty;

	    @Column(name = "PSTPICKQTY", length = 10)
	    private Long pstpickqty;

	    @Column(name = "SELLERCODE", length = 20)
	    private String sellercode;

	    @Column(name = "SHIPADDRESS1", length = 300)
	    private String shipaddress1;

	    @Column(name = "SHIPADDRESS2", length = 300)
	    private String shipaddress2;

	    @Column(name = "SHIPADDRESS3", length = 300)
	    private String shipaddress3;

	    @Column(name = "SHIPCITYORDISTRICT", length = 40)
	    private String shipcityordistrict;

	    @Column(name = "SHIPCOUNTRY", length = 40)
	    private String shipcountry;

	    @Column(name = "SHIPEMAILID", length = 240)
	    private String shipemailid;

	    @Column(name = "SHIPFIRSTNAME", length = 40)
	    private String shipfirstname;

	    @Column(name = "SHIPLASTNAME", length = 300)
	    private String shiplastname;

	    @Column(name = "SHIPMIDDLENAME", length = 300)
	    private String shipmiddlename;

	    @Column(name = "SHIPPHONENO", length = 40)
	    private String shipphoneno;

	    @Column(name = "SHIPPINCODE", length = 25)
	    private String shippincode;

	    @Column(name = "SHIPPINGCHARGE", length = 10)
	    private BigDecimal shippingcharge;

	    @Column(name = "SHIPSTATE", length = 40)
	    private String shipstate;

	    @Column(name = "TRANSACTIONID", length = 30)
	    private String transactionid;

	    @Column(name = "TRANSPORTMODE", length = 10)
	    private String transportmode;

	    @Column(name = "USSID", length = 68)
	    private String ussid;
	    
	    @Column(name = "PSTSKUNO", length = 60)
	    private String pstskuno;

	    @Column(name = "PSTCOLOUR", length = 100)
	    private String pstcolour;

	    @Column(name = "PSTORDERSTATUSTIMESTAMP", length = 40)
	    private String pstorderstatustimestamp;

	    @Column(name = "PSTSIZE", length = 80)
	    private String pstsize;

	    @Column(name = "PSTSTYLENO", length = 20)
	    private String pststyleno;

	    @Column(name = "PSTPRODUCTNAME", length = 300)
	    private String pstproductname;

	    @Column(name = "PSTSRNO", length = 20)
	    private String pstsrno;

	    @Column(name = "PSTIMEI1", length = 100)
	    private String pstimei1;

	    @Column(name = "PSTIMEI2", length = 100)
	    private String pstimei2;

	    @Column(name = "DELIVERYDATE", length = 20)
	    private String deliverydate;

	    @Column(name = "REFUNDEDBY", length = 45)
	    private String refundedBy;

	    @Column(name = "REFUNDEDAMT", length = 45)
	    private String refundedAmt;

	    @Column(name = "REFUNDEDTYPE", length = 45)
	    private String refundType;

	    @Column(name = "REFUNDEDBANKTRXSTATUS", length = 45)
	    private String refundedBankTrxStatus;

	    @Column(name = "REFUNDTRIGGERDATE", length = 45)
	    private String refundTriggeredDate;

	    @Column(name = "REFUNDEDBANKTRXID", length = 45)
	    private String refundedBankTrxID;

	    @Column(name = "TAXTYPE", length = 10)
	    private String taxtype;

	    @Column(name = "CALTAXVALUE", length = 10)
	    private BigDecimal caltaxvalue;

	    @Column(name = "TAXVALUE", length = 10)
	    private BigDecimal taxvalue;

	    @Column(name = "PICKERPERSONNAME", length = 40)
	    private String pickerPersonName;

	    @Column(name = "SHIPLANDMARK", length = 30)
	    private String shipLandmark;

	    @Column(name = "ALTERNATECONTACTNAME", length = 30)
	    private String alternatecontactname;

	    @Column(name = "ALTERNATEPHONENO", length = 40)
	    private String alternatephoneno;

	    @Column(name = "PICKERPERSONPHONE", length = 40)
	    private String pickerPersonPhone;

	    @Column(name = "SUBORDERTYPE", length = 55)
	    private String subordertype;

	    @Column(name = "CISTATUS", length = 10)
	    private String ciStatus;

	    @Column(name = "ISSSHIPACK", length = 1)
	    private String isSShipAck;

	    @Column(name = "PICKERPERSONEMAIL", length = 240)
	    private String pickerPersonEmail;

	    @Column(name = "CUSTOMERCONFDELDATE", length = 20)
	    private String customerConfDelDate;

	    @Column(name = "CUSTOMERRECEIVED", length = 24)
	    private String customerReceived;

	    @Column(name = "COLLECTFROMDATE", length = 11)
	    private String collectFromDate;

	    @Column(name = "COLLECTTODATE", length = 11)
	    private String collectToDate;

	    @Column(name = "RSSSHIPINGCHARGE", length = 5)
	    private BigDecimal rssshipingcharge;

	    @Column(name = "PRODUCTNOOFEXPDAYS", length = 24)
	    private Long productNoOfExpDays;

	    @Column(name = "ISRETURNTOSTOREELIGIBLE", length = 1)
	    private String isReturnToStoreEligible;

	    @Column(name = "PICKUPDATE", length = 12)
	    private String PickupDate;

	    @Column(name = "TIMESLOTFROM", length = 12)
	    private String TimeSlotFrom;

	    @Column(name = "TIMESLOTTO", length = 12)
	    private String TimeSlotTo;

	    @Column(name = "RETURNSLAVEID", length = 128)
	    private String returnSlaveId;

	    @Column(name = "ISEDTOHD", length = 1)
	    private String isEDtoHD;

	    @Column(name = "ISSTORECREDIT", length = 1)
	    private String isStoreCredit;

	    @Column(name = "RETURNINVOICESLAVEID", length = 128)
	    private String returnInvoiceSlaveId;

	    @Column(name = "SCHEDULEDDELIVERYCHARGE", length = 24)
	    private BigDecimal scheduledDeliveryCharge;

	    @Column(name = "ISQCFAILED", length = 1)
	    private String isQcFailed;

	    @Column(name = "PSTIMEI3", length = 100)
	    private String pstimei3;

	    @Column(name = "PSTIMEI4", length = 100)
	    private String pstimei4;

	    @Column(name = "L1CATEGORY", length = 20)
	    private String l1catecory;

	    @Column(name = "L1CATCODE", length = 20)
	    private String l1catCode;

	    @Column(name = "L4CATCODE", length = 20)
	    private String l4catCode;

	    @Column(name = "PROCESSED_FROM", length = 30)
	    private String processedFrom;

	    @Column(name = "PACKLIMITAMT", length = 10)
	    private BigDecimal packLimitAmt;

	    @Column(name = "ISSENDTOUNICOM", length = 1)
	    private String isSendToUnicom;

	    @Column(name = "PSTGSTSTATECODE", length = 50)
	    private String pstGstStateCode;

	    @Column(name = "PSTHSNCODE", length = 50)
	    private String pstHSNCode;

	    @Column(name = "PSTGSTCREDITNOTE", length = 50)
	    private String pstGSTCreditNote;

	    @Column(name = "TAXTYPE2", length = 10)
	    private String taxtype2;

	    @Column(name = "CALCTAXVALUE2", length = 10)
	    private BigDecimal calctaxvalue2;

	    @Column(name = "TAXVALUE2", length = 10)
	    private BigDecimal taxvalue2;

	    @Column(name = "PSTGSTCREDITNOTECOUNT", length = 10)
	    private Integer pstGstCreditNoteCount;

	    @Column(name = "PSTISEXEMPTED", length = 1)
	    private String pstIsExempted;

	    @Column(name = "TAXABLEAMT", length = 10)
	    private BigDecimal taxableAmt;

	    @Column(name = "PRODUCTCREATEDATE", length = 11)
	    private Date productcreatedate;

	    @Column(name = "JW_ISPRICEBREAKUPONINVOICE", length = 1)
	    private String isPriceBreakUpOnInvoice;

	    @Column(name = "JW_METALNAME", length = 256)
	    private String metalName;

	    @Column(name = "JW_METALRATE", length = 22)
	    private BigDecimal metalRate;

	    @Column(name = "JW_METALVALUE", length = 22)
	    private BigDecimal metalValue;

	    @Column(name = "JW_PURITY", length = 256)
	    private String purity;

	    @Column(name = "JW_SOLITAIREVALUE", length = 22)
	    private BigDecimal solitaireValue;

	    @Column(name = "JW_DIAMONDVALUE", length = 22)
	    private BigDecimal diamondValue;

	    @Column(name = "JW_STOREVALUE", length = 22)
	    private BigDecimal storeValue;

	    @Column(name = "JW_MAKINGCHARGES", length = 22)
	    private BigDecimal makingCharges;

	    @Column(name = "JW_WASTAGECHARGES", length = 22)
	    private BigDecimal wastageCharges;

	    @Column(name = "JW_SOLITAIRERATE", length = 22)
	    private BigDecimal solitaireRate;

	    @Column(name = "JW_BRANDNAME", length = 130)
	    private String brandName;

	    @Column(name = "SHIPGSTNUMBER", length = 35)
	    private String shipGSTNumber;

	    @Column(name = "SHIPCOMPANYNAME", length = 130)
	    private String shipCompanyName;

	    @Column(name = "JW_ISREVERSESEALNOAVAILABE", length = 1)
	    private String isReverseSealNoAvailable;

	    @Column(name = "JW_CATGROSSMETALWT", length = 30)
	    private String catGrossMetalWt;

	    @Column(name = "JW_CATMETALWT", length = 30)
	    private String catMetalWt;

	    @Column(name = "JW_CATCOINBARWT", length = 30)
	    private String catCoinBarWt;

	    @Column(name = "JW_CATSOLITAIREWT", length = 30)
	    private String catSolitaireWt;

	    @Column(name = "JW_CATTOTALWT", length = 30)
	    private String catTotalWt;
	    @Column(name = "JW_CATWT1", length = 30)
	    private String catWt1;

	    @Column(name = "JW_CATWT2", length = 30)
	    private String catWt2;

	    @Column(name = "JW_CATWT3", length = 30)
	    private String catWt3;

	    @Column(name = "JW_CATWT4", length = 30)
	    private String catWt4;

	    @Column(name = "JW_CATWT5", length = 30)
	    private String catWt5;

	    @Column(name = "JW_CATWT6", length = 30)
	    private String catWt6;

	    @Column(name = "JW_CATWT7", length = 30)
	    private String catWt7;

	    @Column(name = "PANCARDVerificationReq", length = 1)
	    private String PANCARDVerificationReq;

	    @Column(name = "pstpancardpath", length = 1)
	    private String pstpancardpath;

	    @Column(name = "REJECTFORCEFITSLAVE", length = 25)
	    private String rejectForcefitSlave;

	    @Column(name = "L2CATCODE", length = 20)
	    private String l2catCode;

	    @Column(name = "L2CATEGORY", length = 30)
	    private String l2category;

	    @Column(name = "DISCREETCONTAINS", length = 30)
	    private String discreetContains;

	    @Column(name = "ERQCREFNUM", length = 30)
	    private String erqcrefNum;

	    @Column(name = "ERQCAPRREFNUM", length = 30)
	    private String erqcAprrefNum;

	    @Column(name = "ISERELIGIBLE", length = 1)
	    private String iserEligible;

	    @Column(name = "ERCOMPENSATIONRATE", length = 10)
	    private BigDecimal erCompensationrate;

	    @Column(name = "ERCOMMISSIONVALUE", length = 10)
	    private BigDecimal erCommissionvalue;

	    @Column(name = "SUGGCOMPPERCENT", length = 10)
	    private BigDecimal suggcomppercent;

	    @Column(name = "SUGGCOMPVALUE", length = 10)
	    private BigDecimal suggcompvalue;

	    @Column(name = "ACTUALCOMPPERCENT", length = 10)
	    private BigDecimal actualcomppercent;

	    @Column(name = "ACTUALCOMPVALUE", length = 10)
	    private BigDecimal actualcompvalue;

	    @Column(name = "L3CATCODE", length = 20)
	    private String l3catCode;

	    @Column(name = "L3CATEGORY", length = 30)
	    private String l3category;

	    @Column(name = "SELLERDISCOUNT", length = 10)
	    private BigDecimal sellerDiscount;

	    @Column(name = "TATADISCOUNT", length = 10)
	    private BigDecimal tataDiscount;

	    @Column(name = "ISERQCAPPROVED", length = 1)
	    private String iserqcapproved;

	    @Column(name = "ISERQCREJECT", length = 1)
	    private String iserqcreject;

	    @Column(name = "DISPUTECOMMENT", length = 200)
	    private String disputecomment;

	    @Column(name = "ISERPICKUP", length = 1)
	    private String iserpickup;

	    @Column(name = "ISERDELIVER", length = 1)
	    private String iserdeliver;

	    @Column(name = "ISERLIT", length = 1)
	    private String iserlit;

	    @Column(name = "ISERQCPASS", length = 1)
	    private String iserqcpass;

	    @Column(name = "ISERQCFAIL", length = 1)
	    private String iserqcfail;

	    @Column(name = "ISRETUIRTO", length = 1)
	    private String isretuirto;

	    @Column(name = "ISLUXURYTXN", length = 1)
	    private String isLuxuryTxn;

	    @Column(name = "ISSELLERSEND", length = 1)
	    private String isSellerSend;

	    @Column(name = "ISINVAVAILSUCC", length = 1)
	    private String isInvAvailSucc;
	    @Column(name = "PBIIDENTITYCODES", length = 120)
	    private String pbiIdentityCodes;

	    @Column(name = "ISPLASTICBAN", length = 1)
	    private String isPlasticBan;

	    @Column(name = "JIOREFUNDDATE", length = 50)
	    private String jioRefundDate;

	    @Column(name = "REJECTFORCEFITLPCODE", length = 40)
	    private String rejectForcefitLpCode;

	    @Column(name = "BRANDCODE", length = 20)
	    private String brandCode;

	    @Column(name = "FICOINVOICEREMARK", length = 300)
	    private String ficoInvoiceRemark;

	    @Column(name = "FICONORSTATUS", length = 20)
	    private String ficoNORStatus;

	    @Column(name = "FICORRFSTATUS", length = 20)
	    private String ficoRRFStatus;

	    @Column(name = "JIOPOSSTATUS", length = 500)
	    private String jioPosStatus;

	    @Column(name = "JIOPOSREMARK", length = 500)
	    private String jioPosRemark;

	    @Column(name = "ELECQCSTATUS", length = 500)
	    private String elecQCStatus;

	    @Column(name = "ELECQCDATE", length = 6)
	    private Date elecQCDate;

	    @Column(name = "ELECQCREASON", length = 500)
	    private String elecQCReason;

	    @Column(name = "SPCREATEDATE", length = 11)
	    private Date spCreateDate;

	    @Column(name = "RETURNDELIVEREDDATE", length = 11)
	    private Date returnDeliveredDate;

	    @Column(name = "ISERXDISPUTE", length = 1)
	    private String isErXDispute;

	    @Column(name = "ISAUTOQCPASS", length = 1)
	    private String isAutoQcPass;

	    @Column(name = "CIRRTODATE", length = 11)
	    private Date cirRtoDate;

	    @Column(name = "RETURNPICKUPDATE", length = 11)
	    private Date returnPickUpDate;

	    @Column(name = "CLAIMREGDATE", length = 11)
	    private Date claimRegDate;

	    @Column(name = "ERDISPUTETYPE", length = 45)
	    private String erDisputeType;

	    @Column(name = "CESSRATE", length = 10)
	    private BigDecimal cessrate;

	    @Column(name = "CESSVALUE", length = 10)
	    private BigDecimal cessvalue;

	    @Column(name = "SCHECKSIZE", length = 45)
	    private String sCheckSize;

	    @Column(name = "SCHECKCOLOR", length = 150)
	    private String sCheckColor;

	    @Column(name = "SCHECKBRAND", length = 125)
	    private String sCheckBrand;

	    @Column(name = "SCHECKSKUCODE", length = 60)
	    private String sCheckSkuCode;

	    @Column(name = "SCHECKSERIALNUMBER", length = 100)
	    private String sCheckSerialNumber;

	    @Column(name = "SCHECKREVERSESEALCODE", length = 100)
	    private String sCheckReverseSealCode;

	    @Column(name = "SCHECKIMEINUMBER", length = 100)
	    private String sCheckImeiNumber;

	    @Column(name = "SCHECKWRONGPRODUCTCODE", length = 64)
	    private String sCheckWrongProductCode;

	    @Column(name = "SCHECKWRONGPRODUCTDESC", length = 2147483647)
	    private String sCheckWrongProductDesc;

	    @Column(name = "SCHECKISPACKAGINGMANDATORY", length = 1)
	    private String sCheckIsPackagingMandatory;

	    @Column(name = "SCHECKISCHECKDAMAGE", length = 1)
	    private String sCheckIsCheckDamage;

	    @Column(name = "SCHECKISCHECKUSAGE", length = 1)
	    private String sCheckIsCheckUsage;

	    @Column(name = "SCHECKISCHECKACCESSORIES", length = 1)
	    private String sCheckIsCheckAccessories;
	    @Column(name = "SCHECKISIMAGE", length = 1)
	    private String sCheckIsImage;

	    @Column(name = "RETURNREASON", length = 500)
	    private String returnReason;

	    @Column(name = "RETURNSUBREASON", length = 500)
	    private String returnSubReason;

	    @Column(name = "ISREVELIGIBLE", length = 1)
	    private String isRevEligible;

	    @Column(name = "ISMEDIATION", length = 1)
	    private String isMediation;

	    @Column(name = "REFUNDREPLACETYPE", length = 120)
	    private String refundReplaceType;

	    @Column(name = "ISCLIQCASHREFUNDED", length = 1)
	    private String iscliqcashRefunded;

	    @Column(name = "RETURNCNCLRSNCODE", length = 300)
	    private String returnCnclRsnCode;

	    @Column(name = "ADDRESSCATEGORY", length = 20)
	    private String addrCat;

	    @Column(name = "HOTCDATE", length = 11)
	    private Date hotcDate;

	    @Column(name = "FWDORDERDELIVERDATE", length = 11)
	    private Date fwdorderdeliverdate;

	    @Column(name = "ISCNCTOHD", length = 1)
	    private String isCNCtoHD;

	    @Column(name = "ISSDDTOHD", length = 1)
	    private String isSDDtoHD;

	    @Column(name = "ESTIMATEDDELIVERYDATE", length = 20)
	    private String estimatedDeliveryDate;

	    @Column(name = "PREDICTIONPICKCONFIRMED", length = 11)
	    private Date predictionPickConfirmed;

	    @Column(name = "PREDICTIONHOTC", length = 11)
	    private Date predictionHOTC;

	    @Column(name = "PREDICTIONINSCAN", length = 11)
	    private Date predictionInscan;

	    @Column(name = "PREDICTIONEDD", length = 11)
	    private Date predictionEDD;

	    @Column(name = "ISHDTOHD", length = 1)
	    private String isHDtoHD;

	    @Column(name = "PSTZONETYPE", length = 1)
	    private Integer zoneType;

	    @Column(name = "INSCANDATE", length = 11)
	    private Date inScanDate;

	    @Column(name = "AUTOACTIVATEFLAG", length = 5)
	    private String autoActivateFlag;

	    @Column(name = "BUNDEDWITH", length = 25)
	    private String bundedWith;

	    @Column(name = "ISHAZMAT", length = 1)
	    private String isHazmat;

	    @Column(name = "ISCOLDSTORAGE", length = 1)
	    private String isColdStorage;

	    @Column(name = "BBEXTERNALORDERID", length = 40)
	    private String bbExternalOrderId;

	    @Column(name = "ISHANDREPLACEMENT", length = 10)
	    private String isHandReplacement;

	    @Column(name = "STOREFRONT", length = 100)
	    private String storeFront;

	    @Column(name = "RETURNREASONCODE", length = 200)
	    private String returnReasonCode;

	    @Column(name = "RETURNSUBREASONCODE", length = 200)
	    private String returnSubReasonCode;
	    @Column(name = "ISMAXDISCOUNTPERCARDFLAG", length = 1)
	    private String isMaxDiscountPerCardFlag;

	    @Column(name = "MAXDISCOUNTPERCARDAMT", length = 10)
	    private BigDecimal maxDiscountPerCardAmt;

	    @Column(name = "PRODUCTLOTID", length = 40)
	    private String productLotId;

	    @Column(name = "PRODUCTEXPIRYDATE")
	    private Date productExpiryDate;

	    @Column(name = "RESTOCKINGFEE", length = 10)
	    private BigDecimal restockingFee;

	    @ManyToOne
	    @JoinColumn(name = "PSTREJECTRESON")
	    private OctParam pstrejectreason;

	    @ManyToOne
	    @JoinColumn(name = "PSTSMTRFNUM")
	    private Ismsmt ismsmt;

	    @ManyToOne
	    @JoinColumn(name = "PSTSLVRFNUM")
	    private OctSlv octSlv;

	    @ManyToOne
	    @JoinColumn(name = "PSTSHIPRFNUM")
	    private OctShipment shipment;

	    @ManyToOne
	    @JoinColumn(name = "PSTREVERSESHIPRFNUM")
	    private OctShipment reverseshipment;

	    @OneToMany(mappedBy = "ismpst")
	    @Transient
	    private Set<OctDisputeTicket> octDisputeTicket;

	    @OneToMany(mappedBy = "ismpst")
	    @Transient
	    private Set<OctTicket> octTicket;

	    @ManyToOne
	    @JoinColumn(name = "PSTPOTRFNUM")
	    private Ismpot ismpot;

	    @ManyToOne
	    @JoinColumn(name = "PACKID")
	    private OctPack octpack;

	    @ManyToOne
	    @JoinColumn(name = "DELIVERYMODE")
	    private OctParam deliverymode;

	    @ManyToOne
	    @JoinColumn(name = "FULFILLMENTTYPE")
	    private OctParam fulfillmenttype;

	    @ManyToOne
	    @JoinColumn(name = "CHANNEL")
	    private OctParam channel;
	    @ManyToOne
	    @JoinColumn(name = "ADDRESSTYPE")
	    private OctParam addresstype;

	    @ManyToOne
	    @JoinColumn(name = "RETURNFULFILLMENTTYPE")
	    private OctParam returnfulfillmenttype;

	    @ManyToOne
	    @JoinColumn(name = "PSTFEEDERSLVRFNUM")
	    private OctSlv octSlvFeeder;

	    @ManyToOne
	    @JoinColumn(name = "pstpancardstatus")
	    private OctParam pstpancardstatus;

	    @ManyToOne
	    @JoinColumn(name = "REVREFUNDTYPE")
	    private OctParam revRefundType;

	    @ManyToOne
	    @JoinColumn(name = "OCTDELVCHALLAN")
	    private OctDelChallan delvChallan;
	    
	    @OneToMany(mappedBy = "ismpst")
	    @Transient
	    private Set<Ismstl> ismstls;
	    
	    @Column(name = "ORIGINALTRANSACTIONID", length = 30)
	    private String originaltransactionid;
	    
	    @Column(name = "APPORTIONEDSHIPPINGCHARGE", precision = 10, scale = 2)
	    private BigDecimal apportionedshippingcharge;
	    
	    @Column(name = "GIFTMESSAGE", length = 300)
	    private String giftmessage;
	    
	    @Column(name = "PRODUCTIMAGEURL", length = 300)
	    private String productimageurl;
	    
	    @Column(name = "GIFTPRICE", precision = 10, scale = 2)
	    private BigDecimal giftprice;
	    
	    @Column(name = "DISCOUNT", precision = 10, scale = 2)
	    private BigDecimal discount;
	    
	    @Column(name = "NETAMOUNT", precision = 10, scale = 2)
	    private BigDecimal netamount;
	    
	    @Column(name = "ISINVOICESENT", length = 1)
	    private String isinvoicesent;
	    
	    @Column(name = "ISREVINVOICESENT", length = 1)
	    private String isrevinvoicesent;
	    
	    @Column(name = "ISSALESORDERSTATUSSENT", length = 1)
	    private String issalesorderstatussent;
	    
	    @Column(name = "INSCAN", length = 1)
	    private String inScan;

	    @Column(name = "ISEARLYREFUND", length = 1)
	    private String isEarlyRefund;
	    
	    @Column(name = "ISIMEIREQ", length = 1)
	    private String isimeireq;

	    @Column(name = "L4CATEGEGORY", length = 20)
	    private String l4category;

	    @Column(name = "SELLERACCEPTTAT", length = 10)
	    private String selleraccepttat;

	    @Column(name = "ISCIRDELIVERED", length = 1)
	    private String isCIRDelivered;

	    @Column(name = "QCFAILCOMMENT", length = 300)
	    private String qcfailcomment;

	    @Column(name = "RETPICKFIRSTNAME", length = 20)
	    private String retPickFirstName;

	    @Column(name = "RETPICKLASTNAME", length = 20)
	    private String retPickLastName;

	    @Column(name = "RETPICKPHONENO", length = 40)
	    private String retPickPhoneNo;

	    @Column(name = "RETPICKADDRESS1", length = 300)
	    private String retPickAddress1;

	    @Column(name = "RETPICKADDRESS2", length = 300)
	    private String retPickAddress2;

	    @Column(name = "RETPICKADDRESS3", length = 300)
	    private String retPickAddress3;

	    @Column(name = "RETPICKLANDMARK", length = 30)
	    private String retPickLandmark;

	    @Column(name = "RETPICKCOUNTRY", length = 40)
	    private String retPickCountry;

	    @Column(name = "RETPICKSTATE", length = 40)
	    private String retPickState;

	    @Column(name = "RETPICKCITY", length = 40)
	    private String retPickCity;

	    @Column(name = "RETPICKPINCODE", length = 25)
	    private String retPickPinCode;

	    @Column(name = "RETPICKALTERNATECONTNAME", length = 40)
	    private String retPickAlternateContName;

	    @Column(name = "RETPICKALTERNATECONTPHONENO", length = 40)
	    private String retPickAlternateContPhoneNo;

	    @Column(name = "ISCNCPARENTDELIVERD", length = 1)
	    private String iscncparentdeliverd;
	    
	    @Column(name = "INLINESTATUSFORINBOUND", length = 20)
	    private String inlineStatusForInbound;

	    @Column(name = "ACKDATE")
	    private Date ackdate;

	    @Column(name = "FWDDELVDATE")
	    private Date fwedeliverydate;
	    
	    @Column(name = "SELLERORDERSENDSTATUS", length = 1)
	    private String sellerordersendstatus;
	    
	public String getRejectForcefitSlave() {
		return rejectForcefitSlave;
	}

	public void setRejectForcefitSlave(String rejectForcefitSlave) {
		this.rejectForcefitSlave = rejectForcefitSlave;
	}

	
	
	
	public String getReturnSubReasonCode() {
		return returnSubReasonCode;
	}

	public void setReturnSubReasonCode(String returnSubReasonCode) {
		this.returnSubReasonCode = returnSubReasonCode;
	}

	public String getReturnReasonCode() {
		return returnReasonCode;
	}

	public void setReturnReasonCode(String returnReasonCode) {
		this.returnReasonCode = returnReasonCode;
	}

	public String getIsInvAvailSucc() {
		return isInvAvailSucc;
	}

	public void setIsInvAvailSucc(String isInvAvailSucc) {
		this.isInvAvailSucc = isInvAvailSucc;
	}

	
	/** full constructor 
	 * @param octpack 
	 * @param octTicket 
	 * @param isafreebie 
	 * @param apportionedshippingcharge 
	 * @param originaltransactionid 
	 * @param giftmessage 
	 * @param giftprice 
	 * @param returnlogisticid 
	 * @param discount 
	 * @param netamount 
	 * @param isinvoicesent 
	 * @param addresstype 
	 * @param channel 
	 * @param selleraccepttat */
	public Ismpst(Long pstrfnum,OctPick octpick, BigDecimal apportionedcodprice, BigDecimal apportionedprice,Date createdate, Long createdby, String deleted,String returnlogisticprovidername, OctParam deliverymode, OctParam fulfillmenttype, String isagift, String iscod, Date modidate, Long modifiedby, String p1logisticsid,String qcreasoncode, String p1slaveid, String p2logisticsid, String p2slaveid, String parenttransactionid,BigDecimal price, Integer pstqty, String sellercode, String shipaddress1, String shipaddress2, String shipaddress3, String shipcityordistrict, String shipcountry, String shipemailid, String shipfirstname, String shiplastname,  String shipmiddlename, String shipphoneno,Long pstpickqty, String shippincode, BigDecimal shippingcharge, String shipstate, String transactionid, String transportmode, String ussid,String pstskuno,String pstcolour,String pstsize,String pststyleno,String pstproductname,String pstsrno,String pstimei1,String pstimei2,String pstorderstatustimestamp, com.sellerportal.model.Ismsmt ismsmt,  com.sellerportal.model.OctSlv octSlv,  com.sellerportal.model.Ismpot ismpot, com.sellerportal.model.OctShipment shipment, Set<Ismstl> ismstls, OctPack octpack, Set<OctTicket> octTicket, String isafreebie,String psttat, BigDecimal apportionedshippingcharge, String originaltransactionid, String giftmessage, BigDecimal giftprice, String returnlogisticid, BigDecimal discount, BigDecimal netamount, String isinvoicesent, OctParam addresstype, OctParam channel, String selleraccepttat,BigDecimal mrp, BigDecimal totalammount, String issalesorderstatussent, String deliverydate, String refundedBy,String refundedAmt, String refundedBankTrxID,String refundType,String refundedBankTrxStatus,String refundTriggeredDate,String productimageurl,String taxtype,BigDecimal caltaxvalue,BigDecimal taxvalue,String isrevinvoicesent,String inScan, String isEarlyRefund, BigDecimal rssshipingcharge,String isimeireq,String l4category,String pstimei3,String pstimei4,String l1catCode,String l4catCode, String bbExternalOrderId) {
		this.pstrfnum = pstrfnum;
		this.apportionedcodprice = apportionedcodprice;
		this.apportionedprice = apportionedprice;
		this.createdate = createdate;
		this.createdby = createdby;
		this.deleted = deleted;
		this.returnlogisticprovidername = returnlogisticprovidername;
		this.deliverymode = deliverymode;
		this.fulfillmenttype = fulfillmenttype;
		this.isagift = isagift;
		this.iscod = iscod;
		this.modidate = modidate;
		this.modifiedby = modifiedby;
		this.p1logisticsid = p1logisticsid;
		this.p1slaveid = p1slaveid;
		this.p2logisticsid = p2logisticsid;
		this.p2slaveid = p2slaveid;
		this.parenttransactionid = parenttransactionid;
		this.octpick = octpick;
		this.price = price;
		this.pstqty = pstqty;
		this.sellercode = sellercode;
		this.shipaddress1 = shipaddress1;
		this.shipaddress2 = shipaddress2;
		this.shipaddress3 = shipaddress3;
		this.shipcityordistrict = shipcityordistrict;
		this.shipcountry = shipcountry;
		this.shipemailid = shipemailid;
		this.shipfirstname = shipfirstname;
		this.shiplastname = shiplastname;
		this.shipment = shipment;
		this.shipmiddlename = shipmiddlename;
		this.shipphoneno = shipphoneno;
		this.shippincode = shippincode;
		this.shippingcharge = shippingcharge;
		this.shipstate = shipstate;
		this.transactionid = transactionid;
		this.transportmode = transportmode;
		this.ussid = ussid;
		this.ismsmt = ismsmt;
		this.octSlv = octSlv;
		this.ismpot = ismpot;
		this.ismstls = ismstls;
		this.octTicket = octTicket; 
		this.pstskuno = pstskuno;
		this.pstcolour = pstcolour;
		this.pstsize = pstsize;
		this.pststyleno=pststyleno;
		this.pstpickqty=pstpickqty;
		this.pstproductname=pstproductname;
		this.pstsrno=pstsrno;
		this.pstimei1=pstimei1;
		this.pstimei2=pstimei2;
		this.octpack=octpack;
		this.pstorderstatustimestamp=pstorderstatustimestamp;
		this.isafreebie=isafreebie;
//		this.psttat = psttat; 
		this.apportionedshippingcharge=apportionedshippingcharge;
		this.originaltransactionid=originaltransactionid;
		this.giftmessage=giftmessage;
		this.giftprice=giftprice;
		this.returnlogisticid=returnlogisticid;
		this.discount=discount;
		this.netamount=netamount;
		this.isinvoicesent=isinvoicesent;
		this.addresstype=addresstype;
		this.channel=channel;
		this.mrp=mrp;
		this.totalammount=totalammount;
		this.setSelleraccepttat(selleraccepttat);
		this.issalesorderstatussent = issalesorderstatussent;
		this.deliverydate = deliverydate; 
		this.refundedBy = refundedBy;
		this.refundedAmt = refundedAmt;
		this.refundedBankTrxID= refundedBankTrxID;
		this.refundType = refundType;
		this.refundedBankTrxStatus = refundedBankTrxStatus;
		this.refundTriggeredDate = refundTriggeredDate;
		this.qcreasoncode=qcreasoncode;
		this.productimageurl=productimageurl;
		this.taxtype = taxtype;
		this.caltaxvalue=caltaxvalue;
		this.taxvalue = taxvalue;
		this.isrevinvoicesent = isrevinvoicesent;
		this.inScan  =inScan;
		this.isEarlyRefund =isEarlyRefund;
		this.rssshipingcharge = rssshipingcharge;
		this.l4category = l4category;
		this.isimeireq = isimeireq;
		this.pstimei3 = pstimei3;
		this.pstimei3 = pstimei4;
		this.l1catCode=l1catCode;
		this.l4catCode=l4catCode;
		this.bbExternalOrderId = bbExternalOrderId;
	}

	/** default constructor */
	public Ismpst() {
	}

	/** minimal constructor 
	 * @param octpack */
	public Ismpst(Long pstrfnum, BigDecimal apportionedcodprice, BigDecimal apportionedprice, Date createdate, Long createdby, OctParam deliverymode, OctParam fulfillmenttype, String isagift, String iscod, Long modifiedby, String p1logisticsid, String p1slaveid, String p2logisticsid, String p2slaveid, String parenttransactionid,OctPick octpick,BigDecimal price, Integer pstqty, String sellercode, String shipaddress1, String shipaddress2, String shipaddress3, String shipcityordistrict, String shipcountry, String shipemailid, String shipfirstname, String shiplastname, String shipmiddlename, String shipphoneno, String shippincode, BigDecimal shippingcharge, String shipstate, String transactionid, String transportmode, String ussid,  com.sellerportal.model.Ismsmt ismsmt,  com.sellerportal.model.OctSlv octSlv,  com.sellerportal.model.Ismpot ismpot, Set<Ismstl> ismstls,Set<OctTicket> octTicket, OctPack octpack, com.sellerportal.model.OctShipment shipment, com.sellerportal.model.OctShipment reverseshipment,String psttat,String deliverydate,String refundedBy,String refundedAmt, String refundedBankTrxID,String refundType,String refundedBankTrxStatus,String refundTriggeredDate,String productimageurl,String taxtype,BigDecimal caltaxvalue,BigDecimal taxvalue) {
		this.pstrfnum = pstrfnum;
		this.apportionedcodprice = apportionedcodprice;
		this.apportionedprice = apportionedprice;
		this.createdate = createdate;
		this.createdby = createdby;
		this.deliverymode = deliverymode;
		this.fulfillmenttype = fulfillmenttype;
		this.isagift = isagift;
		this.iscod = iscod;
		this.modifiedby = modifiedby;
		this.p1logisticsid = p1logisticsid;
		this.p1slaveid = p1slaveid;
		this.p2logisticsid = p2logisticsid;
		this.p2slaveid = p2slaveid;
		this.parenttransactionid = parenttransactionid;
		this.octpick =octpick;
		this.price = price;
		this.pstqty = pstqty;
		this.sellercode = sellercode;
		this.shipaddress1 = shipaddress1;
		this.shipaddress2 = shipaddress2;
		this.shipaddress3 = shipaddress3;
		this.shipcityordistrict = shipcityordistrict;
		this.shipcountry = shipcountry;
		this.shipemailid = shipemailid;
		this.shipfirstname = shipfirstname;
		this.shiplastname = shiplastname;
		this.shipment = shipment;
		this.reverseshipment = reverseshipment;
		this.shipmiddlename = shipmiddlename;
		this.shipphoneno = shipphoneno;
		this.shippincode = shippincode;
		this.shippingcharge = shippingcharge;
		this.shipstate = shipstate;
		this.transactionid = transactionid;
		this.transportmode = transportmode;
		this.ussid = ussid;
		this.ismsmt = ismsmt;
		this.octSlv = octSlv;
		this.ismpot = ismpot;
		this.ismstls = ismstls;
		this.octTicket = octTicket; 
		this.octpack=octpack;
//		this.octTicketReq=octTicketReq;
//		this.psttat = psttat;
		this.deliverydate = deliverydate;
		this.refundedBy = refundedBy;
		this.refundedAmt= refundedAmt;
		this.refundedBankTrxID = refundedBankTrxID;
		this.refundType = refundType;
		this.refundedBankTrxStatus = refundedBankTrxStatus;
		this.refundTriggeredDate = refundTriggeredDate;
		this.productimageurl = productimageurl;
		this.taxtype = taxtype;
		this.caltaxvalue=caltaxvalue;
		this.taxvalue=taxvalue;
	}


	public Long getPstrfnum() {
		return this.pstrfnum;
	}

	public void setPstrfnum(Long pstrfnum) {
		this.pstrfnum = pstrfnum;
	}

	public BigDecimal getApportionedcodprice() {
		return apportionedcodprice;
	}

	public void setApportionedcodprice(BigDecimal apportionedcodprice) {
		this.apportionedcodprice = apportionedcodprice;
	}

	public BigDecimal getApportionedprice() {
		return apportionedprice;
	}

	public void setApportionedprice(BigDecimal apportionedprice) {
		this.apportionedprice = apportionedprice;
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

	public BigDecimal getMrp() {
		return mrp;
	}
	public String getIsFragile() {
		return isFragile;
	}

	public void setIsFragile(String isFragile) {
		this.isFragile = isFragile;
	}
	public void setMrp(BigDecimal mrp) {
		this.mrp = mrp;
	}

	public BigDecimal getTotalammount() {
		return totalammount;
	}

	public void setTotalammount(BigDecimal totalammount) {
		this.totalammount = totalammount;
	}

	public String getReturnlogisticprovidername() {
		return returnlogisticprovidername;
	}

	public void setReturnlogisticprovidername(String returnlogisticprovidername) {
		this.returnlogisticprovidername = returnlogisticprovidername;
	}

	public OctParam getDeliverymode() {
		return this.deliverymode;
	}

	public void setDeliverymode(OctParam deliverymode) {
		this.deliverymode = deliverymode;
	}

	public OctParam getFulfillmenttype() {
		return this.fulfillmenttype;
	}

	public void setFulfillmenttype(OctParam fulfillmenttype) {
		this.fulfillmenttype = fulfillmenttype;
	}

	public String getIsagift() {
		return this.isagift;
	}

	public void setIsagift(String isagift) {
		this.isagift = isagift;
	}

	public String getIscod() {
		return this.iscod;
	}

	public void setIscod(String iscod) {
		this.iscod = iscod;
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

	public String getP1logisticsid() {
		return this.p1logisticsid;
	}

	public void setP1logisticsid(String p1logisticsid) {
		this.p1logisticsid = p1logisticsid;
	}

	public String getP1slaveid() {
		return this.p1slaveid;
	}

	public void setP1slaveid(String p1slaveid) {
		this.p1slaveid = p1slaveid;
	}

	public String getP2logisticsid() {
		return this.p2logisticsid;
	}

	public void setP2logisticsid(String p2logisticsid) {
		this.p2logisticsid = p2logisticsid;
	}

	public String getP2slaveid() {
		return this.p2slaveid;
	}

	public void setP2slaveid(String p2slaveid) {
		this.p2slaveid = p2slaveid;
	}

	public String getParenttransactionid() {
		return this.parenttransactionid;
	}

	public void setParenttransactionid(String parenttransactionid) {
		this.parenttransactionid = parenttransactionid;
	}

	public BigDecimal getPrice() {
		return this.price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public Integer getPstqty() {
		return this.pstqty;
	}

	public void setPstqty(Integer pstqty) {
		this.pstqty = pstqty;
	}

	public String getSellercode() {
		return this.sellercode;
	}

	public void setSellercode(String sellercode) {
		this.sellercode = sellercode;
	}

	public String getShipaddress1() {
		return this.shipaddress1;
	}

	public void setShipaddress1(String shipaddress1) {
		this.shipaddress1 = shipaddress1;
	}

	public String getShipaddress2() {
		return this.shipaddress2;
	}

	public void setShipaddress2(String shipaddress2) {
		this.shipaddress2 = shipaddress2;
	}

	public String getShipaddress3() {
		return this.shipaddress3;
	}

	public void setShipaddress3(String shipaddress3) {
		this.shipaddress3 = shipaddress3;
	}

	public String getShipcityordistrict() {
		return this.shipcityordistrict;
	}

	public void setShipcityordistrict(String shipcityordistrict) {
		this.shipcityordistrict = shipcityordistrict;
	}

	public String getShipcountry() {
		return this.shipcountry;
	}

	public void setShipcountry(String shipcountry) {
		this.shipcountry = shipcountry;
	}

	public String getShipemailid() {
		return this.shipemailid;
	}

	public void setShipemailid(String shipemailid) {
		this.shipemailid = shipemailid;
	}

	public String getShipfirstname() {
		return this.shipfirstname;
	}

	public void setShipfirstname(String shipfirstname) {
		this.shipfirstname = shipfirstname;
	}

	public String getShiplastname() {
		return this.shiplastname;
	}

	public void setShiplastname(String shiplastname) {
		this.shiplastname = shiplastname;
	}

	public String getShipmiddlename() {
		return this.shipmiddlename;
	}

	public void setShipmiddlename(String shipmiddlename) {
		this.shipmiddlename = shipmiddlename;
	}

	public String getShipphoneno() {
		return this.shipphoneno;
	}

	public void setShipphoneno(String shipphoneno) {
		this.shipphoneno = shipphoneno;
	}

	public String getShippincode() {
		return this.shippincode;
	}

	public void setShippincode(String shippincode) {
		this.shippincode = shippincode;
	}

	public String getShipstate() {
		return this.shipstate;
	}

	public void setShipstate(String shipstate) {
		this.shipstate = shipstate;
	}

	public String getTransactionid() {
		return this.transactionid;
	}

	public void setTransactionid(String transactionid) {
		this.transactionid = transactionid;
	}

	public String getTransportmode() {
		return this.transportmode;
	}

	public void setTransportmode(String transportmode) {
		this.transportmode = transportmode;
	}

	public String getUssid() {
		return this.ussid;
	}

	public void setUssid(String ussid) {
		this.ussid = ussid;
	}

	public String getPstskuno() {
		return pstskuno;
	}

	public void setPstskuno(String pstskuno) {
		this.pstskuno = pstskuno;
	}

	public String getPstcolour() {
		return pstcolour;
	}

	public void setPstcolour(String pstcolour) {
		this.pstcolour = pstcolour;
	}

	public String getPstsize() {
		return pstsize;
	}

	public void setPstsize(String pstsize) {
		this.pstsize = pstsize;
	}

	public String getPststyleno() {
		return pststyleno;
	}

	public void setPststyleno(String pststyleno) {
		this.pststyleno = pststyleno;
	}

	public  com.sellerportal.model.Ismsmt getIsmsmt() {
		return this.ismsmt;
	}

	public void setIsmsmt( com.sellerportal.model.Ismsmt ismsmt) {
		this.ismsmt = ismsmt;
	}

	public  com.sellerportal.model.OctSlv getOctSlv() {
		return this.octSlv;
	}

	public void setOctSlv( com.sellerportal.model.OctSlv octSlv) {
		this.octSlv = octSlv;
	}

	public  com.sellerportal.model.Ismpot getIsmpot() {
		return this.ismpot;
	}

	public void setIsmpot( com.sellerportal.model.Ismpot ismpot) {
		this.ismpot = ismpot;
	}

	public Set<Ismstl> getIsmstls() {
		return this.ismstls;
	}

	public void setIsmstls(Set<Ismstl> ismstls) {
		this.ismstls = ismstls;
	}

	public String toString() {
		return new ToStringBuilder(this)
				.append("pstrfnum", getPstrfnum())
				.toString();
	}

	public OctPick getOctpick() {
		return octpick;
	}

	public void setOctpick(OctPick octpick) {
		this.octpick = octpick;
	}

	public Long getPstpickqty() {
		return pstpickqty;
	}

	public void setPstpickqty(Long pstpickqty) {
		this.pstpickqty = pstpickqty;
	}

	public String getPstproductname() {
		return pstproductname;
	}

	public void setPstproductname(String pstproductname) {
		this.pstproductname = pstproductname;
	}

	public String getPstsrno() {
		return pstsrno;
	}

	public void setPstsrno(String pstsrno) {
		this.pstsrno = pstsrno;
	}

	public String getPstimei1() {
		return pstimei1;
	}

	public void setPstimei1(String pstimei1) {
		this.pstimei1 = pstimei1;
	}

	public String getPstimei2() {
		return pstimei2;
	}

	public void setPstimei2(String pstimei2) {
		this.pstimei2 = pstimei2;
	}

	public  com.sellerportal.model.OctPack getOctpack() {
		return octpack;
	}

	public void setOctpack( com.sellerportal.model.OctPack octpack) {
		this.octpack = octpack;
	}

	public String getPstorderstatustimestamp() {
		return pstorderstatustimestamp;
	}

	public void setPstorderstatustimestamp(String pstorderstatustimestamp) {
		this.pstorderstatustimestamp = pstorderstatustimestamp;
	}

	public  com.sellerportal.model.OctShipment getShipment() {
		return shipment;
	}

	public void setShipment( com.sellerportal.model.OctShipment shipment) {
		this.shipment = shipment;
	}

	public  com.sellerportal.model.OctShipment getReverseshipment() {
		return reverseshipment;
	}

	public void setReverseshipment( com.sellerportal.model.OctShipment reverseshipment) {
		this.reverseshipment = reverseshipment;
	}

	public Set<OctTicket> getOctTicket() {
		return octTicket;
	}

	public void setOctTicket(Set<OctTicket> octTicket) {
		this.octTicket = octTicket;
	}

//	public Set getOctTicketReq() {
//		return octTicketReq;
//	}
//
//	public void setOctTicketReq(Set octTicketReq) {
//		this.octTicketReq = octTicketReq;
//	}

	public String getIsafreebie() {
		return isafreebie;
	}

	public void setIsafreebie(String isafreebie) {
		this.isafreebie = isafreebie;
	}

//	public String getPsttat() {
//		return psttat;
//	}
//
//	public void setPsttat(String psttat) {
//		this.psttat = psttat;
//	}

	public BigDecimal getApportionedshippingcharge() {
		return apportionedshippingcharge;
	}

	public void setApportionedshippingcharge(BigDecimal apportionedshippingcharge) {
		this.apportionedshippingcharge = apportionedshippingcharge;
	}

	public BigDecimal getShippingcharge() {
		return shippingcharge;
	}

	public void setShippingcharge(BigDecimal shippingcharge) {
		this.shippingcharge = shippingcharge;
	}

	public String getOriginaltransactionid() {
		return originaltransactionid;
	}

	public void setOriginaltransactionid(String originaltransactionid) {
		this.originaltransactionid = originaltransactionid;
	}

	public String getGiftmessage() {
		return giftmessage;
	}

	public void setGiftmessage(String giftmessage) {
		this.giftmessage = giftmessage;
	}

	public BigDecimal getGiftprice() {
		return giftprice;
	}

	public void setGiftprice(BigDecimal giftprice) {
		this.giftprice = giftprice;
	}

	public String getReturnlogisticid() {
		return returnlogisticid;
	}

	public void setReturnlogisticid(String returnlogisticid) {
		String value = LPUtils.returnLogisticsIds.get(returnlogisticid);
		if(value != null) {
			this.returnlogisticid = value;
		}
		else {
			this.returnlogisticid = returnlogisticid;
		}
	}

	public BigDecimal getDiscount() {
		return discount;
	}

	public void setDiscount(BigDecimal discount) {
		this.discount = discount;
	}

	public BigDecimal getNetamount() {
		return netamount;
	}

	public void setNetamount(BigDecimal netamount) {
		this.netamount = netamount;
	}

	public String getIsinvoicesent() {
		return isinvoicesent;
	}

	public void setIsinvoicesent(String isinvoicesent) {
		this.isinvoicesent = isinvoicesent;
	}

	public  com.sellerportal.model.OctParam getAddresstype() {
		return addresstype;
	}

	public void setAddresstype( com.sellerportal.model.OctParam addresstype) {
		this.addresstype = addresstype;
	}

	public  com.sellerportal.model.OctParam getChannel() {
		return channel;
	}

	public void setChannel( com.sellerportal.model.OctParam channel) {
		this.channel = channel;
	}

	public String getSelleraccepttat() {
		return selleraccepttat;
	}

	public void setSelleraccepttat(String selleraccepttat) {
		this.selleraccepttat = selleraccepttat;
	}

	public String getIssalesorderstatussent() {
		return issalesorderstatussent;
	}

	public void setIssalesorderstatussent(String issalesorderstatussent) {
		this.issalesorderstatussent = issalesorderstatussent;
	}

	public String getP1logisticname() {
		return p1logisticname;
	}

	public void setP1logisticname(String p1logisticname) {
		this.p1logisticname = p1logisticname;
	}

	public String getP2logisticname() {
		return p2logisticname;
	}

	public void setP2logisticname(String p2logisticname) {
		this.p2logisticname = p2logisticname;
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

	public String getDeliverydate() {
		return deliverydate;
	}

	public void setDeliverydate(String deliverydate) {
		this.deliverydate = deliverydate;
	}

	public String getRefundedBy() {
		return refundedBy;
	}

	public String getRefundedAmt() {
		return refundedAmt;
	}

	public String getRefundedBankTrxID() {
		return refundedBankTrxID;
	}

	public String getRefundType() {
		return refundType;
	}

	public String getRefundedBankTrxStatus() {
		return refundedBankTrxStatus;
	}

	public String getRefundTriggeredDate() {
		return refundTriggeredDate;
	}

	public void setRefundedBy(String refundedBy) {
		this.refundedBy = refundedBy;
	}

	public void setRefundedAmt(String refundedAmt) {
		this.refundedAmt = refundedAmt;
	}

	public void setRefundedBankTrxID(String refundedBankTrxID) {
		this.refundedBankTrxID = refundedBankTrxID;
	}

	public void setRefundType(String refundType) {
		this.refundType = refundType;
	}

	public void setRefundedBankTrxStatus(String refundedBankTrxStatus) {
		this.refundedBankTrxStatus = refundedBankTrxStatus;
	}

	public void setRefundTriggeredDate(String refundTriggeredDate) {
		this.refundTriggeredDate = refundTriggeredDate;
	}

	public String getQcreasoncode() {
		return qcreasoncode;
	}

	public void setQcreasoncode(String qcreasoncode) {
		this.qcreasoncode = qcreasoncode;
	}

	public String getProductimageurl() {
		return productimageurl;
	}

	public void setProductimageurl(String productimageurl) {
		this.productimageurl = productimageurl;
	}

	public String getTaxtype() {
		return taxtype;
	}

	public void setTaxtype(String taxtype) {
		this.taxtype = taxtype;
	}

	public BigDecimal getCaltaxvalue() {
		return caltaxvalue;
	}

	public void setCaltaxvalue(BigDecimal caltaxvalue) {
		this.caltaxvalue = caltaxvalue;
	}

	public BigDecimal getTaxvalue() {
		return taxvalue;
	}

	public void setTaxvalue(BigDecimal taxvalue) {
		this.taxvalue = taxvalue;
	}

	public String getSubordertype() {
		return subordertype;
	}

	public void setSubordertype(String subordertype) {
		this.subordertype = subordertype;
	}

	public String getPickerPersonEmail() {
		return pickerPersonEmail;
	}

	public void setPickerPersonEmail(String pickerPersonEmail) {
		this.pickerPersonEmail = pickerPersonEmail;
	}

	public String getCustomerConfDelDate() {
		return customerConfDelDate;
	}

	public void setCustomerConfDelDate(String customerConfDelDate) {
		this.customerConfDelDate = customerConfDelDate;
	}

	public String getCustomerReceived() {
		return customerReceived;
	}

	public void setCustomerReceived(String customerReceived) {
		this.customerReceived = customerReceived;
	}

	public String getCollectFromDate() {
		return collectFromDate;
	}

	public void setCollectFromDate(String collectFromDate) {
		this.collectFromDate = collectFromDate;
	}

	public String getCollectToDate() {
		return collectToDate;
	}

	public void setCollectToDate(String collectToDate) {
		this.collectToDate = collectToDate;
	}

	public OctParam getReturnfulfillmenttype() {
		return returnfulfillmenttype;
	}

	public void setReturnfulfillmenttype(OctParam returnfulfillmenttype) {
		this.returnfulfillmenttype = returnfulfillmenttype;
	}

	public String getIsCIRDelivered() {
		return isCIRDelivered;
	}

	public void setIsCIRDelivered(String isCIRDelivered) {
		this.isCIRDelivered = isCIRDelivered;
	}

	public String getQcfailcomment() {
		return qcfailcomment;
	}

	public void setQcfailcomment(String qcfailcomment) {
		this.qcfailcomment = qcfailcomment;
	}

	public String getIscncparentdeliverd() {
		return iscncparentdeliverd;
	}

	public void setIscncparentdeliverd(String iscncparentdeliverd) {
		this.iscncparentdeliverd = iscncparentdeliverd;
	}

	public String getRetPickFirstName() {
		return retPickFirstName;
	}

	public void setRetPickFirstName(String retPickFirstName) {
		this.retPickFirstName = retPickFirstName;
	}

	public String getRetPickLastName() {
		return retPickLastName;
	}

	public void setRetPickLastName(String retPickLastName) {
		this.retPickLastName = retPickLastName;
	}

	public String getRetPickPhoneNo() {
		return retPickPhoneNo;
	}

	public void setRetPickPhoneNo(String retPickPhoneNo) {
		this.retPickPhoneNo = retPickPhoneNo;
	}

	public String getRetPickAddress1() {
		return retPickAddress1;
	}

	public void setRetPickAddress1(String retPickAddress1) {
		this.retPickAddress1 = retPickAddress1;
	}

	public String getRetPickAddress2() {
		return retPickAddress2;
	}

	public void setRetPickAddress2(String retPickAddress2) {
		this.retPickAddress2 = retPickAddress2;
	}

	public String getRetPickAddress3() {
		return retPickAddress3;
	}

	public void setRetPickAddress3(String retPickAddress3) {
		this.retPickAddress3 = retPickAddress3;
	}

	public String getRetPickLandmark() {
		return retPickLandmark;
	}

	public void setRetPickLandmark(String retPickLandmark) {
		this.retPickLandmark = retPickLandmark;
	}

	public String getRetPickCountry() {
		return retPickCountry;
	}

	public void setRetPickCountry(String retPickCountry) {
		this.retPickCountry = retPickCountry;
	}

	public String getRetPickState() {
		return retPickState;
	}

	public void setRetPickState(String retPickState) {
		this.retPickState = retPickState;
	}

	public String getRetPickCity() {
		return retPickCity;
	}

	public void setRetPickCity(String retPickCity) {
		this.retPickCity = retPickCity;
	}

	public String getRetPickPinCode() {
		return retPickPinCode;
	}

	public void setRetPickPinCode(String retPickPinCode) {
		this.retPickPinCode = retPickPinCode;
	}

	public String getRetPickAlternateContName() {
		return retPickAlternateContName;
	}

	public void setRetPickAlternateContName(String retPickAlternateContName) {
		this.retPickAlternateContName = retPickAlternateContName;
	}

	public String getRetPickAlternateContPhoneNo() {
		return retPickAlternateContPhoneNo;
	}

	public void setRetPickAlternateContPhoneNo(String retPickAlternateContPhoneNo) {
		this.retPickAlternateContPhoneNo = retPickAlternateContPhoneNo;
	}

	public String getPickerPersonName() {
		return pickerPersonName;
	}

	public void setPickerPersonName(String pickerPersonName) {
		this.pickerPersonName = pickerPersonName;
	}

	public String getShipLandmark() {
		return shipLandmark;
	}

	public void setShipLandmark(String shipLandmark) {
		this.shipLandmark = shipLandmark;
	}

	public String getAlternatecontactname() {
		return alternatecontactname;
	}

	public void setAlternatecontactname(String alternatecontactname) {
		this.alternatecontactname = alternatecontactname;
	}

	public String getAlternatephoneno() {
		return alternatephoneno;
	}

	public void setAlternatephoneno(String alternatephoneno) {
		this.alternatephoneno = alternatephoneno;
	}

	public String getPickerPersonPhone() {
		return pickerPersonPhone;
	}

	public void setPickerPersonPhone(String pickerPersonPhone) {
		this.pickerPersonPhone = pickerPersonPhone;
	}

	public String getCiStatus() {
		return ciStatus;
	}

	public void setCiStatus(String ciStatus) {
		if(ciStatus == null || "".equals(ciStatus)) {
			this.ciStatus = "1";
		} else {
			this.ciStatus = ciStatus;
		}
	}

	public String getIsSShipAck() {
		return isSShipAck;
	}

	public void setIsSShipAck(String isSShipAck) {
		this.isSShipAck = isSShipAck;
	}

	public  com.sellerportal.model.OctSlv getOctSlvFeeder() {
		return octSlvFeeder;
	}

	public void setOctSlvFeeder( com.sellerportal.model.OctSlv octSlvFeeder) {
		this.octSlvFeeder = octSlvFeeder;
	}

	public String getInlineStatusForInbound() {
		return inlineStatusForInbound;
	}

	public void setInlineStatusForInbound(String inlineStatusForInbound) {
		this.inlineStatusForInbound = inlineStatusForInbound;
	}

	public String getIsrevinvoicesent() {
		return isrevinvoicesent;
	}

	public void setIsrevinvoicesent(String isrevinvoicesent) {
		this.isrevinvoicesent = isrevinvoicesent;
	}

	public Date getAckdate() {
		return ackdate;
	}

	public void setAckdate(Date ackdate) {
		this.ackdate = ackdate;
	}

	public Date getFwedeliverydate() {
		return fwedeliverydate;
	}

	public void setFwedeliverydate(Date fwedeliverydate) {
		this.fwedeliverydate = fwedeliverydate;
	}


	public String getIsEarlyRefund() {
		return isEarlyRefund;
	}

	public void setIsEarlyRefund(String isEarlyRefund) {
		this.isEarlyRefund = isEarlyRefund;
	}

	public String getInScan() {
		return inScan;
	}

	public void setInScan(String inScan) {
		this.inScan = inScan;
	}

	public BigDecimal getRssshipingcharge() {
		return rssshipingcharge;
	}

	public void setRssshipingcharge(BigDecimal rssshipingcharge) {
		this.rssshipingcharge = rssshipingcharge;
	}

	public String getPickupDate() {
		return PickupDate;
	}

	public void setPickupDate(String pickupDate) {
		PickupDate = pickupDate;
	}

	public String getTimeSlotFrom() {
		return TimeSlotFrom;
	}

	public void setTimeSlotFrom(String timeSlotFrom) {
		TimeSlotFrom = timeSlotFrom;
	}

	public String getTimeSlotTo() {
		return TimeSlotTo;
	}

	public void setTimeSlotTo(String timeSlotTo) {
		TimeSlotTo = timeSlotTo;
	}




	public Long getProductNoOfExpDays() {
		return productNoOfExpDays;
	}

	public void setProductNoOfExpDays(Long productNoOfExpDays) {
		this.productNoOfExpDays = productNoOfExpDays;
	}



	public String getIsReturnToStoreEligible() {
		return isReturnToStoreEligible;
	}

	public void setIsReturnToStoreEligible(String isReturnToStoreEligible) {
		this.isReturnToStoreEligible = isReturnToStoreEligible;
	}

	public String getSellerordersendstatus() {
		return sellerordersendstatus;
	}

	public void setSellerordersendstatus(String sellerordersendstatus) {
		this.sellerordersendstatus = sellerordersendstatus;
	}

	public String getReturnSlaveId() {
		return returnSlaveId;
	}

	public void setReturnSlaveId(String returnSlaveId) {
		this.returnSlaveId = returnSlaveId;
	}

	public BigDecimal getScheduledDeliveryCharge() {
		return scheduledDeliveryCharge;
	}

	public void setScheduledDeliveryCharge(BigDecimal scheduledDeliveryCharge) {
		this.scheduledDeliveryCharge = scheduledDeliveryCharge;
	}

	public String getIsEDtoHD() {
		return isEDtoHD;
	}

	public void setIsEDtoHD(String isEDtoHD) {
		this.isEDtoHD = isEDtoHD;
	}

	public String getIsStoreCredit() {
		return isStoreCredit;
	}

	public void setIsStoreCredit(String isStoreCredit) {
		this.isStoreCredit = isStoreCredit;
	}

	public String getReturnInvoiceSlaveId() {
		return returnInvoiceSlaveId;
	}

	public void setReturnInvoiceSlaveId(String returnInvoiceSlaveId) {
		this.returnInvoiceSlaveId = returnInvoiceSlaveId;
	}

	public String getIsimeireq() {
		return isimeireq;
	}

	public void setIsimeireq(String isimeireq) {
		this.isimeireq = isimeireq;
	}

	public String getL4category() {
		return l4category;
	}

	public void setL4category(String l4category) {
		this.l4category = l4category;
	}

	public String getIsQcFailed() {
		return isQcFailed;
	}

	public void setIsQcFailed(String isQcFailed) {
		this.isQcFailed = isQcFailed;
	}

	public String getPstimei3() {
		return pstimei3;
	}

	public void setPstimei3(String pstimei3) {
		this.pstimei3 = pstimei3;
	}

	public String getPstimei4() {
		return pstimei4;
	}

	public void setPstimei4(String pstimei4) {
		this.pstimei4 = pstimei4;
	}

	public String getL1catecory() {
		return l1catecory;
	}

	public void setL1catecory(String l1catecory) {
		this.l1catecory = l1catecory;
	}

	public String getL1catCode() {
		return l1catCode;
	}

	public void setL1catCode(String l1catCode) {
		this.l1catCode = l1catCode;
	}

	public String getL4catCode() {
		return l4catCode;
	}

	public void setL4catCode(String l4catCode) {
		this.l4catCode = l4catCode;
	}

	public String getIsPrecious() {
		return isPrecious;
	}

	public void setIsPrecious(String isPrecious) {
		this.isPrecious = isPrecious;
	}
	public String getProcessedFrom() {
		return processedFrom;
	}

	public void setProcessedFrom(String processedFrom) {
		this.processedFrom = processedFrom;
	}

//	public String getStlMobileSrc() {
//		return stlMobileSrc;
//	}
//
//	public void setStlMobileSrc(String stlMobileSrc) {
//		this.stlMobileSrc = stlMobileSrc;
//	}
	public BigDecimal getPackLimitAmt() {
		return packLimitAmt;
	}

	public void setPackLimitAmt(BigDecimal packLimitAmt) {
		this.packLimitAmt = packLimitAmt;
	}


	public String getIsSendToUnicom() {
		return isSendToUnicom;
	}

	public void setIsSendToUnicom(String isSendToUnicom) {
		this.isSendToUnicom = isSendToUnicom;
	}

//	public String getIsSendFeederDispatch() {
//		return isSendFeederDispatch;
//	}
//
//	public void setIsSendFeederDispatch(String isSendFeederDispatch) {
//		this.isSendFeederDispatch = isSendFeederDispatch;
//	}

	public String getPstGstStateCode() {
		return pstGstStateCode;
	}

	public void setPstGstStateCode(String pstGstStateCode) {
		this.pstGstStateCode = pstGstStateCode;
	}

	public String getPstHSNCode() {
		return pstHSNCode;
	}

	public void setPstHSNCode(String pstHSNCode) {
		this.pstHSNCode = pstHSNCode;
	}

	public String getPstGSTCreditNote() {
		return pstGSTCreditNote;
	}

	public void setPstGSTCreditNote(String pstGSTCreditNote) {
		this.pstGSTCreditNote = pstGSTCreditNote;
	}

	public String getTaxtype2() {
		return taxtype2;
	}

	public void setTaxtype2(String taxtype2) {
		this.taxtype2 = taxtype2;
	}

	public BigDecimal getTaxvalue2() {
		return taxvalue2;
	}

	public void setTaxvalue2(BigDecimal taxvalue2) {
		this.taxvalue2 = taxvalue2;
	}

	public BigDecimal getCalctaxvalue2() {
		return calctaxvalue2;
	}

	public void setCalctaxvalue2(BigDecimal calctaxvalue2) {
		this.calctaxvalue2 = calctaxvalue2;
	}

	public int getPstGstCreditNoteCount() {
		return pstGstCreditNoteCount;
	}

	public void setPstGstCreditNoteCount(int pstGstCreditNoteCount) {
		this.pstGstCreditNoteCount = pstGstCreditNoteCount;
	}

	public String getIsPriceBreakUpOnInvoice() {
		return isPriceBreakUpOnInvoice;
	}

	public void setIsPriceBreakUpOnInvoice(String isPriceBreakUpOnInvoice) {
		this.isPriceBreakUpOnInvoice = isPriceBreakUpOnInvoice;
	}

	public String getMetalName() {
		return metalName;
	}

	public void setMetalName(String metalName) {
		this.metalName = metalName;
	}

	public BigDecimal getMetalRate() {
		return metalRate;
	}

	public void setMetalRate(BigDecimal metalRate) {
		this.metalRate = metalRate;
	}

	public BigDecimal getMetalValue() {
		return metalValue;
	}

	public void setMetalValue(BigDecimal metalValue) {
		this.metalValue = metalValue;
	}

	public BigDecimal getSolitaireValue() {
		return solitaireValue;
	}

	public void setSolitaireValue(BigDecimal solitaireValue) {
		this.solitaireValue = solitaireValue;
	}

	public BigDecimal getDiamondValue() {
		return diamondValue;
	}

	public void setDiamondValue(BigDecimal diamondValue) {
		this.diamondValue = diamondValue;
	}

	public BigDecimal getStoreValue() {
		return storeValue;
	}

	public void setStoreValue(BigDecimal storeValue) {
		this.storeValue = storeValue;
	}

	public BigDecimal getMakingCharges() {
		return makingCharges;
	}

	public void setMakingCharges(BigDecimal makingCharges) {
		this.makingCharges = makingCharges;
	}

	public BigDecimal getWastageCharges() {
		return wastageCharges;
	}

	public void setWastageCharges(BigDecimal wastageCharges) {
		this.wastageCharges = wastageCharges;
	}

	public BigDecimal getSolitaireRate() {
		return solitaireRate;
	}

	public void setSolitaireRate(BigDecimal solitaireRate) {
		this.solitaireRate = solitaireRate;
	}

	public String getBrandName() {
		return brandName;
	}

	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}

	public String getPurity() {
		return purity;
	}

	public void setPurity(String purity) {
		this.purity = purity;
	}

	public String getIsReverseSealNoAvailable() {
		return isReverseSealNoAvailable;
	}

	public void setIsReverseSealNoAvailable(String isReverseSealNoAvailable) {
		this.isReverseSealNoAvailable = isReverseSealNoAvailable;
	}

	public String getCatGrossMetalWt() {
		return catGrossMetalWt;
	}

	public void setCatGrossMetalWt(String catGrossMetalWt) {
		this.catGrossMetalWt = catGrossMetalWt;
	}

	public String getCatMetalWt() {
		return catMetalWt;
	}

	public void setCatMetalWt(String catMetalWt) {
		this.catMetalWt = catMetalWt;
	}

	public String getCatCoinBarWt() {
		return catCoinBarWt;
	}

	public void setCatCoinBarWt(String catCoinBarWt) {
		this.catCoinBarWt = catCoinBarWt;
	}

	public String getCatSolitaireWt() {
		return catSolitaireWt;
	}

	public void setCatSolitaireWt(String catSolitaireWt) {
		this.catSolitaireWt = catSolitaireWt;
	}

	public String getCatTotalWt() {
		return catTotalWt;
	}

	public void setCatTotalWt(String catTotalWt) {
		this.catTotalWt = catTotalWt;
	}

	public String getCatWt1() {
		return catWt1;
	}

	public void setCatWt1(String catWt1) {
		this.catWt1 = catWt1;
	}

	public String getCatWt2() {
		return catWt2;
	}

	public void setCatWt2(String catWt2) {
		this.catWt2 = catWt2;
	}

	public String getCatWt3() {
		return catWt3;
	}

	public void setCatWt3(String catWt3) {
		this.catWt3 = catWt3;
	}

	public String getCatWt4() {
		return catWt4;
	}

	public void setCatWt4(String catWt4) {
		this.catWt4 = catWt4;
	}

	public String getCatWt5() {
		return catWt5;
	}

	public void setCatWt5(String catWt5) {
		this.catWt5 = catWt5;
	}

	public String getCatWt7() {
		return catWt7;
	}

	public void setCatWt7(String catWt7) {
		this.catWt7 = catWt7;
	}

	public String getCatWt6() {
		return catWt6;
	}

	public void setCatWt6(String catWt6) {
		this.catWt6 = catWt6;
	}

	public String getPANCARDVerificationReq() {
		return PANCARDVerificationReq;
	}

	public void setPANCARDVerificationReq(String pANCARDVerificationReq) {
		PANCARDVerificationReq = pANCARDVerificationReq;
	}

	public String getPstpancardpath() {
		return pstpancardpath;
	}

	public void setPstpancardpath(String pstpancardpath) {
		this.pstpancardpath = pstpancardpath;
	}

	public OctParam getPstpancardstatus() {
		return pstpancardstatus;
	}

	public void setPstpancardstatus(OctParam pstpancardstatus) {
		this.pstpancardstatus = pstpancardstatus;
	}

	public String getPstIsExempted() {
		return pstIsExempted;
	}

	public void setPstIsExempted(String pstIsExempted) {
		this.pstIsExempted = pstIsExempted;
	}

	public Date getProductcreatedate() {
		return productcreatedate;
	}

	public void setProductcreatedate(Date productcreatedate) {
		this.productcreatedate = productcreatedate;
	}

	public BigDecimal getTaxableAmt() {
		return taxableAmt;
	}

	public void setTaxableAmt(BigDecimal taxableAmt) {
		this.taxableAmt = taxableAmt;
	}
	public String getL2catCode() {
		return l2catCode;
	}

	public void setL2catCode(String l2catCode) {
		this.l2catCode = l2catCode;
	}

	public String getL2category() {
		return l2category;
	}

	public void setL2category(String l2category) {
		this.l2category = l2category;
	}

	public String getDiscreetContains() {
		return discreetContains;
	}

	public void setDiscreetContains(String discreetContains) {
		this.discreetContains = discreetContains;
	}

	public String getErqcrefNum() {
		return erqcrefNum;
	}

	public void setErqcrefNum(String erqcrefNum) {
		this.erqcrefNum = erqcrefNum;
	}

	public String getErqcAprrefNum() {
		return erqcAprrefNum;
	}

	public void setErqcAprrefNum(String erqcAprrefNum) {
		this.erqcAprrefNum = erqcAprrefNum;
	}

	public String getIserEligible() {
		return iserEligible;
	}

	public void setIserEligible(String iserEligible) {
		this.iserEligible = iserEligible;
	}

	public String getL3catCode() {
		return l3catCode;
	}

	public void setL3catCode(String l3catCode) {
		this.l3catCode = l3catCode;
	}

	public String getL3category() {
		return l3category;
	}

	public void setL3category(String l3category) {
		this.l3category = l3category;
	}

	public BigDecimal getSellerDiscount() {
		return sellerDiscount;
	}

	public void setSellerDiscount(BigDecimal sellerDiscount) {
		this.sellerDiscount = sellerDiscount;
	}

	public BigDecimal getTataDiscount() {
		return tataDiscount;
	}

	public void setTataDiscount(BigDecimal tataDiscount) {
		this.tataDiscount = tataDiscount;
	}

	public BigDecimal getErCompensationrate() {
		return erCompensationrate;
	}

	public void setErCompensationrate(BigDecimal erCompensationrate) {
		this.erCompensationrate = erCompensationrate;
	}

	public BigDecimal getErCommissionvalue() {
		return erCommissionvalue;
	}

	public void setErCommissionvalue(BigDecimal erCommissionvalue) {
		this.erCommissionvalue = erCommissionvalue;
	}

	public String getIserqcapproved() {
		return iserqcapproved;
	}

	public void setIserqcapproved(String iserqcapproved) {
		this.iserqcapproved = iserqcapproved;
	}

	public String getIserqcreject() {
		return iserqcreject;
	}

	public void setIserqcreject(String iserqcreject) {
		this.iserqcreject = iserqcreject;
	}

	public String getDisputecomment() {
		return disputecomment;
	}

	public void setDisputecomment(String disputecomment) {
		this.disputecomment = disputecomment;
	}

	public Set<OctDisputeTicket> getOctDisputeTicket() {
		return octDisputeTicket;
	}

	public void setOctDisputeTicket(Set<OctDisputeTicket> octDisputeTicket) {
		this.octDisputeTicket = octDisputeTicket;
	}



	public String getIserpickup() {
		return iserpickup;
	}

	public void setIserpickup(String iserpickup) {
		this.iserpickup = iserpickup;
	}

	public String getIserdeliver() {
		return iserdeliver;
	}

	public void setIserdeliver(String iserdeliver) {
		this.iserdeliver = iserdeliver;
	}

	public String getIserlit() {
		return iserlit;
	}

	public void setIserlit(String iserlit) {
		this.iserlit = iserlit;
	}

	public String getIserqcpass() {
		return iserqcpass;
	}

	public void setIserqcpass(String iserqcpass) {
		this.iserqcpass = iserqcpass;
	}

	public String getIserqcfail() {
		return iserqcfail;
	}

	public void setIserqcfail(String iserqcfail) {
		this.iserqcfail = iserqcfail;
	}

	public String getIsretuirto() {
		return isretuirto;
	}

	public void setIsretuirto(String isretuirto) {
		this.isretuirto = isretuirto;
	}

	public String getIsLuxuryTxn() {
		return isLuxuryTxn;
	}

	public void setIsLuxuryTxn(String isLuxuryTxn) {
		this.isLuxuryTxn = isLuxuryTxn;
	}
	/**
	 * @return the isSellerSend
	 */
	public String getIsSellerSend() {
		return isSellerSend;
	}

	/**
	 * @param isSellerSend the isSellerSend to set
	 */
	public void setIsSellerSend(String isSellerSend) {
		this.isSellerSend = isSellerSend;
	}

	public  com.sellerportal.model.OctParam getPstrejectreason() {
		return pstrejectreason;
	}

	public void setPstrejectreason( com.sellerportal.model.OctParam pstrejectreason) {
		this.pstrejectreason = pstrejectreason;
	}

	public String getPbiIdentityCodes() {
		return pbiIdentityCodes;
	}

	public void setPbiIdentityCodes(String pbiIdentityCodes) {
		this.pbiIdentityCodes = pbiIdentityCodes;
	}

	public String getIsPlasticBan() {
		return isPlasticBan;
	}

	public void setIsPlasticBan(String isPlasticBan) {
		this.isPlasticBan = isPlasticBan;
	}
	public String getJioRefundDate() {
		return jioRefundDate;
	}

	public void setJioRefundDate(String jioRefundDate) {
		this.jioRefundDate = jioRefundDate;
	}

	public String getRejectForcefitLpCode() {
		return rejectForcefitLpCode;
	}

	public void setRejectForcefitLpCode(String rejectForcefitLpCode) {
		this.rejectForcefitLpCode = rejectForcefitLpCode;
	}

	public String getFicoInvoiceRemark() {
		return ficoInvoiceRemark;
	}

	public void setFicoInvoiceRemark(String ficoInvoiceRemark) {
		this.ficoInvoiceRemark = ficoInvoiceRemark;
	}

	public String getFicoNORStatus() {
		return ficoNORStatus;
	}

	public void setFicoNORStatus(String ficoNORStatus) {
		this.ficoNORStatus = ficoNORStatus;
	}

	public String getFicoRRFStatus() {
		return ficoRRFStatus;
	}

	public void setFicoRRFStatus(String ficoRRFStatus) {
		this.ficoRRFStatus = ficoRRFStatus;
	}

	public String getJioPosRemark() {
		return jioPosRemark;
	}

	public void setJioPosRemark(String jioPosRemark) {
		this.jioPosRemark = jioPosRemark;
	}

	public String getJioPosStatus() {
		return jioPosStatus;
	}

	public void setJioPosStatus(String jioPosStatus) {
		this.jioPosStatus = jioPosStatus;
	}

	public Date getSpCreateDate() {
		return spCreateDate;
	}

	public void setSpCreateDate(Date spCreateDate) {
		this.spCreateDate = spCreateDate;
	}

	public String getBrandCode() {
		return brandCode;
	}

	public void setBrandCode(String brandCode) {
		this.brandCode = brandCode;
	}
	
	public String getElecQCStatus() {
		return elecQCStatus;
	}

	public void setElecQCStatus(String elecQCStatus) {
		this.elecQCStatus = elecQCStatus;
	}

	public Date getElecQCDate() {
		return elecQCDate;
	}

	public void setElecQCDate(Date elecQCDate) {
		this.elecQCDate = elecQCDate;
	}

	public String getElecQCReason() {
		return elecQCReason;
	}

	public void setElecQCReason(String elecQCReason) {
		this.elecQCReason = elecQCReason;
	}

	public Date getReturnDeliveredDate() {
		return returnDeliveredDate;
	}

	public void setReturnDeliveredDate(Date returnDeliveredDate) {
		this.returnDeliveredDate = returnDeliveredDate;
	}
	public String getIsErXDispute() {
        return isErXDispute;
    }

    public void setIsErXDispute(String isErXDispute) {
        this.isErXDispute = isErXDispute;
    }

	public String getIsAutoQcPass() {
		return isAutoQcPass;
	}

	public void setIsAutoQcPass(String isAutoQcPass) {
		this.isAutoQcPass = isAutoQcPass;
	}

	public BigDecimal getSuggcomppercent() {
		return suggcomppercent;
	}

	public void setSuggcomppercent(BigDecimal suggcomppercent) {
		this.suggcomppercent = suggcomppercent;
	}

	public BigDecimal getSuggcompvalue() {
		return suggcompvalue;
	}

	public void setSuggcompvalue(BigDecimal suggcompvalue) {
		this.suggcompvalue = suggcompvalue;
	}

	public BigDecimal getActualcomppercent() {
		return actualcomppercent;
	}

	public void setActualcomppercent(BigDecimal actualcomppercent) {
		this.actualcomppercent = actualcomppercent;
	}

	public BigDecimal getActualcompvalue() {
		return actualcompvalue;
	}

	public void setActualcompvalue(BigDecimal actualcompvalue) {
		this.actualcompvalue = actualcompvalue;
	}

	public Date getCirRtoDate() {
		return cirRtoDate;
	}

	public void setCirRtoDate(Date cirRtoDate) {
		this.cirRtoDate = cirRtoDate;
	}

	public Date getReturnPickUpDate() {
		return returnPickUpDate;
	}

	public void setReturnPickUpDate(Date returnPickUpDate) {
		this.returnPickUpDate = returnPickUpDate;
	}

	public Date getClaimRegDate() {
		return claimRegDate;
	}

	public void setClaimRegDate(Date claimRegDate) {
		this.claimRegDate = claimRegDate;
	}

	public String getErDisputeType() {
		return erDisputeType;
	}

	public void setErDisputeType(String erDisputeType) {
		this.erDisputeType = erDisputeType;
	}

	public BigDecimal getCessrate() {
		return cessrate;
	}

	public void setCessrate(BigDecimal cessrate) {
		this.cessrate = cessrate;
	}

	public BigDecimal getCessvalue() {
		return cessvalue;
	}

	public void setCessvalue(BigDecimal cessvalue) {
		this.cessvalue = cessvalue;
	}	
	
	public String getsCheckSize() {
		return sCheckSize;
	}

	public void setsCheckSize(String sCheckSize) {
		this.sCheckSize = sCheckSize;
	}

	public String getsCheckColor() {
		return sCheckColor;
	}

	public void setsCheckColor(String sCheckColor) {
		this.sCheckColor = sCheckColor;
	}

	public String getsCheckBrand() {
		return sCheckBrand;
	}

	public void setsCheckBrand(String sCheckBrand) {
		this.sCheckBrand = sCheckBrand;
	}

	public String getsCheckSkuCode() {
		return sCheckSkuCode;
	}

	public void setsCheckSkuCode(String sCheckSkuCode) {
		this.sCheckSkuCode = sCheckSkuCode;
	}

	public String getsCheckSerialNumber() {
		return sCheckSerialNumber;
	}

	public void setsCheckSerialNumber(String sCheckSerialNumber) {
		this.sCheckSerialNumber = sCheckSerialNumber;
	}

	public String getsCheckReverseSealCode() {
		return sCheckReverseSealCode;
	}

	public void setsCheckReverseSealCode(String sCheckReverseSealCode) {
		this.sCheckReverseSealCode = sCheckReverseSealCode;
	}

	public String getsCheckImeiNumber() {
		return sCheckImeiNumber;
	}

	public void setsCheckImeiNumber(String sCheckImeiNumber) {
		this.sCheckImeiNumber = sCheckImeiNumber;
	}

	public String getsCheckWrongProductCode() {
		return sCheckWrongProductCode;
	}

	public void setsCheckWrongProductCode(String sCheckWrongProductCode) {
		this.sCheckWrongProductCode = sCheckWrongProductCode;
	}

	public String getsCheckWrongProductDesc() {
		return sCheckWrongProductDesc;
	}

	public void setsCheckWrongProductDesc(String sCheckWrongProductDesc) {
		this.sCheckWrongProductDesc = sCheckWrongProductDesc;
	}

	public String getsCheckIsPackagingMandatory() {
		return sCheckIsPackagingMandatory;
	}

	public void setsCheckIsPackagingMandatory(String sCheckIsPackagingMandatory) {
		this.sCheckIsPackagingMandatory = sCheckIsPackagingMandatory;
	}

	public String getsCheckIsCheckDamage() {
		return sCheckIsCheckDamage;
	}

	public void setsCheckIsCheckDamage(String sCheckIsCheckDamage) {
		this.sCheckIsCheckDamage = sCheckIsCheckDamage;
	}

	public String getsCheckIsCheckUsage() {
		return sCheckIsCheckUsage;
	}

	public void setsCheckIsCheckUsage(String sCheckIsCheckUsage) {
		this.sCheckIsCheckUsage = sCheckIsCheckUsage;
	}

	public String getsCheckIsCheckAccessories() {
		return sCheckIsCheckAccessories;
	}

	public void setsCheckIsCheckAccessories(String sCheckIsCheckAccessories) {
		this.sCheckIsCheckAccessories = sCheckIsCheckAccessories;
	}

	public String getReturnReason() {
		return returnReason;
	}

	public void setReturnReason(String returnReason) {
		this.returnReason = returnReason;
	}

	public String getReturnSubReason() {
		return returnSubReason;
	}

	public void setReturnSubReason(String returnSubReason) {
		this.returnSubReason = returnSubReason;
	}
	
	public String getIsRevEligible() {
		return isRevEligible;
	}

	public void setIsRevEligible(String isRevEligible) {
		this.isRevEligible = isRevEligible;
	}

	public String getIsMediation() {
		return isMediation;
	}

	public void setIsMediation(String isMediation) {
		this.isMediation = isMediation;
	}

	public OctParam getRevRefundType() {
		return revRefundType;
	}

	public void setRevRefundType(OctParam revRefundType) {
		this.revRefundType = revRefundType;
	}

	public String getRefundReplaceType() {
		return refundReplaceType;
	}

	public void setRefundReplaceType(String refundReplaceType) {
		this.refundReplaceType = refundReplaceType;
	}

	public String getIscliqcashRefunded() {
		return iscliqcashRefunded;
	}

	public void setIscliqcashRefunded(String iscliqcashRefunded) {
		this.iscliqcashRefunded = iscliqcashRefunded;
	}

	public String getReturnCnclRsnCode() {
		return returnCnclRsnCode;
	}

	public void setReturnCnclRsnCode(String returnCnclRsnCode) {
		this.returnCnclRsnCode = returnCnclRsnCode;
	}
	
	public String getAddrCat() {
		return addrCat;
	}

	public void setAddrCat(String addrCat) {
		this.addrCat = addrCat;
	}
	
		public Date getHotcDate() {
		return hotcDate;
	}

	public void setHotcDate(Date hotcDate) {
		this.hotcDate = hotcDate;
	}

	public Date getFwdorderdeliverdate() {
		return fwdorderdeliverdate;
	}

	public void setFwdorderdeliverdate(Date fwdorderdeliverdate) {
		this.fwdorderdeliverdate = fwdorderdeliverdate;
	}
	
	public String getIsCNCtoHD() {
		return isCNCtoHD;
	}

	public void setIsCNCtoHD(String isCNCtoHD) {
		this.isCNCtoHD = isCNCtoHD;
	}

	public String getIsSDDtoHD() {
		return isSDDtoHD;
	}

	public void setIsSDDtoHD(String isSDDtoHD) {
		this.isSDDtoHD = isSDDtoHD;
	}
	
	public String getEstimatedDeliveryDate() {
		return estimatedDeliveryDate;
	}

	public void setEstimatedDeliveryDate(String estimatedDeliveryDate) {
		this.estimatedDeliveryDate = estimatedDeliveryDate;
	}
	
	public Date getPredictionPickConfirmed() {
		return predictionPickConfirmed;
	}

	public void setPredictionPickConfirmed(Date predictionPickConfirmed) {
		this.predictionPickConfirmed = predictionPickConfirmed;
	}

	public Date getPredictionHOTC() {
		return predictionHOTC;
	}

	public void setPredictionHOTC(Date predictionHOTC) {
		this.predictionHOTC = predictionHOTC;
	}

	public Date getPredictionInscan() {
		return predictionInscan;
	}

	public void setPredictionInscan(Date predictionInscan) {
		this.predictionInscan = predictionInscan;
	}

	public Date getPredictionEDD() {
		return predictionEDD;
	}

	public void setPredictionEDD(Date predictionEDD) {
		this.predictionEDD = predictionEDD;
	}

	public String getIsHDtoHD() {
		return isHDtoHD;
	}

	public void setIsHDtoHD(String isHDtoHD) {
		this.isHDtoHD = isHDtoHD;
	}
	
//	 public String getIsForcedReject() {
//        return isForcedReject;
//    }
//
//    public void setIsForcedReject(String isForcedReject) {
//        this.isForcedReject = isForcedReject;
//    }

	public Integer getZoneType() {
		return zoneType;
	}

	public void setZoneType(Integer zoneType) {
		this.zoneType = zoneType;
	}

	public Date getInScanDate() {
		return inScanDate;
	}

	public void setInScanDate(Date inScanDate) {
		this.inScanDate = inScanDate;
	}
	public String getAutoActivateFlag() {
		return autoActivateFlag;
	}

	public void setAutoActivateFlag(String autoActivateFlag) {
		this.autoActivateFlag = autoActivateFlag;
	}

	public String getBundedWith() {
		return bundedWith;
	}

	public void setBundedWith(String bundedWith) {
		this.bundedWith = bundedWith;
	}

	public String getShipGSTNumber() {
		return shipGSTNumber;
	}

	public void setShipGSTNumber(String shipGSTNumber) {
		this.shipGSTNumber = shipGSTNumber;
	}

	public String getShipCompanyName() {
		return shipCompanyName;
	}

	public void setShipCompanyName(String shipCompanyName) {
		this.shipCompanyName = shipCompanyName;
	}
	
	public String getIsHazmat() {
		return isHazmat;
	}

	public void setIsHazmat(String isHazmat) {
		this.isHazmat = isHazmat;
	}

	public String getIsColdStorage() {
		return isColdStorage;
	}

	public void setIsColdStorage(String isColdStorage) {
		this.isColdStorage = isColdStorage;
	}

	public String getIsHandReplacement() {
		return isHandReplacement;
	}

	public void setIsHandReplacement(String isHandReplacement) {
		this.isHandReplacement = isHandReplacement;
	}

	public  com.sellerportal.model.OctDelChallan getDelvChallan() {
		return delvChallan;
	}

	public void setDelvChallan( com.sellerportal.model.OctDelChallan delvChallan) {
		this.delvChallan = delvChallan;
	}
	public String getBbExternalOrderId() {
		return bbExternalOrderId;
	}

	public void setBbExternalOrderId(String bbExternalOrderId) {
		this.bbExternalOrderId = bbExternalOrderId;
	}
	
	public String getStoreFront() {
		return storeFront;
	}

	public void setStoreFront(String storeFront) {
		this.storeFront = storeFront;
	}

	public String getIsMaxDiscountPerCardFlag() {
		return isMaxDiscountPerCardFlag;
	}

	public void setIsMaxDiscountPerCardFlag(String isMaxDiscountPerCardFlag) {
		this.isMaxDiscountPerCardFlag = isMaxDiscountPerCardFlag;
	}

	public BigDecimal getMaxDiscountPerCardAmt() {
		return maxDiscountPerCardAmt;
	}

	public void setMaxDiscountPerCardAmt(BigDecimal maxDiscountPerCardAmt) {
		this.maxDiscountPerCardAmt = maxDiscountPerCardAmt;
	}
	
	

	public String getProductLotId() {
		return productLotId;
	}

	public void setProductLotId(String productLotId) {
		this.productLotId = productLotId;
	}

	public Date getProductExpiryDate() {
		return productExpiryDate;
	}

	public void setProductExpiryDate(Date productExpiryDate) {
		this.productExpiryDate = productExpiryDate;
	}
	
}