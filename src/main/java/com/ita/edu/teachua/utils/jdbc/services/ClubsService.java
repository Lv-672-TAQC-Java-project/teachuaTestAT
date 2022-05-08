package com.ita.edu.teachua.utils.jdbc.services;

import com.ita.edu.teachua.utils.jdbc.dao.ClubsDao;
import com.ita.edu.teachua.utils.jdbc.entity.ClubsEntity;
import org.json.JSONObject;

import java.sql.SQLException;
import java.util.List;

public class ClubsService {
    private final ClubsDao clubsDao;

    public ClubsService() {
        this.clubsDao = new ClubsDao();
    }

    public List<ClubsEntity> getAllClubs() {
        return clubsDao.selectAll();
    }

    public JSONObject getClubWhereName(String clubName) {
        return clubsDao.selectAllWhereName(clubName);
    }

    public List<ClubsEntity> getClubsName() {
        return clubsDao.selectAllNames();

    }
}
