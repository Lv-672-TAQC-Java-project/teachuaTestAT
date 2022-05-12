package com.ita.edu.teachua.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Properties;

public class TestValueProvider {
    private final Properties properties;

    public TestValueProvider() throws IOException {
        FileInputStream fileInputStream = new FileInputStream("src/test/resources/data.properties");
        InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream, StandardCharsets.UTF_8);
        properties = new Properties();
        properties.load(inputStreamReader);
    }

    public String getAdminEmail() {
        return properties.getProperty("adminEmail");
    }

    public String getAdminPassword() {
        return properties.getProperty("adminPassword");
    }

    public String getSizeOfSearchResult() {
        return properties.getProperty("sizeOfSearchResult");
    }

    public String getMaxSizeOfSearchField() {
        return properties.getProperty("maxSizeOfSearchField");
    }

    public String getLastName() {
        return properties.getProperty("lastName");
    }

    public String getFirstName() {
        return properties.getProperty("firstName");
    }

    public String getPhone() {
        return properties.getProperty("phone");
    }

    public String getEmail() {
        return properties.getProperty("email");
    }

    public String getPassword() {
        return properties.getProperty("password");
    }

    public String getConfirmPassword() {
        return properties.getProperty("confirmPassword");
    }

    public String getUserWithNonAdministratorRightsPassword() {
        return properties.getProperty("userWithNonAdministratorPassword");
    }

    public String getUserWithNonAdministratorRightsEmail() {
        return properties.getProperty("userWithNonAdministratorEmail");
    }
}
