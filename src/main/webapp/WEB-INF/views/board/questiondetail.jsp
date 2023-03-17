<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="/css/reset.css">
<link rel="stylesheet" href="/css/detail.css">
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
</head>
<body>
	<%@ include file="../layout/header.jsp"%>
	<div id="banner">
		<img src="/img/banner2.jpg">
	</div>


	<div id="container">



		<div id="board_wrap">
			<div class="board_wrap_title">문의 사항</div>
			<div class="board_title">&nbsp; ${question.title}</div>

			<div class="board_subtitle">
				<div>
					&nbsp;&nbsp;글번호 : <span id="id">${question.id}</span> &nbsp; 작성자 :
					${question.user.username}
				</div>
				<div class="board_subtitle_etc">
					<div>&nbsp;&nbsp;</div>
					<div>조회수&nbsp;${question.count}</div>
					<div>
						작성일 &nbsp;
						<fmt:formatDate pattern="yyyy/MM/dd"
							value="${question.createDate}" />
					</div>
				</div>
			</div>

			<div class="board_content_wrap">
				<div class="board_content"><pre>${question.contents}</pre></div>
			</div>

			<div id="reply_title">&nbsp;댓글</div>

			<c:forEach var="reply" items="${question.reply}">
				<div class="reply_box">
					<div class="reply_body">
						<div id="reply_info">
							<h4>&nbsp;작성자 : ${reply.users.username}</h4>
							<h4>
								작성시간 :
								<fmt:formatDate pattern="yyyy/MM/dd  hh.mm.ss"
									value="${reply.createDate}" />
							</h4>
							<br>
							<c:if
								test="${reply.users.id==principal.user.id or principal.user.roles=='ADMIN'}">
								<button onClick="index.replyDelete(${question.id},${reply.id})">&nbsp;삭제</button>
							</c:if>
						</div>
						<div id="reply_content">
							<h4>&nbsp;&nbsp;${reply.content}</h4>
						</div>

					</div>
				</div>
			</c:forEach>



			<div id="reply_box">
				<form>
					<input type="hidden" id="questionId" value="${question.id}">
					<div id="reply_body">
						<textarea id="reply-content" class="from_control" rows="5"
							cols="127"></textarea>
					</div>
				</form>

				<button type="button" id="btn-reply-save">등록</button>
			</div>



			<c:if
				test="${question.user.id==principal.user.id or principal.user.roles=='ADMIN'}">
				<div id="board_button">
					<a href="/question/${question.id}/questionUpdateForm"><button>수정</button></a>
					<button id="btn-question-delete">삭제</button>

				</div>
			</c:if>

		</div>

	</div>

	<%@ include file="../layout/footer.jsp"%>

	<script type="text/javascript" src="/js/question.js"></script>

</body>
</html>