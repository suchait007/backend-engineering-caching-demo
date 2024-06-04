package com.backend.caching.service;


import com.backend.caching.dto.ProductDTO;
import com.backend.caching.jpa.ProductRepository;
import com.backend.caching.models.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@RequiredArgsConstructor
@Service
public class ProductService {


    private final ProductRepository productRepository;


    @Cacheable(cacheNames = "products", key = "#id")
    public Product getProductById(Long id) {
        return productRepository.findById(id).get();
    }


    @Cacheable(cacheNames = "products", key = "#name", condition = "#name.equals('electronics')")
    public Product getProductByName(String name) {
        return productRepository.findProductByName(name);
    }


    public List<Product> getAllProducts(List<Long> ids) {
        return productRepository.findAllById(ids);
    }

    
    public ProductDTO getProductDTO(Product product) {

        ProductDTO dto = new ProductDTO();
        dto.setId(product.getId());
        dto.setName(product.getName());
        dto.setDescription(product.getDescription());
        dto.setPrice(product.getPrice());

        return dto;

    }


}


