package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.entity.Product;

@Repository
public interface ProductoRepository extends JpaRepository<Product, Long> {

}
