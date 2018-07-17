package com.agit.crm.domain.customer.kuesioner;

import com.agit.crm.shared.object.EntityObject;
import java.util.Date;
import java.util.Objects;

/**
 *
 * @author lintang
 */
public class PertanyaanOpsi implements EntityObject<PertanyaanOpsi> {

    long id;
    private String pertanyaanOpsiID;
    private String pertanyaanID;
    private String opsi;
    private double value;
    private String createdBy;
    private Date createdDate;
    private String modifiedBy;
    private Date modifiedDate;

    public PertanyaanOpsi() {
    }

    public PertanyaanOpsi(String pertanyaanOpsiID, String pertanyaanID, String opsi, double value, String createdBy, Date createdDate, String modifiedBy, Date modifiedDate) {
        this.pertanyaanOpsiID = pertanyaanOpsiID;
        this.pertanyaanID = pertanyaanID;
        this.opsi = opsi;
        this.value = value;
        this.createdBy = createdBy;
        this.createdDate = createdDate;
        this.modifiedBy = modifiedBy;
        this.modifiedDate = modifiedDate;
    }

    public void assignNewOpsi(PertanyaanOpsi o) {
        this.pertanyaanOpsiID = o.pertanyaanOpsiID;
        this.pertanyaanID = o.pertanyaanID;
        this.opsi = o.opsi;
        this.value = o.value;
        this.modifiedBy = o.modifiedBy;
        this.modifiedDate = o.modifiedDate;
    }

    public String getPertanyaanOpsiID() {
        return pertanyaanOpsiID;
    }

    public void setPertanyaanOpsiID(String pertanyaanOpsiID) {
        this.pertanyaanOpsiID = pertanyaanOpsiID;
    }

    public String getPertanyaanID() {
        return pertanyaanID;
    }

    public void setPertanyaanID(String pertanyaanID) {
        this.pertanyaanID = pertanyaanID;
    }

    public String getOpsi() {
        return opsi;
    }

    public void setOpsi(String opsi) {
        this.opsi = opsi;
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

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 53 * hash + Objects.hashCode(this.pertanyaanOpsiID);
        hash = 53 * hash + Objects.hashCode(this.pertanyaanID);
        hash = 53 * hash + Objects.hashCode(this.opsi);
        hash = 53 * hash + (int) (Double.doubleToLongBits(this.value) ^ (Double.doubleToLongBits(this.value) >>> 32));
        hash = 53 * hash + Objects.hashCode(this.createdBy);
        hash = 53 * hash + Objects.hashCode(this.createdDate);
        hash = 53 * hash + Objects.hashCode(this.modifiedBy);
        hash = 53 * hash + Objects.hashCode(this.modifiedDate);
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
        final PertanyaanOpsi other = (PertanyaanOpsi) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

    @Override
    public boolean sameIdentityAs(PertanyaanOpsi other) {
        return this.equals(other);
    }

}
