package com.agit.crm.domain.customer.touchpoint;

import java.util.List;
import java.util.Map;

/**
 *
 * @author lintang
 */
public interface TouchpointRepository {

    void saveOrUpdate(Touchpoint touchpoint);

    void deleteData(Touchpoint touchpoint);

    Touchpoint findByID(String touchpointID);

    List<Touchpoint> findAll();

    List<Touchpoint> findByParams(Map map);

}
