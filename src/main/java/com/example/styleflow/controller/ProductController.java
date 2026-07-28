package com.example.styleflow.controller;

import com.example.styleflow.entity.Product;
import com.example.styleflow.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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


}
