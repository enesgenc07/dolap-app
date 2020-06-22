package com.trendyol.dolapapp.manager;

import com.trendyol.dolapapp.converter.CategoryConverter;
import com.trendyol.dolapapp.converter.ProductConverter;
import com.trendyol.dolapapp.dto.ProductDto;
import com.trendyol.dolapapp.exception.NotFoundException;
import com.trendyol.dolapapp.model.Product;
import com.trendyol.dolapapp.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductManager {

    @Autowired
    private ProductConverter productConverter;

    @Autowired
    private ProductService productService;

    @Autowired
    private CategoryConverter categoryConverter;

    public ProductDto addProduct(ProductDto productDto) {
        if (productDto.getCategory() != null && productDto.getCategory().getId() > 0) {
            Product product = productService.save(productConverter.toEntity(productDto));
            return productConverter.toDto(product);
        } else {
            throw new NotFoundException("category");
        }
    }

    public ProductDto getProduct(long id) {
        Product product = productService.findById(id);
        return productConverter.toDto(product);
    }


    public Page<ProductDto> getAllProducts(Pageable pageable) {
        return productService.findAll(pageable).map(p -> productConverter.toDto(p));
    }

    public List<ProductDto> getAllProducts() {
        return productConverter.toDto(productService.findAll());
    }

    public void deleteProduct(Long id) {
        final Product product = productService.getProductById(id)
                .orElseThrow(() -> new NotFoundException("category"));
        productService.delete(product);
    }

    public ProductDto updateProduct(ProductDto product, Long id) {
        return productConverter.toDto(
                productService.getProductById(id)
                        .map(p -> {
                            p.setName(product.getName());
                            p.setDescription(product.getDescription());
                            p.setPrice(product.getPrice());
                            p.setCategory(categoryConverter.toEntity(product.getCategory()));
                            return productService.save(p);
                        }).orElseThrow(() -> new NotFoundException("product")));
    }

}
