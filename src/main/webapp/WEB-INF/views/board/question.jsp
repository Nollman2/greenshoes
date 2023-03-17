<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<%@taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 	<link rel="stylesheet" href="/css/reset.css">
    <link rel="stylesheet" href="/css/cs.css"> 
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Dongle&display=swap" rel="stylesheet">
</head>
<body>
<%@ include file="../layout/header.jsp"%>

<div id="banner">
        <img src="/img/banner2.jpg">
    </div>
    <div id="container">
        <div id="FAQ">
            <h2>FAQ자주 받는 질문</h2>
        </div>
        <div id="FAQsearch">
            <div id="logobox"><img src="/img/logo.png"></div>
            <div id="search1">
                <form>
                    <input id="searchbar" type="text" placeholder="무엇을 도와드릴까요?">
                    <input id="searchbutton" type="submit" value="검색">
                </form>
            </div>
        </div>
        <div class="navbar">
            <nav>
                <ul>
                    <li><a href="/board/csboard">공지사항</a></li>
                     <li><a href="/event">이벤트</a></li>
                    <li><a href="/inquire">문의사항</a></li>
                                  
                </ul>
            </nav>
        </div>



	<div class="board_list_wrap">
			<div id="board_title">문의사항</div>
            <table class="board_list">
                <caption>게시판 목록</caption>
                <thead>
                    <tr>
                        <th>번호</th>
                        <th>제목</th>
                        <th>글쓴이</th>
                        <th>작성일</th>
                        <th>조회</th>
                    </tr>
                </thead>
                <tbody>
                    <tr class="notice">
                        <td></td>
                        <td class="tit"><a href="">공지사항</a></td>
                        <td>관리자</td>
                        <td>2022-12-07</td>
                        <td>123</td>
                    </tr>
                    <tr class="notice">
                        <td></td>
                        <td class="tit"><a href="">공지사항</a></td>
                        <td>관리자</td>
                        <td>2022-12-07</td>
                        <td>123</td>
                    </tr>
                    <tr class="notice">
                        <td></td>
                        <td class="tit"><a href="">공지사항</a></td>
                        <td>관리자</td>
                        <td>2022-12-07</td>
                        <td>123</td>
                    </tr>
                    
                    
                    
                    
                   <c:forEach var="question" items="${questions.content}">
                    <tr>
                        <td>${question.id}</td>
                        <td class="tit"><a href="/question/${question.id}">${question.title}</a></td>
                        <td>${question.user.username}</td>
                        <td><fmt:formatDate pattern = "yyyy/MM/dd" value="${question.createDate}"/></td>
                        <td>${question.count}</td>
                    </tr>         
                    
                   </c:forEach>
                   
                   
                   
                    <c:forEach var="board" items="${board.content}">
	                   <tr>
	                        <td>${board.id}</td>
	                        <td class="tit"><a href="/question/${board.id}">${board.title}</a></td>
	                        <td>${board.user.username}</td>
	                        <td><fmt:formatDate pattern = "yyyy/MM/dd" value="${board.createDate}"/></td>
	                        <td>${board.count}</td>
	                    </tr>      
                                        						
					</c:forEach>
                   
                   
                  
              
                </tbody>
            </table>
            <div class="write">
                <a href="/board/questionSaveForm"><button onclick="">글쓰기</button></a>
            </div>
            
            
            
           
            <div class="search2">
               <form action="/questionsearch" method="get">
					<select name="searchtype">
						<option value="title">제목</option>
						<option value="content">내용</option>
						<option value="user">작성자</option>
					</select>
					
					 <input type="text" name="keyword" placeholder="검색어를 입력해주세요">
					 <button type="submit">검색</button>
					 
				</form>
            </div>
           
            
        
            
            
            <div class="paging">
                <a href="?page=0" class="bt">첫 페이지</a>                
                <a href="?page=${questions.number-1}" class="bt">이전 페이지</a>
                <a href="?page=0" class="num">1</a>
                <a href="?page=1" class="num">2</a>
                <a href="?page=2" class="num">3</a>
                <a href="?page=3" class="num">4</a>
                <a href="?page=4" class="num">5</a>    
            	<a href="?page=${questions.number+1}" class="bt">다음 페이지</a>                     
                <a href="" class="bt">마지막 페이지</a>            
            </div>
            
        </div>
        
        
</div>
         <%@ include file="../layout/footer.jsp"%>
</body>
</html>