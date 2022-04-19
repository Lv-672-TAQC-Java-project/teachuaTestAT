package com.ita.edu.teachua.utils.jdbc.entity;

import java.util.ArrayList;
import java.util.List;

public class DistrictsEntity {
    public static final String SELECT_ALL = "SELECT * FROM districts ORDER BY id;";

    private Long id;
    private Long cityId;
    private String name;

    public DistrictsEntity(Long id, Long cityId, String name) {
        this.id = id;
        this.cityId = cityId;
        this.name = name;
    }

    public DistrictsEntity() {
        this.id = 0L;
        this.cityId = 0L;
        this.name = null;
    }


    public static DistrictsEntity getDistrict(List<String> row) {
        DistrictsEntity district = new DistrictsEntity();
        district.setId(Long.parseLong(row.get(0)));
        district.setName(row.get(1));
        district.setCityId(Long.parseLong(row.get(2)));
        return district;
    }

    public static List<DistrictsEntity> getDistricts(List<List<String>> rows) {
        List<DistrictsEntity> districts = new ArrayList<>();
        for (List<String> row : rows) {
            districts.add(getDistrict(row));
        }
        return districts;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCityId() {
        return cityId;
    }

    public void setCityId(Long cityId) {
        this.cityId = cityId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "DistrictsEntity{" +
                "id=" + id +
                ", cityId=" + cityId +
                ", name='" + name + '\'' +
                '}';
    }
}
