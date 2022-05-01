package com.ita.edu.teachua.utils.jdbc.entity;

import java.util.ArrayList;
import java.util.List;

public class GalleriesEntity {

    public static final String SELECT_ALL = "SELECT * FROM galleries ORDER BY id;";

    private Long id;
    private String url;
    private Long clubId;

    public GalleriesEntity(Long id, String url, Long clubId) {
        this.id = id;
        this.url = url;
        this.clubId = clubId;
    }

    public GalleriesEntity() {
        this.id = 0L;
        this.url = null;
        this.clubId = 0L;
    }

    public static GalleriesEntity getGallery(List<String> row) {
        GalleriesEntity gallery = new GalleriesEntity();
        gallery.setId(Long.parseLong(row.get(0)));
        if (row.get(1) != null) {
            gallery.setUrl(row.get(1));
        }
        gallery.setClubId(Long.parseLong(row.get(2)));

        return gallery;
    }

    public static List<GalleriesEntity> getGalleries(List<List<String>> rows) {
        List<GalleriesEntity> galleries = new ArrayList<>();
        for (List<String> row : rows) {
            galleries.add(getGallery(row));
        }
        return galleries;
    }

    public Long getClubId() {
        return clubId;
    }

    public void setClubId(Long clubId) {
        this.clubId = clubId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "GalleriesEntity{" +
                "clubId=" + clubId +
                ", id=" + id +
                ", url='" + url + '\'' +
                '}';
    }
}
