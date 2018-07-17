package com.agit.crm.domain.infrastructure.persistance.hibernate;

import com.agit.crm.domain.customer.touchpoint.Touchpoint;
import com.agit.crm.domain.customer.touchpoint.TouchpointRepository;
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
public class TouchpointHibernateRepository extends HibernateRepository implements TouchpointRepository {

    @Override
    public void saveOrUpdate(Touchpoint touchpoint) {
        getSession().saveOrUpdate(touchpoint);
    }

    @Override
    public void deleteData(Touchpoint touchpoint) {
        Query query = getSession().createQuery("delete from com.agit.crm.domain.customer.touchpoint.Touchpoint where touchpointID = :cid");
        query.setParameter("cid", touchpoint.getTouchpointID());
        query.executeUpdate();
    }

    @Override
    public Touchpoint findByID(String touchpointID) {
        return (Touchpoint) getSession()
                .createQuery("from com.agit.crm.domain.customer.touchpoint.Touchpoint where touchpointID = :cid")
                .setParameter("cid", touchpointID)
                .uniqueResult();
    }

    @Override
    public List<Touchpoint> findAll() {
        return (List<Touchpoint>) getSession()
                .createQuery("from com.agit.crm.domain.customer.touchpoint.Touchpoint ")
                .list();
    }

    @Override
    public List<Touchpoint> findByParams(Map map) {
        Criteria criteria = getSession().createCriteria(Touchpoint.class);

        if (StringUtil.hasValue(map.get("touchpointID"))) {
            criteria.add(Restrictions.eq("touchpointID", map.get("touchpointID")));
        }
        if (StringUtil.hasValue(map.get("touchpoint"))) {
            criteria.add(Restrictions.eq("touchpoint", map.get("touchpoint")));
        }
        return criteria.list();
    }

}
