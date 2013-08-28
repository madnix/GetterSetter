<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<link rel="stylesheet" type="text/css" href="./css/searchid.css" />
<script type="text/javascript" src="./js/jquery.js" ></script>
<script type="text/javascript" src="./js/searchid.js" ></script>
<title>아이디 찾기</title>
	
<!-- =========================================  header 시작 ========================================= -->
	   <jsp:include page="header.jsp" />
<!-- =========================================  header 끝 ========================================= -->




<!-- =========================================  아이디 찾기 시작 ========================================= -->
	<form method="post" name="f" onsubmit="return searchid_check()">
	<div id="box">
		<div id="inner_box">
			<div id="inner_top">
				<ul>
					<li><img src="./images/search/searchid.jpg" /></li>
					<li><img src="./images/search/searchid_mid.jpg" class="mid_box"/></li>
				</ul>
			</div>

			
			<div id="searchid">
				<ul>
					<li>이름</li>
					<li><input type="text" name="name" id="name" class="search_li_box" /></li>
					<li class="search_box">E-MAIL로 찾기</li>
					<li><input type="text" name="email" id="email" class="search_li_box" /></li>
				</ul>
				<p class="search_btn"><input type="image" src="./images/search/search_btn.jpg" alt="아이디찾기 버튼"/></p> 
			</div>
			
			
			
		</div>
	</div>	
	</form>
<!-- =========================================  아이디 찾기 끝 ========================================= -->








<!-- =============================== footer 시작 ===============================-->
<jsp:include page="footer.jsp" />	
<!-- =============================== footer 끝 ===============================-->

