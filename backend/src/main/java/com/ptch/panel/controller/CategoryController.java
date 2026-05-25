package com.ptch.panel.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.ptch.panel.model.CategoryModel;
import com.ptch.panel.service.CategoryService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @GetMapping
    public List<CategoryModel> getAllCategories(){
        return categoryService.getAllCategories();
    }

    @GetMapping("/{id}")
    public ResponseEntity<CategoryModel> getBookById(@PathVariable Long id){
        Optional<CategoryModel> category = categoryService.getCategoryById(id);
        return category.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public CategoryModel createCategory(@RequestBody CategoryModel category){
        return categoryService.createCategory(category);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCategory(@PathVariable Long id){
        categoryService.deleteCategory(id);
        return ResponseEntity.noContent().build();
    }
}
