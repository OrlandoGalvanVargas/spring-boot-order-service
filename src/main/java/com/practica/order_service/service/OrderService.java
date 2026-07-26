package com.practica.order_service.service;

import com.practica.order_service.dto.OrderRequest;
import com.practica.order_service.entity.Order;
import com.practica.order_service.exception.OrderNotFoundException;
import com.practica.order_service.repository.OrderRepository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {
    // Service file to OrderService
    private final OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository)
    {
        this.orderRepository = orderRepository;
    }

    @Transactional
    public Order createOrder(OrderRequest request)
    {
        Order order = new Order();
        order.setCustomerName(request.getCustomerName());
        order.setTotalAmount(request.getTotalAmount());
        return orderRepository.save(order);
    }

    @Transactional(readOnly = true)
    public List<Order> getAllOrders()
    {
        return orderRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Order getOrderById(Long id){
        return orderRepository.findById(id).orElseThrow(() -> new OrderNotFoundException(id));
    }

    @Transactional
    public Order updateOrder(Long id, OrderRequest request){
        Order order = getOrderById(id);
        order.setCustomerName(request.getCustomerName());
        order.setTotalAmount(request.getTotalAmount());
        return orderRepository.save(order);
    }

    @Transactional
    public void deleteOrder(Long id){
        Order order = getOrderById(id);
        orderRepository.delete(order);
    }
}
