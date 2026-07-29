package com.example.styleflow.service;

import com.example.styleflow.entity.Product;
import com.example.styleflow.exception.ProductNotFoundException;
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

    public Product addProduct(Product product) {
        return productRepository.save(product);   // save() returns the persisted entity, with its new id
    }

    public Product getProduct(int id) {
        return productRepository.findById(id)
                .orElseThrow(() -> new ProductNotFoundException(id));
    }

    public void deleteProduct(int id) {
        Product product = getProduct(id);   // already throws 404 if missing
        productRepository.delete(product);
    }
}
