package com.think41.interview.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.think41.interview.dto.OrderResponseDTO;
import com.think41.interview.model.OrdersModel;
import com.think41.interview.repository.OrderRepository;

@Service
public class OrdersService {

    @Autowired
    private OrderRepository ordersRepository;

    public List<OrdersModel> getOrdersByUserId(Long userId) {
        try {
            return ordersRepository.findByUserId(userId);
        } catch (Exception e) {
            e.printStackTrace();
            return List.of(); 
        }
    }

    public Optional<OrdersModel> getOrderById(Long orderId) {
    try {
        return ordersRepository.findByOrderId(orderId);
    } catch (Exception e) {
        e.printStackTrace();
        return Optional.empty();
    }
}
}