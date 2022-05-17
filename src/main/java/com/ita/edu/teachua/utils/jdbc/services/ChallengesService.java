package com.ita.edu.teachua.utils.jdbc.services;

import com.ita.edu.teachua.utils.jdbc.dao.ChallengesDao;
import com.ita.edu.teachua.utils.jdbc.entity.ChallengesEntity;

import java.util.List;

public class ChallengesService {
    private final ChallengesDao challengesDao;

    public ChallengesService() {
        this.challengesDao = new ChallengesDao();
    }

    public List<ChallengesEntity> getAllChallenges() {
        return challengesDao.selectAll();
    }
}
