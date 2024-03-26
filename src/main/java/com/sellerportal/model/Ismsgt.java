package com.sellerportal.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import org.apache.commons.lang.builder.ToStringBuilder;
import javax.persistence.*;

@Entity
@Table(name = "ISMSGT")
public class Ismsgt implements Serializable {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "SGTRFNUM")
    private Long sgtrfnum;

    @Column(name = "CREATEDATE", nullable = false)
    private Date createdate;

    @Column(name = "CREATEDBY", nullable = false)
    private Long createdby;

    @Column(name = "DELETED", nullable = false, length = 1)
    private String deleted;

    @Column(name = "MODIDATE", nullable = false)
    private Date modidate;

    @Column(name = "SGTDISCVALUE", nullable = false, length = 8)
    private BigDecimal sgtdiscvalue;

    @Column(name = "SGTISACTIVE", nullable = false, length = 1)
    private String sgtisactive;

    @Column(name = "SGTISADMIN", nullable = false, length = 1)
    private String sgtisadmin;

    @Column(name = "SGTISPERCENT", nullable = false, length = 1)
    private String sgtispercent;

    @Column(name = "SGTMAXQTY", length = 11)
    private Integer sgtmaxqty;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "SGTVSMRFNUM", nullable = false)
    private Ismvsm ismvsm;

    /** persistent field */

    /** full constructor */
    public Ismsgt(Date createdate, Long createdby, String deleted, Date modidate, BigDecimal sgtdiscvalue, String sgtisactive, String sgtisadmin, String sgtispercent, Integer sgtmaxqty,com.sellerportal.model.Ismvsm ismvsm) {
        this.createdate = createdate;
        this.createdby = createdby;
        this.deleted = deleted;
        this.modidate = modidate;
        this.sgtdiscvalue = sgtdiscvalue;
        this.sgtisactive = sgtisactive;
        this.sgtisadmin = sgtisadmin;
        this.sgtispercent = sgtispercent;
        this.sgtmaxqty = sgtmaxqty;
        this.ismvsm = ismvsm;
    }

    /** default constructor */
    public Ismsgt() {
    }

    /** minimal constructor */
    public Ismsgt(Date createdate, Long createdby, String deleted, Date modidate, BigDecimal sgtdiscvalue, String sgtisactive, String sgtisadmin, String sgtispercent,com.sellerportal.model.Ismvsm ismvsm) {
        this.createdate = createdate;
        this.createdby = createdby;
        this.deleted = deleted;
        this.modidate = modidate;
        this.sgtdiscvalue = sgtdiscvalue;
        this.sgtisactive = sgtisactive;
        this.sgtisadmin = sgtisadmin;
        this.sgtispercent = sgtispercent;
        this.ismvsm = ismvsm;
    }

    /** 
     * 		       auto_increment
     * 		    
     */
    public Long getSgtrfnum() {
        return this.sgtrfnum;
    }

    public void setSgtrfnum(Long sgtrfnum) {
        this.sgtrfnum = sgtrfnum;
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

    public BigDecimal getSgtdiscvalue() {
        return this.sgtdiscvalue;
    }

    public void setSgtdiscvalue(BigDecimal sgtdiscvalue) {
        this.sgtdiscvalue = sgtdiscvalue;
    }

    public String getSgtisactive() {
        return this.sgtisactive;
    }

    public void setSgtisactive(String sgtisactive) {
        this.sgtisactive = sgtisactive;
    }

    public String getSgtisadmin() {
        return this.sgtisadmin;
    }

    public void setSgtisadmin(String sgtisadmin) {
        this.sgtisadmin = sgtisadmin;
    }

    public String getSgtispercent() {
        return this.sgtispercent;
    }

    public void setSgtispercent(String sgtispercent) {
        this.sgtispercent = sgtispercent;
    }

    public Integer getSgtmaxqty() {
        return this.sgtmaxqty;
    }

    public void setSgtmaxqty(Integer sgtmaxqty) {
        this.sgtmaxqty = sgtmaxqty;
    }

    public com.sellerportal.model.Ismvsm getIsmvsm() {
        return this.ismvsm;
    }

    public void setIsmvsm(com.sellerportal.model.Ismvsm ismvsm) {
        this.ismvsm = ismvsm;
    }


    public String toString() {
        return new ToStringBuilder(this)
            .append("sgtrfnum", getSgtrfnum())
            .toString();
    }

}
