package com.ita.edu.teachua.api.models.response.club;

import lombok.Data;

import java.util.List;

@Data
public class Role {
    private Integer id;
    private String name;
    private List<String> users;
}
