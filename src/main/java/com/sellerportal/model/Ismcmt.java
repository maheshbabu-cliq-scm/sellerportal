package com.sellerportal.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import org.apache.commons.lang3.builder.ToStringBuilder;
import javax.persistence.*;

@Entity
@Table(name = "ISMCMT")
public class Ismcmt implements Serializable,Comparable<Ismcmt> {

	@Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ISMCMT_CMTRFNUM_SEQ")
    @SequenceGenerator(name = "ISMCMT_CMTRFNUM_SEQ", sequenceName = "ISMCMT_CMTRFNUM_SEQ", allocationSize = 1)
    @Column(name = "CMTRFNUM")
    private Long cmtrfnum;

    @Column(name = "CMTKEYDESC", length = 2048)
    private String cmtkeydesc;

    @Column(name = "CMTNAME", nullable = false, length = 254)
    private String cmtname;

    @Column(name = "CMTTITLE", length = 254)
    private String cmttitle;

    @Column(name = "CMTCODE", length = 254)
    private String cmtcode;

    @Column(name = "CMTDESC", nullable = false, length = 5000)
    private String cmtdesc;

    @Column(name = "CMTIMAGE", length = 254)
    private String cmtimage;

    @Column(name = "CMTISACTIVE", length = 1)
    private String cmtisactive;

    @Column(name = "CMTMETADESC", length = 2048)
    private String cmtmetadesc;

    @Column(name = "CMTISPRIMARY")
    private String cmtisprimary;

    @Column(name = "CMTSEQ", length = 11)
    private Integer cmtseq;

    @Column(name = "costCenter", length = 10)
    private Float costCenter;

    @Column(name = "profitCenter", length = 10)
    private Float profitCenter;

    @Column(name = "CREATEDATE", nullable = false)
    private Date createdate;

    @Column(name = "CREATEDBY", nullable = false)
    private Long createdby;

    @Column(name = "MODIFIEDBY", nullable = false)
    private Long modifiedby;

    @Column(name = "DELETED", nullable = false, length = 1)
    private String deleted;

    @Column(name = "MODIDATE", nullable = false)
    private Date modidate;

    @Column(name = "PRODIMGPREFIX", length = 10)
    private String prodimgprefix;

    @Column(name = "CMTREQUIREIMG", length = 20)
    private String cmtrequireimg;

    @Column(name = "CMTLEVEL", nullable = false, length = 38)
    private Long cmtlevel;
    
	/** full constructor */
    public Ismcmt(String cmtcode, String cmtdesc,String cmtisprimary, String cmtimage, String cmtisactive,String cmtstaging,String cmtisparent,String cmtissubparent, String cmtisism, String cmtisordermail, String cmtispublish, String cmtkeydesc, String cmtname, String cmttitle, Integer cmtseq, String cmtsmsdesc, String cmtthumbnail, Date createdate, Long createdby, String deleted, Date modidate, com.sellerportal.model.Ismptm ismptm, com.sellerportal.model.Ismafm ismafm,com.sellerportal.model.Ismcnd ismcnd, Set ismaccs, Set ismppls, Set ismslgs, Set ismccrs, Set ismpcas, Set ismppts, Set ismcptsByCptcmtrfnum, Set ismcptsByCptcmtrfnum1, Set ismmcts,Set octctms, Set octctmsBynewcmts, String cmtthumbnaillink, String cmtimagelink, String cmttype,String cmtmetadesc,Long modifiedby,Long cmtimgwidth,Long cmtimgheight,String cmtalternatename,String cmtislistingenable,String isCategoryDisplayName, String cmtisbooks, String prodimgprefix,String cmtrequireimg, Long cmtlevel) {
        this.cmtcode = cmtcode;
        this.cmtdesc = cmtdesc;
        this.cmtisprimary=cmtisprimary;
        this.cmtimage = cmtimage;
        this.cmtisactive = cmtisactive;
        this.cmtkeydesc = cmtkeydesc;
        this.cmtname = cmtname;
        this.cmttitle = cmttitle;
        this.cmtseq = cmtseq;
        this.cmtmetadesc=cmtmetadesc; 
        this.modidate=modidate;
        this.modifiedby=modifiedby;
        this.createdate=createdate;
        this.createdby=createdby;
        this.deleted=deleted;
        this.prodimgprefix = prodimgprefix;
        this.cmtrequireimg = cmtrequireimg;
        this.cmtlevel = cmtlevel;
    }

    /** default constructor */
    public Ismcmt() {
    }

