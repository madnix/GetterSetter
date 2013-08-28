<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="UTF-8"%>
<% 
	String id = (String) session.getAttribute("id");
	String section = (String) session.getAttribute("section");
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<script type="text/javascript">
function logout(msg){
	var ch;
	ch = confirm(msg);
	if(ch == true){
		location.href="logout.do";
	}
}

</script>

	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<link rel="stylesheet" type="text/css" href="./css/main.css" />
		<script type="text/javascript" src="./js/jquery.js" ></script>
		<script src="./js/jquery-spin.js"></script>
		<script src="./js/product_board.js"></script>
	</head>
	<body>
<!-- =========================================  header 시작 ========================================= -->	
	
	<div id="header">
		<h1><a href="main.do"><img src="./images/common/logo.gif" alt="settergetter"/></a></h1>
			
		<div id="gnb">
			<ul class="fontcontrol">

				<%	if(id == null){	%>
						<li><a href="join_select.do" >JOIN US</a></li>	
						<li><a href="login.do">LOGIN</a></li>
				<%	}else if(id != null){	%>
						<li><a href="javascript:logout('로그아웃하시겠습니까?')" >LOGOUT</a></li>
				<%	}	%>

				<%	if(id == null && section == null){	%>
					<li><a href="login.do">CART</a></li>
				<%}else{%>
					<li><a href="cart.do">CART</a></li>
				<%	}	%>
				
				<% if(id == null && section == null){ %>
					<li><a href="login.do">MY PAGE</a></li>		<!-- 로그인 유지가 안되었을 경우 -->				
				<% }else if(section.equals("0")) { %>
					<li><a href="buyer_mypage.do">MY PAGE</a></li>	<!-- 구매자로 로그인 되었을 경우 -->
				<% }else if(section.equals("1")) { %>
					<li><a href="seller_mypage.do">MY PAGE</a></li>	<!-- 판매자로 로그인 되었을 경우 -->
				<% } %>
			</ul>
		</div>
		
		<h2 class="skip">주메뉴</h2>
		<ul id="topmenu">
			<li><a href="product_list.do?species_id=1"><img src="./images/common/menu01_off.gif" alt="의류" class="image_rollover" /></a></li>
			<li><a href="product_list.do?species_id=2"><img src="./images/common/menu02_off.gif" alt="패션잡화" class="image_rollover"  /></a></li>
			<li><a href="product_list.do?species_id=3"><img src="./images/common/menu03_off.gif" alt="식품" class="image_rollover" /></a></li>
			<li><a href="product_list.do?species_id=4"><img src="./images/common/menu04_off.gif" alt="생활" class="image_rollover" /></a></li>
			<li><a href="product_list.do?species_id=5"><img src="./images/common/menu05_off.gif" alt="가전" class="image_rollover"  /></a></li>
		</ul>
	</div>
	<hr/>
	
	<script type="text/javascript">
		jQuery(document).ready(function() {
			$("img.image_rollover").mouseover(function() {
				var temp = $(this).attr("src");
				var length = temp.length;
				var file_name = temp.substring(0, length - 6);
				var status = temp.substring(length - 6).substring(0, 2); //ff
				var file_type = temp.substring(length - 6).substring(3);
				if (status == "ff")
					$(this).attr("src", file_name + "n." + file_type);
			}).mouseout(function() {
				var temp = $(this).attr("src");
				var length = temp.length;
				var file_name = temp.substring(0, length - 6);
				var status = temp.substring(length - 6).substring(0, 2); //on
				var file_type = temp.substring(length - 6).substring(3);
				if (status == "on")
					$(this).attr("src", file_name + "off." + file_type);
			});
		});
	</script>





	<!-- =========================================  header 끝 ========================================= -->