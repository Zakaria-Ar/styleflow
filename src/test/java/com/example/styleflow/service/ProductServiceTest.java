package com.example.styleflow.service;

import com.example.styleflow.entity.Product;
import com.example.styleflow.exception.ProductNotFoundException;
import com.example.styleflow.repository.ProductRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

// Unit tests for ProductService, isolated from the database via a mocked repository.
@ExtendWith(MockitoExtension.class)
class ProductServiceTest {

    // Fake repository — its behaviour is defined per-test, so no real DB is touched.
    @Mock
    private ProductRepository productRepository;

    // Service under test, with the mock injected into its constructor.
    @InjectMocks
    private ProductService productService;

    @Test
    void shouldGetProductByIdSuccessfully() {
        // Given a product that the repository will return for id 1
        Product product = new Product(1, "si", "driss", BigDecimal.valueOf(10.0), 1, null);
        Mockito.when(productRepository.findById(1)).thenReturn(Optional.of(product));

        // When the product is requested
        Product result = productService.getProduct(1);

        // Then the same product is returned
        Assertions.assertNotNull(result);
        Assertions.assertEquals(product, result);
        Assertions.assertEquals(1, result.getId());
    }

    @Test
    void shouldThrowWhenProductNotFound() {
        // Given the repository finds nothing for id 67
        Mockito.when(productRepository.findById(67)).thenReturn(Optional.empty());

        // When/Then requesting it raises ProductNotFoundException
        Assertions.assertThrows(ProductNotFoundException.class, () -> productService.getProduct(67));
    }


    @Test
    void shouldIncludeIdInExceptionMessage() {
        // Given a missing product
        Mockito.when(productRepository.findById(67)).thenReturn(Optional.empty());

        // When the exception is thrown, its message names the missing id
        ProductNotFoundException ex = Assertions.assertThrows(
                ProductNotFoundException.class,
                () -> productService.getProduct(67));
        Assertions.assertEquals("Product not found with id: 67", ex.getMessage());
    }

    @Test
    void shouldCallRepositoryFindByIdExactlyOnce() {
        // Given an existing product
        Product product = new Product(1, "si", "driss", BigDecimal.valueOf(10.0), 1, null);
        Mockito.when(productRepository.findById(1)).thenReturn(Optional.of(product));

        // When the service runs
        productService.getProduct(1);

        // Then it delegates to the repository exactly once (guards against redundant DB calls)
        Mockito.verify(productRepository, Mockito.times(1)).findById(1);
    }

    @Test
    void shouldReturnAllProducts() {
        // Given the repo returns a list of two products
        List<Product> products = List.of(
                new Product(1, "Shirt", "desc", BigDecimal.valueOf(200.0), 5, null),
                new Product(2, "Jeans", "desc", BigDecimal.valueOf(350.0), 3, null)
        );
        Mockito.when(productRepository.findAll()).thenReturn(products);

        // When getProducts is called
        List<Product> result = productService.getProducts();

        // Then it returns the repo's list
        Assertions.assertEquals(2, result.size());
        Assertions.assertEquals(products, result);
    }

    @Test
    void shouldAddProduct() {
        // Given a product the repo will save and return
        Product product = new Product(null, "Shirt", "desc", BigDecimal.valueOf(200.0), 5, null);
        Product saved = new Product(1, "Shirt", "desc", BigDecimal.valueOf(200.0), 5, null);
        Mockito.when(productRepository.save(product)).thenReturn(saved);

        // When addProduct is called
        Product result = productService.addProduct(product);

        // Then it returns the saved product with its id
        Assertions.assertEquals(1, result.getId());
        Assertions.assertEquals("Shirt", result.getName());
    }

    @Test
    void shouldDeleteProduct() {
        // Given an existing product
        Product product = new Product(1, "Shirt", "desc", BigDecimal.valueOf(200.0), 5, null);
        Mockito.when(productRepository.findById(1)).thenReturn(Optional.of(product));

        // When deleteProduct is called
        productService.deleteProduct(1);

        // Then the repo's delete is called with that product
        Mockito.verify(productRepository).delete(product);
    }

    @Test
    void shouldThrowWhenDeletingMissingProduct() {
        // Given the product does not exist
        Mockito.when(productRepository.findById(999)).thenReturn(Optional.empty());

        // When/Then deleting it throws ProductNotFoundException
        Assertions.assertThrows(ProductNotFoundException.class,
                () -> productService.deleteProduct(999));

        // And delete is never called (nothing to delete)
        Mockito.verify(productRepository, Mockito.never()).delete(Mockito.any());
    }
}