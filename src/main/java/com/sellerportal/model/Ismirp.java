package com.sellerportal.model;

import java.io.Serializable;
import java.util.Date;

import org.apache.commons.lang.builder.ToStringBuilder;
import javax.persistence.*;

@Entity
@Table(name = "ISMIRP")
public class Ismirp implements Serializable {

	@Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "IRPRFNUM_SEQ")
    @SequenceGenerator(name = "IRPRFNUM_SEQ", sequenceName = "ISMIRP_IRPRFNUM_SEQ", allocationSize = 1)
    @Column(name = "IRPRFNUM")
    private Long irprfnum;

    @Column(name = "IRPCREATEDATE", nullable = false)
    private Date irpcreatedate;

    @Column(name = "IRPCREATEDBY", nullable = false, length = 20)
    private Long irpcreatedby;

    @Column(name = "IRPDEFAULT", length = 1024)
    private String irpdefault;

    @Column(name = "IRPDELETED", nullable = false, length = 1)
    private String irpdeleted;

    @Column(name = "IRPDESC", length = 2048)
    private String irpdesc;

    @Column(name = "IRPISMNAME", length = 128)
    private String irpismname;

    @Column(name = "IRPMANDATORY", length = 1)
    private String irpmandatory;

    @Column(name = "IRPMODIDATE", nullable = false)
    private Date irpmodidate;

    @Column(name = "IRPNAME", length = 128)
    private String irpname;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "IRPIDMRFNUM", nullable = false)
    private Ismidm ismidm;

    /** full constructor */
    public Ismirp(Date irpcreatedate, Long irpcreatedby, String irpdefault, String irpdeleted, String irpdesc, String irpismname, String irpmandatory, Date irpmodidate, String irpname, com.sellerportal.model.Ismidm ismidm) {
        this.irpcreatedate = irpcreatedate;
        this.irpcreatedby = irpcreatedby;
        this.irpdefault = irpdefault;
        this.irpdeleted = irpdeleted;
        this.irpdesc = irpdesc;
        this.irpismname = irpismname;
        this.irpmandatory = irpmandatory;
        this.irpmodidate = irpmodidate;
        this.irpname = irpname;
        this.ismidm = ismidm;
    }

    /** default constructor */
    public Ismirp() {
    }

    /** minimal constructor */
    public Ismirp(Date irpcreatedate, Long irpcreatedby, String irpdeleted, Date irpmodidate, com.sellerportal.model.Ismidm ismidm) {
        this.irpcreatedate = irpcreatedate;
        this.irpcreatedby = irpcreatedby;
        this.irpdeleted = irpdeleted;
        this.irpmodidate = irpmodidate;
        this.ismidm = ismidm;
    }

    /** 
     * 		       auto_increment
     * 		    
     */
    public Long getIrprfnum() {
        return this.irprfnum;
    }

    public void setIrprfnum(Long irprfnum) {
        this.irprfnum = irprfnum;
    }

    public Date getIrpcreatedate() {
        return this.irpcreatedate;
    }

    public void setIrpcreatedate(Date irpcreatedate) {
        this.irpcreatedate = irpcreatedate;
    }

    public Long getIrpcreatedby() {
        return this.irpcreatedby;
    }

    public void setIrpcreatedby(Long irpcreatedby) {
        this.irpcreatedby = irpcreatedby;
    }

    public String getIrpdefault() {
        return this.irpdefault;
    }

    public void setIrpdefault(String irpdefault) {
        this.irpdefault = irpdefault;
    }

    public String getIrpdeleted() {
        return this.irpdeleted;
    }

    public void setIrpdeleted(String irpdeleted) {
        this.irpdeleted = irpdeleted;
    }

    public String getIrpdesc() {
        return this.irpdesc;
    }

    public void setIrpdesc(String irpdesc) {
        this.irpdesc = irpdesc;
    }

    public String getIrpismname() {
        return this.irpismname;
    }

    public void setIrpismname(String irpismname) {
        this.irpismname = irpismname;
    }

    public String getIrpmandatory() {
        return this.irpmandatory;
    }

    public void setIrpmandatory(String irpmandatory) {
        this.irpmandatory = irpmandatory;
    }

    public Date getIrpmodidate() {
        return this.irpmodidate;
    }

    public void setIrpmodidate(Date irpmodidate) {
        this.irpmodidate = irpmodidate;
    }

    public String getIrpname() {
        return this.irpname;
    }

    public void setIrpname(String irpname) {
        this.irpname = irpname;
    }

    public com.sellerportal.model.Ismidm getIsmidm() {
        return this.ismidm;
    }

    public void setIsmidm(com.sellerportal.model.Ismidm ismidm) {
        this.ismidm = ismidm;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("irprfnum", getIrprfnum())
            .toString();
    }

}
