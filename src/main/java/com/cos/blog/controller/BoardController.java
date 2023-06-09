package com.cos.blog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import com.cos.blog.service.BoardService;

@Controller
public class BoardController {
	
	@Autowired
	private BoardService boardService;		
	
//	@GetMapping({"","/"})
//	public String index() {
//		return "index";
//	}
	
	@GetMapping({"/board/saveForm"})
	public String saveForm() {
		return "board/saveForm";
	}
	
	@GetMapping({"/board/questionSaveForm"})
	public String questionSaveForm() {
		return "board/questionSaveForm";
	}	
		
	
	//게시글 조회
	@GetMapping("/board/csboard")
	public String index(Model model,@PageableDefault(size= 10, sort = "id",
	direction = Sort.Direction.DESC) Pageable pageable) {
		model.addAttribute("boards",boardService.글목록(pageable));			
		return "board/cs";
	}
	
	//게시글 상세보기
	@GetMapping("/board/{id}")
	public String findById(@PathVariable int id, Model model) {
		model.addAttribute("board",boardService.글상세보기(id));
		boardService.updateCount(id);
		return "board/detail";
	}
	
	//게시글 수정
	@GetMapping("/board/{id}/updateForm")
	public String UpdateForm(@PathVariable int id,Model model) {
		model.addAttribute("board",boardService.글상세보기(id));
		return "board/updateForm";
	}
		
	//게시글 검색
	@GetMapping("/board/search")
	public String searchcontent(@RequestParam(value="keyword")String keyword,
								@RequestParam(value="searchtype")String searchtype,								
								Model model) {
		System.out.println("board/search 결과 "+boardService.searchpost(keyword,searchtype));
		model.addAttribute("board", boardService.searchpost(keyword,searchtype));
		return "board/cs";
	}		
	
	
	//이벤트게시판 열기
	@GetMapping("/event")
		public String event() {
		return "board/eventboard";
	}
	
	
	

}
