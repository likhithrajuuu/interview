package com.think41.interview.controller;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.think41.interview.dto.OrderResponseDTO;
import com.think41.interview.model.OrdersModel;
import com.think41.interview.model.UsersModel;
import com.think41.interview.repository.OrderRepository;
import com.think41.interview.repository.UserRepository;
import com.think41.interview.service.OrdersService;

@RestController
@RequestMapping("/api/order")
public class OrderController {
     @Autowired
    private UserRepository usersRepository;

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private OrdersService ordersService;

    @GetMapping("/user/{userId}")
    public ResponseEntity<?> getOrdersByUserId(@PathVariable Long userId) {
        try {
            List<OrdersModel> orders = ordersService.getOrdersByUserId(userId);
            return ResponseEntity.ok(orders);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error fetching orders: " + e.getMessage());
        }
    }

    @GetMapping("/{orderId}")
public ResponseEntity<?> getOrderById(@PathVariable Long orderId) {
    try {
        Optional<OrdersModel> order = ordersService.getOrderById(orderId);

        if (order.isPresent()) {
            return ResponseEntity.ok(order.get());
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(Map.of("error", "Order not found"));
        }

    } catch (Exception e) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(Map.of("error", "Error fetching order: " + e.getMessage()));
    }
}
}
