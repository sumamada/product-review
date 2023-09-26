package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.entity.Feedback;
import com.example.entity.Product;
import com.example.entity.User;
import com.example.service.IAdminService;
import com.example.service.IUserService;

@CrossOrigin(value = "*")
@RestController
@RequestMapping("api/v1")
public class UserController {

	
	@Autowired
    IAdminService admService;
    
    @Autowired
    IUserService usrService;
    
    
    @PostMapping("/add/user")
	public ResponseEntity<User> registerUser(@RequestBody User user) {
	User usr = usrService.registerUser(user);
	return new ResponseEntity<>(usr, HttpStatus.OK);
	}
    
    @PostMapping(path = "/user/login", consumes = { "application/json" } )
	public ResponseEntity<User> loginCheck(@RequestBody User user) {
		User us = new User();
		
		User userLogin = usrService.userLogin(user.getUsername(), user.getPassword());
		if (userLogin != null) {
			us = userLogin;
		}
		return new ResponseEntity<>(us, HttpStatus.OK);
	}
	
    
	@GetMapping("/view/products/{productCategory}")
	public ResponseEntity<List<Product>> viewProductsBycategory(@PathVariable ("productCategory") String productCategory, @PathVariable("productName") String productName) {
		List<Product> productsByCategory = usrService.viewAllProductsByCategory(productCategory, productName);
	  return new ResponseEntity<>(productsByCategory, HttpStatus.OK);
	}
	
    @GetMapping("/view/product/{productName}")
	public ResponseEntity<Product> viewProductByName(@PathVariable ("productName") String productName) {
		Product product = usrService.viewProductByName(productName);
	  return new ResponseEntity<>(product, HttpStatus.OK);
	}
    
    @PostMapping("/feedback/{userId}/{productId}")
   	public ResponseEntity<Feedback> giveFeedbackByProductId( @RequestBody Feedback feedback, @PathVariable ("userId") int userId, @PathVariable ("productId") int productId) {	
   		Feedback  fbk = usrService.giveFeedbackByProductId(feedback, userId, productId);
   		return new ResponseEntity<>(fbk, HttpStatus.OK);
   	}
    
    @PostMapping("/rating/{userId}/{productId}")
	public ResponseEntity<Feedback> giveRatingByProductId(@RequestBody Feedback feedback, @PathVariable ("userId") int userId, @PathVariable ("productId") int productId) {	
		Feedback  fdback = usrService.giveRatingByProductId(feedback, userId, productId);
		return new ResponseEntity<>(fdback, HttpStatus.OK);
	}
    
    @PutMapping(path = "/user/update/{userId}", consumes = { "application/json" } )
	public ResponseEntity<User> updateUser(@PathVariable("userId") int userId, @RequestBody User usr) {
		
		User ur = usrService.updateUserDetails(usr, userId);
		
		
		return new ResponseEntity<>(ur , HttpStatus.OK);
		
	}
    
    @GetMapping("/user/{userId}")
	public User getUserById(@PathVariable int userId) {
		return usrService.getUserById(userId);
	}
}
