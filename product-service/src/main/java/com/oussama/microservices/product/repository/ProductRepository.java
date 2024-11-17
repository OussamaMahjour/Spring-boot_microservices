package com.oussama.microservices.product.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.oussama.microservices.product.module.Product;

/**
 * ProductRepository
 */

public interface ProductRepository extends MongoRepository<Product, String> {

}
