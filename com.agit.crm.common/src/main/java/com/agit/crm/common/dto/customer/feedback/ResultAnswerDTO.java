/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.agit.crm.common.dto.customer.feedback;

import com.agit.crm.shared.type.TypeTouchpoints;
import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author BayuHS
 */
public class ResultAnswerDTO implements Serializable {

    private String ResultAnswerID;
    private String userID;
    private String answerID;
    private String nama;
    private String email;

    private String chooseAnswer;
    private TypeTouchpoints touchpoints;
    private String createdBy;
    private Date createdDate;
    private String modifiedBy;
    private Date modifiedDate;

    public ResultAnswerDTO() {
    }

    public ResultAnswerDTO(String ResultAnswerID, String userID, String answerID, String nama, String email, String chooseAnswer, TypeTouchpoints touchpoints, String createdBy, Date createdDate, String modifiedBy, Date modifiedDate) {
        this.ResultAnswerID = ResultAnswerID;
        this.userID = userID;
        this.answerID = answerID;
        this.nama = nama;
        this.email = email;
        this.chooseAnswer = chooseAnswer;
        this.touchpoints = touchpoints;
        this.createdBy = createdBy;
        this.createdDate = createdDate;
        this.modifiedBy = modifiedBy;
        this.modifiedDate = modifiedDate;
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

    public String getResultAnswerID() {
        return ResultAnswerID;
    }

    public void setResultAnswerID(String ResultAnswerID) {
        this.ResultAnswerID = ResultAnswerID;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getAnswerID() {
        return answerID;
    }

    public void setAnswerID(String answerID) {
        this.answerID = answerID;
    }

    public String getChooseAnswer() {
        return chooseAnswer;
    }

    public void setChooseAnswer(String chooseAnswer) {
        this.chooseAnswer = chooseAnswer;
    }

    public TypeTouchpoints getTouchpoints() {
        return touchpoints;
    }

    public void setTouchpoints(TypeTouchpoints touchpoints) {
        this.touchpoints = touchpoints;
    }

    @Override
    public String toString() {
        return "ResultAnswerDTO{" + "ResultAnswerID=" + ResultAnswerID + ", userID=" + userID + ", answerID=" + answerID + ", nama=" + nama + ", email=" + email + ", chooseAnswer=" + chooseAnswer + ", touchpoints=" + touchpoints + ", createdBy=" + createdBy + ", createdDate=" + createdDate + ", modifiedBy=" + modifiedBy + ", modifiedDate=" + modifiedDate + '}';
    }

}
