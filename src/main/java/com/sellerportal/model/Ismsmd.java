package com.sellerportal.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import org.apache.commons.lang.builder.ToStringBuilder;
import javax.persistence.*;

@Entity
@Table(name = "ISMSMD")
public class Ismsmd implements Serializable {

	 @Id
	    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ISMSMD_SMDRFNUM_SEQ")
	    @SequenceGenerator(name = "ISMSMD_SMDRFNUM_SEQ", sequenceName = "ISMSMD_SMDRFNUM_SEQ")
	    @Column(name = "SMDRFNUM")
	    private Long smdrfnum;

	    @Column(name = "CREATEDATE", nullable = false)
	    private Date createdate;

	    @Column(name = "CREATEDBY", nullable = false, length = 20)
	    private Long createdby;

	    @Column(name = "DELETED", nullable = false, length = 1)
	    private String deleted;

	    @Column(name = "MODIDATE", nullable = false)
	    private Date modidate;

	    @Column(name = "SMDDESC", length = 2048)
	    private String smddesc;

	    @Column(name = "SMDISDEFAULT", nullable = false, length = 1)
	    private String smdisdefault;

	    @Column(name = "SMDNAME", nullable = false, length = 128)
	    private String smdname;

	    @OneToMany(mappedBy = "ismsmd", cascade = CascadeType.ALL, orphanRemoval = true)
	    private Set<Ismssu> ismssus ;

	    @OneToMany(mappedBy = "ismsmd", cascade = CascadeType.ALL, orphanRemoval = true)
	    private Set<Ismpot> ismpots ;

	    @OneToMany(mappedBy = "ismsmd", cascade = CascadeType.ALL, orphanRemoval = true)
	    private Set<Ismsvu> ismsvus ;

	    @OneToMany(mappedBy = "ismsmd", cascade = CascadeType.ALL, orphanRemoval = true)
	    private Set<Ismpmt> ismpmts ;

	    @OneToMany(mappedBy = "ismsmd", cascade = CascadeType.ALL, orphanRemoval = true)
	    private Set<Ismosu> ismosus ;

    /** full constructor */
    public Ismsmd(Date createdate, Long createdby, String deleted, Date modidate, String smddesc, String smdisdefault, String smdname, Set ismssus, Set ismpots, Set ismsvus, Set ismpmts, Set ismosus) {
        this.createdate = createdate;
        this.createdby = createdby;
        this.deleted = deleted;
        this.modidate = modidate;
        this.smddesc = smddesc;
        this.smdisdefault = smdisdefault;
        this.smdname = smdname;
        this.ismssus = ismssus;
        this.ismpots = ismpots;
        this.ismsvus = ismsvus;
        this.ismpmts = ismpmts;
        this.ismosus = ismosus;
    }

    /** default constructor */
    public Ismsmd() {
    }

    /** minimal constructor */
    public Ismsmd(Date createdate, Long createdby, String deleted, Date modidate, String smdisdefault, String smdname, Set ismssus, Set ismpots, Set ismsvus, Set ismpmts, Set ismosus) {
        this.createdate = createdate;
        this.createdby = createdby;
        this.deleted = deleted;
        this.modidate = modidate;
        this.smdisdefault = smdisdefault;
        this.smdname = smdname;
        this.ismssus = ismssus;
        this.ismpots = ismpots;
        this.ismsvus = ismsvus;
        this.ismpmts = ismpmts;
        this.ismosus = ismosus;
    }

    /** 
     * 		       auto_increment
     * 		    
     */
    public Long getSmdrfnum() {
        return this.smdrfnum;
    }

    public void setSmdrfnum(Long smdrfnum) {
        this.smdrfnum = smdrfnum;
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

    public String getSmddesc() {
        return this.smddesc;
    }

    public void setSmddesc(String smddesc) {
        this.smddesc = smddesc;
    }

    public String getSmdisdefault() {
        return this.smdisdefault;
    }

    public void setSmdisdefault(String smdisdefault) {
        this.smdisdefault = smdisdefault;
    }

    public String getSmdname() {
        return this.smdname;
    }

    public void setSmdname(String smdname) {
        this.smdname = smdname;
    }

    public Set getIsmssus() {
        return this.ismssus;
    }

    public void setIsmssus(Set ismssus) {
        this.ismssus = ismssus;
    }

    public Set getIsmpots() {
        return this.ismpots;
    }

    public void setIsmpots(Set ismpots) {
        this.ismpots = ismpots;
    }

    public Set getIsmsvus() {
        return this.ismsvus;
    }

    public void setIsmsvus(Set ismsvus) {
        this.ismsvus = ismsvus;
    }

    public Set getIsmpmts() {
        return this.ismpmts;
    }

    public void setIsmpmts(Set ismpmts) {
        this.ismpmts = ismpmts;
    }

    public Set getIsmosus() {
        return this.ismosus;
    }

    public void setIsmosus(Set ismosus) {
        this.ismosus = ismosus;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("smdrfnum", getSmdrfnum())
            .toString();
    }

}
