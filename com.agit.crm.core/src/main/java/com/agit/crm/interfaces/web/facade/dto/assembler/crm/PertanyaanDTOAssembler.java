package com.agit.crm.interfaces.web.facade.dto.assembler.crm;

import com.agit.crm.common.dto.customer.kuesioner.PertanyaanDTO;
import com.agit.crm.common.dto.customer.kuesioner.PertanyaanDTOBuilder;
import com.agit.crm.domain.customer.kuesioner.Pertanyaan;
import com.agit.crm.domain.customer.kuesioner.PertanyaanBuilder;
import com.agit.crm.shared.object.IObjectAssembler;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author lintang
 */
public class PertanyaanDTOAssembler implements IObjectAssembler<Pertanyaan, PertanyaanDTO> {

    @Override
    public PertanyaanDTO toDTO(Pertanyaan domainObject) {
        return new PertanyaanDTOBuilder()
                .setPertanyaanID(domainObject.getPertanyaanID())
                .setPertanyaan(domainObject.getPertanyaan())
                .setTouchpoint(domainObject.getTouchpoint())
                .setStatus(domainObject.getStatus())
                .setCreatedBy(domainObject.getCreatedBy())
                .setCreatedDate(domainObject.getCreatedDate())
                .setModifiedBy(domainObject.getModifiedBy())
                .setModifiedDate(domainObject.getModifiedDate())
                .createPertanyaanDTO();
    }

    @Override
    public Pertanyaan toDomain(PertanyaanDTO dtoObject) {
        return new PertanyaanBuilder()
                .setPertanyaanID(dtoObject.getPertanyaanID())
                .setPertanyaan(dtoObject.getPertanyaan())
                .setTouchpoint(dtoObject.getTouchpoint())
                .setStatus(dtoObject.getStatus())
                .setCreatedBy(dtoObject.getCreatedBy())
                .setCreatedDate(dtoObject.getCreatedDate())
                .setModifiedBy(dtoObject.getModifiedBy())
                .setModifiedDate(dtoObject.getModifiedDate())
                .createPertanyaan();
    }

    public List<Pertanyaan> toDomains(List<PertanyaanDTO> arg0) {
        List<Pertanyaan> res = new ArrayList<>();
        for (PertanyaanDTO t : arg0) {
            res.add(new PertanyaanDTOAssembler().toDomain(t));
        }
        return res;
    }

    public List<PertanyaanDTO> toDTOs(List<Pertanyaan> arg0) {
        List<PertanyaanDTO> res = new ArrayList<>();
        for (Pertanyaan t : arg0) {
            res.add(this.toDTO(t));
        }
        return res;

    }

}
