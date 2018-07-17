package com.agit.crm.common.dto.customer.kuesioner;

import com.agit.crm.shared.status.Status;
import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author lintang
 */
public class PertanyaanDTO implements Serializable {

    private String pertanyaanID;
    private String pertanyaan;
    private String touchpoint;
    private Status status;
    private String createdBy;
    private Date createdDate;
    private String modifiedBy;
    private Date modifiedDate;

    public PertanyaanDTO() {
    }

    public PertanyaanDTO(String pertanyaanID, String pertanyaan, String touchpoint, Status status, String createdBy, Date createdDate, String modifiedBy, Date modifiedDate) {
        this.pertanyaanID = pertanyaanID;
        this.pertanyaan = pertanyaan;
        this.touchpoint = touchpoint;
        this.status = status;
        this.createdBy = createdBy;
        this.createdDate = createdDate;
        this.modifiedBy = modifiedBy;
        this.modifiedDate = modifiedDate;
    }

    public void assignNewPertanyaan(PertanyaanDTO p) {
        this.pertanyaanID = p.pertanyaanID;
        this.pertanyaan = p.pertanyaan;
        this.status = p.status;
        this.touchpoint = p.touchpoint;
        this.modifiedBy = p.modifiedBy;
        this.modifiedDate = p.modifiedDate;
    }

    public String getPertanyaanID() {
        return pertanyaanID;
    }

    public void setPertanyaanID(String pertanyaanID) {
        this.pertanyaanID = pertanyaanID;
    }

    public String getPertanyaan() {
        return pertanyaan;
    }

    public void setPertanyaan(String pertanyaan) {
        this.pertanyaan = pertanyaan;
    }

    public String getTouchpoint() {
        return touchpoint;
    }

    public void setTouchpoint(String touchpoint) {
        this.touchpoint = touchpoint;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
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
        return "PertanyaanDTO{" + "pertanyaanID=" + pertanyaanID + ", pertanyaan=" + pertanyaan + ", touchpoint=" + touchpoint + ", status=" + status + ", createdBy=" + createdBy + ", createdDate=" + createdDate + ", modifiedBy=" + modifiedBy + ", modifiedDate=" + modifiedDate + '}';
    }

}
