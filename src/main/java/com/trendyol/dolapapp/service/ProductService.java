package com.trendyol.dolapapp.service;

import com.trendyol.dolapapp.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface ProductService {

    Product save(Product product);

    Page<Product> findAll(Pageable page);

    List<Product> findAll();

    Product findById(long id);

    void delete(Product product);

    Optional<Product> getProductById(Long id);
}
