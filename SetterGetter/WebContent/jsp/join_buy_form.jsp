<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html><html><head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="./css/join_buy_form.css" />
<script type="text/javascript" src="./js/jquery.js" ></script>
<script type="text/javascript" src="./js/join_buy_form.js" ></script>

<title>구매자 회원가입</title>
</head><body>


<!-- =========================================  header 시작 ========================================= -->
	   <jsp:include page="header.jsp" />
<!-- =========================================  header 끝 ========================================= -->



<form method="post" name="f" action="join_buy_form.do" onsubmit="return join_check()" >
	
	<div id="box">
		<ul>
			<li><img src="./images/join/join_img2.jpg" class="box_li_1" /></li>
			<li><img src="./images/join/join_img1.jpg" class="box_li_2" /></li>
		</ul>
		
		<div id="info">
		<input type="hidden" name="section" value="0"/>
		<input type="hidden" id="zipbtnchk" value="" />
			<table>
				<tr>
					<td class="info_list">아이디</td>
					<td colspan="3"><input name="id" id="id" readonly onclick="id_search()" maxlength="15" class="info_box" />
					<input type="button" id="id_btn" value="아이디중복체크" onclick="id_check()" class="info_box" />		
					</td>
								
				</tr>
				
				<tr><th colspan="4"><img src="./images/join/join_line.jpg" /></th></tr>
							
				<tr>
					<td class="info_list">비밀번호</td>
					<td colspan="3">
						<input type="password" name="pwd" id="pwd" maxlength="16" class="info_box" />(영문소문자/숫자, 4~16자)</td>
				</tr>
				
				<tr><th colspan="4"><img src="./images/join/join_line.jpg" /></th></tr>
				
				<tr>
					<td class="info_list">비밀번호 확인</td>
					<td colspan="3"><input type="password" id="pwd_check" maxlength="16" class="info_box" /></td>
				</tr>
				
				<tr><th colspan="4"><img src="./images/join/join_line.jpg" /></th></tr>
				
				<tr>
					<td class="info_list">비밀번호 확인 질문</td>
					<td><select name="pwd_q" id="pwd_q" class="info_box" >
						<option value="">++비밀번호 분실 시 사용 될 질문을 선택해주세요.</option>
						<option value="1">인상 깊게 읽은 책 이름은?</option>
						<option value="2">자신이 첫번째로 존경하는 인물은?</option>
						<option value="3">초등학교 때 기억에 남는 짝꿍 이름은?</option>
						<option value="4">다시 태어나면 되고 싶은 것은?</option>
						<option value="5">유년시절 가장 생각나는 친구 이름은?</option>
						<option value="6">받았던 선물 중 기억에 남는 독특한 선물은?</option>
						<option value="7">어릴 적 별명은?</option>                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                     
						<option value="8">자신만의 신체비밀이 있다면?</option>
						<option value="9">인생의 좌우명은?</option>
					</select></td>
				</tr>
				
				<tr><th colspan="4"><img src="./images/join/join_line.jpg" /></th></tr>
				
				<tr>
					<td class="info_list">비밀번호 확인 답변</td>
					<td colspan="3"><input name="pwd_a" id="pwd_a" class="info_box3" /></td>
				</tr>
				
				<tr><th colspan="4"><img src="./images/join/join_line.jpg" /></th></tr>
				
				<tr>
					<td class="info_list">이름</td>
					<td><input name="name" id="name" class="info_box" /></td>
				</tr>
				
				<tr><th colspan="4"><img src="./images/join/join_line.jpg" /></th></tr>
				
				
				<tr>
					<td rowspan="3" class="info_list">주소</td>
					<td>
						<input name="zip1" id="zip1" maxlength="3" class="info_box4" /> - <input name="zip2" id="zip2" maxlength="3" class="info_box4" />						
						<input type="button" id="zip_btn" value="우편번호" onclick="post_check(1)" class="info_box" /></td>
				</tr>
				
				<tr>
					<td colspan="3">
						<input name="addr1" id="addr1" class="info_box2" />
					</td>
				</tr>
				
				<tr>
					<td colspan="3">
						<input name="addr2" id="addr2" class="info_box2" />
					</td>
				</tr>
				
				<tr><th colspan="4"><img src="./images/join/join_line.jpg" /></th></tr>
			
				<tr>
					<td class="info_list">유선전화</td>
					<td colspan="3"><select name="tel1" id="tel1" class="info_box5" >
						<option value="02">02</option>	<option value="">031</option>		
						<option value="032">032</option>	<option value="033">033</option>		
						<option value="041">041</option>	<option value="042">042</option>		
						<option value="043">043</option>	<option value="044">044</option>		
						<option value="051">051</option>	<option value="052">052</option>		
						<option value="053">053</option>	<option value="054">054</option>		
						<option value="055">055</option>	<option value="061">061</option>		
						<option value="062">062</option>	<option value="063">063</option>		
						<option value="064">064</option>
							
					</select>-<input name="tel2" id="tel2" maxlength="4" class="info_box4" />-<input name="tel3" id="tel3" maxlength="4" class="info_box4" /></td>
				</tr>
				
				<tr><th colspan="4"><img src="./images/join/join_line.jpg" /></th></tr>				
				
				<tr>
					<td class="info_list">휴대전화</td>
					<td colspan="3"><select name="phone1" id="phone1" class="info_box5" >
						<option value="010">010</option>
						<option value="011">011</option>
						<option value="016">016</option>
						<option value="019">019</option>
					</select>-<input name="phone2" id="phone2" maxlength="4" class="info_box4" />-<input name="phone3" id="phone3" maxlength="4" class="info_box4" />
					</td>
				</tr>
				
				<tr><th colspan="4"><img src="./images/join/join_line.jpg" /></th></tr>
								
				<tr>
					<td class="info_list">이메일</td>
					<td colspan="3"><input name="email1" id="email1" class="info_box" /> @ <input name="email2" id="email2" class="info_box" />
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
						<input name="birth1" maxlength="4" class="info_box1" /> 년
						<input name="birth2" maxlength="2" class="info_box2"  /> 월
						<input name="birth3" maxlength="2" class="info_box2"  /> 일
					</td>
				</tr>
			
				<tr><th colspan="4"><img src="./images/join/join_line.jpg" /></th></tr>
	
				<tr>
					<td class="info_list">결혼기념일</td>
					<td colspan="4">
						<input name="wedding1" maxlength="4" class="info_box1" /> 년
						<input name="wedding2" maxlength="2" class="info_box2"  /> 월
						<input name="wedding3" maxlength="2" class="info_box2"  /> 일
					</td>
				</tr>	
				
				<tr><th colspan="4"><img src="./images/join/join_line.jpg" /></th></tr>
				
				<tr>
					<td class="info_list">배우자생일</td>
					<td colspan="4">
						<input name="wifebirth1" maxlength="4" class="info_box1" /> 년
						<input name="wifebirth2" maxlength="2" class="info_box2"  /> 월
						<input name="wifebirth3" maxlength="2" class="info_box2"   /> 일
					</td>
				</tr>
				
				<tr><th colspan="4"><img src="./images/join/join_line.jpg" /></th></tr>
				
				<tr>
					<td class="info_list">지역</td>
					<td colspan="4"><select name="location" id="location" class="info_box3">
						<option value="1">선택</option>
						<option value="2">서울</option>
						<option value="3">경기도</option>
						<option value="4">강원도</option>
						<option value="5">충청남도</option>
						<option value="6">충청북도</option>
						<option value="7">대전광역시</option>
						<option value="8">전라북도</option>
						<option value="9">전라남도</option>
						<option value="10">광주광역시</option>
						<option value="11">경상북도</option>
						<option value="12">경상남도</option>
						<option value="13">대구광역시</option>
						<option value="14">울산광역시</option>
						<option value="15">부산광역시</option>
						<option value="16">인천광역시</option>
						<option value="17">울릉도</option>
						<option value="18">제주도</option>					
					</select></td>
				</tr>
				
			</table>
		
		</div>
		
		<img src="./images/join/join_img19.jpg" class="add_img" />
		
		
		<div id="info_check">
			<textarea readonly="readonly"  class="info_textarea" >
