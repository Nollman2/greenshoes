package com.cos.blog.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.cos.blog.model.green_basket;
import com.cos.blog.repository.BasketRepository;

@Controller
public class OrderController {

	@Autowired
	private BasketRepository basketRepository;
	
	 @GetMapping("/api/order/{itemIds}")
	    public String order(@PathVariable String itemIds,Model model) throws IOException{
	      List<green_basket> baskets = new ArrayList<>();
	      String itemId[]= itemIds.split(",");
	      for(int i =0;i <itemId.length ;i++) {
	         green_basket basket =basketRepository.findById(Integer.parseInt(itemId[i])).orElseThrow();
	         baskets.add(basket);
	      }
	      model.addAttribute("baskets", baskets);
	      return "/product/buy";
	    } 


}
