package com.example.product.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.product.Entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{
    
    public List<Product> findAll();
}
