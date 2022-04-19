package com.ita.edu.teachua.utils.jdbc.services;

import com.ita.edu.teachua.utils.jdbc.dao.CityDao;
import com.ita.edu.teachua.utils.jdbc.entity.CityEntity;

import java.util.List;

public class CityService {

    private final CityDao cityDao;

    public CityService() {
        this.cityDao = new CityDao();
    }

    public List<CityEntity> getAllCities() {
        return cityDao.selectAll();
    }
}
