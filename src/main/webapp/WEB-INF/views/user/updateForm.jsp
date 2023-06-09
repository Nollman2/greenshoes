<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../layout/header.jsp"%>
<link rel="stylesheet" href="/css/updateForm.css">

  <div class="join-wrapper">
    <h3><img src="/img/greenshoeslogo.jpg"></h3>
    <form id="join-form" action="/auth/user" method="POST">
	  <input type="hidden" id="id" value="${principal.user.id}"/>
	  <div class="info_name">이름</div>
      <input type="text" name="userid" id="userid" placeholder="이름 입력" readonly value="${principal.user.userid}">
	  <div class="info_name">아이디</div>
        <input type="text" name="username" id="username" placeholder="아이디 입력(6~20자)" readonly value="${principal.user.username}">
	
	 
	 
	 
	 <c:if test="${empty principal.user.oauth}">
	 	<div class="info_name">비밀번호</div>
      	<input type="password" name="password" id="password" placeholder="새로운 비밀번호 입력(문자,숫자,특수문자 포함 8~20자)">
      	<div class="info_name">비밀번호 확인</div>
      	<input type="password" name="pwd_check" placeholder="비밀번호 확인">
      </c:if>
      
      <div class="info_name">휴대폰 번호</div>
      <span id="phone1"><input type="text" name="phonenumber" id="phonenumber" placeholder="휴대폰 번호 입력('-'제외 11자리 입력)" maxlength="11" value="${principal.user.phonenumber}"></span>
	  <div class="info_name">생일</div>
	  <input type="text" name="birthday" id="birthday"
				placeholder="년, 월, 일 8자리 입력 (예: 20181020)" maxlength="8" value="${principal.user.birthday}">
	  <div class="info_name">이메일</div>
      <div class="info_email">
				<input type="text" name="email" id="email" placeholder="이메일 주소" value="${principal.user.email}">
	  </div>
	  
	  
	  
	

    </form>
    <button id="btn-update"class="btn btn-primary">회원 정보 변경</button>
  </div>



<script src="/js/user.js"></script>

<%@ include file="../layout/footer.jsp"%>

