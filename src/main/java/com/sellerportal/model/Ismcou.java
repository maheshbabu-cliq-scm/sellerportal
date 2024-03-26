package com.sellerportal.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import org.apache.commons.lang.builder.ToStringBuilder;
import javax.persistence.*;

@Entity
@Table(name = "ISMCOU")
public class Ismcou implements Serializable {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "COURFNUM")
    private Long courfnum;

    @Column(name = "COUCREATEDATE", nullable = false)
    private Date coucreatedate;

    @Column(name = "COUCREATEDBY", nullable = false, length = 20)
    private Long coucreatedby;

    @Column(name = "COUDELETED", nullable = false, length = 1)
    private String coudeleted;

    @Column(name = "COUMODIDATE", nullable = false)
    private Date coumodidate;

    @Column(name = "COURDESC", length = 256)
    private String courdesc;

    @Column(name = "COURNAME", nullable = false, length = 32)
    private String courname;

    @Column(name = "COUTITLE", length = 64)
    private String coutitle;

    @OneToMany(mappedBy = "ismcou")
    @Transient
    private Set<Ismout> ismouts;

    /** full constructor */
    public Ismcou(Date coucreatedate, Long coucreatedby, String coudeleted, Date coumodidate, String courdesc, String courname, String coutitle, Set<Ismout> ismouts) {
        this.coucreatedate = coucreatedate;
        this.coucreatedby = coucreatedby;
        this.coudeleted = coudeleted;
        this.coumodidate = coumodidate;
        this.courdesc = courdesc;
        this.courname = courname;
        this.coutitle = coutitle;
        this.ismouts = ismouts;
//        this.crmplcs = crmplcs;
    }

    /** default constructor */
    public Ismcou() {
    }

    /** minimal constructor */
    public Ismcou(Date coucreatedate, Long coucreatedby, String coudeleted, Date coumodidate, String courname, Set<Ismout> ismouts) {
        this.coucreatedate = coucreatedate;
        this.coucreatedby = coucreatedby;
        this.coudeleted = coudeleted;
        this.coumodidate = coumodidate;
        this.courname = courname;
        this.ismouts = ismouts;
//        this.crmplcs = crmplcs;
    }

    /** 
     * 		       auto_increment
     * 		    
     */
    public Long getCourfnum() {
        return this.courfnum;
    }

    public void setCourfnum(Long courfnum) {
        this.courfnum = courfnum;
    }

    public Date getCoucreatedate() {
        return this.coucreatedate;
    }

    public void setCoucreatedate(Date coucreatedate) {
        this.coucreatedate = coucreatedate;
    }

    public Long getCoucreatedby() {
        return this.coucreatedby;
    }

    public void setCoucreatedby(Long coucreatedby) {
        this.coucreatedby = coucreatedby;
    }

    public String getCoudeleted() {
        return this.coudeleted;
    }

    public void setCoudeleted(String coudeleted) {
        this.coudeleted = coudeleted;
    }

    public Date getCoumodidate() {
        return this.coumodidate;
    }

    public void setCoumodidate(Date coumodidate) {
        this.coumodidate = coumodidate;
    }

    public String getCourdesc() {
        return this.courdesc;
    }

    public void setCourdesc(String courdesc) {
        this.courdesc = courdesc;
    }

    public String getCourname() {
        return this.courname;
    }

    public void setCourname(String courname) {
        this.courname = courname;
    }

    public String getCoutitle() {
        return this.coutitle;
    }

    public void setCoutitle(String coutitle) {
        this.coutitle = coutitle;
    }

    public Set<Ismout> getIsmouts() {
        return this.ismouts;
    }

    public void setIsmouts(Set<Ismout> ismouts) {
        this.ismouts = ismouts;
    }

//    public Set getCrmplcs() {
//        return this.crmplcs;
//    }
//
//    public void setCrmplcs(Set crmplcs) {
//        this.crmplcs = crmplcs;
//    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("courfnum", getCourfnum())
            .toString();
    }

}
