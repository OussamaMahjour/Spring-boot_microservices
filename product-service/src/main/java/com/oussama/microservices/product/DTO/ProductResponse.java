package com.oussama.microservices.product.DTO;

import java.math.BigDecimal;

/**
 * ProductRequest
 */

public record ProductResponse(String id, String name, String description, BigDecimal price) {
}
