package com.sellerportal.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.apache.commons.lang.builder.ToStringBuilder;


/** @author Hibernate CodeGenerator */
@Entity
@Table(name = "Ismpco")
public class Ismpco implements Serializable {

    /** identifier field */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long pcorfnum;

    /** persistent field */
    @Column(name = "createdate")
    private Date createdate;

    /** persistent field */
    @Column(name = "createdby")
    private Long createdby;

    /** persistent field */
    @Column(name = "deleted")
    private String deleted;

    /** persistent field */
    @Column(name = "modidate")
    private Date modidate;

    /** persistent field */
    @Column(name = "pcoppmrfnum")
    private Long pcoppmrfnum;

    /** persistent field */
    @ManyToOne
    @JoinColumn(name = "ismcnd_id")
    private Ismcnd ismcnd;

    /** full constructor */
    public Ismpco(Date createdate, Long createdby, String deleted, Date modidate, Long pcoppmrfnum,  com.sellerportal.model.Ismcnd ismcnd) {
        this.createdate = createdate;
        this.createdby = createdby;
        this.deleted = deleted;
        this.modidate = modidate;
        this.pcoppmrfnum = pcoppmrfnum;
        this.ismcnd = ismcnd;
    }

    /** default constructor */
    public Ismpco() {
    }

    /** 
     * 		       auto_increment
     * 		    
     */
    public Long getPcorfnum() {
        return this.pcorfnum;
    }

    public void setPcorfnum(Long pcorfnum) {
        this.pcorfnum = pcorfnum;
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

    public Long getPcoppmrfnum() {
        return this.pcoppmrfnum;
    }

    public void setPcoppmrfnum(Long pcoppmrfnum) {
        this.pcoppmrfnum = pcoppmrfnum;
    }

    public  com.sellerportal.model.Ismcnd getIsmcnd() {
        return this.ismcnd;
    }

    public void setIsmcnd( com.sellerportal.model.Ismcnd ismcnd) {
        this.ismcnd = ismcnd;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("pcorfnum", getPcorfnum())
            .toString();
    }

}
