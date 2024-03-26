package com.sellerportal.model;

import java.io.Serializable;
import java.util.Date;

import org.apache.commons.lang.builder.ToStringBuilder;
import javax.persistence.*;

@Entity
@Table(name = "OCT_CMT_TAX")
public class OctCmtTax implements Serializable {

	@Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "octcmttaxrfnum_generator")
    @SequenceGenerator(name = "octcmttaxrfnum_generator", sequenceName = "CMT_TAX_OCTCMTTAXRFNUM_SEQ", allocationSize = 1)
    @Column(name = "OCTCMTTAXRFNUM")
    private Long octcmttaxrfnum;

    @Column(name = "CREATEDATE", nullable = false)
    private Date createdate;

    @Column(name = "CREATEDBY", nullable = false, length = 20)
    private Long createdby;

    @Column(name = "DELETED", length = 1)
    private String deleted;

    @Column(name = "ISACTIVE", length = 1)
    private String isactive;

    @Column(name = "MODIDATE", nullable = false)
    private Date modidate;

    @Column(name = "MODIFIEDBY", length = 20)
    private Long modifiedby;

    @Column(name = "OCTCMTTAXUSSID", length = 10)
    private String octcmttaxussid;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "OCTCMTTAXCMT", nullable = false)
    private Ismcmt ismcmt;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "OCTCMTTAX_TAX", nullable = false)
    private OctTaxMstr octTaxMstr;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "OCTCMTTAX_STATE", nullable = false)
    private StateMaster octStateMaster;
    
    /** full constructor */
    public OctCmtTax(Date createdate, Long createdby, String deleted, String isactive, Date modidate, Long modifiedby, String octcmttaxussid, com.sellerportal.model.Ismcmt ismcmt, com.sellerportal.model.OctTaxMstr octTaxMstr, com.sellerportal.model.StateMaster octStateMaster) {
        this.createdate = createdate;
        this.createdby = createdby;
        this.deleted = deleted;
        this.isactive = isactive;
        this.modidate = modidate;
        this.modifiedby = modifiedby;
        this.octcmttaxussid = octcmttaxussid;
        this.ismcmt = ismcmt;
        this.octTaxMstr = octTaxMstr;
        this.octStateMaster = octStateMaster;
    }

    /** default constructor */
    public OctCmtTax() {
    }

    /** minimal constructor */
    public OctCmtTax(Date createdate, Long createdby, Date modidate, com.sellerportal.model.Ismcmt ismcmt, com.sellerportal.model.OctTaxMstr octTaxMstr, com.sellerportal.model.StateMaster octStateMaster) {
        this.createdate = createdate;
        this.createdby = createdby;
        this.modidate = modidate;
        this.ismcmt = ismcmt;
        this.octTaxMstr = octTaxMstr;
        this.octStateMaster = octStateMaster;
    }

    public Long getOctcmttaxrfnum() {
        return this.octcmttaxrfnum;
    }

    public void setOctcmttaxrfnum(Long octcmttaxrfnum) {
        this.octcmttaxrfnum = octcmttaxrfnum;
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

    public String getIsactive() {
        return this.isactive;
    }

    public void setIsactive(String isactive) {
        this.isactive = isactive;
    }

    public Date getModidate() {
        return this.modidate;
    }

    public void setModidate(Date modidate) {
        this.modidate = modidate;
    }

    public Long getModifiedby() {
        return this.modifiedby;
    }

    public void setModifiedby(Long modifiedby) {
        this.modifiedby = modifiedby;
    }

    public String getOctcmttaxussid() {
        return this.octcmttaxussid;
    }

    public void setOctcmttaxussid(String octcmttaxussid) {
        this.octcmttaxussid = octcmttaxussid;
    }

    public com.sellerportal.model.Ismcmt getIsmcmt() {
        return this.ismcmt;
    }

    public void setIsmcmt(com.sellerportal.model.Ismcmt ismcmt) {
        this.ismcmt = ismcmt;
    }

    public com.sellerportal.model.OctTaxMstr getOctTaxMstr() {
        return this.octTaxMstr;
    }

    public void setOctTaxMstr(com.sellerportal.model.OctTaxMstr octTaxMstr) {
        this.octTaxMstr = octTaxMstr;
    }

    public com.sellerportal.model.StateMaster getOctStateMaster() {
        return this.octStateMaster;
    }

    public void setOctStateMaster(com.sellerportal.model.StateMaster octStateMaster) {
        this.octStateMaster = octStateMaster;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("octcmttaxrfnum", getOctcmttaxrfnum())
            .toString();
    }

}
