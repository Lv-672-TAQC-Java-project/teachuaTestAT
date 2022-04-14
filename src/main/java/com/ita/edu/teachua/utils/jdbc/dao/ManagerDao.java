package com.ita.edu.teachua.utils.jdbc.dao;

import com.ita.edu.teachua.utils.ValueProvider;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ManagerDao {
    private static volatile ManagerDao instance = null;
    private final Map<Long, Connection> connections;
    private String userName;
    private String password;
    private String url;
    private ValueProvider property;

    private ManagerDao() {
        connections = new HashMap<>();
        try {
            DriverManager.registerDriver(new org.postgresql.Driver());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            property = new ValueProvider();
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.userName = property.getJDBCTeachUAUser();
        this.password = property.getJDBCTeachUAPassword();
        this.url = property.getJDBCTeachUAURL();
    }

    public static ManagerDao get(){
        if(instance == null){
            synchronized (ManagerDao.class) {
                if (instance == null){
                    instance = new ManagerDao();
                }
            }
        }
        return instance;
    }

    public static void closeAllConnection() {
        if(instance != null){
            for (Map.Entry<Long, Connection> entry: instance.connections.entrySet()) {
                try {
                    entry.getValue().close();
                } catch (SQLException e){
                    e.printStackTrace();
                }
            }
        }
    }

    private Connection createConnection() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(url, userName, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    public Connection getConnection() {
        Long idThread = Thread.currentThread().getId();
        Connection connection = connections.get(idThread);
        if(connection==null){
            connection = createConnection();
            connections.put(idThread, connection);
        }
        return connection;
    }


    public Statement getStatement(){
        Statement statement = null;
        try {
            statement = getConnection().createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return statement;
    }

    public void closeStatement(Statement statement){
        try {
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<List<String>> parseResultSet(ResultSet resultSet) throws SQLException {
        List<List<String>> result = new ArrayList<>();
        int columnCounter = resultSet.getMetaData().getColumnCount();
        while (resultSet.next()) {
            List<String> row = new ArrayList<>();
            for (int i = 1; i <= columnCounter; i++) {
                row.add(resultSet.getString(i));
            }
            result.add(row);
        }
        return result;
    }






}
