package com.oussama.microservices.orders.service;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.oussama.microservices.orders.dto.OrderRequest;
import com.oussama.microservices.orders.dto.OrderResponse;
import com.oussama.microservices.orders.module.Order;
import com.oussama.microservices.orders.repository.OrderRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * OrderService
 */
@Service
@RequiredArgsConstructor
@Slf4j
public class OrderService {
	public final OrderRepository orderRepository;

	public void placeOrder(OrderRequest orderRequest) {
		Order order = Order.builder()
				.orderNumber(UUID.randomUUID().toString())
				.price(orderRequest.price())
				.skuCode(orderRequest.skuCode())
				.quantity(orderRequest.quantity())
				.build();
		orderRepository.save(order);
		log.info("Order Placed Succefully");
	}

	public List<OrderResponse> getAllOrders() {
		return orderRepository.findAll()
				.stream()
				.map(order -> new OrderResponse(
						order.getId(),
						order.getOrderNumber(),
						order.getSkuCode(),
						order.getPrice(),
						order.getQuantity()))
				.toList();
	}

}
