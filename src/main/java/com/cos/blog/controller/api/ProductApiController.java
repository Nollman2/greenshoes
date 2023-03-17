//package com.cos.test.controller.api;
//
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.cos.test.dto.ResponseDto;
//import com.cos.test.model.green_product;
//import com.cos.test.service.ProductService;
//
//@RestController
//public class ProductApiController {
//	@Autowired
//	private ProductService productService;
//	
//	@PostMapping("api/product")
//	public ResponseDto<Integer> save(@RequestBody green_product product) {
//		productService.상품목록(product);
//		return new ResponseDto<Integer>(HttpStatus.OK.value(),1);
//	}
//	
//	
//
//}
