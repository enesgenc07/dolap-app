//package com.trendyol.dolapapp;
//
//import com.trendyol.dolapapp.converter.CategoryConverter;
//import com.trendyol.dolapapp.dto.ProductDto;
//import com.trendyol.dolapapp.manager.CategoryManager;
//import com.trendyol.dolapapp.manager.ProductManager;
//import com.trendyol.dolapapp.model.Category;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//
//import java.math.BigDecimal;
//
//import static com.sun.javafx.fxml.expression.Expression.greaterThanOrEqualTo;
//import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
//import static org.springframework.test.util.AssertionErrors.assertNotNull;
//import static org.springframework.test.util.AssertionErrors.assertTrue;
//
//@SpringBootTest
//public class ProductUnitTest {
//
//    @Autowired
//    private ProductManager productManager;
//
//    @Autowired
//    private CategoryManager categoryManager;
//
//    @Autowired
//    private CategoryConverter categoryConverter;
//
//    @Test
//    public void addProduct() throws Exception {
//        ProductDto productDto = new ProductDto();
//        productDto.setName("Tv");
//        productDto.setDescription("About tv");
//        productDto.setNote("used 1 months");
//        productDto.setPrice(new BigDecimal(2220));
//
//        String categoryName = "Book";
//        Category category = categoryManager.findByName(categoryName);
//        assertTrue("Category not found", category != null);
//
//        productDto.setCategory(categoryConverter.toDto(category));
//
//        assertNotNull("Product cant be null", productManager.addProduct(productDto));
//    }
//
//    @Test
//    public void getAllProducts() throws Exception {
//        assertThat(greaterThanOrEqualTo(productManager.getAllProducts().size(), 0));
//    }
//
//    @Test
//    public void findByName() throws Exception {
//        Long productId = 1L;
//        assertTrue("Category not found", productManager.getProduct(productId) != null);
//    }
//
//    @Test
//    public void deleteProduct() throws Exception {
//        Long productId = 1L;
//        ProductDto productDto = productManager.getProduct(productId);
//        assertTrue("Product not found", productDto != null);
//        productManager.deleteProduct(productDto.getId());
//    }
//
//    @Test
//    public void updateProduct() throws Exception {
//        Long productId = 1L;
//        ProductDto productDto = productManager.getProduct(productId);
//        assertTrue("Product not found", productDto != null);
//        ProductDto proDtoRequest = new ProductDto();
//
//        proDtoRequest.setName("Tv");
//        proDtoRequest.setDescription("About tv");
//        proDtoRequest.setNote("used 2 months");
//        proDtoRequest.setPrice(new BigDecimal(2220));
//
//        productDto.setName(proDtoRequest.getName());
//        productDto.setDescription(proDtoRequest.getDescription());
//        productDto.setNote(proDtoRequest.getNote());
//        productDto.setPrice(proDtoRequest.getPrice());
//
//        assertTrue("Product not found", productManager.updateProduct(productDto, productId) != null);
//
//    }
//
//
//}
