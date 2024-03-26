package com.sellerportal.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import org.apache.commons.lang.builder.ToStringBuilder;
import javax.persistence.*;

/** @author Hibernate CodeGenerator */
@Entity
@Table(name = "ISMCCR")
public class Ismccr implements Serializable {

	@Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ccrrfnum_sequence")
    @SequenceGenerator(name = "ccrrfnum_sequence", sequenceName = "ISMCCR_CCRRFNUM_SEQ", allocationSize = 1)
    @Column(name = "CCRRFNUM")
    private Long ccrrfnum;

    @Column(name = "CCRISALLCHILD", length = 1)
    private String ccrisallchild;

    @Column(name = "CREATEDATE", nullable = false)
    private Date createdate;

    @Column(name = "CREATEDBY", nullable = false, length = 20)
    private Long createdby;

    @Column(name = "DELETED", nullable = false, length = 1)
    private String deleted;

    @Column(name = "MODIDATE", nullable = false)
    private Date modidate;

    @Column(name = "MODIFIEDBY", nullable = false, length = 20)
    private Long modifiedby;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CCRPRODFOOTER", nullable = false)
    private Ismdem ismdemByCcrprodfooter;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CCRCATEBODY", nullable = false)
    private Ismdem ismdemByCcrcatebody;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CCRPRODHEADER", nullable = false)
    private Ismdem ismdemByCcrprodheader;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CCRPRODBODY", nullable = false)
    private Ismdem ismdemByCcrprodbody;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CCRCATEFOOTER", nullable = false)
    private Ismdem ismdemByCcrcatefooter;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CCRCATEHEADER", nullable = false)
    private Ismdem ismdemByCcrcateheader;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CCRCMTRFNUM", nullable = false)
    private Ismcmt ismcmt;

    @OneToMany(mappedBy = "ismccr", fetch = FetchType.LAZY)
    @Transient
    private Set<Ismpcc> ismpccs;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CCRMCTRFNUM", nullable = false)
    private Ismmct ismmct;
    /** full constructor */
    public Ismccr(String ccrisallchild, Date createdate, Long createdby, String deleted, Date modidate, com.sellerportal.model.Ismdem ismdemByCcrprodfooter, com.sellerportal.model.Ismdem ismdemByCcrcatebody, com.sellerportal.model.Ismdem ismdemByCcrprodheader, com.sellerportal.model.Ismdem ismdemByCcrprodbody, com.sellerportal.model.Ismdem ismdemByCcrcatefooter, com.sellerportal.model.Ismdem ismdemByCcrcateheader, com.sellerportal.model.Ismcmt ismcmt, com.sellerportal.model.Ismmct ismmct, Set<Ismpcc> ismpccs,Long modifiedby) {
        this.ccrisallchild = ccrisallchild;
        this.createdate = createdate;
        this.createdby = createdby;
        this.deleted = deleted;
        this.modidate = modidate;
        this.ismdemByCcrprodfooter = ismdemByCcrprodfooter;
        this.ismdemByCcrcatebody = ismdemByCcrcatebody;
        this.ismdemByCcrprodheader = ismdemByCcrprodheader;
        this.ismdemByCcrprodbody = ismdemByCcrprodbody;
        this.ismdemByCcrcatefooter = ismdemByCcrcatefooter;
        this.ismdemByCcrcateheader = ismdemByCcrcateheader;
        this.ismcmt = ismcmt;
        this.ismmct = ismmct;
        this.ismpccs = ismpccs;
        this.modifiedby=modifiedby;
    }

    /** default constructor */
    public Ismccr() {
    }

