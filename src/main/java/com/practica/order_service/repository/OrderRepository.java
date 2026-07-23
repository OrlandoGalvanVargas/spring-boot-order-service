package com.practica.order_service.repository;

import com.practica.order_service.entity.Order;
import com.practica.order_service.entity.OrderStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {

    List<Order> findByStatus(OrderStatus status);
    List<Order> findByCustomerNameContainingIgnoreCase(String name);
}
