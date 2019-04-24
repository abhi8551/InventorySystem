//package com.userSpringH2.controllers;
//
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.userSpringH2.entities.Product;
//import com.userSpringH2.entities.ShoppingCart;
//import com.userSpringH2.entities.User;
//import com.userSpringH2.repositories.UserRepository;
//import com.userSpringH2.services.ProductService;
//import com.userSpringH2.services.ShoppingService;
//
//@RestController
//@RequestMapping("/api/")
//public class ShoppingController {
//
//	@Autowired
//	ProductService productService;
//
//	@Autowired
//	ShoppingService shoppingService;
//
//	@Autowired
//	UserRepository userRepository;
//
//	/**
//	 * This method is to buy the product and update the information to the Shopping
//	 * cart table
//	 * 
//	 * @param cart
//	 */
//	@PostMapping("/buy/products/")
//	private void buyProduct(@RequestBody ShoppingCart cart) {
//		int productId = cart.getProductId();
//		if (checkProductAvailable(productId) && checkUserExists(cart.getUserName())) {
//			shoppingService.purchaseProduct(cart);
//		} else {
//			System.out.println("Product is not Available");
//		}
//	}
//
//	/**
//	 * This method will check if User exists in Database
//	 * 
//	 * @param userName
//	 * @return
//	 */
//	private boolean checkUserExists(String userName) {
//		User user = userRepository.findByUsername(userName);
//		return user != null;
//	}
//
//	/**
//	 * This method will check if Product available in Database
//	 * 
//	 * @param productId
//	 * @return
//	 */
//	private boolean checkProductAvailable(int productId) {
//		Product product = productService.getProductById(productId);
//		return product.isAvailable();
//	}
//
//	/**
//	 * This method will retrieve all the orders
//	 * 
//	 * @param cart
//	 * @return 
//	 */
//	@GetMapping("/view/orders/")
//	private List<ShoppingCart> getAllOrders() {
//		return shoppingService.getAllOrders();
//	}
//}
