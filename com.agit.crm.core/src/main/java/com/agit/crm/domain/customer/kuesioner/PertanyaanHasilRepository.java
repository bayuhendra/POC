package com.agit.crm.domain.customer.kuesioner;

import java.util.List;
import java.util.Map;

/**
 *
 * @author lintang
 */
public interface PertanyaanHasilRepository {

    void saveOrUpdate(PertanyaanHasil pertanyaanHasil);

    void deleteData(PertanyaanHasil pertanyaanHasil);

    PertanyaanHasil findByID(String pertanyaanHasilID);

    List<PertanyaanHasil> findAll();

    List<PertanyaanHasil> findByParams(Map map);

    List<PertanyaanHasil> findHasilByTouchpoint(String touchpointID);

}
