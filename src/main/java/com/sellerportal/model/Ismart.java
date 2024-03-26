package com.sellerportal.model;

import java.io.Serializable;
import java.util.Date;

import org.apache.commons.lang.builder.ToStringBuilder;
import javax.persistence.*;

@Entity
@Table(name = "ISMART")
public class Ismart implements Serializable {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ARTRFNUM")
    private Long artrfnum;

    @Column(name = "CREATEDATE", nullable = false)
    private Date createdate;

    @Column(name = "CREATEDBY", nullable = false, length = 20)
    private Long createdby;

    @Column(name = "DELETED", nullable = false, length = 1)
    private String deleted;

    @Column(name = "ISACTIVE", nullable = false, length = 1)
    private String isactive;

    @Column(name = "ISALL", nullable = false, length = 1)
    private String isall;

    @Column(name = "MODIDATE", nullable = false)
    private Date modidate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ARTGATRFNUM", nullable = false)
    private Ismgat ismgat;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ARTGOTRFNUM", nullable = false)
    private Ismgot ismgot;

    /** full constructor */
    public Ismart(Date createdate, Long createdby, String deleted, String isactive, String isall, Date modidate, com.sellerportal.model.Ismgat ismgat, com.sellerportal.model.Ismgot ismgot) {
        this.createdate = createdate;
        this.createdby = createdby;
        this.deleted = deleted;
        this.isactive = isactive;
        this.isall = isall;
        this.modidate = modidate;
        this.ismgat = ismgat;
        this.ismgot = ismgot;
    }

    /** default constructor */
    public Ismart() {
    }

    /** 
     * 		       auto_increment
     * 		    
     */
    public Long getArtrfnum() {
        return this.artrfnum;
    }

    public void setArtrfnum(Long artrfnum) {
        this.artrfnum = artrfnum;
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

    public String getIsactive() {
        return this.isactive;
    }

    public void setIsactive(String isactive) {
        this.isactive = isactive;
    }

    public String getIsall() {
        return this.isall;
    }

    public void setIsall(String isall) {
        this.isall = isall;
    }

    public Date getModidate() {
        return this.modidate;
    }

    public void setModidate(Date modidate) {
        this.modidate = modidate;
    }

    public com.sellerportal.model.Ismgat getIsmgat() {
        return this.ismgat;
    }

    public void setIsmgat(com.sellerportal.model.Ismgat ismgat) {
        this.ismgat = ismgat;
    }

    public com.sellerportal.model.Ismgot getIsmgot() {
        return this.ismgot;
    }

    public void setIsmgot(com.sellerportal.model.Ismgot ismgot) {
        this.ismgot = ismgot;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("artrfnum", getArtrfnum())
            .toString();
    }

}
