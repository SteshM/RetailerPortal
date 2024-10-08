package com.example.demo.repository;

import com.example.demo.model.DeportDriver;
import com.example.demo.model.Depot;
import com.example.demo.model.MyUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DeportDriverRepo extends JpaRepository<DeportDriver,Long> {

    DeportDriver findByDriver(MyUser user);
    DeportDriver findByDriverAndDepot(MyUser driver, Depot depot);
}
