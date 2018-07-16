/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.agit.crm.common.dto.customer.feedback;

import com.agit.crm.shared.type.TypeTouchpoints;
import java.io.Serializable;

/**
 *
 * @author BayuHS
 */
public class ResultAnswerDTO implements Serializable {

    private String ResultAnswerID;
    private String userID;
    private String answerID;

    private String chooseAnswer;
    private TypeTouchpoints touchpoints;

    public ResultAnswerDTO() {
    }

    public ResultAnswerDTO(String ResultAnswerID, String userID, String answerID, String chooseAnswer, TypeTouchpoints touchpoints) {
        this.ResultAnswerID = ResultAnswerID;
        this.userID = userID;
        this.answerID = answerID;
        this.chooseAnswer = chooseAnswer;
        this.touchpoints = touchpoints;
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
        return "ResultAnswerDTO{" + "ResultAnswerID=" + ResultAnswerID + ", userID=" + userID + ", answerID=" + answerID + ", chooseAnswer=" + chooseAnswer + ", touchpoints=" + touchpoints + '}';
    }

}
