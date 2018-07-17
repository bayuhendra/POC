package com.agit.crm.common.dto.customer.kuesioner;

import com.agit.crm.shared.status.Status;
import java.util.Date;

public class PertanyaanDTOBuilder {

    private String pertanyaanID;
    private String pertanyaan;
    private String touchpoint;
    private Status status;
    private String createdBy;
    private Date createdDate;
    private String modifiedBy;
    private Date modifiedDate;

    public PertanyaanDTOBuilder() {
    }

    public PertanyaanDTOBuilder setPertanyaanID(String pertanyaanID) {
        this.pertanyaanID = pertanyaanID;
        return this;
    }

    public PertanyaanDTOBuilder setPertanyaan(String pertanyaan) {
        this.pertanyaan = pertanyaan;
        return this;
    }

    public PertanyaanDTOBuilder setTouchpoint(String touchpoint) {
        this.touchpoint = touchpoint;
        return this;
    }

    public PertanyaanDTOBuilder setStatus(Status status) {
        this.status = status;
        return this;
    }

    public PertanyaanDTOBuilder setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
        return this;
    }

    public PertanyaanDTOBuilder setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
        return this;
    }

    public PertanyaanDTOBuilder setModifiedBy(String modifiedBy) {
        this.modifiedBy = modifiedBy;
        return this;
    }

    public PertanyaanDTOBuilder setModifiedDate(Date modifiedDate) {
        this.modifiedDate = modifiedDate;
        return this;
    }

    public PertanyaanDTO createPertanyaanDTO() {
        return new PertanyaanDTO(pertanyaanID, pertanyaan, touchpoint, status, createdBy, createdDate, modifiedBy, modifiedDate);
    }

}
