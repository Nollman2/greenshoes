package com.cos.blog.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cos.blog.model.green_product;

public interface ItemRepository extends JpaRepository<green_product,Integer> {

	green_product findByProductname(String productname);

//	 @Query("select count(productname) from green_product where productname = :productname")
//	 int findproduct(@Param("productname") String productname);


}
