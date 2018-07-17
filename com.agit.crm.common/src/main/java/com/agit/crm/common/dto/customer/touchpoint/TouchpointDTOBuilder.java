package com.agit.crm.common.dto.customer.touchpoint;

import java.util.Date;


public class TouchpointDTOBuilder {
    private String touchpointID;
    private String touchpoint;
    private String deskripsi;
    private String url;
    private String createdBy;
    private Date createdDate;
    private String modifiedBy;
    private Date modifiedDate;

    public TouchpointDTOBuilder() {
    }

    public TouchpointDTOBuilder setTouchpointID(String touchpointID) {
        this.touchpointID = touchpointID;
        return this;
    }

    public TouchpointDTOBuilder setTouchpoint(String touchpoint) {
        this.touchpoint = touchpoint;
        return this;
    }

    public TouchpointDTOBuilder setDeskripsi(String deskripsi) {
        this.deskripsi = deskripsi;
        return this;
    }

    public TouchpointDTOBuilder setUrl(String url) {
        this.url = url;
        return this;
    }

    public TouchpointDTOBuilder setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
        return this;
    }

    public TouchpointDTOBuilder setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
        return this;
    }

    public TouchpointDTOBuilder setModifiedBy(String modifiedBy) {
        this.modifiedBy = modifiedBy;
        return this;
    }

    public TouchpointDTOBuilder setModifiedDate(Date modifiedDate) {
        this.modifiedDate = modifiedDate;
        return this;
    }

    public TouchpointDTO createTouchpointDTO() {
        return new TouchpointDTO(touchpointID, touchpoint, deskripsi, url, createdBy, createdDate, modifiedBy, modifiedDate);
    }
    
}
