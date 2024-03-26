package com.sellerportal.model;

import java.io.Serializable;
import java.util.Date;

import org.apache.commons.lang.builder.ToStringBuilder;
import javax.persistence.*;

@Entity
@Table(name = "ISMEML")
public class Ismeml implements Serializable {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "EMLRFNUM")
    private Long emlrfnum;

    @Column(name = "CREATEDATE", nullable = false)
    private Date createdate;

    @Column(name = "CREATEDBY", nullable = false, length = 20)
    private Long createdby;

    @Column(name = "DELETED", nullable = false, length = 1)
    private String deleted;

    @Column(name = "EMLMTMRFNUM", nullable = false, length = 20)
    private Long emlmtmrfnum;

    @Column(name = "MODIDATE", nullable = false)
    private Date modidate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "EMLCNDEVENT")
    private Ismcnd ismcnd; 

    /** full constructor */
    public Ismeml(Date createdate, Long createdby, String deleted, Long emlmtmrfnum, Date modidate,  com.sellerportal.model.Ismcnd ismcnd) {
        this.createdate = createdate;
        this.createdby = createdby;
        this.deleted = deleted;
        this.emlmtmrfnum = emlmtmrfnum;
        this.modidate = modidate;
        this.ismcnd = ismcnd;
    }

    /** default constructor */
    public Ismeml() {
    }

    /** 
     * 		       auto_increment
     * 		    
     */
    public Long getEmlrfnum() {
        return this.emlrfnum;
    }

    public void setEmlrfnum(Long emlrfnum) {
        this.emlrfnum = emlrfnum;
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

    public Long getEmlmtmrfnum() {
        return this.emlmtmrfnum;
    }

    public void setEmlmtmrfnum(Long emlmtmrfnum) {
        this.emlmtmrfnum = emlmtmrfnum;
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
            .append("emlrfnum", getEmlrfnum())
            .toString();
    }

}
