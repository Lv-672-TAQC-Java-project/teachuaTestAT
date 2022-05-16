package com.ita.edu.teachua.api.models.response.club;

import lombok.Data;

import java.util.List;

@Data
public class Club {
    private Integer id;
    private Integer ageFrom;
    private Integer ageTo;
    private String name;
    private String description;
    private String urlWeb;
    private String urlLogo;
    private String urlBackground;
    private List<String> urlGallery;
    private String workTime;
    private Integer rating;
    private Integer feedbackCount;
    private List<String> locations;
    private List<String> categories;
    private User user;
    private String center;
    private Boolean isApproved;
    private Boolean isOnline;
    private String contacts;
    private Integer clubExternalId;
    private Integer centerExternalId;
}
