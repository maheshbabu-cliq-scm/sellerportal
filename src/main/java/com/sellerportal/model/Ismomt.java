package com.sellerportal.model;

import java.io.Serializable;
import java.util.Date;

import org.apache.commons.lang.builder.ToStringBuilder;
import javax.persistence.*;

@Entity
@Table(name = "ISMOMT")
public class Ismomt implements Serializable {
	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    @Column(name = "OMTRFNUM")
	    private Long omtrfnum;

	    @Lob
	    @Column(name = "ABOUTUS", length = 65535)
	    private byte[] aboutus;

	    @Lob
	    @Column(name = "CONTACTUS", length = 65535)
	    private byte[] contactus;

	    @Column(name = "CREATEDATE", nullable = false)
	    private Date createdate;

	    @Column(name = "CREATEDBY", nullable = false)
	    private Long createdby;

	    @Lob
	    @Column(name = "DEFAULTHEADER", length = 65535)
	    private byte[] defaultheader;

	    @Column(name = "DELETED", nullable = false, length = 1)
	    private String deleted;

	    @Lob
	    @Column(name = "FOOTER", length = 65535)
	    private byte[] footer;

	    @Column(name = "ISACTIVE", nullable = false, length = 1)
	    private String isactive;

	    @Column(name = "MODIDATE", nullable = false)
	    private Date modidate;

	    @Column(name = "OMTMODULECODE", nullable = false, length = 100)
	    private Long omtmodulecode;

	    @Column(name = "OMTMODULENAME", nullable = false, length = 100)
	    private String omtmodulename;

	    @Column(name = "OMTMODULEURL", nullable = false, length = 50)
	    private String omtmoduleurl;

	    @Lob
	    @Column(name = "TERMASANDCONDITION", length = 65535)
	    private byte[] termasandcondition;

	    @ManyToOne(fetch = FetchType.LAZY)
	    @JoinColumn(name = "OMTGOTRFNUM", nullable = false)
	    private Ismgot ismgot;

    /** full constructor */
    public Ismomt(byte[] aboutus, byte[] contactus, Date createdate, Long createdby, byte[] defaultheader, String deleted, byte[] footer, String isactive, Date modidate, Long omtmodulecode, String omtmodulename, String omtmoduleurl, byte[] termasandcondition, com.sellerportal.model.Ismgot ismgot) {
        this.aboutus = aboutus;
        this.contactus = contactus;
        this.createdate = createdate;
        this.createdby = createdby;
        this.defaultheader = defaultheader;
        this.deleted = deleted;
        this.footer = footer;
        this.isactive = isactive;
        this.modidate = modidate;
        this.omtmodulecode = omtmodulecode;
        this.omtmodulename = omtmodulename;
        this.omtmoduleurl = omtmoduleurl;
        this.termasandcondition = termasandcondition;
        this.ismgot = ismgot;
    }

    /** default constructor */
    public Ismomt() {
    }

    /** minimal constructor */
    public Ismomt(Date createdate, Long createdby, String deleted, String isactive, Date modidate, Long omtmodulecode, String omtmodulename, String omtmoduleurl, com.sellerportal.model.Ismgot ismgot) {
        this.createdate = createdate;
        this.createdby = createdby;
        this.deleted = deleted;
        this.isactive = isactive;
        this.modidate = modidate;
        this.omtmodulecode = omtmodulecode;
        this.omtmodulename = omtmodulename;
        this.omtmoduleurl = omtmoduleurl;
        this.ismgot = ismgot;
    }

    /** 
     * 		       auto_increment
     * 		    
     */
    public Long getOmtrfnum() {
        return this.omtrfnum;
    }

    public void setOmtrfnum(Long omtrfnum) {
        this.omtrfnum = omtrfnum;
    }

    public byte[] getAboutus() {
        return this.aboutus;
    }

    public void setAboutus(byte[] aboutus) {
        this.aboutus = aboutus;
    }

    public byte[] getContactus() {
        return this.contactus;
    }

    public void setContactus(byte[] contactus) {
        this.contactus = contactus;
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

    public byte[] getDefaultheader() {
        return this.defaultheader;
    }

    public void setDefaultheader(byte[] defaultheader) {
        this.defaultheader = defaultheader;
    }

    public String getDeleted() {
        return this.deleted;
    }

    public void setDeleted(String deleted) {
        this.deleted = deleted;
    }

    public byte[] getFooter() {
        return this.footer;
    }

    public void setFooter(byte[] footer) {
        this.footer = footer;
    }

    public String getIsactive() {
        return this.isactive;
    }

    public void setIsactive(String isactive) {
        this.isactive = isactive;
    }

    public Date getModidate() {
        return this.modidate;
    }

    public void setModidate(Date modidate) {
        this.modidate = modidate;
    }

    public Long getOmtmodulecode() {
        return this.omtmodulecode;
    }

    public void setOmtmodulecode(Long omtmodulecode) {
        this.omtmodulecode = omtmodulecode;
    }

    public String getOmtmodulename() {
        return this.omtmodulename;
    }

    public void setOmtmodulename(String omtmodulename) {
        this.omtmodulename = omtmodulename;
    }

    public String getOmtmoduleurl() {
        return this.omtmoduleurl;
    }

    public void setOmtmoduleurl(String omtmoduleurl) {
        this.omtmoduleurl = omtmoduleurl;
    }

    public byte[] getTermasandcondition() {
        return this.termasandcondition;
    }

    public void setTermasandcondition(byte[] termasandcondition) {
        this.termasandcondition = termasandcondition;
    }

    public com.sellerportal.model.Ismgot getIsmgot() {
        return this.ismgot;
    }

    public void setIsmgot(com.sellerportal.model.Ismgot ismgot) {
        this.ismgot = ismgot;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("omtrfnum", getOmtrfnum())
            .toString();
    }

}
