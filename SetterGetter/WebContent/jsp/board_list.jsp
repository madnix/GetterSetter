<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %> 

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<link rel="stylesheet" type="text/css" href="./css/board_list.css" />
<script type="text/javascript" src="./js/board_list.js"></script>
<title>게시판 목록</title>

	
<!-- =========================================  header 시작 ========================================= -->
	   <jsp:include page="header.jsp" />
<!-- =========================================  header 끝 ========================================= -->
	<div id="main_line"></div>
	<div id="side_line"></div>
<!-- =============================== board 시작 ===============================-->	
	<div id="main_line"></div>

	<form method="post" name="f" action="board_list.do" onsubmit="return boardSearch()">
	
	<input type="hidden" name="pageNum" id="pageNum" value="${pageNum}">
	<!-- 현제 페이징 정보 가져가기 -->
	
	<div id="board_Wrap">
	
	 	<tr>
		 	<th margin-bottom="30"><img src="./images/board/review.jpg" /></th>
		</tr>
		
		<div id="board_spare"></div>
			<table width="900" height="50">
			<div id="green_Box"></div>
			
				<tr>
					<th width="10%"><strong>NO&nbsp;&nbsp;&nbsp;</strong></th>
					<th width="60%"><strong>TITLE</strong></th>
					<th width="10%"><strong>NAME</strong></th>
					<th width="12%"><strong>DATE</strong></th>
					<th width="8%"><strong>HIT</strong></th>
				</tr>
			</table>
			<div id="green_Box"></div>
	</div>
		
	<!-- ==== 게시판 한줄 내용 출력 ==== -->
	
	<div id="board_Wrap2">
		<c:forEach items="${boardList}" var="b">
		
		 <table width="900" height="40" id="list">
			<tr>
	 			<th width="6%" align="center" ><strong>&nbsp;${b.board_no }</strong></th>
	 			<th width="9%" align="center">
		<!-- 비공개글 secret = 1 이면 자물쇠 그림 나오게함  -->	 			
	 				<c:if test="${b.board_secret == 1 }"><img src="./images/board/icon_lock.gif"/></c:if>
					<c:if test="${b.board_secret == 0 }"></c:if>
	 			</th>
	 			
	 	<!-- 답글 들여쓰기 시작   -->
	 	<!-- 답글일시 답글 깊이(reply_level)가 0이상이면 답글 이미지 및 들여쓰기함   -->
				<c:if test="${b.reply_level == 0 }">
					<th width="55%" align="left" name="no" id="no"><a href="board_view.do?no=${ b.board_no }&pageNum=${pageNum}">${b.board_title }</a></th>
				</c:if>
	 			
				<c:if test="${b.reply_level != 0 }">
					<th width="${b.reply_level * 2 }%" ></th>
					<th width="${55-(b.reply_level * 2)}%" align="left" name="no" id="no">
						<a href="board_view.do?no=${ b.board_no }&pageNum=${pageNum}">
					<img src="./images/board/re.gif"/>
					${b.board_title }</a></th>
				</c:if>
		<!-- 답글 들여쓰기 끝   -->
				
				<th width="10%" align="center"><a href="#">${b.board_name }</a></th>
				<th width="12%" align="center">
				<!-- fn 태그를 사용하여 substring 으로 출력 시간 표시  
					오늘 작성한 글은 시간:분:초 출력
					전날 작성한 글은 년 월 일 출력 -->
				<c:set var="date" value="${b.board_date }"/>
				
					<c:if test="${toDay == fn:substring(date,0,10) }">
						<c:out value="${fn:substring(date,11,19)}"/>
					</c:if>

					<c:if test="${toDay != fn:substring(date,0,10) }">
						<c:out value="${fn:substring(date,0,10)}"/>
					</c:if>
				</th>
				
				<th width="8%" align="center">${b.hit }</th>
			</tr>
		 </table><div id="gray_Box"></div>
		</c:forEach>
		
	<!-- ==== 게시판 한줄 내용 출력 끝 ==== -->
	
	<!-- ==== 글쓰기 ==== -->
		<div id="list_menu">
			<tr>
		  		<th><a href="board_write.do?pageNum=${pageNum}"><img src="./images/board/board_list_write.jpg"/></a></th>
		  	</tr>
		</div>	
	<!-- ==== 글쓰기 끝 ==== -->
	
	${search}

<!-- =================  페이징 부분  ================= -->
		<div id="list_paging">
			<tr>
		
	<c:if test="${ count > 0 }">
		<c:set var="pageCount" value="${ count / pageSize + (count % pageSize == 0 ? 0 : 1)}" />
			 
		<c:set var="startPage" value="${ pageGroupSize * ( numPageGroup-1) + 1 }" />
		<c:set var="endPage" value="${ startPage + pageGroupSize - 1 }" />

		<c:if test="${ endPage > pageCount }">
			<c:set var="endPage" value="${ pageCount }" />
		</c:if>
						
		<c:if test="${numPageGroup > 1}">
			<a href="./board_list.do?pageNum=${(numPageGroup-2)*pageGroupSize+1 }&search=${search}"">[이전]</a>
		</c:if>			
			
			
		<c:forEach var="i" begin="${startPage}" end="${endPage}">
			<a href="board_list.do?pageNum=${i}&search=${search}""> [ 
				<c:if test="${pageNum == i}" ></c:if> ${i} ]
			</a>
		</c:forEach>
		
		<c:if test="${numPageGroup < pageGroupCount}">
			<a href="board_list.do?pageNum=${numPageGroup*pageGroupSize+1}&search=${search}">[다음]</a>
		</c:if>
	</c:if>
		</tr>
		
	</div>
<!-- =================  페이징 끝  ================= -->


<!-- =================  검색  ================= -->
<c:if test="${search != null }">
	<div id="move_all">
		<table>
			<tr>
			<th><a href="board_list.do"><img src="./images/board/board_list.jpg" alt="목록" /></a></th>
			</tr>
		</table>
	</div>
</c:if>
	
	<div id="board_search"><input type="text" name="search" id="search" size="30">
		<table>
			<tr>
				<th><p><input type="image" src="./images/board/board_search.jpg" id="image_box" width="60" height="25"/></p></th>
			</tr>
		</table>
	</div>


<!-- =================  검색 끝  ================= -->
	
	
	
	
	</div>
	</form>
<!-- =============================== board 끝 ===============================-->	
	
<!-- =============================== footer  ===============================-->		
<jsp:include page="footer.jsp" />
<!-- =============================== footer 끝 ===============================-->
