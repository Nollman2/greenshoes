<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="../css/inquiry.css">
</head>
<body>
	<%@ include file="../layout/header.jsp"%>
	<div id="banner">
		<img src="/img/banner2.jpg">
	</div>
	
	<div id=container>
		<div id="Inquiry_wrap">
			<div class="Inquiry_wrap_title">공지 사항</div>
			<form id="Inquiry_form">

				<div>
					제목&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <input type="text"
						name="Inquiry_title" id="title" size="50" maxlength="100">
				</div>

				<div>
					이름&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <input type="text"
						name="Inquiry_name" id="user" size="15" maxlength="100"
						value=&nbsp;${principal.user.username} disabled>
				</div>

				<div id="Inquiry_content">
					<div>공지내용&nbsp;&nbsp;</div>
					<textarea id="contents" rows="18" cols="128"></textarea>
				</div>


			</form>
			<div id="Inquiry_submit">
				<button id="btn-save">저장</button>
			</div>
		</div>
	</div>
	  <script
	src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.min.js"></script>
  
	<script type="text/javascript" src="/js/board.js"></script>
	<%@ include file="../layout/footer.jsp"%>


</body>
</html>