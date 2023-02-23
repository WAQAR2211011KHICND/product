package com.example.product.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.product.Entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{
    
    
}
