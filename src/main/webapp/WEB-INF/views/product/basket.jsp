<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
   <%@ include file="../layout/header.jsp"%>
 
 
  <link rel="stylesheet" type="text/css" href="../css/basket.css">
  <script type="text/javascript" src="/js/order.js"></script>
  <script type="text/javascript" src="/js/basket.js"></script>
  

<body>
<form name="orderform" id="orderform" method="post" class="orderform" action="/Page" onSubmit="return false;">
         <input type="hidden" name="cmd" value="order">
         <div class="all">
         <div class="container">
         <div class="basketdiv" id="basket">
            <div class="row head">
               <div class="subdiv">
                  <div class="check">
                  <input type='checkbox' onClick="basket.checkAll()" id="th_checkAll"/>
                  </div>
                  <div class="pname">상품</div>
               </div>
               <div class="subdiv">
                  <div class="basketprice">가격</div>
                  <div class="num">수량</div>
                  <div class="sum" style="font-weight:bold">합계</div>
               </div>
               <div class="split"></div>
            </div>
            
            <c:forEach var="basket" items="${baskets}">
            <input type="hidden" id="arrayParam" name="arrayParam" value="${basketid}">
                 <div class="row datas" id="rowd">
                     <div class="subdiv"> 
                        <div class="check">
                           <input type="checkbox" name="buy" value="${basket.id}" onClick="basket.checkItem();">&nbsp;
                        </div>
                        <div class="pname">
                           <a href="/auth/product/${basket.product.id}">
                           <span class="basket_img"><img src="${basket.product.img}"></span>
                           <span>${basket.product.brand_name}</span>
                           <span>${basket.product.productname}</span>
                           <span>${basket.productsize}</span>
                           </a>
                        </div>
                     </div>
                     <div class="subdiv">
                        <div class="basketprice">
                           <input type="hidden" name="p_price" id="p_price${basket.id}" class="p_price" value="${basket.product.price}">${basket.product.price}원
                        </div>
                        <div class="num">
                           <div class="updown">
                              <input type="text" name="p_num${basket.id}" id="p_num${basket.id}" size="2" maxlength="4" class="p_num" value="1" onKeyUp="javascript:basket.changePNum(${basket.id});"  oninput="this.value = this.value.replace(/[^0-9]/g, '').replace(/(\..*)\./g, '$1');">
                           </div>
                        </div>
                        <div class="sum" style="font-weight:bold">${basket.product.price}원</div>
                     </div>
                  </div> 
             </c:forEach>
         </div>
         <div class="right-align basketrowcmd" id="deletebuttons">
            <button type="button" class="btn btn-warning btn-sm" onClick="index5.deleteById()">선택상품삭제</button> 
            <button type="button" class="btn btn-danger btn-sm" onClick="index5.deleteAll()">장바구니비우기</button>
         </div><br>
         </div>
         <div>
	         <div class="sidebar">
	         	<div class="bigtext right-align sumcount" id="sum_p_num">상품갯수: -개</div>
	         	<div class="bigtext right-align box blue summoney" id="sum_p_price">합계금액: -원</div>
	         </div>
	         <div id="goorder">
	            	<div id="o_btn" class="buttongroup center-align cmd" style="text-align: center">
	               		<button type="button" class="btn btn-primary" onClick="basket1.purchase()">구매하기</button>    
	            	</div>
	         </div>
	         </div>
         </div>
         
      </form>
      
    <%@ include file="../layout/footer.jsp"%>
    
    
</body>