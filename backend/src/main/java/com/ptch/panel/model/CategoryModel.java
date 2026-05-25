package com.ptch.panel.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="categories")
public class CategoryModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String category;

    // No argument constructors
    public CategoryModel(){
    }

    // All argument constructors for convenience
    public CategoryModel(String category){
        this.category=category;
    }

    // Getters and Setters
    public Long getId(){
        return id;
    }

    public String getCategory(){
        return category;
    }

    public void setCategory(String category){
        this.category=category;
    }

}
