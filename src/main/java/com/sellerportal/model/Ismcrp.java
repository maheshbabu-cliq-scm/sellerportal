package com.sellerportal.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import org.apache.commons.lang.builder.ToStringBuilder;
import javax.persistence.*;

/** @author Hibernate CodeGenerator */
@Entity
@Table(name = "ISMCRP")
public class Ismcrp implements Serializable {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CRPRFNUM")
    private Long crprfnum;

    @Column(name = "CREATEDATE", nullable = false)
    private Date createdate;

    @Column(name = "CREATEDBY", length = 20, nullable = false)
    private Long createdby;

    @Column(name = "CRPARTICLEQTY", length = 3)
    private Byte crparticleqty;

    @Column(name = "CRPBATCHDATE", nullable = false)
    private Date crpbatchdate;

    @Column(name = "CRPBATCHID", length = 20, nullable = false)
    private Long crpbatchid;

    @Column(name = "CRPISDONE", length = 1, nullable = false)
    private String crpisdone;

    @Column(name = "CRPISEXCEPTION", length = 1, nullable = false)
    private String crpisexception;

    @Column(name = "CRPISPASSED", length = 1, nullable = false)
    private String crpispassed;

    @Column(name = "CRPITEMSIZE", length = 3, nullable = false)
    private String crpitemsize;

    @Column(name = "CRPNEWPOTRFNUM", length = 20)
    private Long crpnewpotrfnum;

    @Column(name = "CRPORDERAMOUNT", nullable = false, precision = 10, scale = 2)
    private BigDecimal crporderamount;

    @Column(name = "CRPPRODMRP", nullable = false, precision = 10, scale = 2)
    private BigDecimal crpprodmrp;

    @Column(name = "CRPPRODDISC", precision = 10, scale = 2)
    private BigDecimal crpproddisc;

    @Column(name = "CRPPILSKU", length = 7, nullable = false)
    private String crppilsku;

    @Column(name = "CRPCOMMENTS", length = 256)
    private String crpcomments;

    @Column(name = "CRPPOSORDERDATE", nullable = false)
    private Date crpposorderdate;

    @Column(name = "CRPPOTRFNUM", length = 20)
    private Long crppotrfnum;

    @Column(name = "CRPRCPTNUM", length = 20, nullable = false)
    private String crprcptnum;

    @Column(name = "CRPSSISHOPNO", length = 5, nullable = false)
    private String crpssishopno;

    @Column(name = "DELETED", length = 1, nullable = false)
    private String deleted;

    @Column(name = "MODIDATE", nullable = false)
    private Date modidate;

    @Column(name = "CRPCRTDSKU", length = 7)
    private String crpcrtdsku;

    @Column(name = "CRPCRTDSIZE", length = 2)
    private String crpcrtdsize;

    @Column(name = "CRPCRTDDATE")
    private Date crpcrtddate;

    @Column(name = "CRPSTOREDISC", precision = 10, scale = 2)
    private BigDecimal crpstoredisc;

    @Column(name = "CRPPILAMT", precision = 10, scale = 2)
    private BigDecimal crppilamount;

    @Column(name = "CRPCRTPRODMRP", precision = 10, scale = 2)
    private BigDecimal crpcrtprodmrp;

    @Column(name = "CRPCRTPRODDISC", precision = 10, scale = 2)
    private BigDecimal crpcrtproddisc;

    @Column(name = "CRPCRTORDERAMOUNT", precision = 10, scale = 2)
    private BigDecimal crpcrtorderamount;

    @Column(name = "CRPCUSTOMERID", length = 64)
    private String crpcustomerid;

    @Column(name = "CRPGCNUM", length = 64)
    private String crpgcnum;

    @Column(name = "CRPGCVALUE", precision = 10, scale = 2)
    private BigDecimal crpgcvalue;

    @Column(name = "CRPGVNUM", length = 64)
    private String crpgvnum;

    @Column(name = "CRPGVVALUE", precision = 10, scale = 2)
    private BigDecimal crpgvvalue;

    @Column(name = "CRPLYTPOINTS", length = 64)
    private String crplytpoints;

