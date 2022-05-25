package com.ita.edu.teachua.utils.jdbc.services;

import com.ita.edu.teachua.utils.jdbc.dao.GalleriesDao;
import com.ita.edu.teachua.utils.jdbc.entity.GalleriesEntity;

import java.util.List;

public class GalleriesService {

    private final GalleriesDao galleriesDao;

    public GalleriesService() {
        this.galleriesDao = new GalleriesDao();
    }

    public List<GalleriesEntity> getAllGalleries() {
        return galleriesDao.selectAll();
    }
}
