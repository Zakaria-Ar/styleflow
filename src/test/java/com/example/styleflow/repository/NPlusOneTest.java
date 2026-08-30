package com.example.styleflow.repository;

import com.example.styleflow.entity.Category;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.springframework.transaction.annotation.Transactional;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

import java.util.List;

@SpringBootTest
@Testcontainers
@Transactional
class NPlusOneTest {

    @Container
    static PostgreSQLContainer<?> postgres = new PostgreSQLContainer<>("postgres:16");

    @DynamicPropertySource
    static void props(DynamicPropertyRegistry registry) {
        registry.add("spring.datasource.url", postgres::getJdbcUrl);
        registry.add("spring.datasource.username", postgres::getUsername);
        registry.add("spring.datasource.password", postgres::getPassword);
    }

    @Autowired
    private CategoryRepository categoryRepository;

    @Test
    void demonstrateNPlusOne() {
        System.out.println("=== FETCHING CATEGORIES ===");
        List<Category> categories = categoryRepository.findAllWithProducts();

        System.out.println("=== ACCESSING PRODUCTS ===");
        for (Category category : categories) {
            int count = category.getProducts().size();
            System.out.println(category.getName() + " has " + count + " products");
        }
    }
}