package com.example.styleflow.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;

import java.math.BigDecimal;

@Entity // maps this class to a DB table (one row per instance) — NOT a Spring bean
public class Product {

    @Id // primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY) // DB auto-increments on insert; never set manually
    private Integer id;

    @NotBlank // rejected at 400 by @Valid if blank or null — before it reaches the DB
    private String name;

    private String description;

    @Positive // must be > 0
    private BigDecimal price;

    @Positive
    private Integer stockQuantity;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id")
    private Category category;

    public Product() {} // no-arg constructor required by JPA/Hibernate to build entities

    public Product(Integer id, String name, String description, BigDecimal price, Integer stockQuantity, Category category) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.stockQuantity = stockQuantity;
        this.category = category;
    }

    // getters/setters — required so Jackson can serialize to JSON and Hibernate can populate fields
    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    public BigDecimal getPrice() { return price; }
    public void setPrice(BigDecimal price) { this.price = price; }
    public Integer getStockQuantity() { return stockQuantity; }
    public void setStockQuantity(Integer stockQuantity) { this.stockQuantity = stockQuantity; }
    public Category getCategory() { return category; }
    public void setCategory(Category category) { this.category = category; }
}