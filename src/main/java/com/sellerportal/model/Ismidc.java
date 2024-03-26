package com.sellerportal.model;

import java.io.Serializable;
import java.util.Date;

import org.apache.commons.lang.builder.ToStringBuilder;
import javax.persistence.*;

/** @author Hibernate CodeGenerator */
@Entity
@Table(name = "ISMIDC")
public class Ismidc implements Serializable {

	@Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "IDCRFNUM_SEQ")
    @SequenceGenerator(name = "IDCRFNUM_SEQ", sequenceName = "ISMIDC_IDCRFNUM_SEQ", allocationSize = 1)
    @Column(name = "IDCRFNUM")
    private Long idcrfnum;

    @Column(name = "CREATEDATE", nullable = false)
    private Date createdate;

    @Column(name = "CREATEDBY", nullable = false, length = 20)
    private Long createdby;

    @Column(name = "DELETED", nullable = false, length = 1)
    private String deleted;

    @Column(name = "IDCPRICEVAL", length = 11)
    private Integer idcpriceval;

    @Column(name = "MODIDATE", nullable = false)
    private Date modidate;

    @ManyToOne
    @JoinColumn(name = "IDCCNDPTYPE", nullable = false)
    private Ismcnd ismcnd;

    @ManyToOne
    @JoinColumn(name = "IDCCCGRFNUM", nullable = false)
    private Ismccg ismccg;


    /** full constructor */
    public Ismidc(Date createdate, Long createdby, String deleted, Integer idcpriceval, Date modidate,  com.sellerportal.model.Ismcnd ismcnd,  com.sellerportal.model.Ismccg ismccg) {
        this.createdate = createdate;
        this.createdby = createdby;
        this.deleted = deleted;
        this.idcpriceval = idcpriceval;
        this.modidate = modidate;
        this.ismcnd = ismcnd;
        this.ismccg = ismccg;
        
    }

    /** default constructor */
    public Ismidc() {
    }

    /** minimal constructor */
    public Ismidc(Date createdate, Long createdby, String deleted, Date modidate,  com.sellerportal.model.Ismcnd ismcnd,  com.sellerportal.model.Ismccg ismccg) {
        this.createdate = createdate;
        this.createdby = createdby;
        this.deleted = deleted;
        this.modidate = modidate;
        this.ismcnd = ismcnd;
        this.ismccg = ismccg;
       
    }

    /** 
     * 		       auto_increment
     * 		    
     */
    public Long getIdcrfnum() {
        return this.idcrfnum;
    }

    public void setIdcrfnum(Long idcrfnum) {
        this.idcrfnum = idcrfnum;
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

    public Integer getIdcpriceval() {
        return this.idcpriceval;
    }

    public void setIdcpriceval(Integer idcpriceval) {
        this.idcpriceval = idcpriceval;
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

    public  com.sellerportal.model.Ismccg getIsmccg() {
        return this.ismccg;
    }

    public void setIsmccg( com.sellerportal.model.Ismccg ismccg) {
        this.ismccg = ismccg;
    }

  

    public String toString() {
        return new ToStringBuilder(this)
            .append("idcrfnum", getIdcrfnum())
            .toString();
    }

}
