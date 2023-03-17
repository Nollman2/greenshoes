package com.cos.blog.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cos.blog.model.green_Users;
import com.cos.blog.model.green_basket;
import com.cos.blog.model.green_product;
import com.cos.blog.repository.BasketRepository;
import com.cos.blog.repository.ProductRepository;
@Service
public class BasketService {
	@Autowired
	private ProductRepository productRepository;
	@Autowired
	private BasketRepository basketRepository;

	
	@Transactional(readOnly=true)
	public Page<green_basket> 장바구니확인하기(Pageable pageable){
		return basketRepository.findAll(pageable);
	}
	@Transactional
	public void 장바구니등록(int id,green_basket basket,green_Users user) {
		green_product refer= productRepository.findById(id).orElseThrow(()->{
			return new IllegalArgumentException("장바구니등록실패");
		});
		basket.setProduct(refer);
		basket.setUsers(user);
		basketRepository.save(basket);
	}
	
	
	
	

	


	

	
}
