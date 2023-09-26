package com.example.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.entity.Admin;
import com.example.entity.Feedback;
import com.example.entity.Product;
import com.example.entity.User;

@Service
public interface IAdminService {

	public Product addProduct(Product product);
	public List<Product> viewProductsByCategory(String category);
	public List<Product> viewAllProducts();
	public Product editProduct(Product product, int productId);
	public List<User> viewAllUsers();
	public List<Feedback> viewAllFeedbacks();
	
	public void deleteUser(Integer userId);
	public void deleteProduct(Integer productId);
	public void deleteFeedback(Integer feedbackId);
	
	public Product getProductById(int productId);
	public Feedback getFeedbackById(int feedbackId);
	
	public Admin getAdmin(String username, String password);

	public Admin validateLogin(String username, String password);

	public Admin saveAdmin();
}
