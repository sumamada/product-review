package com.example.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


import com.example.entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

	@Query("from Product pr where pr.productCategory=?1")
	public List<Product> viewProductsByCategory(String productCategory);
	
	@Query("from Product pr where pr.productCategory=?1 and pr.productName=?2")
	public List<Product> viewSameProductsByCategory(String productCategory, String productName);
	
	
	@Query("from Product p where p.productName=?1")
	public Product getProductByproductName(String productName);
}
