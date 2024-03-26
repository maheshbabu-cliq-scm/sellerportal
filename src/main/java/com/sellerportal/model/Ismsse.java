package com.sellerportal.model;

import java.io.Serializable;
import java.util.Date;

import org.apache.commons.lang.builder.ToStringBuilder;
import javax.persistence.*;

@Entity
@Table(name = "ISMSSE")
public class Ismsse implements Serializable {

	@Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sserfnum_sequence")
    @SequenceGenerator(name = "sserfnum_sequence", sequenceName = "ISMSSE_SSERFNUM_SEQ", allocationSize = 1)
    @Column(name = "SSERFNUM")
    private Long sserfnum;

    @Column(name = "CREATEDATE", nullable = false)
    private Date createdate;

    @Column(name = "CREATEDBY", nullable = false, length = 20)
    private Long createdby;

    @Column(name = "DELETED", nullable = false, length = 1)
    private String deleted;

    @Column(name = "MODIDATE", nullable = false)
    private Date modidate;

    @Column(name = "SSEAFMRFNUM", length = 20)
    private Long sseafmrfnum;

    @Column(name = "SSECMTRFNUM", length = 20)
    private Long ssecmtrfnum;

    @Column(name = "SSEISDEFAULT", length = 1)
    private String sseisdefault;

    @Column(name = "SSESENDBUYER", length = 1)
    private String ssesendbuyer;

    @Column(name = "SSESENDSELLER", length = 1)
    private String ssesendseller;

    @Column(name = "SSESMTRFNUM", length = 20)
    private Long ssesmtrfnum;

    @Column(name = "SSESSIRFNUM", length = 20)
    private Long ssessirfnum;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "SSESSTRFNUM", nullable = false)
    private Ismssu ismssu;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "SSEMDMRFNUM", nullable = false)
    private Ismmdm ismmdmBySsemdmrfnum;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "SSEMDMRFNUMAFM", nullable = false)
    private Ismmdm ismmdmBySsemdmrfnumafm;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "SSEMTMRFNUM", nullable = false)
    private Ismmtm ismmtm;

    /** full constructor */
    public Ismsse(Date createdate, Long createdby, String deleted, Date modidate, Long sseafmrfnum, Long ssecmtrfnum, String sseisdefault, String ssesendbuyer, String ssesendseller, Long ssesmtrfnum, Long ssessirfnum, com.sellerportal.model.Ismssu ismssu, com.sellerportal.model.Ismmdm ismmdmBySsemdmrfnum, com.sellerportal.model.Ismmdm ismmdmBySsemdmrfnumafm, com.sellerportal.model.Ismmtm ismmtm) {
        this.createdate = createdate;
        this.createdby = createdby;
        this.deleted = deleted;
        this.modidate = modidate;
        this.sseafmrfnum = sseafmrfnum;
        this.ssecmtrfnum = ssecmtrfnum;
        this.sseisdefault = sseisdefault;
        this.ssesendbuyer = ssesendbuyer;
        this.ssesendseller = ssesendseller;
        this.ssesmtrfnum = ssesmtrfnum;
        this.ssessirfnum = ssessirfnum;
        this.ismssu = ismssu;
        this.ismmdmBySsemdmrfnum = ismmdmBySsemdmrfnum;
        this.ismmdmBySsemdmrfnumafm = ismmdmBySsemdmrfnumafm;
        this.ismmtm = ismmtm;
    }

    /** default constructor */
    public Ismsse() {
    }

    /** minimal constructor */
    public Ismsse(Date createdate, Long createdby, String deleted, Date modidate, com.sellerportal.model.Ismssu ismssu, com.sellerportal.model.Ismmdm ismmdmBySsemdmrfnum, com.sellerportal.model.Ismmdm ismmdmBySsemdmrfnumafm, com.sellerportal.model.Ismmtm ismmtm) {
        this.createdate = createdate;
        this.createdby = createdby;
        this.deleted = deleted;
        this.modidate = modidate;
        this.ismssu = ismssu;
        this.ismmdmBySsemdmrfnum = ismmdmBySsemdmrfnum;
        this.ismmdmBySsemdmrfnumafm = ismmdmBySsemdmrfnumafm;
        this.ismmtm = ismmtm;
    }

    /** 
     * 		       auto_increment
     * 		    
     */
    public Long getSserfnum() {
        return this.sserfnum;
    }

    public void setSserfnum(Long sserfnum) {
        this.sserfnum = sserfnum;
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

    public Long getSseafmrfnum() {
        return this.sseafmrfnum;
    }

    public void setSseafmrfnum(Long sseafmrfnum) {
        this.sseafmrfnum = sseafmrfnum;
    }

    public Long getSsecmtrfnum() {
        return this.ssecmtrfnum;
    }

    public void setSsecmtrfnum(Long ssecmtrfnum) {
        this.ssecmtrfnum = ssecmtrfnum;
    }

    public String getSseisdefault() {
        return this.sseisdefault;
    }

    public void setSseisdefault(String sseisdefault) {
        this.sseisdefault = sseisdefault;
    }

    public String getSsesendbuyer() {
        return this.ssesendbuyer;
    }

    public void setSsesendbuyer(String ssesendbuyer) {
        this.ssesendbuyer = ssesendbuyer;
    }

    public String getSsesendseller() {
        return this.ssesendseller;
    }

    public void setSsesendseller(String ssesendseller) {
        this.ssesendseller = ssesendseller;
    }

    public Long getSsesmtrfnum() {
        return this.ssesmtrfnum;
    }

    public void setSsesmtrfnum(Long ssesmtrfnum) {
        this.ssesmtrfnum = ssesmtrfnum;
    }

    public Long getSsessirfnum() {
        return this.ssessirfnum;
    }

    public void setSsessirfnum(Long ssessirfnum) {
        this.ssessirfnum = ssessirfnum;
    }

    public com.sellerportal.model.Ismssu getIsmssu() {
        return this.ismssu;
    }

    public void setIsmssu(com.sellerportal.model.Ismssu ismssu) {
        this.ismssu = ismssu;
    }

    public com.sellerportal.model.Ismmdm getIsmmdmBySsemdmrfnum() {
        return this.ismmdmBySsemdmrfnum;
    }

    public void setIsmmdmBySsemdmrfnum(com.sellerportal.model.Ismmdm ismmdmBySsemdmrfnum) {
        this.ismmdmBySsemdmrfnum = ismmdmBySsemdmrfnum;
    }

    public com.sellerportal.model.Ismmdm getIsmmdmBySsemdmrfnumafm() {
        return this.ismmdmBySsemdmrfnumafm;
    }

    public void setIsmmdmBySsemdmrfnumafm(com.sellerportal.model.Ismmdm ismmdmBySsemdmrfnumafm) {
        this.ismmdmBySsemdmrfnumafm = ismmdmBySsemdmrfnumafm;
    }

    public com.sellerportal.model.Ismmtm getIsmmtm() {
        return this.ismmtm;
    }

    public void setIsmmtm(com.sellerportal.model.Ismmtm ismmtm) {
        this.ismmtm = ismmtm;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("sserfnum", getSserfnum())
            .toString();
    }

}
