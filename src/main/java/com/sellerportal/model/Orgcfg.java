package com.sellerportal.model;

import java.io.Serializable;
import java.util.Date;

import org.apache.commons.lang.builder.ToStringBuilder;
import javax.persistence.*;

@Entity
@Table(name = "ORGCFG")
public class Orgcfg implements Serializable {

	@Id
    @Column(name = "CFGNAME")
    private String cfgname;

    @Column(name = "CFGVALUE", nullable = false, length = 254)
    private String cfgvalue;

    @Column(name = "CREATEDATE", nullable = false)
    private Date createdate;

    @Column(name = "CREATEDBY", length = 20)
    private Long createdby;

    @Column(name = "DELETED", length = 1)
    private String deleted;

    @Column(name = "MODIDATE", nullable = false)
    private Date modidate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CFGGOTRFNUM", nullable = false)
    private Ismgot ismgot;

    /** full constructor */
    public Orgcfg(String cfgvalue, Date createdate, Long createdby, String deleted, Date modidate, com.sellerportal.model.Ismgot ismgot) {
        this.cfgvalue = cfgvalue;
        this.createdate = createdate;
        this.createdby = createdby;
        this.deleted = deleted;
        this.modidate = modidate;
        this.ismgot = ismgot;
    }

    /** default constructor */
    public Orgcfg() {
    }

    /** minimal constructor */
    public Orgcfg(String cfgvalue, Date createdate, Date modidate, com.sellerportal.model.Ismgot ismgot) {
        this.cfgvalue = cfgvalue;
        this.createdate = createdate;
        this.modidate = modidate;
        this.ismgot = ismgot;
    }

    public String getCfgname() {
        return this.cfgname;
    }

    public void setCfgname(String cfgname) {
        this.cfgname = cfgname;
    }

    public String getCfgvalue() {
        return this.cfgvalue;
    }

    public void setCfgvalue(String cfgvalue) {
        this.cfgvalue = cfgvalue;
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

    public com.sellerportal.model.Ismgot getIsmgot() {
        return this.ismgot;
    }

    public void setIsmgot(com.sellerportal.model.Ismgot ismgot) {
        this.ismgot = ismgot;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("cfgname", getCfgname())
            .toString();
    }

}
