package com.userSpringH2.controllers;

import java.io.UnsupportedEncodingException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.userSpringH2.entities.Product;
import com.userSpringH2.services.ProductService;
import com.userSpringH2.utility.ProductUtility;

@RestController
@RequestMapping("/api/")
public class ProductController {

	@Autowired
	ProductService productService;

	@Autowired
	ProductUtility productUtility;

	@GetMapping("/products")
	private List<Product> getAllProducts() {
		return productService.getAllProducts();
	}

	@GetMapping("/products/{id}")
	private Product getProduct(@PathVariable("id") int id) {
		return productService.getProductById(id);
	}

	@DeleteMapping("/products/{id}")
	private void deleteProduct(@PathVariable("id") Integer id) {
		productService.delete(id);
	}

	@PostMapping("/products")
	private String saveProduct(@RequestBody Product product) throws UnsupportedEncodingException {
		if(productUtility.checkIfPresent(product.getProductId())) {
			return "Product already present!!";
		}
		productService.saveOrUpdate(product);
		return "Product successfully added!!";
	}


}
