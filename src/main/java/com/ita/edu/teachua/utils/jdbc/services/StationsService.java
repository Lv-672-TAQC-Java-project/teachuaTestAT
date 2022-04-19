package com.ita.edu.teachua.utils.jdbc.services;

import com.ita.edu.teachua.utils.jdbc.dao.StationsDao;
import com.ita.edu.teachua.utils.jdbc.entity.StationsEntity;

import java.util.List;

public class StationsService {
    private final StationsDao stationsDao;

    public StationsService() {
        this.stationsDao = new StationsDao();
    }

    public List<StationsEntity> getAllStations() {
        return stationsDao.selectAll();
    }
}