    @Column(name = "CRPLYTPOINTSVALUE", precision = 10, scale = 2)
    private BigDecimal crplytpointsvalue;

    @Column(name = "CRPPCNUM", length = 64)
    private String crppcnum;

    @Column(name = "CRPPCVALUE", precision = 10, scale = 2)
    private BigDecimal crppcvalue;

    @Column(name = "CRPSAN", length = 64)
    private String crpsan;

    @Column(name = "CRPSANDISC", precision = 10, scale = 2)
    private BigDecimal crpsandisc;

    @Column(name = "CRPSANVALUE", precision = 10, scale = 2)
    private BigDecimal crpsanvalue;

    @Column(name = "CRPSTOREACODE", length = 64)
    private String crpstoreacode;

    @ManyToOne
    @JoinColumn(name = "CRPCNDBATCHTYPE", nullable = false)
    private Ismcnd ismcndByCrpcndbatchtype;

    @ManyToOne
    @JoinColumn(name = "CRPCNDREMARK", nullable = false)
    private Ismcnd ismcndByCrpcndremark;
    
    @ManyToOne
    @JoinColumn(name = "CRPCNDREASON", nullable = false)
    private Ismcnd ismcndByCrpcndreason;

    @ManyToOne
    @JoinColumn(name = "CRPSMTSTATUS")
    private Ismsmt ismsmt;

    /** full constructor */
    public Ismcrp(Date createdate, Long createdby, Byte crparticleqty, Date crpbatchdate, Long crpbatchid, String crpisdone, String crpisexception, String crpispassed, String crpitemsize, Long crpnewpotrfnum, BigDecimal crporderamount, BigDecimal crpprodmrp, BigDecimal crpproddisc, String crppilsku, String crpcomments, Date crpposorderdate, Long crppotrfnum, String crprcptnum, String crpssishopno, String deleted, Date modidate,Date crpcrtddate,BigDecimal crpstoredisc,String crpcrtdsize,String crpcrtdsku,BigDecimal crppilamount,BigDecimal crpcrtprodmrp,BigDecimal crpcrtproddisc,BigDecimal crpcrtorderamount,com.sellerportal.model.Ismcnd ismcndByCrpcndbatchtype, com.sellerportal.model.Ismcnd ismcndByCrpcndremark, com.sellerportal.model.Ismcnd ismcndByCrpcndreason, com.sellerportal.model.Ismsmt ismsmt, String crpcustomerid, String crpgcnum, BigDecimal crpgcvalue, String crpgvnum, BigDecimal crpgvvalue, String crplytpoints, BigDecimal crplytpointsvalue, String crppcnum, BigDecimal crppcvalue, String crpsan, BigDecimal crpsandisc, BigDecimal crpsanvalue, String crpstoreacode) {
        this.createdate = createdate;
        this.createdby = createdby;
        this.crparticleqty = crparticleqty;
        this.crpbatchdate = crpbatchdate;
        this.crpbatchid = crpbatchid;
        this.crpisdone = crpisdone;
        this.crpisexception = crpisexception;
        this.crpispassed = crpispassed;
        this.crpitemsize = crpitemsize;
        this.crpnewpotrfnum = crpnewpotrfnum;
        this.crporderamount = crporderamount;
        this.crpprodmrp = crpprodmrp;
        this.crpproddisc = crpproddisc;
        this.crppilsku = crppilsku;
        this.crpcomments = crpcomments;
        this.crpposorderdate = crpposorderdate;
        this.crppotrfnum = crppotrfnum;
        this.crprcptnum = crprcptnum;
        this.crpssishopno = crpssishopno;
        this.deleted = deleted;
        this.modidate = modidate;
        this.crpcrtdsize=crpcrtdsize;
        this.crpcrtdsku=crpcrtdsku;
        this.crpstoredisc=crpstoredisc;
        this.crpcrtorderamount=crpcrtorderamount;       
        this.crpcrtddate=crpcrtddate;
        this.ismcndByCrpcndbatchtype = ismcndByCrpcndbatchtype;
        this.ismcndByCrpcndremark = ismcndByCrpcndremark;
        this.ismcndByCrpcndreason = ismcndByCrpcndreason;
        this.ismsmt = ismsmt;
        this.crppilamount = crppilamount;
        this.crpcrtprodmrp = crpcrtprodmrp;
        this.crpcrtproddisc = crpcrtproddisc;
        this.crpcustomerid = crpcustomerid;
        this.crpgcnum = crpgcnum;
        this.crpgcvalue = crpgcvalue;
        this.crpgvnum = crpgvnum;
        this.crpgvvalue = crpgvvalue;        
        this.crplytpoints = crplytpoints;
        this.crplytpointsvalue = crplytpointsvalue;        
        this.crppcnum = crppcnum;
        this.crppcvalue = crppcvalue;        
        this.crpsan = crpsan;
        this.crpsandisc = crpsandisc;
        this.crpsanvalue = crpsanvalue;        
        this.crpstoreacode = crpstoreacode;
    }

