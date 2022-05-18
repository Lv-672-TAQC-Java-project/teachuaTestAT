package com.ita.edu.teachua.api.models.credenntials;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class TaskCredentials {

    private String name;
    private String headerText;
    private String description;
    private String picture;
    private String startDate;
    private Long challengeId;

    public TaskCredentials(String name, String headerText, String description, String picture, String startDate) {
        this.name = name;
        this.headerText = headerText;
        this.description = description;
        this.picture = picture;
        this.startDate = startDate;
    }
}
