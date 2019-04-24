package com.userSpringH2.entities;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Order {
	@Id
	private String orderId;
	
	private String productId;
	
	private String username;

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
}
