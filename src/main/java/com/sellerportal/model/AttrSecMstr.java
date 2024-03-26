package com.sellerportal.model;

import java.io.Serializable;
import java.util.Date;

import org.apache.commons.lang.builder.ToStringBuilder;
import javax.persistence.*;

@Entity
@Table(name = "OCT_ATTR_SEC_MSTR")
public class AttrSecMstr implements Serializable {

	@Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "asm_secrfnum_seq")
    @SequenceGenerator(name = "asm_secrfnum_seq", sequenceName = "ASM_SECRFNUM_SEQ", allocationSize = 1)
    @Column(name = "SECRFNUM")
    private Long secrfnum;

    @Column(name = "CREATEDATE", nullable = false)
    private Date createdate;

    @Column(name = "CREATEDBY", nullable = false)
    private Long createdby;

    @Column(name = "DELETED", nullable = false, length = 1)
    private String deleted;

    @Column(name = "ISACTIVE", length = 1)
    private String isactive;

    @Column(name = "MODIDATE", nullable = false)
    private Date modidate;

    @Column(name = "MODIFIEDBY", nullable = false)
    private Long modifiedby;

    @Column(name = "SECACTION", nullable = false, length = 256)
    private String secaction;

    @Column(name = "SECLABEL", length = 24)
    private String seclabel;

    @Column(name = "SECSEQUENCE", length = 38)
    private Long secsequence;

    /** full constructor */
    public AttrSecMstr(Date createdate, Long createdby,Long modifiedby, String deleted, String isactive, Date modidate, String secaction, String seclabel, Long secsequence) {
        this.createdate = createdate;
        this.createdby = createdby;
        this.modifiedby = modifiedby;
        this.deleted = deleted;
        this.isactive = isactive;
        this.modidate = modidate;
        this.secaction = secaction;
        this.seclabel = seclabel;
        this.secsequence = secsequence;
    }

    /** default constructor */
    public AttrSecMstr() {
    }

    /** minimal constructor */
    public AttrSecMstr(Date createdate, Long createdby,Long modifiedby, String deleted, Date modidate, String secaction) {
        this.createdate = createdate;
        this.createdby = createdby;
        this.modifiedby = modifiedby;
        this.deleted = deleted;
        this.modidate = modidate;
        this.secaction = secaction;
    }

    public Long getSecrfnum() {
        return this.secrfnum;
    }

    public void setSecrfnum(Long secrfnum) {
        this.secrfnum = secrfnum;
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
    
    public Long getModifiedby() {
		return modifiedby;
	}

	public void setModifiedby(Long modifiedby) {
		this.modifiedby = modifiedby;
	}

	public String getDeleted() {
        return this.deleted;
    }

    public void setDeleted(String deleted) {
        this.deleted = deleted;
    }

    public String getIsactive() {
        return this.isactive;
    }

    public void setIsactive(String isactive) {
        this.isactive = isactive;
    }

    public Date getModidate() {
        return this.modidate;
    }

    public void setModidate(Date modidate) {
        this.modidate = modidate;
    }

    public String getSecaction() {
        return this.secaction;
    }

    public void setSecaction(String secaction) {
        this.secaction = secaction;
    }

    public String getSeclabel() {
        return this.seclabel;
    }

    public void setSeclabel(String seclabel) {
        this.seclabel = seclabel;
    }

    public Long getSecsequence() {
        return this.secsequence;
    }

    public void setSecsequence(Long secsequence) {
        this.secsequence = secsequence;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("secrfnum", getSecrfnum())
            .toString();
    }

}
