package com.sellerportal.model;

import javax.persistence.*;

@Entity
@Table(name = "GST_COMMPANY_ADDRESS")
public class GSTCompanyAddress {
	@Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence")
    @SequenceGenerator(name = "sequence", sequenceName = "GSTCOMPANY_GSTCOMADDRFNUM_SEQ", allocationSize = 1)
    @Column(name = "GSTCOMADDRFNUM")
    private Long gstcomaddrfnum;

    @Column(name = "TRANSACTIONID", nullable = false, length = 255)
    private String transactionID;

    @Column(name = "ADDRESSLINE1", length = 255)
    private String addressLine1;

    @Column(name = "ADDRESSLINE2", length = 255)
    private String addressLine2;

    @Column(name = "ADDRESSLINE3", length = 255)
    private String addressLine3;

    @Column(name = "PINCODE", length = 255)
    private String pinCode;

    @Column(name = "STATECODE", length = 20)
    private String stateCode;

	public Long getGstcomaddrfnum() {
		return gstcomaddrfnum;
	}

	public void setGstcomaddrfnum(Long gstcomaddrfnum) {
		this.gstcomaddrfnum = gstcomaddrfnum;
	}

	public String getAddressLine1() {
		return addressLine1;
	}

	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}

	public String getAddressLine2() {
		return addressLine2;
	}

	public void setAddressLine2(String addressLine2) {
		this.addressLine2 = addressLine2;
	}

	public String getAddressLine3() {
		return addressLine3;
	}

	public void setAddressLine3(String addressLine3) {
		this.addressLine3 = addressLine3;
	}

	public String getPinCode() {
		return pinCode;
	}

	public void setPinCode(String pinCode) {
		this.pinCode = pinCode;
	}

	public String getStateCode() {
		return stateCode;
	}

	public void setStateCode(String stateCode) {
		this.stateCode = stateCode;
	}

	public String getTransactionID() {
		return transactionID;
	}

	public void setTransactionID(String transactionID) {
		this.transactionID = transactionID;
	}

}
