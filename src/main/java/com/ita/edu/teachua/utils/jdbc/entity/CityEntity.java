package com.ita.edu.teachua.utils.jdbc.entity;

import java.util.ArrayList;
import java.util.List;

public class CityEntity {
    public static final String SELECT_ALL = "SELECT * FROM cities ORDER BY id;";

    private Long id;
    private Double latitude;
    private Double longitude;
    private String name;

    public CityEntity(Long id, Double latitude, Double longitude, String name) {
        this.id = id;
        this.latitude = latitude;
        this.longitude = longitude;
        this.name = name;
    }

    public CityEntity() {
        this.id = 0l;
        this.latitude = null;
        this.longitude = null;
        this.name = null;
    }

    public static CityEntity getCity(List<String> row) {
        CityEntity city = new CityEntity();
        city.setId(Long.parseLong(row.get(0)));
        city.setLatitude(Double.parseDouble(row.get(1)));
        city.setLongitude(Double.parseDouble(row.get(2)));
        city.setName(row.get(3));

        return city;
    }

    public static List<CityEntity> getCities(List<List<String>> rows) {
        List<CityEntity> cities = new ArrayList<>();
        for (List<String> row : rows) {
            cities.add(getCity(row));
        }
        return cities;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "CityEntity{" +
                "id=" + id +
                ", latitude=" + latitude +
                ", longitude=" + longitude +
                ", name='" + name + '\'' +
                '}';
    }
}
