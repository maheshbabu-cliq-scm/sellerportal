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
@Table(name = "OCT_SLR_RATING")
public class OctSlrRating implements Serializable{
	
	/**
	 * 
	 */
	@Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "slr_rating_seq_generator")
    @SequenceGenerator(name = "slr_rating_seq_generator", sequenceName = "SLR_RATING_SEQ", allocationSize = 1)
    @Column(name = "SLRRATINGRFNUM")
    private Long slrRatingRfnum;

    @Column(name = "SLRCODE", length = 24)
    private Long slrCode;

    @Column(name = "RAISED", length = 10)
    private BigDecimal raised;

    @Column(name = "IMPROVE", length = 30)
    private String improve;

    @Column(name = "SCORE", length = 5)
    private String score;

    @Column(name = "RESULTOFDAYS", length = 10)
    private String resultOfDays;

    @Column(name = "FROMDATE")
    private Date fromDate;

    @Column(name = "TODATE")
    private Date toDate;

    @Column(name = "PREVRAISED", length = 10)
    private BigDecimal prevRaised;

    @Column(name = "TIERRATE", length = 10)
    private String tierRate;

    @Column(name = "CRITERIARATE", length = 10)
    private BigDecimal criteriaRate;

    @Column(name = "CREATEDATE")
    private Date createdate;

    @Column(name = "MODIDATE")
    private Date modidate;

    @ManyToOne
    @JoinColumn(name = "SLRRFNUM")
    private OctSlr slrRfnum;

    @ManyToOne
    @JoinColumn(name = "OCTPARAM")
    private OctParam octparam;
    
	public Long getSlrRatingRfnum() {
		return slrRatingRfnum;
	}
	public void setSlrRatingRfnum(Long slrRatingRfnum) {
		this.slrRatingRfnum = slrRatingRfnum;
	}
	public OctSlr getSlrRfnum() {
		return slrRfnum;
	}
	public void setSlrRfnum(OctSlr slrRfnum) {
		this.slrRfnum = slrRfnum;
	}
	public OctParam getOctparam() {
		return octparam;
	}
	public void setOctparam(OctParam octparam) {
		this.octparam = octparam;
	}
	public Long getSlrCode() {
		return slrCode;
	}
	public void setSlrCode(Long slrCode) {
		this.slrCode = slrCode;
	}
	public BigDecimal getRaised() {
		return raised;
	}
	public void setRaised(BigDecimal raised) {
		this.raised = raised;
	}
	public String getImprove() {
		return improve;
	}
	public void setImprove(String improve) {
		this.improve = improve;
	}
	public String getScore() {
		return score;
	}
	public void setScore(String score) {
		this.score = score;
	}
	public String getResultOfDays() {
		return resultOfDays;
	}
	public void setResultOfDays(String resultOfDays) {
		this.resultOfDays = resultOfDays;
	}
	public Date getFromDate() {
		return fromDate;
	}
	public void setFromDate(Date fromDate) {
		this.fromDate = fromDate;
	}
	public Date getToDate() {
		return toDate;
	}
	public void setToDate(Date toDate) {
		this.toDate = toDate;
	}
	public BigDecimal getPrevRaised() {
		return prevRaised;
	}
	public void setPrevRaised(BigDecimal prevRaised) {
		this.prevRaised = prevRaised;
	}
	public String getTierRate() {
		return tierRate;
	}
	public void setTierRate(String tierRate) {
		this.tierRate = tierRate;
	}
	public BigDecimal getCriteriaRate() {
		return criteriaRate;
	}
	public void setCriteriaRate(BigDecimal criteriaRate) {
		this.criteriaRate = criteriaRate;
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