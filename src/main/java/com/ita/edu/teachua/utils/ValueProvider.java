package com.ita.edu.teachua.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ValueProvider {
    private final Properties properties;

    public ValueProvider() throws IOException {
        FileInputStream fileInputStream = new FileInputStream("C:\\Users\\Yura\\teachuaTestAT\\src\\test\\resources\\data.properties");
        properties = new Properties();
        properties.load(fileInputStream);
    }

    public String getJDBCTeachUAURL() {
        return properties.getProperty("JDBCTeachUAURL");
    }

    public String getJDBCTeachUAUser() {
        return properties.getProperty("JDBCTeachUAUser");
    }

    public String getJDBCTeachUAPassword() {
        return properties.getProperty("JDBCTeachUAPassword");
    }
    public String getAPIBaseUrl() {
        return properties.getProperty("APIBaseUrl");
    }

}
