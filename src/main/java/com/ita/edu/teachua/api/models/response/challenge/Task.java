package com.ita.edu.teachua.api.models.response.challenge;

import lombok.Data;

import java.util.List;

@Data
public class Task {
    private int id;
    private String name;
    private String headerText;
    private String picture;
    private List<Integer> startDate;
}
