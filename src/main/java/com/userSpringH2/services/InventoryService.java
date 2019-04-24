package com.userSpringH2.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.userSpringH2.entities.Inventory;
import com.userSpringH2.entities.InventoryDisplay;
import com.userSpringH2.entities.Product;
import com.userSpringH2.repositories.InventoryRepository;
import com.userSpringH2.repositories.ProductRepository;

@Service
public class InventoryService {

	@Autowired
	InventoryRepository inventoryRepository;
	
	@Autowired
	ProductRepository productRepository;
	
	public void saveOrUpdate(Inventory product) {
		Inventory inventory = new Inventory();
		inventory.setProductId(product.getProductId());
		inventory.setCount(product.getCount());
		inventoryRepository.save(inventory);
	}
	
	public List<InventoryDisplay> getAllInventoryProducts() {
		List<InventoryDisplay> invnetoryProducts = new ArrayList<InventoryDisplay>();
		inventoryRepository.findAll().forEach(entity -> {
			InventoryDisplay inventoryDisplay = new InventoryDisplay();
			Product product = productRepository.findById(entity.getProductId());
			inventoryDisplay.setProductId(product.getProductId());
			inventoryDisplay.setProductName(product.getProductName());
			inventoryDisplay.setProductDescription(product.getProductDescription());
			inventoryDisplay.setCount(entity.getCount());
			invnetoryProducts.add(inventoryDisplay);
		});
		return invnetoryProducts;
	}
}
