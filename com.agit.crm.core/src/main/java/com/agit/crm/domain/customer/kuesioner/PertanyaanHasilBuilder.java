package com.agit.crm.domain.customer.kuesioner;

import java.util.Date;

public class PertanyaanHasilBuilder {

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

    public PertanyaanHasilBuilder() {
    }

    public PertanyaanHasilBuilder setPertanyaanHasilID(String pertanyaanHasilID) {
        this.pertanyaanHasilID = pertanyaanHasilID;
        return this;
    }

    public PertanyaanHasilBuilder setPertanyaanID(String pertanyaanID) {
        this.pertanyaanID = pertanyaanID;
        return this;
    }

    public PertanyaanHasilBuilder setTouchpointID(String touchpointID) {
        this.touchpointID = touchpointID;
        return this;
    }

    public PertanyaanHasilBuilder setPertanyaanOpsiID(String pertanyaanOpsiID) {
        this.pertanyaanOpsiID = pertanyaanOpsiID;
        return this;
    }

    public PertanyaanHasilBuilder setNama(String nama) {
        this.nama = nama;
        return this;
    }

    public PertanyaanHasilBuilder setEmail(String email) {
        this.email = email;
        return this;
    }

    public PertanyaanHasilBuilder setContact(String contact) {
        this.contact = contact;
        return this;
    }

    public PertanyaanHasilBuilder setValue(double value) {
        this.value = value;
        return this;
    }

    public PertanyaanHasilBuilder setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
        return this;
    }

    public PertanyaanHasilBuilder setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
        return this;
    }

    public PertanyaanHasilBuilder setModifiedBy(String modifiedBy) {
        this.modifiedBy = modifiedBy;
        return this;
    }

    public PertanyaanHasilBuilder setModifiedDate(Date modifiedDate) {
        this.modifiedDate = modifiedDate;
        return this;
    }

    public PertanyaanHasil createPertanyaanHasil() {
        return new PertanyaanHasil(pertanyaanHasilID, pertanyaanID, touchpointID, pertanyaanOpsiID, nama, email, contact, value, createdBy, createdDate, modifiedBy, modifiedDate);
    }

}
