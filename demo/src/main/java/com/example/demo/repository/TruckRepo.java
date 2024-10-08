package com.example.demo.repository;

import com.example.demo.model.MyUser;
import com.example.demo.model.Truck;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TruckRepo extends JpaRepository<Truck,Long> {
    public Truck findByTruckNo(String TruckNo);

    public Truck findByMyUser(MyUser user);

    public List<Truck> findByMyUserIsNull();
}