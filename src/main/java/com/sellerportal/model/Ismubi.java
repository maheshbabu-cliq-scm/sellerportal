package com.sellerportal.model;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;
import java.util.Set;
import java.util.*;

import javax.annotation.Generated;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.*;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.springframework.stereotype.Component;

@Entity
@Table(name="Ismubi")
@Component
public class Ismubi implements Serializable {

	/** identifier field */
	@Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ismubi_sequence")
    @SequenceGenerator(name = "ismubi_sequence", sequenceName = "ISMUBI_UBIRFNUM_SEQ", allocationSize = 1)
    @Column(name = "UBIRFNUM")
    private Long ubirfnum;

	@Column(name = "CREATEDATE", nullable = false)
    private Date createdate;

    @Column(name = "CREATEDBY", nullable = false, length = 20)
    private Long createdby;

    @Column(name = "DELETED", nullable = false, length = 1)
    private String deleted;

    @Column(name = "MODIDATE")
    private Date modidate;

    @Column(name = "UBIACTIVE", length = 1)
    private String ubiactive;

    @Column(name = "UBIFNAME", length = 128)
    private String ubifname;

    @Column(name = "UBILASTACCESS")
    private Date ubilastaccess;

    @Column(name = "UBILASTUPDATE")
    private Date ubilastupdate;

    @Column(name = "UBILNAME", length = 128)
    private String ubilname;

    @Column(name = "UBILOGIN", nullable = false, length = 241)
    private String ubilogin;

    @Column(name = "UBIMNAME", length = 128)
    private String ubimname;

    @Column(name = "UBIPASS", length = 64)
    private String ubipass;

    @Column(name = "COMMUNICATION_EMAIL", length = 255)
    private String communicationEmail;

    @Column(name = "MOBILE", length = 55)
    private String mobile;

    @Column(name = "EMAIL_AUTHENTICATE", length = 1)
    private String emailauthenticate;

    @Column(name = "MOBILE_AUTHENTICATE", length = 1)
    private String mobileauthenticate;
    
    @Column(name = "EMAIL_AUTHCODE_EXPIRY")
    private Date emailauthcodeexpiry;
    
    @Column(name = "SMS_AUTHCODE_EXPIRY")
    private Date smsauthcodeexpiry;
    
    @Column(name = "EMAIL_AUTHCODE", length = 100)
    private String emailauthcode;

    @Column(name = "SMS_AUTHCODE", length = 100)
    private String smsauthcode;
   
    @Column(name = "LAST_LOGIN")
    private Date lastlogin;
    
