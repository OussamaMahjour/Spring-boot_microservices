package com.oussama.microservices.orders.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.oussama.microservices.orders.module.Order;

/**
 * OrderRepository
 */
public interface OrderRepository extends JpaRepository<Order, Long> {

}
