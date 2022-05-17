package com.ita.edu.teachua.utils.jdbc.dao;

import com.ita.edu.teachua.utils.jdbc.entity.CenterEntity;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import static com.ita.edu.teachua.utils.jdbc.entity.CenterEntity.SELECT_ID_NAME_ASC;
import static com.ita.edu.teachua.utils.jdbc.entity.CenterEntity.SELECT_ID_NAME_DESC;

public class CenterDao {

    public List<CenterEntity> selectAll() {
        Statement statement = ManagerDao.get().getStatement();
        List<List<String>> rows = null;

        try {
            ResultSet resultSet = statement.executeQuery(CenterEntity.SELECT_ALL);
            rows = ManagerDao.get().parseResultSet(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        ManagerDao.get().closeStatement(statement);
        return CenterEntity.getCenters(rows);
    }

    public int selectIdWhereName(String centerName) {
        Statement statement = ManagerDao.get().getStatement();
        int result = 0;

        try {
            ResultSet resultSet = statement.executeQuery(String.format(CenterEntity.SELECT_ID_WHERE_NAME, centerName));
            while (resultSet.next()) {
                result = resultSet.getInt("id");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        ManagerDao.get().closeStatement(statement);
        return result;
    }

    public List<CenterEntity> selectByNameSortedAscOrDesc(boolean isAsc) {
        Statement statement = ManagerDao.get().getStatement();

        List<List<String>> rows = null;
        String query = isAsc
                ? SELECT_ID_NAME_ASC
                : SELECT_ID_NAME_DESC;

        try {
            ResultSet resultSet = statement.executeQuery(query);
            rows = ManagerDao.get().parseResultSet(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        ManagerDao.get().closeStatement(statement);

        return CenterEntity.getCentersName(rows);
    }

    public List<CenterEntity> selectByRating() {
        Statement statement = ManagerDao.get().getStatement();
        List<List<String>> rows = null;

        try {
            ResultSet resultSet = statement.executeQuery(CenterEntity.SELECT_BY_RATING);
            rows = ManagerDao.get().parseResultSet(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        ManagerDao.get().closeStatement(statement);
        return CenterEntity.getCentersByRating(rows);
    }

    public List<CenterEntity> selectByDescendingRating() {
        Statement statement = ManagerDao.get().getStatement();
        List<List<String>> rows = null;

        try {
            ResultSet resultSet = statement.executeQuery(CenterEntity.SELECT_BY_RATING_DESC);
            rows = ManagerDao.get().parseResultSet(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        ManagerDao.get().closeStatement(statement);
        return CenterEntity.getCentersByRating(rows);
    }

    public List<CenterEntity> selectAllWhereName(String name) {
        Statement statement = ManagerDao.get().getStatement();
        List<List<String>> rows = null;

        try {
            ResultSet resultSet = statement.executeQuery(String.format(CenterEntity.SELECT_All_WHERE_NAME, name));
            rows = ManagerDao.get().parseResultSet(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        ManagerDao.get().closeStatement(statement);
        return CenterEntity.getCenters(rows);
    }
}
