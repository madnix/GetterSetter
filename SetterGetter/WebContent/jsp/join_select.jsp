<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<link rel="stylesheet" type="text/css" href="./css/join_select.css" />
<title>가입 회원 선택</title>
	
<!-- =========================================  header 시작 ========================================= -->
	   <jsp:include page="header.jsp" />
<!-- =========================================  header 끝 ========================================= -->

<!-- =========================================  회원가입 선택 시작 ========================================= -->



	<div id="box">
		<div id="join_wel">
			<ul><li><img src="./images/join/join_welcome.jpg" /></li></ul>
		</div>
		<div id="join_img">
			<ul>
				<li class="join_img_li"><a href="join_buy_form.do"><img src="./images/join/join_buy.jpg" /></a></li>
				<li><a href="join_sell_form.do"><img src="./images/join/join_sell.jpg" /></a></li>
			</ul>
		</div>
	</div>		



<!-- =========================================  회원가입 선택 끝 ========================================= -->



<!-- =============================== footer 시작 ===============================-->
<jsp:include page="footer.jsp" />	
<!-- =============================== footer 끝 ===============================-->

