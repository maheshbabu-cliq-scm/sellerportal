package com.sellerportal.model;

import java.io.Serializable;
import java.util.Date;

import org.apache.commons.lang.builder.ToStringBuilder;
import javax.persistence.*;

@Entity
@Table(name = "OCT_SLR_PRODUCT_LIST_VIDEO")
public class SlrProductListVideo implements Serializable {

	@Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "splv_splvrfnum_seq")
    @SequenceGenerator(name = "splv_splvrfnum_seq", sequenceName = "SPLV_SPLVRFNUM_SEQ", allocationSize = 1)
    @Column(name = "SPLVRFNUM")
    private Long splvrfnum;

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

    @Column(name = "VIDEOCOMMENT", length = 256)
    private String videocomment;

    @Column(name = "VIDEOFILENAME", length = 256)
    private String videofilename;

    @Column(name = "VIDEOLINK", length = 256)
    private String videolink;

    @Column(name = "VIDEOTITLE", length = 256)
    private String videotitle;

    @Column(name = "VIDEOTYPE", length = 1)
    private String videotype;

    @Column(name = "VIDEOSEQUENCE", length = 5)
    private String videosequence;

    @ManyToOne
    @JoinColumn(name = "SPLVSPLRFNUM", nullable = false)
    private SlrProductList slrProductList;

    /** full constructor */
    public SlrProductListVideo(Date createdate, Long createdby, String deleted, Date modidate, Long modifiedby, String videocomment, String videofilename, String videolink, String videotitle, String videotype,String videosequence, com.sellerportal.model.SlrProductList slrProductList) {
        this.createdate = createdate;
        this.createdby = createdby;
        this.deleted = deleted;
        this.modidate = modidate;
        this.modifiedby = modifiedby;
        this.videocomment = videocomment;
        this.videofilename = videofilename;
        this.videolink = videolink;
        this.videotitle = videotitle;
        this.videotype = videotype;
        this.slrProductList = slrProductList;
        this.videosequence = videosequence;
    }

    /** default constructor */
    public SlrProductListVideo() {
    }

    /** minimal constructor */
    public SlrProductListVideo(Date createdate, Long createdby, String deleted, Date modidate, Long modifiedby, com.sellerportal.model.SlrProductList slrProductList) {
        this.createdate = createdate;
        this.createdby = createdby;
        this.deleted = deleted;
        this.modidate = modidate;
        this.modifiedby = modifiedby;
        this.slrProductList = slrProductList;
    }

    public Long getSplvrfnum() {
        return this.splvrfnum;
    }

    public void setSplvrfnum(Long splvrfnum) {
        this.splvrfnum = splvrfnum;
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

    public String getVideocomment() {
        return this.videocomment;
    }

    public void setVideocomment(String videocomment) {
        this.videocomment = videocomment;
    }

    public String getVideofilename() {
        return this.videofilename;
    }

    public void setVideofilename(String videofilename) {
        this.videofilename = videofilename;
    }

    public String getVideolink() {
        return this.videolink;
    }

    public void setVideolink(String videolink) {
        this.videolink = videolink;
    }

    public String getVideotitle() {
        return this.videotitle;
    }

    public void setVideotitle(String videotitle) {
        this.videotitle = videotitle;
    }

    public String getVideotype() {
        return this.videotype;
    }

    public void setVideotype(String videotype) {
        this.videotype = videotype;
    }

    public com.sellerportal.model.SlrProductList getSlrProductList() {
        return this.slrProductList;
    }

    public void setSlrProductList(com.sellerportal.model.SlrProductList slrProductList) {
        this.slrProductList = slrProductList;
    }
    
    public String getVideosequence() {
		return videosequence;
	}

	public void setVideosequence(String videosequence) {
		this.videosequence = videosequence;
	}

	public String toString() {
        return new ToStringBuilder(this)
            .append("splvrfnum", getSplvrfnum())
            .toString();
    }

}
