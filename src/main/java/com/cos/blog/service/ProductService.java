package com.cos.blog.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cos.blog.model.green_img;
import com.cos.blog.model.green_product;
import com.cos.blog.model.green_shoessize;
import com.cos.blog.repository.ProductRepository;
import com.cos.blog.repository.itemStockRepository;
import com.cos.blog.repository.itemimgrepository;

@Service
public class ProductService {
	
	@Autowired
	private ProductRepository productRepository;
	@Autowired
	private itemStockRepository itemstockRepository;
    @Autowired
    private itemimgrepository itemimgrepository;
	
	
	@Transactional(readOnly=true)
	public  Page<green_product> 상품목록(Pageable pageable){
		return productRepository.findAll(pageable);
	}

	@Transactional(readOnly=true)
	public  Page<green_product> 추천상품(Pageable pageable){
		return productRepository.findAll(pageable);
	}
	@Transactional
	public green_product 상품상세보기(int id) {
		return productRepository.findById(id)
				.orElseThrow(()-> {
					return new IllegalArgumentException("상품상세보기실패");
				});
	}
	@Transactional
	public green_product 상품정보(int id) {
		return productRepository.findById(id)
				.orElseThrow(()-> {
					return new IllegalArgumentException("상품담기실패");
				});
	}
	@Transactional
	public List<green_shoessize>사이즈 (int id){
		green_product refer=productRepository.findById(id)
		.orElseThrow(()-> {
			return new IllegalArgumentException("상품담기실패");
		});
		return itemstockRepository.findAllByProduct(refer);
	}
	@Transactional
	public List<green_img>서브이미지(int id){
		green_product refer=productRepository.findById(id)
				.orElseThrow(()->{
					return new IllegalArgumentException("서브이미지담기실패");
				});
		return itemimgrepository.findAllByProduct(refer);
	}
	



}