('www.SetterGetter.co.kr'이하 'www.SetterGetter.co.kr')은(는) 개인정보보호법에 따라 이용자의 개인정보 보호 및 권익을 보호하고 개인정보와 관련한 이용자의 고충을 원활하게 처리할 수 있도록 다음과 같은 처리방침을 두고 있습니다.

('www.SetterGetter.co.kr') 은(는) 회사는 개인정보처리방침을 개정하는 경우 웹사이트 공지사항(또는 개별공지)을 통하여 공지할 것입니다.

○ 본 방침은부터 2012년 10월 15일부터 시행됩니다.

1. 개인정보의 처리 목적 ('www.SetterGetter.co.kr'이하 'www.SetterGetter.co.kr')은(는) 개인정보를 다음의 목적을 위해 처리합니다. 처리한 개인정보는 다음의 목적이외의 용도로는 사용되지 않으며 이용 목적이 변경될 시에는 사전동의를 구할 예정입니다.

가. 홈페이지 회원가입 및 관리
회원 가입의사 확인, 회원자격 유지·관리, 제한적 본인확인제 시행에 따른 본인확인, 서비스 부정이용 방지, 만14세 미만 아동 개인정보 수집 시 법정대리인 동의 여부 확인 등을 목적으로 개인정보를 처리합니다.

