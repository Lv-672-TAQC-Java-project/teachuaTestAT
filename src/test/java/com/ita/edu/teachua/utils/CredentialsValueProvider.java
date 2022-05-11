package com.ita.edu.teachua.utils;

import com.ita.edu.teachua.api.models.clubs.Locations;

import java.io.IOException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class CredentialsValueProvider extends TestValueProvider{
    public CredentialsValueProvider() throws IOException {
    }

    public List<String> getCategoriesName() {
        return Arrays.stream(properties.getProperty("categoriesName").split(",")).toList();
    }

    public String getName() {
        return properties.getProperty("name");
    }

    public String getAgeFrom() {
        return properties.getProperty("ageFrom");
    }

    public String getAgeTo() {
        return properties.getProperty("ageTo");
    }

    public String getUrlLogo() {
        return properties.getProperty("urlLogo");
    }

    public String getUrlBackground() {
        return properties.getProperty("urlBackground");
    }

    public String getIsOnline() {
        return properties.getProperty("isOnline");
    }

    public String getDescription() {
        return properties.getProperty("description");
    }

    public String getUserId() {
        return properties.getProperty("userId");
    }

    public LinkedList<Locations> getLocations() {
        String[] temp = properties.getProperty("locations")
                .replaceFirst("\\{", "")
                .split("} \\{");
        LinkedList<String> va = new LinkedList<>();
        LinkedList<Locations> result = new LinkedList<>();
        Locations location = new Locations();
        temp[temp.length - 1] = temp[temp.length - 1].replaceAll("}", "");
        for (String t : temp) {
            String[] t1 = t.split("; ");
            for (String tt : t1) {
                String[] ttt = tt.split(": ");
                va.add(ttt[1]);
            }
            location.setName(va.get(0));
            location.setCityName(va.get(1));
            location.setDistrictName(va.get(2));
            location.setStationName(va.get(3));
            location.setAddress(va.get(4));
            location.setCoordinates(va.get(5));
            location.setPhone(va.get(6));
            location.setKey(Double.valueOf(va.get(7)));

            result.add(location);
        }
        return result;
    }

    public String getContacts() {
        return properties.getProperty("contacts");
    }

    public String getCenterId() {
        return properties.getProperty("centerId");
    }
}
