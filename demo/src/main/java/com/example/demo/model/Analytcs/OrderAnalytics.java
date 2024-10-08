package com.example.demo.model.Analytcs;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class OrderAnalytics {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int date;
    private int month;
    private int year;
    private float dailyCount;
    private Long depotId;
}