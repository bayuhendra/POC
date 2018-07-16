/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.agit.crm.domain.customer.feedback;

import com.agit.crm.shared.object.EntityObject;
import com.agit.crm.shared.type.TypeTouchpoints;

/**
 *
 * @author BayuHS
 */
public class ResultAnswer implements EntityObject<ResultAnswer> {

    private long id;
    private String ResultAnswerID;
    private String userID;
    private String answerID;

    private String chooseAnswer;
    private TypeTouchpoints touchpoints;

    public ResultAnswer() {
    }

    public ResultAnswer(long id, String ResultAnswerID, String userID, String answerID, String chooseAnswer, TypeTouchpoints touchpoints) {
        this.id = id;
        this.ResultAnswerID = ResultAnswerID;
        this.userID = userID;
        this.answerID = answerID;
        this.chooseAnswer = chooseAnswer;
        this.touchpoints = touchpoints;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public void assignNewResultAnswer(ResultAnswer resultAnswer) {
        this.id = resultAnswer.id;
        this.ResultAnswerID = resultAnswer.ResultAnswerID;
        this.userID = resultAnswer.userID;
        this.answerID = resultAnswer.answerID;
        this.chooseAnswer = resultAnswer.chooseAnswer;
        this.touchpoints = resultAnswer.touchpoints;
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
        final ResultAnswer other = (ResultAnswer) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

    @Override
    public boolean sameIdentityAs(ResultAnswer other) {
        return this.equals(other);
    }

}
