package com.ita.edu.teachua.api.models.response.club;

import lombok.Data;

@Data
public class Location {
    private Integer id;
    private String name;
    private String address;
    private String cityName;
    private String districtName;
    private String stationName;
    private LocationCity locationCity;
    private Integer cityId;
    private Integer districtId;
    private Integer stationId;
    private Integer clubId;
    private String coordinates;
    private Integer latitude;
    private Integer longitude;
    private String phone;
}
