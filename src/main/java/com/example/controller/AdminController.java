package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.entity.Admin;
import com.example.entity.Feedback;
import com.example.entity.Product;
import com.example.entity.User;
import com.example.exception.AdminNotFoundException;
import com.example.service.IAdminService;
import com.example.service.IUserService;

@CrossOrigin(value = "*")
@RestController
@RequestMapping("api/v1")
public class AdminController {

    @Autowired
    IAdminService admService;
    
    @Autowired
    IUserService usrService;
  
    @PostMapping(path = "/admin/login", consumes = {"application/json"})
	public ResponseEntity<String> adminCheck(@RequestBody Admin adminLogin) {
		String message = null;

		admService.saveAdmin();
		
		Admin admin = admService.getAdmin(adminLogin.getUsername(), adminLogin.getPassword());

		if (admin == null) {
			throw new AdminNotFoundException("You are not Admin");

		} else {
			Admin checkAdmin = admService.validateLogin(adminLogin.getUsername(), adminLogin.getPassword());

			if (checkAdmin == null) {
				throw new AdminNotFoundException("Username or Password Incorrect... Enter correct credentials please");
			}
			else {
				message = "Welcome " + checkAdmin.getUsername();
			}
			return new ResponseEntity<>(message, HttpStatus.OK);

		}
	}
    
    
	@PostMapping("/add/product")
	public ResponseEntity<Product> addProduct(@RequestBody Product product) {
	Product productt = admService.addProduct(product);
	return new ResponseEntity<>(productt, HttpStatus.OK);
	}
	
	@GetMapping("/view/products/{category}")
	public ResponseEntity<List<Product>> viewProductsBycategory(@PathVariable ("productCategory") String productCategory) {
		List<Product> productsByCategory = admService.viewProductsByCategory(productCategory);
	  return new ResponseEntity<>(productsByCategory, HttpStatus.OK);
	}

	@GetMapping("/products")
	public List<Product> getAllProducts() {
		List<Product> products = admService.viewAllProducts();
		
		return products;
}
	
	@PutMapping(path = "/product/update/{productId}", consumes = { "application/json" } )
	public ResponseEntity<Product> updateProduct(@PathVariable("productId") int productId, @RequestBody Product psr) {
		
		Product pr = admService.editProduct(psr, productId);
				
		return new ResponseEntity<>(pr , HttpStatus.OK);		
	}

	@GetMapping("/users")
	public List<User> getAllUsers() {
		List<User> users = admService.viewAllUsers();
		
		return users;
}
	
	@GetMapping("/feedbacks")
	public List<Feedback> getAllFeedbacks() {
		List<Feedback> feedbacks = admService.viewAllFeedbacks();
		
		return feedbacks;
}
	
	@GetMapping("/product/{productId}")
	public Product getProductById(@PathVariable int productId) {
		return admService.getProductById(productId);
	}
	
	@DeleteMapping("/user/delete/{userId}")
	public ResponseEntity<String> deleteUser(@PathVariable Integer userId) {
		admService.deleteUser(userId);
		return new ResponseEntity<>("User has been deleted", HttpStatus.OK);
	}
	
	@DeleteMapping("/product/delete/{productId}")
	public ResponseEntity<String> deleteProduct(@PathVariable Integer productId) {
		admService.deleteProduct(productId);
		return new ResponseEntity<>("Product has been deleted", HttpStatus.OK);
	}
	
	@DeleteMapping("/feedback/delete/{feedbackId}")
	public ResponseEntity<String> deleteFeedback(@PathVariable Integer feedbackId) {
		admService.deleteFeedback(feedbackId);
		return new ResponseEntity<>("Feedback has been deleted", HttpStatus.OK);
	}
}
