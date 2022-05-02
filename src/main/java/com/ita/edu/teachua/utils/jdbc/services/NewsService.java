package com.ita.edu.teachua.utils.jdbc.services;

import com.ita.edu.teachua.utils.jdbc.dao.NewsDao;
import com.ita.edu.teachua.utils.jdbc.entity.NewsEntity;

import java.util.List;

public class NewsService {
    private final NewsDao newsDao;

    public NewsService() {
        this.newsDao = new NewsDao();
    }

    public List<NewsEntity> getAllNews() {
        return newsDao.selectAll();
    }
}