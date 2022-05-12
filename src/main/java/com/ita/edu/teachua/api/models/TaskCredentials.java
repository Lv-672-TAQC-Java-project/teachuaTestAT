package com.ita.edu.teachua.api.models;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class TaskCredentials {
    String name;
    String headerText;
    String description;
    String picture;
    String startDate;
}