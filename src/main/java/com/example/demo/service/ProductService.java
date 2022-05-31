package com.example.demo.service;

import com.example.demo.dto.ProductDto;
import com.example.demo.dto.converters.ProductConverter;
import com.example.demo.entity.Product;
import com.example.demo.repo.ProductRepo;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    private final ProductRepo productRepo;
    private final ProductConverter converter;

    public ProductService(ProductRepo productRepo, ProductConverter converter) {
        this.productRepo = productRepo;
        this.converter = converter;
    }

    public ProductDto create(ProductDto productDto) {
        Product product = productRepo.save(converter.toProduct(productDto));
        return converter.toDto(productRepo.getById(product.getProductId()));
    }
}
