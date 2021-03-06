package com.ita.edu.teachua.utils.jdbc.entity;

import java.util.ArrayList;
import java.util.List;

public class CenterEntity {
    public static final String SELECT_ALL = "SELECT * FROM centers ORDER BY id;";
    public static final String SELECT_ID_WHERE_NAME = "SELECT id FROM centers WHERE name = '%s';";
    public static final String SELECT_All_WHERE_NAME = "select * from public.centers where name = '%s'";
    public static final String SELECT_ID_NAME_ASC = "SELECT id, name FROM centers ORDER BY name ASC;";
    public static final String SELECT_ID_NAME_DESC = "SELECT id, name FROM centers ORDER BY name DESC;";
    public static final String SELECT_BY_RATING = "SELECT id, name, rating FROM centers ORDER BY rating ASC;";
    public static final String SELECT_BY_RATING_DESC = "SELECT id, name, rating FROM centers ORDER BY rating DESC;";

    private Long id;
    private Long centerExternalId;
    private Long clubCount;
    private String contacts;
    private String description;
    private String name;
    private Double rating;
    private String urlBackgroundPicture;
    private String urlLogo;
    private String urlWeb;
    private Long userId;

    public CenterEntity(Long centerExternalId, Long clubCount, String contacts, String description, Long id, String name, Double rating, String urlBackgroundPicture, String urlLogo, String urlWeb, Long userId) {
        this.centerExternalId = centerExternalId;
        this.clubCount = clubCount;
        this.contacts = contacts;
        this.description = description;
        this.id = id;
        this.name = name;
        this.rating = rating;
        this.urlBackgroundPicture = urlBackgroundPicture;
        this.urlLogo = urlLogo;
        this.urlWeb = urlWeb;
        this.userId = userId;
    }

    public CenterEntity() {
        this.centerExternalId = 0l;
        this.clubCount = 0l;
        this.contacts = null;
        this.description = null;
        this.id = 0l;
        this.name = null;
        this.rating = null;
        this.urlBackgroundPicture = null;
        this.urlLogo = null;
        this.urlWeb = null;
        this.userId = 0l;
    }

    public static CenterEntity getCenter(List<String> row) {
        CenterEntity center = new CenterEntity();
        center.setId(Long.parseLong(row.get(0)));
        if (row.get(1) != null) {
            center.setCenterExternalId(Long.parseLong(row.get(1)));
        }
        center.setContacts(row.get(2));
        center.setDescription(row.get(3));
        center.setName(row.get(4));
        center.setUrlBackgroundPicture(row.get(5));
        center.setUrlLogo(row.get(6));
        center.setUrlWeb(row.get(7));
        if (row.get(8) != null) {
            center.setUserId(Long.parseLong(row.get(8)));
        }
        if (row.get(9) != null) {
            center.setUserId(Long.parseLong(row.get(9)));
        }
        if (row.get(10) != null) {
            center.setRating(Double.parseDouble(row.get(10)));
        }
        return center;
    }

    public static List<CenterEntity> getCenters(List<List<String>> rows) {
        List<CenterEntity> centers = new ArrayList<>();
        for (List<String> row : rows) {
            centers.add(getCenter(row));
        }
        return centers;
    }

    public static CenterEntity getCenterName(List<String> row) {
        CenterEntity center = new CenterEntity();
        center.setId(Long.parseLong(row.get(0)));
        center.setName(row.get(1));

        return center;
    }

    public static List<CenterEntity> getCentersName(List<List<String>> rows) {
        List<CenterEntity> centers = new ArrayList<>();
        for (List<String> row : rows) {
            centers.add(getCenterName(row));
        }

        return centers;
    }

    public static CenterEntity getCenterByRating(List<String> row) {
        CenterEntity center = new CenterEntity();
        center.setId(Long.parseLong(row.get(0)));
        center.setName(row.get(1));
        if (row.get(2) != null) {
            center.setRating(Double.parseDouble(row.get(2)));
        }
        return center;
    }

    public static List<CenterEntity> getCentersByRating(List<List<String>> rows) {
        List<CenterEntity> centers = new ArrayList<>();
        for (List<String> row : rows) {
            centers.add(getCenterByRating(row));
        }
        return centers;
    }

    public Long getCenterExternalId() {
        return centerExternalId;
    }

    public void setCenterExternalId(Long centerExternalId) {
        this.centerExternalId = centerExternalId;
    }

    public Long getClubCount() {
        return clubCount;
    }

    public void setClubCount(Long clubCount) {
        this.clubCount = clubCount;
    }

    public String getContacts() {
        return contacts;
    }

    public void setContacts(String contacts) {
        this.contacts = contacts;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

    public String getUrlBackgroundPicture() {
        return urlBackgroundPicture;
    }

    public void setUrlBackgroundPicture(String urlBackgroundPicture) {
        this.urlBackgroundPicture = urlBackgroundPicture;
    }

    public String getUrlLogo() {
        return urlLogo;
    }

    public void setUrlLogo(String urlLogo) {
        this.urlLogo = urlLogo;
    }

    public String getUrlWeb() {
        return urlWeb;
    }

    public void setUrlWeb(String urlWeb) {
        this.urlWeb = urlWeb;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "CenterEntity{" +
                "id=" + id +
                ", centerExternalId=" + centerExternalId +
                ", clubCount=" + clubCount +
                ", contacts='" + contacts + '\'' +
                ", description='" + description + '\'' +
                ", name='" + name + '\'' +
                ", rating=" + rating +
                ", urlBackgroundPicture='" + urlBackgroundPicture + '\'' +
                ", urlLogo='" + urlLogo + '\'' +
                ", urlWeb='" + urlWeb + '\'' +
                ", userId=" + userId +
                '}';
    }
}
