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
import com.cos.blog.model.green_question;
import com.cos.blog.model.green_reply;
import com.cos.blog.service.QuestionService;
import com.cos.blog.service.ReplyService;

@RestController
public class QuestionApiController {
	
	@Autowired
	private QuestionService questionService;
		
	@Autowired
	private ReplyService replyService;
	
	//문의글 작성
	@PostMapping("/api/question")
	public ResponseDto<Integer> savequestion(@RequestBody green_question question, @AuthenticationPrincipal PrincipalDetail principal) {
		questionService.질문하기(question,principal.getUser());
		return new ResponseDto<Integer>(HttpStatus.OK.value(),1);
	}		
	
	//문의글 수정
	@PutMapping("api/question/{id}")
	public ResponseDto<Integer> questionupdate(@PathVariable int id,@RequestBody green_question board){
		questionService.질문수정하기(id,board);
		return new ResponseDto<Integer>(HttpStatus.OK.value(),1);
	}
	
	//문의글 삭제
	@DeleteMapping("/api/question/{id}") 
	public ResponseDto<Integer> deleteById(@PathVariable int id) {
		questionService.글삭제하기(id);
		return new ResponseDto<Integer>(HttpStatus.OK.value(),1);
	}
	
			
	
	//댓글 쓰기
	@PostMapping("/api/reply/{questionId}")
	public ResponseDto<Integer> replySave(@PathVariable int questionId,
						@RequestBody green_reply reply,
						@AuthenticationPrincipal PrincipalDetail principal
						) {		
		replyService.댓글쓰기(principal.getUser(),questionId,reply);
		return new ResponseDto<Integer>(HttpStatus.OK.value(),1);
	}
	
	//댓글 삭제
	@DeleteMapping("/api/{boardId}/reply/{replyId}")
	public ResponseDto<Integer> replyDelete(@PathVariable int replyId) {
		replyService.댓글삭제(replyId);
		return new ResponseDto<Integer>(HttpStatus.OK.value(),1);
	}

}
