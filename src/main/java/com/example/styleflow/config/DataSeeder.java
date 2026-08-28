package com.example.styleflow.config;

import com.example.styleflow.entity.Category;
import com.example.styleflow.entity.Product;
import com.example.styleflow.repository.CategoryRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class DataSeeder implements CommandLineRunner {

    private final CategoryRepository categoryRepository;

    public DataSeeder(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public void run(String... args) {
        // create 5 categories, each with 3 products
        String[] categoryNames = {"Tops", "Bottoms", "Footwear", "Outerwear", "Accessories"};

        for (String catName : categoryNames) {
            Category category = new Category(catName);

            for (int i = 1; i <= 3; i++) {
                Product product = new Product();
                product.setName(catName + " item " + i);
                product.setDescription("A " + catName + " product");
                product.setPrice(BigDecimal.valueOf(100.0 * i));
                product.setStockQuantity(10 * i);
                product.setCategory(category);           // link product → category
                category.getProducts().add(product);     // link category → product
            }

            categoryRepository.save(category);   // cascade saves the products too
        }
    }
}