package com.ita.edu.teachua.utils.jdbc.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Setter
@Getter
public class CategoryEntity {
    public static final String SELECT_ALL = "SELECT * FROM categories ORDER BY id;";
    private String backgroundColor;
    private String description;
    private Long id;
    private String name;
    private int sortBy;
    private String tagBackgroundColor;
    private String tagTextColor;
    private String urlLogo;

    public CategoryEntity() {
        this.backgroundColor = null;
        this.description = null;
        this.id = 0L;
        this.name = null;
        this.sortBy = 0;
        this.tagBackgroundColor = null;
        this.tagTextColor = null;
        this.urlLogo = null;
    }

    @Override
    public String toString() {
        return "CategoryEntity{" +
                "backgroundColor='" + backgroundColor + '\'' +
                ", description='" + description + '\'' +
                ", id=" + id +
                ", name='" + name + '\'' +
                ", sortBy=" + sortBy +
                ", tagBackgroundColor='" + tagBackgroundColor + '\'' +
                ", tagTextColor='" + tagTextColor + '\'' +
                ", urlLogo='" + urlLogo + '\'' +
                '}';
    }

    public static CategoryEntity getCategory(List<String> row) {
        CategoryEntity categoryEntity = new CategoryEntity();

        categoryEntity.setId(Long.parseLong(row.get(0)));
        categoryEntity.setBackgroundColor(row.get(1));
        categoryEntity.setDescription(row.get(2));
        categoryEntity.setName(row.get(3));
        categoryEntity.setSortBy(Integer.parseInt(row.get(4)));
        categoryEntity.setTagBackgroundColor(row.get(5));
        categoryEntity.setTagTextColor(row.get(6));
        categoryEntity.setUrlLogo(row.get(7));

        return categoryEntity;
    }

    public static List<CategoryEntity> getCategories(List<List<String>> rows) {
        List<CategoryEntity> categories = new ArrayList<>();

        for(List<String> row : rows) {
            categories.add(getCategory(row));
        }

        return categories;
    }
}
