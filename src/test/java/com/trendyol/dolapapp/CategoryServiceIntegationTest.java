package com.trendyol.dolapapp;

import com.trendyol.dolapapp.converter.CategoryConverterImpl;
import com.trendyol.dolapapp.dto.CategoryDto;
import com.trendyol.dolapapp.model.Category;
import com.trendyol.dolapapp.repo.CategoryRepository;
import com.trendyol.dolapapp.service.impl.CategoryServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collections;
import java.util.List;

import static com.sun.javafx.fxml.expression.Expression.greaterThanOrEqualTo;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class CategoryServiceIntegationTest {

    @InjectMocks
    private CategoryServiceImpl categoryService;

    @Mock
    private CategoryRepository categoryRepository;

    @InjectMocks
    private CategoryConverterImpl categoryConverter;

    @Test
    public void testSave() {
        CategoryDto categoryDto = new CategoryDto();
        categoryDto.setName("Book1");
        categoryDto.setDescription("About Book");
        Category categoryMock = mock(Category.class);

        when(categoryMock.getId()).thenReturn(0L);
        when(categoryRepository.save(ArgumentMatchers.any(Category.class))).thenReturn(categoryMock);

        Category category = categoryService.save(categoryConverter.toEntity(categoryDto));

        assertEquals(category.getName(), categoryDto.getName());
    }

    @Test
    public void testGetAll() {
        Category category = new Category();
        category.setName("Book1");
        category.setDescription("About Book");
        when(categoryRepository.findAll()).thenReturn(Collections.singletonList(category));
        List<CategoryDto> categoryDtos = categoryConverter.toDto(categoryService.findAll());
        assertThat(greaterThanOrEqualTo(categoryDtos.size(), 0));
    }


}
