package com.userSpringH2.repositories;

import org.springframework.data.repository.CrudRepository;

import com.userSpringH2.entities.Inventory;

public interface InventoryRepository extends CrudRepository<Inventory, Integer>{
	
	Inventory findById(int id);
}
