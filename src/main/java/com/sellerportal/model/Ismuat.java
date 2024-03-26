package com.sellerportal.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import org.apache.commons.lang3.builder.ToStringBuilder;
import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "ISMUAT")
public class Ismuat implements Serializable,Cloneable {

	@Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ismuat_sequence")
    @SequenceGenerator(name = "ismuat_sequence", sequenceName = "ISMUAT_UATRFNUM_SEQ", allocationSize = 1)
    @Column(name = "UATRFNUM")
    private Long uatrfnum;
    private String extension;
    
    @Column(name = "CREATEDATE", nullable = false)
    private Date createdate;

    @Column(name = "CREATEDBY", nullable = false)
    private Long createdby;

    @Column(name = "DELETED", nullable = false, length = 1)
    private String deleted;

    @Column(name = "MODIDATE", nullable = false)
    private Date modidate;

    @Column(name = "UATACTIVE", length = 1)
    private String uatactive;

    @Column(name = "UATADDR1", length = 254)
    private String uataddr1;

    @Column(name = "UATADDR2", length = 254)
    private String uataddr2;
    /** nullable persistent field */
//    private String uataddr3;
//
//    /** nullable persistent field */
//    private String uatcallerno;

    @Column(name = "UATEMAIL", length = 128)
    private String uatemail;

//    /** nullable persistent field */
//    private String uatemail2;

    @Column(name = "UATFAX", length = 16)
    private String uatfax;

    @Column(name = "UATFNAME", length = 128)
    private String uatfname;

//    /** persistent field */
//    private String uatisbilling;
//
//    /** persistent field */
//    private String uatiscompany;
//
//    /** persistent field */
//    private String uatispickup;
//
//    /** persistent field */
//    private String uatisshipping;

    @Column(name = "UATLNAME", length = 128)
    private String uatlname;

    @Column(name = "UATMNAME", length = 128)
    private String uatmname;

    @Column(name = "UATMOBILE", length = 16)
    private String uatmobile;

//    /** nullable persistent field */
//    private String uatothercity;
//
//    /** nullable persistent field */
//    private String uatotherstate;

    @Column(name = "UATPHONE", length = 16)
    private String uatphone;

