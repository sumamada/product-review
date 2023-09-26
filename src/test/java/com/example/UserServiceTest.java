package com.example;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.example.controller.UserController;
import com.example.entity.Feedback;
import com.example.entity.Product;
import com.example.entity.User;
import com.example.service.UserService;

public class UserServiceTest {
	@InjectMocks
    private UserController userController;

 

    @Mock
    private UserService usrService;

 

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

 

    @Test
    public void testRegisterUser() {
        User user = new User(); // Create a sample user for testing
        when(usrService.registerUser(user)).thenReturn(user);

 

        ResponseEntity<User> responseEntity = userController.registerUser(user);

 

        verify(usrService).registerUser(user);
        assertSame(user, responseEntity.getBody());
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
    }

 

    @Test
    public void testLoginCheck() {
        User user = new User(); // Create a sample user for testing
        when(usrService.userLogin(user.getUsername(), user.getPassword())).thenReturn(user);

 

        ResponseEntity<User> responseEntity = userController.loginCheck(user);

 

        verify(usrService).userLogin(user.getUsername(), user.getPassword());
        assertSame(user, responseEntity.getBody());
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
    }

 

    @Test
    public void testViewProductsByCategory() {
        String productCategory = "TestCategory";
        List<Product> productsByCategory = new ArrayList<>(); // Create a sample list of products
        when(usrService.viewAllProductsByCategory(productCategory, null)).thenReturn(productsByCategory);

 

        ResponseEntity<List<Product>> responseEntity = userController.viewProductsBycategory(productCategory, null);

 

        verify(usrService).viewAllProductsByCategory(productCategory, null);
        assertSame(productsByCategory, responseEntity.getBody());
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
    }

 

    @Test
    public void testViewProductByName() {
        String productName = "TestProduct";
        Product product = new Product(); // Create a sample product for testing
        when(usrService.viewProductByName(productName)).thenReturn(product);

 

        ResponseEntity<Product> responseEntity = userController.viewProductByName(productName);

 

        verify(usrService).viewProductByName(productName);
        assertSame(product, responseEntity.getBody());
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
    }

 

    @Test
    public void testGiveFeedbackByProductId() {
        Feedback feedback = new Feedback(); // Create a sample feedback for testing
        int userId = 1;
        int productId = 2;
        when(usrService.giveFeedbackByProductId(feedback, userId, productId)).thenReturn(feedback);

 

        ResponseEntity<Feedback> responseEntity = userController.giveFeedbackByProductId(feedback, userId, productId);

 

        verify(usrService).giveFeedbackByProductId(feedback, userId, productId);
        assertSame(feedback, responseEntity.getBody());
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
    }

 

    @Test
    public void testGiveRatingByProductId() {
        Feedback feedback = new Feedback(); // Create a sample feedback for testing
        int userId = 1;
        int productId = 2;
        when(usrService.giveRatingByProductId(feedback, userId, productId)).thenReturn(feedback);

 

        ResponseEntity<Feedback> responseEntity = userController.giveRatingByProductId(feedback, userId, productId);

 

        verify(usrService).giveRatingByProductId(feedback, userId, productId);
        assertSame(feedback, responseEntity.getBody());
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
    }

 

    @Test
    public void testUpdateUser() {
        int userId = 1;
        User user = new User(); // Create a sample user for testing
        when(usrService.updateUserDetails(user, userId)).thenReturn(user);

 

        ResponseEntity<User> responseEntity = userController.updateUser(userId, user);

 

        verify(usrService).updateUserDetails(user, userId);
        assertSame(user, responseEntity.getBody());
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
    }

 

    @Test
    public void testGetUserById() {
        int userId = 1;
        User user = new User(); // Create a sample user for testing
        when(usrService.getUserById(userId)).thenReturn(user);

 

        User result = userController.getUserById(userId);

 

        verify(usrService).getUserById(userId);
        assertSame(user, result);
    }
}

	

	