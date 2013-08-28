<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<link rel="stylesheet" type="text/css" href="./css/searchpwd.css" />
<title>비밀번호 찾기</title>
	
<!-- =========================================  header 시작 ========================================= -->
	   <jsp:include page="header.jsp" />
<!-- =========================================  header 끝 ========================================= -->


<!-- =========================================  비밀번호 찾기 시작 ========================================= -->

<form method="post" action="searchpwd.do">
	<div id="box">
		<div id="inner_box">
			<div id="inner_top">
				<ul>
					<li><img src="./images/search/searchpwd.jpg" /></li>
					<li><img src="./images/search/searchpwd_mid.jpg" class="mid_box"/></li>
				</ul>
			</div>

			
			<div id="searchid">
				<ul>
					<li>아이디</li>
					<li><input type="text" name="id" id="id" class="search_li_box" /></li>
					<li class="search_box">이름</li>
					<li><input type="text" name="name" id="name" class="search_li_box" /></li>
					<li class="search_box">비밀번호 힌트 질문</li>
					<li>
						<select name="pwd_q" id="pwd_q" class="search_li_sel">
							<option value="">++회원가입 시 선택한 질문을 선택해주세요.</option>
							<option value="1">인상 깊게 읽은 책 이름은?</option>
							<option value="2">자신이 첫번째로 존경하는 인물은?</option>
							<option value="3">초등학교 때 기억에 남는 짝꿍 이름은?</option>
							<option value="4">다시 태어나면 되고 싶은 것은?</option>
							<option value="5">유년시절 가장 생각나는 친구 이름은?</option>
							<option value="6">받았던 선물 중 기억에 남는 독특한 선물은?</option>
							<option value="7">어릴 적 별명은?</option>                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                     
							<option value="8">자신만의 신체비밀이 있다면?</option>
							<option value="9">인생의 좌우명은?</option>
						</select>
					</li>
					<li class="search_box">비밀번호 힌트 답변</li>
					<li><input type="text" name="pwd_a" id="pwd_a" class="search_li_box" /></li>
				
					<li class="search_btn"><input type="image" src="./images/search/search_btn.jpg" alt="비밀번호찾기" /></li> 
				</ul>
			</div>
						
		</div>
	</div>
</form>		
<!-- =========================================  비밀번호 찾기 끝 ========================================= -->



<!-- =============================== footer 시작 ===============================-->
<jsp:include page="footer.jsp" />	
<!-- =============================== footer 끝 ===============================-->

