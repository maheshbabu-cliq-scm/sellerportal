package com.sellerportal.model;

import java.io.Serializable;
import java.util.Date;

import org.apache.commons.lang.builder.ToStringBuilder;

import javax.persistence.*;

/** @author Hibernate CodeGenerator */
@Entity
@Table(name = "ISMHLM")
public class Ismhlm implements Serializable {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "HLMRFNUM")
    private Long hlmrfnum;

    @Column(name = "HLMCREATEDATE", nullable = false)
    private Date hlmcreatedate;

    @Column(name = "HLMCREATEDBY", nullable = false, length = 20)
    private Long hlmcreatedby;

    @Column(name = "HLMDATE", nullable = false)
    private Date hlmdate;

    @Column(name = "HLMDELETED", nullable = false, length = 1)
    private String hlmdeleted;

    @Column(name = "HLMMODIDATE", nullable = false)
    private Date hlmmodidate;

    @Column(name = "HLMNAME", length = 25)
    private String hlmname;

    @Column(name = "HLMREASON", nullable = false, length = 20)
    private Long hlmreason;

    @ManyToOne
    @JoinColumn(name = "HLMCNDREASON", nullable = false)
    private Ismcnd ismcnd;

    /** full constructor */
    public Ismhlm(Date hlmcreatedate, Long hlmcreatedby, Date hlmdate, String hlmdeleted, Date hlmmodidate, String hlmname, Long hlmreason,  com.sellerportal.model.Ismcnd ismcnd) {
        this.hlmcreatedate = hlmcreatedate;
        this.hlmcreatedby = hlmcreatedby;
        this.hlmdate = hlmdate;
        this.hlmdeleted = hlmdeleted;
        this.hlmmodidate = hlmmodidate;
        this.hlmname = hlmname;
        this.hlmreason = hlmreason;
        this.ismcnd = ismcnd;
    }

    /** default constructor */
    public Ismhlm() {
    }

    /** minimal constructor */
    public Ismhlm(Date hlmcreatedate, Long hlmcreatedby, Date hlmdate, String hlmdeleted, Date hlmmodidate, Long hlmreason,  com.sellerportal.model.Ismcnd ismcnd) {
        this.hlmcreatedate = hlmcreatedate;
        this.hlmcreatedby = hlmcreatedby;
        this.hlmdate = hlmdate;
        this.hlmdeleted = hlmdeleted;
        this.hlmmodidate = hlmmodidate;
        this.hlmreason = hlmreason;
        this.ismcnd = ismcnd;
    }

    /** 
     * 		       auto_increment
     * 		    
     */
    public Long getHlmrfnum() {
        return this.hlmrfnum;
    }

    public void setHlmrfnum(Long hlmrfnum) {
        this.hlmrfnum = hlmrfnum;
    }

    public Date getHlmcreatedate() {
        return this.hlmcreatedate;
    }

    public void setHlmcreatedate(Date hlmcreatedate) {
        this.hlmcreatedate = hlmcreatedate;
    }

    public Long getHlmcreatedby() {
        return this.hlmcreatedby;
    }

    public void setHlmcreatedby(Long hlmcreatedby) {
        this.hlmcreatedby = hlmcreatedby;
    }

    public Date getHlmdate() {
        return this.hlmdate;
    }

    public void setHlmdate(Date hlmdate) {
        this.hlmdate = hlmdate;
    }

    public String getHlmdeleted() {
        return this.hlmdeleted;
    }

    public void setHlmdeleted(String hlmdeleted) {
        this.hlmdeleted = hlmdeleted;
    }

    public Date getHlmmodidate() {
        return this.hlmmodidate;
    }

    public void setHlmmodidate(Date hlmmodidate) {
        this.hlmmodidate = hlmmodidate;
    }

    public String getHlmname() {
        return this.hlmname;
    }

    public void setHlmname(String hlmname) {
        this.hlmname = hlmname;
    }

    public Long getHlmreason() {
        return this.hlmreason;
    }

    public void setHlmreason(Long hlmreason) {
        this.hlmreason = hlmreason;
    }

    public  com.sellerportal.model.Ismcnd getIsmcnd() {
        return this.ismcnd;
    }

    public void setIsmcnd( com.sellerportal.model.Ismcnd ismcnd) {
        this.ismcnd = ismcnd;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("hlmrfnum", getHlmrfnum())
            .toString();
    }

}
