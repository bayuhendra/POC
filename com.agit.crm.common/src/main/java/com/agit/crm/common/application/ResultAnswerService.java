/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.agit.crm.common.application;

import com.agit.crm.common.dto.customer.feedback.ResultAnswerDTO;
import java.util.List;

/**
 *
 * @author BayuHS
 */
public interface ResultAnswerService {

    void SaveOrUpdate(ResultAnswerDTO resultAnswer);

    void deleteData(ResultAnswerDTO resultAnswer);

    ResultAnswerDTO findByID(String ResultAnswerID);

    List<ResultAnswerDTO> findAll();

}
