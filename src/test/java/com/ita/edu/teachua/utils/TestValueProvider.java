package com.ita.edu.teachua.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class TestValueProvider {
    private Properties properties;
    public TestValueProvider() throws IOException {
        FileInputStream fileInputStream = new FileInputStream("src/test/resources/data.properties");
        properties = new Properties();
        properties.load(fileInputStream);
    }

    public String getAdminEmail() {
        return properties.getProperty("adminEmail");
    }
    public String getAdminPassword() {
        return properties.getProperty("adminPassword");
    }
}
