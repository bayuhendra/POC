package com.agit.crm.application.impl;

import com.agit.crm.common.application.PertanyaanHasilService;
import com.agit.crm.common.dto.customer.kuesioner.PertanyaanHasilDTO;
import com.agit.crm.domain.customer.kuesioner.PertanyaanHasil;
import com.agit.crm.domain.customer.kuesioner.PertanyaanHasilRepository;
import com.agit.crm.interfaces.web.facade.dto.assembler.crm.PertanyaanHasilDTOAssembler;
import java.util.List;
import java.util.Map;
import org.apache.commons.lang.Validate;

/**
 *
 * @author lintang
 */
public class PertanyaanHasilServiceImpl implements PertanyaanHasilService {

    private PertanyaanHasilRepository pertanyaanHasilRepository;
    private PertanyaanHasilDTOAssembler pertanyaanHasilDTOAssembler;

    public void setPertanyaanHasilRepository(PertanyaanHasilRepository pertanyaanHasilRepository) {
        this.pertanyaanHasilRepository = pertanyaanHasilRepository;
    }

    public void setPertanyaanHasilDTOAssembler(PertanyaanHasilDTOAssembler pertanyaanHasilDTOAssembler) {
        this.pertanyaanHasilDTOAssembler = pertanyaanHasilDTOAssembler;
    }

    @Override
    public void saveOrUpdate(PertanyaanHasilDTO pertanyaan) {
        PertanyaanHasil t = pertanyaanHasilRepository.findByID(pertanyaan.getPertanyaanHasilID());

        if (t == null) {
            t = pertanyaanHasilDTOAssembler.toDomain(pertanyaan);
        } else {
            PertanyaanHasil newPertanyaanHasil = pertanyaanHasilDTOAssembler.toDomain(pertanyaan);
            t.assignNewHasil(newPertanyaanHasil);

        }
        pertanyaanHasilRepository.saveOrUpdate(t);
    }

    @Override
    public void deleteData(PertanyaanHasilDTO pertanyaan) {
        PertanyaanHasil p = pertanyaanHasilDTOAssembler.toDomain(pertanyaan);
        pertanyaanHasilRepository.deleteData(p);
    }

    @Override
    public PertanyaanHasilDTO findByID(String pertanyaanID) {
        Validate.notNull(pertanyaanHasilRepository);
        PertanyaanHasil b = (PertanyaanHasil) pertanyaanHasilRepository.findByID(pertanyaanID);
        if (b != null) {
            return pertanyaanHasilDTOAssembler.toDTO(b);
        }
        return null;
    }

    @Override
    public List<PertanyaanHasilDTO> findAll() {
        Validate.notNull(pertanyaanHasilRepository);
        return pertanyaanHasilDTOAssembler.toDTOs(pertanyaanHasilRepository.findAll());
    }

    @Override
    public List<PertanyaanHasilDTO> findByParams(Map map) {
        Validate.notNull(pertanyaanHasilRepository);
        List<PertanyaanHasil> pertanyaans = pertanyaanHasilRepository.findByParams(map);
        if (pertanyaans != null) {
            return (List<PertanyaanHasilDTO>) pertanyaanHasilDTOAssembler.toDTOs(pertanyaans);
        }
        return null;
    }

    @Override
    public List<PertanyaanHasilDTO> findHasilByTouchpoint(String pertanyaanID) {
        Validate.notNull(pertanyaanHasilRepository);
        List<PertanyaanHasil> pertanyaans = pertanyaanHasilRepository.findHasilByTouchpoint(pertanyaanID);
        if (pertanyaans != null) {
            return (List<PertanyaanHasilDTO>) pertanyaanHasilDTOAssembler.toDTOs(pertanyaans);
        }
        return null;
    }

}
