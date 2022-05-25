package com.ita.edu.teachua.utils.jdbc.entity;

import java.util.ArrayList;
import java.util.List;

public class AboutUsItemsEntity {
    public static final String SELECT_ALL = "SELECT * FROM about_us_items ORDER BY id;";

    private Long id;
    private Long number;
    private String picture;
    private String text;
    private Long type;
    private String video;

    public AboutUsItemsEntity(Long id, Long number, String picture, String text, Long type, String video) {
        this.id = id;
        this.number = number;
        this.picture = picture;
        this.text = text;
        this.type = type;
        this.video = video;
    }

    public AboutUsItemsEntity() {
        this.id = 0L;
        this.number = 0L;
        this.picture = null;
        this.text = null;
        this.type = 0L;
        this.video = null;
    }

    public static AboutUsItemsEntity getAboutUsItem(List<String> row) {
        AboutUsItemsEntity aboutUsItem = new AboutUsItemsEntity();
        aboutUsItem.setId(Long.parseLong(row.get(0)));
        aboutUsItem.setNumber(Long.parseLong(row.get(1)));
        if (row.get(2) != null) {
            aboutUsItem.setPicture(row.get(2));
        }
        if (row.get(3) != null) {
            aboutUsItem.setText(row.get(3));
        }
        aboutUsItem.setType(Long.parseLong(row.get(4)));
        if (row.get(5) != null) {
            aboutUsItem.setVideo(row.get(5));
        }

        return aboutUsItem;
    }

    public static List<AboutUsItemsEntity> getAboutUsItems(List<List<String>> rows) {
        List<AboutUsItemsEntity> aboutUsItems = new ArrayList<>();
        for (List<String> row : rows) {
            aboutUsItems.add(getAboutUsItem(row));
        }
        return aboutUsItems;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getNumber() {
        return number;
    }

    public void setNumber(Long number) {
        this.number = number;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Long getType() {
        return type;
    }

    public void setType(Long type) {
        this.type = type;
    }

    public String getVideo() {
        return video;
    }

    public void setVideo(String video) {
        this.video = video;
    }

    @Override
    public String toString() {
        return "AboutUsItemsEntity{" +
                "id=" + id +
                ", number=" + number +
                ", picture='" + picture + '\'' +
                ", text='" + text + '\'' +
                ", type=" + type +
                ", video='" + video + '\'' +
                '}';
    }
}
