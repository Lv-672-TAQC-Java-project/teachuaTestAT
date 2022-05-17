package com.ita.edu.teachua.utils.jdbc.dao;

import com.ita.edu.teachua.utils.jdbc.entity.ClubsEntity;
import org.json.JSONArray;
import org.json.JSONObject;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class ClubsDao {
    public List<ClubsEntity> selectAll() {
        Statement statement = ManagerDao.get().getStatement();
        List<List<String>> rows = null;

        try {
            ResultSet resultSet = statement.executeQuery(ClubsEntity.SELECT_ALL);
            rows = ManagerDao.get().parseResultSet(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        ManagerDao.get().closeStatement(statement);
        return ClubsEntity.getClubs(rows);
    }

    public JSONObject selectAllWhereName(String clubName) {
        Statement statement = ManagerDao.get().getStatement();
        JSONObject obj = new JSONObject();
        JSONArray arr = new JSONArray();

        try {
            ResultSet resultSet = statement.executeQuery(String.format(ClubsEntity.SELECT_ALL_WHERE_NAME, clubName));
            while (resultSet.next()) {
                JSONObject result = new JSONObject();

                JSONObject description = new JSONObject(resultSet.getString("description"));
                JSONArray descriptionJSONArray = description.getJSONArray("blocks");
                String descriptionText = descriptionJSONArray.getJSONObject(0).getString("text");

                JSONObject contacts = new JSONObject(resultSet.getString("contacts").replace("::", ":"));
                String contactsValue = contacts.getString("1");

                result.put("id", resultSet.getInt("id"));
                result.put("name", resultSet.getString("name"));
                result.put("ageFrom", resultSet.getInt("age_from"));
                result.put("ageTo", resultSet.getInt("age_to"));
                result.put("description", descriptionText);
                result.put("contacts", String.format("+380" + contactsValue));
                result.put("isOnline", resultSet.getBoolean("is_online"));
                result.put("centerId", resultSet.getInt("center_id"));
                arr.put(result);
                obj = arr.getJSONObject(0);
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }
        ManagerDao.get().closeStatement(statement);
        return obj;
    }

    public List<ClubsEntity> selectAllNames() {
        Statement statement = ManagerDao.get().getStatement();
        List<List<String>> rows = null;

        try {
            ResultSet resultSet = statement.executeQuery(ClubsEntity.SELECT_NAME);
            rows = ManagerDao.get().parseResultSet(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        ManagerDao.get().closeStatement(statement);
        return ClubsEntity.getClubsName(rows);
    }
}
