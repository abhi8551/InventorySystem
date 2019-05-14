package com.userSpringH2.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.userSpringH2.entities.Inventory;
import com.userSpringH2.entities.InventoryDisplay;
import com.userSpringH2.entities.Product;
import com.userSpringH2.exceptions.ProductNotFoundException;
import com.userSpringH2.repositories.InventoryRepository;
import com.userSpringH2.repositories.ProductRepository;

@Service
public class InventoryService {

	@Autowired
	InventoryRepository inventoryRepository;
	
	@Autowired
	ProductRepository productRepository;
	
	public void saveOrUpdate(Inventory inventoryUpdateInstance) {
		Inventory inventory = new Inventory();
		if(productRepository.findById(inventoryUpdateInstance.getProductId())!=null) {
			inventory.setProductId(inventoryUpdateInstance.getProductId());
			inventory.setCount(inventoryUpdateInstance.getCount());
			inventoryRepository.save(inventory);
		} else {
			throw new ProductNotFoundException(
					"Product is not available for id : " + inventoryUpdateInstance.getProductId());
		}
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
