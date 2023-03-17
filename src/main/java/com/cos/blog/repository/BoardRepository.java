package com.cos.blog.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.cos.blog.model.green_Users;
import com.cos.blog.model.green_notice;

public interface BoardRepository extends JpaRepository<green_notice,Integer> {

	 @Modifying
	 @Query("update green_notice p set p.count = p.count + 1 where p.id = :id")
	 int updateCount(int id);

	List<green_notice> findByContentsContaining(String keyword);

	List<green_notice> findByTitleContaining(String keyword);

	Page<green_notice> findByTitleContaining(String keyword, Pageable pageable);

	
	Page<green_notice> findByContentsContaining(String keyword, Pageable pageable);

	Page<green_notice> findByUser(green_Users searchuser, Pageable pageable);
	
	List<green_notice> findByUser(green_Users searchuser);

	

	

	

	

}
