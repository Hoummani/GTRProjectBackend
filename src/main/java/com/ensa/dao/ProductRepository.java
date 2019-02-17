package com.ensa.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.ensa.entity.Product;

@RepositoryRestResource
public interface ProductRepository extends JpaRepository<Product, Long>{

}
