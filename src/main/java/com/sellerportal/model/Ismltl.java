package com.sellerportal.model;

import java.io.Serializable;
import java.util.Date;

import org.apache.commons.lang.builder.ToStringBuilder;
import javax.persistence.*;

@Entity
@Table(name = "ISMLTL")
public class Ismltl implements Serializable {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ltlrfnum;

	@Column(name = "LTLCREATEDATE")
    private Date ltlcreatedate;

    @Column(name = "LTLCREATEDBY", nullable = false)
    private Long ltlcreatedby;

    @Column(name = "LTLDELETED", nullable = false, length = 1)
    private String ltldeleted;

    @Column(name = "LTLMODIDATE")
    private Date ltlmodidate;

    @Column(name = "LTLPOINTS")
    private Long ltlpoints;

    @Column(name = "LTLTRANSACTION")
    private Long ltltransaction;

    @Column(name = "LTLTYPE", length = 1)
    private String ltltype;

    @ManyToOne(optional = false)
    @JoinColumn(name = "LTLUBIRFNUM", nullable = false)
    private com.sellerportal.model.Ismubi ismubi;

    /** full constructor */
    public Ismltl(Date ltlcreatedate, Long ltlcreatedby, String ltldeleted, Date ltlmodidate, Long ltlpoints, Long ltltransaction, String ltltype, com.sellerportal.model.Ismubi ismubi) {
        this.ltlcreatedate = ltlcreatedate;
        this.ltlcreatedby = ltlcreatedby;
        this.ltldeleted = ltldeleted;
        this.ltlmodidate = ltlmodidate;
        this.ltlpoints = ltlpoints;
        this.ltltransaction = ltltransaction;
        this.ltltype = ltltype;
        this.ismubi = ismubi;
    }

    /** default constructor */
    public Ismltl() {
    }

    /** minimal constructor */
    public Ismltl(Long ltlcreatedby, String ltldeleted, com.sellerportal.model.Ismubi ismubi) {
        this.ltlcreatedby = ltlcreatedby;
        this.ltldeleted = ltldeleted;
        this.ismubi = ismubi;
    }

    /** 
     * 		       auto_increment
     * 		    
     */
    public Long getLtlrfnum() {
        return this.ltlrfnum;
    }

    public void setLtlrfnum(Long ltlrfnum) {
        this.ltlrfnum = ltlrfnum;
    }

    public Date getLtlcreatedate() {
        return this.ltlcreatedate;
    }

    public void setLtlcreatedate(Date ltlcreatedate) {
        this.ltlcreatedate = ltlcreatedate;
    }

    public Long getLtlcreatedby() {
        return this.ltlcreatedby;
    }

    public void setLtlcreatedby(Long ltlcreatedby) {
        this.ltlcreatedby = ltlcreatedby;
    }

    public String getLtldeleted() {
        return this.ltldeleted;
    }

    public void setLtldeleted(String ltldeleted) {
        this.ltldeleted = ltldeleted;
    }

    public Date getLtlmodidate() {
        return this.ltlmodidate;
    }

    public void setLtlmodidate(Date ltlmodidate) {
        this.ltlmodidate = ltlmodidate;
    }

    public Long getLtlpoints() {
        return this.ltlpoints;
    }

    public void setLtlpoints(Long ltlpoints) {
        this.ltlpoints = ltlpoints;
    }

    public Long getLtltransaction() {
        return this.ltltransaction;
    }

    public void setLtltransaction(Long ltltransaction) {
        this.ltltransaction = ltltransaction;
    }

    public String getLtltype() {
        return this.ltltype;
    }

    public void setLtltype(String ltltype) {
        this.ltltype = ltltype;
    }

    public com.sellerportal.model.Ismubi getIsmubi() {
        return this.ismubi;
    }

    public void setIsmubi(com.sellerportal.model.Ismubi ismubi) {
        this.ismubi = ismubi;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("ltlrfnum", getLtlrfnum())
            .toString();
    }

}
