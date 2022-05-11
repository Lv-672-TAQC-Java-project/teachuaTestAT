package com.ita.edu.teachua.api.models.clubs;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.LinkedList;
import java.util.List;

@Data
@AllArgsConstructor
public class NewClubCredentials {
    List<String> categoriesName;
    String name;
    Integer ageFrom;
    Integer ageTo;
    String urlLogo;
    String urlBackground;
    Boolean isOnline;
    String description;
    String userId;
    LinkedList<Locations> locations;
    String contacts;
    Integer centerId;
}

