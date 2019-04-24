package com.userSpringH2.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.userSpringH2.entities.Inventory;
import com.userSpringH2.entities.InventoryDisplay;
import com.userSpringH2.services.InventoryService;

@RestController
@RequestMapping("/api/")
public class InventoryController {
	
	@Autowired
	InventoryService inventoryService;
	
	/**
	 * @param inventoryEntity
	 * @return
	 */
	@PostMapping("/inventory")
	private String saveProductInventory(@RequestBody Inventory inventoryEntity) {
		inventoryService.saveOrUpdate(inventoryEntity);
		return "Inventory successfully updated!!";
	}
	
	/**
	 * @return
	 */
	@GetMapping("/inventory")
	private List<InventoryDisplay> getAllInventoryProducts() {
		return inventoryService.getAllInventoryProducts();
	}
}
