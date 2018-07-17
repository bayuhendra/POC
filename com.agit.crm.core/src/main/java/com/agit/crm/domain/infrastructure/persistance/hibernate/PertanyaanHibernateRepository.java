package com.agit.crm.domain.infrastructure.persistance.hibernate;

import com.agit.crm.domain.customer.kuesioner.Pertanyaan;
import com.agit.crm.domain.customer.kuesioner.PertanyaanRepository;
import com.agit.crm.util.StringUtil;
import java.util.List;
import java.util.Map;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author lintang
 */
@Repository
@Transactional
public class PertanyaanHibernateRepository extends HibernateRepository implements PertanyaanRepository {

    @Override
    public void saveOrUpdate(Pertanyaan pertanyaan) {
        getSession().saveOrUpdate(pertanyaan);
    }

    @Override
    public void deleteData(Pertanyaan pertanyaan) {
        Query query = getSession().createQuery("delete from com.agit.crm.domain.customer.kuesioner.Pertanyaan where pertanyaanID = :cid");
        query.setParameter("cid", pertanyaan.getPertanyaanID());
        query.executeUpdate();
    }

    @Override
    public Pertanyaan findByID(String pertanyaanID) {
        return (Pertanyaan) getSession()
                .createQuery("from com.agit.crm.domain.customer.kuesioner.Pertanyaan where pertanyaanID = :cid")
                .setParameter("cid", pertanyaanID)
                .uniqueResult();
    }

    @Override
    public List<Pertanyaan> findAll() {
        return (List<Pertanyaan>) getSession()
                .createQuery("from com.agit.crm.domain.customer.kuesioner.Pertanyaan ")
                .list();
    }

    @Override
    public List<Pertanyaan> findByParams(Map map) {
        Criteria criteria = getSession().createCriteria(Pertanyaan.class);

        if (StringUtil.hasValue(map.get("pertanyaanID"))) {
            criteria.add(Restrictions.eq("pertanyaanID", map.get("pertanyaanID")));
        }
        if (StringUtil.hasValue(map.get("pertanyaan"))) {
            criteria.add(Restrictions.eq("pertanyaan", map.get("pertanyaan")));
        }
        if (StringUtil.hasValue(map.get("touchpoint"))) {
            criteria.add(Restrictions.eq("touchpoint", map.get("touchpoint")));
        }
        if (StringUtil.hasValue(map.get("status"))) {
            criteria.add(Restrictions.eq("status", map.get("status")));
        }
        return criteria.list();
    }

    @Override
    public List<Pertanyaan> findPertanyaanByTouchPoints(String touchpointID) {
        Criteria criteria = getSession().createCriteria(Pertanyaan.class);
        criteria.add(Restrictions.eq("touchpoints", touchpointID));
        return (List<Pertanyaan>) criteria.list();
    }

}
