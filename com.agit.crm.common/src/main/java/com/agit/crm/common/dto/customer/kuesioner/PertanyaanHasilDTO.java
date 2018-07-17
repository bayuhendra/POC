package com.agit.crm.common.dto.customer.kuesioner;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author lintang
 */
public class PertanyaanHasilDTO implements Serializable {

    private String pertanyaanHasilID;
    private String pertanyaanID;
    private String pertanyaanOpsiID;
    private String touchpointID;
    private String nama;
    private String email;
    private String contact;
    private double value;
    private String createdBy;
    private Date createdDate;
    private String modifiedBy;
    private Date modifiedDate;

    public PertanyaanHasilDTO() {
    }

    public PertanyaanHasilDTO(String pertanyaanHasilID, String pertanyaanID, String touchpointID, String pertanyaanOpsiID, String nama, String email, String contact, double value, String createdBy, Date createdDate, String modifiedBy, Date modifiedDate) {
        this.pertanyaanHasilID = pertanyaanHasilID;
        this.pertanyaanID = pertanyaanID;
        this.pertanyaanOpsiID = pertanyaanOpsiID;
        this.touchpointID = touchpointID;
        this.nama = nama;
        this.email = email;
        this.contact = contact;
        this.value = value;
        this.createdBy = createdBy;
        this.createdDate = createdDate;
        this.modifiedBy = modifiedBy;
        this.modifiedDate = modifiedDate;
    }

    public void assignNewHasil(PertanyaanHasilDTO h) {
        this.pertanyaanHasilID = h.pertanyaanHasilID;
        this.pertanyaanID = h.pertanyaanID;
        this.pertanyaanOpsiID = h.pertanyaanOpsiID;
        this.touchpointID = h.touchpointID;
        this.nama = h.nama;
        this.email = h.email;
        this.contact = h.contact;
        this.value = h.value;
        this.modifiedBy = h.modifiedBy;
        this.modifiedDate = h.modifiedDate;
    }

    public String getPertanyaanHasilID() {
        return pertanyaanHasilID;
    }

    public void setPertanyaanHasilID(String pertanyaanHasilID) {
        this.pertanyaanHasilID = pertanyaanHasilID;
    }

    public String getPertanyaanID() {
        return pertanyaanID;
    }

    public void setPertanyaanID(String pertanyaanID) {
        this.pertanyaanID = pertanyaanID;
    }

    public String getPertanyaanOpsiID() {
        return pertanyaanOpsiID;
    }

    public void setPertanyaanOpsiID(String pertanyaanOpsiID) {
        this.pertanyaanOpsiID = pertanyaanOpsiID;
    }

    public String getTouchpointID() {
        return touchpointID;
    }

    public void setTouchpointID(String touchpointID) {
        this.touchpointID = touchpointID;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
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
        return "PertanyaanHasilDTO{" + "pertanyaanHasilID=" + pertanyaanHasilID + ", pertanyaanID=" + pertanyaanID + ", pertanyaanOpsiID=" + pertanyaanOpsiID + ", touchpointID=" + touchpointID + ", nama=" + nama + ", email=" + email + ", contact=" + contact + ", value=" + value + ", createdBy=" + createdBy + ", createdDate=" + createdDate + ", modifiedBy=" + modifiedBy + ", modifiedDate=" + modifiedDate + '}';
    }

}