    /** minimal constructor */
    public Ismccr(Date createdate, Long createdby, String deleted, Date modidate, com.sellerportal.model.Ismdem ismdemByCcrprodfooter, com.sellerportal.model.Ismdem ismdemByCcrcatebody, com.sellerportal.model.Ismdem ismdemByCcrprodheader, com.sellerportal.model.Ismdem ismdemByCcrprodbody, com.sellerportal.model.Ismdem ismdemByCcrcatefooter, com.sellerportal.model.Ismdem ismdemByCcrcateheader, com.sellerportal.model.Ismcmt ismcmt, com.sellerportal.model.Ismmct ismmct, Set<Ismpcc> ismpccs) {
        this.createdate = createdate;
        this.createdby = createdby;
        this.deleted = deleted;
        this.modidate = modidate;
        this.ismdemByCcrprodfooter = ismdemByCcrprodfooter;
        this.ismdemByCcrcatebody = ismdemByCcrcatebody;
        this.ismdemByCcrprodheader = ismdemByCcrprodheader;
        this.ismdemByCcrprodbody = ismdemByCcrprodbody;
        this.ismdemByCcrcatefooter = ismdemByCcrcatefooter;
        this.ismdemByCcrcateheader = ismdemByCcrcateheader;
        this.ismcmt = ismcmt;
        this.ismmct = ismmct;
        this.ismpccs = ismpccs;
    }

    /** 
     * 		       auto_increment
     * 		    
     */
    
    public Long getCcrrfnum() {
        return this.ccrrfnum;
    }

    public Long getModifiedby() {
		return modifiedby;
	}

	public void setModifiedby(Long modifiedby) {
		this.modifiedby = modifiedby;
	}

	public void setCcrrfnum(Long ccrrfnum) {
        this.ccrrfnum = ccrrfnum;
    }

    public String getCcrisallchild() {
        return this.ccrisallchild;
    }

    public void setCcrisallchild(String ccrisallchild) {
        this.ccrisallchild = ccrisallchild;
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

    public com.sellerportal.model.Ismdem getIsmdemByCcrprodfooter() {
        return this.ismdemByCcrprodfooter;
    }

    public void setIsmdemByCcrprodfooter(com.sellerportal.model.Ismdem ismdemByCcrprodfooter) {
        this.ismdemByCcrprodfooter = ismdemByCcrprodfooter;
    }

    public com.sellerportal.model.Ismdem getIsmdemByCcrcatebody() {
        return this.ismdemByCcrcatebody;
    }

    public void setIsmdemByCcrcatebody(com.sellerportal.model.Ismdem ismdemByCcrcatebody) {
        this.ismdemByCcrcatebody = ismdemByCcrcatebody;
    }

    public com.sellerportal.model.Ismdem getIsmdemByCcrprodheader() {
        return this.ismdemByCcrprodheader;
    }

    public void setIsmdemByCcrprodheader(com.sellerportal.model.Ismdem ismdemByCcrprodheader) {
        this.ismdemByCcrprodheader = ismdemByCcrprodheader;
    }

    public com.sellerportal.model.Ismdem getIsmdemByCcrprodbody() {
        return this.ismdemByCcrprodbody;
    }

    public void setIsmdemByCcrprodbody(com.sellerportal.model.Ismdem ismdemByCcrprodbody) {
        this.ismdemByCcrprodbody = ismdemByCcrprodbody;
    }

    public com.sellerportal.model.Ismdem getIsmdemByCcrcatefooter() {
        return this.ismdemByCcrcatefooter;
    }

    public void setIsmdemByCcrcatefooter(com.sellerportal.model.Ismdem ismdemByCcrcatefooter) {
        this.ismdemByCcrcatefooter = ismdemByCcrcatefooter;
    }

    public com.sellerportal.model.Ismdem getIsmdemByCcrcateheader() {
        return this.ismdemByCcrcateheader;
    }

    public void setIsmdemByCcrcateheader(com.sellerportal.model.Ismdem ismdemByCcrcateheader) {
        this.ismdemByCcrcateheader = ismdemByCcrcateheader;
    }

    public com.sellerportal.model.Ismcmt getIsmcmt() {
        return this.ismcmt;
    }

    public void setIsmcmt(com.sellerportal.model.Ismcmt ismcmt) {
        this.ismcmt = ismcmt;
    }

    public com.sellerportal.model.Ismmct getIsmmct() {
        return this.ismmct;
    }

    public void setIsmmct(com.sellerportal.model.Ismmct ismmct) {
        this.ismmct = ismmct;
    }

    public Set<Ismpcc> getIsmpccs() {
        return this.ismpccs;
    }

    public void setIsmpccs(Set<Ismpcc> ismpccs) {
        this.ismpccs = ismpccs;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("ccrrfnum", getCcrrfnum())
            .toString();
    }

}
