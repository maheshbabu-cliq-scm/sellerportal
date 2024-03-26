package com.sellerportal.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import org.apache.commons.lang.builder.ToStringBuilder;
import javax.persistence.*;

@Entity
@Table(name = "ISMSMT")
public class Ismsmt implements Serializable {

	@Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ISMSMT_SMTRFNUM_SEQ")
    @SequenceGenerator(name = "ISMSMT_SMTRFNUM_SEQ", sequenceName = "ISMSMT_SMTRFNUM_SEQ", allocationSize = 1)
    @Column(name = "SMTRFNUM")
    private Long smtrfnum;

    @Column(name = "CREATEDATE", nullable = false)
    private Date createdate;

    @Column(name = "CREATEDBY")
    private Long createdby;

    @Column(name = "DELETED", length = 1)
    private String deleted;

    @Column(name = "MODIDATE", nullable = false)
    private Date modidate;

    @Column(name = "SMTDESC", length = 2048)
    private String smtdesc;

    @Column(name = "SMTISACTIVE", nullable = false, length = 1)
    private String smtisactive;

    @Column(name = "SMTNAME", nullable = false, length = 128)
    private String smtname;

    @Column(name = "SMTNAMEFORCUSTVIEW", length = 128)
    private String smtnameforcustview;

    @Column(name = "SMTISCAT", nullable = false, length = 1)
    private String smtiscat;

    @Column(name = "SMTCODE", nullable = false, length = 10)
    private String smtcode;

    @ManyToOne
    @JoinColumn(name = "SMTTAGGED")
    private OctParam smttagged;

    @ManyToOne
    @JoinColumn(name = "SMTCAT")
    private Ismcmt smtcat;

    @OneToMany(mappedBy = "ismsmtBySsucompdifferent")
    private Set<Ismssu> ismssusBySsucompdifferent;

    @OneToMany(mappedBy = "ismsmtBySsusmtfstate")
    private Set<Ismssu> ismssusBySsusmtfstate;

    @OneToMany(mappedBy = "ismsmtBySsuincomplete")
    private Set<Ismssu> ismssusBySsuincomplete;

    @OneToMany(mappedBy = "ismsmtBySsusmttstate")
    private Set<Ismssu> ismssusBySsusmttstate;

    @OneToMany(mappedBy = "ismsmtBySsucomplete")
    private Set<Ismssu> ismssusBySsucomplete;

    @OneToMany(mappedBy = "ismsmt")
    private Set<Ismpot> ismpots;

    @OneToMany(mappedBy = "ismsmt")
    private Set<Ismcrp> ismcrps;

    @OneToMany(mappedBy = "ismsmt")
    private Set<Ismsvu> ismsvus;

    @OneToMany(mappedBy = "ismsmt")
    private Set<Ismpst> ismpsts;

    @OneToMany(mappedBy = "ismsmtByPmtsmtrfnum")
    private Set<Ismpmt> ismpmtsByPmtsmtrfnum;

    @OneToMany(mappedBy = "ismsmtByPmtsmtpartsucc")
    private Set<Ismpmt> ismpmtsByPmtsmtpartsucc;

    @OneToMany(mappedBy = "ismsmtByOsusmtfstate")
    private Set<Ismosu> ismosusByOsusmtfstate;

    @OneToMany(mappedBy = "ismsmtByOsusuborderstate")
    private Set<Ismosu> ismosusByOsusuborderstate;

    @OneToMany(mappedBy = "ismsmtByOsusuborderstatea")
    private Set<Ismosu> ismosusByOsusuborderstatea;

    @OneToMany(mappedBy = "ismsmtByOsusmttstate")
    private Set<Ismosu> ismosusByOsusmttstate;

    @OneToMany(mappedBy = "ismsmt")
    private Set<Ismrsa> ismrsas;
    
