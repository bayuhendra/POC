package com.agit.crm.common.application;

import com.agit.crm.common.dto.customer.kuesioner.PertanyaanHasilDTO;
import java.util.List;
import java.util.Map;

/**
 *
 * @author lintang
 */
public interface PertanyaanHasilService {

    void saveOrUpdate(PertanyaanHasilDTO pertanyaanHasil);

    void deleteData(PertanyaanHasilDTO pertanyaanHasil);

    PertanyaanHasilDTO findByID(String pertanyaanHasilID);

    List<PertanyaanHasilDTO> findAll();

    List<PertanyaanHasilDTO> findByParams(Map map);

    List<PertanyaanHasilDTO> findHasilByTouchpoint(String touchpointID);

}
