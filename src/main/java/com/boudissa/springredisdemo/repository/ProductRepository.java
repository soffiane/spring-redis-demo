package com.boudissa.springredisdemo.repository;

import com.boudissa.springredisdemo.model.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<Product, Long> {
}
