package com.cos.blog.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cos.blog.model.green_img;
import com.cos.blog.model.green_product;
import com.cos.blog.model.green_shoessize;

public interface itemimgrepository extends JpaRepository<green_img,Integer>{
	List<green_img>  findAllByProduct(green_product refer);
}
