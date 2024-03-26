package com.sellerportal.model;

import java.io.Serializable;
import java.util.Date;

import org.apache.commons.lang.builder.ToStringBuilder;
import javax.persistence.*;


@Entity
@Table(name = "ISMSEM")
public class Ismsem implements Serializable {

	@Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ismsem_seq_generator")
    @SequenceGenerator(name="ismsem_seq_generator", sequenceName = "ISMSEM_SEMRFNUM_SEQ", allocationSize = 1)
    @Column(name = "SEMRFNUM")
    private Long semrfnum;

    @Column(name = "CREATEDATE", nullable = false)
    private Date createdate;

    @Column(name = "CREATEDBY", length = 20)
    private Long createdby;

    @Column(name = "DELETED", length = 1)
    private String deleted;

    @Column(name = "MODIDATE", nullable = false)
    private Date modidate;

    @Column(name = "SEMBCCLIST", length = 254)
    private String sembcclist;

    @Column(name = "SEMCCLIST", length = 254)
    private String semcclist;

    @Column(name = "SEMCMTRFNUM")
    private Long semcmtrfnum;

    @Column(name = "SEMISDEFAULT", length = 1)
    private String semisdefault;

    @Column(name = "SEMSENDBUYER", length = 1)
    private String semsendbuyer;

