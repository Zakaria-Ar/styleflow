package com.example.styleflow.repository;

import com.example.styleflow.IntegrationTestBase;
import com.example.styleflow.entity.Category;
import com.example.styleflow.repository.CategoryRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@SpringBootTest
@Transactional   // keeps the session open so lazy loading works inside the test
class NPlusOneTest extends IntegrationTestBase {

    @Autowired
    private CategoryRepository categoryRepository;

    @Test
    void demonstrateNPlusOne() {
        System.out.println("=== FETCHING CATEGORIES ===");
        List<Category> categories = categoryRepository.findAllWithProducts();   // was findAll()

        System.out.println("=== ACCESSING PRODUCTS (watch the queries) ===");
        for (Category category : categories) {
            // accessing getProducts() triggers a LAZY load — 1 query PER category
            int count = category.getProducts().size();
            System.out.println(category.getName() + " has " + count + " products");
        }
    }
}