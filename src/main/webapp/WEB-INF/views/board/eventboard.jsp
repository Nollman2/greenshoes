<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
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
			<div id="board_title">이벤트</div>
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
                    <tr class="notice">
                        <td></td>
                        <td class="tit"><a href="">공지사항</a></td>
                        <td>관리자</td>
                        <td>2022-12-07</td>
                        <td>123</td>
                    </tr>
                    <tr>
                        <td>1</td>
                        <td class="tit"><a href="">제목1</a></td>
                        <td>노민종</td>
                        <td>2022-12-07</td>
                        <td>123</td>
                    </tr>
                    <tr>
                        <td>2</td>
                        <td class="tit"><a href="">제목2</a></td>
                        <td>노민종</td>
                        <td>2022-12-07</td>
                        <td>123</td>
                    </tr>
                    <tr>
                        <td>3</td>
                        <td class="tit"><a href="">제목3</a></td>
                        <td>노민종</td>
                        <td>2022-12-07</td>
                        <td>123</td>
                    </tr>
                    <tr>
                        <td>4</td>
                        <td class="tit"><a href="">제목4</a></td>
                        <td>노민종</td>
                        <td>2022-12-07</td>
                        <td>123</td>
                    </tr>
                    <tr>
                        <td>5</td>
                        <td class="tit"><a href="">제목5</a></td>
                        <td>노민종</td>
                        <td>2022-12-07</td>
                        <td>123</td>
                    </tr>
                    <tr>
                        <td>6</td>
                        <td class="tit"><a href="">제목6</a></td>
                        <td>노민종</td>
                        <td>2022-12-07</td>
                        <td>123</td>
                    </tr>
                    <tr>
                        <td>7</td>
                        <td class="tit"><a href="">제목7</a></td>
                        <td>노민종</td>
                        <td>2022-12-07</td>
                        <td>123</td>
                    </tr>
                </tbody>
            </table>
            <div class="write">
                <button onclick="">글쓰기</button>
            </div>
            <div class="search2">
                <form>
                    <input id="searchbar2"type="text">
                    <input id="searchbutton2" type="submit" value="검색">
                </form>
            </div>
            <div class="paging">
                <a href="" class="bt">첫 페이지</a>
                <a href="" class="bt">이전 페이지</a>
                <a href="" class="num">1</a>
                <a href="" class="num">2</a>
                <a href="" class="num">3</a>
                <a href="" class="num">4</a>
                <a href="" class="num">5</a>                
                <a href="" class="bt">다음 페이지</a>
                <a href="" class="bt">마지막 페이지</a>            
            </div>
            </div>
        </div>
         <%@ include file="../layout/footer.jsp"%>
</body>
</html>