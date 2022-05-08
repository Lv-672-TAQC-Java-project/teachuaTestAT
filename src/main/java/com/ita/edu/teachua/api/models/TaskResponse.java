package com.ita.edu.teachua.api.models;


import lombok.AllArgsConstructor;
import lombok.Data;

@Data
//@AllArgsConstructor
public class TaskResponse {
    private Long id;
    private String name;
    private String headerText;
    private String description;
    private String picture;
    private String startDate;
    private Long challengeId;
}