    /** full constructor */
    public Ismsmt(Date createdate, Long createdby, String deleted, Date modidate, String smtdesc, String smtisactive, String smtname, Set ismssusBySsucompdifferent, Set ismssusBySsusmtfstate, Set ismssusBySsuincomplete, Set ismssusBySsusmttstate, Set ismssusBySsucomplete, Set ismpots, Set ismcrps, Set ismsvus, Set ismpsts, Set ismpmtsByPmtsmtrfnum, Set ismpmtsByPmtsmtpartsucc, Set ismosusByOsusmtfstate, Set ismosusByOsusuborderstate, Set ismosusByOsusuborderstatea, Set ismosusByOsusmttstate, Set ismrsas, OctParam smttagged,Ismcmt smtcat) {
        this.createdate = createdate;
        this.createdby = createdby;
        this.deleted = deleted;
        this.modidate = modidate;
        this.smtdesc = smtdesc;
        this.smtisactive = smtisactive;
        this.smtname = smtname;
        this.ismssusBySsucompdifferent = ismssusBySsucompdifferent;
        this.ismssusBySsusmtfstate = ismssusBySsusmtfstate;
        this.ismssusBySsuincomplete = ismssusBySsuincomplete;
        this.ismssusBySsusmttstate = ismssusBySsusmttstate;
        this.ismssusBySsucomplete = ismssusBySsucomplete;
        this.ismpots = ismpots;
        this.ismcrps = ismcrps;
        this.ismsvus = ismsvus;
        this.ismpsts = ismpsts;
        this.ismpmtsByPmtsmtrfnum = ismpmtsByPmtsmtrfnum;
        this.ismpmtsByPmtsmtpartsucc = ismpmtsByPmtsmtpartsucc;
        this.ismosusByOsusmtfstate = ismosusByOsusmtfstate;
        this.ismosusByOsusuborderstate = ismosusByOsusuborderstate;
        this.ismosusByOsusuborderstatea = ismosusByOsusuborderstatea;
        this.ismosusByOsusmttstate = ismosusByOsusmttstate;
        this.ismrsas = ismrsas;
        this.smttagged = smttagged;
        this.smtcat=smtcat;

    }

    /** default constructor */
    public Ismsmt() {
    }

    /** minimal constructor */
    public Ismsmt(Date createdate, Date modidate, String smtisactive, String smtname, Set ismssusBySsucompdifferent, Set ismssusBySsusmtfstate, Set ismssusBySsuincomplete, Set ismssusBySsusmttstate, Set ismssusBySsucomplete, Set ismpots, Set ismcrps, Set ismsvus, Set ismpsts, Set ismpmtsByPmtsmtrfnum, Set ismpmtsByPmtsmtpartsucc, Set ismosusByOsusmtfstate, Set ismosusByOsusuborderstate, Set ismosusByOsusuborderstatea, Set ismosusByOsusmttstate, Set ismrsas) {
        this.createdate = createdate;
        this.modidate = modidate;
        this.smtisactive = smtisactive;
        this.smtname = smtname;
        this.ismssusBySsucompdifferent = ismssusBySsucompdifferent;
        this.ismssusBySsusmtfstate = ismssusBySsusmtfstate;
        this.ismssusBySsuincomplete = ismssusBySsuincomplete;
        this.ismssusBySsusmttstate = ismssusBySsusmttstate;
        this.ismssusBySsucomplete = ismssusBySsucomplete;
        this.ismpots = ismpots;
        this.ismcrps = ismcrps;
        this.ismsvus = ismsvus;
        this.ismpsts = ismpsts;
        this.ismpmtsByPmtsmtrfnum = ismpmtsByPmtsmtrfnum;
        this.ismpmtsByPmtsmtpartsucc = ismpmtsByPmtsmtpartsucc;
        this.ismosusByOsusmtfstate = ismosusByOsusmtfstate;
        this.ismosusByOsusuborderstate = ismosusByOsusuborderstate;
        this.ismosusByOsusuborderstatea = ismosusByOsusuborderstatea;
        this.ismosusByOsusmttstate = ismosusByOsusmttstate;
        this.ismrsas = ismrsas;
    }

    /** 
     * 		       auto_increment
     * 		    
     */
    public Long getSmtrfnum() {
        return this.smtrfnum;
    }

