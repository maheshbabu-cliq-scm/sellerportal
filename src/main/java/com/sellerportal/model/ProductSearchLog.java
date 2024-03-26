package com.sellerportal.model;

import java.io.Serializable;
import java.util.Date;

import org.apache.commons.lang.builder.ToStringBuilder;
import javax.persistence.*;

@Entity
@Table(name = "OCT_PRODUCT_SEARCH_LOG")
public class ProductSearchLog implements Serializable {

	@Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "psl_seq")
    @SequenceGenerator(name = "psl_seq", sequenceName = "PSL_PSLRFNUM_SEQ", allocationSize = 1)
    @Column(name = "PSLRFNUM")
    private Long pslrfnum;

    @Column(name = "CREATEDATE", nullable = false)
    private Date createdate;

    @Column(name = "SEARCHKEYWORD", length = 120)
    private String searchkeyword;

    @ManyToOne
    @JoinColumn(name = "PSLSLRRFNUM", nullable = false)
    private OctSlr octSlr;

    @ManyToOne
    @JoinColumn(name = "PSLPBIRFNUM", nullable = false)
    private Ismpbi ismpbi;

    /** full constructor */
    public ProductSearchLog(Date createdate,String searchkeyword, com.sellerportal.model.OctSlr octSlr,com.sellerportal.model.Ismpbi ismpbi) {
        this.createdate = createdate;
        this.searchkeyword = searchkeyword;
        this.octSlr = octSlr;
        this.ismpbi = ismpbi;
    }

    /** default constructor */
    public ProductSearchLog() {
    }

    /** minimal constructor */
    public ProductSearchLog(Date createdate,com.sellerportal.model.OctSlr octSlr,com.sellerportal.model.Ismpbi ismpbi) {
        this.createdate = createdate;
        this.octSlr = octSlr;
        this.ismpbi = ismpbi;
    }

    public Long getPslrfnum() {
		return pslrfnum;
	}

	public void setPslrfnum(Long pslrfnum) {
		this.pslrfnum = pslrfnum;
	}

	public Date getCreatedate() {
		return createdate;
	}

	public void setCreatedate(Date createdate) {
		this.createdate = createdate;
	}

	public String getSearchkeyword() {
		return searchkeyword;
	}

	public void setSearchkeyword(String searchkeyword) {
		this.searchkeyword = searchkeyword;
	}

	public com.sellerportal.model.OctSlr getOctSlr() {
		return octSlr;
	}

	public void setOctSlr(com.sellerportal.model.OctSlr octSlr) {
		this.octSlr = octSlr;
	}

	public com.sellerportal.model.Ismpbi getIsmpbi() {
		return ismpbi;
	}

	public void setIsmpbi(com.sellerportal.model.Ismpbi ismpbi) {
		this.ismpbi = ismpbi;
	}

	public String toString() {
        return new ToStringBuilder(this)
            .append("pslrfnum", getPslrfnum())
            .toString();
    }
	
}
