package com.agit.crm.common.dto.customer.touchpoint;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author lintang
 */
public class TouchpointDTO implements Serializable {

    private String touchpointID;
    private String touchpoint;
    private String deskripsi;
    private String url;
    private String createdBy;
    private Date createdDate;
    private String modifiedBy;
    private Date modifiedDate;

    public TouchpointDTO() {
    }

    public TouchpointDTO(String touchpointID, String touchpoint, String deskripsi, String url, String createdBy, Date createdDate, String modifiedBy, Date modifiedDate) {
        this.touchpointID = touchpointID;
        this.touchpoint = touchpoint;
        this.deskripsi = deskripsi;
        this.url = url;
        this.createdBy = createdBy;
        this.createdDate = createdDate;
        this.modifiedBy = modifiedBy;
        this.modifiedDate = modifiedDate;
    }

    public void assignNewTouchpoint(TouchpointDTO t) {
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
    public String toString() {
        return "TouchpointDTO{" + "touchpointID=" + touchpointID + ", touchpoint=" + touchpoint + ", deskripsi=" + deskripsi + ", url=" + url + ", createdBy=" + createdBy + ", createdDate=" + createdDate + ", modifiedBy=" + modifiedBy + ", modifiedDate=" + modifiedDate + '}';
    }

}
