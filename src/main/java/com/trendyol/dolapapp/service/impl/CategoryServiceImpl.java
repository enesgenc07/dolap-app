package com.trendyol.dolapapp.service.impl;

import com.trendyol.dolapapp.model.Category;
import com.trendyol.dolapapp.repo.CategoryRepository;
import com.trendyol.dolapapp.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public Category findByName(String categoryName) {
        return categoryRepository.findByName(categoryName);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public Category save(Category categoryDto) {
        return categoryRepository.save(categoryDto);
    }

    @Override
    public List<Category> findAll() {
        return categoryRepository.findAll();
    }
}
