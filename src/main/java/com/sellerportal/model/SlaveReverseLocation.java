/**
 * @author Negi Rohit 
 * Created On : 23 April 2018
 * TPR - 8280
 */
package com.sellerportal.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Entity
@Table(name = "OCT_SLV_REVERSE_LOCATION")
public class SlaveReverseLocation implements Serializable{

	/**
	 * 
	 */
	@Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "reverse_location_rfnum_seq")
    @SequenceGenerator(name = "reverse_location_rfnum_seq", sequenceName = "REVERSE_LOCATION_RFNUM_SEQ", allocationSize = 1)
    @Column(name = "SLVREVRFNUM")
    private Long slvrevrfnum;

    @Column(name = "CATNAME", length = 19)
    private String catName;

    @Column(name = "CATCODE", length = 1)
    private String catCode;

    @Column(name = "SLVCODE", length = 1)
    private String slvCode;

    @Column(name = "SLRCODE", length = 20)
    private String slrCode;

    @Column(name = "CREATEDATE")
    private Date createdate;

    @Column(name = "MODIDATE")
    private Date modidate;

    @ManyToOne
    @JoinColumn(name = "OCTSLVRFNUM", nullable = false)
    private OctSlv octSlv;

	public Long getSlvrevrfnum() {
		return slvrevrfnum;
	}

	public void setSlvrevrfnum(Long slvrevrfnum) {
		this.slvrevrfnum = slvrevrfnum;
	}

	public String getCatName() {
		return catName;
	}

	public void setCatName(String catName) {
		this.catName = catName;
	}

	public String getCatCode() {
		return catCode;
	}

	public void setCatCode(String catCode) {
		this.catCode = catCode;
	}

	public String getSlvCode() {
		return slvCode;
	}

	public void setSlvCode(String slvCode) {
		this.slvCode = slvCode;
	}

	public String getSlrCode() {
		return slrCode;
	}

	public void setSlrCode(String slrCode) {
		this.slrCode = slrCode;
	}

	public com.sellerportal.model.OctSlv getOctSlv() {
		return octSlv;
	}

	public void setOctSlv(com.sellerportal.model.OctSlv octSlv) {
		this.octSlv = octSlv;
	}
	
	public Date getCreatedate() {
		return createdate;
	}

	public void setCreatedate(Date createdate) {
		this.createdate = createdate;
	}

	public Date getModidate() {
		return modidate;
	}

	public void setModidate(Date modidate) {
		this.modidate = modidate;
	}
}
