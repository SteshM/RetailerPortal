package com.example.demo.repository;

import com.example.demo.model.TruckMaintenance;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TruckMaintenanceRepo extends JpaRepository<TruckMaintenance,Long> {
}
