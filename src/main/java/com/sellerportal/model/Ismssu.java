package com.sellerportal.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import org.apache.commons.lang.builder.ToStringBuilder;
import javax.persistence.*;

@Entity
@Table(name = "ISMSSU")
public class Ismssu implements Serializable {

	@Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ismssu_seq_generator")
    @SequenceGenerator(name="ismssu_seq_generator", sequenceName = "ISMSSU_SSURFNUM_SEQ", allocationSize = 1)
    @Column(name = "SSURFNUM")
    private Long ssurfnum;

    @Column(name = "CREATEDATE", nullable = false)
    private Date createdate;

    @Column(name = "CREATEDBY", nullable = false, length = 20)
    private Long createdby;

    @Column(name = "DELETED", nullable = false, length = 1)
    private String deleted;

    @Column(name = "MODIDATE", nullable = false)
    private Date modidate;

    @Column(name = "SSUUPDATEORDER", length = 1)
    private String ssuupdateorder;

    @OneToMany(mappedBy = "ismssu", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Ismsem> ismsems;

    @OneToMany(mappedBy = "ismssu", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Ismsse> ismsses;

    @OneToMany(mappedBy = "ismssu", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Ismrst> ismrsts;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "SSUCOMPDIFFERENT", nullable = false)
    private Ismsmt ismsmtBySsucompdifferent;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "SSUSMTFSTATE", nullable = false)
    private Ismsmt ismsmtBySsusmtfstate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "SSUINCOMPLETE", nullable = false)
    private Ismsmt ismsmtBySsuincomplete;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "SSUSMTTSTATE", nullable = false)
    private Ismsmt ismsmtBySsusmttstate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "SSUCOMPLETE", nullable = false)
    private Ismsmt ismsmtBySsucomplete;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "SSUSMDRFNUM", nullable = false)
    private Ismsmd ismsmd;

    /** full constructor */
    public Ismssu(Date createdate, Long createdby, String deleted, Date modidate, String ssuupdateorder,  com.sellerportal.model.Ismsmt ismsmtBySsucompdifferent,  com.sellerportal.model.Ismsmt ismsmtBySsusmtfstate,  com.sellerportal.model.Ismsmt ismsmtBySsuincomplete,  com.sellerportal.model.Ismsmt ismsmtBySsusmttstate,  com.sellerportal.model.Ismsmt ismsmtBySsucomplete,  com.sellerportal.model.Ismsmd ismsmd, Set ismsems, Set ismsses, Set ismrsts) {
        this.createdate = createdate;
        this.createdby = createdby;
        this.deleted = deleted;
        this.modidate = modidate;
        this.ssuupdateorder = ssuupdateorder;
        this.ismsmtBySsucompdifferent = ismsmtBySsucompdifferent;
        this.ismsmtBySsusmtfstate = ismsmtBySsusmtfstate;
        this.ismsmtBySsuincomplete = ismsmtBySsuincomplete;
        this.ismsmtBySsusmttstate = ismsmtBySsusmttstate;
        this.ismsmtBySsucomplete = ismsmtBySsucomplete;
        this.ismsmd = ismsmd;
        this.ismsems = ismsems;
        this.ismsses = ismsses;
        this.ismrsts = ismrsts;
    }

    /** default constructor */
    public Ismssu() {
    }

    /** minimal constructor */
    public Ismssu(Date createdate, Long createdby, String deleted, Date modidate,  com.sellerportal.model.Ismsmt ismsmtBySsucompdifferent,  com.sellerportal.model.Ismsmt ismsmtBySsusmtfstate,  com.sellerportal.model.Ismsmt ismsmtBySsuincomplete,  com.sellerportal.model.Ismsmt ismsmtBySsusmttstate,  com.sellerportal.model.Ismsmt ismsmtBySsucomplete,  com.sellerportal.model.Ismsmd ismsmd, Set ismsems, Set ismsses, Set ismrsts) {
        this.createdate = createdate;
        this.createdby = createdby;
        this.deleted = deleted;
        this.modidate = modidate;
        this.ismsmtBySsucompdifferent = ismsmtBySsucompdifferent;
        this.ismsmtBySsusmtfstate = ismsmtBySsusmtfstate;
        this.ismsmtBySsuincomplete = ismsmtBySsuincomplete;
        this.ismsmtBySsusmttstate = ismsmtBySsusmttstate;
        this.ismsmtBySsucomplete = ismsmtBySsucomplete;
        this.ismsmd = ismsmd;
        this.ismsems = ismsems;
        this.ismsses = ismsses;
        this.ismrsts = ismrsts;
    }

    /** 
     * 		       auto_increment
     * 		    
     */
    public Long getSsurfnum() {
        return this.ssurfnum;
    }

    public void setSsurfnum(Long ssurfnum) {
        this.ssurfnum = ssurfnum;
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

    public String getSsuupdateorder() {
        return this.ssuupdateorder;
    }

    public void setSsuupdateorder(String ssuupdateorder) {
        this.ssuupdateorder = ssuupdateorder;
    }

    public  com.sellerportal.model.Ismsmt getIsmsmtBySsucompdifferent() {
        return this.ismsmtBySsucompdifferent;
    }

    public void setIsmsmtBySsucompdifferent( com.sellerportal.model.Ismsmt ismsmtBySsucompdifferent) {
        this.ismsmtBySsucompdifferent = ismsmtBySsucompdifferent;
    }

    public  com.sellerportal.model.Ismsmt getIsmsmtBySsusmtfstate() {
        return this.ismsmtBySsusmtfstate;
    }

    public void setIsmsmtBySsusmtfstate( com.sellerportal.model.Ismsmt ismsmtBySsusmtfstate) {
        this.ismsmtBySsusmtfstate = ismsmtBySsusmtfstate;
    }

    public  com.sellerportal.model.Ismsmt getIsmsmtBySsuincomplete() {
        return this.ismsmtBySsuincomplete;
    }

    public void setIsmsmtBySsuincomplete( com.sellerportal.model.Ismsmt ismsmtBySsuincomplete) {
        this.ismsmtBySsuincomplete = ismsmtBySsuincomplete;
    }

    public  com.sellerportal.model.Ismsmt getIsmsmtBySsusmttstate() {
        return this.ismsmtBySsusmttstate;
    }

    public void setIsmsmtBySsusmttstate( com.sellerportal.model.Ismsmt ismsmtBySsusmttstate) {
        this.ismsmtBySsusmttstate = ismsmtBySsusmttstate;
    }

    public  com.sellerportal.model.Ismsmt getIsmsmtBySsucomplete() {
        return this.ismsmtBySsucomplete;
    }

    public void setIsmsmtBySsucomplete( com.sellerportal.model.Ismsmt ismsmtBySsucomplete) {
        this.ismsmtBySsucomplete = ismsmtBySsucomplete;
    }

    public  com.sellerportal.model.Ismsmd getIsmsmd() {
        return this.ismsmd;
    }

    public void setIsmsmd( com.sellerportal.model.Ismsmd ismsmd) {
        this.ismsmd = ismsmd;
    }

    public Set getIsmsems() {
        return this.ismsems;
    }

    public void setIsmsems(Set ismsems) {
        this.ismsems = ismsems;
    }

    public Set getIsmsses() {
        return this.ismsses;
    }

    public void setIsmsses(Set ismsses) {
        this.ismsses = ismsses;
    }

    public Set getIsmrsts() {
        return this.ismrsts;
    }

    public void setIsmrsts(Set ismrsts) {
        this.ismrsts = ismrsts;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("ssurfnum", getSsurfnum())
            .toString();
    }

}
