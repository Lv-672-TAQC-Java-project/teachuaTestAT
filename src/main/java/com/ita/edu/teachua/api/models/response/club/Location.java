package com.ita.edu.teachua.api.models.response.club;

import lombok.Data;

@Data
public class Location {
    private Integer id;
    private String name;
    private String address;
    private Integer latitude;
    private Integer longitude;
    private String phone;
    private District district;
    private Station station;
    private City city;
    private Club club;
    private String center;
}
