package com.sellerportal.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import org.apache.commons.lang.builder.ToStringBuilder;
import javax.persistence.*;

@Entity
@Table(name = "ISMMTM")
public class Ismmtm implements Serializable {

	@Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ISMMTM_MTMRFNUM_SEQ")
    @SequenceGenerator(name = "ISMMTM_MTMRFNUM_SEQ", sequenceName = "ISMMTM_MTMRFNUM_SEQ")
    @Column(name = "MTMRFNUM")
    private Long mtmrfnum;

    @Column(name = "CREATEDATE", nullable = false)
    private Date createdate;

    @Column(name = "CREATEDBY", nullable = false, length = 20)
    private Long createdby;

    @Column(name = "DELETED", nullable = false, length = 1)
    private String deleted;

    @Column(name = "MODIDATE", nullable = false)
    private Date modidate;

    @Column(name = "MTMDESC", length = 2048)
    private String mtmdesc;

    @Column(name = "MTMFILENAME", nullable = false, length = 254)
    private String mtmfilename;

    @Column(name = "MTMISSMS", nullable = false, length = 1)
    private String mtmissms;

    @Column(name = "MTMNAME", nullable = false, length = 128)
    private String mtmname;

    @Column(name = "MTMSUBJECT", length = 1024)
    private String mtmsubject;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "MTMCNDUSERTYPE", nullable = false)
    private Ismcnd ismcnd;

    @OneToMany(mappedBy = "ismmtmBySemccmtmrfnum", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Ismsem> ismsemsBySemccmtmrfnum ;

    @OneToMany(mappedBy = "ismmtmBySemmtmrfnum", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Ismsem> ismsemsBySemmtmrfnum ;

    @OneToMany(mappedBy = "ismmtm", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Ismose> ismoses ;

    @OneToMany(mappedBy = "ismmtm", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Ismsse> ismsses ;

    @OneToMany(mappedBy = "ismmtmByOemccmtmrfnum", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Ismoem> ismoemsByOemccmtmrfnum ;

    @OneToMany(mappedBy = "ismmtmByOemmtmrfnum", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Ismoem> ismoemsByOemmtmrfnum ;

    @OneToMany(mappedBy = "ismmtmByPmtmtmrfnum", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Ismpmt> ismpmtsByPmtmtmrfnum ;

    @OneToMany(mappedBy = "ismmtmByPmtccmtmrfnum", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Ismpmt> ismpmtsByPmtccmtmrfnum ;

    /** full constructor */
    public Ismmtm(Date createdate, Long createdby, String deleted, Date modidate, String mtmdesc, String mtmfilename, String mtmissms, String mtmname, String mtmsubject,  com.sellerportal.model.Ismcnd ismcnd, Set ismsemsBySemccmtmrfnum, Set ismsemsBySemmtmrfnum, Set ismoses, Set ismsses, Set ismoemsByOemccmtmrfnum, Set ismoemsByOemmtmrfnum, Set ismpmtsByPmtmtmrfnum, Set ismpmtsByPmtccmtmrfnum) {
        this.createdate = createdate;
        this.createdby = createdby;
        this.deleted = deleted;
        this.modidate = modidate;
        this.mtmdesc = mtmdesc;
        this.mtmfilename = mtmfilename;
        this.mtmissms = mtmissms;
        this.mtmname = mtmname;
        this.mtmsubject = mtmsubject;
        this.ismcnd = ismcnd;
        this.ismsemsBySemccmtmrfnum = ismsemsBySemccmtmrfnum;
        this.ismsemsBySemmtmrfnum = ismsemsBySemmtmrfnum;
        this.ismoses = ismoses;
        this.ismsses = ismsses;
        this.ismoemsByOemccmtmrfnum = ismoemsByOemccmtmrfnum;
        this.ismoemsByOemmtmrfnum = ismoemsByOemmtmrfnum;
        this.ismpmtsByPmtmtmrfnum = ismpmtsByPmtmtmrfnum;
        this.ismpmtsByPmtccmtmrfnum = ismpmtsByPmtccmtmrfnum;
    }

    /** default constructor */
    public Ismmtm() {
    }

    /** minimal constructor */
    public Ismmtm(Date createdate, Long createdby, String deleted, Date modidate, String mtmfilename, String mtmissms, String mtmname,  com.sellerportal.model.Ismcnd ismcnd, Set ismsemsBySemccmtmrfnum, Set ismsemsBySemmtmrfnum, Set ismoses, Set ismsses, Set ismoemsByOemccmtmrfnum, Set ismoemsByOemmtmrfnum, Set ismpmtsByPmtmtmrfnum, Set ismpmtsByPmtccmtmrfnum) {
        this.createdate = createdate;
        this.createdby = createdby;
        this.deleted = deleted;
        this.modidate = modidate;
        this.mtmfilename = mtmfilename;
        this.mtmissms = mtmissms;
        this.mtmname = mtmname;
        this.ismcnd = ismcnd;
        this.ismsemsBySemccmtmrfnum = ismsemsBySemccmtmrfnum;
        this.ismsemsBySemmtmrfnum = ismsemsBySemmtmrfnum;
        this.ismoses = ismoses;
        this.ismsses = ismsses;
        this.ismoemsByOemccmtmrfnum = ismoemsByOemccmtmrfnum;
        this.ismoemsByOemmtmrfnum = ismoemsByOemmtmrfnum;
        this.ismpmtsByPmtmtmrfnum = ismpmtsByPmtmtmrfnum;
        this.ismpmtsByPmtccmtmrfnum = ismpmtsByPmtccmtmrfnum;
    }

    /** 
     * 		       auto_increment
     * 		    
     */
    public Long getMtmrfnum() {
        return this.mtmrfnum;
    }

    public void setMtmrfnum(Long mtmrfnum) {
        this.mtmrfnum = mtmrfnum;
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

    public String getMtmdesc() {
        return this.mtmdesc;
    }

    public void setMtmdesc(String mtmdesc) {
        this.mtmdesc = mtmdesc;
    }

    public String getMtmfilename() {
        return this.mtmfilename;
    }

    public void setMtmfilename(String mtmfilename) {
        this.mtmfilename = mtmfilename;
    }

    public String getMtmissms() {
        return this.mtmissms;
    }

    public void setMtmissms(String mtmissms) {
        this.mtmissms = mtmissms;
    }

    public String getMtmname() {
        return this.mtmname;
    }

    public void setMtmname(String mtmname) {
        this.mtmname = mtmname;
    }

    public String getMtmsubject() {
        return this.mtmsubject;
    }

    public void setMtmsubject(String mtmsubject) {
        this.mtmsubject = mtmsubject;
    }

    public  com.sellerportal.model.Ismcnd getIsmcnd() {
        return this.ismcnd;
    }

    public void setIsmcnd( com.sellerportal.model.Ismcnd ismcnd) {
        this.ismcnd = ismcnd;
    }

    public Set getIsmsemsBySemccmtmrfnum() {
        return this.ismsemsBySemccmtmrfnum;
    }

    public void setIsmsemsBySemccmtmrfnum(Set ismsemsBySemccmtmrfnum) {
        this.ismsemsBySemccmtmrfnum = ismsemsBySemccmtmrfnum;
    }

    public Set getIsmsemsBySemmtmrfnum() {
        return this.ismsemsBySemmtmrfnum;
    }

    public void setIsmsemsBySemmtmrfnum(Set ismsemsBySemmtmrfnum) {
        this.ismsemsBySemmtmrfnum = ismsemsBySemmtmrfnum;
    }

    public Set getIsmoses() {
        return this.ismoses;
    }

    public void setIsmoses(Set ismoses) {
        this.ismoses = ismoses;
    }

    public Set getIsmsses() {
        return this.ismsses;
    }

    public void setIsmsses(Set ismsses) {
        this.ismsses = ismsses;
    }

    public Set getIsmoemsByOemccmtmrfnum() {
        return this.ismoemsByOemccmtmrfnum;
    }

    public void setIsmoemsByOemccmtmrfnum(Set ismoemsByOemccmtmrfnum) {
        this.ismoemsByOemccmtmrfnum = ismoemsByOemccmtmrfnum;
    }

    public Set getIsmoemsByOemmtmrfnum() {
        return this.ismoemsByOemmtmrfnum;
    }

    public void setIsmoemsByOemmtmrfnum(Set ismoemsByOemmtmrfnum) {
        this.ismoemsByOemmtmrfnum = ismoemsByOemmtmrfnum;
    }

    public Set getIsmpmtsByPmtmtmrfnum() {
        return this.ismpmtsByPmtmtmrfnum;
    }

    public void setIsmpmtsByPmtmtmrfnum(Set ismpmtsByPmtmtmrfnum) {
        this.ismpmtsByPmtmtmrfnum = ismpmtsByPmtmtmrfnum;
    }

    public Set getIsmpmtsByPmtccmtmrfnum() {
        return this.ismpmtsByPmtccmtmrfnum;
    }

    public void setIsmpmtsByPmtccmtmrfnum(Set ismpmtsByPmtccmtmrfnum) {
        this.ismpmtsByPmtccmtmrfnum = ismpmtsByPmtccmtmrfnum;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("mtmrfnum", getMtmrfnum())
            .toString();
    }

}
