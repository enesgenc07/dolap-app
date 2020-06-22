package com.trendyol.dolapapp.controller;

import com.trendyol.dolapapp.dto.CategoryDto;
import com.trendyol.dolapapp.exception.ResourceAlreadyHaveException;
import com.trendyol.dolapapp.manager.CategoryManager;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/categories")
@Api(value = "Category APIs")
public class CategoryController {

    @Autowired
    private CategoryManager categoryManager;

    @PostMapping("/save")
    @PreAuthorize("hasRole('ROLE_USER') or hasRole('ROLE_ADMIN')")
    public ResponseEntity<?> save(@Valid @RequestBody CategoryDto categoryDto) {

        if (Optional.ofNullable(categoryManager.findByName(categoryDto.getName())).isPresent())
            throw new ResourceAlreadyHaveException("Category name already have: " + categoryDto.getName());

        categoryManager.addCategory(categoryDto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }


    @GetMapping("/list")
    @PreAuthorize("hasRole('ROLE_USER') or hasRole('ROLE_ADMIN')")
    @ApiOperation(value = "Get Category List Operation", response = CategoryDto.class)
    public ResponseEntity<?> retriveAllCategories() {
        return new ResponseEntity<>(categoryManager.getAllCategory(), HttpStatus.OK);
    }

}
