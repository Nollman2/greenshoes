<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../layout/header.jsp"%>
<!DOCTYPE html>

<meta charset="UTF-8">
<link rel="stylesheet" href="/css/login.css">

<script src="https://developers.kakao.com/sdk/js/kakao.js"></script>
<script src="https://static.nid.naver.com/js/naveridlogin_js_sdk_2.0.2.js"
	charset="utf-8"></script>
	

<title>로그인</title>

	<div class="login-wrapper">

		<h3>
			<img src="/img/greenshoeslogo.jpg">
		</h3>
		<form action="/auth/loginProc" method="POST" id="login-form"
			name="login-form">

			<input type="text" name="username" id="username" size="30"
				placeholder="아이디를 입력해주세요">
			
			<input type="password"
				name="password" id="password" size="30" placeholder="비밀번호를 입력해주세요">
			
			<label for="remember-check"> <input type="checkbox"
				name="remember" id="remember">&nbsp;아이디 저장
			</label>
			<button type="submit" onclick="loginform_check();">로그인</button>
			<!--  -->
		</form>

		<div class="join">
			<ul>
				<li class="look_box"><a href="/auth/search_id" class=look_link>아이디
						찾기</a></li>
				<li>|</li>
				<li class="look_box"><a href="/auth/joinForm" class=look_link>회원
						가입</a></li>
			</ul>

		</div>

		<div class="social_login">

			<ul>
				<li>
					<a href="https://kauth.kakao.com/oauth/authorize?client_id=8379262af351efcfd484fe086c959b51&redirect_uri=http://localhost:8006/auth/kakao/callback&response_type=code" >
						<div>
							<img src="/image/kakao_login.png"   style="width: 250px; height: 40px">
							<!--  <span class="social_loginname">카카오 로그인</span>-->
						</div>
					</a>

				<!--  
				<span th:if="${userId!=null}" >
						<form name="logout"  action="http://localhost:8006/logout">
						<input type="submit" value="로그아웃">
						</form>
				</span>
				-->
				
				</li>
			</ul>
		</div>
	</div>



	<script>
		//joinform_check 함수로 유효성 검사
		function loginform_check() {
			//변수에 담아주기
			var username = document.getElementById("username");
			var password = document.getElementById("password");
			var remember_check = document.getElementById("rememberCheck");

			if (username.value == "") {
				alert("아이디를 입력하세요.");
				username.focus();
				return false;
			};

			if (password.value == "") {
				alert("비밀번호를 입력하세요.");
				password.focus();
				return false;
			};
			
		}
	</script>

		<%@ include file="../layout/footer.jsp"%>
