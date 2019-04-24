//package com.userSpringH2.services;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Optional;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import com.userSpringH2.entities.Product;
//import com.userSpringH2.entities.ShoppingCart;
//import com.userSpringH2.entities.User;
//import com.userSpringH2.repositories.CartRepository;
//import com.userSpringH2.repositories.ProductRepository;
//import com.userSpringH2.repositories.UserRepository;
//
//@Service
//public class ShoppingService {
//
//	@Autowired
//	ProductService productService;
//
//	@Autowired
//	CartRepository cartRepository;
//
//	@Autowired
//	ProductRepository productRepository;
//
//	@Autowired
//	UserRepository userRepository;
//
//	/**
//	 * This method will list of Orders placed
//	 * 
//	 * @return
//	 */
//	public List<ShoppingCart> getAllOrders() {
//		List<ShoppingCart> totalOrders = new ArrayList<ShoppingCart>();
//		cartRepository.findAll().forEach(order -> totalOrders.add(order));
//		return totalOrders;
//	}
//
//	/**
//	 * This method will retrieve the Order for {id}
//	 * 
//	 * @param id
//	 * @return
//	 */
//	public Optional<ShoppingCart> getOrderById(int id) {
//		return cartRepository.findById(id);
//	}
//
//	/**
//	 * This will check if the existing order id present or not
//	 * 
//	 * @param cart
//	 */
//	public void purchaseProduct(ShoppingCart cart) {
//		// TODO: If transaction fails
//		// update the delivery address in the Product information for existing order
//		saveOrUpdate(cart);
//	}
//
//	/**
//	 * This method will save the instance of cart and product
//	 * 
//	 * @param cart
//	 */
//	public void saveOrUpdate(ShoppingCart cart) {
//		ShoppingCart cartModel = new ShoppingCart();
//		cartModel.setUserName(cart.getUserName());
//		cartModel.setProductId(cart.getProductId());
//		// TODO: If update to product table fails
//		updateProductStatus(cart);
//		cartRepository.save(cartModel);
//	}
//
//	/**
//	 * This method will update the status of the product in the database
//	 * 
//	 * @param cart
//	 */
//	private void updateProductStatus(ShoppingCart cart) {
//		Product product = productService.getProductById(cart.getProductId());
//		String username = cart.getUserName();
//		User user = retrieveUserInformation(username);
//		productRepository.save(product);
//	}
//
//	private User retrieveUserInformation(String username) {
//		return userRepository.findByUsername(username);
//	}
//
//	public void delete(Integer id) {
//		cartRepository.deleteById(id);
//	}
//
//}
