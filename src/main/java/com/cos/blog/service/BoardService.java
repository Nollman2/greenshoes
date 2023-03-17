package com.cos.blog.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cos.blog.model.green_Users;
import com.cos.blog.model.green_notice;
import com.cos.blog.repository.BoardRepository;
import com.cos.blog.repository.UserRepository;

@Service
public class BoardService {

	@Autowired
	private BoardRepository boardRepository;

	@Autowired
	private UserRepository userRepository;

	// 게시글 조회
	public Page<green_notice> 글목록(Pageable pageable) {
		return boardRepository.findAll(pageable);
	}

	// 게시글 작성
	@Transactional
	public void 글쓰기(green_notice board, green_Users user) {
		board.setCount(0);
		board.setUser(user);
		boardRepository.save(board);
	}

	// 게시글 상세보기
	public green_notice 글상세보기(int id) {
		return boardRepository.findById(id).orElseThrow(() -> {
			return new IllegalArgumentException("글상세보기 실패");
		});
	}

	// 게시글 수정
	@Transactional
	public void 글수정하기(int id, green_notice requestBoard) {
		green_notice board = boardRepository.findById(id).orElseThrow(() -> {
			return new IllegalArgumentException("글찾기 실패");
		});
		board.setTitle(requestBoard.getTitle());
		board.setContents(requestBoard.getContents());
	}

	// 게시글 삭제
	@Transactional
	public void 글삭제하기(int id) {
		boardRepository.deleteById(id);
	}

	// 게시글 조회수 증가
	@Transactional
	public int updateCount(int id) {
		return boardRepository.updateCount(id);
	}

	// 게시글 검색
	@Transactional
	public List<green_notice> searchpost(String keyword, String searchtype) {
		
		List<green_notice> listboard = null;

		switch (searchtype) {
			case "title": {
				listboard = boardRepository.findByTitleContaining(keyword); //  리스트로 받음
				System.out.println("게시글 검색 title" +listboard);
				break;
			}
			case "content": {
				listboard = boardRepository.findByContentsContaining(keyword);
				System.out.println("게시글 검색 content" +listboard);
				break;
			}
			case "user": {			 				
				List<green_Users> searchuser =userRepository.findByUsernameContaining(keyword);						
								
				listboard=new ArrayList<green_notice>();			
								
				for(int i =0 ; i<searchuser.size();i++) { 				
					for(int j=0;j<boardRepository.findByUser(searchuser.get(i)).size();j++) { 												
						listboard.add(boardRepository.findByUser(searchuser.get(i)).get(j)); 						
					}
				}												
				break;
			}
			
		}

		return listboard;
	}

}
