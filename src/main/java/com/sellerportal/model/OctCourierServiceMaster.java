package com.sellerportal.model;

import java.io.Serializable;
import java.util.Date;

import org.apache.commons.lang.builder.ToStringBuilder;
import javax.persistence.*;

@Entity
@Table(name = "OCT_COURIER_SERVICE_MASTER")
public class OctCourierServiceMaster implements Serializable {

	@Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "oct_courier_service_sequence")
    @SequenceGenerator(name = "oct_courier_service_sequence", sequenceName = "OCT_COURIER_SERVICE_SEQ", allocationSize = 1)
    @Column(name = "OCSMRFNUM")
    private Long ocsmrfnum;

    @Column(name = "OCSMFORNREQ", length = 1)
    private String ocsmfornreq;

    @Column(name = "OCSMRCODLIMIT", length = 24)
    private Double ocsmrcodlimit;

    @Column(name = "OCSMRCREATEDATE", nullable = false)
    private Date ocsmrcreatedate;

    @Column(name = "OCSMRCREATEDBY", nullable = false, length = 19)
    private Long ocsmrcreatedby;

    @Column(name = "OCSMRDELETED", nullable = false, length = 1)
    private String ocsmrdeleted;

    @Column(name = "OCSMRISACTIVE", nullable = false, length = 1)
    private String ocsmrisactive;

    @Column(name = "OCSMRISCOD", length = 1)
    private String ocsmriscod;

    @Column(name = "OCSMRISPREPAID", length = 1)
    private String ocsmrisprepaid;

    @Column(name = "OCSMRMODIDATE", nullable = false)
    private Date ocsmrmodidate;

    @Column(name = "OCSMRMODIFIEDBY", nullable = false, length = 19)
    private Long ocsmrmodifiedby;

    @Column(name = "OCSMRPREPAIDLIMIT", length = 24)
    private Double ocsmrprepaidlimit;

    @Column(name = "OCSMRTRNPINCODE", length = 1)
    private String ocsmrtrnpincode;

    @Column(name = "OCTSMCLOCTYPE", length = 100)
    private String octsmcloctype;

    @Column(name = "OCTSMCSCRCD", length = 100)
    private String octsmcscrcd;

    @Column(name = "OCTSMNEWZONE", length = 100)
    private String octsmnewzone;

    @Column(name = "OCTSMRCAREA", length = 100)
    private String octsmrcarea;

    @Column(name = "OCTSMTRANSITETATCOD", length = 24)
    private Long octsmtransitetatcod;

    @Column(name = "OCTSMTRANSITETATPREPAID", length = 24)
    private Long octsmtransitetatprepaid;

    @Column(name = "OCSMPICKUP", length = 100)
    private String ocsmpickup;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "OCSMRPINMSTRCRNUM", nullable = false)
    private IsmpincityMaster ismpincityMaster;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "OCSMROCRFNUM", nullable = false)
    private OctCourierMaster octCourierMaster;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "OCSMROCTPARAMTRANSPORTMODE", nullable = false)
    private OctParam octParamByOcsmroctparamtransportmode;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "DELIVERYMODE", nullable = false)
    private OctParam deliveryMode;

    /** full constructor 
     * @param deliveryMode */
    public OctCourierServiceMaster(String ocsmfornreq, Double ocsmrcodlimit, Date ocsmrcreatedate, Long ocsmrcreatedby, String ocsmrdeleted, String ocsmrisactive, String ocsmriscod, String ocsmrisprepaid, Date ocsmrmodidate, Long ocsmrmodifiedby, Double ocsmrprepaidlimit, String ocsmrtrnpincode, String octsmcloctype, String octsmcscrcd, String octsmnewzone, String octsmrcarea, Long octsmtransitetatcod, Long octsmtransitetatprepaid, com.sellerportal.model.IsmpincityMaster ismpincityMaster, com.sellerportal.model.OctCourierMaster octCourierMaster, com.sellerportal.model.OctParam octParamByOcsmroctparamtransportmode, OctParam deliveryMode) {
        this.ocsmfornreq = ocsmfornreq;
        this.ocsmrcodlimit = ocsmrcodlimit;
        this.ocsmrcreatedate = ocsmrcreatedate;
        this.ocsmrcreatedby = ocsmrcreatedby;
        this.ocsmrdeleted = ocsmrdeleted;
        this.ocsmrisactive = ocsmrisactive;
        this.ocsmriscod = ocsmriscod;
        this.ocsmrisprepaid = ocsmrisprepaid;
        this.ocsmrmodidate = ocsmrmodidate;
        this.ocsmrmodifiedby = ocsmrmodifiedby;
        this.ocsmrprepaidlimit = ocsmrprepaidlimit;
        this.ocsmrtrnpincode = ocsmrtrnpincode;
        this.octsmcloctype = octsmcloctype;
        this.octsmcscrcd = octsmcscrcd;
        this.octsmnewzone = octsmnewzone;
        this.octsmrcarea = octsmrcarea;
        this.octsmtransitetatcod = octsmtransitetatcod;
        this.octsmtransitetatprepaid = octsmtransitetatprepaid;
        this.ismpincityMaster = ismpincityMaster;
        this.octCourierMaster = octCourierMaster;
        this.octParamByOcsmroctparamtransportmode = octParamByOcsmroctparamtransportmode;
        this.deliveryMode=deliveryMode;
    }

    /** default constructor */
    public OctCourierServiceMaster() {
    }

    /** minimal constructor 
     * @param deliveryMode */
    public OctCourierServiceMaster(Date ocsmrcreatedate, Long ocsmrcreatedby, String ocsmrdeleted, String ocsmrisactive, Date ocsmrmodidate, Long ocsmrmodifiedby, com.sellerportal.model.IsmpincityMaster ismpincityMaster, com.sellerportal.model.OctCourierMaster octCourierMaster, com.sellerportal.model.OctParam octParamByOcsmroctparamdeliverytype, com.sellerportal.model.OctParam octParamByOcsmroctparamtransportmode, OctParam deliveryMode) {
        this.ocsmrcreatedate = ocsmrcreatedate;
        this.ocsmrcreatedby = ocsmrcreatedby;
        this.ocsmrdeleted = ocsmrdeleted;
        this.ocsmrisactive = ocsmrisactive;
        this.ocsmrmodidate = ocsmrmodidate;
        this.ocsmrmodifiedby = ocsmrmodifiedby;
        this.ismpincityMaster = ismpincityMaster;
        this.octCourierMaster = octCourierMaster;
        this.octParamByOcsmroctparamtransportmode = octParamByOcsmroctparamtransportmode;
        this.deliveryMode=deliveryMode;
    }

    public Long getOcsmrfnum() {
        return this.ocsmrfnum;
    }

    public void setOcsmrfnum(Long ocsmrfnum) {
        this.ocsmrfnum = ocsmrfnum;
    }

    public String getOcsmfornreq() {
        return this.ocsmfornreq;
    }

    public void setOcsmfornreq(String ocsmfornreq) {
        this.ocsmfornreq = ocsmfornreq;
    }
    
    public Double getOcsmrcodlimit() {
		return ocsmrcodlimit;
	}

	public void setOcsmrcodlimit(Double ocsmrcodlimit) {
		this.ocsmrcodlimit = ocsmrcodlimit;
	}

	public Date getOcsmrcreatedate() {
        return this.ocsmrcreatedate;
    }

    public void setOcsmrcreatedate(Date ocsmrcreatedate) {
        this.ocsmrcreatedate = ocsmrcreatedate;
    }

    public Long getOcsmrcreatedby() {
        return this.ocsmrcreatedby;
    }

    public void setOcsmrcreatedby(Long ocsmrcreatedby) {
        this.ocsmrcreatedby = ocsmrcreatedby;
    }

    public String getOcsmrdeleted() {
        return this.ocsmrdeleted;
    }

    public void setOcsmrdeleted(String ocsmrdeleted) {
        this.ocsmrdeleted = ocsmrdeleted;
    }

    public String getOcsmrisactive() {
        return this.ocsmrisactive;
    }

    public void setOcsmrisactive(String ocsmrisactive) {
        this.ocsmrisactive = ocsmrisactive;
    }

    public String getOcsmriscod() {
        return this.ocsmriscod;
    }

    public void setOcsmriscod(String ocsmriscod) {
        this.ocsmriscod = ocsmriscod;
    }

    public String getOcsmrisprepaid() {
        return this.ocsmrisprepaid;
    }

    public void setOcsmrisprepaid(String ocsmrisprepaid) {
        this.ocsmrisprepaid = ocsmrisprepaid;
    }

    public Date getOcsmrmodidate() {
        return this.ocsmrmodidate;
    }

    public void setOcsmrmodidate(Date ocsmrmodidate) {
        this.ocsmrmodidate = ocsmrmodidate;
    }

    public Long getOcsmrmodifiedby() {
        return this.ocsmrmodifiedby;
    }

    public void setOcsmrmodifiedby(Long ocsmrmodifiedby) {
        this.ocsmrmodifiedby = ocsmrmodifiedby;
    }

    public Double getOcsmrprepaidlimit() {
		return ocsmrprepaidlimit;
	}

	public void setOcsmrprepaidlimit(Double ocsmrprepaidlimit) {
		this.ocsmrprepaidlimit = ocsmrprepaidlimit;
	}

	public String getOcsmrtrnpincode() {
        return this.ocsmrtrnpincode;
    }

    public void setOcsmrtrnpincode(String ocsmrtrnpincode) {
        this.ocsmrtrnpincode = ocsmrtrnpincode;
    }

    public String getOctsmcloctype() {
        return this.octsmcloctype;
    }

    public void setOctsmcloctype(String octsmcloctype) {
        this.octsmcloctype = octsmcloctype;
    }

    public String getOctsmcscrcd() {
        return this.octsmcscrcd;
    }

    public void setOctsmcscrcd(String octsmcscrcd) {
        this.octsmcscrcd = octsmcscrcd;
    }

    public String getOctsmnewzone() {
        return this.octsmnewzone;
    }

    public void setOctsmnewzone(String octsmnewzone) {
        this.octsmnewzone = octsmnewzone;
    }

    public String getOctsmrcarea() {
        return this.octsmrcarea;
    }

    public void setOctsmrcarea(String octsmrcarea) {
        this.octsmrcarea = octsmrcarea;
    }

    public Long getOctsmtransitetatcod() {
        return this.octsmtransitetatcod;
    }

    public void setOctsmtransitetatcod(Long octsmtransitetatcod) {
        this.octsmtransitetatcod = octsmtransitetatcod;
    }

    public Long getOctsmtransitetatprepaid() {
        return this.octsmtransitetatprepaid;
    }

    public void setOctsmtransitetatprepaid(Long octsmtransitetatprepaid) {
        this.octsmtransitetatprepaid = octsmtransitetatprepaid;
    }

    public com.sellerportal.model.IsmpincityMaster getIsmpincityMaster() {
        return this.ismpincityMaster;
    }

    public void setIsmpincityMaster(com.sellerportal.model.IsmpincityMaster ismpincityMaster) {
        this.ismpincityMaster = ismpincityMaster;
    }

    public com.sellerportal.model.OctCourierMaster getOctCourierMaster() {
        return this.octCourierMaster;
    }

    public void setOctCourierMaster(com.sellerportal.model.OctCourierMaster octCourierMaster) {
        this.octCourierMaster = octCourierMaster;
    }


    public com.sellerportal.model.OctParam getOctParamByOcsmroctparamtransportmode() {
        return this.octParamByOcsmroctparamtransportmode;
    }

    public void setOctParamByOcsmroctparamtransportmode(com.sellerportal.model.OctParam octParamByOcsmroctparamtransportmode) {
        this.octParamByOcsmroctparamtransportmode = octParamByOcsmroctparamtransportmode;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("ocsmrfnum", getOcsmrfnum())
            .toString();
    }

	public com.sellerportal.model.OctParam getDeliveryMode() {
		return deliveryMode;
	}

	public void setDeliveryMode(com.sellerportal.model.OctParam deliveryMode) {
		this.deliveryMode = deliveryMode;
	}
	
	//@Avinash R2 merged
	public String getOcsmpickup() {
		return ocsmpickup;
	}

	public void setOcsmpickup(String ocsmpickup) {
		this.ocsmpickup = ocsmpickup;
	}

}
