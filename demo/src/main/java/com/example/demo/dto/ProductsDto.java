package com.example.demo.dto;


import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class ProductsDto {
    private Long id;
    private String productName;
    private String description;}

