package com.userSpringH2.exceptions;

public class ProductNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public ProductNotFoundException(String exception) {
		super(exception);
	}
}
