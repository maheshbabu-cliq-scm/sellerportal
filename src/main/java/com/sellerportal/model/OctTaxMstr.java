package com.sellerportal.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import org.apache.commons.lang.builder.ToStringBuilder;
import javax.persistence.*;

@Entity
@Table(name = "OCT_TAX_MSTR")
public class OctTaxMstr extends ParentPojo implements Serializable {

	@Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "TAX_MSTR_OCTTAXMSTRRFNUM_SEQ")
    @SequenceGenerator(name = "TAX_MSTR_OCTTAXMSTRRFNUM_SEQ", sequenceName = "TAX_MSTR_OCTTAXMSTRRFNUM_SEQ", allocationSize = 1)
    @Column(name = "OCTTAXMSTRRFNUM")
    private Long octtaxmstrrfnum;

    @Column(name = "CREATEDATE", nullable = false)
    private Date createdate;

    @Column(name = "CREATEDBY", nullable = false)
    private Long createdby;

    @Column(name = "DELETED", length = 1)
    private String deleted;

    @Column(name = "ISACTIVE", length = 1)
    private String isactive;

    @Column(name = "MODIDATE", nullable = false)
    private Date modidate;

    @Column(name = "MODIFIEDBY")
    private Long modifiedby;

    @Column(name = "OCTTAXMSTRCODE", nullable = false, length = 20)
    private String octtaxmstrcode;

    @Column(name = "OCTTAXMSTRCONDTYPE", nullable = false, length = 10)
    private String octtaxmstrcondtype;

    @Column(name = "OCTTAXMSTRDESCR", length = 64)
    private String octtaxmstrdescr;

    @Column(name = "OCTTAXMSTRRATE", nullable = false, length = 10)
    private String octtaxmstrrate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "OCTTAXMSTRTYPE")
    private OctParam octtaxmstrtype;

    @OneToMany(mappedBy = "octCmtTax", fetch = FetchType.LAZY)
    @Transient
    private Set<OctCmtTax> octCmtTaxs;

    @OneToMany(mappedBy = "octStateTax", fetch = FetchType.LAZY)
    @Transient
    private Set<OctStateTax> octStateTaxs;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "STATERFNUM", nullable = false)
    private StateMaster stateMaster;

    public StateMaster getStateMaster() {
		return stateMaster;
	}

	public void setStateMaster(StateMaster stateMaster) {
		this.stateMaster = stateMaster;
	}

	/** full constructor */
    public OctTaxMstr(Date createdate, Long createdby, String deleted, String isactive, Date modidate, Long modifiedby, String octtaxmstrcode, String octtaxmstrcondtype, String octtaxmstrdescr, String octtaxmstrrate, OctParam octtaxmstrtype, Set<OctCmtTax> octCmtTaxs, Set<OctStateTax> octStateTaxs,StateMaster stateMaster) {
        this.createdate = createdate;
        this.createdby = createdby;
        this.deleted = deleted;
        this.isactive = isactive;
        this.modidate = modidate;
        this.modifiedby = modifiedby;
        this.octtaxmstrcode = octtaxmstrcode;
        this.octtaxmstrcondtype = octtaxmstrcondtype;
        this.octtaxmstrdescr = octtaxmstrdescr;
        this.octtaxmstrrate = octtaxmstrrate;
        this.octtaxmstrtype = octtaxmstrtype;
        this.octCmtTaxs = octCmtTaxs;
        this.octStateTaxs = octStateTaxs;
        this.stateMaster=stateMaster;
    }

    /** default constructor */
    public OctTaxMstr() {
    }

    /** minimal constructor */
    public OctTaxMstr(Date createdate, Long createdby, Date modidate, String octtaxmstrcode, String octtaxmstrcondtype, String octtaxmstrrate, OctParam octtaxmstrtype, Set<OctCmtTax> octCmtTaxs, Set<OctStateTax> octStateTaxs) {
        this.createdate = createdate;
        this.createdby = createdby;
        this.modidate = modidate;
        this.octtaxmstrcode = octtaxmstrcode;
        this.octtaxmstrcondtype = octtaxmstrcondtype;
        this.octtaxmstrrate = octtaxmstrrate;
        this.octtaxmstrtype = octtaxmstrtype;
        this.octCmtTaxs = octCmtTaxs;
        this.octStateTaxs = octStateTaxs;
    }

    public Long getOcttaxmstrrfnum() {
        return this.octtaxmstrrfnum;
    }

    public void setOcttaxmstrrfnum(Long octtaxmstrrfnum) {
        this.octtaxmstrrfnum = octtaxmstrrfnum;
    }

    public String getIsactive() {
        return this.isactive;
    }

    public void setIsactive(String isactive) {
        this.isactive = isactive;
    }

    public String getOcttaxmstrcode() {
        return this.octtaxmstrcode;
    }

    public void setOcttaxmstrcode(String octtaxmstrcode) {
        this.octtaxmstrcode = octtaxmstrcode;
    }

    public String getOcttaxmstrcondtype() {
        return this.octtaxmstrcondtype;
    }

    public void setOcttaxmstrcondtype(String octtaxmstrcondtype) {
        this.octtaxmstrcondtype = octtaxmstrcondtype;
    }

    public String getOcttaxmstrdescr() {
        return this.octtaxmstrdescr;
    }

    public void setOcttaxmstrdescr(String octtaxmstrdescr) {
        this.octtaxmstrdescr = octtaxmstrdescr;
    }

    public String getOcttaxmstrrate() {
        return this.octtaxmstrrate;
    }

    public void setOcttaxmstrrate(String octtaxmstrrate) {
        this.octtaxmstrrate = octtaxmstrrate;
    }

    public OctParam getOcttaxmstrtype() {
        return this.octtaxmstrtype;
    }

    public void setOcttaxmstrtype(OctParam octtaxmstrtype) {
        this.octtaxmstrtype = octtaxmstrtype;
    }

    public Set<OctCmtTax> getOctCmtTaxs() {
        return this.octCmtTaxs;
    }

    public void setOctCmtTaxs(Set<OctCmtTax> octCmtTaxs) {
        this.octCmtTaxs = octCmtTaxs;
    }

    public Set<OctStateTax> getOctStateTaxs() {
        return this.octStateTaxs;
    }

    public void setOctStateTaxs(Set<OctStateTax> octStateTaxs) {
        this.octStateTaxs = octStateTaxs;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("octtaxmstrrfnum", getOcttaxmstrrfnum())
            .toString();
    }

}
