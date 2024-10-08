package com.example.demo.repository;

import com.example.demo.model.DepotOrder;
import com.example.demo.model.DepotOrderItem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DepotOrderItemRepo extends JpaRepository<DepotOrderItem,Long> {
    public List<DepotOrderItem> findByDepotOrder(DepotOrder depotOrder);
}
