package com.agit.crm.common.application;

import com.agit.crm.common.dto.customer.kuesioner.PertanyaanDTO;
import java.util.List;
import java.util.Map;

/**
 *
 * @author lintang
 */
public interface PertanyaanService {

    void saveOrUpdate(PertanyaanDTO pertanyaan);

    void deleteData(PertanyaanDTO pertanyaan);

    PertanyaanDTO findByID(String pertanyaanID);

    List<PertanyaanDTO> findAll();

    List<PertanyaanDTO> findByParams(Map map);

    List<PertanyaanDTO> findPertanyaanByTouchPoints(String touchpointID);

}
