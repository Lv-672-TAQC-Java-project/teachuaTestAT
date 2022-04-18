package com.ita.edu.teachua.utils.jdbc.services;

import com.ita.edu.teachua.utils.jdbc.dao.AboutUsItemsDao;
import com.ita.edu.teachua.utils.jdbc.entity.AboutUsItemsEntity;

import java.util.List;

public class AboutUsItemsService {

    private final AboutUsItemsDao aboutUsItemsDao;

    public AboutUsItemsService() {
        this.aboutUsItemsDao = new AboutUsItemsDao();
    }

    public List<AboutUsItemsEntity> getAllAboutUsItems() {
        return aboutUsItemsDao.selectAll();
    }
}
