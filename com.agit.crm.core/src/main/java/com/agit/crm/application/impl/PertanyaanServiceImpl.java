package com.agit.crm.application.impl;

import com.agit.crm.common.application.PertanyaanService;
import com.agit.crm.common.dto.customer.kuesioner.PertanyaanDTO;
import com.agit.crm.domain.customer.kuesioner.Pertanyaan;
import com.agit.crm.domain.customer.kuesioner.PertanyaanRepository;
import com.agit.crm.interfaces.web.facade.dto.assembler.crm.PertanyaanDTOAssembler;
import java.util.List;
import java.util.Map;
import org.apache.commons.lang.Validate;

/**
 *
 * @author lintang
 */
public class PertanyaanServiceImpl implements PertanyaanService {

    private PertanyaanRepository pertanyaanRepository;
    private PertanyaanDTOAssembler pertanyaanDTOAssembler;

    public void setPertanyaanRepository(PertanyaanRepository pertanyaanRepository) {
        this.pertanyaanRepository = pertanyaanRepository;
    }

    public void setPertanyaanDTOAssembler(PertanyaanDTOAssembler pertanyaanDTOAssembler) {
        this.pertanyaanDTOAssembler = pertanyaanDTOAssembler;
    }

    @Override
    public void saveOrUpdate(PertanyaanDTO pertanyaan) {
        Pertanyaan t = pertanyaanRepository.findByID(pertanyaan.getPertanyaanID());

        if (t == null) {
            t = pertanyaanDTOAssembler.toDomain(pertanyaan);
        } else {
            Pertanyaan newPertanyaan = pertanyaanDTOAssembler.toDomain(pertanyaan);
            t.assignNewPertanyaan(newPertanyaan);

        }
        pertanyaanRepository.saveOrUpdate(t);
    }

    @Override
    public void deleteData(PertanyaanDTO pertanyaan) {
        Pertanyaan p = pertanyaanDTOAssembler.toDomain(pertanyaan);
        pertanyaanRepository.deleteData(p);
    }

    @Override
    public PertanyaanDTO findByID(String pertanyaanID) {
        Validate.notNull(pertanyaanRepository);
        Pertanyaan b = (Pertanyaan) pertanyaanRepository.findByID(pertanyaanID);
        if (b != null) {
            return pertanyaanDTOAssembler.toDTO(b);
        }
        return null;
    }

    @Override
    public List<PertanyaanDTO> findAll() {
        Validate.notNull(pertanyaanRepository);
        return pertanyaanDTOAssembler.toDTOs(pertanyaanRepository.findAll());
    }

    @Override
    public List<PertanyaanDTO> findByParams(Map map) {
        Validate.notNull(pertanyaanRepository);
        List<Pertanyaan> pertanyaans = pertanyaanRepository.findByParams(map);
        if (pertanyaans != null) {
            return (List<PertanyaanDTO>) pertanyaanDTOAssembler.toDTOs(pertanyaans);
        }
        return null;
    }

    @Override
    public List<PertanyaanDTO> findPertanyaanByTouchPoints(String touchpointID) {
        Validate.notNull(pertanyaanRepository);
        List<Pertanyaan> pertanyaans = pertanyaanRepository.findPertanyaanByTouchPoints(touchpointID);
        if (pertanyaans != null) {
            return (List<PertanyaanDTO>) pertanyaanDTOAssembler.toDTOs(pertanyaans);
        }
        return null;
    }

}
