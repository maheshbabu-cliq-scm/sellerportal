package com.sellerportal.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;
import javax.persistence.*;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.springframework.stereotype.Component;


@Entity
@Table(name = "OCT_PARAM")
@Component
public class OctParam implements Serializable {

	@Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "oct_param_sequence")
    @SequenceGenerator(name = "oct_param_sequence", sequenceName = "OCT_PARAM_PARAMRFNUM_SEQ", allocationSize = 1)
    @Column(name = "PARAMRFNUM")
    private Long paramrfnum;

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

	    @Column(name = "PARAMCODE", length = 20)
	    private String paramcode;

	    @Column(name = "PARAMDESC", nullable = false, length = 254)
	    private String paramdesc;

	    @Column(name = "PARAMGROUP", nullable = false, length = 128)
	    private String paramgroup;

	    @Column(name = "PARAMVALUE", length = 256)
	    private String paramvalue;

	    @Column(name = "PARAMSEQ", length = 5)
	    private Long paramseq;

	    @Column(name = "SLRRATINGSEQ", length = 1)
	    private String slrratingseq;

	    
    @OneToMany(mappedBy = "octParam", fetch = FetchType.LAZY)
    @Transient
    private Set<Ismubi> ismubis;

    /** full constructor */
    public OctParam(Date createdate, Long createdby, String deleted, Date modidate,Long modifiedby, String paramcode, String paramdesc, String paramgroup, String paramvalue, Long paramseq, Set ismubis) {
        this.createdate = createdate;
        this.createdby = createdby;
        this.deleted = deleted;
        this.modidate = modidate;
        this.modifiedby = modifiedby; 
        this.paramcode = paramcode;
        this.paramdesc = paramdesc;
        this.paramgroup = paramgroup;
        this.paramvalue = paramvalue;
        this.paramseq = paramseq;
        this.ismubis = ismubis;
    }

    /** default constructor */
    public OctParam() {
    }

    /** minimal constructor */
    public OctParam(Date createdate, Long createdby, String deleted, Date modidate,Long modifiedby, String paramdesc, String paramgroup, Long paramseq, Set ismubis) {
        this.createdate = createdate;
        this.createdby = createdby;
        this.deleted = deleted;
        this.modidate = modidate;
        this.modifiedby = modifiedby;
        this.paramdesc = paramdesc;
        this.paramgroup = paramgroup;
        this.paramseq = paramseq;
        this.ismubis = ismubis;
    }

    public Long getParamrfnum() {
        return this.paramrfnum;
    }

    public void setParamrfnum(Long paramrfnum) {
        this.paramrfnum = paramrfnum;
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
		return modifiedby;
	}

	public void setModifiedby(Long modifiedby) {
		this.modifiedby = modifiedby;
	}

	public String getParamcode() {
        return this.paramcode;
    }

    public void setParamcode(String paramcode) {
        this.paramcode = paramcode;
    }

    public String getParamdesc() {
        return this.paramdesc;
    }

    public void setParamdesc(String paramdesc) {
        this.paramdesc = paramdesc;
    }

    public String getParamgroup() {
        return this.paramgroup;
    }

    public void setParamgroup(String paramgroup) {
        this.paramgroup = paramgroup;
    }

    public String getParamvalue() {
        return this.paramvalue;
    }

    public void setParamvalue(String paramvalue) {
        this.paramvalue = paramvalue;
    }

    public Long getParamseq() {
		return paramseq;
	}

	public void setParamseq(Long paramseq) {
		this.paramseq = paramseq;
	}
	
	public String getSlrratingseq() {
		return slrratingseq;
	}

	public void setSlrratingseq(String slrratingseq) {
		this.slrratingseq = slrratingseq;
	}

    public Set getIsmubis() {
        return this.ismubis;
    }

    public void setIsmubis(Set ismubis) {
        this.ismubis = ismubis;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("paramrfnum", getParamrfnum())
            .toString();
    }

}