    @Column(name = "UATZIP", length = 10)
    private String uatzip;

//    /** nullable persistent field */
//    private String uattitle;
//    
//    /** persistent field */
//    private String uatispreffered;

//    /** persistent field */
//    private com.sellerportal.model.Ismcnd ismcndByUatcndtitle;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "UATUBIRFNUM", nullable = false)
    private Ismubi ismubi;

//    /** persistent field */
//    private Set ismscls;

//    @OneToMany(mappedBy = "ismuat", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
//    @JoinColumn(name = "PBIUATRFNUM") // Assuming PBIUATRFNUM is the foreign key column in Ismpbi
//    private Set<Ismpbi> ismpbis;

    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "UATSTATEMASTER", nullable = false)
    private StateMaster stateMaster;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "UATCOUNTRYMASTER", nullable = false)
    private CountryMaster countryMaster;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "UATCITYMASTER", nullable = false)
    private CityMaster cityMaster;
    
    @Column(name = "UATAREA", length = 10)
    private String uatarea;
    
    @Column(name = "ISCORPADDR", length = 1)
    private String iscorpaddr;
    
    @Column(name = "ISRETURNADD", length = 1)
    private String isreturnadd;

    @Column(name = "UATISPROCESSED", length = 1)
    private String uatisprocessed;

    @Column(name = "UATISAPPROVED", length = 1)
    private String uatisapproved;
    
    
    /** full constructor */
    public Ismuat(Date createdate, Long createdby, String deleted, Date modidate, String uatactive, String uataddr1, String uataddr2, String uataddr3, String uatcallerno, String uatemail1, String uatemail2, String uatfax, String uatfname, String uatisbilling, String uatiscompany, String uatispickup, String uatisshipping, String uatlname, String uatmname, String uatmobile, String uatothercity, String uatotherstate, String uatphone, String uatphone2, String uattitle, String uatzip,String uatispreffered, com.sellerportal.model.Ismcnd ismcndByUatcndtitle, com.sellerportal.model.Ismcnd ismcndByUatcndcountry, com.sellerportal.model.Ismcnd ismcndByUatcndcity, com.sellerportal.model.Ismcnd ismcndByUatcndstate, com.sellerportal.model.Ismubi ismubi, Set ismscls, Set ismpbis,com.sellerportal.model.StateMaster stateMaster,com.sellerportal.model.CountryMaster countryMaster,com.sellerportal.model.CityMaster cityMaster, String uatarea, String iscorpaddr,String isreturnadd,String uatemail,String uatisprocessed,String uatisapproved) {
        this.createdate = createdate;
        this.createdby = createdby;
        this.deleted = deleted;
        this.modidate = modidate;
        this.uatactive = uatactive;
        this.uataddr1 = uataddr1;
        this.uataddr2 = uataddr2;
//        this.uataddr3 = uataddr3;
//        this.uatcallerno = uatcallerno;
        this.uatemail = uatemail;
//        this.uatemail2 = uatemail2;
        this.uatfax = uatfax;
        this.uatfname = uatfname;
//        this.uatisbilling = uatisbilling;
//        this.uatiscompany = uatiscompany;
//        this.uatispickup = uatispickup;
//        this.uatisshipping = uatisshipping;
        this.uatlname = uatlname;
        this.uatmname = uatmname;
        this.uatmobile = uatmobile;
//        this.uatothercity = uatothercity;
//        this.uatotherstate = uatotherstate;
        this.uatphone = uatphone;
//        this.uatphone2 = uatphone2;
//        this.uattitle = uattitle;
        this.uatzip = uatzip;
//        this.uatispreffered = uatispreffered;
//        this.ismcndByUatcndtitle = ismcndByUatcndtitle;
        this.ismubi = ismubi;
//        this.ismscls = ismscls;
//        this.ismpbis = ismpbis;
        this.countryMaster = countryMaster;
        this.stateMaster = stateMaster;
        this.countryMaster = countryMaster;
        this.uatarea = uatarea;
        this.iscorpaddr = iscorpaddr;
        this.isreturnadd = isreturnadd;
        this.uatisapproved = uatisapproved;
        this.uatisprocessed = uatisprocessed;
    }

    /** default constructor */
    public Ismuat() {
    }
    
    /** minimal constructor */
    public Ismuat(Date createdate, Long createdby, String deleted, Date modidate, String uataddr1, String uatfname, String uatisbilling, String uatiscompany, String uatispickup, String uatisshipping, String uatlname, String uatzip, com.sellerportal.model.Ismcnd ismcndByUatcndtitle, com.sellerportal.model.Ismcnd ismcndByUatcndcountry, com.sellerportal.model.Ismcnd ismcndByUatcndcity, com.sellerportal.model.Ismcnd ismcndByUatcndstate, com.sellerportal.model.Ismubi ismubi, Set ismscls, Set ismpbis, String uatarea) {
        this.createdate = createdate;
        this.createdby = createdby;
        this.deleted = deleted;
        this.modidate = modidate;
        this.uataddr1 = uataddr1;
        this.uatfname = uatfname;
//        this.uatisbilling = uatisbilling;
//        this.uatiscompany = uatiscompany;
//        this.uatispickup = uatispickup;
//        this.uatisshipping = uatisshipping;
        this.uatlname = uatlname;
        this.uatzip = uatzip;
//        this.ismcndByUatcndtitle = ismcndByUatcndtitle;
        this.ismubi = ismubi;
//        this.ismscls = ismscls;
//        this.ismpbis = ismpbis;
        this.uatarea = uatarea;
    }

    /** 
     * 		       auto_increment
     * 		    
     */
    public Long getUatrfnum() {
        return this.uatrfnum;
    }

    public void setUatrfnum(Long uatrfnum) {
        this.uatrfnum = uatrfnum;
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

    public Date getModidate() {
        return this.modidate;
    }

    public void setModidate(Date modidate) {
        this.modidate = modidate;
    }

    public String getUatactive() {
        return this.uatactive;
    }

    public void setUatactive(String uatactive) {
        this.uatactive = uatactive;
    }

    public String getUataddr1() {
        return this.uataddr1;
    }

    public void setUataddr1(String uataddr1) {
        this.uataddr1 = uataddr1;
    }

    public String getUataddr2() {
        return this.uataddr2;
    }

    public void setUataddr2(String uataddr2) {
        this.uataddr2 = uataddr2;
    }

//    public String getUataddr3() {
//        return this.uataddr3;
//    }
//
//    public void setUataddr3(String uataddr3) {
//        this.uataddr3 = uataddr3;
//    }
//
//    public String getUatcallerno() {
//        return this.uatcallerno;
//    }
//
//    public void setUatcallerno(String uatcallerno) {
//        this.uatcallerno = uatcallerno;
//    }

    public String getUatemail() {
        return this.uatemail;
    }

    public void setUatemail(String uatemail) {
        this.uatemail = uatemail;
    }

//    public String getUatemail2() {
//        return this.uatemail2;
//    }
//
//    public void setUatemail2(String uatemail2) {
//        this.uatemail2 = uatemail2;
//    }

    public String getUatfax() {
        return this.uatfax;
    }

    public void setUatfax(String uatfax) {
        this.uatfax = uatfax;
    }

    public String getUatfname() {
        return this.uatfname;
    }

    public void setUatfname(String uatfname) {
        this.uatfname = uatfname;
    }

//    public String getUatisbilling() {
//        return this.uatisbilling;
//    }
//
//    public void setUatisbilling(String uatisbilling) {
//        this.uatisbilling = uatisbilling;
//    }
//
//    public String getUatiscompany() {
//        return this.uatiscompany;
//    }
//
//    public void setUatiscompany(String uatiscompany) {
//        this.uatiscompany = uatiscompany;
//    }
//
//    public String getUatispickup() {
//        return this.uatispickup;
//    }
//
//    public void setUatispickup(String uatispickup) {
//        this.uatispickup = uatispickup;
//    }
//
//    public String getUatisshipping() {
//        return this.uatisshipping;
//    }
//
//    public void setUatisshipping(String uatisshipping) {
//        this.uatisshipping = uatisshipping;
//    }

    public String getUatlname() {
        return this.uatlname;
    }

    public void setUatlname(String uatlname) {
        this.uatlname = uatlname;
    }

    public String getUatmname() {
        return this.uatmname;
    }

    public void setUatmname(String uatmname) {
        this.uatmname = uatmname;
    }

    public String getUatmobile() {
        return this.uatmobile;
    }

    public void setUatmobile(String uatmobile) {
        this.uatmobile = uatmobile;
    }

//    public String getUatothercity() {
//        return this.uatothercity;
//    }
//
//    public void setUatothercity(String uatothercity) {
//        this.uatothercity = uatothercity;
//    }
//
//    public String getUatotherstate() {
//        return this.uatotherstate;
//    }
//
//    public void setUatotherstate(String uatotherstate) {
//        this.uatotherstate = uatotherstate;
//    }

    public String getUatphone() {
        return this.uatphone;
    }

    public void setUatphone(String uatphone) {
        this.uatphone = uatphone;
    }

//    public String getUatphone2() {
//        return this.uatphone2;
//    }
//
//    public void setUatphone2(String uatphone2) {
//        this.uatphone2 = uatphone2;
//    }
//
//    public String getUattitle() {
//        return this.uattitle;
//    }
//
//    public void setUattitle(String uattitle) {
//        this.uattitle = uattitle;
//    }

    public String getUatzip() {
        return this.uatzip;
    }

    public void setUatzip(String uatzip) {
        this.uatzip = uatzip;
    }

//    public com.sellerportal.model.Ismcnd getIsmcndByUatcndtitle() {
//        return this.ismcndByUatcndtitle;
//    }
//
//    public void setIsmcndByUatcndtitle(com.sellerportal.model.Ismcnd ismcndByUatcndtitle) {
//        this.ismcndByUatcndtitle = ismcndByUatcndtitle;
//    }

    

    public com.sellerportal.model.Ismubi getIsmubi() {
        return this.ismubi;
    }

    public void setIsmubi(com.sellerportal.model.Ismubi ismubi) {
        this.ismubi = ismubi;
    }

//    public Set getIsmscls() {
//        return this.ismscls;
//    }

//    public void setIsmscls(Set ismscls) {
//        this.ismscls = ismscls;
//    }

//    public Set getIsmpbis() {
//        return this.ismpbis;
//    }
//
//    public void setIsmpbis(Set ismpbis) {
//        this.ismpbis = ismpbis;
//    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("uatrfnum", getUatrfnum())
            .toString();
    }

    public Object clone() throws CloneNotSupportedException
    {
        return super.clone();
    }
    /*public Object clone(){
    	try {
			return super.clone();
		} catch (CloneNotSupportedException e) {
			
		}
		return null;
    }*/

	/**
	 * Created getUatispreffered
	 * By ali
	 * On Dec 23, 2011
	 * @return the uatispreffered
	 */
