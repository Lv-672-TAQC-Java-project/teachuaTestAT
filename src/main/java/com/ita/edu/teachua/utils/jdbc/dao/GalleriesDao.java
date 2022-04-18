package com.ita.edu.teachua.utils.jdbc.dao;

import com.ita.edu.teachua.utils.jdbc.entity.GalleriesEntity;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class GalleriesDao {
    public List<GalleriesEntity> selectAll() {
        Statement statement = ManagerDao.get().getStatement();
        List<List<String>> rows = null;

        try {
            ResultSet resultSet = statement.executeQuery(GalleriesEntity.SELECT_ALL);
            rows = ManagerDao.get().parseResultSet(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        ManagerDao.get().closeStatement(statement);
        return GalleriesEntity.getGalleries(rows);
    }
}
