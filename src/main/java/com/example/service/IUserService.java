package com.example.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.entity.Feedback;
import com.example.entity.Product;
import com.example.entity.User;

@Service
public interface IUserService {

	public User registerUser(User user);
	public User userLogin(String username, String password);
	public List<Product> viewAllProductsByCategory(String category, String productName);
	public Product viewProductByName(String productName);
	public Feedback giveFeedbackByProductId(Feedback feedback, int userId, int productId);
	public Feedback giveRatingByProductId(Feedback feedback, int userId, int productId);
	public User updateUserDetails(User user, int userId);
	
	public User getUserById(int userId);
}
