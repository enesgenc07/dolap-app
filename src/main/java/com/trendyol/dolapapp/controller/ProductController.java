package com.trendyol.dolapapp.controller;

import com.trendyol.dolapapp.dto.ProductDto;
import com.trendyol.dolapapp.manager.ProductManager;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/products")
@Api(value = "Product APIs")
@CrossOrigin(origins = "*", maxAge = 3600)
public class ProductController {

    @Autowired
    private ProductManager productManager;

    @ApiOperation(value = "Save Product Operation", response = ProductDto.class)
    @PostMapping("/save")
    @PreAuthorize("hasRole('ROLE_USER') or hasRole('ROLE_ADMIN')")
    public ResponseEntity<ProductDto> save(@Valid @RequestBody ProductDto productDto) {
        return new ResponseEntity<>(productManager.addProduct(productDto), HttpStatus.CREATED);
    }

    @GetMapping("/pagination-list")
    @PreAuthorize("hasRole('ROLE_USER') or hasRole('ROLE_ADMIN')")
    @ApiOperation(value = "Get Product List Operation", response = ProductDto.class)
    public ResponseEntity<?> retrieveAllProductsWithPagination(Pageable pageable) {
        Page<ProductDto> productDtos = productManager.getAllProducts(pageable);
        return new ResponseEntity<>(productDtos, HttpStatus.OK);
    }

    @GetMapping("/list")
    @PreAuthorize("hasRole('ROLE_USER') or hasRole('ROLE_ADMIN')")
    @ApiOperation(value = "Get Product List Operation", response = ProductDto.class)
    public ResponseEntity<?> retrieveAllProducts() {
        return new ResponseEntity<>(productManager.getAllProducts(), HttpStatus.OK);
    }


    @DeleteMapping("/delete/{id}")
    @PreAuthorize("hasRole('ROLE_USER') or hasRole('ROLE_ADMIN')")
    @ApiOperation(value = "Product Delete Operation", response = ProductDto.class)
    public ResponseEntity<HttpStatus> delete(@PathVariable("id") Long id) {
        productManager.deleteProduct(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/update/{id}")
    @PreAuthorize("hasRole('ROLE_USER') or hasRole('ROLE_ADMIN')")
    @ApiOperation(value = "Product Update Operation")
    public ResponseEntity<ProductDto> update(@PathVariable("id") long id, @RequestBody ProductDto productDto) {
        return new ResponseEntity<>(productManager.updateProduct(productDto, id), HttpStatus.OK);
    }

    @GetMapping("/get/{id}")
    @PreAuthorize("hasRole('ROLE_USER') or hasRole('ROLE_ADMIN')")
    @ApiOperation(value = "Get Product Operation", response = ProductDto.class)
    public ResponseEntity<?> getProductById(@PathVariable("id") long id) {
        ProductDto productDto = productManager.getProduct(id);
        return new ResponseEntity<>(productDto, HttpStatus.OK);
    }


}
