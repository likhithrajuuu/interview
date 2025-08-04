package com.think41.interview.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import lombok.Data;

@Data
public class OrderResponseDTO {
    private Long orderId;
    private Long customerId;
    private String productName;
    private BigDecimal price;
    private int quantity;
    private BigDecimal totalAmount;
    private String status;
    private LocalDateTime orderDate;
}