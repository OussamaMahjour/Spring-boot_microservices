package com.oussama.microservices.orders.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.oussama.microservices.orders.dto.OrderRequest;
import com.oussama.microservices.orders.dto.OrderResponse;
import com.oussama.microservices.orders.service.OrderService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

/**
 * OrderController
 */
@RestController
@RequestMapping("/api/order")
@RequiredArgsConstructor
@Slf4j
public class OrderController {

	public final OrderService orderService;

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public String placeOrder(@RequestBody OrderRequest orderRequest) {
		orderService.placeOrder(orderRequest);
		return "Order Placed Successfully";
	}

	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	public List<OrderResponse> getAllOrders() {
		return orderService.getAllOrders();
	}

}
