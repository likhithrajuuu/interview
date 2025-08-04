package com.think41.interview.dto;

import java.util.List;

import lombok.Data;

@Data
public class CustomerOrdersResponseDTO {
    public Long customerId;
    public String customerName;
    public List<OrderResponseDTO> orders;
}
