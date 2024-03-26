package com.sellerportal.model;

import java.io.Serializable;
import java.util.Date;

import org.apache.commons.lang.builder.ToStringBuilder;
import javax.persistence.*;

@Entity
@Table(name = "OCT_SLV_INFO")
public class OctSlvInfo extends ParentPojo implements Serializable  {

	@Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "oct_slv_info_seq")
    @SequenceGenerator(name = "oct_slv_info_seq", sequenceName = "OCT_SLV_INFO_SLVINFORFNUM_SEQ", allocationSize = 1)
    @Column(name = "SLVINFORFNUM")
    private Long slvinforfnum;

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

    @Column(name = "ORGID", nullable = false)
    private Long orgid;

    @Column(name = "SLVINFOADDRESS", length = 128)
    private String slvinfoaddress;

    @Column(name = "SLVINFODESGNTN", length = 128)
    private String slvinfodesgntn;

    @Column(name = "SLVINFOEMAIL", length = 128)
    private String slvinfoemail;

    @Column(name = "SLVINFOFNAME", length = 128)
    private String slvinfofname;

    @Column(name = "SLVINFOMNAME", length = 128)
    private String slvinfomname;

    @Column(name = "SLVINFOSURNAME", length = 128)
    private String slvinfosurname;

    @Column(name = "SLVINFOPHONEO", length = 128)
    private String slvinfophoneo;

    @Column(name = "SLVINFOPHONEP", length = 128)
    private String slvinfophonep;

    @Column(name = "SLVLOGISTICIDENTIFIER", length = 10)
    private String slvlogisticidentifier;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "OCTSLVRFNUM", nullable = false)
    private OctSlv octSlv;

    /** full constructor */
    public OctSlvInfo(Date createdate, Long createdby, String deleted, Date modidate, Long modifiedby, Long orgid, String slvinfoaddress, String slvinfodesgntn, String slvinfoemail, String slvinfofname,String slvinfomname,String slvinfosurname , String slvinfophoneo, String slvinfophonep,String slvlogisticidentifier, com.sellerportal.model.OctSlv octSlv) {
        this.createdate = createdate;
        this.createdby = createdby;
        this.deleted = deleted;
        this.modidate = modidate;
        this.modifiedby = modifiedby;
        this.orgid = orgid;
        this.slvinfoaddress = slvinfoaddress;
        this.slvinfodesgntn = slvinfodesgntn;
        this.slvinfoemail = slvinfoemail;
        this.slvinfofname = slvinfofname;
        this.slvinfophoneo = slvinfophoneo;
        this.slvinfophonep = slvinfophonep;
        this.slvinfomname = slvinfomname;
        this.slvinfosurname = slvinfosurname;
        this.slvlogisticidentifier = slvlogisticidentifier;
        this.octSlv = octSlv;
    }

    /** default constructor */
    public OctSlvInfo() {
    }

    /** minimal constructor */
    public OctSlvInfo(Date createdate, Long createdby, String deleted, Date modidate, Long modifiedby, Long orgid, com.sellerportal.model.OctSlv octSlv) {
        this.createdate = createdate;
        this.createdby = createdby;
        this.deleted = deleted;
        this.modidate = modidate;
        this.modifiedby = modifiedby;
        this.orgid = orgid;
        this.octSlv = octSlv;
    }

    /** 
     * 		       auto_increment
     * 		    
     */
    public Long getSlvinforfnum() {
        return this.slvinforfnum;
    }

    public void setSlvinforfnum(Long slvinforfnum) {
        this.slvinforfnum = slvinforfnum;
    }

    

    public Long getOrgid() {
        return this.orgid;
    }

    public void setOrgid(Long orgid) {
        this.orgid = orgid;
    }

    public String getSlvinfoaddress() {
        return this.slvinfoaddress;
    }

    public void setSlvinfoaddress(String slvinfoaddress) {
        this.slvinfoaddress = slvinfoaddress;
    }

    public String getSlvinfodesgntn() {
        return this.slvinfodesgntn;
    }

    public void setSlvinfodesgntn(String slvinfodesgntn) {
        this.slvinfodesgntn = slvinfodesgntn;
    }

    public String getSlvinfoemail() {
        return this.slvinfoemail;
    }

    public void setSlvinfoemail(String slvinfoemail) {
        this.slvinfoemail = slvinfoemail;
    }

    public String getSlvinfofname() {
        return this.slvinfofname;
    }

    public void setSlvinfofname(String slvinfofname) {
        this.slvinfofname = slvinfofname;
    }

    public String getSlvinfophoneo() {
        return this.slvinfophoneo;
    }

    public void setSlvinfophoneo(String slvinfophoneo) {
        this.slvinfophoneo = slvinfophoneo;
    }

    public String getSlvinfophonep() {
        return this.slvinfophonep;
    }

    public void setSlvinfophonep(String slvinfophonep) {
        this.slvinfophonep = slvinfophonep;
    }

    public com.sellerportal.model.OctSlv getOctSlv() {
        return this.octSlv;
    }

    public void setOctSlv(com.sellerportal.model.OctSlv octSlv) {
        this.octSlv = octSlv;
    }
    
    

    public String getSlvinfomname() {
		return slvinfomname;
	}

	public void setSlvinfomname(String slvinfomname) {
		this.slvinfomname = slvinfomname;
	}

	public String getSlvinfosurname() {
		return slvinfosurname;
	}

	public void setSlvinfosurname(String slvinfosurname) {
		this.slvinfosurname = slvinfosurname;
	}

	public String getSlvlogisticidentifier() {
		return slvlogisticidentifier;
	}

	public void setSlvlogisticidentifier(String slvlogisticidentifier) {
		this.slvlogisticidentifier = slvlogisticidentifier;
	}

	public String toString() {
        return new ToStringBuilder(this)
            .append("slvinforfnum", getSlvinforfnum())
            .toString();
    }

}
