<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html><html><head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="./css/buyer_edit.css" />
<script type="text/javascript" src="./js/jquery.js" ></script>
<script type="text/javascript" src="./js/buyer_edit.js" ></script>

<title>회원 정보수정</title>
</head><body>


<!-- =========================================  header 시작 ========================================= -->
	   <jsp:include page="header.jsp" />
<!-- =========================================  header 끝 ========================================= -->



<form method="post" name="f" action="buyeredit_ok.do" onsubmit="return check()" >
	
	<div id="box">
		<ul>
			<li><img src="./images/join/join_img2.jpg" class="box_li_1" /></li>
		</ul>
		
		<div id="info">
		<input type="hidden" name="section" value="bean.section"/>
		<input type="hidden" id="zipbtnchk" value="" />
			<table>
				<tr>
					<td class="info_list">아이디</td>
					<td colspan="3">
						<input name="id" id="id" readonly value="${ bean.id }" maxlength="15" class="info_box" />	
					</td>
								
				</tr>
				
				<tr><th colspan="4"><img src="./images/join/join_line.jpg" /></th></tr>
					
				<tr>
					<td class="info_list">기존 비밀번호</td>
					<td colspan="3">
						<input type="password" name="p_check" id="p_check" maxlength="16" class="info_box" />&nbsp;기존 비밀번호를 입력해주세요.</td>
				</tr>
				
				<tr><th colspan="4"><img src="./images/join/join_line.jpg" /></th></tr>
							
				<tr>
					<td class="info_list">새로운 비밀번호</td>
					<td colspan="3">
						<input type="password" name="pwd" id="pwd" maxlength="16" class="info_box" />&nbsp;새로운 비밀번호를 입력해주세요.</td>
				</tr>
				
				<tr><th colspan="4"><img src="./images/join/join_line.jpg" /></th></tr>
				
				<tr>
					<td class="info_list">새로운 비밀번호 확인</td>
					<td colspan="3"><input type="password" id="pwd_check" maxlength="16" class="info_box" /></td>
				</tr>
				
				<tr><th colspan="4"><img src="./images/join/join_line.jpg" /></th></tr>
				
				<tr>
					<td class="info_list">비밀번호 확인 질문</td>
					<td><select name="pwd_q" id="pwd_q" class="info_box" >
						<option value="">++비밀번호 분실 시 사용 될 질문을 선택해주세요.</option>
						<option value="1" <c:if test="${ bean.pwd_q == '1' }"><c:out value="selected" /></c:if>>인상 깊게 읽은 책 이름은?</option>
						<option value="2" <c:if test="${ bean.pwd_q == '2' }"><c:out value="selected" /></c:if>>자신이 첫번째로 존경하는 인물은?</option>
						<option value="3" <c:if test="${ bean.pwd_q == '3' }"><c:out value="selected" /></c:if>>초등학교 때 기억에 남는 짝꿍 이름은?</option>
						<option value="4" <c:if test="${ bean.pwd_q == '4' }"><c:out value="selected" /></c:if>>다시 태어나면 되고 싶은 것은?</option>
						<option value="5" <c:if test="${ bean.pwd_q == '5' }"><c:out value="selected" /></c:if>>유년시절 가장 생각나는 친구 이름은?</option>
						<option value="6" <c:if test="${ bean.pwd_q == '6' }"><c:out value="selected" /></c:if>>받았던 선물 중 기억에 남는 독특한 선물은?</option>
						<option value="7" <c:if test="${ bean.pwd_q == '7' }"><c:out value="selected" /></c:if>>어릴 적 별명은?</option>                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                     
						<option value="8" <c:if test="${ bean.pwd_q == '8' }"><c:out value="selected" /></c:if>>자신만의 신체비밀이 있다면?</option>
						<option value="9" <c:if test="${ bean.pwd_q == '9' }"><c:out value="selected" /></c:if>>인생의 좌우명은?</option>
					</select></td>
				</tr>
				
				<tr><th colspan="4"><img src="./images/join/join_line.jpg" /></th></tr>
				
				<tr>
					<td class="info_list">비밀번호 확인 답변</td>
					<td colspan="3"><input name="pwd_a" id="pwd_a" value="${ bean.pwd_a }" class="info_box3" /></td>
				</tr>
				
				<tr><th colspan="4"><img src="./images/join/join_line.jpg" /></th></tr>
				
				<tr>
					<td class="info_list">이름</td>
					<td><input name="name" id="name" readonly value="${ bean.name }" class="info_box" /></td>
				</tr>
				
				<tr><th colspan="4"><img src="./images/join/join_line.jpg" /></th></tr>
				
				
				<tr>
					<td rowspan="3" class="info_list">주소</td>
					<td>
						<input name="zip1" id="zip1" maxlength="3" value="${ bean.zip1 }" class="info_box4" /> - <input name="zip2" id="zip2" maxlength="3" value="${ bean.zip2 }" class="info_box4" />						
						<input type="button" id="zip_btn" value="우편번호" onclick="post_check(1)" class="info_box" /></td>
				</tr>
				
				<tr>
					<td colspan="3">
						<input name="addr1" id="addr1" value="${ bean.addr1 }" class="info_box2" />
					</td>
				</tr>
				
				<tr>
					<td colspan="3">
						<input name="addr2" id="addr2" value="${ bean.addr2 }" class="info_box2" />
					</td>
				</tr>
				
				<tr><th colspan="4"><img src="./images/join/join_line.jpg" /></th></tr>
			
				<tr>
					<td class="info_list">유선전화</td>
					<td colspan="3"><select name="tel1" id="tel1" class="info_box5" >
						<option value="02" <c:if test="${ bean.tel1 == '02' }"><c:out value="selected" /></c:if>>02</option>		<option value="031" <c:if test="${ bean.pwd_q == '031' }"><c:out value="selected" /></c:if>>031</option>		
						<option value="032" <c:if test="${ bean.tel1 == '032' }"><c:out value="selected" /></c:if>>032</option>	<option value="033" <c:if test="${ bean.pwd_q == '033' }"><c:out value="selected" /></c:if>>033</option>		
						<option value="041" <c:if test="${ bean.tel1 == '041' }"><c:out value="selected" /></c:if>>041</option>	<option value="042" <c:if test="${ bean.pwd_q == '042' }"><c:out value="selected" /></c:if>>042</option>		
						<option value="043" <c:if test="${ bean.tel1 == '043' }"><c:out value="selected" /></c:if>>043</option>	<option value="044" <c:if test="${ bean.pwd_q == '044' }"><c:out value="selected" /></c:if>>044</option>		
						<option value="051" <c:if test="${ bean.tel1 == '051' }"><c:out value="selected" /></c:if>>051</option>	<option value="052" <c:if test="${ bean.pwd_q == '052' }"><c:out value="selected" /></c:if>>052</option>		
						<option value="053" <c:if test="${ bean.tel1 == '053' }"><c:out value="selected" /></c:if>>053</option>	<option value="054" <c:if test="${ bean.pwd_q == '054' }"><c:out value="selected" /></c:if>>054</option>		
						<option value="055" <c:if test="${ bean.tel1 == '055' }"><c:out value="selected" /></c:if>>055</option>	<option value="061" <c:if test="${ bean.pwd_q == '061' }"><c:out value="selected" /></c:if>>061</option>		
						<option value="062" <c:if test="${ bean.tel1 == '062' }"><c:out value="selected" /></c:if>>062</option>	<option value="063" <c:if test="${ bean.pwd_q == '063' }"><c:out value="selected" /></c:if>>063</option>		
						<option value="064" <c:if test="${ bean.tel1 == '064' }"><c:out value="selected" /></c:if>>064</option>
							
					</select>-<input name="tel2" id="tel2" value="${ bean.tel2 }" maxlength="4" class="info_box4" />-<input name="tel3" id="tel3" value="${ bean.tel3 }" maxlength="4" class="info_box4" /></td>
				</tr>
				
				<tr><th colspan="4"><img src="./images/join/join_line.jpg" /></th></tr>				
				
				<tr>
					<td class="info_list">휴대전화</td>
					<td colspan="3"><select name="phone1" id="phone1" class="info_box5" >
						<option value="010" <c:if test="${ bean.phone1 == '010' }"><c:out value="selected" /></c:if>>010</option>
						<option value="011" <c:if test="${ bean.phone1 == '011' }"><c:out value="selected" /></c:if>>011</option>
						<option value="016" <c:if test="${ bean.phone1 == '016' }"><c:out value="selected" /></c:if>>016</option>
						<option value="019" <c:if test="${ bean.phone1 == '019' }"><c:out value="selected" /></c:if>>019</option>
					</select>-<input name="phone2" id="phone2" value="${ bean.phone2 }" maxlength="4" class="info_box4" />-<input name="phone3" id="phone3" value="${ bean.phone3 }" maxlength="4" class="info_box4" />
					</td>
				</tr>
				
				<tr><th colspan="4"><img src="./images/join/join_line.jpg" /></th></tr>
								
				<tr>
					<td class="info_list">이메일</td>
					<td colspan="3"><input name="email1" id="email1" value="${ bean.email1 }" class="info_box" /> @ <input name="email2" id="email2" value="${ bean.email2 }" class="info_box" />
						<select name="email3" id="email3" onchange="select_email()" class="info_box" >
							<option value="">:::선택하세요:::</option>
							<option value="gmail.com">gmail.com</option>
							<option value="hanmail.net">hanmail.net</option>
							<option value="nate.com">nate.com</option>
							<option value="naver.com">naver.com</option>
							<option value="yahoo.co.kr">yahoo.co.kr</option>
						</select>
					</td>
				</tr>				
			</table>
		</div>	
		
		
		
		<!-- =============================== 추가정보 입력 시작 ========================== -->
		
		<img src="./images/join/join_img14.jpg" class="add_img"/>
		
		<div id="add_info">
			<table>
				<tr>
					<td class="info_list">생년월일</td>
					<td colspan="4">
						<input name="birth1" maxlength="4" value="${ bean.birth1 }" class="info_box1" /> 년
						<input name="birth2" maxlength="2" value="${ bean.birth2 }" class="info_box2"  /> 월
						<input name="birth3" maxlength="2" value="${ bean.birth3 }" class="info_box2"  /> 일
					</td>
				</tr>
			
				<tr><th colspan="4"><img src="./images/join/join_line.jpg" /></th></tr>
	
				<tr>
					<td class="info_list">결혼기념일</td>
					<td colspan="4">
						<input name="wedding1" maxlength="4" value="${ bean.wedding1 }" class="info_box1" /> 년
						<input name="wedding2" maxlength="2" value="${ bean.wedding2 }" class="info_box2"  /> 월
						<input name="wedding3" maxlength="2" value="${ bean.wedding3 }" class="info_box2"  /> 일
					</td>
				</tr>	
				
				<tr><th colspan="4"><img src="./images/join/join_line.jpg" /></th></tr>
				
				<tr>
					<td class="info_list">배우자생일</td>
					<td colspan="4"> 
						<input name="wifebirth1" maxlength="4" value="${ bean.wifebirth1 }" class="info_box1" /> 년
						<input name="wifebirth2" maxlength="2" value="${ bean.wifebirth2 }" class="info_box2"  /> 월
						<input name="wifebirth3" maxlength="2" value="${ bean.wifebirth3 }" class="info_box2"   /> 일
					</td>
				</tr>
				
				<tr><th colspan="4"><img src="./images/join/join_line.jpg" /></th></tr>
				
				<tr>
					<td class="info_list">지역</td>
					<td colspan="4"><select name="location" id="location" class="info_box3">
						<option value="1" <c:if test="${ bean.location == '1' }"><c:out value="selected" /></c:if>>선택</option>
						<option value="2" <c:if test="${ bean.location == '2' }"><c:out value="selected" /></c:if>>서울</option>
						<option value="3" <c:if test="${ bean.location == '3' }"><c:out value="selected" /></c:if>>경기도</option>
						<option value="4" <c:if test="${ bean.location == '4' }"><c:out value="selected" /></c:if>>강원도</option>
						<option value="5" <c:if test="${ bean.location == '5' }"><c:out value="selected" /></c:if>>충청남도</option>
						<option value="6" <c:if test="${ bean.location == '6' }"><c:out value="selected" /></c:if>>충청북도</option>
						<option value="7" <c:if test="${ bean.location == '7' }"><c:out value="selected" /></c:if>>대전광역시</option>
						<option value="8" <c:if test="${ bean.location == '8' }"><c:out value="selected" /></c:if>>전라북도</option>
						<option value="9" <c:if test="${ bean.location == '9' }"><c:out value="selected" /></c:if>>전라남도</option>
						<option value="10" <c:if test="${ bean.location == '10' }"><c:out value="selected" /></c:if>>광주광역시</option>
						<option value="11" <c:if test="${ bean.location == '11' }"><c:out value="selected" /></c:if>>경상북도</option>
						<option value="12" <c:if test="${ bean.location == '12' }"><c:out value="selected" /></c:if>>경상남도</option>
						<option value="13" <c:if test="${ bean.location == '13' }"><c:out value="selected" /></c:if>>대구광역시</option>
						<option value="14" <c:if test="${ bean.location == '14' }"><c:out value="selected" /></c:if>>울산광역시</option>
						<option value="15" <c:if test="${ bean.location == '15' }"><c:out value="selected" /></c:if>>부산광역시</option>
						<option value="16" <c:if test="${ bean.location == '16' }"><c:out value="selected" /></c:if>>울릉도</option>
						<option value="17" <c:if test="${ bean.location == '17' }"><c:out value="selected" /></c:if>>제주도</option>					
					</select></td>
				</tr>

			</table>
		
		</div>
		
		
		<div id="info_btn">
			<p><input type="image" src="./images/join/join_img21.jpg" alt="회원정보수정" /></p>
			<p><input type="image" src="./images/join/join_img20.jpg" alt="수정취소" onclick="return cancel_check()" /></p>
		</div>
		
	</div>
</form>


<!-- =============================== footer 시작 ===============================-->
<jsp:include page="footer.jsp" />	
<!-- =============================== footer 끝 ===============================-->