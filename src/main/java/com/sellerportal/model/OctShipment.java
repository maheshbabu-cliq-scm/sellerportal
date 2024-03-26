package com.sellerportal.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import org.apache.commons.lang.builder.ToStringBuilder;
import javax.persistence.*;


@Entity
@Table(name = "OCT_SHIPMENT")
public class OctShipment implements Serializable {

	 @Id
	    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "shipment_sequence")
	    @SequenceGenerator(name = "shipment_sequence", sequenceName = "OCTSHIP_SHIPRFNUM_SEQ", allocationSize = 1)
	    @Column(name = "SHIPRFNUM")
	    private Long shiprfnum;

	    @Column(name = "AWBNUM", length = 30)
	    private String awbnum;

	    @Column(name = "SELLERMAPREFPACKID", length = 50)
	    private String sellerMapPackId;

	    @Column(name = "BOXNAME", length = 50)
	    private String boxname;

	    @Column(name = "INFO1", length = 50)
	    private String info1;

	    @Column(name = "INFO2", length = 20)
	    private String info2;

	    @Column(name = "INFO3", length = 50)
	    private String info3;

	    @Column(name = "INFO4", length = 50)
	    private String info4;

	    @Column(name = "CREATEDATE")
	    private Date createdate;

	    @Column(name = "CREATEDBY")
	    private Long createdby;

	    @Column(name = "DELETED", length = 1)
	    private String deleted;

	    @Column(name = "DIMENSIONTYPE", length = 10)
	    private String dimensiontype;

	    @Column(name = "HEIGHT", length = 10)
	    private String height;

	    @Column(name = "ISACTIVE", length = 1)
	    private String isactive;

	    @Column(name = "ISPICKMADE", length = 1)
	    private String ispickmade;

	    @Column(name = "LENGTH", length = 10)
	    private String length;

	    @Column(name = "COURIERCODE", length = 40)
	    private String couriercode;

	    @Column(name = "MODIDATE")
	    private Date modidate;

	    @Column(name = "MODIFIEDBY")
	    private Long modifiedby;

	    @Column(name = "WIDTH", length = 10)
	    private String width;

	    @Column(name = "WEIGHT", length = 10)
	    private String weight;

	    @Column(name = "FLOWTYPE", length = 1)
	    private String flowtype;
	    
	    @Column(name = "INFO5", length = 50)
	    private String info5;

	    @Column(name = "INFO6", length = 50)
	    private String info6;

	    @Column(name = "INFO7", length = 50)
	    private String info7;

	    @Column(name = "INFO8", length = 50)
	    private String info8;

	    @Column(name = "INFO9", length = 50)
	    private String info9;

	    @Column(name = "LPPICKID", length = 50)
	    private String lppickid;

	    @Column(name = "INFO10", length = 50)
	    private String info10;

	    @Column(name = "INFO11", length = 50)
	    private String info11;

	    @Column(name = "INFO12", length = 50)
	    private String info12;

	    @Column(name = "INFO13", length = 50)
	    private String info13;

	    @Column(name = "AWBGENDATE")
	    private Date awbgendate;

	    @Column(name = "PICKUPTOKENDATE")
	    private Date pickuptokendate;

	    @Column(name = "SECURITYCODE1", length = 20)
	    private String securityCode1;

	    @Column(name = "COLLECTIONEXPIRYDATE", length = 25)
	    private String collectionExpiryDate;

	    @Column(name = "COLLECTIONEXPIRYCOUNTER")
	    private Long collectionExpiryCounter;

	    @Column(name = "LPMENIFESTREMARK", length = 1024)
	    private String lpmenifestremark;

	    @Column(name = "LPMENIFESTSTATUS", length = 100)
	    private String lpmenifeststatus;

	    @Column(name = "ISMENIFESTSENT", length = 20)
	    private String ismenifestsent;

	    @Column(name = "MENIFESTSENTDATE")
	    private Date menifestsentdate;

	    @Column(name = "OCTSHIPMENTPROOFURL", length = 256)
	    private String shipmentproofurl;

	    @Column(name = "ISSHIPEXPRESS", length = 11)
	    private String isShipExpress;

	    @Column(name = "FORWARDSEALNO", length = 100)
	    private String fsealNo;

	    @Column(name = "REVERSESEALNO", length = 100)
	    private String rsealNo;

	    @Column(name = "ISCHILDMENIFESTSENT", length = 20)
	    private String ischildmenifestsent;

	    @Column(name = "CHILDMENIFESTSENTDATE")
	    private Date childmenifestsentdate;

	    @Column(name = "CHILDAWBNUM", length = 255)
	    private String childawbnum;
	    
	    @Column(name = "INFO14", length = 50)
	    private String info14;

	    @Column(name = "INFO15", length = 50)
	    private String info15;

	    @Column(name = "INFO16", length = 50)
	    private String info16;
	    
	    @Column(name = "INFO17", length = 50)
	    private String info17;

	    @Column(name = "INFO18", length = 50)
	    private String info18;

	    @Column(name = "INFO19", length = 50)
	    private String info19;

	    @Column(name = "INFO20", length = 50)
	    private String info20;

	    @Column(name = "INFO21", length = 50)
	    private String info21;

	    @Column(name = "INFO22", length = 50)
	    private String info22;

	    @Column(name = "INFO23", length = 50)
	    private String info23;

	    @Column(name = "INFO24", length = 50)
	    private String info24;

	    @Column(name = "INFO25", length = 50)
	    private String info25;

	    @Column(name = "INFO26", length = 50)
	    private String info26;

	    @Column(name = "INFO27", length = 50)
	    private String info27;

	    @Column(name = "INFO28", length = 50)
	    private String info28;

	    @Column(name = "INFO29", length = 50)
	    private String info29;

	    @Column(name = "INFO30", length = 50)
	    private String info30;

	    @Column(name = "INFO31", length = 50)
	    private String info31;

	    @Column(name = "INFO32", length = 50)
	    private String info32;

	    @Column(name = "INFO33", length = 50)
	    private String info33;
	    
	    @ManyToOne
	    @JoinColumn(name = "MENIFESTO")
	    private OctMenifesto menifesto;

	    @ManyToOne
	    @JoinColumn(name = "OCTINVOICE")
	    private OctInvoice octinvoice;

	    @ManyToOne
	    @JoinColumn(name = "OCTTXNDOC")
	    private OctTxnDoc octTxnDoc;

	    @ManyToOne
	    @JoinColumn(name = "OCTCOUPONBANK")
	    private OctCouponBank octcouponbank;

	    @OneToMany(mappedBy = "shipment")
	    @Transient
	    private Set<Ismpst> ismpsts;
	    
	    @OneToMany(mappedBy = "reverseShipment")
	    @Transient
	    private Set<Ismpst> reverseIsmpsts;

    
    public String getFsealNo() {
		return fsealNo;
	}

	public void setFsealNo(String fsealNo) {
		this.fsealNo = fsealNo;
	}

	public String getRsealNo() {
		return rsealNo;
	}

	public void setRsealNo(String rseal) {
		this.rsealNo = rseal;
	}

	
    private String readyDate;
    @Column(name = "COMPANYCLOSETIME", length = 50)
    private String companyCloseTime;
    //Shankar End : TPR-12098
    
    @Column(name = "RCStatus", length = 1)
    private String RCStatus;

    @Column(name = "RCRemark", length = 255)
    private String RCRemark;

    @Column(name = "ORDERCANCELSTATUS", length = 1)
    private String orderCancelStatus;

    @Column(name = "ORDERCANCELREMARK", length = 255)
    private String orderCancelRemark;

    @Column(name = "SHIPMENTPAYMENTLINK", length = 255)
    private String shipmentPaymentLink;
    /** full constructor 
     * @param ismpsts 
     * @param octTxnDoc 
     * @param octinvoice */
    public OctShipment(String awbnum, Date createdate, Long createdby, String deleted, String dimensiontype, String height,String couriercode, String isactive,String ispickmade, String length, Date modidate, Long modifiedby, String width,String weight, String flowtype,String lppickid, Set<Ismpst> ismpsts,Set<Ismpst> reverseIsmpsts, com.sellerportal.model.OctMenifesto menifesto, OctTxnDoc octTxnDoc, OctInvoice octinvoice,Date awbgendate, Date pickuptokendate,String shipmentproofurl,String lpmenifestremark,String lpmenifeststatus,Date menifestsentdate,String ismenifestsent,String isShipExpress,String childawbnum,String ischildmenifestsent,Date childmenifestsentdate) {
        this.awbnum = awbnum;
        this.createdate = createdate;
        this.createdby = createdby;
        this.deleted = deleted;
        this.dimensiontype = dimensiontype;
        this.height = height;
        this.isactive = isactive;
        this.length = length;
        this.modidate = modidate;
        this.modifiedby = modifiedby;
        this.width = width;
        this.weight = weight;
        this.ismpsts = ismpsts;
        this.reverseIsmpsts = reverseIsmpsts;
        this.menifesto = menifesto;
        this.octTxnDoc=octTxnDoc;
        this.octinvoice = octinvoice; 
        this.ispickmade= ispickmade;
        this.couriercode=couriercode;
        this.flowtype = flowtype;
        this.lppickid = lppickid;
        this.awbgendate = awbgendate;
        this.pickuptokendate = pickuptokendate;
        this.shipmentproofurl = shipmentproofurl;
        this.lpmenifestremark = lpmenifestremark;
        this.lpmenifeststatus = lpmenifeststatus;
        this.menifestsentdate = menifestsentdate;
        this.ismenifestsent = ismenifestsent;
        this.isShipExpress=isShipExpress;
        this.childawbnum = childawbnum;
        this.ischildmenifestsent = ischildmenifestsent;
        this.childmenifestsentdate = childmenifestsentdate;
    }

    /** default constructor */
    public OctShipment() {
    }

    public Long getShiprfnum() {
        return this.shiprfnum;
    }

    public void setShiprfnum(Long shiprfnum) {
        this.shiprfnum = shiprfnum;
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

    public String getDimensiontype() {
        return this.dimensiontype;
    }

    public void setDimensiontype(String dimensiontype) {
        this.dimensiontype = dimensiontype;
    }

    public String getHeight() {
        return this.height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public String getIsactive() {
        return this.isactive;
    }

    public void setIsactive(String isactive) {
        this.isactive = isactive;
    }

    public String getLength() {
        return this.length;
    }

    public void setLength(String length) {
        this.length = length;
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
    
    public String getCouriercode() {
		return couriercode;
	}

	public void setCouriercode(String couriercode) {
		this.couriercode = couriercode;
	}

	public String getIspickmade() {
		return ispickmade;
	}

	public void setIspickmade(String ispickmade) {
		this.ispickmade = ispickmade;
	}

	public String getWidth() {
        return this.width;
    }

    public void setWidth(String width) {
        this.width = width;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("shiprfnum", getShiprfnum())
            .toString();
    }

	public String getWeight() {
		return weight;
	}

	public void setWeight(String weight) {
		this.weight = weight;
	}

	
	public String getFlowtype() {
		return flowtype;
	}

	public void setFlowtype(String flowtype) {
		this.flowtype = flowtype;
	}

	public Set<Ismpst> getIsmpsts() {
		return ismpsts;
	}

	public void setIsmpsts(Set<Ismpst> ismpsts) {
		this.ismpsts = ismpsts;
	}

	public  com.sellerportal.model.OctMenifesto getMenifesto() {
		return menifesto;
	}

	public void setMenifesto( com.sellerportal.model.OctMenifesto menifesto) {
		this.menifesto = menifesto;
	}

	public  com.sellerportal.model.OctTxnDoc getOctTxnDoc() {
		return octTxnDoc;
	}

	public void setOctTxnDoc( com.sellerportal.model.OctTxnDoc octTxnDoc) {
		this.octTxnDoc = octTxnDoc;
	}

	public  com.sellerportal.model.OctInvoice getOctinvoice() {
		return octinvoice;
	}

	public void setOctinvoice( com.sellerportal.model.OctInvoice octinvoice) {
		this.octinvoice = octinvoice;
	}

	public String getInfo1() {
		return info1;
	}

	public void setInfo1(String info1) {
		this.info1 = info1;
	}

	public String getInfo2() {
		return info2;
	}

	public void setInfo2(String info2) {
		this.info2 = info2;
	}

	public String getInfo3() {
		return info3;
	}

	public void setInfo3(String info3) {
		this.info3 = info3;
	}

	public String getInfo4() {
		return info4;
	}

	public void setInfo4(String info4) {
		this.info4 = info4;
	}

	public String getInfo5() {
		return info5;
	}

	public String getInfo6() {
		return info6;
	}

	public String getInfo7() {
		return info7;
	}

	public String getInfo8() {
		return info8;
	}

	public void setInfo5(String info5) {
		this.info5 = info5;
	}

	public void setInfo6(String info6) {
		this.info6 = info6;
	}

	public void setInfo7(String info7) {
		this.info7 = info7;
	}

	public void setInfo8(String info8) {
		this.info8 = info8;
	}

	public String getInfo9() {
		return info9;
	}

	public void setInfo9(String info9) {
		this.info9 = info9;
	}

    public String getSellerMapPackId() {
		return sellerMapPackId;
	}

	public void setSellerMapPackId(String sellerMapPackId) {
		this.sellerMapPackId = sellerMapPackId;
	}

	public String getLppickid() {
		return lppickid;
	}

	public void setLppickid(String lppickid) {
		this.lppickid = lppickid;
	}

	public String getInfo10() {
		return info10;
	}

	public void setInfo10(String info10) {
		this.info10 = info10;
	}

	public String getInfo11() {
		return info11;
	}

	public void setInfo11(String info11) {
		this.info11 = info11;
	}

	public String getInfo12() {
		return info12;
	}

	public void setInfo12(String info12) {
		this.info12 = info12;
	}

	public String getInfo13() {
		return info13;
	}

	public void setInfo13(String info13) {
		this.info13 = info13;
	}

	public Date getAwbgendate() {
		return awbgendate;
	}

	public void setAwbgendate(Date awbgendate) {
		this.awbgendate = awbgendate;
	}

	public Date getPickuptokendate() {
		return pickuptokendate;
	}

	public void setPickuptokendate(Date pickuptokendate) {
		this.pickuptokendate = pickuptokendate;
	}

    public String getBoxname() {
		return boxname;
	}

	public void setBoxname(String boxname) {
		this.boxname = boxname;
	}

	public String getSecurityCode1() {
		return securityCode1;
	}

	public void setSecurityCode1(String securityCode1) {
		this.securityCode1 = securityCode1;
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

	public String getShipmentproofurl() {
		return shipmentproofurl;
	}

	public void setShipmentproofurl(String shipmentproofurl) {
		this.shipmentproofurl = shipmentproofurl;
	}	
	
	public String getLpmenifestremark() {
		return lpmenifestremark;
	}

	public void setLpmenifestremark(String lpmenifestremark) {
		this.lpmenifestremark = lpmenifestremark;
	}

	public String getLpmenifeststatus() {
		return lpmenifeststatus;
	}

	public void setLpmenifeststatus(String lpmenifeststatus) {
		this.lpmenifeststatus = lpmenifeststatus;
	}

	public Date getMenifestsentdate() {
		return menifestsentdate;
	}

	public void setMenifestsentdate(Date menifestsentdate) {
		this.menifestsentdate = menifestsentdate;
	}

	public String getIsmenifestsent() {
		return ismenifestsent;
	}

	public void setIsmenifestsent(String ismenifestsent) {
		this.ismenifestsent = ismenifestsent;
	}

	public String getIsShipExpress() {
		return isShipExpress;
	}

	public void setIsShipExpress(String isShipExpress) {
		this.isShipExpress = isShipExpress;
	}

	public  com.sellerportal.model.OctCouponBank getOctcouponbank() {
		return octcouponbank;
	}

	public void setOctcouponbank( com.sellerportal.model.OctCouponBank octcouponbank) {
		this.octcouponbank = octcouponbank;
	}

	public String getChildawbnum() {
		return childawbnum;
	}

	public void setChildawbnum(String childawbnum) {
		this.childawbnum = childawbnum;
	}

	public String getIschildmenifestsent() {
		return ischildmenifestsent;
	}

	public void setIschildmenifestsent(String ischildmenifestsent) {
		this.ischildmenifestsent = ischildmenifestsent;
	}

	public Date getChildmenifestsentdate() {
		return childmenifestsentdate;
	}

	public void setChildmenifestsentdate(Date childmenifestsentdate) {
		this.childmenifestsentdate = childmenifestsentdate;
	}

	public String getInfo14() {
		return info14;
	}

	public void setInfo14(String info14) {
		this.info14 = info14;
	}

	public String getInfo15() {
		return info15;
	}

	public void setInfo15(String info15) {
		this.info15 = info15;
	}

	public String getInfo16() {
		return info16;
	}

	public void setInfo16(String info16) {
		this.info16 = info16;
	}

	public String getInfo17() {
		return info17;
	}

	public void setInfo17(String info17) {
		this.info17 = info17;
	}

	public String getInfo18() {
		return info18;
	}

	public void setInfo18(String info18) {
		this.info18 = info18;
	}

	public String getInfo19() {
		return info19;
	}

	public void setInfo19(String info19) {
		this.info19 = info19;
	}

	public String getInfo20() {
		return info20;
	}

	public void setInfo20(String info20) {
		this.info20 = info20;
	}

	public String getInfo21() {
		return info21;
	}

	public void setInfo21(String info21) {
		this.info21 = info21;
	}

	public String getInfo22() {
		return info22;
	}

	public void setInfo22(String info22) {
		this.info22 = info22;
	}

	public String getInfo23() {
		return info23;
	}

	public void setInfo23(String info23) {
		this.info23 = info23;
	}

	public String getInfo24() {
		return info24;
	}

	public void setInfo24(String info24) {
		this.info24 = info24;
	}

	public String getInfo25() {
		return info25;
	}

	public void setInfo25(String info25) {
		this.info25 = info25;
	}

	public String getInfo26() {
		return info26;
	}

	public void setInfo26(String info26) {
		this.info26 = info26;
	}

	public String getInfo27() {
		return info27;
	}

	public void setInfo27(String info27) {
		this.info27 = info27;
	}

	public String getInfo28() {
		return info28;
	}

	public void setInfo28(String info28) {
		this.info28 = info28;
	}

	public String getInfo29() {
		return info29;
	}

	public void setInfo29(String info29) {
		this.info29 = info29;
	}

	public String getInfo30() {
		return info30;
	}

	public void setInfo30(String info30) {
		this.info30 = info30;
	}

	public String getInfo31() {
		return info31;
	}

	public void setInfo31(String info31) {
		this.info31 = info31;
	}

	public String getInfo32() {
		return info32;
	}

	public void setInfo32(String info32) {
		this.info32 = info32;
	}
	
	public String getInfo33() {
		return info33;
	}
	public void setInfo33(String info33) {
		this.info33 = info33;
	}
	
	public String getReadyDate() {
		return readyDate;
	}

	public void setReadyDate(String readyDate) {
		this.readyDate = readyDate;
	}

	public String getCompanyCloseTime() {
		return companyCloseTime;
	}

	public void setCompanyCloseTime(String companyCloseTime) {
		this.companyCloseTime = companyCloseTime;
	}

	public String getRCStatus() {
		return RCStatus;
	}

	public void setRCStatus(String rCStatus) {
		RCStatus = rCStatus;
	}

	public Set<Ismpst> getReverseIsmpsts() {
		return reverseIsmpsts;
	}

	public void setReverseIsmpsts(Set<Ismpst> reverseIsmpsts) {
		this.reverseIsmpsts = reverseIsmpsts;
	}

	public String getRCRemark() {
		return RCRemark;
	}

	public void setRCRemark(String rCRemark) {
		RCRemark = rCRemark;
	}

	public String getOrderCancelStatus() {
		return orderCancelStatus;
	}

	public void setOrderCancelStatus(String orderCancelStatus) {
		this.orderCancelStatus = orderCancelStatus;
	}

	public String getOrderCancelRemark() {
		return orderCancelRemark;
	}

	public void setOrderCancelRemark(String orderCancelRemark) {
		this.orderCancelRemark = orderCancelRemark;
	}

	public String getShipmentPaymentLink() {
		return shipmentPaymentLink;
	}

	public void setShipmentPaymentLink(String shipmentPaymentLink) {
		this.shipmentPaymentLink = shipmentPaymentLink;
	}
}