package com.ita.edu.teachua.utils.jdbc.entity;

import java.util.ArrayList;
import java.util.List;

public class ClubCategoryEntity {
    public static final String SELECT_FIRST = "SELECT * FROM club_category WHERE club_id = 1;";

    private Long clubId;
    private Long categoryId;

    public ClubCategoryEntity(Long clubId, Long categoryId) {
        this.clubId = clubId;
        this.categoryId = categoryId;
    }

    public ClubCategoryEntity() {
        this.clubId = 0L;
        this.categoryId = 0L;
    }

    public static ClubCategoryEntity getClubCategory(List<String> row) {
        ClubCategoryEntity clubCategoryEntity = new ClubCategoryEntity();
        clubCategoryEntity.setClubId(Long.parseLong(row.get(0)));
        clubCategoryEntity.setCategoryId(Long.parseLong(row.get(1)));
        //        if (row.get(11) != null) {
//            user.setRoleId(Integer.parseInt(row.get(11)));
//        }

        return clubCategoryEntity;
    }

    public static List<ClubCategoryEntity> getClubCategories(List<List<String>> rows) {
        List<ClubCategoryEntity> clubCategories = new ArrayList<>();
        for (List<String> row : rows) {
            clubCategories.add(getClubCategory(row));
        }
        return clubCategories;
    }


    public Long getClubId() {
        return clubId;
    }

    public void setClubId(Long clubId) {
        this.clubId = clubId;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    @Override
    public String toString() {
        return "ClubCategoryEntity{" +
                "clubId=" + clubId +
                ", categoryId=" + categoryId +
                '}';
    }

}
