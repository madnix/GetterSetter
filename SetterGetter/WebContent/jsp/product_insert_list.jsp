<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<link rel="stylesheet" type="text/css" href="./css/board_list.css" />
<title>게시판 목록</title>
	
<!-- =========================================  header 시작 ========================================= -->
	   <jsp:include page="header.jsp" />
<!-- =========================================  header 끝 ========================================= -->
		
<!-- =============================== board 시작 ===============================-->	
		
	<div id="main_line"></div>
	<ul class="menulist">
				<li><a href="product_insert_list.do">ㅁ 등록함</a></li>
		      	<li><a href="buyer_product_list.do">ㅁ 구매함</a></li> 
		      	<li><a href="product_delete_list.do">ㅁ 삭제함</a></li>
	</ul>
	<div id="board_Wrap">
	
		<p><img src="./images/board/review.jpg" /></p>
		
		<div id="board_spare"></div>
			<table width="900" height="50">
			<div id="green_Box"></div>
				<tr>
					<th width="10%">IMG</th>
					<th width="10%">NO</th>
					<th width="*">TITLE</th>
					<th width="10%">SPECIES</th>
					<th width="10%">COUNT</th>
					<th width="10%">DATE</th>
					<th width="10%">VIEW</th>
				</tr>
			</table>
			<div id="green_Box"></div>
	</div>
		
	<!-- ==== 게시판 한줄 내용 출력 ==== -->
	
	<div id="board_Wrap2">
<c:forEach items="${insertList}" var="insertItem">
		<table width="900" height="50">
			<tr>
	 			<th width="10%" align="center">
	 				<img src="Upload${insertItem.pro_listImg}" width="50" height="50">
	 			</th>
	 			<th width="10%" align="center">${insertItem.pro_id}</th>
				<th width="40%" align="center">${insertItem.pro_title}</th>
				<th width="10%" align="center">${insertItem.species_id}</th>
				<th width="10%" align="center">${insertItem.pro_count}</th>
				<th width="10%" align="center">${insertItem.pro_date}</th>
				<th align="center">
					<a href="product_insert_detail.do?id=${insertItem.pro_id}">
						상세보기
					</a>
				</th>
			</tr>
		</table>
</c:forEach>
		 <div id="gray_Box"></div>

		
	<!-- ==== 게시판 한줄 내용 출력 끝 ==== -->

	<!-- ==== 페이징 ==== -->	

   		<div id="list_paging">

		<c:if test="${ count > 0 }">
			<c:set var="pageCount"
				value="${ count / pageSize + (count % pageSize == 0 ? 0 : 1)}" />

			<c:set var="startPage"
				value="${ pageGroupSize * ( numPageGroup-1) + 1 }" />
			<c:set var="endPage" value="${ startPage + pageGroupSize - 1 }" />

			<c:if test="${ endPage > pageCount }">
				<c:set var="endPage" value="${ pageCount }" />
			</c:if>

			<c:if test="${numPageGroup > 1}">
				<a href="./product_insert_list.do?pageNum=${(numPageGroup-2)*pageGroupSize+1 }">[이전]</a>
			</c:if>

			<c:forEach var="i" begin="${startPage}" end="${endPage}">
				<a href="product_insert_list.do?pageNum=${i}"> [ <c:if
						test="${currentPage == i}"></c:if> ${i} ]
				</a>
			</c:forEach>

			<c:if test="${numPageGroup < pageGroupCount}">
				<a href="product_insert_list.do?pageNum=${numPageGroup*pageGroupSize+1}">[다음]</a>
			</c:if>
		</c:if>

   		</div>
	<!-- ==== 페이징 끝==== -->	
	</div>
<!-- =============================== board 끝 ===============================-->	
	
<!-- =============================== footer  ===============================-->		
<jsp:include page="footer.jsp" />
<!-- =============================== footer 끝 ===============================-->
