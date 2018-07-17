package com.agit.crm.interfaces.web.facade.dto.assembler.crm;

import com.agit.crm.common.dto.customer.touchpoint.TouchpointDTO;
import com.agit.crm.common.dto.customer.touchpoint.TouchpointDTOBuilder;
import com.agit.crm.domain.customer.touchpoint.Touchpoint;
import com.agit.crm.domain.customer.touchpoint.TouchpointBuilder;
import com.agit.crm.shared.object.IObjectAssembler;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author lintang
 */
public class TouchpointDTOAssembler implements IObjectAssembler<Touchpoint, TouchpointDTO> {

    @Override
    public TouchpointDTO toDTO(Touchpoint domainObject) {
        return new TouchpointDTOBuilder()
                .setTouchpointID(domainObject.getTouchpointID())
                .setTouchpoint(domainObject.getTouchpoint())
                .setTouchpoint(domainObject.getTouchpoint())
                .setDeskripsi(domainObject.getDeskripsi())
                .setUrl(domainObject.getUrl())
                .setCreatedBy(domainObject.getCreatedBy())
                .setCreatedDate(domainObject.getCreatedDate())
                .setModifiedBy(domainObject.getModifiedBy())
                .setModifiedDate(domainObject.getModifiedDate())
                .createTouchpointDTO();
    }

    @Override
    public Touchpoint toDomain(TouchpointDTO dtoObject) {
        return new TouchpointBuilder()
                .setTouchpointID(dtoObject.getTouchpointID())
                .setTouchpoint(dtoObject.getTouchpoint())
                .setTouchpoint(dtoObject.getTouchpoint())
                .setDeskripsi(dtoObject.getDeskripsi())
                .setUrl(dtoObject.getUrl())
                .setCreatedBy(dtoObject.getCreatedBy())
                .setCreatedDate(dtoObject.getCreatedDate())
                .setModifiedBy(dtoObject.getModifiedBy())
                .setModifiedDate(dtoObject.getModifiedDate())
                .createTouchpoint();
    }

    public List<Touchpoint> toDomains(List<TouchpointDTO> arg0) {
        List<Touchpoint> res = new ArrayList<>();
        for (TouchpointDTO t : arg0) {
            res.add(new TouchpointDTOAssembler().toDomain(t));
        }
        return res;
    }

    public List<TouchpointDTO> toDTOs(List<Touchpoint> arg0) {
        List<TouchpointDTO> res = new ArrayList<>();
        for (Touchpoint t : arg0) {
            res.add(this.toDTO(t));
        }
        return res;

    }

}