//	public String getUatispreffered() {
//		return uatispreffered;
//	}

	/**
	 * Created setUatispreffered 
	 * By ali
	 * On Dec 23, 2011
	 * @param uatispreffered the uatispreffered to set
	 */
//	public void setUatispreffered(String uatispreffered) {
//		this.uatispreffered = uatispreffered;
//	}

	public com.sellerportal.model.StateMaster getStateMaster() {
		return stateMaster;
	}

	public void setStateMaster(com.sellerportal.model.StateMaster stateMaster) {
		this.stateMaster = stateMaster;
	}

	public com.sellerportal.model.CountryMaster getCountryMaster() {
		return countryMaster;
	}

	public void setCountryMaster(com.sellerportal.model.CountryMaster countryMaster) {
		this.countryMaster = countryMaster;
	}

	public com.sellerportal.model.CityMaster getCityMaster() {
		return cityMaster;
	}

	public void setCityMaster(com.sellerportal.model.CityMaster cityMaster) {
		this.cityMaster = cityMaster;
	}

	public String getUatarea() {
		return uatarea;
	}

	public void setUatarea(String uatarea) {
		this.uatarea = uatarea;
	}

	public String getIscorpaddr() {
		return iscorpaddr;
	}

	public void setIscorpaddr(String iscorpaddr) {
		this.iscorpaddr = iscorpaddr;
	}

	public String getIsreturnadd() {
		return isreturnadd;
	}

	public void setIsreturnadd(String isreturnadd) {
		this.isreturnadd = isreturnadd;
	}
	
	public String getExtension() {
		return extension;
	}

	public void setExtension(String extension) {
		this.extension = extension;
	}

	public String getUatisapproved() {
		return uatisapproved;
	}

	public void setUatisapproved(String uatisapproved) {
		this.uatisapproved = uatisapproved;
	}

	public String getUatisprocessed() {
		return uatisprocessed;
	}

	public void setUatisprocessed(String uatisprocessed) {
		this.uatisprocessed = uatisprocessed;
	}
	
	
}
