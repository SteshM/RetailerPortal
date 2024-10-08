package com.example.demo.repository;

import com.example.demo.model.Depot;
import com.example.demo.model.DepotProduct;
import com.example.demo.model.Product;
import com.example.demo.model.QuantityAttribute;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DepotProductsRepo extends JpaRepository<DepotProduct,Long> {
    public DepotProduct findByProductAndQuantityAtAndDepot(Product product, QuantityAttribute quantityAttribute, Depot depot);

    public DepotProduct findByProductAndQuantityAt(Product product, QuantityAttribute quantityAttribute);

    public DepotProduct findByProduct(Product product);

    public List<DepotProduct> findByDepot(Depot depot);
}