나. 민원사무 처리
민원사항 확인 등을 목적으로 개인정보를 처리합니다.

다. 재화 또는 서비스 제공
물품배송, 서비스 제공, 청구서 발송, 콘텐츠 제공, 맞춤 서비스 제공, 연령인증, 요금결제·정산 등을 목적으로 개인정보를 처리합니다.

라. 마케팅 및 광고에의 활용
신규 서비스(제품) 개발 및 맞춤 서비스 제공, 이벤트 및 광고성 정보 제공 및 참여기회 제공 , 인구통계학적 특성에 따른 서비스 제공 및 광고 게재 , 서비스의 유효성 확인, 접속빈도 파악 또는 회원의 서비스 이용에 대한 통계 등을 목적으로 개인정보를 처리합니다.



2. 개인정보 파일 현황
('www.SetterGetter.co.kr'이하 'www.SetterGetter.co.kr')가 개인정보 보호법 제32조에 따라 등록․공개하는 개인정보파일의 처리목적은 다음과 같습니다.

1. 개인정보 파일명 : SetterGetter
- 개인정보 항목 : 자택주소, 비밀번호 질문과 답, 비밀번호, 생년월일, 자택전화번호, 로그인ID, 휴대전화번호, 이름, 이메일, 결혼여부
- 수집방법 : 서면양식, 홈페이지, 배송요청
- 보유근거 : SetterGetter
- 보유기간 : 3년
- 관련법령 : 소비자의 불만 또는 분쟁처리에 관한 기록 : 3년, 신용정보의 수집/처리 및 이용 등에 관한 기록 : 3년, 대금결제 및 재화 등의 공급에 관한 기록 : 5년, 계약 또는 청약철회 등에 관한 기록 : 5년, 표시/광고에 관한 기록 : 6개월



3. 개인정보의 처리 및 보유 기간

① ('www.SetterGetter.co.kr')은(는) 법령에 따른 개인정보 보유·이용기간 또는 정보주체로부터 개인정보를 수집시에 동의 받은 개인정보 보유,이용기간 내에서 개인정보를 처리,보유합니다.

② 각각의 개인정보 처리 및 보유 기간은 다음과 같습니다.

1.마케팅 및 광고에의 활용
마케팅 및 광고에의 활용와 관련한 개인정보는 수집.이용에 관한 동의일로부터(3년)까지 위 이용목적을 위하여 보유.이용됩니다.
-보유근거 : SetterGetter
-관련법령 : 1)소비자의 불만 또는 분쟁처리에 관한 기록 : 3년
2) 신용정보의 수집/처리 및 이용 등에 관한 기록 : 3년
3) 대금결제 및 재화 등의 공급에 관한 기록 : 5년
4) 계약 또는 청약철회 등에 관한 기록 : 5년
5) 표시/광고에 관한 기록 : 6개월

-예외사유 : 



4. 개인정보의 제3자 제공에 관한 사항

① ('www.SetterGetter.co.kr'이하 'www.SetterGetter.co.kr')은(는) 정보주체의 동의, 법률의 특별한 규정 등 개인정보 보호법 제17조 및 제18조에 해당하는 경우에만 개인정보를 제3자에게 제공합니다.

② ('www.SetterGetter.co.kr')은(는) 다음과 같이 개인정보를 제3자에게 제공하고 있습니다.
	</textarea>
			<ul>
				<li><p>개인정보취급방침에 동의하십니까?</p></li>
				<li class="input_check"><input type="checkbox" id="checkbox" />  동의함</li>
			</ul>					
		</div>
		
		
		<div id="info_btn">
			<p><input type="image" src="./images/join/join_img21.jpg" alt="회원가입" /></p>
			<p><img src="./images/join/join_img20.jpg" alt="회원가입취소" onclick="reset_check()" /></p>
		</div>
		
	</div>
</form>


<!-- =============================== footer 시작 ===============================-->
<jsp:include page="footer.jsp" />	
<!-- =============================== footer 끝 ===============================-->