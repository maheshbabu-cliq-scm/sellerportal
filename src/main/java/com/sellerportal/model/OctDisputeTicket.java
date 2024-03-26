package com.sellerportal.model;

import java.io.Serializable;
import java.util.Date;

import org.apache.commons.lang.builder.ToStringBuilder;
import javax.persistence.*;

@Entity
@Table(name = "OCT_DISPUTETICKET")
public class OctDisputeTicket implements Serializable {

	@Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "octDisputeTicketSeq")
    @SequenceGenerator(name = "octDisputeTicketSeq", sequenceName = "OCT_DISPUTE_TICKET_SEQ", allocationSize = 1)
    @Column(name = "OCTDTRFNUM")
    private Long octdtrfnum;

    @Column(name = "CREATEDATE", nullable = false)
    private Date createdate;

    @Column(name = "CREATEDBY", nullable = false)
    private Long createdby;

    @Column(name = "DELETED", length = 1)
    private String deleted;

    @Column(name = "MODIDATE")
    private Date modidate;

    @Column(name = "MODIFIEDBY", nullable = false)
    private Long modifiedby;

    @Column(name = "OCTTICKETID", nullable = false, length = 60)
    private String octticketid;

    @ManyToOne
    @JoinColumn(name = "OCTTICKETPST", nullable = false)
    private Ismpst ismpst;

    
    /** full constructor */
    public OctDisputeTicket(Date createdate, Long createdby, String deleted,String isreqexist, Date modidate, Long modifiedby, String octremark, String octticketid, com.sellerportal.model.OctParam octParam, com.sellerportal.model.Ismpst ismpst,com.sellerportal.model.OctParam tcktrefundtype,com.sellerportal.model.OctParam tcktcnclreason) {
        this.createdate = createdate;
        this.createdby = createdby;
        this.deleted = deleted;
        this.modidate = modidate;
        this.modifiedby = modifiedby;
       // this.octremark = octremark;
        this.octticketid = octticketid;
       // this.octParam = octParam;
        this.ismpst = ismpst;
        /*this.tcktrefundtype = tcktrefundtype;
        this.tcktcnclreason = tcktcnclreason;
        this.tcktoctticktreq = tcktoctticktreq;*/
    }

    /** default constructor */
    public OctDisputeTicket() {
    }

    /** minimal constructor */
    public OctDisputeTicket(Date createdate, Long createdby, Long modifiedby, String octticketid, com.sellerportal.model.OctParam octParam, com.sellerportal.model.Ismpst ismpst,com.sellerportal.model.OctParam tcktrefundtype,com.sellerportal.model.OctParam tcktcnclreason) {
        this.createdate = createdate;
        this.createdby = createdby;
        this.modifiedby = modifiedby;
        this.octticketid = octticketid;
      //  this.octParam = octParam;
        this.ismpst = ismpst;
        /*this.tcktrefundtype = tcktrefundtype;
        this.tcktcnclreason = tcktcnclreason; */
    }



    public Long getOctdtrfnum() {
		return octdtrfnum;
	}

	public void setOctdtrfnum(Long octdtrfnum) {
		this.octdtrfnum = octdtrfnum;
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

    /*public String getOctremark() {
        return this.octremark;
    }

    public void setOctremark(String octremark) {
        this.octremark = octremark;
    }*/

    public String getOctticketid() {
        return this.octticketid;
    }

    public void setOctticketid(String octticketid) {
        this.octticketid = octticketid;
    }

/*    public com.sellerportal.model.OctParam getOctParam() {
        return this.octParam;
    }

    public void setOctParam(com.sellerportal.model.OctParam octParam) {
        this.octParam = octParam;
    }*/

    public com.sellerportal.model.Ismpst getIsmpst() {
        return this.ismpst;
    }

    public void setIsmpst(com.sellerportal.model.Ismpst ismpst) {
        this.ismpst = ismpst;
    }

 /*   public com.sellerportal.model.OctParam getTcktrefundtype() {
		return tcktrefundtype;
	}*/

	/*public void setTcktrefundtype(com.sellerportal.model.OctParam tcktrefundtype) {
		this.tcktrefundtype = tcktrefundtype;
	}

	public com.sellerportal.model.OctParam getTcktcnclreason() {
		return tcktcnclreason;
	}

	public void setTcktcnclreason(com.sellerportal.model.OctParam tcktcnclreason) {
		this.tcktcnclreason = tcktcnclreason;
	}*/
	
	
/*	public com.sellerportal.model.OctTicketReq getTcktoctticktreq() {
		return tcktoctticktreq;
	}

	public void setTcktoctticktreq(com.sellerportal.model.OctTicketReq tcktoctticktreq) {
		this.tcktoctticktreq = tcktoctticktreq;
	}*/

	public String toString() {
        return new ToStringBuilder(this)
            .append("octrfnum", getOctdtrfnum())
            .toString();
    }

/*	public com.sellerportal.model.OctParam getOctParamSubTickType() {
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
	}*/

		
	
}