package com.example.demo.repository;

import com.example.demo.model.Analytcs.OrderAnalytics;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderAnalyticsRepo extends JpaRepository<OrderAnalytics, Integer>{
    public OrderAnalytics findByDateAndDepotId(int date, Long depotId);
    public List<OrderAnalytics> findByMonth(int month);
    public List<OrderAnalytics> findByYear(int year);
}
