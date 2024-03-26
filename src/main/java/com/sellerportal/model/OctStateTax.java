package com.sellerportal.model;

import java.io.Serializable;
import java.util.Date;

import org.apache.commons.lang.builder.ToStringBuilder;
import javax.persistence.*;

@Entity
@Table(name = "OCT_STATE_TAX")
public class OctStateTax extends ParentPojo implements Serializable {

	@Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "octstatetaxrfnum_generator")
    @SequenceGenerator(name = "octstatetaxrfnum_generator", sequenceName = "STATE_TAX_OCTSTATETAXRFNUM_SEQ", allocationSize = 1)
    @Column(name = "OCTSTATETAXRFNUM")
    private Long octstatetaxrfnum;

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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "OCTSTATETAX_TAX", nullable = false)
    private OctTaxMstr octTaxMstr;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "OCTSTATETAX_STATE", nullable = false)
    private StateMaster octStateMaster;

    /** full constructor */
    public OctStateTax(Date createdate, Long createdby, String deleted, String isactive, Date modidate, Long modifiedby, com.sellerportal.model.OctTaxMstr octTaxMstr, com.sellerportal.model.StateMaster octStateMaster) {
        this.createdate = createdate;
        this.createdby = createdby;
        this.deleted = deleted;
        this.isactive = isactive;
        this.modidate = modidate;
        this.modifiedby = modifiedby;
        this.octTaxMstr = octTaxMstr;
        this.octStateMaster = octStateMaster;
    }

    /** default constructor */
    public OctStateTax() {
    }

    /** minimal constructor */
    public OctStateTax(Date createdate, Long createdby, Date modidate, com.sellerportal.model.OctTaxMstr octTaxMstr, com.sellerportal.model.StateMaster octStateMaster) {
        this.createdate = createdate;
        this.createdby = createdby;
        this.modidate = modidate;
        this.octTaxMstr = octTaxMstr;
        this.octStateMaster = octStateMaster;
    }

    public Long getOctstatetaxrfnum() {
        return this.octstatetaxrfnum;
    }

    public void setOctstatetaxrfnum(Long octstatetaxrfnum) {
        this.octstatetaxrfnum = octstatetaxrfnum;
    }


    public String getIsactive() {
        return this.isactive;
    }

    public void setIsactive(String isactive) {
        this.isactive = isactive;
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
            .append("octstatetaxrfnum", getOctstatetaxrfnum())
            .toString();
    }

}
