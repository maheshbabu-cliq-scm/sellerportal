package com.sellerportal.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import org.apache.commons.lang.builder.ToStringBuilder;
import javax.persistence.*;

@Entity
@Table(name = "OCTIAT")
public class Octiat implements Serializable {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IATRFNUM")
    private Long iatrfnum;

    @Column(name = "CREATEDATE", nullable = false)
    private Date createdate;

    @Column(name = "CREATEDBY", nullable = false)
    private Long createdby;

    @Column(name = "DELETED", nullable = false, length = 1)
    private String deleted;

    @Column(name = "MODIDATE", nullable = false)
    private Date modidate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "IATCNDBUSID", nullable = false)
    private Ismcnd ismcndByIatcndbusid;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "IATCNDCHANNELID", nullable = false)
    private Ismcnd ismcndByIatcndchannelid;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "IATPETRFNUM", nullable = false)
    private Ismpet ismpet;

    /** full constructor */
    public Octiat(Date createdate, Long createdby, String deleted, Date modidate,  com.sellerportal.model.Ismcnd ismcndByIatcndbusid,  com.sellerportal.model.Ismcnd ismcndByIatcndchannelid,  com.sellerportal.model.Ismpet ismpet) {
        this.createdate = createdate;
        this.createdby = createdby;
        this.deleted = deleted;
        this.modidate = modidate;
        this.ismcndByIatcndbusid = ismcndByIatcndbusid;
        this.ismcndByIatcndchannelid = ismcndByIatcndchannelid;
        this.ismpet = ismpet;
//        this.ismscls = ismscls;
    }

    /** default constructor */
    public Octiat() {
    }

    /** 
     * 		       auto_increment
     * 		    
     */
    public Long getIatrfnum() {
        return this.iatrfnum;
    }

    public void setIatrfnum(Long iatrfnum) {
        this.iatrfnum = iatrfnum;
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

    public  com.sellerportal.model.Ismcnd getIsmcndByIatcndbusid() {
        return this.ismcndByIatcndbusid;
    }

    public void setIsmcndByIatcndbusid( com.sellerportal.model.Ismcnd ismcndByIatcndbusid) {
        this.ismcndByIatcndbusid = ismcndByIatcndbusid;
    }

    public  com.sellerportal.model.Ismcnd getIsmcndByIatcndchannelid() {
        return this.ismcndByIatcndchannelid;
    }

    public void setIsmcndByIatcndchannelid( com.sellerportal.model.Ismcnd ismcndByIatcndchannelid) {
        this.ismcndByIatcndchannelid = ismcndByIatcndchannelid;
    }

    public  com.sellerportal.model.Ismpet getIsmpet() {
        return this.ismpet;
    }

    public void setIsmpet( com.sellerportal.model.Ismpet ismpet) {
        this.ismpet = ismpet;
    }

//    public Set getIsmscls() {
//        return this.ismscls;
//    }
//
//    public void setIsmscls(Set ismscls) {
//        this.ismscls = ismscls;
//    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("iatrfnum", getIatrfnum())
            .toString();
    }

}
