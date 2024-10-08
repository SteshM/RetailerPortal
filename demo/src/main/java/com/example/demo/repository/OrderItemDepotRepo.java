package com.example.demo.repository;

import com.example.demo.model.OrderItemDepot;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemDepotRepo extends JpaRepository<OrderItemDepot,Long> {
}

