package com.userSpringH2.utility;

import java.io.UnsupportedEncodingException;
import java.util.Base64;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.userSpringH2.entities.Product;
import com.userSpringH2.repositories.ProductRepository;

@Service
public class ProductUtil {

	@Autowired
	ProductRepository productRepository;

	public boolean checkIfPresent(int productId) {
		Product product = productRepository.findById(productId);
		return product != null;
	}

	public static String encode(String str) throws UnsupportedEncodingException {
		return Base64.getEncoder().encodeToString(str.getBytes("utf-8"));
	}


}
