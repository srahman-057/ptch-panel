package com.ptch.panel.service;

import com.ptch.panel.model.CategoryModel;
import com.ptch.panel.repository.CategoryRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {
    private final CategoryRepository categoryRepository;

    @Autowired
    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public List<CategoryModel> getAllCategories(){
        return categoryRepository.findAll();
    }

    public Optional<CategoryModel> getCategoryById(Long id){
        return categoryRepository.findById(id);
    }

    public CategoryModel createCategory(CategoryModel category){
        return categoryRepository.save(category);
    }

    public void deleteCategory(Long id){
        if(categoryRepository.existsById(id)){
            categoryRepository.deleteById(id);
        }
        else{
            throw new RuntimeException("Category not found with id: " + id);
        }
    }
}
