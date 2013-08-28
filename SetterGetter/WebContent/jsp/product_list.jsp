<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<link rel="stylesheet" type="text/css" href="./css/content.css" />
<title>Product List</title>
	
<!-- =========================================  header 시작 ========================================= -->
	   <jsp:include page="header.jsp" />
<!-- =========================================  header 끝 ========================================= -->

	
		<div id="category">
			<div id="product">
			<!-- product list -->
			
			<ul>
				<c:forEach items="${ productList }" var="list">
					<li>
						<a href="product_view.do?pro_id=${ list.pro_id }">
							<img src="./Upload/${ list.pro_listImg }" width="230" height="250"/>
						</a>
						<p class="a">${ list.pro_title }</p>
						<p class="d">￦ ${ list.user_price }</p>

						
<%-- 						<c:choose>  --%>
<%-- 							<c:when test="${ list.pro_price == list.user_price }">  --%>
<%-- 								<p class="b">￦ ${ list.user_price }</p>  --%>
<%-- 							</c:when> --%>
<%-- 							<c:otherwise> 					 --%>
<%-- 								<p class="c">￦ ${ list.pro_price }</p> --%>
<%--  								<p class="d">￦ ${ list.user_price }</p>  --%>
<%-- 							</c:otherwise> --%>
<%-- 						</c:choose>  --%>
					</li>
				</c:forEach>
			</ul>
			
			
			
			
			<p class="pageList">
				<!-- 페이징 부분 -->
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
						<a href="./product_list.do?pageNum=${(numPageGroup-2)*pageGroupSize+1 }&species_id=${species}">[이전]</a>
					</c:if>
	
					<c:forEach var="i" begin="${startPage}" end="${endPage}">
						<a href="product_list.do?pageNum=${i}&species_id=${species}" class="on"> [ 
							<c:if test="${currentPage == i}"></c:if> ${i} ]
						</a>
					</c:forEach>
	
					<c:if test="${numPageGroup < pageGroupCount}">
						<a href="product_list.do?pageNum=${numPageGroup*pageGroupSize+1}&species_id=${species}">[다음]</a>
					</c:if>
				</c:if>
			</p>
			</div>
		</div>
	


<!-- =============================== footer 시작 ===============================-->
<jsp:include page="footer.jsp" />	
<!-- =============================== footer 끝 ===============================-->


