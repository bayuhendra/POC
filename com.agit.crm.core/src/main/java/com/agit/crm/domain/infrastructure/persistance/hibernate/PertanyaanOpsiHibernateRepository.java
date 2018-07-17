package com.agit.crm.domain.infrastructure.persistance.hibernate;

import com.agit.crm.domain.customer.kuesioner.PertanyaanOpsi;
import com.agit.crm.domain.customer.kuesioner.PertanyaanOpsiRepository;
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
public class PertanyaanOpsiHibernateRepository extends HibernateRepository implements PertanyaanOpsiRepository {

    @Override
    public void saveOrUpdate(PertanyaanOpsi pertanyaanOpsi) {
        getSession().saveOrUpdate(pertanyaanOpsi);
    }

    @Override
    public void deleteData(PertanyaanOpsi pertanyaanOpsi) {
        Query query = getSession().createQuery("delete from com.agit.crm.domain.customer.kuesioner.PertanyaanOpsi where pertanyaanOpsiID = :cid");
        query.setParameter("cid", pertanyaanOpsi.getPertanyaanOpsiID());
        query.executeUpdate();
    }

    @Override
    public PertanyaanOpsi findByID(String pertanyaanOpsiID) {
        return (PertanyaanOpsi) getSession()
                .createQuery("from com.agit.crm.domain.customer.kuesioner.PertanyaanOpsi where pertanyaanOpsiID = :cid")
                .setParameter("cid", pertanyaanOpsiID)
                .uniqueResult();
    }

    @Override
    public List<PertanyaanOpsi> findAll() {
        return (List<PertanyaanOpsi>) getSession()
                .createQuery("from com.agit.crm.domain.customer.kuesioner.PertanyaanOpsi ")
                .list();
    }

    @Override
    public List<PertanyaanOpsi> findByParams(Map map) {
        Criteria criteria = getSession().createCriteria(PertanyaanOpsi.class);

        if (StringUtil.hasValue(map.get("pertanyaanOpsiID"))) {
            criteria.add(Restrictions.eq("pertanyaanOpsiID", map.get("pertanyaanOpsiID")));
        }
        if (StringUtil.hasValue(map.get("opsi"))) {
            criteria.add(Restrictions.eq("opsi", map.get("opsi")));
        }
        if (StringUtil.hasValue(map.get("pertanyaanID"))) {
            criteria.add(Restrictions.eq("pertanyaanID", map.get("pertanyaanID")));
        }
        return criteria.list();
    }

    @Override
    public List<PertanyaanOpsi> findOpsiByPertanyaan(String pertanyaanID) {
        Criteria criteria = getSession().createCriteria(PertanyaanOpsi.class);
        criteria.add(Restrictions.eq("pertanyaanID", pertanyaanID));
        return (List<PertanyaanOpsi>) criteria.list();
    }

}
