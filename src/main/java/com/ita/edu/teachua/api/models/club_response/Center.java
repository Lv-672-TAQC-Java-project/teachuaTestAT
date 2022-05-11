package com.ita.edu.teachua.api.models.club_response;

import lombok.Data;

import java.util.List;

@Data
public class Center {
    private Integer id;
    private String name;
    private String contacts;
    private String urlBackgroundPicture;
    private String description;
    private String urlWeb;
    private String urlLogo;
    private List<Location> locations;
    private List<Club> clubs;
    private User user;
    private Integer centerExternalId;
    private Integer rating;
    private Integer clubCount;
}
