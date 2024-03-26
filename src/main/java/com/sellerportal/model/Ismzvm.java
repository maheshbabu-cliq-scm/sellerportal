package com.sellerportal.model;

import java.io.Serializable;
import java.util.Date;

import org.apache.commons.lang.builder.ToStringBuilder;
import javax.persistence.*;

@Entity
@Table(name = "ISMZVM")
public class Ismzvm implements Serializable {

	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    @Column(name = "ZVMRFNUM")
	    private Long zvmrfnum;

	    @Column(name = "ZVMCREATEDATE", nullable = false)
	    private Date zvmcreatedate;

	    @Column(name = "ZVMCREATEDBY", nullable = false)
	    private Long zvmcreatedby;

	    @Column(name = "ZVMDELETED", nullable = false, length = 1)
	    private String zvmdeleted;

	    @Column(name = "ZVMISPREFEREDZIP", length = 1)
	    private String zvmispreferedzip;

	    @Column(name = "ZVMISPREFERREDCITY", length = 1)
	    private String zvmispreferredcity;

	    @Column(name = "ZVMMODIDATE", nullable = false)
	    private Date zvmmodidate;

	    @ManyToOne(fetch = FetchType.LAZY)
	    @JoinColumn(name = "ZVMCITY", nullable = false)
	    private Ismcnd ismcndByZvmcity;

	    @ManyToOne(fetch = FetchType.LAZY)
	    @JoinColumn(name = "ZVMCNDZIP", nullable = false)
	    private Ismcnd ismcndByZvmcndzip;


    /** full constructor */
    public Ismzvm(Date zvmcreatedate, Long zvmcreatedby, String zvmdeleted, String zvmispreferedzip, String zvmispreferredcity, Date zvmmodidate,  com.sellerportal.model.Ismcnd ismcndByZvmcity,  com.sellerportal.model.Ismcnd ismcndByZvmcndzip) {
        this.zvmcreatedate = zvmcreatedate;
        this.zvmcreatedby = zvmcreatedby;
        this.zvmdeleted = zvmdeleted;
        this.zvmispreferedzip = zvmispreferedzip;
        this.zvmispreferredcity = zvmispreferredcity;
        this.zvmmodidate = zvmmodidate;
        this.ismcndByZvmcity = ismcndByZvmcity;
        this.ismcndByZvmcndzip = ismcndByZvmcndzip;
    }

    /** default constructor */
    public Ismzvm() {
    }

    /** minimal constructor */
    public Ismzvm(Date zvmcreatedate, Long zvmcreatedby, String zvmdeleted, Date zvmmodidate,  com.sellerportal.model.Ismcnd ismcndByZvmcity,  com.sellerportal.model.Ismcnd ismcndByZvmcndzip) {
        this.zvmcreatedate = zvmcreatedate;
        this.zvmcreatedby = zvmcreatedby;
        this.zvmdeleted = zvmdeleted;
        this.zvmmodidate = zvmmodidate;
        this.ismcndByZvmcity = ismcndByZvmcity;
        this.ismcndByZvmcndzip = ismcndByZvmcndzip;
    }

    /** 
     * 		       auto_increment
     * 		    
     */
    public Long getZvmrfnum() {
        return this.zvmrfnum;
    }

    public void setZvmrfnum(Long zvmrfnum) {
        this.zvmrfnum = zvmrfnum;
    }

    public Date getZvmcreatedate() {
        return this.zvmcreatedate;
    }

    public void setZvmcreatedate(Date zvmcreatedate) {
        this.zvmcreatedate = zvmcreatedate;
    }

    public Long getZvmcreatedby() {
        return this.zvmcreatedby;
    }

    public void setZvmcreatedby(Long zvmcreatedby) {
        this.zvmcreatedby = zvmcreatedby;
    }

    public String getZvmdeleted() {
        return this.zvmdeleted;
    }

    public void setZvmdeleted(String zvmdeleted) {
        this.zvmdeleted = zvmdeleted;
    }

    public String getZvmispreferedzip() {
        return this.zvmispreferedzip;
    }

    public void setZvmispreferedzip(String zvmispreferedzip) {
        this.zvmispreferedzip = zvmispreferedzip;
    }

    public String getZvmispreferredcity() {
        return this.zvmispreferredcity;
    }

    public void setZvmispreferredcity(String zvmispreferredcity) {
        this.zvmispreferredcity = zvmispreferredcity;
    }

    public Date getZvmmodidate() {
        return this.zvmmodidate;
    }

    public void setZvmmodidate(Date zvmmodidate) {
        this.zvmmodidate = zvmmodidate;
    }

    public  com.sellerportal.model.Ismcnd getIsmcndByZvmcity() {
        return this.ismcndByZvmcity;
    }

    public void setIsmcndByZvmcity( com.sellerportal.model.Ismcnd ismcndByZvmcity) {
        this.ismcndByZvmcity = ismcndByZvmcity;
    }

    public  com.sellerportal.model.Ismcnd getIsmcndByZvmcndzip() {
        return this.ismcndByZvmcndzip;
    }

    public void setIsmcndByZvmcndzip( com.sellerportal.model.Ismcnd ismcndByZvmcndzip) {
        this.ismcndByZvmcndzip = ismcndByZvmcndzip;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("zvmrfnum", getZvmrfnum())
            .toString();
    }

}