    /** default constructor */
    public Ismcrp() {
    }

    /** minimal constructor */
    public Ismcrp(Date createdate, Long createdby, Date crpbatchdate, Long crpbatchid, String crpisdone, String crpisexception, String crpispassed, String crpitemsize, BigDecimal crporderamount, BigDecimal crpprodmrp, BigDecimal crpproddisc, String crppilsku, String crpcomments, Date crpposorderdate, String crprcptnum, String crpssishopno, String deleted, Date modidate,Date crpcrtddate,BigDecimal crpstoredisc,String crpcrtdsize,String crpcrtdsku,BigDecimal crpcrtprodmrp,BigDecimal crpcrtproddisc,BigDecimal crpcrtorderamount,com.sellerportal.model.Ismcnd ismcndByCrpcndbatchtype, com.sellerportal.model.Ismcnd ismcndByCrpcndremark, com.sellerportal.model.Ismcnd ismcndByCrpcndreason, com.sellerportal.model.Ismsmt ismsmt, String crpcustomerid, String crpgcnum, BigDecimal crpgcvalue, String crpgvnum, BigDecimal crpgvvalue, String crplytpoints, BigDecimal crplytpointsvalue, String crppcnum, BigDecimal crppcvalue, String crpsan, BigDecimal crpsandisc, BigDecimal crpsanvalue, String crpstoreacode) {
        this.createdate = createdate;
        this.createdby = createdby;
        this.crpbatchdate = crpbatchdate;
        this.crpbatchid = crpbatchid;
        this.crpisdone = crpisdone;
        this.crpisexception = crpisexception;
        this.crpispassed = crpispassed;
        this.crpitemsize = crpitemsize;
        this.crporderamount = crporderamount;
        this.crpprodmrp = crpprodmrp;
        this.crpproddisc = crpproddisc;
        this.crppilsku = crppilsku;
        this.crpcomments = crpcomments;
        this.crpposorderdate = crpposorderdate;
        this.crprcptnum = crprcptnum;
        this.crpssishopno = crpssishopno;
        this.deleted = deleted;
        this.modidate = modidate;
        this.crpcrtdsize=crpcrtdsize;
        this.crpcrtdsku=crpcrtdsku;
        this.crpstoredisc=crpstoredisc;        
        this.crpcrtprodmrp=crpcrtprodmrp;
        this.crpcrtproddisc=crpcrtproddisc;
        this.crpcrtorderamount=crpcrtorderamount;        
        this.crpcrtddate=crpcrtddate;
        this.ismcndByCrpcndbatchtype = ismcndByCrpcndbatchtype;
        this.ismcndByCrpcndremark = ismcndByCrpcndremark;
        this.ismcndByCrpcndreason = ismcndByCrpcndreason;
        this.ismsmt = ismsmt;
        this.crpcustomerid = crpcustomerid;
        this.crpgcnum = crpgcnum;
        this.crpgcvalue = crpgcvalue;
        this.crpgvnum = crpgvnum;
        this.crpgvvalue = crpgvvalue;        
        this.crplytpoints = crplytpoints;
        this.crplytpointsvalue = crplytpointsvalue;        
        this.crppcnum = crppcnum;
        this.crppcvalue = crppcvalue;        
        this.crpsan = crpsan;
        this.crpsandisc = crpsandisc;
        this.crpsanvalue = crpsanvalue;        
        this.crpstoreacode = crpstoreacode;
    }

