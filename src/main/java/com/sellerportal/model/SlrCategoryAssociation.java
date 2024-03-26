package com.sellerportal.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import org.apache.commons.lang3.builder.ToStringBuilder;
import javax.persistence.*;


@Entity
@Table(name = "oct_slr_category_association")
public class SlrCategoryAssociation implements Serializable {

	@Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "slr_category_association_seq")
    @SequenceGenerator(name = "slr_category_association_seq", sequenceName = "SLR_CTG_ASSO_SCARFNUM_SEQ", allocationSize = 1)
    @Column(name = "SCARFNUM")
    private Long scarfnum;

    @Column(name = "CREATEDATE", nullable = false)
    private Date createdate;

    @Column(name = "CREATEDBY", nullable = false, length = 20)
    private Long createdby;

    @Column(name = "DELETED", nullable = false, length = 1)
    private String deleted;

    @Column(name = "MODIDATE", nullable = false)
    private Date modidate;

    @Column(name = "MODIFIEDBY", nullable = false, length = 20)
    private Long modifiedby;

    @Column(name = "CMTLEVEL", length = 2)
    private Integer cmtlevel;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "SCACMTRFNUM", nullable = false)
    private Ismcmt ismcmt;

    @OneToMany(mappedBy = "slrCategoryAssociation")
    @Transient
    private Set<SlrCategoryCommision> slrCategoryCommisions;

    @OneToMany(mappedBy = "slrCategoryAssociation")
    @Transient
    private Set<SlrCategoryFee> slrCategoryFee;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "SCASLRRFNUM", nullable = false)
    private OctSlr octSlr;

 
    /** full constructor */
    public SlrCategoryAssociation(Date createdate, Long createdby, String deleted, Date modidate, Long modifiedby,Integer cmtlevel, com.sellerportal.model.Ismcmt ismcmt, com.sellerportal.model.OctSlr octSlr, Set slrCategoryCommisions,Set slrCategoryFee) {
        this.createdate = createdate;
        this.createdby = createdby;
        this.deleted = deleted;
        this.modidate = modidate;
        this.modifiedby = modifiedby;
        this.cmtlevel = cmtlevel;
        this.ismcmt = ismcmt;
        this.octSlr = octSlr;
        this.slrCategoryCommisions = slrCategoryCommisions;
        this.slrCategoryFee=slrCategoryFee;
    }

    /** default constructor */
    public SlrCategoryAssociation() {
    }

    /** 
     * 		       auto_increment
     * 		    
     */
    public Long getScarfnum() {
        return this.scarfnum;
    }

    public void setScarfnum(Long scarfnum) {
        this.scarfnum = scarfnum;
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
    
    public Integer getCmtlevel() {
		return cmtlevel;
	}

	public void setCmtlevel(Integer cmtlevel) {
		this.cmtlevel = cmtlevel;
	}

	public com.sellerportal.model.Ismcmt getIsmcmt() {
        return this.ismcmt;
    }

    public void setIsmcmt(com.sellerportal.model.Ismcmt ismcmt) {
        this.ismcmt = ismcmt;
    }

    public com.sellerportal.model.OctSlr getOctSlr() {
        return this.octSlr;
    }

    public void setOctSlr(com.sellerportal.model.OctSlr octSlr) {
        this.octSlr = octSlr;
    }

    public Set getSlrCategoryCommisions() {
        return this.slrCategoryCommisions;
    }

    public void setSlrCategoryCommisions(Set slrCategoryCommisions) {
        this.slrCategoryCommisions = slrCategoryCommisions;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("scarfnum", getScarfnum())
            .toString();
    }

	public Set getSlrCategoryFee() {
		return slrCategoryFee;
	}

	public void setSlrCategoryFee(Set slrCategoryFee) {
		this.slrCategoryFee = slrCategoryFee;
	}

}
