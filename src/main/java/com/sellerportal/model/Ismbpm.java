package com.sellerportal.model;

import java.io.Serializable;
import java.util.Date;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import javax.persistence.*;


@Entity
@Table(name = "ISMBPM")
public class Ismbpm implements Serializable {

    @EmbeddedId
    private IsmbpmId id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "BPMCNDBUSINESSID", nullable = false)
    private Ismcnd ismcnd;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "BPMPMTRFNUM", nullable = false)
    private Ismpmt ismpmt;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "BPMMDMRFNUM", nullable = false)
    private Ismmdm ismmdm;

    // Getters and setters
    public IsmbpmId getId() {
        return id;
    }

    public void setId(IsmbpmId id) {
        this.id = id;
    }

    public Ismcnd getIsmcnd() {
        return ismcnd;
    }

    public void setIsmcnd(Ismcnd ismcnd) {
        this.ismcnd = ismcnd;
    }

    public Ismpmt getIsmpmt() {
        return ismpmt;
    }

    public void setIsmpmt(Ismpmt ismpmt) {
        this.ismpmt = ismpmt;
    }

    public Ismmdm getIsmmdm() {
        return ismmdm;
    }

    public void setIsmmdm(Ismmdm ismmdm) {
        this.ismmdm = ismmdm;
    }

    // Equals method
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Ismbpm ismbpm = (Ismbpm) o;

        return new EqualsBuilder()
            .append(id, ismbpm.id)
            .isEquals();
    }

    // HashCode method
    @Override
    public int hashCode() {
        return new HashCodeBuilder()
            .append(id)
            .toHashCode();
    }

    // ToString method
    @Override
    public String toString() {
        return new ToStringBuilder(this)
            .append("id", id)
            .toString();
    }

    
}
