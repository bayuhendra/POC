/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.agit.crm.common.dto.customer.feedback;

import com.agit.crm.shared.type.TypeTouchpoints;
import java.util.Date;


public class ResultAnswerDTOBuilder {

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

    public ResultAnswerDTOBuilder() {
    }

    public ResultAnswerDTOBuilder setResultAnswerID(String ResultAnswerID) {
        this.ResultAnswerID = ResultAnswerID;
        return this;
    }

    public ResultAnswerDTOBuilder setUserID(String userID) {
        this.userID = userID;
        return this;
    }

    public ResultAnswerDTOBuilder setAnswerID(String answerID) {
        this.answerID = answerID;
        return this;
    }

    public ResultAnswerDTOBuilder setNama(String nama) {
        this.nama = nama;
        return this;
    }

    public ResultAnswerDTOBuilder setEmail(String email) {
        this.email = email;
        return this;
    }

    public ResultAnswerDTOBuilder setChooseAnswer(String chooseAnswer) {
        this.chooseAnswer = chooseAnswer;
        return this;
    }

    public ResultAnswerDTOBuilder setTouchpoints(TypeTouchpoints touchpoints) {
        this.touchpoints = touchpoints;
        return this;
    }

    public ResultAnswerDTOBuilder setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
        return this;
    }

    public ResultAnswerDTOBuilder setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
        return this;
    }

    public ResultAnswerDTOBuilder setModifiedBy(String modifiedBy) {
        this.modifiedBy = modifiedBy;
        return this;
    }

    public ResultAnswerDTOBuilder setModifiedDate(Date modifiedDate) {
        this.modifiedDate = modifiedDate;
        return this;
    }

    public ResultAnswerDTO createResultAnswerDTO() {
        return new ResultAnswerDTO(ResultAnswerID, userID, answerID, nama, email, chooseAnswer, touchpoints, createdBy, createdDate, modifiedBy, modifiedDate);
    }
    
}
