<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<sec:authorize access="isAuthenticated()">
	<sec:authentication property="principal" var="principal" />
</sec:authorize>


<!DOCTYPE html>
<html lang="ko">
<head>
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
<link rel="icon" type="image/png" sizes="192x192"
	href="images/favicon/android-icon-192x192.png">
<link rel="stylesheet" href="/css/header.css">
<link rel="stylesheet" href="/css/reset.css">

<script
	src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>

<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Green Shoes</title>


</head>
<body>
	<div class="header">
		<div class="headermain">
			<div class="header_logo">
				<a href="/"><img src="/images/reallogo.png" alt="logo"
					id="logo"></a>
			</div>
			<div id="search">
				<div id="searchbox">
			 <c:choose>
				<c:when test="${empty principal}">
				
							 <div id="box">
           					  	 <input type="text" placeholder="검색어를 입력해 주세요" id="searchinput"  >
            					 <button type="button" id="search-icon" onclick="dd2()"><img src="/images/searchicon2.png" width="70%" height="70%"></button>
         					 </div>
				</c:when>

				<c:otherwise>
							<div id="box">
           						   <input type="text" placeholder="검색어를 입력해 주세요" id="searchinput" onfocus="liston()" >
          						    <button type="button" id="search-icon" onclick="dd()"><img src="/images/searchicon2.png" width="70%" height="70%"></button>
          					</div>
				
					
					
				</c:otherwise>
		</c:choose>
					<div class="data">
					  <br>
                <br>
				<span style="color:white;font-weight:800;margin:1em;">최근 검색어</span><span style="float:right;margin-right:1em;"onclick="listoff()">닫기</span>
		  <br><br>
		  <hr>
				<c:forEach var="history" items="${historys.content}">
					<div class="historybox">
						<a class="historytext" onclick="searchhistoryinput(this)">${history.searchhistory }</a><span class="historybtn_x" onclick="deletehistory(this)" data-ck="${history.id }">X</span>
					</div>
				</c:forEach>
					</div>
				</div>
			</div>


			<c:choose>
				<c:when test="${empty principal}">
				
					<div class="nav">
						<ul>
							<li><a href="/auth/basket">장바구니</a></li>
							<li><a href="/auth/loginForm">로그인</a></li>
							<li><a href="/auth/joinForm">회원가입</a></li>
						</ul>
					</div>

				</c:when>
				<c:when test="${principal.user.roles =='ADMIN' }">		
					<div class="nav">
						<ul>
							<li><a href="/auth/manager">관리자페이지</a></li>
							<li><a href="/user/mypage">마이페이지</a></li>
							<li><a href="/logout">로그아웃</a></li>
						</ul>
					</div>

				</c:when>
				<c:otherwise>
				
					<div class="nav">
						<ul>
							<li><a href="/auth/basket">장바구니</a></li>
							<li><a href="/user/mypage">마이페이지</a></li>
							<li><a href="/logout">로그아웃</a></li>
						</ul>
					</div>
					
				</c:otherwise>

			</c:choose>


			
			
			
			
			
			
			
		</div>
	

			<div class="headernav">
				<ul class="menu">
					<li><a href="">For U</a>
						<ul class="submenu">
							<li>하위항목</li>
							<li>하위항목</li>
							<li>하위항목</li>
							<li>하위항목</li>
							<li>하위항목</li>
							<li>하위항목</li>
						</ul></li>
					<li><a href="">NEW</a>
						<ul class="submenu">
							<li>하위항목</li>
							<li>하위항목</li>
							<li>하위항목</li>
							<li>하위항목</li>
							<li>하위항목</li>
							<li>하위항목</li>
							<li>하위항목</li>
							<li>하위항목</li>
						</ul></li>
					<li><a href="">BEST</a>
						<ul class="submenu">
							<li>하위항목</li>
							<li>하위항목</li>
							<li>하위항목</li>
							<li>하위항목</li>
							<li>하위항목</li>
							<li>하위항목</li>
						</ul></li>
					<li><a href="">BRAND</a>
						<ul class="submenu">
							<li>하위항목</li>
							<li>하위항목</li>
							<li>하위항목</li>
							<li>하위항목</li>
							<li>하위항목</li>
							<li>하위항목</li>
							<li>하위항목</li>
							<li>하위항목</li>
						</ul></li>
					<li><a href="">SALE</a>
						<ul class="submenu">
							<li>하위항목</li>
							<li>하위항목</li>
							<li>하위항목</li>
							<li>하위항목</li>
						</ul></li>
					<li><a href="">중고거래</a></li>
					<li><a href="/board/event">event</a></li>
					<li><a href="/board/csboard">고객센터</a></li>
				</ul>
			</div>
		</div>
		<script>
		 function dd(){
			    let text= document.querySelector("#searchinput");
			    if(text.value!=null && text.value!=""){
			    	 historyinput();
			    }else {
			      alert("검색어를 입력해주세요")
			    }
			  }
			  function dd2(){
				    let text= document.querySelector("#searchinput");
				    if(text.value!=null && text.value!=""){
				    	 
				    }else {
				      alert("검색어를 입력해주세요")
				    }
				  }  
			  function historyinput(){
				  let history =  $("#searchinput").val();
				  $.ajax({
					  url:"/auth/history",
					  type:"POST",
					  data:history,
					  contentType:"application/json; charset=utf-8",
					  dataType:"json"
					  
				  }).done(function(resp){
					  location.href="/";
				  }).fail(function(error){
					  alert(JSON.stringify(error));
					
				  });
			  }
			  function searchhistoryinput(e){
				  let history=e.innerHTML;
				  let searchinput = document.querySelector("#searchinput");
				  searchinput.value=history;
				  listoff();
			  }
			  function deletehistory(e){
				  let historydata = document.querySelector(".data");
				  let historyid = e.dataset.ck;
				  $.ajax({
					  url:"/auth/delhistory/"+historyid,
					  type:"DELETE",
					  dataType:"json"
				  }).done(function(resp){
						location.reload();
				  }).fail(function(error){
					  alert(JSON.stringify(error));
				  })
			  }
		</script>
		<script src="/js/header.js"></script>
</body>
</html>


