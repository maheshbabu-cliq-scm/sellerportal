package com.sellerportal.model;

import java.io.Serializable;
import java.util.Date;

import org.apache.commons.lang.builder.ToStringBuilder;
import javax.persistence.*;


@Entity
@Table(name = "OCTUEA")
public class Octuea extends ParentPojo implements Serializable {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "UEARFNUM")
    private Long uearfnum;

    @Column(name = "CREATEDATE", nullable = false)
    private Date createdate;

    @Column(name = "CREATEDBY", nullable = false)
    private Long createdby;

    @Column(name = "DELETED", nullable = false, length = 1)
    private String deleted;

    @Column(name = "MODIDATE", nullable = false)
    private Date modidate;

    @Column(name = "UEAAGE", length = 20)
    private Long ueaage;

    @Column(name = "UEADATE", length = 10)
    private Date ueadate;

    @Column(name = "UEADESC", length = 128)
    private String ueadesc;

    @Column(name = "UEANAME", length = 128)
    private String ueaname;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "UEACNDOCCUR", nullable = false)
    private Ismcnd ismcndByUeacndoccur;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "UEACNDEVENT", nullable = false)
    private Ismcnd ismcndByUeacndevent;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "UEAUBIRFNUM", nullable = false)
    private Ismubi ismubi;

    /** full constructor */
    public Octuea(Date createdate, Long createdby, String deleted, Date modidate, Long ueaage, Date ueadate, String ueadesc, String ueaname,  com.sellerportal.model.Ismcnd ismcndByUeacndoccur,  com.sellerportal.model.Ismcnd ismcndByUeacndevent,  com.sellerportal.model.Ismubi ismubi) {
        this.createdate = createdate;
        this.createdby = createdby;
        this.deleted = deleted;
        this.modidate = modidate;
        this.ueaage = ueaage;
        this.ueadate = ueadate;
        this.ueadesc = ueadesc;
        this.ueaname = ueaname;
        this.ismcndByUeacndoccur = ismcndByUeacndoccur;
        this.ismcndByUeacndevent = ismcndByUeacndevent;
        this.ismubi = ismubi;
    }

    /** default constructor */
    public Octuea() {
    }

    /** minimal constructor */
    public Octuea(Date createdate, Long createdby, String deleted, Date modidate,  com.sellerportal.model.Ismcnd ismcndByUeacndoccur,  com.sellerportal.model.Ismcnd ismcndByUeacndevent,  com.sellerportal.model.Ismubi ismubi) {
        this.createdate = createdate;
        this.createdby = createdby;
        this.deleted = deleted;
        this.modidate = modidate;
        this.ismcndByUeacndoccur = ismcndByUeacndoccur;
        this.ismcndByUeacndevent = ismcndByUeacndevent;
        this.ismubi = ismubi;
    }

    /** 
     * 		       auto_increment
     * 		    
     */
    public Long getUearfnum() {
        return this.uearfnum;
    }

    public void setUearfnum(Long uearfnum) {
        this.uearfnum = uearfnum;
    }

    public Long getUeaage() {
        return this.ueaage;
    }

    public void setUeaage(Long ueaage) {
        this.ueaage = ueaage;
    }

    public Date getUeadate() {
        return this.ueadate;
    }

    public void setUeadate(Date ueadate) {
        this.ueadate = ueadate;
    }

    public String getUeadesc() {
        return this.ueadesc;
    }

    public void setUeadesc(String ueadesc) {
        this.ueadesc = ueadesc;
    }

    public String getUeaname() {
        return this.ueaname;
    }

    public void setUeaname(String ueaname) {
        this.ueaname = ueaname;
    }

    public  com.sellerportal.model.Ismcnd getIsmcndByUeacndoccur() {
        return this.ismcndByUeacndoccur;
    }

    public void setIsmcndByUeacndoccur( com.sellerportal.model.Ismcnd ismcndByUeacndoccur) {
        this.ismcndByUeacndoccur = ismcndByUeacndoccur;
    }

    public  com.sellerportal.model.Ismcnd getIsmcndByUeacndevent() {
        return this.ismcndByUeacndevent;
    }

    public void setIsmcndByUeacndevent( com.sellerportal.model.Ismcnd ismcndByUeacndevent) {
        this.ismcndByUeacndevent = ismcndByUeacndevent;
    }

    public  com.sellerportal.model.Ismubi getIsmubi() {
        return this.ismubi;
    }

    public void setIsmubi( com.sellerportal.model.Ismubi ismubi) {
        this.ismubi = ismubi;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("uearfnum", getUearfnum())
            .toString();
    }

}
