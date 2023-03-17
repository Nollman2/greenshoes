<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
  
 <link rel="stylesheet" href="/css/itemboard.css">
<!--  유저 확인 페이지 입니다. -->
<div class="usermanage-userinfo-container">
	<table>
		<tr>
		<th>ID(고유번호)
		</th>
		<th>	username
		</th>
		<th>userid
		</th>
		<th>email
		</th>
		<th>phone number
		</th>
		<th>birthday
		</th>
		<th>oauth
		</th>
		<th>role
		</th>
		<th>createdate
		</th>
		</tr>
		<c:forEach var="user" items="${users.content}">
		<tr>
		<td>${user.id}
		</td>
		<td>${user.username}
		</td>
		<td>${user.userid}
		</td>
		<td>${user.email}
		</td>
		<td>${user.phonenumber}
		</td>
		<td>${user.birthday}
		</td>
		<td>${user.oauth}
		</td>
		<td>${user.roles}
		</td>
		<td>${user.createDate}
		</td>
		</tr>
		</c:forEach>
	</table>
	


</div>
