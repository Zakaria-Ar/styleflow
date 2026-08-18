package com.example.styleflow.repository;

import com.example.styleflow.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CategoryRepository extends JpaRepository<Category, Integer> {

    @Query("SELECT DISTINCT c FROM Category c JOIN FETCH c.products")
    List<Category> findAllWithProducts();
}