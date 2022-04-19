package com.ita.edu.teachua.utils.jdbc.services;

import com.ita.edu.teachua.utils.jdbc.dao.BannerItemsDao;
import com.ita.edu.teachua.utils.jdbc.entity.BannerItemsEntity;

import java.util.List;

public class BannerItemsService {

    private final BannerItemsDao bannerItemsDao;

    public BannerItemsService() {
        this.bannerItemsDao = new BannerItemsDao();
    }

    public List<BannerItemsEntity> getAllBannerItems() {
        return bannerItemsDao.selectAll();
    }
}
