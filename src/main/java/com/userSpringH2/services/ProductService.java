package com.userSpringH2.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.userSpringH2.entities.Product;
import com.userSpringH2.exceptions.ProductNotFoundException;
import com.userSpringH2.repositories.ProductRepository;

@Service
public class ProductService {

	@Autowired
	ProductRepository productRepository;

	public List<Product> getAllProducts() {
		List<Product> products = new ArrayList<Product>();
		productRepository.findAll().forEach(product -> products.add(product));
		return products;
	}

	public Product getProductById(int id) {
		Product productForId = productRepository.findById(id);
		if (productForId == null) {
			throw new ProductNotFoundException("Product is not available for id : " + id);
		} else {
			return productForId;
		}
	}

	public void saveOrUpdate(Product product) {
		Product updatedProduct = new Product();
		updatedProduct.setProductId(product.getProductId());
		updatedProduct.setProductDescription(product.getProductDescription());
		updatedProduct.setProductName(product.getProductName());
		productRepository.save(updatedProduct);
	}

	public void delete(Integer id) {
		productRepository.deleteById(id);
	}
}
