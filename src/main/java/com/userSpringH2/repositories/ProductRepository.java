package com.userSpringH2.repositories;

import org.springframework.data.repository.CrudRepository;

import com.userSpringH2.entities.Product;

public interface ProductRepository extends CrudRepository<Product, Integer> {

	Product findById(int id);

}
