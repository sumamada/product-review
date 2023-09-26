package com.example.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.Admin;
import com.example.entity.Feedback;
import com.example.entity.Product;
import com.example.entity.User;
import com.example.exception.FeedbackNotFoundException;
import com.example.exception.ProductNotFoundException;
import com.example.exception.UserNotFoundException;
import com.example.repository.AdminRepository;
import com.example.repository.FeedbackRepository;
import com.example.repository.ProductRepository;
import com.example.repository.UserRepository;

@Service
public class AdminService implements IAdminService {

	@Autowired
	ProductRepository productRepo;
	
	@Autowired
	UserRepository userRepo;
	
	@Autowired
	AdminRepository admRepo;
	
	@Autowired
	FeedbackRepository feedbackRepo;
	
	@Override
	public Product addProduct(Product product) {
		// TODO Auto-generated method stub
		Product product1 = productRepo.save(product);
		return product1;
	}

	@Override
	public List<Product> viewProductsByCategory(String category) {
		// TODO Auto-generated method stub
		List<Product> productsByCategory = productRepo.viewProductsByCategory(category);
		if(productsByCategory == null) {
			throw new ProductNotFoundException("No Products found for given category :"+category);
		}
		return productsByCategory;
	}

	@Override
	public List<Product> viewAllProducts() {
		// TODO Auto-generated method stub
		List<Product> allProducts = productRepo.findAll();
		return allProducts;
	}

	@Override
	public Product editProduct(Product product, int productId) {
		// TODO Auto-generated method stub
		Product pro = getProductById(productId);
		pro.setProductName(product.getProductName());
		pro.setProductPrice(product.getProductPrice());
		pro.setProductSeller(product.getProductSeller());
		pro.setProductCategory(product.getProductCategory());
		
		return productRepo.save(pro);
	}

	@Override
	public List<User> viewAllUsers() {
		// TODO Auto-generated method stub
		List<User> allUsers = userRepo.findAll();
		return allUsers;
	}

	@Override
	public List<Feedback> viewAllFeedbacks() {
		// TODO Auto-generated method stub
		List<Feedback> allFeedbacks = feedbackRepo.findAll();
		return allFeedbacks;
	}

	@Override
	public Product getProductById(int productId) {
		// TODO Auto-generated method stub	
		Optional<Product> byproductId = productRepo.findById(productId);
		if (byproductId.isPresent()) {
			return byproductId.get();
			}
			throw new ProductNotFoundException("Product not found for given Id :"+productId);
			}


	
	@Override
	public Admin getAdmin(String username, String password) {

		Admin adm = admRepo.adminById(username, password);

		return adm;
		
	}
	

	@Override
	public Admin validateLogin(String username, String password) {
	
		
		Admin admin = admRepo.adminById(username, password);

		if (admin.getUsername().equals(username) && admin.getPassword().equals(password)) {
			return admin;
		}

		return null;
	}

	
	public Admin saveAdmin() {
		

		Admin ad = new Admin();
		ad.setAdminId(1);
		ad.setUsername("admin");
		ad.setPassword("admin");
		return	admRepo.save(ad);
	}

	
	@Override
	public void deleteUser(Integer userId) {

	Optional<User> userById = userRepo.findById(userId);
	if (userById.isPresent()) {
	feedbackRepo.deleteById(userId);
	userRepo.deleteById(userId);
	
	} else {
	throw new UserNotFoundException("User not found for given Id :"+userId);
	 }
	}


	@Override
	public void deleteProduct(Integer productId) {

	Optional<User> productById = userRepo.findById(productId);
	if (productById.isPresent()) {
	feedbackRepo.deleteById(productId);
	productRepo.deleteById(productId);
	
	} else {
	throw new ProductNotFoundException("Product not found for given Id :"+productId);
	 }
	}
	
	@Override
	public void deleteFeedback(Integer feedbackId) {
		// TODO Auto-generated method stub
		Optional<Feedback> feedbackById = feedbackRepo.findById(feedbackId);
		if (feedbackById.isPresent()) {
		feedbackRepo.deleteById(feedbackId);
		
		} else {
		throw new FeedbackNotFoundException("Feedback not found for given Id :"+feedbackId);
		 }
		}
	
	
	@Override
	public Feedback getFeedbackById(int feedbackId) {
		// TODO Auto-generated method stub
		Optional<Feedback> byfeedbackId = feedbackRepo.findById(feedbackId);
		if (byfeedbackId.isPresent()) {
			return byfeedbackId.get();
			}
			throw new FeedbackNotFoundException("No Feedback found for given Id :"+feedbackId);
			}
	}

	

