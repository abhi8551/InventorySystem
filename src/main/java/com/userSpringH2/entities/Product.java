package com.userSpringH2.entities;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Product {
	
	@Id
	private int productId;

	private String productDescription;
	
	private String productName;

	public int getProductId() {
		return productId;
	}

	public void setProductId(int subProductId) {
		this.productId = subProductId;
	}

	public String getProductDescription() {
		return productDescription;
	}

	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}
}
