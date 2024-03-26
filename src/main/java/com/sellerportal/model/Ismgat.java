package com.sellerportal.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.Set;

import org.apache.commons.lang.builder.ToStringBuilder;


@Entity
@Table(name = "ISMGAT")
public class Ismgat implements Serializable {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "GATRFNUM")
    private Long gatrfnum;

    @Column(name = "ADMINID", length = 20)
    private Long adminid;

    @Column(name = "CREATEDATE", nullable = false)
    private Date createdate;

    @Column(name = "CREATEDBY", nullable = false, length = 20)
    private Long createdby;

    @Column(name = "DELETED", nullable = false, length = 1)
    private String deleted;

    @Column(name = "EMAILID", length = 254)
    private String emailid;

    @Column(name = "GATADD1", length = 254)
    private String gatadd1;

    @Column(name = "GATADD2", length = 254)
    private String gatadd2;

    @Column(name = "GATCNDCITYRFNUM", length = 50)
    private String gatcndcityrfnum;

    @Column(name = "GATCNDCOUNTRYRFNUM", length = 50)
    private String gatcndcountryrfnum;

    @Column(name = "GATCNDSTATERFNUM", length = 50)
    private String gatcndstaterfnum;

    @Column(name = "GATTITLE", nullable = false, length = 10)
    private String gattitle;

    @Column(name = "GATNAME", length = 254)
    private String gatname;

    @Column(name = "ISACTIVE", nullable = false, length = 1)
    private String isactive;

    @Column(name = "ISADMIN", nullable = false, length = 1)
    private String isadmin;

    @Column(name = "LOGINID", length = 254)
    private String loginid;

    @Column(name = "MOBILENO", length = 20)
    private Long mobileno;

    @Column(name = "MODIDATE", nullable = false)
    private Date modidate;

    @Column(name = "PASSWORD", length = 254)
    private String password;

    @Column(name = "PHONENO", length = 20)
    private Long phoneno;

    @Column(name = "ROOT", nullable = false, length = 1)
    private String root;

    @OneToMany(mappedBy = "ismgat", fetch = FetchType.LAZY)
    @Transient
    private Set<Ismart> ismarts;

    /** full constructor */
    public Ismgat(Long adminid, Date createdate, Long createdby, String deleted, String emailid, String gatadd1, String gatadd2, String gatcndcityrfnum, String gatcndcountryrfnum, String gatcndstaterfnum, String gattitle,String gatname, String isactive, String isadmin, String loginid, Long mobileno, Date modidate, String password, Long phoneno, String root, Set<Ismart> ismarts) {
        this.adminid = adminid;
        this.createdate = createdate;
        this.createdby = createdby;
        this.deleted = deleted;
        this.emailid = emailid;
        this.gatadd1 = gatadd1;
        this.gatadd2 = gatadd2;
        this.gatcndcityrfnum = gatcndcityrfnum;
        this.gatcndcountryrfnum = gatcndcountryrfnum;
        this.gatcndstaterfnum = gatcndstaterfnum;
        this.gattitle=gattitle;
        this.gatname = gatname;
        this.isactive = isactive;
        this.isadmin = isadmin;
        this.loginid = loginid;
        this.mobileno = mobileno;
        this.modidate = modidate;
        this.password = password;
        this.phoneno = phoneno;
        this.root = root;
        this.ismarts = ismarts;
    }

    /** default constructor */
    public Ismgat() {
    }

    /** minimal constructor */
    public Ismgat(Long adminid, Date createdate, Long createdby, String deleted, String isactive, String isadmin, Date modidate, String root, Set<Ismart> ismarts) {
        this.adminid = adminid;
        this.createdate = createdate;
        this.createdby = createdby;
        this.deleted = deleted;
        this.isactive = isactive;
        this.isadmin = isadmin;
        this.modidate = modidate;
        this.root = root;
        this.ismarts = ismarts;
    }

    /** 
     * 		       auto_increment
     * 		    
     */
    public Long getGatrfnum() {
        return this.gatrfnum;
    }

    public void setGatrfnum(Long gatrfnum) {
        this.gatrfnum = gatrfnum;
    }

    public Long getAdminid() {
        return this.adminid;
    }

    public void setAdminid(Long adminid) {
        this.adminid = adminid;
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

    public String getEmailid() {
        return this.emailid;
    }

    public void setEmailid(String emailid) {
        this.emailid = emailid;
    }

    public String getGatadd1() {
        return this.gatadd1;
    }

    public void setGatadd1(String gatadd1) {
        this.gatadd1 = gatadd1;
    }

    public String getGatadd2() {
        return this.gatadd2;
    }

    public void setGatadd2(String gatadd2) {
        this.gatadd2 = gatadd2;
    }

    public String getGatcndcityrfnum() {
        return this.gatcndcityrfnum;
    }

    public void setGatcndcityrfnum(String gatcndcityrfnum) {
        this.gatcndcityrfnum = gatcndcityrfnum;
    }

    public String getGatcndcountryrfnum() {
        return this.gatcndcountryrfnum;
    }

    public void setGatcndcountryrfnum(String gatcndcountryrfnum) {
        this.gatcndcountryrfnum = gatcndcountryrfnum;
    }

    public String getGatcndstaterfnum() {
        return this.gatcndstaterfnum;
    }

    public void setGatcndstaterfnum(String gatcndstaterfnum) {
        this.gatcndstaterfnum = gatcndstaterfnum;
    }

    public String getGatname() {
        return this.gatname;
    }

    public void setGatname(String gatname) {
        this.gatname = gatname;
    }

    public String getIsactive() {
        return this.isactive;
    }

    public void setIsactive(String isactive) {
        this.isactive = isactive;
    }

    public String getIsadmin() {
        return this.isadmin;
    }

    public void setIsadmin(String isadmin) {
        this.isadmin = isadmin;
    }

    public String getLoginid() {
        return this.loginid;
    }

    public void setLoginid(String loginid) {
        this.loginid = loginid;
    }

    public Long getMobileno() {
        return this.mobileno;
    }

    public void setMobileno(Long mobileno) {
        this.mobileno = mobileno;
    }

    public Date getModidate() {
        return this.modidate;
    }

    public void setModidate(Date modidate) {
        this.modidate = modidate;
    }

      /**
	 * @return Returns the password.
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password The password to set.
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	public Long getPhoneno() {
        return this.phoneno;
    }

    public void setPhoneno(Long phoneno) {
        this.phoneno = phoneno;
    }

    public String getRoot() {
        return this.root;
    }

    public void setRoot(String root) {
        this.root = root;
    }

    public Set<Ismart> getIsmarts() {
        return this.ismarts;
    }

    public void setIsmarts(Set<Ismart> ismarts) {
        this.ismarts = ismarts;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("gatrfnum", getGatrfnum())
            .toString();
    }

	/**
	 * @return Returns the gattitle.
	 */
	public String getGattitle() {
		return gattitle;
	}

	/**
	 * @param gattitle The gattitle to set.
	 */
	public void setGattitle(String gattitle) {
		this.gattitle = gattitle;
	}

}
