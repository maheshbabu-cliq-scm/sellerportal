package com.sellerportal.model;

import java.io.Serializable;
import java.util.Date;

import org.apache.commons.lang.builder.ToStringBuilder;
import javax.persistence.*;

@Entity
@Table(name = "oct_slv_doc")
public class OctSlvDoc implements Serializable {

	 @Id
	    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "oct_slv_doc_seq")
	    @SequenceGenerator(name = "oct_slv_doc_seq", sequenceName = "OCT_SLV_DOC_SLVDOCRFNUM_SEQ", allocationSize = 1)
	    @Column(name = "SLVDOCRFNUM")
	    private Long slvdocrfnum;

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

	    @Column(name = "SLVDOCFILENAME", length = 128)
	    private String slvdocfilename;

	    @Column(name = "SLVDOCTEMPLATE", length = 128)
	    private String slvdoctemplate;

	    @ManyToOne(fetch = FetchType.LAZY)
	    @JoinColumn(name = "OCTSLVRFNUM", nullable = false)
	    private OctSlv octSlv;

    /** full constructor */
    public OctSlvDoc(Date createdate, Long createdby, String deleted, Date modidate, Long modifiedby, Long orgid, String slvdocfilename, String slvdoctemplate, com.sellerportal.model.OctSlv octSlv) {
        this.createdate = createdate;
        this.createdby = createdby;
        this.deleted = deleted;
        this.modidate = modidate;
        this.modifiedby = modifiedby;
        this.orgid = orgid;
        this.slvdocfilename = slvdocfilename;
        this.slvdoctemplate = slvdoctemplate;
        this.octSlv = octSlv;
    }

    /** default constructor */
    public OctSlvDoc() {
    }

    /** minimal constructor */
    public OctSlvDoc(Date createdate, Long createdby, String deleted, Date modidate, Long modifiedby, Long orgid, com.sellerportal.model.OctSlv octSlv) {
        this.createdate = createdate;
        this.createdby = createdby;
        this.deleted = deleted;
        this.modidate = modidate;
        this.modifiedby = modifiedby;
        this.orgid = orgid;
        this.octSlv = octSlv;
    }

    /** 
     * 		       auto_increment
     * 		    
     */
    public Long getSlvdocrfnum() {
        return this.slvdocrfnum;
    }

    public void setSlvdocrfnum(Long slvdocrfnum) {
        this.slvdocrfnum = slvdocrfnum;
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

    public String getSlvdocfilename() {
        return this.slvdocfilename;
    }

    public void setSlvdocfilename(String slvdocfilename) {
        this.slvdocfilename = slvdocfilename;
    }

    public String getSlvdoctemplate() {
        return this.slvdoctemplate;
    }

    public void setSlvdoctemplate(String slvdoctemplate) {
        this.slvdoctemplate = slvdoctemplate;
    }

    public com.sellerportal.model.OctSlv getOctSlv() {
        return this.octSlv;
    }

    public void setOctSlv(com.sellerportal.model.OctSlv octSlv) {
        this.octSlv = octSlv;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("slvdocrfnum", getSlvdocrfnum())
            .toString();
    }

}
