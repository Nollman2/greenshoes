package com.cos.blog.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import com.cos.blog.model.KakaoProfile;
import com.cos.blog.model.OAuthToken;
import com.cos.blog.model.green_Users;
import com.cos.blog.service.UserService;
import com.cos.blog.test.Member;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;


@Controller
public class UserController {
	
	
	
	@Autowired
	private UserService userService;
	
	@Value("${cos.key}")
	private String cosKey;
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	
	
	@GetMapping("/auth/joinForm")
	public String joinForm() {
		return "user/joinForm";
	}
	@GetMapping("/auth/loginForm")
	public String loginForm() {
		return "user/loginForm";
	}
	
//	@GetMapping("/auth/main")
//	public String main() {
//		return "index";
//	}
	
	@GetMapping("/user/updateForm")
	public String updateForm() {
		return "user/updateForm";
	}
	
	@GetMapping("/auth/out")
	public String out() {
		return "user/out";
	}
	
	@GetMapping("/user/mypage")
	public String mypage() {
		return "user/mypage";
	}
//	@GetMapping("/")
//	public String Form() {
//		return "index";
//	}

	@GetMapping("/user/OrderStatus")
	public String OrderStatus() {
		return "user/OrderStatus";
	}
	
	@GetMapping("/user/selectProduct")
	public String selectProduct() {
		return "user/selectProduct";
	}
	
	@GetMapping("/auth/search_id")
	public String idsearch() {
		return "user/search_id";
	}
	
	
	
	
	
	
	
	
	
	//카카오 로그인
	@GetMapping("/auth/kakao/callback")
	public  String kakaoCallback(String code) { //Date를 리턴해주는 컨트롤러 함수
		//POST방식으로 key=value 데이터를 요청(카카오쪽으로)
		RestTemplate rt = new RestTemplate();//http요청을 편하게 할 수 있음
		
		//HttpHeader 오브젝트 생성
		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-type","application/x-www-form-urlencoded;charset=utf-8");
		
		//HttpBody 오브젝트 생성
		
		MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
		params.add("grant_type", "authorization_code");
		params.add("client_id", "8379262af351efcfd484fe086c959b51");
		params.add("redirect_uri", "http://localhost:8006/auth/kakao/callback");
		params.add("code", code);

		//HttpHeader와 HttpBody를 하나의 오브젝트에 담기
		HttpEntity<MultiValueMap<String, String>> kakaoTokenRequest = 
				new HttpEntity<>(params,headers);
		
		//Http 요청하기 - Post방식으로 -그리고 response 변수의 응답 받음.
		ResponseEntity<String> response = rt.exchange(
				"https://kauth.kakao.com/oauth/token",
				HttpMethod.POST,
				kakaoTokenRequest,
				String.class
				);
		
		//Gson,Json,Simple,ObjectMapper
		ObjectMapper objectMapper = new ObjectMapper();
		OAuthToken oauthToken = null;
		try {
			oauthToken = objectMapper.readValue(response.getBody(), OAuthToken.class);
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		
		System.out.println("카카오 엑세스 토큰 : " + oauthToken.getAccess_token());
		
		RestTemplate rt2 = new RestTemplate();//http요청을 편하게 할 수 있음
		
		//HttpHeader 오브젝트 생성
		HttpHeaders headers2 = new HttpHeaders();
		headers2.add("Authorization","Bearer "+oauthToken.getAccess_token());
		headers2.add("Content-type","application/x-www-form-urlencoded;charset=utf-8");
		

		//HttpHeader와 HttpBody를 하나의 오브젝트에 담기
		HttpEntity<MultiValueMap<String, String>> kakaoProfileRequest2 = 
				new HttpEntity<>(headers2);
		
		//Http 요청하기 - Post방식으로 -그리고 response 변수의 응답 받음.
		ResponseEntity<String> response2 = rt2.exchange(
				"https://kapi.kakao.com/v2/user/me",
				HttpMethod.POST,
				kakaoProfileRequest2,
				String.class
				);
		
		ObjectMapper objectMapper2 = new ObjectMapper();
		KakaoProfile kakaoProfile = null;
		try {
			kakaoProfile = objectMapper2.readValue(response2.getBody(), KakaoProfile.class);
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		
		green_Users kakaoUser = green_Users.builder()
				.username(kakaoProfile.getKakao_account().getEmail()+"_"+kakaoProfile.getId())
				.password(cosKey)
				.email(kakaoProfile.getKakao_account().getEmail())
				.birthday("null")
				.phonenumber("null")
				.userid(kakaoProfile.getProperties().getNickname())
				.oauth("kakao")
				.build();
		
		green_Users originUser = userService.회원찾기(kakaoUser.getUsername());
		
		System.out.println(originUser);
		
		 if(originUser.getUsername() == null) {
		 System.out.println("기존 회원이 아닙니다..........."); 
		 userService.회원가입(kakaoUser); 
		 }
		 
		 Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(kakaoUser.getUsername(),cosKey));
		 SecurityContextHolder.getContext().setAuthentication(authentication);
			
		return "redirect:/";
	}
}
