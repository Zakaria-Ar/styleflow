package com.example.styleflow.exception;

// extends RuntimeException → unchecked, so no 'throws' needed anywhere it's thrown
public class ProductNotFoundException extends RuntimeException {
    public ProductNotFoundException(Integer id) {
        super("Product not found with id: " + id); // message surfaced in the 404 response body
    }
}