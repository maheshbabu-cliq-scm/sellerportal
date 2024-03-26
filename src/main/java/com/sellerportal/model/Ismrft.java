package com.sellerportal.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import org.apache.commons.lang.builder.ToStringBuilder;
import javax.persistence.*;

@Entity
@Table(name = "ISMRFT")
public class Ismrft implements Serializable {

	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    @Column(name = "RFTRFNUM")
	    private Long rftrfnum;

	    @Column(name = "CREATEDATE", nullable = false)
	    private Date createdate;

	    @Column(name = "CREATEDBY", nullable = false, length = 20)
	    private Long createdby;

	    @Column(name = "DELETED", nullable = false, length = 1)
	    private String deleted;

	    @Column(name = "MODIDATE", nullable = false)
	    private Date modidate;

	    @Column(name = "RFTCOLNAME", nullable = false, length = 128)
	    private String rftcolname;

	    @Column(name = "RFTDESC", length = 2048)
	    private String rftdesc;

	    @Column(name = "RFTISORDER", length = 1)
	    private String rftisorder;

	    @Column(name = "RFTISSUBORDER", length = 1)
	    private String rftissuborder;

	    @Column(name = "RFTNAME", nullable = false, length = 128)
	    private String rftname;

	    @OneToMany(mappedBy = "ismrft", fetch = FetchType.LAZY)
	    @Transient
	    private Set<Ismrfa> ismrfas;

    /** full constructor */
    public Ismrft(Date createdate, Long createdby, String deleted, Date modidate, String rftcolname, String rftdesc, String rftisorder, String rftissuborder, String rftname, Set<Ismrfa> ismrfas) {
        this.createdate = createdate;
        this.createdby = createdby;
        this.deleted = deleted;
        this.modidate = modidate;
        this.rftcolname = rftcolname;
        this.rftdesc = rftdesc;
        this.rftisorder = rftisorder;
        this.rftissuborder = rftissuborder;
        this.rftname = rftname;
        this.ismrfas = ismrfas;
    }

    /** default constructor */
    public Ismrft() {
    }

    /** minimal constructor */
    public Ismrft(Date createdate, Long createdby, String deleted, Date modidate, String rftcolname, String rftname, Set<Ismrfa> ismrfas) {
        this.createdate = createdate;
        this.createdby = createdby;
        this.deleted = deleted;
        this.modidate = modidate;
        this.rftcolname = rftcolname;
        this.rftname = rftname;
        this.ismrfas = ismrfas;
    }

    /** 
     * 		       auto_increment
     * 		    
     */
    public Long getRftrfnum() {
        return this.rftrfnum;
    }

    public void setRftrfnum(Long rftrfnum) {
        this.rftrfnum = rftrfnum;
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

    public String getRftcolname() {
        return this.rftcolname;
    }

    public void setRftcolname(String rftcolname) {
        this.rftcolname = rftcolname;
    }

    public String getRftdesc() {
        return this.rftdesc;
    }

    public void setRftdesc(String rftdesc) {
        this.rftdesc = rftdesc;
    }

    public String getRftisorder() {
        return this.rftisorder;
    }

    public void setRftisorder(String rftisorder) {
        this.rftisorder = rftisorder;
    }

    public String getRftissuborder() {
        return this.rftissuborder;
    }

    public void setRftissuborder(String rftissuborder) {
        this.rftissuborder = rftissuborder;
    }

    public String getRftname() {
        return this.rftname;
    }

    public void setRftname(String rftname) {
        this.rftname = rftname;
    }

    public Set<Ismrfa> getIsmrfas() {
        return this.ismrfas;
    }

    public void setIsmrfas(Set<Ismrfa> ismrfas) {
        this.ismrfas = ismrfas;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("rftrfnum", getRftrfnum())
            .toString();
    }

}
