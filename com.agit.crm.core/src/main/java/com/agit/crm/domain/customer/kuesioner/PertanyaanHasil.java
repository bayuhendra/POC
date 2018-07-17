package com.agit.crm.domain.customer.kuesioner;

import com.agit.crm.shared.object.EntityObject;
import java.util.Date;
import java.util.Objects;

/**
 *
 * @author lintang
 */
public class PertanyaanHasil implements EntityObject<PertanyaanHasil> {

    long id;
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

    public PertanyaanHasil() {
    }

    public PertanyaanHasil(String pertanyaanHasilID, String pertanyaanID, String touchpointID, String pertanyaanOpsiID, String nama, String email, String contact, double value, String createdBy, Date createdDate, String modifiedBy, Date modifiedDate) {
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

    public void assignNewHasil(PertanyaanHasil h) {
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
    public int hashCode() {
        int hash = 7;
        hash = 43 * hash + Objects.hashCode(this.pertanyaanHasilID);
        hash = 43 * hash + Objects.hashCode(this.pertanyaanID);
        hash = 43 * hash + Objects.hashCode(this.pertanyaanOpsiID);
        hash = 43 * hash + Objects.hashCode(this.touchpointID);
        hash = 43 * hash + Objects.hashCode(this.nama);
        hash = 43 * hash + Objects.hashCode(this.email);
        hash = 43 * hash + Objects.hashCode(this.contact);
        hash = 43 * hash + (int) (Double.doubleToLongBits(this.value) ^ (Double.doubleToLongBits(this.value) >>> 32));
        hash = 43 * hash + Objects.hashCode(this.createdBy);
        hash = 43 * hash + Objects.hashCode(this.createdDate);
        hash = 43 * hash + Objects.hashCode(this.modifiedBy);
        hash = 43 * hash + Objects.hashCode(this.modifiedDate);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final PertanyaanHasil other = (PertanyaanHasil) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

    @Override
    public boolean sameIdentityAs(PertanyaanHasil other) {
        return this.equals(other);
    }

}
