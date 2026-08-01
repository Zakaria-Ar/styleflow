package com.example.styleflow.controller;

import com.example.styleflow.entity.Product;
import com.example.styleflow.service.ProductService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController // @Controller + @ResponseBody → return values become JSON
@RequestMapping("/api") // base path prefix for every endpoint below
@CrossOrigin(origins = "http://localhost:4200")   // allow the Angular dev server
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) { // constructor injection
        this.productService = productService;
    }

    @GetMapping("/products") // GET /api/products → list all (200)
    public List<Product> getProducts() {
        return productService.getProducts();
    }

    @PostMapping("/products") // POST /api/products → create (201, or 400 if @Valid fails)
    public ResponseEntity<Product> addProduct(@Valid @RequestBody Product product) {
        // @Valid runs the field constraints BEFORE this body; invalid input never reaches here
        Product savedProduct = productService.addProduct(product);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedProduct); // 201 + saved product (with id)
    }

    @GetMapping("/products/{id}") // GET one (200, or 404 if missing)
    public ResponseEntity<Product> getProduct(@PathVariable Integer id) {
        return ResponseEntity.ok(productService.getProduct(id));
    }

    @DeleteMapping("/products/{id}") // DELETE (204, or 404 if missing)
    public ResponseEntity<Void> deleteProduct(@PathVariable Integer id) {
        productService.deleteProduct(id);
        return ResponseEntity.noContent().build(); // 204 No Content — success, empty body
    }
}