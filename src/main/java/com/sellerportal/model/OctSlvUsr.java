package com.sellerportal.model;

import java.io.Serializable;
import java.util.Date;

import org.apache.commons.lang3.builder.ToStringBuilder;
import javax.persistence.*;

@Entity
@Table(name = "oct_slv_usr")
public class OctSlvUsr extends ParentPojo implements Serializable {

	@Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "oct_slv_usr_seq")
    @SequenceGenerator(name = "oct_slv_usr_seq", sequenceName = "OCT_SLV_USR_OCTSLVUSRRFNUM_SEQ", allocationSize = 1)
    @Column(name = "OCTSLVUSRRFNUM")
    private Long octslvusrrfnum;

    @Column(name = "CREATEDATE", nullable = false)
    private Date createdate;

    @Column(name = "CREATEDBY", nullable = false)
    private Long createdby;

    @Column(name = "DELETED", nullable = false, length = 1)
    private String deleted;

    @Column(name = "MODIDATE", nullable = false)
    private Date modidate;

    @Column(name = "MODIFIEDBY", nullable = false)
    private Long modifiedby;

    @Column(name = "ORGID", nullable = false)
    private Long orgid;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ISMUBI", nullable = false)
    private Ismubi ismubi;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "OCTSLV", nullable = false)
    private OctSlv octSlv;

    /** full constructor */
    public OctSlvUsr(Date createdate, Long createdby, String deleted, Date modidate, Long modifiedby, Long orgid, com.sellerportal.model.Ismubi ismubi, com.sellerportal.model.OctSlv octSlv) {
        this.createdate = createdate;
        this.createdby = createdby;
        this.deleted = deleted;
        this.modidate = modidate;
        this.modifiedby = modifiedby;
        this.orgid = orgid;
        this.ismubi = ismubi;
        this.octSlv = octSlv;
    }

    /** default constructor */
    public OctSlvUsr() {
    }

    /** 
     * 		       auto_increment
     * 		    
     */
    public Long getOctslvusrrfnum() {
        return this.octslvusrrfnum;
    }

    public void setOctslvusrrfnum(Long octslvusrrfnum) {
        this.octslvusrrfnum = octslvusrrfnum;
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

    public com.sellerportal.model.OctSlv getOctSlv() {
        return this.octSlv;
    }

    public void setOctSlv(com.sellerportal.model.OctSlv octSlv) {
        this.octSlv = octSlv;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("octslvusrrfnum", getOctslvusrrfnum())
            .toString();
    }

}
