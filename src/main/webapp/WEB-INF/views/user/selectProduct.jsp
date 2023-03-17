<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>


<meta charset="UTF-8">
<link rel="stylesheet" href="../css/reset.css">
<link rel="stylesheet" href="../css/selectProduct.css">   
<title>Insert title here</title>


    <div id="container">
        <div id="sidebar">
            <div></div>

            <div class="info_my">
                <h2>마이페이지</h2>
                <ul class="navi">
                    <li><a href="user/mypage">마이페이지</a></li>
                </ul>
            </div>

            <div class="info_my">
                <h2>쇼핑 내역</h2>
                <ul class="navi">
                    <li><a href="/user/OrderStatus">주문/배송 현황 조회</a></li>
                    <li><a href="">판매 내역</a></li>
                    <li><a href="">취소/교환/반품 신청</a></li>
                    <li><a href="/user/selectProduct">관심상품</a></li>
                </ul>
            </div>

            <div class="info_my">
                <h2>나의 정보</h2>
                <ul class="navi">
                    <li><a href="">개인 정보 수정</a></li>
                    <li><a href="">회원 탈퇴</a></li>
                </ul>
            </div>
        </div>


        <div id="content">
           
                <div id="profil">
                    <div id="profilbox">
                        <div id="user_profil"><img src="../img/mypage/mypage_profil.png"></div>
                        <div id="user_profil01">
                            <p>                              
                            <span>홍길동 님은 <b>통합멤버십 회원</b>입니다.<br></span>
                            <b><span class="profil_class">MEMBERSHIP</span></b> <span class="profil_class2">123456789123456<br></span>
                            <b><span class="profil_class">멤버십 회원 가입일</span></b><span class="profil_class2"> 2022.00.00</span>
                            </p>
                        </div>
                        <div id="user_profil02">
                            <div>
                                <div><img src="../img/mypage/아이콘/포인트아이콘.png"></div>
                                <div><a href="" class="profil_side"><b>1000P</b></a></div>
                            </div>
                            <div>
                                <div><img src="../img/mypage/아이콘/쿠폰아이콘.png"></div>
                                <div><a href="" class="profil_side"><b>3개</b></a></div>
                            </div>
                        </div>
                        <div id="user_profil04">
                            <div>
                                <div><img src="../img/mypage/아이콘/장바구니아이콘.png"></div>
                                <div><a href="" class="profil_side"><b style="color: red;">0</b>개</a></div>
                            </div>
                            <div>
                                <div><img src="../img/mypage/아이콘/찜한상품아이콘.png"></div>
                                <div><a href="" class="profil_side"><b style="color: red;">5</b>개</a></div>
                            </div>
                        </div>
                    </div>
                </div>
            








                <div id="recentorder">
                  <div id="recentordertitle">최근주문내역</div>
                  <div id="orderprocess">
                      <ul>
                          <li>
                              <div class="ordercount"><a href="">0</a></div>
                              <div>입금대기</div>
                          </li>
                          <li>></li>
                          <li>
                              <div class="ordercount"><a href="">0</a></div>
                              <div>결제완료</div>
                          </li>
                          <li>></li>
                          <li>
                              <div class="ordercount"><a href="">0</a></div>
                              <div>상품준비중</div>
                          </li>
                          <li>></li>
                          <li>
                              <div class="ordercount"><a href="">0</a></div>
                              <div>배송중</div>
                          </li>
                          <li>></li>
                          <li>
                              <div class="ordercount"><a href="">0</a></div>
                              <div>수령완료</div>
                          </li>
                      </ul>
                  </div>
                  <div>
                      <ul id="orderchange">
                          <li>주문취소</li>
                          <li><a href="">0건</a></li>
                          <li>교환신청</li>
                          <li><a href="">0건</a></li>
                          <li>반품신청</li>
                          <li><a href="">0건</a></li>
                      </ul>
                  </div>
              </div>




              <div id="order_history">
                <div id="order_historytitle" style="margin-bottom: 20px;">관심 상품</div><br>
              </div>


            <div id="order_main">
                
                <div id="order_main_product">
                    <div id="order_product1">
                    <ul>
                        <li>
                            <a href=""><img src="../img/adidas_ogel.jpg"></a>
                        </li>

                        <li style="margin-left: 10px;">
                            <span style="font-size: 14px;">아디다스<br><br></span>
                            <span class="order_product1_info1">오젤<br><br><br></span>
                            <span class="order_product1_info1">275</span>
                        </li>

                        <li style="margin-top: 25px; margin-left: 300px;">
                            <del class="order_product1_info1" style="font-size: 13px; align-items: center; ">99000원</del><br>
                            <span style="color: red;">49,000</span>원
                        </li>
 
                        <li style="margin-top: 20px; margin-left: 100px;">
                            <button type="button" id="button_buy">바로 구매</button><br>
                            <a href=""><b style=" text-decoration: underline; font-size: 12px; margin-left: 175px; ">삭제</b></a>
                        </li>
                    </ul>
                    </div>


                    <div id="order_product1">
                        <ul>
                            <li>
                                <a href=""><img src="../img/adidas_ogel.jpg"></a>
                            </li>
    
                            <li style="margin-left: 10px;">
                                <span style="font-size: 14px;">아디다스<br><br></span>
                                <span class="order_product1_info1">오젤<br><br><br></span>
                                <span class="order_product1_info1">275</span>
                            </li>
    
                            <li style="margin-top: 25px; margin-left: 300px;">
                                <del class="order_product1_info1" style="font-size: 13px; align-items: center; ">99000원</del><br>
                                <span style="color: red;">49,000</span>원
                            </li>
     
                            <li style="margin-top: 20px; margin-left: 100px;">
                              <button type="button" id="button_buy">바로 구매</button><br>
                              <a href=""><b style=" text-decoration: underline; font-size: 12px; margin-left: 175px; ">삭제</b></a>
                          </li>
                        </ul>
                        </div>

                        <div style="margin: 20px 0px 0px 400px;">
                            <button type="button" id="order_productbtn">1</button>        
                        </div>

                </div>


            </div>

        </div>
    </div>