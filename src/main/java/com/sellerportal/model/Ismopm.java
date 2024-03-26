package com.sellerportal.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;
import javax.persistence.*;

import org.apache.commons.lang.builder.ToStringBuilder;


@Entity
@Table(name = "ISMOPM")
public class Ismopm implements Serializable {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "OPMRFNUM")
    private Long opmrfnum;

    @Column(name = "CREATEDATE", nullable = false)
    private Date createdate;

    @Column(name = "CREATEDBY", nullable = false)
    private Long createdby;

    @Column(name = "DELETED", nullable = false, length = 1)
    private String deleted;

    @Column(name = "MODIDATE", nullable = false)
    private Date modidate;

    @Column(name = "OPMACTIVE", nullable = false, length = 1)
    private String opmactive;

    @Column(name = "OPMCMDMODULE")
    private Long opmcmdmodule;

    @Column(name = "OPMPAGENAME", nullable = false, length = 128)
    private String opmpagename;

    @OneToMany(mappedBy = "ismopm", fetch = FetchType.LAZY)
    @Transient
    private Set<Ismocm> ismocms;

    /** full constructor */
    public Ismopm(Date createdate, Long createdby, String deleted, Date modidate, String opmactive, Long opmcmdmodule, String opmpagename, Set<Ismocm> ismocms) {
        this.createdate = createdate;
        this.createdby = createdby;
        this.deleted = deleted;
        this.modidate = modidate;
        this.opmactive = opmactive;
        this.opmcmdmodule = opmcmdmodule;
        this.opmpagename = opmpagename;
        this.ismocms = ismocms;
    }

    /** default constructor */
    public Ismopm() {
    }

    /** minimal constructor */
    public Ismopm(Date createdate, Long createdby, String deleted, Date modidate, String opmactive, String opmpagename, Set<Ismocm> ismocms) {
        this.createdate = createdate;
        this.createdby = createdby;
        this.deleted = deleted;
        this.modidate = modidate;
        this.opmactive = opmactive;
        this.opmpagename = opmpagename;
        this.ismocms = ismocms;
    }

    /** 
     * 		       auto_increment
     * 		    
     */
    public Long getOpmrfnum() {
        return this.opmrfnum;
    }

    public void setOpmrfnum(Long opmrfnum) {
        this.opmrfnum = opmrfnum;
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

    public String getOpmactive() {
        return this.opmactive;
    }

    public void setOpmactive(String opmactive) {
        this.opmactive = opmactive;
    }

    public Long getOpmcmdmodule() {
        return this.opmcmdmodule;
    }

    public void setOpmcmdmodule(Long opmcmdmodule) {
        this.opmcmdmodule = opmcmdmodule;
    }

    public String getOpmpagename() {
        return this.opmpagename;
    }

    public void setOpmpagename(String opmpagename) {
        this.opmpagename = opmpagename;
    }

    public Set<Ismocm> getIsmocms() {
        return this.ismocms;
    }

    public void setIsmocms(Set<Ismocm> ismocms) {
        this.ismocms = ismocms;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("opmrfnum", getOpmrfnum())
            .toString();
    }

}
