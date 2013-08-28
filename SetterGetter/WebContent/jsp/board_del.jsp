<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<link rel="stylesheet" type="text/css" href="./css/board_del.css" />
<script type="text/javascript" src="./js/jquery.js" ></script>
<script type="text/javascript" src="./js/board_edit.js"></script>

<title>게시판 작성</title>
	
<!-- =========================================  header 시작 ========================================= -->
	   <jsp:include page="header.jsp" />
<!-- =========================================  header 끝 ========================================= -->

<!-- =============================== board_Wirte 시작 =============================== -->

	<div id="main_line"></div>
	<div id="side_line"></div>
	
	 <!-- ===========   board_info 시작   ============= -->
<form method="post" name="f" action="board_del.do?pageNum=${pageNum }" onsubmit="return board_del()" >
	 <div id="board_Write_Wrap">
	 
	  <table>
		<tr>
			<td class="left_box"><strong>비밀번호를 입력하시오</strong>&nbsp;&nbsp;&nbsp;&nbsp;</td>
			<td class="right_box">
				<input type="text" id="del_pwd" name="del_pwd">
				<input type="hidden" id="no" name="no" value="${no }"> <!-- 해당 게시물 정보 -->
			</td>
		</tr>
	  </table>
	  
		<div id="side_line2"></div>
		
	</div>
	   
		<!-- ===========   board_info 끝   ============= -->
	
	
	   	
	   		<!-- =============   board_move_box 시작   ============== -->
	   	
	   	<div id="move_box">
	   		<div id="move1"><td><a href="board_list.do?pageNum=${pageNum }"><img src="./images/board/board_list_go.jpg" alt="목록" /></a></td></div>
	   		<div id="move2"><td><a href="board_del.do?no=${no }&pageNum=${pageNum}"><img src="./images/board/board_cancel.jpg" alt="취소" /></a></td> </div>
	   		<div id="move3"><p><input type="image" src="./images/board/board_del.jpg" alt="삭제" /></p></div>
	   	</div>
</form>
	   	
			<!-- =============   board_move_box 끝   ============== -->	
	   	
<!-- =============================== board_Wirte 끝 =============================== -->			

<!-- =============================== footer 시작 ===============================-->
<jsp:include page="footer.jsp" />	
<!-- =============================== footer 끝 ===============================-->