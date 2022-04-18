package com.ita.edu.teachua.utils.jdbc.services;

import com.ita.edu.teachua.utils.jdbc.dao.CategoryDao;
import com.ita.edu.teachua.utils.jdbc.entity.CategoryEntity;

import java.util.List;

public class CategoryService {
    public final CategoryDao categoryDao;

    public CategoryService() {
        this.categoryDao = new CategoryDao();
    }

    public List<CategoryEntity> getAllCategories() {
        return categoryDao.selectAll();
    }
}
