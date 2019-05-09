package com.userSpringH2.entities;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Inventory {

	@Id
	private int productId;
	private int count;
	private boolean isUpdate;

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public boolean isUpdate() {
		return isUpdate;
	}

	public void setUpdate(boolean isUpdate) {
		this.isUpdate = isUpdate;
	}

}
