package com.example.styleflow.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;

@Entity // maps this class to a DB table (one row per instance) — NOT a bean
public class Product {
    @Id // marks the primary key field
    @GeneratedValue(strategy = GenerationType.IDENTITY) // DB generates the key value on insert (IDENTITY = auto-increment)
    private Integer id;
    @NotBlank
    private String name;
    private String description;
    @Positive
    private Double price;
    @Positive
    private Integer stockQuantity;
    private String category;

    public Product() {}

    public Product(Integer id, String name, String description, Double price, Integer stockQuantity, String category) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.stockQuantity = stockQuantity;
        this.category = category;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public Double getPrice() {
        return price;
    }
    public void setPrice(Double price) {
        this.price = price;
    }
    public Integer getStockQuantity() {
        return stockQuantity;
    }
    public void setStockQuantity(Integer stockQuantity) {
        this.stockQuantity = stockQuantity;
    }
    public String getCategory() {
        return category;
    }
    public void setCategory(String category) {
        this.category = category;
    }
}
