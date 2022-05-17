package com.ita.edu.teachua.api.models.credenntials;

import com.ita.edu.teachua.api.models.response.club.Location;
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
    private List<Location> locations;
    private int userId;
}
