package com.example.demo.controller;

import com.example.demo.dto.*;
import com.example.demo.service.Components.main.OrderInterface;
import com.example.demo.service.Components.main.RetailerGuide;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/v1/retailer")
@RequiredArgsConstructor
public class RetailerController {

    @Autowired
    OrderInterface orderServices;
    @Autowired
    RetailerGuide retailerServices;

    @PostMapping("/placeOrder")
    public MinimalRes placeOrder(@RequestBody OrderDto orderDto)
    {return orderServices.placeOrder(orderDto);
    }
    @PostMapping("/addToCart")
    public MinimalRes addCartItem(@RequestBody CartItemRequest cartItem) {
        return orderServices.addCartItem(cartItem);
    }
    @GetMapping("/cartItems")
    public ExtendedRes getCartItems(){
        return orderServices.getCartItems();
    }

    @PostMapping("/deleteCartItem/{cartItemId}")
    public MinimalRes deleteCartItem(@PathVariable Long cartItemId){
        return orderServices.deleteCartItem(cartItemId);
    }
    @PostMapping("/addorupdateShop")
    public ExtendedRes addOrUpdateShop(@RequestBody ShopDto shopDto){
        return retailerServices.addShopUpdate(shopDto);
    }

    @PostMapping("/addShopWithImages")
    public MinimalRes addShopAndImages( @RequestPart("data") String shopDto,@RequestPart("images") List<MultipartFile> images){
        return retailerServices.addShopWithPictures(shopDto, images);
    }


    @GetMapping("/getShops")
    public ExtendedRes getShops(){
        return retailerServices.getShops();
    }

    @GetMapping("/deleteShop/{shopId}")
    public MinimalRes deleteShop(@PathVariable Long shopId){
        return retailerServices.deleteShop(shopId);
    }

    @GetMapping("/getShop/{shopId}")
    public ExtendedRes getShopByShopId(@PathVariable Long shopId){
        return retailerServices.getShopById(shopId);
    }
    @GetMapping("/getOrders")
    public Object retailerGetHisOrders(){
        return orderServices.retailerGetHisOrders();
    }

    @GetMapping("cartItemsCount")
    public ExtendedRes cartItemsCount(){
        return orderServices.getMyCartItemsCount();
    }


}
