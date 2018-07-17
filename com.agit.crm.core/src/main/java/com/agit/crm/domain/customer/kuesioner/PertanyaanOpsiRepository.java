package com.agit.crm.domain.customer.kuesioner;

import java.util.List;
import java.util.Map;

/**
 *
 * @author lintang
 */
public interface PertanyaanOpsiRepository {

    void saveOrUpdate(PertanyaanOpsi pertanyaanOpsi);

    void deleteData(PertanyaanOpsi pertanyaanOpsi);

    PertanyaanOpsi findByID(String pertanyaanOpsiID);

    List<PertanyaanOpsi> findAll();

    List<PertanyaanOpsi> findByParams(Map map);

    List<PertanyaanOpsi> findOpsiByPertanyaan(String pertanyaanID);

}
