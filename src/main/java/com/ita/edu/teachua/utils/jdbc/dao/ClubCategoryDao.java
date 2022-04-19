package com.ita.edu.teachua.utils.jdbc.dao;

import com.ita.edu.teachua.utils.jdbc.entity.ClubCategoryEntity;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class ClubCategoryDao {

    public List<ClubCategoryEntity> selectAll() {
        Statement statement = ManagerDao.get().getStatement();
        List<List<String>> rows = null;

        try {
            ResultSet resultSet = statement.executeQuery(ClubCategoryEntity.SELECT_FIRST);
            rows = ManagerDao.get().parseResultSet(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        ManagerDao.get().closeStatement(statement);
        return ClubCategoryEntity.getClubCategories(rows);
    }
}
