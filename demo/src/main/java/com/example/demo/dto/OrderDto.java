package com.example.demo.dto;


import lombok.Data;

import java.util.List;

@Data
public class OrderDto {
    private Long shopId;
    private List<OrderItemDto> orderItems;
}
