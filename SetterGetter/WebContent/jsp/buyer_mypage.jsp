<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<link rel="stylesheet" type="text/css" href="./css/mypage.css" />
<title>Product List</title>
  
<!-- =========================================  header 시작 ========================================= -->
     <jsp:include page="header.jsp" />
<!-- =========================================  header 끝 ========================================= -->

  
    <div id="mypage">
      <div id="my_list">
      <!-- mypage list -->
      <p><a href="cart.do"><img src="./images/mypage/mypage_01.gif" alt="카트"></a></p>
      <p><a href="order_ask_ok.do"><img src="./images/mypage/mypage_02.gif" alt="주문한내역"></a></p>
      <p><a href="buyer_edit.do" ><img src="./images/mypage/mypage_03.gif" alt="내정보사항수정하기"></a></p>
      <p><a href="board_list.do"><img src="./images/mypage/mypage_04.gif" alt="게시판"></a></p>
      <!-- //mypage list -->
      </div>
      </div>
<!-- =============================== footer 시작 ===============================-->
<jsp:include page="footer.jsp" /> 
<!-- =============================== footer 끝 ===============================-->


