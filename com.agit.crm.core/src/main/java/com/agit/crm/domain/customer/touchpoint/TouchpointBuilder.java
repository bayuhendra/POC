package com.agit.crm.domain.customer.touchpoint;

import java.util.Date;

public class TouchpointBuilder {

    private String touchpointID;
    private String touchpoint;
    private String deskripsi;
    private String url;
    private String createdBy;
    private Date createdDate;
    private String modifiedBy;
    private Date modifiedDate;

    public TouchpointBuilder() {
    }

    public TouchpointBuilder setTouchpointID(String touchpointID) {
        this.touchpointID = touchpointID;
        return this;
    }

    public TouchpointBuilder setTouchpoint(String touchpoint) {
        this.touchpoint = touchpoint;
        return this;
    }

    public TouchpointBuilder setDeskripsi(String deskripsi) {
        this.deskripsi = deskripsi;
        return this;
    }

    public TouchpointBuilder setUrl(String url) {
        this.url = url;
        return this;
    }

    public TouchpointBuilder setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
        return this;
    }

    public TouchpointBuilder setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
        return this;
    }

    public TouchpointBuilder setModifiedBy(String modifiedBy) {
        this.modifiedBy = modifiedBy;
        return this;
    }

    public TouchpointBuilder setModifiedDate(Date modifiedDate) {
        this.modifiedDate = modifiedDate;
        return this;
    }

    public Touchpoint createTouchpoint() {
        return new Touchpoint(touchpointID, touchpoint, deskripsi, url, createdBy, createdDate, modifiedBy, modifiedDate);
    }

}
