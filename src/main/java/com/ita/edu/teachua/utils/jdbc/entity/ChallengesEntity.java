package com.ita.edu.teachua.utils.jdbc.entity;

import java.util.ArrayList;
import java.util.List;

public class ChallengesEntity {
    public static final String SELECT_ALL = "SELECT id, description, is_active, name, picture, registration_link, sort_number, title, user_id FROM challenges ORDER BY id;";

    private Long id;
    private String description;
    private Boolean isActive;
    private String name;
    private String picture;
    private String registrationLink;
    private Integer sortNumber;
    private String title;
    private Integer userId;

    public ChallengesEntity(String description, Long id, Boolean isActive, String name, String picture, String registrationLink, Integer sortNumber, String title, Integer userId) {
        this.id = id;
        this.description = description;
        this.isActive = isActive;
        this.name = name;
        this.picture = picture;
        this.registrationLink = registrationLink;
        this.sortNumber = sortNumber;
        this.title = title;
        this.userId = userId;
    }

    public ChallengesEntity() {
        this.id = 0L;
        this.description = null;
        this.isActive = null;
        this.name = null;
        this.picture = null;
        this.registrationLink = null;
        this.sortNumber = null;
        this.title = null;
        this.userId = null;
    }

    public static ChallengesEntity getChallenge(List<String> row) {
        ChallengesEntity challenge = new ChallengesEntity();
        challenge.setId(Long.parseLong(row.get(0)));
        challenge.setDescription(row.get(1));

        challenge.setIsActive(row.get(2).equals("t"));

        challenge.setName(row.get(3));
        challenge.setPicture(row.get(4));
        challenge.setRegistrationLink(row.get(5));
        challenge.setSortNumber(Integer.parseInt(row.get(6)));
        challenge.setTitle(row.get(7));
        if (row.get(8) != null) {
            challenge.setUserId(Integer.parseInt(row.get(8)));
        }

        return challenge;
    }

    public static List<ChallengesEntity> getChallenges(List<List<String>> rows) {
        List<ChallengesEntity> challenges = new ArrayList<>();
        for (List<String> row : rows) {
            challenges.add(getChallenge(row));
        }
        return challenges;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(Boolean isActive) {
        this.isActive = isActive;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getRegistrationLink() {
        return registrationLink;
    }

    public void setRegistrationLink(String registrationLink) {
        this.registrationLink = registrationLink;
    }

    public Integer getSortNumber() {
        return sortNumber;
    }

    public void setSortNumber(Integer sortNumber) {
        this.sortNumber = sortNumber;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "ChallengesEntity{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", isActive=" + isActive +
                ", name='" + name + '\'' +
                ", picture='" + picture + '\'' +
                ", registrationLink='" + registrationLink + '\'' +
                ", sortNumber=" + sortNumber +
                ", title='" + title + '\'' +
                ", userId=" + userId +
                '}';
    }
}
