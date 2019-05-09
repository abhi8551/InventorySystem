package com.userSpringH2.utility;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.userSpringH2.entities.Inventory;
import com.userSpringH2.repositories.InventoryRepository;

@Service
public class InventoryUtil {

	@Autowired
	InventoryRepository inventoryRepository;

	public boolean checkIfPresent(int productId) {
		Inventory inventoryEntity = inventoryRepository.findById(productId);
		return inventoryEntity != null;
	}
}
