package com.sellerportal.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.Set;

import org.apache.commons.lang.builder.ToStringBuilder;


@Entity
@Table(name = "ismcca")
public class Ismcca implements Serializable {

	 @Id
	    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ismcca_sequence")
	    @SequenceGenerator(name = "ismcca_sequence", sequenceName = "ISMCCA_CCARFNUM_SEQ", allocationSize = 1)
	    @Column(name = "CCARFNUM")
	    private Long ccarfnum;

	    @Column(name = "CCAEMAILID", length = 64)
	    private String ccaemailid;

	    @Column(name = "CCAISACTIVE", nullable = false, length = 1)
	    private String ccaisactive;

	    @Column(name = "CCAUSERID", nullable = false, length = 64)
	    private String ccauserid;

	    @Column(name = "CCAUSERNAME", nullable = false, length = 128)
	    private String ccausername;

	    @Column(name = "CREATEDATE", nullable = false)
	    private Date createdate;

	    @Column(name = "CREATEDBY", nullable = false)
	    private Long createdby;

	    @Column(name = "DELETED", nullable = false, length = 1)
	    private String deleted;

	    @Column(name = "MODIDATE", nullable = false)
	    private Date modidate;
    

	    @ManyToOne(fetch = FetchType.LAZY)
	    @JoinColumn(name = "CCACCDRFNUM", nullable = false)
	    private Ismccd ismccd;

	    @ManyToOne(fetch = FetchType.LAZY)
	    @JoinColumn(name = "CCACNDAGENTTYPE")
	    private Ismcnd ismcnd;

//    /** persistent field */
//    private Set crmraas;

