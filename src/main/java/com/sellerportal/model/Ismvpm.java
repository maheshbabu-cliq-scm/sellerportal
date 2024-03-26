package com.sellerportal.model;

import java.io.Serializable;
import java.util.Date;

import org.apache.commons.lang.builder.ToStringBuilder;
import javax.persistence.*;

@Entity
@Table(name = "ISMVPM")
public class Ismvpm implements Serializable {

	@Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "vpmrfnum_sequence")
    @SequenceGenerator(name = "vpmrfnum_sequence", sequenceName = "ISMVPM_VPMRFNUM_SEQ", allocationSize = 1)
    @Column(name = "VPMRFNUM")
    private Long vpmrfnum;

    @Column(name = "VPMCREATEDATE", nullable = false)
    private Date vpmcreatedate;

    @Column(name = "VPMCREATEDBY", nullable = false)
    private Long vpmcreatedby;

    @Column(name = "VPMDELETED", nullable = false, length = 1)
    private String vpmdeleted;

    @Column(name = "VPMMODIDATE", nullable = false)
    private Date vpmmodidate;

    @Column(name = "VPMMODIFIEDBY", nullable = false)
    private Long vpmmodifiedby;

    @Column(name = "VPMPILSTOCKQTY", nullable = false)
    private Long vpmpilstockqty;

    @Column(name = "VPMSAFETYSTOCK", nullable = false)
    private Long vpmsafetystock;

    @Column(name = "ISSENT", length = 1)
    private String issent;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "VPMSLRPRODUCTRFNUM", nullable = false)
    private SlrProduct slrProduct;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "VPMSLVRFNUM", nullable = false)
    private OctSlv octslv;

    /** full constructor 
     * @param vpmcreatedate 
     * @param vpmcreatedby 
     * @param vpmdeleted 
     * @param vpmmodidate 
     * @param vpmpilstockqty 
     * @param ismpbi 
     * @param ismpil 
     * @param slrProduct 
     * @param octslv */
    public Ismvpm(Date vpmcreatedate, Long vpmcreatedby, String vpmdeleted, Date vpmmodidate, Long vpmpilstockqty,String issent, SlrProduct slrProduct, OctSlv octslv) {
        this.issent = issent;
    	this.vpmcreatedate = vpmcreatedate;
        this.vpmcreatedby = vpmcreatedby;
        this.vpmdeleted = vpmdeleted;
        this.vpmmodidate = vpmmodidate;
        this.vpmpilstockqty = vpmpilstockqty;
        this.slrProduct=slrProduct;
        this.octslv=octslv;
    }

    /** default constructor */
    public Ismvpm() {
    }

    /** minimal constructor */
    public Ismvpm(Date vpmcreatedate, Long vpmcreatedby, String vpmdeleted, Date vpmmodidate, Long vpmpilstockqty, Long vpmpilvirtualstockqty) {
        this.vpmcreatedate = vpmcreatedate;
        this.vpmcreatedby = vpmcreatedby;
        this.vpmdeleted = vpmdeleted;
        this.vpmmodidate = vpmmodidate;
        this.vpmpilstockqty = vpmpilstockqty;
       
    }

    /** 
     * 		       auto_increment
     * 		    
     */
    public Long getVpmrfnum() {
        return this.vpmrfnum;
    }

    public void setVpmrfnum(Long vpmrfnum) {
        this.vpmrfnum = vpmrfnum;
    }

    public Date getVpmcreatedate() {
        return this.vpmcreatedate;
    }

    public void setVpmcreatedate(Date vpmcreatedate) {
        this.vpmcreatedate = vpmcreatedate;
    }

    public Long getVpmcreatedby() {
        return this.vpmcreatedby;
    }

    public void setVpmcreatedby(Long vpmcreatedby) {
        this.vpmcreatedby = vpmcreatedby;
    }

    public String getVpmdeleted() {
        return this.vpmdeleted;
    }

    public void setVpmdeleted(String vpmdeleted) {
        this.vpmdeleted = vpmdeleted;
    }

    public Date getVpmmodidate() {
        return this.vpmmodidate;
    }

    public void setVpmmodidate(Date vpmmodidate) {
        this.vpmmodidate = vpmmodidate;
    }

    public Long getVpmpilstockqty() {
        return this.vpmpilstockqty;
    }

    public void setVpmpilstockqty(Long vpmpilstockqty) {
        this.vpmpilstockqty = vpmpilstockqty;
    }


    public String toString() {
        return new ToStringBuilder(this)
            .append("vpmrfnum", getVpmrfnum())
            .toString();
    }

//	public String getAdjMsg() {
//		return adjMsg;
//	}
//
//	public void setAdjMsg(String adjMsg) {
//		this.adjMsg = adjMsg;
//	}

	public com.sellerportal.model.SlrProduct getSlrProduct() {
		return slrProduct;
	}

	public void setSlrProduct(com.sellerportal.model.SlrProduct slrProduct) {
		this.slrProduct = slrProduct;
	}

	public Long getVpmsafetystock() {
		return vpmsafetystock;
	}

	public void setVpmsafetystock(Long vpmsafetystock) {
		this.vpmsafetystock = vpmsafetystock;
	}

	public Long getVpmmodifiedby() {
		return vpmmodifiedby;
	}

	public void setVpmmodifiedby(Long vpmmodifiedby) {
		this.vpmmodifiedby = vpmmodifiedby;
	}

	public com.sellerportal.model.OctSlv getOctslv() {
		return octslv;
	}

	public void setOctslv(com.sellerportal.model.OctSlv octslv) {
		this.octslv = octslv;
	}

	public String getIssent() {
		return issent;
	}

	public void setIssent(String issent) {
		this.issent = issent;
	}
	
}
