<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%
	String id = (String)session.getAttribute("id");
%>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<link rel="stylesheet" type="text/css" href="./css/mypage.css" />
<title>Product List</title>
  
<!-- =========================================  header 시작 ========================================= -->
     <jsp:include page="header.jsp" />
<!-- =========================================  header 끝 ========================================= -->

  
    <div id="mypage">
      <div id="my_list">
      <!-- mypage list -->
      <p><a href="product_insert.do"><img src="./images/mypage/mypage_06.gif" alt="상품등록"></a></p>
      <p><a href="product_insert_list.do"><img src="./images/mypage/mypage_05.gif" alt="주문내역"></a></p>
      <p><a href="seller_edit.do"><img src="./images/mypage/mypage_03.gif" alt="내정보사항수정하기"></a></p>
      <p><a href="board_list.do"><img src="./images/mypage/mypage_04.gif" alt="게시판"></a></p>
      <!-- //mypage list -->
      </div>
      </div>
<!-- =============================== footer 시작 ===============================-->
<jsp:include page="footer.jsp" /> 
<!-- =============================== footer 끝 ===============================-->


