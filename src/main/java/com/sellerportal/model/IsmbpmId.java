package com.sellerportal.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

@Embeddable
public class IsmbpmId implements Serializable {

    @Column(name = "BPMISACTIVE", nullable = false, length = 1)
    private String bpmisactive;

    @Column(name = "BPMRFNUM", nullable = false, length = 10)
    private Long bpmrfnum;

    @Column(name = "BPMSUCESSDETAILS", length = 255)
    private String bpmsucessdetails;

    @Column(name = "CREATEDATE", nullable = false)
    private Date createdate;

    @Column(name = "CREATEDBY", nullable = false, length = 20)
    private Long createdby;

    @Column(name = "DELETED", nullable = false, length = 1)
    private String deleted;

    @Column(name = "MODIDATE")
    private Date modidate;

    // Getters and setters
    public String getBpmisactive() {
        return bpmisactive;
    }

    public void setBpmisactive(String bpmisactive) {
        this.bpmisactive = bpmisactive;
    }

    public Long getBpmrfnum() {
        return bpmrfnum;
    }

    public void setBpmrfnum(Long bpmrfnum) {
        this.bpmrfnum = bpmrfnum;
    }

    public String getBpmsucessdetails() {
        return bpmsucessdetails;
    }

    public void setBpmsucessdetails(String bpmsucessdetails) {
        this.bpmsucessdetails = bpmsucessdetails;
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

    // Equals method
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        IsmbpmId ismbpmId = (IsmbpmId) o;

        return new EqualsBuilder()
            .append(bpmisactive, ismbpmId.bpmisactive)
            .append(bpmrfnum, ismbpmId.bpmrfnum)
            .append(bpmsucessdetails, ismbpmId.bpmsucessdetails)
            .append(createdate, ismbpmId.createdate)
            .append(createdby, ismbpmId.createdby)
            .append(deleted, ismbpmId.deleted)
            .append(modidate, ismbpmId.modidate)
            .isEquals();
    }

    // HashCode method
    @Override
    public int hashCode() {
        return new HashCodeBuilder()
            .append(bpmisactive)
            .append(bpmrfnum)
            .append(bpmsucessdetails)
            .append(createdate)
            .append(createdby)
            .append(deleted)
            .append(modidate)
            .toHashCode();
    }

    // ToString method
    @Override
    public String toString() {
        return new ToStringBuilder(this)
            .append("bpmisactive", bpmisactive)
            .append("bpmrfnum", bpmrfnum)
            .append("bpmsucessdetails", bpmsucessdetails)
            .append("createdate", createdate)
            .append("createdby", createdby)
            .append("deleted", deleted)
            .append("modidate", modidate)
            .toString();
    }
}
