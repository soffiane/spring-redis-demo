package com.boudissa.springredisdemo.service;

import com.boudissa.springredisdemo.model.Product;

import java.util.List;

public interface ProductService {
    List<Product> getAllProducts() throws InterruptedException;
}