    /** minimal constructor */
    public Ismcmt(String cmtcode, String cmtdesc, String cmtname, Date createdate, Long createdby, String deleted, Date modidate, com.sellerportal.model.Ismptm ismptm, com.sellerportal.model.Ismafm ismafm, Set ismaccs, Set ismppls, Set ismslgs, Set ismccrs, Set ismpcas, Set ismppts, Set ismcptsByCptcmtrfnum, Set ismcptsByCptcmtrfnum1, Set ismmcts,Set octctms,  Set octctmsBynewcmts,String cmtalternatename) {
        this.cmtcode = cmtcode;
        this.cmtdesc = cmtdesc;
        this.cmtname = cmtname;
    }

    /** 
     * 		       auto_increment
     * 		    
     */
    public Long getCmtrfnum() {
        return this.cmtrfnum;
    }

    public String getCmtmetadesc() {
		return cmtmetadesc;
	}

	public void setCmtmetadesc(String cmtmetadesc) {
		this.cmtmetadesc = cmtmetadesc;
	}

	public void setCmtrfnum(Long cmtrfnum) {
        this.cmtrfnum = cmtrfnum;
    }

    public String getCmtcode() {
        return this.cmtcode;
    }

    public void setCmtcode(String cmtcode) {
        this.cmtcode = cmtcode;
    }

    public String getCmtdesc() {
        return this.cmtdesc;
    }

    public void setCmtdesc(String cmtdesc) {
        this.cmtdesc = cmtdesc;
    }

    public String getCmtimage() {
        return this.cmtimage;
    }

    public void setCmtimage(String cmtimage) {
        this.cmtimage = cmtimage;
    }

    public String getCmtisactive() {
        return this.cmtisactive;
    }

    public void setCmtisactive(String cmtisactive) {
        this.cmtisactive = cmtisactive;
    }
   
    public String getCmtkeydesc() {
        return this.cmtkeydesc;
    }

    public void setCmtkeydesc(String cmtkeydesc) {
        this.cmtkeydesc = cmtkeydesc;
    }

    public String getCmtname() {
        return this.cmtname;
    }

    public void setCmtname(String cmtname) {
        this.cmtname = cmtname;
    }

    public Integer getCmtseq() {
        return this.cmtseq;
    }

    public void setCmtseq(Integer cmtseq) {
        this.cmtseq = cmtseq;
    }

  

    public String toString() {
        return new ToStringBuilder(this)
            .append("cmtrfnum", getCmtrfnum())
            .toString();
    }

	public String getCmttitle() {
		return cmttitle;
	}

	public void setCmttitle(String cmttitle) {
		this.cmttitle = cmttitle;
	}

	
	public int compareTo(Ismcmt cmt) {
		
		if(cmtseq != null && cmt.getCmtseq() != null){			
			if(cmtseq < cmt.getCmtseq()){
				return -1;
			}
			else if(cmtseq > cmt.getCmtseq()){
				return +1;
			}
			else{
				return 0;
			}
		}
		
		return 0;
	}

	public String getCmtisprimary() {
		return cmtisprimary;
	}

	public void setCmtisprimary(String cmtisprimary) {
		this.cmtisprimary = cmtisprimary;
	}

	public Float getCostCenter() {
		return costCenter;
	}

	public void setCostCenter(Float costCenter) {
		this.costCenter = costCenter;
	}

	public Float getProfitCenter() {
		return profitCenter;
	}

	public void setProfitCenter(Float profitCenter) {
		this.profitCenter = profitCenter;
	}

	public Date getCreatedate() {
		return createdate;
	}

	public void setCreatedate(Date createdate) {
		this.createdate = createdate;
	}

	public Long getCreatedby() {
		return createdby;
	}

	public void setCreatedby(Long createdby) {
		this.createdby = createdby;
	}

	public String getDeleted() {
		return deleted;
	}

	public void setDeleted(String deleted) {
		this.deleted = deleted;
	}

	public Date getModidate() {
		return modidate;
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

	public String getProdimgprefix() {
		return prodimgprefix;
	}

	public void setProdimgprefix(String prodimgprefix) {
		this.prodimgprefix = prodimgprefix;
	}

	public String getCmtrequireimg() {
		return cmtrequireimg;
	}

	public void setCmtrequireimg(String cmtrequireimg) {
		this.cmtrequireimg = cmtrequireimg;
	}

	public Long getCmtlevel() {
		return cmtlevel;
	}

	public void setCmtlevel(Long cmtlevel) {
		this.cmtlevel = cmtlevel;
	}
	
	
}
