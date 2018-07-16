/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.agit.crm.domain.infrastructure.persistance.hibernate;

import com.agit.crm.domain.customer.feedback.Answer;
import com.agit.crm.domain.customer.feedback.ResultAnswer;
import com.agit.crm.domain.customer.feedback.ResultAnswerRepository;
import java.util.List;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author BayuHS
 */
@Repository
@Transactional
public class ResultAnswerHibernateRepository extends HibernateRepository implements ResultAnswerRepository {

    @Override
    public void saveOrUpdate(ResultAnswer resultAnswer) {
        getSession().saveOrUpdate(resultAnswer);
    }

    @Override
    public void deleteData(ResultAnswer resultAnswer) {
        Query query = getSession().createQuery("delete from com.agit.crm.domain.customer.feedback.ResultAnswer where ResultAnswerID = :cid");
        query.setParameter("cid", null);
        query.executeUpdate();
    }

    @Override
    public ResultAnswer findByID(String ResultAnswerID) {
        return (ResultAnswer) getSession()
                .createQuery("from com.agit.crm.domain.customer.feedback.ResultAnswer where ResultAnswerID = :cid")
                .setParameter("cid", ResultAnswerID)
                .uniqueResult();
    }

    @Override
    public List<ResultAnswer> findAll() {
        return (List<ResultAnswer>) getSession()
                .createQuery("from com.agit.crm.domain.customer.feedback.ResultAnswer ")
                .list();
    }

}
