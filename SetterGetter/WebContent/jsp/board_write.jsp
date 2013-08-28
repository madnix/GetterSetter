<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<link rel="stylesheet" type="text/css" href="./css/board_write.css" />
<script type="text/javascript" src="./js/jquery.js" ></script>
<script type="text/javascript" src="./js/board_write.js"></script>
<title>게시판 작성</title>

	
<!-- =========================================  header 시작 ========================================= -->
	   <jsp:include page="header.jsp" />
<!-- =========================================  header 끝 ========================================= -->

<!-- =============================== board_Wirte 시작 =============================== -->

	<div id="main_line"></div>
	<div id="side_line"></div>
	
	 <!-- ===========   board_info 시작   ============= -->
<form method="post" name="f" action="board_write.do" onsubmit="return board_write()" >
	 <div id="board_Write_Wrap">
	 
	  <table>
		<tr>
			<td class="left_box">제목&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
			<td colspan="3"><input type="text" name="title" id="title" size="30" class="right_title_box" maxlength="20"></td>
		</tr>
	  </table>
	  
			<div id="line2"></div>
			
	  <table>
		<tr>
			<td class="left_box">작성자&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
			<td><th class="right_box"><input type="text" name="name" id="name" size="15" 
			value="${boardInfo.name }" >&nbsp;&nbsp;이름 or 닉네임</th></td>
			
		</tr>
	  </table>
	  
			<div id="line2"></div>
			
	   <table>
		<tr>
			<td class="left_box">이메일&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
				<td>
					<input type="text" name="email1" id="email1" size="20" value="${boardInfo.email1 }">@
					<input type="text" name="email2" id="email2" size="20" value="${boardInfo.email2 }">
					<select name="email3" id="email3" onchange="select_email()" >
						<option value="">=선택=</option>
						<option value="naver.com">@naver.com</option>
						<option value="daum.net">@hanmail.net</option>
	 				    <option value="yahoo.com">@yahoo.co.kr</option>
					    <option value="기타">기타</option>
					</select>
				</td>
		</tr>
	   </table>
		 
		<div id="side_line2"></div>
			
	   <table>
		<tr>
			<td algin="center">
				<td><textarea name="cont" id="cont" cols="81" rows="10"></textarea></td>
			</td>
		</tr>
	   </table>
		
		<div id="line2"></div>
		
	   <table>
		<tr>
			<td class="left_box">비밀번호&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
			<td><input type="text" name="pwd" id="pwd" size="15" class="right_box"></td>
		</tr>
	   </table>
	   
		<div id="line2"></div>
		
	   <table>
		<tr>
			<td class="left_box">빌밀글설정&nbsp;&nbsp;</td>
			<td>
				<input type="checkbox" name="secret" id="secret1" value="0" />공개글&nbsp;&nbsp;
				<input type="checkbox" name="secret" id="secret2" value="1" />비밀글
			</td>
		</tr>
	   </table>
	</div>
	   
		<!-- ===========   board_info 끝   ============= -->
	
	 <div id="side_line3"></div>
	
		<!-- =============   개인정보취급방침 시작    ============== -->
	
		<div id="board_Write_footer">
	   		<table>
	   			<tr>
					<th class="left_box">
						<br>
						&nbsp;&nbsp;개인정보&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<br><br>
						&nbsp;&nbsp;보호정책&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					</th>
					<td algin="center">
						<td><textarea readonly="readonly" name="secret" id="secret" cols="70" rows="10">
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
						</textarea></td>
					</td>
			</table>
			<br>
			<table> 
					<td></td>
					<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						개인정보취급방침에 대하여 동의하십니까?&nbsp;&nbsp;
						<input type="checkbox" name="check" id="check" value="0" />동의함&nbsp;&nbsp;
					</td>
				</tr>
	   		</table>
	   	</div>	
	   	
	   		<!-- =============   개인정보취급방침 끝    ============== -->
	   		
	   	<div id="side_line3"></div>	
	   	
	   		<!-- =============   board_move_box 시작   ============== -->
	   	
	   	<div id="move_box">
	   		<div id="move1"><td><a href="board_list.do?pageNum=${pageNum }"><img src="./images/board/board_list_go.jpg" alt="목록" /></a></td></div>
	   		<div id="move2"><td><a href="board_write.do?pageNum=${pageNum}"><img src="./images/board/board_cancel.jpg" alt="취소" /></a></td></div>
	   		<div id="move3"><td><p><input type="image" src="./images/board/board_ok.jpg" alt="등록"/></p></td></div>
	   	</div>
</form>
	   	
			<!-- =============   board_move_box 끝   ============== -->	
	   	
<!-- =============================== board_Wirte 끝 =============================== -->			

<!-- =============================== footer 시작 ===============================-->
<jsp:include page="footer.jsp" />	
<!-- =============================== footer 끝 ===============================-->