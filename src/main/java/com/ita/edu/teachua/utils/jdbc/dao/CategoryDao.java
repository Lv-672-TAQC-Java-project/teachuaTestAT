package com.ita.edu.teachua.utils.jdbc.dao;

import com.ita.edu.teachua.utils.jdbc.entity.CategoryEntity;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class CategoryDao {
    public List<CategoryEntity> selectAll() {
        Statement statement = ManagerDao.get().getStatement();

        List<List<String>> rows = null;

        try {
            ResultSet resultSet = statement.executeQuery(CategoryEntity.SELECT_ALL);
            rows = ManagerDao.get().parseResultSet(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        ManagerDao.get().closeStatement(statement);

        return CategoryEntity.getCategories(rows);
    }
}
