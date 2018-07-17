package com.agit.crm.domain.customer.kuesioner;

import com.agit.crm.shared.object.EntityObject;
import com.agit.crm.shared.status.Status;
import java.util.Date;
import java.util.Objects;

/**
 *
 * @author lintang
 */
public class Pertanyaan implements EntityObject<Pertanyaan> {

    long id;
    private String pertanyaanID;
    private String pertanyaan;
    private String touchpoint;
    private Status status;
    private String createdBy;
    private Date createdDate;
    private String modifiedBy;
    private Date modifiedDate;

    public Pertanyaan() {
    }

    public Pertanyaan(String pertanyaanID, String pertanyaan, String touchpoint, Status status, String createdBy, Date createdDate, String modifiedBy, Date modifiedDate) {
        this.pertanyaanID = pertanyaanID;
        this.pertanyaan = pertanyaan;
        this.touchpoint = touchpoint;
        this.status = status;
        this.createdBy = createdBy;
        this.createdDate = createdDate;
        this.modifiedBy = modifiedBy;
        this.modifiedDate = modifiedDate;
    }

    public void assignNewPertanyaan(Pertanyaan p) {
        this.pertanyaanID = p.pertanyaanID;
        this.pertanyaan = p.pertanyaan;
        this.status = p.status;
        this.touchpoint = p.touchpoint;
        this.modifiedBy = p.modifiedBy;
        this.modifiedDate = p.modifiedDate;
    }

    public String getPertanyaanID() {
        return pertanyaanID;
    }

    public void setPertanyaanID(String pertanyaanID) {
        this.pertanyaanID = pertanyaanID;
    }

    public String getPertanyaan() {
        return pertanyaan;
    }

    public void setPertanyaan(String pertanyaan) {
        this.pertanyaan = pertanyaan;
    }

    public String getTouchpoint() {
        return touchpoint;
    }

    public void setTouchpoint(String touchpoint) {
        this.touchpoint = touchpoint;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public String getModifiedBy() {
        return modifiedBy;
    }

    public void setModifiedBy(String modifiedBy) {
        this.modifiedBy = modifiedBy;
    }

    public Date getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(Date modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + Objects.hashCode(this.pertanyaanID);
        hash = 29 * hash + Objects.hashCode(this.pertanyaan);
        hash = 29 * hash + Objects.hashCode(this.touchpoint);
        hash = 29 * hash + Objects.hashCode(this.status);
        hash = 29 * hash + Objects.hashCode(this.createdBy);
        hash = 29 * hash + Objects.hashCode(this.createdDate);
        hash = 29 * hash + Objects.hashCode(this.modifiedBy);
        hash = 29 * hash + Objects.hashCode(this.modifiedDate);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Pertanyaan other = (Pertanyaan) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

    @Override
    public boolean sameIdentityAs(Pertanyaan other) {
        return this.equals(other);
    }

}
