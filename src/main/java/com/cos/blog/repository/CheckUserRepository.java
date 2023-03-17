package com.cos.blog.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cos.blog.model.green_Users;


public interface CheckUserRepository extends JpaRepository<green_Users,Integer> {
	green_Users findByUsername(String username);

	
}
