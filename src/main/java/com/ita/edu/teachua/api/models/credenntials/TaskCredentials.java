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
}
