package com.example.demo.dto.converters;

import com.example.demo.dto.ProductDto;
import com.example.demo.entity.Product;
import org.springframework.stereotype.Component;

@Component
public class ProductConverter {

    public Product toProduct(ProductDto productDto) {
        Product product = new Product();
        product.setProductId(productDto.getProductId());
        product.setProductTitle(productDto.getProductTitle());
        product.setPrice(productDto.getPrice());
        return product;
    }

    public ProductDto toDto(Product product) {
        ProductDto productDto = new ProductDto();
        productDto.setProductId(product.getProductId());
        productDto.setProductTitle(product.getProductTitle());
        productDto.setPrice(product.getPrice());
        return productDto;
    }
}