    public void setSmtrfnum(Long smtrfnum) {
        this.smtrfnum = smtrfnum;
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

    public String getSmtdesc() {
        return this.smtdesc;
    }

    public void setSmtdesc(String smtdesc) {
        this.smtdesc = smtdesc;
    }

    public String getSmtisactive() {
        return this.smtisactive;
    }

    public void setSmtisactive(String smtisactive) {
        this.smtisactive = smtisactive;
    }

    public String getSmtname() {
        return this.smtname;
    }

    public void setSmtname(String smtname) {
        this.smtname = smtname;
    }

    public Set getIsmssusBySsucompdifferent() {
        return this.ismssusBySsucompdifferent;
    }

    public void setIsmssusBySsucompdifferent(Set ismssusBySsucompdifferent) {
        this.ismssusBySsucompdifferent = ismssusBySsucompdifferent;
    }

    public Set getIsmssusBySsusmtfstate() {
        return this.ismssusBySsusmtfstate;
    }

    public void setIsmssusBySsusmtfstate(Set ismssusBySsusmtfstate) {
        this.ismssusBySsusmtfstate = ismssusBySsusmtfstate;
    }

    public Set getIsmssusBySsuincomplete() {
        return this.ismssusBySsuincomplete;
    }

    public void setIsmssusBySsuincomplete(Set ismssusBySsuincomplete) {
        this.ismssusBySsuincomplete = ismssusBySsuincomplete;
    }

    public Set getIsmssusBySsusmttstate() {
        return this.ismssusBySsusmttstate;
    }

    public void setIsmssusBySsusmttstate(Set ismssusBySsusmttstate) {
        this.ismssusBySsusmttstate = ismssusBySsusmttstate;
    }

    public Set getIsmssusBySsucomplete() {
        return this.ismssusBySsucomplete;
    }

    public void setIsmssusBySsucomplete(Set ismssusBySsucomplete) {
        this.ismssusBySsucomplete = ismssusBySsucomplete;
    }

    public Set getIsmpots() {
        return this.ismpots;
    }

    public void setIsmpots(Set ismpots) {
        this.ismpots = ismpots;
    }

    public Set getIsmcrps() {
        return this.ismcrps;
    }

    public void setIsmcrps(Set ismcrps) {
        this.ismcrps = ismcrps;
    }

    public Set getIsmsvus() {
        return this.ismsvus;
    }

    public void setIsmsvus(Set ismsvus) {
        this.ismsvus = ismsvus;
    }

    public Set getIsmpsts() {
        return this.ismpsts;
    }

    public void setIsmpsts(Set ismpsts) {
        this.ismpsts = ismpsts;
    }

    public Set getIsmpmtsByPmtsmtrfnum() {
        return this.ismpmtsByPmtsmtrfnum;
    }

    public void setIsmpmtsByPmtsmtrfnum(Set ismpmtsByPmtsmtrfnum) {
        this.ismpmtsByPmtsmtrfnum = ismpmtsByPmtsmtrfnum;
    }

    public Set getIsmpmtsByPmtsmtpartsucc() {
        return this.ismpmtsByPmtsmtpartsucc;
    }

    public void setIsmpmtsByPmtsmtpartsucc(Set ismpmtsByPmtsmtpartsucc) {
        this.ismpmtsByPmtsmtpartsucc = ismpmtsByPmtsmtpartsucc;
    }

    public Set getIsmosusByOsusmtfstate() {
        return this.ismosusByOsusmtfstate;
    }

    public void setIsmosusByOsusmtfstate(Set ismosusByOsusmtfstate) {
        this.ismosusByOsusmtfstate = ismosusByOsusmtfstate;
    }

    public Set getIsmosusByOsusuborderstate() {
        return this.ismosusByOsusuborderstate;
    }

    public void setIsmosusByOsusuborderstate(Set ismosusByOsusuborderstate) {
        this.ismosusByOsusuborderstate = ismosusByOsusuborderstate;
    }

    public Set getIsmosusByOsusuborderstatea() {
        return this.ismosusByOsusuborderstatea;
    }

    public void setIsmosusByOsusuborderstatea(Set ismosusByOsusuborderstatea) {
        this.ismosusByOsusuborderstatea = ismosusByOsusuborderstatea;
    }

    public Set getIsmosusByOsusmttstate() {
        return this.ismosusByOsusmttstate;
    }

    public void setIsmosusByOsusmttstate(Set ismosusByOsusmttstate) {
        this.ismosusByOsusmttstate = ismosusByOsusmttstate;
    }

    public Set getIsmrsas() {
        return this.ismrsas;
    }

    public void setIsmrsas(Set ismrsas) {
        this.ismrsas = ismrsas;
    }

    
    /**
	 * @return the smtnameforcustview
	 */
	public String getSmtnameforcustview() {
		return smtnameforcustview;
	}

	/**
	 * @param smtnameforcustview the smtnameforcustview to set
	 */
	public void setSmtnameforcustview(String smtnameforcustview) {
		this.smtnameforcustview = smtnameforcustview;
	}
	
	
	public String getSmtcode() {
		return smtcode;
	}

	public void setSmtcode(String smtcode) {
		this.smtcode = smtcode;
	}

	public String toString() {
        return new ToStringBuilder(this)
            .append("smtrfnum", getSmtrfnum())
            .toString();
    }

	public OctParam getSmttagged() {
		return smttagged;
	}

	public void setSmttagged(OctParam smttagged) {
		this.smttagged = smttagged;
	}

	public String getSmtiscat() {
		return smtiscat;
	}

	public void setSmtiscat(String smtiscat) {
		this.smtiscat = smtiscat;
	}

	public Ismcmt getSmtcat() {
		return smtcat;
	}

	public void setSmtcat(Ismcmt smtcat) {
		this.smtcat = smtcat;
	}

	

}
