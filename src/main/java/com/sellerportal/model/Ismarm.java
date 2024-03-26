package com.sellerportal.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import org.apache.commons.lang.builder.ToStringBuilder;
import javax.persistence.*;

@Entity
@Table(name = "ISMARM")
public class Ismarm implements Serializable {

	@Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ismarm_sequence")
    @SequenceGenerator(name = "ismarm_sequence", sequenceName = "ISMARM_ARMRFNUM_SEQ", allocationSize = 1)
    @Column(name = "ARMRFNUM")
    private Long armrfnum;

    @Column(name = "ARMACTIVE", length = 1)
    private String armactive;

    @Column(name = "ARMROLENAME", nullable = false, length = 128)
    private String armrolename;

    @Column(name = "CREATEDATE", nullable = false)
    private Date createdate;

    @Column(name = "CREATEDBY", nullable = false)
    private Long createdby;

    @Column(name = "DELETED", nullable = false, length = 1)
    private String deleted;

    @Column(name = "MODIDATE", nullable = false)
    private Date modidate;

    @OneToMany(mappedBy = "ismarm", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Ismaur> ismaurs;

    @OneToMany(mappedBy = "ismarm", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Ismacr> ismacrs;
    
    @Column(name = "ARMROLECODE", nullable = false, length = 128)
    private String armrolecode;

    /** full constructor */
    public Ismarm(String armactive, String armrolename, Date createdate, Long createdby, String deleted, Date modidate, Set ismaurs, Set ismacrs, String armrolecode) {
        this.armactive = armactive;
        this.armrolename = armrolename;
        this.createdate = createdate;
        this.createdby = createdby;
        this.deleted = deleted;
        this.modidate = modidate;
        this.ismaurs = ismaurs;
        this.ismacrs = ismacrs;
        this.armrolecode = armrolecode;
        
    }

    /** default constructor */
    public Ismarm() {
    }

    /** minimal constructor */
    public Ismarm(String armrolename, Date createdate, Long createdby, String deleted, Date modidate, Set ismaurs, Set ismacrs, String armrolecode) {
        this.armrolename = armrolename;
        this.createdate = createdate;
        this.createdby = createdby;
        this.deleted = deleted;
        this.modidate = modidate;
        this.ismaurs = ismaurs;
        this.ismacrs = ismacrs;
        this.armrolecode=armrolecode;
    }

    /** 
     * 		       auto_increment
     * 		    
     */
    public Long getArmrfnum() {
        return this.armrfnum;
    }

    public void setArmrfnum(Long armrfnum) {
        this.armrfnum = armrfnum;
    }

    public String getArmactive() {
        return this.armactive;
    }

    public void setArmactive(String armactive) {
        this.armactive = armactive;
    }

    public String getArmrolename() {
        return this.armrolename;
    }

    public void setArmrolename(String armrolename) {
        this.armrolename = armrolename;
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

    public Set getIsmaurs() {
        return this.ismaurs;
    }

    public void setIsmaurs(Set ismaurs) {
        this.ismaurs = ismaurs;
    }

    public Set getIsmacrs() {
        return this.ismacrs;
    }

    public void setIsmacrs(Set ismacrs) {
        this.ismacrs = ismacrs;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("armrfnum", getArmrfnum())
            .toString();
    }

	public String getArmrolecode() {
		return armrolecode;
	}

	public void setArmrolecode(String armrolecode) {
		this.armrolecode = armrolecode;
	}
}