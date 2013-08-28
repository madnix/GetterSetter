<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<link rel="stylesheet" type="text/css" href="./css/board_edit.css" />
<script type="text/javascript" src="./js/jquery.js" ></script>
<script type="text/javascript" src="./js/board_edit.js"></script>
<title>게시판 수정</title>
	
<!-- =========================================  header 시작 ========================================= -->
	   <jsp:include page="header.jsp" />
<!-- =========================================  header 끝 ========================================= -->

<!-- =============================== board_Wirte 시작 =============================== -->

	<div id="main_line"></div>
	<div id="side_line"></div>
	
	 <!-- ===========   board_info 시작   ============= -->
<form method="post" name="f" action="board_edit.do?no=${boardEdit.board_no }&pageNum=${pageNum}" onsubmit="return board_edit()" >
	 <div id="board_Write_Wrap">
	 
	  <table>
		<tr>
			<td class="left_box">제목&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
			<td colspan="3"><input type="text" name="title" id="title" size="30" class="right_title_box" value="${boardEdit.board_title }"></td>
		</tr>
	  </table>
	  
			<div id="line2"></div>
			
	  <table>
		<tr>
			<td class="left_box">작성자&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
			<td><input type="text" name="name" id="name" size="15" class="right_box" value="${boardEdit.board_name }"></td>
		</tr>
	  </table>
	  
			<div id="line2"></div>
			
	   <table>
		<tr>
			<td class="left_box">이메일&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
				<td class="right_check_box">
					<input type="text" name="email1" id="email1" size="20" value="${boardEdit.board_email1 }">@
					<input type="text" name="email2" id="email2" size="20" value="${boardEdit.board_email2 }">
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
				<td><textarea name="cont" id="cont" cols="81" rows="10">${boardEdit.board_cont }</textarea></td>
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
			<td class="right_box">
				<input type="checkbox" name="secret" id="secret1" value="0" />공개글&nbsp;&nbsp;
				<input type="checkbox" name="secret" id="secret2" value="1" />비밀글
			</td>
		</tr>
	   </table>
	</div>
	   
		<!-- ===========   board_info 끝   ============= -->
	
	 <div id="side_line3"></div>
	
	   		
	   	<div id="side_line3"></div>	
	   	
	   		<!-- =============   board_move_box 시작   ============== -->
	   	
	   	<div id="move_box">
	   		<div id="move1"><td><a href="board_list.do?pageNum=${pageNum}"><img src="./images/board/board_list_go.jpg" alt="목록" /></a></td></div>
	   		<div id="move2"><td><a href="board_edit.do?no=${boardEdit.board_no }&pageNum=${pageNum}"><img src="./images/board/board_cancel.jpg" alt="취소" /></a></td></div>
	   		<div id="move3"><td><p><input type="image" src="./images/board/board_edit.jpg" alt="수정"/></p></td></div>
	   	</div>
</form>
	   	
			<!-- =============   board_move_box 끝   ============== -->	
	   	
<!-- =============================== board_Wirte 끝 =============================== -->			

<!-- =============================== footer 시작 ===============================-->
<jsp:include page="footer.jsp" />	
<!-- =============================== footer 끝 ===============================-->