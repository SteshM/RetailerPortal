package com.example.demo.service.Components.main;

import com.example.demo.dto.*;
import com.example.demo.enums.OrderStatus;

public interface DepotOrderService {
    public MinimalRes addProductToCart(DepotCartDto depotCartDto);
    public MinimalRes makeOrder(DepotOrderRequestDto depotOrderRequestDto);
    public ExtendedRes getCartItems();
    public ExtendedRes getDepotOrders();
    public ExtendedRes getDepotOrders( OrderStatus orderStatus);
    public ExtendedRes getOrderItems(Long depotOrderId);
    public MinimalRes deleteCartItem(Long cartItemId);
    public MinimalRes assignDepotOrderToDepot(AssigneDepotOrderToDepot assigneDepotOrderToDepot);
    public ExtendedRes getInterdepotDepotOrders();
    public MinimalRes assignDepotOrderToDriver(AssignDepotOrderToDriver assignDepotOrderToDriver);
    public MinimalRes confirmDelivery(DepotOrderConfirmDelivery delivery);
    public ExtendedRes getMyDepotOrders();
    public MinimalRes updateCartItemQuanity(DepotCartQuantityDto depotCartQuantityDto);



}
