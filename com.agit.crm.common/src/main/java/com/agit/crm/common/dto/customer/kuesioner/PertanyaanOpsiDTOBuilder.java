package com.agit.crm.common.dto.customer.kuesioner;

import java.util.Date;

public class PertanyaanOpsiDTOBuilder {

    private String pertanyaanOpsiID;
    private String pertanyaanID;
    private String opsi;
    private double value;
    private String createdBy;
    private Date createdDate;
    private String modifiedBy;
    private Date modifiedDate;

    public PertanyaanOpsiDTOBuilder() {
    }

    public PertanyaanOpsiDTOBuilder setPertanyaanOpsiID(String pertanyaanOpsiID) {
        this.pertanyaanOpsiID = pertanyaanOpsiID;
        return this;
    }

    public PertanyaanOpsiDTOBuilder setPertanyaanID(String pertanyaanID) {
        this.pertanyaanID = pertanyaanID;
        return this;
    }

    public PertanyaanOpsiDTOBuilder setOpsi(String opsi) {
        this.opsi = opsi;
        return this;
    }

    public PertanyaanOpsiDTOBuilder setValue(double value) {
        this.value = value;
        return this;
    }

    public PertanyaanOpsiDTOBuilder setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
        return this;
    }

    public PertanyaanOpsiDTOBuilder setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
        return this;
    }

    public PertanyaanOpsiDTOBuilder setModifiedBy(String modifiedBy) {
        this.modifiedBy = modifiedBy;
        return this;
    }

    public PertanyaanOpsiDTOBuilder setModifiedDate(Date modifiedDate) {
        this.modifiedDate = modifiedDate;
        return this;
    }

    public PertanyaanOpsiDTO createPertanyaanOpsiDTO() {
        return new PertanyaanOpsiDTO(pertanyaanOpsiID, pertanyaanID, opsi, value, createdBy, createdDate, modifiedBy, modifiedDate);
    }

}
