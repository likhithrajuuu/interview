package com.think41.interview.model;

import java.sql.Timestamp;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "orders", schema = "dev")
public class OrdersModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderId;

    @Column(name = "user_id")
    private Long userId;

    @Column(name = "status")
    private String status;

    @Column(name="gender")
    private String gender;

    @Column(name="created_at")
    private Timestamp createdAt;
    
    @Column(name="returned_at")
    private Timestamp returnedAt;

    @Column(name="shipped_at")
    private Timestamp shippedAt;

    @Column(name="delivered_at")
    private Timestamp deliveredAt;

    @Column(name="num_of_item")
    private Long numOfItem;

    public OrdersModel() {

    }

    

    public OrdersModel(Long orderId, Long userId, String status, String gender, Timestamp createdAt,
            Timestamp returnedAt, Timestamp shippedAt, Timestamp deliveredAt, Long numOfItem) {
        this.orderId = orderId;
        this.userId = userId;
        this.status = status;
        this.gender = gender;
        this.createdAt = createdAt;
        this.returnedAt = returnedAt;
        this.shippedAt = shippedAt;
        this.deliveredAt = deliveredAt;
        this.numOfItem = numOfItem;
    }



    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    public Timestamp getReturnedAt() {
        return returnedAt;
    }

    public void setReturnedAt(Timestamp returnedAt) {
        this.returnedAt = returnedAt;
    }

    public Timestamp getShippedAt() {
        return shippedAt;
    }

    public void setShippedAt(Timestamp shippedAt) {
        this.shippedAt = shippedAt;
    }

    public Timestamp getDeliveredAt() {
        return deliveredAt;
    }

    public void setDeliveredAt(Timestamp deliveredAt) {
        this.deliveredAt = deliveredAt;
    }

    public Long getNumOfItem() {
        return numOfItem;
    }

    public void setNumOfItem(Long numOfItem) {
        this.numOfItem = numOfItem;
    }

    @Override
    public String toString() {
        return "OrdersModel [orderId=" + orderId + ", userId=" + userId + ", status=" + status + ", gender=" + gender
                + ", createdAt=" + createdAt + ", returnedAt=" + returnedAt + ", shippedAt=" + shippedAt
                + ", deliveredAt=" + deliveredAt + ", numOfItem=" + numOfItem + "]";
    }
    
}
