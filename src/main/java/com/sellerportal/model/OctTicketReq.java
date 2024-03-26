package com.sellerportal.model;

import java.io.Serializable;
import java.util.Date;

import org.apache.commons.lang.builder.ToStringBuilder;
import javax.persistence.*;

@Entity
@Table(name = "OCT_TICKET_REQ")
public class OctTicketReq extends ParentPojo implements Serializable {

	@Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "octTicketReqSeq")
    @SequenceGenerator(name = "octTicketReqSeq", sequenceName = "OCT_TICKET_REQ_SEQ", allocationSize = 1)
    @Column(name = "OCTREQRFNUM")
    private Long octreqrfnum;

    @Column(name = "CREATEDATE", nullable = false)
    private Date createdate;

    @Column(name = "CREATEDBY", nullable = false)
    private Long createdby;

    @Column(name = "DELETED", length = 1)
    private String deleted;

    @Column(name = "OCTREQTYPE", length = 1)
    private String octreqtype;

    @Column(name = "MODIDATE")
    private Date modidate;

    @Column(name = "MODIFIEDBY", nullable = false)
    private Long modifiedby;

    @ManyToOne
    @JoinColumn(name = "OCTREQPST", nullable = false)
    private Ismpst ismpst;
    /** full constructor */
    public OctTicketReq(Date createdate, Long createdby, String deleted,String octreqtype, Date modidate, Long modifiedby, com.sellerportal.model.Ismpst ismpst) {
        this.createdate = createdate;
        this.createdby = createdby;
        this.deleted = deleted;
        this.modidate = modidate;
        this.modifiedby = modifiedby;
        this.ismpst = ismpst;
        this.octreqtype=octreqtype; 
    }

    /** default constructor */
    public OctTicketReq() {
    }

    /** minimal constructor */
    public OctTicketReq(Date createdate, Long createdby, Long modifiedby, com.sellerportal.model.Ismpst ismpst) {
        this.createdate = createdate;
        this.createdby = createdby;
        this.modifiedby = modifiedby;
        this.ismpst = ismpst;
    }

    public Long getOctreqrfnum() {
        return this.octreqrfnum;
    }

    public void setOctreqrfnum(Long octreqrfnum) {
        this.octreqrfnum = octreqrfnum;
    }


    public com.sellerportal.model.Ismpst getIsmpst() {
        return this.ismpst;
    }

    public void setIsmpst(com.sellerportal.model.Ismpst ismpst) {
        this.ismpst = ismpst;
    }
    
    public String getOctreqtype() {
		return octreqtype;
	}

	public void setOctreqtype(String octreqtype) {
		this.octreqtype = octreqtype;
	}

	public String toString() {
        return new ToStringBuilder(this)
            .append("octreqrfnum", getOctreqrfnum())
            .toString();
    }

}
