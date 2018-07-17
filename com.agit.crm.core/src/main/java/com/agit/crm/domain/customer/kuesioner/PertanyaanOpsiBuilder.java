package com.agit.crm.domain.customer.kuesioner;

import java.util.Date;

public class PertanyaanOpsiBuilder {

    private String pertanyaanOpsiID;
    private String pertanyaanID;
    private String opsi;
    private double value;
    private String createdBy;
    private Date createdDate;
    private String modifiedBy;
    private Date modifiedDate;

    public PertanyaanOpsiBuilder() {
    }

    public PertanyaanOpsiBuilder setPertanyaanOpsiID(String pertanyaanOpsiID) {
        this.pertanyaanOpsiID = pertanyaanOpsiID;
        return this;
    }

    public PertanyaanOpsiBuilder setPertanyaanID(String pertanyaanID) {
        this.pertanyaanID = pertanyaanID;
        return this;
    }

    public PertanyaanOpsiBuilder setOpsi(String opsi) {
        this.opsi = opsi;
        return this;
    }

    public PertanyaanOpsiBuilder setValue(double value) {
        this.value = value;
        return this;
    }

    public PertanyaanOpsiBuilder setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
        return this;
    }

    public PertanyaanOpsiBuilder setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
        return this;
    }

    public PertanyaanOpsiBuilder setModifiedBy(String modifiedBy) {
        this.modifiedBy = modifiedBy;
        return this;
    }

    public PertanyaanOpsiBuilder setModifiedDate(Date modifiedDate) {
        this.modifiedDate = modifiedDate;
        return this;
    }

    public PertanyaanOpsi createPertanyaanOpsi() {
        return new PertanyaanOpsi(pertanyaanOpsiID, pertanyaanID, opsi, value, createdBy, createdDate, modifiedBy, modifiedDate);
    }

}
