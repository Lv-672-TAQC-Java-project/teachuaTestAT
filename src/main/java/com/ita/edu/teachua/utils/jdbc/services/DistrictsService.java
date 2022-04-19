package com.ita.edu.teachua.utils.jdbc.services;

import com.ita.edu.teachua.utils.jdbc.dao.DistrictsDao;
import com.ita.edu.teachua.utils.jdbc.entity.DistrictsEntity;

import java.util.List;

public class DistrictsService {
    private final DistrictsDao districtsDao;

    public DistrictsService() {
        this.districtsDao = new DistrictsDao();
    }

    public List<DistrictsEntity> getAllDistricts() {
        return districtsDao.selectAll();
    }
}
