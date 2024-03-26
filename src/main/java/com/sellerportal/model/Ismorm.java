package com.sellerportal.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import org.apache.commons.lang.builder.ToStringBuilder;
import javax.persistence.*;

@Entity
@Table(name = "ISMORM")
public class Ismorm implements Serializable {

	@Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ismorm_generator")
    @SequenceGenerator(name="ismorm_generator", sequenceName = "ISMORM_ORMRFNUM_SEQ", allocationSize=1)
    @Column(name = "ORMRFNUM")
    private Long ormrfnum;

    @Column(name = "CREATEDATE", nullable = false)
    private Date createdate;

    @Column(name = "CREATEDBY", nullable = false)
    private Long createdby;

    @Column(name = "DELETED", nullable = false, length = 1)
    private String deleted;

    @Column(name = "MODIDATE", nullable = false)
    private Date modidate;

    @Column(name = "ORMACTIVE", nullable = false, length = 1)
    private String ormactive;

    @Column(name = "ORMROLENAME", nullable = false, length = 128)
    private String ormrolename;

    @OneToMany(mappedBy = "ismorm", fetch = FetchType.LAZY)
    private Set<Ismrot> ismrots;

    @OneToMany(mappedBy = "ismorm", fetch = FetchType.LAZY)
    private Set<Ismocr> ismocrs;

    @OneToMany(mappedBy = "ismorm", fetch = FetchType.LAZY)
    private Set<Ismour> ismours;

    @OneToMany(mappedBy = "ismorm", fetch = FetchType.LAZY)
    private Set<Ismrst> ismrsts;

    @OneToMany(mappedBy = "ismorm", fetch = FetchType.LAZY)
    private Set<Ismrsa> ismrsas;

    /** full constructor */
    public Ismorm(Date createdate, Long createdby, String deleted, Date modidate, String ormactive, String ormrolename, Set ismrots, Set ismocrs, Set ismours, Set ismrsts, Set ismrsas) {
        this.createdate = createdate;
        this.createdby = createdby;
        this.deleted = deleted;
        this.modidate = modidate;
        this.ormactive = ormactive;
        this.ormrolename = ormrolename;
        this.ismrots = ismrots;
        this.ismocrs = ismocrs;
        this.ismours = ismours;
        this.ismrsts = ismrsts;
        this.ismrsas = ismrsas;
    }

    /** default constructor */
    public Ismorm() {
    }

    /** 
     * 		       auto_increment
     * 		    
     */
    public Long getOrmrfnum() {
        return this.ormrfnum;
    }

    public void setOrmrfnum(Long ormrfnum) {
        this.ormrfnum = ormrfnum;
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

    public String getOrmactive() {
        return this.ormactive;
    }

    public void setOrmactive(String ormactive) {
        this.ormactive = ormactive;
    }

    public String getOrmrolename() {
        return this.ormrolename;
    }

    public void setOrmrolename(String ormrolename) {
        this.ormrolename = ormrolename;
    }

    public Set getIsmrots() {
        return this.ismrots;
    }

    public void setIsmrots(Set ismrots) {
        this.ismrots = ismrots;
    }

    public Set getIsmocrs() {
        return this.ismocrs;
    }

    public void setIsmocrs(Set ismocrs) {
        this.ismocrs = ismocrs;
    }

    public Set getIsmours() {
        return this.ismours;
    }

    public void setIsmours(Set ismours) {
        this.ismours = ismours;
    }

    public Set getIsmrsts() {
        return this.ismrsts;
    }

    public void setIsmrsts(Set ismrsts) {
        this.ismrsts = ismrsts;
    }

    public Set getIsmrsas() {
        return this.ismrsas;
    }

    public void setIsmrsas(Set ismrsas) {
        this.ismrsas = ismrsas;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("ormrfnum", getOrmrfnum())
            .toString();
    }

}
