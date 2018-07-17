package com.agit.crm.common.application;

import com.agit.crm.common.dto.customer.kuesioner.PertanyaanOpsiDTO;
import java.util.List;
import java.util.Map;

/**
 *
 * @author lintang
 */
public interface PertanyaanOpsiService {

    void saveOrUpdate(PertanyaanOpsiDTO pertanyaanOpsi);

    void deleteData(PertanyaanOpsiDTO pertanyaanOpsi);

    PertanyaanOpsiDTO findByID(String pertanyaanOpsiID);

    List<PertanyaanOpsiDTO> findAll();

    List<PertanyaanOpsiDTO> findByParams(Map map);

    List<PertanyaanOpsiDTO> findOpsiByPertanyaan(String pertanyaanID);

}
