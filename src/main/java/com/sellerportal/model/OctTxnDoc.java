package com.sellerportal.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;
/*CREATE TABLE "TCSDB"."OCT_TXN_DOC"
(
   TXNDOCRFNUM decimal(24,0) PRIMARY KEY NOT NULL,
   TRANNO decimal(24,0) references ismpst(pstrfnum),
   DOCFOR decimal(24,0) references oct_param(paramrfnum),
   CREATEDATE  Date, 
   DOCPATH varchar2(250)
);*/
@Entity
@Table(name = "OCT_TXN_DOC")
public class OctTxnDoc implements Serializable {
	 @Id
	    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "TXNDOCRFNUM_AUTOINC_SEQ")
	    @SequenceGenerator(name = "TXNDOCRFNUM_AUTOINC_SEQ", sequenceName = "TXNDOCRFNUM_AUTOINC_SEQ", allocationSize = 1)
	    @Column(name = "TXNDOCRFNUM")
	    private Long txndocrfnum;

	    @ManyToOne(fetch = FetchType.LAZY)
	    @JoinColumn(name = "DOCFOR")
	    private OctParam docfor;

	    @ManyToOne(fetch = FetchType.LAZY)
	    @JoinColumn(name = "TRANNO")
	    private Ismpst transno;

	    @Column(name = "CREATEDATE", nullable = false)
	    private Date createDate;

	    @Column(name = "DOCPATH", length = 250)
	    private String docpath;
    
    

    /** full constructor */
    public OctTxnDoc(Long txndocrfnum, OctParam docfor, Ismpst transno, Date createDate,String docpath ) {
        this.txndocrfnum=txndocrfnum;
        this.docfor=docfor;
        this.transno=transno;
        this.createDate=createDate;      
        this.docpath=docpath;
    }

    /** default constructor */
    public OctTxnDoc() {
    }

	public Long getTxndocrfnum() {
		return txndocrfnum;
	}

	public void setTxndocrfnum(Long txndocrfnum) {
		this.txndocrfnum = txndocrfnum;
	}

	public OctParam getDocfor() {
		return docfor;
	}

	public void setDocfor(OctParam docfor) {
		this.docfor = docfor;
	}

	public Ismpst getTransno() {
		return transno;
	}

	public void setTransno(Ismpst transno) {
		this.transno = transno;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public String getDocpath() {
		return docpath;
	}

	public void setDocpath(String docpath) {
		this.docpath = docpath;
	}

	
}
