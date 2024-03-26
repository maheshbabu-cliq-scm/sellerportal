package com.sellerportal.model;

import java.io.Serializable;
import java.util.Date;

import org.apache.commons.lang.builder.ToStringBuilder;
import javax.persistence.*;

@Entity
@Table(name = "OCT_TICKET")
public class OctTicket extends ParentPojo implements Serializable {

	@Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "octTicketSeq")
    @SequenceGenerator(name = "octTicketSeq", sequenceName = "OCT_TICKET_SEQ", allocationSize = 1)
    @Column(name = "OCTRFNUM")
    private Long octrfnum;

    @Column(name = "CREATEDATE", nullable = false)
    private Date createdate;

    @Column(name = "CREATEDBY", nullable = false)
    private Long createdby;

    @Column(name = "DELETED", length = 1)
    private String deleted;

    @Column(name = "ISREQEXIST", length = 1)
    private String isreqexist;

    @Column(name = "MODIDATE")
    private Date modidate;

    @Column(name = "MODIFIEDBY", nullable = false)
    private Long modifiedby;

    @Column(name = "OCTREMARK", length = 255)
    private String octremark;

    @Column(name = "OCTTICKETID", nullable = false, length = 30)
    private String octticketid;

    @Column(name = "CREDITCARDNO", length = 30)
    private String creditCardNo;

    @Column(name = "COMMENTS", length = 200)
    private String comments;

    @ManyToOne
    @JoinColumn(name = "OCTTICKETTYPE", nullable = false)
    private OctParam octParam;

    @ManyToOne
    @JoinColumn(name = "OCTTICKETPST", nullable = false)
    private Ismpst ismpst;

    @ManyToOne
    @JoinColumn(name = "TCKTREFUNDTYPE")
    private OctParam tcktrefundtype;

    @ManyToOne
    @JoinColumn(name = "TCKTCNCLREASON")
    private OctParam tcktcnclreason;

    @ManyToOne
    @JoinColumn(name = "TCKTOCTTICKTREQ")
    private OctTicketReq tcktoctticktreq;

    @ManyToOne
    @JoinColumn(name = "OCTSUBTICKETTYPE", nullable = false)
    private OctParam octParamSubTickType;

    @ManyToOne
    @JoinColumn(name = "OLDSUBTICKETTYPE")
    private OctParam oldSubTickType;

    @ManyToOne
    @JoinColumn(name = "TCKTSUBREASON")
    private OctParam tcktsubreason;
    
    /** full constructor */
    public OctTicket(Date createdate, Long createdby, String deleted,String isreqexist, Date modidate, Long modifiedby, String octremark, String octticketid, com.sellerportal.model.OctParam octParam, com.sellerportal.model.Ismpst ismpst,com.sellerportal.model.OctParam tcktrefundtype,com.sellerportal.model.OctParam tcktcnclreason,com.sellerportal.model.OctTicketReq tcktoctticktreq) {
        this.createdate = createdate;
        this.createdby = createdby;
        this.deleted = deleted;
        this.isreqexist = isreqexist;
        this.modidate = modidate;
        this.modifiedby = modifiedby;
        this.octremark = octremark;
        this.octticketid = octticketid;
        this.octParam = octParam;
        this.ismpst = ismpst;
        this.tcktrefundtype = tcktrefundtype;
        this.tcktcnclreason = tcktcnclreason;
        this.tcktoctticktreq = tcktoctticktreq;
    }

    /** default constructor */
    public OctTicket() {
    }

    /** minimal constructor */
    public OctTicket(Date createdate, Long createdby, Long modifiedby, String octticketid, com.sellerportal.model.OctParam octParam, com.sellerportal.model.Ismpst ismpst,com.sellerportal.model.OctParam tcktrefundtype,com.sellerportal.model.OctParam tcktcnclreason) {
        this.createdate = createdate;
        this.createdby = createdby;
        this.modifiedby = modifiedby;
        this.octticketid = octticketid;
        this.octParam = octParam;
        this.ismpst = ismpst;
        this.tcktrefundtype = tcktrefundtype;
        this.tcktcnclreason = tcktcnclreason; 
    }

    public Long getOctrfnum() {
        return this.octrfnum;
    }

    public void setOctrfnum(Long octrfnum) {
        this.octrfnum = octrfnum;
    }

    public String getOctremark() {
        return this.octremark;
    }

    public void setOctremark(String octremark) {
        this.octremark = octremark;
    }

    public String getOctticketid() {
        return this.octticketid;
    }

    public void setOctticketid(String octticketid) {
        this.octticketid = octticketid;
    }

    public com.sellerportal.model.OctParam getOctParam() {
        return this.octParam;
    }

    public void setOctParam(com.sellerportal.model.OctParam octParam) {
        this.octParam = octParam;
    }

    public com.sellerportal.model.Ismpst getIsmpst() {
        return this.ismpst;
    }

    public void setIsmpst(com.sellerportal.model.Ismpst ismpst) {
        this.ismpst = ismpst;
    }

    public com.sellerportal.model.OctParam getTcktrefundtype() {
		return tcktrefundtype;
	}

	public void setTcktrefundtype(com.sellerportal.model.OctParam tcktrefundtype) {
		this.tcktrefundtype = tcktrefundtype;
	}

	public com.sellerportal.model.OctParam getTcktcnclreason() {
		return tcktcnclreason;
	}

	public void setTcktcnclreason(com.sellerportal.model.OctParam tcktcnclreason) {
		this.tcktcnclreason = tcktcnclreason;
	}
	
	public String getIsreqexist() {
		return isreqexist;
	}

	public void setIsreqexist(String isreqexist) {
		this.isreqexist = isreqexist;
	}
	
	public com.sellerportal.model.OctTicketReq getTcktoctticktreq() {
		return tcktoctticktreq;
	}

	public void setTcktoctticktreq(com.sellerportal.model.OctTicketReq tcktoctticktreq) {
		this.tcktoctticktreq = tcktoctticktreq;
	}

	public String toString() {
        return new ToStringBuilder(this)
            .append("octrfnum", getOctrfnum())
            .toString();
    }

	public com.sellerportal.model.OctParam getOctParamSubTickType() {
		return octParamSubTickType;
	}

	public void setOctParamSubTickType(com.sellerportal.model.OctParam octParamSubTickType) {
		this.octParamSubTickType = octParamSubTickType;
	}

	public com.sellerportal.model.OctParam getOldSubTickType() {
		return oldSubTickType;
	}

	public void setOldSubTickType(com.sellerportal.model.OctParam oldSubTickType) {
		this.oldSubTickType = oldSubTickType;
	}

	public String getCreditCardNo() {
		return creditCardNo;
	}

	public void setCreditCardNo(String creditCardNo) {
		this.creditCardNo = creditCardNo;
	}

	public com.sellerportal.model.OctParam getTcktsubreason() {
		return tcktsubreason;
	}

	public void setTcktsubreason(com.sellerportal.model.OctParam tcktsubreason) {
		this.tcktsubreason = tcktsubreason;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

		
	
}