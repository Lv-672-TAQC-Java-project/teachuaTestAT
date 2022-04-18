package com.ita.edu.teachua.utils.jdbc.entity;

import java.util.ArrayList;
import java.util.List;

public class NewsEntity {
    public static final String SELECT_ALL = "SELECT * FROM news ORDER BY id;";

    private String date;
    private String description;
    private Long id;
    private Boolean isActive;
    private String title;
    private String urlTitleLogo;
    private Integer userId;

    public NewsEntity(String date, String description, Long id, Boolean isActive, String title, String urlTitleLogo, Integer userId) {
        this.date = date;
        this.description = description;
        this.id = id;
        this.isActive = isActive;
        this.title = title;
        this.urlTitleLogo = urlTitleLogo;
        this.userId = userId;
    }

    public NewsEntity() {
        this.date = null;
        this.description = null;
        this.id = 0L;
        this.isActive = null;
        this.title = null;
        this.urlTitleLogo = null;
        this.userId = 0;
    }

    public static NewsEntity getNewsItem(List<String> row) {
        NewsEntity newsItem = new NewsEntity();
        newsItem.setId(Long.parseLong(row.get(0)));
        newsItem.setDate(row.get(1));
        newsItem.setDescription(row.get(2));
        newsItem.setIsActive(row.get(3) == "t");
        newsItem.setTitle(row.get(4));
        newsItem.setUrlTitleLogo(row.get(5));
        newsItem.setUserId(Integer.parseInt(row.get(6)));

        return newsItem;
    }

    public static List<NewsEntity> getNews(List<List<String>> rows) {
        List<NewsEntity> news = new ArrayList<>();
        for (List<String> row : rows) {
            news.add(getNewsItem(row));
        }
        return news;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
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

    public Boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(Boolean active) {
        isActive = active;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrlTitleLogo() {
        return urlTitleLogo;
    }

    public void setUrlTitleLogo(String urlTitleLogo) {
        this.urlTitleLogo = urlTitleLogo;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", date='" + date + '\'' +
                ", description='" + description + '\'' +
                ", isActive=" + isActive +
                ", title='" + title + '\'' +
                ", urlTitleLogo='" + urlTitleLogo + '\'' +
                ", userId=" + userId +
                '}';
    }
}
