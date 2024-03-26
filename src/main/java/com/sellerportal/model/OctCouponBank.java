package com.sellerportal.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Entity
@Table(name = "OCT_COUPON_BANK")
public class OctCouponBank implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "oct_coupon_bank_sequence")
    @SequenceGenerator(name = "oct_coupon_bank_sequence", sequenceName = "OCT_COUPON_BANK_SEQ", allocationSize = 1)
    @Column(name = "OCBRFNUM")
    private Long ocbrfnum;

    @Column(name = "COUPONCODE", length = 200)
    private String couponcode;

    @Column(name = "CREATEDATE", nullable = false)
    private Date createdate;

    @Column(name = "CREATEDBY", nullable = false, length = 20)
    private Long createdby;

    @Column(name = "DELETED", nullable = false, length = 1)
    private String deleted;

    @Column(name = "ISUSED", length = 1)
    private String isused;

    @Column(name = "MODIDATE", nullable = false)
    private Date modidate;

    @Column(name = "MODIFIEDBY", nullable = false, length = 20)
    private Long modifiedby;

    @Column(name = "AMOUNT", length = 10)
    private String amount;

    @Column(name = "BRAND", length = 200)
    private String brand;

    @Column(name = "ISACTIVE", nullable = false, length = 1)
    private String isactive;

 

	/** full constructor */
    public OctCouponBank(String couponcode, Date createdate, Long createdby, String deleted, String isused, Date modidate, Long modifiedby,String amount,String brand,String isactive) {
        this.couponcode = couponcode;
        this.createdate = createdate;
        this.createdby = createdby;
        this.deleted = deleted;
        this.isused = isused;
        this.modidate = modidate;
        this.modifiedby = modifiedby;
        this.amount = amount;
        this.brand = brand;
        this.isactive=isactive;
    }

    /** default constructor */
    public OctCouponBank() {
    }

    /** minimal constructor */
    public OctCouponBank(Date createdate, Long createdby, String deleted, Date modidate, Long modifiedby) {
        this.createdate = createdate;
        this.createdby = createdby;
        this.deleted = deleted;
        this.modidate = modidate;
        this.modifiedby = modifiedby;
       
    }

	public Long getOcbrfnum() {
		return ocbrfnum;
	}

	public void setOcbrfnum(Long ocbrfnum) {
		this.ocbrfnum = ocbrfnum;
	}

	public String getCouponcode() {
		return couponcode;
	}

	public void setCouponcode(String couponcode) {
		this.couponcode = couponcode;
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

	public String getIsused() {
		return isused;
	}

	public void setIsused(String isused) {
		this.isused = isused;
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

	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getIsactive() {
		return isactive;
	}

	public void setIsactive(String isactive) {
		this.isactive = isactive;
	}


    

}
