package com.ita.edu.teachua.utils.jdbc.dao;

import com.ita.edu.teachua.utils.jdbc.entity.UserEntity;
import io.qameta.allure.Step;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import static java.lang.String.format;

public class UserDao {

    public List<UserEntity> selectAll() {
        Statement statement = ManagerDao.get().getStatement();
        List<List<String>> rows = null;

        try {
            ResultSet resultSet = statement.executeQuery(UserEntity.SELECT_ALL);
            rows = ManagerDao.get().parseResultSet(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        ManagerDao.get().closeStatement(statement);
        return UserEntity.getUsers(rows);
    }

    public List<UserEntity> selectAllWhereEmail(String email) {
        Statement statement = ManagerDao.get().getStatement();
        List<List<String>> rows = null;

        try {
            ResultSet resultSet = statement.executeQuery(format(UserEntity.SELECT_ALL_WHERE_NAME, email));
            rows = ManagerDao.get().parseResultSet(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        ManagerDao.get().closeStatement(statement);
        return UserEntity.getUsers(rows);
    }

    @Step("Select all users from users table where {id}")
    public List<UserEntity> selectAllWhereId(int id) {
        Statement statement = ManagerDao.get().getStatement();
        List<List<String>> rows = null;

        try {
            ResultSet resultSet = statement.executeQuery(format(UserEntity.SELECT_ALL_WHERE_ID, id));
            rows = ManagerDao.get().parseResultSet(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        ManagerDao.get().closeStatement(statement);
        return UserEntity.getUsers(rows);
    }
  
    @Step("Select all users from users table where {email}")
    public List<UserEntity> selectWhereEmailLike(String email) {

        Statement statement = ManagerDao.get().getStatement();
        List<List<String>> rows = null;

        try {
            ResultSet resultSet = statement.executeQuery(format(UserEntity.SELECT_ALL_WHERE_EMAIL, email));
            rows = ManagerDao.get().parseResultSet(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        ManagerDao.get().closeStatement(statement);
        return UserEntity.getUsers(rows);
    }
}
