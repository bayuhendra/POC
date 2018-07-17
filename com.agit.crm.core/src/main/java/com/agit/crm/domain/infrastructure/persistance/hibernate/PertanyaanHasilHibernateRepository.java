package com.agit.crm.domain.infrastructure.persistance.hibernate;

import com.agit.crm.domain.customer.kuesioner.PertanyaanHasil;
import com.agit.crm.domain.customer.kuesioner.PertanyaanHasilRepository;
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
public class PertanyaanHasilHibernateRepository extends HibernateRepository implements PertanyaanHasilRepository {

    @Override
    public void saveOrUpdate(PertanyaanHasil pertanyaanHasil) {
        getSession().saveOrUpdate(pertanyaanHasil);
    }

    @Override
    public void deleteData(PertanyaanHasil pertanyaanHasil) {
        Query query = getSession().createQuery("delete from com.agit.crm.domain.customer.kuesioner.PertanyaanHasil where pertanyaanHasilID = :cid");
        query.setParameter("cid", pertanyaanHasil.getPertanyaanHasilID());
        query.executeUpdate();
    }

    @Override
    public PertanyaanHasil findByID(String pertanyaanHasilID) {
        return (PertanyaanHasil) getSession()
                .createQuery("from com.agit.crm.domain.customer.kuesioner.PertanyaanHasil where pertanyaanHasilID = :cid")
                .setParameter("cid", pertanyaanHasilID)
                .uniqueResult();
    }

    @Override
    public List<PertanyaanHasil> findAll() {
        return (List<PertanyaanHasil>) getSession()
                .createQuery("from com.agit.crm.domain.customer.kuesioner.PertanyaanHasil ")
                .list();
    }

    @Override
    public List<PertanyaanHasil> findByParams(Map map) {
        Criteria criteria = getSession().createCriteria(PertanyaanHasil.class);

        if (StringUtil.hasValue(map.get("pertanyaanHasilID"))) {
            criteria.add(Restrictions.eq("pertanyaanHasilID", map.get("pertanyaanHasilID")));
        }
        if (StringUtil.hasValue(map.get("pertanyaanOpsiID"))) {
            criteria.add(Restrictions.eq("pertanyaanOpsiID", map.get("pertanyaanOpsiID")));
        }
        if (StringUtil.hasValue(map.get("pertanyaanID"))) {
            criteria.add(Restrictions.eq("pertanyaanID", map.get("pertanyaanID")));
        }
        if (StringUtil.hasValue(map.get("touchpointID"))) {
            criteria.add(Restrictions.eq("touchpointID", map.get("touchpointID")));
        }
        if (StringUtil.hasValue(map.get("email"))) {
            criteria.add(Restrictions.eq("email", map.get("email")));
        }
        return criteria.list();
    }

    @Override
    public List<PertanyaanHasil> findHasilByTouchpoint(String touchpointID) {
        Criteria criteria = getSession().createCriteria(PertanyaanHasil.class);
        criteria.add(Restrictions.eq("touchpointID", touchpointID));
        return (List<PertanyaanHasil>) criteria.list();
    }

}
