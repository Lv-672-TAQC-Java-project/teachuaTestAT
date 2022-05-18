package com.ita.edu.teachua.utils.jdbc.services;

import com.ita.edu.teachua.utils.jdbc.dao.UserDao;
import com.ita.edu.teachua.utils.jdbc.entity.UserEntity;

import java.util.List;

public class UserService {
    private final UserDao userDao;

    public UserService() {
        this.userDao = new UserDao();
    }

    public List<UserEntity> getAllUsers() {
        return userDao.selectAll();
    }

    public List<UserEntity> getAllUsersWhereEmail(String email) {
        return userDao.selectAllWhereEmail(email);
    }

    public List<UserEntity> getAllUsersWhereEmailLike(String email) {
        return userDao.selectWhereEmailLike(email);
    }
}
