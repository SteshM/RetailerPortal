package com.example.demo.repository;

import com.example.demo.model.Truck;
import com.example.demo.model.TruckImages;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TruckImagesRepo extends JpaRepository<TruckImages,Long> {
    public List<TruckImages> findByTruck(Truck truck);
    public TruckImages findById(long id);

}

