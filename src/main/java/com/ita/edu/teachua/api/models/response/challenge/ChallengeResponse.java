package com.ita.edu.teachua.api.models.response.challenge;

import lombok.Data;

import java.util.List;

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
    private List<Task> tasks;
    User user;
}
