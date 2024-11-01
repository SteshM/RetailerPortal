package com.example.demo.dto;

import com.example.demo.enums.OrderStatus;
import com.example.demo.model.Location;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DepotOrderRequest {
    private Long depotOrderId;
    private String orderName;
    private Long depoId;
    private String depotToName;
    private String depotFromName;
    private Location location;
    private String orderDate;
    private OrderStatus status;
}
