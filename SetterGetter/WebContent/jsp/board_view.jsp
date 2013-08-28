<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<link rel="stylesheet" type="text/css" href="./css/board_view.css" />
<title>게시판 작성</title>
	
<!-- =========================================  header 시작 ========================================= -->
	   <jsp:include page="header.jsp" />
<!-- =========================================  header 끝 ========================================= -->

<!-- =============================== board_Wirte 시작 =============================== -->

	<div id="main_line"></div>
	<div id="side_line"></div>
	
	 <!-- ===========   board_info 시작   ============= -->
<form method="post" name="f" action="board_write.do" onsubmit="return board_check()" >
	 <div id="board_Write_Wrap">
	 
	  <table>	 			
	  
		<tr>
			<td width="13%" class="left_box"><strong>제목</strong>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
			<td class="">
				<th width="72%" align="left" class="right_box">&nbsp;${boardView.board_title}</th>
				<th width="15%" align="right" class="hit_box">조회수 : ${boardView.hit }&nbsp;&nbsp;&nbsp;</th>
			</td>
		</tr>
	  </table>
	  
			<div id="line2"></div>
			
	  <table>
		<tr>
			<td class="left_box"><strong>작성자</strong>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
			<td class="right_box">${boardView.board_name }</td>
		</tr>
	  </table>
	  
			<div id="line2"></div>
			
	   <table>
		<tr>
			<td class="left_box"><strong>이메일</strong>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
				<td class="right_box">
					${boardView.board_email1} @ 
					${boardView.board_email2}
				</td>
		</tr>
	   </table>
		 
		<div id="side_line2"></div>
			
	   <table>
		<tr>
				<td>
				<textarea class="board_cont"name="cont" id="cont" cols="81" rows="100">${boardView.board_cont}</textarea>
				</td>
		</tr>
	   </table>
		
		<div id="line2"></div>
		
	   <table>
		<tr>
			<td class="left_box"><strong>빌밀글설정</strong>&nbsp;&nbsp;</td>
			<td class="right_box">
			
			<c:if test="${boardView.board_secret == 0 }">공개글입니다.</c:if>
			<c:if test="${boardView.board_secret == 1 }">비공개글입니다.</c:if>

			</td>
		</tr>
	   </table>
	   
	   <table>
	   	<tr>
	   		<td>  &nbsp;</td>
	   	</tr>
	   </table>
	</div>
		<!-- ===========   board_info 끝   ============= -->
	
	 <div id="side_line3"></div>
	
	   	<div id="side_line3"></div>	
	   		<!-- =============   board_move_box 시작   ============== -->
	   	<div id="move_box">
	   		<div id="move1"><td><a href="board_list.do?pageNum=${pageNum }"><img src="./images/board/board_list_go.jpg" alt="목록" /></a></td></div>
	   		
	   		<!-- 공개글은 답글만 출력 -->
	   		<c:if test="${(boardView.board_id == null) || (boardView.board_id != boardLoginId) }">
	   			<div id="move4"><td><a href="board_reply.do?no=${boardView.board_no }&pageNum=${pageNum}"><img src="./images/board/board_reply.jpg" alt="답글" /></a></td> </div>
	   		</c:if>
	   		
	   		<!-- 작성자 아이디가 맞지않으면 수정 및 삭제 목록이 않나옴. -->
	   		<c:if test="${boardView.board_id == boardLoginId }">
	   			<div id="move2"><td><a href="board_reply.do?no=${boardView.board_no }&pageNum=${pageNum}"><img src="./images/board/board_reply.jpg" alt="답글" /></a></td> </div>
	   			<div id="move3"><td><a href="board_edit.do?no=${boardView.board_no }&pageNum=${pageNum}"><img src="./images/board/board_edit.jpg" alt="수정" /></a></td> </div>
	   			<div id="move4"><td><a href="board_del.do?no=${boardView.board_no }&pageNum=${pageNum}"><img src="./images/board/board_del.jpg" alt="삭제" /></a></td> </div>
	   		</c:if>
	   	</div>
</form>
	   	
			<!-- =============   board_move_box 끝   ============== -->	
	   	
<!-- =============================== board_Wirte 끝 =============================== -->			

<!-- =============================== footer 시작 ===============================-->
<jsp:include page="footer.jsp" />	
<!-- =============================== footer 끝 ===============================-->