package com.trendyol.dolapapp.service;

import com.trendyol.dolapapp.model.Category;

import java.util.List;

public interface CategoryService {
    Category findByName(String categoryName);

    Category save(Category save);

    List<Category> findAll();
}
