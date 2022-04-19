package com.ita.edu.teachua.utils.jdbc.services;

import com.ita.edu.teachua.utils.jdbc.dao.LocationDao;
import com.ita.edu.teachua.utils.jdbc.entity.LocationEntity;

import java.util.List;

public class LocationService {
    private final LocationDao locationDao;

    public LocationService() {
        this.locationDao = new LocationDao();
    }

    public List<LocationEntity> getAllLocations() {
        return locationDao.selectAll();
    }
}
