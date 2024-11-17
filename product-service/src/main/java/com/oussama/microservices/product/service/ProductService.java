package com.oussama.microservices.product.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.oussama.microservices.product.DTO.ProductRequest;
import com.oussama.microservices.product.DTO.ProductResponse;
import com.oussama.microservices.product.module.Product;
import com.oussama.microservices.product.repository.ProductRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductService {
    private final ProductRepository productRepository;

    public ProductResponse creatProduct(ProductRequest productRequest) {
        Product product = Product.builder()
                .name(productRequest.name())
                .description(productRequest.description())
                .price(productRequest.price())
                .build();
        productRepository.save(product);
        log.info("Product create Successfully");
        return new ProductResponse(product.getId(), product.getName(), product.getDescription(), product.getPrice());
    }

    public List<ProductResponse> getAllProducts() {
        return productRepository.findAll().stream().map(
                product -> new ProductResponse(product.getId(), product.getName(), product.getDescription(),
                        product.getPrice()))
                .toList();
    }
}