    @Column(name = "SEMSENDSELLER", length = 1)
    private String semsendseller;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "SEMCNDCHANNELID", nullable = false)
    private Ismcnd ismcnd;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "SEMSSTRFNUM", nullable = false)
    private Ismssu ismssu;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "SEMCCMDMRFNUM", nullable = false)
    private Ismmdm ismmdmBySemccmdmrfnum;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "SEMMDMRFNUM", nullable = false)
    private Ismmdm ismmdmBySemmdmrfnum;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "SEMCCMTMRFNUM", nullable = false)
    private Ismmtm ismmtmBySemccmtmrfnum;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "SEMMTMRFNUM", nullable = false)
    private Ismmtm ismmtmBySemmtmrfnum;

    /** full constructor */
    public Ismsem(Date createdate, Long createdby, String deleted, Date modidate, String sembcclist, String semcclist, Long semcmtrfnum, String semisdefault, String semsendbuyer, String semsendseller, com.sellerportal.model.Ismcnd ismcnd, com.sellerportal.model.Ismssu ismssu, /*com.sellerportal.model.Ismssi ismssi,*/ com.sellerportal.model.Ismmdm ismmdmBySemccmdmrfnum, com.sellerportal.model.Ismmdm ismmdmBySemmdmrfnum, com.sellerportal.model.Ismmtm ismmtmBySemccmtmrfnum, com.sellerportal.model.Ismmtm ismmtmBySemmtmrfnum) {
        this.createdate = createdate;
        this.createdby = createdby;
        this.deleted = deleted;
        this.modidate = modidate;
        this.sembcclist = sembcclist;
        this.semcclist = semcclist;
        this.semcmtrfnum = semcmtrfnum;
        this.semisdefault = semisdefault;
        this.semsendbuyer = semsendbuyer;
        this.semsendseller = semsendseller;
        this.ismcnd = ismcnd;
        this.ismssu = ismssu;
        //this.ismssi = ismssi;
        this.ismmdmBySemccmdmrfnum = ismmdmBySemccmdmrfnum;
        this.ismmdmBySemmdmrfnum = ismmdmBySemmdmrfnum;
        this.ismmtmBySemccmtmrfnum = ismmtmBySemccmtmrfnum;
        this.ismmtmBySemmtmrfnum = ismmtmBySemmtmrfnum;
    }

    /** default constructor */
    public Ismsem() {
    }

    /** minimal constructor */
    public Ismsem(Date createdate, Date modidate, com.sellerportal.model.Ismcnd ismcnd, com.sellerportal.model.Ismssu ismssu, /*com.sellerportal.model.Ismssi ismssi,*/ com.sellerportal.model.Ismmdm ismmdmBySemccmdmrfnum, com.sellerportal.model.Ismmdm ismmdmBySemmdmrfnum, com.sellerportal.model.Ismmtm ismmtmBySemccmtmrfnum, com.sellerportal.model.Ismmtm ismmtmBySemmtmrfnum) {
        this.createdate = createdate;
        this.modidate = modidate;
        this.ismcnd = ismcnd;
        this.ismssu = ismssu;
       //this.ismssi = ismssi;
        this.ismmdmBySemccmdmrfnum = ismmdmBySemccmdmrfnum;
        this.ismmdmBySemmdmrfnum = ismmdmBySemmdmrfnum;
        this.ismmtmBySemccmtmrfnum = ismmtmBySemccmtmrfnum;
        this.ismmtmBySemmtmrfnum = ismmtmBySemmtmrfnum;
    }

    /** 
     * 		       auto_increment
     * 		    
     */
    public Long getSemrfnum() {
        return this.semrfnum;
    }

    public void setSemrfnum(Long semrfnum) {
        this.semrfnum = semrfnum;
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

    public String getSembcclist() {
        return this.sembcclist;
    }

    public void setSembcclist(String sembcclist) {
        this.sembcclist = sembcclist;
    }

    public String getSemcclist() {
        return this.semcclist;
    }

    public void setSemcclist(String semcclist) {
        this.semcclist = semcclist;
    }

    public Long getSemcmtrfnum() {
        return this.semcmtrfnum;
    }

    public void setSemcmtrfnum(Long semcmtrfnum) {
        this.semcmtrfnum = semcmtrfnum;
    }

    public String getSemisdefault() {
        return this.semisdefault;
    }

    public void setSemisdefault(String semisdefault) {
        this.semisdefault = semisdefault;
    }

    public String getSemsendbuyer() {
        return this.semsendbuyer;
    }

    public void setSemsendbuyer(String semsendbuyer) {
        this.semsendbuyer = semsendbuyer;
    }

    public String getSemsendseller() {
        return this.semsendseller;
    }

    public void setSemsendseller(String semsendseller) {
        this.semsendseller = semsendseller;
    }

    public com.sellerportal.model.Ismcnd getIsmcnd() {
        return this.ismcnd;
    }

    public void setIsmcnd(com.sellerportal.model.Ismcnd ismcnd) {
        this.ismcnd = ismcnd;
    }

    public com.sellerportal.model.Ismssu getIsmssu() {
        return this.ismssu;
    }

    public void setIsmssu(com.sellerportal.model.Ismssu ismssu) {
        this.ismssu = ismssu;
    }

    /*public com.sellerportal.model.Ismssi getIsmssi() {
        return this.ismssi;
    }

    public void setIsmssi(com.sellerportal.model.Ismssi ismssi) {
        this.ismssi = ismssi;
    }*/

    public com.sellerportal.model.Ismmdm getIsmmdmBySemccmdmrfnum() {
        return this.ismmdmBySemccmdmrfnum;
    }

    public void setIsmmdmBySemccmdmrfnum(com.sellerportal.model.Ismmdm ismmdmBySemccmdmrfnum) {
        this.ismmdmBySemccmdmrfnum = ismmdmBySemccmdmrfnum;
    }

    public com.sellerportal.model.Ismmdm getIsmmdmBySemmdmrfnum() {
        return this.ismmdmBySemmdmrfnum;
    }

    public void setIsmmdmBySemmdmrfnum(com.sellerportal.model.Ismmdm ismmdmBySemmdmrfnum) {
        this.ismmdmBySemmdmrfnum = ismmdmBySemmdmrfnum;
    }

    public com.sellerportal.model.Ismmtm getIsmmtmBySemccmtmrfnum() {
        return this.ismmtmBySemccmtmrfnum;
    }

    public void setIsmmtmBySemccmtmrfnum(com.sellerportal.model.Ismmtm ismmtmBySemccmtmrfnum) {
        this.ismmtmBySemccmtmrfnum = ismmtmBySemccmtmrfnum;
    }

    public com.sellerportal.model.Ismmtm getIsmmtmBySemmtmrfnum() {
        return this.ismmtmBySemmtmrfnum;
    }

    public void setIsmmtmBySemmtmrfnum(com.sellerportal.model.Ismmtm ismmtmBySemmtmrfnum) {
        this.ismmtmBySemmtmrfnum = ismmtmBySemmtmrfnum;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("semrfnum", getSemrfnum())
            .toString();
    }

}
