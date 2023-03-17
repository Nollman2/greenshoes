package com.cos.blog.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.cos.blog.model.green_Users;
import com.cos.blog.model.green_question;

public interface QuestionRepository extends JpaRepository<green_question,Integer>{

	@Modifying
	 @Query("update green_question p set p.count = p.count + 1 where p.id = :id")
	 int updateCount(int id);

	List<green_question> findByTitleContaining(String keyword);

	List<green_question> findByContentsContaining(String keyword);

	Page<green_question> findByTitleContaining(String keyword, Pageable pageable);

	Page<green_question> findByContentsContaining(String keyword, Pageable pageable);

	

	
}
