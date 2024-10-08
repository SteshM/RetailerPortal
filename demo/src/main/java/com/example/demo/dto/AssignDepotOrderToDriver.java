package com.example.demo.dto;

import lombok.Data;

@Data
public class AssignDepotOrderToDriver {
    private Long depotId;
    private Long depotOrderId;
    private Long driverId;

}
