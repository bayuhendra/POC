package com.agit.crm.application.impl;

import com.agit.crm.common.application.PertanyaanOpsiService;
import com.agit.crm.common.dto.customer.kuesioner.PertanyaanOpsiDTO;
import com.agit.crm.domain.customer.kuesioner.PertanyaanOpsi;
import com.agit.crm.domain.customer.kuesioner.PertanyaanOpsiRepository;
import com.agit.crm.interfaces.web.facade.dto.assembler.crm.PertanyaanOpsiDTOAssembler;
import java.util.List;
import java.util.Map;
import org.apache.commons.lang.Validate;

/**
 *
 * @author lintang
 */
public class PertanyaanOpsiServiceImpl implements PertanyaanOpsiService {

    private PertanyaanOpsiRepository pertanyaanOpsiRepository;
    private PertanyaanOpsiDTOAssembler pertanyaanOpsiDTOAssembler;

    public void setPertanyaanOpsiRepository(PertanyaanOpsiRepository pertanyaanOpsiRepository) {
        this.pertanyaanOpsiRepository = pertanyaanOpsiRepository;
    }

    public void setPertanyaanOpsiDTOAssembler(PertanyaanOpsiDTOAssembler pertanyaanOpsiDTOAssembler) {
        this.pertanyaanOpsiDTOAssembler = pertanyaanOpsiDTOAssembler;
    }

    @Override
    public void saveOrUpdate(PertanyaanOpsiDTO pertanyaan) {
        PertanyaanOpsi t = pertanyaanOpsiRepository.findByID(pertanyaan.getPertanyaanOpsiID());

        if (t == null) {
            t = pertanyaanOpsiDTOAssembler.toDomain(pertanyaan);
        } else {
            PertanyaanOpsi newPertanyaanOpsi = pertanyaanOpsiDTOAssembler.toDomain(pertanyaan);
            t.assignNewOpsi(newPertanyaanOpsi);

        }
        pertanyaanOpsiRepository.saveOrUpdate(t);
    }

    @Override
    public void deleteData(PertanyaanOpsiDTO pertanyaan) {
        PertanyaanOpsi p = pertanyaanOpsiDTOAssembler.toDomain(pertanyaan);
        pertanyaanOpsiRepository.deleteData(p);
    }

    @Override
    public PertanyaanOpsiDTO findByID(String pertanyaanID) {
        Validate.notNull(pertanyaanOpsiRepository);
        PertanyaanOpsi b = (PertanyaanOpsi) pertanyaanOpsiRepository.findByID(pertanyaanID);
        if (b != null) {
            return pertanyaanOpsiDTOAssembler.toDTO(b);
        }
        return null;
    }

    @Override
    public List<PertanyaanOpsiDTO> findAll() {
        Validate.notNull(pertanyaanOpsiRepository);
        return pertanyaanOpsiDTOAssembler.toDTOs(pertanyaanOpsiRepository.findAll());
    }

    @Override
    public List<PertanyaanOpsiDTO> findByParams(Map map) {
        Validate.notNull(pertanyaanOpsiRepository);
        List<PertanyaanOpsi> pertanyaans = pertanyaanOpsiRepository.findByParams(map);
        if (pertanyaans != null) {
            return (List<PertanyaanOpsiDTO>) pertanyaanOpsiDTOAssembler.toDTOs(pertanyaans);
        }
        return null;
    }

    @Override
    public List<PertanyaanOpsiDTO> findOpsiByPertanyaan(String pertanyaanID) {
        Validate.notNull(pertanyaanOpsiRepository);
        List<PertanyaanOpsi> pertanyaans = pertanyaanOpsiRepository.findOpsiByPertanyaan(pertanyaanID);
        if (pertanyaans != null) {
            return (List<PertanyaanOpsiDTO>) pertanyaanOpsiDTOAssembler.toDTOs(pertanyaans);
        }
        return null;
    }

}
