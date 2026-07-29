package com.example.styleflow.service;

import com.example.styleflow.entity.Product;
import com.example.styleflow.repository.ProductRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

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

    public Product addProduct(Product product) {
        return productRepository.save(product);   // save() returns the persisted entity, with its new id
    }
}
