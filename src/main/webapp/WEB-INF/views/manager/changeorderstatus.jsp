<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
 <link rel="stylesheet" href="/css/itemboard.css">
<div class="orderupdate_container">
<h4>주문 상태 변경페이지</h4>
	<form>
		<table>
			<tr>
				<td>주문번호
				</td>
				<td>11
				</td>
			</tr>
			<tr>
				<td>주문상품
				</td>
				<td>11
				</td>
			</tr>
			<tr>
				<td>상품금액(개별가격)
				</td>
				<td>11
				</td>
			</tr>
			<tr>
				<td>수량
				</td>
				<td>11
				</td>
			</tr>
			<tr>
				<td>주문일자
				</td>
				<td>11
				</td>
			</tr>
			<tr>
				<td>주문자
				</td>
				<td>11
				</td>
			</tr>
			<tr>
				<td>상태
				</td>
				<td>defaultorder
				</td>
			</tr>
		</table>
	</form>
	<button onclick="ordermanage.defaultorder">(관리자권한)주문정보 기본값설정(교환,취소시)</button>
	<button onclick="ordermanage.cancelorder">(관리자권한)주문취소신청</button>
	<button onclick="ordermanage.changeorder">(관리자권한)주문교환신청</button>
	 <button type="button" class="itemdetail_popupclose" onclick="closedetail()">닫기</button>
</div>