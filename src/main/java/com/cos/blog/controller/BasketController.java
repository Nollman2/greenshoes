package com.cos.blog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.cos.blog.config.auth.PrincipalDetail;
import com.cos.blog.repository.UserRepository;

@Controller
public class BasketController {

	@Autowired
	private UserRepository userRepository;
	
	@GetMapping({"/auth/basket"})
	public String findById(@AuthenticationPrincipal PrincipalDetail principal,Model model) {
		model.addAttribute("baskets",userRepository.findById(principal.getUser().getId()).orElseThrow().getBaskets());
		return "/product/basket"; 
	}

	
	
}
