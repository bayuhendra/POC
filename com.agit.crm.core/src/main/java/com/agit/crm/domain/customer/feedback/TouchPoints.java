package com.agit.crm.domain.customer.feedback;

import com.agit.crm.shared.object.EntityObject;
import java.util.Date;
import java.util.Objects;

/**
 *
 * @author BayuHS
 */
public class TouchPoints implements EntityObject<Answer> {

    private long id;
    private String touchpointsID;
    private String nameTouchpoints;
    private String createdBy;
    private Date createdDate;
    private String modifiedBy;
    private Date modifiedDate;

    public TouchPoints() {
    }

    public TouchPoints(long id, String touchpointsID, String nameTouchpoints, String createdBy, Date createdDate, String modifiedBy, Date modifiedDate) {
        this.id = id;
        this.touchpointsID = touchpointsID;
        this.nameTouchpoints = nameTouchpoints;
        this.createdBy = createdBy;
        this.createdDate = createdDate;
        this.modifiedBy = modifiedBy;
        this.modifiedDate = modifiedDate;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTouchpointsID() {
        return touchpointsID;
    }

    public void setTouchpointsID(String touchpointsID) {
        this.touchpointsID = touchpointsID;
    }

    public String getNameTouchpoints() {
        return nameTouchpoints;
    }

    public void setNameTouchpoints(String nameTouchpoints) {
        this.nameTouchpoints = nameTouchpoints;
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
        hash = 19 * hash + Objects.hashCode(this.touchpointsID);
        hash = 19 * hash + Objects.hashCode(this.nameTouchpoints);
        hash = 19 * hash + Objects.hashCode(this.createdBy);
        hash = 19 * hash + Objects.hashCode(this.createdDate);
        hash = 19 * hash + Objects.hashCode(this.modifiedBy);
        hash = 19 * hash + Objects.hashCode(this.modifiedDate);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final TouchPoints other = (TouchPoints) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

    public void assignNewTouchPoints(TouchPoints touchPoints) {
        this.touchpointsID = touchPoints.touchpointsID;
        this.nameTouchpoints = touchPoints.nameTouchpoints;
        this.createdBy = touchPoints.createdBy;
        this.createdDate = touchPoints.createdDate;
        this.modifiedBy = touchPoints.modifiedBy;
        this.modifiedDate = touchPoints.modifiedDate;
    }

    @Override
    public boolean sameIdentityAs(Answer other) {
        return this.equals(other);
    }

}
