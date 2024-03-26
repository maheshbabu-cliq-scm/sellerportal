package com.sellerportal.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.*;

import org.apache.commons.lang.builder.ToStringBuilder;


@Entity
@Table(name = "ISMBCO")
public class Ismbco implements Serializable {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bcorfnum;

	@Column(name = "BCOCCORDERRFNUM", length = 64)
    private String bcoccorderrfnum;

    @Column(name = "BCOPAYMENTDISC", length = 10)
    private BigDecimal bcopaymentdisc;

    @Column(name = "BCOPAYMENTSCHARGE", length = 10)
    private BigDecimal bcopaymentscharge;

    @Column(name = "BCOPMNUM", length = 254)
    private String bcopmnum;

    @Column(name = "BCOPMTAMT", nullable = false, length = 20)
    private BigDecimal bcopmtamt;

    @Column(name = "CREATEDATE")
    private Date createdate;

    @Column(name = "CREATEDBY", nullable = false, length = 20)
    private Long createdby;

    @Column(name = "DELETED", nullable = false, length = 1)
    private String deleted;

    @Column(name = "MODIDATE")
    private Date modidate;

    @ManyToOne
    @JoinColumn(name = "BCOPMTRFNUM", nullable = false)
    private Ismpmt ismpmt;

    @ManyToOne
    @JoinColumn(name = "BCOUBIRFNUM", nullable = false)
    private Ismubi ismubi;

    @ManyToOne
    @JoinColumn(name = "BCOCCARFNUM", nullable = false)
    private Ismcca ismcca;
    
    /** full constructor */
    public Ismbco(String bcoccorderrfnum, BigDecimal bcopaymentdisc, BigDecimal bcopaymentscharge, String bcopmnum, BigDecimal bcopmtamt, Date createdate, Long createdby, String deleted, Date modidate, com.sellerportal.model.Ismpmt ismpmt, com.sellerportal.model.Ismubi ismubi, com.sellerportal.model.Ismcca ismcca) {
        this.bcoccorderrfnum = bcoccorderrfnum;
        this.bcopaymentdisc = bcopaymentdisc;
        this.bcopaymentscharge = bcopaymentscharge;
        this.bcopmnum = bcopmnum;
        this.bcopmtamt = bcopmtamt;
        this.createdate = createdate;
        this.createdby = createdby;
        this.deleted = deleted;
        this.modidate = modidate;
        this.ismpmt = ismpmt;
        this.ismubi = ismubi;
        this.ismcca = ismcca;
    }

    /** default constructor */
    public Ismbco() {
    }

    /** minimal constructor */
    public Ismbco(BigDecimal bcopmtamt, Long createdby, String deleted, com.sellerportal.model.Ismpmt ismpmt, com.sellerportal.model.Ismubi ismubi, com.sellerportal.model.Ismcca ismcca) {
        this.bcopmtamt = bcopmtamt;
        this.createdby = createdby;
        this.deleted = deleted;
        this.ismpmt = ismpmt;
        this.ismubi = ismubi;
        this.ismcca = ismcca;
    }

    /** 
     * 		       auto_increment
     * 		    
     */
    public Long getBcorfnum() {
        return this.bcorfnum;
    }

    public void setBcorfnum(Long bcorfnum) {
        this.bcorfnum = bcorfnum;
    }

    public String getBcoccorderrfnum() {
        return this.bcoccorderrfnum;
    }

    public void setBcoccorderrfnum(String bcoccorderrfnum) {
        this.bcoccorderrfnum = bcoccorderrfnum;
    }

    public BigDecimal getBcopaymentdisc() {
        return this.bcopaymentdisc;
    }

    public void setBcopaymentdisc(BigDecimal bcopaymentdisc) {
        this.bcopaymentdisc = bcopaymentdisc;
    }

    public BigDecimal getBcopaymentscharge() {
        return this.bcopaymentscharge;
    }

    public void setBcopaymentscharge(BigDecimal bcopaymentscharge) {
        this.bcopaymentscharge = bcopaymentscharge;
    }

    public String getBcopmnum() {
        return this.bcopmnum;
    }

    public void setBcopmnum(String bcopmnum) {
        this.bcopmnum = bcopmnum;
    }

    public BigDecimal getBcopmtamt() {
        return this.bcopmtamt;
    }

    public void setBcopmtamt(BigDecimal bcopmtamt) {
        this.bcopmtamt = bcopmtamt;
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

    public com.sellerportal.model.Ismpmt getIsmpmt() {
        return this.ismpmt;
    }

    public void setIsmpmt(com.sellerportal.model.Ismpmt ismpmt) {
        this.ismpmt = ismpmt;
    }

    public com.sellerportal.model.Ismubi getIsmubi() {
        return this.ismubi;
    }

    public void setIsmubi(com.sellerportal.model.Ismubi ismubi) {
        this.ismubi = ismubi;
    }

    public com.sellerportal.model.Ismcca getIsmcca() {
        return this.ismcca;
    }

    public void setIsmcca(com.sellerportal.model.Ismcca ismcca) {
        this.ismcca = ismcca;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("bcorfnum", getBcorfnum())
            .toString();
    }

}
