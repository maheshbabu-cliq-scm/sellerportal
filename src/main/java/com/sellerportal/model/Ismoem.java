package com.sellerportal.model;

import java.io.Serializable;
import java.util.Date;

import org.apache.commons.lang.builder.ToStringBuilder;
import javax.persistence.*;


@Entity
@Table(name = "ISMOEM")
public class Ismoem implements Serializable {

	@Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ISMOEM_OEMRFNUM_SEQ")
    @SequenceGenerator(name = "ISMOEM_OEMRFNUM_SEQ", sequenceName = "ISMOEM_OEMRFNUM_SEQ", allocationSize = 1)
    @Column(name = "OEMRFNUM")
    private Long oemrfnum;

    @Column(name = "CREATEDATE", nullable = false)
    private Date createdate;

    @Column(name = "CREATEDBY", nullable = false)
    private Long createdby;

    @Column(name = "DELETED", nullable = false, length = 1)
    private String deleted;

    @Column(name = "MODIDATE", nullable = false)
    private Date modidate;

    @Column(name = "OEMBCCLIST", length = 254)
    private String oembcclist;

    @Column(name = "OEMCCLIST", length = 254)
    private String oemcclist;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "OEMCNDBUSINESSID", nullable = false)
    private Ismcnd ismcnd;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "OEMMDMRFNUM", nullable = false)
    private Ismmdm ismmdmByOemmdmrfnum;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "OEMCCMDMRFNUM", nullable = false)
    private Ismmdm ismmdmByOemccmdmrfnum;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "OEMOSTRFNUM", nullable = false)
    private Ismosu ismosu;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "OEMCCMTMRFNUM", nullable = false)
    private Ismmtm ismmtmByOemccmtmrfnum;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "OEMMTMRFNUM", nullable = false)
    private Ismmtm ismmtmByOemmtmrfnum;

    /** full constructor */
    public Ismoem(Date createdate, Long createdby, String deleted, Date modidate, String oembcclist, String oemcclist,  com.sellerportal.model.Ismcnd ismcnd,  com.sellerportal.model.Ismmdm ismmdmByOemmdmrfnum,  com.sellerportal.model.Ismmdm ismmdmByOemccmdmrfnum,  com.sellerportal.model.Ismosu ismosu,  com.sellerportal.model.Ismmtm ismmtmByOemccmtmrfnum,  com.sellerportal.model.Ismmtm ismmtmByOemmtmrfnum) {
        this.createdate = createdate;
        this.createdby = createdby;
        this.deleted = deleted;
        this.modidate = modidate;
        this.oembcclist = oembcclist;
        this.oemcclist = oemcclist;
        this.ismcnd = ismcnd;
        this.ismmdmByOemmdmrfnum = ismmdmByOemmdmrfnum;
        this.ismmdmByOemccmdmrfnum = ismmdmByOemccmdmrfnum;
        this.ismosu = ismosu;
        this.ismmtmByOemccmtmrfnum = ismmtmByOemccmtmrfnum;
        this.ismmtmByOemmtmrfnum = ismmtmByOemmtmrfnum;
    }

    /** default constructor */
    public Ismoem() {
    }

    /** minimal constructor */
    public Ismoem(Date createdate, Long createdby, String deleted, Date modidate,  com.sellerportal.model.Ismcnd ismcnd,  com.sellerportal.model.Ismmdm ismmdmByOemmdmrfnum,  com.sellerportal.model.Ismmdm ismmdmByOemccmdmrfnum,  com.sellerportal.model.Ismosu ismosu,  com.sellerportal.model.Ismmtm ismmtmByOemccmtmrfnum,  com.sellerportal.model.Ismmtm ismmtmByOemmtmrfnum) {
        this.createdate = createdate;
        this.createdby = createdby;
        this.deleted = deleted;
        this.modidate = modidate;
        this.ismcnd = ismcnd;
        this.ismmdmByOemmdmrfnum = ismmdmByOemmdmrfnum;
        this.ismmdmByOemccmdmrfnum = ismmdmByOemccmdmrfnum;
        this.ismosu = ismosu;
        this.ismmtmByOemccmtmrfnum = ismmtmByOemccmtmrfnum;
        this.ismmtmByOemmtmrfnum = ismmtmByOemmtmrfnum;
    }

    /** 
     * 		       auto_increment
     * 		    
     */
    public Long getOemrfnum() {
        return this.oemrfnum;
    }

    public void setOemrfnum(Long oemrfnum) {
        this.oemrfnum = oemrfnum;
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

    public String getOembcclist() {
        return this.oembcclist;
    }

    public void setOembcclist(String oembcclist) {
        this.oembcclist = oembcclist;
    }

    public String getOemcclist() {
        return this.oemcclist;
    }

    public void setOemcclist(String oemcclist) {
        this.oemcclist = oemcclist;
    }

    public  com.sellerportal.model.Ismcnd getIsmcnd() {
        return this.ismcnd;
    }

    public void setIsmcnd( com.sellerportal.model.Ismcnd ismcnd) {
        this.ismcnd = ismcnd;
    }

    public  com.sellerportal.model.Ismmdm getIsmmdmByOemmdmrfnum() {
        return this.ismmdmByOemmdmrfnum;
    }

    public void setIsmmdmByOemmdmrfnum( com.sellerportal.model.Ismmdm ismmdmByOemmdmrfnum) {
        this.ismmdmByOemmdmrfnum = ismmdmByOemmdmrfnum;
    }

    public  com.sellerportal.model.Ismmdm getIsmmdmByOemccmdmrfnum() {
        return this.ismmdmByOemccmdmrfnum;
    }

    public void setIsmmdmByOemccmdmrfnum( com.sellerportal.model.Ismmdm ismmdmByOemccmdmrfnum) {
        this.ismmdmByOemccmdmrfnum = ismmdmByOemccmdmrfnum;
    }

    public  com.sellerportal.model.Ismosu getIsmosu() {
        return this.ismosu;
    }

    public void setIsmosu( com.sellerportal.model.Ismosu ismosu) {
        this.ismosu = ismosu;
    }

    public  com.sellerportal.model.Ismmtm getIsmmtmByOemccmtmrfnum() {
        return this.ismmtmByOemccmtmrfnum;
    }

    public void setIsmmtmByOemccmtmrfnum( com.sellerportal.model.Ismmtm ismmtmByOemccmtmrfnum) {
        this.ismmtmByOemccmtmrfnum = ismmtmByOemccmtmrfnum;
    }

    public  com.sellerportal.model.Ismmtm getIsmmtmByOemmtmrfnum() {
        return this.ismmtmByOemmtmrfnum;
    }

    public void setIsmmtmByOemmtmrfnum( com.sellerportal.model.Ismmtm ismmtmByOemmtmrfnum) {
        this.ismmtmByOemmtmrfnum = ismmtmByOemmtmrfnum;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("oemrfnum", getOemrfnum())
            .toString();
    }

}
