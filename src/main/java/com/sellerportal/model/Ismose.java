package com.sellerportal.model;

import java.io.Serializable;
import java.util.Date;

import org.apache.commons.lang.builder.ToStringBuilder;
import javax.persistence.*;

@Entity
@Table(name = "ISMOSE")
public class Ismose implements Serializable {

	@Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ISMOSE_OSERFNUM_SEQ")
    @SequenceGenerator(name = "ISMOSE_OSERFNUM_SEQ", sequenceName = "ISMOSE_OSERFNUM_SEQ", allocationSize = 1)
    @Column(name = "OSERFNUM")
    private Long oserfnum;

    @Column(name = "CREATEDATE", nullable = false)
    private Date createdate;

    @Column(name = "CREATEDBY", nullable = false)
    private Long createdby;

    @Column(name = "DELETED", nullable = false, length = 1)
    private String deleted;

    @Column(name = "MODIDATE", nullable = false)
    private Date modidate;

    @Column(name = "OSESMTRFNUM")
    private Long osesmtrfnum;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "OSECNDBUSINESSID", nullable = false)
    private Ismcnd ismcnd;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "OSEMDMRFNUM", nullable = false)
    private Ismmdm ismmdm;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "OSEOSTRFNUM", nullable = false)
    private Ismosu ismosu;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "OSEMTMRFNUM", nullable = false)
    private Ismmtm ismmtm;

    /** full constructor */
    public Ismose(Date createdate, Long createdby, String deleted, Date modidate, Long osesmtrfnum,  com.sellerportal.model.Ismcnd ismcnd,  com.sellerportal.model.Ismmdm ismmdm,  com.sellerportal.model.Ismosu ismosu,  com.sellerportal.model.Ismmtm ismmtm) {
        this.createdate = createdate;
        this.createdby = createdby;
        this.deleted = deleted;
        this.modidate = modidate;
        this.osesmtrfnum = osesmtrfnum;
        this.ismcnd = ismcnd;
        this.ismmdm = ismmdm;
        this.ismosu = ismosu;
        this.ismmtm = ismmtm;
    }

    /** default constructor */
    public Ismose() {
    }

    /** minimal constructor */
    public Ismose(Date createdate, Long createdby, String deleted, Date modidate,  com.sellerportal.model.Ismcnd ismcnd,  com.sellerportal.model.Ismmdm ismmdm,  com.sellerportal.model.Ismosu ismosu,  com.sellerportal.model.Ismmtm ismmtm) {
        this.createdate = createdate;
        this.createdby = createdby;
        this.deleted = deleted;
        this.modidate = modidate;
        this.ismcnd = ismcnd;
        this.ismmdm = ismmdm;
        this.ismosu = ismosu;
        this.ismmtm = ismmtm;
    }

    /** 
     * 		       auto_increment
     * 		    
     */
    public Long getOserfnum() {
        return this.oserfnum;
    }

    public void setOserfnum(Long oserfnum) {
        this.oserfnum = oserfnum;
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

    public Long getOsesmtrfnum() {
        return this.osesmtrfnum;
    }

    public void setOsesmtrfnum(Long osesmtrfnum) {
        this.osesmtrfnum = osesmtrfnum;
    }

    public  com.sellerportal.model.Ismcnd getIsmcnd() {
        return this.ismcnd;
    }

    public void setIsmcnd( com.sellerportal.model.Ismcnd ismcnd) {
        this.ismcnd = ismcnd;
    }

    public  com.sellerportal.model.Ismmdm getIsmmdm() {
        return this.ismmdm;
    }

    public void setIsmmdm( com.sellerportal.model.Ismmdm ismmdm) {
        this.ismmdm = ismmdm;
    }

    public  com.sellerportal.model.Ismosu getIsmosu() {
        return this.ismosu;
    }

    public void setIsmosu( com.sellerportal.model.Ismosu ismosu) {
        this.ismosu = ismosu;
    }

    public  com.sellerportal.model.Ismmtm getIsmmtm() {
        return this.ismmtm;
    }

    public void setIsmmtm( com.sellerportal.model.Ismmtm ismmtm) {
        this.ismmtm = ismmtm;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("oserfnum", getOserfnum())
            .toString();
    }

}
