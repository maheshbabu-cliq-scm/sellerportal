package com.sellerportal.model;

import java.io.Serializable;
import java.util.Date;

import org.apache.commons.lang.builder.ToStringBuilder;
import javax.persistence.*;

/** @author Hibernate CodeGenerator */
@Entity
@Table(name = "ISMDPP")
public class Ismdpp implements Serializable {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "DPPRFNUM")
    private Long dpprfnum;

    @Column(name = "CREATEDATE", nullable = false)
    private Date createdate;

    @Column(name = "CREATEDBY", length = 20, nullable = false)
    private Long createdby;

    @Column(name = "DELETED", length = 1, nullable = false)
    private String deleted;

    @Column(name = "DPPPDTRFNUM", nullable = false, length = 20)
    private Long dpppdtrfnum;

    @Column(name = "MODIDATE", nullable = false)
    private Date modidate;

    @ManyToOne
    @JoinColumn(name = "DPPCNDELEMENT", nullable = false)
    private Ismcnd ismcnd;

    /** full constructor */
    public Ismdpp(Date createdate, Long createdby, String deleted, Long dpppdtrfnum, Date modidate,  com.sellerportal.model.Ismcnd ismcnd) {
        this.createdate = createdate;
        this.createdby = createdby;
        this.deleted = deleted;
        this.dpppdtrfnum = dpppdtrfnum;
        this.modidate = modidate;
        this.ismcnd = ismcnd;
    }

    /** default constructor */
    public Ismdpp() {
    }

    /** 
     * 		       auto_increment
     * 		    
     */
    public Long getDpprfnum() {
        return this.dpprfnum;
    }

    public void setDpprfnum(Long dpprfnum) {
        this.dpprfnum = dpprfnum;
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

    public Long getDpppdtrfnum() {
        return this.dpppdtrfnum;
    }

    public void setDpppdtrfnum(Long dpppdtrfnum) {
        this.dpppdtrfnum = dpppdtrfnum;
    }

    public Date getModidate() {
        return this.modidate;
    }

    public void setModidate(Date modidate) {
        this.modidate = modidate;
    }

    public  com.sellerportal.model.Ismcnd getIsmcnd() {
        return this.ismcnd;
    }

    public void setIsmcnd( com.sellerportal.model.Ismcnd ismcnd) {
        this.ismcnd = ismcnd;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("dpprfnum", getDpprfnum())
            .toString();
    }

}
