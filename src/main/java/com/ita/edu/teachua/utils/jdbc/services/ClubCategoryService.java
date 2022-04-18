package com.ita.edu.teachua.utils.jdbc.services;

import com.ita.edu.teachua.utils.jdbc.dao.ClubCategoryDao;
import com.ita.edu.teachua.utils.jdbc.entity.ClubCategoryEntity;

import java.util.List;

public class ClubCategoryService {
    private final ClubCategoryDao clubCategoryDao;

    public ClubCategoryService() {
        this.clubCategoryDao = new ClubCategoryDao();
    }

    public List<ClubCategoryEntity> getAllClubCategories() {
        return clubCategoryDao.selectAll();
    }
}
