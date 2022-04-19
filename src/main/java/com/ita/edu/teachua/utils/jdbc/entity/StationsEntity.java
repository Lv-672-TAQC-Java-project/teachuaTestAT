package com.ita.edu.teachua.utils.jdbc.entity;

import java.util.ArrayList;
import java.util.List;

public class StationsEntity {
    public static final String SELECT_ALL = "SELECT * FROM stations ORDER BY id;";

    private Long id;
    private Long cityId;
    private Long districtId;
    private String name;

    public StationsEntity(Long id, Long cityId, Long districtId, String name) {
        this.id = id;
        this.cityId = cityId;
        this.districtId = districtId;
        this.name = name;
    }

    public StationsEntity() {
        this.id = 0L;
        this.cityId =  0L;
        this.districtId =  0L;
        this.name = null;
    }

    public static StationsEntity getStation(List<String> row) {
        StationsEntity station = new StationsEntity();
        station.setId(Long.parseLong(row.get(0)));
        station.setName(row.get(1));
        station.setCityId(Long.parseLong(row.get(2)));

        if (row.get(3) != null) {
            station.setDistrictId(Long.parseLong(row.get(3)));
        }
        return station;
    }

    public static List<StationsEntity> getStations(List<List<String>> rows) {
        List<StationsEntity> stations = new ArrayList<>();
        for (List<String> row : rows) {
            stations.add(getStation(row));
        }
        return stations;
    }

    public Long getId() {
        return id;
    }

    public Long getCityId() {
        return cityId;
    }

    public Long getDistrictId() {
        return districtId;
    }

    public String getName() {
        return name;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setCityId(Long cityId) {
        this.cityId = cityId;
    }

    public void setDistrictId(Long districtId) {
        this.districtId = districtId;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "StationsEntity{" +
                "id=" + id +
                ", cityId=" + cityId +
                ", districtId=" + districtId +
                ", name='" + name + '\'' +
                '}';
    }
}
