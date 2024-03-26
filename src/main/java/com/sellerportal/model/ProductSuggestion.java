package com.sellerportal.model;

import java.io.Serializable;
import java.util.Date;

import org.apache.commons.lang.builder.ToStringBuilder;
import javax.persistence.*;

@Entity
@Table(name = "oct_product_suggestion")
public class ProductSuggestion implements Serializable {

	@Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sp_psrnum_seq")
    @SequenceGenerator(name = "sp_psrnum_seq", sequenceName = "SP_PSRNUM_SEQ", allocationSize = 1)
    @Column(name = "PSRFNUM")
    private Long psrfnum;

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

    @Column(name = "SUGGESTIONS", nullable = false, length = 256)
    private String suggestions;

    @ManyToOne
    @JoinColumn(name = "PSSLRRFNUM", nullable = false)
    private OctSlr octSlr;

    @ManyToOne
    @JoinColumn(name = "PSSPLRFNUM", nullable = false)
    private SlrProductList slrProductList;

    /** full constructor */
    public ProductSuggestion(Date createdate, Long createdby, String deleted, Date modidate, Long modifiedby, String suggestions, com.sellerportal.model.OctSlr octSlr, com.sellerportal.model.SlrProductList slrProductList) {
        this.createdate = createdate;
        this.createdby = createdby;
        this.deleted = deleted;
        this.modidate = modidate;
        this.modifiedby = modifiedby;
        this.suggestions = suggestions;
        this.octSlr = octSlr;
        this.slrProductList = slrProductList;
    }

    /** default constructor */
    public ProductSuggestion() {
    }

    /** 
     * 		       auto_increment
     * 		    
     */
    public Long getPsrfnum() {
        return this.psrfnum;
    }

    public void setPsrfnum(Long psrfnum) {
        this.psrfnum = psrfnum;
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

    public String getSuggestions() {
        return this.suggestions;
    }

    public void setSuggestions(String suggestions) {
        this.suggestions = suggestions;
    }

    public com.sellerportal.model.OctSlr getOctSlr() {
        return this.octSlr;
    }

    public void setOctSlr(com.sellerportal.model.OctSlr octSlr) {
        this.octSlr = octSlr;
    }
    
    public com.sellerportal.model.SlrProductList getSlrProductList() {
		return slrProductList;
	}

	public void setSlrProductList(com.sellerportal.model.SlrProductList slrProductList) {
		this.slrProductList = slrProductList;
	}

	public String toString() {
        return new ToStringBuilder(this)
            .append("psrfnum", getPsrfnum())
            .toString();
    }

}
