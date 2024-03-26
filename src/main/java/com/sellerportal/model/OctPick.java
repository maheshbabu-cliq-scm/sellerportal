package com.sellerportal.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;


@Entity
@Table(name = "oct_pick")
public class OctPick implements Serializable {
	 @Id
	    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pick_sequence")
	    @SequenceGenerator(name = "pick_sequence", sequenceName = "PICKRFNUM_AUTOINC_SEQ", allocationSize = 1)
	    @Column(name = "pickrfnum")
	    private Long pickrfnum;

	    @Column(name = "pickid", nullable = false)
	    private Long pickid;

	    @ManyToOne
	    @JoinColumn(name = "pickstatus")
	    private OctParam pickstatus;

	    @Column(name = "opendate")
	    private Date opendate;

	    @Column(name = "closedate")
	    private Date closedate;

	    @Column(name = "PICKERNAME", length = 30)
	    private String pickername;

	    @Column(name = "REAMARK", length = 250)
	    private String remark;
    

    /** full constructor */
    public OctPick(Long pickrfnum, Long pickid, OctParam pickstatus, Date opendate, Date closedate,String pickername,String remark ) {
        this.pickrfnum=pickrfnum;
        this.pickid=pickid;
        this.pickstatus=pickstatus;
        this.opendate=opendate;
        this.closedate=closedate;
        this.pickername=pickername;
        this.remark=remark;
    }

    /** default constructor */
    public OctPick() {
    }

	public Long getPickrfnum() {
		return pickrfnum;
	}

	public void setPickrfnum(Long pickrfnum) {
		this.pickrfnum = pickrfnum;
	}

	public Long getPickid() {
		return pickid;
	}

	public void setPickid(Long pickid) {
		this.pickid = pickid;
	}

	public OctParam getPickstatus() {
		return pickstatus;
	}

	public void setPickstatus(OctParam pickstatus) {
		this.pickstatus = pickstatus;
	}

	public Date getOpendate() {
		return opendate;
	}

	public void setOpendate(Date opendate) {
		this.opendate = opendate;
	}

	public Date getClosedate() {
		return closedate;
	}

	public void setClosedate(Date closedate) {
		this.closedate = closedate;
	}

	public String getPickername() {
		return pickername;
	}

	public void setPickername(String pickername) {
		this.pickername = pickername;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

}
