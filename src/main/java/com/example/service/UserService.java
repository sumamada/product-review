package com.example.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.entity.Feedback;
import com.example.entity.Product;
import com.example.entity.User;
import com.example.exception.ProductNotFoundException;
import com.example.exception.UserNotFoundException;
import com.example.repository.FeedbackRepository;
import com.example.repository.ProductRepository;
import com.example.repository.UserRepository;

@Service
public class UserService implements IUserService {

	@Autowired
	UserRepository userRepo;
	
	@Autowired
	IAdminService adminService;
	
	@Autowired
	ProductRepository productRepo;
	
	@Autowired
	FeedbackRepository feedbackRepo;
	
	

	@Override
	public User userLogin(String username, String password) {
		// TODO Auto-generated method stub
		
		List<User> users = userRepo.findAll();
		for (User user : users) {
			if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
				return user;
			}
		}
		return null;
		
	}
	@Override
	public List<Product> viewAllProductsByCategory(String category, String productName) {
		// TODO Auto-generated method stub
		
		List<Product> sameproductsByCategory = productRepo.viewSameProductsByCategory(category, productName);
		if(sameproductsByCategory == null) {
			throw new ProductNotFoundException("No Products found for given category & name");
		}
		
			return sameproductsByCategory;
		}
		

	@Override
	public Product viewProductByName(String productName) {
		// TODO Auto-generated method stub
		Product pro = productRepo.getProductByproductName(productName);
		if(pro == null) {
			throw new ProductNotFoundException("No Product found with given name :"+productName);
		}
		return pro;
	}

	@Override
	public Feedback giveFeedbackByProductId(Feedback feedback, int userId, int productId) {
		// TODO Auto-generated method stub
		
		Feedback fk = new Feedback();
		
		Product product = adminService.getProductById(productId);
		User user = userRepo.getUserById(userId);
		
		if(product != null && user != null) {
			fk.setFeedback(feedback.getFeedback());
			fk.setProduct(product);
			fk.setUser(user);
						
		}
		return feedbackRepo.save(fk);
	}

	@Override
	public Feedback giveRatingByProductId(Feedback feedback, int userId, int productId) {
		// TODO Auto-generated method stub
      Feedback fkk = new Feedback();
		
		Product product = adminService.getProductById(productId);
		User user = userRepo.getUserById(userId);
		
		if(product != null && user != null) {
			fkk.setRating(feedback.getRating());
			fkk.setProduct(product);
			fkk.setUser(user);
		}
		return feedbackRepo.save(fkk);
	}


	@Override
	public User updateUserDetails(User user, int userId) {
		// TODO Auto-generated method stub
		User usr = getUserById(userId);
		usr.setName(user.getName());
		usr.setAddress(user.getAddress());
		usr.setMobileNo(user.getMobileNo());
		usr.setUsername(user.getUsername());
		usr.setPassword(user.getPassword());
				
		return userRepo.save(usr);
	}

	@Override
	public User getUserById(int userId) {
		// TODO Auto-generated method stub	
		Optional<User> byuserId = userRepo.findById(userId);
		if (byuserId.isPresent()) {
			return byuserId.get();
			}
			throw new UserNotFoundException("User not found for given Id :"+userId);
			}
	@Override
	public User registerUser(User user) {
		// TODO Auto-generated method stub
		return null;
	}


}
