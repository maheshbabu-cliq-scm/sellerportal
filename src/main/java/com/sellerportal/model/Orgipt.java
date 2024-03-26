package com.sellerportal.model;

import java.io.Serializable;
import java.util.Date;

import org.apache.commons.lang3.builder.ToStringBuilder;
import javax.persistence.*;


@Entity
@Table(name = "ORGIPT")
public class Orgipt implements Serializable{
	
	 @Id
	    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ipt_seq")
	    @SequenceGenerator(name = "ipt_seq", sequenceName = "ORGIPT_IPTRFNUM_SEQ", allocationSize = 1)
	    @Column(name = "IPTRFNUM")
	    private Long iptrfnum;

	    @Column(name = "IPTNAME", nullable = false, length = 245)
	    private String iptname;

	    @Column(name = "CREATEDATE", nullable = false)
	    private Date createdate;

	    @Column(name = "CREATEDBY", length = 20)
	    private Long createdby;

	    @Column(name = "DELETED", length = 1)
	    private String deleted;

	    @Column(name = "IPTVALUE", nullable = false, length = 254)
	    private String iptvalue;

	    @Column(name = "MODIDATE", nullable = false)
	    private Date modidate;

    /** full constructor */
    public Orgipt(String iptname,Date createdate, Long createdby, String deleted, String iptvalue, Date modidate) {
    	this.iptname = iptname;
        this.createdate = createdate;
        this.createdby = createdby;
        this.deleted = deleted;
        this.iptvalue = iptvalue;
        this.modidate = modidate;
    }

    /** default constructor */
    public Orgipt() {
    }

    /** minimal constructor */
    public Orgipt(Date createdate, String iptvalue, Date modidate) {
        this.createdate = createdate;
        this.iptvalue = iptvalue;
        this.modidate = modidate;
    }

    public String getIptname() {
        return this.iptname;
    }

    public void setIptname(String iptname) {
        this.iptname = iptname;
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

    public String getIptvalue() {
        return this.iptvalue;
    }

    public void setIptvalue(String iptvalue) {
        this.iptvalue = iptvalue;
    }

    public Date getModidate() {
        return this.modidate;
    }

    public void setModidate(Date modidate) {
        this.modidate = modidate;
    }

    
    public Long getIptrfnum() {
		return iptrfnum;
	}

	public void setIptrfnum(Long iptrfnum) {
		this.iptrfnum = iptrfnum;
	}

	public String toString() {
        return new ToStringBuilder(this)
            .append("iptrfnum", getIptrfnum())
            .toString();
    }

}
