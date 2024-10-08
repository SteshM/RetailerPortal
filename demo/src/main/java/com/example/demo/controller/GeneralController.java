package com.example.demo.controller;

import com.example.demo.dto.ExtendedRes;
import com.example.demo.service.Components.main.DepotOrderService;
import com.example.demo.service.Components.main.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("v1/general")
@RequiredArgsConstructor
public class GeneralController {
    private final ProductService productService;
    private final DepotOrderService depotOrderService;
    // private final OrderService orderService;
    // private final InventoryService inventoryService;

    @GetMapping("getProducts")
    public ExtendedRes getProducts() {
        return productService.getDisplayProducts();
    }

    @GetMapping("getProductAttributes/{productId}")
    public ExtendedRes getProductAttributes(@PathVariable Long productId) {
        return productService.getProductQAttributes(productId);
    }

    @GetMapping("getProductById/{productId}")
    public ExtendedRes getProductById(@PathVariable Long productId) {
        return productService.findById(productId);

    }
    @GetMapping("getOrderItems/{depotOrderId}")
    public ExtendedRes getOrderItems(@PathVariable Long depotOrderId) {
        return depotOrderService.getOrderItems(depotOrderId);
    }


}
