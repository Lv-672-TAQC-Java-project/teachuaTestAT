package com.ita.edu.teachua.utils.jdbc.entity;

import java.util.ArrayList;
import java.util.List;

public class CenterEntity {
    public static final String SELECT_ALL = "SELECT * FROM centers ORDER BY id;";

    private Long id;
    private Long center_external_id;
    private Long club_count;
    private String contacts;
    private String description;
    private String name;
    private Double rating;
    private String url_background_picture;
    private String url_logo;
    private String url_web;
    private Long user_id;

    public CenterEntity(Long center_external_id, Long club_count, String contacts, String description, Long id, String name, Double rating, String url_background_picture, String url_logo, String url_web, Long user_id) {
        this.center_external_id = center_external_id;
        this.club_count = club_count;
        this.contacts = contacts;
        this.description = description;
        this.id = id;
        this.name = name;
        this.rating = rating;
        this.url_background_picture = url_background_picture;
        this.url_logo = url_logo;
        this.url_web = url_web;
        this.user_id = user_id;
    }

    public CenterEntity() {
        this.center_external_id = 0l;
        this.club_count = 0l;
        this.contacts = null;
        this.description = null;
        this.id = 0l;
        this.name = null;
        this.rating = null;
        this.url_background_picture = null;
        this.url_logo = null;
        this.url_web = null;
        this.user_id = 0l;
    }

    public static CenterEntity getCenter(List<String> row) {
        CenterEntity center = new CenterEntity();
        center.setId(Long.parseLong(row.get(0)));
        if (row.get(1) != null) {
            center.setCenter_external_id(Long.parseLong(row.get(1)));
        }
        center.setContacts(row.get(2));
        center.setDescription(row.get(3));
        center.setName(row.get(4));
        center.setUrl_background_picture(row.get(5));
        center.setUrl_logo(row.get(6));
        center.setUrl_web(row.get(7));
        if (row.get(8) != null) {
            center.setUser_id(Long.parseLong(row.get(8)));
        }
        center.setClub_count(Long.parseLong(row.get(9)));
        center.setRating(Double.parseDouble(row.get(10)));
        return center;
    }

    public static List<CenterEntity> getCenters(List<List<String>> rows) {
        List<CenterEntity> centers = new ArrayList<>();
        for (List<String> row : rows) {
            centers.add(getCenter(row));
        }
        return centers;
    }

    public void setCenter_external_id(Long center_external_id) {
        this.center_external_id = center_external_id;
    }

    public void setClub_count(Long club_count) {
        this.club_count = club_count;
    }

    public void setContacts(String contacts) {
        this.contacts = contacts;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

    public void setUrl_background_picture(String url_background_picture) {
        this.url_background_picture = url_background_picture;
    }

    public void setUrl_logo(String url_logo) {
        this.url_logo = url_logo;
    }

    public void setUrl_web(String url_web) {
        this.url_web = url_web;
    }

    public void setUser_id(Long user_id) {
        this.user_id = user_id;
    }

    public Long getCenter_external_id() {
        return center_external_id;
    }

    public Long getClub_count() {
        return club_count;
    }

    public String getContacts() {
        return contacts;
    }

    public String getDescription() {
        return description;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Double getRating() {
        return rating;
    }

    public String getUrl_background_picture() {
        return url_background_picture;
    }

    public String getUrl_logo() {
        return url_logo;
    }

    public String getUrl_web() {
        return url_web;
    }

    public Long getUser_id() {
        return user_id;
    }

    @Override
    public String toString() {
        return "CenterEntity{" +
                "id=" + id +
                ", center_external_id=" + center_external_id +
                ", club_count=" + club_count +
                ", contacts='" + contacts + '\'' +
                ", description='" + description + '\'' +
                ", name='" + name + '\'' +
                ", rating=" + rating +
                ", url_background_picture='" + url_background_picture + '\'' +
                ", url_logo='" + url_logo + '\'' +
                ", url_web='" + url_web + '\'' +
                ", user_id=" + user_id +
                '}';
    }
}
