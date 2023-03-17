package com.cos.blog.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.cos.blog.model.green_Users;
import com.cos.blog.model.searchhistory;

public interface historyRepository  extends JpaRepository<searchhistory,Integer>{

	Page<searchhistory> findByUsers(green_Users user, Pageable pageable);

}
