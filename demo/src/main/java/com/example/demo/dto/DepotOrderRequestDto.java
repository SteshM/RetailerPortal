package com.example.demo.dto;

import lombok.Data;

import java.util.List;

@Data
public class DepotOrderRequestDto {
    private Long depotId;
    private List<DepotOrderDto> depotOrderDtos;

}
