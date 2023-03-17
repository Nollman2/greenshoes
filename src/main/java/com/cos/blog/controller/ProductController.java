package com.cos.blog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.cos.blog.config.auth.PrincipalDetail;
import com.cos.blog.service.ItemService;
import com.cos.blog.service.ProductService;

@Controller
public class ProductController {
	
	@Autowired
	private ProductService productService;
	@Autowired
	private ItemService itemservice;
	
	@GetMapping({"","/","/auth/main"})
	public String findbyId(@PageableDefault(size=8,sort="id",direction= Sort.Direction.ASC) Pageable pageable,Model model,@AuthenticationPrincipal  PrincipalDetail principal) {
		model.addAttribute("green_product",productService.상품목록(pageable));
		if(principal!=null) {
			model.addAttribute("historys",itemservice.기록보기(pageable,principal.getUser()));			
		}
		return "index"; 
	}
	@GetMapping("/auth/product")
	public String findAll(@PageableDefault(size=6,sort="id",direction= Sort.Direction.ASC) Pageable pageable,Model model) {
		model.addAttribute("products",productService.추천상품(pageable));
		return "product/product"; 
	}
	@GetMapping("/auth/product/{id}")
	public String productupdate(@PathVariable int id,Model model) {
		model.addAttribute("product",productService.상품상세보기(id));
		model.addAttribute("size",productService.사이즈(id));
		model.addAttribute("subimgs",productService.서브이미지(id));
		return "product/product";
	}

	

	
}
