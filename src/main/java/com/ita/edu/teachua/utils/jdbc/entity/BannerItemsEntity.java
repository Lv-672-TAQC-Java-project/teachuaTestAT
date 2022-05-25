package com.ita.edu.teachua.utils.jdbc.entity;

import java.util.ArrayList;
import java.util.List;

public class BannerItemsEntity {
    public static final String SELECT_ALL = "SELECT * FROM banner_items ORDER BY id;";

    private Long id;
    private String link;
    private String picture;
    private Integer sequenceNumber;
    private String subtitle;
    private String title;

    public BannerItemsEntity(Long id, String link, String picture, Integer sequenceNumber, String subtitle, String title) {
        this.id = id;
        this.link = link;
        this.picture = picture;
        this.sequenceNumber = sequenceNumber;
        this.subtitle = subtitle;
        this.title = title;
    }

    public BannerItemsEntity() {
        this.id = 0L;
        this.link = null;
        this.picture = null;
        this.sequenceNumber = 0;
        this.subtitle = null;
        this.title = null;
    }

    public static BannerItemsEntity getBannerItem(List<String> row) {
        BannerItemsEntity bannerItem = new BannerItemsEntity();
        bannerItem.setId(Long.parseLong(row.get(0)));
        bannerItem.setLink(row.get(1));
        bannerItem.setPicture(row.get(2));
        bannerItem.setSequenceNumber(Integer.parseInt(row.get(3)));
        bannerItem.setSubtitle(row.get(4));
        bannerItem.setTitle(row.get(5));

        return bannerItem;
    }

    public static List<BannerItemsEntity> getBannerItems(List<List<String>> rows) {
        List<BannerItemsEntity> bannerItems = new ArrayList<>();
        for (List<String> row : rows) {
            bannerItems.add(getBannerItem(row));
        }
        return bannerItems;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public Integer getSequenceNumber() {
        return sequenceNumber;
    }

    public void setSequenceNumber(Integer sequenceNumber) {
        this.sequenceNumber = sequenceNumber;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "BannerItemsEntity{" +
                "id=" + id +
                ", link='" + link + '\'' +
                ", picture='" + picture + '\'' +
                ", sequenceNumber=" + sequenceNumber +
                ", subtitle='" + subtitle + '\'' +
                ", title='" + title + '\'' +
                '}';
    }
}
