package com.ita.edu.teachua.utils.jdbc.entity;

import java.util.ArrayList;
import java.util.List;

public class GalleriesEntity {

    public static final String SELECT_ALL = "SELECT * FROM galleries ORDER BY id;";

    private Long clubId;
    private Long id;
    private String url;

    public GalleriesEntity(Long clubId, Long id, String url) {
        this.clubId = clubId;
        this.id = id;
        this.url = url;
    }

    public GalleriesEntity() {
        this.clubId = 0L;
        this.id = 0L;
        this.url = null;
    }

    public static GalleriesEntity getGallery(List<String> row) {
        GalleriesEntity gallery = new GalleriesEntity();
        gallery.setId(Long.parseLong(row.get(0)));
        gallery.setUrl(row.get(1));
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
