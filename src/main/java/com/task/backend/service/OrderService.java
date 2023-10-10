package com.task.backend.service;

import com.task.backend.OrderStatus;
import com.task.backend.models.Order;
import com.task.backend.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class OrderService {
    @Autowired
    OrderRepository orderRepository;

    public void createAndSaveOrder(String username, Date orderDate, OrderStatus orderStatus, Double totalPrice) {
        Order order = new Order();
        order.setUsername(username);
        order.setOrderDate(new Date());
        order.setOrderStatus(orderStatus);
        order.setTotalPrice(totalPrice);
        orderRepository.save(order);
    }
}
