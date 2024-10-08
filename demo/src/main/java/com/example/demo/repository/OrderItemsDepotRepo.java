package com.example.demo.repository;

import com.example.demo.model.Order;
import com.example.demo.model.OrderItem;
import com.example.demo.model.QuantityAttribute;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderItemsDepotRepo extends JpaRepository<OrderItem,Long> {
    public List<OrderItem> findByOrder(Order order);
    public List<OrderItem> findByOrderAndQuantityAttribute(Order order, QuantityAttribute quantityAttribute);
    public Integer countByOrder(Order order);
}