package com.trendyol.dolapapp.service.impl;

import com.trendyol.dolapapp.model.Product;
import com.trendyol.dolapapp.repo.ProductRepository;
import com.trendyol.dolapapp.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public Product save(Product product) {
        return productRepository.save(product);
    }

    @Override
    public Page<Product> findAll(Pageable page) {
        return productRepository.findAll(page);
    }

    @Override
    public List<Product> findAll() {
        return productRepository.findAll(Sort.by(Sort.Direction.DESC, "category"));
    }

    @Override
    public Product findById(long id) {
        return productRepository.findById(id).get();
    }

    @Override
    public void delete(Product product) {
        productRepository.deleteById(product.getId());
    }

    @Override
    public Optional<Product> getProductById(Long id) {
        return productRepository.findById(id);
    }


}
