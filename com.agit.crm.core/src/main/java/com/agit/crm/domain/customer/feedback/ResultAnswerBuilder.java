/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.agit.crm.domain.customer.feedback;

import com.agit.crm.shared.type.TypeTouchpoints;
import java.util.Date;


public class ResultAnswerBuilder {

    private long id;
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

    public ResultAnswerBuilder() {
    }

    public ResultAnswerBuilder setId(long id) {
        this.id = id;
        return this;
    }

    public ResultAnswerBuilder setResultAnswerID(String ResultAnswerID) {
        this.ResultAnswerID = ResultAnswerID;
        return this;
    }

    public ResultAnswerBuilder setUserID(String userID) {
        this.userID = userID;
        return this;
    }

    public ResultAnswerBuilder setAnswerID(String answerID) {
        this.answerID = answerID;
        return this;
    }

    public ResultAnswerBuilder setNama(String nama) {
        this.nama = nama;
        return this;
    }

    public ResultAnswerBuilder setEmail(String email) {
        this.email = email;
        return this;
    }

    public ResultAnswerBuilder setChooseAnswer(String chooseAnswer) {
        this.chooseAnswer = chooseAnswer;
        return this;
    }

    public ResultAnswerBuilder setTouchpoints(TypeTouchpoints touchpoints) {
        this.touchpoints = touchpoints;
        return this;
    }

    public ResultAnswerBuilder setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
        return this;
    }

    public ResultAnswerBuilder setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
        return this;
    }

    public ResultAnswerBuilder setModifiedBy(String modifiedBy) {
        this.modifiedBy = modifiedBy;
        return this;
    }

    public ResultAnswerBuilder setModifiedDate(Date modifiedDate) {
        this.modifiedDate = modifiedDate;
        return this;
    }

    public ResultAnswer createResultAnswer() {
        return new ResultAnswer(id, ResultAnswerID, userID, answerID, nama, email, chooseAnswer, touchpoints, createdBy, createdDate, modifiedBy, modifiedDate);
    }
    
}
