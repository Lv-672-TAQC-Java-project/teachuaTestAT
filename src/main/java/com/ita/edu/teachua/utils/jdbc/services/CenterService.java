package com.ita.edu.teachua.utils.jdbc.services;

import com.ita.edu.teachua.utils.jdbc.dao.CenterDao;
import com.ita.edu.teachua.utils.jdbc.entity.CenterEntity;
import com.ita.edu.teachua.utils.jdbc.entity.LocationEntity;

import java.util.List;

public class CenterService {
    private final CenterDao centerDao;

    public CenterService() {
        this.centerDao = new CenterDao();
    }

    public List<CenterEntity> getAllCenters() {
        return centerDao.selectAll();
    }

    public List<CenterEntity> getAllCentersWhereName(String name) {
        return centerDao.selectAllWhereName(name);
    }
}