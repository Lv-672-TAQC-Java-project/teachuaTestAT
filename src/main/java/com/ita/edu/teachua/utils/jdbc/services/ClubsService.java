package com.ita.edu.teachua.utils.jdbc.services;


import com.ita.edu.teachua.utils.jdbc.dao.ClubsDao;
import com.ita.edu.teachua.utils.jdbc.entity.ClubsEntity;
import com.ita.edu.teachua.utils.jdbc.entity.UserEntity;

import java.util.List;

public class ClubsService {
    private final ClubsDao clubsDao;

    public ClubsService() {
        this.clubsDao = new ClubsDao();
    }

    public List<ClubsEntity> getAllClubs() {
        return clubsDao.selectAll();
    }

    public List<ClubsEntity> getClubsName() {
        return clubsDao.selectAllNames();
    }
}