    @Column(name = "PASSWORDRESET_DATE")
    private Date passwordresetdate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "UBICNDTITLE", referencedColumnName = "CNDRFNUM")
    private Ismcnd ismcnd;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "UBICCTRFNUM", referencedColumnName = "CCTNCODE")
    private Ismcct ismcct;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "UBIUSERTYPE", referencedColumnName = "PARAMRFNUM")
    private OctParam octParam;
    
    @OneToMany(mappedBy = "ismubi")
    private Set<Ismaur> ismaurs;

    @OneToMany(mappedBy = "ismubi")
    private Set<Ismltl> ismltls;

    @OneToMany(mappedBy = "ismubi")
    private Set<Ismsua> ismsuas;

    @OneToMany(mappedBy = "ismubi")
    private Set<Ismuat> ismuats;

    @OneToMany(mappedBy = "ismubi")
    private Set<Ismbco> ismbcos;

    public com.sellerportal.model.OctParam getOctParam() {
		return octParam;
	}

	public void setOctParam(com.sellerportal.model.OctParam octParam) {
		this.octParam = octParam;
	}

	@Column(name = "RESET_PASSWORD", length = 1)
    private String resetpassword;
    
    //private String ubiisprioritycustomer;
    
    @Column(name = "UBI_LOGO", length = 255)
    private String ubiLogo;

    @Column(name = "PHONE", length = 55)
    private String phone;

    @Column(name = "ISSUPEROMS", length = 1)
    private String issuperoms;

    @Column(name = "ISEXPIRED", length = 1)
    private String isAccountexpired;

    @Column(name = "PWDEXPIRY")
    private Date pwdexpiry;

    @Column(name = "MASKCUSTDATA", length = 4)
    private String maskCustData;

    @Column(name = "LOGIN_ATTEMPTS", length = 2)
    private Long loginAttempts;

    @Column(name = "LOGIN_BLOCK_TIME")
    private Date loginBlockTime;
    
	/** full constructor */
    public Ismubi(Date createdate, Long createdby, String deleted, Date modidate, String ubiactive, String ubifname, Date ubilastaccess, Date ubilastupdate, String ubilname, String ubilogin, String ubimname, String ubipass, String communicationEmail, String ubiusertype, Ismcnd ismcnd, Ismcct ismcct, OctParam octParam, String mobile, String emailauthenticate, String mobileauthenticate, Date smsauthcodeexpiry, Date emailauthcodeexpiry, String emailauthcode, String smsauthcode, String resetpassword, String ubiisprioritycustomer, String ubiLogo, String phone) {
        this.createdate = createdate;
        this.createdby = createdby;
        this.deleted = deleted;
        this.modidate = modidate;
        this.ubiactive = ubiactive;
        this.ubifname = ubifname;
        this.ubilastaccess = ubilastaccess;
        this.ubilastupdate = ubilastupdate;
        this.ubilname = ubilname;
        this.ubilogin = ubilogin;
        this.ubimname = ubimname;
        this.ubipass = ubipass;
        this.communicationEmail=communicationEmail;
        this.ismcnd = ismcnd;
        this.ismcct = ismcct;
        this.octParam = octParam;
        this.mobile = mobile;
        this.emailauthenticate = emailauthenticate;
        this.mobileauthenticate = mobileauthenticate; 
        this.smsauthcodeexpiry = smsauthcodeexpiry;
        this.emailauthcodeexpiry = emailauthcodeexpiry;
        this.emailauthcode = emailauthcode;
        this.smsauthcode = smsauthcode;
        this.resetpassword = resetpassword;
//        this.ubiisprioritycustomer=ubiisprioritycustomer;
        this.ubiLogo=ubiLogo;
        this.phone=phone;
    }

    /** default constructor */
    public Ismubi() {
    }

    /** minimal constructor */
    public Ismubi(Date createdate, Long createdby, String deleted, String ubilogin, com.sellerportal.model.Ismcnd ismcnd
    		, com.sellerportal.model.Ismcct ismcct,com.sellerportal.model.OctParam octParam,
    		 String ubiisprioritycustomer, String ubiLogo) {
        this.createdate = createdate;
        this.createdby = createdby;
        this.deleted = deleted;
        this.ubilogin = ubilogin;
        this.ismcnd = ismcnd;
        this.ismcct = ismcct;
        this.octParam = octParam;
//        this.ubiisprioritycustomer=ubiisprioritycustomer;
        this.ubiLogo=ubiLogo;
    }

    /** 
     * 		       auto_increment
     * 		    
     */
    public Long getUbirfnum() {
        return this.ubirfnum;
    }

    public void setUbirfnum(Long ubirfnum) {
        this.ubirfnum = ubirfnum;
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

    public String getUbiactive() {
        return this.ubiactive;
    }

    public void setUbiactive(String ubiactive) {
        this.ubiactive = ubiactive;
    }

    public String getUbifname() {
        return this.ubifname;
    }

    public void setUbifname(String ubifname) {
        this.ubifname = ubifname;
    }


    public Date getUbilastaccess() {
        return this.ubilastaccess;
    }

    public void setUbilastaccess(Date ubilastaccess) {
        this.ubilastaccess = ubilastaccess;
    }

    public Date getUbilastupdate() {
        return this.ubilastupdate;
    }

    public void setUbilastupdate(Date ubilastupdate) {
        this.ubilastupdate = ubilastupdate;
    }

    public String getUbilname() {
        return this.ubilname;
    }

    public void setUbilname(String ubilname) {
        this.ubilname = ubilname;
    }

    public String getUbilogin() {
        return this.ubilogin;
    }

    public void setUbilogin(String ubilogin) {
        this.ubilogin = ubilogin;
    }


    public String getUbimname() {
        return this.ubimname;
    }

    public void setUbimname(String ubimname) {
        this.ubimname = ubimname;
    }

    public String getUbipass() {
        return this.ubipass;
    }

    public void setUbipass(String ubipass) {
        this.ubipass = ubipass;
    }

	/**
	 * @return the emailauthenticate
	 */
	public String getEmailauthenticate() {
		return emailauthenticate;
	}

	/**
	 * @param emailauthenticate the emailauthenticate to set
	 */
	public void setEmailauthenticate(String emailauthenticate) {
		this.emailauthenticate = emailauthenticate;
	}

	/**
	 * @return the mobileauthenticate
	 */
	public String getMobileauthenticate() {
		return mobileauthenticate;
	}

	/**
	 * @param mobileauthenticate the mobileauthenticate to set
	 */
	public void setMobileauthenticate(String mobileauthenticate) {
		this.mobileauthenticate = mobileauthenticate;
	}

    public com.sellerportal.model.Ismcnd getIsmcnd() {
        return this.ismcnd;
    }

    public void setIsmcnd(com.sellerportal.model.Ismcnd ismcnd) {
        this.ismcnd = ismcnd;
    }

    public com.sellerportal.model.Ismcct getIsmcct() {
        return this.ismcct;
    }

    public void setIsmcct(com.sellerportal.model.Ismcct ismcct) {
        this.ismcct = ismcct;
    }

   

    public String toString() {
        return new ToStringBuilder(this)
            .append("ubirfnum", getUbirfnum())
            .toString();
    }

	public String getCommunicationEmail() {
		return communicationEmail;
	}

	public void setCommunicationEmail(String communicationEmail) {
		this.communicationEmail = communicationEmail;
	}

	/**
	 * @return the mobile
	 */
	public String getMobile() {
		return mobile;
	}

	/**
	 * @param mobile the mobile to set
	 */
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public Date getEmailauthcodeexpiry() {
		return emailauthcodeexpiry;
	}

	public void setEmailauthcodeexpiry(Date emailauthcodeexpiry) {
		this.emailauthcodeexpiry = emailauthcodeexpiry;
	}

	public Date getSmsauthcodeexpiry() {
		return smsauthcodeexpiry;
	}

	public void setSmsauthcodeexpiry(Date smsauthcodeexpiry) {
		this.smsauthcodeexpiry = smsauthcodeexpiry;
	}

	public String getEmailauthcode() {
		return emailauthcode;
	}

	public void setEmailauthcode(String emailauthcode) {
		this.emailauthcode = emailauthcode;
	}

	public String getSmsauthcode() {
		return smsauthcode;
	}

	public void setSmsauthcode(String smsauthcode) {
		this.smsauthcode = smsauthcode;
	}

	public String getResetpassword() {
		return resetpassword;
	}

	public void setResetpassword(String resetpassword) {
		this.resetpassword = resetpassword;
	}

	public Date getLastlogin() {
		return lastlogin;
	}

	public void setLastlogin(Date lastlogin) {
		this.lastlogin = lastlogin;
	}

	public Date getPasswordresetdate() {
		return passwordresetdate;
	}

	public void setPasswordresetdate(Date passwordresetdate) {
		this.passwordresetdate = passwordresetdate;
	}

		/**
		 * @param ubiisprioritycustomer the ubiisprioritycustomer to set
		 */
		public void setUbiisprioritycustomer(String ubiisprioritycustomer) {
//			this.ubiisprioritycustomer = ubiisprioritycustomer;
		}

		public String getUbiLogo() {
			return ubiLogo;
		}

		public void setUbiLogo(String ubiLogo) {
			this.ubiLogo = ubiLogo;
		}

		public String getPhone() {
			return phone;
		}

		public void setPhone(String phone) {
			this.phone = phone;
		}

		public String getIssuperoms() {
			return issuperoms;
		}

		public void setIssuperoms(String issuperoms) {
			this.issuperoms = issuperoms;
		}
		
		public Date getPwdexpiry() {
			return pwdexpiry;
		}

		public void setPwdexpiry(Date pwdexpiry) {
			this.pwdexpiry = pwdexpiry;
		}
		
		  public String getIsAccountexpired() {
				return isAccountexpired;
			}

			public void setIsAccountexpired(String isAccountexpired) {
				this.isAccountexpired = isAccountexpired;
			}

			public String getMaskCustData() {
				return maskCustData;
			}

			public void setMaskCustData(String maskCustData) {
				this.maskCustData = maskCustData;
			}

			public Long getLoginAttempts() {
				return loginAttempts;
			}

			public void setLoginAttempts(Long loginAttempts) {
				this.loginAttempts = loginAttempts;
			}

			public Date getLoginBlockTime() {
				return loginBlockTime;
			}

			public void setLoginBlockTime(Date loginBlockTime) {
				this.loginBlockTime = loginBlockTime;
			}
			
			
			
			
		
}