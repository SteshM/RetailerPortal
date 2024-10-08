package com.example.demo.model;

import com.example.demo.enums.MaintenanceStatus;
import com.example.demo.utils.DateUtils;
import jakarta.persistence.*;
@Entity
public class TruckMaintenance {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "truckId")
    private Truck truck;
    @ManyToOne
    @JoinColumn(name="userId")
    private MyUser myUser;
    private MaintenanceStatus maintenanceStatus;
    private String maintenanceApprovalDate;
    private String maintenanceDate = DateUtils.dateNowString();
    private float cost;
    private String details;
}
