package com.ita.edu.teachua.api.models.response.challenge;

import lombok.Data;

@Data
public class ChallengeResponse {
    private int id;
    private String name;
    private String title;
    private String description;
    private String registrationLink;
    private String picture;
    private int sortNumber;
    private Boolean isActive;
    User user;
}
