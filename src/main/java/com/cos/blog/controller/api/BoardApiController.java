package com.cos.blog.controller.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cos.blog.config.auth.PrincipalDetail;
import com.cos.blog.dto.ResponseDto;
import com.cos.blog.model.green_notice;
import com.cos.blog.service.BoardService;

@RestController
public class BoardApiController {
	
	@Autowired
	private BoardService boardService;
			
	
	//게시글 작성
	@PostMapping("/api/board")
	public ResponseDto<Integer> save(@RequestBody green_notice board,@AuthenticationPrincipal PrincipalDetail principal) {
		boardService.글쓰기(board,principal.getUser());
		return new ResponseDto<Integer>(HttpStatus.OK.value(),1);
	}	
	
	//게시글 수정
	@PutMapping("api/board/{id}")
	public ResponseDto<Integer> update(@PathVariable int id,@RequestBody green_notice board){
		boardService.글수정하기(id,board);
		return new ResponseDto<Integer>(HttpStatus.OK.value(),1);
	}		
	
	//게시글 삭제
		@DeleteMapping("/api/board/{id}") 
		public ResponseDto<Integer> deleteById(@PathVariable int id) {
			boardService.글삭제하기(id);
			return new ResponseDto<Integer>(HttpStatus.OK.value(),1);
		}
	
	
}
