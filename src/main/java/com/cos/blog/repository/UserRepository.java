package com.cos.blog.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cos.blog.model.green_Users;

public interface UserRepository extends JpaRepository<green_Users,Integer> {
	Optional<green_Users> findByUsername(String username);

	List<green_Users> findByUsernameContaining(String keyword);

	
}
