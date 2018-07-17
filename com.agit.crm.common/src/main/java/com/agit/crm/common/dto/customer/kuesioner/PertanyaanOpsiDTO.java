package com.agit.crm.common.dto.customer.kuesioner;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author lintang
 */
public class PertanyaanOpsiDTO implements Serializable {

    private String pertanyaanOpsiID;
    private String pertanyaanID;
    private String opsi;
    private double value;
    private String createdBy;
    private Date createdDate;
    private String modifiedBy;
    private Date modifiedDate;

    public PertanyaanOpsiDTO() {
    }

    public PertanyaanOpsiDTO(String pertanyaanOpsiID, String pertanyaanID, String opsi, double value, String createdBy, Date createdDate, String modifiedBy, Date modifiedDate) {
        this.pertanyaanOpsiID = pertanyaanOpsiID;
        this.pertanyaanID = pertanyaanID;
        this.opsi = opsi;
        this.value = value;
        this.createdBy = createdBy;
        this.createdDate = createdDate;
        this.modifiedBy = modifiedBy;
        this.modifiedDate = modifiedDate;
    }

    public void assignNewOpsi(PertanyaanOpsiDTO o) {
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
    public String toString() {
        return "PertanyaanOpsiDTO{" + "pertanyaanOpsiID=" + pertanyaanOpsiID + ", pertanyaanID=" + pertanyaanID + ", opsi=" + opsi + ", value=" + value + ", createdBy=" + createdBy + ", createdDate=" + createdDate + ", modifiedBy=" + modifiedBy + ", modifiedDate=" + modifiedDate + '}';
    }

}
