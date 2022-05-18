package com.ita.edu.teachua.api.models.response.club;

import lombok.Data;

import java.util.List;

@Data
public class ClubResponse {
    private Integer id;
    private Integer ageFrom;
    private Integer ageTo;
    private String name;
    private String description;
    private String urlWeb;
    private String urlLogo;
    private String urlBackground;
    private List<UrlGallery> urlGallery;
    private String workTime;
    private List<Category> categories;
    private User user;
    private Center center;
    private Integer rating;
    private List<Location> locations;
    private Boolean isApproved;
    private Boolean isOnline;
}
