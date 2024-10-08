package com.example.demo.repository;

import com.example.demo.model.OrderDepot;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderDepotRepo extends JpaRepository<OrderDepot,Long> {

}