package com.sellerportal.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import org.apache.commons.lang.builder.ToStringBuilder;
import javax.persistence.*;

@Entity
@Table(name = "ISMPVM")
public class Ismpvm implements Serializable {

	@Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pvm_generator")
    @SequenceGenerator(name="pvm_generator", sequenceName = "PVM_SEQ", allocationSize=1)
    @Column(name = "PVMRFNUM")
    private Long pvmrfnum;

    @Column(name = "CREATEDATE", nullable = false)
    private Date createdate;

    @Column(name = "CREATEDBY", nullable = false)
    private Long createdby;

    @Column(name = "DELETED", nullable = false, length = 1)
    private String deleted;

    @Column(name = "MODIDATE", nullable = false)
    private Date modidate;

    @Column(name = "PVMDESC", length = 2048)
    private String pvmdesc;

    @Column(name = "PVMNAME", nullable = false, length = 128)
    private String pvmname;

    @OneToMany(mappedBy = "ismpvm", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Ismsvu> ismsvus;

    /** full constructor */
    public Ismpvm(Date createdate, Long createdby, String deleted, Date modidate, String pvmdesc, String pvmname, Set ismsvus) {
        this.createdate = createdate;
        this.createdby = createdby;
        this.deleted = deleted;
        this.modidate = modidate;
        this.pvmdesc = pvmdesc;
        this.pvmname = pvmname;
        this.ismsvus = ismsvus;
    }

    /** default constructor */
    public Ismpvm() {
    }

    /** minimal constructor */
    public Ismpvm(Date createdate, Long createdby, String deleted, Date modidate, String pvmname, Set ismsvus) {
        this.createdate = createdate;
        this.createdby = createdby;
        this.deleted = deleted;
        this.modidate = modidate;
        this.pvmname = pvmname;
        this.ismsvus = ismsvus;
    }

    /** 
     * 		       auto_increment
     * 		    
     */
    public Long getPvmrfnum() {
        return this.pvmrfnum;
    }

    public void setPvmrfnum(Long pvmrfnum) {
        this.pvmrfnum = pvmrfnum;
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

    public String getPvmdesc() {
        return this.pvmdesc;
    }

    public void setPvmdesc(String pvmdesc) {
        this.pvmdesc = pvmdesc;
    }

    public String getPvmname() {
        return this.pvmname;
    }

    public void setPvmname(String pvmname) {
        this.pvmname = pvmname;
    }

    public Set getIsmsvus() {
        return this.ismsvus;
    }

    public void setIsmsvus(Set ismsvus) {
        this.ismsvus = ismsvus;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("pvmrfnum", getPvmrfnum())
            .toString();
    }

}
