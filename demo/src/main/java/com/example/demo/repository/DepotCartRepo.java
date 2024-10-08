package com.example.demo.repository;

import com.example.demo.model.Depot;
import com.example.demo.model.DepotCart;
import com.example.demo.model.MyUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DepotCartRepo extends JpaRepository<DepotCart,Long> {
    public List<DepotCart> findByAdmin(MyUser admin);
    public DepotCart findByCartIdAndAdmin(Long cartId, MyUser admin);

}