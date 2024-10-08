package com.example.demo.dto;

import lombok.Data;

@Data
public class DepotCartDto {
    private Long productId;
    private Long qAttId;
    private int quantity;
}
