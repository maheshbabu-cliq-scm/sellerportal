package com.sellerportal.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

import org.apache.commons.lang3.builder.ToStringBuilder;


@Entity
@Table(name = "ISMIPT")
public class Ismipt implements Serializable {

	@Id
    @Column(name = "IPTNAME", length = 50)
    private String iptname;

    @Column(name = "CREATEDATE", nullable = false)
    private Date createdate;

    @Column(name = "CREATEDBY", length = 20)
    private Long createdby;

    @Column(name = "DELETED", length = 1)
    private String deleted;

    @Column(name = "IPTVALUE", nullable = false, length = 254)
    private String iptvalue;

    @Column(name = "MODIDATE", nullable = false)
    private Date modidate;

    /** full constructor */
    public Ismipt(Date createdate, Long createdby, String deleted, String iptvalue, Date modidate) {
        this.createdate = createdate;
        this.createdby = createdby;
        this.deleted = deleted;
        this.iptvalue = iptvalue;
        this.modidate = modidate;
    }

    /** default constructor */
    public Ismipt() {
    }

    /** minimal constructor */
    public Ismipt(Date createdate, String iptvalue, Date modidate) {
        this.createdate = createdate;
        this.iptvalue = iptvalue;
        this.modidate = modidate;
    }

    public String getIptname() {
        return this.iptname;
    }

    public void setIptname(String iptname) {
        this.iptname = iptname;
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

    public String getIptvalue() {
        return this.iptvalue;
    }

    public void setIptvalue(String iptvalue) {
        this.iptvalue = iptvalue;
    }

    public Date getModidate() {
        return this.modidate;
    }

    public void setModidate(Date modidate) {
        this.modidate = modidate;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("iptname", getIptname())
            .toString();
    }

}
