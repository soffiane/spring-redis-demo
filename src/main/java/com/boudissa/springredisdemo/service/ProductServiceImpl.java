package com.boudissa.springredisdemo.service;

import com.boudissa.springredisdemo.model.Product;
import com.boudissa.springredisdemo.repository.ProductRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public List<Product> getAllProducts() throws InterruptedException {
        // Save products if they don't exist
        if (productRepository.count() == 0) {
            log.info("Loading products into Redis repository");
            Thread.sleep(3000);
            List<Product> products = List.of(
                    new Product(1L, "Laptop", 1200),
                    new Product(2L, "Phone", 800),
                    new Product(3L, "Tablet", 600)
            );
            productRepository.saveAll(products);
        }

        log.info("Fetching products from Redis repository");
        return (List<Product>) productRepository.findAll();
    }
}
