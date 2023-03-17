package com.cos.blog.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cos.blog.model.green_Users;
import com.cos.blog.model.green_question;
import com.cos.blog.model.green_reply;
import com.cos.blog.repository.QuestionRepository;
import com.cos.blog.repository.ReplyRepository;

@Service
public class ReplyService {

	@Autowired
	private QuestionRepository questionRepository;

	@Autowired
	private ReplyRepository replyRepository;

	// 댓글쓰기
	@Transactional
	public void 댓글쓰기(green_Users user, int questionId, green_reply requestReply) {

		green_question question = questionRepository.findById(questionId).orElseThrow(() -> {
			return new IllegalArgumentException("글 찾기 실패");
		});

		requestReply.setQuestion(question);
		requestReply.setUsers(user);

		replyRepository.save(requestReply);
	}

	// 댓글삭제
	@Transactional
	public void 댓글삭제(int replyId) {
		replyRepository.deleteById(replyId);
	}

}
