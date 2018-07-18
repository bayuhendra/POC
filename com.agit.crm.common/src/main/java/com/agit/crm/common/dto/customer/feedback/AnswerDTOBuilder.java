/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.agit.crm.common.dto.customer.feedback;

import com.agit.crm.shared.type.TypeTouchpoints;
import java.util.Date;


public class AnswerDTOBuilder {

    private String answerID;
    private String chooseQuestion;
    private String idChooseAnswer1;
    private String idChooseAnswer2;
    private String idChooseAnswer3;
    private String idChooseAnswer4;
    private String idChooseAnswer5;
    private String chooseAnswer1;
    private String chooseAnswer2;
    private String chooseAnswer3;
    private String chooseAnswer4;
    private String chooseAnswer5;
    private String feedback;
    private TypeTouchpoints touchpoints;
    private String createdBy;
    private Date createdDate;
    private String modifiedBy;
    private Date modifiedDate;

    public AnswerDTOBuilder() {
    }

    public AnswerDTOBuilder setAnswerID(String answerID) {
        this.answerID = answerID;
        return this;
    }

    public AnswerDTOBuilder setChooseQuestion(String chooseQuestion) {
        this.chooseQuestion = chooseQuestion;
        return this;
    }

    public AnswerDTOBuilder setIdChooseAnswer1(String idChooseAnswer1) {
        this.idChooseAnswer1 = idChooseAnswer1;
        return this;
    }

    public AnswerDTOBuilder setIdChooseAnswer2(String idChooseAnswer2) {
        this.idChooseAnswer2 = idChooseAnswer2;
        return this;
    }

    public AnswerDTOBuilder setIdChooseAnswer3(String idChooseAnswer3) {
        this.idChooseAnswer3 = idChooseAnswer3;
        return this;
    }

    public AnswerDTOBuilder setIdChooseAnswer4(String idChooseAnswer4) {
        this.idChooseAnswer4 = idChooseAnswer4;
        return this;
    }

    public AnswerDTOBuilder setIdChooseAnswer5(String idChooseAnswer5) {
        this.idChooseAnswer5 = idChooseAnswer5;
        return this;
    }

    public AnswerDTOBuilder setChooseAnswer1(String chooseAnswer1) {
        this.chooseAnswer1 = chooseAnswer1;
        return this;
    }

    public AnswerDTOBuilder setChooseAnswer2(String chooseAnswer2) {
        this.chooseAnswer2 = chooseAnswer2;
        return this;
    }

    public AnswerDTOBuilder setChooseAnswer3(String chooseAnswer3) {
        this.chooseAnswer3 = chooseAnswer3;
        return this;
    }

    public AnswerDTOBuilder setChooseAnswer4(String chooseAnswer4) {
        this.chooseAnswer4 = chooseAnswer4;
        return this;
    }

    public AnswerDTOBuilder setChooseAnswer5(String chooseAnswer5) {
        this.chooseAnswer5 = chooseAnswer5;
        return this;
    }

    public AnswerDTOBuilder setFeedback(String feedback) {
        this.feedback = feedback;
        return this;
    }

    public AnswerDTOBuilder setTouchpoints(TypeTouchpoints touchpoints) {
        this.touchpoints = touchpoints;
        return this;
    }

    public AnswerDTOBuilder setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
        return this;
    }

    public AnswerDTOBuilder setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
        return this;
    }

    public AnswerDTOBuilder setModifiedBy(String modifiedBy) {
        this.modifiedBy = modifiedBy;
        return this;
    }

    public AnswerDTOBuilder setModifiedDate(Date modifiedDate) {
        this.modifiedDate = modifiedDate;
        return this;
    }

    public AnswerDTO createAnswerDTO() {
        return new AnswerDTO(answerID, chooseQuestion, idChooseAnswer1, idChooseAnswer2, idChooseAnswer3, idChooseAnswer4, idChooseAnswer5, chooseAnswer1, chooseAnswer2, chooseAnswer3, chooseAnswer4, chooseAnswer5, feedback, touchpoints, createdBy, createdDate, modifiedBy, modifiedDate);
    }
    
}
