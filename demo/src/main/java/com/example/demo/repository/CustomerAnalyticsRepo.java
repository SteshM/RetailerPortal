package com.example.demo.repository;

import com.example.demo.model.Analytcs.CustomerAnalytics;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CustomerAnalyticsRepo extends JpaRepository<CustomerAnalytics,Long> {
    public CustomerAnalytics findByDate(int date);
    public List<CustomerAnalyticsRepo> findByMonth(int month);
    public List<CustomerAnalytics> findByYear(int year);
}
