package com.ita.edu.teachua.api.models.response.club;

import lombok.Data;

@Data
public class Station {
    private Integer id;
    private String name;
    private City city;
    private District district;
}
