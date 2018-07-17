package com.agit.crm.application.impl;

import com.agit.crm.common.application.TouchpointService;
import com.agit.crm.common.dto.customer.touchpoint.TouchpointDTO;
import com.agit.crm.domain.customer.touchpoint.Touchpoint;
import com.agit.crm.domain.customer.touchpoint.TouchpointRepository;
import com.agit.crm.interfaces.web.facade.dto.assembler.crm.TouchpointDTOAssembler;
import java.util.List;
import java.util.Map;
import org.apache.commons.lang.Validate;

/**
 *
 * @author lintang
 */
public class TouchpointServiceImpl implements TouchpointService {

    private TouchpointRepository touchpointRepository;
    private TouchpointDTOAssembler touchpointDTOAssembler;

    public void setTouchpointRepository(TouchpointRepository touchpointRepository) {
        this.touchpointRepository = touchpointRepository;
    }

    public void setTouchpointDTOAssembler(TouchpointDTOAssembler touchpointDTOAssembler) {
        this.touchpointDTOAssembler = touchpointDTOAssembler;
    }

    @Override
    public void saveOrUpdate(TouchpointDTO touchpoint) {
        Touchpoint t = touchpointRepository.findByID(touchpoint.getTouchpointID());

        if (t == null) {
            t = touchpointDTOAssembler.toDomain(touchpoint);
        } else {
            Touchpoint newTouchpoint = touchpointDTOAssembler.toDomain(touchpoint);
            t.assignNewTouchpoint(newTouchpoint);

        }
        touchpointRepository.saveOrUpdate(t);
    }

    @Override
    public void deleteData(TouchpointDTO touchpoint) {
        Touchpoint p = touchpointDTOAssembler.toDomain(touchpoint);
        touchpointRepository.deleteData(p);
    }

    @Override
    public TouchpointDTO findByID(String touchpointID) {
        Validate.notNull(touchpointRepository);
        Touchpoint b = (Touchpoint) touchpointRepository.findByID(touchpointID);
        if (b != null) {
            return touchpointDTOAssembler.toDTO(b);
        }
        return null;
    }

    @Override
    public List<TouchpointDTO> findAll() {
        Validate.notNull(touchpointRepository);
        return touchpointDTOAssembler.toDTOs(touchpointRepository.findAll());
    }

    @Override
    public List<TouchpointDTO> findByParams(Map map) {
        Validate.notNull(touchpointRepository);
        List<Touchpoint> touchpoints = touchpointRepository.findByParams(map);
        if (touchpoints != null) {
            return (List<TouchpointDTO>) touchpointDTOAssembler.toDTOs(touchpoints);
        }
        return null;
    }

}
