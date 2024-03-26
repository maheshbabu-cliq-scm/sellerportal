package com.sellerportal.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import org.apache.commons.lang.builder.ToStringBuilder;
import javax.persistence.*;

@Entity
@Table(name = "ISMOSU")
public class Ismosu implements Serializable {

	@Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ISMOSU_OSURFNUM_SEQ")
    @SequenceGenerator(name = "ISMOSU_OSURFNUM_SEQ", sequenceName = "ISMOSU_OSURFNUM_SEQ", allocationSize = 1)
    @Column(name = "OSURFNUM")
    private Long osurfnum;

    @Column(name = "CREATEDATE", nullable = false)
    private Date createdate;

    @Column(name = "CREATEDBY", nullable = false)
    private Long createdby;

    @Column(name = "DELETED", nullable = false, length = 1)
    private String deleted;

    @Column(name = "MODIDATE", nullable = false)
    private Date modidate;

    @Column(name = "OSUSUBORDERUPDATE", length = 1)
    private String osusuborderupdate;

    @OneToMany(mappedBy = "ismosu")
    @Transient
    private Set<Ismrot> ismrots;

    @OneToMany(mappedBy = "ismosu")
    @Transient
    private Set<Ismose> ismoses;

    @OneToMany(mappedBy = "ismosu")
    @Transient
    private Set<Ismoem> ismoems;

    @ManyToOne
    @JoinColumn(name = "OSUSMTFSTATE", nullable = false)
    private Ismsmt ismsmtByOsusmtfstate;

    @ManyToOne
    @JoinColumn(name = "OSUSUBORDERSTATE", nullable = false)
    private Ismsmt ismsmtByOsusuborderstate;

    @ManyToOne
    @JoinColumn(name = "OSUSUBORDERSTATEA", nullable = false)
    private Ismsmt ismsmtByOsusuborderstatea;

    @ManyToOne
    @JoinColumn(name = "OSUSMTTSTATE", nullable = false)
    private Ismsmt ismsmtByOsusmttstate;

    @ManyToOne
    @JoinColumn(name = "OSUSMDRFNUM", nullable = false)
    private Ismsmd ismsmd;

    /** full constructor */
    public Ismosu(Date createdate, Long createdby, String deleted, Date modidate, String osusuborderupdate,  com.sellerportal.model.Ismsmt ismsmtByOsusmtfstate,  com.sellerportal.model.Ismsmt ismsmtByOsusuborderstate,  com.sellerportal.model.Ismsmt ismsmtByOsusuborderstatea,  com.sellerportal.model.Ismsmt ismsmtByOsusmttstate,  com.sellerportal.model.Ismsmd ismsmd, Set<Ismrot> ismrots, Set<Ismose> ismoses, Set<Ismoem> ismoems) {
        this.createdate = createdate;
        this.createdby = createdby;
        this.deleted = deleted;
        this.modidate = modidate;
        this.osusuborderupdate = osusuborderupdate;
        this.ismsmtByOsusmtfstate = ismsmtByOsusmtfstate;
        this.ismsmtByOsusuborderstate = ismsmtByOsusuborderstate;
        this.ismsmtByOsusuborderstatea = ismsmtByOsusuborderstatea;
        this.ismsmtByOsusmttstate = ismsmtByOsusmttstate;
        this.ismsmd = ismsmd;
        this.ismrots = ismrots;
        this.ismoses = ismoses;
        this.ismoems = ismoems;
    }

    /** default constructor */
    public Ismosu() {
    }

    /** minimal constructor */
    public Ismosu(Date createdate, Long createdby, String deleted, Date modidate,  com.sellerportal.model.Ismsmt ismsmtByOsusmtfstate,  com.sellerportal.model.Ismsmt ismsmtByOsusuborderstate,  com.sellerportal.model.Ismsmt ismsmtByOsusuborderstatea,  com.sellerportal.model.Ismsmt ismsmtByOsusmttstate,  com.sellerportal.model.Ismsmd ismsmd, Set<Ismrot> ismrots, Set<Ismose> ismoses, Set<Ismoem> ismoems) {
        this.createdate = createdate;
        this.createdby = createdby;
        this.deleted = deleted;
        this.modidate = modidate;
        this.ismsmtByOsusmtfstate = ismsmtByOsusmtfstate;
        this.ismsmtByOsusuborderstate = ismsmtByOsusuborderstate;
        this.ismsmtByOsusuborderstatea = ismsmtByOsusuborderstatea;
        this.ismsmtByOsusmttstate = ismsmtByOsusmttstate;
        this.ismsmd = ismsmd;
        this.ismrots = ismrots;
        this.ismoses = ismoses;
        this.ismoems = ismoems;
    }

    /** 
     * 		       auto_increment
     * 		    
     */
    public Long getOsurfnum() {
        return this.osurfnum;
    }

    public void setOsurfnum(Long osurfnum) {
        this.osurfnum = osurfnum;
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

    public String getOsusuborderupdate() {
        return this.osusuborderupdate;
    }

    public void setOsusuborderupdate(String osusuborderupdate) {
        this.osusuborderupdate = osusuborderupdate;
    }

    public  com.sellerportal.model.Ismsmt getIsmsmtByOsusmtfstate() {
        return this.ismsmtByOsusmtfstate;
    }

    public void setIsmsmtByOsusmtfstate( com.sellerportal.model.Ismsmt ismsmtByOsusmtfstate) {
        this.ismsmtByOsusmtfstate = ismsmtByOsusmtfstate;
    }

    public  com.sellerportal.model.Ismsmt getIsmsmtByOsusuborderstate() {
        return this.ismsmtByOsusuborderstate;
    }

    public void setIsmsmtByOsusuborderstate( com.sellerportal.model.Ismsmt ismsmtByOsusuborderstate) {
        this.ismsmtByOsusuborderstate = ismsmtByOsusuborderstate;
    }

    public  com.sellerportal.model.Ismsmt getIsmsmtByOsusuborderstatea() {
        return this.ismsmtByOsusuborderstatea;
    }

    public void setIsmsmtByOsusuborderstatea( com.sellerportal.model.Ismsmt ismsmtByOsusuborderstatea) {
        this.ismsmtByOsusuborderstatea = ismsmtByOsusuborderstatea;
    }

    public  com.sellerportal.model.Ismsmt getIsmsmtByOsusmttstate() {
        return this.ismsmtByOsusmttstate;
    }

    public void setIsmsmtByOsusmttstate( com.sellerportal.model.Ismsmt ismsmtByOsusmttstate) {
        this.ismsmtByOsusmttstate = ismsmtByOsusmttstate;
    }

    public  com.sellerportal.model.Ismsmd getIsmsmd() {
        return this.ismsmd;
    }

    public void setIsmsmd( com.sellerportal.model.Ismsmd ismsmd) {
        this.ismsmd = ismsmd;
    }

    public Set<Ismrot> getIsmrots() {
        return this.ismrots;
    }

    public void setIsmrots(Set<Ismrot> ismrots) {
        this.ismrots = ismrots;
    }

    public Set<Ismose> getIsmoses() {
        return this.ismoses;
    }

    public void setIsmoses(Set<Ismose> ismoses) {
        this.ismoses = ismoses;
    }

    public Set<Ismoem> getIsmoems() {
        return this.ismoems;
    }

    public void setIsmoems(Set<Ismoem> ismoems) {
        this.ismoems = ismoems;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("osurfnum", getOsurfnum())
            .toString();
    }

}
