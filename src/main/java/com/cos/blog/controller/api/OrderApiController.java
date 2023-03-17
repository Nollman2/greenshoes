package com.cos.blog.controller.api;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cos.blog.config.auth.PrincipalDetail;
import com.cos.blog.dto.ItemIds;
import com.cos.blog.dto.ResponseDto;
import com.cos.blog.model.green_basket;
import com.cos.blog.repository.BasketRepository;

@RestController
public class OrderApiController {

	@Autowired
	private BasketRepository basketRepository;
	
	@PostMapping("/api/order")
    public ResponseDto<Integer> order1(@RequestBody ItemIds itemIds,@AuthenticationPrincipal  PrincipalDetail principal) throws IOException{
      List<green_basket> baskets = new ArrayList<>();
      String itemId[]= itemIds.getItemIds().split(",");
      String amount[] =itemIds.getAmounts().split(",");
      for(int i =0;i <itemId.length ;i++) {
         green_basket basket =basketRepository.findById(Integer.parseInt(itemId[i])).orElseThrow();
         basket.setAmount(Integer.parseInt(amount[i]));
         baskets.add(basket);
      }
      basketRepository.saveAll(baskets);
      return new ResponseDto<Integer>(HttpStatus.OK.value(),1);
    } 

	

}
