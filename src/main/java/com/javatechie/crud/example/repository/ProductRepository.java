package com.javatechie.crud.example.repository;

import com.javatechie.crud.example.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

//JpaRepository<Entity/Model class, Data type of Primary Key>
public interface ProductRepository extends JpaRepository<Product,Integer> {
    Product findByName(String name);
}
