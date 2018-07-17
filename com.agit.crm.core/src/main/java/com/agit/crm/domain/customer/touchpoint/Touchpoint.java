package com.agit.crm.domain.customer.touchpoint;

import com.agit.crm.shared.object.EntityObject;
import java.util.Date;
import java.util.Objects;

/**
 *
 * @author lintang
 */
public class Touchpoint implements EntityObject<Touchpoint> {

    long id;
    private String touchpointID;
    private String touchpoint;
    private String deskripsi;
    private String url;
    private String createdBy;
    private Date createdDate;
    private String modifiedBy;
    private Date modifiedDate;

    public Touchpoint() {
    }

    public Touchpoint(String touchpointID, String touchpoint, String deskripsi, String url, String createdBy, Date createdDate, String modifiedBy, Date modifiedDate) {
        this.touchpointID = touchpointID;
        this.touchpoint = touchpoint;
        this.deskripsi = deskripsi;
        this.url = url;
        this.createdBy = createdBy;
        this.createdDate = createdDate;
        this.modifiedBy = modifiedBy;
        this.modifiedDate = modifiedDate;
    }

    public void assignNewTouchpoint(Touchpoint t) {
        this.touchpointID = t.touchpointID;
        this.touchpoint = t.touchpoint;
        this.deskripsi = t.deskripsi;
        this.url = t.url;
        this.modifiedBy = t.modifiedBy;
        this.modifiedDate = t.modifiedDate;
    }

    public String getTouchpointID() {
        return touchpointID;
    }

    public void setTouchpointID(String touchpointID) {
        this.touchpointID = touchpointID;
    }

    public String getTouchpoint() {
        return touchpoint;
    }

    public void setTouchpoint(String touchpoint) {
        this.touchpoint = touchpoint;
    }

    public String getDeskripsi() {
        return deskripsi;
    }

    public void setDeskripsi(String deskripsi) {
        this.deskripsi = deskripsi;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
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
        hash = 29 * hash + Objects.hashCode(this.touchpointID);
        hash = 29 * hash + Objects.hashCode(this.touchpoint);
        hash = 29 * hash + Objects.hashCode(this.deskripsi);
        hash = 29 * hash + Objects.hashCode(this.url);
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
        final Touchpoint other = (Touchpoint) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

    @Override
    public boolean sameIdentityAs(Touchpoint other) {
        return this.equals(other);
    }

}
