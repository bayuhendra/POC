package com.agit.crm.domain.customer.kuesioner;

import com.agit.crm.shared.status.Status;
import java.util.Date;

public class PertanyaanBuilder {

    private String pertanyaanID;
    private String pertanyaan;
    private String touchpoint;
    private Status status;
    private String createdBy;
    private Date createdDate;
    private String modifiedBy;
    private Date modifiedDate;

    public PertanyaanBuilder() {
    }

    public PertanyaanBuilder setPertanyaanID(String pertanyaanID) {
        this.pertanyaanID = pertanyaanID;
        return this;
    }

    public PertanyaanBuilder setPertanyaan(String pertanyaan) {
        this.pertanyaan = pertanyaan;
        return this;
    }

    public PertanyaanBuilder setTouchpoint(String touchpoint) {
        this.touchpoint = touchpoint;
        return this;
    }

    public PertanyaanBuilder setStatus(Status status) {
        this.status = status;
        return this;
    }

    public PertanyaanBuilder setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
        return this;
    }

    public PertanyaanBuilder setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
        return this;
    }

    public PertanyaanBuilder setModifiedBy(String modifiedBy) {
        this.modifiedBy = modifiedBy;
        return this;
    }

    public PertanyaanBuilder setModifiedDate(Date modifiedDate) {
        this.modifiedDate = modifiedDate;
        return this;
    }

    public Pertanyaan createPertanyaan() {
        return new Pertanyaan(pertanyaanID, pertanyaan, touchpoint, status, createdBy, createdDate, modifiedBy, modifiedDate);
    }

}
