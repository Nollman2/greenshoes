package com.cos.blog.controller.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cos.blog.config.auth.PrincipalDetail;
import com.cos.blog.dto.ItemIds;
import com.cos.blog.dto.ResponseDto;
import com.cos.blog.model.green_basket;
import com.cos.blog.repository.BasketRepository;
import com.cos.blog.service.BasketService;

@RestController
public class BasketApiController {
	@Autowired
	private BasketService basketService;
	@Autowired
	private BasketRepository basketRepository;

	@PostMapping("/api/basket/{productid}")
	public ResponseDto<Integer> basketinput(@AuthenticationPrincipal PrincipalDetail principal,@PathVariable int productid,Model model,@RequestBody green_basket basket) {
		   basketService.장바구니등록(productid,basket,principal.getUser());
		   return new ResponseDto<Integer>(HttpStatus.OK.value(),1);
	}
	@DeleteMapping("/api/basket/delete")
    public ResponseDto<Integer> deleteById(@RequestBody ItemIds itemIds){

        String itemId[] = itemIds.getItemIds().split(",");
        for(int i =0;i < itemId.length;i++) {
            System.out.println(itemId[i]);
        basketRepository.deleteById(Integer.parseInt(itemId[i]));
        }
        return new ResponseDto<Integer>(HttpStatus.OK.value(),1);
    }

}
