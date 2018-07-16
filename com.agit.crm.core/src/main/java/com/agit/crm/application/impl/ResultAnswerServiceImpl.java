/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.agit.crm.application.impl;

import com.agit.crm.common.application.ResultAnswerService;
import com.agit.crm.common.dto.customer.feedback.ResultAnswerDTO;
import com.agit.crm.domain.customer.feedback.ResultAnswer;
import com.agit.crm.domain.customer.feedback.ResultAnswerRepository;
import com.agit.crm.interfaces.web.facade.dto.assembler.crm.ResultAnswerDTOAssembler;
import java.util.List;
import org.apache.commons.lang.Validate;

/**
 *
 * @author BayuHS
 */
public class ResultAnswerServiceImpl implements ResultAnswerService {

    private ResultAnswerRepository resultAnswerRepository;
    private ResultAnswerDTOAssembler resultAnswerDTOAssembler;

    public void setResultAnswerRepository(ResultAnswerRepository resultAnswerRepository) {
        this.resultAnswerRepository = resultAnswerRepository;
    }

    public void setResultAnswerDTOAssembler(ResultAnswerDTOAssembler resultAnswerDTOAssembler) {
        this.resultAnswerDTOAssembler = resultAnswerDTOAssembler;
    }

    @Override
    public void SaveOrUpdate(ResultAnswerDTO resultAnswer) {
        ResultAnswer t = resultAnswerRepository.findByID(resultAnswer.getResultAnswerID());

        if (t == null) {
            t = resultAnswerDTOAssembler.toDomain(resultAnswer);
        } else {
            ResultAnswer newAnswer = resultAnswerDTOAssembler.toDomain(resultAnswer);
            t.assignNewResultAnswer(newAnswer);

        }
        resultAnswerRepository.saveOrUpdate(t);
    }

    @Override
    public void deleteData(ResultAnswerDTO resultAnswer) {
        ResultAnswer p = resultAnswerDTOAssembler.toDomain(resultAnswer);
        resultAnswerRepository.deleteData(p);
    }

    @Override
    public ResultAnswerDTO findByID(String ResultAnswerID) {
        Validate.notNull(resultAnswerRepository);
        ResultAnswer b = (ResultAnswer) resultAnswerRepository.findByID(ResultAnswerID);
        if (b != null) {
            return resultAnswerDTOAssembler.toDTO(b);
        }
        return null;
    }

    @Override
    public List<ResultAnswerDTO> findAll() {
        Validate.notNull(resultAnswerRepository);
        return resultAnswerDTOAssembler.toDTOs(resultAnswerRepository.findAll());
    }

}
