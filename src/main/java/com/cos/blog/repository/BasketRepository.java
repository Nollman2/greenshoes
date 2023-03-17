package com.cos.blog.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.cos.blog.model.green_basket;

public interface BasketRepository extends JpaRepository<green_basket,Integer> {

	Page<green_basket> findById(Pageable pageable, Object userid);
	



	

	
}
