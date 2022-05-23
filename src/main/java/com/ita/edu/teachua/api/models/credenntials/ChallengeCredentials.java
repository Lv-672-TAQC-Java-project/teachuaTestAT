package com.ita.edu.teachua.api.models.credenntials;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ChallengeCredentials {

    private String name;
    private String title;
    private String description;
    private String registrationLink;
    private String picture;
    private String sortNumber;
    private String isActive;

    public ChallengeCredentials(String name, String title, String description, String registrationLink, String picture, String sortNumber) {
        this.name = name;
        this.title = title;
        this.description = description;
        this.registrationLink = registrationLink;
        this.picture = picture;
        this.sortNumber = sortNumber;
    }
}
