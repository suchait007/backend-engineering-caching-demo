package com.backend.caching.jpa;

import com.backend.caching.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {

    Product findProductByName(String name);

}
