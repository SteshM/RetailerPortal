package com.example.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ShopDto {
    private Long shopId;
    private String shopName;
    private String locationLatLong;
    private String region;
    private String shopType;

}
