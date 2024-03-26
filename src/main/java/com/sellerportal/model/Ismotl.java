package com.sellerportal.model;

import java.io.Serializable;
import java.util.Date;

import org.apache.commons.lang.builder.ToStringBuilder;
import javax.persistence.*;

@Entity
@Table(name = "ISMOTL")
public class Ismotl implements Serializable {

	@Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ISMOTL_OTLRFNUM_SEQ")
    @SequenceGenerator(name = "ISMOTL_OTLRFNUM_SEQ", sequenceName = "ISMOTL_OTLRFNUM_SEQ", allocationSize = 1)
    @Column(name = "OTLRFNUM")
    private Long otlrfnum;

    @Column(name = "CREATEDATE", nullable = false)
    private Date createdate;

    @Column(name = "CREATEDBY", nullable = false)
    private Long createdby;

    @Column(name = "DELETED", length = 1)
    private String deleted;

    @Column(name = "MODIDATE")
    private Date modidate;

    @Column(name = "MODIFIEDBY", nullable = false)
    private Long modifiedby;

    @Column(name = "OTLREMARK", length = 500)
    private String otlremark;

    @Column(name = "OTLSLRCODE", length = 25)
    private String otlslrcode;

    @Column(name = "OTLSLRRFNUM")
    private Long otlslrrfnum;

    @Column(name = "OTLSMDRFNUM")
    private Long otlsmdrfnum;

    @Column(name = "OTLSMTFSTATE")
    private Long otlsmtfstate;

    @Column(name = "OTLSMTTSTATE")
    private Long otlsmttstate;

    @ManyToOne
    @JoinColumn(name = "OTLUBIRFNUM")
    private Ismubi ismubi;

    @ManyToOne
    @JoinColumn(name = "OTLPOTRFNUM", nullable = false)
    private Ismpot ismpot;

    /** full constructor */
    public Ismotl(Date createdate, Long createdby, String deleted, Date modidate, Long modifiedby, String otlremark, String otlslrcode, Long otlslrrfnum, Long otlsmdrfnum, Long otlsmtfstate, Long otlsmttstate,  com.sellerportal.model.Ismubi ismubi,  com.sellerportal.model.Ismpot ismpot) {
        this.createdate = createdate;
        this.createdby = createdby;
        this.deleted = deleted;
        this.modidate = modidate;
        this.modifiedby = modifiedby;
        this.otlremark = otlremark;
        this.otlslrcode = otlslrcode;
        this.otlslrrfnum = otlslrrfnum;
        this.otlsmdrfnum = otlsmdrfnum;
        this.otlsmtfstate = otlsmtfstate;
        this.otlsmttstate = otlsmttstate;
        this.ismubi = ismubi;
        this.ismpot = ismpot;
    }

    /** default constructor */
    public Ismotl() {
    }

    /** minimal constructor */
    public Ismotl(Date createdate, Long createdby, Long modifiedby, String otlremark, String otlslrcode, Long otlslrrfnum, Long otlsmdrfnum, Long otlsmtfstate, Long otlsmttstate,  com.sellerportal.model.Ismubi ismubi,  com.sellerportal.model.Ismpot ismpot) {
        this.createdate = createdate;
        this.createdby = createdby;
        this.modifiedby = modifiedby;
        this.otlremark = otlremark;
        this.otlslrcode = otlslrcode;
        this.otlslrrfnum = otlslrrfnum;
        this.otlsmdrfnum = otlsmdrfnum;
        this.otlsmtfstate = otlsmtfstate;
        this.otlsmttstate = otlsmttstate;
        this.ismubi = ismubi;
        this.ismpot = ismpot;
    }

    public Long getOtlrfnum() {
        return this.otlrfnum;
    }

    public void setOtlrfnum(Long otlrfnum) {
        this.otlrfnum = otlrfnum;
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

    public Long getModifiedby() {
        return this.modifiedby;
    }

    public void setModifiedby(Long modifiedby) {
        this.modifiedby = modifiedby;
    }

    public String getOtlremark() {
        return this.otlremark;
    }

    public void setOtlremark(String otlremark) {
        this.otlremark = otlremark;
    }

    public String getOtlslrcode() {
        return this.otlslrcode;
    }

    public void setOtlslrcode(String otlslrcode) {
        this.otlslrcode = otlslrcode;
    }

    public Long getOtlslrrfnum() {
        return this.otlslrrfnum;
    }

    public void setOtlslrrfnum(Long otlslrrfnum) {
        this.otlslrrfnum = otlslrrfnum;
    }

    public Long getOtlsmdrfnum() {
        return this.otlsmdrfnum;
    }

    public void setOtlsmdrfnum(Long otlsmdrfnum) {
        this.otlsmdrfnum = otlsmdrfnum;
    }

    public Long getOtlsmtfstate() {
        return this.otlsmtfstate;
    }

    public void setOtlsmtfstate(Long otlsmtfstate) {
        this.otlsmtfstate = otlsmtfstate;
    }

    public Long getOtlsmttstate() {
        return this.otlsmttstate;
    }

    public void setOtlsmttstate(Long otlsmttstate) {
        this.otlsmttstate = otlsmttstate;
    }

    public  com.sellerportal.model.Ismubi getIsmubi() {
        return this.ismubi;
    }

    public void setIsmubi( com.sellerportal.model.Ismubi ismubi) {
        this.ismubi = ismubi;
    }

    public  com.sellerportal.model.Ismpot getIsmpot() {
        return this.ismpot;
    }

    public void setIsmpot( com.sellerportal.model.Ismpot ismpot) {
        this.ismpot = ismpot;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("otlrfnum", getOtlrfnum())
            .toString();
    }

}
