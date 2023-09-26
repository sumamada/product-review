package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.entity.Admin;

@Repository
public interface AdminRepository extends JpaRepository<Admin, Integer> {

	@Query("from Admin ad where ad.username=?1 and ad.password=?2")
	public Admin adminById(String username, String password);
}
