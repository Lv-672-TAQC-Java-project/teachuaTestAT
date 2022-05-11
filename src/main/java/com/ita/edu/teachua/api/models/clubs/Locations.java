package com.ita.edu.teachua.api.models.clubs;

import lombok.Data;


@Data
public class Locations {
    String name;
    String cityName;
    String districtName;
    String stationName;
    String address;
    String coordinates;
    String phone;
    Double key;
}
