package com.agit.crm.interfaces.web.facade.dto.assembler.crm;

import com.agit.crm.common.dto.customer.kuesioner.PertanyaanHasilDTO;
import com.agit.crm.common.dto.customer.kuesioner.PertanyaanHasilDTOBuilder;
import com.agit.crm.domain.customer.kuesioner.PertanyaanHasil;
import com.agit.crm.domain.customer.kuesioner.PertanyaanHasilBuilder;
import com.agit.crm.shared.object.IObjectAssembler;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author lintang
 */
public class PertanyaanHasilDTOAssembler implements IObjectAssembler<PertanyaanHasil, PertanyaanHasilDTO> {

    @Override
    public PertanyaanHasilDTO toDTO(PertanyaanHasil domainObject) {
        return new PertanyaanHasilDTOBuilder()
                .setPertanyaanHasilID(domainObject.getPertanyaanHasilID())
                .setPertanyaanID(domainObject.getPertanyaanID())
                .setPertanyaanOpsiID(domainObject.getPertanyaanOpsiID())
                .setTouchpointID(domainObject.getTouchpointID())
                .setNama(domainObject.getNama())
                .setEmail(domainObject.getEmail())
                .setContact(domainObject.getContact())
                .setValue(domainObject.getValue())
                .setCreatedBy(domainObject.getCreatedBy())
                .setCreatedDate(domainObject.getCreatedDate())
                .setModifiedBy(domainObject.getModifiedBy())
                .setModifiedDate(domainObject.getModifiedDate())
                .createPertanyaanHasilDTO();
    }

    @Override
    public PertanyaanHasil toDomain(PertanyaanHasilDTO dtoObject) {
        return new PertanyaanHasilBuilder()
                .setPertanyaanHasilID(dtoObject.getPertanyaanHasilID())
                .setPertanyaanID(dtoObject.getPertanyaanID())
                .setPertanyaanOpsiID(dtoObject.getPertanyaanOpsiID())
                .setTouchpointID(dtoObject.getTouchpointID())
                .setNama(dtoObject.getNama())
                .setEmail(dtoObject.getEmail())
                .setContact(dtoObject.getContact())
                .setValue(dtoObject.getValue())
                .setCreatedBy(dtoObject.getCreatedBy())
                .setCreatedDate(dtoObject.getCreatedDate())
                .setModifiedBy(dtoObject.getModifiedBy())
                .setModifiedDate(dtoObject.getModifiedDate())
                .createPertanyaanHasil();
    }

    public List<PertanyaanHasil> toDomains(List<PertanyaanHasilDTO> arg0) {
        List<PertanyaanHasil> res = new ArrayList<>();
        for (PertanyaanHasilDTO t : arg0) {
            res.add(new PertanyaanHasilDTOAssembler().toDomain(t));
        }
        return res;
    }

    public List<PertanyaanHasilDTO> toDTOs(List<PertanyaanHasil> arg0) {
        List<PertanyaanHasilDTO> res = new ArrayList<>();
        for (PertanyaanHasil t : arg0) {
            res.add(this.toDTO(t));
        }
        return res;

    }

}
