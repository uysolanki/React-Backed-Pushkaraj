package com.react.reactbackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.react.reactbackend.entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer>{

}
