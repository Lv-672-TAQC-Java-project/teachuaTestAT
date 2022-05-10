package com.ita.edu.teachua.api.models;

import lombok.Data;

import java.util.List;

@Data
public class TaskResponse {

    private Long id;
    private String name;
    private String headerText;
    private String description;
    private String picture;
    private List<Integer> startDate;
    private Long challengeId;
}
