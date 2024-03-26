package com.sellerportal.model;

import java.io.Serializable;
import java.util.Date;

import org.apache.commons.lang.builder.ToStringBuilder;
import javax.persistence.*;

@Entity
@Table(name = "oct_product_video")
public class ProductVideo implements Serializable {

	@Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pvrfnum_seq")
    @SequenceGenerator(name = "pvrfnum_seq", sequenceName = "PROD_VIDEO_PVRFNUM_SEQ", allocationSize = 1)
    @Column(name = "PVRFNUM")
    private Long pvrfnum;

    @Column(name = "CREATEDATE", nullable = false)
    private Date createdate;

    @Column(name = "CREATEDBY", nullable = false, length = 20)
    private Long createdby;

    @Column(name = "DELETED", nullable = false, length = 1)
    private String deleted;

    @Column(name = "MODIDATE", nullable = false)
    private Date modidate;

    @Column(name = "MODIFIEDBY", nullable = false, length = 20)
    private Long modifiedby;

    @Column(name = "VIDEOLINK", length = 256)
    private String videolink;

    @Column(name = "VIDEOTITLE", length = 256)
    private String videotitle;

    @Column(name = "VIDEOFILE", length = 256)
    private String videofile;

    @Column(name = "VIDEOSEQ", length = 60)
    private String videoseq;

    @Column(name = "VIDEOCOMMENT", length = 256)
    private String videocomment;

    @Column(name = "VIDEOTYPE", length = 1)
    private String videotype;

    @ManyToOne
    @JoinColumn(name = "PVPBIRFNUM", nullable = false)
    private Ismpbi ismpbi;

    /** full constructor */
    public ProductVideo(Date createdate, Long createdby, String deleted, Date modidate, Long modifiedby, String videolink,String videotitle,String videofile,String videoseq,String videocomment,String videotype, com.sellerportal.model.Ismpbi ismpbi) {
        this.createdate = createdate;
        this.createdby = createdby;
        this.deleted = deleted;
        this.modidate = modidate;
        this.modifiedby = modifiedby;
        this.videolink = videolink;
        this.videotitle = videotitle;
        this.videofile = videofile;
        this.videoseq = videoseq;
        this.videocomment = videocomment;
        this.videotype = videotype;
        this.ismpbi = ismpbi;
    }

    /** default constructor */
    public ProductVideo() {
    }

    /** 
     * 		       auto_increment
     * 		    
     */
    

    public Date getCreatedate() {
        return this.createdate;
    }

    public Long getPvrfnum() {
		return pvrfnum;
	}

	public void setPvrfnum(Long pvrfnum) {
		this.pvrfnum = pvrfnum;
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

    public String getVideolink() {
        return this.videolink;
    }

    public void setVideolink(String videolink) {
        this.videolink = videolink;
    }
    
    public String getVideotitle() {
		return videotitle;
	}

	public void setVideotitle(String videotitle) {
		this.videotitle = videotitle;
	}

	public String getVideofile() {
		return videofile;
	}

	public void setVideofile(String videofile) {
		this.videofile = videofile;
	}

	public String getVideoseq() {
		return videoseq;
	}

	public void setVideoseq(String videoseq) {
		this.videoseq = videoseq;
	}

	public String getVideocomment() {
		return videocomment;
	}

	public void setVideocomment(String videocomment) {
		this.videocomment = videocomment;
	}
	
    public com.sellerportal.model.Ismpbi getIsmpbi() {
		return ismpbi;
	}

	public void setIsmpbi(com.sellerportal.model.Ismpbi ismpbi) {
		this.ismpbi = ismpbi;
	}
	
	public String getVideotype() {
		return videotype;
	}

	public void setVideotype(String videotype) {
		this.videotype = videotype;
	}

	public String toString() {
        return new ToStringBuilder(this)
            .append("pvrfnum", getPvrfnum())
            .toString();
    }

}
