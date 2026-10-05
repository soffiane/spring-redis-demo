package com.boudissa.springredisdemo.controller;

import com.boudissa.springredisdemo.model.Product;
import com.boudissa.springredisdemo.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/products")
@AllArgsConstructor
public class ProductController {

    private final ProductService productService;

    @GetMapping
    public List<Product> getAllProducts() throws InterruptedException {
        return productService.getAllProducts();
    }
}
