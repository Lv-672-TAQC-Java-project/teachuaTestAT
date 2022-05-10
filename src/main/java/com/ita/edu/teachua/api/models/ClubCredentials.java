package com.ita.edu.teachua.api.models;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class ClubCredentials {
    private List<String> categoriesName;
    private String name;
    private int ageFrom;
    private int ageTo;
    private boolean isOnline;
    private String contacts;
    private String description;
    private List<Locations> locations;
    private int userId;

    @Data
    @AllArgsConstructor
    public class Locations {

        //body of class
    }
}
