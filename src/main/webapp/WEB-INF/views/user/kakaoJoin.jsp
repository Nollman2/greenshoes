<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../layout/header.jsp"%>

<!DOCTYPE html>

<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" href="/css/join.css">
<script src="http://code.jquery.com/jquery-latest.min.js"></script>


<title>회원가입</title>

<div class="container">
		<div class="box">
			<div class="bigbox">
				<div>
					<img src="/images/loginLogo.png" alt="x" class="image">
				</div>
				<br />

				<div class="text">
					<hr class="hr" />
					추가 인증 필요
					<hr class="hr" />
				</div>
				<!-- 섬네일은 아래 주소 참고 -->
				<!-- https://medium.com/@asadise/create-thumbnail-for-an-image-in-spring-framework-49776c873ea1 -->
				<form action="/auth/kakao/joinProc" method="post">
					<table class="table">
						<tr>
							<td><input type="text" name="username" placeholder="Username"></td>
						</tr>
						<tr>
							<td><input type="email" name="email" placeholder="Email"></td>
						</tr>
					</table>
					<input type="submit" value="가입완료">
				</form>

			</div>
			<div class="smallbox">
				<div class=text>
					<a href="javascript:window.history.back()" class="under1">뒤로가기</a>
				</div>
			</div>
		</div>
	</div>


<!-- onclick="joinform_check();" -->
<script src="/js/user.js"></script>


<%@ include file="../layout/footer.jsp"%>