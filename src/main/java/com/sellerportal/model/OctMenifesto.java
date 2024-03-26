package com.sellerportal.model;

import java.util.Date;
import java.util.Set;
import javax.persistence.*;

@Entity
@Table(name = "OCT_MENIFESTO")
public class OctMenifesto {

	@Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "menifesto_sequence")
    @SequenceGenerator(name = "menifesto_sequence", sequenceName = "MENIFESTO_MENIFESTORFNUM_SEQ", allocationSize = 1)
    @Column(name = "MENIFESTORFNUM")
    private Long menifestorfnum;

    @Column(name = "MENIFESTOPATH", length = 256)
    private String menifestopath;

    @Column(name = "CREATEDATE")
    private Date createdate;

    @Column(name = "CREATEDBY")
    private Long createdby;

    @Column(name = "DELETED", length = 1)
    private String deleted;

    @Column(name = "ISACTIVE", length = 1)
    private String isactive;

    @Column(name = "MODIDATE")
    private Date modidate;

    @Column(name = "MODIFIEDBY")
    private Long modifiedby;

    @Column(name = "SELLERMAPREFMENIFESTOID", length = 50)
    private String sellermaprefmenifestoid;

    @Column(name = "SELLERSHIPID", length = 20)
    private String sellershipid;

    @Column(name = "ISUPLOADED", length = 1)
    private String isuploaded;

    @Column(name = "UPLOADEDMENIFESTOPATH", length = 256)
    private String uploadedmenifestopath;

    @Column(name = "SCANNED_MENIFEST_DATE")
    private Date scannedMenifestDate;

    @Column(name = "UPLOADED_MENIFEST_DATE")
    private Date uploadedMenifestDate;

    @Column(name = "UPLOADEDMENIFESTTIME", length = 11)
    private String uploadedMenifestTime;

    @ManyToOne
    @JoinColumn(name = "MENIFESTOSTATUS")
    private OctParam menifestostatus;

    @OneToMany(mappedBy = "menifesto")
    @Transient
    private Set<OctShipment> shipments;
	
	/* For R2 gulab*/
	
	public Date getUploadedMenifestDate() {
		return uploadedMenifestDate;
	}

	public void setUploadedMenifestDate(Date uploadedMenifestDate) {
		this.uploadedMenifestDate = uploadedMenifestDate;
	}

	public Date getScannedMenifestDate() {
		return scannedMenifestDate;
	}

	public void setScannedMenifestDate(Date scannedMenifestDate) {
		this.scannedMenifestDate = scannedMenifestDate;
	}

//	private  com.sellerportal.model.OctParam menifestostatus;
//
//	private Set shipments;
//	private String invoicepath;

	/** full constructor 
	 * @param ismpsts */
	public OctMenifesto(String menifestopath,Date createdate, Long createdby, String deleted, String isactive, Date modidate, Long modifiedby,  com.sellerportal.model.OctParam menifestostatus,Set<OctShipment> shipments,String sellershipid ,String isuploaded) {
		this.menifestopath = menifestopath;
		this.createdate = createdate;
		this.createdby = createdby;
		this.deleted = deleted;
		this.isactive = isactive;
		this.modidate = modidate;
		this.modifiedby = modifiedby;
		this.menifestostatus = menifestostatus;
		this.shipments = shipments;
		this.sellershipid = sellershipid;
		this.isuploaded = isuploaded;
		
	}

	/** default constructor */
	public OctMenifesto() {
	}

	public Long getMenifestorfnum() {
		return menifestorfnum;
	}

	public void setMenifestorfnum(Long menifestorfnum) {
		this.menifestorfnum = menifestorfnum;
	}

	public String getMenifestopath() {
		return menifestopath;
	}

	public void setMenifestopath(String menifestopath) {
		this.menifestopath = menifestopath;
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

	public String getIsactive() {
		return isactive;
	}

	public void setIsactive(String isactive) {
		this.isactive = isactive;
	}

	public Date getModidate() {
		return modidate;
	}

	public void setModidate(Date modidate) {
		this.modidate = modidate;
	}

	public Long getModifiedby() {
		return modifiedby;
	}

	public void setModifiedby(Long modifiedby) {
		this.modifiedby = modifiedby;
	}

	public  com.sellerportal.model.OctParam getMenifestostatus() {
		return menifestostatus;
	}

	public void setMenifestostatus( com.sellerportal.model.OctParam menifestostatus) {
		this.menifestostatus = menifestostatus;
	}

	public Set<OctShipment> getShipments() {
		return shipments;
	}

	public void setShipments(Set<OctShipment> shipments) {
		this.shipments = shipments;
	}

	public String getSellershipid() {
		return sellershipid;
	}

	public void setSellershipid(String sellershipid) {
		this.sellershipid = sellershipid;
	}
	public String getSellermaprefmenifestoid() {
		return sellermaprefmenifestoid;
	}

	public void setSellermaprefmenifestoid(String sellermaprefmenifestoid) {
		this.sellermaprefmenifestoid = sellermaprefmenifestoid;
	}

	public String getIsuploaded() {
		return isuploaded;
	}

	public void setIsuploaded(String isuploaded) {
		this.isuploaded = isuploaded;
	}

	public String getUploadedmenifestopath() {
		return uploadedmenifestopath;
	}

	public void setUploadedmenifestopath(String uploadedmenifestopath) {
		this.uploadedmenifestopath = uploadedmenifestopath;
	}
//	public String getInvoicepath() {
//		return invoicepath;
//	}
//
//	public void setInvoicepath(String invoicepath) {
//		this.invoicepath = invoicepath;
//	}

	public String getUploadedMenifestTime() {
		return uploadedMenifestTime;
	}

	public void setUploadedMenifestTime(String uploadedMenifestTime) {
		this.uploadedMenifestTime = uploadedMenifestTime;
	}
	
	
}
