package com.agit.crm.masterdata.domain;

import com.agit.crm.shared.object.EntityObject;
import java.util.Date;
import java.util.Objects;

/**
 *
 * @author TriAA
 */
public class SetupEmail implements EntityObject<SetupEmail> {

    long id;
    private String idEmail;
    private String templateTitle;
    private String parameter;
    private String subject;
    private String content;
    private String createBy;
    private String createdBy;
    private Date createdDate;
    private String modifiedBy;
    private Date modifiedDate;

    public SetupEmail() {
    }

    public SetupEmail(String idEmail, String templateTitle, String parameter, String subject, String content, String createBy, String createdBy, Date createdDate, String modifiedBy, Date modifiedDate) {
        this.idEmail = idEmail;
        this.templateTitle = templateTitle;
        this.parameter = parameter;
        this.subject = subject;
        this.content = content;
        this.createBy = createBy;
        this.createdBy = createdBy;
        this.createdDate = createdDate;
        this.modifiedBy = modifiedBy;
        this.modifiedDate = modifiedDate;
    }

    public void assignNewSetupEmail(SetupEmail setupEmail) {
        this.idEmail = setupEmail.idEmail;
        this.templateTitle = setupEmail.templateTitle;
        this.parameter = setupEmail.parameter;
        this.subject = setupEmail.subject;
        this.content = setupEmail.content;
        this.createBy = setupEmail.createBy;
        this.createdBy = setupEmail.createdBy;
        this.createdDate = setupEmail.createdDate;
        this.modifiedBy = setupEmail.modifiedBy;
        this.modifiedDate = setupEmail.modifiedDate;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getIdEmail() {
        return idEmail;
    }

    public void setIdEmail(String idEmail) {
        this.idEmail = idEmail;
    }

    public String getTemplateTitle() {
        return templateTitle;
    }

    public void setTemplateTitle(String templateTitle) {
        this.templateTitle = templateTitle;
    }

    public String getParameter() {
        return parameter;
    }

    public void setParameter(String parameter) {
        this.parameter = parameter;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
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
        int hash = 3;
        hash = 31 * hash + Objects.hashCode(this.idEmail);
        hash = 31 * hash + Objects.hashCode(this.templateTitle);
        hash = 31 * hash + Objects.hashCode(this.parameter);
        hash = 31 * hash + Objects.hashCode(this.subject);
        hash = 31 * hash + Objects.hashCode(this.content);
        hash = 31 * hash + Objects.hashCode(this.createBy);
        hash = 31 * hash + Objects.hashCode(this.createdBy);
        hash = 31 * hash + Objects.hashCode(this.createdDate);
        hash = 31 * hash + Objects.hashCode(this.modifiedBy);
        hash = 31 * hash + Objects.hashCode(this.modifiedDate);
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
        final SetupEmail other = (SetupEmail) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

    @Override
    public boolean sameIdentityAs(SetupEmail other) {
        return this.equals(other);
    }

}
