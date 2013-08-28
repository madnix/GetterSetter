<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<link rel="stylesheet" type="text/css" href="./css/login.css" />
<script type="text/javascript" src="./js/jquery.js" ></script>
<script type="text/javascript" src="./js/login.js" ></script>

<title>로그인</title>
	
<!-- =========================================  header 시작 ========================================= -->
	   <jsp:include page="header.jsp" />
<!-- =========================================  header 끝 ========================================= -->



<!-- ============================= 로그인창 시작 ============================= -->
	<form method="post" name="f" onsubmit="return login_check()" >
	<div id="box">
		<div id="inner_box">
			<div id="input_box">
				<ul>
					<li class="input_li_1"><input type="text" name="id" id="id" class="input_txt" /></li>
					<li class="input_li_1"><input type="password" name="pwd" id="pwd" class="input_txt"/></li>
				</ul>
				<p><input type="image" src="./images/login/login_button.jpg" alt="로그인버튼" /></p>
			</div>			
			
			<div id="bottom">
				<ul>
					<li class="bottom_li_1"><a href="join_select.do">JOIN US</a>&nbsp;&nbsp;:&nbsp;&nbsp;</li>
					<li><a href="searchid.do">SEARCH ID</a>&nbsp;&nbsp;:&nbsp;&nbsp;</li>
					<li><a href="searchpwd.do">SEARCH P/W</a></li>
				</ul>
			</div>
		</div>
	</div>
	</form>
		
<!-- ============================= 로그인창 끝 ============================= -->		
		
		
		
		
		

<!-- =============================== footer 시작 ===============================-->
<jsp:include page="footer.jsp" />	
<!-- =============================== footer 끝 ===============================-->

