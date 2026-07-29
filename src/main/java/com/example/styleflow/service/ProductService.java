package com.example.styleflow.service;

import com.example.styleflow.entity.Product;
import com.example.styleflow.exception.ProductNotFoundException;
import com.example.styleflow.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service // business-logic bean; plain @Component, no extra behaviour
public class ProductService {

    private final ProductRepository productRepository; // final: set once in constructor, never reassigned

    // constructor injection: Spring passes the repository bean in; testable, immutable, no half-built object
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getProducts() {
        return productRepository.findAll(); // inherited from JpaRepository — no implementation written
    }

    public Product addProduct(Product product) {
        return productRepository.save(product); // returns the persisted entity WITH its DB-generated id
    }

    public Product getProduct(Integer id) {
        // findById returns Optional<Product>; empty means "not found" → we decide that's a 404
        return productRepository.findById(id)
                .orElseThrow(() -> new ProductNotFoundException(id));
    }

    public void deleteProduct(Integer id) {
        Product product = getProduct(id); // reuse: throws 404 if missing, so no duplicate existence check
        productRepository.delete(product);
    }
}