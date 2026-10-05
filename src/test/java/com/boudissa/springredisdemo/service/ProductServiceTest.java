package com.boudissa.springredisdemo.service;

import com.boudissa.springredisdemo.model.Product;
import com.boudissa.springredisdemo.repository.ProductRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyList;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ProductServiceTest {

    @Mock
    private ProductRepository productRepository;

    @InjectMocks
    private ProductServiceImpl productService;

    private List<Product> sampleProducts;

    @BeforeEach
    void setUp() {
        sampleProducts = List.of(
                new Product(1L, "Laptop", 1200),
                new Product(2L, "Phone", 800),
                new Product(3L, "Tablet", 600)
        );
    }

    @Test
    void getAllProducts_WhenRepoIsEmpty_ShouldSeedAndReturnProducts() throws InterruptedException {
        // Arrange
        when(productRepository.count()).thenReturn(0L);
        when(productRepository.findAll()).thenReturn(sampleProducts);

        // Act
        List<Product> result = productService.getAllProducts();

        // Assert
        verify(productRepository, times(1)).count();
        verify(productRepository, times(1)).saveAll(anyList());
        verify(productRepository, times(1)).findAll();
        assertEquals(3, result.size());
        assertEquals("Laptop", result.getFirst().getName());
    }

    @Test
    void getAllProducts_WhenRepoNotEmpty_ShouldReturnProductsWithoutSeeding() throws InterruptedException {
        // Arrange
        when(productRepository.count()).thenReturn(3L);
        when(productRepository.findAll()).thenReturn(sampleProducts);

        // Act
        List<Product> result = productService.getAllProducts();

        // Assert
        verify(productRepository, times(1)).count();
        verify(productRepository, never()).saveAll(anyList());
        verify(productRepository, times(1)).findAll();
        assertEquals(3, result.size());
    }
}
