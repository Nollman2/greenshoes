package com.cos.blog.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cos.blog.model.RoleType;
import com.cos.blog.model.green_Users;
import com.cos.blog.repository.CheckUserRepository;
import com.cos.blog.repository.UserRepository;

//스프링이 컴포넌트 스캔을 통해서 Bean에 등록을 해준다. Ioc를 해준다.
@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private CheckUserRepository checkUserRepository;
	
	@Autowired
	private BCryptPasswordEncoder encodeer;
	
	

//	
	// 카카오 회원찾기
//	@Transactional(readOnly = true)
//	public green_Users 카카오회원찾기(String username) {
//		green_Users user = userRepository.findByUsername(username).orElseGet(()-> new green_Users());
//		return user;
//	}
	//orElseGet   회원을 찾을떄 없으면 빈 객체를 리턴해라

	// 카카오 회원찾기
	@Transactional(readOnly = true)
	public green_Users 회원찾기(String username) {
		green_Users user = userRepository.findByUsername(username).orElseGet(()-> {
			return new green_Users();
		}); 
		return user;
	}
	
	
	
	@Transactional
	public void 회원가입(green_Users user) {
		String rawPassword = user.getPassword();
		String encPassword = encodeer.encode(rawPassword);
		user.setPassword(encPassword);
		userRepository.save(user); // 하나의 트랜젝션
	}

	// 회원정보 수정
	@Transactional
	public void 회원수정(green_Users user) {
		green_Users persistance = userRepository.findById(user.getId()).orElseThrow(() -> {
			return new IllegalArgumentException("회원 찾기 실패");
		});

			if(persistance.getOauth() == null || persistance.getOauth().equals("")) {
				String rawPassword=user.getPassword();
				String encPassword= encodeer.encode(rawPassword);
				persistance.setPassword(encPassword);
			}
			persistance.setEmail(user.getEmail());
			persistance.setPhonenumber(user.getPhonenumber());
			persistance.setBirthday(user.getBirthday());

		// 회원수정 메서드종료 = 서비스종료 = 트랜잭션 종료= commit
		// 영속화된 persistance 객체의 변화가 감지되면 더티체킹 되어 update문 날림.

	}

	// 회원 탈퇴
	@Transactional
	public void 회원탈퇴(int id) {
		userRepository.deleteById(id);
	}
	
	//아이디 중복체크
	@Transactional
	public green_Users 중복체크(String username) {
		green_Users check = checkUserRepository.findByUsername(username);
		return check;
	}
	
	//아이디 찾기
	@Transactional
	public green_Users 아이디찾기(green_Users user) {
		green_Users search = userRepository.findById(user.getId()).orElseGet(() -> new green_Users());
		return search;

	}
	
	

}
