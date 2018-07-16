/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.agit.crm.common.dto.customer.feedback;

import com.agit.crm.shared.type.TypeTouchpoints;


public class ResultAnswerDTOBuilder {

    private String ResultAnswerID;
    private String userID;
    private String answerID;
    private String chooseAnswer;
    private TypeTouchpoints touchpoints;

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

    public ResultAnswerDTOBuilder setChooseAnswer(String chooseAnswer) {
        this.chooseAnswer = chooseAnswer;
        return this;
    }

    public ResultAnswerDTOBuilder setTouchpoints(TypeTouchpoints touchpoints) {
        this.touchpoints = touchpoints;
        return this;
    }

    public ResultAnswerDTO createResultAnswerDTO() {
        return new ResultAnswerDTO(ResultAnswerID, userID, answerID, chooseAnswer, touchpoints);
    }
    
}
