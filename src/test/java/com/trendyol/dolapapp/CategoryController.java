package com.trendyol.dolapapp;

import com.trendyol.dolapapp.dto.CategoryDto;
import com.trendyol.dolapapp.manager.CategoryManager;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static com.sun.javafx.fxml.expression.Expression.greaterThanOrEqualTo;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.springframework.test.util.AssertionErrors.assertNotNull;
import static org.springframework.test.util.AssertionErrors.assertTrue;

@SpringBootTest
public class CategoryController {

    @Autowired
    private CategoryManager categoryManager;

    @Test
    public void addCategory() throws Exception {
        CategoryDto category = new CategoryDto();
        category.setName("Book");
        category.setDescription("About Book");
        assertNotNull("Category cant be null", categoryManager.addCategory(category));
    }

    @Test
    public void getAllCategory() throws Exception {
        assertThat(greaterThanOrEqualTo(categoryManager.getAllCategory().size(), 0));
    }

    @Test
    public void findByName() throws Exception {
        String categoryName = "Book";
        assertTrue("Category not found", categoryManager.findByName(categoryName) != null);
    }

}
