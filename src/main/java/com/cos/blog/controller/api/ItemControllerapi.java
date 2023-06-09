package com.cos.blog.controller.api;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.cos.blog.config.auth.PrincipalDetail;
import com.cos.blog.dto.ResponseDto;
import com.cos.blog.model.green_product;
import com.cos.blog.model.green_shoessize;
import com.cos.blog.service.ItemService;

@RestController
public class ItemControllerapi {
	@Autowired
	private ItemService itemservice;

	
	@PostMapping("/api/itemimg")
	public ResponseDto<Integer> saveimg(@RequestPart MultipartFile img) throws IOException{
		itemservice.이미지저장(img);
		return new ResponseDto<Integer>(HttpStatus.OK.value(),1);
	}
	@PostMapping("/api/itemimgold")
	public ResponseDto<Integer> saveimgold(@RequestPart MultipartFile img) throws IOException{
		itemservice.이미지저장(img);
		return new ResponseDto<Integer>(HttpStatus.OK.value(),1);
	}
	@PostMapping("/api/item")
	public ResponseDto<Integer> save(@RequestBody green_product pd){
	itemservice.상품입력(pd);
	return new ResponseDto<Integer>(HttpStatus.OK.value(),1);
	}
	@PostMapping("/api/itemold")
	public ResponseDto<Integer> saveold(@RequestBody green_product pd){
	itemservice.상품입력old(pd);
	return new ResponseDto<Integer>(HttpStatus.OK.value(),1);
	}
	
	@PutMapping("/api/item/{id}")
	public ResponseDto<Integer> update(@PathVariable int id,@RequestBody green_product pd){
		itemservice.상품수정(id,pd);
		return new ResponseDto<Integer>(HttpStatus.OK.value(),1);
	}
	
	@DeleteMapping("/api/item/{id}")
	public ResponseDto<Integer> delete(@PathVariable int id){
		itemservice.상품삭제(id);
		return new ResponseDto<Integer>(HttpStatus.OK.value(),1);
		
	}
	@PostMapping("/api/itemsize/{productid}")
	public ResponseDto<Integer> stockinput(@PathVariable int productid,@RequestBody green_shoessize green_shoessize){
		itemservice.재고입력(green_shoessize, productid);
		return new ResponseDto<Integer>(HttpStatus.OK.value(),1);
		}
	@PutMapping("/api/itemsize/{id}")
	public ResponseDto<Integer> stockupdate(@PathVariable int id,@RequestBody green_shoessize green_shoessize){
		itemservice.재고변경(id,green_shoessize);
		return new ResponseDto<Integer>(HttpStatus.OK.value(),1);
	}
	@PostMapping("/api/checking")
	public ResponseDto<Integer> checkingname(@RequestBody String productname){
		int i =0;
		if(itemservice.상품확인(productname)!=null) {
			i=itemservice.상품확인(productname).getId();
		}
		return new ResponseDto<Integer>(HttpStatus.OK.value(),i);
	
	}
	@PostMapping("/auth/history")
	public ResponseDto<Integer> searchhistory(@RequestBody String searchhistory,@AuthenticationPrincipal  PrincipalDetail principal){
		itemservice.기록입력(searchhistory,principal.getUser());
		return new ResponseDto<Integer>(HttpStatus.OK.value(),1);
	}
	@DeleteMapping("/auth/delhistory/{id}")
	public ResponseDto<Integer> deletehistory(@PathVariable int id){
		itemservice.기록삭제(id);
		return new ResponseDto<Integer>(HttpStatus.OK.value(),1);
	}


	
}
