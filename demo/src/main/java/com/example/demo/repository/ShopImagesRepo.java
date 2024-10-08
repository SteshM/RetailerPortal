package com.example.demo.repository;

import com.example.demo.model.Shop;
import com.example.demo.model.ShopImages;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ShopImagesRepo extends JpaRepository<ShopImages,Long> {
    List<ShopImages> findByShop(Shop shop);

}

