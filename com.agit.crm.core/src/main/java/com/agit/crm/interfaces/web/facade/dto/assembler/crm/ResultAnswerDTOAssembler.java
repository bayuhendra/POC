/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.agit.crm.interfaces.web.facade.dto.assembler.crm;

import com.agit.crm.common.dto.customer.feedback.ResultAnswerDTO;
import com.agit.crm.common.dto.customer.feedback.ResultAnswerDTOBuilder;
import com.agit.crm.domain.customer.feedback.ResultAnswer;
import com.agit.crm.domain.customer.feedback.ResultAnswerBuilder;
import com.agit.crm.shared.object.IObjectAssembler;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author BayuHS
 */
public class ResultAnswerDTOAssembler implements IObjectAssembler<ResultAnswer, ResultAnswerDTO> {

    @Override
    public ResultAnswerDTO toDTO(ResultAnswer domainObject) {
        return new ResultAnswerDTOBuilder()
                .setAnswerID(domainObject.getAnswerID())
                .setResultAnswerID(domainObject.getResultAnswerID())
                .setUserID(domainObject.getUserID())
                .setTouchpoints(domainObject.getTouchpoints())
                .setChooseAnswer(domainObject.getChooseAnswer())
                .setNama(domainObject.getNama())
                .setEmail(domainObject.getEmail())
                .setCreatedBy(domainObject.getCreatedBy())
                .setCreatedDate(domainObject.getCreatedDate())
                .setModifiedBy(domainObject.getModifiedBy())
                .setModifiedDate(domainObject.getModifiedDate())
                .createResultAnswerDTO();
    }

    @Override
    public ResultAnswer toDomain(ResultAnswerDTO dtoObject) {
        return new ResultAnswerBuilder()
                .setAnswerID(dtoObject.getAnswerID())
                .setResultAnswerID(dtoObject.getResultAnswerID())
                .setUserID(dtoObject.getUserID())
                .setTouchpoints(dtoObject.getTouchpoints())
                .setChooseAnswer(dtoObject.getChooseAnswer())
                .setNama(dtoObject.getNama())
                .setEmail(dtoObject.getEmail())
                .setCreatedBy(dtoObject.getCreatedBy())
                .setCreatedDate(dtoObject.getCreatedDate())
                .setModifiedBy(dtoObject.getModifiedBy())
                .setModifiedDate(dtoObject.getModifiedDate())
                .createResultAnswer();
    }

    public List<ResultAnswer> toDomains(List<ResultAnswerDTO> arg0) {
        List<ResultAnswer> res = new ArrayList<>();
        for (ResultAnswerDTO t : arg0) {
            res.add(new ResultAnswerDTOAssembler().toDomain(t));
        }
        return res;
    }

    public List<ResultAnswerDTO> toDTOs(List<ResultAnswer> arg0) {
        List<ResultAnswerDTO> res = new ArrayList<>();
        for (ResultAnswer t : arg0) {
            res.add(this.toDTO(t));
        }
        return res;

    }

}
