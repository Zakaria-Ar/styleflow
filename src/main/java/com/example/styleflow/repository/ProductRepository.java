package com.example.styleflow.repository;

import com.example.styleflow.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

// empty interface; Spring generates the impl as a bean → free CRUD
public interface ProductRepository extends JpaRepository<Product,Integer>  {

}
