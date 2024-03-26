package com.sellerportal.model;

import java.io.Serializable;
import java.util.Date;

import org.apache.commons.lang3.builder.ToStringBuilder;
import javax.persistence.*;

@Entity
@Table(name = "oct_slr_usr")
public class OctSlrUsr implements Serializable {

	@Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "oct_slr_usr_octslrusrrfnum_seq_generator")
    @SequenceGenerator(name = "oct_slr_usr_octslrusrrfnum_seq_generator", sequenceName = "OCT_SLR_USR_OCTSLRUSRRFNUM_SEQ", allocationSize = 1)
    @Column(name = "OCTSLRUSRRFNUM")
    private Long octslrusrrfnum;

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

    @Column(name = "ORGID", nullable = false, length = 20)
    private Long orgid;

    @ManyToOne
    @JoinColumn(name = "ISMUBI", nullable = false)
    private Ismubi ismubi;

    @ManyToOne
    @JoinColumn(name = "OCTSLR", nullable = false)
    private OctSlr octSlr;
    
    /** full constructor */
    public OctSlrUsr(Date createdate, Long createdby, String deleted, Date modidate, Long modifiedby, Long orgid, com.sellerportal.model.Ismubi ismubi, com.sellerportal.model.OctSlr octSlr) {
        this.createdate = createdate;
        this.createdby = createdby;
        this.deleted = deleted;
        this.modidate = modidate;
        this.modifiedby = modifiedby;
        this.orgid = orgid;
        this.ismubi = ismubi;
        this.octSlr = octSlr;
    }

    /** default constructor */
    public OctSlrUsr() {
    }

    /** 
     * 		       auto_increment
     * 		    
     */
    public Long getOctslrusrrfnum() {
        return this.octslrusrrfnum;
    }

    public void setOctslrusrrfnum(Long octslrusrrfnum) {
        this.octslrusrrfnum = octslrusrrfnum;
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

    public Long getOrgid() {
        return this.orgid;
    }

    public void setOrgid(Long orgid) {
        this.orgid = orgid;
    }

    public com.sellerportal.model.Ismubi getIsmubi() {
        return this.ismubi;
    }

    public void setIsmubi(com.sellerportal.model.Ismubi ismubi) {
        this.ismubi = ismubi;
    }

    public com.sellerportal.model.OctSlr getOctSlr() {
        return this.octSlr;
    }

    public void setOctSlr(com.sellerportal.model.OctSlr octSlr) {
        this.octSlr = octSlr;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("octslrusrrfnum", getOctslrusrrfnum())
            .toString();
    }

}
