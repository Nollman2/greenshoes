package com.cos.blog.test;

import java.util.List;
import java.util.function.Supplier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cos.blog.model.RoleType;
import com.cos.blog.model.green_Users;
import com.cos.blog.repository.UserRepository;

@RestController
public class DummyControllerTest {
	@Autowired // 의존성 주입(DI)
	private UserRepository userRepository;
	
	@DeleteMapping("/dummy/user/{id}")
	public String delete(@PathVariable int id) {
		try {
		userRepository.deleteById(id);
		}catch(EmptyResultDataAccessException e) {
		return "삭제 실패하였습니다. 해당 id는 없습니다. id: "+id;
		}
		return  "삭제되었습니다. id: "+id;
	}
	
	@PutMapping("/dummy/user/{id}")
	public green_Users updateUser(@PathVariable int id, @RequestBody green_Users requestUser) {
		System.out.println("id : "+id);
		System.out.println("password : "+requestUser.getPassword());
		System.out.println("email : "+requestUser.getEmail());
		
		green_Users user=userRepository.findById(id).orElseThrow(()->{
			return new IllegalArgumentException("수정에 실패하였습니다.");
		});
		user.setPassword(requestUser.getPassword());
		user.setEmail(requestUser.getEmail());
		user.setUsername(requestUser.getUsername());
		
		userRepository.save(user);
		return null;
	}
	
	// http://localhost:8005/blog/dummy/user/page?page=0
		@GetMapping("/dummy/user/page")
		public List<green_Users> pageList(
				@PageableDefault(size = 2, sort = "id", direction = Sort.Direction.DESC) 
				Pageable pageable) {
			Page<green_Users> pagingUSer = userRepository.findAll(pageable);
			if (pagingUSer.isLast()) {
				System.out.println("마지막 요소입니다.");
			}
			List<green_Users> users = pagingUSer.getContent();
			return users;
		}
	
	@PostMapping("/dummy/join")
	public String join(green_Users users) {
		// key=value(약속된 규칙)
		System.out.println("id: " + users.getId());
		System.out.println("username: " + users.getUsername());
		System.out.println("password: " + users.getPassword());
		System.out.println("email: " + users.getEmail());
		System.out.println("role: " + users.getRoles());
		System.out.println("createDate: " + users.getCreateDate());

		users.setRoles(RoleType.USER);
		userRepository.save(users);
		return "회원가입이 완료되었습니다.";
	}
	// {id}주소로 파라미터를 전달 받을 수 있다.
		// http://localhost:8005/blog/dummy/user/3
		@GetMapping("/dummy/user/{id}")
		public green_Users detail(@PathVariable int id) {
			// DB에는 id가 4까지 밖에 없는데 만약 주소에 5를 넣으면 null이 리턴이 될것인데
			// 그러면 에러가 발생하게되니 optional로 감싸서 리턴된다.
			// 그렇기 때문에 리턴 전에 null인지 아닌지 판단이 필요하다.
			green_Users user = userRepository.findById(id).orElseThrow(new Supplier<IllegalArgumentException>() {
				@Override
				public IllegalArgumentException get() {
					return new IllegalArgumentException("해당 유저는 없습니다. id: " + id);
				}
			});
			return user;// 리턴 타입이 optional이라 변환이 필요;
		}
}
