package com.agit.crm.interfaces.web.facade.dto.assembler.crm;

import com.agit.crm.common.dto.customer.kuesioner.PertanyaanOpsiDTO;
import com.agit.crm.common.dto.customer.kuesioner.PertanyaanOpsiDTOBuilder;
import com.agit.crm.domain.customer.kuesioner.PertanyaanOpsi;
import com.agit.crm.domain.customer.kuesioner.PertanyaanOpsiBuilder;
import com.agit.crm.shared.object.IObjectAssembler;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author lintang
 */
public class PertanyaanOpsiDTOAssembler implements IObjectAssembler<PertanyaanOpsi, PertanyaanOpsiDTO> {

    @Override
    public PertanyaanOpsiDTO toDTO(PertanyaanOpsi domainObject) {
        return new PertanyaanOpsiDTOBuilder()
                .setPertanyaanOpsiID(domainObject.getPertanyaanOpsiID())
                .setPertanyaanID(domainObject.getPertanyaanID())
                .setOpsi(domainObject.getOpsi())
                .setValue(domainObject.getValue())
                .setCreatedBy(domainObject.getCreatedBy())
                .setCreatedDate(domainObject.getCreatedDate())
                .setModifiedBy(domainObject.getModifiedBy())
                .setModifiedDate(domainObject.getModifiedDate())
                .createPertanyaanOpsiDTO();
    }

    @Override
    public PertanyaanOpsi toDomain(PertanyaanOpsiDTO dtoObject) {
        return new PertanyaanOpsiBuilder()
                .setPertanyaanOpsiID(dtoObject.getPertanyaanOpsiID())
                .setPertanyaanID(dtoObject.getPertanyaanID())
                .setOpsi(dtoObject.getOpsi())
                .setValue(dtoObject.getValue())
                .setCreatedBy(dtoObject.getCreatedBy())
                .setCreatedDate(dtoObject.getCreatedDate())
                .setModifiedBy(dtoObject.getModifiedBy())
                .setModifiedDate(dtoObject.getModifiedDate())
                .createPertanyaanOpsi();
    }

    public List<PertanyaanOpsi> toDomains(List<PertanyaanOpsiDTO> arg0) {
        List<PertanyaanOpsi> res = new ArrayList<>();
        for (PertanyaanOpsiDTO t : arg0) {
            res.add(new PertanyaanOpsiDTOAssembler().toDomain(t));
        }
        return res;
    }

    public List<PertanyaanOpsiDTO> toDTOs(List<PertanyaanOpsi> arg0) {
        List<PertanyaanOpsiDTO> res = new ArrayList<>();
        for (PertanyaanOpsi t : arg0) {
            res.add(this.toDTO(t));
        }
        return res;

    }

}
