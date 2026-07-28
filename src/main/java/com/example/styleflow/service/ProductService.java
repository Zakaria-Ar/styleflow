package com.example.styleflow.service;

import com.example.styleflow.entity.Product;
import com.example.styleflow.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service // business-logic bean; plain @Component, no extra behaviour
public class ProductService {
    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getProducts() {
        return productRepository.findAll();
    }
}
