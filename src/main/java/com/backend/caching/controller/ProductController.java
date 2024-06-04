package com.backend.caching.controller;


import com.backend.caching.models.Product;
import com.backend.caching.service.ProductService;
import com.github.benmanes.caffeine.cache.Cache;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.CacheManager;
import org.springframework.cache.caffeine.CaffeineCache;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;



@Slf4j
@RequestMapping("/v1")
@RestController
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;
    private final CacheManager cacheManager;

    @GetMapping("/id")
    public Product getProductById(@RequestParam("id") Long id) {
        return productService.getProductById(id);
    }

    @GetMapping("/all")
    public List<Product> getAllProducts(@RequestParam("ids") List<Long> ids) {
        return productService.getAllProducts(ids);
    }

    @GetMapping("/name")
    public Product getProductByName(@RequestParam("name") String name) {
        return productService.getProductByName(name);
    }

    @GetMapping("/cache-all")
    public void getAllCacheProducts() {

        CaffeineCache caffeineCache = (CaffeineCache) cacheManager.getCache("products");
        Cache<Object, Object> currentCache = caffeineCache.getNativeCache();

        currentCache.asMap().entrySet().stream().forEach(entry -> {
            log.info("key : " + entry.getKey() + " value : " + entry.getValue());
        });
    }
}
