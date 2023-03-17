package com.cos.blog.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cos.blog.model.green_Users;
import com.cos.blog.model.green_question;
import com.cos.blog.repository.QuestionRepository;
import com.cos.blog.repository.UserRepository;

@Service
public class QuestionService {
		
	
	@Autowired
	private QuestionRepository questionRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	//문의글 조회
	public Page<green_question> 질문목록(Pageable pageable) {
		return questionRepository.findAll(pageable);
	}	
	
	//문의글 작성
	@Transactional
	public void 질문하기(green_question question,green_Users user) {			
		
		question.setUser(user);
		questionRepository.save(question);
	}	
	

	//문의글 상세보기
	public green_question 문의상세보기(int id) {
		return questionRepository.findById(id)
				.orElseThrow(()->{
					return new IllegalArgumentException("글상세보기 실패");
				});
	}		

	//문의글 수정
	@Transactional
	public void 질문수정하기(int id,green_question requestBoard) {
		green_question board = questionRepository.findById(id).orElseThrow(()->{
			return new IllegalArgumentException("글찾기 실패");
		});
	board.setTitle(requestBoard.getTitle());
	board.setContents(requestBoard.getContents());
	}	
	
	//문의글 삭제
	@Transactional
	public void 글삭제하기(int id) {
		questionRepository.deleteById(id);
	}
	
	//문의글 조회수 증가
	@Transactional
    public int updateCount(int id) {
        return questionRepository.updateCount(id);
    }
	
	//문의글 검색
	@Transactional
	public Page<green_question> searchpost(String keyword,String searchtype,Pageable pageable){
		Page<green_question> listboard = null;
		
		switch(searchtype) {
			case "title" :{
				 listboard = questionRepository.findByTitleContaining(keyword,pageable);
				break;
			}
			case "content":{
				 listboard = questionRepository.findByContentsContaining(keyword,pageable);
				break;
			}
			case "user":{
				List<green_Users> searchuser =userRepository.findByUsernameContaining(keyword);
				System.out.println(searchuser.get(1).getId());
				System.out.println(searchuser.get(0).getId());			
						
						
				//listboard = questionRepository.findByUser(searchuser.get(0));
				
					
			
								
						
						
				break;
				
				
				
				
//				listboard = (Page<green_question>) questionRepository.findByUser(searchuser,pageable);
//				break;
			}
		}
		
		return listboard;
	}

}