    @OneToMany(mappedBy = "ismcca", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Ismbco> ismbcos;
    
//    /** persistent field */
//    private Set crmgaas;
//
//    /** persistent field */
//    private Set crmctts;
//
//    /** persistent field */
//    private Set crmchtsByChtccarfnum;
//
//    /** persistent field */
//    private Set crmchtsByChtccatrfnum;
//
//    /** persistent field */
//    private Set ismscls;
    
    /** persistent field Dialer Agent ID */
    @Column(name = "CCADAID", length = 20)
    private String ccadaid;

    @Column(name = "CCACALLCENTERCAMPAIGNNAME", length = 128)
    private String ccacallcentercampaignname;

    /** full constructor */
    public Ismcca(String ccaemailid, String ccaisactive, String ccauserid, String ccausername, Date createdate, Long createdby, String deleted, Date modidate, Long orgid, com.sellerportal.model.Ismccd ismccd,com.sellerportal.model.Ismcnd ismcnd,  Set crmraas, Set ismbcos, Set crmgaas, Set crmctts, Set crmchtsByChtccarfnum, Set crmchtsByChtccatrfnum, Set ismscls,String ccadaid,String ccacallcentercampaignname) {
        this.ccaemailid = ccaemailid;
        this.ccaisactive = ccaisactive;
        this.ccauserid = ccauserid;
        this.ccausername = ccausername;
        this.createdate = createdate;
        this.createdby = createdby;
        this.deleted = deleted;
        this.modidate = modidate;
        
        this.ismccd = ismccd;
//        this.crmraas = crmraas;
        this.ismbcos = ismbcos;
//        this.crmgaas = crmgaas;
//        this.crmctts = crmctts;
//        this.crmchtsByChtccarfnum = crmchtsByChtccarfnum;
//        this.crmchtsByChtccatrfnum = crmchtsByChtccatrfnum;
//        this.ismscls = ismscls;
        this.ismcnd = ismcnd;
        this.ccadaid = ccadaid;
        this.ccacallcentercampaignname = ccacallcentercampaignname;
    }

    /** default constructor */
    public Ismcca() {
    }

    /** minimal constructor */
    public Ismcca(String ccaisactive, String ccauserid, String ccausername, Date createdate, Long createdby, String deleted, Date modidate, Long orgid, com.sellerportal.model.Ismccd ismccd,com.sellerportal.model.Ismcnd ismcnd, Set crmraas, Set ismbcos, Set crmgaas, Set crmctts, Set crmchtsByChtccarfnum, Set crmchtsByChtccatrfnum, Set ismscls) {
        this.ccaisactive = ccaisactive;
        this.ccauserid = ccauserid;
        this.ccausername = ccausername;
        this.createdate = createdate;
        this.createdby = createdby;
        this.deleted = deleted;
        this.modidate = modidate;
        
        this.ismccd = ismccd;
//        this.crmraas = crmraas;
        this.ismbcos = ismbcos;
//        this.crmgaas = crmgaas;
//        this.crmctts = crmctts;
//        this.crmchtsByChtccarfnum = crmchtsByChtccarfnum;
//        this.crmchtsByChtccatrfnum = crmchtsByChtccatrfnum;
//        this.ismscls = ismscls;
        this.ismcnd = ismcnd;
    }

    /** 
     * 		       auto_increment
     * 		    
     */
    public Long getCcarfnum() {
        return this.ccarfnum;
    }

    public void setCcarfnum(Long ccarfnum) {
        this.ccarfnum = ccarfnum;
    }

    public String getCcaemailid() {
        return this.ccaemailid;
    }

    public void setCcaemailid(String ccaemailid) {
        this.ccaemailid = ccaemailid;
    }

    public String getCcaisactive() {
        return this.ccaisactive;
    }

    public void setCcaisactive(String ccaisactive) {
        this.ccaisactive = ccaisactive;
    }

    public String getCcauserid() {
        return this.ccauserid;
    }

    public void setCcauserid(String ccauserid) {
        this.ccauserid = ccauserid;
    }

    public String getCcausername() {
        return this.ccausername;
    }

    public void setCcausername(String ccausername) {
        this.ccausername = ccausername;
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

   

    public com.sellerportal.model.Ismccd getIsmccd() {
        return this.ismccd;
    }

    public void setIsmccd(com.sellerportal.model.Ismccd ismccd) {
        this.ismccd = ismccd;
    }

//    public Set getCrmraas() {
//        return this.crmraas;
//    }
//
//    public void setCrmraas(Set crmraas) {
//        this.crmraas = crmraas;
//    }

    public Set getIsmbcos() {
        return this.ismbcos;
    }

    public void setIsmbcos(Set ismbcos) {
        this.ismbcos = ismbcos;
    }

//    public Set getCrmgaas() {
//        return this.crmgaas;
//    }
//
//    public void setCrmgaas(Set crmgaas) {
//        this.crmgaas = crmgaas;
//    }
//
//    public Set getCrmctts() {
//        return this.crmctts;
//    }
//
//    public void setCrmctts(Set crmctts) {
//        this.crmctts = crmctts;
//    }
//
//    public Set getCrmchtsByChtccarfnum() {
//        return this.crmchtsByChtccarfnum;
//    }
//
//    public void setCrmchtsByChtccarfnum(Set crmchtsByChtccarfnum) {
//        this.crmchtsByChtccarfnum = crmchtsByChtccarfnum;
//    }
//
//    public Set getCrmchtsByChtccatrfnum() {
//        return this.crmchtsByChtccatrfnum;
//    }
//
//    public void setCrmchtsByChtccatrfnum(Set crmchtsByChtccatrfnum) {
//        this.crmchtsByChtccatrfnum = crmchtsByChtccatrfnum;
//    }
//
//    public Set getIsmscls() {
//        return this.ismscls;
//    }
//
//    public void setIsmscls(Set ismscls) {
//        this.ismscls = ismscls;
//    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("ccarfnum", getCcarfnum())
            .toString();
    }
    
    /**
	 * @return the ismcnd
	 */
	public com.sellerportal.model.Ismcnd getIsmcnd() {
		return ismcnd;
	}
	/**
	 * @param ismcnd the ismcnd to set
	 */
	public void setIsmcnd(com.sellerportal.model.Ismcnd ismcnd) {
		this.ismcnd = ismcnd;
	}
	/**
	 * @return the ccadaid
	 */
	public String getCcadaid() {
		return ccadaid;
	}

	/**
	 * @param ccadaid the ccadaid to set
	 */
	public void setCcadaid(String ccadaid) {
		this.ccadaid = ccadaid;
	}

	/**
	 * @return the ccacallcentercampaignname
	 */
	public String getCcacallcentercampaignname() {
		return ccacallcentercampaignname;
	}

	/**
	 * @param ccacallcentercampaignname the ccacallcentercampaignname to set
	 */
	public void setCcacallcentercampaignname(String ccacallcentercampaignname) {
		this.ccacallcentercampaignname = ccacallcentercampaignname;
	}


}
