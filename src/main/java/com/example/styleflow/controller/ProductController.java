package com.example.styleflow.controller;

import com.example.styleflow.entity.Product;
import com.example.styleflow.service.ProductService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController // @Controller + @ResponseBody → returns become JSON
@RequestMapping("/api") // base path for every endpoint in this controller
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/products") // maps HTTP GET (retrieve) to this method
    public List<Product> getProducts()  {
        return productService.getProducts();
    }


    @PostMapping("/products")
    public ResponseEntity<Product> addProduct(@Valid @RequestBody Product product) {
        Product product1 = productService.addProduct(product);
        return ResponseEntity.status(HttpStatus.CREATED).body(product1);
    }

    @GetMapping("/products/{id}")
    public ResponseEntity<Product> getProduct(@PathVariable int id) {
        return ResponseEntity.ok(productService.getProduct(id));
    }

}
