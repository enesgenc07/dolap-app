package com.trendyol.dolapapp.manager;

import com.trendyol.dolapapp.converter.CategoryConverter;
import com.trendyol.dolapapp.dto.CategoryDto;
import com.trendyol.dolapapp.model.Category;
import com.trendyol.dolapapp.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryManager {

    @Autowired
    private CategoryConverter categoryConverter;

    @Autowired
    private CategoryService categoryService;

    public CategoryDto addCategory(CategoryDto categoryDto) {
        Category category = categoryService.save(categoryConverter.toEntity(categoryDto));
        return categoryConverter.toDto(category);
    }

    public Category findByName(String categoryName) {
        return categoryService.findByName(categoryName);
    }


    public List<CategoryDto> getAllProducts() {
        return categoryConverter.toDto(categoryService.findAll());
    }
}
