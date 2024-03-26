package com.sellerportal.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Entity
@Table(name = "oct_pack")
public class OctPack implements Serializable {
	 
	@Id
	    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pack_sequence")
	    @SequenceGenerator(name = "pack_sequence", sequenceName = "OCT_PACK_PACKRFNUM_SEQ", allocationSize = 1)
	    @Column(name = "packrfnum")
	    private Long packrfnum;

	    @Column(name = "packid", nullable = false)
	    private Long packid;

	    @ManyToOne
	    @JoinColumn(name = "packstatus")
	    private OctParam packstatus;

	    @Column(name = "opendate")
	    private Date opendate;

	    @Column(name = "closedate")
	    private Date closedate;

	    @Column(name = "REAMARK", length = 250)
	    private String remark;

	    @Column(name = "LOCATION", length = 55)
	    private String location;

	    @Column(name = "EXPAIRYDATE")
	    private Date expairydate;

	    @Column(name = "ISACKNOWLDGE", length = 1)
	    private String acknowldge;

	    @Column(name = "COSTATUS", length = 10)
	    private String coStatus;

	    @Column(name = "SLRPACKID", length = 32)
	    private String slrpackid;

	    // Getters and setters
    
  //@Raju R2 Merged end

    /** full constructor */
    public OctPack(Long packrfnum, Long packid, OctParam packstatus, Date opendate, Date closedate,String packername,String remark ,Date expairydate,String acknowldge,String location,String coStatus) {
        this.packrfnum=packrfnum;
        this.packid=packid;
        this.packstatus=packstatus;
        this.opendate=opendate;
        this.closedate=closedate;
        this.remark=remark;
        this.expairydate=expairydate;
        this.acknowldge=acknowldge;
        this.location=location;
        this.coStatus=coStatus;
    }


	public OctPack() {
		
	}


	


	public Long getPackrfnum() {
		return packrfnum;
	}


	public void setPackrfnum(Long packrfnum) {
		this.packrfnum = packrfnum;
	}


	public Long getPackid() {
		return packid;
	}


	public void setPackid(Long packid) {
		this.packid = packid;
	}


	public OctParam getPackstatus() {
		return packstatus;
	}


	public void setPackstatus(OctParam packstatus) {
		this.packstatus = packstatus;
	}


	public Date getOpendate() {
		return opendate;
	}


	public void setOpendate(Date opendate) {
		this.opendate = opendate;
	}

	public String getRemark() {
		return remark;
	}


	public void setRemark(String remark) {
		this.remark = remark;
	}


	public Date getClosedate() {
		return closedate;
	}


	public void setClosedate(Date closedate) {
		this.closedate = closedate;
	}


	public String getLocation() {
		return location;
	}


	public void setLocation(String location) {
		this.location = location;
	}


	public String getAcknowldge() {
		return acknowldge;
	}


	public void setAcknowldge(String acknowldge) {
		this.acknowldge = acknowldge;
	}


	public String getCoStatus() {
		return coStatus;
	}


	public void setCoStatus(String coStatus) {
		this.coStatus = coStatus;
	}


	public Date getExpairydate() {
		return expairydate;
	}


	public void setExpairydate(Date expairydate) {
		this.expairydate = expairydate;
	}


	public String getSlrpackid() {
		return slrpackid;
	}


	public void setSlrpackid(String slrpackid) {
		this.slrpackid = slrpackid;
	}

	
	
	
	
    /** default constructor */

}
