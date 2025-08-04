package com.think41.interview.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.think41.interview.model.OrdersModel;

@Repository
public interface OrderRepository extends JpaRepository<OrdersModel, Long> {
    List<OrdersModel> findByUserId(Long userId);
    Long countByUserId(Long userId);
}