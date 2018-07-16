package com.agit.crm.domain.customer.feedback;

import java.util.List;

/**
 *
 * @author 3AD
 */
public interface ResultAnswerRepository {

    void saveOrUpdate(ResultAnswer resultAnswer);

    void deleteData(ResultAnswer resultAnswer);

    ResultAnswer findByID(String ResultAnswerID);

    List<ResultAnswer> findAll();

}
