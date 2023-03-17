package com.cos.blog.test;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

//사용자가 요청-> 응답(Data : @RestController)
@Controller
public class HttpControllerTest {
	@GetMapping("/tmp/home")
	public String tmpHome() {
		return "/home.html";
	}
	@GetMapping("/tmp/test")
	public String tmpTest() {
		return "test";
	}
	
//	@GetMapping("/http/lombok")
//	public String lombokTest() {
//		Member m = new Member(1,"aaa","1234","email@nanana.com");
//		System.out.println("getter: "+m.getId());
//		m.setId(500);
//		System.out.println("getter: "+m.getId());
//		return "lombok test";
//	}
	
	//http:localhost:8005/http/get(select)
	@GetMapping("/http/get")
	public String getTest(Member m) { //id=1&username=kim Member 에서 자동으로 매칭
		return "get 요청"+m.getId()+"  "+m.getUsername();
	}
	//http:localhost:8005/http/post(insert)
	@PostMapping("/http/post") 
	public String postTest(@RequestBody Member m) {
		return "post 요청"+m;
	}
	//http:localhost:8005/http/put(update)
	@PutMapping("/http/put")
	public String putTest() {
		return "put 요청";
	}
	//http:localhost:8005/http/delete(delete)
	@DeleteMapping("/http/delete")
	public String deleteTest() {
		return "delete 요청";
	}
	
}
