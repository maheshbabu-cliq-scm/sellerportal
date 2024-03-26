package com.sellerportal.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.*;
/**
 * @author:Tiwari Suraj
 * :: Seller Rating
 */
@Entity
@Table(name = "OCT_SLR_SCORE")
public class OctSlrScore implements Serializable{
	
	/**
	 * 
	 */
	 @Id
	    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "slr_score_seq_generator")
	    @SequenceGenerator(name = "slr_score_seq_generator", sequenceName = "SLR_SCORE_SEQ", allocationSize = 1)
	    @Column(name = "SCORERFNUM")
	    private Long scoreRfnum;

	    @Column(name = "SLRCODE", length = 24)
	    private Long slrCode;

	    @Column(name = "RATING", length = 10)
	    private String rating;

	    @Column(name = "SEQUENCE", length = 5)
	    private String sequence;

	    @Column(name = "RESULTOFDAYS", length = 10)
	    private String resultOfDays;

	    @Column(name = "IMGURL", length = 300)
	    private String imgUrl;

	    @Column(name = "TOTALSCORE", length = 10)
	    private String totalScore;

	    @Column(name = "SALESCOUNT", precision = 24, scale = 0)
	    private BigDecimal salesCount;

	    @Column(name = "SALESVALUE", precision = 24, scale = 0)
	    private BigDecimal salesValue;

	    @Column(name = "COUNTIMPROVE", length = 25)
	    private String countImprove;

	    @Column(name = "VALUEIMPROVE", length = 25)
	    private String valueImprove;

	    @Column(name = "SELLERRATINGPDFURL", length = 300)
	    private String sellerRatingPdfUrl;

	    @Column(name = "CREATEDATE")
	    private Date createdate;

	    @Column(name = "MODIDATE")
	    private Date modidate;

	    @ManyToOne
	    @JoinColumn(name = "SLRRFNUM")
	    private OctSlr slrRfnum;
	
	public Long getScoreRfnum() {
		return scoreRfnum;
	}
	public void setScoreRfnum(Long scoreRfnum) {
		this.scoreRfnum = scoreRfnum;
	}
	public OctSlr getSlrRfnum() {
		return slrRfnum;
	}
	public void setSlrRfnum(OctSlr slrRfnum) {
		this.slrRfnum = slrRfnum;
	}
	public Long getSlrCode() {
		return slrCode;
	}
	public void setSlrCode(Long slrCode) {
		this.slrCode = slrCode;
	}
	public String getRating() {
		return rating;
	}
	public void setRating(String rating) {
		this.rating = rating;
	}
	public String getSequence() {
		return sequence;
	}
	public void setSequence(String sequence) {
		this.sequence = sequence;
	}
	public String getResultOfDays() {
		return resultOfDays;
	}
	public void setResultOfDays(String resultOfDays) {
		this.resultOfDays = resultOfDays;
	}
	public String getImgUrl() {
		return imgUrl;
	}
	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}
	public String getTotalScore() {
		return totalScore;
	}
	public void setTotalScore(String totalScore) {
		this.totalScore = totalScore;
	}
	public BigDecimal getSalesCount() {
		return salesCount;
	}
	public void setSalesCount(BigDecimal salesCount) {
		this.salesCount = salesCount;
	}
	public BigDecimal getSalesValue() {
		return salesValue;
	}
	public void setSalesValue(BigDecimal salesValue) {
		this.salesValue = salesValue;
	}
	public String getCountImprove() {
		return countImprove;
	}
	public void setCountImprove(String countImprove) {
		this.countImprove = countImprove;
	}
	public String getValueImprove() {
		return valueImprove;
	}
	public void setValueImprove(String valueImprove) {
		this.valueImprove = valueImprove;
	}
	public String getSellerRatingPdfUrl() {
		return sellerRatingPdfUrl;
	}
	public void setSellerRatingPdfUrl(String sellerRatingPdfUrl) {
		this.sellerRatingPdfUrl = sellerRatingPdfUrl;
	}
	public Date getCreatedate() {
		return createdate;
	}
	public void setCreatedate(Date createdate) {
		this.createdate = createdate;
	}
	public Date getModidate() {
		return modidate;
	}
	public void setModidate(Date modidate) {
		this.modidate = modidate;
	}
}