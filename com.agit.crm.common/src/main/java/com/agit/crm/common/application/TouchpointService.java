package com.agit.crm.common.application;

import com.agit.crm.common.dto.customer.touchpoint.TouchpointDTO;
import java.util.List;
import java.util.Map;

/**
 *
 * @author lintang
 */
public interface TouchpointService {

    void saveOrUpdate(TouchpointDTO touchpoint);

    void deleteData(TouchpointDTO touchpoint);

    TouchpointDTO findByID(String touchpointID);

    List<TouchpointDTO> findAll();

    List<TouchpointDTO> findByParams(Map map);

}
