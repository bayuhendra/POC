package com.agit.crm.common.dto.customer.kuesioner;

import java.util.Date;

public class PertanyaanHasilDTOBuilder {

    private String pertanyaanHasilID;
    private String pertanyaanID;
    private String touchpointID;
    private String pertanyaanOpsiID;
    private String nama;
    private String email;
    private String contact;
    private double value;
    private String createdBy;
    private Date createdDate;
    private String modifiedBy;
    private Date modifiedDate;

    public PertanyaanHasilDTOBuilder() {
    }

    public PertanyaanHasilDTOBuilder setPertanyaanHasilID(String pertanyaanHasilID) {
        this.pertanyaanHasilID = pertanyaanHasilID;
        return this;
    }

    public PertanyaanHasilDTOBuilder setPertanyaanID(String pertanyaanID) {
        this.pertanyaanID = pertanyaanID;
        return this;
    }

    public PertanyaanHasilDTOBuilder setTouchpointID(String touchpointID) {
        this.touchpointID = touchpointID;
        return this;
    }

    public PertanyaanHasilDTOBuilder setPertanyaanOpsiID(String pertanyaanOpsiID) {
        this.pertanyaanOpsiID = pertanyaanOpsiID;
        return this;
    }

    public PertanyaanHasilDTOBuilder setNama(String nama) {
        this.nama = nama;
        return this;
    }

    public PertanyaanHasilDTOBuilder setEmail(String email) {
        this.email = email;
        return this;
    }

    public PertanyaanHasilDTOBuilder setContact(String contact) {
        this.contact = contact;
        return this;
    }

    public PertanyaanHasilDTOBuilder setValue(double value) {
        this.value = value;
        return this;
    }

    public PertanyaanHasilDTOBuilder setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
        return this;
    }

    public PertanyaanHasilDTOBuilder setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
        return this;
    }

    public PertanyaanHasilDTOBuilder setModifiedBy(String modifiedBy) {
        this.modifiedBy = modifiedBy;
        return this;
    }

    public PertanyaanHasilDTOBuilder setModifiedDate(Date modifiedDate) {
        this.modifiedDate = modifiedDate;
        return this;
    }

    public PertanyaanHasilDTO createPertanyaanHasilDTO() {
        return new PertanyaanHasilDTO(pertanyaanHasilID, pertanyaanID, touchpointID, pertanyaanOpsiID, nama, email, contact, value, createdBy, createdDate, modifiedBy, modifiedDate);
    }

}
