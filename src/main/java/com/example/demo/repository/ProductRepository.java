package com.example.demo.repository;

import com.example.demo.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product,Long> {
    List<Product> findByNameContains(String mc);
    @Query("select p from Product p where p.name like :x")
    List<Product>search(@Param("x") String mc);
    @Query("select p from Product p where p.price >:x")
    List<Product>searchByPrice(@Param("x") double price);
    List<Product> findByPriceGreaterThan(double price);
}
