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
}
