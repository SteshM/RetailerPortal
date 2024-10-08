package com.example.demo.service.Components.main;

import com.example.demo.dto.ExtendedRes;
import com.example.demo.dto.MinimalRes;
import com.example.demo.dto.ShopDto;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface RetailerGuide {
    public ExtendedRes addShopUpdate(ShopDto shopDto);
    public MinimalRes addShopWithPictures(String shopDto, List<MultipartFile> images);
    public ExtendedRes getShops();
    public ExtendedRes getShopById(Long shopId);
    public MinimalRes deleteShop(Long shopId);

}
