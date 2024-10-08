package com.example.demo.model;

import com.example.demo.enums.OrderStatus;
import com.example.demo.utils.DateUtils;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
    @Setter
    @Getter
    @AllArgsConstructor
    @NoArgsConstructor
    @Entity
    public class OrderDepot {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long orderId;
        private Long adminId;
        private Long depotId;
        private Long driverId;
        private OrderStatus status;
        private String orderName;
        private String orderDate = DateUtils.dateNowString();
}