    /** 
     * 		       auto_increment
     * 		    
     */
    public Long getCrprfnum() {
        return this.crprfnum;
    }

    public void setCrprfnum(Long crprfnum) {
        this.crprfnum = crprfnum;
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

    public Byte getCrparticleqty() {
        return this.crparticleqty;
    }

    public void setCrparticleqty(Byte crparticleqty) {
        this.crparticleqty = crparticleqty;
    }

    public Date getCrpbatchdate() {
        return this.crpbatchdate;
    }

    public void setCrpbatchdate(Date crpbatchdate) {
        this.crpbatchdate = crpbatchdate;
    }

    public Long getCrpbatchid() {
        return this.crpbatchid;
    }

    public void setCrpbatchid(Long crpbatchid) {
        this.crpbatchid = crpbatchid;
    }

    public String getCrpisdone() {
        return this.crpisdone;
    }

    public void setCrpisdone(String crpisdone) {
        this.crpisdone = crpisdone;
    }

    public String getCrpisexception() {
        return this.crpisexception;
    }

    public void setCrpisexception(String crpisexception) {
        this.crpisexception = crpisexception;
    }

    public String getCrpispassed() {
        return this.crpispassed;
    }

    public void setCrpispassed(String crpispassed) {
        this.crpispassed = crpispassed;
    }

    public String getCrpitemsize() {
        return this.crpitemsize;
    }

    public void setCrpitemsize(String crpitemsize) {
        this.crpitemsize = crpitemsize;
    }

    public Long getCrpnewpotrfnum() {
        return this.crpnewpotrfnum;
    }

    public void setCrpnewpotrfnum(Long crpnewpotrfnum) {
        this.crpnewpotrfnum = crpnewpotrfnum;
    }

    public BigDecimal getCrporderamount() {
        return this.crporderamount;
    }

    public void setCrporderamount(BigDecimal crporderamount) {
        this.crporderamount = crporderamount;
    }

    public String getCrppilsku() {
        return this.crppilsku;
    }

    public void setCrppilsku(String crppilsku) {
        this.crppilsku = crppilsku;
    }

    public Date getCrpposorderdate() {
        return this.crpposorderdate;
    }

    public void setCrpposorderdate(Date crpposorderdate) {
        this.crpposorderdate = crpposorderdate;
    }

    public Long getCrppotrfnum() {
        return this.crppotrfnum;
    }

    public void setCrppotrfnum(Long crppotrfnum) {
        this.crppotrfnum = crppotrfnum;
    }

    public String getCrprcptnum() {
        return this.crprcptnum;
    }

    public void setCrprcptnum(String crprcptnum) {
        this.crprcptnum = crprcptnum;
    }

    public String getCrpssishopno() {
        return this.crpssishopno;
    }

    public void setCrpssishopno(String crpssishopno) {
        this.crpssishopno = crpssishopno;
    }

    public String getDeleted() {
        return this.deleted;
    }

    public void setDeleted(String deleted) {
        this.deleted = deleted;
    }

    public Date getModidate() {
        return this.modidate;
    }

    public void setModidate(Date modidate) {
        this.modidate = modidate;
    }

    public com.sellerportal.model.Ismcnd getIsmcndByCrpcndbatchtype() {
        return this.ismcndByCrpcndbatchtype;
    }

    public void setIsmcndByCrpcndbatchtype(com.sellerportal.model.Ismcnd ismcndByCrpcndbatchtype) {
        this.ismcndByCrpcndbatchtype = ismcndByCrpcndbatchtype;
    }

    public com.sellerportal.model.Ismcnd getIsmcndByCrpcndremark() {
        return this.ismcndByCrpcndremark;
    }

    public void setIsmcndByCrpcndremark(com.sellerportal.model.Ismcnd ismcndByCrpcndremark) {
        this.ismcndByCrpcndremark = ismcndByCrpcndremark;
    }

    public com.sellerportal.model.Ismcnd getIsmcndByCrpcndreason() {
        return this.ismcndByCrpcndreason;
    }

    public void setIsmcndByCrpcndreason(com.sellerportal.model.Ismcnd ismcndByCrpcndreason) {
        this.ismcndByCrpcndreason = ismcndByCrpcndreason;
    }

    public com.sellerportal.model.Ismsmt getIsmsmt() {
        return this.ismsmt;
    }

    public void setIsmsmt(com.sellerportal.model.Ismsmt ismsmt) {
        this.ismsmt = ismsmt;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("crprfnum", getCrprfnum())
            .toString();
    }

	public String getCrpcomments() {
		return crpcomments;
	}

	public void setCrpcomments(String crpcomments) {
		this.crpcomments = crpcomments;
	}

	/**
	 * @return Returns the crpcrtdsize.
	 */
	public String getCrpcrtdsize() {
		return crpcrtdsize;
	}

	/**
	 * @param crpcrtdsize The crpcrtdsize to set.
	 */
	public void setCrpcrtdsize(String crpcrtdsize) {
		this.crpcrtdsize = crpcrtdsize;
	}

	/**
	 * @return Returns the crpcrtdsku.
	 */
	public String getCrpcrtdsku() {
		return crpcrtdsku;
	}

	/**
	 * @param crpcrtdsku The crpcrtdsku to set.
	 */
	public void setCrpcrtdsku(String crpcrtdsku) {
		this.crpcrtdsku = crpcrtdsku;
	}

	/**
	 * @return Returns the crpstoredisc.
	 */
	public BigDecimal getCrpstoredisc() {
		return crpstoredisc;
	}

	/**
	 * @param crpstoredisc The crpstoredisc to set.
	 */
	public void setCrpstoredisc(BigDecimal crpstoredisc) {
		this.crpstoredisc = crpstoredisc;
	}

	
	/**
	 * @return Returns the crpcrtddate.
	 */
	public Date getCrpcrtddate() {
		return crpcrtddate;
	}

	/**
	 * @param crpcrtddate The crpcrtddate to set.
	 */
	public void setCrpcrtddate(Date crpcrtddate) {
		this.crpcrtddate = crpcrtddate;
	}

	public BigDecimal getCrppilamount() {
		return crppilamount;
	}

	public void setCrppilamount(BigDecimal crppilamount) {
		this.crppilamount = crppilamount;
	}

	/**
	 * @return the crpcrtproddisc
	 */
	public BigDecimal getCrpcrtproddisc() {
		return crpcrtproddisc;
	}

	/**
	 * @param crpcrtproddisc the crpcrtproddisc to set
	 */
	public void setCrpcrtproddisc(BigDecimal crpcrtproddisc) {
		this.crpcrtproddisc = crpcrtproddisc;
	}

	/**
	 * @return the crpcrtprodmrp
	 */
	public BigDecimal getCrpcrtprodmrp() {
		return crpcrtprodmrp;
	}

	/**
	 * @param crpcrtprodmrp the crpcrtprodmrp to set
	 */
	public void setCrpcrtprodmrp(BigDecimal crpcrtprodmrp) {
		this.crpcrtprodmrp = crpcrtprodmrp;
	}

	/**
	 * @return the crpproddisc
	 */
	public BigDecimal getCrpproddisc() {
		return crpproddisc;
	}

	/**
	 * @param crpproddisc the crpproddisc to set
	 */
	public void setCrpproddisc(BigDecimal crpproddisc) {
		this.crpproddisc = crpproddisc;
	}

	/**
	 * @return the crpprodmrp
	 */
	public BigDecimal getCrpprodmrp() {
		return crpprodmrp;
	}

	/**
	 * @param crpprodmrp the crpprodmrp to set
	 */
	public void setCrpprodmrp(BigDecimal crpprodmrp) {
		this.crpprodmrp = crpprodmrp;
	}

	/**
	 * @return the crpcrtorderamount
	 */
	public BigDecimal getCrpcrtorderamount() {
		return crpcrtorderamount;
	}

	/**
	 * @param crpcrtorderamount the crpcrtorderamount to set
	 */
	public void setCrpcrtorderamount(BigDecimal crpcrtorderamount) {
		this.crpcrtorderamount = crpcrtorderamount;
	}

	/**
	 * @return the crpcustomerid
	 */
	public String getCrpcustomerid() {
		return crpcustomerid;
	}

	/**
	 * @param crpcustomerid the crpcustomerid to set
	 */
	public void setCrpcustomerid(String crpcustomerid) {
		this.crpcustomerid = crpcustomerid;
	}

	/**
	 * @return the crpgcnum
	 */
	public String getCrpgcnum() {
		return crpgcnum;
	}

	/**
	 * @param crpgcnum the crpgcnum to set
	 */
	public void setCrpgcnum(String crpgcnum) {
		this.crpgcnum = crpgcnum;
	}

	/**
	 * @return the crpgcvalue
	 */
	public BigDecimal getCrpgcvalue() {
		return crpgcvalue;
	}

	/**
	 * @param crpgcvalue the crpgcvalue to set
	 */
	public void setCrpgcvalue(BigDecimal crpgcvalue) {
		this.crpgcvalue = crpgcvalue;
	}

	/**
	 * @return the crpgvnum
	 */
	public String getCrpgvnum() {
		return crpgvnum;
	}

	/**
	 * @param crpgvnum the crpgvnum to set
	 */
	public void setCrpgvnum(String crpgvnum) {
		this.crpgvnum = crpgvnum;
	}

	/**
	 * @return the crpgvvalue
	 */
	public BigDecimal getCrpgvvalue() {
		return crpgvvalue;
	}

	/**
	 * @param crpgvvalue the crpgvvalue to set
	 */
	public void setCrpgvvalue(BigDecimal crpgvvalue) {
		this.crpgvvalue = crpgvvalue;
	}

	/**
	 * @return the crplytpoints
	 */
	public String getCrplytpoints() {
		return crplytpoints;
	}

	/**
	 * @param crplytpoints the crplytpoints to set
	 */
	public void setCrplytpoints(String crplytpoints) {
		this.crplytpoints = crplytpoints;
	}

	/**
	 * @return the crplytpointsvalue
	 */
	public BigDecimal getCrplytpointsvalue() {
		return crplytpointsvalue;
	}

	/**
	 * @param crplytpointsvalue the crplytpointsvalue to set
	 */
	public void setCrplytpointsvalue(BigDecimal crplytpointsvalue) {
		this.crplytpointsvalue = crplytpointsvalue;
	}

	/**
	 * @return the crppcnum
	 */
	public String getCrppcnum() {
		return crppcnum;
	}

	/**
	 * @param crppcnum the crppcnum to set
	 */
	public void setCrppcnum(String crppcnum) {
		this.crppcnum = crppcnum;
	}

	/**
	 * @return the crppcvalue
	 */
	public BigDecimal getCrppcvalue() {
		return crppcvalue;
	}

	/**
	 * @param crppcvalue the crppcvalue to set
	 */
	public void setCrppcvalue(BigDecimal crppcvalue) {
		this.crppcvalue = crppcvalue;
	}

	/**
	 * @return the crpsan
	 */
	public String getCrpsan() {
		return crpsan;
	}

	/**
	 * @param crpsan the crpsan to set
	 */
	public void setCrpsan(String crpsan) {
		this.crpsan = crpsan;
	}

	/**
	 * @return the crpsandisc
	 */
	public BigDecimal getCrpsandisc() {
		return crpsandisc;
	}

	/**
	 * @param crpsandisc the crpsandisc to set
	 */
	public void setCrpsandisc(BigDecimal crpsandisc) {
		this.crpsandisc = crpsandisc;
	}

	/**
	 * @return the crpsanvalue
	 */
	public BigDecimal getCrpsanvalue() {
		return crpsanvalue;
	}

	/**
	 * @param crpsanvalue the crpsanvalue to set
	 */
	public void setCrpsanvalue(BigDecimal crpsanvalue) {
		this.crpsanvalue = crpsanvalue;
	}

	/**
	 * @return the crpstoreacode
	 */
	public String getCrpstoreacode() {
		return crpstoreacode;
	}

	/**
	 * @param crpstoreacode the crpstoreacode to set
	 */
	public void setCrpstoreacode(String crpstoreacode) {
		this.crpstoreacode = crpstoreacode;
	}
	

}
