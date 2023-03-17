<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../layout/header.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>

<script src="http://code.jquery.com/jquery-latest.min.js"></script>

<meta charset="UTF-8">
<link rel="stylesheet" href="../css/reset.css">
<link rel="stylesheet" href="../css/search_id.css">

<title>Insert title here</title>


<div id="userid_search">
	<h2>아이디 찾기</h2>
	<form action="/auth/user/search" id=createForm name="createForm" >
		<input type="text" name="userid" id="userid"
			placeholder="이름을 입력해 주세요."
			style="border: 0 solid black; border-bottom: 1px solid rgb(180, 178, 178);">
		<input type="text" name="phonenumber" id="phonenumber"
			placeholder="휴대폰 번호를 '-' 없이 입력해주세요" maxlength="11"  
			style="border: 0 solid black; border-bottom: 1px solid rgb(180, 178, 178);">
		</p>
<a onclick="searchuserid()"><span>아이디 찾기</span></a>
	</form>

	<div id="userid_search_info">
		<div class="search_info">
			아직 회원이 아니신가요?
			<!-- <br><br><br>비밀번호를 잊으셨나요? -->
		</div>

		<div class="search_button">
			<a href="/auth/joinForm"><button type="button" id="searchbtn1">회원가입</button></a><br>
			<!-- <button type="button" id="searchbtn2">비밀번호 찾기</button> -->
		</div>
	</div>
</div>


<script src="/js/user.js"></script>
<%@ include file="../layout/footer.jsp"%>