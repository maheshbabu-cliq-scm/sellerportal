package com.sellerportal.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import org.apache.commons.lang.builder.ToStringBuilder;
import javax.persistence.*;

@Entity
@Table(name = "OCTAPP")
public class Octapp implements Serializable {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "APPRFNUM")
    private Long apprfnum;

    @Column(name = "APPPRICE", length = 10)
    private BigDecimal appprice;

    @Column(name = "CREATEDATE", nullable = false)
    private Date createdate;

    @Column(name = "CREATEDBY", nullable = false, length = 20)
    private Long createdby;

    @Column(name = "DELETED", nullable = false, length = 1)
    private String deleted;

    @Column(name = "MODIDATE", nullable = false)
    private Date modidate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "APPCNDRFNUM", nullable = false)
    private Ismcnd ismcnd;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "APPAFMRFNUM", nullable = false)
    private Ismafm ismafm;
    
    /** full constructor */
    public Octapp(BigDecimal appprice, Date createdate, Long createdby, String deleted, Date modidate,  com.sellerportal.model.Ismcnd ismcnd,  com.sellerportal.model.Ismafm ismafm ) {
        this.appprice = appprice;
        this.createdate = createdate;
        this.createdby = createdby;
        this.deleted = deleted;
        this.modidate = modidate;
        this.ismcnd = ismcnd;
        this.ismafm = ismafm;
        
    }

    /** default constructor */
    public Octapp() {
    }

    /** minimal constructor */
    public Octapp(Date createdate, Long createdby, String deleted, Date modidate,  com.sellerportal.model.Ismcnd ismcnd,  com.sellerportal.model.Ismafm ismafm ) {
        this.createdate = createdate;
        this.createdby = createdby;
        this.deleted = deleted;
        this.modidate = modidate;
        this.ismcnd = ismcnd;
        this.ismafm = ismafm;
        
    }

    /** 
     * 		       auto_increment
     * 		    
     */
    public Long getApprfnum() {
        return this.apprfnum;
    }

    public void setApprfnum(Long apprfnum) {
        this.apprfnum = apprfnum;
    }

    public BigDecimal getAppprice() {
        return this.appprice;
    }

    public void setAppprice(BigDecimal appprice) {
        this.appprice = appprice;
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

    public  com.sellerportal.model.Ismcnd getIsmcnd() {
        return this.ismcnd;
    }

    public void setIsmcnd( com.sellerportal.model.Ismcnd ismcnd) {
        this.ismcnd = ismcnd;
    }

    public  com.sellerportal.model.Ismafm getIsmafm() {
        return this.ismafm;
    }

    public void setIsmafm( com.sellerportal.model.Ismafm ismafm) {
        this.ismafm = ismafm;
    }

  
    public String toString() {
        return new ToStringBuilder(this)
            .append("apprfnum", getApprfnum())
            .toString();
    }

}
