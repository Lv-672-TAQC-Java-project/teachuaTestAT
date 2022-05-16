package com.ita.edu.teachua.api.models.response.club;

import lombok.Data;

import java.util.List;

@Data
public class Category {
    private Integer id;
    private Integer sortby;
    private String name;
    private String description;
    private String urlLogo;
    private String backgroundColor;
    private String tagBackgroundColor;
    private String tagTextColor;
    private List<Club> clubs;
}
