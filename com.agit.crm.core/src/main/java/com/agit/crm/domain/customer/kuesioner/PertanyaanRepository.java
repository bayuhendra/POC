package com.agit.crm.domain.customer.kuesioner;

import java.util.List;
import java.util.Map;

/**
 *
 * @author lintang
 */
public interface PertanyaanRepository {

    void saveOrUpdate(Pertanyaan pertanyaan);

    void deleteData(Pertanyaan pertanyaan);

    Pertanyaan findByID(String pertanyaanID);

    List<Pertanyaan> findAll();

    List<Pertanyaan> findByParams(Map map);

    List<Pertanyaan> findPertanyaanByTouchPoints(String touchpointID);

}
